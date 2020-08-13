package cn.hiczy.chatserver.handler;

import cn.hiczy.chatserver.mapper.TMessageRecordMapper;
import cn.hiczy.chatserver.mapper.TOfflineMessageMapper;
import cn.hiczy.protobuf.MessageProto;
import cn.hiczy.protobuf.MessageProto.Message;
import cn.hiczy.protobuf.entity.TMessageRecord;
import cn.hiczy.protobuf.PlainMessageProto;
import cn.hiczy.protobuf.entity.TOfflineMessage;
import cn.hiczy.protobuf.utils.ProtoMessageUtils;
import cn.hiczy.protobuf.utils.SessionUtils;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/**
 * 消息转发处理器 A ->  MsgDispatcherHandler -> B
 */
@Component
@ChannelHandler.Sharable
public class MsgDispatcherHandler extends ChannelInboundHandlerAdapter {


    @Resource
    private TMessageRecordMapper messageRecordMapper;

    @Resource
    private TOfflineMessageMapper offlineMessageMapper;


    /**
     * 服务器收到消息时的处理方式
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Message receiveMsg = (Message) msg;
        System.out.println("Receiver msg =======");
        System.out.println(receiveMsg);
        //判断接受的消息类型
        switch (receiveMsg.getType()){
            //普通消息
            case PLAIN: handlePainMessage(receiveMsg,ctx); break;
//            //处理认证请求
//            case AUTH_REQ: break;
        }

    }



    /**
     * 处理普通消息
     * @param msg   消息
     * @return      处理后的响应
     */
    private void handlePainMessage(Message msg,ChannelHandlerContext ctx){
        //接收到消息后存入聊天记录数据库
        PlainMessageProto.PlainMessage plainMessage = msg.getPlainMessage();
        TMessageRecord tMessageRecord = ProtoMessageUtils.convertToTMessageRecord(msg);
        messageRecordMapper.insert(tMessageRecord);
        Channel channel = SessionUtils.getChannel(msg.getPlainMessage().getToId());
        //如果对方不在线
        if(channel == null){
            //存入离线消息库
            TOfflineMessage offlineMessage = ProtoMessageUtils.convertToOfflineMsg(tMessageRecord);
            offlineMessageMapper.insert(offlineMessage);
            Message normalResponseOK = ProtoMessageUtils.buildNormalResponseOK(msg.getMId());
            ctx.writeAndFlush(normalResponseOK);
            return;
        }

        //如果在线则将消息转发给toId用户
        ctx.writeAndFlush(msg);
    }




}

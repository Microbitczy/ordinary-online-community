package cn.hiczy.chatserver.handler;

import cn.hiczy.chatserver.mapper.TMessageRecordMapper;
import cn.hiczy.protobuf.MessageProto;
import cn.hiczy.protobuf.MessageProto.Message;
import cn.hiczy.protobuf.entity.TMessageRecord;
import cn.hiczy.protobuf.PlainMessageProto;
import cn.hiczy.protobuf.utils.ProtoMessageUtils;
import cn.hiczy.protobuf.utils.SessionUtils;
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
            case PLAIN: handlePainMessage(receiveMsg); break;
//            //处理认证请求
//            case AUTH_REQ: break;
        }

    }


    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //读取消息完成后返回 响应


        super.channelReadComplete(ctx);
    }


    /**
     * 当连接断开是被调用
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        //当连接断开时,将userId 从redis中移除

        super.channelInactive(ctx);
    }

    /**
     * 处理普通消息
     * @param msg   消息
     * @return      处理后的响应
     */
    private MessageProto.Message handlePainMessage(MessageProto.Message msg){
        //接收到消息后存入聊天记录数据库
        PlainMessageProto.PlainMessage plainMessage = msg.getPlainMessage();
        TMessageRecord tMessageRecord = ProtoMessageUtils.convertToTMessageRecord(msg);
        messageRecordMapper.insert(tMessageRecord);
        //查询Redis中的set是否包含 toTd ,以此判断对方是否在线,如果不在线则将消息存入离线消息表中
        if(SessionUtils.getChannel(msg.getPlainMessage().getToId()) == null){

            //return //
        }

        //如果再线则将消息转发给toId用户


        return null;
    }




}

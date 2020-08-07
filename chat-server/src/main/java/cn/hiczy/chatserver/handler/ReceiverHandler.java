package cn.hiczy.chatserver.handler;

import cn.hiczy.chatserver.mapper.TMessageRecordMapper;
import cn.hiczy.entity.TMessageRecord;
import cn.hiczy.protobuf.MessageProto;
import cn.hiczy.protobuf.PlainMessageProto;
import cn.hiczy.protobuf.utils.ProtoMessageUtils;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

@Component
public class ReceiverHandler extends ChannelInboundHandlerAdapter {


    @Resource
    private TMessageRecordMapper messageRecordMapper;


    /**
     * 收到消息时的处理方式
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        MessageProto.Message receiveMsg = (MessageProto.Message) msg;
        //判断接受的消息类型
        switch (receiveMsg.getType()){
            //普通消息
            case PLAIN: handlePainMessage(receiveMsg); break;
            //处理认证请求
            case AUTH_REQ: break;
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
        //第一次时校验JWT
        if(ObjectUtils.isEmpty(msg) || ObjectUtils.isEmpty(msg.getJwt())){
            //返回认证响应
            return null;
        }

        //...层层认证...

        //如果认证成功

        //通过解析JWT 将userId作为key 存入 redis 中,过期时间和 jwt中的过期时间相同



        //接收到消息后存入数据库
        PlainMessageProto.PlainMessage plainMessage = msg.getPlainMessage();
        TMessageRecord tMessageRecord = ProtoMessageUtils.protoToBean(msg);
        messageRecordMapper.insert(tMessageRecord);
        //查询Redis中是否包含 toTd 以此 判断对方是否在线,如果不在线则将消息存入离线消息表中


        return null;
    }




}

package cn.hiczy.chatserver.handler;

import cn.hiczy.entity.TMessageRecord;
import cn.hiczy.protobuf.MessageProto;
import cn.hiczy.protobuf.PlainMessageProto;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.springframework.stereotype.Component;

@Component
public class ReceiverHandler extends ChannelInboundHandlerAdapter {




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
        super.channelReadComplete(ctx);
    }


    /**
     * 处理普通消息
     * @param msg   消息
     * @return      处理后的响应
     */
    private MessageProto.Message handlePainMessage(MessageProto.Message msg){
        //第一次时校验JWT
//        if()

        //接收到消息后存入数据库
        PlainMessageProto.PlainMessage plainMessage = msg.getPlainMessage();
        TMessageRecord tMessageRecord = new TMessageRecord();
        tMessageRecord.setContent(plainMessage.getContent())
                .setCreateTime(plainMessage.getCreateTime())
                .setFromId(plainMessage.getFromId())
                .setToId(plainMessage.getToId())
                .setMessageType(plainMessage.getType().getNumber());

        //判断对方是否在线,如果不在线则存入


        return null;
    }

}

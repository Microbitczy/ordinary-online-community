package cn.hiczy.chat.client.handler;

import cn.hiczy.protobuf.MessageProto;
import cn.hiczy.protobuf.entity.TMessageRecord;
import cn.hiczy.protobuf.enums.MessageType;
import cn.hiczy.protobuf.utils.ProtoMessageUtils;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class MyClientHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println((MessageProto.Message)msg + "<=====");

        TMessageRecord messageRecord = new TMessageRecord();
        messageRecord.setContent("first plain message");
        messageRecord.setMId(333L);
        messageRecord.setFromId(1L);
        messageRecord.setToId(3L);
        messageRecord.setMessageType(MessageType.TEXT.getCode());

        MessageProto.Message message = ProtoMessageUtils.convertToMessage(messageRecord);
        ctx.writeAndFlush(message);
    }
}

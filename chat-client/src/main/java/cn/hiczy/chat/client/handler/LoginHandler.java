package cn.hiczy.chat.client.handler;

import cn.hiczy.protobuf.MessageProto;
import cn.hiczy.protobuf.PlainMessageProto;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

import java.net.SocketAddress;

public class LoginHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //连接时发送信息
        MessageProto.Message auth = MessageProto.Message.newBuilder()
                .setMId(3)
                .setPlainMessage(PlainMessageProto.PlainMessage.newBuilder().build())
                .setType(MessageProto.Message.MessageType.AUTH_REQ)
                .setJwt("ss")
                .build();

        ctx.writeAndFlush(auth);
        super.channelActive(ctx);

    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        MessageProto.Message message = (MessageProto.Message) msg;
        System.out.println("接收到的回复: ====");
        System.out.println(message);
        super.channelRead(ctx, msg);
    }
}

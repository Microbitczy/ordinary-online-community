package cn.hiczy.chat.client.handler;

import cn.hiczy.protobuf.MessageProto;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

import java.net.SocketAddress;

public class LoginHandler extends ChannelOutboundHandlerAdapter {



    @Override
    public void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) throws Exception {
//        连接时发送信息
        MessageProto.Message auth = MessageProto.Message.newBuilder()
                .setMId(3)
//                .setSessionId("1")
                .setType(MessageProto.Message.MessageType.AUTH_REQ)
                .setJwt("auth")
                .build();

        ctx.writeAndFlush(auth);
        super.connect(ctx, remoteAddress, localAddress, promise);
    }
}

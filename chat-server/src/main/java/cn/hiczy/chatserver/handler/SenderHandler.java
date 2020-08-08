package cn.hiczy.chatserver.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandler;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import org.springframework.stereotype.Component;

import java.net.SocketAddress;


/**
 *  服务端发送消息给客户端
 */
@Component
public class SenderHandler extends ChannelOutboundHandlerAdapter {

    @Override
    public void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) throws Exception {

        super.connect(ctx, remoteAddress, localAddress, promise);
    }

}

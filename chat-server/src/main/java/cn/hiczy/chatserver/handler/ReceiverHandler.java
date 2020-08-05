package cn.hiczy.chatserver.handler;

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
        MessagePojo.Message receiveMsg = (MessagePojo.Message) msg;
        //


        super.channelRead(ctx, msg);
    }


    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
    }
}

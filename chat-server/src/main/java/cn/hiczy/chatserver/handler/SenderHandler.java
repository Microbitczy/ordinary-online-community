package cn.hiczy.chatserver.handler;

import cn.hiczy.chatserver.mapper.TMessageRecordMapper;
import io.netty.channel.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.net.SocketAddress;


/**
 *  服务端发送消息给客户端
 */
@Component
@ChannelHandler.Sharable
public class SenderHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //判断是否为离线消息响应,如果是处理离线消息


        //判断是否为普通消息



        super.channelRead(ctx, msg);
    }
}

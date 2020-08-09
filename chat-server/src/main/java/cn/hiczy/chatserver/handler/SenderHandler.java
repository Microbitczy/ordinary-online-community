package cn.hiczy.chatserver.handler;

import io.netty.channel.*;
import org.springframework.stereotype.Component;

import java.net.SocketAddress;


/**
 *  服务端发送消息给客户端
 */
@Component
@ChannelHandler.Sharable
public class SenderHandler extends ChannelOutboundHandlerAdapter {

}

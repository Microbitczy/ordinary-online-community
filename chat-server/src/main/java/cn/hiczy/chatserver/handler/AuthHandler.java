package cn.hiczy.chatserver.handler;

import cn.hiczy.protobuf.AuthResponseProto;
import cn.hiczy.protobuf.MessageProto;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 认证处理器,每个连接进来都要首先经过这个处理器
 */
public class AuthHandler extends ChannelInboundHandlerAdapter {

    ConcurrentHashMap<Channel, String> sessionMap = new ConcurrentHashMap<>();

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //校验登陆
        MessageProto.Message message = (MessageProto.Message) msg;
        if (sessionMap.containsKey(message.getSessionId())) {

        }


        if(message.getType().equals(MessageProto.Message.MessageType.AUTH_REQ)){
            message.getJwt().equals("auth");
            String sessionId = UUID.randomUUID().toString().substring(0, 8);
            sessionMap.put( ctx.channel(),sessionId);
        }

        //提示登陆
        AuthResponseProto.AuthResponse authRsp = AuthResponseProto.AuthResponse.newBuilder()
                .setCode(AuthResponseProto.AuthResponse.ResponseCode.FAILED)
                .build();

        MessageProto.Message.newBuilder()
                .setAuthRsp(authRsp);

        ctx.writeAndFlush(authRsp);


    }


    /**
     * 与客户端建立连接时
     * @param ctx ctx
     * @throws Exception Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //一上线就提示登陆



        super.channelActive(ctx);
    }


    /**
     * 当客户端失去连接时
     * @param ctx ctx
     * @throws Exception Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
    }
}

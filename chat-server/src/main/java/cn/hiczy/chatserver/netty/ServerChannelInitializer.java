package cn.hiczy.chatserver.netty;

import cn.hiczy.chatserver.handler.AuthHandler;
import cn.hiczy.chatserver.handler.OfflineMessageHandler;
import cn.hiczy.chatserver.handler.MsgDispatcherHandler;
import cn.hiczy.protobuf.MessageProto;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Resource
    private MsgDispatcherHandler dispatcherHandler;

//    @Resource
//    private SenderHandler senderHandler;

    @Resource
    private AuthHandler authHandler;

    @Resource
    private OfflineMessageHandler offlineMessageHandler;

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {


        ch.pipeline()
                //添加解码器相关组件
                .addLast(new ProtobufVarint32FrameDecoder())
                .addLast(new ProtobufDecoder(MessageProto.Message.getDefaultInstance()))

                //添加编码器相关组件
                .addLast(new ProtobufVarint32LengthFieldPrepender())
                .addLast(new ProtobufEncoder())

                //认证处理器
                .addLast(authHandler)

                //离线消息处理器
                .addLast(offlineMessageHandler)

                //转发处理器
                .addLast(dispatcherHandler);

    }
}

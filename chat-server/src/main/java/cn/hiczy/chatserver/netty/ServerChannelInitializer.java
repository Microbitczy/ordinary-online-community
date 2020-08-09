package cn.hiczy.chatserver.netty;

import cn.hiczy.chatserver.handler.AuthHandler;
import cn.hiczy.chatserver.handler.ReceiverHandler;
import cn.hiczy.chatserver.handler.SenderHandler;
import cn.hiczy.protobuf.MessageProto;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Resource
    private ReceiverHandler receiverHandler;

    @Resource
    private SenderHandler senderHandler;

    @Resource
    private AuthHandler authHandler;

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {


        ch.pipeline()
                //添加解码器相关组件
                .addLast(new ProtobufVarint32FrameDecoder())
                .addLast(new ProtobufDecoder(MessageProto.Message.getDefaultInstance()))

                //添加编码器相关组件
                .addLast(new ProtobufVarint32LengthFieldPrepender())
                .addLast(new ProtobufEncoder())
                .addLast("authHandler",authHandler)
                .addLast(receiverHandler)
                .addLast(senderHandler);
    }
}

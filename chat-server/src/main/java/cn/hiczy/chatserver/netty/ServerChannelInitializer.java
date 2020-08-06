package cn.hiczy.chatserver.netty;

import cn.hiczy.chatserver.handler.ReceiverHandler;
import cn.hiczy.chatserver.handler.SenderHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import org.springframework.beans.factory.annotation.Autowired;

public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Autowired
    private ReceiverHandler receiverHandler;

    @Autowired
    private SenderHandler senderHandler;

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {




        ch.pipeline()
                //添加解码器相关组件
                .addLast(new ProtobufVarint32FrameDecoder())
                .addLast(new ProtobufDecoder(MessageProto.Message.getDefaultInstance()))

                //添加编码器相关组件
                .addLast(new ProtobufVarint32LengthFieldPrepender())
                .addLast(new ProtobufEncoder())

                //添加自定义业务逻辑处理器
                .addLast(receiverHandler)
                .addLast(senderHandler);
    }
}

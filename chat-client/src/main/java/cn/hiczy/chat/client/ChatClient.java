package cn.hiczy.chat.client;

import io.netty.bootstrap.Bootstrap;

import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class ChatClient {

    public static void main(String[] args) throws InterruptedException {

        NioEventLoopGroup worker = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(worker)
                .option(ChannelOption.SO_KEEPALIVE,true)
                .channel(NioSocketChannel.class)
                .handler(new ClientChannelInitializer());

        bootstrap.connect("localhost",9333).sync();

    }

}

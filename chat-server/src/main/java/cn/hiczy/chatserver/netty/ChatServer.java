package cn.hiczy.chatserver.netty;

import cn.hiczy.chatserver.handler.AuthHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LoggingHandler;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class ChatServer implements InitializingBean, DisposableBean {

    /**
     * boss线程组,处理连接请求
     */
    private EventLoopGroup boss = new NioEventLoopGroup();


    /**
     * worker线程组,处理业务请求
     */
    private EventLoopGroup worker = new NioEventLoopGroup();


    @Value("${chat-server.backlog-num}")
    private Integer backlogNum;

    @Value("${chat-server.port}")
    private Integer port;


    @Resource
    private ServerChannelInitializer serverChannelInitializer;

    /**
     * 启动Server
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(boss, worker)

                .channel(NioServerSocketChannel.class)

                //服务段可连接队列数-->对应TCP/IP 协议listen 函数中backlog函数
                .option(ChannelOption.SO_BACKLOG, backlogNum)

                //设置TCP长连接,一般如果两小时内没有数据的通信时,TCP会自动发送一个活动探测数据报文
                .childOption(ChannelOption.SO_KEEPALIVE, true)

                //关闭Nagle算法,及时传输数据. Nagle算法:将小的数据包包装成更大的帧进行传送,提高网络的负载,即 TCP延迟传输
                .childOption(ChannelOption.TCP_NODELAY, true)


                .childHandler(serverChannelInitializer);

        ChannelFuture future = bootstrap.bind(port).sync();

    }

    @Override
    public void destroy() throws Exception {
        boss.shutdownGracefully().sync();
        worker.shutdownGracefully().sync();
    }
}

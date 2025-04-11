package org.nettyx.test.template.tcp.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.fz.nettyx.template.tcp.server.TcpServerTemplate;
import org.nettyx.test.template.TestChannelInitializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/**
 * @author fengbinbin
 * @version 1.0
 * @since 2024/4/11 15:59
 */

@Component
public class TestServer extends TcpServerTemplate implements CommandLineRunner {

    public TestServer(@Value("${nettyx.test.server.port}") int bindPort) {
        super(bindPort);
    }

    @Override
    protected ChannelInitializer<NioSocketChannel> childChannelInitializer() {
        return new TestChannelInitializer<>();
    }

    @Override
    public void run(String... args) throws Exception {
        // 如果需要查看tcp连接的请把下面的代码注释去掉
//        ChannelFuture bindFuture = this.bind();
//        bindFuture.addListener(cf -> Console.log("binding state:" + cf.isSuccess()));
//        bindFuture.channel().closeFuture().addListener(cf -> {
//            Console.log("关闭了");
//            this.shutdownGracefully();
//        });
    }
}

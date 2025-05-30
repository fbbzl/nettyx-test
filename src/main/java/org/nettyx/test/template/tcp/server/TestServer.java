package org.nettyx.test.template.tcp.server;

import cn.hutool.core.lang.Console;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.fz.nettyx.template.tcp.server.TcpServerTemplate;
import org.nettyx.test.template.TestChannelInitializer;
import org.springframework.beans.factory.InitializingBean;


/**
 * @author fengbinbin
 * @version 1.0
 * @since 2024/4/11 15:59
 */

public class TestServer extends TcpServerTemplate implements InitializingBean {

    public TestServer(int bindPort) {
        super(bindPort);
    }

    @Override
    protected ChannelInitializer<NioSocketChannel> childChannelInitializer() {
        return new TestChannelInitializer<>();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ChannelFuture bindFuture = this.bind();
        bindFuture.addListener(cf -> Console.log("binding state:" + cf.isSuccess()));
        bindFuture.channel().closeFuture().addListener(cf -> {
            Console.log("关闭了");
            this.shutdownGracefully();
        });
    }
}

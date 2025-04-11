package org.nettyx.test.template.tcp.client;


import cn.hutool.core.lang.Console;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.fz.nettyx.listener.ActionChannelFutureListener;
import org.fz.nettyx.template.tcp.client.SingleTcpChannelClientTemplate;
import org.nettyx.test.template.TestChannelInitializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

import static org.fz.nettyx.action.ListenerAction.redo;
import static org.nettyx.test.codec.UserCodec.TEST_USER;

/**
 * @author fengbinbin
 * @version 1.0
 * @since 2024/4/11 15:59
 */

@Component
public class TestSingleTcpClient extends SingleTcpChannelClientTemplate implements CommandLineRunner {


    public TestSingleTcpClient(
            @Value("${nettyx.text.server.host}") String address,
            @Value("${nettyx.text.server.port}") int serverPort) {
        super(new InetSocketAddress(address, serverPort));
    }

    @Override
    protected ChannelInitializer<NioSocketChannel> channelInitializer() {
        return new TestChannelInitializer<>();
    }

    @Override
    public void run(String... args) throws Exception {
        ChannelFutureListener listener = new ActionChannelFutureListener()
                .whenSuccess((ls, cf) -> {

                    this.writeAndFlush(TEST_USER);

                    Console.log(cf.channel().localAddress() + ": ok");
                })
                .whenCancelled((ls, cf) -> Console.log("cancel"))
                .whenFailure(redo(this::connect, 10, TimeUnit.SECONDS, 3, (l, c) -> System.err.println(
                        "最后次失败后执行")))
                .whenDone((ls, cf) -> Console.log("done"));

        // 连接服务器
        this.connect().addListener(listener);
    }
}
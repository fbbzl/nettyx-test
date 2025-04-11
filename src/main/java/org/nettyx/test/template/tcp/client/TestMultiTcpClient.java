package org.nettyx.test.template.tcp.client;


import cn.hutool.core.lang.Console;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.fz.nettyx.listener.ActionChannelFutureListener;
import org.fz.nettyx.template.tcp.client.MultiTcpChannelClientTemplate;
import org.nettyx.test.template.TestChannelInitializer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.fz.nettyx.action.ListenerAction.redo;
import static org.nettyx.test.codec.UserCodec.TEST_USER;


/**
 * @author fengbinbin
 * @version 1.0
 * @since 2024/4/11 15:59
 */

@Component
public class TestMultiTcpClient extends MultiTcpChannelClientTemplate<String> implements CommandLineRunner {

    protected TestMultiTcpClient() {
        super(mockNewClientMap());
    }

    private static Map<String, InetSocketAddress> mockNewClientMap() {
        Map<String, InetSocketAddress> map        = new HashMap<>();
        InetSocketAddress              serverAddr = new InetSocketAddress(9888);
        for (int i = 0; i < 32; i++) {
            map.put("b" + i, serverAddr);
        }

        return map;
    }

    @Override
    protected ChannelInitializer<NioSocketChannel> channelInitializer() {
        return new TestChannelInitializer<>();
    }

    @Override
    public void run(String... args) throws Exception {
        ChannelFutureListener listener = new ActionChannelFutureListener()
                .whenSuccess((l, cf) -> {

                    cf.channel().writeAndFlush(TEST_USER);

                    Console.log(cf.channel().localAddress() + ": ok");
                })
                .whenCancelled((l, cf) -> Console.log("cancel"))
                .whenFailure(redo(cf -> this.connect(channelKey(cf)), 2, SECONDS, 2, (l, cf) -> {
                    String string = channelKey(cf).toString();
                    System.err.println(string);
                }))
                .whenDone((l, cf) -> Console.log("done"));

        this.connectAll().values().forEach(c -> c.addListener(listener));
    }
}

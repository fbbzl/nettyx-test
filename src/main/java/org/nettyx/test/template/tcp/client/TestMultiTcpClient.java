package org.nettyx.test.template.tcp.client;


import cn.hutool.core.lang.Console;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.fz.nettyx.listener.ActionChannelFutureListener;
import org.fz.nettyx.template.tcp.client.MultiTcpChannelClientTemplate;
import org.nettyx.test.template.TestChannelInitializer;
import org.springframework.boot.CommandLineRunner;

import java.net.InetSocketAddress;
import java.util.Map;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.fz.nettyx.action.ListenerAction.redo;
import static org.nettyx.test.codec.MsgCodec.TEST_MSG;


/**
 * @author fengbinbin
 * @version 1.0
 * @since 2024/4/11 15:59
 */

public class TestMultiTcpClient extends MultiTcpChannelClientTemplate<String> implements CommandLineRunner {

    public TestMultiTcpClient(Map<String, InetSocketAddress> map) {
        super(map);
    }

    @Override
    protected ChannelInitializer<NioSocketChannel> channelInitializer() {
        return new TestChannelInitializer<>();
    }

    @Override
    public void run(String... args) throws Exception {
        ChannelFutureListener listener = new ActionChannelFutureListener()
                .whenSuccess((l, cf) -> {

                    cf.channel().writeAndFlush(TEST_MSG);

                    Console.log(cf.channel().localAddress() + ": ok");
                })
                .whenCancelled((l, cf) -> Console.log("cancel"))
                .whenFailure(redo(cf -> this.connect(channelKey(cf)), 2, SECONDS, 2, (l, cf) -> {
                    String string = channelKey(cf).toString();
                    System.err.println(string);
                }))
                .whenDone((l, cf) -> Console.log("done"))
                ;

        this.connectAll().values().forEach(c -> c.addListener(listener));
    }
}

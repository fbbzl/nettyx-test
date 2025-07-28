package org.nettyx.test.template.tcp.client;


import cn.hutool.core.lang.Console;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.fz.nettyx.listener.ActionChannelFutureListener;
import org.fz.nettyx.template.tcp.client.SingleTcpChannelClientTemplate;
import org.nettyx.test.template.TestChannelInitializer;
import org.springframework.boot.CommandLineRunner;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

import static org.fz.nettyx.action.ListenerAction.redo;
import static org.nettyx.test.codec.MsgCodec.TEST_MSG;


/**
 * @author fengbinbin
 * @version 1.0
 * @since 2024/4/11 15:59
 */

public class TestSingleTcpClient extends SingleTcpChannelClientTemplate implements CommandLineRunner {

    public TestSingleTcpClient(String address, int serverPort) {
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
                    cf.channel().writeAndFlush(TEST_MSG);
                    Console.log(cf.channel().localAddress() + ": ok");
                })
                .whenCancelled((ls, cf) -> Console.log("cancel"))
                .whenFailure(redo(this::connect, 10, TimeUnit.SECONDS, 3, (l, c) -> Console.log("已重试3次, 但是依然失败")))
                .whenDone((ls, cf) -> Console.log("done"));

        this.connect().addListener(listener);
    }
}
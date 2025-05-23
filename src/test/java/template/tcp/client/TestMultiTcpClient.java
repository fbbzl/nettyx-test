package template.tcp.client;


import cn.hutool.core.lang.Console;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.fz.nettyx.listener.ActionChannelFutureListener;
import org.fz.nettyx.template.tcp.client.MultiTcpChannelClientTemplate;
import template.TestChannelInitializer;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

import static codec.UserCodec.TEST_USER;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.fz.nettyx.action.ListenerAction.redo;


/**
 * @author fengbinbin
 * @version 1.0
 * @since 2024/2/29 14:58
 */
public class TestMultiTcpClient extends MultiTcpChannelClientTemplate<String> {

    protected TestMultiTcpClient(Map<String, InetSocketAddress> inetSocketAddressMap) {
        super(inetSocketAddressMap);
    }

    @Override
    protected ChannelInitializer<NioSocketChannel> channelInitializer() {
        return new TestChannelInitializer<>();
    }

    public static void main(String[] args) {
        Map<String, InetSocketAddress> map        = new HashMap<>();
        InetSocketAddress              serverAddr = new InetSocketAddress(9888);
        for (int i = 0; i < 32; i++) {
            map.put("b" + i, serverAddr);
        }

        TestMultiTcpClient testMultiTcp = new TestMultiTcpClient(map);
        ChannelFutureListener listener = new ActionChannelFutureListener()
                .whenSuccess((l, cf) -> {

                    cf.channel().writeAndFlush(TEST_USER);

                    Console.log(cf.channel().localAddress() + ": ok");
                })
                .whenCancelled((l, cf) -> Console.log("cancel"))
                .whenFailure(redo(cf -> testMultiTcp.connect(channelKey(cf)), 2, SECONDS, 2, (l, cf) -> {
                    String string = channelKey(cf).toString();
                    System.err.println(string);
                }))
                .whenDone((l, cf) -> Console.log("done"));

        testMultiTcp.connectAll().values().forEach(c -> c.addListener(listener));

    }
}

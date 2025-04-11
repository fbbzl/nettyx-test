package org.nettyx.test.template.rxtx;

import cn.hutool.core.lang.Console;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import org.fz.nettyx.channel.serial.rxtx.RxtxChannel;
import org.fz.nettyx.channel.serial.rxtx.RxtxChannelConfig;
import org.fz.nettyx.listener.ActionChannelFutureListener;
import org.fz.nettyx.template.serial.rxtx.SingleRxtxChannelTemplate;
import org.nettyx.test.template.TestChannelInitializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;

import java.util.concurrent.TimeUnit;

import static org.fz.nettyx.action.ListenerAction.redo;

/**
 * @author fengbinbin
 * @version 1.0
 * @since 2024/4/11 15:59
 */
// rxtx 在通信前需要把工具jar和动态链接dll放到类路径下, 不然会报异常, 墙裂建议使用jsc库进行通信
//@Component
public class TestSingleRxtx extends SingleRxtxChannelTemplate implements CommandLineRunner {

    public TestSingleRxtx(@Value("${nettyx.test.comm.tx}") String commAddress) {
        super(commAddress);
    }

    @Override
    protected ChannelInitializer<RxtxChannel> channelInitializer() {
        return new TestChannelInitializer<>();
    }

    @Override
    public void run(String... args) throws Exception {
        ChannelFutureListener listener = new ActionChannelFutureListener()
                .whenSuccess((l, cf) -> {

                })
                .whenCancelled((l, cf) -> Console.log("cancel"))
                .whenFailure(redo(this::connect, 2, TimeUnit.MILLISECONDS, 3, (l, c) -> {

                    c.cause().printStackTrace();
                }))
                .whenDone((l, cf) -> Console.log("done"));

        this.connect().addListener(listener);

        // send msg
        this.write("this is msg from 5 write");
        this.writeAndFlush("this is msg from 6 writeAndFlush");
    }

    @Override
    protected void doChannelConfig(RxtxChannelConfig channelConfig) {
        channelConfig
                .setBaudRate(115200)
                .setDataBits(RxtxChannelConfig.DataBits.DATA_BITS_8)
                .setStopBits(RxtxChannelConfig.StopBits.STOP_BITS_1)
                .setParityBit(RxtxChannelConfig.ParityBit.NO)
                .setDtr(false)
                .setRts(false);
    }
}
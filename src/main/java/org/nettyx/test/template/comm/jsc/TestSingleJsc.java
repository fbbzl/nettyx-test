package org.nettyx.test.template.comm.jsc;


import cn.hutool.core.lang.Console;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import org.fz.nettyx.channel.serial.jsc.JscChannel;
import org.fz.nettyx.channel.serial.jsc.JscChannelConfig;
import org.fz.nettyx.listener.ActionChannelFutureListener;
import org.fz.nettyx.template.serial.jsc.SingleJscChannelTemplate;
import org.nettyx.test.template.TestChannelInitializer;
import org.springframework.boot.CommandLineRunner;

import java.util.concurrent.TimeUnit;

import static org.fz.nettyx.action.ListenerAction.redo;
import static org.nettyx.test.codec.MsgCodec.TEST_MSG;


/**
 * @author fengbinbin
 * @version 1.0
 * @since 2024/4/11 15:59
 */


public class TestSingleJsc extends SingleJscChannelTemplate implements CommandLineRunner {

    public TestSingleJsc(String commAddress) {
        super(commAddress);
    }

    @Override
    protected ChannelInitializer<JscChannel> channelInitializer() {
        return new TestChannelInitializer<>();
    }

    @Override
    public void run(String... args) throws Exception {
        ChannelFutureListener listener = new ActionChannelFutureListener()
                .whenSuccess((l, cf) -> {
                    this.writeAndFlush(TEST_MSG);
                })
                .whenCancelled((l, cf) -> Console.log("cancel"))
                .whenFailure(redo(this::connect, 2, TimeUnit.MILLISECONDS, 3, (l, c) -> {

                    c.cause().printStackTrace();
                }))
                .whenDone((l, cf) -> Console.log("done"))
                ;

        this.connect().addListener(listener);
    }

    @Override
    protected void doChannelConfig(JscChannelConfig channelConfig) {
        channelConfig
                .setBaudRate(115200)
                .setDataBits(JscChannelConfig.DataBits.DATA_BITS_8)
                .setStopBits(JscChannelConfig.StopBits.STOP_BITS_1)
                .setParityBit(JscChannelConfig.ParityBit.NO)
                .setDtr(false)
                .setRts(false)
        ;
    }


}
package org.nettyx.test.tcp.template;


import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.logging.LoggingHandler;
import org.fz.nettyx.codec.EscapeCodec;
import org.fz.nettyx.codec.StartEndFlagFrameCodec;
import org.fz.nettyx.handler.MessageEchoHandler;
import org.nettyx.test.tcp.codec.UserCodec;

import static io.netty.buffer.Unpooled.wrappedBuffer;
import static io.netty.handler.logging.ByteBufFormat.HEX_DUMP;


/**
 * @author fengbinbin
 * @version 1.0
 * @since 2024/3/1 22:59
 */

public class TestChannelInitializer<C extends Channel> extends ChannelInitializer<C> {

    @Override
    protected void initChannel(C channel) {
        channel.pipeline().addLast(
                new StartEndFlagFrameCodec(1024*1024, true, wrappedBuffer(new byte[]{ (byte) 0x7e }))
                , new EscapeCodec(EscapeCodec.EscapeMapping.mapHex("7e", "7d5e"))
                , new UserCodec()
                , new MessageEchoHandler()
                , new LoggingHandler(HEX_DUMP));
    }
}

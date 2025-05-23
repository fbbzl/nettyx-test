package org.nettyx.test.template;


import cn.hutool.core.lang.Console;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.logging.ByteBufFormat;
import io.netty.handler.logging.LoggingHandler;
import org.fz.nettyx.codec.EscapeCodec;
import org.fz.nettyx.codec.EscapeCodec.EscapeMap;
import org.fz.nettyx.codec.StartEndFlagFrameCodec;
import org.fz.nettyx.handler.ChannelAdvice.InboundAdvice;
import org.fz.nettyx.handler.ChannelAdvice.OutboundAdvice;
import org.fz.nettyx.handler.MessageEchoHandler;
import org.nettyx.test.codec.MsgCodec;


/**
 * @author fengbinbin
 * @version 1.0
 * @since 2024/4/11 15:59
 */

public class TestChannelInitializer<C extends Channel> extends ChannelInitializer<C> {

    @Override
    protected void initChannel(C channel) {
        InboundAdvice inboundAdvice = new InboundAdvice(channel)
                .whenChannelInactive(ctx -> Console.print("[断连了] 在这执行你的逻辑代码, 可以在这执行访问数据库, 发布事件,记录状态等任何操作"))
                .whenChannelActive(ctx -> Console.print("[连接成功] 在这执行你的逻辑代码, 可以在这执行访问数据库, 发布事件,记录状态等任何操作"));

        OutboundAdvice outboundAdvice = new OutboundAdvice(channel)
                .whenDisconnect((ctx, promise) -> Console.print("[断连了] 执行你的逻辑, 访问数据库, 发布事件,记录状态等任何操作..."));

        channel.pipeline().addLast(
                outboundAdvice,
                new StartEndFlagFrameCodec(1024 * 1024 * 8, true, "7e"),
                new EscapeCodec(new EscapeMap() {{ putHex("7e", "7d5e"); }}),
                new MsgCodec(),
                new MessageEchoHandler(),
                new LoggingHandler(ByteBufFormat.HEX_DUMP),
                inboundAdvice);
    }
}

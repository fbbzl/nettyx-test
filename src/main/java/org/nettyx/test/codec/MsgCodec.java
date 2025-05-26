package org.nettyx.test.codec;

import cn.hutool.core.date.StopWatch;
import cn.hutool.core.lang.Console;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.fz.nettyx.codec.StructCodec;
import org.fz.nettyx.serializer.struct.StructSerializer;
import org.nettyx.test.codec.model.Msg;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author fengbinbin
 * @version 1.0
 * @since 2024/7/26 19:52
 */
public class MsgCodec extends StructCodec<Msg> {

    public static final Msg TEST_MSG;

    static {
        byte[] bytes = new byte[5000];
        Arrays.fill(bytes, (byte) 67);
        bytes[2] = 0x7e;
        bytes[4] = 0x1e;
        bytes[5] = 0x7d;

        TEST_MSG = StructSerializer.toStruct(Msg.class, bytes);
        byte[] bytes1 = StructSerializer.toBytes(TEST_MSG);
        System.err.println();
    }

    @Override
    protected void encode(
            ChannelHandlerContext ctx,
            Msg msg,
            ByteBuf out) {
        StopWatch stopWatch = StopWatch.create("encode");
        stopWatch.start("encode");
        super.encode(ctx, msg, out);
        stopWatch.stop();

        Console.log(stopWatch.prettyPrint(TimeUnit.MICROSECONDS));
    }

    @Override
    protected void decode(
            ChannelHandlerContext ctx,
            ByteBuf msg,
            List<Object> out) {
        StopWatch stopWatch = StopWatch.create("decode");
        stopWatch.start("decode");
        super.decode(ctx, msg, out);
        stopWatch.stop();

        Console.log(stopWatch.prettyPrint(TimeUnit.MICROSECONDS));
    }
}

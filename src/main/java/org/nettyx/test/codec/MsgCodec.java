package org.nettyx.test.codec;

import cn.hutool.core.date.StopWatch;
import cn.hutool.core.lang.Console;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.fz.nettyx.codec.StructCodec;
import org.fz.nettyx.serializer.struct.StructSerializer;
import org.fz.nettyx.serializer.struct.basic.c.signed.clong4;
import org.fz.nettyx.serializer.struct.basic.c.unsigned.culong8;
import org.fz.nettyx.util.TypeRefer;
import org.nettyx.test.codec.model.*;

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
        TypeRefer<User<clong4, Wife<culong8, Son<clong4, Bill>>, GirlFriend>> typeRefer = new TypeRefer<User<clong4,
                Wife<culong8, Son<clong4, Bill>>, GirlFriend>>() {};
        byte[] bytes = new byte[8000];
        Arrays.fill(bytes, (byte) 67);

        TEST_MSG = StructSerializer.toStruct(Msg.class, bytes);

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

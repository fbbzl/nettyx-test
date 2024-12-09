package org.nettyx.test.codec;

import cn.hutool.core.date.StopWatch;
import cn.hutool.core.lang.Console;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.fz.nettyx.codec.StructCodec;
import org.fz.nettyx.serializer.struct.StructSerializerContext;
import org.fz.nettyx.serializer.struct.basic.c.signed.Cint;
import org.fz.nettyx.serializer.struct.basic.c.signed.Clong4;
import org.fz.nettyx.serializer.struct.basic.c.unsigned.Culong8;
import org.nettyx.test.codec.model.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author fengbinbin
 * @version 1.0
 * @since 2024/7/26 19:52
 */
public class UserCodec extends StructCodec<User<Clong4, Wife<Culong8, Son<Clong4, Bill>>, GirlFriend>> {

    private static final StructSerializerContext context = new StructSerializerContext("org.nettyx.test");

    public static final User<Clong4, Wife<Culong8, Son<Clong4, Bill>>, GirlFriend> TEST_USER;

    static {
        TEST_USER = new User<>();
        TEST_USER.setCint(Cint.MIN_VALUE);
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, User<Clong4, Wife<Culong8, Son<Clong4, Bill>>, GirlFriend> msg, ByteBuf out) {
        StopWatch stopWatch = StopWatch.create("encode");
        stopWatch.start("encode");
        super.encode(ctx, msg, out);
        stopWatch.stop();

        Console.log(stopWatch.prettyPrint(TimeUnit.MILLISECONDS));
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) {
        StopWatch stopWatch = StopWatch.create("decode");
        stopWatch.start("decode");
        super.decode(ctx, msg, out);
        stopWatch.stop();

        Console.log(stopWatch.prettyPrint(TimeUnit.MILLISECONDS));
    }
}

package org.nettyx.test.codec;

import cn.hutool.core.date.StopWatch;
import cn.hutool.core.lang.Console;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.fz.nettyx.codec.StructCodec;
import org.fz.nettyx.serializer.struct.StructSerializer;
import org.fz.nettyx.serializer.struct.TypeRefer;
import org.fz.nettyx.serializer.struct.basic.c.signed.Clong4;
import org.fz.nettyx.serializer.struct.basic.c.unsigned.Culong8;
import org.nettyx.test.codec.model.*;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author fengbinbin
 * @version 1.0
 * @since 2024/7/26 19:52
 */
public class UserCodec extends StructCodec<User<Clong4, Wife<Culong8, Son<Clong4, Bill>>, GirlFriend>> {

    public static final User<Clong4, Wife<Culong8, Son<Clong4, Bill>>, GirlFriend> TEST_USER;

    static {
        TypeRefer<User<Clong4, Wife<Culong8, Son<Clong4, Bill>>, GirlFriend>> typeRefer = new TypeRefer<User<Clong4,
                Wife<Culong8, Son<Clong4, Bill>>, GirlFriend>>() {};
        byte[] bytes = new byte[8000];
        Arrays.fill(bytes, (byte) 67);

        TEST_USER = StructSerializer.toStruct(typeRefer, bytes);
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, User<Clong4, Wife<Culong8, Son<Clong4, Bill>>, GirlFriend> msg,
                          ByteBuf out) {
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

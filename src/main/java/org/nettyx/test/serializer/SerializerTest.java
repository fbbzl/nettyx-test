package org.nettyx.test.serializer;

import cn.hutool.core.date.StopWatch;
import cn.hutool.core.lang.Console;
import io.netty.buffer.ByteBuf;
import org.fz.nettyx.serializer.struct.StructSerializer;
import org.fz.nettyx.serializer.struct.StructSerializerContext;
import org.fz.nettyx.serializer.struct.basic.c.signed.clong4;
import org.fz.nettyx.serializer.struct.basic.c.signed.clong8;
import org.fz.nettyx.util.TypeRefer;
import org.junit.Before;
import org.junit.Test;
import org.nettyx.test.codec.model.*;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.fz.nettyx.serializer.struct.StructSerializer.toBytes;
import static org.fz.nettyx.serializer.struct.StructSerializer.toStruct;

/**
 * @author fengbinbin
 * @version 1.0
 * @since 2023/5/23 21:35
 */
public class SerializerTest {
    static final TypeRefer<User<Bill, Wife<GirlFriend, Son<clong4, Bill>>, clong8>> userTypeRefer =
            new TypeRefer<User<Bill,
                                Wife<GirlFriend, Son<clong4, Bill>>, clong8>>() {
            };

    static final Class<You> youCLass = You.class;
    private static final StructSerializerContext context = new StructSerializerContext("org.nettyx");

    @Before
    public void correctnessTest() {
        TypeRefer< User< Bill,  Wife<Son<clong4, Bill>, Son<clong4, Bill>>, GirlFriend>> userTypeRefer =
                new TypeRefer<>() {};

        byte[] bytes = new byte[1200];
        Arrays.fill(bytes, (byte) 67);
        User struct   = toStruct(userTypeRefer, bytes);
        byte[]           buf      = toBytes(userTypeRefer, struct);
        byte[]           emptyBuf = toBytes(userTypeRefer, new User<>());
        Console.log(">correctness test passed!!!!!!!!<");
        Console.log("");
    }

    @Test
    public void testStructSerializer() {
        byte[] bytes = new byte[200];
        Arrays.fill(bytes, (byte) 67);
        You turn = StructSerializer.toStruct(youCLass, bytes);
        byte[] bytes1 = StructSerializer.toBytes(turn);
        System.err.println(bytes1.length+"个字节");
        StopWatch stopWatch = StopWatch.create("反序列");
        stopWatch.start();
        for (int i = 0; i < 1_000_000; i++) {
            ByteBuf byteBuf = StructSerializer.toByteBuf(youCLass, turn);
        }
        stopWatch.stop();
        Console.print(stopWatch.prettyPrint(TimeUnit.MILLISECONDS));

//        final byte[] userWriteBytes = StructSerializer.toBytes(userTypeRefer, turn);
//
//        System.err.println(ArrayUtil.equals(bytes, userWriteBytes));
    }

    public void setNullForTest(User user) {
        user.setAddress(null);
        user.setQqNames(null);
        user.setSs(null);
        user.setWives(null);
        user.setWives121212(null);
        user.setG111fs(null);
        user.setBs2d(null);
        user.setSonsbaba(null);
        user.setSonff(null);
        user.setSo111ns(null);
        user.setWwife(null);
        user.setWives(null);
        user.setWives121212(null);
    }
}

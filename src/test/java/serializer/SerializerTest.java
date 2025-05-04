package serializer;

import cn.hutool.core.date.StopWatch;
import cn.hutool.core.lang.Console;
import codec.ComplexStruct;
import codec.ExampleStruct;
import codec.model.You;
import org.fz.nettyx.serializer.struct.StructSerializer;
import org.fz.nettyx.serializer.struct.StructSerializerContext;
import org.fz.nettyx.serializer.struct.basic.c.signed.Clong4;
import org.fz.nettyx.serializer.struct.basic.c.signed.Clong8;
import org.fz.nettyx.util.HexKit;
import org.fz.nettyx.util.TypeRefer;
import org.junit.Test;
import org.nettyx.test.codec.model.*;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @author fengbinbin
 * @version 1.0
 * @since 2023/5/23 21:35
 */
public class SerializerTest {
    static final TypeRefer<User<Bill, Wife<GirlFriend, Son<Clong4, Bill>>, Clong8>> userTypeRefer =
            new TypeRefer<User<Bill,
                                Wife<GirlFriend, Son<Clong4, Bill>>, Clong8>>() {
            };

    static final Class<You> youCLass = You.class;
    private static final StructSerializerContext context = new StructSerializerContext("codec");


    @Test
    public void testComplexStructSerializer() {
        byte[] bytes = HexKit.decode("39300000C3F54840572E1640F304B53F4B696D69000000000000802A00182D4444FB210940");

        ComplexStruct struct = StructSerializer.toStruct(ComplexStruct.class, bytes);

        System.err.println(struct);
    }

    @Test
    public void testExampleStructSerializer() {
        byte[] bytes = HexKit.decode("39300000C3F5484048656C6C6F576F726C64000000000000");

        ExampleStruct struct = StructSerializer.toStruct(ExampleStruct.class, bytes);

        System.err.println(struct);
    }
    @Test
    public void testStructSerializer() {
        byte[] bytes = new byte[88];
        Arrays.fill(bytes, (byte) 67);

        StopWatch stopWatch = StopWatch.create("反序列");
        stopWatch.start();
        for (int i = 0; i < 1_000_000; i++) {
            You turn = StructSerializer.toStruct(youCLass, bytes);
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

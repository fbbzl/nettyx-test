package org.nettyx.test.serializer;

import cn.hutool.core.date.StopWatch;
import cn.hutool.core.lang.Console;
import io.netty.buffer.ByteBuf;
import org.fz.erwin.lang.TypeRefer;
import org.fz.nettyx.serializer.struct.StructSerializer;
import org.fz.nettyx.serializer.struct.StructSerializerContext;
import org.fz.nettyx.serializer.struct.basic.c.signed.cchar;
import org.fz.nettyx.serializer.struct.basic.c.signed.cint;
import org.fz.nettyx.serializer.struct.basic.c.signed.clong4;
import org.fz.nettyx.serializer.struct.basic.c.signed.clong8;
import org.junit.Before;
import org.junit.Test;
import org.nettyx.test.biz.Bill;
import org.nettyx.test.codec.model.*;
import org.nettyx.test.codec.test.Score;
import org.nettyx.test.codec.test.Score.Contact;
import org.nettyx.test.codec.test.Score.Student;

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

    static final         Class<You>              youCLass = You.class;
    private static final StructSerializerContext context  = new StructSerializerContext("org.nettyx");

    @Before
    public void correctnessTest() {
        TypeRefer<User<Bill, Wife<Son<clong4, Bill>, Son<clong4, Bill>>, GirlFriend>> userTypeRefer =
                new TypeRefer<User<Bill, Wife<Son<clong4, Bill>, Son<clong4, Bill>>, GirlFriend>>() { };

        byte[] bytes = new byte[1200];
        Arrays.fill(bytes, (byte) 67);
        User   struct   = toStruct(userTypeRefer, bytes);
        byte[] buf      = toBytes(userTypeRefer, struct);
        byte[] emptyBuf = toBytes(userTypeRefer, new User<>());
        Score  score    = new Score();
        score.setMath(new cint(100));
        score.setEnglish(new cint(99));
        Contact contact = new Contact();
        contact.setPhone(new cint(78));
        contact.setEmail(new cchar[]{ new cchar(1), new cchar(4) });
        Student student = new Student();
        student.setId(new cint(23));
        student.setName(new cchar[]{ new cchar(7), new cchar(2) });
        student.setScores(score);
        student.setContact(contact);

        Student struct1 = toStruct(Student.class, toBytes(student));
        Console.log(">correctness test passed!!!!!!!!<");
        Console.log("");
    }

    @Test
    public void testStructSerializer() {
        byte[] bytes = new byte[300];
        Arrays.fill(bytes, (byte) 67);
        You    turn   = StructSerializer.toStruct(youCLass, bytes);
        byte[] bytes1 = StructSerializer.toBytes(turn);
        System.err.println(bytes1.length + "个字节");
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

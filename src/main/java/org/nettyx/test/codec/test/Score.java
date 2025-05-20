package org.nettyx.test.codec.test;

import lombok.Data;
import org.fz.nettyx.serializer.struct.annotation.Struct;
import org.fz.nettyx.serializer.struct.annotation.ToArray;
import org.fz.nettyx.serializer.struct.basic.c.signed.cchar;
import org.fz.nettyx.serializer.struct.basic.c.signed.cint;

/**
 * @author fengbinbin
 * @version 1.0
 * @since 2025/5/20 19:31
 */
@Data
@Struct
public class Score {
    cint math;
    cint english;

    @Data
    @Struct
    public static class Student {
        cint id;
        @ToArray(length = 20)
        cchar[] name;
        Score   scores;
        Contact contact;
    }

    @Data
    @Struct
    public static class Contact {
        cint phone;
        @ToArray(length = 30)
        cchar[] email;
    }
}

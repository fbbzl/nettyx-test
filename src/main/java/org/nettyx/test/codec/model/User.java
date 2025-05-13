package org.nettyx.test.codec.model;

import lombok.Data;
import org.fz.nettyx.serializer.struct.annotation.Chunk;
import org.fz.nettyx.serializer.struct.annotation.Struct;
import org.fz.nettyx.serializer.struct.annotation.ToArray;
import org.fz.nettyx.serializer.struct.annotation.ToNamedEnum;
import org.fz.nettyx.serializer.struct.basic.c.signed.*;
import org.fz.nettyx.serializer.struct.basic.c.unsigned.*;
import org.fz.nettyx.serializer.struct.basic.cpp.cppbool;
import org.fz.nettyx.serializer.struct.basic.cpp.signed.*;
import org.fz.nettyx.serializer.struct.basic.cpp.unsigned.*;

@Data
@Struct
public class User<T, W, G> {

    // 占位 header
    @Chunk(length = 40)
    byte[] header;

    @ToNamedEnum(enumType = Ccc.class, bufferLength = 2)
    private Ccc cccEnum;

    private clong4          uid;
    @ToArray(length = 5)
    private cppushort[]     qqNames;

    private Bom<T, W, G>                                  b;
    @ToArray(length = 5)
    private Bom<T, W, clong4>[]                           g111fs;
    @ToArray(length = 5)
    private Bom<T, Son<Cuchar11, Bill>, GirlFriend>[] bs2d;

    private T       sonsbaba;
    @ToArray(length = 5)
    private T[]     sonff;

    private W       wwife;
    @ToArray(length = 5)
    private W[]     wives121212;

    private cchar        uname;
    private cint         isMarried;
    private cchar        sex;
    private cfloat       address;
    private cdouble      platformId;
    private clong8       description;
    private culong8      interest;
    private Bill         bill;
    private cchar        cchar;
    private cdouble      cdouble;
    private cfloat       cfloat;
    private cint         cint;
    private clong4       clong4;
    private clong8       clong8;
    private clonglong    clonglong;
    private cshort       cshort;
    private Cuchar11     cuchar11;
    private cuint        cuint;
    private culong4      culong4;
    private culong8      culong8;
    private culonglong   culonglong;
    private cushort      cushort;
    private cppchar8_t   cpp8tchar;
    private cppchar16_t  cpp16tchar;
    private cppchar32_t  cpp32tchar;
    private cppdouble    cppdouble;
    private cppfloat     cppfloat;
    private cppint       cppint;
    private cpplong4     cpplong4;
    private cpplong8     cpplong8;
    private cpplonglong  cpplonglong;
    private cppshort     cppshort;
    private cppuchar     cppuchar;
    private cppuint      cppuint;
    private cppulong4    cppulong4;
    private cppulong8    cppulong8;
    private cppulonglong cppulonglong;
    private cppushort    cppushort;
    private cppbool      cppBool;

    public enum Ccc {
        TT,
        CC,
        ;
    }

}
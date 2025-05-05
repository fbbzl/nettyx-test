package org.nettyx.test.codec.model;

import lombok.Data;
import org.fz.nettyx.serializer.struct.annotation.Struct;
import org.fz.nettyx.serializer.struct.annotation.ToArray;
import org.fz.nettyx.serializer.struct.annotation.ToArrayList;
import org.fz.nettyx.serializer.struct.annotation.ToNamedEnum;
import org.fz.nettyx.serializer.struct.basic.c.signed.*;
import org.fz.nettyx.serializer.struct.basic.c.unsigned.*;
import org.fz.nettyx.serializer.struct.basic.cpp.CppBool;
import org.fz.nettyx.serializer.struct.basic.cpp.signed.*;
import org.fz.nettyx.serializer.struct.basic.cpp.unsigned.*;

import java.util.List;

@Data
@Struct
public class User<T, W, G> {

    @ToNamedEnum(enumType = Ccc.class, bufferLength = 2)
    private Ccc cccEnum;

    private Clong4          uid;
    @ToArray(length = 5)
    private Cppushort[]     qqNames;
    @ToArrayList(size = 5)
    private List<Cppushort> ss;
    @ToArrayList(size = 5)
    private List<Cppushort> tts;

    private Bom<T, W, G>                                  b;
    @ToArray(length = 5)
    private Bom<T, W, Clong4>[]                           g111fs;
    @ToArrayList(size = 5)
    private List<Bom<T, Son<Cuchar11, Bill>, GirlFriend>> bs2d;

    private T       sonsbaba;
    @ToArray(length = 5)
    private T[]     sonff;
    @ToArrayList(size = 5)
    private List<T> so111ns;

    private W       wwife;
    @ToArrayList(size = 5)
    private List<W> wives;
    @ToArray(length = 5)
    private W[]     wives121212;

    private Cchar        uname;
    private Cint         isMarried;
    private Cchar        sex;
    private Cfloat       address;
    private Cdouble      platformId;
    private Clong8       description;
    private Culong8      interest;
    private Bill         bill;
    private Cchar        cchar;
    private Cdouble      cdouble;
    private Cfloat       cfloat;
    private Cint         cint;
    private Clong4       clong4;
    private Clong8       clong8;
    private Clonglong    clonglong;
    private Cshort       cshort;
    private Cuchar11     cuchar11;
    private Cuint        cuint;
    private Culong4      culong4;
    private Culong8      culong8;
    private Culonglong   culonglong;
    private Cushort      cushort;
    private Cpp8charT    cpp8tchar;
    private Cpp16charT   cpp16tchar;
    private Cpp32charT   cpp32tchar;
    private Cppdouble    cppdouble;
    private Cppfloat     cppfloat;
    private Cppint       cppint;
    private Cpplong4     cpplong4;
    private Cpplong8     cpplong8;
    private Cpplonglong  cpplonglong;
    private Cppshort     cppshort;
    private Cppuchar     cppuchar;
    private Cppuint      cppuint;
    private Cppulong4    cppulong4;
    private Cppulong8    cppulong8;
    private Cppulonglong cppulonglong;
    private Cppushort    cppushort;
    private CppBool      cppBool;

    public enum Ccc {
        TT,
        CC,
        ;
    }

}
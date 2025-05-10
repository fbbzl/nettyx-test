package codec.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.fz.nettyx.serializer.struct.annotation.Struct;
import org.fz.nettyx.serializer.struct.annotation.ToArray;
import org.fz.nettyx.serializer.struct.annotation.ToArrayList;
import org.fz.nettyx.serializer.struct.annotation.ToNamedEnum;
import org.fz.nettyx.serializer.struct.basic.c.signed.*;
import org.fz.nettyx.serializer.struct.basic.c.unsigned.*;
import org.fz.nettyx.serializer.struct.basic.cpp.cppbool;
import org.fz.nettyx.serializer.struct.basic.cpp.signed.*;
import org.fz.nettyx.serializer.struct.basic.cpp.unsigned.*;

import java.util.List;

@Data
@Struct
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User<T, W, G> {

    @ToNamedEnum(enumType = Ccc.class, bufferLength = 2)
    Ccc cccEnum;

    clong4 uid;
    @ToArray(length = 5)
    cppushort[]     qqNames;
    @ToArrayList(size = 5)
    List<cppushort> ss;
    @ToArrayList(size = 5)
    List<cppushort> tts;

    Bom<T, W, G> b;
    @ToArray(length = 5)
    Bom<T, W, clong4>[]                         g111fs;
    @ToArrayList(size = 5)
    List<Bom<T, Son<cuchar, Bill>, GirlFriend>> bs2d;

    T sonsbaba;
    @ToArray(length = 5)
    T[]     sonff;
    @ToArrayList(size = 5)
    List<T> so111ns;

    W wwife;
    @ToArrayList(size = 5)
    List<W> wives;
    @ToArray(length = 5)
    W[]     wives121212;

    cchar        uname;
    cint         isMarried;
    cchar        sex;
    cfloat       address;
    cdouble      platformId;
    clong8       description;
    culong8      interest;
    Bill         bill;
    cchar        cchar;
    cdouble      cdouble;
    cfloat       cfloat;
    cint         cint;
    clong4       clong4;
    clong8       clong8;
    clonglong    clonglong;
    cshort       cshort;
    cuchar       cuchar;
    cuint        cuint;
    culong4      culong4;
    culong8      culong8;
    culonglong   culonglong;
    cushort      cushort;
    cppchar8_t    cpp8tchar;
    cppchar16_t   cpp16tchar;
    cppchar32_t   cpp32tchar;
    cppdouble    cppdouble;
    cppfloat     cppfloat;
    cppint       cppint;
    cpplong4     cpplong4;
    cpplong8     cpplong8;
    cpplonglong  cpplonglong;
    cppshort     cppshort;
    cppuchar     cppuchar;
    cppuint      cppuint;
    cppulong4    cppulong4;
    cppulong8    cppulong8;
    cppulonglong cppulonglong;
    cppushort cppushort;
    cppbool   cppBool;

    public enum Ccc {
        TT,
        CC,
        ;
    }

}
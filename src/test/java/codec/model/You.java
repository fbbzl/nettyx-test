package codec.model;

import lombok.Data;
import org.fz.nettyx.serializer.struct.annotation.ToCharSequence;
import org.fz.nettyx.serializer.struct.basic.c.signed.*;
import org.fz.nettyx.serializer.struct.basic.c.unsigned.*;
import org.fz.nettyx.serializer.struct.basic.cpp.signed.*;
import org.fz.nettyx.serializer.struct.basic.cpp.unsigned.Cppuchar;
import org.fz.nettyx.serializer.struct.basic.cpp.unsigned.Cppuint;
import org.fz.nettyx.serializer.struct.basic.cpp.unsigned.Cppulong4;
import org.fz.nettyx.serializer.struct.basic.cpp.unsigned.Cppulong8;

/**
 * @author fengbinbin
 * @version 1.0
 * @since 2025/4/19 16:48
 */

@Data
public class You {

    Cchar       uname;
    Cint        isMarried;
    Cchar       sex;
    Cfloat      address;
    Cdouble     platformId;
    Clong8      description;
    Culong8     interest;
    Bill        bill;
    Cchar       cchar;
    Cdouble     cdouble;
    Cfloat      cfloat;
    Cshort      cshort;
    Cuchar      cuchar;
    Cuint       cuint;
    Culong4     culong4;
    Culong8     culong8;
    Culonglong  culonglong;
    Cushort     cushort;
    Cpp8tchar   cpp8tchar;
    Cpp16tchar  cpp16tchar;
    Cpp32tchar  cpp32tchar;
    Cppdouble   cppdouble;
    Cppfloat    cppfloat;
    Cppint      cppint;
    Cpplong4    cpplong4;
    Cpplong8    cpplong8;
    Cpplonglong cpplonglong;
    Cppshort    cppshort;
    Cppuchar    cppuchar;
    Cppuint     cppuint;
    Cppulong4   cppulong4;
    Cppulong8   cppulong8;
    @ToCharSequence(bufferLength = 4)
    String fl;
    @ToCharSequence(bufferLength = 4)
    String fl3;
    @ToCharSequence(bufferLength = 4)
    String fl4;
    @ToCharSequence(bufferLength = 4)
    String f33l4;
    @ToCharSequence(bufferLength = 4)
    String fl443;
    @ToCharSequence(bufferLength = 4)
    String fl444;
    @ToCharSequence(bufferLength = 4)
    String f3344l4;

}

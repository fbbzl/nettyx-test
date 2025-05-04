package codec;

import lombok.Data;
import org.fz.nettyx.serializer.struct.annotation.Struct;
import org.fz.nettyx.serializer.struct.annotation.ToArray;
import org.fz.nettyx.serializer.struct.basic.c.signed.Cchar;
import org.fz.nettyx.serializer.struct.basic.c.signed.Cdouble;
import org.fz.nettyx.serializer.struct.basic.c.signed.Cfloat;
import org.fz.nettyx.serializer.struct.basic.c.signed.Cint;
import org.fz.nettyx.serializer.struct.basic.c.unsigned.Cuchar;
import org.fz.nettyx.serializer.struct.basic.c.unsigned.Cushort;

/**
 * @author fengbinbin
 * @version 1.0
 * @since 2025/5/4 14:24
 */
@Data
@Struct
public class ComplexStruct {
    Cint id;                // 4字节
    @ToArray(length = 3)
    Cfloat[] values;           // 3个浮点数，共12字节
    @ToArray(length = 10)
    Cchar[]    name;             // 10字节字符串
    Cuchar  flags;             // 1字节
    Cushort count;            // 2字节
    Cdouble bigValue;
}

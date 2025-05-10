package codec;

import lombok.Data;
import org.fz.nettyx.serializer.struct.annotation.Struct;
import org.fz.nettyx.serializer.struct.annotation.ToArray;
import org.fz.nettyx.serializer.struct.basic.c.signed.cchar;
import org.fz.nettyx.serializer.struct.basic.c.signed.cdouble;
import org.fz.nettyx.serializer.struct.basic.c.signed.cfloat;
import org.fz.nettyx.serializer.struct.basic.c.signed.cint;
import org.fz.nettyx.serializer.struct.basic.c.unsigned.cuchar;
import org.fz.nettyx.serializer.struct.basic.c.unsigned.cushort;

/**
 * @author fengbinbin
 * @version 1.0
 * @since 2025/5/4 14:24
 */
@Data
@Struct
public class ComplexStruct {
    cint id;                // 4字节
    @ToArray(length = 3)
    cfloat[] values;           // 3个浮点数，共12字节
    @ToArray(length = 10)
    cchar[]  name;             // 10字节字符串
    cuchar  flags;             // 1字节
    cushort count;            // 2字节
    cdouble bigValue;
}

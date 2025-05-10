package codec;

import lombok.Data;
import org.fz.nettyx.serializer.struct.annotation.Struct;
import org.fz.nettyx.serializer.struct.annotation.ToArray;
import org.fz.nettyx.serializer.struct.basic.c.signed.cchar;
import org.fz.nettyx.serializer.struct.basic.c.signed.cdouble;
import org.fz.nettyx.serializer.struct.basic.c.signed.cfloat;
import org.fz.nettyx.serializer.struct.basic.c.stdint.signed.cint32_t;
import org.fz.nettyx.serializer.struct.basic.c.stdint.unsigned.cuint16_t;
import org.fz.nettyx.serializer.struct.basic.c.stdint.unsigned.cuint8_t;

/**
 * @author fengbinbin
 * @version 1.0
 * @since 2025/5/5 10:23
 */

@Data
@Struct
public class OutComplexStruct {
    cint32_t id;                // 4字节有符号整数
    cuint8_t flags;             // 1字节无符号整数
    cuint16_t count;            // 2字节无符号整数
    cfloat    value;               // 4字节浮点数
    @ToArray(length = 10)
    cchar[] name;             // 10字节字符串
    cdouble      bigValue;           // 8字节双精度浮点数
    NestedStruct nested; // 嵌套结构体
    @ToArray(length = 5)
    cuint8_t[] array;
}

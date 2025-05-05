package codec;

import lombok.Data;
import org.fz.nettyx.serializer.struct.annotation.Struct;
import org.fz.nettyx.serializer.struct.annotation.ToArray;
import org.fz.nettyx.serializer.struct.basic.c.signed.Cchar;
import org.fz.nettyx.serializer.struct.basic.c.signed.Cdouble;
import org.fz.nettyx.serializer.struct.basic.c.signed.Cfloat;
import org.fz.nettyx.serializer.struct.basic.c.stdint.signed.Cint32T;
import org.fz.nettyx.serializer.struct.basic.c.stdint.unsigned.Cuint16T;
import org.fz.nettyx.serializer.struct.basic.c.stdint.unsigned.Cuint8T;

/**
 * @author fengbinbin
 * @version 1.0
 * @since 2025/5/5 9:30
 */

@Data
@Struct
public class TestStruct {

    Cint32T  id;                // 4字节有符号整数
    Cuint8T  flags;             // 1字节无符号整数
    Cuint16T count;            // 2字节无符号整数
    Cfloat   value;               // 4字节浮点数
    @ToArray(length = 10)
    Cchar[] name;             // 10字节字符串
    Cdouble bigValue;
}

package codec;

import lombok.Data;
import org.fz.nettyx.serializer.struct.annotation.Struct;
import org.fz.nettyx.serializer.struct.basic.c.signed.Cfloat;
import org.fz.nettyx.serializer.struct.basic.c.stdint.unsigned.Cuint16T;

/**
 * @author fengbinbin
 * @version 1.0
 * @since 2025/5/5 10:22
 */
@Data
@Struct
public class NestedStruct {
    Cuint16T nestedId;         // 2字节无符号整数
    Cfloat   nestedValue;         // 4字节浮点数
}

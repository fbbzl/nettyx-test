package codec;

import lombok.Data;
import org.fz.nettyx.serializer.struct.annotation.Struct;
import org.fz.nettyx.serializer.struct.basic.c.signed.cfloat;
import org.fz.nettyx.serializer.struct.basic.c.stdint.unsigned.cuint16_t;


/**
 * @author fengbinbin
 * @version 1.0
 * @since 2025/5/5 10:22
 */
@Data
@Struct
public class NestedStruct {
    cuint16_t nestedId;         // 2字节无符号整数
    cfloat    nestedValue;         // 4字节浮点数
}

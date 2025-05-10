package codec;

import lombok.Data;
import org.fz.nettyx.serializer.struct.annotation.Struct;
import org.fz.nettyx.serializer.struct.annotation.ToArray;
import org.fz.nettyx.serializer.struct.basic.c.signed.cchar;
import org.fz.nettyx.serializer.struct.basic.c.signed.cfloat;
import org.fz.nettyx.serializer.struct.basic.c.signed.cint;

/**
 * @author fengbinbin
 * @version 1.0
 * @since 2025/5/4 13:00
 */
@Data
@Struct
public class ExampleStruct {

    cint   id;           // 4字节
    cfloat value;          // 4字节
    @ToArray(length = 16)
    cchar[] name;

}

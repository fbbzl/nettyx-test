package codec;

import lombok.Data;
import org.fz.nettyx.serializer.struct.annotation.Struct;
import org.fz.nettyx.serializer.struct.annotation.ToArray;
import org.fz.nettyx.serializer.struct.basic.c.signed.Cchar;
import org.fz.nettyx.serializer.struct.basic.c.signed.Cfloat;
import org.fz.nettyx.serializer.struct.basic.c.signed.Cint;

/**
 * @author fengbinbin
 * @version 1.0
 * @since 2025/5/4 13:00
 */
@Data
@Struct
public class ExampleStruct {

    Cint   id;           // 4字节
    Cfloat value;          // 4字节
    @ToArray(length = 16)
    Cchar[] name;

}

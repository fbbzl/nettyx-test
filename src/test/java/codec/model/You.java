package codec.model;

import lombok.Data;
import org.fz.nettyx.serializer.struct.annotation.Struct;
import org.fz.nettyx.serializer.struct.annotation.ToArray;
import org.fz.nettyx.serializer.struct.basic.c.signed.*;
import org.fz.nettyx.serializer.struct.basic.c.unsigned.culong8;

/**
 * @author fengbinbin
 * @version 1.0
 * @since 2025/4/19 16:48
 */

@Data
@Struct
public class You {

    cchar   uname;
    cint    isMarried;
    cchar   sex;
    cfloat  address;
    cdouble platformId;
    clong8  description;
    culong8 interest;
    cint    isMarried1;
    cchar   sex1;
    cfloat  address1;
    cdouble platformId1;
    clong8  description1;
    @ToArray(length = 3)
    culong8[] interest1;



}

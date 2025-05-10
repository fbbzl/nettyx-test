package codec.model;

import lombok.Data;
import org.fz.nettyx.serializer.struct.annotation.Struct;
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
    culong8 interest1;
    cint    isMarried2;
    cchar   sex2;
    cfloat  address2;
    cdouble platformId2;
    clong8  description2;
    culong8 interest2;
    culong8 interest12;
    cint    isMarried22;
    cchar   sex22;
    cfloat  address22;
    cdouble platformId22;
    clong8  description22;
    culong8 interest22;

}

package codec.model;

import lombok.Data;
import org.fz.nettyx.serializer.struct.annotation.Struct;
import org.fz.nettyx.serializer.struct.basic.c.signed.*;
import org.fz.nettyx.serializer.struct.basic.c.unsigned.Culong8;

/**
 * @author fengbinbin
 * @version 1.0
 * @since 2025/4/19 16:48
 */

@Data
@Struct
public class You {

    Cchar       uname;
    Cint        isMarried;
    Cchar       sex;
    Cfloat      address;
    Cdouble     platformId;
    Clong8      description;
    Culong8     interest;
    Cint        isMarried1;
    Cchar       sex1;
    Cfloat      address1;
    Cdouble     platformId1;
    Clong8      description1;
    Culong8     interest1;

}

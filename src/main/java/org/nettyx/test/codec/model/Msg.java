package org.nettyx.test.codec.model;

import lombok.Data;
import org.fz.nettyx.serializer.struct.annotation.Struct;
import org.fz.nettyx.serializer.struct.annotation.ToArray;
import org.fz.nettyx.serializer.struct.basic.c.signed.*;
import org.fz.nettyx.serializer.struct.basic.c.unsigned.culong8;
import org.nettyx.test.biz.Bill;

/**
 * @author fengbinbin
 * @version 1.0
 * @since 2025/4/19 16:48
 */

@Data
@Struct
public class Msg {

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

    cfloat  address22;
    cdouble platformId22;
    clong8  description22;
    culong8 interest22;
    cfloat  address12;
    cdouble platformId12;
    clong8  description12;
    culong8 interest121;
    cint    isMarried222;
    cchar   sex22;
    cfloat  address222;
    cdouble platfo2rmId22;
    clong8  descriptio2n22;
    culong8 intere2st22;
    culong8 interest1222;
    cint    isMarried2222;
    cfloat  address2222;
    cdouble platformId222;
    clong8  description222;
    culong8 interest222;

    cchar   sex2222;
    cfloat  address22222;
    cdouble platfo2rmId2222;
    clong8  descriptio2n2222;
    culong8 intere2st2222;
    culong8 interest122222;
    cint    isMarried222222;
    cfloat  address222222;
    cdouble platformId22222;
    clong8  description22222;
    culong8 interest22222;
    Bill    bill;
    @ToArray(length = 100)
    culong8[] interest222221;
    Fork fork;


    @Data
    @Struct
    public static class Fork {
        Giffy giffy;

        @Data
        @Struct
        public static class Giffy {
            culong8 interest;
        }

    }

}

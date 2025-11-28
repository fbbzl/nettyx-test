package org.nettyx.test.codec.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.fz.nettyx.serializer.struct.annotation.Struct;
import org.fz.nettyx.serializer.struct.annotation.ToCharSequence;
import org.fz.nettyx.serializer.struct.annotation.ToNamedEnum;
import org.fz.nettyx.serializer.struct.basic.c.unsigned.cuchar;

@Data
@Struct
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Bill {

    cuchar bid;

    @ToCharSequence(bufferLength = 4)
    String orgName;

    @ToNamedEnum(enumType = BillType.class, bufferLength = 3)
    BillType billType;

    public enum BillType {
        C,
        CC,
        CCC,
        CCCC, CCCCC,
        ;
    }
}







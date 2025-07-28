package org.nettyx.test.core.struct;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.fz.nettyx.serializer.struct.annotation.Struct;
import org.fz.nettyx.serializer.struct.annotation.ToCharSequence;
import org.fz.nettyx.serializer.struct.basic.c.signed.cdouble;
import org.fz.nettyx.serializer.struct.basic.c.signed.cint;
import org.fz.nettyx.serializer.struct.basic.c.unsigned.culong8;

/**
 * Temperature message
 *
 * @author fengbinbin
 * @version 1.0
 * @since 2025 /7/28 16:26
 */
@Data
@Struct
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Temperature {

    cint value;

    @ToCharSequence(bufferLength = 2)
    String deviceName;

    cdouble platformId;

    culong8 description;


}

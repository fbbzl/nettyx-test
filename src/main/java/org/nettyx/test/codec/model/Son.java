package org.nettyx.test.codec.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.fz.nettyx.serializer.struct.annotation.Struct;

@Data
@Struct
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Son<B, Y> {

    B name;
    Y sonOrder;

}

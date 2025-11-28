package org.nettyx.test.codec.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.fz.nettyx.serializer.struct.annotation.Struct;

/**
 * @author fengbinbin
 * @version 1.0
 * @since 2024/3/19 11:17
 */

@Data
@Struct
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Bom<T, W, U> {

    T t;
    W gg;
    U mm;

}

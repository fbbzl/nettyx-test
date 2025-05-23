package org.nettyx.test.codec.model;

import lombok.Data;
import org.fz.nettyx.serializer.struct.annotation.Struct;

/**
 * @author fengbinbin
 * @version 1.0
 * @since 2024/3/19 11:17
 */

@Data
@Struct
public class Bom<T, W, U> {

    private T t;
    private W gg;
    private U mm;

}

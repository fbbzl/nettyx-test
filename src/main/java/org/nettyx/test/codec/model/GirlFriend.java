package org.nettyx.test.codec.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.fz.nettyx.serializer.struct.annotation.Struct;
import org.fz.nettyx.serializer.struct.annotation.ToCharSequence;

@Data
@Struct
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GirlFriend {

    @ToCharSequence(bufferLength = 2)
    String cup;
}
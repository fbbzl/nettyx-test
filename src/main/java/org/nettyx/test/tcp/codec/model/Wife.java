package org.nettyx.test.tcp.codec.model;

import lombok.Data;
import org.fz.nettyx.serializer.struct.annotation.Struct;
import org.fz.nettyx.serializer.struct.annotation.ToString;

@Data
@Struct
public class Wife<I, V> {

    private I      intt;
    @ToString(bufferLength = 2)
    private String name;

    private V vv;
}
package org.nettyx.test.config;

import org.fz.nettyx.serializer.struct.StructSerializerContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author fengbinbin
 * @version 1.0
 * @since 2025/4/13 11:33
 */

@Configuration
public class SerializerConfiguration {

    @Bean
    public StructSerializerContext structSerializerContext(@Value("${nettyx.struct.scan-packages:org.nettyx.test}") String scanPackages) {
        return new StructSerializerContext(scanPackages);
    }
}

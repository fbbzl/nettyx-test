package org.nettyx.test.template.comm;

import org.nettyx.test.template.comm.jsc.TestSingleJsc;
import org.nettyx.test.template.comm.rxtx.TestSingleRxtx;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava.Range;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.system.JavaVersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author fengbinbin
 * @version 1.0
 * @since 2025/4/13 12:46
 */

@Configuration
@ConditionalOnProperty(name = "comm-test.enable", havingValue = "true")
public class TestCommConfiguration {

    @Bean
    public TestSingleJsc jscClientTx(@Value("${comm-test.comm.rx}") String commAddress) {
        return new TestSingleJsc(commAddress);
    }

    @Bean
    @ConditionalOnJava(value = JavaVersion.NINE, range = Range.OLDER_THAN)
    public TestSingleRxtx rxtxClientRx(@Value("${comm-test.comm.tx}") String commAddress) {
        return new TestSingleRxtx(commAddress);
    }

    @Bean
    @ConditionalOnJava(value = JavaVersion.NINE, range = Range.EQUAL_OR_NEWER)
    public TestSingleJsc jscClientRx(@Value("${comm-test.comm.tx}") String commAddress) {
        return new TestSingleJsc(commAddress);
    }


}

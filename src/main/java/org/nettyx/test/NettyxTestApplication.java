package org.nettyx.test;

import org.fz.nettyx.starter.annotation.EnableStructScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * this application is for the nettyx testing
 *
 * @author fengbinbin
 * @version 1.0
 * @since 2025/4/11 14:16
 */
@EnableStructScan(basePackages = { "org.nettyx.test" })
@SpringBootApplication
public class NettyxTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(NettyxTestApplication.class, args);
    }

}

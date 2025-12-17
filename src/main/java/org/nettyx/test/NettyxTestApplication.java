package org.nettyx.test;

import lombok.extern.slf4j.Slf4j;
import org.fz.nettyx.starter.annotation.EnableStructScan;
import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * this application is for the nettyx testing
 *
 * @author fengbinbin
 * @version 1.0
 * @since 2025/4/11 14:16
 */
@Slf4j
@EnableStructScan(basePackages = { "org.nettyx.test" })
@SpringBootApplication
public class NettyxTestApplication {

    public static void main(String[] args) {
        MDC.put("traceId", "ABC-12345");

        // 启动 Spring Boot（会输出 banner 和启动日志）
        SpringApplication.run(NettyxTestApplication.class, args);

        // 手动打一条日志
        log.info("✅ This log should show traceId!");
    }

}

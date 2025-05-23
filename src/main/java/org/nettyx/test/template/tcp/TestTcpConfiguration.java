package org.nettyx.test.template.tcp;

import org.nettyx.test.template.tcp.client.TestMultiTcpClient;
import org.nettyx.test.template.tcp.client.TestSingleTcpClient;
import org.nettyx.test.template.tcp.server.TestServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fengbinbin
 * @version 1.0
 * @since 2025/4/13 12:39
 */

@Configuration
@ConditionalOnProperty(name = "tcp-test.enable", havingValue = "true")
public class TestTcpConfiguration {

    @Bean
    public TestSingleTcpClient testSingleTcpClient(
            @Value("${tcp-test.server.host}") String host,
            @Value("${tcp-test.server.port}") int port) {
        return new TestSingleTcpClient(host, port);
    }

    @Bean
    public TestServer testServer(@Value("${tcp-test.server.port}") int port) {
        return new TestServer(port);
    }

    @Bean
    public TestMultiTcpClient testMultiTcpClient(
            @Value("${tcp-test.server.host}") String host,
            @Value("${tcp-test.server.port}") int port) {
        Map<String, InetSocketAddress> map        = new HashMap<>();
        InetSocketAddress              serverAddr = new InetSocketAddress(host, port);
        // 模拟创建了4channel
        for (int i = 0; i < 4; i++) {
            map.put("b" + i, serverAddr);
        }
        return new TestMultiTcpClient(map);
    }
}

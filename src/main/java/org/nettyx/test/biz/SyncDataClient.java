package org.nettyx.test.biz;

import lombok.RequiredArgsConstructor;
import org.nettyx.test.template.tcp.client.TestSingleTcpClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static org.nettyx.test.codec.MsgCodec.TEST_MSG;

/**
 * @author fengbinbin
 * @version 1.0
 * @since 2025/5/24 15:28
 */

@Component
@RequiredArgsConstructor
public class SyncDataClient implements CommandLineRunner {

    private final TestSingleTcpClient client;

    @Override
    public void run(String... args) throws Exception {
        client.writeAndFlush(TEST_MSG);
    }

}

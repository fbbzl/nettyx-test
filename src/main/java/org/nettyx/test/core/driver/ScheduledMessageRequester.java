package org.nettyx.test.core.driver;

import org.fz.nettyx.template.tcp.client.SingleTcpChannelClientTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author fengbinbin
 * @version 1.0
 * @since 2025/7/28 16:15
 */

public abstract class ScheduledMessageRequester implements MessageRequester {

    @Resource
    protected SingleTcpChannelClientTemplate jscChannelTemplate;
    @Resource
    protected ThreadPoolTaskScheduler        taskScheduler;

    protected abstract long interval();

    protected abstract TimeUnit timeUnit();

    public void scheduleRequestToSend() {
        taskScheduler.scheduleAtFixedRate(this::requestToSend, interval());
    }

}

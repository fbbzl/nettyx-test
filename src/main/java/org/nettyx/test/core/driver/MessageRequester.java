package org.nettyx.test.core.driver;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.CommandLineRunner;

/**
 * The interface Message requester.
 *
 * @author fengbinbin
 * @version 1.0
 * @since 2025 /7/28 16:12
 */
public interface MessageRequester extends CommandLineRunner, DisposableBean {

    /**
     * Request to send.
     */
    void requestToSend();

    /**
     * Request to stop.
     */
    void requestToStop();

    @Override
    default void destroy() throws Exception {
        requestToStop();
    }

    @Override
    default void run(String... args) throws Exception {
        requestToSend();
    }

}

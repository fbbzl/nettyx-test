package org.nettyx.test.core.config;

/**
 * top level device interface
 *
 * @author fengbinbin
 * @version 1.0
 * @since 2025 /7/28 16:26
 */
public interface Device {
    /**
     * Gets device name.
     *
     * @return the device name
     */
    String getDeviceName();

    /**
     * Gets protocol.
     *
     * @return the protocol
     */
    Protocol getProtocol();
}

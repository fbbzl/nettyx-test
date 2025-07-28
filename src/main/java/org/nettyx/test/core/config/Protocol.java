package org.nettyx.test.core.config;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * Temperature message
 *
 * @author fengbinbin
 * @version 1.0
 * @since 2025 /7/28 16:26
 */
public interface Protocol {

    String getVersion();

    @Getter
    @FieldDefaults(level = AccessLevel.PRIVATE)
    @RequiredArgsConstructor
    enum ProtocolEnum implements Protocol {
        TCP,
        UDP,
        HTTP,
        HTTPS,
        FTP,
        SSH,
        SMTP,
        POP3,
        IMAP,
        MQTT3,
        MQTT5;
        String version;

    }

}



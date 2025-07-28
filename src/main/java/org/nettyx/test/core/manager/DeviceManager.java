package org.nettyx.test.core.manager;

import cn.hutool.core.lang.Console;
import org.nettyx.test.core.config.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Indexed;

import java.lang.annotation.*;
import java.util.List;

import static cn.hutool.core.collection.CollUtil.isEmpty;

/**
 * @author fengbinbin
 * @version 1.0
 * @since 2025/7/28 16:31
 */
public abstract class DeviceManager {
    protected List<? extends Device> devices;

    @Autowired
    public void register(List<? extends Device> devices) {
        if (isEmpty(devices)) return;
        this.devices = devices;
        Console.log("registered devices: [{}]", devices);
    }

    /**
     * device tag annotation
     */
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @Indexed
    @interface DevicTag {
        String tag();
    }

}

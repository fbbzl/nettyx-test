package org.nettyx.test.protostuff;

import cn.hutool.core.date.StopWatch;
import cn.hutool.core.lang.Console;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import org.junit.Test;
import org.nettyx.test.protostuff.Abses.XX;

import java.util.concurrent.TimeUnit;

public class ProtostuffTest {

    @Test
    public void test() {
        Abses<XX> user = setProperties();

        // 获取 Schema
        Schema<Abses> schema = RuntimeSchema.getSchema(Abses.class);

        // 序列化
        LinkedBuffer buffer = LinkedBuffer.allocate(512);
        byte[]       data;
        try {
            data = ProtostuffIOUtil.toByteArray(user, schema, buffer);
            System.err.println(data.length + "个字节");
        }
        finally {
            buffer.clear();
        }

        // 反序列化
        StopWatch stopWatch = StopWatch.create("反序列");
        stopWatch.start();
        for (int i = 0; i < 1_000_000; i++) {
            Abses<String> newUser = new Abses<>();
            ProtostuffIOUtil.mergeFrom(data, newUser, schema);
            // List age = newUser.getAge();
        }
        stopWatch.stop();

        Console.print(stopWatch.prettyPrint(TimeUnit.MILLISECONDS));
    }

    private static Abses<XX> setProperties() {
        XX xx = new XX();
        xx.setNa4me132("11");

        // 创建 User 对象
        Abses<XX> user = new Abses<>();
        user.setFffff(xx);
        user.setAge(xx);
        user.setAge1(0L);
        user.setName1("");
        user.setAge11((byte) 0);
        user.setName11(0L);
        user.setAge191(0);
        user.setName119(0L);
        user.setAge1291(0);
        user.setName19('1');
        user.setAge12((byte) 0);
        user.setName12(0L);
        user.setAge123(false);
        user.setName132(0);
        user.setName2132((byte) 0);
        user.setNamfe132(0);
        user.setNa4me132("");
        return user;
    }
}
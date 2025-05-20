package org.nettyx.test.codec.test;

import lombok.Data;
import org.fz.nettyx.serializer.struct.annotation.Struct;
import org.fz.nettyx.serializer.struct.annotation.ToArray;
import org.fz.nettyx.serializer.struct.basic.c.signed.cchar;
import org.fz.nettyx.serializer.struct.basic.c.signed.cfloat;
import org.fz.nettyx.serializer.struct.basic.c.stdint.unsigned.cuint32_t;
import org.fz.nettyx.serializer.struct.basic.c.stdint.unsigned.cuint64_t;
import org.fz.nettyx.serializer.struct.basic.c.stdint.unsigned.cuint8_t;

/**
 * @author fengbinbin
 * @version 1.0
 * @since 2025/5/20 19:05
 */

@Data
@Struct
public class ProductInfo {
    /**
     * 产品ID
     */
    cuint32_t productId;
    /**
     * 产品名称（假设最多15个字符+1个结束符）
     */
    @ToArray(length = 16)
    cchar[] productName;
    /**
     * 产品价格
     */
    cfloat productPrice;

    @Struct
    @Data
    public static class OrderDetail {
        /**
         * 订单ID
         */
        cuint64_t   orderId;
        /**
         * 产品信息
         */
        ProductInfo product;
        cuint8_t    orderStatus;
    }

}

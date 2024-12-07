package org.nettyx.test.codec.model;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.fz.nettyx.serializer.struct.basic.c.CBasic;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * C uchar mush use Java short
 *
 * @author fengbinbin
 * @version 1.0
 * @since 2023 /12/15 14:38
 */
public class Cuchar11 extends CBasic<Short> {

	/**
	 * The constant MIN_VALUE.
	 */
	public static final Cuchar11 MIN_VALUE = new Cuchar11(0);

	/**
	 * The constant MAX_VALUE.
	 */
	public static final Cuchar11 MAX_VALUE = new Cuchar11(Byte.MAX_VALUE * 2 + 1);
	
	/**
	 * Instantiates a new Cuchar.
	 *
	 * @param value the length
	 */
	public Cuchar11(Integer value) {
		super(value.shortValue(), 1);
	}

	/**
	 * Instantiates a new Cuchar.
	 *
	 * @param buf the buf
	 */
	public Cuchar11(ByteBuf buf) {
		super(buf, 1);
	}

	@Override
	public boolean hasSinged() {
		return false;
	}

	@Override
	protected ByteBuf toByteBuf(Short value, int size) {
		return Unpooled.buffer(size).writeByte(value.byteValue());
	}

	@Override
	protected Short toValue(ByteBuf byteBuf) {
		return byteBuf.readUnsignedByte();
	}

	@Override
	public String toString() {
		return new String(this.getBytes(), StandardCharsets.US_ASCII);
	}

	public String toString(Charset charset) {
		return new String(this.getBytes(), charset);
	}

}

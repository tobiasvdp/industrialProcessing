package mod.industrialProcessing.utils;

import java.nio.ByteBuffer;
import java.util.UUID;

public class UUIDUtil {
	public static UUID getUUID(byte[] bytes) {
		if (bytes == null || bytes.length != 16)
			return new UUID(0, 0);
		ByteBuffer bb = ByteBuffer.wrap(bytes);
		long firstLong = bb.getLong();
		long secondLong = bb.getLong();
		return new UUID(firstLong, secondLong);
	}

	public static byte[] getBytes(UUID id) {
		byte[] bytes = new byte[16];
		ByteBuffer bb = ByteBuffer.wrap(bytes);
		bb.putLong(id.getMostSignificantBits());
		bb.putLong(id.getLeastSignificantBits());
		return bytes;
	}
}

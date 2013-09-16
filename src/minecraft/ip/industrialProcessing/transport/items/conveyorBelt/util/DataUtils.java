package ip.industrialProcessing.transport.items.conveyorBelt.util;

import ip.industrialProcessing.DirectionUtils;
import ip.industrialProcessing.LocalDirection;
import net.minecraftforge.common.ForgeDirection;

public class DataUtils {

	public static <T> T getItem(ForgeDirection world, T[] data, T defaultValue, ForgeDirection forward) {
		LocalDirection local = DirectionUtils.getLocalDirection(world, forward);
		return getItem(local, data, defaultValue);
	}

	public static <T> T getItem(LocalDirection local, T[] data, T defaultValue) {
		int index = local.ordinal();
		if (index > 3)
			return defaultValue;
		return data[index];
	}

	public static <T> void setItem(ForgeDirection world, T[] data, T value, ForgeDirection forward) {
		LocalDirection local = DirectionUtils.getLocalDirection(world, forward);
		setItem(local, data, value);
	}

	public static <T> void setItem(LocalDirection local, T[] data, T value) {
		int index = local.ordinal();
		if (index > 3)
			return;
		data[index] = value;
	}

}

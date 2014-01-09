package ip.industrialProcessing.transport.items.conveyorBelt.util;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.utils.DirectionUtils;
import net.minecraftforge.common.ForgeDirection;

public class DataUtils {

	public static <T> T getItem(ForgeDirection world, T[] data, T defaultValue, ForgeDirection forward, int maxIndex) {
		LocalDirection local = DirectionUtils.getLocalDirection(world, forward);
		return getItem(local, data, defaultValue, maxIndex);
	}

	public static <T> T getItem(LocalDirection local, T[] data, T defaultValue, int maxIndex) {
		int index = local.ordinal();
		if (index > maxIndex || index < 0 || index >= data.length)
			return defaultValue;
		return data[index];
	} 


	public static <T> void setItem(ForgeDirection world, T[] data, T value, ForgeDirection forward, int maxIndex) {
		LocalDirection local = DirectionUtils.getLocalDirection(world, forward);
		setItem(local, data, value, maxIndex);
	}

	public static <T> void setItem(LocalDirection local, T[] data, T value, int maxIndex) {
		int index = local.ordinal();
		if (index > maxIndex)
			return;
		data[index] = value;
	}

}

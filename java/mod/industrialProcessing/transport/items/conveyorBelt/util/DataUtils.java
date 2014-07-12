package mod.industrialProcessing.transport.items.conveyorBelt.util;

import mod.industrialProcessing.utils.rotation.DirectionUtils;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import net.minecraftforge.common.util.ForgeDirection;

public class DataUtils {

	public static <T> T getItem(ForgeDirection world, T[] data, T defaultValue, ForgeDirection forward, int maxIndex) {
		LocalDirection local =  DirectionUtils.getLocalDirection(world, forward);
		return getItem(local, data, defaultValue, maxIndex);
	}
	
	public static <T> T getItem(ForgeDirection world, T[] data, T defaultValue, ForgeDirection forward, int maxIndex,int offset) {
		LocalDirection local =  DirectionUtils.getLocalDirection(world, forward);
		return getItem(local, data, defaultValue, maxIndex,offset);
	}

	public static <T> T getItem(LocalDirection local, T[] data, T defaultValue, int maxIndex) {
		int index = local.ordinal();
		if (index > maxIndex || index < 0 || index >= data.length)
			return defaultValue;
		return data[index];
	} 
	
	public static <T> T getItem(LocalDirection local, T[] data, T defaultValue, int maxIndex,int offset) {
		int index = local.ordinal() - offset;
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

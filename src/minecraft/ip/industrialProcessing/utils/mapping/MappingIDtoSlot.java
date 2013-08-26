package ip.industrialProcessing.utils.mapping;

import net.minecraftforge.common.ForgeDirection;

public class MappingIDtoSlot {
	int[][] mapping;
	public MappingIDtoSlot(int size) {
		mapping = new int[size][6];
	}
	public int getSlot(int id, ForgeDirection side){
		return mapping[id][side.ordinal()];
	}

}

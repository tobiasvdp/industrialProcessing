package ip.industrialProcessing.multiblock.utils;

import java.util.ArrayList;

public class MultiblockItemStackID {
	private int validID;
	private ArrayList<blockSide> validSides = new ArrayList<blockSide>();

	public MultiblockItemStackID(int ID, blockSide... sides) {
		this.validID = ID;
		for (blockSide side : sides)
			this.validSides.add(side);
	}

	public boolean isValid(int ID, int s) {
		if (ID != validID)
			return false;
		for (blockSide side : validSides) {
			if (side.ordinal() == s)
				return true;
		}
		return false;
	}

}

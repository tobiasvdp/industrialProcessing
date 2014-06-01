package mod.industrialProcessing.blockContainer.multiblock.tier;

import net.minecraft.block.Block;

public class TierRequirement {
	private int ID;
	private Block[] blockId;
	
	public TierRequirement(int ID) {
		this.ID = ID;
	}
	public TierRequirement(int ID, Block... blockid) {
		this.ID = ID;
		blockId = blockid;
	}
	public Block[] getBlockIDs() {
		return blockId;
	}
	public int getID(){
		return ID;
	}

}

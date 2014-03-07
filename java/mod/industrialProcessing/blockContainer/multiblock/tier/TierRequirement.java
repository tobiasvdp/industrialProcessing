package mod.industrialProcessing.blockContainer.multiblock.tier;

public class TierRequirement {
	private int ID;
	private int[] blockId;
	
	public TierRequirement(int ID) {
		this.ID = ID;
	}
	public TierRequirement(int ID, int... blockid) {
		this.ID = ID;
		blockId = blockid;
	}
	public int[] getBlockIDs() {
		return blockId;
	}
	public int getID(){
		return ID;
	}

}

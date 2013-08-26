package ip.industrialProcessing.multiblock.layout;

public class LayoutBlockDescription {
	private int[] blockIDs;
	private int renderID;

	public LayoutBlockDescription(int renderID, int... blockIDs) {
		this.renderID = renderID;
		this.blockIDs = blockIDs;
	}

	public int getRenderID() {
		return renderID;
	}
	
	public int[] getBlockID(){
		return blockIDs;
	}

	public boolean isValidID(int blockID) {
		for (int i = 0; i < this.blockIDs.length; i++) {
			if (this.blockIDs[i] == blockID)
				return true;
		}
		return false;
	}

}

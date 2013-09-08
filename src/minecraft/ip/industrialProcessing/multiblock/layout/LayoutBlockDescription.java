package ip.industrialProcessing.multiblock.layout;

public class LayoutBlockDescription {
	private int[] blockIDs;
	private int modelID;
	private int modelConnection;
	private int ID;

	public LayoutBlockDescription(int ID, int renderID,int modelConnection, int... blockIDs) {
		this.modelID = renderID;
		this.modelConnection = modelConnection;
		this.blockIDs = blockIDs;
		this.ID = ID;
	}

	public int getModelConnection() {
		return modelConnection;
	}
	public int getModelID() {
		return modelID;
	}
	public int getID(){
		return ID;
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
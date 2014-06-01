package mod.industrialProcessing.blockContainer.multiblock.layout;

import mod.industrialProcessing.IndustrialProcessing;
import net.minecraft.block.Block;

public class LayoutBlockDescription {
	private Block[] blockIDs;
	private int modelID;
	private int modelConnection;
	private int groupID;
	private int ID;

	public LayoutBlockDescription(int ID, int renderID, int modelConnection, int groupID, Block... blockIDs) {
		this.modelID = renderID;
		this.modelConnection = modelConnection;
		this.groupID = groupID;
		this.blockIDs = blockIDs;
		this.ID = ID;
	}

	public int getGroupID() {
		return groupID;
	}

	public int getModelConnection() {
		return modelConnection;
	}

	public int getModelID() {
		return modelID;
	}

	public int getID() {
		return ID;
	}

	public Block[] getBlockID() {
		return blockIDs;
	}

	public boolean isValidID(Block blockID) {
		for (int i = 0; i < this.blockIDs.length; i++) {
			if (this.blockIDs[i].equals(blockID))
				return true;
			if (this.blockIDs[i].equals(IndustrialProcessing.blocktransparent))
				return true;
		}
		return false;
	}

}

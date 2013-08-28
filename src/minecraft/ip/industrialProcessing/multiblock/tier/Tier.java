package ip.industrialProcessing.multiblock.tier;

import ip.industrialProcessing.multiblock.core.TEmultiblockCore;
import ip.industrialProcessing.multiblock.dummy.TEmultiblockDummy;

import java.util.ArrayList;

public class Tier {

	private ArrayList<TierRequirement> blockpresent = new ArrayList<TierRequirement>();
	private ArrayList<TierRequirement> blockidpresent = new ArrayList<TierRequirement>();

	public Tier() {

	}

	public void setBlockPresent(int ID) {
		blockpresent.add(new TierRequirement(ID));
	}

	public void setBlockIDPresent(int ID, int... blockid) {
		blockidpresent.add(new TierRequirement(ID, blockid));
	}

	public boolean isTierRequirementMet(TEmultiblockCore te) {
		if (!areBlocksPresent(te)) {
			return false;
		}
		if (!areBlockIdsPresent(te)) {
			return false;
		}
		return true;
	}

	private boolean areBlockIdsPresent(TEmultiblockCore te) {
		for (TierRequirement req : blockidpresent) {
			boolean isValid = false;
			TEmultiblockDummy dummy = te.getDummyByID(req.getID());
			int blockID = dummy.worldObj.getBlockMetadata(dummy.xCoord, dummy.yCoord, dummy.zCoord);
			for (int id : req.getBlockIDs()) {
				if (id == blockID)
					isValid = true;
			}
			if (!isValid)
				return false;
		}
		return true;
	}

	// Only use dummy blocks here
	private boolean areBlocksPresent(TEmultiblockCore te) {
		for (TierRequirement req : blockpresent) {
			TEmultiblockDummy dummy = te.getDummyByID(req.getID());
			if (dummy == null)
				return false;
		}
		return true;
	}


}

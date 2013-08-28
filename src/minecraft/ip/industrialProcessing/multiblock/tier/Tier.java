package ip.industrialProcessing.multiblock.tier;

import ip.industrialProcessing.multiblock.core.TEmultiblockCore;
import ip.industrialProcessing.multiblock.dummy.TEmultiblockDummy;
import ip.industrialProcessing.multiblock.utils.MultiblockActionType;

import java.util.ArrayList;

public class Tier {

	private ArrayList<TierRequirement> blockpresent = new ArrayList<TierRequirement>();
	private ArrayList<TierRequirement> blockidpresent = new ArrayList<TierRequirement>();
	private ArrayList<int[]> modelID = new ArrayList<int[]>();
	private ArrayList<int[]> modelConnection = new ArrayList<int[]>();

	public Tier() {

	}

	public void setBlockPresent(int ID) {
		blockpresent.add(new TierRequirement(ID));
	}

	public void setBlockIDPresent(int ID, int... blockid) {
		blockidpresent.add(new TierRequirement(ID, blockid));
	}

	public void setAction(MultiblockActionType type, int ID, int newValue) {
		switch (type) {
		case modelID: {
			modelID.add(new int[] { ID, newValue });
			break;
		}
		case modelConnection: {
			modelConnection.add(new int[] { ID, newValue });
			break;
		}
		}
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

	public void configMultiblock(TEmultiblockCore tEmultiblockCore, ArrayList<TEmultiblockDummy> dummy) {
		configMultiblockModelIDs(tEmultiblockCore,dummy);
		configMultiblockModelConnections(tEmultiblockCore,dummy);
		
	}

	private void configMultiblockModelConnections(TEmultiblockCore tEmultiblockCore, ArrayList<TEmultiblockDummy> dummy) {
		for(int[] id:modelConnection){
			int registeredID = id[0];
			int newValue = id[1];
			setNewModelConnectionToDummy(dummy,registeredID,newValue);
		}
	}

	private boolean setNewModelConnectionToDummy(ArrayList<TEmultiblockDummy> dummy, int registeredID, int newValue) {
		for(TEmultiblockDummy te:dummy){
			if (te.getID() == registeredID){
				te.setModelConnection(newValue);
				return true;
			}
		}
		return false;
	}

	private void configMultiblockModelIDs(TEmultiblockCore tEmultiblockCore, ArrayList<TEmultiblockDummy> dummy) {
		for(int[] id:modelID){
			int registeredID = id[0];
			int newValue = id[1];
			setNewModelIDToDummy(dummy,registeredID,newValue);
		}
	}
	private boolean setNewModelIDToDummy(ArrayList<TEmultiblockDummy> dummy,int registeredID, int newValue){
		for(TEmultiblockDummy te:dummy){
			if (te.getID() == registeredID){
				te.setModelID(newValue);
				return true;
			}
		}
		return false;
	}

}

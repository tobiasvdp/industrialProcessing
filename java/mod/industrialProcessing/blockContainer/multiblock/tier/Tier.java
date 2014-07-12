package mod.industrialProcessing.blockContainer.multiblock.tier;

import java.util.ArrayList;

import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.blockContainer.multiblock.core.TileEntityMultiblockCore;
import mod.industrialProcessing.blockContainer.multiblock.dummy.TileEntityMultiblockDummy;
import mod.industrialProcessing.blockContainer.multiblock.utils.MultiblockActionType;
import net.minecraft.block.Block;

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

	public void setBlockIDPresent(int ID, Block... blockid) {
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

	public boolean isTierRequirementMet(TileEntityMultiblockCore te) {
		if (!areBlocksPresent(te)) {
			return false;
		}
		if (!areBlockIdsPresent(te)) {
			return false;
		}
		return true;
	}

	private boolean areBlockIdsPresent(TileEntityMultiblockCore te) {
		for (TierRequirement req : blockidpresent) {
			boolean isValid = false;
			TileEntityMultiblockDummy dummy = te.getDummyByID(req.getID());
			Block blockID = null;
			if(dummy != null){
				blockID = dummy.getBlockType();
			}
			for (Block id : req.getBlockIDs()) {
				if (id.equals(blockID))
					isValid = true;
				if(id.equals(IndustrialProcessing.blocktransparent))
					isValid = true;
			}
			
			if (!isValid)
				return false;
		}
		return true;
	}

	// Only use dummy blocks here
	private boolean areBlocksPresent(TileEntityMultiblockCore te) {
		for (TierRequirement req : blockpresent) {
			TileEntityMultiblockDummy dummy = te.getDummyByID(req.getID());
			if (dummy == null)
				return false;
		}
		return true;
	}

	public void configMultiblock(TileEntityMultiblockCore tileEntityMultiblockCore, ArrayList<TileEntityMultiblockDummy> dummy) {
		configMultiblockModelIDs(tileEntityMultiblockCore,dummy);
		configMultiblockModelConnections(tileEntityMultiblockCore,dummy);
		
	}

	private void configMultiblockModelConnections(TileEntityMultiblockCore tileEntityMultiblockCore, ArrayList<TileEntityMultiblockDummy> dummy) {
		for(int[] id:modelConnection){
			int registeredID = id[0];
			int newValue = id[1];
			setNewModelConnectionToDummy(dummy,registeredID,newValue);
		}
	}

	private boolean setNewModelConnectionToDummy(ArrayList<TileEntityMultiblockDummy> dummy, int registeredID, int newValue) {
		for(TileEntityMultiblockDummy te:dummy){
			if (te.getID() == registeredID){
				te.setModelConnection(newValue);
				return true;
			}
		}
		return false;
	}

	private void configMultiblockModelIDs(TileEntityMultiblockCore tileEntityMultiblockCore, ArrayList<TileEntityMultiblockDummy> dummy) {
		for(int[] id:modelID){
			int registeredID = id[0];
			int newValue = id[1];
			setNewModelIDToDummy(dummy,registeredID,newValue);
		}
	}
	private boolean setNewModelIDToDummy(ArrayList<TileEntityMultiblockDummy> dummy,int registeredID, int newValue){
		for(TileEntityMultiblockDummy te:dummy){
			if (te.getID() == registeredID){
				te.setModelID(newValue);
				return true;
			}
		}
		return false;
	}

}

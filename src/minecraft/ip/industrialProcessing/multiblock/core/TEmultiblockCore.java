package ip.industrialProcessing.multiblock.core;

import java.util.ArrayList;

import ip.industrialProcessing.multiblock.dummy.TEmultiblockDummy;
import ip.industrialProcessing.multiblock.layout.FacingDirection;
import ip.industrialProcessing.multiblock.layout.StructureMultiblock;
import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.multiblock.tier.TierCollection;
import ip.industrialProcessing.multiblock.utils.MultiblockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Facing;
import net.minecraftforge.common.ForgeDirection;

public class TEmultiblockCore extends TileEntity {

	private StructureMultiblock structure;
	private ArrayList<TEmultiblockDummy> dummy = new ArrayList<TEmultiblockDummy>();
	private FacingDirection side = FacingDirection.North;
	private MultiblockState state = MultiblockState.CONNECTED;
	private Tiers tier = Tiers.Invalid;
	private TierCollection tierRequirments;
	private int modelID;
	private int modelConnection;

	public TEmultiblockCore(StructureMultiblock structure, TierCollection tierRequirments) {
		this.structure = structure;
		this.tierRequirments = tierRequirments;
	}

	public void registerDummy(TEmultiblockDummy te) {
		dummy.add(te);
	}

	public void unregisterDummy(TEmultiblockDummy temultiblockDummy) {
		dummy.remove(temultiblockDummy);
	}

	public boolean isDummyValidForStructure(TEmultiblockDummy te) {
		/*
		 * check if the new placed block is valid, if not try other directions.
		 * If direction is changed, take necessary actions
		 */
		FacingDirection dir = structure.isBlockValid(te.xCoord - xCoord, te.yCoord - yCoord, te.zCoord - zCoord, te.worldObj.getBlockId(te.xCoord, te.yCoord, te.zCoord), side, false);
		if (dir == FacingDirection.Invalid) {
			return false;
		} else {
			if (dir != side) {
				side = dir;
				onSideChange();
			}
			return true;
		}
	}

	public void checkIfRegisteredDummiesAreValid() {
		// first determinate what to delete. If you delete while running trough
		// your loop, you will mess sh* up.
		ArrayList<TEmultiblockDummy> dummiesToBeEreased = new ArrayList<TEmultiblockDummy>();
		for (TEmultiblockDummy te : dummy) {
			FacingDirection dir = structure.isBlockValid(te.xCoord - xCoord, te.yCoord - yCoord, te.zCoord - zCoord, te.worldObj.getBlockId(te.xCoord, te.yCoord, te.zCoord), side, true);
			if (dir == FacingDirection.Invalid)
				dummiesToBeEreased.add(te);
		}
		for (TEmultiblockDummy te : dummiesToBeEreased) {
			te.delCore();
		}
	}

	public void destroyMultiblock() {
		for (TEmultiblockDummy te : dummy) {
			worldObj.destroyBlock(te.xCoord, te.yCoord, te.zCoord, true);
		}
	}

	public void onStateChange() {
		for (TEmultiblockDummy te : dummy) {
			te.setState(state);
		}
	}

	public void onLayoutChange() {
		// determinate if the state has changed. if so do necessary actions
		MultiblockState state = structure.isLayoutValid(worldObj, xCoord, yCoord, zCoord, this.side);
		if (state != this.state) {
			this.state = state;
			onStateChange();
		}
		// if state is complete determinate the tier level, else reset the tier.
		if (state == MultiblockState.COMPLETED) {
			Tiers tier = determinateTier();
			if (this.tier != tier) {
				this.tier = tier;
				onTierChange();
			} else {
				this.tier = tier;
			}
		} else {
			this.tier = Tiers.Invalid;
		}
	}

	public void onTierChange() {

	}

	public void onSideChange() {
		checkIfRegisteredDummiesAreValid();
		setMultiblockRotation();
		setDummiesModelConnections();
		setDummiesModelIDs();
	}

	private void setMultiblockRotation() {
		if (side != FacingDirection.Invalid) {
			int metadata = 0;
			switch (side) {
			case North: {
				metadata = 2;
				break;
			}
			case East: {
				metadata = 3;
				break;
			}
			case South: {
				metadata = 0;
				break;
			}
			case West: {
				metadata = 1;
				break;
			}
			}
			worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, metadata, 1);
			for (TEmultiblockDummy te : dummy) {
				worldObj.setBlockMetadataWithNotify(te.xCoord, te.yCoord, te.zCoord, metadata, 1);
			}
		}
	}

	public MultiblockState getState() {
		return state;
	}

	public void notifyNeighboursOfCorePlaced() {
		for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
			TileEntity neighbour = worldObj.getBlockTileEntity(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ);
			if (neighbour instanceof TEmultiblockDummy) {
				TEmultiblockDummy te = (TEmultiblockDummy) neighbour;
				if (te.getCore() == null)
					te.searchForCore();
			}
		}
	}

	public int getModelID() {
		return modelID;
	}

	public int getModelConnection() {
		return modelConnection;
	}

	public void setModelID() {
		modelID = structure.getModelIDforBlock(0, 0, 0, side);
	}

	public void setModelConnection() {
		modelConnection = structure.getModelConnectionforBlock(0, 0, 0, side);
	}

	public int setDummieModelID(TEmultiblockDummy te) {
		return structure.getModelIDforBlock(te.xCoord - xCoord, te.yCoord - yCoord, te.zCoord - zCoord, side);
	}

	public int setDummieModelConnection(TEmultiblockDummy te) {
		return structure.getModelConnectionforBlock(te.xCoord - xCoord, te.yCoord - yCoord, te.zCoord - zCoord, side);
	}

	public void setDummiesModelIDs() {

	}

	public void setDummiesModelConnections() {

	}

	public void setsideFromMetadata(int dir) {
		switch (dir) {
		case 1: {
			side = FacingDirection.West;
			break;
		}
		case 2: {
			side = FacingDirection.North;
			break;
		}
		case 3: {
			side = FacingDirection.East;
			break;
		}
		case 0: {
			side = FacingDirection.South;
			break;
		}
		default: {
			side = FacingDirection.North;
		}
		}
	}

	public Tiers determinateTier() {
		Tiers tier = Tiers.Tier0;
		for (Tiers tr:Tiers.values()) {
			if (tr.ordinal() > 0 && tr.ordinal() < tierRequirments.getAmountTiers() && tierRequirments.getTier(tr).isTierRequirementMet(this)) {
				tier = tr;
			}
		}
		System.out.println("Tier = " + tier);
		return tier;
	}

	public int setDummieID(TEmultiblockDummy te) {
		return structure.getIDforBlock(te.xCoord - xCoord, te.yCoord - yCoord, te.zCoord - zCoord, side);
	}

	public TEmultiblockDummy getDummyByID(int ID) {
		for (TEmultiblockDummy te : dummy) {
			if (te.getID() == ID) {
				return te;
			}
		}
		return null;
	}

	public boolean isDummyValidForStructure(TEmultiblockDummy te, boolean b) {
		/*
		 * check if the new placed block is valid. This does not change directions.
		 */
		FacingDirection dir = structure.isBlockValid(te.xCoord - xCoord, te.yCoord - yCoord, te.zCoord - zCoord, te.worldObj.getBlockId(te.xCoord, te.yCoord, te.zCoord), side, true);
		if (dir == side) 
			return true;
		return false;
	}

}

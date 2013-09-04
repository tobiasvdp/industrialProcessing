package ip.industrialProcessing.multiblock.core.block.elevator;

import java.util.ArrayList;

import net.minecraft.entity.Entity;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.machines.crusher.RecipesCrusher;
import ip.industrialProcessing.multiblock.core.TEmultiblockCore;
import ip.industrialProcessing.multiblock.dummy.block.frame.ENmultiblockFrame;
import ip.industrialProcessing.multiblock.layout.FacingDirection;
import ip.industrialProcessing.multiblock.layout.LayoutMultiblock;
import ip.industrialProcessing.multiblock.layout.LayoutTransformer;
import ip.industrialProcessing.multiblock.layout.StructureMultiblock;
import ip.industrialProcessing.multiblock.tier.Tier;
import ip.industrialProcessing.multiblock.tier.TierCollection;
import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.multiblock.utils.MultiblockActionType;

public class TEmultiblockElevator extends TEmultiblockCore {
	static StructureMultiblock structure;
	static TierCollection tierRequirments;
	static {
		// set layout
		structure = new StructureMultiblock();

		LayoutMultiblock layout = new LayoutMultiblock(0, 3, 0, 3, 8, 0);

		int i = 2;
		for (int j = 0; j < 8; j++) {
			for (int k = 0; k < 4; k++) {
				layout.setBlockID(0, j, -k, i++, 1, 0, IndustrialProcessing.BLmultiblockFrame.blockID);
				layout.setBlockID(3, j, -k, i++, 1, 0, IndustrialProcessing.BLmultiblockFrame.blockID);
			}
			layout.setBlockID(1, j, 0, i++, 1, 0, IndustrialProcessing.BLmultiblockFrame.blockID);
			layout.setBlockID(1, j, -3, i++, 1, 0, IndustrialProcessing.BLmultiblockFrame.blockID);
			layout.setBlockID(2, j, 0, i++, 1, 0, IndustrialProcessing.BLmultiblockFrame.blockID);
			layout.setBlockID(2, j, -3, i++, 1, 0, IndustrialProcessing.BLmultiblockFrame.blockID);
		}

		layout.setBlockID(1, 0, -1, i++, 1, 0, IndustrialProcessing.BLmultiblockFrame.blockID);
		layout.setBlockID(1, 0, -2, i++, 1, 0, IndustrialProcessing.BLmultiblockFrame.blockID);
		layout.setBlockID(2, 0, -1, i++, 1, 0, IndustrialProcessing.BLmultiblockFrame.blockID);
		layout.setBlockID(2, 0, -2, i++, 1, 0, IndustrialProcessing.BLmultiblockFrame.blockID);

		layout.unsetBlockID(1, 1, 0);
		layout.unsetBlockID(2, 1, 0);
		layout.unsetBlockID(1, 2, 0);
		layout.unsetBlockID(2, 2, 0);
		layout.unsetBlockID(1, 5, 0);
		layout.unsetBlockID(2, 5, 0);
		layout.unsetBlockID(1, 6, 0);
		layout.unsetBlockID(2, 6, 0);

		layout.setCoreID(0, 0, 0, IndustrialProcessing.BLmultiblockElevator.blockID);
		layout.setBlockID(0, 2, -1, 1, 0, 0, IndustrialProcessing.BLmultiblockToggleButton.blockID);

		structure.addLayout(layout, FacingDirection.North);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.East), FacingDirection.East);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.South), FacingDirection.South);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.West), FacingDirection.West);

		// set tiers
		tierRequirments = new TierCollection(1);

		Tier tier = new Tier();
		tierRequirments.addTier(tier, Tiers.Tier0);
	}
	private boolean toggled = false;
	private boolean toggleLock = false;
	private ArrayList<Entity> players = new ArrayList<Entity>();

	public TEmultiblockElevator() {
		super(structure, tierRequirments);
	}

	public void toggle(int ID) {
		if (!toggleLock) {
			if (toggled)
				toggled = false;
			else
				toggled = true;
		}
		searchForPlayers();
		if (worldObj.isRemote)
			worldObj.spawnEntityInWorld(new ENmultiblockFrame(worldObj, xCoord - 1, yCoord, zCoord + 1));
	}

	@Override
	public void updateEntity() {
		if (toggled) {
			for (Entity player : players) {
				player.isAirBorne = true;
				player.addVelocity(0, 0.2, 0);
			}
		}
	}

	public void searchForPlayers() {
		players.clear();
		for (Object obj : worldObj.playerEntities) {
			Entity player = (Entity) obj;
			if (player.posX > this.xCoord + structure.getSizeLeft(this.side) && player.posX < this.xCoord + structure.getSizeRight(this.side)) {
				if (player.posY > this.yCoord + structure.getSizeDown(this.side) && player.posY < this.yCoord + structure.getSizeUp(this.side)) {
					if (player.posZ > this.zCoord - structure.getSizeBack(this.side) && player.posZ < this.zCoord - structure.getSizeFront(this.side)) {
						System.out.println("player " + player.getEntityName() + " in Elevator");
						players.add(player);
					}
				}
			}
		}
	}

}

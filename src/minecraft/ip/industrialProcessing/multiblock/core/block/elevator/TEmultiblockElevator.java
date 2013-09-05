package ip.industrialProcessing.multiblock.core.block.elevator;

import java.util.ArrayList;

import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.DimensionManager;
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

		LayoutMultiblock layout = new LayoutMultiblock(0, 3, 0, 3, 4, 0);

		int i = 2;
		for (int j = 0; j < 4; j++) {
			for (int k = 0; k < 4; k++) {
				layout.setBlockID(0, j, -k, i++, 1, 0, IndustrialProcessing.BLmultiblockFrame.blockID);
				layout.setBlockID(3, j, -k, i++, 1, 0, IndustrialProcessing.BLmultiblockFrame.blockID);
			}
			layout.setBlockID(1, j, 0, i++, 1, 0, IndustrialProcessing.BLmultiblockFrame.blockID);
			layout.setBlockID(1, j, -3, i++, 1, 0, IndustrialProcessing.BLmultiblockFrame.blockID);
			layout.setBlockID(2, j, 0, i++, 1, 0, IndustrialProcessing.BLmultiblockFrame.blockID);
			layout.setBlockID(2, j, -3, i++, 1, 0, IndustrialProcessing.BLmultiblockFrame.blockID);
		}

		layout.unsetBlockID(1, 1, 0);
		layout.unsetBlockID(2, 1, 0);
		layout.unsetBlockID(1, 2, 0);
		layout.unsetBlockID(2, 2, 0);

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
	private ArrayList<Integer> levels = new ArrayList<Integer>();

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
		findLevels();
		setElevatorToLevel(1);
	}

	private void setElevatorToLevel(int level) {
		createPlatform(level);
	}

	public void createPlatform(int level) {
		if (worldObj.isRemote) {
			switch (this.side) {
			case North:
				worldObj.spawnEntityInWorld(new ENmultiblockFrame(worldObj, xCoord + 1.5, yCoord, zCoord - 0.5, levels.get(level)));
				worldObj.spawnEntityInWorld(new ENmultiblockFrame(worldObj, xCoord + 2.5, yCoord, zCoord - 0.5, levels.get(level)));
				worldObj.spawnEntityInWorld(new ENmultiblockFrame(worldObj, xCoord + 1.5, yCoord, zCoord - 1.5, levels.get(level)));
				worldObj.spawnEntityInWorld(new ENmultiblockFrame(worldObj, xCoord + 2.5, yCoord, zCoord - 1.5, levels.get(level)));
				break;
			case South:
				worldObj.spawnEntityInWorld(new ENmultiblockFrame(worldObj, xCoord - 1.5, yCoord, zCoord + 0.5, levels.get(level)));
				worldObj.spawnEntityInWorld(new ENmultiblockFrame(worldObj, xCoord - 2.5, yCoord, zCoord + 0.5, levels.get(level)));
				worldObj.spawnEntityInWorld(new ENmultiblockFrame(worldObj, xCoord - 1.5, yCoord, zCoord + 1.5, levels.get(level)));
				worldObj.spawnEntityInWorld(new ENmultiblockFrame(worldObj, xCoord - 2.5, yCoord, zCoord + 1.5, levels.get(level)));
				break;
			case East:
				worldObj.spawnEntityInWorld(new ENmultiblockFrame(worldObj, xCoord - 0.5, yCoord, zCoord + 1.5, levels.get(level)));
				worldObj.spawnEntityInWorld(new ENmultiblockFrame(worldObj, xCoord - 0.5, yCoord, zCoord + 2.5, levels.get(level)));
				worldObj.spawnEntityInWorld(new ENmultiblockFrame(worldObj, xCoord - 1.5, yCoord, zCoord + 1.5, levels.get(level)));
				worldObj.spawnEntityInWorld(new ENmultiblockFrame(worldObj, xCoord - 1.5, yCoord, zCoord + 2.5, levels.get(level)));
				break;
			case West:
				worldObj.spawnEntityInWorld(new ENmultiblockFrame(worldObj, xCoord - 0.5, yCoord, zCoord - 0.5, levels.get(level)));
				worldObj.spawnEntityInWorld(new ENmultiblockFrame(worldObj, xCoord - 0.5, yCoord, zCoord - 1.5, levels.get(level)));
				worldObj.spawnEntityInWorld(new ENmultiblockFrame(worldObj, xCoord - 1.5, yCoord, zCoord - 0.5, levels.get(level)));
				worldObj.spawnEntityInWorld(new ENmultiblockFrame(worldObj, xCoord - 1.5, yCoord, zCoord - 1.5, levels.get(level)));
				break;
			default:
				break;
			}
		}
	}

	public void findLevels() {
		levels.clear();
		for (int i = 0; i < 256; i++) {
			TileEntity te = worldObj.getBlockTileEntity(this.xCoord, i, this.zCoord);
			if (te != null && te instanceof TEmultiblockElevator) {
				levels.add(te.yCoord);
				System.out.println(te.yCoord);
			}
		}
	}
	public ArrayList<Integer> getLevels(){
		return levels;
	}

}

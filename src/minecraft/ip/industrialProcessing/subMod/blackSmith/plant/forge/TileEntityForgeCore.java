package ip.industrialProcessing.subMod.blackSmith.plant.forge;

import java.util.Random;

import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.client.render.IAnimationProgress;
import ip.industrialProcessing.machines.animation.IAnimationSyncable;
import ip.industrialProcessing.machines.animation.tanks.TankHandler;
import ip.industrialProcessing.multiblock.coreAndDummy.TileEntityMultiblockSwitcherCore;
import ip.industrialProcessing.multiblock.layout.FacingDirection;
import ip.industrialProcessing.multiblock.layout.LayoutMultiblock;
import ip.industrialProcessing.multiblock.layout.LayoutTransformer;
import ip.industrialProcessing.multiblock.layout.StructureMultiblock;
import ip.industrialProcessing.multiblock.recipes.RecipesMultiblock;
import ip.industrialProcessing.multiblock.tier.Tier;
import ip.industrialProcessing.multiblock.tier.TierCollection;
import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.subMod.blackSmith.config.ISetupBlackSmith;
import ip.industrialProcessing.subMod.blackSmith.plant.waterBasin.RecipesWaterBasin;
import ip.industrialProcessing.utils.DropBlock;
import ip.industrialProcessing.utils.IProgressSync;
import ip.industrialProcessing.utils.packets.PacketIP006SyncValues;

public class TileEntityForgeCore extends TileEntityMultiblockSwitcherCore implements IProgressSync {
	static StructureMultiblock structure;
	static TierCollection tierRequirments;
	private TankHandler tankHandler;
	public int burnTime = 0;
	public int PrevburnTime = 0;
	public static RecipesMultiblock recipes = new RecipesForge();
	static {
		// set layout
		structure = new StructureMultiblock();

		LayoutMultiblock layout = new LayoutMultiblock(1, 1, 0, 1, 2, 0);

		int i = 0;
		layout.setCoreID(i++, 0, 0, ISetupBlackSmith.blockForge.blockID);

		layout.setBlockID(-1, 0, 0, i++, 0, 0, ISetupBlackSmith.blockForge.blockID);
		layout.setBlockID(1, 0, 0, i++, 0, 0, ISetupBlackSmith.blockForge.blockID);
		layout.setBlockID(-1, 1, 0, i++, 0, 1, ISetupBlackSmith.blockForge.blockID);
		layout.setBlockID(1, 1, 0, i++, 0, 2, ISetupBlackSmith.blockForge.blockID);
		layout.setBlockID(0, 2, 0, i++, 0, 3, ISetupBlackSmith.blockForge.blockID);
		layout.setBlockID(-1, 2, 0, i++, 0, 4, ISetupBlackSmith.blockForge.blockID);
		layout.setBlockID(1, 2, 0, i++, 0, 5, ISetupBlackSmith.blockForge.blockID);

		layout.setBlockID(0, 0, -1, i++, 0, 0, ISetupBlackSmith.blockForge.blockID);
		layout.setBlockID(-1, 0, -1, i++, 0, 0, ISetupBlackSmith.blockForge.blockID);
		layout.setBlockID(1, 0, -1, i++, 0, 0, ISetupBlackSmith.blockForge.blockID);

		layout.setBlockID(0, 1, -1, i++, 0, 6, ISetupBlackSmith.blockForge.blockID);
		layout.setBlockID(-1, 1, -1, i++, 0, 7, ISetupBlackSmith.blockForge.blockID);
		layout.setBlockID(1, 1, -1, i++, 0, 8, ISetupBlackSmith.blockForge.blockID);

		layout.setBlockID(0, 2, -1, i++, 0, 0, ISetupBlackSmith.blockForge.blockID);
		layout.setBlockID(-1, 2, -1, i++, 0, 9, ISetupBlackSmith.blockForge.blockID);
		layout.setBlockID(1, 2, -1, i++, 0, 10, ISetupBlackSmith.blockForge.blockID);

		structure.addLayout(layout, FacingDirection.North);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.East), FacingDirection.East);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.South), FacingDirection.South);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.West), FacingDirection.West);

		// set tiers
		tierRequirments = new TierCollection(1);
		Tier tier = new Tier();
		tierRequirments.addTier(tier, Tiers.Tier0);
	}

	public TileEntityForgeCore() {
		super(structure, tierRequirments, recipes, LocalDirection.UNKNOWN, 10000, 100);
	}

	@Override
	protected boolean isTankValidForFluid(int groupid, int slot, int fluidId) {
		return false;
	}

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		return false;
	}

	public void burn() {
		if (burnTime > 10000) {
			Random random = new Random();
			for (int j = 0; j < 2; j++) {
				worldObj.spawnParticle("smoke", xCoord + Math.max(0.1, random.nextFloat()), yCoord + 1.25, zCoord + Math.max(0.1, random.nextFloat()), 0.0D, 0.0D, 0.0D);
				worldObj.spawnParticle("flame", xCoord + Math.max(0.1, random.nextFloat()), yCoord + 1.25, zCoord + Math.max(0.1, random.nextFloat()), 0.0D, 0.0D, 0.0D);
			}

			if (getForwardDirection() == ForgeDirection.NORTH || getForwardDirection() == ForgeDirection.SOUTH) {
				for (int j = 0; j < 2; j++) {
					worldObj.spawnParticle("smoke", xCoord + 1 + Math.max(0.1, random.nextFloat() / 2), yCoord + 1.25, zCoord + Math.max(0.1, random.nextFloat()), 0.0D, 0.0D, 0.0D);
					worldObj.spawnParticle("flame", xCoord - 1 + Math.max(0.1, random.nextFloat() / 2), yCoord + 1.25, zCoord + Math.max(0.1, random.nextFloat()), 0.0D, 0.0D, 0.0D);
				}
			} else {
				for (int j = 0; j < 2; j++) {

					worldObj.spawnParticle("smoke", xCoord + Math.max(0.1, random.nextFloat() / 2), yCoord + 1.25, zCoord + 1 + Math.max(0.1, random.nextFloat()), 0.0D, 0.0D, 0.0D);
					worldObj.spawnParticle("flame", xCoord + Math.max(0.1, random.nextFloat() / 2), yCoord + 1.25, zCoord - 1 + Math.max(0.1, random.nextFloat()), 0.0D, 0.0D, 0.0D);

				}
			}
		}
	}

	public void canBurnBlock() {
		int id = worldObj.getBlockId(xCoord, yCoord + 1, zCoord);
		if (id != 0) {
			Block block = Block.blocksList[id];
			int value = GameRegistry.getFuelValue(new ItemStack(block));
			if (value == 0 || burnTime > 40000) {
				DropBlock.doDispense(worldObj, new ItemStack(block), 1, getForwardDirection().getOpposite(), xCoord, yCoord + 1, zCoord);
			} else {
				burnTime += value;
				PrevburnTime = burnTime;
			}
			worldObj.destroyBlock(xCoord, yCoord + 1, zCoord, false);
		}
	}

	@Override
	public void updateEntity() {
		if (!worldObj.isRemote) {
			if (burnTime > 0) {
				burnTime--;
			}
			sendUpdatesifChanged(getValues(), getPrevValues());
		}
		super.updateEntity();
	}

	@Override
	public void setValues(int[] val) {
		burnTime = val[0];
	}

	@Override
	public int[] getValues() {
		return new int[] { burnTime };
	}

	@Override
	public void sendUpdatesifChanged(int[] val, int[] prev) {
		boolean requireUpdate = false;
		for (int i = 0; i < val.length; i++) {
			if (Math.abs(val[i] - prev[i]) > offsetForSync()) {
				requireUpdate = true;
			}
		}
		if (requireUpdate) {
			for (int i = 0; i < val.length; i++) {
				prev[i] = val[i];
			}
			PacketDispatcher.sendPacketToAllAround(xCoord, yCoord, zCoord, 50, this.worldObj.provider.dimensionId, new PacketIP006SyncValues(xCoord, yCoord, zCoord,val).getCustom250Packet());
		}
	}

	@Override
	public int[] getPrevValues() {
		return new int[] { PrevburnTime };
	}

	@Override
	public int offsetForSync() {
		return 5;
	}
}

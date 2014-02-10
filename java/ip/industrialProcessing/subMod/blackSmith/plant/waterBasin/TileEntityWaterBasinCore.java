package ip.industrialProcessing.subMod.blackSmith.plant.waterBasin;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.animation.tanks.ITankSyncable;
import ip.industrialProcessing.machines.animation.tanks.TankHandler;
import ip.industrialProcessing.machines.animation.tanks.TileTankSyncHandler;
import ip.industrialProcessing.multiblock.coreAndDummy.TileEntityMultiblockSwitcherCore;
import ip.industrialProcessing.multiblock.layout.FacingDirection;
import ip.industrialProcessing.multiblock.layout.LayoutMultiblock;
import ip.industrialProcessing.multiblock.layout.LayoutTransformer;
import ip.industrialProcessing.multiblock.layout.StructureMultiblock;
import ip.industrialProcessing.multiblock.recipes.RecipeMultiblock;
import ip.industrialProcessing.multiblock.recipes.RecipesMultiblock;
import ip.industrialProcessing.multiblock.tier.Tier;
import ip.industrialProcessing.multiblock.tier.TierCollection;
import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.multiblock.utils.MultiblockState;
import ip.industrialProcessing.subMod.blackSmith.config.ISetupBlackSmith;
import ip.industrialProcessing.utils.DropBlock;

import java.util.Iterator;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidContainerRegistry.FluidContainerData;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class TileEntityWaterBasinCore extends TileEntityMultiblockSwitcherCore implements ITankSyncable {
	static StructureMultiblock structure;
	static TierCollection tierRequirments;
	private TankHandler tankHandler;
	public static RecipesMultiblock recipes = new RecipesWaterBasin();
	static {
		// set layout
		structure = new StructureMultiblock();

		LayoutMultiblock layout = new LayoutMultiblock(1, 0, 0, 0, 0, 0);

		int i = 0;
		layout.setCoreID(i++, 0, 1, ISetupBlackSmith.blockWaterBasin.blockID);

		layout.setBlockID(-1, 0, 0, i++, 0, 0, ISetupBlackSmith.blockWaterBasin.blockID);

		structure.addLayout(layout, FacingDirection.North);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.East), FacingDirection.East);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.South), FacingDirection.South);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.West), FacingDirection.West);

		// set tiers
		tierRequirments = new TierCollection(1);
		Tier tier = new Tier();
		tierRequirments.addTier(tier, Tiers.Tier0);
	}

	public TileEntityWaterBasinCore() {
		super(structure, tierRequirments, recipes, LocalDirection.UNKNOWN, 10000, 100);
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 5, 0, new ForgeDirection[] { ForgeDirection.UNKNOWN }, true, true);
		this.tankHandler = new TankHandler(this, new int[] { 0 });
	}

	@Override
	public TankHandler getTankHandler() {
		return this.tankHandler;
	}

	@Override
	public void updateEntity() {
		if (!worldObj.isRemote && this.tankHandler.readDataFromTanks())
			TileTankSyncHandler.sendTankData(this, this.tankHandler);
		if (!worldObj.isRemote && worldObj.isRaining()) {
			fill(ForgeDirection.UNKNOWN, new FluidStack(FluidRegistry.WATER, (int) (worldObj.rainingStrength * 10)), true);
		}
		super.updateEntity();
	};

	@Override
	public int getTankCount() {
		return 1;
	}

	@Override
	protected boolean isTankValidForFluid(int groupid, int slot, int fluidId) {
		return true;
	}

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		return false;
	}

	public void handleRightClick(EntityPlayer player) {
		if (getState() == MultiblockState.COMPLETED) {
			if (!handleBucket(player))
				handleItem(player);
		}
	}

	private boolean handleItem(EntityPlayer player) {
		if (drain(ForgeDirection.UNKNOWN, new FluidStack(FluidRegistry.WATER, 1000), false) != null && drain(ForgeDirection.UNKNOWN, new FluidStack(FluidRegistry.WATER, 1000), false).amount == 1000) {

			Iterator<RecipeMultiblock> it = recipes.getRecipes();
			while (it.hasNext()) {
				RecipeMultiblock recipe = it.next();
				if (recipe.inputs[0].itemId == player.getCurrentEquippedItem().itemID) {
					player.getCurrentEquippedItem().splitStack(1);
					if (!player.inventory.addItemStackToInventory(new ItemStack(recipe.outputs[0].itemId, 1, 0))) {
						DropBlock.doDispense(worldObj, new ItemStack(recipe.outputs[0].itemId, 1, 0), 1, ForgeDirection.UP, xCoord, yCoord, zCoord);
					}
					player.inventory.onInventoryChanged();
					drain(ForgeDirection.UNKNOWN, new FluidStack(FluidRegistry.WATER, 1000), true);
					onInventoryChanged();
					spawnSmoke();
					return true;
				}
			}
		}
		return false;
	}

	private void spawnSmoke() {
		for (double j = 0; j < 1; j += 0.1) {
			for (double i = 0; i < 1; i += 0.1) {
				worldObj.spawnParticle("smoke", xCoord + i, yCoord + 1, zCoord + j, 0.0D, 0.0D, 0.0D);
			}
		}
		for (int i = 0; i < this.getDummies().size(); i++) {
			((TileEntityWaterBasinDummy) this.getDummies().get(i)).spawnSmoke();
		}
	}

	public boolean handleBucket(EntityPlayer player) {
		// liquid input
		FluidStack fluid = FluidContainerRegistry.getFluidForFilledItem(player.getCurrentEquippedItem());
		if (fluid != null) {
			if (fluid.fluidID == new FluidStack(FluidRegistry.WATER, 1).fluidID) {
				ItemStack emptyContainer = getEmptyContainerFromContainer(player.getCurrentEquippedItem());
				if (emptyContainer != null) {
					if (this.tankHasRoomFor(0, fluid)) {
						emptyContainer.stackSize = 1;
						player.getCurrentEquippedItem().splitStack(1);
						this.getTankInSlot(0).fill(fluid, true);
						if (!player.inventory.addItemStackToInventory(emptyContainer)) {
							DropBlock.doDispense(worldObj, emptyContainer, 1, ForgeDirection.UP, xCoord, yCoord, zCoord);
						}
						player.inventory.onInventoryChanged();
						return true;
					}
				}
			}
		}
		return false;
	}

	private ItemStack getEmptyContainerFromContainer(ItemStack stack) {
		FluidContainerData[] data = FluidContainerRegistry.getRegisteredFluidContainerData();
		for (int i = 0; i < data.length; i++) {
			FluidContainerData containerData = data[i];
			if (containerData.filledContainer.isItemEqual(stack))
				return containerData.emptyContainer.copy();
		}
		return null;
	}

}

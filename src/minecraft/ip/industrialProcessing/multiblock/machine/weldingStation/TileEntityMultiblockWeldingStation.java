package ip.industrialProcessing.multiblock.machine.weldingStation;

import java.util.Iterator;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.multiblock.extended.inventory.tank.worker.TileEntityMultiblockCoreTankWorker;
import ip.industrialProcessing.multiblock.machine.mixer.RecipesMultiblockMixer;
import ip.industrialProcessing.multiblock.utils.inventory.MultiblockItemStack;
import ip.industrialProcessing.multiblock.utils.layout.MultiblockLayout;
import ip.industrialProcessing.multiblock.utils.layout.MultiblockStructure;
import ip.industrialProcessing.recipes.Recipe;

public class TileEntityMultiblockWeldingStation extends TileEntityMultiblockCoreTankWorker {
	public static MultiblockLayout structure;

	static {

		structure = new MultiblockLayout();

		MultiblockStructure layout = new MultiblockStructure(0, 1, 0, 0, 1, 0);
		layout.setCoreID(ConfigMachineBlocks.getBlockMultiblockWeldingStationID(),0);
		layout.addBlockIDRelative(1, 0, 0, 0,ConfigMachineBlocks.getBlockMultiblockTankWeldingStationRightID());
		layout.addBlockIDRelative(0, 1, 0, 0,ConfigMachineBlocks.getBlockMultiblockTankWeldingStationScreenID());
		layout.addBlockIDRelative(1, 1, 0, 0,ConfigMachineBlocks.getBlockMultiblockTankWeldingStationScreenID());

		structure.commit(layout);
	}
	
	public static RecipesMultiblockWeldingStation recipes = new RecipesMultiblockWeldingStation();
	
	public TileEntityMultiblockWeldingStation() {
		super(structure, 100);
		itemStacks.add(new MultiblockItemStack(true, false, 0));
		itemStacks.add(new MultiblockItemStack(false, true, 1));
		itemStacks.add(new MultiblockItemStack(true, false, 2));
		itemStacks.add(new MultiblockItemStack(true, false, 3));
		itemStacks.add(new MultiblockItemStack(true, false, 4));
		itemStacks.add(new MultiblockItemStack(true, false, 5));
		itemStacks.add(new MultiblockItemStack(true, false, 6));
		itemStacks.add(new MultiblockItemStack(true, false, 7));
		itemStacks.add(new MultiblockItemStack(true, false, 8));
		itemStacks.add(new MultiblockItemStack(true, false, 9));
		itemStacks.add(new MultiblockItemStack(true, false, 10));
		itemStacks.add(new MultiblockItemStack(false, true, 11));
		itemStacks.add(new MultiblockItemStack(true, false, 12));
		itemStacks.add(new MultiblockItemStack(true, false, 13));
		itemStacks.add(new MultiblockItemStack(true, false, 14));
		itemStacks.add(new MultiblockItemStack(true, false, 15));
		
		addTank(10000, true, false);
	}
	@Override
	protected void triggerAchievement() {
		((EntityPlayer) creator).addStat(IndustrialProcessing.achWeldingTable, 1);
	}
	@Override
	public void updateEntity() {
		addBucketToTank(0, 1, 0);
		super.updateEntity();
	}

	@Override
	public Iterator<Recipe> iterateRecipes() {
		return recipes.iterator();
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
		int itemID = itemstack.itemID;
		if (slot == 2||slot > 11)
			return recipes.isValidInput(slot, itemID);
		if (slot == 0) {
			FluidStack fluid = FluidContainerRegistry.getFluidForFilledItem(new ItemStack(itemID, 1, 0));
			if (fluid == null)
				return false;
			return recipes.isValidFluidInput(0, fluid.fluidID);
		}
		return false;
	}

	@Override
	public boolean isTankValidForFluid(int slot, int fluidId) {
		return recipes.isValidFluidInput(slot, fluidId);
	}

}

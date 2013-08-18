package ip.industrialProcessing.multiblock.machine.mixer;

import java.util.Iterator;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.multiblock.extended.inventory.tank.TileEntityMultiblockCoreTank;
import ip.industrialProcessing.multiblock.extended.inventory.tank.worker.TileEntityMultiblockCoreTankWorker;
import ip.industrialProcessing.multiblock.machine.crusher.RecipesMultiblockCrusher;
import ip.industrialProcessing.multiblock.utils.inventory.MultiblockItemStack;
import ip.industrialProcessing.multiblock.utils.layout.MultiblockLayout;
import ip.industrialProcessing.multiblock.utils.layout.MultiblockStructure;
import ip.industrialProcessing.recipes.Recipe;

public class TileEntityMultiblockMixer extends TileEntityMultiblockCoreTankWorker {
	private static MultiblockLayout structure;

	static {
		int inputTankId = ConfigMachineBlocks.getBlockMultiblockTankInputID();
		int outputTankId = ConfigMachineBlocks.getBlockMultiblockTankOutputID();
		int frameId = ConfigMachineBlocks.getMachineFrameBlockID();
		int outputInvId = ConfigMachineBlocks.getMultiMachineOutputBlockID();
		int inputInvId = ConfigMachineBlocks.getMultiMachineInputBlockID();

		structure = new MultiblockLayout();

		MultiblockStructure layout = new MultiblockStructure(2, 2, 1, 1, 0, 1);
		layout.setCoreID(IndustrialProcessing.blockMultiblockMixer.blockID);
		layout.addBlockIDRelative(-1, 0, 0, inputTankId);
		layout.addBlockIDRelative(1, 0, 0, outputTankId);
		layout.addBlockIDRelative(0, 0, -1, inputInvId);
		layout.fillLayer(-1, 0, -1, frameId);

		structure.commit(layout);
	}

	public static RecipesMultiblockMixer recipes = new RecipesMultiblockMixer();

	public TileEntityMultiblockMixer() {
		super(structure, 1);
		itemStacks.add(new MultiblockItemStack(true, false, 0));
		itemStacks.add(new MultiblockItemStack(true, false, 1));
		itemStacks.add(new MultiblockItemStack(false, true, 2));
		itemStacks.add(new MultiblockItemStack(true, false, 3));
		itemStacks.add(new MultiblockItemStack(false, true, 4));
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, true, false);
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, false, true);
	}

	@Override
	public void updateEntity() {
		addBucketToTank(1, 2, 0);
		getBucketFromTank(3, 4, 1);
		super.updateEntity();
	}

	@Override
	public Iterator<Recipe> iterateRecipes() {
		return recipes.iterator();
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack) {
		int itemID = stack.itemID;
		if (slot == 0)
			return recipes.isValidInput(slot, itemID);
		if (slot == 1) {
			FluidStack fluid = FluidContainerRegistry.getFluidForFilledItem(new ItemStack(itemID, 1, 0));
			if (fluid == null)
				return false;
			return recipes.isValidFluidInput(0, fluid.fluidID);
		}
		if (slot == 3)
			return FluidContainerRegistry.isEmptyContainer(new ItemStack(itemID, 1, 0));
		return false;
	}
	
    @Override
    public boolean isTankValidForFluid(int slot, int fluidId) {
    	return recipes.isValidFluidInput(slot, fluidId);
    }
}

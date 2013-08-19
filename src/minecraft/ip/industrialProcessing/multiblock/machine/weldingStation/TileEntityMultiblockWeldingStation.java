package ip.industrialProcessing.multiblock.machine.weldingStation;

import java.util.Iterator;

import net.minecraft.item.ItemStack;
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

		MultiblockStructure layout = new MultiblockStructure(0, 1, 0, 0, 0, 0);
		layout.setCoreID(ConfigMachineBlocks.getBlockMultiblockWeldingStationID());
		layout.addBlockIDRelative(1, 0, 0, 0,ConfigMachineBlocks.getMultiMachineInputBlockID());

		structure.commit(layout);
	}
	
	public static RecipesMultiblockWeldingStation recipes = new RecipesMultiblockWeldingStation();
	
	public TileEntityMultiblockWeldingStation() {
		super(structure, 100);
		itemStacks.add(new MultiblockItemStack(true, false, 0));
		itemStacks.add(new MultiblockItemStack(true, false, 1));
		itemStacks.add(new MultiblockItemStack(false, true, 2));
	}
	@Override
	public void updateEntity() {
		super.updateEntity();
	}

	@Override
	public Iterator<Recipe> iterateRecipes() {
		return recipes.iterator();
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return recipes.isValidInput(i, itemstack.itemID);
	}

	@Override
	public boolean isTankValidForFluid(int slot, int fluidId) {
		return recipes.isValidFluidInput(slot, fluidId);
	}

}

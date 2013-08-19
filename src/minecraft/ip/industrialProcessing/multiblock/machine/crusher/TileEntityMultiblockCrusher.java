package ip.industrialProcessing.multiblock.machine.crusher;

import java.util.Iterator;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.machines.crusher.RecipesCrusher;
import ip.industrialProcessing.multiblock.TileEntityMultiblockCore;
import ip.industrialProcessing.multiblock.extended.inventory.TileEntityMultiblockCoreInv;
import ip.industrialProcessing.multiblock.extended.inventory.worker.TileEntityMultiblockCoreInvWorker;
import ip.industrialProcessing.multiblock.utils.inventory.MultiblockItemStack;
import ip.industrialProcessing.multiblock.utils.layout.MultiBlockStructureBlockDescription;
import ip.industrialProcessing.multiblock.utils.layout.MultiblockLayout;
import ip.industrialProcessing.multiblock.utils.layout.MultiblockStructure;
import ip.industrialProcessing.recipes.Recipe;

public class TileEntityMultiblockCrusher extends TileEntityMultiblockCoreInvWorker {
	private static MultiblockLayout structure;

	static {
		int inputId = ConfigMachineBlocks.getMultiMachineInputBlockID();
		int outputId = ConfigMachineBlocks.getMultiMachineOutputBlockID();
		int frameId = ConfigMachineBlocks.getMachineFrameBlockID();

		structure = new MultiblockLayout();

		MultiblockStructure layout = new MultiblockStructure(1, 1, 1, 1, 0, 1);
		layout.setCoreID(IndustrialProcessing.blockLargeCrusher.blockID);
		layout.addBlockIDRelative(-1, 0, 0,0, inputId);
		layout.addBlockIDRelative(1, 0, 0,0, outputId);
		layout.fillLayer(-1, 0, -1,0, frameId);
		layout.addBlockIDRelative(-1, -1, 0,1, outputId);
		layout.addBlockIDRelative(-1, -1, 0,1, outputId);
		

		structure.commit(layout);
	}
	public static RecipesMultiblockCrusher recipes = new RecipesMultiblockCrusher();

	public TileEntityMultiblockCrusher() {
		super(structure, 10);
		itemStacks.add(new MultiblockItemStack(true, false, 0));
		itemStacks.add(new MultiblockItemStack(false, true, 1));
	}

	@Override
	public Iterator<Recipe> iterateRecipes() {
		return recipes.iterator();
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack) {
		int itemID = stack.itemID;
		return recipes.isValidInput(slot, itemID);
	}
}

package ip.industrialProcessing.multiblock.machine.blastFurnace;

import java.util.Iterator;

import net.minecraft.item.ItemStack;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.multiblock.extended.inventory.tank.worker.TileEntityMultiblockCoreTankWorker;
import ip.industrialProcessing.multiblock.machine.crusher.RecipesMultiblockCrusher;
import ip.industrialProcessing.multiblock.utils.inventory.MultiblockItemStack;
import ip.industrialProcessing.multiblock.utils.layout.MultiblockLayout;
import ip.industrialProcessing.multiblock.utils.layout.MultiblockStructure;
import ip.industrialProcessing.recipes.Recipe;

public class TileEntityMultiblockBlastFurnace extends
		TileEntityMultiblockCoreTankWorker {
	private static MultiblockLayout structure;
	static {
		int inputId = ConfigMachineBlocks.getMultiMachineInputBlockID();
		int outputId = ConfigMachineBlocks.getMultiMachineOutputBlockID();
		int frameId = ConfigMachineBlocks.getMachineFrameBlockID();

		structure = new MultiblockLayout();

		MultiblockStructure layout = new MultiblockStructure(1, 1, 0, 2, 5, 0);
		layout.setCoreID(IndustrialProcessing.blockMultiblockBlastFurnace.blockID);
		layout.addBlockIDRelative(-1, 0, 0, 1, frameId);
		layout.addBlockIDRelative(+1, 0, 0, 1, frameId);
		layout.addBlockIDRelative(-1, 0, 1, 1, frameId);
		layout.addBlockIDRelative(+1, 0, 1, 1, frameId);
		layout.addBlockIDRelative(-1, 0, 2, 1, frameId);
		layout.addBlockIDRelative(+1, 0, 2, 1, frameId);
		layout.addBlockIDRelative(0, 0, 1, 1, frameId);
		layout.addBlockIDRelative(0, 0, 2, 1, frameId);
		
		for(int i = 1;i<3;i++){
			layout.addBlockIDRelative(-1, i, 0, 1, frameId);
			layout.addBlockIDRelative(+1, i, 0, 1, frameId);
			layout.addBlockIDRelative(-1, i, 1, 1, frameId);
			layout.addBlockIDRelative(+1, i, 1, 1, frameId);
			layout.addBlockIDRelative(-1, i, 2, 1, frameId);
			layout.addBlockIDRelative(+1, i, 2, 1, frameId);
			layout.addBlockIDRelative(0, i, 1, 3, frameId);
			layout.addBlockIDRelative(0, i, 2, 1, frameId);
			layout.addBlockIDRelative(0, i, 0, 1, frameId);
		}
		for(int i= 3;i<5;i++){
			layout.addBlockIDRelative(0, i, 1, 3, frameId);
		}
		layout.addBlockIDRelative(0, 3,1, 4, frameId);

		structure.commit(layout);
	}
	public static RecipesMultiblockCrusher recipes = new RecipesMultiblockCrusher();

	public TileEntityMultiblockBlastFurnace() {
		super(structure, 10);
		itemStacks.add(new MultiblockItemStack(true, false, 0));
		itemStacks.add(new MultiblockItemStack(false, true, 1));
	}

	@Override
	public Iterator<Recipe> iterateRecipes() {
		return recipes.iterator();
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return false;
	}

	@Override
	public boolean isTankValidForFluid(int slot, int fluidId) {
		return false;
	}

}

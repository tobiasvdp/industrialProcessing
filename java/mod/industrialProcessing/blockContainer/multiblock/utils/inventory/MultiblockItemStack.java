package mod.industrialProcessing.blockContainer.multiblock.utils.inventory;

import mod.industrialProcessing.utils.inventory.itemstack.MachineItemStack;
import net.minecraft.item.ItemStack;

public class MultiblockItemStack extends MachineItemStack implements IMultiblockItemStack{

	private int multiblockID;
	
	public MultiblockItemStack(ItemStack stack,int multiblockID, int[] sides, boolean input, boolean output) {
		super(stack, sides, input, output);
		this.multiblockID = multiblockID;
	}

	@Override
	public void setMultiblockID(int id) {
		this.multiblockID = id;
	}

	@Override
	public int getMultiblockID() {
		return this.multiblockID;
	}

}

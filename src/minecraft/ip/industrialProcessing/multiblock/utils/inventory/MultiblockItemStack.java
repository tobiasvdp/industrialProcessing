package ip.industrialProcessing.multiblock.utils.inventory;

import net.minecraft.item.ItemStack;
import ip.industrialProcessing.machines.MachineItemStack;

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

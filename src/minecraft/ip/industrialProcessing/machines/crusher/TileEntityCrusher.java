package ip.industrialProcessing.machines.crusher;

import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.recipes.IRecipeWorkHandler;
import ip.industrialProcessing.recipes.RecipeWorker;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityCrusher extends TileEntityMachine  implements
IRecipeWorkHandler{

	private RecipeWorker recipeWorker;

	public TileEntityCrusher() {
		this.recipeWorker = new RecipeWorker(this);
		super.setWorker(this.recipeWorker);

		this.addStack(null, ForgeDirection.UP, true, false);
		this.addStack(null,
				new ForgeDirection[] { ForgeDirection.SOUTH,
						ForgeDirection.NORTH, ForgeDirection.EAST,
						ForgeDirection.WEST }, false, true);
		this.addStack(null, ForgeDirection.DOWN, false, true);
	}

	@Override
	public void beginWork() {
	}

	@Override
	public void workDone() {

	}

	@Override
	public boolean hasWork() {
		return false;
	}

	@Override
	public boolean canWork() {
		return false;
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		if (i == 0)
			return canInput(itemstack);
		return false;
	}

	private boolean canInput(ItemStack itemstack) {
		if (itemstack == null)
			return false;
		if (itemstack.itemID == Block.gravel.blockID)
			return true;
		if (itemstack.itemID == Block.dirt.blockID)
			return true;
		return false;
	}

}

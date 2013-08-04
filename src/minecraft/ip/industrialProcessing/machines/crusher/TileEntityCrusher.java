package ip.industrialProcessing.machines.crusher;

import java.util.Iterator;

import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.machines.filter.RecipesFilter;
import ip.industrialProcessing.recipes.IRecipeWorkHandler;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeWorker;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityCrusher extends TileEntityMachine implements
	IRecipeWorkHandler {

		public static RecipesFilter recipes = new RecipesFilter();
		
		private RecipeWorker recipeWorker;

		public TileEntityCrusher() {
			this.recipeWorker = new RecipeWorker(this);
			super.setWorker(this.recipeWorker);

			this.addStack(null, ForgeDirection.UP, true, false);
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
			return true;
		}

		@Override
		public boolean canWork() {
			return true;
		}

		@Override
		public boolean isItemValidForSlot(int i, ItemStack itemstack) {
			if (i == 0) return canInput(itemstack);
			return false;
		}

		private boolean canInput(ItemStack itemstack) {
			if (itemstack == null)
				return false;
			if (itemstack.itemID == Block.gravel.blockID)
				return true;
			return false;
		}

		@Override
		public Iterator<Recipe> iterateRecipes() {
			return recipes.iterator();
		}

}

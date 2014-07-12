package mod.industrialProcessing.work.recipe.slots;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import mod.industrialProcessing.utils.inventory.IInventorySlots;
import mod.industrialProcessing.work.recipe.IRecipeWorkHandler;
import mod.industrialProcessing.work.recipe.Inputs.ExactInputBlock;
import mod.industrialProcessing.work.recipe.Inputs.ExactInputItem;
import mod.industrialProcessing.work.recipe.Inputs.InputItem;
import mod.industrialProcessing.work.recipe.Inputs.InputItemStack;
import mod.industrialProcessing.work.recipe.Inputs.OreDictionaryItem;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

public class RecipeInputInventorySlot extends RecipeInputSlot {
	private InputItem item;

	public RecipeInputInventorySlot(int index, Item item, int amount) {
		super(index, amount, RecipeSlotType.INVENTORY);
		this.item = new ExactInputItem(item);
	}

	/** 
	 * @deprecated Use ore dictionary!
	 */
	@Deprecated
	public RecipeInputInventorySlot(int index, Item item, int metadata, RecipeSlotType type, int amount) {
		super(index, amount, RecipeSlotType.INVENTORY);
		this.item = new ExactInputItem(item, metadata);
	}

	/** 
	 * @deprecated Use ore dictionary!
	 */
	@Deprecated
	public RecipeInputInventorySlot(int index, Block item, RecipeSlotType type, int amount) {
		super(index, amount, RecipeSlotType.INVENTORY);
		this.item = new ExactInputBlock(item);
	}

	/** 
	 * @deprecated Use ore dictionary!
	 */
	@Deprecated
	public RecipeInputInventorySlot(int index, Block item, int metadata, RecipeSlotType type, int amount) {
		super(index, amount, RecipeSlotType.INVENTORY);
		this.item = new ExactInputBlock(item, metadata);
	}

	/** 
	 * @deprecated Use ore dictionary!
	 */
	@Deprecated
	public RecipeInputInventorySlot(int index, ItemStack stack) {
		super(index, stack.stackSize, RecipeSlotType.INVENTORY);
		this.item = new InputItemStack(stack);
	}
	
	public RecipeInputInventorySlot(int index, String oreDictionaryKey, int amount)
	{
		super(index, amount, RecipeSlotType.INVENTORY);
		this.item = new OreDictionaryItem(oreDictionaryKey);
	}

	@Override
	public ItemStack getDefaultDisplayStack() {
		if (item != null)
			return item.getDisplayStack();
		return null;
	}

	public boolean isItemValid(Item item2) {
		return this.item.isValid(new ItemStack(item2));
	}

	public boolean isItemValid(ItemStack item2) {
		return this.item.isValid(item2);
	}

	public void removeFrom(IInventorySlots handler) {

		if (!handler.removeFromSlot(this.index, this.getMaxAmount()))
			System.err.println("Failed to remove recipe input?!");
	}
}

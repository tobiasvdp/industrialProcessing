package mod.industrialProcessing.work.recipe.slots;

import mod.industrialProcessing.work.recipe.IRecipeWorkHandler;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

public class RecipeOutputInventorySlot extends RecipeOutputSlot {
	public static final int WILDCARD_VALUE = Short.MAX_VALUE;
 

	private ItemStack item;

	public RecipeOutputInventorySlot(int index, Item item, int minAmount, int maxAmount, double distributionCenter) {
		this(index, new ItemStack(item), minAmount, maxAmount, distributionCenter);
	}

	public RecipeOutputInventorySlot(int index, Item item, int damage, int minAmount, int maxAmount, double distributionCenter) {
		this(index, new ItemStack(item, damage), minAmount, maxAmount, distributionCenter);
	}

	public RecipeOutputInventorySlot(int index, Block item, int minAmount, int maxAmount, double distributionCenter) {
		this(index, new ItemStack(item), minAmount, maxAmount, distributionCenter);
	}

	public RecipeOutputInventorySlot(int index, Block item, int damage, int minAmount, int maxAmount, double distributionCenter) {
		this(index, new ItemStack(item, damage), minAmount, maxAmount, distributionCenter);
	}

	public RecipeOutputInventorySlot(int index, ItemStack stack) {
		this(index, stack, stack.stackSize, stack.stackSize);
	}

	public RecipeOutputInventorySlot(int index, ItemStack stack, int min, int max) {
		this(index, stack, min, max, 0.5);
	}

	public RecipeOutputInventorySlot(int index, ItemStack stack, int min, int max, double distributionCenter) {
		super(index, min, max, distributionCenter, RecipeSlotType.INVENTORY);

		this.item = stack.copy(); 
	}

	public boolean hasSpace(IRecipeWorkHandler handler) {

		ItemStack newStack = this.item.copy();
		newStack.stackSize = this.getMaxAmount();
		return handler.slotHasRoomFor(index, newStack);
	}

	public void addToOutput(IRecipeWorkHandler handler, int amount) {

		ItemStack newStack = this.item.copy();
		newStack.stackSize = amount;
		if (!handler.addToSlot(amount, newStack))
			System.err.println("Failed to create recipe output?!");
	}

	@Override
	public ItemStack getDefaultDisplayStack() {
		ItemStack newStack = this.item.copy();
		newStack.stackSize = 1;
		return newStack;
	}

	public boolean isItemEqual(ItemStack stack) {
		return item.isItemEqual(stack);
	}

	public boolean isItemEqual(ItemStack stack, int damage) {
		return item.isItemEqual(stack) && item.getItemDamage() == damage;
	}

	public ItemStack createStack(int amount) { 
		ItemStack newStack = this.item.copy();
		newStack.stackSize = amount;
		return newStack;
	}

}

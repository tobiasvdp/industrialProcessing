package mod.industrialProcessing.work.recipe.slots;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;

public abstract class RecipeSlot {

	public int index;
	public RecipeSlotType type;
	
	public abstract int getMinAmount();
	public abstract int getMaxAmount();
	
	
	protected RecipeSlot(int index, RecipeSlotType type)
	{
		this.index = index; 
		this.type = type;
	}


	public abstract ItemStack getDefaultDisplayStack() ;
	
	/*
	public int index;
	private Item item;
	private Block block;
	public Fluid fluid;
	public boolean hasMetadata;
	public int metadata;
	public RecipeSlotType type;

	public RecipeSlot(int index, Item item, RecipeSlotType type) {
		this.index = index;
		this.item = item;
		this.type = type;
	}

	public RecipeSlot(int index, Item item, int metadata, RecipeSlotType type) {
		this.index = index;
		this.item = item;
		this.metadata = metadata;
		hasMetadata = true;
		this.type = type;
	}
	
	public RecipeSlot(int index, Block item, RecipeSlotType type) {
		this.index = index;
		this.block = item;
		this.type = type;
	}

	public RecipeSlot(int index, Block item, int metadata, RecipeSlotType type) {
		this.index = index;
		this.block = item;
		this.metadata = metadata;
		hasMetadata = true;
		this.type = type;
	}

	public RecipeSlot() {
	}
	
	public Item getItem() {
		if(item == null && block != null){
			item =  Item.getItemFromBlock(block);
		}
		return item;
	}
	
	public void setItem(Item item){
		this.item = item;
	}
	*/
}

package mod.industrialProcessing.work.recipe.Inputs;

import java.util.ArrayList;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ExactInputItem extends InputItem {

	private Item item;
	private int meta;
	private boolean hasMeta;

	public ExactInputItem(Item item, int meta) {
		this.item = item;
		this.meta = meta;
		this.hasMeta = true;
	}
	
	public ExactInputItem(Item item) {
		this.item = item;
		this.hasMeta = false;
	}

	@Override
	public boolean isValid(ItemStack stack) {
		if(stack == null) return false;
		Item item = stack.getItem();
		return (item == this.item && (!hasMeta || stack.getItemDamage() == this.meta));
	}

	@Override
	public ArrayList<ItemStack>  getValidItemStacks() {
		
		ArrayList<ItemStack> list = new ArrayList<ItemStack> ();
		list.add(new ItemStack(this.item));
		return list;
	}

	@Override
	public ItemStack getDisplayStack() { 
		return  new ItemStack(this.item);
	}

}

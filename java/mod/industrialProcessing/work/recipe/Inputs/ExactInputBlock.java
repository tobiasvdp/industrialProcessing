package mod.industrialProcessing.work.recipe.Inputs;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ExactInputBlock extends InputItem {

	private Block block;
	private int meta;
	private boolean hasMeta;
	private ItemStack stack;

	public ExactInputBlock(Block block, int meta) {
		this.block = block;
		this.meta = meta;
		this.hasMeta = true;
		this.stack = new ItemStack(block, meta);
	}

	public ExactInputBlock(Block item) {
		this.block = item;
		this.hasMeta = false;
		this.stack = new ItemStack(block);
	}

	@Override
	public boolean isValid(ItemStack stack) {
		
		boolean itemEqual = stack.isItemEqual(stack);
		
		return itemEqual				&& (!hasMeta || stack.getItemDamage() == this.meta);
	}

	@Override
	public ArrayList<ItemStack> getValidItemStacks() {

		ArrayList<ItemStack> list = new ArrayList<ItemStack>();
		list.add(new ItemStack(this.block));
		return list;
	}

	@Override
	public ItemStack getDisplayStack() {
		return new ItemStack(this.block);
	}

}

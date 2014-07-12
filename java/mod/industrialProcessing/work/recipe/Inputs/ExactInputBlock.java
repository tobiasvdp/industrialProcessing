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

	public ExactInputBlock(Block block, int meta) {
		this.block = block;
		this.meta = meta;
		this.hasMeta = true;
	}

	public ExactInputBlock(Block item) {
		this.block = item;
		this.hasMeta = false;
	}

	@Override
	public boolean isValid(ItemStack stack) {
		Item item = stack.getItem();

		if (item instanceof ItemBlock) {
			ItemBlock block = (ItemBlock) item;
			return (block.field_150939_a == this.block) && (!hasMeta || stack.getItemDamage() == this.meta);
		}
		return false;
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

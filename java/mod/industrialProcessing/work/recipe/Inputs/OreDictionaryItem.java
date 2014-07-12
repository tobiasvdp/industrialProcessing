package mod.industrialProcessing.work.recipe.Inputs;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryItem extends InputItem {

	private String key;

	public OreDictionaryItem(String key) {
		this.key = key;
	}

	@Override
	public boolean isValid(ItemStack stack) {

		return false;
	}

	@Override
	public ArrayList<ItemStack>  getValidItemStacks() {
		return OreDictionary.getOres(this.key); 
	}

	@Override
	public ItemStack getDisplayStack() {

		ArrayList<ItemStack> ores = getValidItemStacks();

		if (ores.isEmpty())
			return null;
		return ores.get(0);
	}

}

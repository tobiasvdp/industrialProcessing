package mod.industrialProcessing.recipe;

import net.minecraft.item.Item;
import net.minecraftforge.fluids.Fluid;

public class RecipeSlot {
	public int index;
	public Item item;
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

	public RecipeSlot() {
	}
}

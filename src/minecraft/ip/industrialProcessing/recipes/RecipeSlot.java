package ip.industrialProcessing.recipes;

public class RecipeSlot {
	public int index;
	public int itemId;
	public boolean hasMetadata;
	public int metadata;
	public RecipeSlotType type;

	public RecipeSlot(int index, int itemId, RecipeSlotType type) {
		this.index = index;
		this.itemId = itemId;
		this.type = type;
	}

	public RecipeSlot(int index, int itemId, int metadata, RecipeSlotType type) {
		this.index = index;
		this.itemId = itemId;
		this.metadata = metadata;
		hasMetadata = true;
		this.type = type;
	}

	public RecipeSlot() {
	}
}

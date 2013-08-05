package ip.industrialProcessing.recipes;

public class RecipeSlot {
	public int index;
	public int itemId;
	public RecipeSlotType type;
	public RecipeSlot(int index,int itemId, RecipeSlotType type){
		this.index = index;
		this.itemId = itemId;
		this.type = type;
	}
}

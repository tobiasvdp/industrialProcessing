package ip.industrialProcessing.recipes;

public class RecipeInputSlot extends RecipeSlot {
	public int amount;
	public RecipeInputSlot(int index,int itemId, RecipeSlotType type,int amount){
		super(index,itemId,type);
		this.amount = amount;
	}
}

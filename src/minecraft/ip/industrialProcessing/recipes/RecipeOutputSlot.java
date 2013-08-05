package ip.industrialProcessing.recipes;

public class RecipeOutputSlot extends RecipeSlot {

	public int maxAmount = 1;
	public int minAmount = 1;
	public double distributionCenter = 0.5;	
	
	public RecipeOutputSlot(int index,int itemId, RecipeSlotType type,int minAmount,int maxAmount,double distributionCenter){
		super(index,itemId,type);
		this.minAmount = minAmount;
		this.maxAmount = maxAmount;
		this.distributionCenter = distributionCenter;
	}
}

package mod.industrialProcessing.work.recipe.slots;

public abstract class RecipeOutputSlot extends RecipeSlot {

	protected RecipeOutputSlot(int index, int minAmount, int maxAmount, RecipeSlotType type) {
		this(index, minAmount, maxAmount, 0.5, type);
	}
	protected RecipeOutputSlot(int index, int minAmount, int maxAmount, double distributionCenter, RecipeSlotType type) {
		super(index, type);
		this.minAmount = minAmount;
		this.maxAmount = maxAmount;
		this.distributionCenter = distributionCenter;
	}

	private int minAmount;
	private int maxAmount;
	private double distributionCenter;

	@Override
	public int getMinAmount() {
		return this.minAmount;
	}

	@Override
	public int getMaxAmount() {
		return this.maxAmount;
	}

	public int getRandomAmount(double randomValue) {
		double size = maxAmount - minAmount;
		if (size == 0)
			return minAmount;
		
		double distributionCenter = this.distributionCenter;
		distributionCenter = minAmount + distributionCenter * size;
		double value = distributionCenter + randomValue / 3 * size;
		value = Math.max(minAmount, value);
		value = Math.min(maxAmount, value);
		return (int) Math.round(value);
	}
}

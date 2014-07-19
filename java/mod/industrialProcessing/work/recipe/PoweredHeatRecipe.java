package mod.industrialProcessing.work.recipe;

public class PoweredHeatRecipe extends Recipe implements IPowerRecipe, IHeatRecipe {
	public float powerRequired;
	public float heatRequired;

	public PoweredHeatRecipe() {
	}

	@Override
	public float getPowerRequired() {
		return this.powerRequired;
	}

	@Override
	public float getHeatRequired() { 
		return this.heatRequired;
	}
}
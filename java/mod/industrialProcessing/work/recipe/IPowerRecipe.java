package mod.industrialProcessing.work.recipe;

public interface IPowerRecipe extends IMachineRecipe {
	/**
	 * @return returns the amount of power required per tick
	 */
    float getPowerRequired();
}

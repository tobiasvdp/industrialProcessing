package mod.industrialProcessing.work.recipe;

import mod.industrialProcessing.fluids.tank.IMachineTanks;

public interface IRecipeFluidWorkHandler<TMachineRecipe extends IMachineRecipe> extends IRecipeWorkHandler<TMachineRecipe>, IMachineTanks { 
	
}

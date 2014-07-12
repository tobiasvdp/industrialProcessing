package mod.industrialProcessing.work.recipe;

import mod.industrialProcessing.blockContainer.multiblock.tier.Tiers;
import mod.industrialProcessing.fluids.tank.IMachineTanks;
import mod.industrialProcessing.work.worker.IWorkingEntity;

public interface IRecipeMultiblockFluidWorkHandler extends IRecipeFluidWorkHandler<RecipeMultiblock> {
	Tiers getTier();
}

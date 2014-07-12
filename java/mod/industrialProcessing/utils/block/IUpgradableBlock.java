package mod.industrialProcessing.utils.block;

import mod.industrialProcessing.gui.generating.IGuiBuilder;
import mod.industrialProcessing.work.recipe.RecipesMachine;

public interface IUpgradableBlock {

	public IGuiBuilder getUpgradeGui();
	public RecipesMachine getUpgradeRecipes();
	public boolean isMachineUpgradable();
	
}

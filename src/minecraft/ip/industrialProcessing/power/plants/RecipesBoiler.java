package ip.industrialProcessing.power.plants;

import net.minecraftforge.fluids.FluidRegistry;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesBoiler extends RecipesMachine {

	public RecipesBoiler()
	{
		Recipe steam = new Recipe();
		steam.workRequired = 30;
		steam.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER.getID(), RecipeSlotType.TANK, 100)};
		steam.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.LAVA.getID(), RecipeSlotType.TANK, 50, 150, 0.5)};
		addRecipe(steam);
	}
}

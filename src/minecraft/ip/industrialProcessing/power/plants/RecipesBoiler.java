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
		
		int steamID = FluidRegistry.getFluid("steam").getID();
		steam.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, steamID, RecipeSlotType.TANK, 50, 150, 0.5)};
		addRecipe(steam);
	}
}

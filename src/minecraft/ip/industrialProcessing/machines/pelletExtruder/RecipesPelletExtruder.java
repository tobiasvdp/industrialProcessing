package ip.industrialProcessing.machines.pelletExtruder;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;
import net.minecraftforge.fluids.FluidRegistry;

public class RecipesPelletExtruder  extends RecipesMachine{

	public RecipesPelletExtruder() {
		addDefaultRecipes();
	}
	private void addDefaultRecipes() {

		Recipe pellets= new Recipe();
		pellets.workRequired = 30;
		pellets.inputs = new RecipeInputSlot[] { 
				new RecipeInputSlot(0,IndustrialProcessing.itemIronOxideDust.itemID,RecipeSlotType.INVENTORY, 64)};
		pellets.outputs = new RecipeOutputSlot[] {
				new RecipeOutputSlot(1,IndustrialProcessing.itemIronOxidePellets.itemID,RecipeSlotType.INVENTORY, 13, 19, 0.5)  };
		addRecipe(pellets);
	}

}

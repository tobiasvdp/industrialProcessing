package ip.industrialProcessing.machines.blastFurnace;

import net.minecraftforge.fluids.FluidRegistry;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesBlastFurnace extends RecipesMachine {

	public RecipesBlastFurnace() {
		addDefaultRecipes();
	}
	private void addDefaultRecipes() {

		Recipe pigIron= new Recipe();
		pigIron.workRequired = 30;
		pigIron.inputs = new RecipeInputSlot[] { 
				new RecipeInputSlot(0,IndustrialProcessing.itemIronOxidePellets.itemID,RecipeSlotType.INVENTORY, 10),
				new RecipeInputSlot(1,IndustrialProcessing.itemCalcareousSinterDust.itemID,RecipeSlotType.INVENTORY, 10),
				new RecipeInputSlot(2,IndustrialProcessing.itemCokes.itemID,RecipeSlotType.INVENTORY, 10)};
		pigIron.outputs = new RecipeOutputSlot[] {
				new RecipeOutputSlot(0,FluidRegistry.getFluidID(IndustrialProcessing.itemFluidHotSlag.getName()),RecipeSlotType.TANK, 15000, 20000, 0.5)  ,
				new RecipeOutputSlot(1,FluidRegistry.getFluidID(IndustrialProcessing.itemFluidPigIron.getName()),RecipeSlotType.TANK, 10000, 15000, 0.5)  ,
				new RecipeOutputSlot(2,FluidRegistry.getFluidID(IndustrialProcessing.itemFluidExhaustGas.getName()),RecipeSlotType.TANK, 30000, 40000, 0.5)  };
		addRecipe(pigIron);
	}
}

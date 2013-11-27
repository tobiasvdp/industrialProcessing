package ip.industrialProcessing.machines.flotationCell;

import net.minecraftforge.fluids.FluidRegistry;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesFlotationCell extends RecipesMachine {
	public RecipesFlotationCell(){
		addDefaultRecipes();
	}

	private void addDefaultRecipes() {
		addRecipe(dirtyToUnclean(3000,0));
		addRecipe(ThickSludgeToFlotationSedimentIron(3000,1));
		addRecipe(ThickSludgeToFlotationSedimentTin(3000,1));
		addRecipe(ThickSludgeToFlotationSedimentCopper(3000,1));
		addRecipe(ThickSludgeToFlotationSedimentGold(3000,1));
		addRecipe(ThickSludgeToFlotationSedimentTalia(3000,1));
		addRecipe(ThickSludgeToFlotationSedimentGalena(3000,1));
		addRecipe(ThickSludgeToFlotationSedimentChromite(3000,1));
	}
    private Recipe dirtyToUnclean(int i,int power) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.powerRequired = power;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidUncleanWater.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5),new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidResidu.getName()), RecipeSlotType.TANK, 100, 200, 0.5) };
		return recipe;
	}
    
	private Recipe ThickSludgeToFlotationSedimentIron(int i, int powerConsumption) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidThickIronSludge.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidFlotationIronSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidConcentratedIronSludge.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}

	private Recipe ThickSludgeToFlotationSedimentTin(int i, int powerConsumption) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidThickTinSludge.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidFlotationTinSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidConcentratedTinSludge.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}

	private Recipe ThickSludgeToFlotationSedimentCopper(int i, int powerConsumption) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidThickCopperSludge.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidFlotationCopperSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidConcentratedCopperSludge.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}

	private Recipe ThickSludgeToFlotationSedimentGold(int i, int powerConsumption) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidThickGoldSludge.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidFlotationGoldSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidConcentratedGoldSludge.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}

	private Recipe ThickSludgeToFlotationSedimentGalena(int i, int powerConsumption) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidThickGalenaSludge.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidFlotationGalenaSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidConcentratedGalenaSludge.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}

	private Recipe ThickSludgeToFlotationSedimentChromite(int i, int powerConsumption) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidThickChromiteSludge.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidFlotationChromiteSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidConcentratedChromiteSludge.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}

	private Recipe ThickSludgeToFlotationSedimentTalia(int i, int powerConsumption) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.powerRequired = powerConsumption;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidThickTaliaSludge.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidFlotationTaliaSediment.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5), new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidConcentratedTaliaSludge.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}
	
}

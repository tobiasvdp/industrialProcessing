package ip.industrialProcessing.multiblock.core.block.blastFurnace;

import net.minecraft.item.Item;
import net.minecraftforge.fluids.FluidRegistry;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesMultiblockBlastFurnace extends RecipesMachine {
    public RecipesMultiblockBlastFurnace() {
	addDefaultRecipes();
    }

	private void addDefaultRecipes() {
		addRecipe(meltIron(12000, 0));
	}

	private Recipe meltIron(int i, int power) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.powerRequired = power;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidAir.getName()), RecipeSlotType.TANK, 1000),new RecipeInputSlot(0, IndustrialProcessing.itemIronSinter.itemID, RecipeSlotType.INVENTORY, 1),new RecipeInputSlot(1, IndustrialProcessing.itemCokePellet.itemID, RecipeSlotType.INVENTORY, 1) };
		recipe.outputs = new RecipeOutputSlot[] {new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidPigIron.getName()), RecipeSlotType.TANK, 800, 1200, 0.5),new RecipeOutputSlot(2, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidHotSlag.getName()), RecipeSlotType.TANK, 300, 500, 0.5), new RecipeOutputSlot(3, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidExhaustGas.getName()), RecipeSlotType.TANK, 100, 100, 0.5)};
		return recipe;
	}
}

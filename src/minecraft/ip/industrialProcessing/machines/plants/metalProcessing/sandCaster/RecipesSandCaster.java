package ip.industrialProcessing.machines.plants.metalProcessing.sandCaster;

import ip.industrialProcessing.config.ISetupFluids;
import ip.industrialProcessing.config.ISetupItems;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.PoweredRecipe;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.FluidRegistry;

public class RecipesSandCaster extends RecipesMachine {
    public RecipesSandCaster() {
	addDefaultRecipes();
    }

    private void addDefaultRecipes() {
	addRecipe(CastIronIngot(3000, 0));
    }

    private Recipe CastIronIngot(int work, int power) {
	PoweredRecipe recipe = new PoweredRecipe();
	recipe.workRequired = work;
	recipe.powerRequired = power;
	recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(ISetupFluids.itemFluidPigIron.getName()), RecipeSlotType.TANK, 800), new RecipeInputSlot(0, ISetupItems.itemSandCastIngot.itemID, RecipeSlotType.DAMAGEDITEM, 1) };
	recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, Item.ingotIron.itemID, RecipeSlotType.INVENTORY, 1, 1, 0) };
	return recipe;
    }
}

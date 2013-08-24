package ip.industrialProcessing.multiblock.machine.weldingStation;

import net.minecraft.item.Item;
import net.minecraftforge.fluids.FluidRegistry;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesMultiblockWeldingStation extends RecipesMachine {
	public RecipesMultiblockWeldingStation() {
		addDefaultRecipes();
	}
	private void addDefaultRecipes() {
		Recipe ironSludge= new Recipe();
		ironSludge.workRequired = 4000;
		ironSludge.powerRequired= 12000;
		ironSludge.inputs = new RecipeInputSlot[] {
				new RecipeInputSlot(12,IndustrialProcessing.itemHammer.itemID,RecipeSlotType.DAMAGEDITEM, 1),
				new RecipeInputSlot(13,IndustrialProcessing.itemBlowingTorch.itemID,RecipeSlotType.DAMAGEDITEM, 1),
				new RecipeInputSlot(2,Item.ingotIron.itemID,RecipeSlotType.INVENTORY, 1)
		};
		ironSludge.outputs = new RecipeOutputSlot[] {};
		addRecipe(ironSludge);
	}
}

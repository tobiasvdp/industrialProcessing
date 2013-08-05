package ip.industrialProcessing.machines.mixer;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.FluidRegistry;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesMixer extends RecipesMachine {

	public RecipesMixer()
	{
		addDefaultRecipes();
	}

	private void addDefaultRecipes() {

		//dirt
		RecipeInputSlot waterInput = new RecipeInputSlot();
		waterInput.amount = 3000;
		waterInput.index = 0;
		waterInput.itemId=FluidRegistry.WATER.getID();
		waterInput.type = RecipeSlotType.TANK;

		RecipeInputSlot blazeInput = new RecipeInputSlot();
		blazeInput.amount = 1;
		waterInput.index = 0;
		blazeInput.itemId=Item.blazePowder.itemID;
		blazeInput.type = RecipeSlotType.INVENTORY;
		
		RecipeOutputSlot lavaOutput = new RecipeOutputSlot();
		lavaOutput.minAmount = 2000;
		lavaOutput.maxAmount = 4000;
		lavaOutput.distributionCenter = 2;
		lavaOutput.index = 1;
		lavaOutput.itemId = FluidRegistry.LAVA.getID();
		lavaOutput.type = RecipeSlotType.TANK;
		
		Recipe lavaRecipe = new Recipe();
		lavaRecipe.workRequired = 30;
		lavaRecipe.inputs = new RecipeInputSlot[]{waterInput, blazeInput};
		lavaRecipe.outputs = new RecipeOutputSlot[]{lavaOutput};		
		
		addRecipe(lavaRecipe);
	}
}

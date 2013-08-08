package ip.industrialProcessing.machines.mixer;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import ip.industrialProcessing.IndustrialProcessing;
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

		Recipe lava = new Recipe();
		lava.workRequired = 30;
		lava.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0,
				FluidRegistry.WATER.getID(),
				RecipeSlotType.TANK, 1) ,
				new RecipeInputSlot(0,
				Item.blazePowder.itemID,
				RecipeSlotType.TANK, 1)};
		lava.outputs = new RecipeOutputSlot[] {
				new RecipeOutputSlot(1,
						FluidRegistry.LAVA.getID(),
						RecipeSlotType.TANK, 0, 1000, 0.5)  };
		addRecipe(lava);
	}
}

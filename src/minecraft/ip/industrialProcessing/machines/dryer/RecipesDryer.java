package ip.industrialProcessing.machines.dryer;

import net.minecraftforge.fluids.FluidRegistry;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesDryer extends RecipesMachine {

    public RecipesDryer() {
    	addRecipe(ironSludgeToCleanChunks(3000));
    	addRecipe(copperSludgeToCleanChunks(3000));
    	addRecipe(tinSludgeToCleanChunks(3000));
    	addRecipe(goldSludgeToCleanChunks(3000));
    	addRecipe(galenaSludgeToCleanChunks(3000));
    	addRecipe(taliaSludgeToCleanChunks(3000));
    	addRecipe(chromiteSludgeToCleanChunks(3000));
    }

    private Recipe chromiteSludgeToCleanChunks(int i) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidOreSludgeChromite.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, IndustrialProcessing.itemChromiteWashedChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0), new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 0, 1000, 0.5) };
		return recipe;
	}

	private Recipe taliaSludgeToCleanChunks(int i) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidOreSludgeTalia.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, IndustrialProcessing.itemTaliaWashedChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0), new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 0, 1000, 0.5) };
		return recipe;
	}

	private Recipe galenaSludgeToCleanChunks(int i) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidOreSludgeGalena.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, IndustrialProcessing.itemGalenaWashedChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0), new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 0, 1000, 0.5) };
		return recipe;
	}

	private Recipe goldSludgeToCleanChunks(int i) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidOreSludgeGold.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, IndustrialProcessing.itemGoldWashedChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0), new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 0, 1000, 0.5) };
		return recipe;
	}

	private Recipe tinSludgeToCleanChunks(int i) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidOreSludgeTin.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, IndustrialProcessing.itemTinWashedChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0), new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 0, 1000, 0.5) };
		return recipe;
	}

	private Recipe copperSludgeToCleanChunks(int i) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidOreSludgeCopper.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, IndustrialProcessing.itemCopperWashedChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0), new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 0, 1000, 0.5) };
		return recipe;
	}

	private Recipe ironSludgeToCleanChunks(int i) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidOreSludgeIron.getName()), RecipeSlotType.TANK, 1000) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, IndustrialProcessing.itemIronWashedChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0), new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidDirtyWater.getName()), RecipeSlotType.TANK, 0, 1000, 0.5) };
		return recipe;
	}

}

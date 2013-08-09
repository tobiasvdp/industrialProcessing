package ip.industrialProcessing.machines.dryer;

import net.minecraftforge.fluids.FluidRegistry;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesDryer extends RecipesMachine {
	
	public RecipesDryer()
	{
		addDefaultRecipes();
	}

	private void addDefaultRecipes() {

	Recipe ironSludge= new Recipe();
	ironSludge.workRequired = 30;
	ironSludge.inputs = new RecipeInputSlot[] { 
			new RecipeInputSlot(0,FluidRegistry.getFluidID(IndustrialProcessing.itemFluidOreSludgeIron.getName()),RecipeSlotType.TANK, 1000)};
	ironSludge.outputs = new RecipeOutputSlot[] {
			new RecipeOutputSlot(0,IndustrialProcessing.itemIronWashedChunks.itemID,RecipeSlotType.INVENTORY, 1,2,0) ,
			new RecipeOutputSlot(1,FluidRegistry.getFluidID(IndustrialProcessing.itemFluidDirtyWater.getName()),RecipeSlotType.TANK, 0, 1000, 0.5)  };
	addRecipe(ironSludge);
	
	Recipe copperSludge= new Recipe();
	copperSludge.workRequired = 30;
	copperSludge.inputs = new RecipeInputSlot[] { 
			new RecipeInputSlot(0,FluidRegistry.getFluidID(IndustrialProcessing.itemFluidOreSludgeCopper.getName()),RecipeSlotType.TANK, 1000)};
	copperSludge.outputs = new RecipeOutputSlot[] {
			new RecipeOutputSlot(0,IndustrialProcessing.itemCopperWashedChunks.itemID,RecipeSlotType.INVENTORY, 1,2,0) ,
			new RecipeOutputSlot(1,FluidRegistry.getFluidID(IndustrialProcessing.itemFluidDirtyWater.getName()),RecipeSlotType.TANK, 0, 1000, 0.5)  };
	addRecipe(copperSludge);
	
	Recipe tinSludge= new Recipe();
	tinSludge.workRequired = 30;
	tinSludge.inputs = new RecipeInputSlot[] { 
			new RecipeInputSlot(0,FluidRegistry.getFluidID(IndustrialProcessing.itemFluidOreSludgeTin.getName()),RecipeSlotType.TANK, 1000)};
	tinSludge.outputs = new RecipeOutputSlot[] {
			new RecipeOutputSlot(0,IndustrialProcessing.itemTinWashedChunks.itemID,RecipeSlotType.INVENTORY, 1,2,0) ,
			new RecipeOutputSlot(1,FluidRegistry.getFluidID(IndustrialProcessing.itemFluidDirtyWater.getName()),RecipeSlotType.TANK, 0, 1000, 0.5)  };
	addRecipe(tinSludge);
	
	}
	
}

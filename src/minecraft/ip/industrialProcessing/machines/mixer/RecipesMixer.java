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

		Recipe ironSludge= new Recipe();
		ironSludge.workRequired = 4000;
		ironSludge.inputs = new RecipeInputSlot[] { 
				new RecipeInputSlot(0,FluidRegistry.WATER.getID(),RecipeSlotType.TANK, 1000) ,
				new RecipeInputSlot(0,IndustrialProcessing.itemIronSmallChunks.itemID,RecipeSlotType.INVENTORY, 1)};
		ironSludge.outputs = new RecipeOutputSlot[] {
				new RecipeOutputSlot(1,FluidRegistry.getFluidID(IndustrialProcessing.itemFluidOreSludgeIron.getName()),RecipeSlotType.TANK, 1000, 1000, 0.5)  };
		addRecipe(ironSludge);
		
		Recipe copperSludge= new Recipe();
		copperSludge.workRequired = 4000;
		copperSludge.inputs = new RecipeInputSlot[] { 
				new RecipeInputSlot(0,FluidRegistry.WATER.getID(),RecipeSlotType.TANK, 1000) ,
				new RecipeInputSlot(0,IndustrialProcessing.itemCopperSmallChunks.itemID,RecipeSlotType.INVENTORY, 1)};
		copperSludge.outputs = new RecipeOutputSlot[] {
				new RecipeOutputSlot(1,FluidRegistry.getFluidID(IndustrialProcessing.itemFluidOreSludgeCopper.getName()),RecipeSlotType.TANK, 1000, 1000, 0.5)  };
		addRecipe(copperSludge);
		
		Recipe tinSludge= new Recipe();
		tinSludge.workRequired = 4000;
		tinSludge.inputs = new RecipeInputSlot[] { 
				new RecipeInputSlot(0,FluidRegistry.WATER.getID(),RecipeSlotType.TANK, 1000) ,
				new RecipeInputSlot(0,IndustrialProcessing.itemTinSmallChunks.itemID,RecipeSlotType.INVENTORY, 1)};
		tinSludge.outputs = new RecipeOutputSlot[] {
				new RecipeOutputSlot(1,FluidRegistry.getFluidID(IndustrialProcessing.itemFluidOreSludgeTin.getName()),RecipeSlotType.TANK, 1000, 1000, 0.5)  };
		addRecipe(tinSludge);
	}
}

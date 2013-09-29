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

	public RecipesMixer() {
		addRecipe(ironSmallToSludge(3000));
		addRecipe(copperSmallToSludge(3000));
		addRecipe(tinSmallToSludge(3000));
		addRecipe(goldSmallToSludge(3000));
		addRecipe(galenaSmallToSludge(3000));
		addRecipe(chromiteSmallToSludge(3000));
		addRecipe(taliaSmallToSludge(3000));
	}

	private Recipe taliaSmallToSludge(int i) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER.getID(), RecipeSlotType.TANK, 1000), new RecipeInputSlot(0, IndustrialProcessing.itemTaliaSmallChunks.itemID, RecipeSlotType.INVENTORY, 1) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidOreSludgeTalia.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}

	private Recipe chromiteSmallToSludge(int i) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER.getID(), RecipeSlotType.TANK, 1000), new RecipeInputSlot(0, IndustrialProcessing.itemChromiteSmallChunks.itemID, RecipeSlotType.INVENTORY, 1) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidOreSludgeChromite.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}

	private Recipe galenaSmallToSludge(int i) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER.getID(), RecipeSlotType.TANK, 1000), new RecipeInputSlot(0, IndustrialProcessing.itemGalenaSmallChunks.itemID, RecipeSlotType.INVENTORY, 1) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidOreSludgeGalena.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}

	private Recipe goldSmallToSludge(int i) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER.getID(), RecipeSlotType.TANK, 1000), new RecipeInputSlot(0, IndustrialProcessing.itemGoldSmallChunks.itemID, RecipeSlotType.INVENTORY, 1) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidOreSludgeGold.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}

	private Recipe tinSmallToSludge(int i) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER.getID(), RecipeSlotType.TANK, 1000), new RecipeInputSlot(0, IndustrialProcessing.itemTinSmallChunks.itemID, RecipeSlotType.INVENTORY, 1) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidOreSludgeTin.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}

	private Recipe copperSmallToSludge(int i) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER.getID(), RecipeSlotType.TANK, 1000), new RecipeInputSlot(0, IndustrialProcessing.itemCopperSmallChunks.itemID, RecipeSlotType.INVENTORY, 1) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidOreSludgeCopper.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}

	private Recipe ironSmallToSludge(int i) {
		Recipe recipe = new Recipe();
		recipe.workRequired = i;
		recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.WATER.getID(), RecipeSlotType.TANK, 1000), new RecipeInputSlot(0, IndustrialProcessing.itemIronSmallChunks.itemID, RecipeSlotType.INVENTORY, 1) };
		recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidOreSludgeIron.getName()), RecipeSlotType.TANK, 1000, 1000, 0.5) };
		return recipe;
	}
}

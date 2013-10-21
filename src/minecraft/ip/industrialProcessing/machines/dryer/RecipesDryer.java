package ip.industrialProcessing.machines.dryer;

import net.minecraft.block.Block;
import net.minecraftforge.fluids.FluidRegistry;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesDryer extends RecipesMachine {

    public RecipesDryer() {
        addRecipe(ironSludgeToCleanChunks(3000, 1));
        addRecipe(copperSludgeToCleanChunks(3000, 1));
        addRecipe(tinSludgeToCleanChunks(3000, 1));
        addRecipe(goldSludgeToCleanChunks(3000, 1));
        addRecipe(galenaSludgeToCleanChunks(3000, 1));
        addRecipe(taliaSludgeToCleanChunks(3000, 1));
        addRecipe(chromiteSludgeToCleanChunks(3000, 1));
        addRecipe(gritSludgeToGrit(3000, 1));
        addRecipe(residuToSand(3000, 1));
    }

    private Recipe gritSludgeToGrit(int i, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidGritSludge.getName()), RecipeSlotType.TANK, 1000) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, IndustrialProcessing.blockGrit.blockID, RecipeSlotType.INVENTORY, 1, 1, 0) };
        return recipe;
    }

    private Recipe residuToSand(int i, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidResidu.getName()), RecipeSlotType.TANK, 1000) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, Block.sand.blockID, RecipeSlotType.INVENTORY, 1, 1, 0) };
        return recipe;
    }

    private Recipe chromiteSludgeToCleanChunks(int i, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidOreSludgeChromite.getName()), RecipeSlotType.TANK, 1000) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, IndustrialProcessing.itemChromiteWashedChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0), new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 0, 1000, 0.5) };
        return recipe;
    }

    private Recipe taliaSludgeToCleanChunks(int i, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidOreSludgeTalia.getName()), RecipeSlotType.TANK, 1000) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, IndustrialProcessing.itemTaliaWashedChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0), new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 0, 1000, 0.5) };
        return recipe;
    }

    private Recipe galenaSludgeToCleanChunks(int i, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidOreSludgeGalena.getName()), RecipeSlotType.TANK, 1000) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, IndustrialProcessing.itemGalenaWashedChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0), new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 0, 1000, 0.5) };
        return recipe;
    }

    private Recipe goldSludgeToCleanChunks(int i, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidOreSludgeGold.getName()), RecipeSlotType.TANK, 1000) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, IndustrialProcessing.itemGoldWashedChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0), new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 0, 1000, 0.5) };
        return recipe;
    }

    private Recipe tinSludgeToCleanChunks(int i, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidOreSludgeTin.getName()), RecipeSlotType.TANK, 1000) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, IndustrialProcessing.itemTinWashedChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0), new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 0, 1000, 0.5) };
        return recipe;
    }

    private Recipe copperSludgeToCleanChunks(int i, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidOreSludgeCopper.getName()), RecipeSlotType.TANK, 1000) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, IndustrialProcessing.itemCopperWashedChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0), new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 0, 1000, 0.5) };
        return recipe;
    }

    private Recipe ironSludgeToCleanChunks(int i, int powerConsumption) {
        Recipe recipe = new Recipe();
        recipe.workRequired = i;
        recipe.powerRequired = powerConsumption;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidOreSludgeIron.getName()), RecipeSlotType.TANK, 1000) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(0, IndustrialProcessing.itemIronWashedChunks.itemID, RecipeSlotType.INVENTORY, 1, 2, 0), new RecipeOutputSlot(1, FluidRegistry.getFluidID(IndustrialProcessing.itemFluidfiltyWater.getName()), RecipeSlotType.TANK, 0, 1000, 0.5) };
        return recipe;
    }

}

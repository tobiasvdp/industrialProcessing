package ip.industrialProcessing.machines.classifier;

import cpw.mods.fml.common.registry.GameRegistry;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class RecipesClassifier extends RecipesMachine {
    public RecipesClassifier() {
        createRecipe(3000, 1, IndustrialProcessing.itemCopperMixedFragments, 1, FluidRegistry.WATER, 1000, IndustrialProcessing.itemFluidMixedSludgeCopper, 1, 1000, 0.5, IndustrialProcessing.blockGrit, 0, 1, 0.25f);
        createRecipe(3000, 1, IndustrialProcessing.itemTinMixedFragments, 1, FluidRegistry.WATER, 1000, IndustrialProcessing.itemFluidMixedSludgeTin, 1, 1000, 0.5, IndustrialProcessing.blockGrit, 0, 1, 0.25f);
        createRecipe(3000, 1, IndustrialProcessing.itemIronMixedFragments, 1, FluidRegistry.WATER, 1000, IndustrialProcessing.itemFluidMixedSludgeIron, 1, 1000, 0.5, IndustrialProcessing.blockGrit, 0, 1, 0.25f);
    }

    public void createRecipe(int work, int power, Item inputItem, int inputItemAmount, Fluid inputFluid, int inputFluidAmount, Fluid outputFluid, int outputFluidAmountMin, int outputFluidAmountMax, double outputFluidDistribution, Item outputItem, int outputItemAmountMin, int outputItemAmountMax, double outputItemDisribution) {
        createRecipe(work, power, inputItem.itemID, inputItemAmount, inputFluid, inputFluidAmount, outputFluid, outputFluidAmountMin, outputFluidAmountMax, outputFluidDistribution, outputItem.itemID, outputItemAmountMin, outputItemAmountMax, outputItemDisribution);
    }

    public void createRecipe(int work, int power, Block inputItem, int inputItemAmount, Fluid inputFluid, int inputFluidAmount, Fluid outputFluid, int outputFluidAmountMin, int outputFluidAmountMax, double outputFluidDistribution, Item outputItem, int outputItemAmountMin, int outputItemAmountMax, double outputItemDisribution) {
        createRecipe(work, power, inputItem.blockID, inputItemAmount, inputFluid, inputFluidAmount, outputFluid, outputFluidAmountMin, outputFluidAmountMax, outputFluidDistribution, outputItem.itemID, outputItemAmountMin, outputItemAmountMax, outputItemDisribution);
    }

    public void createRecipe(int work, int power, Block inputItem, int inputItemAmount, Fluid inputFluid, int inputFluidAmount, Fluid outputFluid, int outputFluidAmountMin, int outputFluidAmountMax, double outputFluidDistribution, Block outputItem, int outputItemAmountMin, int outputItemAmountMax, double outputItemDisribution) {
        createRecipe(work, power, inputItem.blockID, inputItemAmount, inputFluid, inputFluidAmount, outputFluid, outputFluidAmountMin, outputFluidAmountMax, outputFluidDistribution, outputItem.blockID, outputItemAmountMin, outputItemAmountMax, outputItemDisribution);
    }

    public void createRecipe(int work, int power, Item inputItem, int inputItemAmount, Fluid inputFluid, int inputFluidAmount, Fluid outputFluid, int outputFluidAmountMin, int outputFluidAmountMax, double outputFluidDistribution, Block outputItem, int outputItemAmountMin, int outputItemAmountMax, double outputItemDisribution) {
        createRecipe(work, power, inputItem.itemID, inputItemAmount, inputFluid, inputFluidAmount, outputFluid, outputFluidAmountMin, outputFluidAmountMax, outputFluidDistribution, outputItem.blockID, outputItemAmountMin, outputItemAmountMax, outputItemDisribution);
    }

    protected void createRecipe(int work, int power, int inputItem, int inputItemAmount, Fluid inputFluid, int inputFluidAmount, Fluid outputFluid, int outputFluidAmountMin, int outputFluidAmountMax, double outputFluidDistribution, int outputItem, int outputItemAmountMin, int outputItemAmountMax, double outputItemDisribution) {
        Recipe recipe = new Recipe();
        recipe.workRequired = work;
        recipe.powerRequired = power;
        recipe.inputs = new RecipeInputSlot[] { new RecipeInputSlot(0, inputItem, RecipeSlotType.INVENTORY, inputItemAmount), new RecipeInputSlot(0, inputFluid.getID(), RecipeSlotType.TANK, inputFluidAmount) };
        recipe.outputs = new RecipeOutputSlot[] { new RecipeOutputSlot(1, outputFluid.getID(), RecipeSlotType.TANK, outputFluidAmountMin, outputFluidAmountMax, outputFluidDistribution), new RecipeOutputSlot(1, outputItem, RecipeSlotType.INVENTORY, outputItemAmountMin, outputItemAmountMax, outputItemDisribution) };
        addRecipe(recipe);
    }
}

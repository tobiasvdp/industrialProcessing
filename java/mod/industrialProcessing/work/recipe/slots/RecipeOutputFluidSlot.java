package mod.industrialProcessing.work.recipe.slots;

import mod.industrialProcessing.fluids.FluidIP;
import mod.industrialProcessing.work.recipe.IRecipeFluidWorkHandler;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;

public class RecipeOutputFluidSlot extends RecipeOutputSlot {

	private Fluid fluid;

	public RecipeOutputFluidSlot(int index, int minAmount, int maxAmount, Fluid fluid) {
		super(index, minAmount, maxAmount, RecipeSlotType.TANK);
		this.fluid = fluid;
	}
	
	public RecipeOutputFluidSlot(int index, int minAmount, int maxAmount, FluidIP fluid) {
		this(index, minAmount, maxAmount, fluid.getFluid()); 
	}

	@Override
	public ItemStack getDefaultDisplayStack() {
		return new ItemStack(fluid.getBlock());
	}

	public boolean hasRoom(IRecipeFluidWorkHandler fluidHanlder) {

		return fluidHanlder.tankHasRoomFor(this.index, this.fluid, this.getMaxAmount());
	}

	public void addToOutput(IRecipeFluidWorkHandler fluidHanlder, int amount) {
		if (!fluidHanlder.addToTank(this.index, this.fluid, amount))
			System.out.println("Failed to create recipe output?! ");
	}

}

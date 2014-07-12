package mod.industrialProcessing.work.recipe.slots;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import mod.industrialProcessing.work.recipe.IRecipeFluidWorkHandler;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

public class RecipeInputFluidSlot extends RecipeInputSlot {

	// TODO: fluid registry?!
	private Fluid fluid;

	public RecipeInputFluidSlot(int index, FluidStack stack) {
		super(index, stack.amount, RecipeSlotType.TANK);
		
		this.fluid = stack.getFluid();
		 
	}
	public RecipeInputFluidSlot(int index, Fluid fluid, int amount) {
		super(index, amount, RecipeSlotType.TANK);
		
		this.fluid = fluid;
		 
	}

	@Override
	public ItemStack getDefaultDisplayStack() {

		return new ItemStack(fluid.getBlock(), this.getMaxAmount());
	}

	
	public boolean isFluidValid(Fluid fluid) {

		return this.fluid == fluid;
	}
	
	public Fluid getFluid() { 
		return this.fluid;
	}
	public void removeFrom(IRecipeFluidWorkHandler fluidHandler) { 
		if (!fluidHandler.removeFromTank(index, fluid, getMaxAmount()))
			System.out.println("Failed to remove recipe inpt?!");
	}

}

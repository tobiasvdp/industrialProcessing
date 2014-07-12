package mod.industrialProcessing.work.recipe.slots;

import mod.industrialProcessing.fluids.tank.IMachineTanks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

public class RecipeInputFluidSlot extends RecipeInputSlot implements IRecipeFluidSlot{

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
	public void removeFrom(IMachineTanks fluidHandler) { 
		if (!fluidHandler.removeFromTank(index, fluid, getMaxAmount()))
			System.out.println("Failed to remove recipe inpt?!");
	}
	@Override
	public FluidStack getDisplayFluidStack() { 
		return new FluidStack(this.fluid, getMaxAmount());
	}

}

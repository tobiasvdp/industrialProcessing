package mod.industrialProcessing.work.recipe.Inputs;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidContainerRegistry.FluidContainerData;

public class FluidContainerItem extends InputItem {

	private FluidStack fluid;

	public FluidContainerItem(Fluid fluid)
	{
		this.fluid = new FluidStack(fluid, 0);
	}
	
	@Override
	public boolean isValid(ItemStack stack) {
		return FluidContainerRegistry.containsFluid(stack,fluid);
	}

	@Override
	public ArrayList<ItemStack>  getValidItemStacks() {
		
		
		ArrayList<ItemStack> valid = new ArrayList<ItemStack>();
		FluidContainerData[] data = FluidContainerRegistry.getRegisteredFluidContainerData();
		
		for (int i = 0; i < data.length; i++) {
			FluidContainerData fluidContainerData = data[i];
			if(fluidContainerData.fluid.isFluidEqual(this.fluid))
			{
				valid.add(fluidContainerData.filledContainer);			
			}
		}
		
		
		return valid;
	}

	@Override
	public ItemStack getDisplayStack() { 
		FluidContainerData[] data = FluidContainerRegistry.getRegisteredFluidContainerData();		
		for (int i = 0; i < data.length; i++) {
			FluidContainerData fluidContainerData = data[i];
			if(fluidContainerData.fluid.isFluidEqual(this.fluid))
			{
				 return fluidContainerData.filledContainer;			
			}
		}
		return null;
	}

}

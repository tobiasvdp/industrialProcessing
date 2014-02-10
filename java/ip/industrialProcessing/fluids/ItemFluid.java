package ip.industrialProcessing.fluids;

import ip.industrialProcessing.utils.registry.ItemRegistry;
import ip.industrialProcessing.utils.registry.ItemType;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class ItemFluid extends Fluid{
	
	public ItemFluid(String fluidName, int density,int viscosity) {
		super(fluidName);
		setDensity( density ); 
		setViscosity( viscosity );
		FluidRegistry.registerFluid(this);
	} 
	
}

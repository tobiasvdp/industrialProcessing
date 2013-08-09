package ip.industrialProcessing.fluids;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class ItemFluidDirtyWater extends Fluid{

	public ItemFluidDirtyWater(String fluidName) {
		super(fluidName);
		setDensity( -1000 ); 
		setViscosity( 1000 );
		FluidRegistry.registerFluid( this );
	}


}

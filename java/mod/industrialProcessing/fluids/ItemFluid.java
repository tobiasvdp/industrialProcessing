package mod.industrialProcessing.fluids;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.util.IIcon;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class ItemFluid extends Fluid{
	
	private BlockFluid fluidBlock;
		
	public ItemFluid(String fluidName, int density,int viscosity) {
		super(fluidName);
		setDensity( density ); 
		setViscosity( viscosity );
		FluidRegistry.registerFluid(this);
	} 
	
	public void setFluidBlock(BlockFluid block){
		this.fluidBlock = block;
	}
	
	@Override
	public IIcon getStillIcon() {
		if(fluidBlock.theIcon[0] != null)
			return fluidBlock.theIcon[0];
		else
			return FluidRegistry.WATER.getStillIcon();
			
	}
	
	@Override
	public IIcon getFlowingIcon() {
		if(fluidBlock.theIcon[1] != null)
			return fluidBlock.theIcon[1];
		else
			return FluidRegistry.WATER.getFlowingIcon();
		
	}
	
}

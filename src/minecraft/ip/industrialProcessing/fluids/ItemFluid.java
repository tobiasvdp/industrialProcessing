package ip.industrialProcessing.fluids;

import ip.industrialProcessing.IndustrialProcessing;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
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

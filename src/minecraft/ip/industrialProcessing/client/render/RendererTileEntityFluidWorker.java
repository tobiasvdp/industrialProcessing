package ip.industrialProcessing.client.render;

import ip.industrialProcessing.machines.TileEntityFluidMachine;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidTankInfo;

public class RendererTileEntityFluidWorker extends RendererTileEntityAnimated {

    private ModelAnimatedFluidMachine model;

    public RendererTileEntityFluidWorker(Block block, String name, ModelAnimatedFluidMachine model) {
	super(block, name, model);
	this.model = model;
    }

    @Override
    protected void renderBlock(TileEntity tl, World world, int i, int j, int k, Block block2, float f) {
	super.renderBlock(tl, world, i, j, k, block2, f); 
	/* This is handled by IFluidInfo now
	if (tl instanceof TileEntityFluidMachine) {
	    TileEntityFluidMachine machine = (TileEntityFluidMachine) tl;
	    this.func_110628_a(TextureMap.field_110575_b);
	    for (int t = 0; t < machine.getTankCount(); t++) {
		FluidTankInfo info = machine.getTankInfoForSlot(t);
		if (info != null) {
		    if (info.fluid != null) {
			Icon icon = info.fluid.getFluid().getStillIcon();
			this.model.renderLiquid(0.0625f, t, info.fluid.amount / (float) info.capacity, icon);
		    }
		}
	    }
	}
	*/
	if(tl instanceof IFluidInfo)
	{
	    IFluidInfo fluidInfo = (IFluidInfo)tl;
	    FluidTankInfo[] tanks = fluidInfo.getTanks();
	    this.func_110628_a(TextureMap.field_110575_b);
	    for (int l = 0; l < tanks.length; l++) {
		FluidTankInfo info = tanks[l];
		if (info != null) {
		    if (info.fluid != null) {
			Icon icon = info.fluid.getFluid().getStillIcon();
			this.model.renderLiquid(0.0625f, l, info.fluid.amount / (float) info.capacity, icon);
		    }
		}
	    }
	}
    }
}

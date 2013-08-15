package ip.industrialProcessing.client.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;

public class RendererTileEntityConnectedFluid extends RendererTileEntity {

    private ModelConnectedFluid model;

    public RendererTileEntityConnectedFluid(Block block, String name, ModelConnectedFluid model) {
	super(block, name, model);
	this.model = model;
	this.rotateModel = false;
    }

    @Override
    protected void renderBlock(TileEntity tl, World world, int i, int j, int k, Block block2, float f) {

	ConnectionState north = ConnectionState.DISCONNECTED;
	ConnectionState east = ConnectionState.DISCONNECTED;
	ConnectionState south = ConnectionState.DISCONNECTED;
	ConnectionState west = ConnectionState.DISCONNECTED;
	ConnectionState up = ConnectionState.DISCONNECTED;
	ConnectionState down = ConnectionState.DISCONNECTED;

	if (tl instanceof IConnectedTile) {
	    IConnectedTile tile = (IConnectedTile) tl;
	    if (tile != null) {
		north = tile.getConnection(ForgeDirection.NORTH);
		east = tile.getConnection(ForgeDirection.EAST);
		south = tile.getConnection(ForgeDirection.SOUTH);
		west = tile.getConnection(ForgeDirection.WEST);
		up = tile.getConnection(ForgeDirection.UP);
		down = tile.getConnection(ForgeDirection.DOWN);
	    }
	}
	if (world == null) {
	    north = ConnectionState.PLUGGED;
	    south = ConnectionState.CONNECTED;
	}
	this.model.renderModelConnected(f, north, east, south, west, up, down);
	if (tl instanceof IFluidInfo) {
	    IFluidInfo fluidInfo = (IFluidInfo) tl;
	    FluidTankInfo[] tanks = fluidInfo.getTanks(); 
	    this.func_110628_a(TextureMap.field_110575_b);
	    for (int l = 0; l < tanks.length; l++) {
		FluidTankInfo info = tanks[l];
		if (info != null) {
		    if (info.fluid != null) {
			Icon icon = info.fluid.getFluid().getStillIcon();
			this.model.renderModelConnectedFluid(f, north, east, south, west, up, down, l, info.fluid.amount / (float) info.capacity, icon);
		    }
		}
	    }
	}
    }
}

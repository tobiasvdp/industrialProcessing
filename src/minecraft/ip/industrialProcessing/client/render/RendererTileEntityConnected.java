package ip.industrialProcessing.client.render;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class RendererTileEntityConnected extends RendererTileEntity {

    private ModelConnected model;

    public RendererTileEntityConnected(Block block, String name, ModelConnected model) {
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

	this.model.renderModelConnected(f, north, east, south, west, up, down);
    }
}

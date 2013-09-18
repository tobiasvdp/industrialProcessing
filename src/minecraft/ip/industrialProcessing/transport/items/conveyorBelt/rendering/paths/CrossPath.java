package ip.industrialProcessing.transport.items.conveyorBelt.rendering.paths;

import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.transport.items.conveyorBelt.MovingItemStack;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.util.vector.Vector3f;

public class CrossPath extends ItemPath {

	public CrossPath(TileEntity tl, ConnectionState front, ConnectionState left, ConnectionState right, ConnectionState back, ConnectionState up, ConnectionState down) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public PathState getPosition(MovingItemStack stack) {
		PathState state = new PathState();
		
		return state; 
	}

}

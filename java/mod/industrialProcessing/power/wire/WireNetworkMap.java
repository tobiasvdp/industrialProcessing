package ip.industrialProcessing.power.wire;

import ip.industrialProcessing.power.IPowerAcceptor;
import ip.industrialProcessing.transport.TransportConnectionState;

import java.util.HashSet;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class WireNetworkMap {
    // HashMap<WireLocation, WireNetworkMapEntry> network = new
    // HashMap<WireLocation, WireNetworkMapEntry>();

    private static TileEntityWire getWireAt(WireLocation location, World world) {
	TileEntity ent = world.getBlockTileEntity(location.x, location.y, location.z);
	if (ent instanceof TileEntityWire)
	    return (TileEntityWire) ent;
	return null;
    }

    private static IPowerAcceptor getAcceptorAt(World world, WireLocation location) {
	TileEntity ent = world.getBlockTileEntity(location.x, location.y, location.z);
	if (ent instanceof IPowerAcceptor)
	    return (IPowerAcceptor) ent;
	return null;
    }

    public static void UpdateNetworkAt(World world, int x, int y, int z) {
	HashSet<WireLocation> wireLocations = new HashSet<WireLocation>();
	HashSet<WireConnection> outputLocations = new HashSet<WireConnection>();
	WireLocation start = new WireLocation(x, y, z);
	checkLocation(world, start, wireLocations, outputLocations);
	WireConnection[] outputs = outputLocations.toArray(new WireConnection[outputLocations.size()]);
	for(WireLocation location : wireLocations)
	{
	    TileEntityWire wire = getWireAt(location, world);
	    wire.setOutputs(outputs);
	}
    }

    private static void checkLocation(World world, WireLocation start, HashSet<WireLocation> wireLocations, HashSet<WireConnection> outputLocations) {
	TileEntityWire wire = getWireAt(start, world);
	if (wire != null) { // wire exists, add to map!
	    if (wireLocations.add(start)) {
		for (int i = 0; i < 6; i++) {
		    ForgeDirection direction = ForgeDirection.VALID_DIRECTIONS[i];
		    TransportConnectionState state = wire.getTransportConnection(direction);
		    if (state == TransportConnectionState.TRANSPORT) {
			checkLocation(world, start.moveBy(direction), wireLocations, outputLocations);
		    } else if (state == TransportConnectionState.OUTPUT) {
			checkOutput(world, start.moveBy(direction), direction.getOpposite(), outputLocations);
		    }
		}
	    }
	}
    }

    private static void checkOutput(World world, WireLocation location, ForgeDirection sourceDirection, HashSet<WireConnection> outputLocations) {
	IPowerAcceptor acceptor = getAcceptorAt(world, location);
	if (acceptor != null && acceptor.canAcceptPower(sourceDirection)) {
	    outputLocations.add(new WireConnection(location, sourceDirection));
	}
    }

}

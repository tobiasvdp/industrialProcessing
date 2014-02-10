package ip.industrialProcessing.config;

import ip.industrialProcessing.transport.steve.railway.suspended.rail.BlockSuspendedRail;
import ip.industrialProcessing.transport.steve.railway.suspension.BlockSuspension;

public interface ISetupTransportBlocks {
	public final static BlockSuspendedRail blockSuspendedRail = new BlockSuspendedRail();
	public final static BlockSuspension blockSuspension = new BlockSuspension();
}

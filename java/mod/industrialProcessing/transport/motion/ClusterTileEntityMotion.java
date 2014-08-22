package mod.industrialProcessing.transport.motion;

import mod.industrialProcessing.power.utils.IMechanicalMotionEmitter;
import mod.industrialProcessing.power.utils.IMechanicalMotionReceiver;
import mod.industrialProcessing.utils.clusters.ClusterTileEntityBase;
import mod.industrialProcessing.utils.clusters.IClusterManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class ClusterTileEntityMotion extends ClusterTileEntityBase<ClusterItemMotion, ClusterMotion> {

	@Override
	protected IClusterManager<ClusterItemMotion, ClusterMotion> getManager(World p_145834_1_) {
		return ClusterManagerMotion.manager(p_145834_1_);
	}

	IMechanicalMotionReceiver[] receivers = new IMechanicalMotionReceiver[6];
	IMechanicalMotionEmitter[] emitters = new IMechanicalMotionEmitter[6];

	public void neighborChange(int nTeX, int nTeY, int nTeZ) {
		scanNeighbors();
	}

	public void onPlaced() {
		scanNeighbors();
	}

	private void scanNeighbors() {
		for (int i = 0; i < 6; i++) {
			ForgeDirection dir = ForgeDirection.getOrientation(i);
			if (canConnect(dir)) {
				TileEntity te = getNeighbor(dir);
				checkNeighbor(te, dir);
			}
		}
	}

	private void onEmitterConnected(IMechanicalMotionEmitter emitter, ForgeDirection dir) {
		ClusterMotion cluster = getCluster();
		ClusterItemMotion item = getClusterItem();
		cluster.onEmitterConnected(emitter, item, dir);
	}


	private void onReceiverConnected(IMechanicalMotionReceiver receiver, ForgeDirection dir) { 
		ClusterMotion cluster = getCluster();
		ClusterItemMotion item = getClusterItem();
		cluster.onReceiverConnected(receiver, item, dir);
		
	}
	private void onEmitterDisconnected(IMechanicalMotionEmitter emitter, ForgeDirection dir) {
		ClusterMotion cluster = getCluster();
		ClusterItemMotion item = getClusterItem();
		cluster.onEmitterDisconnected(emitter, item, dir);

	}

	private void onReceiverDisconnected(IMechanicalMotionReceiver receiver, ForgeDirection dir) {
		ClusterMotion cluster = getCluster();
		ClusterItemMotion item = getClusterItem();
		cluster.onReceiverDisconnected(receiver, item, dir);

	}

	private void checkNeighbor(TileEntity te, ForgeDirection dir) {
		if (te instanceof IMechanicalMotionReceiver) {
			IMechanicalMotionReceiver receiver = (IMechanicalMotionReceiver) te;
			checkReceiverNeighbor(receiver, dir);
		} else
			checkReceiverNeighbor(null, dir);

		if (te instanceof IMechanicalMotionEmitter) {
			IMechanicalMotionEmitter emitter = (IMechanicalMotionEmitter) te;
			checkEmitterNeighbor(emitter, dir);
		} else
			checkEmitterNeighbor(null, dir);
	}

	private void checkEmitterNeighbor(IMechanicalMotionEmitter emitter, ForgeDirection dir) {
		int i = dir.ordinal();
		IMechanicalMotionEmitter existing = emitters[i];
		if (emitter == null) {
			if (existing != null) {
				onEmitterDisconnected(existing, dir);
				emitters[i] = null;
			}
		} else {
			if (existing != null) {
				if (existing != emitter) {
					onEmitterDisconnected(existing, dir);
				}
				emitters[i] = emitter;
				onEmitterConnected(emitter, dir);
			}
		}
	}

	private void checkReceiverNeighbor(IMechanicalMotionReceiver receiver, ForgeDirection dir) {
		int i = dir.ordinal();
		IMechanicalMotionReceiver existing = receivers[i];
		if (receiver == null) {
			if (existing != null) {
				onReceiverDisconnected(existing, dir);
				receivers[i] = null;
			}
		} else {
			if (existing != null) {
				if (existing != receiver) {
					onReceiverDisconnected(existing, dir);
				}
				receivers[i] = receiver;
				onReceiverConnected(receiver, dir);
			}
		}
	}

 
}

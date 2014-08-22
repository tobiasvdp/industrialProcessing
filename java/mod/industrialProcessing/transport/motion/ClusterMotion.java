package mod.industrialProcessing.transport.motion;

import java.util.HashSet;
import java.util.UUID;

import net.minecraftforge.common.util.ForgeDirection;
import mod.industrialProcessing.power.utils.IMechanicalMotionEmitter;
import mod.industrialProcessing.power.utils.IMechanicalMotionReceiver;
import mod.industrialProcessing.utils.clusters.ClusterBase;

public class ClusterMotion extends ClusterBase<ClusterItemMotion, ClusterMotion> {

	private float speed;

	HashSet<ClusterItemMotion>[] emittorConnections = new HashSet<ClusterItemMotion>[6];
	HashSet<ClusterItemMotion>[] receiverConnections = new HashSet<ClusterItemMotion>[6];
	
	
	public ClusterMotion(UUID id) {
		super(id);
	}

	public void update() {

	}

	public float getSpeed()
	{
		return this.speed;
	}

	public void onEmitterConnected(IMechanicalMotionEmitter emitter, ClusterItemMotion item, ForgeDirection dir) {
		// TODO Auto-generated method stub
		
	}

	public void onReceiverConnected(IMechanicalMotionReceiver receiver, ClusterItemMotion item, ForgeDirection dir) {
		// TODO Auto-generated method stub
		
	}

	public void onEmitterDisconnected(IMechanicalMotionEmitter emitter, ClusterItemMotion item, ForgeDirection dir) {
		// TODO Auto-generated method stub
		
	}

	public void onReceiverDisconnected(IMechanicalMotionReceiver receiver, ClusterItemMotion item, ForgeDirection dir) {
		// TODO Auto-generated method stub
		
	}
	
	// TODO: add torque, set speed

	// TODO: sync speed to client so it can render the rotation in the tile entities
}

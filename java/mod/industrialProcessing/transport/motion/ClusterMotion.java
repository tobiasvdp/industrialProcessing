package mod.industrialProcessing.transport.motion;

import java.util.UUID;

import mod.industrialProcessing.utils.clusters.ClusterBase;

public class ClusterMotion extends ClusterBase<ClusterItemMotion> {

	public ClusterMotion(UUID id) {
		super(id);
	}

	public void update() {

	}

	// TODO: add torque, set speed

	// TODO: sync speed to client so it can render the rotation in the tile entities
}

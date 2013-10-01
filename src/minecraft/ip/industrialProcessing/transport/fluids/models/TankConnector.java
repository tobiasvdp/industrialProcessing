package ip.industrialProcessing.transport.fluids.models;

import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class TankConnector extends ObjMesh {

	public TankConnector() {
		this.quads = new ObjQuad[6];
		this.quads[0] = new ObjQuad(new Vector3f(0.8f, 1.1f, -0.3f), new Vector3f(0.8f, 1.1f, 0.3f), new Vector3f(0.8f, 0.5f, 0.3f), new Vector3f(0.8f, 0.5f, -0.3f), new Vector2f(1.0f, 1.0f), new Vector2f(0.625f, 1.0f), new Vector2f(0.625f, 0.625f), new Vector2f(1.0f, 0.625f), new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.8f, 0.5f, -0.3f), new Vector3f(0.8f, 0.5f, 0.3f), new Vector3f(0.6f, 0.5f, 0.3f), new Vector3f(0.6f, 0.5f, -0.3f), new Vector2f(1.0f, 0.5f), new Vector2f(0.625f, 0.5f), new Vector2f(0.625f, 0.375f), new Vector2f(1.0f, 0.375f), new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.8f, 1.1f, -0.3f), new Vector3f(0.8f, 0.5f, -0.3f), new Vector3f(0.6f, 0.5f, -0.3f), new Vector3f(0.6f, 1.1f, -0.3f), new Vector2f(1.0f, 0.5f), new Vector2f(0.625f, 0.5f), new Vector2f(0.625f, 0.375f), new Vector2f(1.0f, 0.375f), new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.8f, 1.1f, 0.3f), new Vector3f(0.8f, 1.1f, -0.3f), new Vector3f(0.6f, 1.1f, -0.3f), new Vector3f(0.6f, 1.1f, 0.3f), new Vector2f(1.0f, 0.625f), new Vector2f(0.625f, 0.625f), new Vector2f(0.625f, 0.5f), new Vector2f(1.0f, 0.5f), new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.8f, 0.5f, 0.3f), new Vector3f(0.8f, 1.1f, 0.3f), new Vector3f(0.6f, 1.1f, 0.3f), new Vector3f(0.6f, 0.5f, 0.3f), new Vector2f(1.0f, 0.625f), new Vector2f(0.625f, 0.625f), new Vector2f(0.625f, 0.5f), new Vector2f(1.0f, 0.5f), new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[5] = new ObjQuad(new Vector3f(0.6f, 1.1f, -0.3f), new Vector3f(0.6f, 0.5f, -0.3f), new Vector3f(0.6f, 0.5f, 0.3f), new Vector3f(0.6f, 1.1f, 0.3f), new Vector2f(1.0f, 1.0f), new Vector2f(1.0f, 0.625f), new Vector2f(0.625f, 0.625f), new Vector2f(0.625f, 1.0f), new Vector3f(-4.0f, 0.0f, 0.0f));
	}

	protected TankConnector(int quads) {
		this.quads = new ObjQuad[quads];

	}

	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		TankConnector clone = new TankConnector();
		clone.quads = cloneQuads(this.quads, transform);
		return clone;
	}

}

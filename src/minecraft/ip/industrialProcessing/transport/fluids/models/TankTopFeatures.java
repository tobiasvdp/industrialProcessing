package ip.industrialProcessing.transport.fluids.models;

import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class TankTopFeatures extends ObjMesh {

	public TankTopFeatures() {
		this.quads = new ObjQuad[13];
		this.quads[0] = new ObjQuad(new Vector3f(0.3f, 1.4f, 0.6f), new Vector3f(0.3f, 1.4f, 0.7f), new Vector3f(0.3f, 0.0f, 0.7f), new Vector3f(0.3f, -0.0f, 0.6f), new Vector2f(0.375f, 0.125f), new Vector2f(0.4375f, 0.125f), new Vector2f(0.4375f, 1.0f), new Vector2f(0.375f, 1.0f), new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.3f, 1.4f, 0.6f), new Vector3f(-0.2f, 1.3f, 0.6f), new Vector3f(-0.2f, -0.0f, 0.6f), new Vector3f(-0.3f, 0.0f, 0.6f), new Vector2f(0.5625f, 0.125f), new Vector2f(0.625f, 0.1875f), new Vector2f(0.625f, 1.0f), new Vector2f(0.5625f, 1.0f), new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.3f, 1.4f, 0.7f), new Vector3f(0.2f, 1.3f, 0.7f), new Vector3f(0.2f, -0.0f, 0.7f), new Vector3f(0.3f, 0.0f, 0.7f), new Vector2f(0.5625f, 0.125f), new Vector2f(0.625f, 0.1875f), new Vector2f(0.625f, 1.0f), new Vector2f(0.5625f, 1.0f), new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.2f, 1.3f, 0.65f), new Vector3f(-0.2f, 1.3f, 0.65f), new Vector3f(-0.2f, -0.0f, 0.65f), new Vector3f(0.2f, 0.0f, 0.65f), new Vector2f(0.0f, 0.1875f), new Vector2f(0.25f, 0.1875f), new Vector2f(0.25f, 1.0f), new Vector2f(0.0f, 1.0f), new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.2f, 1.3f, 0.6f), new Vector3f(-0.2f, 1.3f, 0.7f), new Vector3f(-0.2f, 0.0f, 0.7f), new Vector3f(-0.2f, -0.0f, 0.6f), new Vector2f(0.375f, 0.1875f), new Vector2f(0.4375f, 0.1875f), new Vector2f(0.4375f, 1.0f), new Vector2f(0.375f, 1.0f), new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.3f, 0.0f, 0.6f), new Vector3f(-0.3f, -0.0f, 0.7f), new Vector3f(-0.3f, 1.4f, 0.7f), new Vector3f(-0.3f, 1.4f, 0.6f), new Vector2f(0.625f, 1.0f), new Vector2f(0.5625f, 1.0f), new Vector2f(0.5625f, 0.125f), new Vector2f(0.625f, 0.125f), new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.3f, 1.4f, 0.6f), new Vector3f(-0.3f, 1.4f, 0.7f), new Vector3f(0.3f, 1.4f, 0.7f), new Vector3f(0.3f, 1.4f, 0.6f), new Vector2f(0.375f, 0.125f), new Vector2f(0.4375f, 0.125f), new Vector2f(0.4375f, 0.5f), new Vector2f(0.375f, 0.5f), new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.3f, 1.4f, 0.7f), new Vector3f(-0.2f, 1.3f, 0.7f), new Vector3f(0.2f, 1.3f, 0.7f), new Vector3f(0.3f, 1.4f, 0.7f), new Vector2f(0.5625f, 0.125f), new Vector2f(0.625f, 0.1875f), new Vector2f(0.625f, 0.4375f), new Vector2f(0.5625f, 0.5f), new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[8] = new ObjQuad(new Vector3f(-0.3f, 1.4f, 0.6f), new Vector3f(0.3f, 1.4f, 0.6f), new Vector3f(0.2f, 1.3f, 0.6f), new Vector3f(-0.2f, 1.3f, 0.6f), new Vector2f(0.4375f, 0.125f), new Vector2f(0.4375f, 0.5f), new Vector2f(0.375f, 0.4375f), new Vector2f(0.375f, 0.1875f), new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[9] = new ObjQuad(new Vector3f(0.2f, 1.3f, 0.6f), new Vector3f(0.2f, 1.3f, 0.7f), new Vector3f(-0.2f, 1.3f, 0.7f), new Vector3f(-0.2f, 1.3f, 0.6f), new Vector2f(0.625f, 0.4375f), new Vector2f(0.5625f, 0.4375f), new Vector2f(0.5625f, 0.1875f), new Vector2f(0.625f, 0.1875f), new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[10] = new ObjQuad(new Vector3f(0.3f, -0.0f, 0.6f), new Vector3f(0.2f, 0.0f, 0.6f), new Vector3f(0.2f, 1.3f, 0.6f), new Vector3f(0.3f, 1.4f, 0.6f), new Vector2f(0.4375f, 1.0f), new Vector2f(0.375f, 1.0f), new Vector2f(0.375f, 0.1875f), new Vector2f(0.4375f, 0.125f), new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[11] = new ObjQuad(new Vector3f(0.2f, 0.0f, 0.6f), new Vector3f(0.2f, -0.0f, 0.7f), new Vector3f(0.2f, 1.3f, 0.7f), new Vector3f(0.2f, 1.3f, 0.6f), new Vector2f(0.625f, 1.0f), new Vector2f(0.5625f, 1.0f), new Vector2f(0.5625f, 0.1875f), new Vector2f(0.625f, 0.1875f), new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[12] = new ObjQuad(new Vector3f(-0.3f, -0.0f, 0.7f), new Vector3f(-0.2f, 0.0f, 0.7f), new Vector3f(-0.2f, 1.3f, 0.7f), new Vector3f(-0.3f, 1.4f, 0.7f), new Vector2f(0.4375f, 1.0f), new Vector2f(0.375f, 1.0f), new Vector2f(0.375f, 0.1875f), new Vector2f(0.4375f, 0.125f), new Vector3f(0.0f, 0.0f, 4.0f));
	}

	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
        TankTopFeatures other = new TankTopFeatures();
        other.quads = cloneQuads(this.quads, transform);
        return other;
	}

}

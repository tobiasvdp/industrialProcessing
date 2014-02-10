package ip.industrialProcessing.decoration.platforms;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

public class HandRailStraight extends ObjMesh {
	public HandRailStraight() {
		this.quads = new ObjQuad[20];
		this.quads[0] = new ObjQuad(new Vector3f(-0.05f, -0.1f, 0.8f),new Vector3f(0.05f, -0.1f, 0.8f),new Vector3f(0.05f, 0.8f, 0.8f),new Vector3f(-0.05f, 0.8f, 0.8f),new Vector2f(-0.0f, 0.0f),new Vector2f(0.0625f, 0.0f),new Vector2f(0.0625f, 0.5625f),new Vector2f(-0.0f, 0.5625f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.05f, -0.1f, 0.8f),new Vector3f(0.05f, -0.0f, 0.7f),new Vector3f(0.05f, 0.8f, 0.7f),new Vector3f(0.05f, 0.8f, 0.8f),new Vector2f(0.0f, 0.0f),new Vector2f(0.0625f, 0.0625f),new Vector2f(0.0625f, 0.5625f),new Vector2f(0.0f, 0.5625f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.05f, -0.0f, 0.7f),new Vector3f(-0.05f, -0.0f, 0.7f),new Vector3f(-0.05f, 0.8f, 0.7f),new Vector3f(0.05f, 0.8f, 0.7f),new Vector2f(0.9375f, 0.0625f),new Vector2f(1.0f, 0.0625f),new Vector2f(1.0f, 0.5625f),new Vector2f(0.9375f, 0.5625f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.05f, -0.0f, 0.7f),new Vector3f(-0.05f, -0.1f, 0.8f),new Vector3f(-0.05f, 0.8f, 0.8f),new Vector3f(-0.05f, 0.8f, 0.7f),new Vector2f(0.9375f, 0.0625f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 0.5625f),new Vector2f(0.9375f, 0.5625f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.05f, -0.1f, 0.8f),new Vector3f(-0.05f, -0.0f, 0.7f),new Vector3f(-0.05f, -0.0f, 0.2875f),new Vector3f(-0.05f, -0.1f, 0.2875f),new Vector2f(1.0f, 0.0f),new Vector2f(0.9375f, 0.0625f),new Vector2f(0.679687f, 0.0625f),new Vector2f(0.679687f, 0.0f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(0.05f, -0.0f, 0.7f),new Vector3f(0.05f, -0.1f, 0.8f),new Vector3f(0.05f, -0.1f, 0.2875f),new Vector3f(0.05f, -0.0f, 0.2875f),new Vector2f(0.0625f, 0.0625f),new Vector2f(0.0f, 0.0f),new Vector2f(0.320313f, 0.0f),new Vector2f(0.320313f, 0.0625f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(0.05f, -0.1f, 0.8f),new Vector3f(-0.05f, -0.1f, 0.8f),new Vector3f(-0.05f, -0.1f, 0.2875f),new Vector3f(0.05f, -0.1f, 0.2875f),new Vector2f(0.9375f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 0.320313f),new Vector2f(0.9375f, 0.320313f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(0.05f, -0.0f, 0.2875f),new Vector3f(0.05f, -0.1f, 0.2875f),new Vector3f(-0.05f, -0.1f, 0.2875f),new Vector3f(-0.05f, -0.0f, 0.2875f),new Vector2f(0.9375f, 0.0625f),new Vector2f(0.9375f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 0.0625f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[8] = new ObjQuad(new Vector3f(0.05f, 1.3f, 0.8f),new Vector3f(-0.05f, 1.3f, 0.8f),new Vector3f(-0.05f, 0.9f, 0.8f),new Vector3f(0.05f, 0.9f, 0.8f),new Vector2f(0.0625f, 0.875f),new Vector2f(-0.0f, 0.875f),new Vector2f(-0.0f, 0.625f),new Vector2f(0.0625f, 0.625f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[9] = new ObjQuad(new Vector3f(0.05f, 1.3f, 0.7f),new Vector3f(0.05f, 1.3f, 0.8f),new Vector3f(0.05f, 0.9f, 0.8f),new Vector3f(0.05f, 0.9f, 0.7f),new Vector2f(0.0625f, 0.875f),new Vector2f(0.0f, 0.875f),new Vector2f(0.0f, 0.625f),new Vector2f(0.0625f, 0.625f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[10] = new ObjQuad(new Vector3f(-0.05f, 1.3f, 0.7f),new Vector3f(0.05f, 1.3f, 0.7f),new Vector3f(0.05f, 0.9f, 0.7f),new Vector3f(-0.05f, 0.9f, 0.7f),new Vector2f(1.0f, 0.875f),new Vector2f(0.9375f, 0.875f),new Vector2f(0.9375f, 0.625f),new Vector2f(1.0f, 0.625f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[11] = new ObjQuad(new Vector3f(-0.05f, 1.3f, 0.8f),new Vector3f(-0.05f, 1.3f, 0.7f),new Vector3f(-0.05f, 0.9f, 0.7f),new Vector3f(-0.05f, 0.9f, 0.8f),new Vector2f(1.0f, 0.875f),new Vector2f(0.9375f, 0.875f),new Vector2f(0.9375f, 0.625f),new Vector2f(1.0f, 0.625f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[12] = new ObjQuad(new Vector3f(0.6f, 0.9f, 0.7f),new Vector3f(0.6f, 0.8f, 0.7f),new Vector3f(-0.6f, 0.8f, 0.7f),new Vector3f(-0.6f, 0.9f, 0.7f),new Vector2f(0.125f, 0.0625f),new Vector2f(0.125f, 0.0f),new Vector2f(0.875f, 0.0f),new Vector2f(0.875f, 0.0625f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[13] = new ObjQuad(new Vector3f(0.6f, 0.8f, 0.8f),new Vector3f(0.6f, 0.9f, 0.8f),new Vector3f(-0.6f, 0.9f, 0.8f),new Vector3f(-0.6f, 0.8f, 0.8f),new Vector2f(0.875f, 0.0f),new Vector2f(0.875f, 0.0625f),new Vector2f(0.125f, 0.0625f),new Vector2f(0.125f, 0.0f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[14] = new ObjQuad(new Vector3f(0.6f, 0.8f, 0.7f),new Vector3f(0.6f, 0.8f, 0.8f),new Vector3f(-0.6f, 0.8f, 0.8f),new Vector3f(-0.6f, 0.8f, 0.7f),new Vector2f(0.125f, 0.0625f),new Vector2f(0.125f, -0.0f),new Vector2f(0.875f, 0.0f),new Vector2f(0.875f, 0.0625f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[15] = new ObjQuad(new Vector3f(0.6f, 1.4f, 0.7f),new Vector3f(0.6f, 1.3f, 0.7f),new Vector3f(-0.6f, 1.3f, 0.7f),new Vector3f(-0.6f, 1.4f, 0.7f),new Vector2f(0.125f, 1.0f),new Vector2f(0.125f, 0.9375f),new Vector2f(0.875f, 0.9375f),new Vector2f(0.875f, 1.0f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[16] = new ObjQuad(new Vector3f(0.6f, 1.3f, 0.8f),new Vector3f(0.6f, 1.4f, 0.8f),new Vector3f(-0.6f, 1.4f, 0.8f),new Vector3f(-0.6f, 1.3f, 0.8f),new Vector2f(0.875f, 0.9375f),new Vector2f(0.875f, 1.0f),new Vector2f(0.125f, 1.0f),new Vector2f(0.125f, 0.9375f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[17] = new ObjQuad(new Vector3f(0.6f, 1.3f, 0.7f),new Vector3f(0.6f, 1.3f, 0.8f),new Vector3f(-0.6f, 1.3f, 0.8f),new Vector3f(-0.6f, 1.3f, 0.7f),new Vector2f(0.125f, 0.0625f),new Vector2f(0.125f, -0.0f),new Vector2f(0.875f, 0.0f),new Vector2f(0.875f, 0.0625f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[18] = new ObjQuad(new Vector3f(-0.6f, 0.9f, 0.7f),new Vector3f(-0.6f, 0.9f, 0.8f),new Vector3f(0.6f, 0.9f, 0.8f),new Vector3f(0.6f, 0.9f, 0.7f),new Vector2f(0.125f, 0.0625f),new Vector2f(0.125f, 0.0f),new Vector2f(0.875f, -0.0f),new Vector2f(0.875f, 0.0625f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[19] = new ObjQuad(new Vector3f(-0.6f, 1.4f, 0.7f),new Vector3f(-0.6f, 1.4f, 0.8f),new Vector3f(0.6f, 1.4f, 0.8f),new Vector3f(0.6f, 1.4f, 0.7f),new Vector2f(0.125f, 0.0625f),new Vector2f(0.125f, 0.0f),new Vector2f(0.875f, -0.0f),new Vector2f(0.875f, 0.0625f),new Vector3f(0.0f, 4.0f, 0.0f));
}

	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		HandRailStraight other = new HandRailStraight();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

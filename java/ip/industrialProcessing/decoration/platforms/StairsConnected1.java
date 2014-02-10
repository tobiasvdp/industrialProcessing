package ip.industrialProcessing.decoration.platforms;

import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class StairsConnected1 extends ObjMesh {

	public StairsConnected1() {
		this.quads = new ObjQuad[8];
		this.quads[0] = new ObjQuad(new Vector3f(0.8f, 1.6f, -0.8f), new Vector3f(0.8f, 1.6f, 0.0f), new Vector3f(0.6f, 1.6f, -0.0f), new Vector3f(0.6f, 1.6f, -0.8f), new Vector2f(0.4375f, 0.5f), new Vector2f(0.4375f, -0.0f), new Vector2f(0.5625f, -0.0f), new Vector2f(0.5625f, 0.5f), new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.8f, 1.7f, 0.0f), new Vector3f(0.8f, 1.7f, -0.8f), new Vector3f(0.6f, 1.7f, -0.8f), new Vector3f(0.6f, 1.7f, -0.0f), new Vector2f(0.5625f, -0.0f), new Vector2f(0.5625f, 0.5f), new Vector2f(0.4375f, 0.5f), new Vector2f(0.4375f, -0.0f), new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.8f, 1.6f, 0.0f), new Vector3f(0.8f, 1.7f, 0.0f), new Vector3f(0.6f, 1.7f, -0.0f), new Vector3f(0.6f, 1.6f, -0.0f), new Vector2f(0.5625f, 0.9375f), new Vector2f(0.5625f, 1.0f), new Vector2f(0.4375f, 1.0f), new Vector2f(0.4375f, 0.9375f), new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.8f, 0.8f, 0.0f), new Vector3f(0.8f, 0.8f, 0.8f), new Vector3f(0.6f, 0.8f, 0.8f), new Vector3f(0.6f, 0.8f, -0.0f), new Vector2f(0.4375f, 0.5f), new Vector2f(0.4375f, -0.0f), new Vector2f(0.5625f, -0.0f), new Vector2f(0.5625f, 0.5f), new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.8f, 0.9f, 0.8f), new Vector3f(0.8f, 0.9f, 0.0f), new Vector3f(0.6f, 0.9f, -0.0f), new Vector3f(0.6f, 0.9f, 0.8f), new Vector2f(0.5625f, -0.0f), new Vector2f(0.5625f, 0.5f), new Vector2f(0.4375f, 0.5f), new Vector2f(0.4375f, -0.0f), new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(0.8f, 0.8f, 0.8f), new Vector3f(0.8f, 0.9f, 0.8f), new Vector3f(0.6f, 0.9f, 0.8f), new Vector3f(0.6f, 0.8f, 0.8f), new Vector2f(0.5625f, 0.9375f), new Vector2f(0.5625f, 1.0f), new Vector2f(0.4375f, 1.0f), new Vector2f(0.4375f, 0.9375f), new Vector3f(0.0f, 4.0E-6f, 4.0f));
		this.quads[6] = new ObjQuad(new Vector3f(0.6f, 1.6f, -0.8f), new Vector3f(0.6f, 1.7f, -0.8f), new Vector3f(0.8f, 1.7f, -0.8f), new Vector3f(0.8f, 1.6f, -0.8f), new Vector2f(0.5625f, 0.75f), new Vector2f(0.5625f, 0.8125f), new Vector2f(0.4375f, 0.8125f), new Vector2f(0.4375f, 0.75f), new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[7] = new ObjQuad(new Vector3f(0.6f, 0.8f, -0.0f), new Vector3f(0.6f, 0.9f, -0.0f), new Vector3f(0.8f, 0.9f, 0.0f), new Vector3f(0.8f, 0.8f, 0.0f), new Vector2f(0.5625f, 0.75f), new Vector2f(0.5625f, 0.8125f), new Vector2f(0.4375f, 0.8125f), new Vector2f(0.4375f, 0.75f), new Vector3f(0.0f, 0.0f, -4.0f));
	}

	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		StairsConnected1 other = new StairsConnected1();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}

}

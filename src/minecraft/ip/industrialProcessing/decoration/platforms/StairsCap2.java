package ip.industrialProcessing.decoration.platforms;

import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class StairsCap2 extends ObjMesh {

	public StairsCap2() {
		this.quads = new ObjQuad[10];
		this.quads[0] = new ObjQuad(new Vector3f(-0.7f, 1.6f, -0.8f),new Vector3f(-0.6f, 1.6f, -0.8f),new Vector3f(-0.6f, 1.6f, -0.0f),new Vector3f(-0.7f, 1.6f, -0.0f),new Vector2f(1.0f, 0.5f),new Vector2f(0.9375f, 0.5f),new Vector2f(0.9375f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.6f, 1.7f, -0.0f),new Vector3f(-0.6f, 1.7f, -0.8f),new Vector3f(-0.7f, 1.7f, -0.8f),new Vector3f(-0.7f, 1.7f, -0.0f),new Vector2f(0.0625f, 0.0f),new Vector2f(0.0625f, 0.5f),new Vector2f(0.0f, 0.5f),new Vector2f(-0.0f, 0.0f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.6f, 1.6f, -0.0f),new Vector3f(-0.6f, 1.7f, -0.0f),new Vector3f(-0.7f, 1.7f, -0.0f),new Vector3f(-0.7f, 1.6f, -0.0f),new Vector2f(0.0625f, 0.9375f),new Vector2f(0.0625f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector2f(0.0f, 0.9375f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.7f, 1.7f, -0.0f),new Vector3f(-0.7f, 1.7f, -0.8f),new Vector3f(-0.7f, 1.6f, -0.8f),new Vector3f(-0.7f, 1.6f, -0.0f),new Vector2f(1.0f, 1.0f),new Vector2f(0.5f, 1.0f),new Vector2f(0.5f, 0.9375f),new Vector2f(1.0f, 0.9375f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.7f, 1.6f, -0.8f),new Vector3f(-0.7f, 1.7f, -0.8f),new Vector3f(-0.6f, 1.7f, -0.8f),new Vector3f(-0.6f, 1.6f, -0.8f),new Vector2f(1.0f, 0.75f),new Vector2f(1.0f, 0.8125f),new Vector2f(0.9375f, 0.8125f),new Vector2f(0.9375f, 0.75f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.7f, 0.8f, -0.0f),new Vector3f(-0.6f, 0.8f, -0.0f),new Vector3f(-0.6f, 0.8f, 0.8f),new Vector3f(-0.7f, 0.8f, 0.8f),new Vector2f(1.0f, 0.5f),new Vector2f(0.9375f, 0.5f),new Vector2f(0.9375f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.6f, 0.9f, 0.8f),new Vector3f(-0.6f, 0.9f, -0.0f),new Vector3f(-0.7f, 0.9f, -0.0f),new Vector3f(-0.7f, 0.9f, 0.8f),new Vector2f(0.0625f, 0.0f),new Vector2f(0.0625f, 0.5f),new Vector2f(0.0f, 0.5f),new Vector2f(-0.0f, 0.0f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.6f, 0.8f, 0.8f),new Vector3f(-0.6f, 0.9f, 0.8f),new Vector3f(-0.7f, 0.9f, 0.8f),new Vector3f(-0.7f, 0.8f, 0.8f),new Vector2f(0.0625f, 0.9375f),new Vector2f(0.0625f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector2f(0.0f, 0.9375f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[8] = new ObjQuad(new Vector3f(-0.7f, 0.9f, 0.8f),new Vector3f(-0.7f, 0.9f, -0.0f),new Vector3f(-0.7f, 0.8f, -0.0f),new Vector3f(-0.7f, 0.8f, 0.8f),new Vector2f(1.0f, 1.0f),new Vector2f(0.5f, 1.0f),new Vector2f(0.5f, 0.9375f),new Vector2f(1.0f, 0.9375f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[9] = new ObjQuad(new Vector3f(-0.7f, 0.8f, -0.0f),new Vector3f(-0.7f, 0.9f, -0.0f),new Vector3f(-0.6f, 0.9f, -0.0f),new Vector3f(-0.6f, 0.8f, -0.0f),new Vector2f(1.0f, 0.75f),new Vector2f(1.0f, 0.8125f),new Vector2f(0.9375f, 0.8125f),new Vector2f(0.9375f, 0.75f),new Vector3f(0.0f, 0.0f, -4.0f));
}

	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		StairsCap2 other = new StairsCap2();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}

}

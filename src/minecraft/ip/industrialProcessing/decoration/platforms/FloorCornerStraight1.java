package ip.industrialProcessing.decoration.platforms;

import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class FloorCornerStraight1 extends ObjMesh {
	public FloorCornerStraight1() {
		this.quads = new ObjQuad[3];
		this.quads[0] = new ObjQuad(new Vector3f(0.6f, 0.0f, 0.6f), new Vector3f(0.7f, 0.0f, 0.6f), new Vector3f(0.7f, -0.0f, 0.8f), new Vector3f(0.6f, -0.0f, 0.8f), new Vector2f(0.0f, -0.0f), new Vector2f(0.0625f, -0.0f), new Vector2f(0.0625f, 0.125f), new Vector2f(0.0f, 0.125f), new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.7f, 0.0f, 0.6f), new Vector3f(0.7f, 0.1f, 0.6f), new Vector3f(0.7f, 0.1f, 0.8f), new Vector3f(0.7f, -0.0f, 0.8f), new Vector2f(0.9375f, -0.0f), new Vector2f(1.0f, -0.0f), new Vector2f(1.0f, 0.125f), new Vector2f(0.9375f, 0.125f), new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.7f, 0.1f, 0.6f), new Vector3f(0.6f, 0.1f, 0.6f), new Vector3f(0.6f, 0.1f, 0.8f), new Vector3f(0.7f, 0.1f, 0.8f), new Vector2f(0.9375f, -0.0f), new Vector2f(1.0f, -0.0f), new Vector2f(1.0f, 0.125f), new Vector2f(0.9375f, 0.125f), new Vector3f(0.0f, 4.0f, 0.0f));
	}

	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		FloorCornerStraight1 other = new FloorCornerStraight1();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

package ip.industrialProcessing.decoration.platforms;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

public class FloorCornerFull extends ObjMesh {
	public FloorCornerFull() {
		this.quads = new ObjQuad[2];
		this.quads[0] = new ObjQuad(new Vector3f(0.6f, 0.1f, 0.8f), new Vector3f(0.8f, 0.1f, 0.8f), new Vector3f(0.8f, 0.1f, 0.6f), new Vector3f(0.6f, 0.1f, 0.6f), new Vector2f(0.0625f, 0.8125f), new Vector2f(0.1875f, 0.8125f), new Vector2f(0.1875f, 0.9375f), new Vector2f(0.0625f, 0.9375f), new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.6f, -0.0f, 0.8f), new Vector3f(0.6f, -0.0f, 0.6f), new Vector3f(0.8f, -0.0f, 0.6f), new Vector3f(0.8f, -0.0f, 0.8f), new Vector2f(0.9375f, 0.8125f), new Vector2f(0.9375f, 0.9375f), new Vector2f(0.8125f, 0.9375f), new Vector2f(0.8125f, 0.8125f), new Vector3f(0.0f, -4.0f, 0.0f));
	}

	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		FloorCornerFull other = new FloorCornerFull();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

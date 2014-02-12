package mod.industrialProcessing.blocks.platforms;

import mod.industrialProcessing.client.rendering.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class FloorCornerOutside extends ObjMesh {
	public FloorCornerOutside() {
		this.quads = new ObjQuad[4];
		this.quads[0] = new ObjQuad(new Vector3f(0.6f, 0.0f, 0.7f),new Vector3f(0.7f, 0.0f, 0.7f),new Vector3f(0.7f, 0.1f, 0.7f),new Vector3f(0.6f, 0.1f, 0.7f),new Vector2f(0.9375f, 0.9375f),new Vector2f(1.0f, 0.9375f),new Vector2f(1.0f, 1.0f),new Vector2f(0.9375f, 1.0f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.6f, 0.1f, 0.7f),new Vector3f(0.7f, 0.1f, 0.7f),new Vector3f(0.7f, 0.1f, 0.6f),new Vector3f(0.6f, 0.1f, 0.6f),new Vector2f(0.0625f, 1.0f),new Vector2f(-0.0f, 1.0f),new Vector2f(-0.0f, 0.9375f),new Vector2f(0.0625f, 0.9375f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.7f, 0.0f, 0.7f),new Vector3f(0.6f, 0.0f, 0.7f),new Vector3f(0.6f, 0.0f, 0.6f),new Vector3f(0.7f, 0.0f, 0.6f),new Vector2f(1.0f, 1.0f),new Vector2f(0.9375f, 1.0f),new Vector2f(0.9375f, 0.9375f),new Vector2f(1.0f, 0.9375f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.7f, 0.1f, 0.7f),new Vector3f(0.7f, 0.0f, 0.7f),new Vector3f(0.7f, 0.0f, 0.6f),new Vector3f(0.7f, 0.1f, 0.6f),new Vector2f(1.0f, 1.0f),new Vector2f(0.9375f, 1.0f),new Vector2f(0.9375f, 0.9375f),new Vector2f(1.0f, 0.9375f),new Vector3f(4.0f, 0.0f, 0.0f));
	}

	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		FloorCornerOutside other = new FloorCornerOutside();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

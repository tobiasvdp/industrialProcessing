package mod.industrialProcessing.block.platforms;

import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class HandRailCornerInside extends ObjMesh {
	public HandRailCornerInside() {
		this.quads = new ObjQuad[8];
		this.quads[0] = new ObjQuad(new Vector3f(0.8f, 0.8f, 0.7f), new Vector3f(0.7f, 0.8f, 0.7f), new Vector3f(0.7f, 0.9f, 0.7f), new Vector3f(0.8f, 0.9f, 0.7f), new Vector2f(0.9375f, 0.9375f), new Vector2f(1.0f, 0.9375f), new Vector2f(1.0f, 1.0f), new Vector2f(0.9375f, 1.0f), new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.8f, 0.9f, 0.7f), new Vector3f(0.7f, 0.9f, 0.7f), new Vector3f(0.7f, 0.9f, 0.8f), new Vector3f(0.8f, 0.9f, 0.8f), new Vector2f(0.0625f, 1.0f), new Vector2f(-0.0f, 1.0f), new Vector2f(-0.0f, 0.9375f), new Vector2f(0.0625f, 0.9375f), new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.7f, 0.8f, 0.7f), new Vector3f(0.8f, 0.8f, 0.7f), new Vector3f(0.8f, 0.8f, 0.8f), new Vector3f(0.7f, 0.8f, 0.8f), new Vector2f(1.0f, 1.0f), new Vector2f(0.9375f, 1.0f), new Vector2f(0.9375f, 0.9375f), new Vector2f(1.0f, 0.9375f), new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.7f, 0.9f, 0.7f), new Vector3f(0.7f, 0.8f, 0.7f), new Vector3f(0.7f, 0.8f, 0.8f), new Vector3f(0.7f, 0.9f, 0.8f), new Vector2f(1.0f, 1.0f), new Vector2f(0.9375f, 1.0f), new Vector2f(0.9375f, 0.9375f), new Vector2f(1.0f, 0.9375f), new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.8f, 1.3f, 0.7f), new Vector3f(0.7f, 1.3f, 0.7f), new Vector3f(0.7f, 1.4f, 0.7f), new Vector3f(0.8f, 1.4f, 0.7f), new Vector2f(0.9375f, 0.9375f), new Vector2f(1.0f, 0.9375f), new Vector2f(1.0f, 1.0f), new Vector2f(0.9375f, 1.0f), new Vector3f(3.0E-6f, -3.0E-6f, -4.0f));
		this.quads[5] = new ObjQuad(new Vector3f(0.8f, 1.4f, 0.7f), new Vector3f(0.7f, 1.4f, 0.7f), new Vector3f(0.7f, 1.4f, 0.8f), new Vector3f(0.8f, 1.4f, 0.8f), new Vector2f(0.0625f, 1.0f), new Vector2f(-0.0f, 1.0f), new Vector2f(-0.0f, 0.9375f), new Vector2f(0.0625f, 0.9375f), new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(0.7f, 1.3f, 0.7f), new Vector3f(0.8f, 1.3f, 0.7f), new Vector3f(0.8f, 1.3f, 0.8f), new Vector3f(0.7f, 1.3f, 0.8f), new Vector2f(1.0f, 1.0f), new Vector2f(0.9375f, 1.0f), new Vector2f(0.9375f, 0.9375f), new Vector2f(1.0f, 0.9375f), new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(0.7f, 1.4f, 0.7f), new Vector3f(0.7f, 1.3f, 0.7f), new Vector3f(0.7f, 1.3f, 0.8f), new Vector3f(0.7f, 1.4f, 0.8f), new Vector2f(1.0f, 1.0f), new Vector2f(0.9375f, 1.0f), new Vector2f(0.9375f, 0.9375f), new Vector2f(1.0f, 0.9375f), new Vector3f(-4.0f, 0.0f, 0.0f));
	}

	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		HandRailCornerInside other = new HandRailCornerInside();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

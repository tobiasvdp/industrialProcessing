package mod.industrialProcessing.block.platforms;

import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class HandRailCornerStraight2 extends ObjMesh {
	public HandRailCornerStraight2() {
		this.quads = new ObjQuad[8];
		this.quads[0] = new ObjQuad(new Vector3f(0.8f, 0.8f, 0.7f),new Vector3f(0.8f, 0.8f, 0.8f),new Vector3f(0.6f, 0.8f, 0.8f),new Vector3f(0.6f, 0.8f, 0.7f),new Vector2f(0.0f, -0.0f),new Vector2f(0.0625f, -0.0f),new Vector2f(0.0625f, 0.125f),new Vector2f(0.0f, 0.125f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.8f, 0.8f, 0.8f),new Vector3f(0.8f, 0.9f, 0.8f),new Vector3f(0.6f, 0.9f, 0.8f),new Vector3f(0.6f, 0.8f, 0.8f),new Vector2f(0.9375f, -0.0f),new Vector2f(1.0f, -0.0f),new Vector2f(1.0f, 0.125f),new Vector2f(0.9375f, 0.125f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.8f, 0.9f, 0.8f),new Vector3f(0.8f, 0.9f, 0.7f),new Vector3f(0.6f, 0.9f, 0.7f),new Vector3f(0.6f, 0.9f, 0.8f),new Vector2f(0.9375f, -0.0f),new Vector2f(1.0f, -0.0f),new Vector2f(1.0f, 0.125f),new Vector2f(0.9375f, 0.125f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.6f, 0.8f, 0.7f),new Vector3f(0.6f, 0.9f, 0.7f),new Vector3f(0.8f, 0.9f, 0.7f),new Vector3f(0.8f, 0.8f, 0.7f),new Vector2f(0.0625f, 0.125f),new Vector2f(0.0f, 0.125f),new Vector2f(0.0f, -0.0f),new Vector2f(0.0625f, -0.0f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.8f, 1.3f, 0.7f),new Vector3f(0.8f, 1.3f, 0.8f),new Vector3f(0.6f, 1.3f, 0.8f),new Vector3f(0.6f, 1.3f, 0.7f),new Vector2f(0.0f, -0.0f),new Vector2f(0.0625f, -0.0f),new Vector2f(0.0625f, 0.125f),new Vector2f(0.0f, 0.125f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(0.8f, 1.3f, 0.8f),new Vector3f(0.8f, 1.4f, 0.8f),new Vector3f(0.6f, 1.4f, 0.8f),new Vector3f(0.6f, 1.3f, 0.8f),new Vector2f(0.9375f, -0.0f),new Vector2f(1.0f, -0.0f),new Vector2f(1.0f, 0.125f),new Vector2f(0.9375f, 0.125f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[6] = new ObjQuad(new Vector3f(0.8f, 1.4f, 0.8f),new Vector3f(0.8f, 1.4f, 0.7f),new Vector3f(0.6f, 1.4f, 0.7f),new Vector3f(0.6f, 1.4f, 0.8f),new Vector2f(0.9375f, -0.0f),new Vector2f(1.0f, -0.0f),new Vector2f(1.0f, 0.125f),new Vector2f(0.9375f, 0.125f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(0.6f, 1.3f, 0.7f),new Vector3f(0.6f, 1.4f, 0.7f),new Vector3f(0.8f, 1.4f, 0.7f),new Vector3f(0.8f, 1.3f, 0.7f),new Vector2f(0.0625f, 0.125f),new Vector2f(0.0f, 0.125f),new Vector2f(0.0f, -0.0f),new Vector2f(0.0625f, -0.0f),new Vector3f(0.0f, 0.0f, -4.0f));
	}

	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		HandRailCornerStraight2 other = new HandRailCornerStraight2();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

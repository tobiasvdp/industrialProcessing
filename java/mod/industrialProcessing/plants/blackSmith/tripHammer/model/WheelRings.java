package mod.industrialProcessing.plants.blackSmith.tripHammer.model;

import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class WheelRings extends ObjMesh {
	public WheelRings() {
		this.quads = new ObjQuad[18];
		this.quads[0] = new ObjQuad(new Vector3f(0.65f, 0.85f, -1.1f), new Vector3f(0.65f, 0.65f, -1.1f), new Vector3f(0.2167f, 0.65f, -1.1f), new Vector3f(0.2167f, 0.85f, -1.1f), new Vector2f(0.0937f, 0.5625f), new Vector2f(0.0937f, 0.4375f), new Vector2f(0.3646f, 0.4375f), new Vector2f(0.3646f, 0.5625f), new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.65f, 0.65f, -1.1f), new Vector3f(-0.65f, 0.85f, -1.1f), new Vector3f(-0.2167f, 0.85f, -1.1f), new Vector3f(-0.2167f, 0.65f, -1.1f), new Vector2f(0.9062f, 0.4375f), new Vector2f(0.9062f, 0.5625f), new Vector2f(0.6354f, 0.5625f), new Vector2f(0.6354f, 0.4375f), new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.65f, 0.5f, -0.5f), new Vector3f(0.65f, 0.5f, -0.95f), new Vector3f(0.65f, 0.65f, -1.1f), new Vector3f(0.65f, 1.0f, -0.5f), new Vector2f(0.3125f, 0.3438f), new Vector2f(0.5937f, 0.3438f), new Vector2f(0.6875f, 0.4375f), new Vector2f(0.3125f, 0.6563f), new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.65f, 0.65f, -1.1f), new Vector3f(0.65f, 0.85f, -1.1f), new Vector3f(0.65f, 1.0f, -0.95f), new Vector3f(0.65f, 1.0f, -0.5f), new Vector2f(0.6875f, 0.4375f), new Vector2f(0.6875f, 0.5625f), new Vector2f(0.5937f, 0.6563f), new Vector2f(0.3125f, 0.6563f), new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.65f, 0.5f, -0.5f), new Vector3f(0.2167f, 0.5f, -0.5f), new Vector3f(0.2167f, 0.5f, -0.95f), new Vector3f(0.65f, 0.5f, -0.95f), new Vector2f(0.0938f, 0.3125f), new Vector2f(0.3646f, 0.3125f), new Vector2f(0.3646f, 0.5937f), new Vector2f(0.0938f, 0.5937f), new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(0.2167f, 1.0f, -0.5f), new Vector3f(0.2167f, 1.0f, -0.95f), new Vector3f(0.2167f, 0.85f, -1.1f), new Vector3f(0.2167f, 0.5f, -0.5f), new Vector2f(0.6875f, 0.6563f), new Vector2f(0.4063f, 0.6563f), new Vector2f(0.3125f, 0.5625f), new Vector2f(0.6875f, 0.3438f), new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(0.2167f, 0.85f, -1.1f), new Vector3f(0.2167f, 0.65f, -1.1f), new Vector3f(0.2167f, 0.5f, -0.95f), new Vector3f(0.2167f, 0.5f, -0.5f), new Vector2f(0.3125f, 0.5625f), new Vector2f(0.3125f, 0.4375f), new Vector2f(0.4063f, 0.3438f), new Vector2f(0.6875f, 0.3438f), new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(0.2167f, 1.0f, -0.5f), new Vector3f(0.65f, 1.0f, -0.5f), new Vector3f(0.65f, 1.0f, -0.95f), new Vector3f(0.2167f, 1.0f, -0.95f), new Vector2f(0.6354f, 0.3125f), new Vector2f(0.9062f, 0.3125f), new Vector2f(0.9063f, 0.5937f), new Vector2f(0.6354f, 0.5937f), new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(-0.65f, 1.0f, -0.5f), new Vector3f(-0.65f, 1.0f, -0.95f), new Vector3f(-0.65f, 0.85f, -1.1f), new Vector3f(-0.65f, 0.5f, -0.5f), new Vector2f(0.6875f, 0.6563f), new Vector2f(0.4062f, 0.6563f), new Vector2f(0.3125f, 0.5625f), new Vector2f(0.6875f, 0.3438f), new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[9] = new ObjQuad(new Vector3f(-0.65f, 0.85f, -1.1f), new Vector3f(-0.65f, 0.65f, -1.1f), new Vector3f(-0.65f, 0.5f, -0.95f), new Vector3f(-0.65f, 0.5f, -0.5f), new Vector2f(0.3125f, 0.5625f), new Vector2f(0.3125f, 0.4375f), new Vector2f(0.4062f, 0.3438f), new Vector2f(0.6875f, 0.3438f), new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[10] = new ObjQuad(new Vector3f(-0.65f, 1.0f, -0.5f), new Vector3f(-0.2167f, 1.0f, -0.5f), new Vector3f(-0.2167f, 1.0f, -0.95f), new Vector3f(-0.65f, 1.0f, -0.95f), new Vector2f(0.0937f, 0.3125f), new Vector2f(0.3646f, 0.3125f), new Vector2f(0.3646f, 0.5938f), new Vector2f(0.0938f, 0.5938f), new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[11] = new ObjQuad(new Vector3f(-0.2167f, 0.5f, -0.5f), new Vector3f(-0.2167f, 0.5f, -0.95f), new Vector3f(-0.2167f, 0.65f, -1.1f), new Vector3f(-0.2167f, 1.0f, -0.5f), new Vector2f(0.3125f, 0.3438f), new Vector2f(0.5938f, 0.3438f), new Vector2f(0.6875f, 0.4375f), new Vector2f(0.3125f, 0.6563f), new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[12] = new ObjQuad(new Vector3f(-0.2167f, 0.65f, -1.1f), new Vector3f(-0.2167f, 0.85f, -1.1f), new Vector3f(-0.2167f, 1.0f, -0.95f), new Vector3f(-0.2167f, 1.0f, -0.5f), new Vector2f(0.6875f, 0.4375f), new Vector2f(0.6875f, 0.5625f), new Vector2f(0.5938f, 0.6563f), new Vector2f(0.3125f, 0.6563f), new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[13] = new ObjQuad(new Vector3f(-0.2167f, 0.5f, -0.5f), new Vector3f(-0.65f, 0.5f, -0.5f), new Vector3f(-0.65f, 0.5f, -0.95f), new Vector3f(-0.2167f, 0.5f, -0.95f), new Vector2f(0.6354f, 0.3125f), new Vector2f(0.9063f, 0.3125f), new Vector2f(0.9063f, 0.5938f), new Vector2f(0.6354f, 0.5938f), new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[14] = new ObjQuad(new Vector3f(0.65f, 0.65f, -1.1f), new Vector3f(0.65f, 0.5f, -0.95f), new Vector3f(0.2167f, 0.5f, -0.95f), new Vector3f(0.2167f, 0.65f, -1.1f), new Vector2f(0.0937f, 0.4375f), new Vector2f(0.0938f, 0.3438f), new Vector2f(0.3646f, 0.3438f), new Vector2f(0.3646f, 0.4375f), new Vector3f(0.0f, -2.8284f, -2.8284f));
		this.quads[15] = new ObjQuad(new Vector3f(0.2167f, 0.85f, -1.1f), new Vector3f(0.2167f, 1.0f, -0.95f), new Vector3f(0.65f, 1.0f, -0.95f), new Vector3f(0.65f, 0.85f, -1.1f), new Vector2f(0.3646f, 0.5625f), new Vector2f(0.3646f, 0.6563f), new Vector2f(0.0938f, 0.6563f), new Vector2f(0.0937f, 0.5625f), new Vector3f(0.0f, 2.8284f, -2.8284f));
		this.quads[16] = new ObjQuad(new Vector3f(-0.65f, 0.85f, -1.1f), new Vector3f(-0.65f, 1.0f, -0.95f), new Vector3f(-0.2167f, 1.0f, -0.95f), new Vector3f(-0.2167f, 0.85f, -1.1f), new Vector2f(0.9062f, 0.5625f), new Vector2f(0.9063f, 0.6563f), new Vector2f(0.6354f, 0.6563f), new Vector2f(0.6354f, 0.5625f), new Vector3f(0.0f, 2.8284f, -2.8284f));
		this.quads[17] = new ObjQuad(new Vector3f(-0.2167f, 0.65f, -1.1f), new Vector3f(-0.2167f, 0.5f, -0.95f), new Vector3f(-0.65f, 0.5f, -0.95f), new Vector3f(-0.65f, 0.65f, -1.1f), new Vector2f(0.6354f, 0.4375f), new Vector2f(0.6354f, 0.3438f), new Vector2f(0.9063f, 0.3438f), new Vector2f(0.9062f, 0.4375f), new Vector3f(0.0f, -2.8284f, -2.8284f));
	}

	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		WheelRings other = new WheelRings();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

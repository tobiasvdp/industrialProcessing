package mod.industrialProcessing.plants.middleAge.tripHammer.model;

import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class Foot extends ObjMesh {
	public Foot() {
		this.quads = new ObjQuad[24];
		this.quads[0] = new ObjQuad(new Vector3f(-0.65f, 0.0f, 0.5f), new Vector3f(-0.65f, 0.0f, -0.5f), new Vector3f(0.65f, 0.0f, -0.5f), new Vector3f(0.65f, 0.0f, 0.5f), new Vector2f(0.9063f, 0.1875f), new Vector2f(0.9062f, 0.8125f), new Vector2f(0.0937f, 0.8125f), new Vector2f(0.0938f, 0.1875f), new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.65f, 0.0f, 0.5f), new Vector3f(0.65f, 0.0f, 0.5f), new Vector3f(0.65f, 1.5f, 0.5f), new Vector3f(-0.65f, 1.5f, 0.5f), new Vector2f(0.0937f, 0.0f), new Vector2f(0.9062f, 0.0f), new Vector2f(0.9062f, 0.9375f), new Vector2f(0.0937f, 0.9375f), new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.65f, 0.0f, 0.5f), new Vector3f(0.65f, 0.0f, -0.5f), new Vector3f(0.65f, 0.5f, -0.5f), new Vector3f(0.65f, 1.0f, -0.5f), new Vector2f(0.1875f, 0.0f), new Vector2f(0.8125f, 0.0f), new Vector2f(0.8125f, 0.3125f), new Vector2f(0.8125f, 0.625f), new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.65f, 0.0f, 0.5f), new Vector3f(0.65f, 1.0f, -0.5f), new Vector3f(0.65f, 1.5f, -0.5f), new Vector3f(0.65f, 1.5f, -0.0f), new Vector2f(0.1875f, 0.0f), new Vector2f(0.8125f, 0.625f), new Vector2f(0.8125f, 0.9375f), new Vector2f(0.5f, 0.9375f), new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.65f, 0.0f, 0.5f), new Vector3f(0.65f, 1.5f, -0.0f), new Vector3f(0.65f, 1.5f, 0.5f), new Vector2f(0.1875f, 0.0f), new Vector2f(0.5f, 0.9375f), new Vector2f(0.1875f, 0.9375f), new Vector3f(3.0f, 0.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(0.2167f, 1.0f, -0.5f), new Vector3f(0.2167f, 0.5f, -0.5f), new Vector3f(-0.2167f, 0.5f, -0.5f), new Vector3f(-0.2167f, 1.0f, -0.5f), new Vector2f(0.3646f, 0.625f), new Vector2f(0.3646f, 0.3125f), new Vector2f(0.6354f, 0.3125f), new Vector2f(0.6354f, 0.625f), new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.65f, 0.0f, -0.5f), new Vector3f(-0.65f, 0.0f, 0.5f), new Vector3f(-0.65f, 1.5f, 0.5f), new Vector3f(-0.65f, 0.5f, -0.5f), new Vector2f(0.1875f, 0.0f), new Vector2f(0.8125f, 0.0f), new Vector2f(0.8125f, 0.9375f), new Vector2f(0.1875f, 0.3125f), new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.65f, 1.5f, -0.0f), new Vector3f(-0.65f, 1.5f, -0.5f), new Vector3f(-0.65f, 1.0f, -0.5f), new Vector3f(-0.65f, 1.5f, 0.5f), new Vector2f(0.5f, 0.9375f), new Vector2f(0.1875f, 0.9375f), new Vector2f(0.1875f, 0.625f), new Vector2f(0.8125f, 0.9375f), new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(-0.65f, 1.5f, 0.5f), new Vector3f(-0.65f, 1.0f, -0.5f), new Vector3f(-0.65f, 0.5f, -0.5f), new Vector2f(0.8125f, 0.9375f), new Vector2f(0.1875f, 0.625f), new Vector2f(0.1875f, 0.3125f), new Vector3f(-3.0f, 0.0f, 0.0f));
		this.quads[9] = new ObjQuad(new Vector3f(-0.65f, 1.5f, -0.5f), new Vector3f(0.65f, 1.5f, -0.5f), new Vector3f(0.65f, 1.0f, -0.5f), new Vector3f(0.2167f, 1.0f, -0.5f), new Vector2f(0.9062f, 0.9375f), new Vector2f(0.0937f, 0.9375f), new Vector2f(0.0937f, 0.625f), new Vector2f(0.3646f, 0.625f), new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[10] = new ObjQuad(new Vector3f(-0.65f, 1.5f, -0.5f), new Vector3f(0.2167f, 1.0f, -0.5f), new Vector3f(-0.2167f, 1.0f, -0.5f), new Vector3f(-0.65f, 1.0f, -0.5f), new Vector2f(0.9062f, 0.9375f), new Vector2f(0.3646f, 0.625f), new Vector2f(0.6354f, 0.625f), new Vector2f(0.9062f, 0.625f), new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[11] = new ObjQuad(new Vector3f(0.65f, 0.0f, -0.5f), new Vector3f(-0.65f, 0.0f, -0.5f), new Vector3f(-0.65f, 0.5f, -0.5f), new Vector3f(-0.2167f, 0.5f, -0.5f), new Vector2f(0.0937f, 0.0f), new Vector2f(0.9062f, 0.0f), new Vector2f(0.9062f, 0.3125f), new Vector2f(0.6354f, 0.3125f), new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[12] = new ObjQuad(new Vector3f(0.65f, 0.0f, -0.5f), new Vector3f(-0.2167f, 0.5f, -0.5f), new Vector3f(0.2167f, 0.5f, -0.5f), new Vector3f(0.65f, 0.5f, -0.5f), new Vector2f(0.0937f, 0.0f), new Vector2f(0.6354f, 0.3125f), new Vector2f(0.3646f, 0.3125f), new Vector2f(0.0937f, 0.3125f), new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[13] = new ObjQuad(new Vector3f(-0.3438f, 1.5f, -0.4f), new Vector3f(-0.3438f, 1.5f, -0.1f), new Vector3f(0.3438f, 1.5f, -0.1f), new Vector3f(0.3438f, 1.5f, -0.4f), new Vector2f(0.2852f, 0.75f), new Vector2f(0.2852f, 0.5625f), new Vector2f(0.7148f, 0.5625f), new Vector2f(0.7148f, 0.75f), new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[14] = new ObjQuad(new Vector3f(-0.65f, 1.5f, 0.5f), new Vector3f(0.65f, 1.5f, 0.5f), new Vector3f(0.65f, 1.5f, 0.5f), new Vector3f(-0.65f, 1.5f, 0.5f), new Vector2f(0.1875f, 0.9375f), new Vector2f(0.1875f, 0.9375f), new Vector2f(0.1875f, 0.9375f), new Vector2f(0.1875f, 0.9375f), new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[15] = new ObjQuad(new Vector3f(0.65f, 1.5f, 0.5f), new Vector3f(0.65f, 1.5f, -0.0f), new Vector3f(0.65f, 1.5f, 0.0f), new Vector3f(0.65f, 1.5f, 0.5f), new Vector2f(0.1875f, 0.9375f), new Vector2f(0.5f, 0.9375f), new Vector2f(0.5f, 0.9375f), new Vector2f(0.1875f, 0.9375f), new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[16] = new ObjQuad(new Vector3f(0.65f, 1.5f, -0.0f), new Vector3f(-0.65f, 1.5f, -0.0f), new Vector3f(-0.65f, 1.5f, 0.0f), new Vector3f(0.65f, 1.5f, 0.0f), new Vector2f(0.9063f, 0.5f), new Vector2f(0.0938f, 0.5f), new Vector2f(0.0938f, 0.5f), new Vector2f(0.9063f, 0.5f), new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[17] = new ObjQuad(new Vector3f(-0.65f, 1.5f, -0.0f), new Vector3f(-0.65f, 1.5f, 0.5f), new Vector3f(-0.65f, 1.5f, 0.5f), new Vector3f(-0.65f, 1.5f, 0.0f), new Vector2f(0.5f, 0.9375f), new Vector2f(0.1875f, 0.9375f), new Vector2f(0.1875f, 0.9375f), new Vector2f(0.5f, 0.9375f), new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[18] = new ObjQuad(new Vector3f(0.65f, 1.5f, -0.5f), new Vector3f(-0.65f, 1.5f, -0.5f), new Vector3f(-0.55f, 1.5f, -0.4f), new Vector3f(-0.3438f, 1.5f, -0.4f), new Vector2f(0.9063f, 0.8125f), new Vector2f(0.0938f, 0.8125f), new Vector2f(0.1563f, 0.75f), new Vector2f(0.2852f, 0.75f), new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[19] = new ObjQuad(new Vector3f(0.65f, 1.5f, -0.5f), new Vector3f(-0.3438f, 1.5f, -0.4f), new Vector3f(0.3438f, 1.5f, -0.4f), new Vector3f(0.55f, 1.5f, -0.4f), new Vector2f(0.9063f, 0.8125f), new Vector2f(0.2852f, 0.75f), new Vector2f(0.7148f, 0.75f), new Vector2f(0.8438f, 0.75f), new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[20] = new ObjQuad(new Vector3f(-0.65f, 1.5f, -0.5f), new Vector3f(-0.65f, 1.5f, -0.0f), new Vector3f(-0.55f, 1.5f, -0.1f), new Vector3f(-0.55f, 1.5f, -0.4f), new Vector2f(0.0938f, 0.8125f), new Vector2f(0.0938f, 0.5f), new Vector2f(0.1563f, 0.5625f), new Vector2f(0.1563f, 0.75f), new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[21] = new ObjQuad(new Vector3f(-0.65f, 1.5f, -0.0f), new Vector3f(0.65f, 1.5f, -0.0f), new Vector3f(0.55f, 1.5f, -0.1f), new Vector3f(0.3438f, 1.5f, -0.1f), new Vector2f(0.0938f, 0.5f), new Vector2f(0.9063f, 0.5f), new Vector2f(0.8438f, 0.5625f), new Vector2f(0.7148f, 0.5625f), new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[22] = new ObjQuad(new Vector3f(-0.65f, 1.5f, -0.0f), new Vector3f(0.3438f, 1.5f, -0.1f), new Vector3f(-0.3438f, 1.5f, -0.1f), new Vector3f(-0.55f, 1.5f, -0.1f), new Vector2f(0.0938f, 0.5f), new Vector2f(0.7148f, 0.5625f), new Vector2f(0.2852f, 0.5625f), new Vector2f(0.1563f, 0.5625f), new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[23] = new ObjQuad(new Vector3f(0.65f, 1.5f, -0.0f), new Vector3f(0.65f, 1.5f, -0.5f), new Vector3f(0.55f, 1.5f, -0.4f), new Vector3f(0.55f, 1.5f, -0.1f), new Vector2f(0.9063f, 0.5f), new Vector2f(0.9063f, 0.8125f), new Vector2f(0.8438f, 0.75f), new Vector2f(0.8438f, 0.5625f), new Vector3f(0.0f, 4.0f, 0.0f));
	}

	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Foot other = new Foot();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

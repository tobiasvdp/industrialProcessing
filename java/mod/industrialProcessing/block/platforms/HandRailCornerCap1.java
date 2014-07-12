package mod.industrialProcessing.block.platforms;

import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class HandRailCornerCap1 extends ObjMesh {
	public HandRailCornerCap1() {
		this.quads = new ObjQuad[20];
		this.quads[0] = new ObjQuad(new Vector3f(0.8f, 0.8f, 0.6f), new Vector3f(0.8f, 0.8f, 0.7f), new Vector3f(0.7f, 0.8f, 0.7f), new Vector3f(0.7f, 0.8f, 0.6f), new Vector2f(0.0625f, -0.0f), new Vector2f(0.0625f, 0.0625f), new Vector2f(0.0f, 0.0625f), new Vector2f(0.0f, -0.0f), new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.8f, 0.9f, 0.6f), new Vector3f(0.8f, 0.9f, 0.658579f), new Vector3f(0.8f, 0.8f, 0.7f), new Vector3f(0.8f, 0.8f, 0.6f), new Vector2f(1.0f, -0.0f), new Vector2f(1.0f, 0.036612f), new Vector2f(0.9375f, 0.0625f), new Vector2f(0.9375f, -0.0f), new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.7f, 0.9f, 0.6f), new Vector3f(0.7f, 0.9f, 0.658579f), new Vector3f(0.8f, 0.9f, 0.658579f), new Vector3f(0.8f, 0.9f, 0.6f), new Vector2f(1.0f, -0.0f), new Vector2f(1.0f, 0.036612f), new Vector2f(0.9375f, 0.036612f), new Vector2f(0.9375f, -0.0f), new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.7f, 0.8f, 0.7f), new Vector3f(0.7f, 0.9f, 0.658579f), new Vector3f(0.7f, 0.9f, 0.6f), new Vector3f(0.7f, 0.8f, 0.6f), new Vector2f(0.0625f, 0.0625f), new Vector2f(0.0f, 0.036612f), new Vector2f(0.0f, -0.0f), new Vector2f(0.0625f, -0.0f), new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.8f, 1.3f, 0.6f), new Vector3f(0.8f, 1.3f, 0.658579f), new Vector3f(0.7f, 1.3f, 0.658579f), new Vector3f(0.7f, 1.3f, 0.6f), new Vector2f(0.0625f, -0.0f), new Vector2f(0.0625f, 0.036612f), new Vector2f(0.0f, 0.036612f), new Vector2f(0.0f, -0.0f), new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(0.8f, 1.4f, 0.6f), new Vector3f(0.8f, 1.4f, 0.7f), new Vector3f(0.8f, 1.3f, 0.658579f), new Vector3f(0.8f, 1.3f, 0.6f), new Vector2f(1.0f, -0.0f), new Vector2f(1.0f, 0.0625f), new Vector2f(0.9375f, 0.036612f), new Vector2f(0.9375f, -0.0f), new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(0.7f, 1.4f, 0.6f), new Vector3f(0.7f, 1.4f, 0.7f), new Vector3f(0.8f, 1.4f, 0.7f), new Vector3f(0.8f, 1.4f, 0.6f), new Vector2f(1.0f, -0.0f), new Vector2f(1.0f, 0.0625f), new Vector2f(0.9375f, 0.0625f), new Vector2f(0.9375f, -0.0f), new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(0.7f, 1.3f, 0.658579f), new Vector3f(0.7f, 1.4f, 0.7f), new Vector3f(0.7f, 1.4f, 0.6f), new Vector3f(0.7f, 1.3f, 0.6f), new Vector2f(0.0625f, 0.036612f), new Vector2f(0.0f, 0.0625f), new Vector2f(0.0f, -0.0f), new Vector2f(0.0625f, -0.0f), new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(0.8f, 1.3f, 0.8f), new Vector3f(0.7f, 1.3f, 0.8f), new Vector3f(0.7f, 0.9f, 0.8f), new Vector3f(0.8f, 0.9f, 0.8f), new Vector2f(0.0625f, 0.5625f), new Vector2f(-0.0f, 0.5625f), new Vector2f(-0.0f, 0.3125f), new Vector2f(0.0625f, 0.3125f), new Vector3f(0.0f, 1.013279E-6f, 3.69552f));
		this.quads[9] = new ObjQuad(new Vector3f(0.8f, 1.4f, 0.7f), new Vector3f(0.7f, 1.4f, 0.7f), new Vector3f(0.7f, 1.3f, 0.8f), new Vector3f(0.8f, 1.3f, 0.8f), new Vector2f(0.0625f, 0.400888f), new Vector2f(-0.0f, 0.400888f), new Vector2f(-0.0f, 0.3125f), new Vector2f(0.0625f, 0.3125f), new Vector3f(0.0f, 2.1795812f, 3.2619739f));
		this.quads[10] = new ObjQuad(new Vector3f(0.8f, 0.9f, 0.8f), new Vector3f(0.7f, 0.9f, 0.8f), new Vector3f(0.7f, 0.8f, 0.7f), new Vector3f(0.8f, 0.8f, 0.7f), new Vector2f(0.0625f, 0.5625f), new Vector2f(-0.0f, 0.5625f), new Vector2f(-0.0f, 0.474112f), new Vector2f(0.0625f, 0.474112f), new Vector3f(0.0f, -2.17958f, 3.261974f));
		this.quads[11] = new ObjQuad(new Vector3f(0.8f, 0.9f, 0.658579f), new Vector3f(0.8f, 0.941421f, 0.7f), new Vector3f(0.8f, 0.9f, 0.8f), new Vector3f(0.8f, 0.8f, 0.7f), new Vector2f(0.0625f, 0.5f), new Vector2f(0.0625f, 0.536612f), new Vector2f(0.0f, 0.5625f), new Vector2f(0.0f, 0.474112f), new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[12] = new ObjQuad(new Vector3f(0.7f, 0.941421f, 0.7f), new Vector3f(0.8f, 0.941421f, 0.7f), new Vector3f(0.8f, 0.9f, 0.658579f), new Vector3f(0.7f, 0.9f, 0.658579f), new Vector2f(1.0f, 0.536612f), new Vector2f(0.9375f, 0.536612f), new Vector2f(0.9375f, 0.5f), new Vector2f(1.0f, 0.5f), new Vector3f(0.0f, 2.1795778f, -3.261974f));
		this.quads[13] = new ObjQuad(new Vector3f(0.7f, 0.9f, 0.8f), new Vector3f(0.7f, 0.941421f, 0.7f), new Vector3f(0.7f, 0.9f, 0.658579f), new Vector3f(0.7f, 0.8f, 0.7f), new Vector2f(1.0f, 0.5625f), new Vector2f(0.9375f, 0.536612f), new Vector2f(0.9375f, 0.5f), new Vector2f(1.0f, 0.474112f), new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[14] = new ObjQuad(new Vector3f(0.8f, 1.258579f, 0.7f), new Vector3f(0.8f, 1.3f, 0.8f), new Vector3f(0.8f, 0.9f, 0.8f), new Vector3f(0.8f, 0.941421f, 0.7f), new Vector2f(0.0625f, 0.536612f), new Vector2f(0.0f, 0.5625f), new Vector2f(0.0f, 0.3125f), new Vector2f(0.0625f, 0.338388f), new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[15] = new ObjQuad(new Vector3f(0.7f, 1.258579f, 0.7f), new Vector3f(0.8f, 1.258579f, 0.7f), new Vector3f(0.8f, 0.941421f, 0.7f), new Vector3f(0.7f, 0.941421f, 0.7f), new Vector2f(1.0f, 0.536612f), new Vector2f(0.9375f, 0.536612f), new Vector2f(0.9375f, 0.338388f), new Vector2f(1.0f, 0.338388f), new Vector3f(0.0f, -1.9669533E-6f, -3.695518f));
		this.quads[16] = new ObjQuad(new Vector3f(0.7f, 1.3f, 0.8f), new Vector3f(0.7f, 1.258579f, 0.7f), new Vector3f(0.7f, 0.941421f, 0.7f), new Vector3f(0.7f, 0.9f, 0.8f), new Vector2f(1.0f, 0.5625f), new Vector2f(0.9375f, 0.536612f), new Vector2f(0.9375f, 0.338388f), new Vector2f(1.0f, 0.3125f), new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[17] = new ObjQuad(new Vector3f(0.8f, 1.3f, 0.658579f), new Vector3f(0.8f, 1.4f, 0.7f), new Vector3f(0.8f, 1.3f, 0.8f), new Vector3f(0.8f, 1.258579f, 0.7f), new Vector2f(0.0625f, 0.375f), new Vector2f(0.0f, 0.400888f), new Vector2f(0.0f, 0.3125f), new Vector2f(0.0625f, 0.338388f), new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[18] = new ObjQuad(new Vector3f(0.7f, 1.3f, 0.658579f), new Vector3f(0.8f, 1.3f, 0.658579f), new Vector3f(0.8f, 1.258579f, 0.7f), new Vector3f(0.7f, 1.258579f, 0.7f), new Vector2f(1.0f, 0.375f), new Vector2f(0.9375f, 0.375f), new Vector2f(0.9375f, 0.338388f), new Vector2f(1.0f, 0.338388f), new Vector3f(0.0f, -2.179582f, -3.26197f));
		this.quads[19] = new ObjQuad(new Vector3f(0.7f, 1.4f, 0.7f), new Vector3f(0.7f, 1.3f, 0.658579f), new Vector3f(0.7f, 1.258579f, 0.7f), new Vector3f(0.7f, 1.3f, 0.8f), new Vector2f(1.0f, 0.400888f), new Vector2f(0.9375f, 0.375f), new Vector2f(0.9375f, 0.338388f), new Vector2f(1.0f, 0.3125f), new Vector3f(-4.0f, 0.0f, 0.0f));
	}

	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		HandRailCornerCap1 other = new HandRailCornerCap1();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

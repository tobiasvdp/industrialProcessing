package ip.industrialProcessing.multiblock.core.block.blastFurnace.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class BottomHull extends ObjMesh{
	public BottomHull(){
		this.quads = new ObjQuad[15];
		this.quads[0] = new ObjQuad(new Vector3f(-0.7f, 0.7f, -0.7f),new Vector3f(0.7f, 0.7f, -0.7f),new Vector3f(0.3f, 0.2f, -0.3f),new Vector3f(-0.3f, 0.2f, -0.3f),new Vector2f(0.9375f, 0.4375f),new Vector2f(0.0625f, 0.4375f),new Vector2f(0.3125f, 0.125f),new Vector2f(0.6875f, 0.125f),new Vector3f(0.0f, -2.4988f, -3.1236f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.7f, 1.6f, -0.7f),new Vector3f(0.7f, 1.6f, -0.7f),new Vector3f(0.7f, 0.7f, -0.7f),new Vector3f(-0.7f, 0.7f, -0.7f),new Vector2f(0.9375f, 1.0f),new Vector2f(0.0625f, 1.0f),new Vector2f(0.0625f, 0.4375f),new Vector2f(0.9375f, 0.4375f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.7f, 0.7f, 0.7f),new Vector3f(0.7f, 0.7f, -0.7f),new Vector3f(0.7f, 1.6f, -0.7f),new Vector3f(0.7f, 1.6f, 0.7f),new Vector2f(0.0625f, 0.4375f),new Vector2f(0.9375f, 0.4375f),new Vector2f(0.9375f, 1.0f),new Vector2f(0.0625f, 1.0f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.3f, 0.2f, 0.3f),new Vector3f(0.3f, 0.2f, -0.3f),new Vector3f(0.7f, 0.7f, -0.7f),new Vector3f(0.7f, 0.7f, 0.7f),new Vector2f(0.3125f, 0.125f),new Vector2f(0.6875f, 0.125f),new Vector2f(0.9375f, 0.4375f),new Vector2f(0.0625f, 0.4375f),new Vector3f(3.1236f, -2.4988f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.7f, 0.7f, 0.7f),new Vector3f(-0.3f, 0.2f, 0.3f),new Vector3f(0.3f, 0.2f, 0.3f),new Vector3f(0.7f, 0.7f, 0.7f),new Vector2f(0.0625f, 0.4375f),new Vector2f(0.3125f, 0.125f),new Vector2f(0.6875f, 0.125f),new Vector2f(0.9375f, 0.4375f),new Vector3f(0.0f, -2.4988f, 3.1236f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.7f, 0.7f, 0.7f),new Vector3f(-0.7f, 0.7f, -0.7f),new Vector3f(-0.3f, 0.2f, -0.3f),new Vector3f(-0.3f, 0.2f, 0.3f),new Vector2f(0.9375f, 0.4375f),new Vector2f(0.0625f, 0.4375f),new Vector2f(0.3125f, 0.125f),new Vector2f(0.6875f, 0.125f),new Vector3f(-3.1236f, -2.4988f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.7f, 0.8f, 0.55f),new Vector3f(-0.7f, 0.8f, -0.55f),new Vector3f(-0.7f, 0.7f, -0.7f),new Vector3f(-0.7f, 0.7f, 0.7f),new Vector2f(0.8437f, 0.5f),new Vector2f(0.1562f, 0.5f),new Vector2f(0.0625f, 0.4375f),new Vector2f(0.9375f, 0.4375f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(0.7f, 0.7f, 0.7f),new Vector3f(0.7f, 1.6f, 0.7f),new Vector3f(-0.7f, 1.6f, 0.7f),new Vector3f(-0.7f, 0.7f, 0.7f),new Vector2f(0.9375f, 0.4375f),new Vector2f(0.9375f, 1.0f),new Vector2f(0.0625f, 1.0f),new Vector2f(0.0625f, 0.4375f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[8] = new ObjQuad(new Vector3f(0.2f, 0.2f, 0.2f),new Vector3f(0.3f, 0.2f, 0.3f),new Vector3f(-0.3f, 0.2f, 0.3f),new Vector3f(-0.2f, 0.2f, 0.2f),new Vector2f(0.625f, 0.375f),new Vector2f(0.6875f, 0.3125f),new Vector2f(0.6875f, 0.6875f),new Vector2f(0.625f, 0.625f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[9] = new ObjQuad(new Vector3f(0.3f, 0.2f, -0.3f),new Vector3f(0.2f, 0.2f, -0.2f),new Vector3f(-0.2f, 0.2f, -0.2f),new Vector3f(-0.3f, 0.2f, -0.3f),new Vector2f(0.3125f, 0.3125f),new Vector2f(0.375f, 0.375f),new Vector2f(0.375f, 0.625f),new Vector2f(0.3125f, 0.6875f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[10] = new ObjQuad(new Vector3f(-0.3f, 0.2f, -0.3f),new Vector3f(-0.2f, 0.2f, -0.2f),new Vector3f(-0.2f, 0.2f, 0.2f),new Vector3f(-0.3f, 0.2f, 0.3f),new Vector2f(0.3125f, 0.6875f),new Vector2f(0.375f, 0.625f),new Vector2f(0.625f, 0.625f),new Vector2f(0.6875f, 0.6875f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[11] = new ObjQuad(new Vector3f(0.3f, 0.2f, 0.3f),new Vector3f(0.2f, 0.2f, 0.2f),new Vector3f(0.2f, 0.2f, -0.2f),new Vector3f(0.3f, 0.2f, -0.3f),new Vector2f(0.6875f, 0.3125f),new Vector2f(0.625f, 0.375f),new Vector2f(0.375f, 0.375f),new Vector2f(0.3125f, 0.3125f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[12] = new ObjQuad(new Vector3f(-0.7f, 1.6f, 0.7f),new Vector3f(-0.7f, 1.5f, 0.55f),new Vector3f(-0.7f, 0.8f, 0.55f),new Vector3f(-0.7f, 0.7f, 0.7f),new Vector2f(0.9375f, 1.0f),new Vector2f(0.8437f, 0.9375f),new Vector2f(0.8437f, 0.5f),new Vector2f(0.9375f, 0.4375f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[13] = new ObjQuad(new Vector3f(-0.7f, 1.6f, 0.7f),new Vector3f(-0.7f, 1.6f, -0.7f),new Vector3f(-0.7f, 1.5f, -0.55f),new Vector3f(-0.7f, 1.5f, 0.55f),new Vector2f(0.9375f, 1.0f),new Vector2f(0.0625f, 1.0f),new Vector2f(0.1562f, 0.9375f),new Vector2f(0.8437f, 0.9375f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[14] = new ObjQuad(new Vector3f(-0.7f, 1.6f, -0.7f),new Vector3f(-0.7f, 0.7f, -0.7f),new Vector3f(-0.7f, 0.8f, -0.55f),new Vector3f(-0.7f, 1.5f, -0.55f),new Vector2f(0.0625f, 1.0f),new Vector2f(0.0625f, 0.4375f),new Vector2f(0.1562f, 0.5f),new Vector2f(0.1562f, 0.9375f),new Vector3f(-4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		BottomHull other = new BottomHull();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

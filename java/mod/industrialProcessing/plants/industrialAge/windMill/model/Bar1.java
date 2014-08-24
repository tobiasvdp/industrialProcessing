package  mod.industrialProcessing.plants.industrialAge.windMill.model;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Bar1 extends ObjMesh{
	public Bar1(){
		this.quads = new ObjQuad[24];
		this.quads[0] = new ObjQuad(new Vector3f(-0.6f, 0.0f, 0.6f),new Vector3f(-0.6f, 0.0f, 0.8f),new Vector3f(-0.8f, 0.0f, 0.8f),new Vector3f(-0.8f, 0.0f, 0.6f),new Vector2f(0.875f, 0.875f),new Vector2f(0.875f, 1.0f),new Vector2f(1.0f, 1.0f),new Vector2f(1.0f, 0.875f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.7f, 1.6f, 0.7f),new Vector3f(-0.5f, 1.6f, 0.7f),new Vector3f(-0.5f, 1.6f, 0.5f),new Vector3f(-0.7f, 1.6f, 0.5f),new Vector2f(0.0625f, 0.9375f),new Vector2f(0.1875f, 0.9375f),new Vector2f(0.1875f, 0.8125f),new Vector2f(0.0625f, 0.8125f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.7f, 1.6f, 0.5f),new Vector3f(-0.5f, 1.6f, 0.5f),new Vector3f(-0.6f, 0.0f, 0.6f),new Vector3f(-0.8f, 0.0f, 0.6f),new Vector2f(0.0625f, 1.0f),new Vector2f(0.1875f, 1.0f),new Vector2f(0.125f, 0.0f),new Vector2f(0.0f, 0.0f),new Vector3f(0.0f, -0.2496f, -3.9924f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.5f, 1.6f, 0.5f),new Vector3f(-0.5f, 1.6f, 0.7f),new Vector3f(-0.6f, 0.0f, 0.8f),new Vector3f(-0.6f, 0.0f, 0.6f),new Vector2f(0.8125f, 1.0f),new Vector2f(0.9375f, 1.0f),new Vector2f(1.0f, 0.0f),new Vector2f(0.875f, 0.0f),new Vector3f(3.9924f, -0.2496f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.5f, 1.6f, 0.7f),new Vector3f(-0.7f, 1.6f, 0.7f),new Vector3f(-0.8f, 0.0f, 0.8f),new Vector3f(-0.6f, 0.0f, 0.8f),new Vector2f(0.8125f, 1.0f),new Vector2f(0.9375f, 1.0f),new Vector2f(1.0f, 0.0f),new Vector2f(0.875f, 0.0f),new Vector3f(0.0f, 0.2496f, 3.9924f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.7f, 1.6f, 0.7f),new Vector3f(-0.7f, 1.6f, 0.5f),new Vector3f(-0.8f, 0.0f, 0.6f),new Vector3f(-0.8f, 0.0f, 0.8f),new Vector2f(0.0625f, 1.0f),new Vector2f(0.1875f, 1.0f),new Vector2f(0.125f, 0.0f),new Vector2f(-0.0f, 0.0f),new Vector3f(-3.9924f, 0.2496f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(0.8f, 0.0f, 0.8f),new Vector3f(0.6f, 0.0f, 0.8f),new Vector3f(0.6f, 0.0f, 0.6f),new Vector3f(0.8f, 0.0f, 0.6f),new Vector2f(-0.0f, 1.0f),new Vector2f(0.125f, 1.0f),new Vector2f(0.125f, 0.875f),new Vector2f(0.0f, 0.875f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(0.5f, 1.6f, 0.5f),new Vector3f(0.5f, 1.6f, 0.7f),new Vector3f(0.7f, 1.6f, 0.7f),new Vector3f(0.7f, 1.6f, 0.5f),new Vector2f(0.8125f, 0.8125f),new Vector2f(0.8125f, 0.9375f),new Vector2f(0.9375f, 0.9375f),new Vector2f(0.9375f, 0.8125f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(0.6f, 0.0f, 0.6f),new Vector3f(0.5f, 1.6f, 0.5f),new Vector3f(0.7f, 1.6f, 0.5f),new Vector3f(0.8f, 0.0f, 0.6f),new Vector2f(0.875f, 0.0f),new Vector2f(0.8125f, 1.0f),new Vector2f(0.9375f, 1.0f),new Vector2f(1.0f, 0.0f),new Vector3f(0.0f, -0.2496f, -3.9924f));
		this.quads[9] = new ObjQuad(new Vector3f(0.6f, 0.0f, 0.8f),new Vector3f(0.5f, 1.6f, 0.7f),new Vector3f(0.5f, 1.6f, 0.5f),new Vector3f(0.6f, 0.0f, 0.6f),new Vector2f(0.0f, 0.0f),new Vector2f(0.0625f, 1.0f),new Vector2f(0.1875f, 1.0f),new Vector2f(0.125f, 0.0f),new Vector3f(-3.9924f, -0.2496f, 0.0f));
		this.quads[10] = new ObjQuad(new Vector3f(0.8f, 0.0f, 0.8f),new Vector3f(0.7f, 1.6f, 0.7f),new Vector3f(0.5f, 1.6f, 0.7f),new Vector3f(0.6f, 0.0f, 0.8f),new Vector2f(-0.0f, 0.0f),new Vector2f(0.0625f, 1.0f),new Vector2f(0.1875f, 1.0f),new Vector2f(0.125f, 0.0f),new Vector3f(0.0f, 0.2496f, 3.9924f));
		this.quads[11] = new ObjQuad(new Vector3f(0.8f, 0.0f, 0.6f),new Vector3f(0.7f, 1.6f, 0.5f),new Vector3f(0.7f, 1.6f, 0.7f),new Vector3f(0.8f, 0.0f, 0.8f),new Vector2f(0.875f, 0.0f),new Vector2f(0.8125f, 1.0f),new Vector2f(0.9375f, 1.0f),new Vector2f(1.0f, 0.0f),new Vector3f(3.9924f, 0.2496f, 0.0f));
		this.quads[12] = new ObjQuad(new Vector3f(0.6f, 0.0f, -0.6f),new Vector3f(0.6f, 0.0f, -0.8f),new Vector3f(0.8f, 0.0f, -0.8f),new Vector3f(0.8f, 0.0f, -0.6f),new Vector2f(0.125f, 0.125f),new Vector2f(0.125f, -0.0f),new Vector2f(0.0f, -0.0f),new Vector2f(0.0f, 0.125f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[13] = new ObjQuad(new Vector3f(0.7f, 1.6f, -0.7f),new Vector3f(0.5f, 1.6f, -0.7f),new Vector3f(0.5f, 1.6f, -0.5f),new Vector3f(0.7f, 1.6f, -0.5f),new Vector2f(0.9375f, 0.0625f),new Vector2f(0.8125f, 0.0625f),new Vector2f(0.8125f, 0.1875f),new Vector2f(0.9375f, 0.1875f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[14] = new ObjQuad(new Vector3f(0.7f, 1.6f, -0.5f),new Vector3f(0.5f, 1.6f, -0.5f),new Vector3f(0.6f, 0.0f, -0.6f),new Vector3f(0.8f, 0.0f, -0.6f),new Vector2f(0.0625f, 1.0f),new Vector2f(0.1875f, 1.0f),new Vector2f(0.125f, 0.0f),new Vector2f(0.0f, 0.0f),new Vector3f(0.0f, -0.2496f, 3.9924f));
		this.quads[15] = new ObjQuad(new Vector3f(0.5f, 1.6f, -0.5f),new Vector3f(0.5f, 1.6f, -0.7f),new Vector3f(0.6f, 0.0f, -0.8f),new Vector3f(0.6f, 0.0f, -0.6f),new Vector2f(0.8125f, 1.0f),new Vector2f(0.9375f, 1.0f),new Vector2f(1.0f, 0.0f),new Vector2f(0.875f, 0.0f),new Vector3f(-3.9924f, -0.2496f, 0.0f));
		this.quads[16] = new ObjQuad(new Vector3f(0.5f, 1.6f, -0.7f),new Vector3f(0.7f, 1.6f, -0.7f),new Vector3f(0.8f, 0.0f, -0.8f),new Vector3f(0.6f, 0.0f, -0.8f),new Vector2f(0.8125f, 1.0f),new Vector2f(0.9375f, 1.0f),new Vector2f(1.0f, 0.0f),new Vector2f(0.875f, 0.0f),new Vector3f(0.0f, 0.2496f, -3.9924f));
		this.quads[17] = new ObjQuad(new Vector3f(0.7f, 1.6f, -0.7f),new Vector3f(0.7f, 1.6f, -0.5f),new Vector3f(0.8f, 0.0f, -0.6f),new Vector3f(0.8f, 0.0f, -0.8f),new Vector2f(0.0625f, 1.0f),new Vector2f(0.1875f, 1.0f),new Vector2f(0.125f, 0.0f),new Vector2f(-0.0f, 0.0f),new Vector3f(3.9924f, 0.2496f, 0.0f));
		this.quads[18] = new ObjQuad(new Vector3f(-0.8f, 0.0f, -0.8f),new Vector3f(-0.6f, 0.0f, -0.8f),new Vector3f(-0.6f, 0.0f, -0.6f),new Vector3f(-0.8f, 0.0f, -0.6f),new Vector2f(1.0f, 0.0f),new Vector2f(0.875f, 0.0f),new Vector2f(0.875f, 0.125f),new Vector2f(1.0f, 0.125f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[19] = new ObjQuad(new Vector3f(-0.5f, 1.6f, -0.5f),new Vector3f(-0.5f, 1.6f, -0.7f),new Vector3f(-0.7f, 1.6f, -0.7f),new Vector3f(-0.7f, 1.6f, -0.5f),new Vector2f(0.1875f, 0.1875f),new Vector2f(0.1875f, 0.0625f),new Vector2f(0.0625f, 0.0625f),new Vector2f(0.0625f, 0.1875f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[20] = new ObjQuad(new Vector3f(-0.6f, 0.0f, -0.6f),new Vector3f(-0.5f, 1.6f, -0.5f),new Vector3f(-0.7f, 1.6f, -0.5f),new Vector3f(-0.8f, 0.0f, -0.6f),new Vector2f(0.875f, 0.0f),new Vector2f(0.8125f, 1.0f),new Vector2f(0.9375f, 1.0f),new Vector2f(1.0f, 0.0f),new Vector3f(0.0f, -0.2496f, 3.9924f));
		this.quads[21] = new ObjQuad(new Vector3f(-0.6f, 0.0f, -0.8f),new Vector3f(-0.5f, 1.6f, -0.7f),new Vector3f(-0.5f, 1.6f, -0.5f),new Vector3f(-0.6f, 0.0f, -0.6f),new Vector2f(0.0f, 0.0f),new Vector2f(0.0625f, 1.0f),new Vector2f(0.1875f, 1.0f),new Vector2f(0.125f, 0.0f),new Vector3f(3.9924f, -0.2496f, 0.0f));
		this.quads[22] = new ObjQuad(new Vector3f(-0.8f, 0.0f, -0.8f),new Vector3f(-0.7f, 1.6f, -0.7f),new Vector3f(-0.5f, 1.6f, -0.7f),new Vector3f(-0.6f, 0.0f, -0.8f),new Vector2f(-0.0f, 0.0f),new Vector2f(0.0625f, 1.0f),new Vector2f(0.1875f, 1.0f),new Vector2f(0.125f, 0.0f),new Vector3f(0.0f, 0.2496f, -3.9924f));
		this.quads[23] = new ObjQuad(new Vector3f(-0.8f, 0.0f, -0.6f),new Vector3f(-0.7f, 1.6f, -0.5f),new Vector3f(-0.7f, 1.6f, -0.7f),new Vector3f(-0.8f, 0.0f, -0.8f),new Vector2f(0.875f, 0.0f),new Vector2f(0.8125f, 1.0f),new Vector2f(0.9375f, 1.0f),new Vector2f(1.0f, 0.0f),new Vector3f(-3.9924f, 0.2496f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Bar1 other = new Bar1();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

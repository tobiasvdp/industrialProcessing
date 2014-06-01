package mod.industrialProcessing.plants.transport.items.conveyorPacker.model;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Hull extends ObjMesh{
	public Hull(){
		this.quads = new ObjQuad[21];
		this.quads[0] = new ObjQuad(new Vector3f(0.7f, 0.3f, -0.7f),new Vector3f(0.7f, 1.5f, -0.7f),new Vector3f(0.7f, 1.5f, 0.7f),new Vector3f(0.7f, 0.3f, 0.7f),new Vector2f(0.9375f, 0.1875f),new Vector2f(0.9375f, 0.9375f),new Vector2f(0.0625f, 0.9375f),new Vector2f(0.0625f, 0.1875f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.7f, 0.3f, -0.7f),new Vector3f(-0.7f, 0.3f, 0.7f),new Vector3f(-0.7f, 1.5f, 0.7f),new Vector3f(-0.7f, 1.5f, -0.7f),new Vector2f(0.0625f, 0.1875f),new Vector2f(0.9375f, 0.1875f),new Vector2f(0.9375f, 0.9375f),new Vector2f(0.0625f, 0.9375f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.6f, 0.2f, -0.7f),new Vector3f(0.6f, 0.2f, 0.7f),new Vector3f(-0.6f, 0.2f, 0.7f),new Vector3f(-0.6f, 0.2f, -0.7f),new Vector2f(0.0625f, 0.125f),new Vector2f(0.9375f, 0.125f),new Vector2f(0.9375f, 0.875f),new Vector2f(0.0625f, 0.875f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.7f, 0.3f, 0.7f),new Vector3f(0.7f, 1.5f, 0.7f),new Vector3f(0.6f, 1.6f, 0.7f),new Vector3f(-0.7f, 1.5f, 0.7f),new Vector2f(0.1875f, 0.0625f),new Vector2f(0.9375f, 0.0625f),new Vector2f(1.0f, 0.125f),new Vector2f(0.9375f, 0.9375f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.6f, 1.6f, 0.7f),new Vector3f(-0.6f, 1.6f, 0.7f),new Vector3f(-0.7f, 1.5f, 0.7f),new Vector2f(1.0f, 0.125f),new Vector2f(1.0f, 0.875f),new Vector2f(0.9375f, 0.9375f),new Vector3f(0.0f, 0.0f, 3.0f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.7f, 1.5f, 0.7f),new Vector3f(-0.7f, 0.3f, 0.7f),new Vector3f(-0.6f, 0.2f, 0.7f),new Vector3f(0.7f, 0.3f, 0.7f),new Vector2f(0.9375f, 0.9375f),new Vector2f(0.1875f, 0.9375f),new Vector2f(0.125f, 0.875f),new Vector2f(0.1875f, 0.0625f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[6] = new ObjQuad(new Vector3f(0.6f, 0.2f, 0.7f),new Vector3f(0.7f, 0.3f, 0.7f),new Vector3f(-0.6f, 0.2f, 0.7f),new Vector2f(0.125f, 0.125f),new Vector2f(0.1875f, 0.0625f),new Vector2f(0.125f, 0.875f),new Vector3f(0.0f, 0.0f, 3.0f));
		this.quads[7] = new ObjQuad(new Vector3f(0.6f, 1.6f, 0.3f),new Vector3f(-0.6f, 1.6f, 0.3f),new Vector3f(-0.6f, 1.6f, 0.7f),new Vector3f(0.6f, 1.6f, 0.7f),new Vector2f(0.3125f, 0.125f),new Vector2f(0.3125f, 0.875f),new Vector2f(0.0625f, 0.875f),new Vector2f(0.0625f, 0.125f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(0.7f, 1.5f, -0.7f),new Vector3f(0.7f, 0.3f, -0.7f),new Vector3f(0.6f, 0.2f, -0.7f),new Vector3f(-0.7f, 0.3f, -0.7f),new Vector2f(0.0625f, 0.0625f),new Vector2f(0.8125f, 0.0625f),new Vector2f(0.875f, 0.125f),new Vector2f(0.8125f, 0.9375f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[9] = new ObjQuad(new Vector3f(0.6f, 0.2f, -0.7f),new Vector3f(-0.6f, 0.2f, -0.7f),new Vector3f(-0.7f, 0.3f, -0.7f),new Vector2f(0.875f, 0.125f),new Vector2f(0.875f, 0.875f),new Vector2f(0.8125f, 0.9375f),new Vector3f(0.0f, 0.0f, -3.0f));
		this.quads[10] = new ObjQuad(new Vector3f(-0.7f, 0.3f, -0.7f),new Vector3f(-0.7f, 1.5f, -0.7f),new Vector3f(-0.6f, 1.6f, -0.7f),new Vector3f(0.7f, 1.5f, -0.7f),new Vector2f(0.8125f, 0.9375f),new Vector2f(0.0625f, 0.9375f),new Vector2f(-0.0f, 0.875f),new Vector2f(0.0625f, 0.0625f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[11] = new ObjQuad(new Vector3f(0.6f, 1.6f, -0.7f),new Vector3f(0.7f, 1.5f, -0.7f),new Vector3f(-0.6f, 1.6f, -0.7f),new Vector2f(-0.0f, 0.125f),new Vector2f(0.0625f, 0.0625f),new Vector2f(-0.0f, 0.875f),new Vector3f(0.0f, 0.0f, -3.0f));
		this.quads[12] = new ObjQuad(new Vector3f(0.6f, 1.6f, -0.7f),new Vector3f(0.6f, 1.6f, -0.3f),new Vector3f(0.7f, 1.5f, -0.3f),new Vector3f(0.7f, 1.5f, -0.7f),new Vector2f(0.9375f, 0.125f),new Vector2f(0.6875f, 0.125f),new Vector2f(0.6875f, 0.0625f),new Vector2f(0.9375f, 0.0625f),new Vector3f(2.8284f, 2.8284f, 0.0f));
		this.quads[13] = new ObjQuad(new Vector3f(0.7f, 0.3f, 0.7f),new Vector3f(0.6f, 0.2f, 0.7f),new Vector3f(0.6f, 0.2f, -0.7f),new Vector3f(0.7f, 0.3f, -0.7f),new Vector2f(0.9375f, 0.0625f),new Vector2f(0.9375f, 0.125f),new Vector2f(0.0625f, 0.125f),new Vector2f(0.0625f, 0.0625f),new Vector3f(2.8284f, -2.8284f, 0.0f));
		this.quads[14] = new ObjQuad(new Vector3f(-0.7f, 0.3f, -0.7f),new Vector3f(-0.6f, 0.2f, -0.7f),new Vector3f(-0.6f, 0.2f, 0.7f),new Vector3f(-0.7f, 0.3f, 0.7f),new Vector2f(0.0625f, 0.9375f),new Vector2f(0.0625f, 0.875f),new Vector2f(0.9375f, 0.875f),new Vector2f(0.9375f, 0.9375f),new Vector3f(-2.8284f, -2.8284f, 0.0f));
		this.quads[15] = new ObjQuad(new Vector3f(-0.6f, 1.6f, 0.7f),new Vector3f(-0.6f, 1.6f, 0.3f),new Vector3f(-0.7f, 1.5f, 0.3f),new Vector3f(-0.7f, 1.5f, 0.7f),new Vector2f(0.0625f, 0.875f),new Vector2f(0.3125f, 0.875f),new Vector2f(0.3125f, 0.9375f),new Vector2f(0.0625f, 0.9375f),new Vector3f(-2.8284f, 2.8284f, 0.0f));
		this.quads[16] = new ObjQuad(new Vector3f(0.6f, 1.6f, -0.7f),new Vector3f(-0.6f, 1.6f, -0.7f),new Vector3f(-0.6f, 1.6f, -0.3f),new Vector3f(0.6f, 1.6f, -0.3f),new Vector2f(0.9375f, 0.125f),new Vector2f(0.9375f, 0.875f),new Vector2f(0.6875f, 0.875f),new Vector2f(0.6875f, 0.125f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[17] = new ObjQuad(new Vector3f(-0.6f, 1.6f, -0.7f),new Vector3f(-0.7f, 1.5f, -0.7f),new Vector3f(-0.7f, 1.5f, -0.3f),new Vector3f(-0.6f, 1.6f, -0.3f),new Vector2f(0.9375f, 0.875f),new Vector2f(0.9375f, 0.9375f),new Vector2f(0.6875f, 0.9375f),new Vector2f(0.6875f, 0.875f),new Vector3f(-2.8284f, 2.8284f, 0.0f));
		this.quads[18] = new ObjQuad(new Vector3f(0.6f, 1.6f, 0.7f),new Vector3f(0.7f, 1.5f, 0.7f),new Vector3f(0.7f, 1.5f, 0.3f),new Vector3f(0.6f, 1.6f, 0.3f),new Vector2f(0.0625f, 0.125f),new Vector2f(0.0625f, 0.0625f),new Vector2f(0.3125f, 0.0625f),new Vector2f(0.3125f, 0.125f),new Vector3f(2.8284f, 2.8284f, 0.0f));
		this.quads[19] = new ObjQuad(new Vector3f(-0.7f, 1.5f, -0.3f),new Vector3f(0.7f, 1.5f, -0.3f),new Vector3f(0.6f, 1.6f, -0.3f),new Vector3f(-0.6f, 1.6f, -0.3f),new Vector2f(0.9375f, 0.9375f),new Vector2f(0.9375f, 0.0625f),new Vector2f(1.0f, 0.125f),new Vector2f(1.0f, 0.875f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[20] = new ObjQuad(new Vector3f(0.7f, 1.5f, 0.3f),new Vector3f(-0.7f, 1.5f, 0.3f),new Vector3f(-0.6f, 1.6f, 0.3f),new Vector3f(0.6f, 1.6f, 0.3f),new Vector2f(0.0625f, 0.0625f),new Vector2f(0.0625f, 0.9375f),new Vector2f(0.0f, 0.875f),new Vector2f(0.0f, 0.125f),new Vector3f(0.0f, 0.0f, -4.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Hull other = new Hull();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

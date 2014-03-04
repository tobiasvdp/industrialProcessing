package ip.industrialProcessing.machines.redstoneInterface.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class InterfaceBox extends ObjMesh{
	public InterfaceBox(){
		this.quads = new ObjQuad[20];
		this.quads[0] = new ObjQuad(new Vector3f(-0.5f, 0.1f, -0.5f),new Vector3f(-0.5f, 0.1f, -0.8f),new Vector3f(0.5f, 0.1f, -0.8f),new Vector2f(0.8125f, 0.8125f),new Vector2f(0.8125f, 1.0f),new Vector2f(0.1875f, 1.0f),new Vector3f(0.0f, -3.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.5f, 0.1f, -0.8f),new Vector3f(0.5f, 0.1f, -0.5f),new Vector3f(0.4f, 0.1f, -0.4f),new Vector2f(0.1875f, 1.0f),new Vector2f(0.1875f, 0.8125f),new Vector2f(0.25f, 0.75f),new Vector3f(0.0f, -3.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.5f, 0.1f, -0.5f),new Vector3f(0.5f, 0.1f, -0.8f),new Vector3f(0.4f, 0.1f, -0.4f),new Vector2f(0.8125f, 0.8125f),new Vector2f(0.1875f, 1.0f),new Vector2f(0.25f, 0.75f),new Vector3f(0.0f, -3.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.4f, 0.1f, -0.4f),new Vector3f(-0.5f, 0.1f, -0.5f),new Vector3f(0.4f, 0.1f, -0.4f),new Vector2f(0.75f, 0.75f),new Vector2f(0.8125f, 0.8125f),new Vector2f(0.25f, 0.75f),new Vector3f(0.0f, -3.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.4f, 1.1f, -0.4f),new Vector3f(0.4f, 1.1f, -0.4f),new Vector3f(0.5f, 1.1f, -0.5f),new Vector2f(0.25f, 0.75f),new Vector2f(0.75f, 0.75f),new Vector2f(0.8125f, 0.8125f),new Vector3f(0.0f, 3.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.4f, 1.1f, -0.4f),new Vector3f(0.5f, 1.1f, -0.5f),new Vector3f(0.5f, 1.1f, -0.8f),new Vector2f(0.25f, 0.75f),new Vector2f(0.8125f, 0.8125f),new Vector2f(0.8125f, 1.0f),new Vector3f(0.0f, 3.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.4f, 1.1f, -0.4f),new Vector3f(0.5f, 1.1f, -0.8f),new Vector3f(-0.5f, 1.1f, -0.8f),new Vector2f(0.25f, 0.75f),new Vector2f(0.8125f, 1.0f),new Vector2f(0.1875f, 1.0f),new Vector3f(0.0f, 3.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.5f, 1.1f, -0.5f),new Vector3f(-0.4f, 1.1f, -0.4f),new Vector3f(-0.5f, 1.1f, -0.8f),new Vector2f(0.1875f, 0.8125f),new Vector2f(0.25f, 0.75f),new Vector2f(0.1875f, 1.0f),new Vector3f(0.0f, 3.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(-0.4f, 0.1f, -0.4f),new Vector3f(0.4f, 0.1f, -0.4f),new Vector3f(0.4f, 1.1f, -0.4f),new Vector2f(0.25f, 0.0625f),new Vector2f(0.75f, 0.0625f),new Vector2f(0.75f, 0.6875f),new Vector3f(0.0f, 0.0f, 3.0f));
		this.quads[9] = new ObjQuad(new Vector3f(0.4f, 1.1f, -0.4f),new Vector3f(-0.4f, 1.1f, -0.4f),new Vector3f(-0.4f, 0.1f, -0.4f),new Vector2f(0.75f, 0.6875f),new Vector2f(0.25f, 0.6875f),new Vector2f(0.25f, 0.0625f),new Vector3f(0.0f, 0.0f, 3.0f));
		this.quads[10] = new ObjQuad(new Vector3f(0.5f, 0.1f, -0.5f),new Vector3f(0.5f, 0.1f, -0.8f),new Vector3f(0.5f, 1.1f, -0.8f),new Vector2f(0.8125f, 0.0625f),new Vector2f(1.0f, 0.0625f),new Vector2f(1.0f, 0.6875f),new Vector3f(3.0f, 0.0f, 0.0f));
		this.quads[11] = new ObjQuad(new Vector3f(0.5f, 1.1f, -0.8f),new Vector3f(0.5f, 1.1f, -0.5f),new Vector3f(0.5f, 0.1f, -0.5f),new Vector2f(1.0f, 0.6875f),new Vector2f(0.8125f, 0.6875f),new Vector2f(0.8125f, 0.0625f),new Vector3f(3.0f, 0.0f, 0.0f));
		this.quads[12] = new ObjQuad(new Vector3f(0.5f, 0.1f, -0.8f),new Vector3f(-0.5f, 0.1f, -0.8f),new Vector3f(-0.5f, 1.1f, -0.8f),new Vector2f(0.1875f, 0.0625f),new Vector2f(0.8125f, 0.0625f),new Vector2f(0.8125f, 0.6875f),new Vector3f(0.0f, 0.0f, -3.0f));
		this.quads[13] = new ObjQuad(new Vector3f(-0.5f, 1.1f, -0.8f),new Vector3f(0.5f, 1.1f, -0.8f),new Vector3f(0.5f, 0.1f, -0.8f),new Vector2f(0.8125f, 0.6875f),new Vector2f(0.1875f, 0.6875f),new Vector2f(0.1875f, 0.0625f),new Vector3f(0.0f, 0.0f, -3.0f));
		this.quads[14] = new ObjQuad(new Vector3f(-0.5f, 0.1f, -0.8f),new Vector3f(-0.5f, 0.1f, -0.5f),new Vector3f(-0.5f, 1.1f, -0.5f),new Vector2f(0.0f, 0.0625f),new Vector2f(0.1875f, 0.0625f),new Vector2f(0.1875f, 0.6875f),new Vector3f(-3.0f, 0.0f, 0.0f));
		this.quads[15] = new ObjQuad(new Vector3f(-0.5f, 1.1f, -0.5f),new Vector3f(-0.5f, 1.1f, -0.8f),new Vector3f(-0.5f, 0.1f, -0.8f),new Vector2f(0.1875f, 0.6875f),new Vector2f(0.0f, 0.6875f),new Vector2f(0.0f, 0.0625f),new Vector3f(-3.0f, 0.0f, 0.0f));
		this.quads[16] = new ObjQuad(new Vector3f(0.4f, 0.1f, -0.4f),new Vector3f(0.5f, 0.1f, -0.5f),new Vector3f(0.5f, 1.1f, -0.5f),new Vector2f(0.75f, 0.0625f),new Vector2f(0.8125f, 0.0625f),new Vector2f(0.8125f, 0.6875f),new Vector3f(2.121321f, 0.0f, 2.121321f));
		this.quads[17] = new ObjQuad(new Vector3f(0.5f, 1.1f, -0.5f),new Vector3f(0.4f, 1.1f, -0.4f),new Vector3f(0.4f, 0.1f, -0.4f),new Vector2f(0.8125f, 0.6875f),new Vector2f(0.75f, 0.6875f),new Vector2f(0.75f, 0.0625f),new Vector3f(2.121321f, 0.0f, 2.121321f));
		this.quads[18] = new ObjQuad(new Vector3f(-0.4f, 1.1f, -0.4f),new Vector3f(-0.5f, 1.1f, -0.5f),new Vector3f(-0.5f, 0.1f, -0.5f),new Vector2f(0.25f, 0.6875f),new Vector2f(0.1875f, 0.6875f),new Vector2f(0.1875f, 0.0625f),new Vector3f(-2.121321f, 0.0f, 2.121321f));
		this.quads[19] = new ObjQuad(new Vector3f(-0.5f, 0.1f, -0.5f),new Vector3f(-0.4f, 0.1f, -0.4f),new Vector3f(-0.4f, 1.1f, -0.4f),new Vector2f(0.1875f, 0.0625f),new Vector2f(0.25f, 0.0625f),new Vector2f(0.25f, 0.6875f),new Vector3f(-2.121321f, 0.0f, 2.121321f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		InterfaceBox other = new InterfaceBox();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

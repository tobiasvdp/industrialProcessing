package ip.industrialProcessing.machines.redstoneInterface.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class InterfaceAttachment extends ObjMesh{
	public InterfaceAttachment(){
		this.quads = new ObjQuad[20];
		this.quads[0] = new ObjQuad(new Vector3f(-0.4f, 0.2f, -0.8f),new Vector3f(-0.4f, 0.2f, -0.9f),new Vector3f(-0.3f, 0.2f, -0.9f),new Vector2f(0.75f, 0.0f),new Vector2f(0.75f, 0.0625f),new Vector2f(0.6875f, 0.0625f),new Vector3f(0.0f, -3.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.3f, 0.2f, -0.9f),new Vector3f(-0.3f, 0.2f, -0.8f),new Vector3f(-0.4f, 0.2f, -0.8f),new Vector2f(0.6875f, 0.0625f),new Vector2f(0.6875f, 0.0f),new Vector2f(0.75f, 0.0f),new Vector3f(0.0f, -3.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.4f, 1.0f, -0.8f),new Vector3f(-0.3f, 1.0f, -0.8f),new Vector3f(-0.3f, 1.0f, -0.9f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.625f, 0.0f),new Vector2f(0.625f, 0.0625f),new Vector3f(0.0f, 3.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.3f, 1.0f, -0.9f),new Vector3f(-0.4f, 1.0f, -0.9f),new Vector3f(-0.4f, 1.0f, -0.8f),new Vector2f(0.625f, 0.0625f),new Vector2f(0.5625f, 0.0625f),new Vector2f(0.5625f, 0.0f),new Vector3f(0.0f, 3.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.3f, 0.2f, -0.8f),new Vector3f(-0.3f, 0.2f, -0.9f),new Vector3f(-0.3f, 1.0f, -0.9f),new Vector2f(0.3125f, 0.0625f),new Vector2f(0.375f, 0.0625f),new Vector2f(0.375f, 0.5625f),new Vector3f(3.0f, 0.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.3f, 1.0f, -0.9f),new Vector3f(-0.3f, 1.0f, -0.8f),new Vector3f(-0.3f, 0.2f, -0.8f),new Vector2f(0.375f, 0.5625f),new Vector2f(0.3125f, 0.5625f),new Vector2f(0.3125f, 0.0625f),new Vector3f(3.0f, 0.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.3f, 0.2f, -0.9f),new Vector3f(-0.4f, 0.2f, -0.9f),new Vector3f(-0.4f, 1.0f, -0.9f),new Vector2f(0.6875f, 0.0625f),new Vector2f(0.75f, 0.0625f),new Vector2f(0.75f, 0.5625f),new Vector3f(0.0f, 0.0f, -3.0f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.4f, 1.0f, -0.9f),new Vector3f(-0.3f, 1.0f, -0.9f),new Vector3f(-0.3f, 0.2f, -0.9f),new Vector2f(0.75f, 0.5625f),new Vector2f(0.6875f, 0.5625f),new Vector2f(0.6875f, 0.0625f),new Vector3f(0.0f, 0.0f, -3.0f));
		this.quads[8] = new ObjQuad(new Vector3f(-0.4f, 0.2f, -0.9f),new Vector3f(-0.4f, 0.2f, -0.8f),new Vector3f(-0.4f, 1.0f, -0.8f),new Vector2f(0.9375f, 0.0625f),new Vector2f(1.0f, 0.0625f),new Vector2f(1.0f, 0.5625f),new Vector3f(-3.0f, 0.0f, 0.0f));
		this.quads[9] = new ObjQuad(new Vector3f(-0.4f, 1.0f, -0.8f),new Vector3f(-0.4f, 1.0f, -0.9f),new Vector3f(-0.4f, 0.2f, -0.9f),new Vector2f(1.0f, 0.5625f),new Vector2f(0.9375f, 0.5625f),new Vector2f(0.9375f, 0.0625f),new Vector3f(-3.0f, 0.0f, 0.0f));
		this.quads[10] = new ObjQuad(new Vector3f(0.3f, 0.2f, -0.8f),new Vector3f(0.3f, 0.2f, -0.9f),new Vector3f(0.4f, 0.2f, -0.9f),new Vector2f(0.625f, -0.0f),new Vector2f(0.625f, 0.0625f),new Vector2f(0.5625f, 0.0625f),new Vector3f(0.0f, -3.0f, 0.0f));
		this.quads[11] = new ObjQuad(new Vector3f(0.4f, 0.2f, -0.9f),new Vector3f(0.4f, 0.2f, -0.8f),new Vector3f(0.3f, 0.2f, -0.8f),new Vector2f(0.5625f, 0.0625f),new Vector2f(0.5625f, -0.0f),new Vector2f(0.625f, -0.0f),new Vector3f(0.0f, -3.0f, 0.0f));
		this.quads[12] = new ObjQuad(new Vector3f(0.3f, 1.0f, -0.8f),new Vector3f(0.4f, 1.0f, -0.8f),new Vector3f(0.4f, 1.0f, -0.9f),new Vector2f(0.6875f, -0.0f),new Vector2f(0.75f, -0.0f),new Vector2f(0.75f, 0.0625f),new Vector3f(0.0f, 3.0f, 0.0f));
		this.quads[13] = new ObjQuad(new Vector3f(0.4f, 1.0f, -0.9f),new Vector3f(0.3f, 1.0f, -0.9f),new Vector3f(0.3f, 1.0f, -0.8f),new Vector2f(0.75f, 0.0625f),new Vector2f(0.6875f, 0.0625f),new Vector2f(0.6875f, -0.0f),new Vector3f(0.0f, 3.0f, 0.0f));
		this.quads[14] = new ObjQuad(new Vector3f(0.4f, 0.2f, -0.8f),new Vector3f(0.4f, 0.2f, -0.9f),new Vector3f(0.4f, 1.0f, -0.9f),new Vector2f(0.3125f, 0.0625f),new Vector2f(0.375f, 0.0625f),new Vector2f(0.375f, 0.5625f),new Vector3f(3.0f, 0.0f, 0.0f));
		this.quads[15] = new ObjQuad(new Vector3f(0.4f, 1.0f, -0.9f),new Vector3f(0.4f, 1.0f, -0.8f),new Vector3f(0.4f, 0.2f, -0.8f),new Vector2f(0.375f, 0.5625f),new Vector2f(0.3125f, 0.5625f),new Vector2f(0.3125f, 0.0625f),new Vector3f(3.0f, 0.0f, 0.0f));
		this.quads[16] = new ObjQuad(new Vector3f(0.4f, 0.2f, -0.9f),new Vector3f(0.3f, 0.2f, -0.9f),new Vector3f(0.3f, 1.0f, -0.9f),new Vector2f(0.5625f, 0.0625f),new Vector2f(0.625f, 0.0625f),new Vector2f(0.625f, 0.5625f),new Vector3f(0.0f, 0.0f, -3.0f));
		this.quads[17] = new ObjQuad(new Vector3f(0.3f, 1.0f, -0.9f),new Vector3f(0.4f, 1.0f, -0.9f),new Vector3f(0.4f, 0.2f, -0.9f),new Vector2f(0.625f, 0.5625f),new Vector2f(0.5625f, 0.5625f),new Vector2f(0.5625f, 0.0625f),new Vector3f(0.0f, 0.0f, -3.0f));
		this.quads[18] = new ObjQuad(new Vector3f(0.3f, 0.2f, -0.9f),new Vector3f(0.3f, 0.2f, -0.8f),new Vector3f(0.3f, 1.0f, -0.8f),new Vector2f(0.9375f, 0.0625f),new Vector2f(1.0f, 0.0625f),new Vector2f(1.0f, 0.5625f),new Vector3f(-3.0f, 0.0f, 0.0f));
		this.quads[19] = new ObjQuad(new Vector3f(0.3f, 1.0f, -0.8f),new Vector3f(0.3f, 1.0f, -0.9f),new Vector3f(0.3f, 0.2f, -0.9f),new Vector2f(1.0f, 0.5625f),new Vector2f(0.9375f, 0.5625f),new Vector2f(0.9375f, 0.0625f),new Vector3f(-3.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		InterfaceAttachment other = new InterfaceAttachment();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

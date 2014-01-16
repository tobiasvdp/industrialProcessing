package ip.industrialProcessing.power.storage.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class BatteryBoxHull extends ObjMesh{
	public BatteryBoxHull(){
		this.quads = new ObjQuad[41];
		this.quads[0] = new ObjQuad(new Vector3f(-0.7f, 0.2f, 0.6f),new Vector3f(-0.7f, 0.2f, -0.6f),new Vector3f(-0.6f, 0.2f, -0.7f),new Vector3f(0.7f, 0.2f, -0.6f),new Vector2f(0.9375f, 0.125f),new Vector2f(0.9375f, 0.875f),new Vector2f(0.875f, 0.9375f),new Vector2f(0.0625f, 0.875f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.6f, 0.2f, -0.7f),new Vector3f(0.6f, 0.2f, -0.7f),new Vector3f(0.7f, 0.2f, -0.6f),new Vector2f(0.875f, 0.9375f),new Vector2f(0.125f, 0.9375f),new Vector2f(0.0625f, 0.875f),new Vector3f(0.0f, -3.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.7f, 0.2f, -0.6f),new Vector3f(0.7f, 0.2f, 0.6f),new Vector3f(0.6f, 0.2f, 0.7f),new Vector3f(-0.7f, 0.2f, 0.6f),new Vector2f(0.0625f, 0.875f),new Vector2f(0.0625f, 0.125f),new Vector2f(0.125f, 0.0625f),new Vector2f(0.9375f, 0.125f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.6f, 0.2f, 0.7f),new Vector3f(-0.7f, 0.2f, 0.6f),new Vector3f(0.6f, 0.2f, 0.7f),new Vector2f(0.875f, 0.0625f),new Vector2f(0.9375f, 0.125f),new Vector2f(0.125f, 0.0625f),new Vector3f(0.0f, -3.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.5f, 0.9f, 0.5f),new Vector3f(0.5f, 0.9f, 0.5f),new Vector3f(0.5f, 0.9f, -0.5f),new Vector3f(-0.5f, 0.9f, -0.5f),new Vector2f(0.1875f, 0.1875f),new Vector2f(0.8125f, 0.1875f),new Vector2f(0.8125f, 0.8125f),new Vector2f(0.1875f, 0.8125f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.6f, 0.2f, 0.7f),new Vector3f(0.6f, 0.2f, 0.7f),new Vector3f(0.6f, 1.2f, 0.7f),new Vector3f(-0.6f, 1.2f, 0.7f),new Vector2f(0.125f, 0.1563f),new Vector2f(0.875f, 0.1563f),new Vector2f(0.875f, 0.7813f),new Vector2f(0.125f, 0.7813f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[6] = new ObjQuad(new Vector3f(0.7f, 0.2f, 0.6f),new Vector3f(0.7f, 0.2f, -0.6f),new Vector3f(0.7f, 1.2f, -0.6f),new Vector3f(0.7f, 1.2f, 0.6f),new Vector2f(0.125f, 0.1563f),new Vector2f(0.875f, 0.1563f),new Vector2f(0.875f, 0.7813f),new Vector2f(0.125f, 0.7813f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(0.6f, 0.2f, -0.7f),new Vector3f(-0.6f, 0.2f, -0.7f),new Vector3f(-0.6f, 1.2f, -0.7f),new Vector3f(0.6f, 1.2f, -0.7f),new Vector2f(0.125f, 0.1563f),new Vector2f(0.875f, 0.1563f),new Vector2f(0.875f, 0.7813f),new Vector2f(0.125f, 0.7813f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[8] = new ObjQuad(new Vector3f(-0.7f, 0.2f, -0.6f),new Vector3f(-0.7f, 0.2f, 0.6f),new Vector3f(-0.7f, 1.2f, 0.6f),new Vector3f(-0.7f, 1.2f, -0.6f),new Vector2f(0.125f, 0.1563f),new Vector2f(0.875f, 0.1563f),new Vector2f(0.875f, 0.7813f),new Vector2f(0.125f, 0.7813f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[9] = new ObjQuad(new Vector3f(0.6f, 0.2f, 0.7f),new Vector3f(0.7f, 0.2f, 0.6f),new Vector3f(0.7f, 1.2f, 0.6f),new Vector3f(0.6f, 1.2f, 0.7f),new Vector2f(0.875f, 0.1563f),new Vector2f(0.9375f, 0.1563f),new Vector2f(0.9375f, 0.7813f),new Vector2f(0.875f, 0.7813f),new Vector3f(2.8284f, 0.0f, 2.8284f));
		this.quads[10] = new ObjQuad(new Vector3f(-0.6f, 1.2f, 0.7f),new Vector3f(-0.7f, 1.2f, 0.6f),new Vector3f(-0.7f, 0.2f, 0.6f),new Vector3f(-0.6f, 0.2f, 0.7f),new Vector2f(0.9375f, 0.7813f),new Vector2f(0.875f, 0.7813f),new Vector2f(0.875f, 0.1563f),new Vector2f(0.9375f, 0.1563f),new Vector3f(-2.8284f, 0.0f, 2.8284f));
		this.quads[11] = new ObjQuad(new Vector3f(0.7f, 0.2f, -0.6f),new Vector3f(0.6f, 0.2f, -0.7f),new Vector3f(0.6f, 1.2f, -0.7f),new Vector3f(0.7f, 1.2f, -0.6f),new Vector2f(0.875f, 0.1563f),new Vector2f(0.9375f, 0.1563f),new Vector2f(0.9375f, 0.7813f),new Vector2f(0.875f, 0.7813f),new Vector3f(2.8284f, 0.0f, -2.8284f));
		this.quads[12] = new ObjQuad(new Vector3f(-0.6f, 0.2f, -0.7f),new Vector3f(-0.7f, 0.2f, -0.6f),new Vector3f(-0.7f, 1.2f, -0.6f),new Vector3f(-0.6f, 1.2f, -0.7f),new Vector2f(0.875f, 0.1563f),new Vector2f(0.9375f, 0.1563f),new Vector2f(0.9375f, 0.7813f),new Vector2f(0.875f, 0.7813f),new Vector3f(-2.8284f, 0.0f, -2.8284f));
		this.quads[13] = new ObjQuad(new Vector3f(-0.6f, 1.2f, 0.7f),new Vector3f(0.6f, 1.2f, 0.7f),new Vector3f(0.5586f, 1.2f, 0.6f),new Vector3f(-0.5586f, 1.2f, 0.6f),new Vector2f(0.125f, 0.0625f),new Vector2f(0.875f, 0.0625f),new Vector2f(0.8491f, 0.125f),new Vector2f(0.1509f, 0.125f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[14] = new ObjQuad(new Vector3f(0.6f, 1.2f, 0.7f),new Vector3f(0.7f, 1.2f, 0.6f),new Vector3f(0.6f, 1.2f, 0.5586f),new Vector3f(0.5586f, 1.2f, 0.6f),new Vector2f(0.875f, 0.0625f),new Vector2f(0.9375f, 0.125f),new Vector2f(0.875f, 0.1509f),new Vector2f(0.8491f, 0.125f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[15] = new ObjQuad(new Vector3f(0.7f, 1.2f, 0.6f),new Vector3f(0.7f, 1.2f, -0.6f),new Vector3f(0.6f, 1.2f, -0.5586f),new Vector3f(0.6f, 1.2f, 0.5586f),new Vector2f(0.9375f, 0.125f),new Vector2f(0.9375f, 0.875f),new Vector2f(0.875f, 0.8491f),new Vector2f(0.875f, 0.1509f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[16] = new ObjQuad(new Vector3f(0.7f, 1.2f, -0.6f),new Vector3f(0.6f, 1.2f, -0.7f),new Vector3f(0.5586f, 1.2f, -0.6f),new Vector3f(0.6f, 1.2f, -0.5586f),new Vector2f(0.9375f, 0.875f),new Vector2f(0.875f, 0.9375f),new Vector2f(0.8491f, 0.875f),new Vector2f(0.875f, 0.8491f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[17] = new ObjQuad(new Vector3f(0.6f, 1.2f, -0.7f),new Vector3f(-0.6f, 1.2f, -0.7f),new Vector3f(-0.5586f, 1.2f, -0.6f),new Vector3f(0.5586f, 1.2f, -0.6f),new Vector2f(0.875f, 0.9375f),new Vector2f(0.125f, 0.9375f),new Vector2f(0.1509f, 0.875f),new Vector2f(0.8491f, 0.875f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[18] = new ObjQuad(new Vector3f(-0.6f, 1.2f, -0.7f),new Vector3f(-0.7f, 1.2f, -0.6f),new Vector3f(-0.6f, 1.2f, -0.5586f),new Vector3f(-0.5586f, 1.2f, -0.6f),new Vector2f(0.125f, 0.9375f),new Vector2f(0.0625f, 0.875f),new Vector2f(0.125f, 0.8491f),new Vector2f(0.1509f, 0.875f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[19] = new ObjQuad(new Vector3f(-0.7f, 1.2f, -0.6f),new Vector3f(-0.7f, 1.2f, 0.6f),new Vector3f(-0.6f, 1.2f, 0.5586f),new Vector3f(-0.6f, 1.2f, -0.5586f),new Vector2f(0.0625f, 0.875f),new Vector2f(0.0625f, 0.125f),new Vector2f(0.125f, 0.1509f),new Vector2f(0.125f, 0.8491f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[20] = new ObjQuad(new Vector3f(-0.7f, 1.2f, 0.6f),new Vector3f(-0.6f, 1.2f, 0.7f),new Vector3f(-0.5586f, 1.2f, 0.6f),new Vector3f(-0.6f, 1.2f, 0.5586f),new Vector2f(0.0625f, 0.125f),new Vector2f(0.125f, 0.0625f),new Vector2f(0.1509f, 0.125f),new Vector2f(0.125f, 0.1509f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[21] = new ObjQuad(new Vector3f(-0.5586f, 1.2f, 0.6f),new Vector3f(0.5586f, 1.2f, 0.6f),new Vector3f(0.5586f, 1.3f, 0.6f),new Vector3f(-0.5586f, 1.3f, 0.6f),new Vector2f(0.1509f, 0.7813f),new Vector2f(0.8491f, 0.7813f),new Vector2f(0.8491f, 0.8438f),new Vector2f(0.1509f, 0.8438f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[22] = new ObjQuad(new Vector3f(0.5586f, 1.2f, 0.6f),new Vector3f(0.6f, 1.2f, 0.5586f),new Vector3f(0.6f, 1.3f, 0.5586f),new Vector3f(0.5586f, 1.3f, 0.6f),new Vector2f(0.8491f, 0.7813f),new Vector2f(0.875f, 0.7813f),new Vector2f(0.875f, 0.8438f),new Vector2f(0.8491f, 0.8438f),new Vector3f(2.8284f, 0.0f, 2.8284f));
		this.quads[23] = new ObjQuad(new Vector3f(0.6f, 1.2f, 0.5586f),new Vector3f(0.6f, 1.2f, -0.5586f),new Vector3f(0.6f, 1.3f, -0.5586f),new Vector3f(0.6f, 1.3f, 0.5586f),new Vector2f(0.1509f, 0.7813f),new Vector2f(0.8491f, 0.7813f),new Vector2f(0.8491f, 0.8438f),new Vector2f(0.1509f, 0.8438f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[24] = new ObjQuad(new Vector3f(0.6f, 1.2f, -0.5586f),new Vector3f(0.5586f, 1.2f, -0.6f),new Vector3f(0.5586f, 1.3f, -0.6f),new Vector3f(0.6f, 1.3f, -0.5586f),new Vector2f(0.125f, 0.7813f),new Vector2f(0.1509f, 0.7813f),new Vector2f(0.1509f, 0.8438f),new Vector2f(0.125f, 0.8438f),new Vector3f(2.8284f, 0.0f, -2.8284f));
		this.quads[25] = new ObjQuad(new Vector3f(0.5586f, 1.2f, -0.6f),new Vector3f(-0.5586f, 1.2f, -0.6f),new Vector3f(-0.5586f, 1.3f, -0.6f),new Vector3f(0.5586f, 1.3f, -0.6f),new Vector2f(0.1509f, 0.7813f),new Vector2f(0.8491f, 0.7813f),new Vector2f(0.8491f, 0.8438f),new Vector2f(0.1509f, 0.8438f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[26] = new ObjQuad(new Vector3f(-0.5586f, 1.2f, -0.6f),new Vector3f(-0.6f, 1.2f, -0.5586f),new Vector3f(-0.6f, 1.3f, -0.5586f),new Vector3f(-0.5586f, 1.3f, -0.6f),new Vector2f(0.8491f, 0.7813f),new Vector2f(0.875f, 0.7813f),new Vector2f(0.875f, 0.8438f),new Vector2f(0.8491f, 0.8438f),new Vector3f(-2.8284f, 0.0f, -2.8284f));
		this.quads[27] = new ObjQuad(new Vector3f(-0.6f, 1.2f, -0.5586f),new Vector3f(-0.6f, 1.2f, 0.5586f),new Vector3f(-0.6f, 1.3f, 0.5586f),new Vector3f(-0.6f, 1.3f, -0.5586f),new Vector2f(0.1509f, 0.7813f),new Vector2f(0.8491f, 0.7813f),new Vector2f(0.8491f, 0.8438f),new Vector2f(0.1509f, 0.8438f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[28] = new ObjQuad(new Vector3f(-0.6f, 1.2f, 0.5586f),new Vector3f(-0.5586f, 1.2f, 0.6f),new Vector3f(-0.5586f, 1.3f, 0.6f),new Vector3f(-0.6f, 1.3f, 0.5586f),new Vector2f(0.8491f, 0.7813f),new Vector2f(0.875f, 0.7813f),new Vector2f(0.875f, 0.8438f),new Vector2f(0.8491f, 0.8438f),new Vector3f(-2.8284f, 0.0f, 2.8284f));
		this.quads[29] = new ObjQuad(new Vector3f(-0.5586f, 1.3f, 0.6f),new Vector3f(0.5586f, 1.3f, 0.6f),new Vector3f(0.5f, 1.3f, 0.5f),new Vector3f(-0.5f, 1.3f, 0.5f),new Vector2f(0.1509f, 0.125f),new Vector2f(0.8491f, 0.125f),new Vector2f(0.8125f, 0.1875f),new Vector2f(0.1875f, 0.1875f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[30] = new ObjQuad(new Vector3f(0.5586f, 1.3f, 0.6f),new Vector3f(0.6f, 1.3f, 0.5586f),new Vector3f(0.5f, 1.3f, 0.5f),new Vector2f(0.8491f, 0.125f),new Vector2f(0.875f, 0.1509f),new Vector2f(0.8125f, 0.1875f),new Vector3f(0.0f, 3.0f, 0.0f));
		this.quads[31] = new ObjQuad(new Vector3f(0.6f, 1.3f, 0.5586f),new Vector3f(0.6f, 1.3f, -0.5586f),new Vector3f(0.5f, 1.3f, -0.5f),new Vector3f(0.5f, 1.3f, 0.5f),new Vector2f(0.875f, 0.1509f),new Vector2f(0.875f, 0.8491f),new Vector2f(0.8125f, 0.8125f),new Vector2f(0.8125f, 0.1875f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[32] = new ObjQuad(new Vector3f(0.6f, 1.3f, -0.5586f),new Vector3f(0.5586f, 1.3f, -0.6f),new Vector3f(0.5f, 1.3f, -0.5f),new Vector2f(0.875f, 0.8491f),new Vector2f(0.8491f, 0.875f),new Vector2f(0.8125f, 0.8125f),new Vector3f(0.0f, 3.0f, 0.0f));
		this.quads[33] = new ObjQuad(new Vector3f(0.5586f, 1.3f, -0.6f),new Vector3f(-0.5586f, 1.3f, -0.6f),new Vector3f(-0.5f, 1.3f, -0.5f),new Vector3f(0.5f, 1.3f, -0.5f),new Vector2f(0.8491f, 0.875f),new Vector2f(0.1509f, 0.875f),new Vector2f(0.1875f, 0.8125f),new Vector2f(0.8125f, 0.8125f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[34] = new ObjQuad(new Vector3f(-0.5586f, 1.3f, -0.6f),new Vector3f(-0.6f, 1.3f, -0.5586f),new Vector3f(-0.5f, 1.3f, -0.5f),new Vector2f(0.1509f, 0.875f),new Vector2f(0.125f, 0.8491f),new Vector2f(0.1875f, 0.8125f),new Vector3f(0.0f, 3.0f, 0.0f));
		this.quads[35] = new ObjQuad(new Vector3f(-0.6f, 1.3f, -0.5586f),new Vector3f(-0.6f, 1.3f, 0.5586f),new Vector3f(-0.5f, 1.3f, 0.5f),new Vector3f(-0.5f, 1.3f, -0.5f),new Vector2f(0.125f, 0.8491f),new Vector2f(0.125f, 0.1509f),new Vector2f(0.1875f, 0.1875f),new Vector2f(0.1875f, 0.8125f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[36] = new ObjQuad(new Vector3f(-0.6f, 1.3f, 0.5586f),new Vector3f(-0.5586f, 1.3f, 0.6f),new Vector3f(-0.5f, 1.3f, 0.5f),new Vector2f(0.125f, 0.1509f),new Vector2f(0.1509f, 0.125f),new Vector2f(0.1875f, 0.1875f),new Vector3f(0.0f, 3.0f, 0.0f));
		this.quads[37] = new ObjQuad(new Vector3f(-0.5f, 1.3f, 0.5f),new Vector3f(0.5f, 1.3f, 0.5f),new Vector3f(0.5f, 0.9f, 0.5f),new Vector3f(-0.5f, 0.9f, 0.5f),new Vector2f(0.8125f, 0.8438f),new Vector2f(0.1875f, 0.8438f),new Vector2f(0.1875f, 0.5938f),new Vector2f(0.8125f, 0.5938f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[38] = new ObjQuad(new Vector3f(0.5f, 1.3f, 0.5f),new Vector3f(0.5f, 1.3f, -0.5f),new Vector3f(0.5f, 0.9f, -0.5f),new Vector3f(0.5f, 0.9f, 0.5f),new Vector2f(0.8125f, 0.8438f),new Vector2f(0.1875f, 0.8438f),new Vector2f(0.1875f, 0.5938f),new Vector2f(0.8125f, 0.5938f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[39] = new ObjQuad(new Vector3f(0.5f, 1.3f, -0.5f),new Vector3f(-0.5f, 1.3f, -0.5f),new Vector3f(-0.5f, 0.9f, -0.5f),new Vector3f(0.5f, 0.9f, -0.5f),new Vector2f(0.8125f, 0.8438f),new Vector2f(0.1875f, 0.8438f),new Vector2f(0.1875f, 0.5938f),new Vector2f(0.8125f, 0.5938f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[40] = new ObjQuad(new Vector3f(-0.5f, 1.3f, -0.5f),new Vector3f(-0.5f, 1.3f, 0.5f),new Vector3f(-0.5f, 0.9f, 0.5f),new Vector3f(-0.5f, 0.9f, -0.5f),new Vector2f(0.8125f, 0.8438f),new Vector2f(0.1875f, 0.8438f),new Vector2f(0.1875f, 0.5938f),new Vector2f(0.8125f, 0.5938f),new Vector3f(4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		BatteryBoxHull other = new BatteryBoxHull();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

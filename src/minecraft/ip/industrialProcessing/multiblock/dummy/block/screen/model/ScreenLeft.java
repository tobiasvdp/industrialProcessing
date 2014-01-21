package ip.industrialProcessing.multiblock.dummy.block.screen.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class ScreenLeft extends ObjMesh{
	public ScreenLeft(){
		this.quads = new ObjQuad[112];
		this.quads[0] = new ObjQuad(new Vector3f(-0.8f, 0.0f, 0.8f),new Vector3f(-0.8f, 0.0f, 0.7f),new Vector3f(-0.7f, 0.0f, 0.7f),new Vector3f(-0.7f, 0.0f, 0.8f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 0.0625f),new Vector2f(0.9375f, 0.0625f),new Vector2f(0.9375f, 0.0f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.8f, 0.0f, 0.7f),new Vector3f(-0.8f, 0.0f, 0.6f),new Vector3f(-0.7f, 0.0f, 0.6f),new Vector3f(-0.7f, 0.0f, 0.7f),new Vector2f(1.0f, 0.0625f),new Vector2f(1.0f, 0.125f),new Vector2f(0.9375f, 0.125f),new Vector2f(0.9375f, 0.0625f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.8f, 0.0f, 0.6f),new Vector3f(-0.8f, 0.0f, 0.5f),new Vector3f(-0.7f, 0.0f, 0.5f),new Vector3f(-0.7f, 0.0f, 0.6f),new Vector2f(1.0f, 0.125f),new Vector2f(1.0f, 0.1875f),new Vector2f(0.9375f, 0.1875f),new Vector2f(0.9375f, 0.125f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.8f, 0.0f, 0.5f),new Vector3f(-0.8f, 0.0f, 0.4f),new Vector3f(-0.7f, 0.0f, 0.4f),new Vector3f(-0.7f, 0.0f, 0.5f),new Vector2f(1.0f, 0.1875f),new Vector2f(1.0f, 0.25f),new Vector2f(0.9375f, 0.25f),new Vector2f(0.9375f, 0.1875f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.8f, 0.0f, 0.4f),new Vector3f(-0.8f, 0.0f, 0.3f),new Vector3f(-0.7f, 0.0f, 0.3f),new Vector3f(-0.7f, 0.0f, 0.4f),new Vector2f(1.0f, 0.25f),new Vector2f(1.0f, 0.3125f),new Vector2f(0.9375f, 0.3125f),new Vector2f(0.9375f, 0.25f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.8f, 0.0f, 0.3f),new Vector3f(-0.8f, 0.0f, 0.2f),new Vector3f(-0.7f, 0.0f, 0.2f),new Vector3f(-0.7f, 0.0f, 0.3f),new Vector2f(1.0f, 0.3125f),new Vector2f(1.0f, 0.375f),new Vector2f(0.9375f, 0.375f),new Vector2f(0.9375f, 0.3125f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.8f, 0.0f, 0.2f),new Vector3f(-0.8f, 0.0f, 0.1f),new Vector3f(-0.7f, 0.0f, 0.1f),new Vector3f(-0.7f, 0.0f, 0.2f),new Vector2f(1.0f, 0.375f),new Vector2f(1.0f, 0.4375f),new Vector2f(0.9375f, 0.4375f),new Vector2f(0.9375f, 0.375f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.8f, 0.0f, 0.1f),new Vector3f(-0.8f, 0.0f, -0.0f),new Vector3f(-0.7f, 0.0f, -0.0f),new Vector3f(-0.7f, 0.0f, 0.1f),new Vector2f(1.0f, 0.4375f),new Vector2f(1.0f, 0.5f),new Vector2f(0.9375f, 0.5f),new Vector2f(0.9375f, 0.4375f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(-0.8f, 0.0f, -0.0f),new Vector3f(-0.8f, 0.0f, -0.1f),new Vector3f(-0.7f, 0.0f, -0.1f),new Vector3f(-0.7f, 0.0f, -0.0f),new Vector2f(1.0f, 0.5f),new Vector2f(1.0f, 0.5625f),new Vector2f(0.9375f, 0.5625f),new Vector2f(0.9375f, 0.5f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[9] = new ObjQuad(new Vector3f(-0.8f, 0.0f, -0.1f),new Vector3f(-0.8f, 0.0f, -0.2f),new Vector3f(-0.7f, 0.0f, -0.2f),new Vector3f(-0.7f, 0.0f, -0.1f),new Vector2f(1.0f, 0.5625f),new Vector2f(1.0f, 0.625f),new Vector2f(0.9375f, 0.625f),new Vector2f(0.9375f, 0.5625f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[10] = new ObjQuad(new Vector3f(-0.8f, 0.0f, -0.2f),new Vector3f(-0.8f, 0.0f, -0.3f),new Vector3f(-0.7f, 0.0f, -0.3f),new Vector3f(-0.7f, 0.0f, -0.2f),new Vector2f(1.0f, 0.625f),new Vector2f(1.0f, 0.6875f),new Vector2f(0.9375f, 0.6875f),new Vector2f(0.9375f, 0.625f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[11] = new ObjQuad(new Vector3f(-0.8f, 0.6f, 0.8f),new Vector3f(-0.7f, 0.6f, 0.8f),new Vector3f(-0.7f, 0.6f, 0.7f),new Vector3f(-0.8f, 0.6f, 0.7f),new Vector2f(-0.0f, 0.0f),new Vector2f(0.0625f, 0.0f),new Vector2f(0.0625f, 0.0625f),new Vector2f(-0.0f, 0.0625f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[12] = new ObjQuad(new Vector3f(-0.8f, 0.6f, 0.7f),new Vector3f(-0.7f, 0.6f, 0.7f),new Vector3f(-0.7f, 0.6f, 0.6f),new Vector3f(-0.8f, 0.6f, 0.6f),new Vector2f(-0.0f, 0.0625f),new Vector2f(0.0625f, 0.0625f),new Vector2f(0.0625f, 0.125f),new Vector2f(-0.0f, 0.125f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[13] = new ObjQuad(new Vector3f(-0.8f, 0.6f, 0.6f),new Vector3f(-0.7f, 0.6f, 0.6f),new Vector3f(-0.7f, 0.6f, 0.5f),new Vector3f(-0.8f, 0.6f, 0.5f),new Vector2f(-0.0f, 0.125f),new Vector2f(0.0625f, 0.125f),new Vector2f(0.0625f, 0.1875f),new Vector2f(-0.0f, 0.1875f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[14] = new ObjQuad(new Vector3f(-0.8f, 0.6f, 0.5f),new Vector3f(-0.7f, 0.6f, 0.5f),new Vector3f(-0.7f, 0.6f, 0.4f),new Vector3f(-0.8f, 0.6f, 0.4f),new Vector2f(-0.0f, 0.1875f),new Vector2f(0.0625f, 0.1875f),new Vector2f(0.0625f, 0.25f),new Vector2f(-0.0f, 0.25f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[15] = new ObjQuad(new Vector3f(-0.8f, 0.6f, 0.4f),new Vector3f(-0.7f, 0.6f, 0.4f),new Vector3f(-0.7f, 0.6f, 0.3f),new Vector3f(-0.8f, 0.6f, 0.3f),new Vector2f(-0.0f, 0.25f),new Vector2f(0.0625f, 0.25f),new Vector2f(0.0625f, 0.3125f),new Vector2f(-0.0f, 0.3125f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[16] = new ObjQuad(new Vector3f(-0.8f, 0.6f, 0.3f),new Vector3f(-0.7f, 0.6f, 0.3f),new Vector3f(-0.7f, 0.6f, 0.2f),new Vector3f(-0.8f, 0.6f, 0.2f),new Vector2f(-0.0f, 0.3125f),new Vector2f(0.0625f, 0.3125f),new Vector2f(0.0625f, 0.375f),new Vector2f(-0.0f, 0.375f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[17] = new ObjQuad(new Vector3f(-0.8f, 0.6f, 0.2f),new Vector3f(-0.7f, 0.6f, 0.2f),new Vector3f(-0.7f, 0.6f, 0.1f),new Vector3f(-0.8f, 0.6f, 0.1f),new Vector2f(-0.0f, 0.375f),new Vector2f(0.0625f, 0.375f),new Vector2f(0.0625f, 0.4375f),new Vector2f(-0.0f, 0.4375f),new Vector3f(0.0f, 3.9464002f, 0.4596f));
		this.quads[18] = new ObjQuad(new Vector3f(-0.8f, 0.6f, 0.1f),new Vector3f(-0.7f, 0.6f, 0.1f),new Vector3f(-0.7f, 0.65f, -0.0f),new Vector3f(-0.8f, 0.65f, -0.0f),new Vector2f(-0.0f, 0.4375f),new Vector2f(0.0625f, 0.4375f),new Vector2f(0.0625f, 0.5f),new Vector2f(0.0f, 0.5f),new Vector3f(0.0f, 3.5688f, 1.629f));
		this.quads[19] = new ObjQuad(new Vector3f(-0.8f, 0.65f, -0.0f),new Vector3f(-0.7f, 0.65f, -0.0f),new Vector3f(-0.7f, 0.75f, -0.1f),new Vector3f(-0.8f, 0.75f, -0.1f),new Vector2f(0.0f, 0.4063f),new Vector2f(0.0625f, 0.4063f),new Vector2f(0.0625f, 0.4688f),new Vector2f(0.0f, 0.4688f),new Vector3f(0.0f, 2.8904002f, 2.7159998f));
		this.quads[20] = new ObjQuad(new Vector3f(-0.8f, 0.75f, -0.1f),new Vector3f(-0.7f, 0.75f, -0.1f),new Vector3f(-0.7f, 0.9f, -0.2f),new Vector3f(-0.8f, 0.9f, -0.2f),new Vector2f(0.0f, 0.4688f),new Vector2f(0.0625f, 0.4688f),new Vector2f(0.0625f, 0.5625f),new Vector2f(0.0f, 0.5625f),new Vector3f(0.0f, 2.7674f, 2.8702002f));
		this.quads[21] = new ObjQuad(new Vector3f(-0.8f, 0.9f, -0.2f),new Vector3f(-0.7f, 0.9f, -0.2f),new Vector3f(-0.7f, 0.95f, -0.3f),new Vector3f(-0.8f, 0.95f, -0.3f),new Vector2f(0.0f, 0.625f),new Vector2f(0.0625f, 0.625f),new Vector2f(0.0625f, 0.6875f),new Vector2f(0.0f, 0.6875f),new Vector3f(0.0f, 3.2882f, 2.2180002f));
		this.quads[22] = new ObjQuad(new Vector3f(-0.8f, 0.0f, 0.8f),new Vector3f(-0.7f, 0.0f, 0.8f),new Vector3f(-0.7f, 0.6f, 0.8f),new Vector3f(-0.8f, 0.6f, 0.8f),new Vector2f(-0.0f, 0.0f),new Vector2f(0.0625f, 0.0f),new Vector2f(0.0625f, 0.375f),new Vector2f(-0.0f, 0.375f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[23] = new ObjQuad(new Vector3f(-0.7f, 0.0f, 0.8f),new Vector3f(-0.7f, 0.0f, 0.7f),new Vector3f(-0.7f, 0.6f, 0.7f),new Vector3f(-0.7f, 0.6f, 0.8f),new Vector2f(0.0f, 0.0f),new Vector2f(0.0625f, 0.0f),new Vector2f(0.0625f, 0.375f),new Vector2f(0.0f, 0.375f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[24] = new ObjQuad(new Vector3f(-0.7f, 0.0f, 0.7f),new Vector3f(-0.7f, 0.0f, 0.6f),new Vector3f(-0.7f, 0.6f, 0.6f),new Vector3f(-0.7f, 0.6f, 0.7f),new Vector2f(0.0625f, 0.0f),new Vector2f(0.125f, 0.0f),new Vector2f(0.125f, 0.375f),new Vector2f(0.0625f, 0.375f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[25] = new ObjQuad(new Vector3f(-0.7f, 0.0f, 0.6f),new Vector3f(-0.7f, 0.0f, 0.5f),new Vector3f(-0.7f, 0.6f, 0.5f),new Vector3f(-0.7f, 0.6f, 0.6f),new Vector2f(0.125f, 0.0f),new Vector2f(0.1875f, 0.0f),new Vector2f(0.1875f, 0.375f),new Vector2f(0.125f, 0.375f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[26] = new ObjQuad(new Vector3f(-0.7f, 0.0f, 0.5f),new Vector3f(-0.7f, 0.0f, 0.4f),new Vector3f(-0.7f, 0.6f, 0.4f),new Vector3f(-0.7f, 0.6f, 0.5f),new Vector2f(0.1875f, 0.0f),new Vector2f(0.25f, 0.0f),new Vector2f(0.25f, 0.375f),new Vector2f(0.1875f, 0.375f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[27] = new ObjQuad(new Vector3f(-0.7f, 0.0f, 0.4f),new Vector3f(-0.7f, 0.0f, 0.3f),new Vector3f(-0.7f, 0.6f, 0.3f),new Vector3f(-0.7f, 0.6f, 0.4f),new Vector2f(0.25f, 0.0f),new Vector2f(0.3125f, 0.0f),new Vector2f(0.3125f, 0.375f),new Vector2f(0.25f, 0.375f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[28] = new ObjQuad(new Vector3f(-0.7f, 0.0f, 0.3f),new Vector3f(-0.7f, 0.0f, 0.2f),new Vector3f(-0.7f, 0.6f, 0.2f),new Vector3f(-0.7f, 0.6f, 0.3f),new Vector2f(0.3125f, 0.0f),new Vector2f(0.375f, 0.0f),new Vector2f(0.375f, 0.375f),new Vector2f(0.3125f, 0.375f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[29] = new ObjQuad(new Vector3f(-0.7f, 0.0f, 0.2f),new Vector3f(-0.7f, 0.0f, 0.1f),new Vector3f(-0.7f, 0.6f, 0.1f),new Vector3f(-0.7f, 0.6f, 0.2f),new Vector2f(0.375f, 0.0f),new Vector2f(0.4375f, 0.0f),new Vector2f(0.4375f, 0.375f),new Vector2f(0.375f, 0.375f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[30] = new ObjQuad(new Vector3f(-0.7f, 0.0f, 0.1f),new Vector3f(-0.7f, 0.0f, -0.0f),new Vector3f(-0.7f, 0.65f, -0.0f),new Vector3f(-0.7f, 0.6f, 0.1f),new Vector2f(0.4375f, 0.0f),new Vector2f(0.5f, 0.0f),new Vector2f(0.5f, 0.4063f),new Vector2f(0.4375f, 0.375f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[31] = new ObjQuad(new Vector3f(-0.7f, 0.0f, -0.0f),new Vector3f(-0.7f, 0.0f, -0.1f),new Vector3f(-0.7f, 0.75f, -0.1f),new Vector3f(-0.7f, 0.65f, -0.0f),new Vector2f(0.5f, 0.0f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.5625f, 0.4688f),new Vector2f(0.5f, 0.4063f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[32] = new ObjQuad(new Vector3f(-0.7f, 0.0f, -0.1f),new Vector3f(-0.7f, 0.0f, -0.2f),new Vector3f(-0.7f, 0.9f, -0.2f),new Vector3f(-0.7f, 0.75f, -0.1f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.625f, 0.0f),new Vector2f(0.625f, 0.5625f),new Vector2f(0.5625f, 0.4688f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[33] = new ObjQuad(new Vector3f(-0.7f, 0.0f, -0.2f),new Vector3f(-0.7f, 0.0f, -0.3f),new Vector3f(-0.7f, 0.95f, -0.3f),new Vector3f(-0.7f, 0.9f, -0.2f),new Vector2f(0.625f, 0.0f),new Vector2f(0.6875f, 0.0f),new Vector2f(0.6875f, 0.5938f),new Vector2f(0.625f, 0.5625f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[34] = new ObjQuad(new Vector3f(-0.7f, 0.0f, -0.3f),new Vector3f(-0.8f, 0.0f, -0.3f),new Vector3f(-0.8f, 0.95f, -0.3f),new Vector3f(-0.7f, 0.95f, -0.3f),new Vector2f(0.9375f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 0.5938f),new Vector2f(0.9375f, 0.5938f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[35] = new ObjQuad(new Vector3f(-0.8f, 0.0f, -0.3f),new Vector3f(-0.8f, 0.0f, -0.2f),new Vector3f(-0.8f, 0.9f, -0.2f),new Vector3f(-0.8f, 0.95f, -0.3f),new Vector2f(0.3125f, 0.0f),new Vector2f(0.375f, 0.0f),new Vector2f(0.375f, 0.5625f),new Vector2f(0.3125f, 0.5938f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[36] = new ObjQuad(new Vector3f(-0.8f, 0.0f, -0.2f),new Vector3f(-0.8f, 0.0f, -0.1f),new Vector3f(-0.8f, 0.75f, -0.1f),new Vector3f(-0.8f, 0.9f, -0.2f),new Vector2f(0.375f, 0.0f),new Vector2f(0.4375f, 0.0f),new Vector2f(0.4375f, 0.4688f),new Vector2f(0.375f, 0.5625f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[37] = new ObjQuad(new Vector3f(-0.8f, 0.0f, -0.1f),new Vector3f(-0.8f, 0.0f, -0.0f),new Vector3f(-0.8f, 0.65f, -0.0f),new Vector3f(-0.8f, 0.75f, -0.1f),new Vector2f(0.4375f, 0.0f),new Vector2f(0.5f, 0.0f),new Vector2f(0.5f, 0.4063f),new Vector2f(0.4375f, 0.4688f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[38] = new ObjQuad(new Vector3f(-0.8f, 0.0f, -0.0f),new Vector3f(-0.8f, 0.0f, 0.1f),new Vector3f(-0.8f, 0.6f, 0.1f),new Vector3f(-0.8f, 0.65f, -0.0f),new Vector2f(0.5f, 0.0f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.5625f, 0.375f),new Vector2f(0.5f, 0.4063f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[39] = new ObjQuad(new Vector3f(-0.8f, 0.0f, 0.1f),new Vector3f(-0.8f, 0.0f, 0.2f),new Vector3f(-0.8f, 0.6f, 0.2f),new Vector3f(-0.8f, 0.6f, 0.1f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.625f, 0.0f),new Vector2f(0.625f, 0.375f),new Vector2f(0.5625f, 0.375f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[40] = new ObjQuad(new Vector3f(-0.8f, 0.0f, 0.2f),new Vector3f(-0.8f, 0.0f, 0.3f),new Vector3f(-0.8f, 0.6f, 0.3f),new Vector3f(-0.8f, 0.6f, 0.2f),new Vector2f(0.625f, 0.0f),new Vector2f(0.6875f, 0.0f),new Vector2f(0.6875f, 0.375f),new Vector2f(0.625f, 0.375f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[41] = new ObjQuad(new Vector3f(-0.8f, 0.0f, 0.3f),new Vector3f(-0.8f, 0.0f, 0.4f),new Vector3f(-0.8f, 0.6f, 0.4f),new Vector3f(-0.8f, 0.6f, 0.3f),new Vector2f(0.6875f, 0.0f),new Vector2f(0.75f, 0.0f),new Vector2f(0.75f, 0.375f),new Vector2f(0.6875f, 0.375f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[42] = new ObjQuad(new Vector3f(-0.8f, 0.0f, 0.4f),new Vector3f(-0.8f, 0.0f, 0.5f),new Vector3f(-0.8f, 0.6f, 0.5f),new Vector3f(-0.8f, 0.6f, 0.4f),new Vector2f(0.75f, 0.0f),new Vector2f(0.8125f, 0.0f),new Vector2f(0.8125f, 0.375f),new Vector2f(0.75f, 0.375f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[43] = new ObjQuad(new Vector3f(-0.8f, 0.0f, 0.5f),new Vector3f(-0.8f, 0.0f, 0.6f),new Vector3f(-0.8f, 0.6f, 0.6f),new Vector3f(-0.8f, 0.6f, 0.5f),new Vector2f(0.8125f, 0.0f),new Vector2f(0.875f, 0.0f),new Vector2f(0.875f, 0.375f),new Vector2f(0.8125f, 0.375f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[44] = new ObjQuad(new Vector3f(-0.8f, 0.0f, 0.6f),new Vector3f(-0.8f, 0.0f, 0.7f),new Vector3f(-0.8f, 0.6f, 0.7f),new Vector3f(-0.8f, 0.6f, 0.6f),new Vector2f(0.875f, 0.0f),new Vector2f(0.9375f, 0.0f),new Vector2f(0.9375f, 0.375f),new Vector2f(0.875f, 0.375f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[45] = new ObjQuad(new Vector3f(-0.8f, 0.0f, 0.7f),new Vector3f(-0.8f, 0.0f, 0.8f),new Vector3f(-0.8f, 0.6f, 0.8f),new Vector3f(-0.8f, 0.6f, 0.7f),new Vector2f(0.9375f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 0.375f),new Vector2f(0.9375f, 0.375f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[46] = new ObjQuad(new Vector3f(-0.7f, 0.0f, -0.6f),new Vector3f(-0.7f, 0.0f, -0.3f),new Vector3f(-0.8f, 0.0f, -0.3f),new Vector3f(-0.8f, 0.0f, -0.4f),new Vector2f(0.9375f, 0.875f),new Vector2f(0.9375f, 0.6875f),new Vector2f(1.0f, 0.6875f),new Vector2f(1.0f, 0.75f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[47] = new ObjQuad(new Vector3f(-0.7f, 0.0f, -0.3f),new Vector3f(-0.7f, 0.0f, -0.6f),new Vector3f(-0.6f, 0.0f, -0.75f),new Vector3f(-0.6f, 0.0f, -0.6f),new Vector2f(0.9375f, 0.6875f),new Vector2f(0.9375f, 0.875f),new Vector2f(0.875f, 0.9688f),new Vector2f(0.875f, 0.875f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[48] = new ObjQuad(new Vector3f(-0.6f, 0.0f, -0.6f),new Vector3f(-0.6f, 0.0f, -0.75f),new Vector3f(-0.5f, 0.0f, -0.8f),new Vector3f(-0.5f, 0.0f, -0.7f),new Vector2f(0.875f, 0.875f),new Vector2f(0.875f, 0.9688f),new Vector2f(0.8125f, 1.0f),new Vector2f(0.8125f, 0.9375f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[49] = new ObjQuad(new Vector3f(-0.5f, 0.0f, -0.7f),new Vector3f(-0.5f, 0.0f, -0.8f),new Vector3f(-0.4f, 0.0f, -0.8f),new Vector3f(-0.4f, 0.0f, -0.7f),new Vector2f(0.8125f, 0.9375f),new Vector2f(0.8125f, 1.0f),new Vector2f(0.75f, 1.0f),new Vector2f(0.75f, 0.9375f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[50] = new ObjQuad(new Vector3f(-0.4f, 0.0f, -0.7f),new Vector3f(-0.4f, 0.0f, -0.8f),new Vector3f(-0.3f, 0.0f, -0.8f),new Vector3f(-0.3f, 0.0f, -0.7f),new Vector2f(0.75f, 0.9375f),new Vector2f(0.75f, 1.0f),new Vector2f(0.6875f, 1.0f),new Vector2f(0.6875f, 0.9375f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[51] = new ObjQuad(new Vector3f(-0.3f, 0.0f, -0.7f),new Vector3f(-0.3f, 0.0f, -0.8f),new Vector3f(-0.2f, 0.0f, -0.8f),new Vector3f(-0.2f, 0.0f, -0.7f),new Vector2f(0.6875f, 0.9375f),new Vector2f(0.6875f, 1.0f),new Vector2f(0.625f, 1.0f),new Vector2f(0.625f, 0.9375f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[52] = new ObjQuad(new Vector3f(-0.2f, 0.0f, -0.7f),new Vector3f(-0.2f, 0.0f, -0.8f),new Vector3f(-0.1f, 0.0f, -0.8f),new Vector3f(-0.1f, 0.0f, -0.7f),new Vector2f(0.625f, 0.9375f),new Vector2f(0.625f, 1.0f),new Vector2f(0.5625f, 1.0f),new Vector2f(0.5625f, 0.9375f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[53] = new ObjQuad(new Vector3f(-0.1f, 0.0f, -0.7f),new Vector3f(-0.1f, 0.0f, -0.8f),new Vector3f(0.0f, 0.0f, -0.8f),new Vector3f(0.0f, 0.0f, -0.7f),new Vector2f(0.5625f, 0.9375f),new Vector2f(0.5625f, 1.0f),new Vector2f(0.5f, 1.0f),new Vector2f(0.5f, 0.9375f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[54] = new ObjQuad(new Vector3f(0.0f, 0.0f, -0.7f),new Vector3f(0.0f, 0.0f, -0.8f),new Vector3f(0.1f, 0.0f, -0.8f),new Vector3f(0.1f, 0.0f, -0.7f),new Vector2f(0.5f, 0.9375f),new Vector2f(0.5f, 1.0f),new Vector2f(0.4375f, 1.0f),new Vector2f(0.4375f, 0.9375f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[55] = new ObjQuad(new Vector3f(0.1f, 0.0f, -0.7f),new Vector3f(0.1f, 0.0f, -0.8f),new Vector3f(0.2f, 0.0f, -0.8f),new Vector3f(0.2f, 0.0f, -0.7f),new Vector2f(0.4375f, 0.9375f),new Vector2f(0.4375f, 1.0f),new Vector2f(0.375f, 1.0f),new Vector2f(0.375f, 0.9375f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[56] = new ObjQuad(new Vector3f(0.2f, 0.0f, -0.7f),new Vector3f(0.2f, 0.0f, -0.8f),new Vector3f(0.3f, 0.0f, -0.8f),new Vector3f(0.3f, 0.0f, -0.7f),new Vector2f(0.375f, 0.9375f),new Vector2f(0.375f, 1.0f),new Vector2f(0.3125f, 1.0f),new Vector2f(0.3125f, 0.9375f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[57] = new ObjQuad(new Vector3f(0.3f, 0.0f, -0.7f),new Vector3f(0.3f, 0.0f, -0.8f),new Vector3f(0.4f, 0.0f, -0.8f),new Vector3f(0.4f, 0.0f, -0.7f),new Vector2f(0.3125f, 0.9375f),new Vector2f(0.3125f, 1.0f),new Vector2f(0.25f, 1.0f),new Vector2f(0.25f, 0.9375f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[58] = new ObjQuad(new Vector3f(0.4f, 0.0f, -0.7f),new Vector3f(0.4f, 0.0f, -0.8f),new Vector3f(0.5f, 0.0f, -0.8f),new Vector3f(0.5f, 0.0f, -0.7f),new Vector2f(0.25f, 0.9375f),new Vector2f(0.25f, 1.0f),new Vector2f(0.1875f, 1.0f),new Vector2f(0.1875f, 0.9375f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[59] = new ObjQuad(new Vector3f(0.5f, 0.0f, -0.7f),new Vector3f(0.5f, 0.0f, -0.8f),new Vector3f(0.6f, 0.0f, -0.8f),new Vector3f(0.6f, 0.0f, -0.7f),new Vector2f(0.1875f, 0.9375f),new Vector2f(0.1875f, 1.0f),new Vector2f(0.125f, 1.0f),new Vector2f(0.125f, 0.9375f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[60] = new ObjQuad(new Vector3f(0.6f, 0.0f, -0.7f),new Vector3f(0.6f, 0.0f, -0.8f),new Vector3f(0.7f, 0.0f, -0.8f),new Vector3f(0.7f, 0.0f, -0.7f),new Vector2f(0.125f, 0.9375f),new Vector2f(0.125f, 1.0f),new Vector2f(0.0625f, 1.0f),new Vector2f(0.0625f, 0.9375f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[61] = new ObjQuad(new Vector3f(0.7f, 0.0f, -0.7f),new Vector3f(0.7f, 0.0f, -0.8f),new Vector3f(0.8f, 0.0f, -0.8f),new Vector3f(0.8f, 0.0f, -0.7f),new Vector2f(0.0625f, 0.9375f),new Vector2f(0.0625f, 1.0f),new Vector2f(-0.0f, 1.0f),new Vector2f(0.0f, 0.9375f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[62] = new ObjQuad(new Vector3f(-0.8f, 0.95f, -0.3f),new Vector3f(-0.7f, 0.95f, -0.3f),new Vector3f(-0.7f, 1.0f, -0.6f),new Vector3f(-0.8f, 0.97f, -0.4f),new Vector2f(0.0f, 0.6875f),new Vector2f(0.0625f, 0.6875f),new Vector2f(0.0625f, 0.875f),new Vector2f(0.0f, 0.75f),new Vector3f(0.3269f, 3.9134f, 0.684f));
		this.quads[63] = new ObjQuad(new Vector3f(-0.7f, 0.95f, -0.3f),new Vector3f(-0.6f, 1.0f, -0.6f),new Vector3f(-0.6f, 1.0f, -0.75f),new Vector3f(-0.7f, 1.0f, -0.6f),new Vector2f(0.0625f, 0.6875f),new Vector2f(0.125f, 0.875f),new Vector2f(0.125f, 0.9688f),new Vector2f(0.0625f, 0.875f),new Vector3f(-0.15230002f, 3.8868f, 0.3414f));
		this.quads[64] = new ObjQuad(new Vector3f(-0.6f, 1.0f, -0.6f),new Vector3f(-0.5f, 1.0f, -0.7f),new Vector3f(-0.5f, 1.0f, -0.8f),new Vector3f(-0.6f, 1.0f, -0.75f),new Vector2f(0.125f, 0.875f),new Vector2f(0.1875f, 0.9375f),new Vector2f(0.1875f, 1.0f),new Vector2f(0.125f, 0.9688f),new Vector3f(-0.36180001f, 3.9344f, 0.0234f));
		this.quads[65] = new ObjQuad(new Vector3f(-0.5f, 1.0f, -0.7f),new Vector3f(-0.4f, 1.0f, -0.7f),new Vector3f(-0.4f, 1.0f, -0.8f),new Vector3f(-0.5f, 1.0f, -0.8f),new Vector2f(0.1875f, 0.9375f),new Vector2f(0.25f, 0.9375f),new Vector2f(0.25f, 1.0f),new Vector2f(0.1875f, 1.0f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[66] = new ObjQuad(new Vector3f(-0.4f, 1.0f, -0.7f),new Vector3f(-0.3f, 1.0f, -0.7f),new Vector3f(-0.3f, 1.0f, -0.8f),new Vector3f(-0.4f, 1.0f, -0.8f),new Vector2f(0.25f, 0.9375f),new Vector2f(0.3125f, 0.9375f),new Vector2f(0.3125f, 1.0f),new Vector2f(0.25f, 1.0f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[67] = new ObjQuad(new Vector3f(-0.3f, 1.0f, -0.7f),new Vector3f(-0.2f, 1.0f, -0.7f),new Vector3f(-0.2f, 1.0f, -0.8f),new Vector3f(-0.3f, 1.0f, -0.8f),new Vector2f(0.3125f, 0.9375f),new Vector2f(0.375f, 0.9375f),new Vector2f(0.375f, 1.0f),new Vector2f(0.3125f, 1.0f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[68] = new ObjQuad(new Vector3f(-0.2f, 1.0f, -0.7f),new Vector3f(-0.1f, 1.0f, -0.7f),new Vector3f(-0.1f, 1.0f, -0.8f),new Vector3f(-0.2f, 1.0f, -0.8f),new Vector2f(0.375f, 0.9375f),new Vector2f(0.4375f, 0.9375f),new Vector2f(0.4375f, 1.0f),new Vector2f(0.375f, 1.0f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[69] = new ObjQuad(new Vector3f(-0.1f, 1.0f, -0.7f),new Vector3f(0.0f, 1.0f, -0.7f),new Vector3f(0.0f, 1.0f, -0.8f),new Vector3f(-0.1f, 1.0f, -0.8f),new Vector2f(0.4375f, 0.9375f),new Vector2f(0.5f, 0.9375f),new Vector2f(0.5f, 1.0f),new Vector2f(0.4375f, 1.0f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[70] = new ObjQuad(new Vector3f(0.0f, 1.0f, -0.7f),new Vector3f(0.1f, 1.0f, -0.7f),new Vector3f(0.1f, 1.0f, -0.8f),new Vector3f(0.0f, 1.0f, -0.8f),new Vector2f(0.5f, 0.9375f),new Vector2f(0.5625f, 0.9375f),new Vector2f(0.5625f, 1.0f),new Vector2f(0.5f, 1.0f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[71] = new ObjQuad(new Vector3f(0.1f, 1.0f, -0.7f),new Vector3f(0.2f, 1.0f, -0.7f),new Vector3f(0.2f, 1.0f, -0.8f),new Vector3f(0.1f, 1.0f, -0.8f),new Vector2f(0.5625f, 0.9375f),new Vector2f(0.625f, 0.9375f),new Vector2f(0.625f, 1.0f),new Vector2f(0.5625f, 1.0f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[72] = new ObjQuad(new Vector3f(0.2f, 1.0f, -0.7f),new Vector3f(0.3f, 1.0f, -0.7f),new Vector3f(0.3f, 1.0f, -0.8f),new Vector3f(0.2f, 1.0f, -0.8f),new Vector2f(0.625f, 0.9375f),new Vector2f(0.6875f, 0.9375f),new Vector2f(0.6875f, 1.0f),new Vector2f(0.625f, 1.0f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[73] = new ObjQuad(new Vector3f(0.3f, 1.0f, -0.7f),new Vector3f(0.4f, 1.0f, -0.7f),new Vector3f(0.4f, 1.0f, -0.8f),new Vector3f(0.3f, 1.0f, -0.8f),new Vector2f(0.6875f, 0.9375f),new Vector2f(0.75f, 0.9375f),new Vector2f(0.75f, 1.0f),new Vector2f(0.6875f, 1.0f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[74] = new ObjQuad(new Vector3f(0.4f, 1.0f, -0.7f),new Vector3f(0.5f, 1.0f, -0.7f),new Vector3f(0.5f, 1.0f, -0.8f),new Vector3f(0.4f, 1.0f, -0.8f),new Vector2f(0.75f, 0.9375f),new Vector2f(0.8125f, 0.9375f),new Vector2f(0.8125f, 1.0f),new Vector2f(0.75f, 1.0f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[75] = new ObjQuad(new Vector3f(0.5f, 1.0f, -0.7f),new Vector3f(0.6f, 1.0f, -0.7f),new Vector3f(0.6f, 1.0f, -0.8f),new Vector3f(0.5f, 1.0f, -0.8f),new Vector2f(0.8125f, 0.9375f),new Vector2f(0.875f, 0.9375f),new Vector2f(0.875f, 1.0f),new Vector2f(0.8125f, 1.0f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[76] = new ObjQuad(new Vector3f(0.6f, 1.0f, -0.7f),new Vector3f(0.7f, 1.0f, -0.7f),new Vector3f(0.7f, 1.0f, -0.8f),new Vector3f(0.6f, 1.0f, -0.8f),new Vector2f(0.875f, 0.9375f),new Vector2f(0.9375f, 0.9375f),new Vector2f(0.9375f, 1.0f),new Vector2f(0.875f, 1.0f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[77] = new ObjQuad(new Vector3f(0.7f, 1.0f, -0.7f),new Vector3f(0.8f, 1.0f, -0.7f),new Vector3f(0.8f, 1.0f, -0.8f),new Vector3f(0.7f, 1.0f, -0.8f),new Vector2f(0.9375f, 0.9375f),new Vector2f(1.0f, 0.9375f),new Vector2f(1.0f, 1.0f),new Vector2f(0.9375f, 1.0f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[78] = new ObjQuad(new Vector3f(-0.8f, 0.0f, -0.3f),new Vector3f(-0.7f, 0.0f, -0.3f),new Vector3f(-0.7f, 0.95f, -0.3f),new Vector3f(-0.8f, 0.95f, -0.3f),new Vector2f(0.0f, 0.0f),new Vector2f(0.0625f, 0.0f),new Vector2f(0.0625f, 0.5938f),new Vector2f(0.0f, 0.5938f),new Vector3f(1.1968f, 0.0f, 3.6019f));
		this.quads[79] = new ObjQuad(new Vector3f(-0.7f, 0.0f, -0.3f),new Vector3f(-0.6f, 0.0f, -0.6f),new Vector3f(-0.6f, 1.0f, -0.6f),new Vector3f(-0.7f, 0.95f, -0.3f),new Vector2f(0.6875f, 0.0f),new Vector2f(0.875f, 0.0f),new Vector2f(0.875f, 0.625f),new Vector2f(0.6875f, 0.5938f),new Vector3f(2.8916001f, 0.0f, 2.6638f));
		this.quads[80] = new ObjQuad(new Vector3f(-0.6f, 0.0f, -0.6f),new Vector3f(-0.5f, 0.0f, -0.7f),new Vector3f(-0.5f, 1.0f, -0.7f),new Vector3f(-0.6f, 1.0f, -0.6f),new Vector2f(0.125f, 0.0f),new Vector2f(0.1875f, 0.0f),new Vector2f(0.1875f, 0.625f),new Vector2f(0.125f, 0.625f),new Vector3f(2.4601998f, 0.0f, 2.9097f));
		this.quads[81] = new ObjQuad(new Vector3f(-0.5f, 0.0f, -0.7f),new Vector3f(-0.4f, 0.0f, -0.7f),new Vector3f(-0.4f, 1.0f, -0.7f),new Vector3f(-0.5f, 1.0f, -0.7f),new Vector2f(0.1875f, 0.0f),new Vector2f(0.25f, 0.0f),new Vector2f(0.25f, 0.625f),new Vector2f(0.1875f, 0.625f),new Vector3f(0.7654f, 0.0f, 3.8478003f));
		this.quads[82] = new ObjQuad(new Vector3f(-0.4f, 0.0f, -0.7f),new Vector3f(-0.3f, 0.0f, -0.7f),new Vector3f(-0.3f, 1.0f, -0.7f),new Vector3f(-0.4f, 1.0f, -0.7f),new Vector2f(0.25f, 0.0f),new Vector2f(0.3125f, 0.0f),new Vector2f(0.3125f, 0.625f),new Vector2f(0.25f, 0.625f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[83] = new ObjQuad(new Vector3f(-0.3f, 0.0f, -0.7f),new Vector3f(-0.2f, 0.0f, -0.7f),new Vector3f(-0.2f, 1.0f, -0.7f),new Vector3f(-0.3f, 1.0f, -0.7f),new Vector2f(0.3125f, 0.0f),new Vector2f(0.375f, 0.0f),new Vector2f(0.375f, 0.625f),new Vector2f(0.3125f, 0.625f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[84] = new ObjQuad(new Vector3f(-0.2f, 0.0f, -0.7f),new Vector3f(-0.1f, 0.0f, -0.7f),new Vector3f(-0.1f, 1.0f, -0.7f),new Vector3f(-0.2f, 1.0f, -0.7f),new Vector2f(0.375f, 0.0f),new Vector2f(0.4375f, 0.0f),new Vector2f(0.4375f, 0.625f),new Vector2f(0.375f, 0.625f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[85] = new ObjQuad(new Vector3f(-0.1f, 0.0f, -0.7f),new Vector3f(0.0f, 0.0f, -0.7f),new Vector3f(0.0f, 1.0f, -0.7f),new Vector3f(-0.1f, 1.0f, -0.7f),new Vector2f(0.4375f, 0.0f),new Vector2f(0.5f, 0.0f),new Vector2f(0.5f, 0.625f),new Vector2f(0.4375f, 0.625f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[86] = new ObjQuad(new Vector3f(0.0f, 0.0f, -0.7f),new Vector3f(0.1f, 0.0f, -0.7f),new Vector3f(0.1f, 1.0f, -0.7f),new Vector3f(0.0f, 1.0f, -0.7f),new Vector2f(0.5f, 0.0f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.5625f, 0.625f),new Vector2f(0.5f, 0.625f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[87] = new ObjQuad(new Vector3f(0.1f, 0.0f, -0.7f),new Vector3f(0.2f, 0.0f, -0.7f),new Vector3f(0.2f, 1.0f, -0.7f),new Vector3f(0.1f, 1.0f, -0.7f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.625f, 0.0f),new Vector2f(0.625f, 0.625f),new Vector2f(0.5625f, 0.625f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[88] = new ObjQuad(new Vector3f(0.2f, 0.0f, -0.7f),new Vector3f(0.3f, 0.0f, -0.7f),new Vector3f(0.3f, 1.0f, -0.7f),new Vector3f(0.2f, 1.0f, -0.7f),new Vector2f(0.625f, 0.0f),new Vector2f(0.6875f, 0.0f),new Vector2f(0.6875f, 0.625f),new Vector2f(0.625f, 0.625f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[89] = new ObjQuad(new Vector3f(0.3f, 0.0f, -0.7f),new Vector3f(0.4f, 0.0f, -0.7f),new Vector3f(0.4f, 1.0f, -0.7f),new Vector3f(0.3f, 1.0f, -0.7f),new Vector2f(0.6875f, 0.0f),new Vector2f(0.75f, 0.0f),new Vector2f(0.75f, 0.625f),new Vector2f(0.6875f, 0.625f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[90] = new ObjQuad(new Vector3f(0.4f, 0.0f, -0.7f),new Vector3f(0.5f, 0.0f, -0.7f),new Vector3f(0.5f, 1.0f, -0.7f),new Vector3f(0.4f, 1.0f, -0.7f),new Vector2f(0.75f, 0.0f),new Vector2f(0.8125f, 0.0f),new Vector2f(0.8125f, 0.625f),new Vector2f(0.75f, 0.625f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[91] = new ObjQuad(new Vector3f(0.5f, 0.0f, -0.7f),new Vector3f(0.6f, 0.0f, -0.7f),new Vector3f(0.6f, 1.0f, -0.7f),new Vector3f(0.5f, 1.0f, -0.7f),new Vector2f(0.8125f, 0.0f),new Vector2f(0.875f, 0.0f),new Vector2f(0.875f, 0.625f),new Vector2f(0.8125f, 0.625f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[92] = new ObjQuad(new Vector3f(0.6f, 0.0f, -0.7f),new Vector3f(0.7f, 0.0f, -0.7f),new Vector3f(0.7f, 1.0f, -0.7f),new Vector3f(0.6f, 1.0f, -0.7f),new Vector2f(0.875f, 0.0f),new Vector2f(0.9375f, 0.0f),new Vector2f(0.9375f, 0.625f),new Vector2f(0.875f, 0.625f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[93] = new ObjQuad(new Vector3f(0.7f, 0.0f, -0.7f),new Vector3f(0.8f, 0.0f, -0.7f),new Vector3f(0.8f, 1.0f, -0.7f),new Vector3f(0.7f, 1.0f, -0.7f),new Vector2f(0.9375f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 0.625f),new Vector2f(0.9375f, 0.625f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[94] = new ObjQuad(new Vector3f(0.8f, 0.0f, -0.7f),new Vector3f(0.8f, 0.0f, -0.8f),new Vector3f(0.8f, 1.0f, -0.8f),new Vector3f(0.8f, 1.0f, -0.7f),new Vector2f(0.9375f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 0.625f),new Vector2f(0.9375f, 0.625f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[95] = new ObjQuad(new Vector3f(0.8f, 0.0f, -0.8f),new Vector3f(0.7f, 0.0f, -0.8f),new Vector3f(0.7f, 1.0f, -0.8f),new Vector3f(0.8f, 1.0f, -0.8f),new Vector2f(-0.0f, 0.0f),new Vector2f(0.0625f, 0.0f),new Vector2f(0.0625f, 0.625f),new Vector2f(-0.0f, 0.625f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[96] = new ObjQuad(new Vector3f(0.7f, 0.0f, -0.8f),new Vector3f(0.6f, 0.0f, -0.8f),new Vector3f(0.6f, 1.0f, -0.8f),new Vector3f(0.7f, 1.0f, -0.8f),new Vector2f(0.0625f, 0.0f),new Vector2f(0.125f, 0.0f),new Vector2f(0.125f, 0.625f),new Vector2f(0.0625f, 0.625f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[97] = new ObjQuad(new Vector3f(0.6f, 0.0f, -0.8f),new Vector3f(0.5f, 0.0f, -0.8f),new Vector3f(0.5f, 1.0f, -0.8f),new Vector3f(0.6f, 1.0f, -0.8f),new Vector2f(0.125f, 0.0f),new Vector2f(0.1875f, 0.0f),new Vector2f(0.1875f, 0.625f),new Vector2f(0.125f, 0.625f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[98] = new ObjQuad(new Vector3f(0.5f, 0.0f, -0.8f),new Vector3f(0.4f, 0.0f, -0.8f),new Vector3f(0.4f, 1.0f, -0.8f),new Vector3f(0.5f, 1.0f, -0.8f),new Vector2f(0.1875f, 0.0f),new Vector2f(0.25f, 0.0f),new Vector2f(0.25f, 0.625f),new Vector2f(0.1875f, 0.625f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[99] = new ObjQuad(new Vector3f(0.4f, 0.0f, -0.8f),new Vector3f(0.3f, 0.0f, -0.8f),new Vector3f(0.3f, 1.0f, -0.8f),new Vector3f(0.4f, 1.0f, -0.8f),new Vector2f(0.25f, 0.0f),new Vector2f(0.3125f, 0.0f),new Vector2f(0.3125f, 0.625f),new Vector2f(0.25f, 0.625f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[100] = new ObjQuad(new Vector3f(0.3f, 0.0f, -0.8f),new Vector3f(0.2f, 0.0f, -0.8f),new Vector3f(0.2f, 1.0f, -0.8f),new Vector3f(0.3f, 1.0f, -0.8f),new Vector2f(0.3125f, 0.0f),new Vector2f(0.375f, 0.0f),new Vector2f(0.375f, 0.625f),new Vector2f(0.3125f, 0.625f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[101] = new ObjQuad(new Vector3f(0.2f, 0.0f, -0.8f),new Vector3f(0.1f, 0.0f, -0.8f),new Vector3f(0.1f, 1.0f, -0.8f),new Vector3f(0.2f, 1.0f, -0.8f),new Vector2f(0.375f, 0.0f),new Vector2f(0.4375f, 0.0f),new Vector2f(0.4375f, 0.625f),new Vector2f(0.375f, 0.625f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[102] = new ObjQuad(new Vector3f(0.1f, 0.0f, -0.8f),new Vector3f(0.0f, 0.0f, -0.8f),new Vector3f(0.0f, 1.0f, -0.8f),new Vector3f(0.1f, 1.0f, -0.8f),new Vector2f(0.4375f, 0.0f),new Vector2f(0.5f, 0.0f),new Vector2f(0.5f, 0.625f),new Vector2f(0.4375f, 0.625f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[103] = new ObjQuad(new Vector3f(0.0f, 0.0f, -0.8f),new Vector3f(-0.1f, 0.0f, -0.8f),new Vector3f(-0.1f, 1.0f, -0.8f),new Vector3f(0.0f, 1.0f, -0.8f),new Vector2f(0.5f, 0.0f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.5625f, 0.625f),new Vector2f(0.5f, 0.625f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[104] = new ObjQuad(new Vector3f(-0.1f, 0.0f, -0.8f),new Vector3f(-0.2f, 0.0f, -0.8f),new Vector3f(-0.2f, 1.0f, -0.8f),new Vector3f(-0.1f, 1.0f, -0.8f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.625f, 0.0f),new Vector2f(0.625f, 0.625f),new Vector2f(0.5625f, 0.625f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[105] = new ObjQuad(new Vector3f(-0.2f, 0.0f, -0.8f),new Vector3f(-0.3f, 0.0f, -0.8f),new Vector3f(-0.3f, 1.0f, -0.8f),new Vector3f(-0.2f, 1.0f, -0.8f),new Vector2f(0.625f, 0.0f),new Vector2f(0.6875f, 0.0f),new Vector2f(0.6875f, 0.625f),new Vector2f(0.625f, 0.625f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[106] = new ObjQuad(new Vector3f(-0.3f, 0.0f, -0.8f),new Vector3f(-0.4f, 0.0f, -0.8f),new Vector3f(-0.4f, 1.0f, -0.8f),new Vector3f(-0.3f, 1.0f, -0.8f),new Vector2f(0.6875f, 0.0f),new Vector2f(0.75f, 0.0f),new Vector2f(0.75f, 0.625f),new Vector2f(0.6875f, 0.625f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[107] = new ObjQuad(new Vector3f(-0.4f, 0.0f, -0.8f),new Vector3f(-0.5f, 0.0f, -0.8f),new Vector3f(-0.5f, 1.0f, -0.8f),new Vector3f(-0.4f, 1.0f, -0.8f),new Vector2f(0.75f, 0.0f),new Vector2f(0.8125f, 0.0f),new Vector2f(0.8125f, 0.625f),new Vector2f(0.75f, 0.625f),new Vector3f(-0.4596f, 0.0f, -3.9464002f));
		this.quads[108] = new ObjQuad(new Vector3f(-0.5f, 0.0f, -0.8f),new Vector3f(-0.6f, 0.0f, -0.75f),new Vector3f(-0.6f, 1.0f, -0.75f),new Vector3f(-0.5f, 1.0f, -0.8f),new Vector2f(0.8125f, 0.0f),new Vector2f(0.875f, 0.0f),new Vector2f(0.875f, 0.625f),new Vector2f(0.8125f, 0.625f),new Vector3f(-1.7832f, 0.0f, -3.4458f));
		this.quads[109] = new ObjQuad(new Vector3f(-0.6f, 0.0f, -0.75f),new Vector3f(-0.7f, 0.0f, -0.6f),new Vector3f(-0.7f, 1.0f, -0.6f),new Vector3f(-0.6f, 1.0f, -0.75f),new Vector2f(0.0313f, 0.0f),new Vector2f(0.125f, 0.0f),new Vector2f(0.125f, 0.625f),new Vector2f(0.0313f, 0.625f),new Vector3f(-3.052f, 0.0f, -2.5056f));
		this.quads[110] = new ObjQuad(new Vector3f(-0.7f, 0.0f, -0.6f),new Vector3f(-0.8f, 0.0f, -0.4f),new Vector3f(-0.8f, 0.97f, -0.4f),new Vector3f(-0.7f, 1.0f, -0.6f),new Vector2f(0.125f, 0.0f),new Vector2f(0.25f, 0.0f),new Vector2f(0.25f, 0.6062f),new Vector2f(0.125f, 0.625f),new Vector3f(-3.5172f, 0.0f, -1.9006001f));
		this.quads[111] = new ObjQuad(new Vector3f(-0.8f, 0.0f, -0.4f),new Vector3f(-0.8f, 0.0f, -0.3f),new Vector3f(-0.8f, 0.95f, -0.3f),new Vector3f(-0.8f, 0.97f, -0.4f),new Vector2f(0.25f, 0.0f),new Vector2f(0.3125f, 0.0f),new Vector2f(0.3125f, 0.5938f),new Vector2f(0.25f, 0.6062f),new Vector3f(-4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		ScreenLeft other = new ScreenLeft();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}
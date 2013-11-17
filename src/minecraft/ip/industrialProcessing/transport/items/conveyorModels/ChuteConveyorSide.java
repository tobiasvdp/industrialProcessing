package ip.industrialProcessing.transport.items.conveyorModels;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class ChuteConveyorSide extends ObjMesh{
	public ChuteConveyorSide(){
		this.quads = new ObjQuad[52];
		this.quads[0] = new ObjQuad(new Vector3f(-0.3f, 0.6f, 0.8f),new Vector3f(0.3f, 0.6f, 0.8f),new Vector3f(0.3f, 0.8f, 0.8f),new Vector3f(-0.3f, 0.8f, 0.8f),new Vector2f(0.7505f, 0.5625f),new Vector2f(0.7505f, 0.9375f),new Vector2f(0.6255f, 0.9375f),new Vector2f(0.6255f, 0.5625f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.3f, 0.6f, 0.2f),new Vector3f(0.3f, 0.8f, 0.2f),new Vector3f(0.3f, 0.8f, 0.8f),new Vector3f(0.3f, 0.6f, 0.8f),new Vector2f(0.625f, 0.625f),new Vector2f(0.751f, 0.625f),new Vector2f(0.751f, 1.0f),new Vector2f(0.625f, 1.0f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.3f, 0.6f, 0.2f),new Vector3f(-0.3f, 0.6f, 0.2f),new Vector3f(-0.3f, 0.8f, 0.2f),new Vector3f(0.3f, 0.8f, 0.2f),new Vector2f(0.7505f, 0.5625f),new Vector2f(0.7505f, 0.9375f),new Vector2f(0.6255f, 0.9375f),new Vector2f(0.6255f, 0.5625f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.4f, 0.5f, 0.2f),new Vector3f(0.4f, 0.5f, 0.2f),new Vector3f(0.4f, 0.5f, 0.8f),new Vector3f(-0.4f, 0.5f, 0.8f),new Vector2f(0.5f, 0.375f),new Vector2f(0.0f, 0.375f),new Vector2f(0.0f, 0.0f),new Vector2f(0.5f, 0.0f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.4f, 0.5f, 0.2f),new Vector3f(0.4f, 0.6f, 0.2f),new Vector3f(0.4f, 0.6f, 0.8f),new Vector3f(0.4f, 0.5f, 0.8f),new Vector2f(0.875f, 0.875f),new Vector2f(0.813f, 0.875f),new Vector2f(0.813f, 0.5f),new Vector2f(0.875f, 0.5f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.3f, 0.6f, 0.8f),new Vector3f(-0.4f, 0.6f, 0.8f),new Vector3f(-0.4f, 0.5f, 0.8f),new Vector3f(0.4f, 0.5f, 0.8f),new Vector2f(0.7505f, 0.5625f),new Vector2f(0.7505f, 0.5f),new Vector2f(0.813f, 0.5f),new Vector2f(0.813f, 1.0f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[6] = new ObjQuad(new Vector3f(0.3f, 0.6f, 0.8f),new Vector3f(-0.3f, 0.6f, 0.8f),new Vector3f(0.4f, 0.5f, 0.8f),new Vector3f(0.4f, 0.6f, 0.8f),new Vector2f(0.7505f, 0.9375f),new Vector2f(0.7505f, 0.5625f),new Vector2f(0.813f, 1.0f),new Vector2f(0.7505f, 1.0f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.3f, 0.6f, 0.8f),new Vector3f(-0.3f, 0.6f, 0.2f),new Vector3f(-0.4f, 0.6f, 0.2f),new Vector3f(-0.4f, 0.6f, 0.8f),new Vector2f(0.8125f, 0.5f),new Vector2f(0.8125f, 0.875f),new Vector2f(0.75f, 0.875f),new Vector2f(0.75f, 0.5f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(0.3f, 0.6f, 0.2f),new Vector3f(0.4f, 0.6f, 0.2f),new Vector3f(0.4f, 0.5f, 0.2f),new Vector3f(-0.4f, 0.5f, 0.2f),new Vector2f(0.7505f, 0.5625f),new Vector2f(0.7505f, 0.5f),new Vector2f(0.813f, 0.5f),new Vector2f(0.813f, 1.0f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[9] = new ObjQuad(new Vector3f(-0.3f, 0.6f, 0.2f),new Vector3f(0.3f, 0.6f, 0.2f),new Vector3f(-0.4f, 0.5f, 0.2f),new Vector3f(-0.4f, 0.6f, 0.2f),new Vector2f(0.7505f, 0.9375f),new Vector2f(0.7505f, 0.5625f),new Vector2f(0.813f, 1.0f),new Vector2f(0.7505f, 1.0f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[10] = new ObjQuad(new Vector3f(0.4f, 0.9f, 0.8f),new Vector3f(0.4f, 0.9f, 0.2f),new Vector3f(-0.4f, 0.9f, 0.2f),new Vector3f(-0.4f, 0.9f, 0.8f),new Vector2f(0.5f, 0.5f),new Vector2f(0.5f, 0.875f),new Vector2f(0.0f, 0.875f),new Vector2f(0.0f, 0.5f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[11] = new ObjQuad(new Vector3f(0.4f, 0.8f, 0.2f),new Vector3f(0.4f, 0.9f, 0.2f),new Vector3f(0.4f, 0.9f, 0.8f),new Vector3f(0.4f, 0.8f, 0.8f),new Vector2f(0.563f, 0.875f),new Vector2f(0.5f, 0.875f),new Vector2f(0.5f, 0.5f),new Vector2f(0.563f, 0.5f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[12] = new ObjQuad(new Vector3f(0.3f, 0.8f, 0.8f),new Vector3f(0.4f, 0.8f, 0.8f),new Vector3f(0.4f, 0.9f, 0.8f),new Vector3f(-0.4f, 0.9f, 0.8f),new Vector2f(0.6255f, 0.9375f),new Vector2f(0.6255f, 1.0f),new Vector2f(0.5625f, 1.0f),new Vector2f(0.5625f, 0.5f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[13] = new ObjQuad(new Vector3f(-0.3f, 0.8f, 0.8f),new Vector3f(0.3f, 0.8f, 0.8f),new Vector3f(-0.4f, 0.9f, 0.8f),new Vector3f(-0.4f, 0.8f, 0.8f),new Vector2f(0.6255f, 0.5625f),new Vector2f(0.6255f, 0.9375f),new Vector2f(0.5625f, 0.5f),new Vector2f(0.6255f, 0.5f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[14] = new ObjQuad(new Vector3f(0.3f, 0.8f, 0.8f),new Vector3f(0.3f, 0.8f, 0.2f),new Vector3f(0.4f, 0.8f, 0.2f),new Vector3f(0.4f, 0.8f, 0.8f),new Vector2f(0.625f, 0.5f),new Vector2f(0.625f, 0.875f),new Vector2f(0.5625f, 0.875f),new Vector2f(0.5625f, 0.5f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[15] = new ObjQuad(new Vector3f(-0.3f, 0.8f, 0.2f),new Vector3f(-0.4f, 0.8f, 0.2f),new Vector3f(-0.4f, 0.9f, 0.2f),new Vector3f(0.4f, 0.9f, 0.2f),new Vector2f(0.6255f, 0.9375f),new Vector2f(0.6255f, 1.0f),new Vector2f(0.5625f, 1.0f),new Vector2f(0.5625f, 0.5f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[16] = new ObjQuad(new Vector3f(0.3f, 0.8f, 0.2f),new Vector3f(-0.3f, 0.8f, 0.2f),new Vector3f(0.4f, 0.9f, 0.2f),new Vector3f(0.4f, 0.8f, 0.2f),new Vector2f(0.6255f, 0.5625f),new Vector2f(0.6255f, 0.9375f),new Vector2f(0.5625f, 0.5f),new Vector2f(0.6255f, 0.5f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[17] = new ObjQuad(new Vector3f(-0.3f, 0.0f, 0.3f),new Vector3f(-0.2f, 0.0f, 0.3f),new Vector3f(-0.2f, 0.0f, 0.8f),new Vector3f(-0.3f, 0.0f, 0.8f),new Vector2f(0.6875f, 0.3125f),new Vector2f(0.625f, 0.3125f),new Vector2f(0.625f, 0.0f),new Vector2f(0.6875f, 0.0f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[18] = new ObjQuad(new Vector3f(-0.2f, 0.1f, 0.8f),new Vector3f(-0.2f, 0.1f, 0.3f),new Vector3f(-0.3f, 0.1f, 0.3f),new Vector3f(-0.3f, 0.1f, 0.8f),new Vector2f(0.5f, 0.0f),new Vector2f(0.5f, 0.3125f),new Vector2f(0.5625f, 0.3125f),new Vector2f(0.5625f, 0.0f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[19] = new ObjQuad(new Vector3f(-0.3f, 0.0f, 0.8f),new Vector3f(-0.2f, 0.0f, 0.8f),new Vector3f(-0.2f, 0.1f, 0.8f),new Vector3f(-0.3f, 0.1f, 0.8f),new Vector2f(0.75f, 0.0f),new Vector2f(0.75f, 0.0625f),new Vector2f(0.6875f, 0.0625f),new Vector2f(0.6875f, 0.0f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[20] = new ObjQuad(new Vector3f(-0.2f, 0.0f, 0.3f),new Vector3f(-0.2f, 0.1f, 0.3f),new Vector3f(-0.2f, 0.1f, 0.8f),new Vector3f(-0.2f, 0.0f, 0.8f),new Vector2f(0.75f, 0.3125f),new Vector2f(0.6875f, 0.3125f),new Vector2f(0.6875f, 0.0f),new Vector2f(0.75f, 0.0f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[21] = new ObjQuad(new Vector3f(0.2f, 0.0f, 0.3f),new Vector3f(0.3f, 0.0f, 0.3f),new Vector3f(0.3f, 0.0f, 0.8f),new Vector3f(0.2f, 0.0f, 0.8f),new Vector2f(0.6875f, 0.3125f),new Vector2f(0.625f, 0.3125f),new Vector2f(0.625f, 0.0f),new Vector2f(0.6875f, 0.0f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[22] = new ObjQuad(new Vector3f(0.3f, 0.1f, 0.8f),new Vector3f(0.3f, 0.1f, 0.3f),new Vector3f(0.2f, 0.1f, 0.3f),new Vector3f(0.2f, 0.1f, 0.8f),new Vector2f(0.5f, 0.0f),new Vector2f(0.5f, 0.3125f),new Vector2f(0.5625f, 0.3125f),new Vector2f(0.5625f, 0.0f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[23] = new ObjQuad(new Vector3f(0.2f, 0.0f, 0.8f),new Vector3f(0.3f, 0.0f, 0.8f),new Vector3f(0.3f, 0.1f, 0.8f),new Vector3f(0.2f, 0.1f, 0.8f),new Vector2f(0.75f, 0.0f),new Vector2f(0.75f, 0.0625f),new Vector2f(0.6875f, 0.0625f),new Vector2f(0.6875f, 0.0f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[24] = new ObjQuad(new Vector3f(0.3f, 0.0f, 0.3f),new Vector3f(0.3f, 0.1f, 0.3f),new Vector3f(0.3f, 0.1f, 0.8f),new Vector3f(0.3f, 0.0f, 0.8f),new Vector2f(0.75f, 0.3125f),new Vector2f(0.6875f, 0.3125f),new Vector2f(0.6875f, 0.0f),new Vector2f(0.75f, 0.0f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[25] = new ObjQuad(new Vector3f(-0.3f, 0.5f, 0.3f),new Vector3f(-0.3f, 0.5f, 0.2f),new Vector3f(-0.3f, 0.1f, 0.2f),new Vector3f(-0.3f, 0.1f, 0.3f),new Vector2f(0.625f, 0.25f),new Vector2f(0.5625f, 0.25f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.625f, 0.0f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[26] = new ObjQuad(new Vector3f(0.2f, 0.5f, 0.3f),new Vector3f(0.2f, 0.5f, 0.2f),new Vector3f(0.2f, 0.1f, 0.2f),new Vector3f(0.2f, 0.1f, 0.3f),new Vector2f(0.625f, 0.25f),new Vector2f(0.5625f, 0.25f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.625f, 0.0f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[27] = new ObjQuad(new Vector3f(-0.3f, 0.1f, 0.3f),new Vector3f(-0.2f, 0.1f, 0.3f),new Vector3f(-0.2f, 0.5f, 0.3f),new Vector3f(-0.3f, 0.5f, 0.3f),new Vector2f(0.6875f, 0.5f),new Vector2f(0.625f, 0.5f),new Vector2f(0.625f, 0.25f),new Vector2f(0.6875f, 0.25f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[28] = new ObjQuad(new Vector3f(-0.2f, 0.1f, 0.2f),new Vector3f(-0.3f, 0.1f, 0.2f),new Vector3f(-0.3f, 0.5f, 0.2f),new Vector3f(-0.2f, 0.5f, 0.2f),new Vector2f(0.5f, 0.5f),new Vector2f(0.5625f, 0.5f),new Vector2f(0.5625f, 0.25f),new Vector2f(0.5f, 0.25f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[29] = new ObjQuad(new Vector3f(-0.2f, 0.1f, 0.3f),new Vector3f(-0.2f, 0.1f, 0.2f),new Vector3f(-0.2f, 0.5f, 0.2f),new Vector3f(-0.2f, 0.5f, 0.3f),new Vector2f(0.75f, 0.5f),new Vector2f(0.6875f, 0.5f),new Vector2f(0.6875f, 0.25f),new Vector2f(0.75f, 0.25f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[30] = new ObjQuad(new Vector3f(0.2f, 0.1f, 0.3f),new Vector3f(0.3f, 0.1f, 0.3f),new Vector3f(0.3f, 0.5f, 0.3f),new Vector3f(0.2f, 0.5f, 0.3f),new Vector2f(0.6875f, 0.5f),new Vector2f(0.625f, 0.5f),new Vector2f(0.625f, 0.25f),new Vector2f(0.6875f, 0.25f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[31] = new ObjQuad(new Vector3f(0.3f, 0.1f, 0.2f),new Vector3f(0.2f, 0.1f, 0.2f),new Vector3f(0.2f, 0.5f, 0.2f),new Vector3f(0.3f, 0.5f, 0.2f),new Vector2f(0.5f, 0.5f),new Vector2f(0.5625f, 0.5f),new Vector2f(0.5625f, 0.25f),new Vector2f(0.5f, 0.25f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[32] = new ObjQuad(new Vector3f(0.3f, 0.1f, 0.3f),new Vector3f(0.3f, 0.1f, 0.2f),new Vector3f(0.3f, 0.5f, 0.2f),new Vector3f(0.3f, 0.5f, 0.3f),new Vector2f(0.75f, 0.5f),new Vector2f(0.6875f, 0.5f),new Vector2f(0.6875f, 0.25f),new Vector2f(0.75f, 0.25f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[33] = new ObjQuad(new Vector3f(-0.3f, 0.1f, 0.629289f),new Vector3f(-0.3f, 0.1f, 0.770711f),new Vector3f(-0.3f, 0.5f, 0.370711f),new Vector3f(-0.3f, 0.5f, 0.3f),new Vector2f(0.625f, 0.380362f),new Vector2f(0.5625f, 0.442862f),new Vector2f(0.5625f, 0.089308f),new Vector2f(0.59375f, 0.058058f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[34] = new ObjQuad(new Vector3f(-0.3f, 0.429289f, 0.3f),new Vector3f(-0.3f, 0.1f, 0.629289f),new Vector3f(-0.3f, 0.5f, 0.3f),new Vector2f(0.625f, 0.089308f),new Vector2f(0.625f, 0.380362f),new Vector2f(0.59375f, 0.058058f),new Vector3f(-3.0f, 0.0f, 0.0f));
		this.quads[35] = new ObjQuad(new Vector3f(0.2f, 0.1f, 0.629289f),new Vector3f(0.2f, 0.1f, 0.770711f),new Vector3f(0.2f, 0.5f, 0.370711f),new Vector3f(0.2f, 0.5f, 0.3f),new Vector2f(0.625f, 0.380362f),new Vector2f(0.5625f, 0.442862f),new Vector2f(0.5625f, 0.089308f),new Vector2f(0.59375f, 0.058058f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[36] = new ObjQuad(new Vector3f(0.2f, 0.429289f, 0.3f),new Vector3f(0.2f, 0.1f, 0.629289f),new Vector3f(0.2f, 0.5f, 0.3f),new Vector2f(0.625f, 0.089308f),new Vector2f(0.625f, 0.380362f),new Vector2f(0.59375f, 0.058058f),new Vector3f(-3.0f, 0.0f, 0.0f));
		this.quads[37] = new ObjQuad(new Vector3f(-0.3f, 0.429289f, 0.3f),new Vector3f(-0.2f, 0.429289f, 0.3f),new Vector3f(-0.2f, 0.1f, 0.629289f),new Vector3f(-0.3f, 0.1f, 0.629289f),new Vector2f(0.6875f, 0.410692f),new Vector2f(0.625f, 0.410692f),new Vector2f(0.625f, 0.119638f),new Vector2f(0.6875f, 0.119638f),new Vector3f(0.0f, -2.828428f, -2.828428f));
		this.quads[38] = new ObjQuad(new Vector3f(-0.2f, 0.5f, 0.370711f),new Vector3f(-0.3f, 0.5f, 0.370711f),new Vector3f(-0.3f, 0.1f, 0.770711f),new Vector3f(-0.2f, 0.1f, 0.770711f),new Vector2f(0.5f, 0.410692f),new Vector2f(0.5625f, 0.410692f),new Vector2f(0.5625f, 0.057138f),new Vector2f(0.5f, 0.057138f),new Vector3f(0.0f, 2.828428f, 2.828428f));
		this.quads[39] = new ObjQuad(new Vector3f(-0.2f, 0.429289f, 0.3f),new Vector3f(-0.2f, 0.5f, 0.3f),new Vector3f(-0.2f, 0.5f, 0.370711f),new Vector3f(-0.2f, 0.1f, 0.770711f),new Vector2f(0.75f, 0.410692f),new Vector2f(0.71875f, 0.441942f),new Vector2f(0.6875f, 0.410692f),new Vector2f(0.6875f, 0.057138f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[40] = new ObjQuad(new Vector3f(-0.2f, 0.1f, 0.629289f),new Vector3f(-0.2f, 0.429289f, 0.3f),new Vector3f(-0.2f, 0.1f, 0.770711f),new Vector2f(0.75f, 0.119638f),new Vector2f(0.75f, 0.410692f),new Vector2f(0.6875f, 0.057138f),new Vector3f(3.0f, 0.0f, 0.0f));
		this.quads[41] = new ObjQuad(new Vector3f(0.2f, 0.429289f, 0.3f),new Vector3f(0.3f, 0.429289f, 0.3f),new Vector3f(0.3f, 0.1f, 0.629289f),new Vector3f(0.2f, 0.1f, 0.629289f),new Vector2f(0.6875f, 0.410692f),new Vector2f(0.625f, 0.410692f),new Vector2f(0.625f, 0.119638f),new Vector2f(0.6875f, 0.119638f),new Vector3f(0.0f, -2.828428f, -2.828428f));
		this.quads[42] = new ObjQuad(new Vector3f(0.3f, 0.5f, 0.370711f),new Vector3f(0.2f, 0.5f, 0.370711f),new Vector3f(0.2f, 0.1f, 0.770711f),new Vector3f(0.3f, 0.1f, 0.770711f),new Vector2f(0.5f, 0.410692f),new Vector2f(0.5625f, 0.410692f),new Vector2f(0.5625f, 0.057138f),new Vector2f(0.5f, 0.057138f),new Vector3f(0.0f, 2.828428f, 2.828428f));
		this.quads[43] = new ObjQuad(new Vector3f(0.3f, 0.429289f, 0.3f),new Vector3f(0.3f, 0.5f, 0.3f),new Vector3f(0.3f, 0.5f, 0.370711f),new Vector3f(0.3f, 0.1f, 0.770711f),new Vector2f(0.75f, 0.410692f),new Vector2f(0.71875f, 0.441942f),new Vector2f(0.6875f, 0.410692f),new Vector2f(0.6875f, 0.057138f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[44] = new ObjQuad(new Vector3f(0.3f, 0.1f, 0.629289f),new Vector3f(0.3f, 0.429289f, 0.3f),new Vector3f(0.3f, 0.1f, 0.770711f),new Vector2f(0.75f, 0.119638f),new Vector2f(0.75f, 0.410692f),new Vector2f(0.6875f, 0.057138f),new Vector3f(3.0f, 0.0f, 0.0f));
		this.quads[45] = new ObjQuad(new Vector3f(-0.3f, 0.6f, 0.8f),new Vector3f(-0.3f, 0.8f, 0.8f),new Vector3f(-0.3f, 0.8f, 0.2f),new Vector3f(-0.3f, 0.6f, 0.2f),new Vector2f(0.625f, 0.5f),new Vector2f(0.751f, 0.5f),new Vector2f(0.751f, 0.875f),new Vector2f(0.625f, 0.875f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[46] = new ObjQuad(new Vector3f(-0.4f, 0.5f, 0.8f),new Vector3f(-0.4f, 0.6f, 0.8f),new Vector3f(-0.4f, 0.6f, 0.2f),new Vector3f(-0.4f, 0.5f, 0.2f),new Vector2f(0.875f, 1.0f),new Vector2f(0.813f, 1.0f),new Vector2f(0.813f, 0.625f),new Vector2f(0.875f, 0.625f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[47] = new ObjQuad(new Vector3f(0.3f, 0.6f, 0.8f),new Vector3f(0.4f, 0.6f, 0.8f),new Vector3f(0.4f, 0.6f, 0.2f),new Vector3f(0.3f, 0.6f, 0.2f),new Vector2f(0.75f, 0.5f),new Vector2f(0.8125f, 0.5f),new Vector2f(0.8125f, 0.875f),new Vector2f(0.75f, 0.875f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[48] = new ObjQuad(new Vector3f(-0.4f, 0.8f, 0.8f),new Vector3f(-0.4f, 0.9f, 0.8f),new Vector3f(-0.4f, 0.9f, 0.2f),new Vector3f(-0.4f, 0.8f, 0.2f),new Vector2f(0.563f, 1.0f),new Vector2f(0.5f, 1.0f),new Vector2f(0.5f, 0.625f),new Vector2f(0.563f, 0.625f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[49] = new ObjQuad(new Vector3f(-0.3f, 0.8f, 0.8f),new Vector3f(-0.4f, 0.8f, 0.8f),new Vector3f(-0.4f, 0.8f, 0.2f),new Vector3f(-0.3f, 0.8f, 0.2f),new Vector2f(0.5625f, 0.5f),new Vector2f(0.625f, 0.5f),new Vector2f(0.625f, 0.875f),new Vector2f(0.5625f, 0.875f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[50] = new ObjQuad(new Vector3f(-0.3f, 0.0f, 0.8f),new Vector3f(-0.3f, 0.1f, 0.8f),new Vector3f(-0.3f, 0.1f, 0.3f),new Vector3f(-0.3f, 0.0f, 0.3f),new Vector2f(0.625f, 0.5f),new Vector2f(0.5625f, 0.5f),new Vector2f(0.5625f, 0.1875f),new Vector2f(0.625f, 0.1875f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[51] = new ObjQuad(new Vector3f(0.2f, 0.0f, 0.8f),new Vector3f(0.2f, 0.1f, 0.8f),new Vector3f(0.2f, 0.1f, 0.3f),new Vector3f(0.2f, 0.0f, 0.3f),new Vector2f(0.625f, 0.5f),new Vector2f(0.5625f, 0.5f),new Vector2f(0.5625f, 0.1875f),new Vector2f(0.625f, 0.1875f),new Vector3f(-4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		ChuteConveyorSide other = new ChuteConveyorSide();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

package mod.industrialProcessing.transport.items.conveyorBelt.rendering.comonModels;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class BackIn001 extends ObjMesh{
	public BackIn001(){
		this.quads = new ObjQuad[48];
		this.quads[0] = new ObjQuad(new Vector3f(0.8f, 0.6f, 0.3f),new Vector3f(0.8f, 0.6f, -0.3f),new Vector3f(0.8f, 0.8f, -0.3f),new Vector3f(0.8f, 0.8f, 0.3f),new Vector2f(0.7505f, 0.5625f),new Vector2f(0.7505f, 0.9375f),new Vector2f(0.6255f, 0.9375f),new Vector2f(0.6255f, 0.5625f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.4f, 0.6f, -0.3f),new Vector3f(0.300001f, 0.6f, -0.3f),new Vector3f(0.300001f, 0.8f, -0.3f),new Vector3f(0.8f, 0.6f, -0.3f),new Vector2f(0.626142f, 0.749473f),new Vector2f(0.626142f, 0.686939f),new Vector2f(0.75059f, 0.686939f),new Vector2f(0.626142f, 0.999614f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.8f, 0.6f, -0.3f),new Vector3f(0.300001f, 0.8f, -0.3f),new Vector3f(0.4f, 0.8f, -0.3f),new Vector3f(0.8f, 0.8f, -0.3f),new Vector2f(0.626142f, 0.999614f),new Vector2f(0.75059f, 0.686939f),new Vector2f(0.75059f, 0.749473f),new Vector2f(0.75059f, 0.999614f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.4f, 0.5f, -0.4f),new Vector3f(0.4f, 0.6f, -0.4f),new Vector3f(0.8f, 0.6f, -0.4f),new Vector3f(0.8f, 0.5f, -0.4f),new Vector2f(0.812908f, 0.749874f),new Vector2f(0.875329f, 0.749874f),new Vector2f(0.875329f, 0.999908f),new Vector2f(0.812908f, 0.999908f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.8f, 0.6f, 0.3f),new Vector3f(0.8f, 0.6f, 0.4f),new Vector3f(0.8f, 0.5f, 0.4f),new Vector3f(0.8f, 0.5f, -0.4f),new Vector2f(0.7505f, 0.5625f),new Vector2f(0.7505f, 0.5f),new Vector2f(0.813f, 0.5f),new Vector2f(0.813f, 1.0f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(0.8f, 0.6f, -0.3f),new Vector3f(0.8f, 0.6f, 0.3f),new Vector3f(0.8f, 0.5f, -0.4f),new Vector3f(0.8f, 0.6f, -0.4f),new Vector2f(0.7505f, 0.9375f),new Vector2f(0.7505f, 0.5625f),new Vector2f(0.813f, 1.0f),new Vector2f(0.7505f, 1.0f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(0.8f, 0.6f, 0.3f),new Vector3f(0.4f, 0.6f, 0.3f),new Vector3f(0.4f, 0.6f, 0.4f),new Vector3f(0.8f, 0.6f, 0.4f),new Vector2f(0.75f, 1.0f),new Vector2f(0.75f, 0.75f),new Vector2f(0.8125f, 0.75f),new Vector2f(0.8125f, 1.0f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(0.4f, 0.8f, -0.4f),new Vector3f(0.4f, 0.9f, -0.4f),new Vector3f(0.8f, 0.9f, -0.4f),new Vector3f(0.8f, 0.8f, -0.4f),new Vector2f(0.500123f, 0.749795f),new Vector2f(0.562346f, 0.749795f),new Vector2f(0.562346f, 0.999908f),new Vector2f(0.500123f, 0.999907f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[8] = new ObjQuad(new Vector3f(0.8f, 0.8f, -0.3f),new Vector3f(0.8f, 0.8f, -0.4f),new Vector3f(0.8f, 0.9f, -0.4f),new Vector3f(0.8f, 0.9f, 0.4f),new Vector2f(0.6255f, 0.9375f),new Vector2f(0.6255f, 1.0f),new Vector2f(0.5625f, 1.0f),new Vector2f(0.5625f, 0.5f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[9] = new ObjQuad(new Vector3f(0.8f, 0.8f, 0.3f),new Vector3f(0.8f, 0.8f, -0.3f),new Vector3f(0.8f, 0.9f, 0.4f),new Vector3f(0.8f, 0.8f, 0.4f),new Vector2f(0.6255f, 0.5625f),new Vector2f(0.6255f, 0.9375f),new Vector2f(0.5625f, 0.5f),new Vector2f(0.6255f, 0.5f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[10] = new ObjQuad(new Vector3f(0.8f, 0.8f, -0.3f),new Vector3f(0.4f, 0.8f, -0.3f),new Vector3f(0.4f, 0.8f, -0.4f),new Vector3f(0.8f, 0.8f, -0.4f),new Vector2f(0.5625f, 1.0f),new Vector2f(0.5625f, 0.75f),new Vector2f(0.625f, 0.75f),new Vector2f(0.625f, 1.0f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[11] = new ObjQuad(new Vector3f(0.8f, 0.0f, -0.2f),new Vector3f(0.8f, 0.0f, -0.3f),new Vector3f(0.8f, 0.1f, -0.3f),new Vector3f(0.8f, 0.1f, -0.2f),new Vector2f(0.75f, 0.0f),new Vector2f(0.75f, 0.0625f),new Vector2f(0.6875f, 0.0625f),new Vector2f(0.6875f, 0.0f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[12] = new ObjQuad(new Vector3f(0.300001f, 0.0f, -0.3f),new Vector3f(0.300001f, 0.1f, -0.3f),new Vector3f(0.8f, 0.1f, -0.3f),new Vector3f(0.8f, 0.0f, -0.3f),new Vector2f(0.625f, 0.3125f),new Vector2f(0.5625f, 0.3125f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.625f, 0.0f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[13] = new ObjQuad(new Vector3f(0.8f, 0.0f, 0.3f),new Vector3f(0.8f, 0.0f, 0.2f),new Vector3f(0.8f, 0.1f, 0.2f),new Vector3f(0.8f, 0.1f, 0.3f),new Vector2f(0.75f, 0.0f),new Vector2f(0.75f, 0.0625f),new Vector2f(0.6875f, 0.0625f),new Vector2f(0.6875f, 0.0f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[14] = new ObjQuad(new Vector3f(0.3f, 0.0f, 0.2f),new Vector3f(0.3f, 0.1f, 0.2f),new Vector3f(0.8f, 0.1f, 0.2f),new Vector3f(0.8f, 0.0f, 0.2f),new Vector2f(0.625f, 0.3125f),new Vector2f(0.5625f, 0.3125f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.625f, 0.0f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[15] = new ObjQuad(new Vector3f(0.8f, 0.5f, -0.4f),new Vector3f(0.8f, 0.5f, 0.4f),new Vector3f(0.4f, 0.5f, 0.4f),new Vector3f(0.4f, 0.5f, -0.4f),new Vector2f(0.5f, 0.5f),new Vector2f(0.0f, 0.5f),new Vector2f(0.0f, 0.25f),new Vector2f(0.5f, 0.25f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[16] = new ObjQuad(new Vector3f(0.8f, 0.5f, 0.4f),new Vector3f(0.8f, 0.6f, 0.4f),new Vector3f(0.4f, 0.6f, 0.4f),new Vector3f(0.4f, 0.5f, 0.4f),new Vector2f(0.812908f, 0.49984f),new Vector2f(0.875329f, 0.49984f),new Vector2f(0.875329f, 0.749874f),new Vector2f(0.812908f, 0.749874f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[17] = new ObjQuad(new Vector3f(0.8f, 0.6f, -0.3f),new Vector3f(0.8f, 0.6f, -0.4f),new Vector3f(0.4f, 0.6f, -0.4f),new Vector3f(0.4f, 0.6f, -0.3f),new Vector2f(0.8125f, 1.0f),new Vector2f(0.75f, 1.0f),new Vector2f(0.75f, 0.75f),new Vector2f(0.8125f, 0.75f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[18] = new ObjQuad(new Vector3f(0.8f, 0.9f, 0.4f),new Vector3f(0.8f, 0.9f, -0.4f),new Vector3f(0.4f, 0.9f, -0.4f),new Vector3f(0.4f, 0.9f, 0.4f),new Vector2f(0.5f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector2f(0.0f, 0.75f),new Vector2f(0.5f, 0.75f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[19] = new ObjQuad(new Vector3f(0.8f, 0.8f, 0.4f),new Vector3f(0.8f, 0.9f, 0.4f),new Vector3f(0.4f, 0.9f, 0.4f),new Vector3f(0.4f, 0.8f, 0.4f),new Vector2f(0.500123f, 0.499682f),new Vector2f(0.562346f, 0.499682f),new Vector2f(0.562346f, 0.749795f),new Vector2f(0.500123f, 0.749795f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[20] = new ObjQuad(new Vector3f(0.8f, 0.8f, 0.3f),new Vector3f(0.8f, 0.8f, 0.4f),new Vector3f(0.4f, 0.8f, 0.4f),new Vector3f(0.4f, 0.8f, 0.3f),new Vector2f(0.625f, 1.0f),new Vector2f(0.5625f, 1.0f),new Vector2f(0.5625f, 0.75f),new Vector2f(0.625f, 0.75f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[21] = new ObjQuad(new Vector3f(0.4f, 0.6f, 0.3f),new Vector3f(0.8f, 0.6f, 0.3f),new Vector3f(0.8f, 0.8f, 0.3f),new Vector3f(0.3f, 0.6f, 0.3f),new Vector2f(0.626142f, 0.749473f),new Vector2f(0.626142f, 0.499333f),new Vector2f(0.75059f, 0.499333f),new Vector2f(0.626142f, 0.812008f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[22] = new ObjQuad(new Vector3f(0.3f, 0.6f, 0.3f),new Vector3f(0.8f, 0.8f, 0.3f),new Vector3f(0.4f, 0.8f, 0.3f),new Vector3f(0.3f, 0.8f, 0.3f),new Vector2f(0.626142f, 0.812008f),new Vector2f(0.75059f, 0.499333f),new Vector2f(0.75059f, 0.749473f),new Vector2f(0.75059f, 0.812008f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[23] = new ObjQuad(new Vector3f(0.8f, 0.0f, -0.3f),new Vector3f(0.8f, 0.0f, -0.2f),new Vector3f(0.300001f, 0.0f, -0.2f),new Vector3f(0.300001f, 0.0f, -0.3f),new Vector2f(0.6875f, 0.5f),new Vector2f(0.625f, 0.5f),new Vector2f(0.625f, 0.1875f),new Vector2f(0.6875f, 0.1875f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[24] = new ObjQuad(new Vector3f(0.8f, 0.1f, -0.2f),new Vector3f(0.8f, 0.1f, -0.3f),new Vector3f(0.300001f, 0.1f, -0.3f),new Vector3f(0.300001f, 0.1f, -0.2f),new Vector2f(0.5f, 0.5f),new Vector2f(0.5625f, 0.5f),new Vector2f(0.5625f, 0.1875f),new Vector2f(0.5f, 0.1875f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[25] = new ObjQuad(new Vector3f(0.8f, 0.0f, -0.2f),new Vector3f(0.8f, 0.1f, -0.2f),new Vector3f(0.300001f, 0.1f, -0.2f),new Vector3f(0.300001f, 0.0f, -0.2f),new Vector2f(0.75f, 0.5f),new Vector2f(0.6875f, 0.5f),new Vector2f(0.6875f, 0.1875f),new Vector2f(0.75f, 0.1875f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[26] = new ObjQuad(new Vector3f(0.8f, 0.0f, 0.2f),new Vector3f(0.8f, 0.0f, 0.3f),new Vector3f(0.3f, 0.0f, 0.3f),new Vector3f(0.3f, 0.0f, 0.2f),new Vector2f(0.6875f, 0.5f),new Vector2f(0.625f, 0.5f),new Vector2f(0.625f, 0.1875f),new Vector2f(0.6875f, 0.1875f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[27] = new ObjQuad(new Vector3f(0.8f, 0.1f, 0.3f),new Vector3f(0.8f, 0.1f, 0.2f),new Vector3f(0.3f, 0.1f, 0.2f),new Vector3f(0.3f, 0.1f, 0.3f),new Vector2f(0.5f, 0.5f),new Vector2f(0.5625f, 0.5f),new Vector2f(0.5625f, 0.1875f),new Vector2f(0.5f, 0.1875f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[28] = new ObjQuad(new Vector3f(0.8f, 0.0f, 0.3f),new Vector3f(0.8f, 0.1f, 0.3f),new Vector3f(0.3f, 0.1f, 0.3f),new Vector3f(0.3f, 0.0f, 0.3f),new Vector2f(0.75f, 0.5f),new Vector2f(0.6875f, 0.5f),new Vector2f(0.6875f, 0.1875f),new Vector2f(0.75f, 0.1875f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[29] = new ObjQuad(new Vector3f(0.629289f, 0.1f, -0.2f),new Vector3f(0.770711f, 0.1f, -0.2f),new Vector3f(0.370711f, 0.5f, -0.2f),new Vector3f(0.3f, 0.5f, -0.2f),new Vector2f(0.625f, 0.380362f),new Vector2f(0.5625f, 0.442862f),new Vector2f(0.5625f, 0.089308f),new Vector2f(0.59375f, 0.058058f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[30] = new ObjQuad(new Vector3f(0.3f, 0.429289f, -0.2f),new Vector3f(0.629289f, 0.1f, -0.2f),new Vector3f(0.3f, 0.5f, -0.2f),new Vector2f(0.625f, 0.089308f),new Vector2f(0.625f, 0.380362f),new Vector2f(0.59375f, 0.058058f),new Vector3f(0.0f, 0.0f, 3.0f));
		this.quads[31] = new ObjQuad(new Vector3f(0.629289f, 0.1f, 0.3f),new Vector3f(0.770711f, 0.1f, 0.3f),new Vector3f(0.370711f, 0.5f, 0.3f),new Vector3f(0.3f, 0.5f, 0.3f),new Vector2f(0.625f, 0.380362f),new Vector2f(0.5625f, 0.442862f),new Vector2f(0.5625f, 0.089308f),new Vector2f(0.59375f, 0.058058f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[32] = new ObjQuad(new Vector3f(0.3f, 0.429289f, 0.3f),new Vector3f(0.629289f, 0.1f, 0.3f),new Vector3f(0.3f, 0.5f, 0.3f),new Vector2f(0.625f, 0.089308f),new Vector2f(0.625f, 0.380362f),new Vector2f(0.59375f, 0.058058f),new Vector3f(1.0E-6f, 0.0f, 3.0f));
		this.quads[33] = new ObjQuad(new Vector3f(0.3f, 0.429289f, -0.2f),new Vector3f(0.3f, 0.429289f, -0.3f),new Vector3f(0.629289f, 0.1f, -0.3f),new Vector3f(0.629289f, 0.1f, -0.2f),new Vector2f(0.6875f, 0.410692f),new Vector2f(0.625f, 0.410692f),new Vector2f(0.625f, 0.119638f),new Vector2f(0.6875f, 0.119638f),new Vector3f(-2.828428f, -2.828428f, 2.0E-6f));
		this.quads[34] = new ObjQuad(new Vector3f(0.370711f, 0.5f, -0.3f),new Vector3f(0.370711f, 0.5f, -0.2f),new Vector3f(0.770711f, 0.1f, -0.2f),new Vector3f(0.770711f, 0.1f, -0.3f),new Vector2f(0.5f, 0.410692f),new Vector2f(0.5625f, 0.410692f),new Vector2f(0.5625f, 0.057138f),new Vector2f(0.5f, 0.057138f),new Vector3f(2.828428f, 2.828428f, -4.0E-6f));
		this.quads[35] = new ObjQuad(new Vector3f(0.3f, 0.429289f, -0.3f),new Vector3f(0.3f, 0.5f, -0.3f),new Vector3f(0.370711f, 0.5f, -0.3f),new Vector3f(0.770711f, 0.1f, -0.3f),new Vector2f(0.75f, 0.410692f),new Vector2f(0.71875f, 0.441942f),new Vector2f(0.6875f, 0.410692f),new Vector2f(0.6875f, 0.057138f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[36] = new ObjQuad(new Vector3f(0.629289f, 0.1f, -0.3f),new Vector3f(0.3f, 0.429289f, -0.3f),new Vector3f(0.770711f, 0.1f, -0.3f),new Vector2f(0.75f, 0.119638f),new Vector2f(0.75f, 0.410692f),new Vector2f(0.6875f, 0.057138f),new Vector3f(0.0f, 0.0f, -3.0f));
		this.quads[37] = new ObjQuad(new Vector3f(0.3f, 0.429289f, 0.3f),new Vector3f(0.3f, 0.429289f, 0.2f),new Vector3f(0.629289f, 0.1f, 0.2f),new Vector3f(0.629289f, 0.1f, 0.3f),new Vector2f(0.6875f, 0.410692f),new Vector2f(0.625f, 0.410692f),new Vector2f(0.625f, 0.119638f),new Vector2f(0.6875f, 0.119638f),new Vector3f(-2.828428f, -2.828428f, 0.0f));
		this.quads[38] = new ObjQuad(new Vector3f(0.370711f, 0.5f, 0.2f),new Vector3f(0.370711f, 0.5f, 0.3f),new Vector3f(0.770711f, 0.1f, 0.3f),new Vector3f(0.770711f, 0.1f, 0.2f),new Vector2f(0.5f, 0.410692f),new Vector2f(0.5625f, 0.410692f),new Vector2f(0.5625f, 0.057138f),new Vector2f(0.5f, 0.057138f),new Vector3f(2.828428f, 2.828428f, 0.0f));
		this.quads[39] = new ObjQuad(new Vector3f(0.3f, 0.429289f, 0.2f),new Vector3f(0.3f, 0.5f, 0.2f),new Vector3f(0.370711f, 0.5f, 0.2f),new Vector3f(0.770711f, 0.1f, 0.2f),new Vector2f(0.75f, 0.410692f),new Vector2f(0.71875f, 0.441942f),new Vector2f(0.6875f, 0.410692f),new Vector2f(0.6875f, 0.057138f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[40] = new ObjQuad(new Vector3f(0.629289f, 0.1f, 0.2f),new Vector3f(0.3f, 0.429289f, 0.2f),new Vector3f(0.770711f, 0.1f, 0.2f),new Vector2f(0.75f, 0.119638f),new Vector2f(0.75f, 0.410692f),new Vector2f(0.6875f, 0.057138f),new Vector3f(0.0f, 0.0f, -3.0f));
		this.quads[41] = new ObjQuad(new Vector3f(0.8f, 0.6f, 0.3f),new Vector3f(0.8f, 0.6f, -0.3f),new Vector3f(0.8f, 0.8f, -0.3f),new Vector3f(0.8f, 0.8f, 0.3f),new Vector2f(0.7505f, 0.5625f),new Vector2f(0.7505f, 0.9375f),new Vector2f(0.6255f, 0.9375f),new Vector2f(0.6255f, 0.5625f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[42] = new ObjQuad(new Vector3f(0.8f, 0.6f, 0.3f),new Vector3f(0.8f, 0.6f, 0.4f),new Vector3f(0.8f, 0.5f, 0.4f),new Vector3f(0.8f, 0.5f, -0.4f),new Vector2f(0.7505f, 0.5625f),new Vector2f(0.7505f, 0.5f),new Vector2f(0.813f, 0.5f),new Vector2f(0.813f, 1.0f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[43] = new ObjQuad(new Vector3f(0.8f, 0.6f, -0.3f),new Vector3f(0.8f, 0.6f, 0.3f),new Vector3f(0.8f, 0.5f, -0.4f),new Vector3f(0.8f, 0.6f, -0.4f),new Vector2f(0.7505f, 0.9375f),new Vector2f(0.7505f, 0.5625f),new Vector2f(0.813f, 1.0f),new Vector2f(0.7505f, 1.0f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[44] = new ObjQuad(new Vector3f(0.8f, 0.8f, -0.3f),new Vector3f(0.8f, 0.8f, -0.4f),new Vector3f(0.8f, 0.9f, -0.4f),new Vector3f(0.8f, 0.9f, 0.4f),new Vector2f(0.6255f, 0.9375f),new Vector2f(0.6255f, 1.0f),new Vector2f(0.5625f, 1.0f),new Vector2f(0.5625f, 0.5f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[45] = new ObjQuad(new Vector3f(0.8f, 0.8f, 0.3f),new Vector3f(0.8f, 0.8f, -0.3f),new Vector3f(0.8f, 0.9f, 0.4f),new Vector3f(0.8f, 0.8f, 0.4f),new Vector2f(0.6255f, 0.5625f),new Vector2f(0.6255f, 0.9375f),new Vector2f(0.5625f, 0.5f),new Vector2f(0.6255f, 0.5f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[46] = new ObjQuad(new Vector3f(0.8f, 0.0f, -0.2f),new Vector3f(0.8f, 0.0f, -0.3f),new Vector3f(0.8f, 0.1f, -0.3f),new Vector3f(0.8f, 0.1f, -0.2f),new Vector2f(0.75f, 0.0f),new Vector2f(0.75f, 0.0625f),new Vector2f(0.6875f, 0.0625f),new Vector2f(0.6875f, 0.0f),new Vector3f(4.0f, 0.0f, 4.0E-6f));
		this.quads[47] = new ObjQuad(new Vector3f(0.8f, 0.0f, 0.3f),new Vector3f(0.8f, 0.0f, 0.2f),new Vector3f(0.8f, 0.1f, 0.2f),new Vector3f(0.8f, 0.1f, 0.3f),new Vector2f(0.75f, 0.0f),new Vector2f(0.75f, 0.0625f),new Vector2f(0.6875f, 0.0625f),new Vector2f(0.6875f, 0.0f),new Vector3f(4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		BackIn001 other = new BackIn001();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

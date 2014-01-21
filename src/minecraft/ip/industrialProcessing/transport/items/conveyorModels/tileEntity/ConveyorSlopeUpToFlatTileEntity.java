package ip.industrialProcessing.transport.items.conveyorModels.tileEntity;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class ConveyorSlopeUpToFlatTileEntity extends ObjMesh{
	public ConveyorSlopeUpToFlatTileEntity(){
		this.quads = new ObjQuad[48];
		this.quads[0] = new ObjQuad(new Vector3f(0.5891f, 1.6023f, -0.2f),new Vector3f(0.5891f, 1.6023f, 0.2f),new Vector3f(0.6939f, 1.7061f, 0.2f),new Vector3f(0.6939f, 1.7061f, -0.2f),new Vector2f(0.125f, 0.9375f),new Vector2f(0.375f, 0.9375f),new Vector2f(0.375f, 1.0f),new Vector2f(0.125f, 1.0f),new Vector3f(-2.7972f, 2.8592f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.6223f, 1.566f, -0.3f),new Vector3f(0.5891f, 1.6023f, -0.2f),new Vector3f(0.6939f, 1.7061f, -0.2f),new Vector3f(0.7293f, 1.6707f, -0.3f),new Vector2f(0.0625f, 0.9375f),new Vector2f(0.125f, 0.9375f),new Vector2f(0.125f, 1.0f),new Vector2f(0.0625f, 1.0f),new Vector3f(-2.4972f, 2.5724f, -1.7736001f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.6941f, 0.9023f, 0.3f),new Vector3f(-0.6963f, 0.9514f, 0.2f),new Vector3f(-0.8f, 0.95f, 0.2f),new Vector3f(-0.8f, 0.9f, 0.3f),new Vector2f(0.4375f, 0.0625f),new Vector2f(0.375f, 0.0625f),new Vector2f(0.375f, 0.0f),new Vector2f(0.4375f, 0.0f),new Vector3f(-0.1093f, 3.5837998f, 1.7731f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.8f, 0.95f, -0.2f),new Vector3f(-0.8f, 0.95f, 0.2f),new Vector3f(-0.6963f, 0.9514f, 0.2f),new Vector3f(-0.6963f, 0.9514f, -0.2f),new Vector2f(0.125f, 0.0f),new Vector2f(0.375f, 0.0f),new Vector2f(0.375f, 0.0625f),new Vector2f(0.125f, 0.0625f),new Vector3f(-0.1016f, 3.9984f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.8f, 0.9f, -0.3f),new Vector3f(-0.8f, 0.95f, -0.2f),new Vector3f(-0.6963f, 0.9514f, -0.2f),new Vector3f(-0.6941f, 0.9023f, -0.3f),new Vector2f(0.0625f, 0.0f),new Vector2f(0.125f, 0.0f),new Vector2f(0.125f, 0.0625f),new Vector2f(0.0625f, 0.0625f),new Vector3f(-0.10249999f, 3.5837002f, -1.7731999f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.5929f, 0.9093f, 0.3f),new Vector3f(-0.5973f, 0.9575f, 0.2f),new Vector3f(-0.6963f, 0.9514f, 0.2f),new Vector3f(-0.6941f, 0.9023f, 0.3f),new Vector2f(0.4375f, 0.125f),new Vector2f(0.375f, 0.125f),new Vector2f(0.375f, 0.0625f),new Vector2f(0.4375f, 0.0625f),new Vector3f(-0.2402f, 3.5862f, 1.7531999f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.6963f, 0.9514f, -0.2f),new Vector3f(-0.6963f, 0.9514f, 0.2f),new Vector3f(-0.5973f, 0.9575f, 0.2f),new Vector3f(-0.5973f, 0.9575f, -0.2f),new Vector2f(0.125f, 0.0625f),new Vector2f(0.375f, 0.0625f),new Vector2f(0.375f, 0.125f),new Vector2f(0.125f, 0.125f),new Vector3f(-0.2526f, 3.9908f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.6941f, 0.9023f, -0.3f),new Vector3f(-0.6963f, 0.9514f, -0.2f),new Vector3f(-0.5973f, 0.9575f, -0.2f),new Vector3f(-0.5929f, 0.9093f, -0.3f),new Vector2f(0.0625f, 0.0625f),new Vector2f(0.125f, 0.0625f),new Vector2f(0.125f, 0.125f),new Vector2f(0.0625f, 0.125f),new Vector3f(-0.24110001f, 3.586f, -1.7532f));
		this.quads[8] = new ObjQuad(new Vector3f(-0.4957f, 0.9213f, 0.3f),new Vector3f(-0.5023f, 0.9686f, 0.2f),new Vector3f(-0.5973f, 0.9575f, 0.2f),new Vector3f(-0.5929f, 0.9093f, 0.3f),new Vector2f(0.4375f, 0.1875f),new Vector2f(0.375f, 0.1875f),new Vector2f(0.375f, 0.125f),new Vector2f(0.4375f, 0.125f),new Vector3f(-0.4331f, 3.5778f, 1.7326001f));
		this.quads[9] = new ObjQuad(new Vector3f(-0.5973f, 0.9575f, -0.2f),new Vector3f(-0.5973f, 0.9575f, 0.2f),new Vector3f(-0.5023f, 0.9686f, 0.2f),new Vector3f(-0.5023f, 0.9686f, -0.2f),new Vector2f(0.125f, 0.125f),new Vector2f(0.375f, 0.125f),new Vector2f(0.375f, 0.1875f),new Vector2f(0.125f, 0.1875f),new Vector3f(-0.468f, 3.9710002f, 0.0f));
		this.quads[10] = new ObjQuad(new Vector3f(-0.5929f, 0.9093f, -0.3f),new Vector3f(-0.5973f, 0.9575f, -0.2f),new Vector3f(-0.5023f, 0.9686f, -0.2f),new Vector3f(-0.4957f, 0.9213f, -0.3f),new Vector2f(0.0625f, 0.125f),new Vector2f(0.125f, 0.125f),new Vector2f(0.125f, 0.1875f),new Vector2f(0.0625f, 0.1875f),new Vector3f(-0.4342f, 3.5774999f, -1.7326f));
		this.quads[11] = new ObjQuad(new Vector3f(-0.4018f, 0.9385f, 0.3f),new Vector3f(-0.4107f, 0.9848f, 0.2f),new Vector3f(-0.5023f, 0.9686f, 0.2f),new Vector3f(-0.4957f, 0.9213f, 0.3f),new Vector2f(0.4375f, 0.25f),new Vector2f(0.375f, 0.25f),new Vector2f(0.375f, 0.1875f),new Vector2f(0.4375f, 0.1875f),new Vector3f(-0.6429f, 3.5544f, 1.7149f));
		this.quads[12] = new ObjQuad(new Vector3f(-0.5023f, 0.9686f, -0.2f),new Vector3f(-0.5023f, 0.9686f, 0.2f),new Vector3f(-0.4107f, 0.9848f, 0.2f),new Vector3f(-0.4107f, 0.9848f, -0.2f),new Vector2f(0.125f, 0.1875f),new Vector2f(0.375f, 0.1875f),new Vector2f(0.375f, 0.25f),new Vector2f(0.125f, 0.25f),new Vector3f(-0.70159996f, 3.936f, 0.0f));
		this.quads[13] = new ObjQuad(new Vector3f(-0.4957f, 0.9213f, -0.3f),new Vector3f(-0.5023f, 0.9686f, -0.2f),new Vector3f(-0.4107f, 0.9848f, -0.2f),new Vector3f(-0.4018f, 0.9385f, -0.3f),new Vector2f(0.0625f, 0.1875f),new Vector2f(0.125f, 0.1875f),new Vector2f(0.125f, 0.25f),new Vector2f(0.0625f, 0.25f),new Vector3f(-0.6441f, 3.5541f, -1.7149f));
		this.quads[14] = new ObjQuad(new Vector3f(-0.3105f, 0.9611f, 0.3f),new Vector3f(-0.3215f, 1.0065f, 0.2f),new Vector3f(-0.4107f, 0.9848f, 0.2f),new Vector3f(-0.4018f, 0.9385f, 0.3f),new Vector2f(0.4375f, 0.3125f),new Vector2f(0.375f, 0.3125f),new Vector2f(0.375f, 0.25f),new Vector2f(0.4375f, 0.25f),new Vector3f(-0.8639f, 3.5141f, 1.7003f));
		this.quads[15] = new ObjQuad(new Vector3f(-0.4107f, 0.9848f, -0.2f),new Vector3f(-0.4107f, 0.9848f, 0.2f),new Vector3f(-0.3215f, 1.0065f, 0.2f),new Vector3f(-0.3215f, 1.0065f, -0.2f),new Vector2f(0.125f, 0.25f),new Vector2f(0.375f, 0.25f),new Vector2f(0.375f, 0.3125f),new Vector2f(0.125f, 0.3125f),new Vector3f(-0.9476f, 3.8839998f, 0.0f));
		this.quads[16] = new ObjQuad(new Vector3f(-0.4018f, 0.9385f, -0.3f),new Vector3f(-0.4107f, 0.9848f, -0.2f),new Vector3f(-0.3215f, 1.0065f, -0.2f),new Vector3f(-0.3105f, 0.9611f, -0.3f),new Vector2f(0.0625f, 0.25f),new Vector2f(0.125f, 0.25f),new Vector2f(0.125f, 0.3125f),new Vector2f(0.0625f, 0.3125f),new Vector3f(-0.8652f, 3.5138001f, -1.7003f));
		this.quads[17] = new ObjQuad(new Vector3f(-0.2209f, 0.9894f, 0.3f),new Vector3f(-0.2342f, 1.0339f, 0.2f),new Vector3f(-0.3215f, 1.0065f, 0.2f),new Vector3f(-0.3105f, 0.9611f, 0.3f),new Vector2f(0.4375f, 0.375f),new Vector2f(0.375f, 0.375f),new Vector2f(0.375f, 0.3125f),new Vector2f(0.4375f, 0.3125f),new Vector3f(-1.0894f, 3.4564002f, 1.6888f));
		this.quads[18] = new ObjQuad(new Vector3f(-0.3215f, 1.0065f, -0.2f),new Vector3f(-0.3215f, 1.0065f, 0.2f),new Vector3f(-0.2342f, 1.0339f, 0.2f),new Vector3f(-0.2342f, 1.0339f, -0.2f),new Vector2f(0.125f, 0.3125f),new Vector2f(0.375f, 0.3125f),new Vector2f(0.375f, 0.375f),new Vector2f(0.125f, 0.375f),new Vector3f(-1.1982f, 3.8142002f, 0.0f));
		this.quads[19] = new ObjQuad(new Vector3f(-0.3105f, 0.9611f, -0.3f),new Vector3f(-0.3215f, 1.0065f, -0.2f),new Vector3f(-0.2342f, 1.0339f, -0.2f),new Vector3f(-0.2209f, 0.9894f, -0.3f),new Vector2f(0.0625f, 0.3125f),new Vector2f(0.125f, 0.3125f),new Vector2f(0.125f, 0.375f),new Vector2f(0.0625f, 0.375f),new Vector3f(-1.0907f, 3.456f, -1.6888001f));
		this.quads[20] = new ObjQuad(new Vector3f(-0.1324f, 1.0239f, 0.3f),new Vector3f(-0.1478f, 1.0675f, 0.2f),new Vector3f(-0.2342f, 1.0339f, 0.2f),new Vector3f(-0.2209f, 0.9894f, 0.3f),new Vector2f(0.4375f, 0.4375f),new Vector2f(0.375f, 0.4375f),new Vector2f(0.375f, 0.375f),new Vector2f(0.4375f, 0.375f),new Vector3f(-1.3119f, 3.3824f, 1.6806f));
		this.quads[21] = new ObjQuad(new Vector3f(-0.2342f, 1.0339f, -0.2f),new Vector3f(-0.2342f, 1.0339f, 0.2f),new Vector3f(-0.1478f, 1.0675f, 0.2f),new Vector3f(-0.1478f, 1.0675f, -0.2f),new Vector2f(0.125f, 0.375f),new Vector2f(0.375f, 0.375f),new Vector2f(0.375f, 0.4375f),new Vector2f(0.125f, 0.4375f),new Vector3f(-1.4452001f, 3.7275999f, 0.0f));
		this.quads[22] = new ObjQuad(new Vector3f(-0.2209f, 0.9894f, -0.3f),new Vector3f(-0.2342f, 1.0339f, -0.2f),new Vector3f(-0.1478f, 1.0675f, -0.2f),new Vector3f(-0.1324f, 1.0239f, -0.3f),new Vector2f(0.0625f, 0.375f),new Vector2f(0.125f, 0.375f),new Vector2f(0.125f, 0.4375f),new Vector2f(0.0625f, 0.4375f),new Vector3f(-1.3132f, 3.3818998f, -1.6805999f));
		this.quads[23] = new ObjQuad(new Vector3f(-0.044f, 1.0648f, 0.3f),new Vector3f(-0.0617f, 1.1075f, 0.2f),new Vector3f(-0.1478f, 1.0675f, 0.2f),new Vector3f(-0.1324f, 1.0239f, 0.3f),new Vector2f(0.4375f, 0.5f),new Vector2f(0.375f, 0.5f),new Vector2f(0.375f, 0.4375f),new Vector2f(0.4375f, 0.4375f),new Vector3f(-1.5242f, 3.2947001f, 1.6759f));
		this.quads[24] = new ObjQuad(new Vector3f(-0.1478f, 1.0675f, -0.2f),new Vector3f(-0.1478f, 1.0675f, 0.2f),new Vector3f(-0.0617f, 1.1075f, 0.2f),new Vector3f(-0.0617f, 1.1075f, -0.2f),new Vector2f(0.125f, 0.4375f),new Vector2f(0.375f, 0.4375f),new Vector2f(0.375f, 0.5f),new Vector2f(0.125f, 0.5f),new Vector3f(-1.681f, 3.6274f, 0.0f));
		this.quads[25] = new ObjQuad(new Vector3f(-0.1324f, 1.0239f, -0.3f),new Vector3f(-0.1478f, 1.0675f, -0.2f),new Vector3f(-0.0617f, 1.1075f, -0.2f),new Vector3f(-0.044f, 1.0648f, -0.3f),new Vector2f(0.0625f, 0.4375f),new Vector2f(0.125f, 0.4375f),new Vector2f(0.125f, 0.5f),new Vector2f(0.0625f, 0.5f),new Vector3f(-1.5255f, 3.2942f, -1.6759f));
		this.quads[26] = new ObjQuad(new Vector3f(0.0448f, 1.1126f, 0.3f),new Vector3f(0.0249f, 1.1544f, 0.2f),new Vector3f(-0.0617f, 1.1075f, 0.2f),new Vector3f(-0.044f, 1.0648f, 0.3f),new Vector2f(0.4375f, 0.5625f),new Vector2f(0.375f, 0.5625f),new Vector2f(0.375f, 0.5f),new Vector2f(0.4375f, 0.5f),new Vector3f(-1.7206f, 3.1972f, 1.6750001f));
		this.quads[27] = new ObjQuad(new Vector3f(-0.0617f, 1.1075f, -0.2f),new Vector3f(-0.0617f, 1.1075f, 0.2f),new Vector3f(0.0249f, 1.1544f, 0.2f),new Vector3f(0.0249f, 1.1544f, -0.2f),new Vector2f(0.125f, 0.5f),new Vector2f(0.375f, 0.5f),new Vector2f(0.375f, 0.5625f),new Vector2f(0.125f, 0.5625f),new Vector3f(-1.8994f, 3.5182f, 0.0f));
		this.quads[28] = new ObjQuad(new Vector3f(-0.044f, 1.0648f, -0.3f),new Vector3f(-0.0617f, 1.1075f, -0.2f),new Vector3f(0.0249f, 1.1544f, -0.2f),new Vector3f(0.0448f, 1.1126f, -0.3f),new Vector2f(0.0625f, 0.5f),new Vector2f(0.125f, 0.5f),new Vector2f(0.125f, 0.5625f),new Vector2f(0.0625f, 0.5625f),new Vector3f(-1.7216f, 3.1968f, -1.6748999f));
		this.quads[29] = new ObjQuad(new Vector3f(0.1348f, 1.1677f, 0.3f),new Vector3f(0.1127f, 1.2085f, 0.2f),new Vector3f(0.0249f, 1.1544f, 0.2f),new Vector3f(0.0448f, 1.1126f, 0.3f),new Vector2f(0.4375f, 0.625f),new Vector2f(0.375f, 0.625f),new Vector2f(0.375f, 0.5625f),new Vector2f(0.4375f, 0.5625f),new Vector3f(-1.8968999f, 3.0945f, 1.6782f));
		this.quads[30] = new ObjQuad(new Vector3f(0.0249f, 1.1544f, -0.2f),new Vector3f(0.0249f, 1.1544f, 0.2f),new Vector3f(0.1127f, 1.2085f, 0.2f),new Vector3f(0.1127f, 1.2085f, -0.2f),new Vector2f(0.125f, 0.5625f),new Vector2f(0.375f, 0.5625f),new Vector2f(0.375f, 0.625f),new Vector2f(0.125f, 0.625f),new Vector3f(-2.0962f, 3.4049997f, 0.0f));
		this.quads[31] = new ObjQuad(new Vector3f(0.0448f, 1.1126f, -0.3f),new Vector3f(0.0249f, 1.1544f, -0.2f),new Vector3f(0.1127f, 1.2085f, -0.2f),new Vector3f(0.1348f, 1.1677f, -0.3f),new Vector2f(0.0625f, 0.5625f),new Vector2f(0.125f, 0.5625f),new Vector2f(0.125f, 0.625f),new Vector2f(0.0625f, 0.625f),new Vector3f(-1.8978001f, 3.0940998f, -1.678f));
		this.quads[32] = new ObjQuad(new Vector3f(0.2265f, 1.2305f, 0.3f),new Vector3f(0.2022f, 1.2704f, 0.2f),new Vector3f(0.1127f, 1.2085f, 0.2f),new Vector3f(0.1348f, 1.1677f, 0.3f),new Vector2f(0.4375f, 0.6875f),new Vector2f(0.375f, 0.6875f),new Vector2f(0.375f, 0.625f),new Vector2f(0.4375f, 0.625f),new Vector3f(-2.0509999f, 2.9909f, 1.6854f));
		this.quads[33] = new ObjQuad(new Vector3f(0.1127f, 1.2085f, -0.2f),new Vector3f(0.1127f, 1.2085f, 0.2f),new Vector3f(0.2022f, 1.2704f, 0.2f),new Vector3f(0.2022f, 1.2704f, -0.2f),new Vector2f(0.125f, 0.625f),new Vector2f(0.375f, 0.625f),new Vector2f(0.375f, 0.6875f),new Vector2f(0.125f, 0.6875f),new Vector3f(-2.2694001f, 3.2924001f, 0.0f));
		this.quads[34] = new ObjQuad(new Vector3f(0.1348f, 1.1677f, -0.3f),new Vector3f(0.1127f, 1.2085f, -0.2f),new Vector3f(0.2022f, 1.2704f, -0.2f),new Vector3f(0.2265f, 1.2305f, -0.3f),new Vector2f(0.0625f, 0.625f),new Vector2f(0.125f, 0.625f),new Vector2f(0.125f, 0.6875f),new Vector2f(0.0625f, 0.6875f),new Vector3f(-2.0518f, 2.9903998f, -1.6852999f));
		this.quads[35] = new ObjQuad(new Vector3f(0.3206f, 1.3014f, 0.3f),new Vector3f(0.2941f, 1.3404f, 0.2f),new Vector3f(0.2022f, 1.2704f, 0.2f),new Vector3f(0.2265f, 1.2305f, 0.3f),new Vector2f(0.4375f, 0.75f),new Vector2f(0.375f, 0.75f),new Vector2f(0.375f, 0.6875f),new Vector2f(0.4375f, 0.6875f),new Vector3f(-2.1826f, 2.89f, 1.6966f));
		this.quads[36] = new ObjQuad(new Vector3f(0.2022f, 1.2704f, -0.2f),new Vector3f(0.2022f, 1.2704f, 0.2f),new Vector3f(0.2941f, 1.3404f, 0.2f),new Vector3f(0.2941f, 1.3404f, -0.2f),new Vector2f(0.125f, 0.6875f),new Vector2f(0.375f, 0.6875f),new Vector2f(0.375f, 0.75f),new Vector2f(0.125f, 0.75f),new Vector3f(-2.4188f, 3.1845999f, 0.0f));
		this.quads[37] = new ObjQuad(new Vector3f(0.2265f, 1.2305f, -0.3f),new Vector3f(0.2022f, 1.2704f, -0.2f),new Vector3f(0.2941f, 1.3404f, -0.2f),new Vector3f(0.3206f, 1.3014f, -0.3f),new Vector2f(0.0625f, 0.6875f),new Vector2f(0.125f, 0.6875f),new Vector2f(0.125f, 0.75f),new Vector2f(0.0625f, 0.75f),new Vector3f(-2.1832001f, 2.8895001f, -1.6966f));
		this.quads[38] = new ObjQuad(new Vector3f(0.4176f, 1.3807f, 0.3f),new Vector3f(0.3889f, 1.4188f, 0.2f),new Vector3f(0.2941f, 1.3404f, 0.2f),new Vector3f(0.3206f, 1.3014f, 0.3f),new Vector2f(0.4375f, 0.8125f),new Vector2f(0.375f, 0.8125f),new Vector2f(0.375f, 0.75f),new Vector2f(0.4375f, 0.75f),new Vector3f(-2.2926002f, 2.7946f, 1.7118001f));
		this.quads[39] = new ObjQuad(new Vector3f(0.2941f, 1.3404f, -0.2f),new Vector3f(0.2941f, 1.3404f, 0.2f),new Vector3f(0.3889f, 1.4188f, 0.2f),new Vector3f(0.3889f, 1.4188f, -0.2f),new Vector2f(0.125f, 0.75f),new Vector2f(0.375f, 0.75f),new Vector2f(0.375f, 0.8125f),new Vector2f(0.125f, 0.8125f),new Vector3f(-2.5456f, 3.0846f, 0.0f));
		this.quads[40] = new ObjQuad(new Vector3f(0.3206f, 1.3014f, -0.3f),new Vector3f(0.2941f, 1.3404f, -0.2f),new Vector3f(0.3889f, 1.4188f, -0.2f),new Vector3f(0.4176f, 1.3807f, -0.3f),new Vector2f(0.0625f, 0.75f),new Vector2f(0.125f, 0.75f),new Vector2f(0.125f, 0.8125f),new Vector2f(0.0625f, 0.8125f),new Vector3f(-2.2930999f, 2.7941f, -1.7117001f));
		this.quads[41] = new ObjQuad(new Vector3f(0.518f, 1.4688f, 0.3f),new Vector3f(0.487f, 1.506f, 0.2f),new Vector3f(0.3889f, 1.4188f, 0.2f),new Vector3f(0.4176f, 1.3807f, 0.3f),new Vector2f(0.4375f, 0.875f),new Vector2f(0.375f, 0.875f),new Vector2f(0.375f, 0.8125f),new Vector2f(0.4375f, 0.8125f),new Vector3f(-2.3827f, 2.7065f, 1.7305f));
		this.quads[42] = new ObjQuad(new Vector3f(0.3889f, 1.4188f, -0.2f),new Vector3f(0.3889f, 1.4188f, 0.2f),new Vector3f(0.487f, 1.506f, 0.2f),new Vector3f(0.487f, 1.506f, -0.2f),new Vector2f(0.125f, 0.8125f),new Vector2f(0.375f, 0.8125f),new Vector2f(0.375f, 0.875f),new Vector2f(0.125f, 0.875f),new Vector3f(-2.6518f, 2.994f, 0.0f));
		this.quads[43] = new ObjQuad(new Vector3f(0.4176f, 1.3807f, -0.3f),new Vector3f(0.3889f, 1.4188f, -0.2f),new Vector3f(0.487f, 1.506f, -0.2f),new Vector3f(0.518f, 1.4688f, -0.3f),new Vector2f(0.0625f, 0.8125f),new Vector2f(0.125f, 0.8125f),new Vector2f(0.125f, 0.875f),new Vector2f(0.0625f, 0.875f),new Vector3f(-2.3830001f, 2.7061f, -1.7303f));
		this.quads[44] = new ObjQuad(new Vector3f(0.6223f, 1.566f, 0.3f),new Vector3f(0.5891f, 1.6023f, 0.2f),new Vector3f(0.487f, 1.506f, 0.2f),new Vector3f(0.518f, 1.4688f, 0.3f),new Vector2f(0.4375f, 0.9375f),new Vector2f(0.375f, 0.9375f),new Vector2f(0.375f, 0.875f),new Vector2f(0.4375f, 0.875f),new Vector3f(-2.4549f, 2.6268997f, 1.7521f));
		this.quads[45] = new ObjQuad(new Vector3f(0.487f, 1.506f, -0.2f),new Vector3f(0.487f, 1.506f, 0.2f),new Vector3f(0.5891f, 1.6023f, 0.2f),new Vector3f(0.5891f, 1.6023f, -0.2f),new Vector2f(0.125f, 0.875f),new Vector2f(0.375f, 0.875f),new Vector2f(0.375f, 0.9375f),new Vector2f(0.125f, 0.9375f),new Vector3f(-2.7398f, 2.9138f, 0.0f));
		this.quads[46] = new ObjQuad(new Vector3f(0.518f, 1.4688f, -0.3f),new Vector3f(0.487f, 1.506f, -0.2f),new Vector3f(0.5891f, 1.6023f, -0.2f),new Vector3f(0.6223f, 1.566f, -0.3f),new Vector2f(0.0625f, 0.875f),new Vector2f(0.125f, 0.875f),new Vector2f(0.125f, 0.9375f),new Vector2f(0.0625f, 0.9375f),new Vector3f(-2.4551f, 2.6267f, -1.7520001f));
		this.quads[47] = new ObjQuad(new Vector3f(0.7293f, 1.6707f, 0.3f),new Vector3f(0.6939f, 1.7061f, 0.2f),new Vector3f(0.5891f, 1.6023f, 0.2f),new Vector3f(0.6223f, 1.566f, 0.3f),new Vector2f(0.4375f, 1.0f),new Vector2f(0.375f, 1.0f),new Vector2f(0.375f, 0.9375f),new Vector2f(0.4375f, 0.9375f),new Vector3f(-2.5015998f, 2.5682f, 1.7736f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		ConveyorSlopeUpToFlatTileEntity other = new ConveyorSlopeUpToFlatTileEntity();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

package  mod.industrialProcessing.plants.construction.machineBlock.model;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Works extends ObjMesh{
	public Works(){
		this.quads = new ObjQuad[42];
		this.quads[0] = new ObjQuad(new Vector3f(-0.6f, 0.254f, -0.2753f),new Vector3f(-0.6f, 0.246f, -0.3247f),new Vector3f(0.5f, 0.246f, -0.3247f),new Vector3f(0.5f, 0.254f, -0.2753f),new Vector2f(0.8461f, 0.5261f),new Vector2f(0.8461f, 0.5489f),new Vector2f(0.2058f, 0.5489f),new Vector2f(0.2058f, 0.5261f),new Vector3f(0.0f, -3.9488f, 0.6384f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.6f, 1.8335f, -0.5307f),new Vector3f(0.5f, 1.8335f, -0.5307f),new Vector3f(0.5f, 1.8255f, -0.58f),new Vector3f(-0.6f, 1.8255f, -0.58f),new Vector2f(0.1476f, 0.6454f),new Vector2f(0.7879f, 0.6454f),new Vector2f(0.7879f, 0.6682f),new Vector2f(0.1476f, 0.6682f),new Vector3f(0.0f, 3.9488f, -0.6384f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.6f, 0.254f, -0.2753f),new Vector3f(0.5f, 0.254f, -0.2753f),new Vector3f(0.5f, 1.8335f, -0.5307f),new Vector3f(-0.6f, 1.8335f, -0.5307f),new Vector2f(0.1476f, 0.1464f),new Vector2f(0.7879f, 0.1464f),new Vector2f(0.7879f, 0.8768f),new Vector2f(0.1476f, 0.8768f),new Vector3f(0.0f, 0.6384f, 3.9488f));
		this.quads[3] = new ObjQuad(new Vector3f(0.5f, 0.254f, -0.2753f),new Vector3f(0.5f, 0.246f, -0.3247f),new Vector3f(0.5f, 1.8255f, -0.58f),new Vector3f(0.5f, 1.8335f, -0.5307f),new Vector2f(0.6566f, 0.1464f),new Vector2f(0.6853f, 0.1427f),new Vector2f(0.8355f, 0.8731f),new Vector2f(0.8068f, 0.8768f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.5f, 0.246f, -0.3247f),new Vector3f(-0.6f, 0.246f, -0.3247f),new Vector3f(-0.6f, 1.8255f, -0.58f),new Vector3f(0.5f, 1.8255f, -0.58f),new Vector2f(0.2058f, 0.1427f),new Vector2f(0.8461f, 0.1427f),new Vector2f(0.8461f, 0.8731f),new Vector2f(0.2058f, 0.8731f),new Vector3f(0.0f, -0.6384f, -3.9488f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.6f, 0.246f, -0.3247f),new Vector3f(-0.6f, 0.254f, -0.2753f),new Vector3f(-0.6f, 1.8335f, -0.5307f),new Vector3f(-0.6f, 1.8255f, -0.58f),new Vector2f(0.3084f, 0.1427f),new Vector2f(0.3371f, 0.1464f),new Vector2f(0.187f, 0.8768f),new Vector2f(0.1583f, 0.8731f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.52f, 0.2524f, -0.4251f),new Vector3f(-0.52f, 0.2476f, -0.4749f),new Vector3f(0.58f, 0.2476f, -0.4749f),new Vector3f(0.58f, 0.2524f, -0.4251f),new Vector2f(0.7996f, 0.5954f),new Vector2f(0.7996f, 0.6184f),new Vector2f(0.1593f, 0.6184f),new Vector2f(0.1593f, 0.5954f),new Vector3f(0.0f, -3.9812f, 0.3864f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.52f, 1.8449f, -0.5797f),new Vector3f(0.58f, 1.8449f, -0.5797f),new Vector3f(0.58f, 1.8401f, -0.6295f),new Vector3f(-0.52f, 1.8401f, -0.6295f),new Vector2f(0.1942f, 0.6681f),new Vector2f(0.8345f, 0.6681f),new Vector2f(0.8345f, 0.6911f),new Vector2f(0.1942f, 0.6911f),new Vector3f(0.0f, 3.9812f, -0.3864f));
		this.quads[8] = new ObjQuad(new Vector3f(-0.52f, 0.2524f, -0.4251f),new Vector3f(0.58f, 0.2524f, -0.4251f),new Vector3f(0.58f, 1.8449f, -0.5797f),new Vector3f(-0.52f, 1.8449f, -0.5797f),new Vector2f(0.1942f, 0.1456f),new Vector2f(0.8345f, 0.1456f),new Vector2f(0.8345f, 0.8821f),new Vector2f(0.1942f, 0.8821f),new Vector3f(0.0f, 0.3864f, 3.9812f));
		this.quads[9] = new ObjQuad(new Vector3f(0.58f, 0.2524f, -0.4251f),new Vector3f(0.58f, 0.2476f, -0.4749f),new Vector3f(0.58f, 1.8401f, -0.6295f),new Vector3f(0.58f, 1.8449f, -0.5797f),new Vector2f(0.7438f, 0.1456f),new Vector2f(0.7728f, 0.1433f),new Vector2f(0.8643f, 0.8798f),new Vector2f(0.8353f, 0.8821f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[10] = new ObjQuad(new Vector3f(0.58f, 0.2476f, -0.4749f),new Vector3f(-0.52f, 0.2476f, -0.4749f),new Vector3f(-0.52f, 1.8401f, -0.6295f),new Vector3f(0.58f, 1.8401f, -0.6295f),new Vector2f(0.1593f, 0.1433f),new Vector2f(0.7996f, 0.1433f),new Vector2f(0.7996f, 0.8798f),new Vector2f(0.1593f, 0.8798f),new Vector3f(0.0f, -0.3864f, -3.9812f));
		this.quads[11] = new ObjQuad(new Vector3f(-0.52f, 0.2476f, -0.4749f),new Vector3f(-0.52f, 0.2524f, -0.4251f),new Vector3f(-0.52f, 1.8449f, -0.5797f),new Vector3f(-0.52f, 1.8401f, -0.6295f),new Vector2f(0.221f, 0.1433f),new Vector2f(0.25f, 0.1456f),new Vector2f(0.1584f, 0.8821f),new Vector2f(0.1295f, 0.8798f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[12] = new ObjQuad(new Vector3f(0.1542f, 0.2909f, 0.0469f),new Vector3f(0.2439f, 0.3341f, 0.0563f),new Vector3f(0.2458f, 0.3091f, 0.1531f),new Vector3f(0.1561f, 0.2659f, 0.1437f),new Vector2f(0.4071f, 0.3771f),new Vector2f(0.3549f, 0.3728f),new Vector2f(0.3538f, 0.328f),new Vector2f(0.406f, 0.3323f),new Vector3f(1.7676f, -3.4656f, -0.9308f));
		this.quads[13] = new ObjQuad(new Vector3f(-0.7296f, 2.0237f, 0.5122f),new Vector3f(-0.7277f, 1.9986f, 0.609f),new Vector3f(-0.638f, 2.0418f, 0.6184f),new Vector3f(-0.6399f, 2.0669f, 0.5216f),new Vector2f(0.0722f, 0.1632f),new Vector2f(0.0733f, 0.1184f),new Vector2f(0.1255f, 0.114f),new Vector2f(0.1244f, 0.1588f),new Vector3f(-1.7676f, 3.4656f, 0.9308f));
		this.quads[14] = new ObjQuad(new Vector3f(0.1542f, 0.2909f, 0.0469f),new Vector3f(0.1561f, 0.2659f, 0.1437f),new Vector3f(-0.7277f, 1.9986f, 0.609f),new Vector3f(-0.7296f, 2.0237f, 0.5122f),new Vector2f(0.5247f, 0.1637f),new Vector2f(0.581f, 0.1522f),new Vector2f(0.8502f, 0.9541f),new Vector2f(0.7939f, 0.9656f),new Vector3f(-3.5876f, -1.7284f, -0.3776f));
		this.quads[15] = new ObjQuad(new Vector3f(0.1561f, 0.2659f, 0.1437f),new Vector3f(0.2458f, 0.3091f, 0.1531f),new Vector3f(-0.638f, 2.0418f, 0.6184f),new Vector3f(-0.7277f, 1.9986f, 0.609f),new Vector2f(0.5877f, 0.1522f),new Vector2f(0.64f, 0.1722f),new Vector2f(0.1255f, 0.974f),new Vector2f(0.0733f, 0.9541f),new Vector3f(0.0752f, -1.0016f, 3.872f));
		this.quads[16] = new ObjQuad(new Vector3f(0.2458f, 0.3091f, 0.1531f),new Vector3f(0.2439f, 0.3341f, 0.0563f),new Vector3f(-0.6399f, 2.0669f, 0.5216f),new Vector3f(-0.638f, 2.0418f, 0.6184f),new Vector2f(0.4073f, 0.1722f),new Vector2f(0.4637f, 0.1837f),new Vector2f(0.1945f, 0.9856f),new Vector2f(0.1381f, 0.974f),new Vector3f(3.5876f, 1.7284f, 0.3776f));
		this.quads[17] = new ObjQuad(new Vector3f(0.2439f, 0.3341f, 0.0563f),new Vector3f(0.1542f, 0.2909f, 0.0469f),new Vector3f(-0.7296f, 2.0237f, 0.5122f),new Vector3f(-0.6399f, 2.0669f, 0.5216f),new Vector2f(0.3549f, 0.1837f),new Vector2f(0.4071f, 0.1637f),new Vector2f(0.9216f, 0.9656f),new Vector2f(0.8693f, 0.9856f),new Vector3f(-0.0752f, 1.0016f, -3.872f));
		this.quads[18] = new ObjQuad(new Vector3f(0.0355f, 0.2843f, -0.1243f),new Vector3f(0.1129f, 0.3375f, -0.1585f),new Vector3f(0.1645f, 0.3157f, -0.0757f),new Vector3f(0.0871f, 0.2625f, -0.0415f),new Vector2f(0.4762f, 0.4563f),new Vector2f(0.4311f, 0.4721f),new Vector2f(0.4011f, 0.4338f),new Vector2f(0.4462f, 0.4179f),new Vector3f(1.4652f, -3.2728f, -1.7728f));
		this.quads[19] = new ObjQuad(new Vector3f(-0.6971f, 1.9206f, 0.7621f),new Vector3f(-0.6455f, 1.8988f, 0.845f),new Vector3f(-0.5681f, 1.952f, 0.8108f),new Vector3f(-0.6196f, 1.9738f, 0.7279f),new Vector2f(0.0911f, 0.0475f),new Vector2f(0.1211f, 0.0092f),new Vector2f(0.1662f, 0.025f),new Vector2f(0.1362f, 0.0634f),new Vector3f(-1.4652f, 3.2728f, 1.7728f));
		this.quads[20] = new ObjQuad(new Vector3f(0.0355f, 0.2843f, -0.1243f),new Vector3f(0.0871f, 0.2625f, -0.0415f),new Vector3f(-0.6455f, 1.8988f, 0.845f),new Vector3f(-0.6971f, 1.9206f, 0.7621f),new Vector2f(0.425f, 0.1605f),new Vector2f(0.4733f, 0.1505f),new Vector2f(0.9877f, 0.9081f),new Vector2f(0.9394f, 0.9181f),new Vector3f(-3.098f, -2.1284f, 1.3684f));
		this.quads[21] = new ObjQuad(new Vector3f(0.0871f, 0.2625f, -0.0415f),new Vector3f(0.1645f, 0.3157f, -0.0757f),new Vector3f(-0.5681f, 1.952f, 0.8108f),new Vector3f(-0.6455f, 1.8988f, 0.845f),new Vector2f(0.5476f, 0.1505f),new Vector2f(0.5926f, 0.1751f),new Vector2f(0.1662f, 0.9327f),new Vector2f(0.1211f, 0.9081f),new Vector3f(2.0628f, -0.872f, 3.3144f));
		this.quads[22] = new ObjQuad(new Vector3f(0.1645f, 0.3157f, -0.0757f),new Vector3f(0.1129f, 0.3375f, -0.1585f),new Vector3f(-0.6196f, 1.9738f, 0.7279f),new Vector3f(-0.5681f, 1.952f, 0.8108f),new Vector2f(0.5405f, 0.1751f),new Vector2f(0.5887f, 0.1851f),new Vector2f(0.0743f, 0.9427f),new Vector2f(0.0261f, 0.9327f),new Vector3f(3.098f, 2.1284f, -1.3684f));
		this.quads[23] = new ObjQuad(new Vector3f(0.1129f, 0.3375f, -0.1585f),new Vector3f(0.0355f, 0.2843f, -0.1243f),new Vector3f(-0.6971f, 1.9206f, 0.7621f),new Vector3f(-0.6196f, 1.9738f, 0.7279f),new Vector2f(0.4311f, 0.1851f),new Vector2f(0.4762f, 0.1605f),new Vector2f(0.9027f, 0.9181f),new Vector2f(0.8576f, 0.9427f),new Vector3f(-2.0628f, 0.872f, -3.3144f));
		this.quads[24] = new ObjQuad(new Vector3f(-0.0628f, 0.2828f, -0.0275f),new Vector3f(0.0169f, 0.3339f, -0.0597f),new Vector3f(0.0628f, 0.3172f, 0.0275f),new Vector3f(-0.0169f, 0.2661f, 0.0597f),new Vector2f(0.5335f, 0.4115f),new Vector2f(0.4871f, 0.4264f),new Vector2f(0.4603f, 0.3861f),new Vector2f(0.5067f, 0.3711f),new Vector3f(1.5648f, -3.3748f, -1.47f));
		this.quads[25] = new ObjQuad(new Vector3f(-0.8453f, 1.9703f, 0.7075f),new Vector3f(-0.7994f, 1.9536f, 0.7948f),new Vector3f(-0.7196f, 2.0046f, 0.7625f),new Vector3f(-0.7656f, 2.0213f, 0.6753f),new Vector2f(0.0048f, 0.0728f),new Vector2f(0.0316f, 0.0324f),new Vector2f(0.078f, 0.0474f),new Vector2f(0.0512f, 0.0877f),new Vector3f(-1.5648f, 3.3748f, 1.47f));
		this.quads[26] = new ObjQuad(new Vector3f(-0.0628f, 0.2828f, -0.0275f),new Vector3f(-0.0169f, 0.2661f, 0.0597f),new Vector3f(-0.7994f, 1.9536f, 0.7948f),new Vector3f(-0.8453f, 1.9703f, 0.7075f),new Vector2f(0.4814f, 0.1599f),new Vector2f(0.5322f, 0.1523f),new Vector2f(0.9584f, 0.9334f),new Vector2f(0.9076f, 0.941f),new Vector3f(-3.1896f, -2.0408f, 1.2892f));
		this.quads[27] = new ObjQuad(new Vector3f(-0.0169f, 0.2661f, 0.0597f),new Vector3f(0.0628f, 0.3172f, 0.0275f),new Vector3f(-0.7196f, 2.0046f, 0.7625f),new Vector3f(-0.7994f, 1.9536f, 0.7948f),new Vector2f(0.4871f, 0.1523f),new Vector2f(0.5335f, 0.1759f),new Vector2f(0.078f, 0.9569f),new Vector2f(0.0316f, 0.9334f),new Vector3f(1.838f, -0.6676f, 3.4896f));
		this.quads[28] = new ObjQuad(new Vector3f(0.0628f, 0.3172f, 0.0275f),new Vector3f(0.0169f, 0.3339f, -0.0597f),new Vector3f(-0.7656f, 2.0213f, 0.6753f),new Vector3f(-0.7196f, 2.0046f, 0.7625f),new Vector2f(0.4804f, 0.1759f),new Vector2f(0.5312f, 0.1835f),new Vector2f(0.105f, 0.9646f),new Vector2f(0.0542f, 0.9569f),new Vector3f(3.1896f, 2.0408f, -1.2892f));
		this.quads[29] = new ObjQuad(new Vector3f(0.0169f, 0.3339f, -0.0597f),new Vector3f(-0.0628f, 0.2828f, -0.0275f),new Vector3f(-0.8453f, 1.9703f, 0.7075f),new Vector3f(-0.7656f, 2.0213f, 0.6753f),new Vector2f(0.4871f, 0.1835f),new Vector2f(0.5335f, 0.1599f),new Vector2f(0.9889f, 0.941f),new Vector2f(0.9425f, 0.9646f),new Vector3f(-1.838f, 0.6676f, -3.4896f));
		this.quads[30] = new ObjQuad(new Vector3f(-0.8f, -0.0f, 0.8f),new Vector3f(-0.8f, -0.0f, 0.6f),new Vector3f(0.8f, -0.0f, 0.6f),new Vector3f(0.8f, -0.0f, 0.8f),new Vector2f(1.0037f, 0.1998f),new Vector2f(1.0037f, 0.3248f),new Vector2f(0.0037f, 0.3248f),new Vector2f(0.0037f, 0.1998f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[31] = new ObjQuad(new Vector3f(-0.8f, 0.2f, 0.8f),new Vector3f(0.8f, 0.2f, 0.8f),new Vector3f(0.8f, 0.2f, 0.6f),new Vector3f(-0.8f, 0.2f, 0.6f),new Vector2f(-9.0E-4f, 0.6661f),new Vector2f(0.9991f, 0.6661f),new Vector2f(0.9991f, 0.7911f),new Vector2f(-9.0E-4f, 0.7911f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[32] = new ObjQuad(new Vector3f(-0.8f, -0.0f, 0.8f),new Vector3f(0.8f, -0.0f, 0.8f),new Vector3f(0.8f, 0.2f, 0.8f),new Vector3f(-0.8f, 0.2f, 0.8f),new Vector2f(0.0016f, 0.5347f),new Vector2f(1.0016f, 0.5347f),new Vector2f(1.0016f, 0.6597f),new Vector2f(0.0016f, 0.6597f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[33] = new ObjQuad(new Vector3f(0.8f, -0.0f, 0.8f),new Vector3f(0.8f, -0.0f, 0.6f),new Vector3f(0.8f, 0.2f, 0.6f),new Vector3f(0.8f, 0.2f, 0.8f),new Vector2f(0.2595f, 0.0045f),new Vector2f(0.3845f, 0.0043f),new Vector2f(0.3847f, 0.1293f),new Vector2f(0.2597f, 0.1295f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[34] = new ObjQuad(new Vector3f(0.8f, -0.0f, 0.6f),new Vector3f(-0.8f, -0.0f, 0.6f),new Vector3f(-0.8f, 0.2f, 0.6f),new Vector3f(0.8f, 0.2f, 0.6f),new Vector2f(-0.0025f, 0.8013f),new Vector2f(0.9975f, 0.8013f),new Vector2f(0.9975f, 0.9263f),new Vector2f(-0.0025f, 0.9263f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[35] = new ObjQuad(new Vector3f(-0.8f, -0.0f, 0.6f),new Vector3f(-0.8f, -0.0f, 0.8f),new Vector3f(-0.8f, 0.2f, 0.8f),new Vector3f(-0.8f, 0.2f, 0.6f),new Vector2f(0.1317f, 0.0047f),new Vector2f(0.2567f, 0.0049f),new Vector2f(0.2565f, 0.1299f),new Vector2f(0.1315f, 0.1297f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[36] = new ObjQuad(new Vector3f(-0.8f, -0.0f, -0.6f),new Vector3f(-0.8f, -0.0f, -0.8f),new Vector3f(0.8f, -0.0f, -0.8f),new Vector3f(0.8f, -0.0f, -0.6f),new Vector2f(1.0012f, 0.1345f),new Vector2f(1.0012f, 0.2595f),new Vector2f(0.0012f, 0.2595f),new Vector2f(0.0012f, 0.1345f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[37] = new ObjQuad(new Vector3f(-0.8f, 0.2f, -0.6f),new Vector3f(0.8f, 0.2f, -0.6f),new Vector3f(0.8f, 0.2f, -0.8f),new Vector3f(-0.8f, 0.2f, -0.8f),new Vector2f(0.0016f, 0.393f),new Vector2f(1.0016f, 0.393f),new Vector2f(1.0016f, 0.518f),new Vector2f(0.0016f, 0.518f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[38] = new ObjQuad(new Vector3f(-0.8f, -0.0f, -0.6f),new Vector3f(0.8f, -0.0f, -0.6f),new Vector3f(0.8f, 0.2f, -0.6f),new Vector3f(-0.8f, 0.2f, -0.6f),new Vector2f(-9.0E-4f, 0.4636f),new Vector2f(0.9991f, 0.4636f),new Vector2f(0.9991f, 0.5886f),new Vector2f(-9.0E-4f, 0.5886f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[39] = new ObjQuad(new Vector3f(0.8f, -0.0f, -0.6f),new Vector3f(0.8f, -0.0f, -0.8f),new Vector3f(0.8f, 0.2f, -0.8f),new Vector3f(0.8f, 0.2f, -0.6f),new Vector2f(0.3912f, 0.0028f),new Vector2f(0.5162f, 0.0026f),new Vector2f(0.5164f, 0.1276f),new Vector2f(0.3914f, 0.1278f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[40] = new ObjQuad(new Vector3f(0.8f, -0.0f, -0.8f),new Vector3f(-0.8f, -0.0f, -0.8f),new Vector3f(-0.8f, 0.2f, -0.8f),new Vector3f(0.8f, 0.2f, -0.8f),new Vector2f(0.0016f, 0.2644f),new Vector2f(1.0016f, 0.2644f),new Vector2f(1.0016f, 0.3894f),new Vector2f(0.0016f, 0.3894f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[41] = new ObjQuad(new Vector3f(-0.8f, -0.0f, -0.8f),new Vector3f(-0.8f, -0.0f, -0.6f),new Vector3f(-0.8f, 0.2f, -0.6f),new Vector3f(-0.8f, 0.2f, -0.8f),new Vector2f(0.0029f, 0.0043f),new Vector2f(0.1279f, 0.0045f),new Vector2f(0.1277f, 0.1295f),new Vector2f(0.0027f, 0.1293f),new Vector3f(-4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Works other = new Works();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

package mod.industrialProcessing.plants.construction.solderingStation.model;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Tube extends ObjMesh{
	public Tube(){
		this.quads = new ObjQuad[41];
		this.quads[0] = new ObjQuad(new Vector3f(0.2022f, 1.2f, 0.6285f),new Vector3f(0.2022f, 1.2f, 0.6015f),new Vector3f(0.1722f, 1.2f, 0.5715f),new Vector3f(0.1002f, 1.2f, 0.6285f),new Vector2f(0.9956f, 0.0658f),new Vector2f(0.9956f, 0.0856f),new Vector2f(0.9737f, 0.1075f),new Vector2f(0.921f, 0.0658f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.1722f, 1.2f, 0.5715f),new Vector3f(0.1302f, 1.2f, 0.5715f),new Vector3f(0.1002f, 1.2f, 0.6015f),new Vector3f(0.1002f, 1.2f, 0.6285f),new Vector2f(0.9737f, 0.1075f),new Vector2f(0.9429f, 0.1075f),new Vector2f(0.921f, 0.0856f),new Vector2f(0.921f, 0.0658f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.2337f, 0.5f, 0.3237f),new Vector3f(0.2337f, 0.5f, 0.2037f),new Vector3f(0.2337f, 0.6f, 0.2037f),new Vector3f(0.2337f, 0.6f, 0.3237f),new Vector2f(0.8357f, 0.85f),new Vector2f(0.9203f, 0.85f),new Vector2f(0.9203f, 0.9205f),new Vector2f(0.8357f, 0.9205f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.2337f, 0.5f, 0.2037f),new Vector3f(0.0687f, 0.5f, 0.2037f),new Vector3f(0.0687f, 0.6f, 0.2037f),new Vector3f(0.2337f, 0.6f, 0.2037f),new Vector2f(0.8357f, 0.6906f),new Vector2f(0.952f, 0.6906f),new Vector2f(0.952f, 0.7611f),new Vector2f(0.8357f, 0.7611f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.0687f, 0.5f, 0.2037f),new Vector3f(0.0687f, 0.5f, 0.3237f),new Vector3f(0.0687f, 0.6f, 0.3237f),new Vector3f(0.0687f, 0.6f, 0.2037f),new Vector2f(0.7318f, 0.9051f),new Vector2f(0.8164f, 0.9051f),new Vector2f(0.8164f, 0.9756f),new Vector2f(0.7318f, 0.9756f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(0.0687f, 0.5f, 0.3237f),new Vector3f(0.2337f, 0.5f, 0.3237f),new Vector3f(0.2337f, 0.6f, 0.3237f),new Vector3f(0.0687f, 0.6f, 0.3237f),new Vector2f(0.8357f, 0.7703f),new Vector2f(0.952f, 0.7703f),new Vector2f(0.952f, 0.8408f),new Vector2f(0.8357f, 0.8408f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[6] = new ObjQuad(new Vector3f(0.2337f, 0.6f, 0.2037f),new Vector3f(0.2234f, 0.6f, 0.2139f),new Vector3f(0.2022f, 0.6f, 0.2652f),new Vector3f(0.2337f, 0.6f, 0.3237f),new Vector2f(0.952f, 0.6814f),new Vector2f(0.9448f, 0.6741f),new Vector2f(0.9298f, 0.638f),new Vector2f(0.952f, 0.5968f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(0.2337f, 0.6f, 0.3237f),new Vector3f(0.2022f, 0.6f, 0.2652f),new Vector3f(0.2022f, 0.6f, 0.2922f),new Vector2f(0.952f, 0.5968f),new Vector2f(0.9298f, 0.638f),new Vector2f(0.9298f, 0.619f),new Vector3f(0.0f, 3.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(0.0687f, 0.6f, 0.2037f),new Vector3f(0.079f, 0.6f, 0.2139f),new Vector3f(0.1302f, 0.6f, 0.2352f),new Vector3f(0.2337f, 0.6f, 0.2037f),new Vector2f(0.8357f, 0.6814f),new Vector2f(0.8429f, 0.6741f),new Vector2f(0.879f, 0.6592f),new Vector2f(0.952f, 0.6814f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[9] = new ObjQuad(new Vector3f(0.1302f, 0.6f, 0.2352f),new Vector3f(0.1722f, 0.6f, 0.2352f),new Vector3f(0.2234f, 0.6f, 0.2139f),new Vector3f(0.2337f, 0.6f, 0.2037f),new Vector2f(0.879f, 0.6592f),new Vector2f(0.9086f, 0.6592f),new Vector2f(0.9448f, 0.6741f),new Vector2f(0.952f, 0.6814f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[10] = new ObjQuad(new Vector3f(0.0687f, 0.6f, 0.2037f),new Vector3f(0.0687f, 0.6f, 0.3237f),new Vector3f(0.1002f, 0.6f, 0.2922f),new Vector3f(0.079f, 0.6f, 0.2139f),new Vector2f(0.8357f, 0.6814f),new Vector2f(0.8357f, 0.5968f),new Vector2f(0.8579f, 0.619f),new Vector2f(0.8429f, 0.6741f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[11] = new ObjQuad(new Vector3f(0.1002f, 0.6f, 0.2922f),new Vector3f(0.1002f, 0.6f, 0.2652f),new Vector3f(0.079f, 0.6f, 0.2139f),new Vector2f(0.8579f, 0.619f),new Vector2f(0.8579f, 0.638f),new Vector2f(0.8429f, 0.6741f),new Vector3f(0.0f, 3.0f, 0.0f));
		this.quads[12] = new ObjQuad(new Vector3f(0.0687f, 0.6f, 0.3237f),new Vector3f(0.2337f, 0.6f, 0.3237f),new Vector3f(0.2022f, 0.6f, 0.2922f),new Vector3f(0.1002f, 0.6f, 0.2922f),new Vector2f(0.8357f, 0.5968f),new Vector2f(0.952f, 0.5968f),new Vector2f(0.9298f, 0.619f),new Vector2f(0.8579f, 0.619f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[13] = new ObjQuad(new Vector3f(0.2022f, 0.6f, 0.2922f),new Vector3f(0.2022f, 0.6f, 0.2652f),new Vector3f(0.2022f, 1.2f, 0.6015f),new Vector3f(0.2022f, 1.2f, 0.6285f),new Vector2f(0.2391f, 0.5329f),new Vector2f(0.2582f, 0.5329f),new Vector2f(0.021f, 0.956f),new Vector2f(0.002f, 0.956f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[14] = new ObjQuad(new Vector3f(0.1722f, 0.6f, 0.2352f),new Vector3f(0.1302f, 0.6f, 0.2352f),new Vector3f(0.1302f, 1.2f, 0.5715f),new Vector3f(0.1722f, 1.2f, 0.5715f),new Vector2f(0.2674f, 0.5329f),new Vector2f(0.2991f, 0.5329f),new Vector2f(0.2991f, 0.9859f),new Vector2f(0.2674f, 0.9859f),new Vector3f(0.0f, 1.956f, -3.4892f));
		this.quads[15] = new ObjQuad(new Vector3f(0.1002f, 0.6f, 0.2652f),new Vector3f(0.1002f, 0.6f, 0.2922f),new Vector3f(0.1002f, 1.2f, 0.6285f),new Vector3f(0.1002f, 1.2f, 0.6015f),new Vector2f(0.6556f, 0.002f),new Vector2f(0.6747f, 0.002f),new Vector2f(0.9118f, 0.425f),new Vector2f(0.8927f, 0.425f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[16] = new ObjQuad(new Vector3f(0.1302f, 0.5511f, 0.3794f),new Vector3f(0.1722f, 0.5511f, 0.3794f),new Vector3f(0.1722f, 1.1511f, 0.7157f),new Vector3f(0.1302f, 1.1511f, 0.7157f),new Vector2f(0.6556f, 0.4342f),new Vector2f(0.6873f, 0.4342f),new Vector2f(0.6873f, 0.8871f),new Vector2f(0.6556f, 0.8871f),new Vector3f(0.0f, -1.956f, 3.4892f));
		this.quads[17] = new ObjQuad(new Vector3f(0.2022f, 0.6f, 0.2922f),new Vector3f(0.2022f, 0.5658f, 0.3532f),new Vector3f(0.1722f, 0.5511f, 0.3794f),new Vector3f(0.1002f, 0.6f, 0.2922f),new Vector2f(0.921f, 0.1826f),new Vector2f(0.921f, 0.1365f),new Vector2f(0.9436f, 0.1168f),new Vector2f(0.998f, 0.1826f),new Vector3f(0.0f, -3.4892f, -1.956f));
		this.quads[18] = new ObjQuad(new Vector3f(0.1722f, 0.5511f, 0.3794f),new Vector3f(0.1302f, 0.5511f, 0.3794f),new Vector3f(0.1002f, 0.5658f, 0.3532f),new Vector3f(0.1002f, 0.6f, 0.2922f),new Vector2f(0.9436f, 0.1168f),new Vector2f(0.9754f, 0.1168f),new Vector2f(0.998f, 0.1365f),new Vector2f(0.998f, 0.1826f),new Vector3f(0.0f, -3.4892f, -1.956f));
		this.quads[19] = new ObjQuad(new Vector3f(0.2022f, 0.6f, 0.2922f),new Vector3f(0.2022f, 1.2f, 0.6285f),new Vector3f(0.2022f, 1.1658f, 0.6896f),new Vector3f(0.2022f, 0.5658f, 0.3532f),new Vector2f(0.6464f, 0.0386f),new Vector2f(0.395f, 0.4871f),new Vector2f(0.3493f, 0.4615f),new Vector2f(0.6008f, 0.013f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[20] = new ObjQuad(new Vector3f(0.1219f, 1.0149f, 0.5496f),new Vector3f(0.1219f, 0.9957f, 0.5839f),new Vector3f(0.1392f, 0.9873f, 0.599f),new Vector3f(0.1805f, 1.0149f, 0.5496f),new Vector2f(0.8357f, 0.967f),new Vector2f(0.8357f, 0.9411f),new Vector2f(0.8487f, 0.9297f),new Vector2f(0.8799f, 0.967f),new Vector3f(0.0f, 3.4892f, 1.956f));
		this.quads[21] = new ObjQuad(new Vector3f(0.1392f, 0.9873f, 0.599f),new Vector3f(0.1632f, 0.9873f, 0.599f),new Vector3f(0.1805f, 0.9957f, 0.5839f),new Vector3f(0.1805f, 1.0149f, 0.5496f),new Vector2f(0.8487f, 0.9297f),new Vector2f(0.8669f, 0.9297f),new Vector2f(0.8799f, 0.9411f),new Vector2f(0.8799f, 0.967f),new Vector3f(0.0f, 3.4892f, 1.956f));
		this.quads[22] = new ObjQuad(new Vector3f(0.1002f, 1.2f, 0.6285f),new Vector3f(0.1002f, 0.6f, 0.2922f),new Vector3f(0.1002f, 0.5658f, 0.3532f),new Vector3f(0.1002f, 1.1658f, 0.6896f),new Vector2f(0.5812f, 0.9814f),new Vector2f(0.3298f, 0.5328f),new Vector2f(0.3754f, 0.5073f),new Vector2f(0.6268f, 0.9558f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[23] = new ObjQuad(new Vector3f(0.2234f, 0.6f, 0.2139f),new Vector3f(0.1722f, 0.6f, 0.2352f),new Vector3f(0.2022f, 0.6f, 0.2652f),new Vector2f(0.9448f, 0.6741f),new Vector2f(0.9086f, 0.6592f),new Vector2f(0.9298f, 0.638f),new Vector3f(0.0f, 3.0f, 0.0f));
		this.quads[24] = new ObjQuad(new Vector3f(0.079f, 0.6f, 0.2139f),new Vector3f(0.1002f, 0.6f, 0.2652f),new Vector3f(0.1302f, 0.6f, 0.2352f),new Vector2f(0.8429f, 0.6741f),new Vector2f(0.8579f, 0.638f),new Vector2f(0.879f, 0.6592f),new Vector3f(0.0f, 3.0f, 0.0f));
		this.quads[25] = new ObjQuad(new Vector3f(0.2022f, 0.6f, 0.2652f),new Vector3f(0.1722f, 0.6f, 0.2352f),new Vector3f(0.1722f, 1.2f, 0.5715f),new Vector3f(0.2022f, 1.2f, 0.6015f),new Vector2f(0.2945f, 0.002f),new Vector2f(0.3206f, 0.002f),new Vector2f(0.0281f, 0.5237f),new Vector2f(0.002f, 0.5237f),new Vector3f(2.6292f, 1.474f, -2.6292f));
		this.quads[26] = new ObjQuad(new Vector3f(0.1302f, 0.6f, 0.2352f),new Vector3f(0.1002f, 0.6f, 0.2652f),new Vector3f(0.1002f, 1.2f, 0.6015f),new Vector3f(0.1302f, 1.2f, 0.5715f),new Vector2f(0.6965f, 0.4342f),new Vector2f(0.7226f, 0.4342f),new Vector2f(0.7226f, 0.956f),new Vector2f(0.6965f, 0.956f),new Vector3f(-2.6292f, 1.474f, -2.6292f));
		this.quads[27] = new ObjQuad(new Vector3f(0.1722f, 0.5511f, 0.3794f),new Vector3f(0.2022f, 0.5658f, 0.3532f),new Vector3f(0.2022f, 1.1658f, 0.6896f),new Vector3f(0.1722f, 1.1511f, 0.7157f),new Vector2f(0.5812f, 0.002f),new Vector2f(0.6008f, 0.013f),new Vector2f(0.3493f, 0.4615f),new Vector2f(0.3298f, 0.4505f),new Vector3f(2.8284f, -1.3832f, 2.4672f));
		this.quads[28] = new ObjQuad(new Vector3f(0.1302f, 1.1511f, 0.7157f),new Vector3f(0.1002f, 1.1658f, 0.6896f),new Vector3f(0.1002f, 0.5658f, 0.3532f),new Vector3f(0.1302f, 0.5511f, 0.3794f),new Vector2f(0.6464f, 0.9448f),new Vector2f(0.6268f, 0.9558f),new Vector2f(0.3754f, 0.5073f),new Vector2f(0.395f, 0.4963f),new Vector3f(-2.8284f, -1.3832f, 2.4672f));
		this.quads[29] = new ObjQuad(new Vector3f(0.2022f, 1.2f, 0.6285f),new Vector3f(0.1002f, 1.2f, 0.6285f),new Vector3f(0.1219f, 1.1894f, 0.6474f),new Vector3f(0.1805f, 1.1894f, 0.6474f),new Vector2f(0.9956f, 0.0658f),new Vector2f(0.921f, 0.0658f),new Vector2f(0.9369f, 0.052f),new Vector2f(0.9798f, 0.052f),new Vector3f(0.0f, 3.4892f, 1.956f));
		this.quads[30] = new ObjQuad(new Vector3f(0.1002f, 1.2f, 0.6285f),new Vector3f(0.1002f, 1.1658f, 0.6896f),new Vector3f(0.1219f, 1.1702f, 0.6817f),new Vector3f(0.1219f, 1.1894f, 0.6474f),new Vector2f(0.921f, 0.0658f),new Vector2f(0.921f, 0.0211f),new Vector2f(0.9369f, 0.0269f),new Vector2f(0.9369f, 0.052f),new Vector3f(0.0f, 3.4892f, 1.956f));
		this.quads[31] = new ObjQuad(new Vector3f(0.1002f, 1.1658f, 0.6896f),new Vector3f(0.1302f, 1.1511f, 0.7157f),new Vector3f(0.1392f, 1.1617f, 0.6968f),new Vector3f(0.1219f, 1.1702f, 0.6817f),new Vector2f(0.921f, 0.0211f),new Vector2f(0.9429f, 0.002f),new Vector2f(0.9495f, 0.0159f),new Vector2f(0.9369f, 0.0269f),new Vector3f(0.0f, 3.4892f, 1.956f));
		this.quads[32] = new ObjQuad(new Vector3f(0.1302f, 1.1511f, 0.7157f),new Vector3f(0.1722f, 1.1511f, 0.7157f),new Vector3f(0.1632f, 1.1617f, 0.6968f),new Vector3f(0.1392f, 1.1617f, 0.6968f),new Vector2f(0.9429f, 0.002f),new Vector2f(0.9737f, 0.002f),new Vector2f(0.9671f, 0.0159f),new Vector2f(0.9495f, 0.0159f),new Vector3f(0.0f, 3.4892f, 1.956f));
		this.quads[33] = new ObjQuad(new Vector3f(0.1722f, 1.1511f, 0.7157f),new Vector3f(0.2022f, 1.1658f, 0.6896f),new Vector3f(0.1805f, 1.1702f, 0.6817f),new Vector3f(0.1632f, 1.1617f, 0.6968f),new Vector2f(0.9737f, 0.002f),new Vector2f(0.9956f, 0.0211f),new Vector2f(0.9798f, 0.0269f),new Vector2f(0.9671f, 0.0159f),new Vector3f(0.0f, 3.4892f, 1.956f));
		this.quads[34] = new ObjQuad(new Vector3f(0.2022f, 1.1658f, 0.6896f),new Vector3f(0.2022f, 1.2f, 0.6285f),new Vector3f(0.1805f, 1.1894f, 0.6474f),new Vector3f(0.1805f, 1.1702f, 0.6817f),new Vector2f(0.9956f, 0.0211f),new Vector2f(0.9956f, 0.0658f),new Vector2f(0.9798f, 0.052f),new Vector2f(0.9798f, 0.0269f),new Vector3f(0.0f, 3.4892f, 1.956f));
		this.quads[35] = new ObjQuad(new Vector3f(0.1805f, 1.1894f, 0.6474f),new Vector3f(0.1219f, 1.1894f, 0.6474f),new Vector3f(0.1219f, 1.0149f, 0.5496f),new Vector3f(0.1805f, 1.0149f, 0.5496f),new Vector2f(0.9822f, 0.5659f),new Vector2f(0.938f, 0.5659f),new Vector2f(0.938f, 0.4342f),new Vector2f(0.9822f, 0.4342f),new Vector3f(0.0f, -1.956f, 3.4892f));
		this.quads[36] = new ObjQuad(new Vector3f(0.1219f, 1.1894f, 0.6474f),new Vector3f(0.1219f, 1.1702f, 0.6817f),new Vector3f(0.1219f, 0.9957f, 0.5839f),new Vector3f(0.1219f, 1.0149f, 0.5496f),new Vector2f(0.8598f, 0.5708f),new Vector2f(0.8357f, 0.5572f),new Vector2f(0.9046f, 0.4342f),new Vector2f(0.9288f, 0.4478f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[37] = new ObjQuad(new Vector3f(0.1219f, 1.1702f, 0.6817f),new Vector3f(0.1392f, 1.1617f, 0.6968f),new Vector3f(0.1392f, 0.9873f, 0.599f),new Vector3f(0.1219f, 0.9957f, 0.5839f),new Vector2f(0.7445f, 0.5876f),new Vector2f(0.7318f, 0.5805f),new Vector2f(0.8138f, 0.4342f),new Vector2f(0.8265f, 0.4413f),new Vector3f(2.8284f, 1.3832f, -2.4672f));
		this.quads[38] = new ObjQuad(new Vector3f(0.1392f, 1.1617f, 0.6968f),new Vector3f(0.1632f, 1.1617f, 0.6968f),new Vector3f(0.1632f, 0.9873f, 0.599f),new Vector3f(0.1392f, 0.9873f, 0.599f),new Vector2f(0.9391f, 0.3235f),new Vector2f(0.921f, 0.3235f),new Vector2f(0.921f, 0.1918f),new Vector2f(0.9391f, 0.1918f),new Vector3f(0.0f, 1.956f, -3.4892f));
		this.quads[39] = new ObjQuad(new Vector3f(0.1632f, 1.1617f, 0.6968f),new Vector3f(0.1805f, 1.1702f, 0.6817f),new Vector3f(0.1805f, 0.9957f, 0.5839f),new Vector3f(0.1632f, 0.9873f, 0.599f),new Vector2f(0.8265f, 0.7431f),new Vector2f(0.8138f, 0.7501f),new Vector2f(0.7318f, 0.6039f),new Vector2f(0.7445f, 0.5968f),new Vector3f(-2.8284f, 1.3832f, -2.4672f));
		this.quads[40] = new ObjQuad(new Vector3f(0.1805f, 1.1702f, 0.6817f),new Vector3f(0.1805f, 1.1894f, 0.6474f),new Vector3f(0.1805f, 1.0149f, 0.5496f),new Vector3f(0.1805f, 0.9957f, 0.5839f),new Vector2f(0.8249f, 0.8823f),new Vector2f(0.8008f, 0.8959f),new Vector2f(0.7318f, 0.7729f),new Vector2f(0.756f, 0.7593f),new Vector3f(-4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Tube other = new Tube();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

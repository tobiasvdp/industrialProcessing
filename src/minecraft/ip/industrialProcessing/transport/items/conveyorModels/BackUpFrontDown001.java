package ip.industrialProcessing.transport.items.conveyorModels;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class BackUpFrontDown001 extends ObjMesh{
	public BackUpFrontDown001(){
		this.quads = new ObjQuad[70];
		this.quads[0] = new ObjQuad(new Vector3f(-0.3f, 1.458578f, -0.693935f),new Vector3f(-0.3f, 1.6f, -0.552513f),new Vector3f(0.3f, 1.6f, -0.552514f),new Vector3f(0.3f, 1.458579f, -0.693935f),new Vector2f(0.7505f, 0.5625f),new Vector2f(0.6255f, 0.5625f),new Vector2f(0.6255f, 0.9375f),new Vector2f(0.7505f, 0.9375f),new Vector3f(-3.0E-6f, 2.828425f, -2.828429f));
		this.quads[1] = new ObjQuad(new Vector3f(0.299999f, 0.659607f, 0.105038f),new Vector3f(0.3f, 1.458579f, -0.693935f),new Vector3f(0.3f, 1.6f, -0.552514f),new Vector3f(0.299999f, 0.801029f, 0.246459f),new Vector2f(0.625056f, 0.49995f),new Vector2f(0.625056f, 1.000043f),new Vector2f(0.75038f, 1.000043f),new Vector2f(0.75038f, 0.499951f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.3f, -0.141421f, 0.906065f),new Vector3f(0.3f, -0.0f, 1.047486f),new Vector3f(-0.3f, -0.0f, 1.047487f),new Vector3f(-0.3f, -0.141421f, 0.906065f),new Vector2f(0.7505f, 0.5625f),new Vector2f(0.6255f, 0.5625f),new Vector2f(0.6255f, 0.9375f),new Vector2f(0.7505f, 0.9375f),new Vector3f(2.0E-6f, -2.828427f, 2.8284273f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.300001f, 0.659607f, 0.105038f),new Vector3f(-0.3f, -0.141421f, 0.906065f),new Vector3f(-0.3f, -0.0f, 1.047487f),new Vector3f(-0.300001f, 0.801028f, 0.246459f),new Vector2f(0.625056f, 0.49995f),new Vector2f(0.625056f, 1.000043f),new Vector2f(0.75038f, 1.000043f),new Vector2f(0.75038f, 0.499951f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.400001f, 0.588896f, 0.034328f),new Vector3f(-0.4f, 1.387867f, -0.764645f),new Vector3f(0.4f, 1.387868f, -0.764645f),new Vector3f(0.399999f, 0.588896f, 0.034328f),new Vector2f(0.5f, 0.5f),new Vector2f(0.5f, 0.0f),new Vector2f(0.0f, 0.0f),new Vector2f(0.0f, 0.5f),new Vector3f(0.0f, -2.828428f, -2.828426f));
		this.quads[5] = new ObjQuad(new Vector3f(0.399999f, 0.588896f, 0.034328f),new Vector3f(0.4f, 1.387868f, -0.764645f),new Vector3f(0.4f, 1.458579f, -0.693935f),new Vector3f(0.399999f, 0.659607f, 0.105038f),new Vector2f(0.812999f, 0.499981f),new Vector2f(0.812999f, 0.999997f),new Vector2f(0.875f, 0.999997f),new Vector2f(0.875f, 0.499981f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.400001f, 0.588896f, 0.034328f),new Vector3f(-0.4f, -0.212132f, 0.835355f),new Vector3f(-0.4f, -0.141421f, 0.906065f),new Vector3f(-0.400001f, 0.659607f, 0.105038f),new Vector2f(0.812999f, 0.499981f),new Vector2f(0.812999f, 0.999997f),new Vector2f(0.875f, 0.999997f),new Vector2f(0.875f, 0.499981f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.4f, 1.387867f, -0.764645f),new Vector3f(-0.4f, 1.458578f, -0.693934f),new Vector3f(-0.3f, 1.458578f, -0.693935f),new Vector3f(0.4f, 1.387868f, -0.764645f),new Vector2f(0.813f, 0.5f),new Vector2f(0.7505f, 0.5f),new Vector2f(0.7505f, 0.5625f),new Vector2f(0.813f, 1.0f),new Vector3f(-1.0E-5f, 2.8284168f, -2.8284369f));
		this.quads[8] = new ObjQuad(new Vector3f(0.4f, 1.387868f, -0.764645f),new Vector3f(-0.3f, 1.458578f, -0.693935f),new Vector3f(0.3f, 1.458579f, -0.693935f),new Vector3f(0.4f, 1.458579f, -0.693935f),new Vector2f(0.813f, 1.0f),new Vector2f(0.7505f, 0.5625f),new Vector2f(0.7505f, 0.9375f),new Vector2f(0.7505f, 1.0f),new Vector3f(-2.0E-6f, 2.828423f, -2.828432f));
		this.quads[9] = new ObjQuad(new Vector3f(-0.3f, 1.458578f, -0.693935f),new Vector3f(-0.4f, 1.458578f, -0.693934f),new Vector3f(-0.400001f, 0.659607f, 0.105038f),new Vector3f(-0.300001f, 0.659607f, 0.105038f),new Vector2f(0.8125f, 0.5f),new Vector2f(0.75f, 0.5f),new Vector2f(0.75f, 1.0f),new Vector2f(0.8125f, 1.0f),new Vector3f(5.0E-6f, 2.828428f, 2.828427f));
		this.quads[10] = new ObjQuad(new Vector3f(0.4f, -0.212132f, 0.835355f),new Vector3f(0.4f, -0.141421f, 0.906065f),new Vector3f(0.3f, -0.141421f, 0.906065f),new Vector3f(-0.4f, -0.212132f, 0.835355f),new Vector2f(0.813f, 0.5f),new Vector2f(0.7505f, 0.5f),new Vector2f(0.7505f, 0.5625f),new Vector2f(0.813f, 1.0f),new Vector3f(0.0f, -2.82842f, 2.828436f));
		this.quads[11] = new ObjQuad(new Vector3f(-0.4f, -0.212132f, 0.835355f),new Vector3f(0.3f, -0.141421f, 0.906065f),new Vector3f(-0.3f, -0.141421f, 0.906065f),new Vector3f(-0.4f, -0.141421f, 0.906065f),new Vector2f(0.813f, 1.0f),new Vector2f(0.7505f, 0.5625f),new Vector2f(0.7505f, 0.9375f),new Vector2f(0.7505f, 1.0f),new Vector3f(0.0f, -2.82842f, 2.828436f));
		this.quads[12] = new ObjQuad(new Vector3f(0.3f, -0.141421f, 0.906065f),new Vector3f(0.4f, -0.141421f, 0.906065f),new Vector3f(0.399999f, 0.659607f, 0.105038f),new Vector3f(0.299999f, 0.659607f, 0.105038f),new Vector2f(0.75f, 1.0f),new Vector2f(0.8125f, 1.0f),new Vector2f(0.8125f, 0.5f),new Vector2f(0.75f, 0.5f),new Vector3f(0.0f, 2.8284261f, 2.828428f));
		this.quads[13] = new ObjQuad(new Vector3f(0.4f, 1.670711f, -0.481803f),new Vector3f(-0.4f, 1.67071f, -0.481802f),new Vector3f(-0.400001f, 0.871739f, 0.31717f),new Vector3f(0.399999f, 0.871738f, 0.317171f),new Vector2f(-0.0f, 1.0f),new Vector2f(0.5f, 1.0f),new Vector2f(0.5f, 0.5f),new Vector2f(0.0f, 0.5f),new Vector3f(0.0f, 2.828428f, 2.8284261f));
		this.quads[14] = new ObjQuad(new Vector3f(0.399999f, 0.801029f, 0.246459f),new Vector3f(0.4f, 1.600001f, -0.552514f),new Vector3f(0.4f, 1.670711f, -0.481803f),new Vector3f(0.399999f, 0.871738f, 0.317171f),new Vector2f(0.5f, 0.499998f),new Vector2f(0.5f, 0.999991f),new Vector2f(0.562502f, 0.999992f),new Vector2f(0.562502f, 0.499998f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[15] = new ObjQuad(new Vector3f(-0.400001f, 0.801028f, 0.24646f),new Vector3f(-0.4f, -0.0f, 1.047487f),new Vector3f(-0.4f, 0.070711f, 1.118198f),new Vector3f(-0.400001f, 0.871739f, 0.31717f),new Vector2f(0.5f, 0.499998f),new Vector2f(0.5f, 0.999991f),new Vector2f(0.562502f, 0.999992f),new Vector2f(0.562502f, 0.499998f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[16] = new ObjQuad(new Vector3f(0.4f, 1.670711f, -0.481803f),new Vector3f(0.4f, 1.600001f, -0.552514f),new Vector3f(0.3f, 1.6f, -0.552514f),new Vector3f(-0.4f, 1.67071f, -0.481802f),new Vector2f(0.5625f, 1.0f),new Vector2f(0.6255f, 1.0f),new Vector2f(0.6255f, 0.9375f),new Vector2f(0.5625f, 0.5f),new Vector3f(-1.0E-5f, 2.828427f, -2.828428f));
		this.quads[17] = new ObjQuad(new Vector3f(-0.4f, 1.67071f, -0.481802f),new Vector3f(0.3f, 1.6f, -0.552514f),new Vector3f(-0.3f, 1.6f, -0.552513f),new Vector3f(-0.4f, 1.6f, -0.552513f),new Vector2f(0.5625f, 0.5f),new Vector2f(0.6255f, 0.9375f),new Vector2f(0.6255f, 0.5625f),new Vector2f(0.6255f, 0.5f),new Vector3f(-2.0000002E-6f, 2.8284268f, -2.8284283f));
		this.quads[18] = new ObjQuad(new Vector3f(0.3f, 1.6f, -0.552514f),new Vector3f(0.4f, 1.600001f, -0.552514f),new Vector3f(0.399999f, 0.801029f, 0.246459f),new Vector3f(0.299999f, 0.801029f, 0.246459f),new Vector2f(0.625f, 0.5f),new Vector2f(0.5625f, 0.5f),new Vector2f(0.5625f, 1.0f),new Vector2f(0.625f, 1.0f),new Vector3f(1.0E-5f, -2.828428f, -2.8284261f));
		this.quads[19] = new ObjQuad(new Vector3f(-0.4f, 0.070711f, 1.118198f),new Vector3f(-0.4f, -0.0f, 1.047487f),new Vector3f(-0.3f, -0.0f, 1.047487f),new Vector3f(0.4f, 0.070711f, 1.118198f),new Vector2f(0.5625f, 1.0f),new Vector2f(0.6255f, 1.0f),new Vector2f(0.6255f, 0.9375f),new Vector2f(0.5625f, 0.5f),new Vector3f(0.0f, -2.8284278f, 2.828428f));
		this.quads[20] = new ObjQuad(new Vector3f(0.4f, 0.070711f, 1.118198f),new Vector3f(-0.3f, -0.0f, 1.047487f),new Vector3f(0.3f, -0.0f, 1.047486f),new Vector3f(0.4f, -0.0f, 1.047486f),new Vector2f(0.5625f, 0.5f),new Vector2f(0.6255f, 0.9375f),new Vector2f(0.6255f, 0.5625f),new Vector2f(0.6255f, 0.5f),new Vector3f(1.0E-6f, -2.828436f, 2.828419f));
		this.quads[21] = new ObjQuad(new Vector3f(-0.3f, -0.0f, 1.047487f),new Vector3f(-0.4f, -0.0f, 1.047487f),new Vector3f(-0.400001f, 0.801028f, 0.24646f),new Vector3f(-0.300001f, 0.801028f, 0.246459f),new Vector2f(0.5625f, 1.0f),new Vector2f(0.625f, 1.0f),new Vector2f(0.625f, 0.5f),new Vector2f(0.5625f, 0.5f),new Vector3f(-6.0E-6f, -2.8284261f, -2.828428f));
		this.quads[22] = new ObjQuad(new Vector3f(0.3f, -0.141421f, 0.906065f),new Vector3f(0.299999f, 0.659607f, 0.105038f),new Vector3f(0.299999f, 0.801029f, 0.246459f),new Vector3f(0.3f, -0.0f, 1.047486f),new Vector2f(0.625056f, 0.49995f),new Vector2f(0.625056f, 1.000043f),new Vector2f(0.75038f, 1.000043f),new Vector2f(0.75038f, 0.499951f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[23] = new ObjQuad(new Vector3f(-0.3f, 1.458578f, -0.693935f),new Vector3f(-0.300001f, 0.659607f, 0.105038f),new Vector3f(-0.300001f, 0.801028f, 0.246459f),new Vector3f(-0.3f, 1.6f, -0.552513f),new Vector2f(0.625056f, 0.49995f),new Vector2f(0.625056f, 1.000043f),new Vector2f(0.75038f, 1.000043f),new Vector2f(0.75038f, 0.499951f),new Vector3f(-4.0f, 2.0E-6f, 0.0f));
		this.quads[24] = new ObjQuad(new Vector3f(-0.4f, -0.212132f, 0.835355f),new Vector3f(-0.400001f, 0.588896f, 0.034328f),new Vector3f(0.399999f, 0.588896f, 0.034328f),new Vector3f(0.4f, -0.212132f, 0.835355f),new Vector2f(0.5f, 0.5f),new Vector2f(0.5f, 0.0f),new Vector2f(0.0f, 0.0f),new Vector2f(0.0f, 0.5f),new Vector3f(0.0f, -2.828426f, -2.828428f));
		this.quads[25] = new ObjQuad(new Vector3f(0.4f, -0.212132f, 0.835355f),new Vector3f(0.399999f, 0.588896f, 0.034328f),new Vector3f(0.399999f, 0.659607f, 0.105038f),new Vector3f(0.4f, -0.141421f, 0.906065f),new Vector2f(0.812999f, 0.499981f),new Vector2f(0.812999f, 0.999997f),new Vector2f(0.875f, 0.999997f),new Vector2f(0.875f, 0.499981f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[26] = new ObjQuad(new Vector3f(-0.4f, 1.387867f, -0.764645f),new Vector3f(-0.400001f, 0.588896f, 0.034328f),new Vector3f(-0.400001f, 0.659607f, 0.105038f),new Vector3f(-0.4f, 1.458578f, -0.693934f),new Vector2f(0.812999f, 0.499981f),new Vector2f(0.812999f, 0.999997f),new Vector2f(0.875f, 0.999997f),new Vector2f(0.875f, 0.499981f),new Vector3f(-4.0f, 0.0f, -2.0E-6f));
		this.quads[27] = new ObjQuad(new Vector3f(-0.3f, -0.141421f, 0.906065f),new Vector3f(-0.300001f, 0.659607f, 0.105038f),new Vector3f(-0.400001f, 0.659607f, 0.105038f),new Vector3f(-0.4f, -0.141421f, 0.906065f),new Vector2f(0.8125f, 1.0f),new Vector2f(0.8125f, 0.5f),new Vector2f(0.75f, 0.5f),new Vector2f(0.75f, 1.0f),new Vector3f(-5.0E-6f, 2.828426f, 2.828428f));
		this.quads[28] = new ObjQuad(new Vector3f(0.3f, 1.458579f, -0.693935f),new Vector3f(0.299999f, 0.659607f, 0.105038f),new Vector3f(0.399999f, 0.659607f, 0.105038f),new Vector3f(0.4f, 1.458579f, -0.693935f),new Vector2f(0.75f, 0.5f),new Vector2f(0.75f, 1.0f),new Vector2f(0.8125f, 1.0f),new Vector2f(0.8125f, 0.5f),new Vector3f(0.0f, 2.828428f, 2.828426f));
		this.quads[29] = new ObjQuad(new Vector3f(0.4f, 0.070711f, 1.118198f),new Vector3f(0.399999f, 0.871738f, 0.317171f),new Vector3f(-0.400001f, 0.871739f, 0.31717f),new Vector3f(-0.4f, 0.070711f, 1.118198f),new Vector2f(0.0f, 0.5f),new Vector2f(-0.0f, 1.0f),new Vector2f(0.5f, 1.0f),new Vector2f(0.5f, 0.5f),new Vector3f(0.0f, 2.828428f, 2.828428f));
		this.quads[30] = new ObjQuad(new Vector3f(0.4f, -0.0f, 1.047486f),new Vector3f(0.399999f, 0.801029f, 0.246459f),new Vector3f(0.399999f, 0.871738f, 0.317171f),new Vector3f(0.4f, 0.070711f, 1.118198f),new Vector2f(0.5f, 0.499998f),new Vector2f(0.5f, 0.999991f),new Vector2f(0.562502f, 0.999992f),new Vector2f(0.562502f, 0.499998f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[31] = new ObjQuad(new Vector3f(-0.4f, 1.6f, -0.552513f),new Vector3f(-0.400001f, 0.801028f, 0.24646f),new Vector3f(-0.400001f, 0.871739f, 0.31717f),new Vector3f(-0.4f, 1.67071f, -0.481802f),new Vector2f(0.5f, 0.499998f),new Vector2f(0.5f, 0.999991f),new Vector2f(0.562502f, 0.999992f),new Vector2f(0.562502f, 0.499998f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[32] = new ObjQuad(new Vector3f(0.3f, -0.0f, 1.047486f),new Vector3f(0.299999f, 0.801029f, 0.246459f),new Vector3f(0.399999f, 0.801029f, 0.246459f),new Vector3f(0.4f, -0.0f, 1.047486f),new Vector2f(0.625f, 1.0f),new Vector2f(0.625f, 0.5f),new Vector2f(0.5625f, 0.5f),new Vector2f(0.5625f, 1.0f),new Vector3f(0.0f, -2.828426f, -2.8284302f));
		this.quads[33] = new ObjQuad(new Vector3f(-0.3f, 1.6f, -0.552513f),new Vector3f(-0.300001f, 0.801028f, 0.246459f),new Vector3f(-0.400001f, 0.801028f, 0.24646f),new Vector3f(-0.4f, 1.6f, -0.552513f),new Vector2f(0.5625f, 0.5f),new Vector2f(0.5625f, 1.0f),new Vector2f(0.625f, 1.0f),new Vector2f(0.625f, 0.5f),new Vector3f(-8.0E-6f, -2.828428f, -2.828426f));
		this.quads[34] = new ObjQuad(new Vector3f(-0.300001f, 0.235343f, -0.319226f),new Vector3f(-0.3f, 1.034313f, -1.118198f),new Vector3f(-0.2f, 1.034313f, -1.118198f),new Vector3f(-0.200001f, 0.235342f, -0.319225f),new Vector2f(0.6875f, 0.5f),new Vector2f(0.6875f, 0.0f),new Vector2f(0.625f, 0.0f),new Vector2f(0.625f, 0.5f),new Vector3f(8.0E-6f, -2.828428f, -2.828426f));
		this.quads[35] = new ObjQuad(new Vector3f(-0.2f, 1.105024f, -1.047488f),new Vector3f(-0.3f, 1.105024f, -1.047488f),new Vector3f(-0.300001f, 0.306053f, -0.248515f),new Vector3f(-0.200001f, 0.306053f, -0.248515f),new Vector2f(0.5f, 0.0f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.5625f, 0.5f),new Vector2f(0.5f, 0.5f),new Vector3f(-8.0E-6f, 2.828428f, 2.8284261f));
		this.quads[36] = new ObjQuad(new Vector3f(-0.3f, 1.034313f, -1.118198f),new Vector3f(-0.3f, 1.105024f, -1.047488f),new Vector3f(-0.2f, 1.105024f, -1.047488f),new Vector3f(-0.2f, 1.034313f, -1.118198f),new Vector2f(0.75f, 0.0f),new Vector2f(0.6875f, 0.0f),new Vector2f(0.6875f, 0.0625f),new Vector2f(0.75f, 0.0625f),new Vector3f(0.0f, 2.828428f, -2.828428f));
		this.quads[37] = new ObjQuad(new Vector3f(-0.200001f, 0.235342f, -0.319225f),new Vector3f(-0.2f, 1.034313f, -1.118198f),new Vector3f(-0.2f, 1.105024f, -1.047488f),new Vector3f(-0.200001f, 0.306053f, -0.248515f),new Vector2f(0.75f, 0.5f),new Vector2f(0.75f, 0.0f),new Vector2f(0.6875f, 0.0f),new Vector2f(0.6875f, 0.5f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[38] = new ObjQuad(new Vector3f(-0.2f, -0.565686f, 0.481801f),new Vector3f(-0.2f, -0.494975f, 0.552512f),new Vector3f(-0.3f, -0.494975f, 0.552512f),new Vector3f(-0.3f, -0.565686f, 0.481801f),new Vector2f(0.75f, 0.0f),new Vector2f(0.6875f, 0.0f),new Vector2f(0.6875f, 0.0625f),new Vector2f(0.75f, 0.0625f),new Vector3f(0.0f, -2.828428f, 2.828428f));
		this.quads[39] = new ObjQuad(new Vector3f(-0.300001f, 0.235343f, -0.319226f),new Vector3f(-0.3f, -0.565686f, 0.481801f),new Vector3f(-0.3f, -0.494975f, 0.552512f),new Vector3f(-0.300001f, 0.306053f, -0.248515f),new Vector2f(0.625f, 0.5f),new Vector2f(0.625f, 0.0f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.5625f, 0.5f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[40] = new ObjQuad(new Vector3f(-0.3f, -0.565686f, 0.481801f),new Vector3f(-0.300001f, 0.235343f, -0.319226f),new Vector3f(-0.200001f, 0.235342f, -0.319225f),new Vector3f(-0.2f, -0.565686f, 0.481801f),new Vector2f(0.6875f, 0.5f),new Vector2f(0.6875f, 0.0f),new Vector2f(0.625f, 0.0f),new Vector2f(0.625f, 0.5f),new Vector3f(8.0E-6f, -2.828426f, -2.8284302f));
		this.quads[41] = new ObjQuad(new Vector3f(-0.2f, -0.494975f, 0.552512f),new Vector3f(-0.200001f, 0.306053f, -0.248515f),new Vector3f(-0.300001f, 0.306053f, -0.248515f),new Vector3f(-0.3f, -0.494975f, 0.552512f),new Vector2f(0.5f, 0.5f),new Vector2f(0.5f, 0.0f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.5625f, 0.5f),new Vector3f(-8.0E-6f, 2.828426f, 2.828428f));
		this.quads[42] = new ObjQuad(new Vector3f(-0.2f, -0.565686f, 0.481801f),new Vector3f(-0.200001f, 0.235342f, -0.319225f),new Vector3f(-0.200001f, 0.306053f, -0.248515f),new Vector3f(-0.2f, -0.494975f, 0.552512f),new Vector2f(0.75f, 0.5f),new Vector2f(0.75f, 0.0f),new Vector2f(0.6875f, 0.0f),new Vector2f(0.6875f, 0.5f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[43] = new ObjQuad(new Vector3f(-0.3f, 1.034313f, -1.118198f),new Vector3f(-0.300001f, 0.235343f, -0.319226f),new Vector3f(-0.300001f, 0.306053f, -0.248515f),new Vector3f(-0.3f, 1.105024f, -1.047488f),new Vector2f(0.625f, 0.5f),new Vector2f(0.625f, 0.0f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.5625f, 0.5f),new Vector3f(-4.0f, 2.0E-6f, 0.0f));
		this.quads[44] = new ObjQuad(new Vector3f(0.199999f, 0.235342f, -0.319225f),new Vector3f(0.2f, 1.034314f, -1.118198f),new Vector3f(0.3f, 1.034314f, -1.118198f),new Vector3f(0.299999f, 0.235343f, -0.319226f),new Vector2f(0.6875f, 0.5f),new Vector2f(0.6875f, 0.0f),new Vector2f(0.625f, 0.0f),new Vector2f(0.625f, 0.5f),new Vector3f(-8.0E-6f, -2.8284268f, -2.828426f));
		this.quads[45] = new ObjQuad(new Vector3f(0.3f, 1.105025f, -1.047488f),new Vector3f(0.2f, 1.105025f, -1.047488f),new Vector3f(0.199999f, 0.306053f, -0.248515f),new Vector3f(0.299999f, 0.306053f, -0.248515f),new Vector2f(0.5f, 0.0f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.5625f, 0.5f),new Vector2f(0.5f, 0.5f),new Vector3f(3.0E-6f, 2.828428f, 2.8284261f));
		this.quads[46] = new ObjQuad(new Vector3f(0.2f, 1.034314f, -1.118198f),new Vector3f(0.2f, 1.105025f, -1.047488f),new Vector3f(0.3f, 1.105025f, -1.047488f),new Vector3f(0.3f, 1.034314f, -1.118198f),new Vector2f(0.75f, 0.0f),new Vector2f(0.6875f, 0.0f),new Vector2f(0.6875f, 0.0625f),new Vector2f(0.75f, 0.0625f),new Vector3f(-1.6E-5f, 2.8284159f, -2.828439f));
		this.quads[47] = new ObjQuad(new Vector3f(0.299999f, 0.235343f, -0.319226f),new Vector3f(0.3f, 1.034314f, -1.118198f),new Vector3f(0.3f, 1.105025f, -1.047488f),new Vector3f(0.299999f, 0.306053f, -0.248515f),new Vector2f(0.75f, 0.5f),new Vector2f(0.75f, 0.0f),new Vector2f(0.6875f, 0.0f),new Vector2f(0.6875f, 0.5f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[48] = new ObjQuad(new Vector3f(0.3f, -0.565686f, 0.481801f),new Vector3f(0.3f, -0.494975f, 0.552512f),new Vector3f(0.2f, -0.494975f, 0.552512f),new Vector3f(0.2f, -0.565686f, 0.481801f),new Vector2f(0.75f, 0.0f),new Vector2f(0.6875f, 0.0f),new Vector2f(0.6875f, 0.0625f),new Vector2f(0.75f, 0.0625f),new Vector3f(1.2E-5f, -2.828428f, 2.828428f));
		this.quads[49] = new ObjQuad(new Vector3f(0.199999f, 0.235342f, -0.319225f),new Vector3f(0.2f, -0.565686f, 0.481801f),new Vector3f(0.2f, -0.494975f, 0.552512f),new Vector3f(0.199999f, 0.306053f, -0.248515f),new Vector2f(0.625f, 0.5f),new Vector2f(0.625f, 0.0f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.5625f, 0.5f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[50] = new ObjQuad(new Vector3f(0.2f, -0.565686f, 0.481801f),new Vector3f(0.199999f, 0.235342f, -0.319225f),new Vector3f(0.299999f, 0.235343f, -0.319226f),new Vector3f(0.3f, -0.565686f, 0.481801f),new Vector2f(0.6875f, 0.5f),new Vector2f(0.6875f, 0.0f),new Vector2f(0.625f, 0.0f),new Vector2f(0.625f, 0.5f),new Vector3f(-3.0E-6f, -2.828425f, -2.828428f));
		this.quads[51] = new ObjQuad(new Vector3f(0.3f, -0.494975f, 0.552512f),new Vector3f(0.299999f, 0.306053f, -0.248515f),new Vector3f(0.199999f, 0.306053f, -0.248515f),new Vector3f(0.2f, -0.494975f, 0.552512f),new Vector2f(0.5f, 0.5f),new Vector2f(0.5f, 0.0f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.5625f, 0.5f),new Vector3f(-8.0E-6f, 2.828426f, 2.828428f));
		this.quads[52] = new ObjQuad(new Vector3f(0.3f, -0.565686f, 0.481801f),new Vector3f(0.299999f, 0.235343f, -0.319226f),new Vector3f(0.299999f, 0.306053f, -0.248515f),new Vector3f(0.3f, -0.494975f, 0.552512f),new Vector2f(0.75f, 0.5f),new Vector2f(0.75f, 0.0f),new Vector2f(0.6875f, 0.0f),new Vector2f(0.6875f, 0.5f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[53] = new ObjQuad(new Vector3f(0.2f, 1.034314f, -1.118198f),new Vector3f(0.199999f, 0.235342f, -0.319225f),new Vector3f(0.199999f, 0.306053f, -0.248515f),new Vector3f(0.2f, 1.105025f, -1.047488f),new Vector2f(0.625f, 0.5f),new Vector2f(0.625f, 0.0f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.5625f, 0.5f),new Vector3f(-4.0f, 2.0E-6f, 0.0f));
		this.quads[54] = new ObjQuad(new Vector3f(-0.300001f, 0.968296f, -0.345071f),new Vector3f(-0.300001f, 0.685453f, -0.627914f),new Vector3f(-0.300001f, 0.589866f, -0.532328f),new Vector3f(-0.300001f, 0.872709f, -0.249485f),new Vector2f(0.625f, 0.25f),new Vector2f(0.625f, 0.0f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.5625f, 0.25f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[55] = new ObjQuad(new Vector3f(0.199999f, 0.968296f, -0.345072f),new Vector3f(0.199999f, 0.685453f, -0.627915f),new Vector3f(0.199999f, 0.589866f, -0.532327f),new Vector3f(0.199999f, 0.872709f, -0.249485f),new Vector2f(0.625f, 0.25f),new Vector2f(0.625f, 0.0f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.5625f, 0.25f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[56] = new ObjQuad(new Vector3f(-0.300001f, 0.685453f, -0.627914f),new Vector3f(-0.300001f, 0.968296f, -0.345071f),new Vector3f(-0.200001f, 0.968296f, -0.345072f),new Vector3f(-0.200001f, 0.685453f, -0.627914f),new Vector2f(0.6875f, 0.5f),new Vector2f(0.6875f, 0.25f),new Vector2f(0.625f, 0.25f),new Vector2f(0.625f, 0.5f),new Vector3f(-1.6E-5f, 2.828425f, -2.8284302f));
		this.quads[57] = new ObjQuad(new Vector3f(-0.200001f, 0.589866f, -0.532327f),new Vector3f(-0.200001f, 0.872709f, -0.249485f),new Vector3f(-0.300001f, 0.872709f, -0.249485f),new Vector3f(-0.300001f, 0.589866f, -0.532328f),new Vector2f(0.5f, 0.5f),new Vector2f(0.5f, 0.25f),new Vector2f(0.5625f, 0.25f),new Vector2f(0.5625f, 0.5f),new Vector3f(-2.2E-5f, -2.828426f, 2.8284292f));
		this.quads[58] = new ObjQuad(new Vector3f(-0.200001f, 0.685453f, -0.627914f),new Vector3f(-0.200001f, 0.968296f, -0.345072f),new Vector3f(-0.200001f, 0.872709f, -0.249485f),new Vector3f(-0.200001f, 0.589866f, -0.532327f),new Vector2f(0.75f, 0.5f),new Vector2f(0.75f, 0.25f),new Vector2f(0.6875f, 0.25f),new Vector2f(0.6875f, 0.5f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[59] = new ObjQuad(new Vector3f(0.199999f, 0.685453f, -0.627915f),new Vector3f(0.199999f, 0.968296f, -0.345072f),new Vector3f(0.299999f, 0.968296f, -0.345072f),new Vector3f(0.299999f, 0.685453f, -0.627915f),new Vector2f(0.6875f, 0.5f),new Vector2f(0.6875f, 0.25f),new Vector2f(0.625f, 0.25f),new Vector2f(0.625f, 0.5f),new Vector3f(0.0f, 2.828428f, -2.828428f));
		this.quads[60] = new ObjQuad(new Vector3f(0.299999f, 0.589866f, -0.532328f),new Vector3f(0.299999f, 0.872709f, -0.249485f),new Vector3f(0.199999f, 0.872709f, -0.249485f),new Vector3f(0.199999f, 0.589866f, -0.532327f),new Vector2f(0.5f, 0.5f),new Vector2f(0.5f, 0.25f),new Vector2f(0.5625f, 0.25f),new Vector2f(0.5625f, 0.5f),new Vector3f(2.2E-5f, -2.828426f, 2.828429f));
		this.quads[61] = new ObjQuad(new Vector3f(0.299999f, 0.685453f, -0.627915f),new Vector3f(0.299999f, 0.968296f, -0.345072f),new Vector3f(0.299999f, 0.872709f, -0.249485f),new Vector3f(0.299999f, 0.589866f, -0.532328f),new Vector2f(0.75f, 0.5f),new Vector2f(0.75f, 0.25f),new Vector2f(0.6875f, 0.25f),new Vector2f(0.6875f, 0.5f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[62] = new ObjQuad(new Vector3f(-0.200001f, 0.209585f, 0.413638f),new Vector3f(-0.200001f, -0.073258f, 0.130795f),new Vector3f(-0.200001f, 0.022297f, 0.03524f),new Vector3f(-0.200001f, 0.30514f, 0.318083f),new Vector2f(0.625f, 0.25f),new Vector2f(0.625f, 0.0f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.5625f, 0.25f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[63] = new ObjQuad(new Vector3f(0.299999f, 0.209585f, 0.413638f),new Vector3f(0.299999f, -0.073258f, 0.130795f),new Vector3f(0.299999f, 0.022297f, 0.03524f),new Vector3f(0.299999f, 0.30514f, 0.318083f),new Vector2f(0.625f, 0.25f),new Vector2f(0.625f, 0.0f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.5625f, 0.25f),new Vector3f(4.0f, -2.0E-6f, 2.0E-6f));
		this.quads[64] = new ObjQuad(new Vector3f(-0.200001f, -0.073258f, 0.130795f),new Vector3f(-0.200001f, 0.209585f, 0.413638f),new Vector3f(-0.300001f, 0.209585f, 0.413638f),new Vector3f(-0.300001f, -0.073258f, 0.130795f),new Vector2f(0.6875f, 0.5f),new Vector2f(0.6875f, 0.25f),new Vector2f(0.625f, 0.25f),new Vector2f(0.625f, 0.5f),new Vector3f(0.0f, -2.828428f, 2.828424f));
		this.quads[65] = new ObjQuad(new Vector3f(-0.300001f, 0.022297f, 0.03524f),new Vector3f(-0.300001f, 0.30514f, 0.318083f),new Vector3f(-0.200001f, 0.30514f, 0.318083f),new Vector3f(-0.200001f, 0.022297f, 0.03524f),new Vector2f(0.5f, 0.5f),new Vector2f(0.5f, 0.25f),new Vector2f(0.5625f, 0.25f),new Vector2f(0.5625f, 0.5f),new Vector3f(-5.0E-6f, 2.828428f, -2.828427f));
		this.quads[66] = new ObjQuad(new Vector3f(-0.300001f, -0.073258f, 0.130795f),new Vector3f(-0.300001f, 0.209585f, 0.413638f),new Vector3f(-0.300001f, 0.30514f, 0.318083f),new Vector3f(-0.300001f, 0.022297f, 0.03524f),new Vector2f(0.75f, 0.5f),new Vector2f(0.75f, 0.25f),new Vector2f(0.6875f, 0.25f),new Vector2f(0.6875f, 0.5f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[67] = new ObjQuad(new Vector3f(0.299999f, -0.073258f, 0.130795f),new Vector3f(0.299999f, 0.209585f, 0.413638f),new Vector3f(0.199999f, 0.209584f, 0.413639f),new Vector3f(0.199999f, -0.073258f, 0.130796f),new Vector2f(0.6875f, 0.5f),new Vector2f(0.6875f, 0.25f),new Vector2f(0.625f, 0.25f),new Vector2f(0.625f, 0.5f),new Vector3f(2.7E-5f, -2.8284302f, 2.828424f));
		this.quads[68] = new ObjQuad(new Vector3f(0.199999f, 0.022297f, 0.03524f),new Vector3f(0.199999f, 0.30514f, 0.318083f),new Vector3f(0.299999f, 0.30514f, 0.318083f),new Vector3f(0.299999f, 0.022297f, 0.03524f),new Vector2f(0.5f, 0.5f),new Vector2f(0.5f, 0.25f),new Vector2f(0.5625f, 0.25f),new Vector2f(0.5625f, 0.5f),new Vector3f(-2.0E-6f, 2.828428f, -2.828424f));
		this.quads[69] = new ObjQuad(new Vector3f(0.199999f, -0.073258f, 0.130796f),new Vector3f(0.199999f, 0.209584f, 0.413639f),new Vector3f(0.199999f, 0.30514f, 0.318083f),new Vector3f(0.199999f, 0.022297f, 0.03524f),new Vector2f(0.75f, 0.5f),new Vector2f(0.75f, 0.25f),new Vector2f(0.6875f, 0.25f),new Vector2f(0.6875f, 0.5f),new Vector3f(-4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		BackUpFrontDown001 other = new BackUpFrontDown001();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}
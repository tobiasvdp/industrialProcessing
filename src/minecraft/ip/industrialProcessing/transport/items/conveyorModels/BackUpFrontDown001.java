package ip.industrialProcessing.transport.items.conveyorModels;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class BackUpFrontDown001 extends ObjMesh{
	public BackUpFrontDown001(){
		this.quads = new ObjQuad[70];
		this.quads[0] = new ObjQuad(new Vector3f(-0.3f, 1.458578f, -0.941422f),new Vector3f(-0.3f, 1.599999f, -0.8f),new Vector3f(0.3f, 1.6f, -0.800001f),new Vector3f(0.3f, 1.458578f, -0.941422f),new Vector2f(0.7505f, 0.5625f),new Vector2f(0.6255f, 0.5625f),new Vector2f(0.6255f, 0.9375f),new Vector2f(0.7505f, 0.9375f),new Vector3f(-3.0E-6f, 2.828425f, -2.828429f));
		this.quads[1] = new ObjQuad(new Vector3f(0.299999f, 0.659607f, -0.142448f),new Vector3f(0.3f, 1.458578f, -0.941422f),new Vector3f(0.3f, 1.6f, -0.800001f),new Vector3f(0.299999f, 0.801028f, -0.001028f),new Vector2f(0.625056f, 0.49995f),new Vector2f(0.625056f, 1.000043f),new Vector2f(0.75038f, 1.000043f),new Vector2f(0.75038f, 0.499951f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.3f, -0.141422f, 0.658579f),new Vector3f(0.3f, -0.0f, 0.799999f),new Vector3f(-0.3f, -0.0f, 0.8f),new Vector3f(-0.3f, -0.141422f, 0.658579f),new Vector2f(0.7505f, 0.5625f),new Vector2f(0.6255f, 0.5625f),new Vector2f(0.6255f, 0.9375f),new Vector2f(0.7505f, 0.9375f),new Vector3f(2.0E-6f, -2.828427f, 2.8284273f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.300001f, 0.659607f, -0.142448f),new Vector3f(-0.3f, -0.141422f, 0.658579f),new Vector3f(-0.3f, -0.0f, 0.8f),new Vector3f(-0.300001f, 0.801028f, -0.001028f),new Vector2f(0.625056f, 0.49995f),new Vector2f(0.625056f, 1.000043f),new Vector2f(0.75038f, 1.000043f),new Vector2f(0.75038f, 0.499951f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.400001f, 0.588896f, -0.213159f),new Vector3f(-0.4f, 1.387867f, -1.012132f),new Vector3f(0.4f, 1.387868f, -1.012132f),new Vector3f(0.399999f, 0.588896f, -0.213159f),new Vector2f(0.5f, 0.5f),new Vector2f(0.5f, 0.0f),new Vector2f(0.0f, 0.0f),new Vector2f(0.0f, 0.5f),new Vector3f(0.0f, -2.828428f, -2.828426f));
		this.quads[5] = new ObjQuad(new Vector3f(0.399999f, 0.588896f, -0.213159f),new Vector3f(0.4f, 1.387868f, -1.012132f),new Vector3f(0.4f, 1.458578f, -0.941422f),new Vector3f(0.399999f, 0.659607f, -0.142448f),new Vector2f(0.812999f, 0.499981f),new Vector2f(0.812999f, 0.999997f),new Vector2f(0.875f, 0.999997f),new Vector2f(0.875f, 0.499981f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.400001f, 0.588896f, -0.213159f),new Vector3f(-0.4f, -0.212133f, 0.587868f),new Vector3f(-0.4f, -0.141422f, 0.658579f),new Vector3f(-0.400001f, 0.659606f, -0.142448f),new Vector2f(0.812999f, 0.499981f),new Vector2f(0.812999f, 0.999997f),new Vector2f(0.875f, 0.999997f),new Vector2f(0.875f, 0.499981f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.4f, 1.387867f, -1.012132f),new Vector3f(-0.4f, 1.458578f, -0.941421f),new Vector3f(-0.3f, 1.458578f, -0.941422f),new Vector3f(0.4f, 1.387868f, -1.012132f),new Vector2f(0.813f, 0.5f),new Vector2f(0.7505f, 0.5f),new Vector2f(0.7505f, 0.5625f),new Vector2f(0.813f, 1.0f),new Vector3f(-1.0E-5f, 2.8284168f, -2.8284369f));
		this.quads[8] = new ObjQuad(new Vector3f(0.4f, 1.387868f, -1.012132f),new Vector3f(-0.3f, 1.458578f, -0.941422f),new Vector3f(0.3f, 1.458578f, -0.941422f),new Vector3f(0.4f, 1.458578f, -0.941422f),new Vector2f(0.813f, 1.0f),new Vector2f(0.7505f, 0.5625f),new Vector2f(0.7505f, 0.9375f),new Vector2f(0.7505f, 1.0f),new Vector3f(-2.0E-6f, 2.828423f, -2.828432f));
		this.quads[9] = new ObjQuad(new Vector3f(-0.3f, 1.458578f, -0.941422f),new Vector3f(-0.4f, 1.458578f, -0.941421f),new Vector3f(-0.400001f, 0.659606f, -0.142448f),new Vector3f(-0.300001f, 0.659607f, -0.142448f),new Vector2f(0.8125f, 0.5f),new Vector2f(0.75f, 0.5f),new Vector2f(0.75f, 1.0f),new Vector2f(0.8125f, 1.0f),new Vector3f(5.0E-6f, 2.828428f, 2.828427f));
		this.quads[10] = new ObjQuad(new Vector3f(0.4f, -0.212133f, 0.587868f),new Vector3f(0.4f, -0.141422f, 0.658579f),new Vector3f(0.3f, -0.141422f, 0.658579f),new Vector3f(-0.4f, -0.212133f, 0.587868f),new Vector2f(0.813f, 0.5f),new Vector2f(0.7505f, 0.5f),new Vector2f(0.7505f, 0.5625f),new Vector2f(0.813f, 1.0f),new Vector3f(0.0f, -2.82842f, 2.828436f));
		this.quads[11] = new ObjQuad(new Vector3f(-0.4f, -0.212133f, 0.587868f),new Vector3f(0.3f, -0.141422f, 0.658579f),new Vector3f(-0.3f, -0.141422f, 0.658579f),new Vector3f(-0.4f, -0.141422f, 0.658579f),new Vector2f(0.813f, 1.0f),new Vector2f(0.7505f, 0.5625f),new Vector2f(0.7505f, 0.9375f),new Vector2f(0.7505f, 1.0f),new Vector3f(0.0f, -2.82842f, 2.828436f));
		this.quads[12] = new ObjQuad(new Vector3f(0.3f, -0.141422f, 0.658579f),new Vector3f(0.4f, -0.141422f, 0.658579f),new Vector3f(0.399999f, 0.659607f, -0.142448f),new Vector3f(0.299999f, 0.659607f, -0.142448f),new Vector2f(0.75f, 1.0f),new Vector2f(0.8125f, 1.0f),new Vector2f(0.8125f, 0.5f),new Vector2f(0.75f, 0.5f),new Vector3f(0.0f, 2.8284261f, 2.828428f));
		this.quads[13] = new ObjQuad(new Vector3f(0.4f, 1.670711f, -0.72929f),new Vector3f(-0.4f, 1.67071f, -0.729289f),new Vector3f(-0.400001f, 0.871739f, 0.069683f),new Vector3f(0.399999f, 0.871738f, 0.069684f),new Vector2f(-0.0f, 1.0f),new Vector2f(0.5f, 1.0f),new Vector2f(0.5f, 0.5f),new Vector2f(0.0f, 0.5f),new Vector3f(0.0f, 2.828428f, 2.8284261f));
		this.quads[14] = new ObjQuad(new Vector3f(0.399999f, 0.801028f, -0.001028f),new Vector3f(0.4f, 1.600001f, -0.800001f),new Vector3f(0.4f, 1.670711f, -0.72929f),new Vector3f(0.399999f, 0.871738f, 0.069684f),new Vector2f(0.5f, 0.499998f),new Vector2f(0.5f, 0.999991f),new Vector2f(0.562502f, 0.999992f),new Vector2f(0.562502f, 0.499998f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[15] = new ObjQuad(new Vector3f(-0.400001f, 0.801028f, -0.001027f),new Vector3f(-0.4f, -0.0f, 0.8f),new Vector3f(-0.4f, 0.070711f, 0.870711f),new Vector3f(-0.400001f, 0.871739f, 0.069683f),new Vector2f(0.5f, 0.499998f),new Vector2f(0.5f, 0.999991f),new Vector2f(0.562502f, 0.999992f),new Vector2f(0.562502f, 0.499998f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[16] = new ObjQuad(new Vector3f(0.4f, 1.670711f, -0.72929f),new Vector3f(0.4f, 1.600001f, -0.800001f),new Vector3f(0.3f, 1.6f, -0.800001f),new Vector3f(-0.4f, 1.67071f, -0.729289f),new Vector2f(0.5625f, 1.0f),new Vector2f(0.6255f, 1.0f),new Vector2f(0.6255f, 0.9375f),new Vector2f(0.5625f, 0.5f),new Vector3f(-1.0E-5f, 2.828427f, -2.828428f));
		this.quads[17] = new ObjQuad(new Vector3f(-0.4f, 1.67071f, -0.729289f),new Vector3f(0.3f, 1.6f, -0.800001f),new Vector3f(-0.3f, 1.599999f, -0.8f),new Vector3f(-0.4f, 1.6f, -0.8f),new Vector2f(0.5625f, 0.5f),new Vector2f(0.6255f, 0.9375f),new Vector2f(0.6255f, 0.5625f),new Vector2f(0.6255f, 0.5f),new Vector3f(-2.0000002E-6f, 2.8284268f, -2.8284283f));
		this.quads[18] = new ObjQuad(new Vector3f(0.3f, 1.6f, -0.800001f),new Vector3f(0.4f, 1.600001f, -0.800001f),new Vector3f(0.399999f, 0.801028f, -0.001028f),new Vector3f(0.299999f, 0.801028f, -0.001028f),new Vector2f(0.625f, 0.5f),new Vector2f(0.5625f, 0.5f),new Vector2f(0.5625f, 1.0f),new Vector2f(0.625f, 1.0f),new Vector3f(1.0E-5f, -2.828428f, -2.8284261f));
		this.quads[19] = new ObjQuad(new Vector3f(-0.4f, 0.070711f, 0.870711f),new Vector3f(-0.4f, -0.0f, 0.8f),new Vector3f(-0.3f, -0.0f, 0.8f),new Vector3f(0.4f, 0.070711f, 0.870711f),new Vector2f(0.5625f, 1.0f),new Vector2f(0.6255f, 1.0f),new Vector2f(0.6255f, 0.9375f),new Vector2f(0.5625f, 0.5f),new Vector3f(0.0f, -2.8284278f, 2.828428f));
		this.quads[20] = new ObjQuad(new Vector3f(0.4f, 0.070711f, 0.870711f),new Vector3f(-0.3f, -0.0f, 0.8f),new Vector3f(0.3f, -0.0f, 0.799999f),new Vector3f(0.4f, -0.0f, 0.799999f),new Vector2f(0.5625f, 0.5f),new Vector2f(0.6255f, 0.9375f),new Vector2f(0.6255f, 0.5625f),new Vector2f(0.6255f, 0.5f),new Vector3f(1.0E-6f, -2.828436f, 2.828419f));
		this.quads[21] = new ObjQuad(new Vector3f(-0.3f, -0.0f, 0.8f),new Vector3f(-0.4f, -0.0f, 0.8f),new Vector3f(-0.400001f, 0.801028f, -0.001027f),new Vector3f(-0.300001f, 0.801028f, -0.001028f),new Vector2f(0.5625f, 1.0f),new Vector2f(0.625f, 1.0f),new Vector2f(0.625f, 0.5f),new Vector2f(0.5625f, 0.5f),new Vector3f(-6.0E-6f, -2.8284261f, -2.828428f));
		this.quads[22] = new ObjQuad(new Vector3f(0.3f, -0.141422f, 0.658579f),new Vector3f(0.299999f, 0.659607f, -0.142448f),new Vector3f(0.299999f, 0.801028f, -0.001028f),new Vector3f(0.3f, -0.0f, 0.799999f),new Vector2f(0.625056f, 0.49995f),new Vector2f(0.625056f, 1.000043f),new Vector2f(0.75038f, 1.000043f),new Vector2f(0.75038f, 0.499951f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[23] = new ObjQuad(new Vector3f(-0.3f, 1.458578f, -0.941422f),new Vector3f(-0.300001f, 0.659607f, -0.142448f),new Vector3f(-0.300001f, 0.801028f, -0.001028f),new Vector3f(-0.3f, 1.599999f, -0.8f),new Vector2f(0.625056f, 0.49995f),new Vector2f(0.625056f, 1.000043f),new Vector2f(0.75038f, 1.000043f),new Vector2f(0.75038f, 0.499951f),new Vector3f(-4.0f, 2.0E-6f, 0.0f));
		this.quads[24] = new ObjQuad(new Vector3f(-0.4f, -0.212133f, 0.587868f),new Vector3f(-0.400001f, 0.588896f, -0.213159f),new Vector3f(0.399999f, 0.588896f, -0.213159f),new Vector3f(0.4f, -0.212133f, 0.587868f),new Vector2f(0.5f, 0.5f),new Vector2f(0.5f, 0.0f),new Vector2f(0.0f, 0.0f),new Vector2f(0.0f, 0.5f),new Vector3f(0.0f, -2.828426f, -2.828428f));
		this.quads[25] = new ObjQuad(new Vector3f(0.4f, -0.212133f, 0.587868f),new Vector3f(0.399999f, 0.588896f, -0.213159f),new Vector3f(0.399999f, 0.659607f, -0.142448f),new Vector3f(0.4f, -0.141422f, 0.658579f),new Vector2f(0.812999f, 0.499981f),new Vector2f(0.812999f, 0.999997f),new Vector2f(0.875f, 0.999997f),new Vector2f(0.875f, 0.499981f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[26] = new ObjQuad(new Vector3f(-0.4f, 1.387867f, -1.012132f),new Vector3f(-0.400001f, 0.588896f, -0.213159f),new Vector3f(-0.400001f, 0.659606f, -0.142448f),new Vector3f(-0.4f, 1.458578f, -0.941421f),new Vector2f(0.812999f, 0.499981f),new Vector2f(0.812999f, 0.999997f),new Vector2f(0.875f, 0.999997f),new Vector2f(0.875f, 0.499981f),new Vector3f(-4.0f, 0.0f, -2.0E-6f));
		this.quads[27] = new ObjQuad(new Vector3f(-0.3f, -0.141422f, 0.658579f),new Vector3f(-0.300001f, 0.659607f, -0.142448f),new Vector3f(-0.400001f, 0.659606f, -0.142448f),new Vector3f(-0.4f, -0.141422f, 0.658579f),new Vector2f(0.8125f, 1.0f),new Vector2f(0.8125f, 0.5f),new Vector2f(0.75f, 0.5f),new Vector2f(0.75f, 1.0f),new Vector3f(-5.0E-6f, 2.828426f, 2.828428f));
		this.quads[28] = new ObjQuad(new Vector3f(0.3f, 1.458578f, -0.941422f),new Vector3f(0.299999f, 0.659607f, -0.142448f),new Vector3f(0.399999f, 0.659607f, -0.142448f),new Vector3f(0.4f, 1.458578f, -0.941422f),new Vector2f(0.75f, 0.5f),new Vector2f(0.75f, 1.0f),new Vector2f(0.8125f, 1.0f),new Vector2f(0.8125f, 0.5f),new Vector3f(0.0f, 2.828428f, 2.828426f));
		this.quads[29] = new ObjQuad(new Vector3f(0.4f, 0.070711f, 0.870711f),new Vector3f(0.399999f, 0.871738f, 0.069684f),new Vector3f(-0.400001f, 0.871739f, 0.069683f),new Vector3f(-0.4f, 0.070711f, 0.870711f),new Vector2f(0.0f, 0.5f),new Vector2f(-0.0f, 1.0f),new Vector2f(0.5f, 1.0f),new Vector2f(0.5f, 0.5f),new Vector3f(0.0f, 2.828428f, 2.828428f));
		this.quads[30] = new ObjQuad(new Vector3f(0.4f, -0.0f, 0.799999f),new Vector3f(0.399999f, 0.801028f, -0.001028f),new Vector3f(0.399999f, 0.871738f, 0.069684f),new Vector3f(0.4f, 0.070711f, 0.870711f),new Vector2f(0.5f, 0.499998f),new Vector2f(0.5f, 0.999991f),new Vector2f(0.562502f, 0.999992f),new Vector2f(0.562502f, 0.499998f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[31] = new ObjQuad(new Vector3f(-0.4f, 1.6f, -0.8f),new Vector3f(-0.400001f, 0.801028f, -0.001027f),new Vector3f(-0.400001f, 0.871739f, 0.069683f),new Vector3f(-0.4f, 1.67071f, -0.729289f),new Vector2f(0.5f, 0.499998f),new Vector2f(0.5f, 0.999991f),new Vector2f(0.562502f, 0.999992f),new Vector2f(0.562502f, 0.499998f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[32] = new ObjQuad(new Vector3f(0.3f, -0.0f, 0.799999f),new Vector3f(0.299999f, 0.801028f, -0.001028f),new Vector3f(0.399999f, 0.801028f, -0.001028f),new Vector3f(0.4f, -0.0f, 0.799999f),new Vector2f(0.625f, 1.0f),new Vector2f(0.625f, 0.5f),new Vector2f(0.5625f, 0.5f),new Vector2f(0.5625f, 1.0f),new Vector3f(0.0f, -2.828426f, -2.8284302f));
		this.quads[33] = new ObjQuad(new Vector3f(-0.3f, 1.599999f, -0.8f),new Vector3f(-0.300001f, 0.801028f, -0.001028f),new Vector3f(-0.400001f, 0.801028f, -0.001027f),new Vector3f(-0.4f, 1.6f, -0.8f),new Vector2f(0.5625f, 0.5f),new Vector2f(0.5625f, 1.0f),new Vector2f(0.625f, 1.0f),new Vector2f(0.625f, 0.5f),new Vector3f(-8.0E-6f, -2.828428f, -2.828426f));
		this.quads[34] = new ObjQuad(new Vector3f(-0.300001f, 0.235342f, -0.566713f),new Vector3f(-0.3f, 1.034313f, -1.365685f),new Vector3f(-0.2f, 1.034313f, -1.365685f),new Vector3f(-0.200001f, 0.235342f, -0.566712f),new Vector2f(0.6875f, 0.5f),new Vector2f(0.6875f, 0.0f),new Vector2f(0.625f, 0.0f),new Vector2f(0.625f, 0.5f),new Vector3f(8.0E-6f, -2.828428f, -2.828426f));
		this.quads[35] = new ObjQuad(new Vector3f(-0.2f, 1.105024f, -1.294975f),new Vector3f(-0.3f, 1.105024f, -1.294975f),new Vector3f(-0.300001f, 0.306053f, -0.496002f),new Vector3f(-0.200001f, 0.306053f, -0.496001f),new Vector2f(0.5f, 0.0f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.5625f, 0.5f),new Vector2f(0.5f, 0.5f),new Vector3f(-8.0E-6f, 2.828428f, 2.8284261f));
		this.quads[36] = new ObjQuad(new Vector3f(-0.3f, 1.034313f, -1.365685f),new Vector3f(-0.3f, 1.105024f, -1.294975f),new Vector3f(-0.2f, 1.105024f, -1.294975f),new Vector3f(-0.2f, 1.034313f, -1.365685f),new Vector2f(0.75f, 0.0f),new Vector2f(0.6875f, 0.0f),new Vector2f(0.6875f, 0.0625f),new Vector2f(0.75f, 0.0625f),new Vector3f(0.0f, 2.828428f, -2.828428f));
		this.quads[37] = new ObjQuad(new Vector3f(-0.200001f, 0.235342f, -0.566712f),new Vector3f(-0.2f, 1.034313f, -1.365685f),new Vector3f(-0.2f, 1.105024f, -1.294975f),new Vector3f(-0.200001f, 0.306053f, -0.496001f),new Vector2f(0.75f, 0.5f),new Vector2f(0.75f, 0.0f),new Vector2f(0.6875f, 0.0f),new Vector2f(0.6875f, 0.5f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[38] = new ObjQuad(new Vector3f(-0.2f, -0.565686f, 0.234314f),new Vector3f(-0.2f, -0.494975f, 0.305025f),new Vector3f(-0.3f, -0.494975f, 0.305025f),new Vector3f(-0.3f, -0.565686f, 0.234314f),new Vector2f(0.75f, 0.0f),new Vector2f(0.6875f, 0.0f),new Vector2f(0.6875f, 0.0625f),new Vector2f(0.75f, 0.0625f),new Vector3f(0.0f, -2.828428f, 2.828428f));
		this.quads[39] = new ObjQuad(new Vector3f(-0.300001f, 0.235342f, -0.566713f),new Vector3f(-0.3f, -0.565686f, 0.234314f),new Vector3f(-0.3f, -0.494975f, 0.305025f),new Vector3f(-0.300001f, 0.306053f, -0.496002f),new Vector2f(0.625f, 0.5f),new Vector2f(0.625f, 0.0f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.5625f, 0.5f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[40] = new ObjQuad(new Vector3f(-0.3f, -0.565686f, 0.234314f),new Vector3f(-0.300001f, 0.235342f, -0.566713f),new Vector3f(-0.200001f, 0.235342f, -0.566712f),new Vector3f(-0.2f, -0.565686f, 0.234314f),new Vector2f(0.6875f, 0.5f),new Vector2f(0.6875f, 0.0f),new Vector2f(0.625f, 0.0f),new Vector2f(0.625f, 0.5f),new Vector3f(8.0E-6f, -2.828426f, -2.8284302f));
		this.quads[41] = new ObjQuad(new Vector3f(-0.2f, -0.494975f, 0.305025f),new Vector3f(-0.200001f, 0.306053f, -0.496001f),new Vector3f(-0.300001f, 0.306053f, -0.496002f),new Vector3f(-0.3f, -0.494975f, 0.305025f),new Vector2f(0.5f, 0.5f),new Vector2f(0.5f, 0.0f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.5625f, 0.5f),new Vector3f(-8.0E-6f, 2.828426f, 2.828428f));
		this.quads[42] = new ObjQuad(new Vector3f(-0.2f, -0.565686f, 0.234314f),new Vector3f(-0.200001f, 0.235342f, -0.566712f),new Vector3f(-0.200001f, 0.306053f, -0.496001f),new Vector3f(-0.2f, -0.494975f, 0.305025f),new Vector2f(0.75f, 0.5f),new Vector2f(0.75f, 0.0f),new Vector2f(0.6875f, 0.0f),new Vector2f(0.6875f, 0.5f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[43] = new ObjQuad(new Vector3f(-0.3f, 1.034313f, -1.365685f),new Vector3f(-0.300001f, 0.235342f, -0.566713f),new Vector3f(-0.300001f, 0.306053f, -0.496002f),new Vector3f(-0.3f, 1.105024f, -1.294975f),new Vector2f(0.625f, 0.5f),new Vector2f(0.625f, 0.0f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.5625f, 0.5f),new Vector3f(-4.0f, 2.0E-6f, 0.0f));
		this.quads[44] = new ObjQuad(new Vector3f(0.199999f, 0.235342f, -0.566712f),new Vector3f(0.2f, 1.034314f, -1.365685f),new Vector3f(0.3f, 1.034314f, -1.365685f),new Vector3f(0.299999f, 0.235342f, -0.566713f),new Vector2f(0.6875f, 0.5f),new Vector2f(0.6875f, 0.0f),new Vector2f(0.625f, 0.0f),new Vector2f(0.625f, 0.5f),new Vector3f(-8.0E-6f, -2.8284268f, -2.828426f));
		this.quads[45] = new ObjQuad(new Vector3f(0.3f, 1.105025f, -1.294975f),new Vector3f(0.2f, 1.105024f, -1.294975f),new Vector3f(0.199999f, 0.306053f, -0.496002f),new Vector3f(0.299999f, 0.306053f, -0.496002f),new Vector2f(0.5f, 0.0f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.5625f, 0.5f),new Vector2f(0.5f, 0.5f),new Vector3f(3.0E-6f, 2.828428f, 2.8284261f));
		this.quads[46] = new ObjQuad(new Vector3f(0.2f, 1.034314f, -1.365685f),new Vector3f(0.2f, 1.105024f, -1.294975f),new Vector3f(0.3f, 1.105025f, -1.294975f),new Vector3f(0.3f, 1.034314f, -1.365685f),new Vector2f(0.75f, 0.0f),new Vector2f(0.6875f, 0.0f),new Vector2f(0.6875f, 0.0625f),new Vector2f(0.75f, 0.0625f),new Vector3f(-1.6E-5f, 2.8284159f, -2.828439f));
		this.quads[47] = new ObjQuad(new Vector3f(0.299999f, 0.235342f, -0.566713f),new Vector3f(0.3f, 1.034314f, -1.365685f),new Vector3f(0.3f, 1.105025f, -1.294975f),new Vector3f(0.299999f, 0.306053f, -0.496002f),new Vector2f(0.75f, 0.5f),new Vector2f(0.75f, 0.0f),new Vector2f(0.6875f, 0.0f),new Vector2f(0.6875f, 0.5f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[48] = new ObjQuad(new Vector3f(0.3f, -0.565686f, 0.234314f),new Vector3f(0.3f, -0.494975f, 0.305025f),new Vector3f(0.2f, -0.494976f, 0.305025f),new Vector3f(0.2f, -0.565686f, 0.234314f),new Vector2f(0.75f, 0.0f),new Vector2f(0.6875f, 0.0f),new Vector2f(0.6875f, 0.0625f),new Vector2f(0.75f, 0.0625f),new Vector3f(1.2E-5f, -2.828428f, 2.828428f));
		this.quads[49] = new ObjQuad(new Vector3f(0.199999f, 0.235342f, -0.566712f),new Vector3f(0.2f, -0.565686f, 0.234314f),new Vector3f(0.2f, -0.494976f, 0.305025f),new Vector3f(0.199999f, 0.306053f, -0.496002f),new Vector2f(0.625f, 0.5f),new Vector2f(0.625f, 0.0f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.5625f, 0.5f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[50] = new ObjQuad(new Vector3f(0.2f, -0.565686f, 0.234314f),new Vector3f(0.199999f, 0.235342f, -0.566712f),new Vector3f(0.299999f, 0.235342f, -0.566713f),new Vector3f(0.3f, -0.565686f, 0.234314f),new Vector2f(0.6875f, 0.5f),new Vector2f(0.6875f, 0.0f),new Vector2f(0.625f, 0.0f),new Vector2f(0.625f, 0.5f),new Vector3f(-3.0E-6f, -2.828425f, -2.828428f));
		this.quads[51] = new ObjQuad(new Vector3f(0.3f, -0.494975f, 0.305025f),new Vector3f(0.299999f, 0.306053f, -0.496002f),new Vector3f(0.199999f, 0.306053f, -0.496002f),new Vector3f(0.2f, -0.494976f, 0.305025f),new Vector2f(0.5f, 0.5f),new Vector2f(0.5f, 0.0f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.5625f, 0.5f),new Vector3f(-8.0E-6f, 2.828426f, 2.828428f));
		this.quads[52] = new ObjQuad(new Vector3f(0.3f, -0.565686f, 0.234314f),new Vector3f(0.299999f, 0.235342f, -0.566713f),new Vector3f(0.299999f, 0.306053f, -0.496002f),new Vector3f(0.3f, -0.494975f, 0.305025f),new Vector2f(0.75f, 0.5f),new Vector2f(0.75f, 0.0f),new Vector2f(0.6875f, 0.0f),new Vector2f(0.6875f, 0.5f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[53] = new ObjQuad(new Vector3f(0.2f, 1.034314f, -1.365685f),new Vector3f(0.199999f, 0.235342f, -0.566712f),new Vector3f(0.199999f, 0.306053f, -0.496002f),new Vector3f(0.2f, 1.105024f, -1.294975f),new Vector2f(0.625f, 0.5f),new Vector2f(0.625f, 0.0f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.5625f, 0.5f),new Vector3f(-4.0f, 2.0E-6f, 0.0f));
		this.quads[54] = new ObjQuad(new Vector3f(-0.300001f, 0.968296f, -0.592558f),new Vector3f(-0.300001f, 0.685453f, -0.875401f),new Vector3f(-0.300001f, 0.589866f, -0.779815f),new Vector3f(-0.300001f, 0.872709f, -0.496972f),new Vector2f(0.625f, 0.25f),new Vector2f(0.625f, 0.0f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.5625f, 0.25f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[55] = new ObjQuad(new Vector3f(0.199999f, 0.968296f, -0.592559f),new Vector3f(0.199999f, 0.685453f, -0.875402f),new Vector3f(0.199999f, 0.589866f, -0.779814f),new Vector3f(0.199999f, 0.872708f, -0.496972f),new Vector2f(0.625f, 0.25f),new Vector2f(0.625f, 0.0f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.5625f, 0.25f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[56] = new ObjQuad(new Vector3f(-0.300001f, 0.685453f, -0.875401f),new Vector3f(-0.300001f, 0.968296f, -0.592558f),new Vector3f(-0.200001f, 0.968296f, -0.592559f),new Vector3f(-0.200001f, 0.685453f, -0.875401f),new Vector2f(0.6875f, 0.5f),new Vector2f(0.6875f, 0.25f),new Vector2f(0.625f, 0.25f),new Vector2f(0.625f, 0.5f),new Vector3f(-1.6E-5f, 2.828425f, -2.8284302f));
		this.quads[57] = new ObjQuad(new Vector3f(-0.200001f, 0.589866f, -0.779814f),new Vector3f(-0.200001f, 0.872708f, -0.496972f),new Vector3f(-0.300001f, 0.872709f, -0.496972f),new Vector3f(-0.300001f, 0.589866f, -0.779815f),new Vector2f(0.5f, 0.5f),new Vector2f(0.5f, 0.25f),new Vector2f(0.5625f, 0.25f),new Vector2f(0.5625f, 0.5f),new Vector3f(-2.2E-5f, -2.828426f, 2.8284292f));
		this.quads[58] = new ObjQuad(new Vector3f(-0.200001f, 0.685453f, -0.875401f),new Vector3f(-0.200001f, 0.968296f, -0.592559f),new Vector3f(-0.200001f, 0.872708f, -0.496972f),new Vector3f(-0.200001f, 0.589866f, -0.779814f),new Vector2f(0.75f, 0.5f),new Vector2f(0.75f, 0.25f),new Vector2f(0.6875f, 0.25f),new Vector2f(0.6875f, 0.5f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[59] = new ObjQuad(new Vector3f(0.199999f, 0.685453f, -0.875402f),new Vector3f(0.199999f, 0.968296f, -0.592559f),new Vector3f(0.299999f, 0.968296f, -0.592559f),new Vector3f(0.299999f, 0.685453f, -0.875402f),new Vector2f(0.6875f, 0.5f),new Vector2f(0.6875f, 0.25f),new Vector2f(0.625f, 0.25f),new Vector2f(0.625f, 0.5f),new Vector3f(0.0f, 2.828428f, -2.828428f));
		this.quads[60] = new ObjQuad(new Vector3f(0.299999f, 0.589866f, -0.779815f),new Vector3f(0.299999f, 0.872709f, -0.496972f),new Vector3f(0.199999f, 0.872708f, -0.496972f),new Vector3f(0.199999f, 0.589866f, -0.779814f),new Vector2f(0.5f, 0.5f),new Vector2f(0.5f, 0.25f),new Vector2f(0.5625f, 0.25f),new Vector2f(0.5625f, 0.5f),new Vector3f(2.2E-5f, -2.828426f, 2.828429f));
		this.quads[61] = new ObjQuad(new Vector3f(0.299999f, 0.685453f, -0.875402f),new Vector3f(0.299999f, 0.968296f, -0.592559f),new Vector3f(0.299999f, 0.872709f, -0.496972f),new Vector3f(0.299999f, 0.589866f, -0.779815f),new Vector2f(0.75f, 0.5f),new Vector2f(0.75f, 0.25f),new Vector2f(0.6875f, 0.25f),new Vector2f(0.6875f, 0.5f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[62] = new ObjQuad(new Vector3f(-0.200001f, 0.209584f, 0.166151f),new Vector3f(-0.200001f, -0.073258f, -0.116692f),new Vector3f(-0.200001f, 0.022297f, -0.212247f),new Vector3f(-0.200001f, 0.30514f, 0.070596f),new Vector2f(0.625f, 0.25f),new Vector2f(0.625f, 0.0f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.5625f, 0.25f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[63] = new ObjQuad(new Vector3f(0.299999f, 0.209584f, 0.166151f),new Vector3f(0.299999f, -0.073258f, -0.116692f),new Vector3f(0.299999f, 0.022297f, -0.212247f),new Vector3f(0.299999f, 0.30514f, 0.070596f),new Vector2f(0.625f, 0.25f),new Vector2f(0.625f, 0.0f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.5625f, 0.25f),new Vector3f(4.0f, -2.0E-6f, 2.0E-6f));
		this.quads[64] = new ObjQuad(new Vector3f(-0.200001f, -0.073258f, -0.116692f),new Vector3f(-0.200001f, 0.209584f, 0.166151f),new Vector3f(-0.300001f, 0.209584f, 0.166151f),new Vector3f(-0.300001f, -0.073258f, -0.116692f),new Vector2f(0.6875f, 0.5f),new Vector2f(0.6875f, 0.25f),new Vector2f(0.625f, 0.25f),new Vector2f(0.625f, 0.5f),new Vector3f(0.0f, -2.828428f, 2.828424f));
		this.quads[65] = new ObjQuad(new Vector3f(-0.300001f, 0.022297f, -0.212247f),new Vector3f(-0.300001f, 0.30514f, 0.070596f),new Vector3f(-0.200001f, 0.30514f, 0.070596f),new Vector3f(-0.200001f, 0.022297f, -0.212247f),new Vector2f(0.5f, 0.5f),new Vector2f(0.5f, 0.25f),new Vector2f(0.5625f, 0.25f),new Vector2f(0.5625f, 0.5f),new Vector3f(-5.0E-6f, 2.828428f, -2.828427f));
		this.quads[66] = new ObjQuad(new Vector3f(-0.300001f, -0.073258f, -0.116692f),new Vector3f(-0.300001f, 0.209584f, 0.166151f),new Vector3f(-0.300001f, 0.30514f, 0.070596f),new Vector3f(-0.300001f, 0.022297f, -0.212247f),new Vector2f(0.75f, 0.5f),new Vector2f(0.75f, 0.25f),new Vector2f(0.6875f, 0.25f),new Vector2f(0.6875f, 0.5f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[67] = new ObjQuad(new Vector3f(0.299999f, -0.073258f, -0.116692f),new Vector3f(0.299999f, 0.209584f, 0.166151f),new Vector3f(0.199999f, 0.209584f, 0.166152f),new Vector3f(0.199999f, -0.073258f, -0.116691f),new Vector2f(0.6875f, 0.5f),new Vector2f(0.6875f, 0.25f),new Vector2f(0.625f, 0.25f),new Vector2f(0.625f, 0.5f),new Vector3f(2.7E-5f, -2.8284302f, 2.828424f));
		this.quads[68] = new ObjQuad(new Vector3f(0.199999f, 0.022297f, -0.212247f),new Vector3f(0.199999f, 0.30514f, 0.070596f),new Vector3f(0.299999f, 0.30514f, 0.070596f),new Vector3f(0.299999f, 0.022297f, -0.212247f),new Vector2f(0.5f, 0.5f),new Vector2f(0.5f, 0.25f),new Vector2f(0.5625f, 0.25f),new Vector2f(0.5625f, 0.5f),new Vector3f(-2.0E-6f, 2.828428f, -2.828424f));
		this.quads[69] = new ObjQuad(new Vector3f(0.199999f, -0.073258f, -0.116691f),new Vector3f(0.199999f, 0.209584f, 0.166152f),new Vector3f(0.199999f, 0.30514f, 0.070596f),new Vector3f(0.199999f, 0.022297f, -0.212247f),new Vector2f(0.75f, 0.5f),new Vector2f(0.75f, 0.25f),new Vector2f(0.6875f, 0.25f),new Vector2f(0.6875f, 0.5f),new Vector3f(-4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		BackUpFrontDown001 other = new BackUpFrontDown001();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

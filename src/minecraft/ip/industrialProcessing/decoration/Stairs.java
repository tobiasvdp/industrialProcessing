package ip.industrialProcessing.decoration;

import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class Stairs extends ObjMesh {

	public Stairs() {
		this.quads = new ObjQuad[42];
		this.quads[0] = new ObjQuad(new Vector3f(-0.5f, 0.8f, 0.0f), new Vector3f(-0.6f, 0.8f, 0.0f), new Vector3f(-0.6f, 1.6f, -0.8f), new Vector3f(-0.5f, 1.6f, -0.8f), new Vector2f(0.707107f, 0.9375f), new Vector2f(0.707107f, 1.0f), new Vector2f(-0.0f, 1.0f), new Vector2f(-0.0f, 0.9375f), new Vector3f(2.0E-6f, -2.828428f, -2.828428f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.5f, 0.0f, 0.8f), new Vector3f(-0.6f, 0.0f, 0.8f), new Vector3f(-0.6f, 0.8f, -0.0f), new Vector3f(-0.5f, 0.8f, -0.0f), new Vector2f(0.823223f, 0.9375f), new Vector2f(0.823223f, 1.0f), new Vector2f(0.116116f, 1.0f), new Vector2f(0.116116f, 0.9375f), new Vector3f(4.0E-6f, -2.828428f, -2.828428f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.5f, 0.0f, 0.8f), new Vector3f(-0.5f, 0.8f, -0.0f), new Vector3f(-0.5f, 0.8f, 0.141421f), new Vector3f(-0.5f, 0.0f, 0.941421f), new Vector2f(1.0f, 0.176777f), new Vector2f(1.0f, 0.883884f), new Vector2f(0.9375f, 0.821384f), new Vector2f(0.9375f, 0.114277f), new Vector3f(4.0f, -1.0E-6f, -1.0E-6f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.6f, 0.8f, 0.141421f), new Vector3f(-0.6f, 0.8f, -0.0f), new Vector3f(-0.6f, 0.0f, 0.8f), new Vector3f(-0.6f, 0.0f, 0.941421f), new Vector2f(0.0625f, 0.821384f), new Vector2f(0.0f, 0.883884f), new Vector2f(0.0f, 0.176777f), new Vector2f(0.0625f, 0.114277f), new Vector3f(-4.0f, -2.0E-6f, -1.0E-6f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.5f, 0.8f, 0.141421f), new Vector3f(-0.6f, 0.8f, 0.141421f), new Vector3f(-0.6f, 0.0f, 0.941421f), new Vector3f(-0.5f, 0.0f, 0.941421f), new Vector2f(0.821384f, 0.9375f), new Vector2f(0.821384f, 1.0f), new Vector2f(0.114277f, 1.0f), new Vector2f(0.114277f, 0.9375f), new Vector3f(4.0E-6f, 2.828428f, 2.828428f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.5f, 0.8f, 0.0f), new Vector3f(-0.5f, 1.6f, -0.8f), new Vector3f(-0.5f, 1.6f, -0.658578f), new Vector3f(-0.5f, 0.8f, 0.141421f), new Vector2f(1.0f, 0.292893f), new Vector2f(1.0f, 1.0f), new Vector2f(0.9375f, 0.9375f), new Vector2f(0.9375f, 0.230393f), new Vector3f(4.0f, 2.0E-6f, 1.0E-6f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.6f, 1.6f, -0.658579f), new Vector3f(-0.6f, 1.6f, -0.8f), new Vector3f(-0.6f, 0.8f, 0.0f), new Vector3f(-0.6f, 0.8f, 0.141422f), new Vector2f(0.0625f, 0.9375f), new Vector2f(0.0f, 1.0f), new Vector2f(0.0f, 0.292893f), new Vector2f(0.0625f, 0.230393f), new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.5f, 1.6f, -0.658578f), new Vector3f(-0.6f, 1.6f, -0.658579f), new Vector3f(-0.6f, 0.8f, 0.141422f), new Vector3f(-0.5f, 0.8f, 0.141421f), new Vector2f(0.9375f, 0.9375f), new Vector2f(0.9375f, 1.0f), new Vector2f(0.230393f, 1.0f), new Vector2f(0.230393f, 0.9375f), new Vector3f(2.0E-6f, 2.828428f, 2.828428f));
		this.quads[8] = new ObjQuad(new Vector3f(-0.5f, 1.6f, -0.1f), new Vector3f(-0.6f, 1.6f, -0.1f), new Vector3f(-0.6f, 1.041422f, -0.1f), new Vector3f(-0.5f, 1.041422f, -0.1f), new Vector2f(1.0f, 0.6875f), new Vector2f(0.9375f, 0.6875f), new Vector2f(0.9375f, 0.338388f), new Vector2f(1.0f, 0.338388f), new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[9] = new ObjQuad(new Vector3f(-0.5f, 1.141422f, -0.2f), new Vector3f(-0.5f, 1.6f, -0.2f), new Vector3f(-0.5f, 1.6f, -0.1f), new Vector3f(-0.5f, 1.041422f, -0.1f), new Vector2f(0.0625f, 0.400888f), new Vector2f(0.0625f, 0.6875f), new Vector2f(-0.0f, 0.6875f), new Vector2f(-0.0f, 0.338388f), new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[10] = new ObjQuad(new Vector3f(-0.6f, 1.6f, -0.2f), new Vector3f(-0.5f, 1.6f, -0.2f), new Vector3f(-0.5f, 1.141422f, -0.2f), new Vector3f(-0.6f, 1.141422f, -0.2f), new Vector2f(0.0625f, 0.6875f), new Vector2f(0.0f, 0.6875f), new Vector2f(0.0f, 0.400888f), new Vector2f(0.0625f, 0.400888f), new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[11] = new ObjQuad(new Vector3f(-0.6f, 1.6f, -0.1f), new Vector3f(-0.6f, 1.6f, -0.2f), new Vector3f(-0.6f, 1.141422f, -0.2f), new Vector3f(-0.6f, 1.041422f, -0.1f), new Vector2f(1.0f, 0.6875f), new Vector2f(0.9375f, 0.6875f), new Vector2f(0.9375f, 0.400888f), new Vector2f(1.0f, 0.338388f), new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[12] = new ObjQuad(new Vector3f(-0.5f, 0.8f, 0.7f), new Vector3f(-0.6f, 0.8f, 0.7f), new Vector3f(-0.6f, 0.241421f, 0.7f), new Vector3f(-0.5f, 0.241422f, 0.7f), new Vector2f(1.0f, 0.6875f), new Vector2f(0.9375f, 0.6875f), new Vector2f(0.9375f, 0.338388f), new Vector2f(1.0f, 0.338388f), new Vector3f(-2.0E-6f, 0.0f, 4.0f));
		this.quads[13] = new ObjQuad(new Vector3f(-0.5f, 0.341422f, 0.6f), new Vector3f(-0.5f, 0.8f, 0.6f), new Vector3f(-0.5f, 0.8f, 0.7f), new Vector3f(-0.5f, 0.241422f, 0.7f), new Vector2f(0.0625f, 0.400888f), new Vector2f(0.0625f, 0.6875f), new Vector2f(-0.0f, 0.6875f), new Vector2f(-0.0f, 0.338388f), new Vector3f(4.0f, 0.0f, 2.0E-6f));
		this.quads[14] = new ObjQuad(new Vector3f(-0.6f, 0.8f, 0.6f), new Vector3f(-0.5f, 0.8f, 0.6f), new Vector3f(-0.5f, 0.341422f, 0.6f), new Vector3f(-0.6f, 0.341421f, 0.6f), new Vector2f(0.0625f, 0.6875f), new Vector2f(0.0f, 0.6875f), new Vector2f(0.0f, 0.400888f), new Vector2f(0.0625f, 0.400888f), new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[15] = new ObjQuad(new Vector3f(-0.6f, 0.8f, 0.7f), new Vector3f(-0.6f, 0.8f, 0.6f), new Vector3f(-0.6f, 0.341421f, 0.6f), new Vector3f(-0.6f, 0.241421f, 0.7f), new Vector2f(1.0f, 0.6875f), new Vector2f(0.9375f, 0.6875f), new Vector2f(0.9375f, 0.400888f), new Vector2f(1.0f, 0.338388f), new Vector3f(-4.0f, 0.0f, -2.0E-6f));
		this.quads[16] = new ObjQuad(new Vector3f(0.6f, 0.8f, 0.0f), new Vector3f(0.5f, 0.8f, 0.0f), new Vector3f(0.5f, 1.6f, -0.8f), new Vector3f(0.6f, 1.6f, -0.8f), new Vector2f(0.707107f, 0.9375f), new Vector2f(0.707107f, 1.0f), new Vector2f(-0.0f, 1.0f), new Vector2f(-0.0f, 0.9375f), new Vector3f(1.0E-6f, -2.828428f, -2.828428f));
		this.quads[17] = new ObjQuad(new Vector3f(0.6f, 0.0f, 0.8f), new Vector3f(0.5f, 0.0f, 0.8f), new Vector3f(0.5f, 0.8f, -0.0f), new Vector3f(0.6f, 0.8f, -0.0f), new Vector2f(0.823223f, 0.9375f), new Vector2f(0.823223f, 1.0f), new Vector2f(0.116116f, 1.0f), new Vector2f(0.116116f, 0.9375f), new Vector3f(3.0E-6f, -2.828428f, -2.828428f));
		this.quads[18] = new ObjQuad(new Vector3f(0.6f, 0.0f, 0.8f), new Vector3f(0.6f, 0.8f, -0.0f), new Vector3f(0.6f, 0.8f, 0.141421f), new Vector3f(0.6f, 0.0f, 0.941421f), new Vector2f(1.0f, 0.176777f), new Vector2f(1.0f, 0.883884f), new Vector2f(0.9375f, 0.821384f), new Vector2f(0.9375f, 0.114277f), new Vector3f(4.0f, 0.0f, -2.0000002E-6f));
		this.quads[19] = new ObjQuad(new Vector3f(0.5f, 0.8f, 0.141421f), new Vector3f(0.5f, 0.8f, -0.0f), new Vector3f(0.5f, 0.0f, 0.8f), new Vector3f(0.5f, 0.0f, 0.941421f), new Vector2f(0.0625f, 0.821384f), new Vector2f(0.0f, 0.883884f), new Vector2f(0.0f, 0.176777f), new Vector2f(0.0625f, 0.114277f), new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[20] = new ObjQuad(new Vector3f(0.6f, 0.8f, 0.141421f), new Vector3f(0.5f, 0.8f, 0.141421f), new Vector3f(0.5f, 0.0f, 0.941421f), new Vector3f(0.6f, 0.0f, 0.941421f), new Vector2f(0.821384f, 0.9375f), new Vector2f(0.821384f, 1.0f), new Vector2f(0.114277f, 1.0f), new Vector2f(0.114277f, 0.9375f), new Vector3f(4.0E-6f, 2.828428f, 2.828428f));
		this.quads[21] = new ObjQuad(new Vector3f(0.6f, 0.8f, 0.0f), new Vector3f(0.6f, 1.6f, -0.8f), new Vector3f(0.6f, 1.6f, -0.658578f), new Vector3f(0.6f, 0.8f, 0.141421f), new Vector2f(1.0f, 0.292893f), new Vector2f(1.0f, 1.0f), new Vector2f(0.9375f, 0.9375f), new Vector2f(0.9375f, 0.230393f), new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[22] = new ObjQuad(new Vector3f(0.5f, 1.6f, -0.658579f), new Vector3f(0.5f, 1.6f, -0.8f), new Vector3f(0.5f, 0.8f, 0.0f), new Vector3f(0.5f, 0.8f, 0.141422f), new Vector2f(0.0625f, 0.9375f), new Vector2f(0.0f, 1.0f), new Vector2f(0.0f, 0.292893f), new Vector2f(0.0625f, 0.230393f), new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[23] = new ObjQuad(new Vector3f(0.6f, 1.6f, -0.658578f), new Vector3f(0.5f, 1.6f, -0.658579f), new Vector3f(0.5f, 0.8f, 0.141422f), new Vector3f(0.6f, 0.8f, 0.141421f), new Vector2f(0.9375f, 0.9375f), new Vector2f(0.9375f, 1.0f), new Vector2f(0.230393f, 1.0f), new Vector2f(0.230393f, 0.9375f), new Vector3f(2.0E-6f, 2.828428f, 2.828428f));
		this.quads[24] = new ObjQuad(new Vector3f(0.6f, 1.6f, -0.1f), new Vector3f(0.5f, 1.6f, -0.1f), new Vector3f(0.5f, 1.041422f, -0.1f), new Vector3f(0.6f, 1.041422f, -0.1f), new Vector2f(1.0f, 0.6875f), new Vector2f(0.9375f, 0.6875f), new Vector2f(0.9375f, 0.338388f), new Vector2f(1.0f, 0.338388f), new Vector3f(4.0E-6f, 0.0f, 4.0f));
		this.quads[25] = new ObjQuad(new Vector3f(0.6f, 1.141422f, -0.2f), new Vector3f(0.6f, 1.6f, -0.2f), new Vector3f(0.6f, 1.6f, -0.1f), new Vector3f(0.6f, 1.041422f, -0.1f), new Vector2f(0.0625f, 0.400888f), new Vector2f(0.0625f, 0.6875f), new Vector2f(-0.0f, 0.6875f), new Vector2f(-0.0f, 0.338388f), new Vector3f(4.0f, 0.0f, -2.0E-6f));
		this.quads[26] = new ObjQuad(new Vector3f(0.5f, 1.6f, -0.2f), new Vector3f(0.6f, 1.6f, -0.2f), new Vector3f(0.6f, 1.141422f, -0.2f), new Vector3f(0.5f, 1.141422f, -0.2f), new Vector2f(0.0625f, 0.6875f), new Vector2f(0.0f, 0.6875f), new Vector2f(0.0f, 0.400888f), new Vector2f(0.0625f, 0.400888f), new Vector3f(-4.0E-6f, 0.0f, -4.0f));
		this.quads[27] = new ObjQuad(new Vector3f(0.5f, 1.6f, -0.1f), new Vector3f(0.5f, 1.6f, -0.2f), new Vector3f(0.5f, 1.141422f, -0.2f), new Vector3f(0.5f, 1.041422f, -0.1f), new Vector2f(1.0f, 0.6875f), new Vector2f(0.9375f, 0.6875f), new Vector2f(0.9375f, 0.400888f), new Vector2f(1.0f, 0.338388f), new Vector3f(-4.0f, 0.0f, 2.0E-6f));
		this.quads[28] = new ObjQuad(new Vector3f(0.6f, 0.8f, 0.7f), new Vector3f(0.5f, 0.8f, 0.7f), new Vector3f(0.5f, 0.241421f, 0.7f), new Vector3f(0.6f, 0.241421f, 0.7f), new Vector2f(1.0f, 0.6875f), new Vector2f(0.9375f, 0.6875f), new Vector2f(0.9375f, 0.338388f), new Vector2f(1.0f, 0.338388f), new Vector3f(-2.0E-6f, 0.0f, 4.0f));
		this.quads[29] = new ObjQuad(new Vector3f(0.6f, 0.341421f, 0.6f), new Vector3f(0.6f, 0.8f, 0.6f), new Vector3f(0.6f, 0.8f, 0.7f), new Vector3f(0.6f, 0.241421f, 0.7f), new Vector2f(0.0625f, 0.400888f), new Vector2f(0.0625f, 0.6875f), new Vector2f(-0.0f, 0.6875f), new Vector2f(-0.0f, 0.338388f), new Vector3f(4.0f, 0.0f, 3.0E-6f));
		this.quads[30] = new ObjQuad(new Vector3f(0.5f, 0.8f, 0.6f), new Vector3f(0.6f, 0.8f, 0.6f), new Vector3f(0.6f, 0.341421f, 0.6f), new Vector3f(0.5f, 0.341421f, 0.6f), new Vector2f(0.0625f, 0.6875f), new Vector2f(0.0f, 0.6875f), new Vector2f(0.0f, 0.400888f), new Vector2f(0.0625f, 0.400888f), new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[31] = new ObjQuad(new Vector3f(0.5f, 0.8f, 0.7f), new Vector3f(0.5f, 0.8f, 0.6f), new Vector3f(0.5f, 0.341421f, 0.6f), new Vector3f(0.5f, 0.241421f, 0.7f), new Vector2f(1.0f, 0.6875f), new Vector2f(0.9375f, 0.6875f), new Vector2f(0.9375f, 0.400888f), new Vector2f(1.0f, 0.338388f), new Vector3f(-4.0f, 0.0f, -2.0E-6f));
		this.quads[32] = new ObjQuad(new Vector3f(-0.6f, 0.0f, 0.941421f), new Vector3f(-0.6f, 0.0f, 0.8f), new Vector3f(-0.5f, 0.0f, 0.8f), new Vector3f(-0.5f, 0.0f, 0.941421f), new Vector2f(0.544194f, 0.0f), new Vector2f(0.455806f, 0.0f), new Vector2f(0.455806f, 0.0625f), new Vector2f(0.544194f, 0.0625f), new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[33] = new ObjQuad(new Vector3f(0.6f, 0.0f, 0.941421f), new Vector3f(0.5f, 0.0f, 0.941421f), new Vector3f(0.5f, 0.0f, 0.8f), new Vector3f(0.6f, 0.0f, 0.8f), new Vector2f(0.544194f, 0.0f), new Vector2f(0.544194f, 0.0625f), new Vector2f(0.455806f, 0.0625f), new Vector2f(0.455806f, -0.0f), new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[34] = new ObjQuad(new Vector3f(-0.6f, 1.6f, -0.8f), new Vector3f(-0.6f, 1.7f, -0.8f), new Vector3f(0.6f, 1.7f, -0.8f), new Vector3f(0.6f, 1.6f, -0.8f), new Vector2f(0.875f, 0.75f), new Vector2f(0.875f, 0.8125f), new Vector2f(0.125f, 0.8125f), new Vector2f(0.125f, 0.75f), new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[35] = new ObjQuad(new Vector3f(0.6f, 1.6f, -0.8f), new Vector3f(0.6f, 1.6f, -0.0f), new Vector3f(-0.6f, 1.6f, -0.0f), new Vector3f(-0.6f, 1.6f, -0.8f), new Vector2f(0.125f, 0.5f), new Vector2f(0.125f, -0.0f), new Vector2f(0.875f, 0.0f), new Vector2f(0.875f, 0.5f), new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[36] = new ObjQuad(new Vector3f(0.6f, 1.7f, -0.0f), new Vector3f(0.6f, 1.7f, -0.8f), new Vector3f(-0.6f, 1.7f, -0.8f), new Vector3f(-0.6f, 1.7f, -0.0f), new Vector2f(0.875f, -0.0f), new Vector2f(0.875f, 0.5f), new Vector2f(0.125f, 0.5f), new Vector2f(0.125f, 0.0f), new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[37] = new ObjQuad(new Vector3f(0.6f, 1.6f, -0.0f), new Vector3f(0.6f, 1.7f, -0.0f), new Vector3f(-0.6f, 1.7f, -0.0f), new Vector3f(-0.6f, 1.6f, -0.0f), new Vector2f(0.875f, 0.9375f), new Vector2f(0.875f, 1.0f), new Vector2f(0.125f, 1.0f), new Vector2f(0.125f, 0.9375f), new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[38] = new ObjQuad(new Vector3f(-0.6f, 0.8f, -0.0f), new Vector3f(-0.6f, 0.9f, -0.0f), new Vector3f(0.6f, 0.9f, -0.0f), new Vector3f(0.6f, 0.8f, -0.0f), new Vector2f(0.875f, 0.75f), new Vector2f(0.875f, 0.8125f), new Vector2f(0.125f, 0.8125f), new Vector2f(0.125f, 0.75f), new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[39] = new ObjQuad(new Vector3f(0.6f, 0.8f, -0.0f), new Vector3f(0.6f, 0.8f, 0.8f), new Vector3f(-0.6f, 0.8f, 0.8f), new Vector3f(-0.6f, 0.8f, -0.0f), new Vector2f(0.125f, 0.5f), new Vector2f(0.125f, -0.0f), new Vector2f(0.875f, 0.0f), new Vector2f(0.875f, 0.5f), new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[40] = new ObjQuad(new Vector3f(0.6f, 0.9f, 0.8f), new Vector3f(0.6f, 0.9f, -0.0f), new Vector3f(-0.6f, 0.9f, -0.0f), new Vector3f(-0.6f, 0.9f, 0.8f), new Vector2f(0.875f, -0.0f), new Vector2f(0.875f, 0.5f), new Vector2f(0.125f, 0.5f), new Vector2f(0.125f, 0.0f), new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[41] = new ObjQuad(new Vector3f(0.6f, 0.8f, 0.8f), new Vector3f(0.6f, 0.9f, 0.8f), new Vector3f(-0.6f, 0.9f, 0.8f), new Vector3f(-0.6f, 0.8f, 0.8f), new Vector2f(0.875f, 0.9375f), new Vector2f(0.875f, 1.0f), new Vector2f(0.125f, 1.0f), new Vector2f(0.125f, 0.9375f), new Vector3f(0.0f, 0.0f, 4.0f));
	}

	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Stairs other = new Stairs();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}
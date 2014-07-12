package mod.industrialProcessing.block.platforms;

import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class StairsHandRail1 extends ObjMesh {

	public StairsHandRail1() {
		this.quads = new ObjQuad[44];
		this.quads[0] = new ObjQuad(new Vector3f(0.8f, 1.5f, -0.45f), new Vector3f(0.8f, 2.05f, -0.45f), new Vector3f(0.8f, 1.95f, -0.35f), new Vector3f(0.8f, 1.5f, -0.35f), new Vector2f(0.0625f, 0.0f), new Vector2f(0.0625f, 0.34375f), new Vector2f(-0.0f, 0.28125f), new Vector2f(-0.0f, 0.0f), new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.7f, 1.6f, -0.45f), new Vector3f(0.7f, 2.05f, -0.45f), new Vector3f(0.8f, 2.05f, -0.45f), new Vector3f(0.8f, 1.5f, -0.45f), new Vector2f(0.0625f, 0.0625f), new Vector2f(0.0625f, 0.34375f), new Vector2f(0.0f, 0.34375f), new Vector2f(0.0f, 0.0f), new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.7f, 1.6f, -0.45f), new Vector3f(0.7f, 1.6f, -0.35f), new Vector3f(0.7f, 1.95f, -0.35f), new Vector3f(0.7f, 2.05f, -0.45f), new Vector2f(0.9375f, 0.0625f), new Vector2f(1.0f, 0.0625f), new Vector2f(1.0f, 0.28125f), new Vector2f(0.9375f, 0.34375f), new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.7f, 1.6f, -0.35f), new Vector3f(0.8f, 1.5f, -0.35f), new Vector3f(0.8f, 1.95f, -0.35f), new Vector3f(0.7f, 1.95f, -0.35f), new Vector2f(0.9375f, 0.0625f), new Vector2f(1.0f, 0.0f), new Vector2f(1.0f, 0.28125f), new Vector2f(0.9375f, 0.28125f), new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.8f, 1.5f, -0.35f), new Vector3f(0.7f, 1.6f, -0.35f), new Vector3f(0.2875f, 1.6f, -0.35f), new Vector3f(0.2875f, 1.5f, -0.35f), new Vector2f(1.0f, 0.0f), new Vector2f(0.9375f, 0.0625f), new Vector2f(0.679687f, 0.0625f), new Vector2f(0.679687f, 0.0f), new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[5] = new ObjQuad(new Vector3f(0.7f, 1.6f, -0.45f), new Vector3f(0.8f, 1.5f, -0.45f), new Vector3f(0.2875f, 1.5f, -0.45f), new Vector3f(0.2875f, 1.6f, -0.45f), new Vector2f(0.0625f, 0.0625f), new Vector2f(0.0f, 0.0f), new Vector2f(0.320313f, 0.0f), new Vector2f(0.320313f, 0.0625f), new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[6] = new ObjQuad(new Vector3f(0.8f, 1.5f, -0.45f), new Vector3f(0.8f, 1.5f, -0.35f), new Vector3f(0.2875f, 1.5f, -0.35f), new Vector3f(0.2875f, 1.5f, -0.45f), new Vector2f(0.9375f, 0.0f), new Vector2f(1.0f, 0.0f), new Vector2f(1.0f, 0.320313f), new Vector2f(0.9375f, 0.320313f), new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(0.2875f, 1.6f, -0.45f), new Vector3f(0.2875f, 1.5f, -0.45f), new Vector3f(0.2875f, 1.5f, -0.35f), new Vector3f(0.2875f, 1.6f, -0.35f), new Vector2f(0.9375f, 0.0625f), new Vector2f(0.9375f, 0.0f), new Vector2f(1.0f, 0.0f), new Vector2f(1.0f, 0.0625f), new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(0.8f, 0.7f, 0.35f), new Vector3f(0.8f, 1.25f, 0.35f), new Vector3f(0.8f, 1.15f, 0.45f), new Vector3f(0.8f, 0.7f, 0.45f), new Vector2f(0.0625f, 0.0f), new Vector2f(0.0625f, 0.34375f), new Vector2f(-0.0f, 0.28125f), new Vector2f(-0.0f, 0.0f), new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[9] = new ObjQuad(new Vector3f(0.7f, 0.8f, 0.35f), new Vector3f(0.7f, 1.25f, 0.35f), new Vector3f(0.8f, 1.25f, 0.35f), new Vector3f(0.8f, 0.7f, 0.35f), new Vector2f(0.0625f, 0.0625f), new Vector2f(0.0625f, 0.34375f), new Vector2f(0.0f, 0.34375f), new Vector2f(0.0f, 0.0f), new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[10] = new ObjQuad(new Vector3f(0.7f, 0.8f, 0.35f), new Vector3f(0.7f, 0.8f, 0.45f), new Vector3f(0.7f, 1.15f, 0.45f), new Vector3f(0.7f, 1.25f, 0.35f), new Vector2f(0.9375f, 0.0625f), new Vector2f(1.0f, 0.0625f), new Vector2f(1.0f, 0.28125f), new Vector2f(0.9375f, 0.34375f), new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[11] = new ObjQuad(new Vector3f(0.7f, 0.8f, 0.45f), new Vector3f(0.8f, 0.7f, 0.45f), new Vector3f(0.8f, 1.15f, 0.45f), new Vector3f(0.7f, 1.15f, 0.45f), new Vector2f(0.9375f, 0.0625f), new Vector2f(1.0f, 0.0f), new Vector2f(1.0f, 0.28125f), new Vector2f(0.9375f, 0.28125f), new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[12] = new ObjQuad(new Vector3f(0.8f, 0.7f, 0.45f), new Vector3f(0.7f, 0.8f, 0.45f), new Vector3f(0.2875f, 0.8f, 0.45f), new Vector3f(0.2875f, 0.7f, 0.45f), new Vector2f(1.0f, 0.0f), new Vector2f(0.9375f, 0.0625f), new Vector2f(0.679687f, 0.0625f), new Vector2f(0.679687f, 0.0f), new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[13] = new ObjQuad(new Vector3f(0.7f, 0.8f, 0.35f), new Vector3f(0.8f, 0.7f, 0.35f), new Vector3f(0.2875f, 0.7f, 0.35f), new Vector3f(0.2875f, 0.8f, 0.35f), new Vector2f(0.0625f, 0.0625f), new Vector2f(0.0f, 0.0f), new Vector2f(0.320313f, 0.0f), new Vector2f(0.320313f, 0.0625f), new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[14] = new ObjQuad(new Vector3f(0.8f, 0.7f, 0.35f), new Vector3f(0.8f, 0.7f, 0.45f), new Vector3f(0.2875f, 0.7f, 0.45f), new Vector3f(0.2875f, 0.7f, 0.35f), new Vector2f(0.9375f, 0.0f), new Vector2f(1.0f, 0.0f), new Vector2f(1.0f, 0.320313f), new Vector2f(0.9375f, 0.320313f), new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[15] = new ObjQuad(new Vector3f(0.2875f, 0.8f, 0.35f), new Vector3f(0.2875f, 0.7f, 0.35f), new Vector3f(0.2875f, 0.7f, 0.45f), new Vector3f(0.2875f, 0.8f, 0.45f), new Vector2f(0.9375f, 0.0625f), new Vector2f(0.9375f, 0.0f), new Vector2f(1.0f, 0.0f), new Vector2f(1.0f, 0.0625f), new Vector3f(-4.0f, 0.0f, -4.0E-6f));
		this.quads[16] = new ObjQuad(new Vector3f(0.8f, 2.54375f, -0.446875f), new Vector3f(0.8f, 2.45f, -0.35f), new Vector3f(0.8f, 2.05f, -0.35f), new Vector3f(0.8f, 2.15f, -0.45f), new Vector2f(0.060547f, 0.5625f), new Vector2f(-0.0f, 0.503906f), new Vector2f(-0.0f, 0.253906f), new Vector2f(0.0625f, 0.316406f), new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[17] = new ObjQuad(new Vector3f(0.7f, 2.54375f, -0.446875f), new Vector3f(0.8f, 2.54375f, -0.446875f), new Vector3f(0.8f, 2.15f, -0.45f), new Vector3f(0.7f, 2.15f, -0.45f), new Vector2f(0.0625f, 0.5625f), new Vector2f(0.0f, 0.5625f), new Vector2f(0.0f, 0.316406f), new Vector2f(0.0625f, 0.316406f), new Vector3f(0.0f, 0.031744f, -3.999876f));
		this.quads[18] = new ObjQuad(new Vector3f(0.7f, 2.45f, -0.35f), new Vector3f(0.7f, 2.54375f, -0.446875f), new Vector3f(0.7f, 2.15f, -0.45f), new Vector3f(0.7f, 2.05f, -0.35f), new Vector2f(1.0f, 0.503906f), new Vector2f(0.939453f, 0.5625f), new Vector2f(0.9375f, 0.316406f), new Vector2f(1.0f, 0.253906f), new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[19] = new ObjQuad(new Vector3f(0.8f, 2.45f, -0.35f), new Vector3f(0.7f, 2.45f, -0.35f), new Vector3f(0.7f, 2.05f, -0.35f), new Vector3f(0.8f, 2.05f, -0.35f), new Vector2f(1.0f, 0.503906f), new Vector2f(0.9375f, 0.503906f), new Vector2f(0.9375f, 0.253906f), new Vector2f(1.0f, 0.253906f), new Vector3f(2.0E-6f, 0.0f, 4.0f));
		this.quads[20] = new ObjQuad(new Vector3f(0.8f, 1.74375f, 0.353125f), new Vector3f(0.8f, 1.65f, 0.45f), new Vector3f(0.8f, 1.25f, 0.45f), new Vector3f(0.8f, 1.35f, 0.35f), new Vector2f(0.060547f, 0.5625f), new Vector2f(-0.0f, 0.503906f), new Vector2f(-0.0f, 0.253906f), new Vector2f(0.0625f, 0.316406f), new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[21] = new ObjQuad(new Vector3f(0.7f, 1.74375f, 0.353125f), new Vector3f(0.8f, 1.74375f, 0.353125f), new Vector3f(0.8f, 1.35f, 0.35f), new Vector3f(0.7f, 1.35f, 0.35f), new Vector2f(0.0625f, 0.5625f), new Vector2f(0.0f, 0.5625f), new Vector2f(0.0f, 0.316406f), new Vector2f(0.0625f, 0.316406f), new Vector3f(0.0f, 0.031744f, -3.999876f));
		this.quads[22] = new ObjQuad(new Vector3f(0.7f, 1.65f, 0.45f), new Vector3f(0.7f, 1.74375f, 0.353125f), new Vector3f(0.7f, 1.35f, 0.35f), new Vector3f(0.7f, 1.25f, 0.45f), new Vector2f(1.0f, 0.503906f), new Vector2f(0.939453f, 0.5625f), new Vector2f(0.9375f, 0.316406f), new Vector2f(1.0f, 0.253906f), new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[23] = new ObjQuad(new Vector3f(0.8f, 1.65f, 0.45f), new Vector3f(0.7f, 1.65f, 0.45f), new Vector3f(0.7f, 1.25f, 0.45f), new Vector3f(0.8f, 1.25f, 0.45f), new Vector2f(1.0f, 0.503906f), new Vector2f(0.9375f, 0.503906f), new Vector2f(0.9375f, 0.253906f), new Vector2f(1.0f, 0.253906f), new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[24] = new ObjQuad(new Vector3f(0.7f, 1.7f, -0.0f), new Vector3f(0.8f, 1.7f, -0.0f), new Vector3f(0.8f, 2.5f, -0.8f), new Vector3f(0.7f, 2.5f, -0.8f), new Vector2f(0.375f, 0.0625f), new Vector2f(0.375f, 0.0f), new Vector2f(0.875f, -0.0f), new Vector2f(0.875f, 0.0625f), new Vector3f(0.0f, 2.828428f, 2.828428f));
		this.quads[25] = new ObjQuad(new Vector3f(0.7f, 2.2f, -0.0f), new Vector3f(0.8f, 2.2f, -0.0f), new Vector3f(0.8f, 3.0f, -0.8f), new Vector3f(0.7f, 3.0f, -0.8f), new Vector2f(0.375f, 0.0625f), new Vector2f(0.375f, 0.0f), new Vector2f(0.875f, -0.0f), new Vector2f(0.875f, 0.0625f), new Vector3f(0.0f, 2.828428f, 2.828428f));
		this.quads[26] = new ObjQuad(new Vector3f(0.7f, 2.5f, -0.8f), new Vector3f(0.7f, 2.4f, -0.8f), new Vector3f(0.7f, 1.6f, -0.0f), new Vector3f(0.7f, 1.7f, -0.0f), new Vector2f(0.125f, 0.0625f), new Vector2f(0.125f, 0.0f), new Vector2f(0.625f, 0.0f), new Vector2f(0.625f, 0.0625f), new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[27] = new ObjQuad(new Vector3f(0.8f, 2.4f, -0.8f), new Vector3f(0.8f, 2.5f, -0.8f), new Vector3f(0.8f, 1.7f, -0.0f), new Vector3f(0.8f, 1.6f, 0.0f), new Vector2f(0.875f, 0.0f), new Vector2f(0.875f, 0.0625f), new Vector2f(0.375f, 0.0625f), new Vector2f(0.375f, 0.0f), new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[28] = new ObjQuad(new Vector3f(0.7f, 2.4f, -0.8f), new Vector3f(0.8f, 2.4f, -0.8f), new Vector3f(0.8f, 1.6f, 0.0f), new Vector3f(0.7f, 1.6f, -0.0f), new Vector2f(0.125f, 0.0625f), new Vector2f(0.125f, -0.0f), new Vector2f(0.625f, 0.0f), new Vector2f(0.625f, 0.0625f), new Vector3f(2.0E-6f, -2.828428f, -2.828428f));
		this.quads[29] = new ObjQuad(new Vector3f(0.7f, 3.0f, -0.8f), new Vector3f(0.7f, 2.9f, -0.8f), new Vector3f(0.7f, 2.1f, -0.0f), new Vector3f(0.7f, 2.2f, -0.0f), new Vector2f(0.125f, 1.0f), new Vector2f(0.125f, 0.9375f), new Vector2f(0.625f, 0.9375f), new Vector2f(0.625f, 1.0f), new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[30] = new ObjQuad(new Vector3f(0.8f, 2.9f, -0.8f), new Vector3f(0.8f, 3.0f, -0.8f), new Vector3f(0.8f, 2.2f, -0.0f), new Vector3f(0.8f, 2.1f, -0.0f), new Vector2f(0.875f, 0.9375f), new Vector2f(0.875f, 1.0f), new Vector2f(0.375f, 1.0f), new Vector2f(0.375f, 0.9375f), new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[31] = new ObjQuad(new Vector3f(0.7f, 2.9f, -0.8f), new Vector3f(0.8f, 2.9f, -0.8f), new Vector3f(0.8f, 2.1f, -0.0f), new Vector3f(0.7f, 2.1f, -0.0f), new Vector2f(0.125f, 0.0625f), new Vector2f(0.125f, -0.0f), new Vector2f(0.625f, 0.0f), new Vector2f(0.625f, 0.0625f), new Vector3f(0.0f, -2.828428f, -2.828428f));
		this.quads[32] = new ObjQuad(new Vector3f(0.7f, 0.9f, 0.8f), new Vector3f(0.8f, 0.9f, 0.8f), new Vector3f(0.8f, 1.7f, -0.0f), new Vector3f(0.7f, 1.7f, -0.0f), new Vector2f(0.375f, 0.0625f), new Vector2f(0.375f, 0.0f), new Vector2f(0.875f, -0.0f), new Vector2f(0.875f, 0.0625f), new Vector3f(0.0f, 2.828428f, 2.828428f));
		this.quads[33] = new ObjQuad(new Vector3f(0.7f, 1.4f, 0.8f), new Vector3f(0.8f, 1.4f, 0.8f), new Vector3f(0.8f, 2.2f, -0.0f), new Vector3f(0.7f, 2.2f, -0.0f), new Vector2f(0.375f, 0.0625f), new Vector2f(0.375f, 0.0f), new Vector2f(0.875f, -0.0f), new Vector2f(0.875f, 0.0625f), new Vector3f(2.0E-6f, 2.828428f, 2.828428f));
		this.quads[34] = new ObjQuad(new Vector3f(0.7f, 1.7f, -0.0f), new Vector3f(0.7f, 1.6f, -0.0f), new Vector3f(0.7f, 0.8f, 0.8f), new Vector3f(0.7f, 0.9f, 0.8f), new Vector2f(0.125f, 0.0625f), new Vector2f(0.125f, 0.0f), new Vector2f(0.625f, 0.0f), new Vector2f(0.625f, 0.0625f), new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[35] = new ObjQuad(new Vector3f(0.8f, 1.6f, 0.0f), new Vector3f(0.8f, 1.7f, -0.0f), new Vector3f(0.8f, 0.9f, 0.8f), new Vector3f(0.8f, 0.8f, 0.8f), new Vector2f(0.875f, 0.0f), new Vector2f(0.875f, 0.0625f), new Vector2f(0.375f, 0.0625f), new Vector2f(0.375f, 0.0f), new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[36] = new ObjQuad(new Vector3f(0.7f, 1.6f, -0.0f), new Vector3f(0.8f, 1.6f, 0.0f), new Vector3f(0.8f, 0.8f, 0.8f), new Vector3f(0.7f, 0.8f, 0.8f), new Vector2f(0.125f, 0.0625f), new Vector2f(0.125f, -0.0f), new Vector2f(0.625f, 0.0f), new Vector2f(0.625f, 0.0625f), new Vector3f(4.0E-6f, -2.828428f, -2.828428f));
		this.quads[37] = new ObjQuad(new Vector3f(0.7f, 2.2f, -0.0f), new Vector3f(0.7f, 2.1f, -0.0f), new Vector3f(0.7f, 1.3f, 0.8f), new Vector3f(0.7f, 1.4f, 0.8f), new Vector2f(0.125f, 1.0f), new Vector2f(0.125f, 0.9375f), new Vector2f(0.625f, 0.9375f), new Vector2f(0.625f, 1.0f), new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[38] = new ObjQuad(new Vector3f(0.8f, 2.1f, -0.0f), new Vector3f(0.8f, 2.2f, -0.0f), new Vector3f(0.8f, 1.4f, 0.8f), new Vector3f(0.8f, 1.3f, 0.8f), new Vector2f(0.875f, 0.9375f), new Vector2f(0.875f, 1.0f), new Vector2f(0.375f, 1.0f), new Vector2f(0.375f, 0.9375f), new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[39] = new ObjQuad(new Vector3f(0.7f, 2.1f, -0.0f), new Vector3f(0.8f, 2.1f, -0.0f), new Vector3f(0.8f, 1.3f, 0.8f), new Vector3f(0.7f, 1.3f, 0.8f), new Vector2f(0.125f, 0.0625f), new Vector2f(0.125f, -0.0f), new Vector2f(0.625f, 0.0f), new Vector2f(0.625f, 0.0625f), new Vector3f(2.0E-6f, -2.828428f, -2.828428f));
		this.quads[40] = new ObjQuad(new Vector3f(0.7f, 0.8f, 0.8f), new Vector3f(0.8f, 0.8f, 0.8f), new Vector3f(0.8f, 0.9f, 0.8f), new Vector3f(0.7f, 0.9f, 0.8f), new Vector2f(0.9375f, 0.46875f), new Vector2f(1.0f, 0.46875f), new Vector2f(1.0f, 0.53125f), new Vector2f(0.9375f, 0.53125f), new Vector3f(-4.0E-6f, -4.0E-6f, 4.0f));
		this.quads[41] = new ObjQuad(new Vector3f(0.7f, 1.3f, 0.8f), new Vector3f(0.8f, 1.3f, 0.8f), new Vector3f(0.8f, 1.4f, 0.8f), new Vector3f(0.7f, 1.4f, 0.8f), new Vector2f(0.9375f, 0.46875f), new Vector2f(1.0f, 0.46875f), new Vector2f(1.0f, 0.53125f), new Vector2f(0.9375f, 0.53125f), new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[42] = new ObjQuad(new Vector3f(0.8f, 2.5f, -0.8f), new Vector3f(0.8f, 2.4f, -0.8f), new Vector3f(0.7f, 2.4f, -0.8f), new Vector3f(0.7f, 2.5f, -0.8f), new Vector2f(0.9375f, 0.375f), new Vector2f(0.9375f, 0.3125f), new Vector2f(1.0f, 0.3125f), new Vector2f(1.0f, 0.375f), new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[43] = new ObjQuad(new Vector3f(0.8f, 3.0f, -0.8f), new Vector3f(0.8f, 2.9f, -0.8f), new Vector3f(0.7f, 2.9f, -0.8f), new Vector3f(0.7f, 3.0f, -0.8f), new Vector2f(0.9375f, 0.6875f), new Vector2f(0.9375f, 0.625f), new Vector2f(1.0f, 0.625f), new Vector2f(1.0f, 0.6875f), new Vector3f(0.0f, 0.0f, -4.0f));
	}

	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		StairsHandRail1 other = new StairsHandRail1();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}

}

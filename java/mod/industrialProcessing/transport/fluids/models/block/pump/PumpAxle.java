package mod.industrialProcessing.transport.fluids.models.block.pump;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class PumpAxle extends ObjMesh{
	public PumpAxle(){
		this.quads = new ObjQuad[33];
		this.quads[0] = new ObjQuad(new Vector3f(-0.8f, 0.8f, 0.1f),new Vector3f(-0.8f, 0.886603f, 0.05f),new Vector3f(-0.8f, 0.886603f, -0.05f),new Vector3f(-0.8f, 0.713398f, -0.05f),new Vector2f(0.5625f, 0.499999f),new Vector2f(0.53125f, 0.554126f),new Vector2f(0.46875f, 0.554126f),new Vector2f(0.46875f, 0.445873f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.8f, 0.886603f, -0.05f),new Vector3f(-0.8f, 0.8f, -0.1f),new Vector3f(-0.8f, 0.713398f, -0.05f),new Vector2f(0.46875f, 0.554126f),new Vector2f(0.4375f, 0.499999f),new Vector2f(0.46875f, 0.445873f),new Vector3f(-3.0f, 0.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.8f, 0.713398f, 0.05f),new Vector3f(-0.8f, 0.8f, 0.1f),new Vector3f(-0.8f, 0.713398f, -0.05f),new Vector2f(0.53125f, 0.445873f),new Vector2f(0.5625f, 0.499999f),new Vector2f(0.46875f, 0.445873f),new Vector3f(-3.0f, 0.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.75f, 0.8f, 0.15f),new Vector3f(-0.75f, 0.929904f, 0.075f),new Vector3f(-0.85f, 0.929904f, 0.075f),new Vector3f(-0.85f, 0.8f, 0.15f),new Vector2f(0.499999f, 0.875f),new Vector2f(0.581189f, 0.875f),new Vector2f(0.581189f, 0.9375f),new Vector2f(0.499999f, 0.9375f),new Vector3f(0.0f, 2.0f, 3.4641f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.75f, 0.929904f, 0.075f),new Vector3f(-0.75f, 0.929904f, -0.075f),new Vector3f(-0.85f, 0.929905f, -0.074997f),new Vector3f(-0.85f, 0.929904f, 0.075f),new Vector2f(0.453125f, 0.875f),new Vector2f(0.546875f, 0.875f),new Vector2f(0.546873f, 0.9375f),new Vector2f(0.453125f, 0.9375f),new Vector3f(3.2E-5f, 4.0f, 2.0E-5f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.75f, 0.929904f, -0.075f),new Vector3f(-0.75f, 0.8f, -0.15f),new Vector3f(-0.85f, 0.800003f, -0.15f),new Vector3f(-0.85f, 0.929905f, -0.074997f),new Vector2f(0.418811f, 0.875f),new Vector2f(0.5f, 0.875f),new Vector2f(0.499999f, 0.9375f),new Vector2f(0.41881f, 0.9375f),new Vector3f(0.0f, 2.000036f, -3.46408f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.75f, 0.8f, -0.15f),new Vector3f(-0.75f, 0.670096f, -0.075f),new Vector3f(-0.85f, 0.670096f, -0.075f),new Vector3f(-0.85f, 0.800003f, -0.15f),new Vector2f(0.5f, 0.875f),new Vector2f(0.58119f, 0.875f),new Vector2f(0.58119f, 0.9375f),new Vector2f(0.499999f, 0.9375f),new Vector3f(-3.2E-5f, -1.99998f, -3.464112f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.75f, 0.670096f, -0.075f),new Vector3f(-0.75f, 0.670096f, 0.075f),new Vector3f(-0.85f, 0.670096f, 0.075f),new Vector3f(-0.85f, 0.670096f, -0.075f),new Vector2f(0.453125f, 0.875f),new Vector2f(0.546875f, 0.875f),new Vector2f(0.546875f, 0.9375f),new Vector2f(0.453125f, 0.9375f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(-0.75f, 0.670096f, 0.075f),new Vector3f(-0.75f, 0.8f, 0.15f),new Vector3f(-0.85f, 0.8f, 0.15f),new Vector3f(-0.85f, 0.670096f, 0.075f),new Vector2f(0.41881f, 0.875f),new Vector2f(0.499999f, 0.875f),new Vector2f(0.499999f, 0.9375f),new Vector2f(0.41881f, 0.9375f),new Vector3f(0.0f, -2.0f, 3.4641f));
		this.quads[9] = new ObjQuad(new Vector3f(-0.75f, 0.8f, 0.1f),new Vector3f(-0.75f, 0.886603f, 0.05f),new Vector3f(-0.75f, 0.929904f, 0.075f),new Vector3f(-0.75f, 0.8f, 0.15f),new Vector2f(0.4375f, 0.499999f),new Vector2f(0.46875f, 0.554126f),new Vector2f(0.453125f, 0.581189f),new Vector2f(0.40625f, 0.499999f),new Vector3f(4.0f, 4.0E-6f, 4.0E-6f));
		this.quads[10] = new ObjQuad(new Vector3f(-0.75f, 0.886603f, 0.05f),new Vector3f(-0.75f, 0.886603f, -0.05f),new Vector3f(-0.75f, 0.929904f, -0.075f),new Vector3f(-0.75f, 0.929904f, 0.075f),new Vector2f(0.46875f, 0.554126f),new Vector2f(0.53125f, 0.554126f),new Vector2f(0.546875f, 0.581189f),new Vector2f(0.453125f, 0.581189f),new Vector3f(4.0f, 4.0E-6f, 0.0f));
		this.quads[11] = new ObjQuad(new Vector3f(-0.75f, 0.886603f, -0.05f),new Vector3f(-0.75f, 0.8f, -0.1f),new Vector3f(-0.75f, 0.8f, -0.15f),new Vector3f(-0.75f, 0.929904f, -0.075f),new Vector2f(0.53125f, 0.554126f),new Vector2f(0.5625f, 0.499999f),new Vector2f(0.59375f, 0.499999f),new Vector2f(0.546875f, 0.581189f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[12] = new ObjQuad(new Vector3f(-0.75f, 0.8f, -0.1f),new Vector3f(-0.75f, 0.713398f, -0.05f),new Vector3f(-0.75f, 0.670096f, -0.075f),new Vector3f(-0.75f, 0.8f, -0.15f),new Vector2f(0.5625f, 0.499999f),new Vector2f(0.53125f, 0.445873f),new Vector2f(0.546875f, 0.41881f),new Vector2f(0.59375f, 0.499999f),new Vector3f(4.0f, 4.0E-6f, 4.0E-6f));
		this.quads[13] = new ObjQuad(new Vector3f(-0.75f, 0.713398f, -0.05f),new Vector3f(-0.75f, 0.713398f, 0.05f),new Vector3f(-0.75f, 0.670096f, 0.075f),new Vector3f(-0.75f, 0.670096f, -0.075f),new Vector2f(0.53125f, 0.445873f),new Vector2f(0.46875f, 0.445873f),new Vector2f(0.453125f, 0.41881f),new Vector2f(0.546875f, 0.41881f),new Vector3f(4.0f, 4.0E-6f, 0.0f));
		this.quads[14] = new ObjQuad(new Vector3f(-0.75f, 0.713398f, 0.05f),new Vector3f(-0.75f, 0.8f, 0.1f),new Vector3f(-0.75f, 0.8f, 0.15f),new Vector3f(-0.75f, 0.670096f, 0.075f),new Vector2f(0.46875f, 0.445873f),new Vector2f(0.4375f, 0.499999f),new Vector2f(0.40625f, 0.499999f),new Vector2f(0.453125f, 0.41881f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[15] = new ObjQuad(new Vector3f(-0.85f, 0.886603f, 0.05f),new Vector3f(-0.85f, 0.8f, 0.1f),new Vector3f(-0.85f, 0.8f, 0.15f),new Vector3f(-0.85f, 0.929904f, 0.075f),new Vector2f(0.53125f, 0.554126f),new Vector2f(0.5625f, 0.499999f),new Vector2f(0.59375f, 0.499999f),new Vector2f(0.546875f, 0.581189f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[16] = new ObjQuad(new Vector3f(-0.85f, 0.8f, 0.1f),new Vector3f(-0.85f, 0.713397f, 0.05f),new Vector3f(-0.85f, 0.670096f, 0.075f),new Vector3f(-0.85f, 0.8f, 0.15f),new Vector2f(0.5625f, 0.499999f),new Vector2f(0.53125f, 0.445873f),new Vector2f(0.546875f, 0.41881f),new Vector2f(0.59375f, 0.499999f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[17] = new ObjQuad(new Vector3f(-0.85f, 0.713397f, 0.05f),new Vector3f(-0.85f, 0.713397f, -0.05f),new Vector3f(-0.85f, 0.670096f, -0.075f),new Vector3f(-0.85f, 0.670096f, 0.075f),new Vector2f(0.53125f, 0.445873f),new Vector2f(0.46875f, 0.445873f),new Vector2f(0.453125f, 0.41881f),new Vector2f(0.546875f, 0.41881f),new Vector3f(-4.0f, -4.0E-6f, 0.0f));
		this.quads[18] = new ObjQuad(new Vector3f(-0.85f, 0.713397f, -0.05f),new Vector3f(-0.85f, 0.8f, -0.1f),new Vector3f(-0.85f, 0.800003f, -0.15f),new Vector3f(-0.85f, 0.670096f, -0.075f),new Vector2f(0.46875f, 0.445873f),new Vector2f(0.4375f, 0.499999f),new Vector2f(0.40625f, 0.500001f),new Vector2f(0.453125f, 0.41881f),new Vector3f(-4.0f, -4.0E-6f, -4.0E-6f));
		this.quads[19] = new ObjQuad(new Vector3f(-0.85f, 0.8f, -0.1f),new Vector3f(-0.85f, 0.886603f, -0.05f),new Vector3f(-0.85f, 0.929905f, -0.074997f),new Vector3f(-0.85f, 0.800003f, -0.15f),new Vector2f(0.4375f, 0.499999f),new Vector2f(0.46875f, 0.554126f),new Vector2f(0.453127f, 0.58119f),new Vector2f(0.40625f, 0.500001f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[20] = new ObjQuad(new Vector3f(-0.85f, 0.886603f, -0.05f),new Vector3f(-0.85f, 0.886603f, 0.05f),new Vector3f(-0.85f, 0.929904f, 0.075f),new Vector3f(-0.85f, 0.929905f, -0.074997f),new Vector2f(0.46875f, 0.554126f),new Vector2f(0.53125f, 0.554126f),new Vector2f(0.546875f, 0.581189f),new Vector2f(0.453127f, 0.58119f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[21] = new ObjQuad(new Vector3f(-0.85f, 0.8f, 0.1f),new Vector3f(-0.85f, 0.886603f, 0.05f),new Vector3f(-0.8f, 0.886603f, 0.05f),new Vector3f(-0.8f, 0.8f, 0.1f),new Vector2f(0.5f, 0.9375f),new Vector2f(0.445874f, 0.9375f),new Vector2f(0.445874f, 0.90625f),new Vector2f(0.5f, 0.90625f),new Vector3f(0.0f, -2.0f, -3.4641f));
		this.quads[22] = new ObjQuad(new Vector3f(-0.85f, 0.886603f, 0.05f),new Vector3f(-0.85f, 0.886603f, -0.05f),new Vector3f(-0.8f, 0.886603f, -0.05f),new Vector3f(-0.8f, 0.886603f, 0.05f),new Vector2f(0.53125f, 0.9375f),new Vector2f(0.46875f, 0.9375f),new Vector2f(0.46875f, 0.90625f),new Vector2f(0.53125f, 0.90625f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[23] = new ObjQuad(new Vector3f(-0.85f, 0.886603f, -0.05f),new Vector3f(-0.85f, 0.8f, -0.1f),new Vector3f(-0.8f, 0.8f, -0.1f),new Vector3f(-0.8f, 0.886603f, -0.05f),new Vector2f(0.554126f, 0.9375f),new Vector2f(0.499999f, 0.9375f),new Vector2f(0.499999f, 0.90625f),new Vector2f(0.554126f, 0.90625f),new Vector3f(0.0f, -2.0f, 3.464104f));
		this.quads[24] = new ObjQuad(new Vector3f(-0.85f, 0.8f, -0.1f),new Vector3f(-0.85f, 0.713397f, -0.05f),new Vector3f(-0.8f, 0.713398f, -0.05f),new Vector3f(-0.8f, 0.8f, -0.1f),new Vector2f(0.499999f, 0.9375f),new Vector2f(0.445873f, 0.9375f),new Vector2f(0.445873f, 0.90625f),new Vector2f(0.499999f, 0.90625f),new Vector3f(0.0f, 2.0f, 3.4641f));
		this.quads[25] = new ObjQuad(new Vector3f(-0.85f, 0.713397f, -0.05f),new Vector3f(-0.85f, 0.713397f, 0.05f),new Vector3f(-0.8f, 0.713398f, 0.05f),new Vector3f(-0.8f, 0.713398f, -0.05f),new Vector2f(0.53125f, 0.9375f),new Vector2f(0.46875f, 0.9375f),new Vector2f(0.46875f, 0.90625f),new Vector2f(0.53125f, 0.90625f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[26] = new ObjQuad(new Vector3f(-0.85f, 0.713397f, 0.05f),new Vector3f(-0.85f, 0.8f, 0.1f),new Vector3f(-0.8f, 0.8f, 0.1f),new Vector3f(-0.8f, 0.713398f, 0.05f),new Vector2f(0.554127f, 0.9375f),new Vector2f(0.5f, 0.9375f),new Vector2f(0.5f, 0.90625f),new Vector2f(0.554127f, 0.90625f),new Vector3f(0.0f, 2.0f, -3.4641f));
		this.quads[27] = new ObjQuad(new Vector3f(-0.75f, 0.886603f, 0.05f),new Vector3f(-0.75f, 0.8f, 0.1f),new Vector3f(-0.5f, 0.8f, 0.1f),new Vector3f(-0.5f, 0.886603f, 0.05f),new Vector2f(0.554126f, 0.875f),new Vector2f(0.499999f, 0.875f),new Vector2f(0.5f, 0.538461f),new Vector2f(0.554126f, 0.538461f),new Vector3f(-4.0E-6f, 2.0f, 3.4641f));
		this.quads[28] = new ObjQuad(new Vector3f(-0.75f, 0.886603f, -0.05f),new Vector3f(-0.75f, 0.886603f, 0.05f),new Vector3f(-0.5f, 0.886603f, 0.05f),new Vector3f(-0.5f, 0.886603f, -0.05f),new Vector2f(0.53125f, 0.875f),new Vector2f(0.46875f, 0.875f),new Vector2f(0.46875f, 0.538461f),new Vector2f(0.53125f, 0.538461f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[29] = new ObjQuad(new Vector3f(-0.75f, 0.8f, -0.1f),new Vector3f(-0.75f, 0.886603f, -0.05f),new Vector3f(-0.5f, 0.886603f, -0.05f),new Vector3f(-0.5f, 0.8f, -0.1f),new Vector2f(0.5f, 0.875f),new Vector2f(0.445874f, 0.875f),new Vector2f(0.445874f, 0.538461f),new Vector2f(0.5f, 0.538461f),new Vector3f(0.0f, 2.0f, -3.4641f));
		this.quads[30] = new ObjQuad(new Vector3f(-0.75f, 0.713398f, -0.05f),new Vector3f(-0.75f, 0.8f, -0.1f),new Vector3f(-0.5f, 0.8f, -0.1f),new Vector3f(-0.5f, 0.713398f, -0.05f),new Vector2f(0.554127f, 0.875f),new Vector2f(0.5f, 0.875f),new Vector2f(0.5f, 0.538461f),new Vector2f(0.554127f, 0.538461f),new Vector3f(0.0f, -2.0f, -3.4641f));
		this.quads[31] = new ObjQuad(new Vector3f(-0.75f, 0.713398f, 0.05f),new Vector3f(-0.75f, 0.713398f, -0.05f),new Vector3f(-0.5f, 0.713398f, -0.05f),new Vector3f(-0.5f, 0.713398f, 0.05f),new Vector2f(0.53125f, 0.875f),new Vector2f(0.46875f, 0.875f),new Vector2f(0.46875f, 0.538461f),new Vector2f(0.53125f, 0.538461f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[32] = new ObjQuad(new Vector3f(-0.75f, 0.8f, 0.1f),new Vector3f(-0.75f, 0.713398f, 0.05f),new Vector3f(-0.5f, 0.713398f, 0.05f),new Vector3f(-0.5f, 0.8f, 0.1f),new Vector2f(0.499999f, 0.875f),new Vector2f(0.445873f, 0.875f),new Vector2f(0.445873f, 0.538461f),new Vector2f(0.5f, 0.538461f),new Vector3f(0.0f, -2.0f, 3.4641f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		PumpAxle other = new PumpAxle();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}
package mod.industrialProcessing.power.models.solidBurner;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class BurnerBody extends ObjMesh{
	public BurnerBody(){
		this.quads = new ObjQuad[35];
		this.quads[0] = new ObjQuad(new Vector3f(-0.5f, 1.5f, -0.7f),new Vector3f(0.5f, 1.5f, -0.7f),new Vector3f(0.5f, 0.6f, -0.7f),new Vector3f(-0.5f, 0.6f, -0.7f),new Vector2f(0.8125f, 0.9375f),new Vector2f(0.1875f, 0.9375f),new Vector2f(0.1875f, 0.375f),new Vector2f(0.8125f, 0.375f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.6f, 0.6f, -0.7f),new Vector3f(-0.7f, 0.6f, -0.7f),new Vector3f(-0.7f, 1.5f, -0.7f),new Vector3f(-0.6f, 1.5f, -0.7f),new Vector2f(0.875f, 0.375f),new Vector2f(0.9375f, 0.375f),new Vector2f(0.9375f, 0.9375f),new Vector2f(0.875f, 0.9375f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.6f, 1.5f, -0.7f),new Vector3f(0.7f, 1.5f, -0.7f),new Vector3f(0.7f, 0.6f, -0.7f),new Vector3f(0.6f, 0.6f, -0.7f),new Vector2f(0.125f, 0.9375f),new Vector2f(0.0625f, 0.9375f),new Vector2f(0.0625f, 0.375f),new Vector2f(0.125f, 0.375f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.6f, 1.5f, -0.7f),new Vector3f(-0.7f, 1.5f, -0.7f),new Vector3f(-0.7f, 1.5f, 0.7f),new Vector3f(-0.6f, 1.5f, 0.7f),new Vector2f(0.125f, 0.9375f),new Vector2f(0.0625f, 0.9375f),new Vector2f(0.0625f, 0.0625f),new Vector2f(0.125f, 0.0625f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.6f, 1.5f, -0.7f),new Vector3f(-0.6f, 1.5f, 0.7f),new Vector3f(-0.5f, 1.5f, 0.7f),new Vector3f(-0.5f, 1.5f, -0.7f),new Vector2f(0.125f, 0.9375f),new Vector2f(0.125f, 0.0625f),new Vector2f(0.1875f, 0.0625f),new Vector2f(0.1875f, 0.9375f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.5f, 1.5f, -0.7f),new Vector3f(-0.5f, 1.5f, 0.7f),new Vector3f(0.5f, 1.5f, 0.7f),new Vector3f(0.5f, 1.5f, -0.7f),new Vector2f(0.1875f, 0.9375f),new Vector2f(0.1875f, 0.0625f),new Vector2f(0.8125f, 0.0625f),new Vector2f(0.8125f, 0.9375f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(0.5f, 1.5f, -0.7f),new Vector3f(0.5f, 1.5f, 0.7f),new Vector3f(0.6f, 1.5f, 0.7f),new Vector3f(0.6f, 1.5f, -0.7f),new Vector2f(0.8125f, 0.9375f),new Vector2f(0.8125f, 0.0625f),new Vector2f(0.875f, 0.0625f),new Vector2f(0.875f, 0.9375f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(0.6f, 1.5f, -0.7f),new Vector3f(0.6f, 1.5f, 0.7f),new Vector3f(0.7f, 1.5f, 0.7f),new Vector3f(0.7f, 1.5f, -0.7f),new Vector2f(0.875f, 0.9375f),new Vector2f(0.875f, 0.0625f),new Vector2f(0.9375f, 0.0625f),new Vector2f(0.9375f, 0.9375f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(0.6f, 0.6f, 0.7f),new Vector3f(0.7f, 0.6f, 0.7f),new Vector3f(0.7f, 1.5f, 0.7f),new Vector3f(0.6f, 1.5f, 0.7f),new Vector2f(0.875f, 0.375f),new Vector2f(0.9375f, 0.375f),new Vector2f(0.9375f, 0.9375f),new Vector2f(0.875f, 0.9375f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[9] = new ObjQuad(new Vector3f(-0.6f, 0.6f, 0.7f),new Vector3f(-0.7f, 0.6f, 0.7f),new Vector3f(-0.2f, 0.2f, 0.2f),new Vector3f(-0.5f, 0.6f, 0.7f),new Vector2f(0.875f, 0.0625f),new Vector2f(0.9375f, 0.0625f),new Vector2f(0.625f, 0.375f),new Vector2f(0.8125f, 0.0625f),new Vector3f(0.0f, -3.123476f, 2.49878f));
		this.quads[10] = new ObjQuad(new Vector3f(0.5f, 0.6f, 0.7f),new Vector3f(-0.5f, 0.6f, 0.7f),new Vector3f(-0.2f, 0.2f, 0.2f),new Vector3f(0.2f, 0.2f, 0.2f),new Vector2f(0.1875f, 0.0625f),new Vector2f(0.8125f, 0.0625f),new Vector2f(0.625f, 0.375f),new Vector2f(0.375f, 0.375f),new Vector3f(0.0f, -3.123476f, 2.49878f));
		this.quads[11] = new ObjQuad(new Vector3f(0.5f, 0.6f, 0.7f),new Vector3f(0.2f, 0.2f, 0.2f),new Vector3f(0.7f, 0.6f, 0.7f),new Vector2f(0.1875f, 0.0625f),new Vector2f(0.375f, 0.375f),new Vector2f(0.0625f, 0.0625f),new Vector3f(0.0f, -2.342607f, 1.874085f));
		this.quads[12] = new ObjQuad(new Vector3f(-0.6f, 1.5f, 0.7f),new Vector3f(-0.7f, 1.5f, 0.7f),new Vector3f(-0.7f, 0.6f, 0.7f),new Vector3f(-0.6f, 0.6f, 0.7f),new Vector2f(0.125f, 0.9375f),new Vector2f(0.0625f, 0.9375f),new Vector2f(0.0625f, 0.375f),new Vector2f(0.125f, 0.375f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[13] = new ObjQuad(new Vector3f(-0.7f, 1.5f, -0.7f),new Vector3f(-0.7f, 0.6f, -0.7f),new Vector3f(-0.7f, 0.6f, -0.3f),new Vector3f(-0.7f, 1.1f, -0.3f),new Vector2f(0.0625f, 0.9375f),new Vector2f(0.0625f, 0.375f),new Vector2f(0.3125f, 0.375f),new Vector2f(0.3125f, 0.6875f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[14] = new ObjQuad(new Vector3f(-0.7f, 1.5f, -0.7f),new Vector3f(-0.7f, 1.1f, -0.3f),new Vector3f(-0.7f, 1.1f, 0.3f),new Vector3f(-0.7f, 1.5f, 0.7f),new Vector2f(0.0625f, 0.9375f),new Vector2f(0.3125f, 0.6875f),new Vector2f(0.6875f, 0.6875f),new Vector2f(0.9375f, 0.9375f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[15] = new ObjQuad(new Vector3f(-0.7f, 1.1f, 0.3f),new Vector3f(-0.7f, 0.6f, 0.3f),new Vector3f(-0.7f, 0.6f, 0.7f),new Vector3f(-0.7f, 1.5f, 0.7f),new Vector2f(0.6875f, 0.6875f),new Vector2f(0.6875f, 0.375f),new Vector2f(0.9375f, 0.375f),new Vector2f(0.9375f, 0.9375f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[16] = new ObjQuad(new Vector3f(-0.7f, 0.6f, 0.7f),new Vector3f(-0.7f, 0.6f, 0.3f),new Vector3f(-0.575f, 0.5f, 0.3f),new Vector3f(-0.2f, 0.2f, 0.2f),new Vector2f(0.9375f, 0.0625f),new Vector2f(0.9375f, 0.3125f),new Vector2f(0.859375f, 0.3125f),new Vector2f(0.625f, 0.375f),new Vector3f(-2.49878f, -3.123476f, 0.0f));
		this.quads[17] = new ObjQuad(new Vector3f(-0.2f, 0.2f, 0.2f),new Vector3f(-0.575f, 0.5f, 0.3f),new Vector3f(-0.575f, 0.5f, -0.3f),new Vector3f(-0.2f, 0.2f, -0.2f),new Vector2f(0.625f, 0.375f),new Vector2f(0.859375f, 0.3125f),new Vector2f(0.859375f, 0.6875f),new Vector2f(0.625f, 0.625f),new Vector3f(-2.49878f, -3.123476f, 0.0f));
		this.quads[18] = new ObjQuad(new Vector3f(-0.7f, 0.6f, -0.7f),new Vector3f(-0.2f, 0.2f, -0.2f),new Vector3f(-0.575f, 0.5f, -0.3f),new Vector3f(-0.7f, 0.6f, -0.3f),new Vector2f(0.9375f, 0.9375f),new Vector2f(0.625f, 0.625f),new Vector2f(0.859375f, 0.6875f),new Vector2f(0.9375f, 0.6875f),new Vector3f(-2.49878f, -3.123476f, 0.0f));
		this.quads[19] = new ObjQuad(new Vector3f(-0.2f, 0.2f, -0.2f),new Vector3f(-0.2f, 0.1f, -0.2f),new Vector3f(-0.2f, 0.1f, 0.2f),new Vector3f(-0.2f, 0.2f, 0.2f),new Vector2f(0.375f, 0.125f),new Vector2f(0.375f, 0.0625f),new Vector2f(0.625f, 0.0625f),new Vector2f(0.625f, 0.125f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[20] = new ObjQuad(new Vector3f(-0.2f, 0.2f, -0.2f),new Vector3f(0.2f, 0.2f, -0.2f),new Vector3f(0.2f, 0.1f, -0.2f),new Vector3f(-0.2f, 0.1f, -0.2f),new Vector2f(0.625f, 0.125f),new Vector2f(0.375f, 0.125f),new Vector2f(0.375f, 0.0625f),new Vector2f(0.625f, 0.0625f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[21] = new ObjQuad(new Vector3f(-0.2f, 0.2f, -0.2f),new Vector3f(-0.7f, 0.6f, -0.7f),new Vector3f(-0.6f, 0.6f, -0.7f),new Vector3f(-0.5f, 0.6f, -0.7f),new Vector2f(0.625f, 0.625f),new Vector2f(0.9375f, 0.9375f),new Vector2f(0.875f, 0.9375f),new Vector2f(0.8125f, 0.9375f),new Vector3f(0.0f, -3.123476f, -2.49878f));
		this.quads[22] = new ObjQuad(new Vector3f(-0.2f, 0.2f, -0.2f),new Vector3f(-0.5f, 0.6f, -0.7f),new Vector3f(0.5f, 0.6f, -0.7f),new Vector3f(0.2f, 0.2f, -0.2f),new Vector2f(0.625f, 0.625f),new Vector2f(0.8125f, 0.9375f),new Vector2f(0.1875f, 0.9375f),new Vector2f(0.375f, 0.625f),new Vector3f(0.0f, -3.123476f, -2.49878f));
		this.quads[23] = new ObjQuad(new Vector3f(0.5f, 0.6f, -0.7f),new Vector3f(0.7f, 0.6f, -0.7f),new Vector3f(0.2f, 0.2f, -0.2f),new Vector2f(0.1875f, 0.9375f),new Vector2f(0.0625f, 0.9375f),new Vector2f(0.375f, 0.625f),new Vector3f(0.0f, -2.342607f, -1.874085f));
		this.quads[24] = new ObjQuad(new Vector3f(0.5f, 1.5f, 0.7f),new Vector3f(-0.5f, 1.5f, 0.7f),new Vector3f(-0.5f, 0.6f, 0.7f),new Vector3f(0.5f, 0.6f, 0.7f),new Vector2f(0.8125f, 0.9375f),new Vector2f(0.1875f, 0.9375f),new Vector2f(0.1875f, 0.375f),new Vector2f(0.8125f, 0.375f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[25] = new ObjQuad(new Vector3f(0.7f, 0.6f, 0.7f),new Vector3f(0.7f, 0.6f, 0.3f),new Vector3f(0.7f, 1.1f, 0.3f),new Vector3f(0.7f, 1.5f, 0.7f),new Vector2f(0.0625f, 0.375f),new Vector2f(0.3125f, 0.375f),new Vector2f(0.3125f, 0.6875f),new Vector2f(0.0625f, 0.9375f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[26] = new ObjQuad(new Vector3f(0.7f, 1.5f, -0.7f),new Vector3f(0.7f, 1.5f, 0.7f),new Vector3f(0.7f, 1.1f, 0.3f),new Vector3f(0.7f, 1.1f, -0.3f),new Vector2f(0.9375f, 0.9375f),new Vector2f(0.0625f, 0.9375f),new Vector2f(0.3125f, 0.6875f),new Vector2f(0.6875f, 0.6875f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[27] = new ObjQuad(new Vector3f(0.7f, 1.1f, -0.3f),new Vector3f(0.7f, 0.6f, -0.3f),new Vector3f(0.7f, 0.6f, -0.697646f),new Vector3f(0.7f, 1.5f, -0.7f),new Vector2f(0.6875f, 0.6875f),new Vector2f(0.6875f, 0.375f),new Vector2f(0.936029f, 0.375f),new Vector2f(0.9375f, 0.9375f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[28] = new ObjQuad(new Vector3f(0.7f, 1.5f, -0.7f),new Vector3f(0.7f, 0.6f, -0.697646f),new Vector3f(0.7f, 0.6f, -0.7f),new Vector2f(0.9375f, 0.9375f),new Vector2f(0.936029f, 0.375f),new Vector2f(0.9375f, 0.375f),new Vector3f(3.0f, 0.0f, 0.0f));
		this.quads[29] = new ObjQuad(new Vector3f(0.2f, 0.2f, 0.2f),new Vector3f(0.2f, 0.2f, -0.2f),new Vector3f(0.7f, 0.6f, -0.7f),new Vector3f(0.575f, 0.5f, -0.3f),new Vector2f(0.375f, 0.375f),new Vector2f(0.375f, 0.625f),new Vector2f(0.0625f, 0.9375f),new Vector2f(0.140625f, 0.6875f),new Vector3f(2.49878f, -3.123476f, 0.0f));
		this.quads[30] = new ObjQuad(new Vector3f(0.7f, 0.6f, -0.7f),new Vector3f(0.7f, 0.6f, -0.3f),new Vector3f(0.575f, 0.5f, -0.3f),new Vector2f(0.0625f, 0.9375f),new Vector2f(0.0625f, 0.6875f),new Vector2f(0.140625f, 0.6875f),new Vector3f(1.874085f, -2.342607f, 0.0f));
		this.quads[31] = new ObjQuad(new Vector3f(0.2f, 0.2f, 0.2f),new Vector3f(0.575f, 0.5f, -0.3f),new Vector3f(0.575f, 0.5f, 0.3f),new Vector3f(0.7f, 0.6f, 0.7f),new Vector2f(0.375f, 0.375f),new Vector2f(0.140625f, 0.6875f),new Vector2f(0.140625f, 0.3125f),new Vector2f(0.0625f, 0.0625f),new Vector3f(2.49878f, -3.123476f, 0.0f));
		this.quads[32] = new ObjQuad(new Vector3f(0.7f, 0.6f, 0.7f),new Vector3f(0.575f, 0.5f, 0.3f),new Vector3f(0.7f, 0.6f, 0.3f),new Vector2f(0.0625f, 0.0625f),new Vector2f(0.140625f, 0.3125f),new Vector2f(0.0625f, 0.3125f),new Vector3f(1.874085f, -2.342607f, 0.0f));
		this.quads[33] = new ObjQuad(new Vector3f(0.2f, 0.2f, 0.2f),new Vector3f(0.2f, 0.1f, 0.2f),new Vector3f(0.2f, 0.1f, -0.2f),new Vector3f(0.2f, 0.2f, -0.2f),new Vector2f(0.375f, 0.125f),new Vector2f(0.375f, 0.0625f),new Vector2f(0.625f, 0.0625f),new Vector2f(0.625f, 0.125f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[34] = new ObjQuad(new Vector3f(0.2f, 0.2f, 0.2f),new Vector3f(-0.2f, 0.2f, 0.2f),new Vector3f(-0.2f, 0.1f, 0.2f),new Vector3f(0.2f, 0.1f, 0.2f),new Vector2f(0.625f, 0.125f),new Vector2f(0.375f, 0.125f),new Vector2f(0.375f, 0.0625f),new Vector2f(0.625f, 0.0625f),new Vector3f(0.0f, 0.0f, 4.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		BurnerBody other = new BurnerBody();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

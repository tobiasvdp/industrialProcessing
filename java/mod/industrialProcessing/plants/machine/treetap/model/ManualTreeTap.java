package mod.industrialProcessing.plants.machine.treetap.model;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class ManualTreeTap extends ObjMesh{
	public ManualTreeTap(){
		this.quads = new ObjQuad[27];
		this.quads[0] = new ObjQuad(new Vector3f(0.6f, 0.2f, -0.8f),new Vector3f(0.6f, 0.2f, -0.5f),new Vector3f(0.5f, 0.2f, -0.4f),new Vector3f(-0.0f, 0.2f, -0.5f),new Vector2f(0.25f, 0.375f),new Vector2f(0.0625f, 0.375f),new Vector2f(0.0f, 0.3125f),new Vector2f(0.0625f, 0.0f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.5f, 0.2f, -0.4f),new Vector3f(0.1f, 0.2f, -0.4f),new Vector3f(-0.0f, 0.2f, -0.5f),new Vector2f(0.0f, 0.3125f),new Vector2f(0.0f, 0.0625f),new Vector2f(0.0625f, 0.0f),new Vector3f(0.0f, -3.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.0f, 0.2f, -0.8f),new Vector3f(0.6f, 0.2f, -0.8f),new Vector3f(-0.0f, 0.2f, -0.5f),new Vector2f(0.25f, 0.0f),new Vector2f(0.25f, 0.375f),new Vector2f(0.0625f, 0.0f),new Vector3f(0.0f, -3.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.6f, 0.6f, -0.8f),new Vector3f(0.6f, 0.6f, -0.5f),new Vector3f(0.6f, 0.2f, -0.5f),new Vector3f(0.6f, 0.2f, -0.8f),new Vector2f(0.5f, 0.25f),new Vector2f(0.5f, 0.4375f),new Vector2f(0.25f, 0.4375f),new Vector2f(0.25f, 0.25f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.1f, 0.5f, -0.8f),new Vector3f(0.1f, 0.5f, -0.541421f),new Vector3f(0.141421f, 0.5f, -0.5f),new Vector3f(0.5f, 0.5f, -0.541421f),new Vector2f(0.4375f, 0.75f),new Vector2f(0.275888f, 0.75f),new Vector2f(0.25f, 0.724112f),new Vector2f(0.275888f, 0.5f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(0.141421f, 0.5f, -0.5f),new Vector3f(0.458579f, 0.5f, -0.5f),new Vector3f(0.5f, 0.5f, -0.541421f),new Vector2f(0.25f, 0.724112f),new Vector2f(0.25f, 0.525888f),new Vector2f(0.275888f, 0.5f),new Vector3f(0.0f, 3.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(0.5f, 0.5f, -0.8f),new Vector3f(0.1f, 0.5f, -0.8f),new Vector3f(0.5f, 0.5f, -0.541421f),new Vector2f(0.4375f, 0.5f),new Vector2f(0.4375f, 0.75f),new Vector2f(0.275888f, 0.5f),new Vector3f(0.0f, 3.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(0.0f, 0.2f, -0.8f),new Vector3f(-0.0f, 0.2f, -0.5f),new Vector3f(-0.0f, 0.6f, -0.5f),new Vector3f(0.0f, 0.6f, -0.8f),new Vector2f(0.75f, 0.0f),new Vector2f(0.75f, 0.1875f),new Vector2f(0.5f, 0.1875f),new Vector2f(0.5f, 0.0f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(0.5f, 0.2f, -0.4f),new Vector3f(0.5f, 0.6f, -0.4f),new Vector3f(0.1f, 0.6f, -0.4f),new Vector3f(0.1f, 0.2f, -0.4f),new Vector2f(0.25f, 0.25f),new Vector2f(0.25f, 0.0f),new Vector2f(0.5f, 0.0f),new Vector2f(0.5f, 0.25f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[9] = new ObjQuad(new Vector3f(0.6f, 0.2f, -0.5f),new Vector3f(0.6f, 0.6f, -0.5f),new Vector3f(0.5f, 0.6f, -0.4f),new Vector3f(0.5f, 0.2f, -0.4f),new Vector2f(0.25f, 0.4375f),new Vector2f(0.5f, 0.4375f),new Vector2f(0.5f, 0.5f),new Vector2f(0.25f, 0.5f),new Vector3f(2.828428f, 0.0f, 2.828428f));
		this.quads[10] = new ObjQuad(new Vector3f(-0.0f, 0.6f, -0.5f),new Vector3f(-0.0f, 0.2f, -0.5f),new Vector3f(0.1f, 0.2f, -0.4f),new Vector3f(0.1f, 0.6f, -0.4f),new Vector2f(0.5f, 0.1875f),new Vector2f(0.75f, 0.1875f),new Vector2f(0.75f, 0.25f),new Vector2f(0.5f, 0.25f),new Vector3f(-2.828428f, 0.0f, 2.828428f));
		this.quads[11] = new ObjQuad(new Vector3f(0.6f, 0.6f, -0.5f),new Vector3f(0.6f, 0.6f, -0.8f),new Vector3f(0.5f, 0.6f, -0.8f),new Vector3f(0.5f, 0.6f, -0.541421f),new Vector2f(0.0625f, 0.375f),new Vector2f(0.25f, 0.375f),new Vector2f(0.25f, 0.4375f),new Vector2f(0.088388f, 0.4375f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[12] = new ObjQuad(new Vector3f(0.0f, 0.6f, -0.8f),new Vector3f(-0.0f, 0.6f, -0.5f),new Vector3f(0.1f, 0.6f, -0.541421f),new Vector3f(0.1f, 0.6f, -0.8f),new Vector2f(0.25f, 0.75f),new Vector2f(0.0625f, 0.75f),new Vector2f(0.088388f, 0.6875f),new Vector2f(0.25f, 0.6875f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[13] = new ObjQuad(new Vector3f(-0.0f, 0.6f, -0.5f),new Vector3f(0.1f, 0.6f, -0.4f),new Vector3f(0.141421f, 0.6f, -0.5f),new Vector3f(0.1f, 0.6f, -0.541421f),new Vector2f(0.0625f, 0.75f),new Vector2f(0.0f, 0.6875f),new Vector2f(0.0625f, 0.661612f),new Vector2f(0.088388f, 0.6875f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[14] = new ObjQuad(new Vector3f(0.1f, 0.6f, -0.4f),new Vector3f(0.5f, 0.6f, -0.4f),new Vector3f(0.458579f, 0.6f, -0.5f),new Vector3f(0.141421f, 0.6f, -0.5f),new Vector2f(0.0f, 0.6875f),new Vector2f(0.0f, 0.4375f),new Vector2f(0.0625f, 0.463388f),new Vector2f(0.0625f, 0.661612f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[15] = new ObjQuad(new Vector3f(0.5f, 0.6f, -0.4f),new Vector3f(0.6f, 0.6f, -0.5f),new Vector3f(0.5f, 0.6f, -0.541421f),new Vector3f(0.458579f, 0.6f, -0.5f),new Vector2f(0.0f, 0.4375f),new Vector2f(0.0625f, 0.375f),new Vector2f(0.088388f, 0.4375f),new Vector2f(0.0625f, 0.463388f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[16] = new ObjQuad(new Vector3f(0.5f, 0.6f, -0.541421f),new Vector3f(0.5f, 0.6f, -0.8f),new Vector3f(0.5f, 0.5f, -0.8f),new Vector3f(0.5f, 0.5f, -0.541421f),new Vector2f(0.751818f, 0.31105f),new Vector2f(0.751818f, 0.472661f),new Vector2f(0.689318f, 0.472661f),new Vector2f(0.689318f, 0.31105f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[17] = new ObjQuad(new Vector3f(0.1f, 0.6f, -0.8f),new Vector3f(0.1f, 0.6f, -0.541421f),new Vector3f(0.1f, 0.5f, -0.541421f),new Vector3f(0.1f, 0.5f, -0.8f),new Vector2f(0.625938f, 0.438814f),new Vector2f(0.625938f, 0.277202f),new Vector2f(0.688438f, 0.277202f),new Vector2f(0.688438f, 0.438814f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[18] = new ObjQuad(new Vector3f(0.1f, 0.6f, -0.541421f),new Vector3f(0.141421f, 0.6f, -0.5f),new Vector3f(0.141421f, 0.5f, -0.5f),new Vector3f(0.1f, 0.5f, -0.541421f),new Vector2f(0.651415f, 0.750745f),new Vector2f(0.625527f, 0.750745f),new Vector2f(0.625527f, 0.688245f),new Vector2f(0.651415f, 0.688245f),new Vector3f(2.828428f, 0.0f, -2.828428f));
		this.quads[19] = new ObjQuad(new Vector3f(0.141421f, 0.6f, -0.5f),new Vector3f(0.458579f, 0.6f, -0.5f),new Vector3f(0.458579f, 0.5f, -0.5f),new Vector3f(0.141421f, 0.5f, -0.5f),new Vector2f(0.5625f, 0.472611f),new Vector2f(0.5625f, 0.274388f),new Vector2f(0.625f, 0.274388f),new Vector2f(0.625f, 0.472611f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[20] = new ObjQuad(new Vector3f(0.458579f, 0.6f, -0.5f),new Vector3f(0.5f, 0.6f, -0.541421f),new Vector3f(0.5f, 0.5f, -0.541421f),new Vector3f(0.458579f, 0.5f, -0.5f),new Vector2f(0.59217f, 0.688914f),new Vector2f(0.618058f, 0.688914f),new Vector2f(0.618058f, 0.751414f),new Vector2f(0.59217f, 0.751414f),new Vector3f(-2.828428f, 0.0f, -2.828428f));
		this.quads[21] = new ObjQuad(new Vector3f(-0.1f, 0.5f, -0.6f),new Vector3f(-0.1f, 0.5f, -0.7f),new Vector3f(-0.1f, 0.1f, -0.7f),new Vector3f(-0.1f, 0.1f, -0.6f),new Vector2f(0.4375f, 0.5f),new Vector2f(0.5f, 0.5f),new Vector2f(0.5f, 0.75f),new Vector2f(0.4375f, 0.75f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[22] = new ObjQuad(new Vector3f(-0.0f, 0.1f, -0.6f),new Vector3f(-0.0f, 0.5f, -0.6f),new Vector3f(-0.1f, 0.5f, -0.6f),new Vector3f(-0.1f, 0.1f, -0.6f),new Vector2f(0.5f, 0.5f),new Vector2f(0.5f, 0.25f),new Vector2f(0.5625f, 0.25f),new Vector2f(0.5625f, 0.5f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[23] = new ObjQuad(new Vector3f(-0.0f, 0.5f, -0.6f),new Vector3f(-0.0f, 0.5f, -0.7f),new Vector3f(-0.1f, 0.5f, -0.7f),new Vector3f(-0.1f, 0.5f, -0.6f),new Vector2f(0.6875f, 0.25f),new Vector2f(0.75f, 0.25f),new Vector2f(0.75f, 0.3125f),new Vector2f(0.6875f, 0.3125f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[24] = new ObjQuad(new Vector3f(-0.0f, 0.5f, -0.7f),new Vector3f(-0.0f, 0.1f, -0.7f),new Vector3f(-0.1f, 0.1f, -0.7f),new Vector3f(-0.1f, 0.5f, -0.7f),new Vector2f(0.5625f, 0.5f),new Vector2f(0.5625f, 0.75f),new Vector2f(0.5f, 0.75f),new Vector2f(0.5f, 0.5f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[25] = new ObjQuad(new Vector3f(-0.0f, 0.1f, -0.7f),new Vector3f(-0.0f, 0.1f, -0.6f),new Vector3f(-0.1f, 0.1f, -0.6f),new Vector3f(-0.1f, 0.1f, -0.7f),new Vector2f(0.6875f, 0.438814f),new Vector2f(0.6875f, 0.501314f),new Vector2f(0.625f, 0.501314f),new Vector2f(0.625f, 0.438814f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[26] = new ObjQuad(new Vector3f(-0.0f, 0.1f, -0.6f),new Vector3f(-0.0f, 0.1f, -0.7f),new Vector3f(-0.0f, 0.2f, -0.7f),new Vector3f(-0.0f, 0.2f, -0.6f),new Vector2f(0.562753f, 0.624102f),new Vector2f(0.625253f, 0.624102f),new Vector2f(0.625253f, 0.686602f),new Vector2f(0.562753f, 0.686602f),new Vector3f(4.0f, 0.0f, 4.0E-6f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		ManualTreeTap other = new ManualTreeTap();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}
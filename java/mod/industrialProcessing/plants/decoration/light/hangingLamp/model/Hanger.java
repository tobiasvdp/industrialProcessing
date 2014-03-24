package mod.industrialProcessing.plants.decoration.light.hangingLamp.model;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Hanger extends ObjMesh{
	public Hanger(){
		this.quads = new ObjQuad[19];
		this.quads[0] = new ObjQuad(new Vector3f(-0.25f, 1.4f, 0.7f),new Vector3f(0.25f, 1.4f, 0.7f),new Vector3f(0.25f, 1.22f, 0.7f),new Vector3f(0.05f, 1.22f, 0.7f),new Vector2f(0.6563f, 0.875f),new Vector2f(0.3438f, 0.875f),new Vector2f(0.3438f, 0.7625f),new Vector2f(0.4688f, 0.7625f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.25f, 1.4f, 0.7f),new Vector3f(0.05f, 1.22f, 0.7f),new Vector3f(-0.07f, 1.22f, 0.7f),new Vector3f(-0.07f, 0.8f, 0.7f),new Vector2f(0.6563f, 0.875f),new Vector2f(0.4688f, 0.7625f),new Vector2f(0.5438f, 0.7625f),new Vector2f(0.5438f, 0.5f),new Vector3f(0.0f, 0.0f, -2.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.05f, 0.8f, 0.7f),new Vector3f(0.05f, 1.22f, 0.7f),new Vector3f(0.25f, 1.22f, 0.7f),new Vector3f(0.25f, 0.2f, 0.7f),new Vector2f(0.4688f, 0.5f),new Vector2f(0.4688f, 0.7625f),new Vector2f(0.3438f, 0.7625f),new Vector2f(0.3438f, 0.125f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.07f, 0.8f, 0.7f),new Vector3f(0.05f, 0.8f, 0.7f),new Vector3f(0.25f, 0.2f, 0.7f),new Vector3f(-0.25f, 1.4f, 0.7f),new Vector2f(0.5438f, 0.5f),new Vector2f(0.4688f, 0.5f),new Vector2f(0.3438f, 0.125f),new Vector2f(0.6563f, 0.875f),new Vector3f(0.0f, 0.0f, -2.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.25f, 0.2f, 0.7f),new Vector3f(-0.25f, 1.4f, 0.7f),new Vector3f(0.25f, 0.2f, 0.7f),new Vector2f(0.6563f, 0.125f),new Vector2f(0.6563f, 0.875f),new Vector2f(0.3438f, 0.125f),new Vector3f(0.0f, 0.0f, -3.0f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.25f, 0.2f, 0.7f),new Vector3f(0.25f, 0.2f, 0.7f),new Vector3f(0.25f, 0.2f, 0.8f),new Vector3f(-0.25f, 0.2f, 0.8f),new Vector2f(0.6563f, 0.0625f),new Vector2f(0.3438f, 0.0625f),new Vector2f(0.3438f, 0.0f),new Vector2f(0.6563f, 0.0f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(0.25f, 1.4f, 0.7f),new Vector3f(0.25f, 1.4f, 0.8f),new Vector3f(0.25f, 1.22f, 0.8f),new Vector3f(0.25f, 1.22f, 0.7f),new Vector2f(0.0625f, 0.875f),new Vector2f(-0.0f, 0.875f),new Vector2f(-0.0f, 0.7625f),new Vector2f(0.0625f, 0.7625f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(0.25f, 1.22f, 0.7f),new Vector3f(0.25f, 1.22f, 0.8f),new Vector3f(0.25f, 1.067f, 0.8f),new Vector3f(0.25f, 0.2f, 0.8f),new Vector2f(0.0625f, 0.7625f),new Vector2f(-0.0f, 0.7625f),new Vector2f(-0.0f, 0.6669f),new Vector2f(0.0f, 0.125f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(0.25f, 0.2f, 0.7f),new Vector3f(0.25f, 1.22f, 0.7f),new Vector3f(0.25f, 0.2f, 0.8f),new Vector2f(0.0625f, 0.125f),new Vector2f(0.0625f, 0.7625f),new Vector2f(0.0f, 0.125f),new Vector3f(3.0f, 0.0f, 0.0f));
		this.quads[9] = new ObjQuad(new Vector3f(0.25f, 1.4f, 0.7f),new Vector3f(-0.25f, 1.4f, 0.7f),new Vector3f(-0.25f, 1.4f, 0.8f),new Vector3f(0.25f, 1.4f, 0.8f),new Vector2f(0.6562f, 0.0625f),new Vector2f(0.3437f, 0.0625f),new Vector2f(0.3437f, 0.0f),new Vector2f(0.6562f, -0.0f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[10] = new ObjQuad(new Vector3f(-0.25f, 0.2f, 0.7f),new Vector3f(-0.25f, 0.2f, 0.8f),new Vector3f(-0.25f, 1.4f, 0.8f),new Vector3f(-0.25f, 1.4f, 0.7f),new Vector2f(0.9375f, 0.125f),new Vector2f(1.0f, 0.125f),new Vector2f(1.0f, 0.875f),new Vector2f(0.9375f, 0.875f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[11] = new ObjQuad(new Vector3f(0.06f, 1.22f, 0.2f),new Vector3f(0.06f, 1.067f, 0.2f),new Vector3f(-0.06f, 1.067f, 0.2f),new Vector3f(-0.06f, 1.22f, 0.2f),new Vector2f(0.4625f, 0.7625f),new Vector2f(0.4625f, 0.6669f),new Vector2f(0.5375f, 0.6669f),new Vector2f(0.5375f, 0.7625f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[12] = new ObjQuad(new Vector3f(0.05f, 1.22f, 0.7f),new Vector3f(0.05f, 0.8f, 0.7f),new Vector3f(0.0524f, 1.067f, 0.5825f),new Vector3f(0.06f, 1.067f, 0.2f),new Vector2f(0.0625f, 0.7625f),new Vector2f(0.0625f, 0.5f),new Vector2f(0.1359f, 0.6669f),new Vector2f(0.375f, 0.6669f),new Vector3f(3.9992f, 0.0f, 0.08f));
		this.quads[13] = new ObjQuad(new Vector3f(0.05f, 1.22f, 0.7f),new Vector3f(0.06f, 1.067f, 0.2f),new Vector3f(0.06f, 1.22f, 0.2f),new Vector2f(0.0625f, 0.7625f),new Vector2f(0.375f, 0.6669f),new Vector2f(0.375f, 0.7625f),new Vector3f(2.9994001f, 0.0f, 0.06f));
		this.quads[14] = new ObjQuad(new Vector3f(0.05f, 0.8f, 0.7f),new Vector3f(-0.07f, 0.8f, 0.7f),new Vector3f(-0.0677f, 1.067f, 0.5825f),new Vector3f(0.0524f, 1.067f, 0.5825f),new Vector2f(0.4688f, 0.5f),new Vector2f(0.5438f, 0.5f),new Vector2f(0.5423f, 0.6669f),new Vector2f(0.4673f, 0.6669f),new Vector3f(0.0f, -1.6112f, -3.6612f));
		this.quads[15] = new ObjQuad(new Vector3f(-0.07f, 1.22f, 0.7f),new Vector3f(-0.06f, 1.22f, 0.2f),new Vector3f(-0.06f, 1.067f, 0.2f),new Vector3f(-0.0677f, 1.067f, 0.5825f),new Vector2f(0.9375f, 0.7625f),new Vector2f(0.625f, 0.7625f),new Vector2f(0.625f, 0.6669f),new Vector2f(0.8641f, 0.6669f),new Vector3f(-3.9992f, 0.0f, -0.08f));
		this.quads[16] = new ObjQuad(new Vector3f(-0.07f, 0.8f, 0.7f),new Vector3f(-0.07f, 1.22f, 0.7f),new Vector3f(-0.0677f, 1.067f, 0.5825f),new Vector2f(0.9375f, 0.5f),new Vector2f(0.9375f, 0.7625f),new Vector2f(0.8641f, 0.6669f),new Vector3f(-2.9994001f, 0.0f, -0.06f));
		this.quads[17] = new ObjQuad(new Vector3f(-0.07f, 1.22f, 0.7f),new Vector3f(0.05f, 1.22f, 0.7f),new Vector3f(0.06f, 1.22f, 0.2f),new Vector3f(-0.06f, 1.22f, 0.2f),new Vector2f(0.4562f, 0.0625f),new Vector2f(0.5312f, 0.0625f),new Vector2f(0.5375f, 0.375f),new Vector2f(0.4625f, 0.375f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[18] = new ObjQuad(new Vector3f(-0.06f, 1.067f, 0.2f),new Vector3f(0.06f, 1.067f, 0.2f),new Vector3f(0.0524f, 1.067f, 0.5825f),new Vector3f(-0.0677f, 1.067f, 0.5825f),new Vector2f(0.5375f, 0.375f),new Vector2f(0.4625f, 0.375f),new Vector2f(0.4673f, 0.1359f),new Vector2f(0.5423f, 0.1359f),new Vector3f(0.0f, -4.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Hanger other = new Hanger();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

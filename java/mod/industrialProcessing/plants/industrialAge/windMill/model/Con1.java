package  mod.industrialProcessing.plants.industrialAge.windMill.model;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Con1 extends ObjMesh{
	public Con1(){
		this.quads = new ObjQuad[24];
		this.quads[0] = new ObjQuad(new Vector3f(0.5f, 0.8f, -0.8f),new Vector3f(0.25f, 1.233f, -0.8f),new Vector3f(0.2f, 1.1464f, -0.4f),new Vector3f(0.4f, 0.8f, -0.4f),new Vector2f(0.5f, 0.375f),new Vector2f(0.7706f, 0.375f),new Vector2f(0.7165f, 0.625f),new Vector2f(0.5f, 0.625f),new Vector3f(2.9104f, 1.6804f, 0.97f));
		this.quads[1] = new ObjQuad(new Vector3f(0.25f, 1.233f, -0.8f),new Vector3f(-0.25f, 1.233f, -0.8f),new Vector3f(-0.2f, 1.1464f, -0.4f),new Vector3f(0.2f, 1.1464f, -0.4f),new Vector2f(0.3437f, 0.375f),new Vector2f(0.6562f, 0.375f),new Vector2f(0.625f, 0.625f),new Vector2f(0.375f, 0.625f),new Vector3f(0.0f, 3.3608f, 0.97f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.25f, 1.233f, -0.8f),new Vector3f(-0.5f, 0.8f, -0.8f),new Vector3f(-0.4f, 0.8f, -0.4f),new Vector3f(-0.2f, 1.1464f, -0.4f),new Vector2f(0.2294f, 0.375f),new Vector2f(0.5f, 0.375f),new Vector2f(0.5f, 0.625f),new Vector2f(0.2835f, 0.625f),new Vector3f(-2.9104f, 1.6804f, 0.97f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.5f, 0.8f, -0.8f),new Vector3f(-0.25f, 0.367f, -0.8f),new Vector3f(-0.2f, 0.4536f, -0.4f),new Vector3f(-0.4f, 0.8f, -0.4f),new Vector2f(0.5f, 0.375f),new Vector2f(0.7706f, 0.375f),new Vector2f(0.7165f, 0.625f),new Vector2f(0.5f, 0.625f),new Vector3f(-2.9104f, -1.6804f, 0.97f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.25f, 0.367f, -0.8f),new Vector3f(0.25f, 0.367f, -0.8f),new Vector3f(0.2f, 0.4536f, -0.4f),new Vector3f(-0.2f, 0.4536f, -0.4f),new Vector2f(0.3437f, 0.375f),new Vector2f(0.6562f, 0.375f),new Vector2f(0.625f, 0.625f),new Vector2f(0.375f, 0.625f),new Vector3f(0.0f, -3.3608f, 0.97f));
		this.quads[5] = new ObjQuad(new Vector3f(0.25f, 0.367f, -0.8f),new Vector3f(0.5f, 0.8f, -0.8f),new Vector3f(0.4f, 0.8f, -0.4f),new Vector3f(0.2f, 0.4536f, -0.4f),new Vector2f(0.2294f, 0.375f),new Vector2f(0.5f, 0.375f),new Vector2f(0.5f, 0.625f),new Vector2f(0.2835f, 0.625f),new Vector3f(2.9104f, -1.6804f, 0.97f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.25f, 0.367f, -0.8f),new Vector3f(-0.5f, 0.8f, -0.8f),new Vector3f(-0.25f, 1.233f, -0.8f),new Vector3f(0.5f, 0.8f, -0.8f),new Vector2f(0.6563f, 0.2294f),new Vector2f(0.8125f, 0.5f),new Vector2f(0.6562f, 0.7706f),new Vector2f(0.1875f, 0.5f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.25f, 1.233f, -0.8f),new Vector3f(0.25f, 1.233f, -0.8f),new Vector3f(0.5f, 0.8f, -0.8f),new Vector2f(0.6562f, 0.7706f),new Vector2f(0.3437f, 0.7706f),new Vector2f(0.1875f, 0.5f),new Vector3f(0.0f, 0.0f, -3.0f));
		this.quads[8] = new ObjQuad(new Vector3f(0.25f, 0.367f, -0.8f),new Vector3f(-0.25f, 0.367f, -0.8f),new Vector3f(0.5f, 0.8f, -0.8f),new Vector2f(0.3438f, 0.2294f),new Vector2f(0.6563f, 0.2294f),new Vector2f(0.1875f, 0.5f),new Vector3f(0.0f, 0.0f, -3.0f));
		this.quads[9] = new ObjQuad(new Vector3f(0.1423f, 1.0464f, -0.6f),new Vector3f(-0.1423f, 1.0464f, -0.6f),new Vector3f(-0.2845f, 0.8f, -0.6f),new Vector3f(0.1423f, 0.5536f, -0.6f),new Vector2f(0.5889f, 0.654f),new Vector2f(0.4111f, 0.654f),new Vector2f(0.3222f, 0.5f),new Vector2f(0.5889f, 0.346f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[10] = new ObjQuad(new Vector3f(-0.2845f, 0.8f, -0.6f),new Vector3f(-0.1423f, 0.5536f, -0.6f),new Vector3f(0.1423f, 0.5536f, -0.6f),new Vector2f(0.3222f, 0.5f),new Vector2f(0.4111f, 0.346f),new Vector2f(0.5889f, 0.346f),new Vector3f(0.0f, 0.0f, 3.0f));
		this.quads[11] = new ObjQuad(new Vector3f(0.2845f, 0.8f, -0.6f),new Vector3f(0.1423f, 1.0464f, -0.6f),new Vector3f(0.1423f, 0.5536f, -0.6f),new Vector2f(0.6778f, 0.5f),new Vector2f(0.5889f, 0.654f),new Vector2f(0.5889f, 0.346f),new Vector3f(0.0f, 0.0f, 3.0f));
		this.quads[12] = new ObjQuad(new Vector3f(0.4f, 0.8f, -0.4f),new Vector3f(0.2f, 1.1464f, -0.4f),new Vector3f(0.1423f, 1.0464f, -0.4f),new Vector3f(0.2845f, 0.8f, -0.4f),new Vector2f(0.75f, 0.5f),new Vector2f(0.625f, 0.7165f),new Vector2f(0.5889f, 0.654f),new Vector2f(0.6778f, 0.5f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[13] = new ObjQuad(new Vector3f(0.2f, 1.1464f, -0.4f),new Vector3f(-0.2f, 1.1464f, -0.4f),new Vector3f(-0.1423f, 1.0464f, -0.4f),new Vector3f(0.1423f, 1.0464f, -0.4f),new Vector2f(0.625f, 0.7165f),new Vector2f(0.375f, 0.7165f),new Vector2f(0.4111f, 0.654f),new Vector2f(0.5889f, 0.654f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[14] = new ObjQuad(new Vector3f(-0.2f, 1.1464f, -0.4f),new Vector3f(-0.4f, 0.8f, -0.4f),new Vector3f(-0.2845f, 0.8f, -0.4f),new Vector3f(-0.1423f, 1.0464f, -0.4f),new Vector2f(0.375f, 0.7165f),new Vector2f(0.25f, 0.5f),new Vector2f(0.3222f, 0.5f),new Vector2f(0.4111f, 0.654f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[15] = new ObjQuad(new Vector3f(-0.4f, 0.8f, -0.4f),new Vector3f(-0.2f, 0.4536f, -0.4f),new Vector3f(-0.1423f, 0.5536f, -0.4f),new Vector3f(-0.2845f, 0.8f, -0.4f),new Vector2f(0.25f, 0.5f),new Vector2f(0.375f, 0.2835f),new Vector2f(0.4111f, 0.346f),new Vector2f(0.3222f, 0.5f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[16] = new ObjQuad(new Vector3f(-0.2f, 0.4536f, -0.4f),new Vector3f(0.2f, 0.4536f, -0.4f),new Vector3f(0.1423f, 0.5536f, -0.4f),new Vector3f(-0.1423f, 0.5536f, -0.4f),new Vector2f(0.375f, 0.2835f),new Vector2f(0.625f, 0.2835f),new Vector2f(0.5889f, 0.346f),new Vector2f(0.4111f, 0.346f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[17] = new ObjQuad(new Vector3f(0.2f, 0.4536f, -0.4f),new Vector3f(0.4f, 0.8f, -0.4f),new Vector3f(0.2845f, 0.8f, -0.4f),new Vector3f(0.1423f, 0.5536f, -0.4f),new Vector2f(0.625f, 0.2835f),new Vector2f(0.75f, 0.5f),new Vector2f(0.6778f, 0.5f),new Vector2f(0.5889f, 0.346f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[18] = new ObjQuad(new Vector3f(0.2845f, 0.8f, -0.4f),new Vector3f(0.1423f, 1.0464f, -0.4f),new Vector3f(0.1423f, 1.0464f, -0.6f),new Vector3f(0.2845f, 0.8f, -0.6f),new Vector2f(0.5f, 0.625f),new Vector2f(0.346f, 0.625f),new Vector2f(0.346f, 0.5f),new Vector2f(0.5f, 0.5f),new Vector3f(-3.464f, -2.0f, 0.0f));
		this.quads[19] = new ObjQuad(new Vector3f(0.1423f, 1.0464f, -0.4f),new Vector3f(-0.1423f, 1.0464f, -0.4f),new Vector3f(-0.1423f, 1.0464f, -0.6f),new Vector3f(0.1423f, 1.0464f, -0.6f),new Vector2f(0.5889f, 0.625f),new Vector2f(0.4111f, 0.625f),new Vector2f(0.4111f, 0.5f),new Vector2f(0.5889f, 0.5f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[20] = new ObjQuad(new Vector3f(-0.1423f, 1.0464f, -0.4f),new Vector3f(-0.2845f, 0.8f, -0.4f),new Vector3f(-0.2845f, 0.8f, -0.6f),new Vector3f(-0.1423f, 1.0464f, -0.6f),new Vector2f(0.654f, 0.625f),new Vector2f(0.5f, 0.625f),new Vector2f(0.5f, 0.5f),new Vector2f(0.654f, 0.5f),new Vector3f(3.464f, -2.0f, 0.0f));
		this.quads[21] = new ObjQuad(new Vector3f(-0.2845f, 0.8f, -0.4f),new Vector3f(-0.1423f, 0.5536f, -0.4f),new Vector3f(-0.1423f, 0.5536f, -0.6f),new Vector3f(-0.2845f, 0.8f, -0.6f),new Vector2f(0.5f, 0.625f),new Vector2f(0.346f, 0.625f),new Vector2f(0.346f, 0.5f),new Vector2f(0.5f, 0.5f),new Vector3f(3.464f, 2.0f, 0.0f));
		this.quads[22] = new ObjQuad(new Vector3f(-0.1423f, 0.5536f, -0.4f),new Vector3f(0.1423f, 0.5536f, -0.4f),new Vector3f(0.1423f, 0.5536f, -0.6f),new Vector3f(-0.1423f, 0.5536f, -0.6f),new Vector2f(0.5889f, 0.625f),new Vector2f(0.4111f, 0.625f),new Vector2f(0.4111f, 0.5f),new Vector2f(0.5889f, 0.5f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[23] = new ObjQuad(new Vector3f(0.1423f, 0.5536f, -0.4f),new Vector3f(0.2845f, 0.8f, -0.4f),new Vector3f(0.2845f, 0.8f, -0.6f),new Vector3f(0.1423f, 0.5536f, -0.6f),new Vector2f(0.654f, 0.625f),new Vector2f(0.5f, 0.625f),new Vector2f(0.5f, 0.5f),new Vector2f(0.654f, 0.5f),new Vector3f(-3.464f, 2.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Con1 other = new Con1();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

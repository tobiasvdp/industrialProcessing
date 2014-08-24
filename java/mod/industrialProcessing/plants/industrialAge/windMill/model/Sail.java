package  mod.industrialProcessing.plants.industrialAge.windMill.model;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Sail extends ObjMesh{
	public Sail(){
		this.quads = new ObjQuad[16];
		this.quads[0] = new ObjQuad(new Vector3f(-0.1f, -0.1f, -0.1f),new Vector3f(-0.1f, -0.1f, 0.1f),new Vector3f(-0.2f, -1.1f, -0.0f),new Vector3f(-0.2f, -1.1f, -0.0f),new Vector2f(0.9995f, 0.4849f),new Vector2f(5.0E-4f, 0.4849f),new Vector2f(0.5f, 0.3335f),new Vector2f(0.5f, 0.3335f),new Vector3f(3.98f, -0.398f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.1f, -0.1f, 0.1f),new Vector3f(-3.3f, -0.1f, 0.1f),new Vector3f(-3.2f, -1.1f, -0.0f),new Vector3f(-0.2f, -1.1f, -0.0f),new Vector2f(0.4849f, 0.4849f),new Vector2f(5.0E-4f, 0.4849f),new Vector2f(0.0156f, 0.3335f),new Vector2f(0.4697f, 0.3335f),new Vector3f(0.0f, -0.398f, 3.98f));
		this.quads[2] = new ObjQuad(new Vector3f(-3.3f, -0.1f, 0.1f),new Vector3f(-3.3f, -0.1f, -0.1f),new Vector3f(-3.2f, -1.1f, -0.0f),new Vector3f(-3.2f, -1.1f, -0.0f),new Vector2f(0.9995f, 0.4849f),new Vector2f(5.0E-4f, 0.4849f),new Vector2f(0.5f, 0.3335f),new Vector2f(0.5f, 0.3335f),new Vector3f(-3.98f, -0.398f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(-3.3f, -0.1f, -0.1f),new Vector3f(-0.1f, -0.1f, -0.1f),new Vector3f(-0.2f, -1.1f, -0.0f),new Vector3f(-3.2f, -1.1f, -0.0f),new Vector2f(0.9995f, 0.4849f),new Vector2f(0.5151f, 0.4849f),new Vector2f(0.5303f, 0.3335f),new Vector2f(0.9844f, 0.3335f),new Vector3f(0.0f, -0.398f, -3.98f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.1f, 0.1f, -0.1f),new Vector3f(-0.1f, 0.1f, 0.1f),new Vector3f(-1.1f, 0.2f, -0.0f),new Vector3f(-1.1f, 0.2f, -0.0f),new Vector2f(0.5151f, 0.9995f),new Vector2f(0.5151f, 5.0E-4f),new Vector2f(0.6665f, 0.5f),new Vector2f(0.6665f, 0.5f),new Vector3f(-0.398f, -3.98f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.1f, 0.1f, 0.1f),new Vector3f(-0.1f, 3.3f, 0.1f),new Vector3f(-1.1f, 3.2f, -0.0f),new Vector3f(-1.1f, 0.2f, -0.0f),new Vector2f(0.4849f, 0.5151f),new Vector2f(0.4849f, 0.9995f),new Vector2f(0.3335f, 0.9844f),new Vector2f(0.3335f, 0.5303f),new Vector3f(-0.398f, 0.0f, 3.98f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.1f, 3.3f, 0.1f),new Vector3f(-0.1f, 3.3f, -0.1f),new Vector3f(-1.1f, 3.2f, -0.0f),new Vector3f(-1.1f, 3.2f, -0.0f),new Vector2f(0.4849f, 5.0E-4f),new Vector2f(0.4849f, 0.9995f),new Vector2f(0.3335f, 0.5f),new Vector2f(0.3335f, 0.5f),new Vector3f(-0.398f, 3.98f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.1f, 3.3f, -0.1f),new Vector3f(-0.1f, 0.1f, -0.1f),new Vector3f(-1.1f, 0.2f, -0.0f),new Vector3f(-1.1f, 3.2f, -0.0f),new Vector2f(0.5151f, 0.9995f),new Vector2f(0.5151f, 0.5151f),new Vector2f(0.6665f, 0.5303f),new Vector2f(0.6665f, 0.9844f),new Vector3f(-0.398f, 0.0f, -3.98f));
		this.quads[8] = new ObjQuad(new Vector3f(0.1f, 0.1f, -0.1f),new Vector3f(0.1f, 0.1f, 0.1f),new Vector3f(0.2f, 1.1f, -0.0f),new Vector3f(0.2f, 1.1f, -0.0f),new Vector2f(5.0E-4f, 0.5151f),new Vector2f(0.9995f, 0.5151f),new Vector2f(0.5f, 0.6665f),new Vector2f(0.5f, 0.6665f),new Vector3f(-3.98f, 0.398f, 0.0f));
		this.quads[9] = new ObjQuad(new Vector3f(0.1f, 0.1f, 0.1f),new Vector3f(3.3f, 0.1f, 0.1f),new Vector3f(3.2f, 1.1f, -0.0f),new Vector3f(0.2f, 1.1f, -0.0f),new Vector2f(0.5151f, 0.5151f),new Vector2f(0.9995f, 0.5151f),new Vector2f(0.9844f, 0.6665f),new Vector2f(0.5303f, 0.6665f),new Vector3f(0.0f, 0.398f, 3.98f));
		this.quads[10] = new ObjQuad(new Vector3f(3.3f, 0.1f, 0.1f),new Vector3f(3.3f, 0.1f, -0.1f),new Vector3f(3.2f, 1.1f, -0.0f),new Vector3f(3.2f, 1.1f, -0.0f),new Vector2f(5.0E-4f, 0.5151f),new Vector2f(0.9995f, 0.5151f),new Vector2f(0.5f, 0.6665f),new Vector2f(0.5f, 0.6665f),new Vector3f(3.98f, 0.398f, 0.0f));
		this.quads[11] = new ObjQuad(new Vector3f(3.3f, 0.1f, -0.1f),new Vector3f(0.1f, 0.1f, -0.1f),new Vector3f(0.2f, 1.1f, -0.0f),new Vector3f(3.2f, 1.1f, -0.0f),new Vector2f(5.0E-4f, 0.5151f),new Vector2f(0.4849f, 0.5151f),new Vector2f(0.4697f, 0.6665f),new Vector2f(0.0156f, 0.6665f),new Vector3f(0.0f, 0.398f, -3.98f));
		this.quads[12] = new ObjQuad(new Vector3f(0.1f, -0.1f, -0.1f),new Vector3f(0.1f, -0.1f, 0.1f),new Vector3f(1.1f, -0.2f, -0.0f),new Vector3f(1.1f, -0.2f, -0.0f),new Vector2f(0.5151f, 0.9995f),new Vector2f(0.5151f, 5.0E-4f),new Vector2f(0.6665f, 0.5f),new Vector2f(0.6665f, 0.5f),new Vector3f(0.398f, 3.98f, 0.0f));
		this.quads[13] = new ObjQuad(new Vector3f(0.1f, -0.1f, 0.1f),new Vector3f(0.1f, -3.3f, 0.1f),new Vector3f(1.1f, -3.2f, -0.0f),new Vector3f(1.1f, -0.2f, -0.0f),new Vector2f(0.5151f, 0.4849f),new Vector2f(0.5151f, 5.0E-4f),new Vector2f(0.6665f, 0.0156f),new Vector2f(0.6665f, 0.4697f),new Vector3f(0.398f, 0.0f, 3.98f));
		this.quads[14] = new ObjQuad(new Vector3f(0.1f, -3.3f, 0.1f),new Vector3f(0.1f, -3.3f, -0.1f),new Vector3f(1.1f, -3.2f, -0.0f),new Vector3f(1.1f, -3.2f, -0.0f),new Vector2f(0.4849f, 5.0E-4f),new Vector2f(0.4849f, 0.9995f),new Vector2f(0.3335f, 0.5f),new Vector2f(0.3335f, 0.5f),new Vector3f(0.398f, -3.98f, 0.0f));
		this.quads[15] = new ObjQuad(new Vector3f(0.1f, -3.3f, -0.1f),new Vector3f(0.1f, -0.1f, -0.1f),new Vector3f(1.1f, -0.2f, -0.0f),new Vector3f(1.1f, -3.2f, -0.0f),new Vector2f(0.4849f, 5.0E-4f),new Vector2f(0.4849f, 0.4849f),new Vector2f(0.3335f, 0.4697f),new Vector2f(0.3335f, 0.0156f),new Vector3f(0.398f, 0.0f, -3.98f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Sail other = new Sail();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

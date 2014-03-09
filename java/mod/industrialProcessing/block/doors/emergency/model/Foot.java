package mod.industrialProcessing.block.doors.emergency.model;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Foot extends ObjMesh{
	public Foot(){
		this.quads = new ObjQuad[6];
		this.quads[0] = new ObjQuad(new Vector3f(-0.7f, 0.0f, 0.07f),new Vector3f(-0.7f, 0.0f, -0.07f),new Vector3f(0.7f, 0.0f, -0.07f),new Vector3f(0.7f, 0.0f, 0.07f),new Vector2f(0.9375f, 0.4563f),new Vector2f(0.9375f, 0.5438f),new Vector2f(0.0625f, 0.5437f),new Vector2f(0.0625f, 0.4562f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.7f, 0.6f, 0.07f),new Vector3f(0.7f, 0.6f, 0.07f),new Vector3f(0.7f, 0.6f, -0.07f),new Vector3f(-0.7f, 0.6f, -0.07f),new Vector2f(0.0625f, 0.4563f),new Vector2f(0.9375f, 0.4562f),new Vector2f(0.9375f, 0.5437f),new Vector2f(0.0625f, 0.5438f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.7f, 0.0f, 0.07f),new Vector3f(0.7f, 0.0f, 0.07f),new Vector3f(0.7f, 0.6f, 0.07f),new Vector3f(-0.7f, 0.6f, 0.07f),new Vector2f(0.0625f, 0.3125f),new Vector2f(0.9375f, 0.3125f),new Vector2f(0.9375f, 0.6875f),new Vector2f(0.0625f, 0.6875f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.7f, 0.0f, 0.07f),new Vector3f(0.7f, 0.0f, -0.07f),new Vector3f(0.7f, 0.6f, -0.07f),new Vector3f(0.7f, 0.6f, 0.07f),new Vector2f(0.4562f, 0.3125f),new Vector2f(0.5437f, 0.3125f),new Vector2f(0.5437f, 0.6875f),new Vector2f(0.4562f, 0.6875f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.7f, 0.0f, -0.07f),new Vector3f(-0.7f, 0.0f, -0.07f),new Vector3f(-0.7f, 0.6f, -0.07f),new Vector3f(0.7f, 0.6f, -0.07f),new Vector2f(0.0625f, 0.3125f),new Vector2f(0.9375f, 0.3125f),new Vector2f(0.9375f, 0.6875f),new Vector2f(0.0625f, 0.6875f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.7f, 0.0f, -0.07f),new Vector3f(-0.7f, 0.0f, 0.07f),new Vector3f(-0.7f, 0.6f, 0.07f),new Vector3f(-0.7f, 0.6f, -0.07f),new Vector2f(0.4562f, 0.3125f),new Vector2f(0.5437f, 0.3125f),new Vector2f(0.5437f, 0.6875f),new Vector2f(0.4562f, 0.6875f),new Vector3f(-4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Foot other = new Foot();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

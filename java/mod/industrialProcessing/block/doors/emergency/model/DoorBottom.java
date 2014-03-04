package mod.industrialProcessing.block.doors.emergency.model;
import mod.industrialProcessing.client.rendering.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class DoorBottom extends ObjMesh{
	public DoorBottom(){
		this.quads = new ObjQuad[6];
		this.quads[0] = new ObjQuad(new Vector3f(-0.8f, 0.0f, 0.05f),new Vector3f(-0.8f, 0.0f, -0.05f),new Vector3f(0.8f, 0.0f, -0.05f),new Vector3f(0.8f, 0.0f, 0.05f),new Vector2f(1.0f, 0.4688f),new Vector2f(1.0f, 0.5313f),new Vector2f(0.0f, 0.5312f),new Vector2f(0.0f, 0.4687f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.8f, 1.6f, 0.05f),new Vector3f(0.8f, 1.6f, 0.05f),new Vector3f(0.8f, 1.6f, -0.05f),new Vector3f(-0.8f, 1.6f, -0.05f),new Vector2f(0.0f, 0.4688f),new Vector2f(1.0f, 0.4687f),new Vector2f(1.0f, 0.5312f),new Vector2f(0.0f, 0.5313f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.8f, 0.0f, 0.05f),new Vector3f(0.8f, 0.0f, 0.05f),new Vector3f(0.8f, 1.6f, 0.05f),new Vector3f(-0.8f, 1.6f, 0.05f),new Vector2f(0.0f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.8f, 0.0f, 0.05f),new Vector3f(0.8f, 0.0f, -0.05f),new Vector3f(0.8f, 1.6f, -0.05f),new Vector3f(0.8f, 1.6f, 0.05f),new Vector2f(0.4687f, 0.0f),new Vector2f(0.5312f, 0.0f),new Vector2f(0.5312f, 1.0f),new Vector2f(0.4687f, 1.0f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.8f, 0.0f, -0.05f),new Vector3f(-0.8f, 0.0f, -0.05f),new Vector3f(-0.8f, 1.6f, -0.05f),new Vector3f(0.8f, 1.6f, -0.05f),new Vector2f(0.0f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.8f, 0.0f, -0.05f),new Vector3f(-0.8f, 0.0f, 0.05f),new Vector3f(-0.8f, 1.6f, 0.05f),new Vector3f(-0.8f, 1.6f, -0.05f),new Vector2f(0.4687f, 0.0f),new Vector2f(0.5312f, 0.0f),new Vector2f(0.5312f, 1.0f),new Vector2f(0.4687f, 1.0f),new Vector3f(-4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		DoorBottom other = new DoorBottom();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

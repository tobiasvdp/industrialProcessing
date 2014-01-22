package ip.industrialProcessing.decoration.doors.emergency.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Lock extends ObjMesh{
	public Lock(){
		this.quads = new ObjQuad[16];
		this.quads[0] = new ObjQuad(new Vector3f(0.54f, 1.2f, 0.05f),new Vector3f(0.54f, 1.2f, -0.05f),new Vector3f(0.74f, 1.2f, -0.05f),new Vector3f(0.74f, 1.2f, 0.05f),new Vector2f(0.1625f, 0.4687f),new Vector2f(0.1625f, 0.5312f),new Vector2f(0.0375f, 0.5312f),new Vector2f(0.0375f, 0.4687f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.54f, 1.6f, 0.05f),new Vector3f(0.74f, 1.6f, 0.05f),new Vector3f(0.74f, 1.6f, -0.05f),new Vector3f(0.54f, 1.6f, -0.05f),new Vector2f(0.8375f, 0.4687f),new Vector2f(0.9625f, 0.4687f),new Vector2f(0.9625f, 0.5312f),new Vector2f(0.8375f, 0.5312f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.54f, 1.3f, 0.15f),new Vector3f(0.74f, 1.3f, 0.15f),new Vector3f(0.74f, 1.5f, 0.15f),new Vector3f(0.54f, 1.5f, 0.15f),new Vector2f(0.8375f, 0.8125f),new Vector2f(0.9625f, 0.8125f),new Vector2f(0.9625f, 0.9375f),new Vector2f(0.8375f, 0.9375f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.74f, 1.2f, 0.05f),new Vector3f(0.74f, 1.2f, -0.05f),new Vector3f(0.74f, 1.3f, -0.15f),new Vector3f(0.74f, 1.6f, -0.05f),new Vector2f(0.4687f, 0.75f),new Vector2f(0.5312f, 0.75f),new Vector2f(0.5937f, 0.8125f),new Vector2f(0.5312f, 1.0f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.74f, 1.3f, -0.15f),new Vector3f(0.74f, 1.5f, -0.15f),new Vector3f(0.74f, 1.6f, -0.05f),new Vector2f(0.5937f, 0.8125f),new Vector2f(0.5937f, 0.9375f),new Vector2f(0.5312f, 1.0f),new Vector3f(3.0f, 0.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(0.74f, 1.6f, -0.05f),new Vector3f(0.74f, 1.6f, 0.05f),new Vector3f(0.74f, 1.5f, 0.15f),new Vector3f(0.74f, 1.2f, 0.05f),new Vector2f(0.5312f, 1.0f),new Vector2f(0.4687f, 1.0f),new Vector2f(0.4062f, 0.9375f),new Vector2f(0.4687f, 0.75f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(0.74f, 1.3f, 0.15f),new Vector3f(0.74f, 1.2f, 0.05f),new Vector3f(0.74f, 1.5f, 0.15f),new Vector2f(0.4062f, 0.8125f),new Vector2f(0.4687f, 0.75f),new Vector2f(0.4062f, 0.9375f),new Vector3f(3.0f, 0.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(0.74f, 1.3f, -0.15f),new Vector3f(0.54f, 1.3f, -0.15f),new Vector3f(0.54f, 1.5f, -0.15f),new Vector3f(0.74f, 1.5f, -0.15f),new Vector2f(0.0375f, 0.8125f),new Vector2f(0.1625f, 0.8125f),new Vector2f(0.1625f, 0.9375f),new Vector2f(0.0375f, 0.9375f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[8] = new ObjQuad(new Vector3f(0.54f, 1.2f, -0.05f),new Vector3f(0.54f, 1.2f, 0.05f),new Vector3f(0.54f, 1.3f, 0.15f),new Vector3f(0.54f, 1.6f, 0.05f),new Vector2f(0.4688f, 0.75f),new Vector2f(0.5313f, 0.75f),new Vector2f(0.5938f, 0.8125f),new Vector2f(0.5313f, 1.0f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[9] = new ObjQuad(new Vector3f(0.54f, 1.3f, 0.15f),new Vector3f(0.54f, 1.5f, 0.15f),new Vector3f(0.54f, 1.6f, 0.05f),new Vector2f(0.5938f, 0.8125f),new Vector2f(0.5938f, 0.9375f),new Vector2f(0.5313f, 1.0f),new Vector3f(-3.0f, 0.0f, 0.0f));
		this.quads[10] = new ObjQuad(new Vector3f(0.54f, 1.6f, 0.05f),new Vector3f(0.54f, 1.6f, -0.05f),new Vector3f(0.54f, 1.5f, -0.15f),new Vector3f(0.54f, 1.2f, -0.05f),new Vector2f(0.5313f, 1.0f),new Vector2f(0.4688f, 1.0f),new Vector2f(0.4063f, 0.9375f),new Vector2f(0.4688f, 0.75f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[11] = new ObjQuad(new Vector3f(0.54f, 1.3f, -0.15f),new Vector3f(0.54f, 1.2f, -0.05f),new Vector3f(0.54f, 1.5f, -0.15f),new Vector2f(0.4063f, 0.8125f),new Vector2f(0.4688f, 0.75f),new Vector2f(0.4063f, 0.9375f),new Vector3f(-3.0f, 0.0f, 0.0f));
		this.quads[12] = new ObjQuad(new Vector3f(0.54f, 1.2f, -0.05f),new Vector3f(0.54f, 1.3f, -0.15f),new Vector3f(0.74f, 1.3f, -0.15f),new Vector3f(0.74f, 1.2f, -0.05f),new Vector2f(0.1625f, 0.75f),new Vector2f(0.1625f, 0.8125f),new Vector2f(0.0375f, 0.8125f),new Vector2f(0.0375f, 0.75f),new Vector3f(0.0f, -2.8284f, -2.8284f));
		this.quads[13] = new ObjQuad(new Vector3f(0.74f, 1.2f, 0.05f),new Vector3f(0.74f, 1.3f, 0.15f),new Vector3f(0.54f, 1.3f, 0.15f),new Vector3f(0.54f, 1.2f, 0.05f),new Vector2f(0.9625f, 0.75f),new Vector2f(0.9625f, 0.8125f),new Vector2f(0.8375f, 0.8125f),new Vector2f(0.8375f, 0.75f),new Vector3f(0.0f, -2.8284f, 2.8284f));
		this.quads[14] = new ObjQuad(new Vector3f(0.54f, 1.6f, 0.05f),new Vector3f(0.54f, 1.5f, 0.15f),new Vector3f(0.74f, 1.5f, 0.15f),new Vector3f(0.74f, 1.6f, 0.05f),new Vector2f(0.8375f, 1.0f),new Vector2f(0.8375f, 0.9375f),new Vector2f(0.9625f, 0.9375f),new Vector2f(0.9625f, 1.0f),new Vector3f(0.0f, 2.8284f, 2.8284f));
		this.quads[15] = new ObjQuad(new Vector3f(0.74f, 1.6f, -0.05f),new Vector3f(0.74f, 1.5f, -0.15f),new Vector3f(0.54f, 1.5f, -0.15f),new Vector3f(0.54f, 1.6f, -0.05f),new Vector2f(0.0375f, 1.0f),new Vector2f(0.0375f, 0.9375f),new Vector2f(0.1625f, 0.9375f),new Vector2f(0.1625f, 1.0f),new Vector3f(0.0f, 2.8284f, -2.8284f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Lock other = new Lock();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

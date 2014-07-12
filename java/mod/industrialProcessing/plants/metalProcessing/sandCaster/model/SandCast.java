package ip.industrialProcessing.machines.plants.metalProcessing.sandCaster.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class SandCast extends ObjMesh{
	public SandCast(){
		this.quads = new ObjQuad[9];
		this.quads[0] = new ObjQuad(new Vector3f(-0.05f, 0.8f, 0.05f),new Vector3f(0.05f, 0.8f, 0.05f),new Vector3f(0.05f, 0.8f, -0.05f),new Vector3f(-0.05f, 0.8f, -0.05f),new Vector2f(0.4687f, 0.4687f),new Vector2f(0.5313f, 0.4687f),new Vector2f(0.5313f, 0.5313f),new Vector2f(0.4687f, 0.5313f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.5f, 0.9f, -0.5f),new Vector3f(-0.5f, 0.9f, 0.5f),new Vector3f(-0.05f, 0.9f, 0.05f),new Vector3f(-0.05f, 0.9f, -0.05f),new Vector2f(0.1875f, 0.8125f),new Vector2f(0.1875f, 0.1875f),new Vector2f(0.4687f, 0.4687f),new Vector2f(0.4687f, 0.5313f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.5f, 0.9f, 0.5f),new Vector3f(0.5f, 0.9f, 0.5f),new Vector3f(0.05f, 0.9f, 0.05f),new Vector3f(-0.05f, 0.9f, 0.05f),new Vector2f(0.1875f, 0.1875f),new Vector2f(0.8125f, 0.1875f),new Vector2f(0.5313f, 0.4687f),new Vector2f(0.4687f, 0.4687f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.5f, 0.9f, 0.5f),new Vector3f(0.5f, 0.9f, -0.5f),new Vector3f(0.05f, 0.9f, -0.05f),new Vector3f(0.05f, 0.9f, 0.05f),new Vector2f(0.8125f, 0.1875f),new Vector2f(0.8125f, 0.8125f),new Vector2f(0.5313f, 0.5313f),new Vector2f(0.5313f, 0.4687f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.5f, 0.9f, -0.5f),new Vector3f(-0.5f, 0.9f, -0.5f),new Vector3f(-0.05f, 0.9f, -0.05f),new Vector3f(0.05f, 0.9f, -0.05f),new Vector2f(0.8125f, 0.8125f),new Vector2f(0.1875f, 0.8125f),new Vector2f(0.4687f, 0.5313f),new Vector2f(0.5313f, 0.5313f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.05f, 0.9f, -0.05f),new Vector3f(-0.05f, 0.9f, 0.05f),new Vector3f(-0.05f, 0.8f, 0.05f),new Vector3f(-0.05f, 0.8f, -0.05f),new Vector2f(0.4687f, 0.5313f),new Vector2f(0.4687f, 0.4687f),new Vector2f(0.4687f, 0.4687f),new Vector2f(0.4687f, 0.5313f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.05f, 0.9f, 0.05f),new Vector3f(0.05f, 0.9f, 0.05f),new Vector3f(0.05f, 0.8f, 0.05f),new Vector3f(-0.05f, 0.8f, 0.05f),new Vector2f(0.4687f, 0.4687f),new Vector2f(0.5313f, 0.4687f),new Vector2f(0.5313f, 0.4687f),new Vector2f(0.4687f, 0.4687f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[7] = new ObjQuad(new Vector3f(0.05f, 0.9f, 0.05f),new Vector3f(0.05f, 0.9f, -0.05f),new Vector3f(0.05f, 0.8f, -0.05f),new Vector3f(0.05f, 0.8f, 0.05f),new Vector2f(0.5313f, 0.4687f),new Vector2f(0.5313f, 0.5313f),new Vector2f(0.5313f, 0.5313f),new Vector2f(0.5313f, 0.4687f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(0.05f, 0.9f, -0.05f),new Vector3f(-0.05f, 0.9f, -0.05f),new Vector3f(-0.05f, 0.8f, -0.05f),new Vector3f(0.05f, 0.8f, -0.05f),new Vector2f(0.5313f, 0.5313f),new Vector2f(0.4687f, 0.5313f),new Vector2f(0.4687f, 0.5313f),new Vector2f(0.5313f, 0.5313f),new Vector3f(0.0f, 0.0f, 4.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		SandCast other = new SandCast();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

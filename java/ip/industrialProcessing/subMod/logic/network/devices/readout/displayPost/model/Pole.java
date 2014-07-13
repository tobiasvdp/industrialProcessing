package ip.industrialProcessing.subMod.logic.network.devices.readout.displayPost.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Pole extends ObjMesh{
	public Pole(){
		this.quads = new ObjQuad[8];
		this.quads[0] = new ObjQuad(new Vector3f(-0.4f, 0.25f, 0.0f),new Vector3f(-0.0f, 0.25f, -0.4f),new Vector3f(0.4f, 0.25f, -0.0f),new Vector2f(0.25f, 0.0f),new Vector2f(0.0f, 0.0f),new Vector2f(-0.25f, 0.0f),new Vector3f(0.0f, -3.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.4f, 0.25f, -0.0f),new Vector3f(0.0f, 0.25f, 0.4f),new Vector3f(-0.4f, 0.25f, 0.0f),new Vector2f(0.75f, 0.0f),new Vector2f(0.5f, 0.0f),new Vector2f(0.25f, 0.0f),new Vector3f(0.0f, -3.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.4f, 0.25f, -0.0f),new Vector3f(-0.0f, 0.25f, -0.4f),new Vector3f(-0.0f, 1.2f, -0.2f),new Vector3f(0.2f, 1.2f, -0.0f),new Vector2f(-0.25f, 0.0f),new Vector2f(0.0f, 0.0f),new Vector2f(0.0f, 1.0f),new Vector2f(-0.25f, 1.0f),new Vector3f(1.957f, 0.824f, -1.957f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.0f, 0.25f, -0.4f),new Vector3f(-0.4f, 0.25f, 0.0f),new Vector3f(-0.2f, 1.2f, 0.0f),new Vector3f(-0.0f, 1.2f, -0.2f),new Vector2f(0.0f, 0.0f),new Vector2f(0.25f, 0.0f),new Vector2f(0.25f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector3f(-1.957f, 0.824f, -1.957f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.4f, 0.25f, 0.0f),new Vector3f(0.0f, 0.25f, 0.4f),new Vector3f(0.0f, 1.2f, 0.2f),new Vector3f(-0.2f, 1.2f, 0.0f),new Vector2f(0.25f, 0.0f),new Vector2f(0.5f, 0.0f),new Vector2f(0.5f, 1.0f),new Vector2f(0.25f, 1.0f),new Vector3f(-1.957f, 0.824f, 1.957f));
		this.quads[5] = new ObjQuad(new Vector3f(0.0f, 0.25f, 0.4f),new Vector3f(0.4f, 0.25f, -0.0f),new Vector3f(0.2f, 1.2f, -0.0f),new Vector3f(0.0f, 1.2f, 0.2f),new Vector2f(0.5f, 0.0f),new Vector2f(0.75f, 0.0f),new Vector2f(0.75f, 1.0f),new Vector2f(0.5f, 1.0f),new Vector3f(1.957f, 0.824f, 1.957f));
		this.quads[6] = new ObjQuad(new Vector3f(0.0f, 1.2f, 0.2f),new Vector3f(0.2f, 1.2f, -0.0f),new Vector3f(-0.0f, 1.2f, -0.2f),new Vector2f(1.0f, 1.0f),new Vector2f(-0.25f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector3f(0.0f, 3.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.0f, 1.2f, -0.2f),new Vector3f(-0.2f, 1.2f, 0.0f),new Vector3f(0.0f, 1.2f, 0.2f),new Vector2f(0.0f, 1.0f),new Vector2f(0.25f, 1.0f),new Vector2f(0.5f, 1.0f),new Vector3f(0.0f, 3.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Pole other = new Pole();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

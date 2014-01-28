package ip.industrialProcessing.subMod.logic.network.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Down extends ObjMesh{
	public Down(){
		this.quads = new ObjQuad[5];
		this.quads[0] = new ObjQuad(new Vector3f(0.2f, 0.2f, -0.2f),new Vector3f(-0.2f, 0.2f, -0.2f),new Vector3f(-0.2f, 0.2f, 0.2f),new Vector3f(0.2f, 0.2f, 0.2f),new Vector2f(0.25f, 0.25f),new Vector2f(0.0f, 0.25f),new Vector2f(0.0f, 0.0f),new Vector2f(0.25f, 0.0f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.2f, 0.2f, 0.2f),new Vector3f(-0.2f, 0.2f, 0.2f),new Vector3f(-0.2f, 0.0f, 0.2f),new Vector3f(0.2f, 0.0f, 0.2f),new Vector2f(0.5f, 0.25f),new Vector2f(0.25f, 0.25f),new Vector2f(0.25f, 0.125f),new Vector2f(0.5f, 0.125f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.2f, 0.2f, -0.2f),new Vector3f(0.2f, 0.2f, 0.2f),new Vector3f(0.2f, 0.0f, 0.2f),new Vector3f(0.2f, 0.0f, -0.2f),new Vector2f(0.5f, 0.125f),new Vector2f(0.25f, 0.125f),new Vector2f(0.25f, 0.0f),new Vector2f(0.5f, 0.0f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.2f, 0.2f, -0.2f),new Vector3f(0.2f, 0.2f, -0.2f),new Vector3f(0.2f, 0.0f, -0.2f),new Vector3f(-0.2f, 0.0f, -0.2f),new Vector2f(0.5f, 0.375f),new Vector2f(0.25f, 0.375f),new Vector2f(0.25f, 0.25f),new Vector2f(0.5f, 0.25f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.2f, 0.2f, 0.2f),new Vector3f(-0.2f, 0.2f, -0.2f),new Vector3f(-0.2f, 0.0f, -0.2f),new Vector3f(-0.2f, 0.0f, 0.2f),new Vector2f(0.5f, 0.5f),new Vector2f(0.25f, 0.5f),new Vector2f(0.25f, 0.375f),new Vector2f(0.5f, 0.375f),new Vector3f(-4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Down other = new Down();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

package ip.industrialProcessing.subMod.logic.network.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class EastRightCorner extends ObjMesh{
	public EastRightCorner(){
		this.quads = new ObjQuad[4];
		this.quads[0] = new ObjQuad(new Vector3f(0.6f, 0.6f, 1.0f),new Vector3f(0.6f, 0.6f, 0.8f),new Vector3f(0.8f, 0.6f, 0.8f),new Vector3f(0.8f, 0.6f, 1.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector2f(0.0f, 0.0f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.6f, 1.0f, 1.0f),new Vector3f(0.8f, 1.0f, 1.0f),new Vector3f(0.8f, 1.0f, 0.8f),new Vector3f(0.6f, 1.0f, 0.8f),new Vector2f(0.0f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.6f, 0.6f, 1.0f),new Vector3f(0.8f, 0.6f, 1.0f),new Vector3f(0.8f, 1.0f, 1.0f),new Vector3f(0.6f, 1.0f, 1.0f),new Vector2f(0.0f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.8f, 0.6f, 1.0f),new Vector3f(0.8f, 0.6f, 0.8f),new Vector3f(0.8f, 1.0f, 0.8f),new Vector3f(0.8f, 1.0f, 1.0f),new Vector2f(0.0f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector3f(4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		EastRightCorner other = new EastRightCorner();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

package ip.industrialProcessing.subMod.mine.machines.mining.bobcatMiner.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Glass extends ObjMesh{
	public Glass(){
		this.quads = new ObjQuad[6];
		this.quads[0] = new ObjQuad(new Vector3f(0.55f, 1.6f, 0.4f),new Vector3f(0.55f, 1.6f, -0.8f),new Vector3f(0.55f, 3.0f, -0.8f),new Vector3f(0.55f, 3.0f, 0.4f),new Vector2f(0.0f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.45f, 1.6f, -0.8f),new Vector3f(0.45f, 1.6f, 0.4f),new Vector3f(0.45f, 3.0f, 0.4f),new Vector3f(0.45f, 3.0f, -0.8f),new Vector2f(0.0f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.45f, 1.6f, 0.4f),new Vector3f(-0.45f, 1.6f, -0.8f),new Vector3f(-0.45f, 3.0f, -0.8f),new Vector3f(-0.45f, 3.0f, 0.4f),new Vector2f(0.0f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.55f, 1.6f, -0.8f),new Vector3f(-0.55f, 1.6f, 0.4f),new Vector3f(-0.55f, 3.0f, 0.4f),new Vector3f(-0.55f, 3.0f, -0.8f),new Vector2f(0.0f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.4f, 1.6f, 0.55f),new Vector3f(0.4f, 1.6f, 0.55f),new Vector3f(0.4f, 3.0f, 0.55f),new Vector3f(-0.4f, 3.0f, 0.55f),new Vector2f(0.0f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[5] = new ObjQuad(new Vector3f(0.4f, 1.6f, 0.45f),new Vector3f(-0.4f, 1.6f, 0.45f),new Vector3f(-0.4f, 3.0f, 0.45f),new Vector3f(0.4f, 3.0f, 0.45f),new Vector2f(0.0f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector3f(0.0f, 0.0f, -4.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Glass other = new Glass();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

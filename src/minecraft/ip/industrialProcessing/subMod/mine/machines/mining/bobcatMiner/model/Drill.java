package ip.industrialProcessing.subMod.mine.machines.mining.bobcatMiner.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Drill extends ObjMesh{
	public Drill(){
		this.quads = new ObjQuad[9];
		this.quads[0] = new ObjQuad(new Vector3f(-0.8f, 0.9f, 1.5f),new Vector3f(-0.4f, 0.2072f, 1.5f),new Vector3f(-0.0f, 0.9f, 4.5f),new Vector3f(-0.0f, 0.9f, 4.5f),new Vector2f(0.75f, 0.0f),new Vector2f(0.5833f, 0.0f),new Vector2f(0.5f, 1.0f),new Vector2f(0.5f, 1.0f),new Vector3f(-3.1369002f, -0.8368f, 0.9654f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.4f, 0.2072f, 1.5f),new Vector3f(0.4f, 0.2072f, 1.5f),new Vector3f(-0.0f, 0.9f, 4.5f),new Vector3f(-0.0f, 0.9f, 4.5f),new Vector2f(0.5833f, 0.0f),new Vector2f(0.4167f, 0.0f),new Vector2f(0.5f, 1.0f),new Vector2f(0.5f, 1.0f),new Vector3f(-0.8438f, -3.1352f, 0.9654f));
		this.quads[2] = new ObjQuad(new Vector3f(0.4f, 0.2072f, 1.5f),new Vector3f(0.8f, 0.9f, 1.5f),new Vector3f(-0.0f, 0.9f, 4.5f),new Vector3f(-0.0f, 0.9f, 4.5f),new Vector2f(0.4167f, 0.0f),new Vector2f(0.25f, 0.0f),new Vector2f(0.5f, 1.0f),new Vector2f(0.5f, 1.0f),new Vector3f(2.2931f, -2.2984f, 0.9654f));
		this.quads[3] = new ObjQuad(new Vector3f(0.8f, 0.9f, 1.5f),new Vector3f(0.4f, 1.5928f, 1.5f),new Vector3f(-0.0f, 0.9f, 4.5f),new Vector3f(-0.0f, 0.9f, 4.5f),new Vector2f(0.25f, 0.0f),new Vector2f(0.0833f, 0.0f),new Vector2f(0.5f, 1.0f),new Vector2f(0.5f, 1.0f),new Vector3f(3.1369002f, 0.8368f, 0.9654f));
		this.quads[4] = new ObjQuad(new Vector3f(0.4f, 1.5928f, 1.5f),new Vector3f(-0.4f, 1.5928f, 1.5f),new Vector3f(-0.0f, 0.9f, 4.5f),new Vector3f(-0.0f, 0.9f, 4.5f),new Vector2f(-0.9167f, 0.0f),new Vector2f(-0.0833f, 0.0f),new Vector2f(-0.5f, 1.0f),new Vector2f(-0.5f, 1.0f),new Vector3f(0.8438f, 3.1352f, 0.9654f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.4f, 1.5928f, 1.5f),new Vector3f(-0.8f, 0.9f, 1.5f),new Vector3f(-0.0f, 0.9f, 4.5f),new Vector3f(-0.0f, 0.9f, 4.5f),new Vector2f(0.9167f, 0.0f),new Vector2f(0.75f, 0.0f),new Vector2f(0.5f, 1.0f),new Vector2f(0.5f, 1.0f),new Vector3f(-2.2931f, 2.2984f, 0.9654f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.0f, 0.9f, 4.5f),new Vector3f(-0.0f, 0.9f, 4.5f),new Vector3f(-0.0f, 0.9f, 4.5f),new Vector3f(-0.0f, 0.9f, 4.5f),new Vector2f(0.5f, 1.0f),new Vector2f(0.5f, 1.0f),new Vector2f(0.5f, 1.0f),new Vector2f(0.5f, 1.0f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.0f, 0.9f, 4.5f),new Vector3f(-0.0f, 0.9f, 4.5f),new Vector3f(-0.0f, 0.9f, 4.5f),new Vector2f(0.5f, 1.0f),new Vector2f(0.5f, 1.0f),new Vector2f(0.5f, 1.0f),new Vector3f(-3.0f, 0.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(-0.0f, 0.9f, 4.5f),new Vector3f(-0.0f, 0.9f, 4.5f),new Vector3f(-0.0f, 0.9f, 4.5f),new Vector2f(0.5f, 1.0f),new Vector2f(0.5f, 1.0f),new Vector2f(0.5f, 1.0f),new Vector3f(-3.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Drill other = new Drill();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

package ip.industrialProcessing.decoration.crystals.meshes;

import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class Crystal6 extends ObjMesh {

	public Crystal6() {
		this.quads = new ObjQuad[6];
		this.quads[0] = new ObjQuad(new Vector3f(-0.327049f, 0.385482f, -0.116002f), new Vector3f(-0.383188f, 0.337075f, -0.018119f), new Vector3f(-0.370095f, 0.441038f, -0.036205f), new Vector3f(-0.266277f, 0.463074f, -0.042775f), new Vector2f(0.375f, 0.5f), new Vector2f(0.5f, 0.5f), new Vector2f(0.4375f, 0.5625f), new Vector2f(0.375f, 0.625f), new Vector3f(-2.5642378f, 2.204647f, -0.89247704f));
		this.quads[1] = new ObjQuad(new Vector3f(0.035852f, 0.05777f, -0.069935f), new Vector3f(-0.020286f, 0.009362f, 0.027948f), new Vector3f(-0.383188f, 0.337075f, -0.018119f), new Vector3f(-0.327049f, 0.385482f, -0.116002f), new Vector2f(0.0f, 0.0f), new Vector2f(0.125f, 0.0f), new Vector2f(0.125f, 0.5f), new Vector2f(0.0f, 0.5f), new Vector3f(-1.9798089f, -2.52774f, -2.3855581f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.020286f, 0.009362f, 0.027948f), new Vector3f(0.040486f, 0.086954f, 0.101175f), new Vector3f(-0.322416f, 0.414666f, 0.055109f), new Vector3f(-0.383188f, 0.337075f, -0.018119f), new Vector2f(0.375f, 0.0f), new Vector2f(0.5f, 0.0f), new Vector2f(0.5f, 0.5f), new Vector2f(0.375f, 0.5f), new Vector3f(-1.828861f, -1.576996f, 3.188784f));
		this.quads[3] = new ObjQuad(new Vector3f(0.040486f, 0.086954f, 0.101175f), new Vector3f(0.096625f, 0.135361f, 0.003292f), new Vector3f(-0.266277f, 0.463074f, -0.042775f), new Vector3f(-0.322416f, 0.414666f, 0.055109f), new Vector2f(0.25f, 0.0f), new Vector2f(0.375f, 0.0f), new Vector2f(0.375f, 0.5f), new Vector2f(0.25f, 0.5f), new Vector3f(1.979808f, 2.52774f, 2.385556f));
		this.quads[4] = new ObjQuad(new Vector3f(0.096625f, 0.135361f, 0.003292f), new Vector3f(0.035852f, 0.05777f, -0.069935f), new Vector3f(-0.327049f, 0.385482f, -0.116002f), new Vector3f(-0.266277f, 0.463074f, -0.042775f), new Vector2f(0.125f, 0.0f), new Vector2f(0.25f, 0.0f), new Vector2f(0.25f, 0.5f), new Vector2f(0.125f, 0.5f), new Vector3f(1.828864f, 1.576997f, -3.188784f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.322416f, 0.414666f, 0.055109f), new Vector3f(-0.266277f, 0.463074f, -0.042775f), new Vector3f(-0.370095f, 0.441038f, -0.036205f), new Vector3f(-0.383188f, 0.337075f, -0.018119f), new Vector2f(0.5f, 0.625f), new Vector2f(0.375f, 0.625f), new Vector2f(0.4375f, 0.5625f), new Vector2f(0.5f, 0.5f), new Vector3f(-2.533427f, 2.398717f, 0.24538101f));
	}

	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Crystal6 other = new Crystal6();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}

}

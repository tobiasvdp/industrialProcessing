package ip.industrialProcessing.decoration.crystals.meshes;

import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class Crystal2 extends ObjMesh {

	public Crystal2() {
		this.quads = new ObjQuad[6];
		this.quads[0] = new ObjQuad(new Vector3f(-0.240608f, 0.6577f, 0.136941f), new Vector3f(-0.184465f, 0.616885f, 0.018443f), new Vector3f(-0.315258f, 0.555441f, 0.083742f), new Vector3f(-0.243282f, 0.552358f, 0.225008f), new Vector2f(0.9375f, 0.5625f), new Vector2f(1.0f, 0.625f), new Vector2f(0.875f, 0.625f), new Vector2f(0.875f, 0.5f), new Vector3f(-1.685115f, 3.029055f, 0.46639597f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.029409f, -0.032263f, 0.103283f), new Vector3f(0.101385f, 0.029181f, 0.037984f), new Vector3f(-0.112489f, 0.613803f, 0.159709f), new Vector3f(-0.243282f, 0.552358f, 0.225008f), new Vector2f(0.5f, 0.0f), new Vector2f(0.625f, 0.0f), new Vector2f(0.625f, 0.5f), new Vector2f(0.5f, 0.5f), new Vector3f(1.81556f, -0.077752f, 3.563384f));
		this.quads[2] = new ObjQuad(new Vector3f(0.101385f, 0.029181f, 0.037984f), new Vector3f(0.029409f, 0.032263f, -0.103283f), new Vector3f(-0.184465f, 0.616885f, 0.018443f), new Vector3f(-0.112489f, 0.613803f, 0.159709f), new Vector2f(0.875f, 0.0f), new Vector2f(1.0f, 0.0f), new Vector2f(1.0f, 0.5f), new Vector2f(0.875f, 0.5f), new Vector3f(3.2992f, 1.549908f, -1.6471379f));
		this.quads[3] = new ObjQuad(new Vector3f(0.029409f, 0.032263f, -0.103283f), new Vector3f(-0.101385f, -0.029181f, -0.037984f), new Vector3f(-0.315258f, 0.555441f, 0.083742f), new Vector3f(-0.184465f, 0.616885f, 0.018443f), new Vector2f(0.75f, 0.0f), new Vector2f(0.875f, 0.0f), new Vector2f(0.875f, 0.5f), new Vector2f(0.75f, 0.5f), new Vector3f(-1.81556f, 0.077752f, -3.563384f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.101385f, -0.029181f, -0.037984f), new Vector3f(-0.029409f, -0.032263f, 0.103283f), new Vector3f(-0.243282f, 0.552358f, 0.225008f), new Vector3f(-0.315258f, 0.555441f, 0.083742f), new Vector2f(0.625f, 0.0f), new Vector2f(0.75f, 0.0f), new Vector2f(0.75f, 0.5f), new Vector2f(0.625f, 0.5f), new Vector3f(-3.2992f, -1.549908f, 1.64714f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.112489f, 0.613803f, 0.159709f), new Vector3f(-0.184465f, 0.616885f, 0.018443f), new Vector3f(-0.240608f, 0.6577f, 0.136941f), new Vector3f(-0.243282f, 0.552358f, 0.225008f), new Vector2f(1.0f, 0.5f), new Vector2f(1.0f, 0.625f), new Vector2f(0.9375f, 0.5625f), new Vector2f(0.875f, 0.5f), new Vector3f(-0.641069f, 3.329557f, 0.857548f));
	}

	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Crystal2 other = new Crystal2();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}

}

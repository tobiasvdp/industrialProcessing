package ip.industrialProcessing.decoration.crystals.meshes;

import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class Crystal3 extends ObjMesh {

	public Crystal3() {
		this.quads = new ObjQuad[6];
		this.quads[0] = new ObjQuad(new Vector3f(-0.034119f, 0.462749f, 0.233309f),new Vector3f(0.063651f, 0.398112f, 0.313107f),new Vector3f(0.07861f, 0.505807f, 0.256041f),new Vector3f(0.06432f, 0.490357f, 0.135063f),new Vector2f(0.375f, 0.5f),new Vector2f(0.5f, 0.5f),new Vector2f(0.4375f, 0.5625f),new Vector2f(0.375f, 0.625f),new Vector3f(0.14662999f, 3.1024668f, 1.607952f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.151114f, -0.029829f, -0.022338f),new Vector3f(-0.053344f, -0.094466f, 0.057461f),new Vector3f(0.063651f, 0.398112f, 0.313107f),new Vector3f(-0.034119f, 0.462749f, 0.233309f),new Vector2f(0.0f, 0.0f),new Vector2f(0.125f, 0.0f),new Vector2f(0.125f, 0.5f),new Vector2f(0.0f, 0.5f),new Vector3f(-2.777012f, -0.778856f, 2.771568f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.053344f, -0.094466f, 0.057461f),new Vector3f(0.045095f, -0.066857f, -0.040785f),new Vector3f(0.16209f, 0.42572f, 0.214861f),new Vector3f(0.063651f, 0.398112f, 0.313107f),new Vector2f(0.375f, 0.0f),new Vector2f(0.5f, 0.0f),new Vector2f(0.5f, 0.5f),new Vector2f(0.375f, 0.5f),new Vector3f(2.758148f, -1.823444f, 2.2511501f));
		this.quads[3] = new ObjQuad(new Vector3f(0.045095f, -0.066857f, -0.040785f),new Vector3f(-0.052675f, -0.00222f, -0.120584f),new Vector3f(0.06432f, 0.490357f, 0.135063f),new Vector3f(0.16209f, 0.42572f, 0.214861f),new Vector2f(0.25f, 0.0f),new Vector2f(0.375f, 0.0f),new Vector2f(0.375f, 0.5f),new Vector2f(0.25f, 0.5f),new Vector3f(2.777012f, 0.778856f, -2.771568f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.052675f, -0.00222f, -0.120584f),new Vector3f(-0.151114f, -0.029829f, -0.022338f),new Vector3f(-0.034119f, 0.462749f, 0.233309f),new Vector3f(0.06432f, 0.490357f, 0.135063f),new Vector2f(0.125f, 0.0f),new Vector2f(0.25f, 0.0f),new Vector2f(0.25f, 0.5f),new Vector2f(0.125f, 0.5f),new Vector3f(-2.758148f, 1.823444f, -2.251151f));
		this.quads[5] = new ObjQuad(new Vector3f(0.16209f, 0.42572f, 0.214861f),new Vector3f(0.06432f, 0.490357f, 0.135063f),new Vector3f(0.07861f, 0.505807f, 0.256041f),new Vector3f(0.063651f, 0.398112f, 0.313107f),new Vector2f(0.5f, 0.625f),new Vector2f(0.375f, 0.625f),new Vector2f(0.4375f, 0.5625f),new Vector2f(0.5f, 0.5f),new Vector3f(1.276489f, 2.889241f, 1.5017221f));
}

	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Crystal3 other = new Crystal3();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}

}

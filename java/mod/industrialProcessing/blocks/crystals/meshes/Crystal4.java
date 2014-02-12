package mod.industrialProcessing.blocks.crystals.meshes;

import mod.industrialProcessing.client.rendering.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class Crystal4 extends ObjMesh {

	public Crystal4() {
		this.quads = new ObjQuad[6];
		this.quads[0] = new ObjQuad(new Vector3f(0.22256f, 0.516735f, 0.100389f), new Vector3f(0.098005f, 0.572105f, 0.024424f), new Vector3f(0.135039f, 0.607205f, 0.149562f), new Vector3f(0.135827f, 0.497664f, 0.228701f), new Vector2f(0.375f, 0.5f), new Vector2f(0.5f, 0.5f), new Vector2f(0.4375f, 0.5625f), new Vector2f(0.375f, 0.625f), new Vector3f(1.35401f, 3.1023912f, 0.87985694f));
		this.quads[1] = new ObjQuad(new Vector3f(0.077576f, -0.061828f, -0.083603f), new Vector3f(-0.046979f, -0.006457f, -0.159568f), new Vector3f(0.098005f, 0.572105f, 0.024424f), new Vector3f(0.22256f, 0.516735f, 0.100389f), new Vector2f(0.0f, 0.0f), new Vector2f(0.125f, 0.0f), new Vector2f(0.125f, 0.5f), new Vector2f(0.0f, 0.5f), new Vector3f(2.2232828f, 0.488836f, -3.28908f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.046979f, -0.006457f, -0.159568f), new Vector3f(-0.133713f, -0.025527f, -0.031255f), new Vector3f(0.011271f, 0.553035f, 0.152736f), new Vector3f(0.098005f, 0.572105f, 0.024424f), new Vector2f(0.375f, 0.0f), new Vector2f(0.5f, 0.0f), new Vector2f(0.5f, 0.5f), new Vector2f(0.375f, 0.5f), new Vector3f(-3.1927662f, 1.419339f, -1.9472339f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.133713f, -0.025527f, -0.031255f), new Vector3f(-0.009158f, -0.080898f, 0.04471f), new Vector3f(0.135827f, 0.497664f, 0.228701f), new Vector3f(0.011271f, 0.553035f, 0.152736f), new Vector2f(0.25f, 0.0f), new Vector2f(0.375f, 0.0f), new Vector2f(0.375f, 0.5f), new Vector2f(0.25f, 0.5f), new Vector3f(-2.2232819f, -0.488836f, 3.2890809f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.009158f, -0.080898f, 0.04471f), new Vector3f(0.077576f, -0.061828f, -0.083603f), new Vector3f(0.22256f, 0.516735f, 0.100389f), new Vector3f(0.135827f, 0.497664f, 0.228701f), new Vector2f(0.125f, 0.0f), new Vector2f(0.25f, 0.0f), new Vector2f(0.25f, 0.5f), new Vector2f(0.125f, 0.5f), new Vector3f(3.192768f, -1.41934f, 1.947232f));
		this.quads[5] = new ObjQuad(new Vector3f(0.011271f, 0.553035f, 0.152736f), new Vector3f(0.135827f, 0.497664f, 0.228701f), new Vector3f(0.135039f, 0.607205f, 0.149562f), new Vector3f(0.098005f, 0.572105f, 0.024424f), new Vector2f(0.5f, 0.625f), new Vector2f(0.375f, 0.625f), new Vector2f(0.4375f, 0.5625f), new Vector2f(0.5f, 0.5f), new Vector3f(0.24846402f, 3.2923281f, 1.153761f));
	}

	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Crystal4 other = new Crystal4();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}

}

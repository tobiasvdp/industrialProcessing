package mod.industrialProcessing.plants.construction.frame.model;

import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class Box018 extends ObjMesh {
	public Box018() {
		this.quads = new ObjQuad[6];
		this.quads[0] = new ObjQuad(new Vector3f(0.6364f, 1.45f, 0.5864f), new Vector3f(-0.6364f, 1.45f, -0.6864f), new Vector3f(-0.6364f, 1.55f, -0.6864f), new Vector3f(0.6364f, 1.55f, 0.5864f), new Vector2f(1.0f, 0.0f), new Vector2f(1.0f, 1.0f), new Vector2f(0.0f, 1.0f), new Vector2f(0.0f, 0.0f), new Vector3f(2.8284f, 0.0f, -2.8284f));
		this.quads[1] = new ObjQuad(new Vector3f(0.5657f, 1.45f, 0.6571f), new Vector3f(0.5657f, 1.55f, 0.6571f), new Vector3f(-0.7071f, 1.55f, -0.6157f), new Vector3f(-0.7071f, 1.45f, -0.6157f), new Vector2f(0.0f, 0.0f), new Vector2f(1.0f, 0.0f), new Vector2f(1.0f, 1.0f), new Vector2f(0.0f, 1.0f), new Vector3f(-2.8284f, 0.0f, 2.8284f));
		this.quads[2] = new ObjQuad(new Vector3f(0.6364f, 1.45f, 0.5864f), new Vector3f(0.6364f, 1.55f, 0.5864f), new Vector3f(0.5657f, 1.55f, 0.6571f), new Vector3f(0.5657f, 1.45f, 0.6571f), new Vector2f(0.0f, 0.0f), new Vector2f(1.0f, 0.0f), new Vector2f(1.0f, 1.0f), new Vector2f(0.0f, 1.0f), new Vector3f(2.8284f, 0.0f, 2.8284f));
		this.quads[3] = new ObjQuad(new Vector3f(0.6364f, 1.55f, 0.5864f), new Vector3f(-0.6364f, 1.55f, -0.6864f), new Vector3f(-0.7071f, 1.55f, -0.6157f), new Vector3f(0.5657f, 1.55f, 0.6571f), new Vector2f(0.0f, 0.0f), new Vector2f(1.0f, 0.0f), new Vector2f(1.0f, 1.0f), new Vector2f(0.0f, 1.0f), new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.6364f, 1.55f, -0.6864f), new Vector3f(-0.6364f, 1.45f, -0.6864f), new Vector3f(-0.7071f, 1.45f, -0.6157f), new Vector3f(-0.7071f, 1.55f, -0.6157f), new Vector2f(0.0f, 0.0f), new Vector2f(1.0f, 0.0f), new Vector2f(1.0f, 1.0f), new Vector2f(0.0f, 1.0f), new Vector3f(-2.8284f, 0.0f, -2.8284f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.6364f, 1.45f, -0.6864f), new Vector3f(0.6364f, 1.45f, 0.5864f), new Vector3f(0.5657f, 1.45f, 0.6571f), new Vector3f(-0.7071f, 1.45f, -0.6157f), new Vector2f(0.0f, 0.0f), new Vector2f(1.0f, 0.0f), new Vector2f(1.0f, 1.0f), new Vector2f(0.0f, 1.0f), new Vector3f(0.0f, -4.0f, 0.0f));
	}

	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Box018 other = new Box018();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

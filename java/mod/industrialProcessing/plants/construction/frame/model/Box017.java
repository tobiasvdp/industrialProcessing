package mod.industrialProcessing.plants.construction.frame.model;

import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class Box017 extends ObjMesh {
	public Box017() {
		this.quads = new ObjQuad[6];
		this.quads[0] = new ObjQuad(new Vector3f(0.6364f, 1.3864f, -0.65f), new Vector3f(-0.6364f, 0.1136f, -0.65f), new Vector3f(-0.6364f, 0.1136f, -0.75f), new Vector3f(0.6364f, 1.3864f, -0.75f), new Vector2f(1.0f, 0.0f), new Vector2f(1.0f, 1.0f), new Vector2f(0.0f, 1.0f), new Vector2f(0.0f, 0.0f), new Vector3f(2.8284f, -2.8284f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.5657f, 1.4571f, -0.65f), new Vector3f(0.5657f, 1.4571f, -0.75f), new Vector3f(-0.7071f, 0.1843f, -0.75f), new Vector3f(-0.7071f, 0.1843f, -0.65f), new Vector2f(0.0f, 0.0f), new Vector2f(1.0f, 0.0f), new Vector2f(1.0f, 1.0f), new Vector2f(0.0f, 1.0f), new Vector3f(-2.8284f, 2.8284f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.6364f, 1.3864f, -0.65f), new Vector3f(0.6364f, 1.3864f, -0.75f), new Vector3f(0.5657f, 1.4571f, -0.75f), new Vector3f(0.5657f, 1.4571f, -0.65f), new Vector2f(0.0f, 0.0f), new Vector2f(1.0f, 0.0f), new Vector2f(1.0f, 1.0f), new Vector2f(0.0f, 1.0f), new Vector3f(2.8284f, 2.8284f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.6364f, 1.3864f, -0.75f), new Vector3f(-0.6364f, 0.1136f, -0.75f), new Vector3f(-0.7071f, 0.1843f, -0.75f), new Vector3f(0.5657f, 1.4571f, -0.75f), new Vector2f(0.0f, 0.0f), new Vector2f(1.0f, 0.0f), new Vector2f(1.0f, 1.0f), new Vector2f(0.0f, 1.0f), new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.6364f, 0.1136f, -0.75f), new Vector3f(-0.6364f, 0.1136f, -0.65f), new Vector3f(-0.7071f, 0.1843f, -0.65f), new Vector3f(-0.7071f, 0.1843f, -0.75f), new Vector2f(0.0f, 0.0f), new Vector2f(1.0f, 0.0f), new Vector2f(1.0f, 1.0f), new Vector2f(0.0f, 1.0f), new Vector3f(-2.8284f, -2.8284f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.6364f, 0.1136f, -0.65f), new Vector3f(0.6364f, 1.3864f, -0.65f), new Vector3f(0.5657f, 1.4571f, -0.65f), new Vector3f(-0.7071f, 0.1843f, -0.65f), new Vector2f(0.0f, 0.0f), new Vector2f(1.0f, 0.0f), new Vector2f(1.0f, 1.0f), new Vector2f(0.0f, 1.0f), new Vector3f(0.0f, 0.0f, 4.0f));
	}

	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Box017 other = new Box017();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

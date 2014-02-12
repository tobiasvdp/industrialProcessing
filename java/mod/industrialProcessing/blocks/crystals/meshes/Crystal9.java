package mod.industrialProcessing.blocks.crystals.meshes;

import mod.industrialProcessing.client.rendering.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class Crystal9 extends ObjMesh {

	public Crystal9() {
		this.quads = new ObjQuad[6];
		this.quads[0] = new ObjQuad(new Vector3f(-0.079448f, 0.672865f, -0.272209f), new Vector3f(-0.118354f, 0.575003f, -0.360352f), new Vector3f(-0.183201f, 0.601053f, -0.218005f), new Vector3f(-0.038505f, 0.61492f, -0.154625f), new Vector2f(0.9375f, 0.5625f), new Vector2f(1.0f, 0.625f), new Vector2f(0.875f, 0.625f), new Vector2f(0.875f, 0.5f), new Vector3f(-0.58376193f, 3.420595f, -0.437119f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.030359f, -0.008304f, -0.036864f), new Vector3f(0.034489f, -0.034353f, -0.179211f), new Vector3f(0.026343f, 0.58887f, -0.296972f), new Vector3f(-0.038505f, 0.61492f, -0.154625f), new Vector2f(0.5f, 0.0f), new Vector2f(0.625f, 0.0f), new Vector2f(0.625f, 0.5f), new Vector2f(0.5f, 0.5f), new Vector3f(3.649892f, 0.349794f, 1.598724f));
		this.quads[2] = new ObjQuad(new Vector3f(0.034489f, -0.034353f, -0.179211f), new Vector3f(-0.110208f, -0.04822f, -0.24259f), new Vector3f(-0.118354f, 0.575003f, -0.360352f), new Vector3f(0.026343f, 0.58887f, -0.296972f), new Vector2f(0.875f, 0.0f), new Vector2f(1.0f, 0.0f), new Vector2f(1.0f, 0.5f), new Vector2f(0.875f, 0.5f), new Vector3f(1.635736f, -0.657088f, -3.590628f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.110208f, -0.04822f, -0.24259f), new Vector3f(-0.175055f, -0.022171f, -0.100243f), new Vector3f(-0.183201f, 0.601053f, -0.218005f), new Vector3f(-0.118354f, 0.575003f, -0.360352f), new Vector2f(0.75f, 0.0f), new Vector2f(0.875f, 0.0f), new Vector2f(0.875f, 0.5f), new Vector2f(0.75f, 0.5f), new Vector3f(-3.649892f, -0.34979302f, -1.598724f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.175055f, -0.022171f, -0.100243f), new Vector3f(-0.030359f, -0.008304f, -0.036864f), new Vector3f(-0.038505f, 0.61492f, -0.154625f), new Vector3f(-0.183201f, 0.601053f, -0.218005f), new Vector2f(0.625f, 0.0f), new Vector2f(0.75f, 0.0f), new Vector2f(0.75f, 0.5f), new Vector2f(0.625f, 0.5f), new Vector3f(-1.635736f, 0.657088f, 3.590628f));
		this.quads[5] = new ObjQuad(new Vector3f(0.026343f, 0.58887f, -0.296972f), new Vector3f(-0.118354f, 0.575003f, -0.360352f), new Vector3f(-0.079448f, 0.672865f, -0.272209f), new Vector3f(-0.038505f, 0.61492f, -0.154625f), new Vector2f(1.0f, 0.5f), new Vector2f(1.0f, 0.625f), new Vector2f(0.9375f, 0.5625f), new Vector2f(0.875f, 0.5f), new Vector3f(0.495162f, 3.3578691f, -0.843713f));
	}

	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Crystal9 other = new Crystal9();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}

}

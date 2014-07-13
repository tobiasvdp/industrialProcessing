package ip.industrialProcessing.subMod.logic.network.devices.readout.displayPost.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Frame extends ObjMesh{
	public Frame(){
		this.quads = new ObjQuad[13];
		this.quads[0] = new ObjQuad(new Vector3f(-0.7f, 0.8643f, 0.5766f),new Vector3f(-0.7f, 0.7357f, 0.4234f),new Vector3f(0.7f, 0.7357f, 0.4234f),new Vector3f(0.7f, 0.8643f, 0.5766f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector2f(0.0f, 0.0f),new Vector3f(0.0f, -3.064f, 2.5712f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.7f, 1.6303f, -0.0662f),new Vector3f(0.7f, 1.6303f, -0.0662f),new Vector3f(0.7f, 1.5018f, -0.2194f),new Vector3f(-0.7f, 1.5018f, -0.2194f),new Vector2f(0.0f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector3f(0.0f, 3.064f, -2.5712f));
		this.quads[2] = new ObjQuad(new Vector3f(0.7f, 0.8643f, 0.5766f),new Vector3f(0.7f, 0.7357f, 0.4234f),new Vector3f(0.7f, 1.5018f, -0.2194f),new Vector3f(0.7f, 1.6303f, -0.0662f),new Vector2f(0.0f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.7f, 0.7357f, 0.4234f),new Vector3f(-0.7f, 0.7357f, 0.4234f),new Vector3f(-0.7f, 1.5018f, -0.2194f),new Vector3f(0.7f, 1.5018f, -0.2194f),new Vector2f(0.0f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector3f(0.0f, -2.5712f, -3.064f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.7f, 0.7357f, 0.4234f),new Vector3f(-0.7f, 0.8643f, 0.5766f),new Vector3f(-0.7f, 1.6303f, -0.0662f),new Vector3f(-0.7f, 1.5018f, -0.2194f),new Vector2f(0.0f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.7f, 0.8643f, 0.5766f),new Vector3f(0.7f, 0.8643f, 0.5766f),new Vector3f(0.6f, 0.9409f, 0.5123f),new Vector3f(-0.6f, 0.9409f, 0.5123f),new Vector2f(1.0f, 0.0f),new Vector2f(0.0f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(0.0f, 0.0f),new Vector3f(0.0f, 2.5712f, 3.064f));
		this.quads[6] = new ObjQuad(new Vector3f(0.7f, 0.8643f, 0.5766f),new Vector3f(0.7f, 1.6303f, -0.0662f),new Vector3f(0.6f, 1.5537f, -0.0019f),new Vector3f(0.6f, 0.9409f, 0.5123f),new Vector2f(0.0f, 0.0f),new Vector2f(0.0f, 1.0f),new Vector2f(1.0f, 1.0f),new Vector2f(1.0f, 0.0f),new Vector3f(0.0f, 2.5712f, 3.064f));
		this.quads[7] = new ObjQuad(new Vector3f(0.7f, 1.6303f, -0.0662f),new Vector3f(-0.7f, 1.6303f, -0.0662f),new Vector3f(-0.6f, 1.5537f, -0.0019f),new Vector3f(0.6f, 1.5537f, -0.0019f),new Vector2f(1.0f, 0.0f),new Vector2f(0.0f, 0.0f),new Vector2f(0.0f, 1.0f),new Vector2f(1.0f, 1.0f),new Vector3f(0.0f, 2.5712f, 3.064f));
		this.quads[8] = new ObjQuad(new Vector3f(-0.7f, 1.6303f, -0.0662f),new Vector3f(-0.7f, 0.8643f, 0.5766f),new Vector3f(-0.6f, 0.9409f, 0.5123f),new Vector3f(-0.6f, 1.5537f, -0.0019f),new Vector2f(1.0f, 1.0f),new Vector2f(1.0f, 0.0f),new Vector2f(0.0f, 0.0f),new Vector2f(0.0f, 1.0f),new Vector3f(0.0f, 2.5712f, 3.064f));
		this.quads[9] = new ObjQuad(new Vector3f(-0.6f, 0.9409f, 0.5123f),new Vector3f(0.6f, 0.9409f, 0.5123f),new Vector3f(0.6f, 0.9087f, 0.474f),new Vector3f(-0.6f, 0.9087f, 0.474f),new Vector2f(0.0f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(0.0f, 0.0f),new Vector3f(0.0f, 3.064f, -2.5712f));
		this.quads[10] = new ObjQuad(new Vector3f(0.6f, 0.9409f, 0.5123f),new Vector3f(0.6f, 1.5537f, -0.0019f),new Vector3f(0.6f, 1.5216f, -0.0402f),new Vector3f(0.6f, 0.9087f, 0.474f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 1.0f),new Vector2f(1.0f, 1.0f),new Vector2f(1.0f, 0.0f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[11] = new ObjQuad(new Vector3f(0.6f, 1.5537f, -0.0019f),new Vector3f(-0.6f, 1.5537f, -0.0019f),new Vector3f(-0.6f, 1.5216f, -0.0402f),new Vector3f(0.6f, 1.5216f, -0.0402f),new Vector2f(1.0f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector2f(1.0f, 1.0f),new Vector3f(0.0f, -3.064f, 2.5712f));
		this.quads[12] = new ObjQuad(new Vector3f(-0.6f, 1.5537f, -0.0019f),new Vector3f(-0.6f, 0.9409f, 0.5123f),new Vector3f(-0.6f, 0.9087f, 0.474f),new Vector3f(-0.6f, 1.5216f, -0.0402f),new Vector2f(0.0f, 1.0f),new Vector2f(0.0f, 0.0f),new Vector2f(0.0f, 0.0f),new Vector2f(0.0f, 1.0f),new Vector3f(4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Frame other = new Frame();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

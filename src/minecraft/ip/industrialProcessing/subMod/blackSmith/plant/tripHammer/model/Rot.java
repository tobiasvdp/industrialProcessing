package  ip.industrialProcessing.subMod.blackSmith.plant.tripHammer.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Rot extends ObjMesh{
	public Rot(){
		this.quads = new ObjQuad[12];
		this.quads[0] = new ObjQuad(new Vector3f(0.8f, 0.75f, -0.6f),new Vector3f(0.8f, 0.9232f, -0.7f),new Vector3f(-0.8f, 0.9232f, -0.7f),new Vector3f(-0.8f, 0.75f, -0.6f),new Vector2f(0.5f, 0.0f),new Vector2f(0.6083f, 0.0f),new Vector2f(0.6083f, 1.0f),new Vector2f(0.5f, 1.0f),new Vector3f(0.0f, 1.732f, 3.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.8f, 0.9232f, -0.7f),new Vector3f(0.8f, 0.9232f, -0.9f),new Vector3f(-0.8f, 0.9232f, -0.9f),new Vector3f(-0.8f, 0.9232f, -0.7f),new Vector2f(0.4375f, 0.0f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.5625f, 1.0f),new Vector2f(0.4375f, 1.0f),new Vector3f(0.0f, 3.464f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.8f, 0.9232f, -0.9f),new Vector3f(0.8f, 0.75f, -1.0f),new Vector3f(-0.8f, 0.75f, -1.0f),new Vector3f(-0.8f, 0.9232f, -0.9f),new Vector2f(0.3917f, 0.0f),new Vector2f(0.5f, 0.0f),new Vector2f(0.5f, 1.0f),new Vector2f(0.3917f, 1.0f),new Vector3f(0.0f, 1.732f, -3.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.8f, 0.75f, -1.0f),new Vector3f(0.8f, 0.5768f, -0.9f),new Vector3f(-0.8f, 0.5768f, -0.9f),new Vector3f(-0.8f, 0.75f, -1.0f),new Vector2f(0.5f, 0.0f),new Vector2f(0.6083f, 0.0f),new Vector2f(0.6083f, 1.0f),new Vector2f(0.5f, 1.0f),new Vector3f(0.0f, -1.732f, -3.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.8f, 0.5768f, -0.9f),new Vector3f(0.8f, 0.5768f, -0.7f),new Vector3f(-0.8f, 0.5768f, -0.7f),new Vector3f(-0.8f, 0.5768f, -0.9f),new Vector2f(0.4375f, 0.0f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.5625f, 1.0f),new Vector2f(0.4375f, 1.0f),new Vector3f(0.0f, -3.464f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(0.8f, 0.5768f, -0.7f),new Vector3f(0.8f, 0.75f, -0.6f),new Vector3f(-0.8f, 0.75f, -0.6f),new Vector3f(-0.8f, 0.5768f, -0.7f),new Vector2f(0.3917f, 0.0f),new Vector2f(0.5f, 0.0f),new Vector2f(0.5f, 1.0f),new Vector2f(0.3917f, 1.0f),new Vector3f(0.0f, -1.732f, 3.0f));
		this.quads[6] = new ObjQuad(new Vector3f(0.8f, 0.5768f, -0.9f),new Vector3f(0.8f, 0.75f, -1.0f),new Vector3f(0.8f, 0.9232f, -0.9f),new Vector3f(0.8f, 0.75f, -0.6f),new Vector2f(0.5625f, 0.3917f),new Vector2f(0.625f, 0.5f),new Vector2f(0.5625f, 0.6083f),new Vector2f(0.375f, 0.5f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(0.8f, 0.9232f, -0.9f),new Vector3f(0.8f, 0.9232f, -0.7f),new Vector3f(0.8f, 0.75f, -0.6f),new Vector2f(0.5625f, 0.6083f),new Vector2f(0.4375f, 0.6083f),new Vector2f(0.375f, 0.5f),new Vector3f(3.0f, 0.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(0.8f, 0.5768f, -0.7f),new Vector3f(0.8f, 0.5768f, -0.9f),new Vector3f(0.8f, 0.75f, -0.6f),new Vector2f(0.4375f, 0.3917f),new Vector2f(0.5625f, 0.3917f),new Vector2f(0.375f, 0.5f),new Vector3f(3.0f, 0.0f, 0.0f));
		this.quads[9] = new ObjQuad(new Vector3f(-0.8f, 0.9232f, -0.7f),new Vector3f(-0.8f, 0.9232f, -0.9f),new Vector3f(-0.8f, 0.75f, -1.0f),new Vector3f(-0.8f, 0.5768f, -0.7f),new Vector2f(0.5625f, 0.6083f),new Vector2f(0.4375f, 0.6083f),new Vector2f(0.375f, 0.5f),new Vector2f(0.5625f, 0.3917f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[10] = new ObjQuad(new Vector3f(-0.8f, 0.75f, -1.0f),new Vector3f(-0.8f, 0.5768f, -0.9f),new Vector3f(-0.8f, 0.5768f, -0.7f),new Vector2f(0.375f, 0.5f),new Vector2f(0.4375f, 0.3917f),new Vector2f(0.5625f, 0.3917f),new Vector3f(-3.0f, 0.0f, 0.0f));
		this.quads[11] = new ObjQuad(new Vector3f(-0.8f, 0.75f, -0.6f),new Vector3f(-0.8f, 0.9232f, -0.7f),new Vector3f(-0.8f, 0.5768f, -0.7f),new Vector2f(0.625f, 0.5f),new Vector2f(0.5625f, 0.6083f),new Vector2f(0.5625f, 0.3917f),new Vector3f(-3.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Rot other = new Rot();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

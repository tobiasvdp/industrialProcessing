package mod.industrialProcessing.block.doors.emergency.model;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Rectracter extends ObjMesh{
	public Rectracter(){
		this.quads = new ObjQuad[6];
		this.quads[0] = new ObjQuad(new Vector3f(-0.6f, 1.35f, 0.15f),new Vector3f(-0.6f, 1.35f, -0.15f),new Vector3f(0.0f, 1.35f, -0.15f),new Vector3f(0.0f, 1.35f, 0.15f),new Vector2f(0.6875f, 0.4063f),new Vector2f(0.6875f, 0.5938f),new Vector2f(0.3125f, 0.5937f),new Vector2f(0.3125f, 0.4062f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.6f, 1.55f, 0.15f),new Vector3f(0.0f, 1.55f, 0.15f),new Vector3f(0.0f, 1.55f, -0.15f),new Vector3f(-0.6f, 1.55f, -0.15f),new Vector2f(0.3125f, 0.4063f),new Vector2f(0.6875f, 0.4062f),new Vector2f(0.6875f, 0.5937f),new Vector2f(0.3125f, 0.5938f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.6f, 1.35f, 0.15f),new Vector3f(0.0f, 1.35f, 0.15f),new Vector3f(0.0f, 1.55f, 0.15f),new Vector3f(-0.6f, 1.55f, 0.15f),new Vector2f(0.3125f, 0.4375f),new Vector2f(0.6875f, 0.4375f),new Vector2f(0.6875f, 0.5625f),new Vector2f(0.3125f, 0.5625f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.0f, 1.35f, 0.15f),new Vector3f(0.0f, 1.35f, -0.15f),new Vector3f(0.0f, 1.55f, -0.15f),new Vector3f(0.0f, 1.55f, 0.15f),new Vector2f(0.4062f, 0.4375f),new Vector2f(0.5937f, 0.4375f),new Vector2f(0.5937f, 0.5625f),new Vector2f(0.4062f, 0.5625f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.0f, 1.35f, -0.15f),new Vector3f(-0.6f, 1.35f, -0.15f),new Vector3f(-0.6f, 1.55f, -0.15f),new Vector3f(0.0f, 1.55f, -0.15f),new Vector2f(0.3125f, 0.4375f),new Vector2f(0.6875f, 0.4375f),new Vector2f(0.6875f, 0.5625f),new Vector2f(0.3125f, 0.5625f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.6f, 1.35f, -0.15f),new Vector3f(-0.6f, 1.35f, 0.15f),new Vector3f(-0.6f, 1.55f, 0.15f),new Vector3f(-0.6f, 1.55f, -0.15f),new Vector2f(0.4062f, 0.4375f),new Vector2f(0.5937f, 0.4375f),new Vector2f(0.5937f, 0.5625f),new Vector2f(0.4062f, 0.5625f),new Vector3f(-4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Rectracter other = new Rectracter();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

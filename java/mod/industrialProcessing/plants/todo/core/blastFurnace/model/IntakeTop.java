package mod.industrialProcessing.plants.todo.core.blastFurnace.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class IntakeTop extends ObjMesh{
	public IntakeTop(){
		this.quads = new ObjQuad[13];
		this.quads[0] = new ObjQuad(new Vector3f(0.2f, 1.5f, 0.2f),new Vector3f(-0.2f, 1.5f, 0.2f),new Vector3f(-0.2f, 1.4f, 0.2f),new Vector3f(0.2f, 1.4f, 0.2f),new Vector2f(0.5f, 0.7521f),new Vector2f(0.5f, 0.5021f),new Vector2f(0.5625f, 0.5021f),new Vector2f(0.5625f, 0.7521f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.3f, 1.6f, -0.3017f),new Vector3f(0.3f, 1.6f, -0.3017f),new Vector3f(0.3f, 1.5f, -0.3017f),new Vector3f(-0.3f, 1.5f, -0.3017f),new Vector2f(0.4375f, 0.75f),new Vector2f(0.4375f, 0.375f),new Vector2f(0.5f, 0.375f),new Vector2f(0.5f, 0.75f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.3f, 1.6f, -0.3017f),new Vector3f(-0.3f, 1.6f, 0.3f),new Vector3f(0.3f, 1.6f, 0.3f),new Vector3f(0.3f, 1.6f, -0.3017f),new Vector2f(0.9996f, 0.6258f),new Vector2f(0.9996f, 1.0019f),new Vector2f(0.6246f, 1.0019f),new Vector2f(0.6246f, 0.6258f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.3f, 1.6f, -0.3017f),new Vector3f(-0.3f, 1.5f, -0.3017f),new Vector3f(-0.3f, 1.5f, 0.3f),new Vector3f(-0.3f, 1.6f, 0.3f),new Vector2f(0.375f, 0.376f),new Vector2f(0.4375f, 0.376f),new Vector2f(0.4375f, 0.7521f),new Vector2f(0.375f, 0.7521f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.3f, 1.5f, 0.3f),new Vector3f(0.3f, 1.5f, 0.3f),new Vector3f(0.3f, 1.6f, 0.3f),new Vector3f(-0.3f, 1.6f, 0.3f),new Vector2f(0.5f, 0.0f),new Vector2f(0.5f, 0.375f),new Vector2f(0.4375f, 0.375f),new Vector2f(0.4375f, 0.0f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[5] = new ObjQuad(new Vector3f(0.3f, 1.5f, -0.3017f),new Vector3f(0.3f, 1.6f, -0.3017f),new Vector3f(0.3f, 1.6f, 0.3f),new Vector3f(0.3f, 1.5f, 0.3f),new Vector2f(0.4375f, 0.376f),new Vector2f(0.375f, 0.376f),new Vector2f(0.375f, 0.0f),new Vector2f(0.4375f, 0.0f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(0.2f, 1.4f, -0.2017f),new Vector3f(-0.2f, 1.4f, -0.2017f),new Vector3f(-0.2f, 1.5f, -0.2017f),new Vector3f(0.2f, 1.5f, -0.2017f),new Vector2f(0.625f, 0.0f),new Vector2f(0.625f, 0.25f),new Vector2f(0.5625f, 0.25f),new Vector2f(0.5625f, 0.0f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.2f, 1.4f, 0.2f),new Vector3f(-0.2f, 1.5f, 0.2f),new Vector3f(-0.2f, 1.5f, -0.2017f),new Vector3f(-0.2f, 1.4f, -0.2017f),new Vector2f(0.5625f, 0.251f),new Vector2f(0.5f, 0.251f),new Vector2f(0.5f, 0.0f),new Vector2f(0.5625f, 0.0f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(0.2f, 1.5f, 0.2f),new Vector3f(0.2f, 1.4f, 0.2f),new Vector3f(0.2f, 1.4f, -0.2017f),new Vector3f(0.2f, 1.5f, -0.2017f),new Vector2f(0.5f, 0.251f),new Vector2f(0.5625f, 0.251f),new Vector2f(0.5625f, 0.5021f),new Vector2f(0.5f, 0.5021f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[9] = new ObjQuad(new Vector3f(-0.2f, 1.5f, -0.2017f),new Vector3f(-0.3f, 1.5f, -0.3017f),new Vector3f(0.3f, 1.5f, -0.3017f),new Vector3f(0.2f, 1.5f, -0.2017f),new Vector2f(0.6894f, 0.0628f),new Vector2f(0.6269f, 3.0E-4f),new Vector2f(1.0019f, 3.0E-4f),new Vector2f(0.9394f, 0.0628f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[10] = new ObjQuad(new Vector3f(-0.3f, 1.5f, -0.3017f),new Vector3f(-0.2f, 1.5f, -0.2017f),new Vector3f(-0.2f, 1.5f, 0.2f),new Vector3f(-0.3f, 1.5f, 0.3f),new Vector2f(0.6269f, 3.0E-4f),new Vector2f(0.6894f, 0.0628f),new Vector2f(0.6894f, 0.3138f),new Vector2f(0.6269f, 0.3763f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[11] = new ObjQuad(new Vector3f(-0.3f, 1.5f, 0.3f),new Vector3f(-0.2f, 1.5f, 0.2f),new Vector3f(0.2f, 1.5f, 0.2f),new Vector3f(0.3f, 1.5f, 0.3f),new Vector2f(0.6269f, 0.3763f),new Vector2f(0.6894f, 0.3138f),new Vector2f(0.9394f, 0.3138f),new Vector2f(1.0019f, 0.3763f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[12] = new ObjQuad(new Vector3f(0.3f, 1.5f, 0.3f),new Vector3f(0.2f, 1.5f, 0.2f),new Vector3f(0.2f, 1.5f, -0.2017f),new Vector3f(0.3f, 1.5f, -0.3017f),new Vector2f(1.0019f, 0.3763f),new Vector2f(0.9394f, 0.3138f),new Vector2f(0.9394f, 0.0628f),new Vector2f(1.0019f, 3.0E-4f),new Vector3f(0.0f, -4.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		IntakeTop other = new IntakeTop();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

package mod.industrialProcessing.plants.machine.sinter.model;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class SinterFront extends ObjMesh{
	public SinterFront(){
		this.quads = new ObjQuad[10];
		this.quads[0] = new ObjQuad(new Vector3f(-0.5f, 0.3f, 0.725f),new Vector3f(0.5f, 0.3f, 0.725f),new Vector3f(0.5f, 1.1f, 0.725f),new Vector3f(-0.5f, 1.1f, 0.725f),new Vector2f(0.5f, 0.0f),new Vector2f(0.5f, 0.625f),new Vector2f(0.0f, 0.625f),new Vector2f(0.0f, 0.0f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.5f, 0.3f, 0.725f),new Vector3f(-0.5f, 0.3f, 0.725f),new Vector3f(-0.5f, 0.3f, 0.675f),new Vector3f(0.5f, 0.3f, 0.675f),new Vector2f(0.6875f, 0.0f),new Vector2f(0.6875f, 0.625f),new Vector2f(0.6563f, 0.625f),new Vector2f(0.6563f, 0.0f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.5f, 0.3f, 0.725f),new Vector3f(-0.5f, 1.1f, 0.725f),new Vector3f(-0.5f, 1.1f, 0.675f),new Vector3f(-0.5f, 0.3f, 0.675f),new Vector2f(0.7188f, 0.5f),new Vector2f(0.7188f, 0.0f),new Vector2f(0.75f, 0.0f),new Vector2f(0.75f, 0.5f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.5f, 1.1f, 0.725f),new Vector3f(0.5f, 1.1f, 0.725f),new Vector3f(0.5f, 1.1f, 0.675f),new Vector3f(-0.5f, 1.1f, 0.675f),new Vector2f(0.6563f, 0.0f),new Vector2f(0.6563f, 0.625f),new Vector2f(0.625f, 0.625f),new Vector2f(0.625f, 0.0f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.5f, 1.1f, 0.725f),new Vector3f(0.5f, 0.3f, 0.725f),new Vector3f(0.5f, 0.3f, 0.675f),new Vector3f(0.5f, 1.1f, 0.675f),new Vector2f(0.7188f, 0.0f),new Vector2f(0.7188f, 0.5f),new Vector2f(0.6875f, 0.5f),new Vector2f(0.6875f, 0.0f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.5f, 1.2f, 0.725f),new Vector3f(0.5f, 1.2f, 0.725f),new Vector3f(0.5f, 1.4f, 0.725f),new Vector3f(-0.5f, 1.4f, 0.725f),new Vector2f(0.625f, 0.0f),new Vector2f(0.625f, 0.625f),new Vector2f(0.5f, 0.625f),new Vector2f(0.5f, 0.0f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.5f, 1.2f, 0.7f),new Vector3f(0.5f, 1.2f, 0.7f),new Vector3f(0.5f, 1.2f, 0.725f),new Vector3f(-0.5f, 1.2f, 0.725f),new Vector2f(0.7656f, 0.625f),new Vector2f(0.7656f, 0.0f),new Vector2f(0.7813f, 0.0f),new Vector2f(0.7813f, 0.625f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(0.5f, 1.2f, 0.7f),new Vector3f(0.5f, 1.4f, 0.7f),new Vector3f(0.5f, 1.4f, 0.725f),new Vector3f(0.5f, 1.2f, 0.725f),new Vector2f(0.7211f, 0.6251f),new Vector2f(0.7211f, 0.5001f),new Vector2f(0.7367f, 0.5001f),new Vector2f(0.7367f, 0.6251f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(0.5f, 1.4f, 0.7f),new Vector3f(-0.5f, 1.4f, 0.7f),new Vector3f(-0.5f, 1.4f, 0.725f),new Vector3f(0.5f, 1.4f, 0.725f),new Vector2f(0.75f, 0.625f),new Vector2f(0.75f, 0.0f),new Vector2f(0.7656f, 0.0f),new Vector2f(0.7656f, 0.625f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[9] = new ObjQuad(new Vector3f(-0.5f, 1.4f, 0.7f),new Vector3f(-0.5f, 1.2f, 0.7f),new Vector3f(-0.5f, 1.2f, 0.725f),new Vector3f(-0.5f, 1.4f, 0.725f),new Vector2f(0.7042f, 0.5001f),new Vector2f(0.7042f, 0.6251f),new Vector2f(0.6886f, 0.6251f),new Vector2f(0.6886f, 0.5001f),new Vector3f(-4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		SinterFront other = new SinterFront();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

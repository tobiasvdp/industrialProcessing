package mod.industrialProcessing.plants.transport.items.conveyorChute.model;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Chute extends ObjMesh{
	public Chute(){
		this.quads = new ObjQuad[4];
		this.quads[0] = new ObjQuad(new Vector3f(0.25f, 0.1f, 0.25f),new Vector3f(0.25f, 0.1f, -0.25f),new Vector3f(0.25f, 1.5f, -0.25f),new Vector3f(0.25f, 1.5f, 0.25f),new Vector2f(-0.0f, 0.0625f),new Vector2f(0.3125f, 0.0625f),new Vector2f(0.3125f, 0.9375f),new Vector2f(-0.0f, 0.9375f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.25f, 0.1f, -0.25f),new Vector3f(-0.25f, 0.1f, -0.25f),new Vector3f(-0.25f, 1.5f, -0.25f),new Vector3f(0.25f, 1.5f, -0.25f),new Vector2f(0.0f, 0.0625f),new Vector2f(0.3125f, 0.0625f),new Vector2f(0.3125f, 0.9375f),new Vector2f(0.0f, 0.9375f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.25f, 0.1f, 0.25f),new Vector3f(-0.25f, 1.5f, 0.25f),new Vector3f(-0.25f, 1.5f, -0.25f),new Vector3f(-0.25f, 0.1f, -0.25f),new Vector2f(-0.0f, 0.0625f),new Vector2f(-0.0f, 0.9375f),new Vector2f(0.3125f, 0.9375f),new Vector2f(0.3125f, 0.0625f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.25f, 0.1f, 0.25f),new Vector3f(0.25f, 1.5f, 0.25f),new Vector3f(-0.25f, 1.5f, 0.25f),new Vector3f(-0.25f, 0.1f, 0.25f),new Vector2f(0.0f, 0.0625f),new Vector2f(0.0f, 0.9375f),new Vector2f(0.3125f, 0.9375f),new Vector2f(0.3125f, 0.0625f),new Vector3f(0.0f, 0.0f, 4.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Chute other = new Chute();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

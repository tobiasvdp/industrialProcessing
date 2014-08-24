package  mod.industrialProcessing.plants.middleAge.forge.model;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Object001 extends ObjMesh{
	public Object001(){
		this.quads = new ObjQuad[6];
		this.quads[0] = new ObjQuad(new Vector3f(0.8f, 0.0f, 0.8f),new Vector3f(0.8f, 0.0f, -0.8f),new Vector3f(0.8f, 1.6f, -0.8f),new Vector3f(0.8f, 1.6f, 0.8f),new Vector2f(-0.0f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 1.0f),new Vector2f(-0.0f, 1.0f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.8f, 0.0f, 0.8f),new Vector3f(0.8f, 1.6f, 0.8f),new Vector3f(0.0f, 1.6f, 0.8f),new Vector3f(0.0f, 0.0f, 0.8f),new Vector2f(0.75f, 0.0f),new Vector2f(0.75f, 1.0f),new Vector2f(0.25f, 1.0f),new Vector2f(0.25f, 0.0f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.0f, 1.6f, 0.8f),new Vector3f(0.0f, 1.6f, -0.8f),new Vector3f(0.0f, 0.0f, -0.8f),new Vector3f(0.0f, 0.0f, 0.8f),new Vector2f(1.0f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector2f(0.0f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.0f, 0.0f, 0.8f),new Vector3f(0.0f, 0.0f, -0.8f),new Vector3f(0.8f, 0.0f, -0.8f),new Vector3f(0.8f, 0.0f, 0.8f),new Vector2f(0.75f, 0.0f),new Vector2f(0.75f, 1.0f),new Vector2f(0.25f, 1.0f),new Vector2f(0.25f, -0.0f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.8f, 1.6f, -0.8f),new Vector3f(0.0f, 1.6f, -0.8f),new Vector3f(0.0f, 1.6f, 0.8f),new Vector3f(0.8f, 1.6f, 0.8f),new Vector2f(0.75f, 1.0f),new Vector2f(0.25f, 1.0f),new Vector2f(0.25f, 0.0f),new Vector2f(0.75f, -0.0f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(0.8f, 0.0f, -0.8f),new Vector3f(0.0f, 0.0f, -0.8f),new Vector3f(0.0f, 1.6f, -0.8f),new Vector3f(0.8f, 1.6f, -0.8f),new Vector2f(0.25f, 0.0f),new Vector2f(0.75f, 0.0f),new Vector2f(0.75f, 1.0f),new Vector2f(0.25f, 1.0f),new Vector3f(0.0f, 0.0f, -4.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Object001 other = new Object001();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

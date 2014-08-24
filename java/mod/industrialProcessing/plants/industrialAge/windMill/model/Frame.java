package  mod.industrialProcessing.plants.industrialAge.windMill.model;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Frame extends ObjMesh{
	public Frame(){
		this.quads = new ObjQuad[12];
		this.quads[0] = new ObjQuad(new Vector3f(0.0f, 0.8f, 0.8f),new Vector3f(0.6928f, 0.4f, 0.8f),new Vector3f(0.6928f, 1.2f, 0.8f),new Vector3f(0.0f, 1.6f, 0.8f),new Vector2f(0.5f, 0.5f),new Vector2f(0.75f, 0.933f),new Vector2f(0.25f, 0.933f),new Vector2f(0.0f, 0.5f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.0f, 0.8f, 0.8f),new Vector3f(-0.6928f, 0.4f, 0.8f),new Vector3f(-0.0f, 0.0f, 0.8f),new Vector3f(0.6928f, 0.4f, 0.8f),new Vector2f(0.5f, 0.5f),new Vector2f(0.75f, 0.067f),new Vector2f(1.0f, 0.5f),new Vector2f(0.75f, 0.933f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.0f, 0.8f, 0.8f),new Vector3f(0.0f, 1.6f, 0.8f),new Vector3f(-0.6928f, 1.2f, 0.8f),new Vector3f(-0.6928f, 0.4f, 0.8f),new Vector2f(0.5f, 0.5f),new Vector2f(0.0f, 0.5f),new Vector2f(0.25f, 0.067f),new Vector2f(0.75f, 0.067f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.0f, 1.6f, 0.8f),new Vector3f(0.6928f, 1.2f, 0.8f),new Vector3f(0.6928f, 1.2f, -0.8f),new Vector3f(0.0f, 1.6f, -0.8f),new Vector2f(0.5f, 0.0f),new Vector2f(0.933f, 0.0f),new Vector2f(0.933f, 1.0f),new Vector2f(0.5f, 1.0f),new Vector3f(1.732f, 3.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.6928f, 1.2f, 0.8f),new Vector3f(0.6928f, 0.4f, 0.8f),new Vector3f(0.6928f, 0.4f, -0.8f),new Vector3f(0.6928f, 1.2f, -0.8f),new Vector2f(0.25f, 0.0f),new Vector2f(0.75f, 0.0f),new Vector2f(0.75f, 1.0f),new Vector2f(0.25f, 1.0f),new Vector3f(3.464f, 0.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(0.6928f, 0.4f, 0.8f),new Vector3f(-0.0f, 0.0f, 0.8f),new Vector3f(-0.0f, 0.0f, -0.8f),new Vector3f(0.6928f, 0.4f, -0.8f),new Vector2f(0.067f, 0.0f),new Vector2f(0.5f, 0.0f),new Vector2f(0.5f, 1.0f),new Vector2f(0.067f, 1.0f),new Vector3f(1.732f, -3.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.0f, 0.0f, 0.8f),new Vector3f(-0.6928f, 0.4f, 0.8f),new Vector3f(-0.6928f, 0.4f, -0.8f),new Vector3f(-0.0f, 0.0f, -0.8f),new Vector2f(0.5f, 0.0f),new Vector2f(0.933f, 0.0f),new Vector2f(0.933f, 1.0f),new Vector2f(0.5f, 1.0f),new Vector3f(-1.732f, -3.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.6928f, 0.4f, 0.8f),new Vector3f(-0.6928f, 1.2f, 0.8f),new Vector3f(-0.6928f, 1.2f, -0.8f),new Vector3f(-0.6928f, 0.4f, -0.8f),new Vector2f(0.25f, 0.0f),new Vector2f(0.75f, 0.0f),new Vector2f(0.75f, 1.0f),new Vector2f(0.25f, 1.0f),new Vector3f(-3.464f, 0.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(-0.6928f, 1.2f, 0.8f),new Vector3f(0.0f, 1.6f, 0.8f),new Vector3f(0.0f, 1.6f, -0.8f),new Vector3f(-0.6928f, 1.2f, -0.8f),new Vector2f(0.067f, 0.0f),new Vector2f(0.5f, 0.0f),new Vector2f(0.5f, 1.0f),new Vector2f(0.067f, 1.0f),new Vector3f(-1.732f, 3.0f, 0.0f));
		this.quads[9] = new ObjQuad(new Vector3f(0.0f, 0.8f, -0.8f),new Vector3f(-0.6928f, 1.2f, -0.8f),new Vector3f(0.0f, 1.6f, -0.8f),new Vector3f(0.6928f, 1.2f, -0.8f),new Vector2f(0.5f, 0.5f),new Vector2f(0.75f, 0.067f),new Vector2f(1.0f, 0.5f),new Vector2f(0.75f, 0.933f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[10] = new ObjQuad(new Vector3f(0.0f, 0.8f, -0.8f),new Vector3f(0.6928f, 1.2f, -0.8f),new Vector3f(0.6928f, 0.4f, -0.8f),new Vector3f(-0.0f, 0.0f, -0.8f),new Vector2f(0.5f, 0.5f),new Vector2f(0.75f, 0.933f),new Vector2f(0.25f, 0.933f),new Vector2f(0.0f, 0.5f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[11] = new ObjQuad(new Vector3f(0.0f, 0.8f, -0.8f),new Vector3f(-0.0f, 0.0f, -0.8f),new Vector3f(-0.6928f, 0.4f, -0.8f),new Vector3f(-0.6928f, 1.2f, -0.8f),new Vector2f(0.5f, 0.5f),new Vector2f(0.0f, 0.5f),new Vector2f(0.25f, 0.067f),new Vector2f(0.75f, 0.067f),new Vector3f(0.0f, 0.0f, -4.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Frame other = new Frame();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

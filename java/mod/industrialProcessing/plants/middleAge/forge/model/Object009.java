package  mod.industrialProcessing.plants.middleAge.forge.model;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Object009 extends ObjMesh{
	public Object009(){
		this.quads = new ObjQuad[6];
		this.quads[0] = new ObjQuad(new Vector3f(-0.8f, 0.0f, 0.4f),new Vector3f(0.8f, 0.0f, 0.4f),new Vector3f(0.8f, 1.6f, 0.4f),new Vector3f(-0.8f, 1.6f, 0.4f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.8f, 0.0f, -0.8f),new Vector3f(-0.8f, 0.0f, -0.8f),new Vector3f(-0.8f, 1.6f, -0.8f),new Vector3f(0.8f, 1.6f, -0.8f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.8f, 0.0f, 0.4f),new Vector3f(-0.8f, 0.0f, -0.8f),new Vector3f(0.8f, 0.0f, -0.8f),new Vector3f(0.8f, 0.0f, 0.4f),new Vector2f(0.9995f, 0.125f),new Vector2f(0.9995f, 0.875f),new Vector2f(5.0E-4f, 0.875f),new Vector2f(5.0E-4f, 0.125f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.8f, 1.6f, -0.8f),new Vector3f(-0.8f, 1.6f, 0.4f),new Vector3f(0.8f, 1.6f, 0.4f),new Vector3f(0.8f, 1.6f, -0.8f),new Vector2f(5.0E-4f, 0.875f),new Vector2f(5.0E-4f, 0.125f),new Vector2f(0.9995f, 0.125f),new Vector2f(0.9995f, 0.875f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.8f, 0.0f, 0.4f),new Vector3f(0.8f, 0.0f, -0.8f),new Vector3f(0.8f, 1.6f, -0.8f),new Vector3f(0.8f, 1.6f, 0.4f),new Vector2f(0.125f, 5.0E-4f),new Vector2f(0.875f, 5.0E-4f),new Vector2f(0.875f, 0.9995f),new Vector2f(0.125f, 0.9995f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.8f, 1.6f, -0.8f),new Vector3f(-0.8f, 0.0f, -0.8f),new Vector3f(-0.8f, 0.0f, 0.4f),new Vector3f(-0.8f, 1.6f, 0.4f),new Vector2f(0.125f, 0.9995f),new Vector2f(0.125f, 5.0E-4f),new Vector2f(0.875f, 5.0E-4f),new Vector2f(0.875f, 0.9995f),new Vector3f(-4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Object009 other = new Object009();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

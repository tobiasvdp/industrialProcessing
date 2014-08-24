package  mod.industrialProcessing.plants.middleAge.forge.model;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Object007 extends ObjMesh{
	public Object007(){
		this.quads = new ObjQuad[13];
		this.quads[0] = new ObjQuad(new Vector3f(-0.8f, 1.6f, 0.8f),new Vector3f(-0.7f, 1.6f, 0.8f),new Vector3f(-0.7f, 1.6f, -0.8f),new Vector3f(-0.8f, 1.6f, -0.8f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.0629f, 5.0E-4f),new Vector2f(0.0629f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.8f, 0.0f, 0.8f),new Vector3f(0.8f, 0.0f, -0.8f),new Vector3f(0.8f, 0.1f, -0.8f),new Vector3f(0.8f, 0.1f, 0.8f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.0629f),new Vector2f(5.0E-4f, 0.0629f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.8f, 0.0f, -0.8f),new Vector3f(-0.8f, 0.0f, -0.8f),new Vector3f(-0.8f, 1.6f, -0.8f),new Vector3f(0.8f, 0.1f, -0.8f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.0629f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.8f, 1.6f, -0.8f),new Vector3f(-0.7f, 1.6f, -0.8f),new Vector3f(0.1536f, 1.2464f, -0.8f),new Vector3f(0.8f, 0.1f, -0.8f),new Vector2f(0.9995f, 0.9995f),new Vector2f(0.9371f, 0.9995f),new Vector2f(0.4041f, 0.7788f),new Vector2f(5.0E-4f, 0.0629f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.1536f, 1.2464f, -0.8f),new Vector3f(0.4464f, 0.9536f, -0.8f),new Vector3f(0.8f, 0.1f, -0.8f),new Vector2f(0.4041f, 0.7788f),new Vector2f(0.2212f, 0.5959f),new Vector2f(5.0E-4f, 0.0629f),new Vector3f(0.0f, 0.0f, -3.0f));
		this.quads[5] = new ObjQuad(new Vector3f(0.1536f, 1.2464f, 0.8f),new Vector3f(0.4464f, 0.9536f, 0.8f),new Vector3f(0.4464f, 0.9536f, -0.8f),new Vector3f(0.1536f, 1.2464f, -0.8f),new Vector2f(0.5959f, 5.0E-4f),new Vector2f(0.7788f, 5.0E-4f),new Vector2f(0.7788f, 0.9995f),new Vector2f(0.5959f, 0.9995f),new Vector3f(2.8284f, 2.8284f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.7f, 1.6f, 0.8f),new Vector3f(0.1536f, 1.2464f, 0.8f),new Vector3f(0.1536f, 1.2464f, -0.8f),new Vector3f(-0.7f, 1.6f, -0.8f),new Vector2f(0.0629f, 5.0E-4f),new Vector2f(0.5959f, 5.0E-4f),new Vector2f(0.5959f, 0.9995f),new Vector2f(0.0629f, 0.9995f),new Vector3f(1.5308f, 3.6956f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(0.4464f, 0.9536f, 0.8f),new Vector3f(0.8f, 0.1f, 0.8f),new Vector3f(0.8f, 0.1f, -0.8f),new Vector3f(0.4464f, 0.9536f, -0.8f),new Vector2f(5.0E-4f, 0.5959f),new Vector2f(5.0E-4f, 0.0629f),new Vector2f(0.9995f, 0.0629f),new Vector2f(0.9995f, 0.5959f),new Vector3f(3.6956f, 1.5308f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(-0.8f, 0.0f, -0.8f),new Vector3f(-0.8f, 0.0f, 0.8f),new Vector3f(-0.8f, 1.6f, 0.8f),new Vector3f(-0.8f, 1.6f, -0.8f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[9] = new ObjQuad(new Vector3f(0.8f, 0.0f, 0.8f),new Vector3f(0.8f, 0.1f, 0.8f),new Vector3f(0.4464f, 0.9536f, 0.8f),new Vector3f(-0.8f, 1.6f, 0.8f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.0629f),new Vector2f(0.7788f, 0.5959f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[10] = new ObjQuad(new Vector3f(0.4464f, 0.9536f, 0.8f),new Vector3f(0.1536f, 1.2464f, 0.8f),new Vector3f(-0.7f, 1.6f, 0.8f),new Vector3f(-0.8f, 1.6f, 0.8f),new Vector2f(0.7788f, 0.5959f),new Vector2f(0.5959f, 0.7788f),new Vector2f(0.0629f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[11] = new ObjQuad(new Vector3f(-0.8f, 0.0f, 0.8f),new Vector3f(0.8f, 0.0f, 0.8f),new Vector3f(-0.8f, 1.6f, 0.8f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(0.0f, 0.0f, 3.0f));
		this.quads[12] = new ObjQuad(new Vector3f(-0.8f, 0.0f, 0.8f),new Vector3f(-0.8f, 0.0f, -0.8f),new Vector3f(0.8f, 0.0f, -0.8f),new Vector3f(0.8f, 0.0f, 0.8f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector3f(0.0f, -4.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Object007 other = new Object007();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

package  mod.industrialProcessing.plants.middleAge.forge.model;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Object006 extends ObjMesh{
	public Object006(){
		this.quads = new ObjQuad[22];
		this.quads[0] = new ObjQuad(new Vector3f(-0.8f, 0.8f, 0.8f),new Vector3f(-0.2121f, 0.2121f, 0.8f),new Vector3f(0.0f, 0.0f, 0.8f),new Vector3f(-0.8f, 1.6f, 0.8f),new Vector2f(5.0E-4f, 0.5f),new Vector2f(0.3675f, 0.1329f),new Vector2f(0.5f, 5.0E-4f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.8f, 0.0f, 0.8f),new Vector3f(0.8f, 0.1f, 0.8f),new Vector3f(0.4464f, 0.9536f, 0.8f),new Vector3f(-0.7f, 1.6f, 0.8f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.0629f),new Vector2f(0.7788f, 0.5959f),new Vector2f(0.0629f, 0.9995f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.4464f, 0.9536f, 0.8f),new Vector3f(0.1536f, 1.2464f, 0.8f),new Vector3f(-0.7f, 1.6f, 0.8f),new Vector2f(0.7788f, 0.5959f),new Vector2f(0.5959f, 0.7788f),new Vector2f(0.0629f, 0.9995f),new Vector3f(0.0f, 0.0f, 3.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.0f, 0.0f, 0.8f),new Vector3f(0.8f, 0.0f, 0.8f),new Vector3f(-0.7f, 1.6f, 0.8f),new Vector3f(0.0f, 0.0f, 0.8f),new Vector2f(0.5f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.0629f, 0.9995f),new Vector2f(0.5f, 5.0E-4f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.0f, 0.0f, 0.8f),new Vector3f(-0.7f, 1.6f, 0.8f),new Vector3f(-0.8f, 1.6f, 0.8f),new Vector2f(0.5f, 5.0E-4f),new Vector2f(0.0629f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(0.0f, 0.0f, 3.0f));
		this.quads[5] = new ObjQuad(new Vector3f(0.8f, 0.0f, 0.8f),new Vector3f(0.8f, 0.0f, -0.8f),new Vector3f(0.8f, 0.1f, -0.8f),new Vector3f(0.8f, 0.1f, 0.8f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.0629f),new Vector2f(5.0E-4f, 0.0629f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(0.1536f, 1.2464f, 0.8f),new Vector3f(0.4464f, 0.9536f, 0.8f),new Vector3f(0.4464f, 0.9536f, -0.8f),new Vector3f(0.1536f, 1.2464f, -0.8f),new Vector2f(0.5959f, 5.0E-4f),new Vector2f(0.7788f, 5.0E-4f),new Vector2f(0.7788f, 0.9995f),new Vector2f(0.5959f, 0.9995f),new Vector3f(2.8284f, 2.8284f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.7f, 1.6f, 0.8f),new Vector3f(0.1536f, 1.2464f, 0.8f),new Vector3f(0.1536f, 1.2464f, -0.8f),new Vector3f(-0.7f, 1.6f, -0.8f),new Vector2f(0.0629f, 5.0E-4f),new Vector2f(0.5959f, 5.0E-4f),new Vector2f(0.5959f, 0.9995f),new Vector2f(0.0629f, 0.9995f),new Vector3f(1.5308f, 3.6956f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(0.4464f, 0.9536f, 0.8f),new Vector3f(0.8f, 0.1f, 0.8f),new Vector3f(0.8f, 0.1f, -0.8f),new Vector3f(0.4464f, 0.9536f, -0.8f),new Vector2f(5.0E-4f, 0.5959f),new Vector2f(5.0E-4f, 0.0629f),new Vector2f(0.9995f, 0.0629f),new Vector2f(0.9995f, 0.5959f),new Vector3f(3.6956f, 1.5308f, 0.0f));
		this.quads[9] = new ObjQuad(new Vector3f(-0.8f, 0.0f, -0.3f),new Vector3f(-0.8f, 0.0f, -0.8f),new Vector3f(0.0f, 0.0f, -0.8f),new Vector3f(0.0f, 0.0f, 0.8f),new Vector2f(0.9995f, 0.6873f),new Vector2f(0.9995f, 0.9995f),new Vector2f(0.5f, 0.9995f),new Vector2f(0.5f, 5.0E-4f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[10] = new ObjQuad(new Vector3f(0.0f, 0.0f, 0.8f),new Vector3f(0.0f, 0.0f, 0.8f),new Vector3f(0.0f, 0.0f, -0.8f),new Vector2f(0.5f, 5.0E-4f),new Vector2f(0.5f, 5.0E-4f),new Vector2f(0.5f, 0.9995f),new Vector3f(3.0f, 0.0f, 0.0f));
		this.quads[11] = new ObjQuad(new Vector3f(-0.8f, 0.8f, 0.8f),new Vector3f(-0.8f, 0.2121f, 0.2121f),new Vector3f(-0.2121f, 0.2121f, 0.8f),new Vector2f(0.9995f, 0.5f),new Vector2f(0.6324f, 0.1329f),new Vector2f(0.9995f, 0.1329f),new Vector3f(-1.7322001f, -1.7322001f, 1.7322001f));
		this.quads[12] = new ObjQuad(new Vector3f(-0.8f, 0.2121f, 0.2121f),new Vector3f(-0.8f, 0.0f, -0.3f),new Vector3f(0.0f, 0.0f, 0.8f),new Vector3f(-0.2121f, 0.2121f, 0.8f),new Vector2f(0.9995f, 0.3676f),new Vector2f(0.9995f, 0.6873f),new Vector2f(0.5f, 5.0E-4f),new Vector2f(0.6325f, 5.0E-4f),new Vector3f(-2.0244f, -3.0216f, 1.6648f));
		this.quads[13] = new ObjQuad(new Vector3f(-0.8f, 1.6f, 0.8f),new Vector3f(-0.7f, 1.6f, 0.8f),new Vector3f(-0.7f, 1.6f, -0.8f),new Vector3f(-0.8f, 1.6f, -0.8f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.0629f, 5.0E-4f),new Vector2f(0.0629f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[14] = new ObjQuad(new Vector3f(0.0f, 0.0f, -0.8f),new Vector3f(0.8f, 0.0f, -0.8f),new Vector3f(0.8f, 0.0f, 0.8f),new Vector3f(0.0f, 0.0f, 0.8f),new Vector2f(0.5f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.5f, 5.0E-4f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[15] = new ObjQuad(new Vector3f(-0.8f, 0.0f, -0.3f),new Vector3f(-0.8f, 0.2121f, 0.2121f),new Vector3f(-0.8f, 0.8f, 0.8f),new Vector3f(-0.8f, 1.6f, -0.8f),new Vector2f(0.3127f, 5.0E-4f),new Vector2f(0.6324f, 0.1329f),new Vector2f(0.9995f, 0.5f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[16] = new ObjQuad(new Vector3f(-0.8f, 0.8f, 0.8f),new Vector3f(-0.8f, 1.6f, 0.8f),new Vector3f(-0.8f, 1.6f, -0.8f),new Vector2f(0.9995f, 0.5f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(-3.0f, 0.0f, 0.0f));
		this.quads[17] = new ObjQuad(new Vector3f(-0.8f, 0.0f, -0.8f),new Vector3f(-0.8f, 0.0f, -0.3f),new Vector3f(-0.8f, 1.6f, -0.8f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.3127f, 5.0E-4f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(-3.0f, 0.0f, 0.0f));
		this.quads[18] = new ObjQuad(new Vector3f(0.0f, 0.0f, -0.8f),new Vector3f(-0.8f, 0.0f, -0.8f),new Vector3f(-0.8f, 1.6f, -0.8f),new Vector3f(0.8f, 0.1f, -0.8f),new Vector2f(0.5f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.0629f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[19] = new ObjQuad(new Vector3f(-0.8f, 1.6f, -0.8f),new Vector3f(-0.7f, 1.6f, -0.8f),new Vector3f(0.1536f, 1.2464f, -0.8f),new Vector3f(0.8f, 0.1f, -0.8f),new Vector2f(0.9995f, 0.9995f),new Vector2f(0.9371f, 0.9995f),new Vector2f(0.4041f, 0.7788f),new Vector2f(5.0E-4f, 0.0629f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[20] = new ObjQuad(new Vector3f(0.1536f, 1.2464f, -0.8f),new Vector3f(0.4464f, 0.9536f, -0.8f),new Vector3f(0.8f, 0.1f, -0.8f),new Vector2f(0.4041f, 0.7788f),new Vector2f(0.2212f, 0.5959f),new Vector2f(5.0E-4f, 0.0629f),new Vector3f(0.0f, 0.0f, -3.0f));
		this.quads[21] = new ObjQuad(new Vector3f(0.0f, 0.0f, -0.8f),new Vector3f(0.8f, 0.1f, -0.8f),new Vector3f(0.8f, 0.0f, -0.8f),new Vector2f(0.5f, 5.0E-4f),new Vector2f(5.0E-4f, 0.0629f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector3f(0.0f, 0.0f, -3.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Object006 other = new Object006();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

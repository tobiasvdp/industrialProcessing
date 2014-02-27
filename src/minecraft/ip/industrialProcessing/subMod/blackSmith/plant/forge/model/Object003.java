package  ip.industrialProcessing.subMod.blackSmith.plant.forge.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Object003 extends ObjMesh{
	public Object003(){
		this.quads = new ObjQuad[11];
		this.quads[0] = new ObjQuad(new Vector3f(-0.8f, 1.6f, 0.8f),new Vector3f(0.8f, 1.6f, 0.8f),new Vector3f(0.8f, 1.6f, -0.8f),new Vector3f(-0.8f, 1.6f, -0.8f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.8f, 0.8f, 0.8f),new Vector3f(0.8f, 0.8f, 0.8f),new Vector3f(0.8f, 1.6f, 0.8f),new Vector3f(-0.8f, 1.6f, 0.8f),new Vector2f(5.0E-4f, 0.5f),new Vector2f(0.9995f, 0.5f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.8f, 0.0f, -0.3f),new Vector3f(-0.8f, 0.0f, -0.8f),new Vector3f(0.8f, 0.0f, -0.8f),new Vector3f(0.8f, 0.0f, -0.3f),new Vector2f(0.9995f, 0.6873f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector2f(5.0E-4f, 0.6873f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.8f, 0.2121f, 0.2121f),new Vector3f(0.8f, 0.8f, 0.8f),new Vector3f(-0.8f, 0.8f, 0.8f),new Vector3f(-0.8f, 0.2121f, 0.2121f),new Vector2f(5.0E-4f, 0.3675f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.3676f),new Vector3f(0.0f, -2.8284f, 2.8284f));
		this.quads[4] = new ObjQuad(new Vector3f(0.8f, 0.0f, -0.3f),new Vector3f(0.8f, 0.2121f, 0.2121f),new Vector3f(-0.8f, 0.2121f, 0.2121f),new Vector3f(-0.8f, 0.0f, -0.3f),new Vector2f(5.0E-4f, 0.6873f),new Vector2f(5.0E-4f, 0.3675f),new Vector2f(0.9995f, 0.3676f),new Vector2f(0.9995f, 0.6873f),new Vector3f(0.0f, -3.6956f, 1.5308f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.8f, 0.0f, -0.8f),new Vector3f(-0.8f, 0.0f, -0.3f),new Vector3f(-0.8f, 0.2121f, 0.2121f),new Vector3f(-0.8f, 1.6f, -0.8f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.3127f, 5.0E-4f),new Vector2f(0.6324f, 0.1329f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.8f, 1.6f, -0.8f),new Vector3f(-0.8f, 0.2121f, 0.2121f),new Vector3f(-0.8f, 0.8f, 0.8f),new Vector3f(-0.8f, 1.6f, 0.8f),new Vector2f(5.0E-4f, 0.9995f),new Vector2f(0.6324f, 0.1329f),new Vector2f(0.9995f, 0.5f),new Vector2f(0.9995f, 0.9995f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(0.8f, 1.6f, 0.8f),new Vector3f(0.8f, 0.8f, 0.8f),new Vector3f(0.8f, 0.2121f, 0.2121f),new Vector3f(0.8f, 0.0f, -0.8f),new Vector2f(5.0E-4f, 0.9995f),new Vector2f(5.0E-4f, 0.5f),new Vector2f(0.3675f, 0.1329f),new Vector2f(0.9995f, 5.0E-4f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(0.8f, 0.2121f, 0.2121f),new Vector3f(0.8f, 0.0f, -0.3f),new Vector3f(0.8f, 0.0f, -0.8f),new Vector2f(0.3675f, 0.1329f),new Vector2f(0.6873f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector3f(3.0f, 0.0f, 0.0f));
		this.quads[9] = new ObjQuad(new Vector3f(0.8f, 1.6f, -0.8f),new Vector3f(0.8f, 1.6f, 0.8f),new Vector3f(0.8f, 0.0f, -0.8f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector2f(0.9995f, 5.0E-4f),new Vector3f(3.0f, 0.0f, 0.0f));
		this.quads[10] = new ObjQuad(new Vector3f(-0.8f, 1.6f, -0.8f),new Vector3f(0.8f, 1.6f, -0.8f),new Vector3f(0.8f, 0.0f, -0.8f),new Vector3f(-0.8f, 0.0f, -0.8f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector3f(0.0f, 0.0f, -4.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Object003 other = new Object003();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

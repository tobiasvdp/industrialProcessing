package  ip.industrialProcessing.subMod.blackSmith.plant.forge.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Object004 extends ObjMesh{
	public Object004(){
		this.quads = new ObjQuad[12];
		this.quads[0] = new ObjQuad(new Vector3f(0.8f, 0.0f, -0.8f),new Vector3f(-0.8f, 0.0f, -0.8f),new Vector3f(-0.8f, 1.6f, -0.8f),new Vector3f(0.8f, 1.6f, -0.8f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.8f, 0.0f, -0.8f),new Vector3f(-0.8f, 0.0f, 0.8f),new Vector3f(-0.8f, 1.6f, 0.8f),new Vector3f(-0.8f, 1.6f, -0.8f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.8f, 0.0f, 0.4f),new Vector3f(0.8f, 1.6f, 0.4f),new Vector3f(0.0f, 1.6f, 0.4f),new Vector3f(0.0f, 0.0f, 0.4f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.9995f),new Vector2f(0.5f, 0.9995f),new Vector2f(0.5f, 5.0E-4f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.0f, 0.0f, 0.4f),new Vector3f(0.0f, 1.6f, 0.4f),new Vector3f(0.0f, 1.6f, 0.8f),new Vector3f(0.0f, 0.0f, 0.8f),new Vector2f(0.2502f, 5.0E-4f),new Vector2f(0.2502f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.0f, 0.0f, 0.4f),new Vector3f(0.0f, 0.0f, 0.8f),new Vector3f(-0.8f, 0.0f, 0.8f),new Vector3f(0.8f, 0.0f, -0.8f),new Vector2f(0.5f, 0.2502f),new Vector2f(0.5f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.8f, 0.0f, 0.8f),new Vector3f(-0.8f, 0.0f, -0.8f),new Vector3f(0.8f, 0.0f, -0.8f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(0.0f, -3.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(0.8f, 0.0f, 0.4f),new Vector3f(0.0f, 0.0f, 0.4f),new Vector3f(0.8f, 0.0f, -0.8f),new Vector2f(5.0E-4f, 0.2502f),new Vector2f(0.5f, 0.2502f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(0.0f, -3.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(0.8f, 0.0f, -0.8f),new Vector3f(0.8f, 1.6f, -0.8f),new Vector3f(0.8f, 1.6f, 0.4f),new Vector3f(0.8f, 0.0f, 0.4f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.9995f),new Vector2f(0.2502f, 0.9995f),new Vector2f(0.2502f, 5.0E-4f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(0.8f, 1.6f, -0.8f),new Vector3f(-0.8f, 1.6f, -0.8f),new Vector3f(-0.8f, 1.6f, 0.8f),new Vector3f(0.0f, 1.6f, 0.4f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.5f, 0.2502f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[9] = new ObjQuad(new Vector3f(-0.8f, 1.6f, 0.8f),new Vector3f(0.0f, 1.6f, 0.8f),new Vector3f(0.0f, 1.6f, 0.4f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.5f, 5.0E-4f),new Vector2f(0.5f, 0.2502f),new Vector3f(0.0f, 3.0f, 0.0f));
		this.quads[10] = new ObjQuad(new Vector3f(0.8f, 1.6f, -0.8f),new Vector3f(0.0f, 1.6f, 0.4f),new Vector3f(0.8f, 1.6f, 0.4f),new Vector2f(0.9995f, 0.9995f),new Vector2f(0.5f, 0.2502f),new Vector2f(0.9995f, 0.2502f),new Vector3f(0.0f, 3.0f, 0.0f));
		this.quads[11] = new ObjQuad(new Vector3f(-0.8f, 1.6f, 0.8f),new Vector3f(-0.8f, 0.0f, 0.8f),new Vector3f(0.0f, 0.0f, 0.8f),new Vector3f(0.0f, 1.6f, 0.8f),new Vector2f(5.0E-4f, 0.9995f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.5f, 5.0E-4f),new Vector2f(0.5f, 0.9995f),new Vector3f(0.0f, 0.0f, 4.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Object004 other = new Object004();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

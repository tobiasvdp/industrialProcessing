package ip.industrialProcessing.subMod.mine.machines.mining.bobcatMiner.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Rod extends ObjMesh{
	public Rod(){
		this.quads = new ObjQuad[11];
		this.quads[0] = new ObjQuad(new Vector3f(-0.2f, 0.9f, 2.1f),new Vector3f(-0.2f, 0.9f, 0.7f),new Vector3f(0.2f, 0.9f, 0.7f),new Vector3f(0.2f, 0.9f, 2.1f),new Vector2f(0.9995f, 0.0671f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector2f(5.0E-4f, 0.0671f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.2f, 1.3f, 2.1f),new Vector3f(0.2f, 1.3f, 2.1f),new Vector3f(0.2f, 1.3f, 0.7f),new Vector3f(-0.2f, 1.3f, 0.7f),new Vector2f(5.0E-4f, 0.0671f),new Vector2f(0.9995f, 0.0671f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.2f, 1.0f, 2.2f),new Vector3f(0.2f, 1.0f, 2.2f),new Vector3f(0.2f, 1.2f, 2.2f),new Vector3f(-0.2f, 1.2f, 2.2f),new Vector2f(5.0E-4f, 0.2502f),new Vector2f(0.9995f, 0.2502f),new Vector2f(0.9995f, 0.7498f),new Vector2f(5.0E-4f, 0.7498f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.2f, 0.9f, 2.1f),new Vector3f(0.2f, 0.9f, 0.7f),new Vector3f(0.2f, 1.3f, 0.7f),new Vector3f(0.2f, 1.2f, 2.2f),new Vector2f(0.0671f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.7498f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.2f, 1.3f, 0.7f),new Vector3f(0.2f, 1.3f, 2.1f),new Vector3f(0.2f, 1.2f, 2.2f),new Vector2f(0.9995f, 0.9995f),new Vector2f(0.0671f, 0.9995f),new Vector2f(5.0E-4f, 0.7498f),new Vector3f(3.0f, 0.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(0.2f, 1.0f, 2.2f),new Vector3f(0.2f, 0.9f, 2.1f),new Vector3f(0.2f, 1.2f, 2.2f),new Vector2f(5.0E-4f, 0.2502f),new Vector2f(0.0671f, 5.0E-4f),new Vector2f(5.0E-4f, 0.7498f),new Vector3f(3.0f, 0.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.2f, 0.9f, 0.7f),new Vector3f(-0.2f, 0.9f, 2.1f),new Vector3f(-0.2f, 1.0f, 2.2f),new Vector3f(-0.2f, 1.3f, 2.1f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.9329f, 5.0E-4f),new Vector2f(0.9995f, 0.2502f),new Vector2f(0.9329f, 0.9995f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.2f, 1.0f, 2.2f),new Vector3f(-0.2f, 1.2f, 2.2f),new Vector3f(-0.2f, 1.3f, 2.1f),new Vector2f(0.9995f, 0.2502f),new Vector2f(0.9995f, 0.7498f),new Vector2f(0.9329f, 0.9995f),new Vector3f(-3.0f, 0.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(-0.2f, 0.9f, 0.7f),new Vector3f(-0.2f, 1.3f, 2.1f),new Vector3f(-0.2f, 1.3f, 0.7f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.9329f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(-3.0f, 0.0f, 0.0f));
		this.quads[9] = new ObjQuad(new Vector3f(0.2f, 0.9f, 2.1f),new Vector3f(0.2f, 1.0f, 2.2f),new Vector3f(-0.2f, 1.0f, 2.2f),new Vector3f(-0.2f, 0.9f, 2.1f),new Vector2f(5.0E-4f, 0.0671f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.0671f),new Vector3f(0.0f, -2.8284f, 2.8284f));
		this.quads[10] = new ObjQuad(new Vector3f(-0.2f, 1.3f, 2.1f),new Vector3f(-0.2f, 1.2f, 2.2f),new Vector3f(0.2f, 1.2f, 2.2f),new Vector3f(0.2f, 1.3f, 2.1f),new Vector2f(5.0E-4f, 0.0671f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.0671f),new Vector3f(0.0f, 2.8284f, 2.8284f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Rod other = new Rod();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

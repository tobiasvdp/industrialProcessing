package ip.industrialProcessing.subMod.mine.machines.mining.bobcatMiner.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Cabine extends ObjMesh{
	public Cabine(){
		this.quads = new ObjQuad[18];
		this.quads[0] = new ObjQuad(new Vector3f(0.4f, 1.6f, 0.6f),new Vector3f(0.6f, 1.6f, 0.6f),new Vector3f(0.6f, 3.0f, 0.6f),new Vector3f(0.4f, 3.0f, 0.6f),new Vector2f(0.833f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.8746f),new Vector2f(0.833f, 0.8746f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.6f, 1.6f, 0.6f),new Vector3f(0.6f, 1.6f, 0.4f),new Vector3f(0.6f, 3.0f, 0.4f),new Vector3f(0.6f, 3.0f, 0.6f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.1254f, 5.0E-4f),new Vector2f(0.1254f, 0.8746f),new Vector2f(5.0E-4f, 0.8746f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.6f, 1.6f, 0.4f),new Vector3f(0.4f, 1.6f, 0.4f),new Vector3f(0.4f, 3.0f, 0.4f),new Vector3f(0.6f, 3.0f, 0.4f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.167f, 5.0E-4f),new Vector2f(0.167f, 0.8746f),new Vector2f(5.0E-4f, 0.8746f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.4f, 1.6f, 0.4f),new Vector3f(0.4f, 1.6f, 0.6f),new Vector3f(0.4f, 3.0f, 0.6f),new Vector3f(0.4f, 3.0f, 0.4f),new Vector2f(0.8746f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.8746f),new Vector2f(0.8746f, 0.8746f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.6f, 1.6f, 0.6f),new Vector3f(-0.4f, 1.6f, 0.6f),new Vector3f(-0.4f, 3.0f, 0.6f),new Vector3f(-0.6f, 3.0f, 0.6f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.167f, 5.0E-4f),new Vector2f(0.167f, 0.8746f),new Vector2f(5.0E-4f, 0.8746f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.4f, 1.6f, 0.6f),new Vector3f(-0.4f, 1.6f, 0.4f),new Vector3f(-0.4f, 3.0f, 0.4f),new Vector3f(-0.4f, 3.0f, 0.6f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.1254f, 5.0E-4f),new Vector2f(0.1254f, 0.8746f),new Vector2f(5.0E-4f, 0.8746f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.4f, 1.6f, 0.4f),new Vector3f(-0.6f, 1.6f, 0.4f),new Vector3f(-0.6f, 3.0f, 0.4f),new Vector3f(-0.4f, 3.0f, 0.4f),new Vector2f(0.833f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.8746f),new Vector2f(0.833f, 0.8746f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.6f, 1.6f, 0.4f),new Vector3f(-0.6f, 1.6f, 0.6f),new Vector3f(-0.6f, 3.0f, 0.6f),new Vector3f(-0.6f, 3.0f, 0.4f),new Vector2f(0.8746f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.8746f),new Vector2f(0.8746f, 0.8746f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(-0.6f, 1.6f, -0.8f),new Vector3f(0.6f, 1.6f, -0.8f),new Vector3f(0.6f, 3.0f, -0.8f),new Vector3f(-0.6f, 3.0f, -0.8f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.8746f),new Vector2f(5.0E-4f, 0.8746f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[9] = new ObjQuad(new Vector3f(0.6f, 1.6f, -0.8f),new Vector3f(0.6f, 1.6f, -1.0f),new Vector3f(0.6f, 3.0f, -1.0f),new Vector3f(0.6f, 3.0f, -0.8f),new Vector2f(0.8746f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.8746f),new Vector2f(0.8746f, 0.8746f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[10] = new ObjQuad(new Vector3f(0.6f, 1.6f, -1.0f),new Vector3f(-0.6f, 1.6f, -1.0f),new Vector3f(-0.6f, 3.0f, -1.0f),new Vector3f(0.6f, 3.0f, -1.0f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.8746f),new Vector2f(5.0E-4f, 0.8746f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[11] = new ObjQuad(new Vector3f(-0.6f, 1.6f, -1.0f),new Vector3f(-0.6f, 1.6f, -0.8f),new Vector3f(-0.6f, 3.0f, -0.8f),new Vector3f(-0.6f, 3.0f, -1.0f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.1254f, 5.0E-4f),new Vector2f(0.1254f, 0.8746f),new Vector2f(5.0E-4f, 0.8746f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[12] = new ObjQuad(new Vector3f(-0.6f, 3.0f, 0.6f),new Vector3f(-0.6f, 3.0f, -1.0f),new Vector3f(0.6f, 3.0f, -1.0f),new Vector3f(0.6f, 3.0f, 0.6f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[13] = new ObjQuad(new Vector3f(-0.6f, 3.2f, 0.6f),new Vector3f(0.6f, 3.2f, 0.6f),new Vector3f(0.6f, 3.2f, -1.0f),new Vector3f(-0.6f, 3.2f, -1.0f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[14] = new ObjQuad(new Vector3f(-0.6f, 3.0f, 0.6f),new Vector3f(0.6f, 3.0f, 0.6f),new Vector3f(0.6f, 3.2f, 0.6f),new Vector3f(-0.6f, 3.2f, 0.6f),new Vector2f(5.0E-4f, 0.8746f),new Vector2f(0.9995f, 0.8746f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[15] = new ObjQuad(new Vector3f(0.6f, 3.0f, 0.6f),new Vector3f(0.6f, 3.0f, -1.0f),new Vector3f(0.6f, 3.2f, -1.0f),new Vector3f(0.6f, 3.2f, 0.6f),new Vector2f(5.0E-4f, 0.8746f),new Vector2f(0.9995f, 0.8746f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[16] = new ObjQuad(new Vector3f(0.6f, 3.0f, -1.0f),new Vector3f(-0.6f, 3.0f, -1.0f),new Vector3f(-0.6f, 3.2f, -1.0f),new Vector3f(0.6f, 3.2f, -1.0f),new Vector2f(5.0E-4f, 0.8746f),new Vector2f(0.9995f, 0.8746f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[17] = new ObjQuad(new Vector3f(-0.6f, 3.0f, -1.0f),new Vector3f(-0.6f, 3.0f, 0.6f),new Vector3f(-0.6f, 3.2f, 0.6f),new Vector3f(-0.6f, 3.2f, -1.0f),new Vector2f(5.0E-4f, 0.8746f),new Vector2f(0.9995f, 0.8746f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(-4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Cabine other = new Cabine();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

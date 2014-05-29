package ip.industrialProcessing.multiblock.dummy.block.ironPole.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class PowerConnector extends ObjMesh{
	public PowerConnector(){
		this.quads = new ObjQuad[12];
		this.quads[0] = new ObjQuad(new Vector3f(-0.3f, 0.5f, -0.7f),new Vector3f(-0.3f, 0.5f, -0.8f),new Vector3f(0.3f, 0.5f, -0.8f),new Vector3f(0.3f, 0.5f, -0.7f),new Vector2f(0.8746f, 0.8746f),new Vector2f(0.8746f, 0.9995f),new Vector2f(0.1254f, 0.9995f),new Vector2f(0.1254f, 0.8746f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.3f, 1.1f, -0.7f),new Vector3f(0.3f, 1.1f, -0.7f),new Vector3f(0.3f, 1.1f, -0.8f),new Vector3f(-0.3f, 1.1f, -0.8f),new Vector2f(0.1254f, 0.8746f),new Vector2f(0.8746f, 0.8746f),new Vector2f(0.8746f, 0.9995f),new Vector2f(0.1254f, 0.9995f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.3f, 0.5f, -0.7f),new Vector3f(0.3f, 0.5f, -0.8f),new Vector3f(0.3f, 1.1f, -0.8f),new Vector3f(0.3f, 1.1f, -0.7f),new Vector2f(0.8746f, 0.1254f),new Vector2f(0.9995f, 0.1254f),new Vector2f(0.9995f, 0.8746f),new Vector2f(0.8746f, 0.8746f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.3f, 0.5f, -0.8f),new Vector3f(-0.3f, 0.5f, -0.7f),new Vector3f(-0.3f, 1.1f, -0.7f),new Vector3f(-0.3f, 1.1f, -0.8f),new Vector2f(5.0E-4f, 0.1254f),new Vector2f(0.1254f, 0.1254f),new Vector2f(0.1254f, 0.8746f),new Vector2f(5.0E-4f, 0.8746f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.3f, 0.5f, -0.7f),new Vector3f(0.3f, 0.5f, -0.7f),new Vector3f(0.4f, 0.4f, -0.1f),new Vector3f(-0.4f, 0.4f, -0.1f),new Vector2f(0.8746f, 0.8746f),new Vector2f(0.1254f, 0.8746f),new Vector2f(5.0E-4f, 0.1254f),new Vector2f(0.9995f, 0.1254f),new Vector3f(0.0f, -3.9456f, -0.6576f));
		this.quads[5] = new ObjQuad(new Vector3f(0.3f, 0.5f, -0.7f),new Vector3f(0.3f, 1.1f, -0.7f),new Vector3f(0.4f, 1.2f, -0.1f),new Vector3f(0.4f, 0.4f, -0.1f),new Vector2f(0.8746f, 0.1254f),new Vector2f(0.8746f, 0.8746f),new Vector2f(0.1254f, 0.9995f),new Vector2f(0.1254f, 5.0E-4f),new Vector3f(3.9456f, 0.0f, -0.6576f));
		this.quads[6] = new ObjQuad(new Vector3f(0.3f, 1.1f, -0.7f),new Vector3f(-0.3f, 1.1f, -0.7f),new Vector3f(-0.4f, 1.2f, -0.1f),new Vector3f(0.4f, 1.2f, -0.1f),new Vector2f(0.8746f, 0.8746f),new Vector2f(0.1254f, 0.8746f),new Vector2f(5.0E-4f, 0.1254f),new Vector2f(0.9995f, 0.1254f),new Vector3f(0.0f, 3.9456f, -0.6576f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.3f, 1.1f, -0.7f),new Vector3f(-0.3f, 0.5f, -0.7f),new Vector3f(-0.4f, 0.4f, -0.1f),new Vector3f(-0.4f, 1.2f, -0.1f),new Vector2f(0.1254f, 0.8746f),new Vector2f(0.1254f, 0.1254f),new Vector2f(0.8746f, 5.0E-4f),new Vector2f(0.8746f, 0.9995f),new Vector3f(-3.9456f, 0.0f, -0.6576f));
		this.quads[8] = new ObjQuad(new Vector3f(-0.4f, 0.4f, -0.1f),new Vector3f(0.4f, 0.4f, -0.1f),new Vector3f(0.4f, 0.4f, -0.0f),new Vector3f(-0.4f, 0.4f, -0.0f),new Vector2f(0.9995f, 0.1254f),new Vector2f(5.0E-4f, 0.1254f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[9] = new ObjQuad(new Vector3f(0.4f, 0.4f, -0.1f),new Vector3f(0.4f, 1.2f, -0.1f),new Vector3f(0.4f, 1.2f, -0.0f),new Vector3f(0.4f, 0.4f, -0.0f),new Vector2f(0.1254f, 5.0E-4f),new Vector2f(0.1254f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[10] = new ObjQuad(new Vector3f(0.4f, 1.2f, -0.1f),new Vector3f(-0.4f, 1.2f, -0.1f),new Vector3f(-0.4f, 1.2f, -0.0f),new Vector3f(0.4f, 1.2f, -0.0f),new Vector2f(0.9995f, 0.1254f),new Vector2f(5.0E-4f, 0.1254f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[11] = new ObjQuad(new Vector3f(-0.4f, 1.2f, -0.1f),new Vector3f(-0.4f, 0.4f, -0.1f),new Vector3f(-0.4f, 0.4f, -0.0f),new Vector3f(-0.4f, 1.2f, -0.0f),new Vector2f(0.8746f, 0.9995f),new Vector2f(0.8746f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.9995f),new Vector3f(-4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		PowerConnector other = new PowerConnector();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

package ip.industrialProcessing.multiblock.dummy.block.controlBox.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Button3 extends ObjMesh{
	public Button3(){
		this.quads = new ObjQuad[5];
		this.quads[0] = new ObjQuad(new Vector3f(0.05f, 0.5f, -0.57f),new Vector3f(0.05f, 0.6f, -0.57f),new Vector3f(-0.05f, 0.6f, -0.57f),new Vector3f(-0.05f, 0.5f, -0.57f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.05f, 0.5f, -0.62f),new Vector3f(0.05f, 0.5f, -0.62f),new Vector3f(0.05f, 0.5f, -0.57f),new Vector3f(-0.05f, 0.5f, -0.57f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.05f, 0.5f, -0.62f),new Vector3f(0.05f, 0.6f, -0.62f),new Vector3f(0.05f, 0.6f, -0.57f),new Vector3f(0.05f, 0.5f, -0.57f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.05f, 0.6f, -0.62f),new Vector3f(-0.05f, 0.6f, -0.62f),new Vector3f(-0.05f, 0.6f, -0.57f),new Vector3f(0.05f, 0.6f, -0.57f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.05f, 0.6f, -0.62f),new Vector3f(-0.05f, 0.5f, -0.62f),new Vector3f(-0.05f, 0.5f, -0.57f),new Vector3f(-0.05f, 0.6f, -0.57f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector3f(-4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Button3 other = new Button3();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

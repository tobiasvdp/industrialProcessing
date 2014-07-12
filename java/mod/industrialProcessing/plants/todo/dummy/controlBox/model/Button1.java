package mod.industrialProcessing.plants.todo.dummy.controlBox.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Button1 extends ObjMesh{
	public Button1(){
		this.quads = new ObjQuad[5];
		this.quads[0] = new ObjQuad(new Vector3f(-0.05f, 1.1f, -0.57f),new Vector3f(-0.05f, 1.0f, -0.57f),new Vector3f(0.05f, 1.0f, -0.57f),new Vector3f(0.05f, 1.1f, -0.57f),new Vector2f(5.0E-4f, 0.9995f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.9995f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.05f, 1.1f, -0.62f),new Vector3f(-0.05f, 1.1f, -0.62f),new Vector3f(-0.05f, 1.1f, -0.57f),new Vector3f(0.05f, 1.1f, -0.57f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.05f, 1.1f, -0.62f),new Vector3f(-0.05f, 1.0f, -0.62f),new Vector3f(-0.05f, 1.0f, -0.57f),new Vector3f(-0.05f, 1.1f, -0.57f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.05f, 1.0f, -0.62f),new Vector3f(0.05f, 1.0f, -0.62f),new Vector3f(0.05f, 1.0f, -0.57f),new Vector3f(-0.05f, 1.0f, -0.57f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.05f, 1.0f, -0.62f),new Vector3f(0.05f, 1.1f, -0.62f),new Vector3f(0.05f, 1.1f, -0.57f),new Vector3f(0.05f, 1.0f, -0.57f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector3f(4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Button1 other = new Button1();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

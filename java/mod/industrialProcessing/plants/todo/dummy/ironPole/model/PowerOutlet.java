package mod.industrialProcessing.plants.todo.dummy.ironPole.model;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class PowerOutlet extends ObjMesh{
	public PowerOutlet(){
		this.quads = new ObjQuad[1];
		this.quads[0] = new ObjQuad(new Vector3f(0.3f, 0.5f, -0.8f),new Vector3f(-0.3f, 0.5f, -0.8f),new Vector3f(-0.3f, 1.1f, -0.8f),new Vector3f(0.3f, 1.1f, -0.8f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(0.0f, 0.0f, -4.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		PowerOutlet other = new PowerOutlet();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

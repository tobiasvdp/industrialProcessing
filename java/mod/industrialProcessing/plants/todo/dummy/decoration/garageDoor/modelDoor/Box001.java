package mod.industrialProcessing.plants.todo.dummy.decoration.garageDoor.modelDoor;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Box001 extends ObjMesh{
	public Box001(){
		this.quads = new ObjQuad[4];
		this.quads[0] = new ObjQuad(new Vector3f(-0.8f, 0.0f, 0.05f),new Vector3f(-0.8f, 0.0f, -0.05f),new Vector3f(0.8f, 0.0f, -0.05f),new Vector3f(0.8f, 0.0f, 0.05f),new Vector2f(0.8795f, 0.0612f),new Vector2f(0.8795f, 0.1161f),new Vector2f(0.002f, 0.1161f),new Vector2f(0.002f, 0.0612f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.8f, 1.6f, 0.05f),new Vector3f(0.8f, 1.6f, 0.05f),new Vector3f(0.8f, 1.6f, -0.05f),new Vector3f(-0.8f, 1.6f, -0.05f),new Vector2f(0.002f, 0.002f),new Vector2f(0.8795f, 0.002f),new Vector2f(0.8795f, 0.0568f),new Vector2f(0.002f, 0.0568f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.8f, 0.0f, 0.05f),new Vector3f(0.8f, 0.0f, -0.05f),new Vector3f(0.8f, 1.6f, -0.05f),new Vector3f(0.8f, 1.6f, 0.05f),new Vector2f(0.0612f, 0.1205f),new Vector2f(0.1161f, 0.1205f),new Vector2f(0.1161f, 0.998f),new Vector2f(0.0612f, 0.998f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.8f, 0.0f, -0.05f),new Vector3f(-0.8f, 0.0f, 0.05f),new Vector3f(-0.8f, 1.6f, 0.05f),new Vector3f(-0.8f, 1.6f, -0.05f),new Vector2f(0.002f, 0.1205f),new Vector2f(0.0568f, 0.1205f),new Vector2f(0.0568f, 0.998f),new Vector2f(0.002f, 0.998f),new Vector3f(-4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Box001 other = new Box001();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

package ip.industrialProcessing.multiblock.dummy.block.decoration.garageDoor.modelDoor;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Object001 extends ObjMesh{
	public Object001(){
		this.quads = new ObjQuad[1];
		this.quads[0] = new ObjQuad(new Vector3f(-0.8f, 0.0f, 0.05f),new Vector3f(0.8f, 0.0f, 0.05f),new Vector3f(0.8f, 1.6f, 0.05f),new Vector3f(-0.8f, 1.6f, 0.05f),new Vector2f(0.0f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector3f(0.0f, 0.0f, 4.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Object001 other = new Object001();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

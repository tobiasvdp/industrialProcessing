package mod.industrialProcessing.plants.todo.core.blastFurnace.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class ConnectorFillerTop extends ObjMesh{
	public ConnectorFillerTop(){
		this.quads = new ObjQuad[1];
		this.quads[0] = new ObjQuad(new Vector3f(-0.7f, 1.6f, -0.7f),new Vector3f(-0.7f, 1.6f, 0.7f),new Vector3f(0.7f, 1.6f, 0.7f),new Vector3f(0.7f, 1.6f, -0.7f),new Vector2f(0.0625f, 0.9375f),new Vector2f(0.0625f, 0.0625f),new Vector2f(0.9375f, 0.0625f),new Vector2f(0.9375f, 0.9375f),new Vector3f(0.0f, 4.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		ConnectorFillerTop other = new ConnectorFillerTop();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

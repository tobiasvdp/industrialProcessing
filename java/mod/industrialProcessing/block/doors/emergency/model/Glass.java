package mod.industrialProcessing.block.doors.emergency.model;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Glass extends ObjMesh{
	public Glass(){
		this.quads = new ObjQuad[2];
		this.quads[0] = new ObjQuad(new Vector3f(0.32f, 0.2f, -0.01f),new Vector3f(0.32f, 1.4f, -0.01f),new Vector3f(0.6f, 1.4f, -0.01f),new Vector3f(0.6f, 0.2f, -0.01f),new Vector2f(0.425f, 0.0f),new Vector2f(0.425f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector2f(0.0f, 0.0f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.6f, 0.2f, 0.01f),new Vector3f(0.6f, 1.4f, 0.01f),new Vector3f(0.32f, 1.4f, 0.01f),new Vector3f(0.32f, 0.2f, 0.01f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 1.0f),new Vector2f(0.575f, 1.0f),new Vector2f(0.575f, 0.0f),new Vector3f(0.0f, 0.0f, 4.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Glass other = new Glass();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

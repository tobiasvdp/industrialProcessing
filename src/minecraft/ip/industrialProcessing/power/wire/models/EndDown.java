package ip.industrialProcessing.power.wire.models;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class EndDown extends ObjMesh{
	public EndDown(){
		this.quads = new ObjQuad[4];
		this.quads[0] = new ObjQuad(new Vector3f(0.2f, 0.6f, 0.2f),new Vector3f(-0.2f, 0.6f, 0.2f),new Vector3f(-0.2f, 0.0f, 0.2f),new Vector3f(0.2f, -0.0f, 0.2f),new Vector2f(0.500232f, 0.624988f),new Vector2f(0.750095f, 0.624988f),new Vector2f(0.750095f, 0.999748f),new Vector2f(0.500232f, 0.999748f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.2f, 0.6f, 0.2f),new Vector3f(-0.2f, 0.6f, -0.2f),new Vector3f(-0.2f, 0.0f, -0.2f),new Vector3f(-0.2f, 0.0f, 0.2f),new Vector2f(0.500232f, 0.624988f),new Vector2f(0.750095f, 0.624988f),new Vector2f(0.750095f, 0.999748f),new Vector2f(0.500232f, 0.999748f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.2f, 0.6f, -0.2f),new Vector3f(0.2f, 0.6f, -0.2f),new Vector3f(0.2f, -0.0f, -0.2f),new Vector3f(-0.2f, 0.0f, -0.2f),new Vector2f(0.500232f, 0.624988f),new Vector2f(0.750095f, 0.624988f),new Vector2f(0.750095f, 0.999748f),new Vector2f(0.500232f, 0.999748f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.2f, 0.6f, -0.2f),new Vector3f(0.2f, 0.6f, 0.2f),new Vector3f(0.2f, -0.0f, 0.2f),new Vector3f(0.2f, -0.0f, -0.2f),new Vector2f(0.500232f, 0.624988f),new Vector2f(0.750095f, 0.624988f),new Vector2f(0.750095f, 0.999748f),new Vector2f(0.500232f, 0.999748f),new Vector3f(4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		EndDown other = new EndDown();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

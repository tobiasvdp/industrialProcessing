package ip.industrialProcessing.transport.fluids.models.raintank;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class RainTankBottom extends ObjMesh{
	public RainTankBottom(){
		this.quads = new ObjQuad[6];
		this.quads[0] = new ObjQuad(new Vector3f(0.8f, 1.1f, -0.8f),new Vector3f(0.8f, 1.1f, 0.8f),new Vector3f(-0.8f, 1.1f, 0.8f),new Vector3f(-0.8f, 1.1f, -0.8f),new Vector2f(-0.0f, 1.0f),new Vector2f(0.0f, -0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 1.0f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.8f, 1.2f, -0.8f),new Vector3f(-0.8f, 1.2f, -0.8f),new Vector3f(-0.8f, 1.2f, 0.8f),new Vector3f(0.8f, 1.2f, 0.8f),new Vector2f(1.0f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector2f(-0.0f, 0.0f),new Vector2f(1.0f, -0.0f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.8f, 1.2f, 0.8f),new Vector3f(-0.8f, 1.2f, 0.8f),new Vector3f(-0.8f, 1.1f, 0.8f),new Vector3f(0.8f, 1.1f, 0.8f),new Vector2f(1.0f, 0.75f),new Vector2f(-0.0f, 0.75f),new Vector2f(-0.0f, 0.6875f),new Vector2f(1.0f, 0.6875f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.8f, 1.2f, -0.8f),new Vector3f(0.8f, 1.2f, 0.8f),new Vector3f(0.8f, 1.1f, 0.8f),new Vector3f(0.8f, 1.1f, -0.8f),new Vector2f(1.0f, 0.75f),new Vector2f(-0.0f, 0.75f),new Vector2f(-0.0f, 0.6875f),new Vector2f(1.0f, 0.6875f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.8f, 1.2f, -0.8f),new Vector3f(0.8f, 1.2f, -0.8f),new Vector3f(0.8f, 1.1f, -0.8f),new Vector3f(-0.8f, 1.1f, -0.8f),new Vector2f(1.0f, 0.75f),new Vector2f(-0.0f, 0.75f),new Vector2f(-0.0f, 0.6875f),new Vector2f(1.0f, 0.6875f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.8f, 1.2f, 0.8f),new Vector3f(-0.8f, 1.2f, -0.8f),new Vector3f(-0.8f, 1.1f, -0.8f),new Vector3f(-0.8f, 1.1f, 0.8f),new Vector2f(1.0f, 0.75f),new Vector2f(-0.0f, 0.75f),new Vector2f(-0.0f, 0.6875f),new Vector2f(1.0f, 0.6875f),new Vector3f(-4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		RainTankBottom other = new RainTankBottom();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

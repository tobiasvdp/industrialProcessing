package mod.industrialProcessing.transport.fluids.models.block.raintank;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class RainTankSide extends ObjMesh{
	public RainTankSide(){
		this.quads = new ObjQuad[3];
		this.quads[0] = new ObjQuad(new Vector3f(-0.7f, 1.6f, 0.8f),new Vector3f(0.7f, 1.6f, 0.8f),new Vector3f(0.7f, 1.6f, 0.7f),new Vector3f(-0.7f, 1.6f, 0.7f),new Vector2f(0.0625f, 0.0f),new Vector2f(0.9375f, -0.0f),new Vector2f(0.9375f, 0.0625f),new Vector2f(0.0625f, 0.0625f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.7f, 1.2f, 0.8f),new Vector3f(0.7f, 1.2f, 0.8f),new Vector3f(0.7f, 1.6f, 0.8f),new Vector3f(-0.7f, 1.6f, 0.8f),new Vector2f(0.0625f, 0.75f),new Vector2f(0.9375f, 0.75f),new Vector2f(0.9375f, 1.0f),new Vector2f(0.0625f, 1.0f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.7f, 1.2f, 0.7f),new Vector3f(-0.7f, 1.2f, 0.7f),new Vector3f(-0.7f, 1.6f, 0.7f),new Vector3f(0.7f, 1.6f, 0.7f),new Vector2f(0.0625f, 0.75f),new Vector2f(0.9375f, 0.75f),new Vector2f(0.9375f, 1.0f),new Vector2f(0.0625f, 1.0f),new Vector3f(0.0f, 0.0f, -4.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		RainTankSide other = new RainTankSide();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

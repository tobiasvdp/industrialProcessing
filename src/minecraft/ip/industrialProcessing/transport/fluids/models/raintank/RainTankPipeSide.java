package ip.industrialProcessing.transport.fluids.models.raintank;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class RainTankPipeSide extends ObjMesh{
	public RainTankPipeSide(){
		this.quads = new ObjQuad[10];
		this.quads[0] = new ObjQuad(new Vector3f(0.2f, 0.6f, 0.2f),new Vector3f(0.2f, 1.0f, 0.2f),new Vector3f(0.2f, 1.0f, 0.7f),new Vector3f(0.2f, 0.6f, 0.7f),new Vector2f(0.751149f, 1.000805f),new Vector2f(0.501149f, 1.000805f),new Vector2f(0.501149f, 0.688305f),new Vector2f(0.751149f, 0.688305f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.2f, 1.0f, 0.2f),new Vector3f(-0.2f, 1.0f, 0.2f),new Vector3f(-0.2f, 1.0f, 0.7f),new Vector3f(0.2f, 1.0f, 0.7f),new Vector2f(0.751149f, 1.000805f),new Vector2f(0.501149f, 1.000805f),new Vector2f(0.501149f, 0.688305f),new Vector2f(0.751149f, 0.688305f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.2f, 1.0f, 0.2f),new Vector3f(-0.2f, 0.6f, 0.2f),new Vector3f(-0.2f, 0.6f, 0.7f),new Vector3f(-0.2f, 1.0f, 0.7f),new Vector2f(0.501149f, 0.688208f),new Vector2f(0.751149f, 0.688208f),new Vector2f(0.751149f, 1.000708f),new Vector2f(0.501149f, 1.000708f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.2f, 0.6f, 0.2f),new Vector3f(0.2f, 0.6f, 0.2f),new Vector3f(0.2f, 0.6f, 0.7f),new Vector3f(-0.2f, 0.6f, 0.7f),new Vector2f(0.501149f, 0.688208f),new Vector2f(0.751149f, 0.688208f),new Vector2f(0.751149f, 1.000708f),new Vector2f(0.501149f, 1.000708f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.3f, 0.5f, 0.7f),new Vector3f(-0.3f, 1.1f, 0.7f),new Vector3f(0.3f, 1.1f, 0.7f),new Vector3f(0.3f, 0.5f, 0.7f),new Vector2f(0.002112f, 0.37509f),new Vector2f(0.002112f, 9.0E-5f),new Vector2f(0.377112f, 9.0E-5f),new Vector2f(0.377112f, 0.37509f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.3f, 0.5f, 0.8f),new Vector3f(0.3f, 0.5f, 0.8f),new Vector3f(0.3f, 1.1f, 0.8f),new Vector3f(-0.3f, 1.1f, 0.8f),new Vector2f(0.002061f, 3.67E-4f),new Vector2f(0.377061f, 3.67E-4f),new Vector2f(0.377061f, 0.375367f),new Vector2f(0.002061f, 0.375367f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.3f, 0.5f, 0.7f),new Vector3f(0.3f, 0.5f, 0.7f),new Vector3f(0.3f, 0.5f, 0.8f),new Vector3f(-0.3f, 0.5f, 0.8f),new Vector2f(0.002084f, 0.375115f),new Vector2f(0.377084f, 0.375115f),new Vector2f(0.377084f, 0.437615f),new Vector2f(0.002084f, 0.437615f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(0.3f, 0.5f, 0.7f),new Vector3f(0.3f, 1.1f, 0.7f),new Vector3f(0.3f, 1.1f, 0.8f),new Vector3f(0.3f, 0.5f, 0.8f),new Vector2f(0.377394f, 0.437757f),new Vector2f(0.002394f, 0.437757f),new Vector2f(0.002394f, 0.375257f),new Vector2f(0.377394f, 0.375257f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(-0.3f, 1.1f, 0.7f),new Vector3f(-0.3f, 0.5f, 0.7f),new Vector3f(-0.3f, 0.5f, 0.8f),new Vector3f(-0.3f, 1.1f, 0.8f),new Vector2f(0.002084f, 0.375116f),new Vector2f(0.377084f, 0.375115f),new Vector2f(0.377084f, 0.437615f),new Vector2f(0.002084f, 0.437616f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[9] = new ObjQuad(new Vector3f(-0.3f, 1.1f, 0.7f),new Vector3f(-0.3f, 1.1f, 0.8f),new Vector3f(0.3f, 1.1f, 0.8f),new Vector3f(0.3f, 1.1f, 0.7f),new Vector2f(0.002084f, 0.375115f),new Vector2f(0.002084f, 0.437615f),new Vector2f(0.377084f, 0.437615f),new Vector2f(0.377084f, 0.375115f),new Vector3f(0.0f, 4.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		RainTankPipeSide other = new RainTankPipeSide();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

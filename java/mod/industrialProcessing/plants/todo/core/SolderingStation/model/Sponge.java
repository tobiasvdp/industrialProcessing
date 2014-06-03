package mod.industrialProcessing.plants.todo.core.SolderingStation.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Sponge extends ObjMesh{
	public Sponge(){
		this.quads = new ObjQuad[5];
		this.quads[0] = new ObjQuad(new Vector3f(0.112f, 0.5f, 0.5903f),new Vector3f(0.1903f, 0.5f, 0.5903f),new Vector3f(0.1903f, 0.5f, 0.367f),new Vector3f(0.112f, 0.5f, 0.367f),new Vector2f(0.002f, 0.002f),new Vector2f(0.2587f, 0.002f),new Vector2f(0.2587f, 0.7342f),new Vector2f(0.002f, 0.7342f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.112f, 0.45f, 0.5903f),new Vector3f(0.1903f, 0.45f, 0.5903f),new Vector3f(0.1903f, 0.5f, 0.5903f),new Vector3f(0.112f, 0.5f, 0.5903f),new Vector2f(0.2658f, 0.3442f),new Vector2f(0.5225f, 0.3442f),new Vector2f(0.5225f, 0.5082f),new Vector2f(0.2658f, 0.5082f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.1903f, 0.45f, 0.5903f),new Vector3f(0.1903f, 0.45f, 0.367f),new Vector3f(0.1903f, 0.5f, 0.367f),new Vector3f(0.1903f, 0.5f, 0.5903f),new Vector2f(0.2658f, 0.002f),new Vector2f(0.998f, 0.002f),new Vector2f(0.998f, 0.166f),new Vector2f(0.2658f, 0.166f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.1903f, 0.45f, 0.367f),new Vector3f(0.112f, 0.45f, 0.367f),new Vector3f(0.112f, 0.5f, 0.367f),new Vector3f(0.1903f, 0.5f, 0.367f),new Vector2f(0.002f, 0.7413f),new Vector2f(0.2587f, 0.7413f),new Vector2f(0.2587f, 0.9053f),new Vector2f(0.002f, 0.9053f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.112f, 0.45f, 0.367f),new Vector3f(0.112f, 0.45f, 0.5903f),new Vector3f(0.112f, 0.5f, 0.5903f),new Vector3f(0.112f, 0.5f, 0.367f),new Vector2f(0.2658f, 0.1731f),new Vector2f(0.998f, 0.1731f),new Vector2f(0.998f, 0.3371f),new Vector2f(0.2658f, 0.3371f),new Vector3f(-4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Sponge other = new Sponge();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

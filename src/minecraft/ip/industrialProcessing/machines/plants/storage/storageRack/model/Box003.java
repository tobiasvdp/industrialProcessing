package ip.industrialProcessing.machines.plants.storage.storageRack.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Box003 extends ObjMesh{
	public Box003(){
		this.quads = new ObjQuad[6];
		this.quads[0] = new ObjQuad(new Vector3f(-0.5f, 0.1723f, 0.1954f),new Vector3f(-0.5f, 0.2677f, -0.2954f),new Vector3f(0.5f, 0.2677f, -0.2954f),new Vector3f(0.5f, 0.1723f, 0.1954f),new Vector2f(1.0f, 0.5f),new Vector2f(1.0f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector2f(0.0f, 0.5f),new Vector3f(0.0f, -3.9264f, -0.7632f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.5f, 0.5159f, 0.2622f),new Vector3f(0.5f, 0.5159f, 0.2622f),new Vector3f(0.5f, 0.6113f, -0.2286f),new Vector3f(-0.5f, 0.6113f, -0.2286f),new Vector2f(0.0f, 0.5f),new Vector2f(1.0f, 0.5f),new Vector2f(1.0f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector3f(0.0f, 3.9264f, 0.7632f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.5f, 0.1723f, 0.1954f),new Vector3f(0.5f, 0.1723f, 0.1954f),new Vector3f(0.5f, 0.5159f, 0.2622f),new Vector3f(-0.5f, 0.5159f, 0.2622f),new Vector2f(0.0f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 0.5f),new Vector2f(0.0f, 0.5f),new Vector3f(0.0f, -0.7632f, 3.9264f));
		this.quads[3] = new ObjQuad(new Vector3f(0.5f, 0.1723f, 0.1954f),new Vector3f(0.5f, 0.2677f, -0.2954f),new Vector3f(0.5f, 0.6113f, -0.2286f),new Vector3f(0.5f, 0.5159f, 0.2622f),new Vector2f(0.0f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 0.5f),new Vector2f(0.0f, 0.5f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.5f, 0.2677f, -0.2954f),new Vector3f(-0.5f, 0.2677f, -0.2954f),new Vector3f(-0.5f, 0.6113f, -0.2286f),new Vector3f(0.5f, 0.6113f, -0.2286f),new Vector2f(0.0f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 0.5f),new Vector2f(0.0f, 0.5f),new Vector3f(0.0f, 0.7632f, -3.9264f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.5f, 0.2677f, -0.2954f),new Vector3f(-0.5f, 0.1723f, 0.1954f),new Vector3f(-0.5f, 0.5159f, 0.2622f),new Vector3f(-0.5f, 0.6113f, -0.2286f),new Vector2f(0.0f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 0.5f),new Vector2f(0.0f, 0.5f),new Vector3f(-4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Box003 other = new Box003();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

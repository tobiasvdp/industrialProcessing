package ip.industrialProcessing.machines.plants.storage.storageRack.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Box001 extends ObjMesh{
	public Box001(){
		this.quads = new ObjQuad[6];
		this.quads[0] = new ObjQuad(new Vector3f(-0.5f, 0.0723f, 0.7254f),new Vector3f(-0.5f, 0.1677f, 0.2346f),new Vector3f(0.5f, 0.1677f, 0.2346f),new Vector3f(0.5f, 0.0723f, 0.7254f),new Vector2f(1.0f, 0.5f),new Vector2f(1.0f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector2f(0.0f, 0.5f),new Vector3f(0.0f, -3.9264f, -0.7632f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.5f, 0.4159f, 0.7922f),new Vector3f(0.5f, 0.4159f, 0.7922f),new Vector3f(0.5f, 0.5113f, 0.3014f),new Vector3f(-0.5f, 0.5113f, 0.3014f),new Vector2f(0.0f, 0.5f),new Vector2f(1.0f, 0.5f),new Vector2f(1.0f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector3f(0.0f, 3.9264f, 0.7632f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.5f, 0.0723f, 0.7254f),new Vector3f(0.5f, 0.0723f, 0.7254f),new Vector3f(0.5f, 0.4159f, 0.7922f),new Vector3f(-0.5f, 0.4159f, 0.7922f),new Vector2f(0.0f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 0.5f),new Vector2f(0.0f, 0.5f),new Vector3f(0.0f, -0.7632f, 3.9264f));
		this.quads[3] = new ObjQuad(new Vector3f(0.5f, 0.0723f, 0.7254f),new Vector3f(0.5f, 0.1677f, 0.2346f),new Vector3f(0.5f, 0.5113f, 0.3014f),new Vector3f(0.5f, 0.4159f, 0.7922f),new Vector2f(0.0f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 0.5f),new Vector2f(0.0f, 0.5f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.5f, 0.1677f, 0.2346f),new Vector3f(-0.5f, 0.1677f, 0.2346f),new Vector3f(-0.5f, 0.5113f, 0.3014f),new Vector3f(0.5f, 0.5113f, 0.3014f),new Vector2f(0.0f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 0.5f),new Vector2f(0.0f, 0.5f),new Vector3f(0.0f, 0.7632f, -3.9264f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.5f, 0.1677f, 0.2346f),new Vector3f(-0.5f, 0.0723f, 0.7254f),new Vector3f(-0.5f, 0.4159f, 0.7922f),new Vector3f(-0.5f, 0.5113f, 0.3014f),new Vector2f(0.0f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 0.5f),new Vector2f(0.0f, 0.5f),new Vector3f(-4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Box001 other = new Box001();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

package  ip.industrialProcessing.subMod.logic.network.devices.interfaces.machineInterface.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Box extends ObjMesh{
	public Box(){
		this.quads = new ObjQuad[5];
		this.quads[0] = new ObjQuad(new Vector3f(-0.3f, 0.5f, -0.5f),new Vector3f(-0.3f, 0.5f, -0.9f),new Vector3f(0.3f, 0.5f, -0.9f),new Vector3f(0.3f, 0.5f, -0.5f),new Vector2f(0.75f, 0.1875f),new Vector2f(0.75f, 0.375f),new Vector2f(0.375f, 0.375f),new Vector2f(0.375f, 0.1875f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.3f, 1.1f, -0.5f),new Vector3f(0.3f, 1.1f, -0.5f),new Vector3f(0.3f, 1.1f, -0.9f),new Vector3f(-0.3f, 1.1f, -0.9f),new Vector2f(0.375f, 0.0f),new Vector2f(0.75f, 0.0f),new Vector2f(0.75f, 0.1875f),new Vector2f(0.375f, 0.1875f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.3f, 0.5f, -0.5f),new Vector3f(0.3f, 0.5f, -0.9f),new Vector3f(0.3f, 1.1f, -0.9f),new Vector3f(0.3f, 1.1f, -0.5f),new Vector2f(0.0f, 0.375f),new Vector2f(0.1875f, 0.375f),new Vector2f(0.1875f, 0.75f),new Vector2f(0.0f, 0.75f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.3f, 0.5f, -0.9f),new Vector3f(-0.3f, 0.5f, -0.9f),new Vector3f(-0.3f, 1.1f, -0.9f),new Vector3f(0.3f, 1.1f, -0.9f),new Vector2f(0.0f, 0.0f),new Vector2f(0.375f, 0.0f),new Vector2f(0.375f, 0.375f),new Vector2f(0.0f, 0.375f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.3f, 0.5f, -0.9f),new Vector3f(-0.3f, 0.5f, -0.5f),new Vector3f(-0.3f, 1.1f, -0.5f),new Vector3f(-0.3f, 1.1f, -0.9f),new Vector2f(0.0f, 0.0f),new Vector2f(0.1875f, 0.0f),new Vector2f(0.1875f, 0.375f),new Vector2f(0.0f, 0.375f),new Vector3f(-4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Box other = new Box();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

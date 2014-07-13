package  ip.industrialProcessing.subMod.logic.network.devices.interfaces.machineInterface.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Frame extends ObjMesh{
	public Frame(){
		this.quads = new ObjQuad[8];
		this.quads[0] = new ObjQuad(new Vector3f(0.2f, 0.6f, -0.4f),new Vector3f(-0.2f, 0.6f, -0.4f),new Vector3f(-0.2189f, 0.5811f, -0.4377f),new Vector3f(0.2189f, 0.5811f, -0.4377f),new Vector2f(0.2618f, 0.0236f),new Vector2f(0.5118f, 0.0236f),new Vector2f(0.5236f, 0.0471f),new Vector2f(0.25f, 0.0471f),new Vector3f(0.0f, -3.5776f, 1.7888f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.2f, 0.6f, -0.4f),new Vector3f(-0.2f, 1.0f, -0.4f),new Vector3f(-0.2189f, 1.0189f, -0.4377f),new Vector3f(-0.2189f, 0.5811f, -0.4377f),new Vector2f(0.0236f, 0.2618f),new Vector2f(0.0236f, 0.5118f),new Vector2f(0.0f, 0.5236f),new Vector2f(0.0f, 0.25f),new Vector3f(-3.5776f, 0.0f, 1.7888f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.2f, 1.0f, -0.4f),new Vector3f(0.2f, 1.0f, -0.4f),new Vector3f(0.2189f, 1.0189f, -0.4377f),new Vector3f(-0.2189f, 1.0189f, -0.4377f),new Vector2f(0.2618f, 0.0f),new Vector2f(0.5118f, 0.0f),new Vector2f(0.5236f, 0.0236f),new Vector2f(0.25f, 0.0236f),new Vector3f(0.0f, 3.5776f, 1.7888f));
		this.quads[3] = new ObjQuad(new Vector3f(0.2f, 1.0f, -0.4f),new Vector3f(0.2f, 0.6f, -0.4f),new Vector3f(0.2189f, 0.5811f, -0.4377f),new Vector3f(0.2189f, 1.0189f, -0.4377f),new Vector2f(0.0236f, 0.5118f),new Vector2f(0.0236f, 0.2618f),new Vector2f(0.0471f, 0.25f),new Vector2f(0.0471f, 0.5236f),new Vector3f(3.5776f, 0.0f, 1.7888f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.2f, 0.6f, -0.4f),new Vector3f(0.2f, 0.6f, -0.4f),new Vector3f(0.16f, 0.64f, -0.4f),new Vector3f(-0.16f, 0.64f, -0.4f),new Vector2f(0.0f, 0.0f),new Vector2f(0.25f, 0.0f),new Vector2f(0.225f, 0.025f),new Vector2f(0.025f, 0.025f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[5] = new ObjQuad(new Vector3f(0.2f, 0.6f, -0.4f),new Vector3f(0.2f, 1.0f, -0.4f),new Vector3f(0.16f, 0.96f, -0.4f),new Vector3f(0.16f, 0.64f, -0.4f),new Vector2f(0.25f, 0.0f),new Vector2f(0.25f, 0.25f),new Vector2f(0.225f, 0.225f),new Vector2f(0.225f, 0.025f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[6] = new ObjQuad(new Vector3f(0.2f, 1.0f, -0.4f),new Vector3f(-0.2f, 1.0f, -0.4f),new Vector3f(-0.16f, 0.96f, -0.4f),new Vector3f(0.16f, 0.96f, -0.4f),new Vector2f(0.25f, 0.25f),new Vector2f(0.0f, 0.25f),new Vector2f(0.025f, 0.225f),new Vector2f(0.225f, 0.225f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.2f, 1.0f, -0.4f),new Vector3f(-0.2f, 0.6f, -0.4f),new Vector3f(-0.16f, 0.64f, -0.4f),new Vector3f(-0.16f, 0.96f, -0.4f),new Vector2f(0.0f, 0.25f),new Vector2f(0.0f, 0.0f),new Vector2f(0.025f, 0.025f),new Vector2f(0.025f, 0.225f),new Vector3f(0.0f, 0.0f, 4.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Frame other = new Frame();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

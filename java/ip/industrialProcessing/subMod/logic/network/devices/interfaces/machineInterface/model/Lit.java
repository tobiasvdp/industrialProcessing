package  ip.industrialProcessing.subMod.logic.network.devices.interfaces.machineInterface.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Lit extends ObjMesh{
	public Lit(){
		this.quads = new ObjQuad[8];
		this.quads[0] = new ObjQuad(new Vector3f(-0.2811f, 0.5189f, -0.4623f),new Vector3f(0.2811f, 0.5189f, -0.4623f),new Vector3f(0.2189f, 0.5811f, -0.4377f),new Vector3f(-0.2189f, 0.5811f, -0.4377f),new Vector2f(0.0f, 0.0f),new Vector2f(0.3514f, 0.0f),new Vector2f(0.3125f, 0.0389f),new Vector2f(0.0389f, 0.0389f),new Vector3f(0.0f, -1.468f, 3.7208f));
		this.quads[1] = new ObjQuad(new Vector3f(0.2811f, 0.5189f, -0.4623f),new Vector3f(0.2811f, 1.0811f, -0.4623f),new Vector3f(0.2189f, 1.0189f, -0.4377f),new Vector3f(0.2189f, 0.5811f, -0.4377f),new Vector2f(0.3514f, 0.0f),new Vector2f(0.3514f, 0.3514f),new Vector2f(0.3125f, 0.3125f),new Vector2f(0.3125f, 0.0389f),new Vector3f(1.468f, 0.0f, 3.7208f));
		this.quads[2] = new ObjQuad(new Vector3f(0.2811f, 1.0811f, -0.4623f),new Vector3f(-0.2811f, 1.0811f, -0.4623f),new Vector3f(-0.2189f, 1.0189f, -0.4377f),new Vector3f(0.2189f, 1.0189f, -0.4377f),new Vector2f(0.3514f, 0.3514f),new Vector2f(0.0f, 0.3514f),new Vector2f(0.0389f, 0.3125f),new Vector2f(0.3125f, 0.3125f),new Vector3f(0.0f, 1.468f, 3.7208f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.2811f, 1.0811f, -0.4623f),new Vector3f(-0.2811f, 0.5189f, -0.4623f),new Vector3f(-0.2189f, 0.5811f, -0.4377f),new Vector3f(-0.2189f, 1.0189f, -0.4377f),new Vector2f(0.0f, 0.3514f),new Vector2f(0.0f, 0.0f),new Vector2f(0.0389f, 0.0389f),new Vector2f(0.0389f, 0.3125f),new Vector3f(-1.468f, 0.0f, 3.7208f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.3f, 0.5f, -0.5f),new Vector3f(0.3f, 0.5f, -0.5f),new Vector3f(0.2811f, 0.5189f, -0.4623f),new Vector3f(-0.2811f, 0.5189f, -0.4623f),new Vector2f(0.9257f, 0.2464f),new Vector2f(0.5507f, 0.2464f),new Vector2f(0.5625f, 0.2229f),new Vector2f(0.9139f, 0.2229f),new Vector3f(0.0f, -3.5776f, 1.7888f));
		this.quads[5] = new ObjQuad(new Vector3f(0.3f, 0.5f, -0.5f),new Vector3f(0.3f, 1.1f, -0.5f),new Vector3f(0.2811f, 1.0811f, -0.4623f),new Vector3f(0.2811f, 0.5189f, -0.4623f),new Vector2f(0.5743f, 0.4457f),new Vector2f(0.5743f, 0.8207f),new Vector2f(0.5507f, 0.8089f),new Vector2f(0.5507f, 0.4575f),new Vector3f(3.5776f, 0.0f, 1.7888f));
		this.quads[6] = new ObjQuad(new Vector3f(0.3f, 1.1f, -0.5f),new Vector3f(-0.3f, 1.1f, -0.5f),new Vector3f(-0.2811f, 1.0811f, -0.4623f),new Vector3f(0.2811f, 1.0811f, -0.4623f),new Vector2f(0.9257f, 0.0236f),new Vector2f(0.5507f, 0.0236f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.9139f, 0.0f),new Vector3f(0.0f, 3.5776f, 1.7888f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.3f, 1.1f, -0.5f),new Vector3f(-0.3f, 0.5f, -0.5f),new Vector3f(-0.2811f, 0.5189f, -0.4623f),new Vector3f(-0.2811f, 1.0811f, -0.4623f),new Vector2f(0.0f, 0.9257f),new Vector2f(0.0f, 0.5507f),new Vector2f(0.0236f, 0.5625f),new Vector2f(0.0236f, 0.9139f),new Vector3f(-3.5776f, 0.0f, 1.7888f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Lit other = new Lit();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

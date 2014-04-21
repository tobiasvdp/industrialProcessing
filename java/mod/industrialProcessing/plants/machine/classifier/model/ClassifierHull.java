package mod.industrialProcessing.plants.machine.classifier.model;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class ClassifierHull extends ObjMesh{
	public ClassifierHull(){
		this.quads = new ObjQuad[23];
		this.quads[0] = new ObjQuad(new Vector3f(0.6f, 0.5515f, -0.7f),new Vector3f(0.6f, 1.2985f, -0.7f),new Vector3f(0.6f, 1.2985f, 0.7f),new Vector3f(0.6f, 0.7515f, 0.7f),new Vector2f(0.4584f, 0.0625f),new Vector2f(0.8897f, 0.0625f),new Vector2f(0.8897f, 0.9375f),new Vector2f(0.5739f, 0.9375f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.6f, 1.2985f, -0.7f),new Vector3f(-0.6f, 0.5515f, -0.7f),new Vector3f(-0.6f, 0.7515f, 0.7f),new Vector3f(-0.6f, 1.2985f, 0.7f),new Vector2f(0.3973f, 0.0625f),new Vector2f(0.8286f, 0.0625f),new Vector2f(0.7131f, 0.9375f),new Vector2f(0.3973f, 0.9375f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.6f, 0.5515f, -0.7f),new Vector3f(-0.2485f, 0.2f, -0.7f),new Vector3f(-0.2485f, 0.4f, 0.7f),new Vector3f(-0.6f, 0.7515f, 0.7f),new Vector2f(0.2549f, 0.0625f),new Vector2f(0.5419f, 0.0625f),new Vector2f(0.494f, 0.9375f),new Vector2f(0.207f, 0.9375f),new Vector3f(-2.814f, -2.814f, 0.402f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.2485f, 0.2f, -0.7f),new Vector3f(0.2485f, 0.2f, -0.7f),new Vector3f(0.2485f, 0.4f, 0.7f),new Vector3f(-0.2485f, 0.4f, 0.7f),new Vector2f(0.5419f, 0.0625f),new Vector2f(0.8289f, 0.0625f),new Vector2f(0.781f, 0.9375f),new Vector2f(0.494f, 0.9375f),new Vector3f(0.0f, -3.9596f, 0.5656f));
		this.quads[4] = new ObjQuad(new Vector3f(0.2485f, 0.2f, -0.7f),new Vector3f(0.6f, 0.5515f, -0.7f),new Vector3f(0.6f, 0.7515f, 0.7f),new Vector3f(0.2485f, 0.4f, 0.7f),new Vector2f(0.1714f, 0.0625f),new Vector2f(0.4584f, 0.0625f),new Vector2f(0.5739f, 0.9375f),new Vector2f(0.2869f, 0.9375f),new Vector3f(2.814f, -2.814f, 0.402f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.2485f, 0.2f, -0.7f),new Vector3f(-0.6f, 0.5515f, -0.7f),new Vector3f(-0.6f, 1.2985f, -0.7f),new Vector3f(0.6f, 0.5515f, -0.7f),new Vector2f(0.4581f, 0.0525f),new Vector2f(0.7451f, 0.1714f),new Vector2f(0.9238f, 0.6027f),new Vector2f(0.0523f, 0.4584f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.6f, 1.2985f, -0.7f),new Vector3f(0.6f, 1.2985f, -0.7f),new Vector3f(0.6f, 0.5515f, -0.7f),new Vector2f(0.9238f, 0.6027f),new Vector2f(0.2309f, 0.8897f),new Vector2f(0.0523f, 0.4584f),new Vector3f(0.0f, 0.0f, -3.0f));
		this.quads[7] = new ObjQuad(new Vector3f(0.2485f, 0.2f, -0.7f),new Vector3f(-0.2485f, 0.2f, -0.7f),new Vector3f(0.6f, 0.5515f, -0.7f),new Vector2f(0.1711f, 0.1714f),new Vector2f(0.4581f, 0.0525f),new Vector2f(0.0523f, 0.4584f),new Vector3f(0.0f, 0.0f, -3.0f));
		this.quads[8] = new ObjQuad(new Vector3f(-0.6f, 0.7515f, 0.7f),new Vector3f(-0.2485f, 0.4f, 0.7f),new Vector3f(0.2485f, 0.4f, 0.7f),new Vector3f(-0.6f, 1.2985f, 0.7f),new Vector2f(0.207f, 0.2869f),new Vector2f(0.494f, 0.168f),new Vector2f(0.781f, 0.2869f),new Vector2f(0.0762f, 0.6027f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[9] = new ObjQuad(new Vector3f(0.6f, 1.2985f, 0.7f),new Vector3f(-0.6f, 1.2985f, 0.7f),new Vector3f(0.2485f, 0.4f, 0.7f),new Vector3f(0.6f, 0.7515f, 0.7f),new Vector2f(0.7691f, 0.8897f),new Vector2f(0.0762f, 0.6027f),new Vector2f(0.781f, 0.2869f),new Vector2f(0.8999f, 0.5739f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[10] = new ObjQuad(new Vector3f(-0.1f, 0.3f, -0.6f),new Vector3f(-0.1f, 0.4985f, 0.6f),new Vector3f(0.1f, 0.4985f, 0.6f),new Vector3f(0.1f, 0.3f, -0.6f),new Vector2f(0.3963f, 0.125f),new Vector2f(0.4438f, 0.875f),new Vector2f(0.3283f, 0.875f),new Vector2f(0.2808f, 0.125f),new Vector3f(0.0f, 3.9464f, -0.6528f));
		this.quads[11] = new ObjQuad(new Vector3f(0.6f, 1.2985f, 0.7f),new Vector3f(0.6f, 1.2985f, -0.7f),new Vector3f(0.5f, 1.2985f, -0.6f),new Vector3f(0.5f, 1.2985f, 0.6f),new Vector2f(0.2309f, 0.9375f),new Vector2f(0.2309f, 0.0625f),new Vector2f(0.2887f, 0.125f),new Vector2f(0.2887f, 0.875f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[12] = new ObjQuad(new Vector3f(0.6f, 1.2985f, -0.7f),new Vector3f(-0.6f, 1.2985f, -0.7f),new Vector3f(-0.5f, 1.2985f, -0.6f),new Vector3f(0.5f, 1.2985f, -0.6f),new Vector2f(0.2309f, 0.0625f),new Vector2f(0.9238f, 0.0625f),new Vector2f(0.8661f, 0.125f),new Vector2f(0.2887f, 0.125f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[13] = new ObjQuad(new Vector3f(-0.6f, 1.2985f, -0.7f),new Vector3f(-0.6f, 1.2985f, 0.7f),new Vector3f(-0.5f, 1.2985f, 0.6f),new Vector3f(-0.5f, 1.2985f, -0.6f),new Vector2f(0.9238f, 0.0625f),new Vector2f(0.9238f, 0.9375f),new Vector2f(0.8661f, 0.875f),new Vector2f(0.8661f, 0.125f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[14] = new ObjQuad(new Vector3f(-0.6f, 1.2985f, 0.7f),new Vector3f(0.6f, 1.2985f, 0.7f),new Vector3f(0.5f, 1.2985f, 0.6f),new Vector3f(-0.5f, 1.2985f, 0.6f),new Vector2f(0.9238f, 0.9375f),new Vector2f(0.2309f, 0.9375f),new Vector2f(0.2887f, 0.875f),new Vector2f(0.8661f, 0.875f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[15] = new ObjQuad(new Vector3f(0.5f, 1.2985f, 0.6f),new Vector3f(0.5f, 1.2985f, -0.6f),new Vector3f(0.5f, 0.6985f, -0.6f),new Vector3f(0.5f, 0.8985f, 0.6f),new Vector2f(0.1342f, 0.875f),new Vector2f(0.1342f, 0.125f),new Vector2f(0.4806f, 0.125f),new Vector2f(0.3651f, 0.875f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[16] = new ObjQuad(new Vector3f(0.5f, 1.2985f, -0.6f),new Vector3f(-0.5f, 1.2985f, -0.6f),new Vector3f(-0.5f, 0.6985f, -0.6f),new Vector3f(0.5f, 0.6985f, -0.6f),new Vector2f(0.7113f, 0.8658f),new Vector2f(0.1339f, 0.6267f),new Vector2f(0.2774f, 0.2802f),new Vector2f(0.8548f, 0.5194f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[17] = new ObjQuad(new Vector3f(-0.5f, 1.2985f, -0.6f),new Vector3f(-0.5f, 1.2985f, 0.6f),new Vector3f(-0.5f, 0.8985f, 0.6f),new Vector3f(-0.5f, 0.6985f, -0.6f),new Vector2f(0.6267f, 0.125f),new Vector2f(0.6267f, 0.875f),new Vector2f(0.3957f, 0.875f),new Vector2f(0.2802f, 0.125f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[18] = new ObjQuad(new Vector3f(-0.5f, 1.2985f, 0.6f),new Vector3f(0.5f, 1.2985f, 0.6f),new Vector3f(0.5f, 0.8985f, 0.6f),new Vector3f(-0.5f, 0.8985f, 0.6f),new Vector2f(0.8661f, 0.6267f),new Vector2f(0.2887f, 0.8658f),new Vector2f(0.193f, 0.6349f),new Vector2f(0.7704f, 0.3957f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[19] = new ObjQuad(new Vector3f(0.5f, 0.8985f, 0.6f),new Vector3f(0.5f, 0.6985f, -0.6f),new Vector3f(0.1f, 0.3f, -0.6f),new Vector3f(0.1f, 0.4985f, 0.6f),new Vector2f(0.3651f, 0.875f),new Vector2f(0.4806f, 0.125f),new Vector2f(0.8064f, 0.125f),new Vector2f(0.6918f, 0.875f),new Vector3f(-2.8064f, 2.8116f, -0.4668f));
		this.quads[20] = new ObjQuad(new Vector3f(0.5f, 0.6985f, -0.6f),new Vector3f(-0.5f, 0.6985f, -0.6f),new Vector3f(-0.1f, 0.3f, -0.6f),new Vector3f(0.1f, 0.3f, -0.6f),new Vector2f(0.8548f, 0.5194f),new Vector2f(0.2774f, 0.2802f),new Vector2f(0.6037f, 0.1458f),new Vector2f(0.7192f, 0.1936f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[21] = new ObjQuad(new Vector3f(-0.5f, 0.6985f, -0.6f),new Vector3f(-0.5f, 0.8985f, 0.6f),new Vector3f(-0.1f, 0.4985f, 0.6f),new Vector3f(-0.1f, 0.3f, -0.6f),new Vector2f(0.7226f, 0.125f),new Vector2f(0.7704f, 0.875f),new Vector2f(0.4438f, 0.875f),new Vector2f(0.3963f, 0.125f),new Vector3f(2.8064f, 2.8116f, -0.4668f));
		this.quads[22] = new ObjQuad(new Vector3f(-0.5f, 0.8985f, 0.6f),new Vector3f(0.5f, 0.8985f, 0.6f),new Vector3f(0.1f, 0.4985f, 0.6f),new Vector3f(-0.1f, 0.4985f, 0.6f),new Vector2f(0.7704f, 0.3957f),new Vector2f(0.193f, 0.6349f),new Vector2f(0.3283f, 0.3082f),new Vector2f(0.4438f, 0.2604f),new Vector3f(0.0f, 0.0f, -4.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		ClassifierHull other = new ClassifierHull();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

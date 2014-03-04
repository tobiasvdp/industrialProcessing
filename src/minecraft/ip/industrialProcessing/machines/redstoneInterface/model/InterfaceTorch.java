package ip.industrialProcessing.machines.redstoneInterface.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class InterfaceTorch extends ObjMesh{
	public InterfaceTorch(){
		this.quads = new ObjQuad[16];
		this.quads[0] = new ObjQuad(new Vector3f(0.8f, 0.193692f, -0.622618f),new Vector3f(-0.8f, 0.193692f, -0.622618f),new Vector3f(-0.8f, 1.643785f, 0.053571f),new Vector2f(0.0f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 1.0f),new Vector3f(0.0f, 1.267854f, -2.718924f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.8f, 1.643785f, 0.053571f),new Vector3f(0.8f, 1.643785f, 0.053571f),new Vector3f(0.8f, 0.193692f, -0.622618f),new Vector2f(1.0f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector2f(0.0f, 0.0f),new Vector3f(0.0f, 1.267854f, -2.718924f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.1f, 0.489525f, -1.257034f),new Vector3f(-0.1f, -0.186664f, 0.193059f),new Vector3f(-0.1f, 1.263428f, 0.869248f),new Vector2f(0.0f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 1.0f),new Vector3f(-3.0f, 0.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.1f, 1.263428f, 0.869248f),new Vector3f(-0.1f, 1.939618f, -0.580844f),new Vector3f(-0.1f, 0.489525f, -1.257034f),new Vector2f(1.0f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector2f(0.0f, 0.0f),new Vector3f(-3.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.8f, 0.109169f, -0.441357f),new Vector3f(0.8f, 0.109169f, -0.441357f),new Vector3f(0.8f, 1.559261f, 0.234833f),new Vector2f(0.0f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 1.0f),new Vector3f(0.0f, -1.267857f, 2.718924f));
		this.quads[5] = new ObjQuad(new Vector3f(0.8f, 1.559261f, 0.234833f),new Vector3f(-0.8f, 1.559261f, 0.234833f),new Vector3f(-0.8f, 0.109169f, -0.441357f),new Vector2f(1.0f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector2f(0.0f, 0.0f),new Vector3f(0.0f, -1.267857f, 2.718924f));
		this.quads[6] = new ObjQuad(new Vector3f(0.099999f, -0.186664f, 0.193059f),new Vector3f(0.1f, 0.489525f, -1.257034f),new Vector3f(0.100001f, 1.939618f, -0.580844f),new Vector2f(0.0f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 1.0f),new Vector3f(3.0f, -3.0E-6f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(0.100001f, 1.939618f, -0.580844f),new Vector3f(0.1f, 1.263428f, 0.869248f),new Vector3f(0.099999f, -0.186664f, 0.193059f),new Vector2f(1.0f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector2f(0.0f, 0.0f),new Vector3f(3.0f, -3.0E-6f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(0.8f, 1.057738f, -0.109369f),new Vector3f(-0.8f, 1.057738f, -0.109369f),new Vector3f(-0.8f, 0.761905f, 0.525046f),new Vector2f(0.0f, 0.5625f),new Vector2f(1.0f, 0.5625f),new Vector2f(1.0f, 1.0f),new Vector3f(0.0f, 2.718924f, 1.267854f));
		this.quads[9] = new ObjQuad(new Vector3f(-0.8f, 0.761905f, 0.525046f),new Vector3f(0.8f, 0.761906f, 0.525046f),new Vector3f(0.8f, 1.057738f, -0.109369f),new Vector2f(1.0f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector2f(0.0f, 0.5625f),new Vector3f(0.0f, 2.718924f, 1.267854f));
		this.quads[10] = new ObjQuad(new Vector3f(-0.8f, 0.876476f, -0.193893f),new Vector3f(0.8f, 0.876477f, -0.193892f),new Vector3f(0.8f, 0.580644f, 0.440523f),new Vector2f(0.0f, 0.5625f),new Vector2f(1.0f, 0.5625f),new Vector2f(1.0f, 1.0f),new Vector3f(3.0E-6f, -2.718924f, -1.267857f));
		this.quads[11] = new ObjQuad(new Vector3f(0.8f, 0.580644f, 0.440523f),new Vector3f(-0.8f, 0.580643f, 0.440522f),new Vector3f(-0.8f, 0.876476f, -0.193893f),new Vector2f(1.0f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector2f(0.0f, 0.5625f),new Vector3f(3.0E-6f, -2.718924f, -1.267857f));
		this.quads[12] = new ObjQuad(new Vector3f(-0.8f, 1.057738f, -0.109369f),new Vector3f(0.8f, 1.057738f, -0.109369f),new Vector3f(0.8f, 1.353571f, -0.743785f),new Vector2f(0.0f, 0.5625f),new Vector2f(1.0f, 0.5625f),new Vector2f(1.0f, 1.0f),new Vector3f(0.0f, 2.718924f, 1.267854f));
		this.quads[13] = new ObjQuad(new Vector3f(0.8f, 1.353571f, -0.743785f),new Vector3f(-0.8f, 1.353571f, -0.743785f),new Vector3f(-0.8f, 1.057738f, -0.109369f),new Vector2f(1.0f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector2f(0.0f, 0.5625f),new Vector3f(0.0f, 2.718924f, 1.267854f));
		this.quads[14] = new ObjQuad(new Vector3f(0.8f, 0.876476f, -0.193893f),new Vector3f(-0.8f, 0.876477f, -0.193893f),new Vector3f(-0.8f, 1.172309f, -0.828309f),new Vector2f(0.0f, 0.5625f),new Vector2f(1.0f, 0.5625f),new Vector2f(1.0f, 1.0f),new Vector3f(0.0f, -2.718924f, -1.267851f));
		this.quads[15] = new ObjQuad(new Vector3f(-0.8f, 1.172309f, -0.828309f),new Vector3f(0.8f, 1.172308f, -0.828309f),new Vector3f(0.8f, 0.876476f, -0.193893f),new Vector2f(1.0f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector2f(0.0f, 0.5625f),new Vector3f(0.0f, -2.718924f, -1.267851f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		InterfaceTorch other = new InterfaceTorch();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

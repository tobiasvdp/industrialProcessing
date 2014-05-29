package ip.industrialProcessing.multiblock.core.block.blastFurnace.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class TopHull extends ObjMesh{
	public TopHull(){
		this.quads = new ObjQuad[8];
		this.quads[0] = new ObjQuad(new Vector3f(-0.6f, 0.7f, -0.6f),new Vector3f(0.6f, 0.7f, -0.6f),new Vector3f(0.7f, 0.0f, -0.7f),new Vector3f(-0.7f, 0.0f, -0.7f),new Vector2f(0.875f, 0.4375f),new Vector2f(0.125f, 0.4375f),new Vector2f(0.0625f, 0.0f),new Vector2f(0.9375f, 0.0f),new Vector3f(0.0f, 0.5656f, -3.9596f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.6f, 0.7f, -0.6f),new Vector3f(-0.2017f, 1.4f, -0.2f),new Vector3f(0.2f, 1.4f, -0.2f),new Vector3f(0.6f, 0.7f, -0.6f),new Vector2f(0.875f, 0.4375f),new Vector2f(0.626f, 0.875f),new Vector2f(0.375f, 0.875f),new Vector2f(0.125f, 0.4375f),new Vector3f(0.0f, 1.9844f, -3.4728f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.6f, 0.7f, -0.6f),new Vector3f(-0.6f, 0.7f, 0.6f),new Vector3f(-0.2017f, 1.4f, 0.2f),new Vector3f(-0.2017f, 1.4f, -0.2f),new Vector2f(0.125f, 0.4375f),new Vector2f(0.875f, 0.4375f),new Vector2f(0.625f, 0.875f),new Vector2f(0.375f, 0.875f),new Vector3f(-3.4764f, 1.9784f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.6f, 0.7f, 0.6f),new Vector3f(0.6f, 0.7f, 0.6f),new Vector3f(0.2f, 1.4f, 0.2f),new Vector3f(-0.2017f, 1.4f, 0.2f),new Vector2f(0.125f, 0.4375f),new Vector2f(0.875f, 0.4375f),new Vector2f(0.625f, 0.875f),new Vector2f(0.374f, 0.875f),new Vector3f(0.0f, 1.9844f, 3.4728f));
		this.quads[4] = new ObjQuad(new Vector3f(0.6f, 0.7f, 0.6f),new Vector3f(0.6f, 0.7f, -0.6f),new Vector3f(0.2f, 1.4f, -0.2f),new Vector3f(0.2f, 1.4f, 0.2f),new Vector2f(0.125f, 0.4375f),new Vector2f(0.875f, 0.4375f),new Vector2f(0.625f, 0.875f),new Vector2f(0.375f, 0.875f),new Vector3f(3.4728f, 1.9844f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.7f, 0.0f, -0.7f),new Vector3f(-0.7f, 0.0f, 0.7f),new Vector3f(-0.6f, 0.7f, 0.6f),new Vector3f(-0.6f, 0.7f, -0.6f),new Vector2f(0.0625f, 0.0f),new Vector2f(0.9375f, 0.0f),new Vector2f(0.875f, 0.4375f),new Vector2f(0.125f, 0.4375f),new Vector3f(-3.9596f, 0.5656f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.7f, 0.0f, 0.7f),new Vector3f(0.7f, 0.0f, 0.7f),new Vector3f(0.6f, 0.7f, 0.6f),new Vector3f(-0.6f, 0.7f, 0.6f),new Vector2f(0.0625f, 0.0f),new Vector2f(0.9375f, 0.0f),new Vector2f(0.875f, 0.4375f),new Vector2f(0.125f, 0.4375f),new Vector3f(0.0f, 0.5656f, 3.9596f));
		this.quads[7] = new ObjQuad(new Vector3f(0.7f, 0.0f, -0.7f),new Vector3f(0.6f, 0.7f, -0.6f),new Vector3f(0.6f, 0.7f, 0.6f),new Vector3f(0.7f, 0.0f, 0.7f),new Vector2f(0.9375f, 0.0f),new Vector2f(0.875f, 0.4375f),new Vector2f(0.125f, 0.4375f),new Vector2f(0.0625f, 0.0f),new Vector3f(3.9596f, 0.5656f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		TopHull other = new TopHull();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

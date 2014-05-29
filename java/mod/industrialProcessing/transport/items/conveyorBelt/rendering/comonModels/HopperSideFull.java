package mod.industrialProcessing.transport.items.conveyorBelt.rendering.comonModels;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class HopperSideFull extends ObjMesh{
	public HopperSideFull(){
		this.quads = new ObjQuad[7];
		this.quads[0] = new ObjQuad(new Vector3f(0.8f, 1.6f, 0.8f),new Vector3f(0.8f, 1.6f, -0.8f),new Vector3f(0.7f, 1.6f, -0.7f),new Vector3f(0.7f, 1.6f, 0.7f),new Vector2f(1.0f, -0.0f),new Vector2f(1.0f, 1.0f),new Vector2f(0.9375f, 0.9375f),new Vector2f(0.9375f, 0.0625f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.7f, 1.6f, -0.7f),new Vector3f(0.7f, 1.2f, -0.7f),new Vector3f(0.7f, 1.2f, 0.7f),new Vector3f(0.7f, 1.6f, 0.7f),new Vector2f(0.0625f, 1.0f),new Vector2f(0.0625f, 0.75f),new Vector2f(0.9375f, 0.75f),new Vector2f(0.9375f, 1.0f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.8f, 1.2f, -0.8f),new Vector3f(0.8f, 1.2f, 0.8f),new Vector3f(0.4f, 0.4f, 0.4f),new Vector3f(0.3f, 0.2f, 0.3f),new Vector2f(1.0f, 0.75f),new Vector2f(-0.0f, 0.75f),new Vector2f(0.25f, 0.25f),new Vector2f(0.3125f, 0.125f),new Vector3f(3.577708f, -1.788856f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.3f, 0.2f, -0.3f),new Vector3f(0.8f, 1.2f, -0.8f),new Vector3f(0.3f, 0.2f, 0.3f),new Vector2f(0.6875f, 0.125f),new Vector2f(1.0f, 0.75f),new Vector2f(0.3125f, 0.125f),new Vector3f(2.683281f, -1.341639f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.2f, 0.2f, -0.2f),new Vector3f(0.2f, 0.2f, 0.2f),new Vector3f(0.4f, 0.6f, 0.4f),new Vector3f(0.7f, 1.2f, 0.7f),new Vector2f(0.375f, 0.125f),new Vector2f(0.625f, 0.125f),new Vector2f(0.75f, 0.375f),new Vector2f(0.9375f, 0.75f),new Vector3f(-3.577708f, 1.788852f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(0.7f, 1.2f, -0.7f),new Vector3f(0.2f, 0.2f, -0.2f),new Vector3f(0.7f, 1.2f, 0.7f),new Vector2f(0.0625f, 0.75f),new Vector2f(0.375f, 0.125f),new Vector2f(0.9375f, 0.75f),new Vector3f(-2.683281f, 1.341642f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(0.8f, 1.6f, -0.8f),new Vector3f(0.8f, 1.6f, 0.8f),new Vector3f(0.8f, 1.2f, 0.8f),new Vector3f(0.8f, 1.2f, -0.8f),new Vector2f(1.0f, 1.0f),new Vector2f(-0.0f, 1.0f),new Vector2f(-0.0f, 0.75f),new Vector2f(1.0f, 0.75f),new Vector3f(4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		HopperSideFull other = new HopperSideFull();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

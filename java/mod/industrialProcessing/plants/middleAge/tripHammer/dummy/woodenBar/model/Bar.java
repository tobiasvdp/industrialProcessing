package  mod.industrialProcessing.plants.middleAge.tripHammer.dummy.woodenBar.model;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Bar extends ObjMesh{
	public Bar(){
		this.quads = new ObjQuad[16];
		this.quads[0] = new ObjQuad(new Vector3f(-0.1f, 0.35f, 0.8f),new Vector3f(-0.1f, 0.35f, -0.8f),new Vector3f(0.1f, 0.35f, -0.8f),new Vector3f(0.1f, 0.35f, 0.8f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.5625f, 1.0f),new Vector2f(0.4375f, 1.0f),new Vector2f(0.4375f, 0.0f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.1f, 0.85f, 0.8f),new Vector3f(0.1f, 0.85f, 0.8f),new Vector3f(0.1f, 0.85f, -0.8f),new Vector3f(-0.1f, 0.85f, -0.8f),new Vector2f(0.4375f, 0.0f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.5625f, 1.0f),new Vector2f(0.4375f, 1.0f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.25f, 0.5f, 0.8f),new Vector3f(0.25f, 0.5f, -0.8f),new Vector3f(0.25f, 0.7f, -0.8f),new Vector3f(0.25f, 0.7f, 0.8f),new Vector2f(0.0f, 0.3125f),new Vector2f(1.0f, 0.3125f),new Vector2f(1.0f, 0.4375f),new Vector2f(0.0f, 0.4375f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.1f, 0.35f, -0.8f),new Vector3f(-0.1f, 0.35f, -0.8f),new Vector3f(-0.25f, 0.5f, -0.8f),new Vector3f(-0.1f, 0.85f, -0.8f),new Vector2f(0.4375f, 0.2188f),new Vector2f(0.5625f, 0.2188f),new Vector2f(0.6562f, 0.3125f),new Vector2f(0.5625f, 0.5313f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.25f, 0.5f, -0.8f),new Vector3f(-0.25f, 0.7f, -0.8f),new Vector3f(-0.1f, 0.85f, -0.8f),new Vector2f(0.6562f, 0.3125f),new Vector2f(0.6562f, 0.4375f),new Vector2f(0.5625f, 0.5313f),new Vector3f(0.0f, 0.0f, -3.0f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.1f, 0.85f, -0.8f),new Vector3f(0.1f, 0.85f, -0.8f),new Vector3f(0.25f, 0.7f, -0.8f),new Vector3f(0.1f, 0.35f, -0.8f),new Vector2f(0.5625f, 0.5313f),new Vector2f(0.4375f, 0.5313f),new Vector2f(0.3437f, 0.4375f),new Vector2f(0.4375f, 0.2188f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[6] = new ObjQuad(new Vector3f(0.25f, 0.5f, -0.8f),new Vector3f(0.1f, 0.35f, -0.8f),new Vector3f(0.25f, 0.7f, -0.8f),new Vector2f(0.3437f, 0.3125f),new Vector2f(0.4375f, 0.2188f),new Vector2f(0.3437f, 0.4375f),new Vector3f(0.0f, 0.0f, -3.0f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.25f, 0.5f, -0.8f),new Vector3f(-0.25f, 0.5f, 0.8f),new Vector3f(-0.25f, 0.7f, 0.8f),new Vector3f(-0.25f, 0.7f, -0.8f),new Vector2f(0.0f, 0.3125f),new Vector2f(1.0f, 0.3125f),new Vector2f(1.0f, 0.4375f),new Vector2f(0.0f, 0.4375f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(-0.1f, 0.35f, 0.8f),new Vector3f(-0.25f, 0.5f, 0.8f),new Vector3f(-0.25f, 0.5f, -0.8f),new Vector3f(-0.1f, 0.35f, -0.8f),new Vector2f(1.0f, 0.2188f),new Vector2f(1.0f, 0.3125f),new Vector2f(0.0f, 0.3125f),new Vector2f(0.0f, 0.2188f),new Vector3f(-2.8284f, -2.8284f, 0.0f));
		this.quads[9] = new ObjQuad(new Vector3f(0.1f, 0.35f, -0.8f),new Vector3f(0.25f, 0.5f, -0.8f),new Vector3f(0.25f, 0.5f, 0.8f),new Vector3f(0.1f, 0.35f, 0.8f),new Vector2f(1.0f, 0.2188f),new Vector2f(1.0f, 0.3125f),new Vector2f(0.0f, 0.3125f),new Vector2f(0.0f, 0.2188f),new Vector3f(2.8284f, -2.8284f, 0.0f));
		this.quads[10] = new ObjQuad(new Vector3f(0.1f, 0.85f, 0.8f),new Vector3f(0.25f, 0.7f, 0.8f),new Vector3f(0.25f, 0.7f, -0.8f),new Vector3f(0.1f, 0.85f, -0.8f),new Vector2f(0.0f, 0.5313f),new Vector2f(0.0f, 0.4375f),new Vector2f(1.0f, 0.4375f),new Vector2f(1.0f, 0.5313f),new Vector3f(2.8284f, 2.8284f, 0.0f));
		this.quads[11] = new ObjQuad(new Vector3f(-0.1f, 0.85f, -0.8f),new Vector3f(-0.25f, 0.7f, -0.8f),new Vector3f(-0.25f, 0.7f, 0.8f),new Vector3f(-0.1f, 0.85f, 0.8f),new Vector2f(0.0f, 0.5313f),new Vector2f(0.0f, 0.4375f),new Vector2f(1.0f, 0.4375f),new Vector2f(1.0f, 0.5313f),new Vector3f(-2.8284f, 2.8284f, 0.0f));
		this.quads[12] = new ObjQuad(new Vector3f(0.25f, 0.5f, 0.8f),new Vector3f(0.25f, 0.7f, 0.8f),new Vector3f(0.1f, 0.85f, 0.8f),new Vector3f(-0.1f, 0.35f, 0.8f),new Vector2f(0.6562f, 0.3125f),new Vector2f(0.6562f, 0.4375f),new Vector2f(0.5625f, 0.5313f),new Vector2f(0.4375f, 0.2188f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[13] = new ObjQuad(new Vector3f(0.1f, 0.85f, 0.8f),new Vector3f(-0.1f, 0.85f, 0.8f),new Vector3f(-0.25f, 0.7f, 0.8f),new Vector3f(-0.1f, 0.35f, 0.8f),new Vector2f(0.5625f, 0.5313f),new Vector2f(0.4375f, 0.5313f),new Vector2f(0.3437f, 0.4375f),new Vector2f(0.4375f, 0.2188f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[14] = new ObjQuad(new Vector3f(-0.25f, 0.7f, 0.8f),new Vector3f(-0.25f, 0.5f, 0.8f),new Vector3f(-0.1f, 0.35f, 0.8f),new Vector2f(0.3437f, 0.4375f),new Vector2f(0.3437f, 0.3125f),new Vector2f(0.4375f, 0.2188f),new Vector3f(0.0f, 0.0f, 3.0f));
		this.quads[15] = new ObjQuad(new Vector3f(0.1f, 0.35f, 0.8f),new Vector3f(0.25f, 0.5f, 0.8f),new Vector3f(-0.1f, 0.35f, 0.8f),new Vector2f(0.5625f, 0.2188f),new Vector2f(0.6562f, 0.3125f),new Vector2f(0.4375f, 0.2188f),new Vector3f(0.0f, 0.0f, 3.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Bar other = new Bar();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

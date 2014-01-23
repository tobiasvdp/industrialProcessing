package ip.industrialProcessing.machines.plants.metalProcessing.sandCaster.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class CastFlow extends ObjMesh{
	public CastFlow(){
		this.quads = new ObjQuad[16];
		this.quads[0] = new ObjQuad(new Vector3f(0.0f, 0.9f, 0.0f),new Vector3f(-0.0f, 0.9f, -0.0503f),new Vector3f(0.0356f, 0.9f, -0.0356f),new Vector3f(0.0503f, 0.9f, 0.0f),new Vector2f(0.5f, 0.5f),new Vector2f(0.5f, 0.5314f),new Vector2f(0.4778f, 0.5222f),new Vector2f(0.4686f, 0.5f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.0f, 0.9f, 0.0f),new Vector3f(-0.0503f, 0.9f, 0.0f),new Vector3f(-0.0356f, 0.9f, -0.0356f),new Vector3f(-0.0f, 0.9f, -0.0503f),new Vector2f(0.5f, 0.5f),new Vector2f(0.5314f, 0.5f),new Vector2f(0.5222f, 0.5222f),new Vector2f(0.5f, 0.5314f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.0f, 0.9f, 0.0f),new Vector3f(0.0f, 0.9f, 0.0503f),new Vector3f(-0.0356f, 0.9f, 0.0356f),new Vector3f(-0.0503f, 0.9f, 0.0f),new Vector2f(0.5f, 0.5f),new Vector2f(0.5f, 0.4686f),new Vector2f(0.5222f, 0.4778f),new Vector2f(0.5314f, 0.5f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.0f, 0.9f, 0.0f),new Vector3f(0.0503f, 0.9f, 0.0f),new Vector3f(0.0356f, 0.9f, 0.0356f),new Vector3f(0.0f, 0.9f, 0.0503f),new Vector2f(0.5f, 0.5f),new Vector2f(0.4686f, 0.5f),new Vector2f(0.4778f, 0.4778f),new Vector2f(0.5f, 0.4686f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.0503f, 0.9f, 0.0f),new Vector3f(0.0356f, 0.9f, -0.0356f),new Vector3f(0.0356f, 1.2f, -0.0356f),new Vector3f(0.0503f, 1.2f, 0.0f),new Vector2f(0.5f, 0.4688f),new Vector2f(0.5222f, 0.4688f),new Vector2f(0.5222f, 0.6563f),new Vector2f(0.5f, 0.6563f),new Vector3f(3.4141998f, 0.0f, -1.4142f));
		this.quads[5] = new ObjQuad(new Vector3f(0.0356f, 0.9f, -0.0356f),new Vector3f(-0.0f, 0.9f, -0.0503f),new Vector3f(-0.0f, 1.2f, -0.0503f),new Vector3f(0.0356f, 1.2f, -0.0356f),new Vector2f(0.4778f, 0.4688f),new Vector2f(0.5f, 0.4688f),new Vector2f(0.5f, 0.6563f),new Vector2f(0.4778f, 0.6563f),new Vector3f(1.4142f, 0.0f, -3.4141998f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.0f, 0.9f, -0.0503f),new Vector3f(-0.0356f, 0.9f, -0.0356f),new Vector3f(-0.0356f, 1.2f, -0.0356f),new Vector3f(-0.0f, 1.2f, -0.0503f),new Vector2f(0.5f, 0.4688f),new Vector2f(0.5222f, 0.4688f),new Vector2f(0.5222f, 0.6563f),new Vector2f(0.5f, 0.6563f),new Vector3f(-1.4142f, 0.0f, -3.4141998f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.0356f, 0.9f, -0.0356f),new Vector3f(-0.0503f, 0.9f, 0.0f),new Vector3f(-0.0503f, 1.2f, 0.0f),new Vector3f(-0.0356f, 1.2f, -0.0356f),new Vector2f(0.4778f, 0.4688f),new Vector2f(0.5f, 0.4688f),new Vector2f(0.5f, 0.6563f),new Vector2f(0.4778f, 0.6563f),new Vector3f(-3.4141998f, 0.0f, -1.4142f));
		this.quads[8] = new ObjQuad(new Vector3f(-0.0503f, 0.9f, 0.0f),new Vector3f(-0.0356f, 0.9f, 0.0356f),new Vector3f(-0.0356f, 1.2f, 0.0356f),new Vector3f(-0.0503f, 1.2f, 0.0f),new Vector2f(0.5f, 0.4688f),new Vector2f(0.5222f, 0.4688f),new Vector2f(0.5222f, 0.6563f),new Vector2f(0.5f, 0.6563f),new Vector3f(-3.4141998f, 0.0f, 1.4142f));
		this.quads[9] = new ObjQuad(new Vector3f(-0.0356f, 0.9f, 0.0356f),new Vector3f(0.0f, 0.9f, 0.0503f),new Vector3f(0.0f, 1.2f, 0.0503f),new Vector3f(-0.0356f, 1.2f, 0.0356f),new Vector2f(0.4778f, 0.4688f),new Vector2f(0.5f, 0.4688f),new Vector2f(0.5f, 0.6563f),new Vector2f(0.4778f, 0.6563f),new Vector3f(-1.4142f, 0.0f, 3.4141998f));
		this.quads[10] = new ObjQuad(new Vector3f(0.0f, 0.9f, 0.0503f),new Vector3f(0.0356f, 0.9f, 0.0356f),new Vector3f(0.0356f, 1.2f, 0.0356f),new Vector3f(0.0f, 1.2f, 0.0503f),new Vector2f(0.5f, 0.4688f),new Vector2f(0.5222f, 0.4688f),new Vector2f(0.5222f, 0.6563f),new Vector2f(0.5f, 0.6563f),new Vector3f(1.4142f, 0.0f, 3.4141998f));
		this.quads[11] = new ObjQuad(new Vector3f(0.0356f, 0.9f, 0.0356f),new Vector3f(0.0503f, 0.9f, 0.0f),new Vector3f(0.0503f, 1.2f, 0.0f),new Vector3f(0.0356f, 1.2f, 0.0356f),new Vector2f(0.4778f, 0.4688f),new Vector2f(0.5f, 0.4688f),new Vector2f(0.5f, 0.6563f),new Vector2f(0.4778f, 0.6563f),new Vector3f(3.4141998f, 0.0f, 1.4142f));
		this.quads[12] = new ObjQuad(new Vector3f(0.0f, 1.2f, 0.0f),new Vector3f(0.0356f, 1.2f, 0.0356f),new Vector3f(0.0503f, 1.2f, 0.0f),new Vector3f(0.0356f, 1.2f, -0.0356f),new Vector2f(0.5f, 0.5f),new Vector2f(0.5222f, 0.4778f),new Vector2f(0.5314f, 0.5f),new Vector2f(0.5222f, 0.5222f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[13] = new ObjQuad(new Vector3f(0.0f, 1.2f, 0.0f),new Vector3f(0.0356f, 1.2f, -0.0356f),new Vector3f(-0.0f, 1.2f, -0.0503f),new Vector3f(-0.0356f, 1.2f, -0.0356f),new Vector2f(0.5f, 0.5f),new Vector2f(0.5222f, 0.5222f),new Vector2f(0.5f, 0.5314f),new Vector2f(0.4778f, 0.5222f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[14] = new ObjQuad(new Vector3f(0.0f, 1.2f, 0.0f),new Vector3f(-0.0356f, 1.2f, -0.0356f),new Vector3f(-0.0503f, 1.2f, 0.0f),new Vector3f(-0.0356f, 1.2f, 0.0356f),new Vector2f(0.5f, 0.5f),new Vector2f(0.4778f, 0.5222f),new Vector2f(0.4686f, 0.5f),new Vector2f(0.4778f, 0.4778f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[15] = new ObjQuad(new Vector3f(0.0f, 1.2f, 0.0f),new Vector3f(-0.0356f, 1.2f, 0.0356f),new Vector3f(0.0f, 1.2f, 0.0503f),new Vector3f(0.0356f, 1.2f, 0.0356f),new Vector2f(0.5f, 0.5f),new Vector2f(0.4778f, 0.4778f),new Vector2f(0.5f, 0.4686f),new Vector2f(0.5222f, 0.4778f),new Vector3f(0.0f, 4.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		CastFlow other = new CastFlow();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

package ip.industrialProcessing.multiblock.core.block.blastFurnace.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class FluidConnector extends ObjMesh{
	public FluidConnector(){
		this.quads = new ObjQuad[13];
		this.quads[0] = new ObjQuad(new Vector3f(0.3f, 0.5f, -0.8f),new Vector3f(-0.3f, 0.5f, -0.8f),new Vector3f(-0.3f, 1.1f, -0.8f),new Vector3f(0.3f, 1.1f, -0.8f),new Vector2f(1.0f, 0.625f),new Vector2f(1.0f, 1.0f),new Vector2f(0.625f, 1.0f),new Vector2f(0.625f, 0.625f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.3f, 0.5f, -0.8f),new Vector3f(0.3f, 1.1f, -0.8f),new Vector3f(0.3f, 1.1f, -0.7f),new Vector3f(0.3f, 0.5f, -0.7f),new Vector2f(0.25f, 0.0f),new Vector2f(0.625f, 0.0f),new Vector2f(0.625f, 0.0625f),new Vector2f(0.25f, 0.0625f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.3f, 1.1f, -0.8f),new Vector3f(-0.3f, 1.1f, -0.8f),new Vector3f(-0.3f, 1.1f, -0.7f),new Vector3f(0.3f, 1.1f, -0.7f),new Vector2f(0.625f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 0.0625f),new Vector2f(0.625f, 0.0625f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.3f, 1.1f, -0.8f),new Vector3f(-0.3f, 0.5f, -0.8f),new Vector3f(-0.3f, 0.5f, -0.7f),new Vector3f(-0.3f, 1.1f, -0.7f),new Vector2f(0.625f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 0.0625f),new Vector2f(0.625f, 0.0625f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.3f, 0.5f, -0.8f),new Vector3f(0.3f, 0.5f, -0.8f),new Vector3f(0.3f, 0.5f, -0.7f),new Vector3f(-0.3f, 0.5f, -0.7f),new Vector2f(0.25f, 0.0f),new Vector2f(0.625f, 0.0f),new Vector2f(0.625f, 0.0625f),new Vector2f(0.25f, 0.0625f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(0.3f, 0.5f, -0.7f),new Vector3f(0.3f, 1.1f, -0.7f),new Vector3f(0.1992f, 0.9992f, -0.7f),new Vector3f(0.1992f, 0.6008f, -0.7f),new Vector2f(0.6249f, 0.25f),new Vector2f(0.9999f, 0.25f),new Vector2f(0.9369f, 0.313f),new Vector2f(0.6879f, 0.313f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[6] = new ObjQuad(new Vector3f(0.3f, 1.1f, -0.7f),new Vector3f(-0.3f, 1.1f, -0.7f),new Vector3f(-0.1992f, 0.9992f, -0.7f),new Vector3f(0.1992f, 0.9992f, -0.7f),new Vector2f(0.9999f, 0.25f),new Vector2f(0.9999f, 0.625f),new Vector2f(0.9369f, 0.562f),new Vector2f(0.9369f, 0.313f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.3f, 1.1f, -0.7f),new Vector3f(-0.3f, 0.5f, -0.7f),new Vector3f(-0.1992f, 0.6008f, -0.7f),new Vector3f(-0.1992f, 0.9992f, -0.7f),new Vector2f(0.9999f, 0.625f),new Vector2f(0.6249f, 0.625f),new Vector2f(0.6879f, 0.562f),new Vector2f(0.9369f, 0.562f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[8] = new ObjQuad(new Vector3f(-0.3f, 0.5f, -0.7f),new Vector3f(0.3f, 0.5f, -0.7f),new Vector3f(0.1992f, 0.6008f, -0.7f),new Vector3f(-0.1992f, 0.6008f, -0.7f),new Vector2f(0.6249f, 0.625f),new Vector2f(0.6249f, 0.25f),new Vector2f(0.6879f, 0.313f),new Vector2f(0.6879f, 0.562f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[9] = new ObjQuad(new Vector3f(0.1992f, 0.6008f, -0.7f),new Vector3f(0.1992f, 0.9992f, -0.7f),new Vector3f(0.1992f, 0.9992f, -0.3992f),new Vector3f(0.1992f, 0.6008f, -0.3992f),new Vector2f(0.313f, 0.0625f),new Vector2f(0.562f, 0.0625f),new Vector2f(0.562f, 0.2505f),new Vector2f(0.313f, 0.2505f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[10] = new ObjQuad(new Vector3f(0.1992f, 0.9992f, -0.7f),new Vector3f(-0.1992f, 0.9992f, -0.7f),new Vector3f(-0.1992f, 0.9992f, -0.3992f),new Vector3f(0.1992f, 0.9992f, -0.3992f),new Vector2f(0.688f, 0.0625f),new Vector2f(0.937f, 0.0625f),new Vector2f(0.937f, 0.2505f),new Vector2f(0.688f, 0.2505f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[11] = new ObjQuad(new Vector3f(-0.1992f, 0.9992f, -0.7f),new Vector3f(-0.1992f, 0.6008f, -0.7f),new Vector3f(-0.1992f, 0.6008f, -0.3992f),new Vector3f(-0.1992f, 0.9992f, -0.3992f),new Vector2f(0.688f, 0.0625f),new Vector2f(0.937f, 0.0625f),new Vector2f(0.937f, 0.2505f),new Vector2f(0.688f, 0.2505f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[12] = new ObjQuad(new Vector3f(-0.1992f, 0.6008f, -0.7f),new Vector3f(0.1992f, 0.6008f, -0.7f),new Vector3f(0.1992f, 0.6008f, -0.3992f),new Vector3f(-0.1992f, 0.6008f, -0.3992f),new Vector2f(0.313f, 0.0625f),new Vector2f(0.562f, 0.0625f),new Vector2f(0.562f, 0.2505f),new Vector2f(0.313f, 0.2505f),new Vector3f(0.0f, -4.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		FluidConnector other = new FluidConnector();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

package mod.industrialProcessing.plants.transport.conveyorInput.model;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class ImporterParts extends ObjMesh{
	public ImporterParts(){
		this.quads = new ObjQuad[12];
		this.quads[0] = new ObjQuad(new Vector3f(-0.8f, 0.5f, 0.4f),new Vector3f(-0.8f, 0.5f, -0.4f),new Vector3f(-0.7f, 0.5f, -0.4f),new Vector3f(-0.7f, 0.5f, 0.4f),new Vector2f(0.375f, 0.25f),new Vector2f(0.875f, 0.25f),new Vector2f(0.875f, 0.3125f),new Vector2f(0.375f, 0.3125f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.8f, 0.9f, 0.4f),new Vector3f(-0.7f, 0.9f, 0.4f),new Vector3f(-0.7f, 0.9f, -0.4f),new Vector3f(-0.8f, 0.9f, -0.4f),new Vector2f(0.375f, 0.625f),new Vector2f(0.375f, 0.5625f),new Vector2f(0.875f, 0.5625f),new Vector2f(0.875f, 0.625f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.8f, 0.9f, -0.4f),new Vector3f(-0.7f, 0.9f, -0.4f),new Vector3f(-0.7f, 0.5f, -0.4f),new Vector3f(-0.8f, 0.5f, -0.4f),new Vector2f(1.0f, 0.5625f),new Vector2f(0.9375f, 0.5625f),new Vector2f(0.9375f, 0.3125f),new Vector2f(1.0f, 0.3125f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.8f, 0.9f, 0.4f),new Vector3f(-0.8f, 0.9f, -0.4f),new Vector3f(-0.8f, 0.5f, -0.4f),new Vector3f(-0.8f, 0.5f, 0.4f),new Vector2f(0.875f, 0.5625f),new Vector2f(0.375f, 0.5625f),new Vector2f(0.375f, 0.3125f),new Vector2f(0.875f, 0.3125f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.7f, 0.9f, 0.4f),new Vector3f(-0.8f, 0.9f, 0.4f),new Vector3f(-0.8f, 0.5f, 0.4f),new Vector3f(-0.7f, 0.5f, 0.4f),new Vector2f(0.9375f, 0.5625f),new Vector2f(0.875f, 0.5625f),new Vector2f(0.875f, 0.3125f),new Vector2f(0.9375f, 0.3125f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.8f, 1.5f, -0.3f),new Vector3f(-0.8f, 0.9f, -0.3f),new Vector3f(-0.8f, 0.9f, 0.3f),new Vector3f(-0.8f, 1.5f, 0.3f),new Vector2f(0.0f, 0.625f),new Vector2f(0.0f, 0.25f),new Vector2f(0.375f, 0.25f),new Vector2f(0.375f, 0.625f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.7f, 1.5f, -0.3f),new Vector3f(-0.7f, 0.9f, -0.3f),new Vector3f(-0.8f, 0.9f, -0.3f),new Vector3f(-0.8f, 1.5f, -0.3f),new Vector2f(0.0f, 0.375f),new Vector2f(0.0f, 0.0f),new Vector2f(0.0625f, 0.0f),new Vector2f(0.0625f, 0.375f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.7f, 1.5f, 0.3f),new Vector3f(-0.7f, 1.5f, -0.3f),new Vector3f(-0.8f, 1.5f, -0.3f),new Vector3f(-0.8f, 1.5f, 0.3f),new Vector2f(0.0f, 0.375f),new Vector2f(0.0f, 0.0f),new Vector2f(0.0625f, 0.0f),new Vector2f(0.0625f, 0.375f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(-0.7f, 0.9f, 0.3f),new Vector3f(-0.7f, 1.5f, 0.3f),new Vector3f(-0.8f, 1.5f, 0.3f),new Vector3f(-0.8f, 0.9f, 0.3f),new Vector2f(0.0f, 0.375f),new Vector2f(0.0f, 0.0f),new Vector2f(0.0625f, 0.0f),new Vector2f(0.0625f, 0.375f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[9] = new ObjQuad(new Vector3f(0.7f, 1.5f, -0.3f),new Vector3f(-0.7f, 1.5f, -0.3f),new Vector3f(-0.7f, 1.5f, 0.3f),new Vector3f(0.7f, 1.5f, 0.3f),new Vector2f(0.0625f, 0.625f),new Vector2f(0.9375f, 0.625f),new Vector2f(0.9375f, 1.0f),new Vector2f(0.0625f, 1.0f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[10] = new ObjQuad(new Vector3f(0.3f, 1.5f, 0.7f),new Vector3f(0.3f, 1.5f, 0.3f),new Vector3f(-0.3f, 1.5f, 0.3f),new Vector3f(-0.3f, 1.5f, 0.7f),new Vector2f(0.0625f, 0.625f),new Vector2f(0.3125f, 0.625f),new Vector2f(0.3125f, 1.0f),new Vector2f(0.0625f, 1.0f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[11] = new ObjQuad(new Vector3f(-0.3f, 1.5f, -0.7f),new Vector3f(-0.3f, 1.5f, -0.3f),new Vector3f(0.3f, 1.5f, -0.3f),new Vector3f(0.3f, 1.5f, -0.7f),new Vector2f(0.0625f, 0.625f),new Vector2f(0.3125f, 0.625f),new Vector2f(0.3125f, 1.0f),new Vector2f(0.0625f, 1.0f),new Vector3f(0.0f, 4.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		ImporterParts other = new ImporterParts();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

package mod.industrialProcessing.plants.construction.weldingStation.model;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class CraftingBench extends ObjMesh{
	public CraftingBench(){
		this.quads = new ObjQuad[6];
		this.quads[0] = new ObjQuad(new Vector3f(-0.15f, 0.4f, 0.65f),new Vector3f(-0.15f, 0.4f, -0.15f),new Vector3f(0.65f, 0.4f, -0.15f),new Vector3f(0.65f, 0.4f, 0.65f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 1.0f),new Vector2f(-0.0f, 1.0f),new Vector2f(0.0f, -0.0f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.15f, 1.2f, 0.65f),new Vector3f(0.65f, 1.2f, 0.65f),new Vector3f(0.65f, 1.2f, -0.15f),new Vector3f(-0.15f, 1.2f, -0.15f),new Vector2f(-0.0f, 0.0f),new Vector2f(1.0f, -0.0f),new Vector2f(1.0f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.15f, 0.4f, 0.65f),new Vector3f(0.65f, 0.4f, 0.65f),new Vector3f(0.65f, 1.2f, 0.65f),new Vector3f(-0.15f, 1.2f, 0.65f),new Vector2f(-0.0f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 1.0f),new Vector2f(-0.0f, 1.0f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.65f, 0.4f, 0.65f),new Vector3f(0.65f, 0.4f, -0.15f),new Vector3f(0.65f, 1.2f, -0.15f),new Vector3f(0.65f, 1.2f, 0.65f),new Vector2f(-0.0f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 1.0f),new Vector2f(-0.0f, 1.0f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.65f, 0.4f, -0.15f),new Vector3f(-0.15f, 0.4f, -0.15f),new Vector3f(-0.15f, 1.2f, -0.15f),new Vector3f(0.65f, 1.2f, -0.15f),new Vector2f(-0.0f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 1.0f),new Vector2f(-0.0f, 1.0f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.15f, 0.4f, -0.15f),new Vector3f(-0.15f, 0.4f, 0.65f),new Vector3f(-0.15f, 1.2f, 0.65f),new Vector3f(-0.15f, 1.2f, -0.15f),new Vector2f(-0.0f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 1.0f),new Vector2f(-0.0f, 1.0f),new Vector3f(-4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		CraftingBench other = new CraftingBench();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

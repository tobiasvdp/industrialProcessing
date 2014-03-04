package mod.industrialProcessing.block.crystals.meshes;

import mod.industrialProcessing.client.rendering.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class Crystal8 extends ObjMesh {

	public Crystal8() {
		this.quads = new ObjQuad[6];
		this.quads[0] = new ObjQuad(new Vector3f(0.086011f, 0.632419f, -0.192603f), new Vector3f(0.127037f, 0.538274f, -0.249138f), new Vector3f(-0.00355f, 0.563655f, -0.224114f), new Vector3f(0.02752f, 0.598154f, -0.096961f), new Vector2f(0.0625f, 0.4375f), new Vector2f(0.0f, 0.375f), new Vector2f(0.125f, 0.375f), new Vector2f(0.125f, 0.5f), new Vector3f(-0.042509034f, 3.244775f, -1.3045871f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.042336f, 0.084515f, 0.059467f), new Vector3f(0.088251f, 0.059134f, 0.034444f), new Vector3f(0.158108f, 0.572773f, -0.121985f), new Vector3f(0.02752f, 0.598154f, -0.096961f), new Vector2f(0.5f, 1.0f), new Vector2f(0.375f, 1.0f), new Vector2f(0.375f, 0.5f), new Vector2f(0.5f, 0.5f), new Vector3f(0.918128f, 1.019436f, 3.757364f));
		this.quads[2] = new ObjQuad(new Vector3f(0.088251f, 0.059134f, 0.034444f), new Vector3f(0.057181f, 0.024635f, -0.092709f), new Vector3f(0.127037f, 0.538274f, -0.249138f), new Vector3f(0.158108f, 0.572773f, -0.121985f), new Vector2f(0.125f, 1.0f), new Vector2f(-0.0f, 1.0f), new Vector2f(-0.0f, 0.5f), new Vector2f(0.125f, 0.5f), new Vector3f(3.858848f, -0.750008f, -0.739436f));
		this.quads[3] = new ObjQuad(new Vector3f(0.057181f, 0.024635f, -0.092709f), new Vector3f(-0.073406f, 0.050016f, -0.067686f), new Vector3f(-0.00355f, 0.563655f, -0.224114f), new Vector3f(0.127037f, 0.538274f, -0.249138f), new Vector2f(0.25f, 1.0f), new Vector2f(0.125f, 1.0f), new Vector2f(0.125f, 0.5f), new Vector2f(0.25f, 0.5f), new Vector3f(-0.918128f, -1.019436f, -3.757364f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.073406f, 0.050016f, -0.067686f), new Vector3f(-0.042336f, 0.084515f, 0.059467f), new Vector3f(0.02752f, 0.598154f, -0.096961f), new Vector3f(-0.00355f, 0.563655f, -0.224114f), new Vector2f(0.375f, 1.0f), new Vector2f(0.25f, 1.0f), new Vector2f(0.25f, 0.5f), new Vector2f(0.375f, 0.5f), new Vector3f(-3.858852f, 0.750008f, 0.739436f));
		this.quads[5] = new ObjQuad(new Vector3f(0.158108f, 0.572773f, -0.121985f), new Vector3f(0.127037f, 0.538274f, -0.249138f), new Vector3f(0.086011f, 0.632419f, -0.192603f), new Vector3f(0.02752f, 0.598154f, -0.096961f), new Vector2f(0.0f, 0.5f), new Vector2f(0.0f, 0.375f), new Vector2f(0.0625f, 0.4375f), new Vector2f(0.125f, 0.5f), new Vector3f(0.932587f, 3.299772f, -0.68855506f));
	}

	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Crystal8 other = new Crystal8();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}

}

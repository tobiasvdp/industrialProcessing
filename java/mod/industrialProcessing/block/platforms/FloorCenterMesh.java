package mod.industrialProcessing.block.platforms;

import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class FloorCenterMesh extends ObjMesh {

	public FloorCenterMesh() {
		this.quads = new ObjQuad[2];
		this.quads[0] = new ObjQuad(new Vector3f(-0.6f, +0.0f, +0.6f), new Vector3f(-0.6f, +0.0f, -0.6f), new Vector3f(+0.6f, +0.0f, -0.6f), new Vector3f(+0.6f, +0.0f, +0.6f), new Vector2f(0.125f, 0.125f), new Vector2f(0.125f, 0.875f), new Vector2f(0.875f, 0.875f), new Vector2f(0.875f, 0.125f), new Vector3f(0, -1, 0));
		this.quads[1] = new ObjQuad(new Vector3f(-0.6f, +0.1f, +0.6f), new Vector3f(+0.6f, +0.1f, +0.6f), new Vector3f(+0.6f, +0.1f, -0.6f), new Vector3f(-0.6f, +0.1f, -0.6f), new Vector2f(0.125f, 0.125f), new Vector2f(0.125f, 0.875f), new Vector2f(0.875f, 0.875f), new Vector2f(0.875f, 0.125f), new Vector3f(0, +1, 0));
	}

	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		FloorCenterMesh other = new FloorCenterMesh();
		other.quads = cloneQuads(this.quads, transform);
		return null;
	}

}

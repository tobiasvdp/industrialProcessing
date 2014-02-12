package mod.industrialProcessing.blocks.platforms;

import mod.industrialProcessing.client.rendering.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class FloorConnectedSide extends ObjMesh {

	public FloorConnectedSide() {
		this.quads = new ObjQuad[2];
		this.quads[0] = new ObjQuad(new Vector3f(-0.6f, 0.1f, 0.8f), new Vector3f(0.6f, 0.1f, 0.8f), new Vector3f(0.6f, 0.1f, 0.6f), new Vector3f(-0.6f, 0.1f, 0.6f), new Vector2f(0.125f, 0.8125f), new Vector2f(0.875f, 0.8125f), new Vector2f(0.875f, 0.9375f), new Vector2f(0.125f, 0.9375f), new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.6f, -0.0f, 0.8f), new Vector3f(-0.6f, -0.0f, 0.6f), new Vector3f(0.6f, -0.0f, 0.6f), new Vector3f(0.6f, -0.0f, 0.8f), new Vector2f(0.125f, 0.8125f), new Vector2f(0.125f, 0.9375f), new Vector2f(0.875f, 0.9375f), new Vector2f(0.875f, 0.8125f), new Vector3f(0.0f, -4.0f, 0.0f));
	}


	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		FloorConnectedSide other = new FloorConnectedSide();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}

}

package mod.industrialProcessing.plants.blackSmith.forge.model;

import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class Object extends ObjMesh {
	public Object() {
		this.quads = new ObjQuad[1];
		this.quads[0] = new ObjQuad(new Vector3f(-0.8f, 1.6f, 0.8f), new Vector3f(0.8f, 1.6f, 0.8f), new Vector3f(0.8f, 1.6f, -0.8f), new Vector3f(-0.8f, 1.6f, -0.8f), new Vector2f(0.0f, 0.0f), new Vector2f(1.0f, 0.0f), new Vector2f(1.0f, 1.0f), new Vector2f(0.0f, 1.0f), new Vector3f(0.0f, 4.0f, 0.0f));
	}

	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Object other = new Object();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

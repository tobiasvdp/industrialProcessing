package ip.industrialProcessing.transport.fluids.models;

import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class TankCenter extends ObjMesh {
	public TankCenter() {
		this.quads = new ObjQuad[14];
		this.quads[0] = new ObjQuad(new Vector3f(0.289959f, 1.6f, -0.700023f), new Vector3f(0.700024f, 1.6f, -0.289959f), new Vector3f(0.700024f, 0.0f, -0.289959f), new Vector3f(0.289959f, 0.0f, -0.700023f), new Vector2f(1.0f, 0.0f), new Vector2f(1.0f, 0.375f), new Vector2f(0.0f, 0.375f), new Vector2f(0.0f, 0.0f), new Vector3f(2.828428f, 0.0f, -2.828428f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.289959f, 1.6f, -0.700023f), new Vector3f(0.289959f, 1.6f, -0.700023f), new Vector3f(0.289959f, 0.0f, -0.700023f), new Vector3f(-0.289959f, 0.0f, -0.700023f), new Vector2f(1.0f, 0.625f), new Vector2f(1.0f, 1.0f), new Vector2f(0.0f, 1.0f), new Vector2f(0.0f, 0.625f), new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.700024f, 1.6f, -0.289959f), new Vector3f(-0.289959f, 1.6f, -0.700023f), new Vector3f(-0.289959f, 0.0f, -0.700023f), new Vector3f(-0.700024f, 0.0f, -0.289959f), new Vector2f(1.0f, 0.25f), new Vector2f(1.0f, 0.625f), new Vector2f(0.0f, 0.625f), new Vector2f(0.0f, 0.25f), new Vector3f(-2.828428f, 0.0f, -2.828428f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.700023f, 1.6f, 0.289959f), new Vector3f(-0.700024f, 1.6f, -0.289959f), new Vector3f(-0.700024f, 0.0f, -0.289959f), new Vector3f(-0.700023f, 0.0f, 0.289959f), new Vector2f(1.0f, 0.375f), new Vector2f(1.0f, 0.75f), new Vector2f(0.0f, 0.75f), new Vector2f(-0.0f, 0.375f), new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.289959f, 1.6f, 0.700024f), new Vector3f(-0.700023f, 1.6f, 0.289959f), new Vector3f(-0.700023f, 0.0f, 0.289959f), new Vector3f(-0.289959f, 0.0f, 0.700024f), new Vector2f(1.0f, 0.0f), new Vector2f(1.0f, 0.375f), new Vector2f(-0.0f, 0.375f), new Vector2f(-0.0f, 0.0f), new Vector3f(-2.828428f, 0.0f, 2.828428f));
		this.quads[5] = new ObjQuad(new Vector3f(0.700023f, 1.6f, 0.289959f), new Vector3f(0.289959f, 1.6f, 0.700024f), new Vector3f(0.289959f, 0.0f, 0.700024f), new Vector3f(0.700023f, 0.0f, 0.289959f), new Vector2f(1.0f, 0.25f), new Vector2f(1.0f, 0.625f), new Vector2f(0.0f, 0.625f), new Vector2f(0.0f, 0.25f), new Vector3f(2.828428f, 0.0f, 2.828428f));
		this.quads[6] = new ObjQuad(new Vector3f(0.700024f, 1.6f, -0.289959f), new Vector3f(0.700023f, 1.6f, 0.289959f), new Vector3f(0.700023f, 0.0f, 0.289959f), new Vector3f(0.700024f, 0.0f, -0.289959f), new Vector2f(1.0f, 0.375f), new Vector2f(1.0f, 0.75f), new Vector2f(0.0f, 0.75f), new Vector2f(0.0f, 0.375f), new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(0.607636f, 0.0f, -0.251691f), new Vector3f(0.607636f, 1.6f, -0.251691f), new Vector3f(0.251691f, 1.6f, -0.607635f), new Vector3f(0.251691f, 0.0f, -0.607636f), new Vector2f(0.0f, 0.625f), new Vector2f(1.0f, 0.625f), new Vector2f(1.0f, 0.3125f), new Vector2f(0.0f, 0.3125f), new Vector3f(-2.828428f, 0.0f, 2.828428f));
		this.quads[8] = new ObjQuad(new Vector3f(0.251691f, 0.0f, -0.607636f), new Vector3f(0.251691f, 1.6f, -0.607635f), new Vector3f(-0.251691f, 1.6f, -0.607635f), new Vector3f(-0.251691f, 0.0f, -0.607635f), new Vector2f(0.0f, 0.3125f), new Vector2f(1.0f, 0.3125f), new Vector2f(1.0f, 0.0f), new Vector2f(0.0f, 0.0f), new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[9] = new ObjQuad(new Vector3f(-0.251691f, 0.0f, -0.607635f), new Vector3f(-0.251691f, 1.6f, -0.607635f), new Vector3f(-0.607636f, 1.6f, -0.251691f), new Vector3f(-0.607636f, 0.0f, -0.251691f), new Vector2f(0.0f, 0.9375f), new Vector2f(1.0f, 0.9375f), new Vector2f(1.0f, 0.625f), new Vector2f(0.0f, 0.625f), new Vector3f(2.828428f, 0.0f, 2.828428f));
		this.quads[10] = new ObjQuad(new Vector3f(-0.607636f, 0.0f, -0.251691f), new Vector3f(-0.607636f, 1.6f, -0.251691f), new Vector3f(-0.607636f, 1.6f, 0.251691f), new Vector3f(-0.607636f, 0.0f, 0.251691f), new Vector2f(0.0f, 0.625f), new Vector2f(1.0f, 0.625f), new Vector2f(1.0f, 0.3125f), new Vector2f(0.0f, 0.3125f), new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[11] = new ObjQuad(new Vector3f(-0.607636f, 0.0f, 0.251691f), new Vector3f(-0.607636f, 1.6f, 0.251691f), new Vector3f(-0.251691f, 1.6f, 0.607636f), new Vector3f(-0.251691f, 0.0f, 0.607636f), new Vector2f(0.0f, 0.3125f), new Vector2f(1.0f, 0.3125f), new Vector2f(1.0f, 0.0f), new Vector2f(0.0f, 0.0f), new Vector3f(2.828428f, 0.0f, -2.828428f));
		this.quads[12] = new ObjQuad(new Vector3f(0.251691f, 0.0f, 0.607636f), new Vector3f(0.251691f, 1.6f, 0.607636f), new Vector3f(0.607636f, 1.6f, 0.251691f), new Vector3f(0.607636f, 0.0f, 0.251691f), new Vector2f(0.0f, 0.938f), new Vector2f(1.0f, 0.938f), new Vector2f(1.0f, 0.625f), new Vector2f(0.0f, 0.625f), new Vector3f(-2.828428f, 0.0f, -2.828428f));
		this.quads[13] = new ObjQuad(new Vector3f(0.607636f, 0.0f, 0.251691f), new Vector3f(0.607636f, 1.6f, 0.251691f), new Vector3f(0.607636f, 1.6f, -0.251691f), new Vector3f(0.607636f, 0.0f, -0.251691f), new Vector2f(0.0f, 0.9375f), new Vector2f(1.0f, 0.9375f), new Vector2f(1.0f, 0.625f), new Vector2f(0.0f, 0.625f), new Vector3f(-4.0f, 0.0f, 0.0f));
	}

	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
        TankCenter other = new TankCenter();
        other.quads = cloneQuads(this.quads, transform);
        return other;
	}

}

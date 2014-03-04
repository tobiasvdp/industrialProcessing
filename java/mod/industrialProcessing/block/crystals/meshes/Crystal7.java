package mod.industrialProcessing.block.crystals.meshes;

import mod.industrialProcessing.client.rendering.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class Crystal7 extends ObjMesh {

	public Crystal7() {
		this.quads = new ObjQuad[6];
		this.quads[0] = new ObjQuad(new Vector3f(-0.249604f, 0.491138f, -0.227753f), new Vector3f(-0.152806f, 0.448514f, -0.238729f), new Vector3f(-0.255648f, 0.404946f, -0.289732f), new Vector3f(-0.314835f, 0.419952f, -0.183206f), new Vector2f(0.4375f, 0.5625f), new Vector2f(0.5f, 0.625f), new Vector2f(0.375f, 0.625f), new Vector2f(0.375f, 0.5f), new Vector3f(-1.031959f, 3.002607f, -1.4668779f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.188571f, -0.035287f, -0.048927f), new Vector3f(-0.08573f, 0.008281f, 0.002076f), new Vector3f(-0.211993f, 0.46352f, -0.132203f), new Vector3f(-0.314835f, 0.419952f, -0.183206f), new Vector2f(0.0f, 0.0f), new Vector2f(0.125f, 0.0f), new Vector2f(0.125f, 0.5f), new Vector2f(0.0f, 0.5f), new Vector3f(-1.92816f, 0.488836f, 3.470336f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.08573f, 0.008281f, 0.002076f), new Vector3f(-0.026543f, -0.006724f, -0.10445f), new Vector3f(-0.152806f, 0.448514f, -0.238729f), new Vector3f(-0.211993f, 0.46352f, -0.132203f), new Vector2f(0.375f, 0.0f), new Vector2f(0.5f, 0.0f), new Vector2f(0.5f, 0.5f), new Vector2f(0.375f, 0.5f), new Vector3f(3.35033f, 1.419338f, 1.661556f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.026543f, -0.006724f, -0.10445f), new Vector3f(-0.129385f, -0.050292f, -0.155453f), new Vector3f(-0.255648f, 0.404946f, -0.289732f), new Vector3f(-0.152806f, 0.448514f, -0.238729f), new Vector2f(0.25f, 0.0f), new Vector2f(0.375f, 0.0f), new Vector2f(0.375f, 0.5f), new Vector2f(0.25f, 0.5f), new Vector3f(1.92816f, -0.488836f, -3.470336f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.129385f, -0.050292f, -0.155453f), new Vector3f(-0.188571f, -0.035287f, -0.048927f), new Vector3f(-0.314835f, 0.419952f, -0.183206f), new Vector3f(-0.255648f, 0.404946f, -0.289732f), new Vector2f(0.125f, 0.0f), new Vector2f(0.25f, 0.0f), new Vector2f(0.25f, 0.5f), new Vector2f(0.125f, 0.5f), new Vector3f(-3.350328f, -1.41934f, -1.661556f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.211993f, 0.46352f, -0.132203f), new Vector3f(-0.152806f, 0.448514f, -0.238729f), new Vector3f(-0.249604f, 0.491138f, -0.227753f), new Vector3f(-0.314835f, 0.419952f, -0.183206f), new Vector2f(0.5f, 0.5f), new Vector2f(0.5f, 0.625f), new Vector2f(0.4375f, 0.5625f), new Vector2f(0.375f, 0.5f), new Vector3f(-0.74166006f, 3.392111f, -0.41933602f));
	}

	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Crystal7 other = new Crystal7();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}

}

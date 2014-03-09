package mod.industrialProcessing.block.platforms;

import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class HandRailCornerOutside extends ObjMesh {
	public HandRailCornerOutside() {
		this.quads = new ObjQuad[24];
		this.quads[0] = new ObjQuad(new Vector3f(0.657837f, 0.9f, 0.7f), new Vector3f(0.657837f, 0.8f, 0.7f), new Vector3f(0.6f, 0.8f, 0.7f), new Vector3f(0.6f, 0.9f, 0.7f), new Vector2f(0.838927f, 0.0625f), new Vector2f(0.838927f, 0.0f), new Vector2f(0.875f, 0.0f), new Vector2f(0.875f, 0.0625f), new Vector3f(-0.754802f, 0.0f, -3.8521f));
		this.quads[1] = new ObjQuad(new Vector3f(0.7f, 0.8f, 0.8f), new Vector3f(0.7f, 0.9f, 0.8f), new Vector3f(0.6f, 0.9f, 0.8f), new Vector3f(0.6f, 0.8f, 0.8f), new Vector2f(0.1875f, 0.0f), new Vector2f(0.1875f, 0.0625f), new Vector2f(0.125f, 0.0625f), new Vector2f(0.125f, 0.0f), new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.657837f, 0.8f, 0.7f), new Vector3f(0.7f, 0.8f, 0.8f), new Vector3f(0.6f, 0.8f, 0.8f), new Vector3f(0.6f, 0.8f, 0.7f), new Vector2f(0.838927f, 0.0625f), new Vector2f(0.8125f, 0.0f), new Vector2f(0.875f, 0.0f), new Vector2f(0.875f, 0.0625f), new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.657837f, 1.4f, 0.7f), new Vector3f(0.657837f, 1.3f, 0.7f), new Vector3f(0.6f, 1.3f, 0.7f), new Vector3f(0.6f, 1.4f, 0.7f), new Vector2f(0.838927f, 1.0f), new Vector2f(0.838927f, 0.9375f), new Vector2f(0.875f, 0.9375f), new Vector2f(0.875f, 1.0f), new Vector3f(-0.754801f, 0.0f, -3.852099f));
		this.quads[4] = new ObjQuad(new Vector3f(0.7f, 1.3f, 0.8f), new Vector3f(0.7f, 1.4f, 0.8f), new Vector3f(0.6f, 1.4f, 0.8f), new Vector3f(0.6f, 1.3f, 0.8f), new Vector2f(0.1875f, 0.9375f), new Vector2f(0.1875f, 1.0f), new Vector2f(0.125f, 1.0f), new Vector2f(0.125f, 0.9375f), new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[5] = new ObjQuad(new Vector3f(0.657837f, 1.3f, 0.7f), new Vector3f(0.7f, 1.3f, 0.8f), new Vector3f(0.6f, 1.3f, 0.8f), new Vector3f(0.6f, 1.3f, 0.7f), new Vector2f(0.838927f, 0.0625f), new Vector2f(0.8125f, 0.0f), new Vector2f(0.875f, 0.0f), new Vector2f(0.875f, 0.0625f), new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(0.7f, 0.9f, 0.658789f), new Vector3f(0.8f, 0.9f, 0.7f), new Vector3f(0.8f, 0.9f, 0.6f), new Vector3f(0.7f, 0.9f, 0.6f), new Vector2f(0.837757f, 0.0625f), new Vector2f(0.8125f, -0.0f), new Vector2f(0.875f, -0.0f), new Vector2f(0.875f, 0.0625f), new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(0.7f, 1.4f, 0.658789f), new Vector3f(0.8f, 1.4f, 0.7f), new Vector3f(0.8f, 1.4f, 0.6f), new Vector3f(0.7f, 1.4f, 0.6f), new Vector2f(0.837757f, 0.0625f), new Vector2f(0.8125f, -0.0f), new Vector2f(0.875f, -0.0f), new Vector2f(0.875f, 0.0625f), new Vector3f(-2.0E-6f, 4.0f, 2.0E-6f));
		this.quads[8] = new ObjQuad(new Vector3f(0.657837f, 0.9f, 0.7f), new Vector3f(0.6f, 0.9f, 0.7f), new Vector3f(0.6f, 0.9f, 0.8f), new Vector3f(0.7f, 0.9f, 0.8f), new Vector2f(0.161073f, 0.0625f), new Vector2f(0.125f, 0.0625f), new Vector2f(0.125f, 0.0f), new Vector2f(0.1875f, 0.0f), new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[9] = new ObjQuad(new Vector3f(0.657837f, 1.4f, 0.7f), new Vector3f(0.6f, 1.4f, 0.7f), new Vector3f(0.6f, 1.4f, 0.8f), new Vector3f(0.7f, 1.4f, 0.8f), new Vector2f(0.161073f, 0.0625f), new Vector2f(0.125f, 0.0625f), new Vector2f(0.125f, 0.0f), new Vector2f(0.1875f, 0.0f), new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[10] = new ObjQuad(new Vector3f(0.7f, 0.9f, 0.658789f), new Vector3f(0.7f, 0.8f, 0.658789f), new Vector3f(0.657837f, 0.8f, 0.7f), new Vector3f(0.657837f, 0.9f, 0.7f), new Vector2f(0.151524f, 0.0625f), new Vector2f(0.151524f, 0.0f), new Vector2f(0.188036f, 0.0f), new Vector2f(0.188036f, 0.0625f), new Vector3f(-2.5981622f, 0.0f, -2.628005f));
		this.quads[11] = new ObjQuad(new Vector3f(0.8f, 0.8f, 0.7f), new Vector3f(0.8f, 0.9f, 0.7f), new Vector3f(0.7f, 0.9f, 0.8f), new Vector3f(0.7f, 0.8f, 0.8f), new Vector2f(0.875f, 0.0f), new Vector2f(0.875f, 0.0625f), new Vector2f(0.786612f, 0.0625f), new Vector2f(0.786612f, 0.0f), new Vector3f(2.828428f, 0.0f, 2.828428f));
		this.quads[12] = new ObjQuad(new Vector3f(0.657837f, 0.8f, 0.7f), new Vector3f(0.7f, 0.8f, 0.658789f), new Vector3f(0.8f, 0.8f, 0.7f), new Vector3f(0.7f, 0.8f, 0.8f), new Vector2f(0.188036f, 0.0625f), new Vector2f(0.151524f, 0.0625f), new Vector2f(0.125f, -0.0f), new Vector2f(0.213388f, -0.0f), new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[13] = new ObjQuad(new Vector3f(0.7f, 1.4f, 0.658789f), new Vector3f(0.7f, 1.3f, 0.658789f), new Vector3f(0.657837f, 1.3f, 0.7f), new Vector3f(0.657837f, 1.4f, 0.7f), new Vector2f(0.151524f, 1.0f), new Vector2f(0.151524f, 0.9375f), new Vector2f(0.188036f, 0.9375f), new Vector2f(0.188036f, 1.0f), new Vector3f(-2.5981631f, 0.0f, -2.628003f));
		this.quads[14] = new ObjQuad(new Vector3f(0.8f, 1.3f, 0.7f), new Vector3f(0.8f, 1.4f, 0.7f), new Vector3f(0.7f, 1.4f, 0.8f), new Vector3f(0.7f, 1.3f, 0.8f), new Vector2f(0.875f, 0.9375f), new Vector2f(0.875f, 1.0f), new Vector2f(0.786611f, 1.0f), new Vector2f(0.786611f, 0.9375f), new Vector3f(2.828428f, 0.0f, 2.828428f));
		this.quads[15] = new ObjQuad(new Vector3f(0.657837f, 1.3f, 0.7f), new Vector3f(0.7f, 1.3f, 0.658789f), new Vector3f(0.8f, 1.3f, 0.7f), new Vector3f(0.7f, 1.3f, 0.8f), new Vector2f(0.188036f, 0.0625f), new Vector2f(0.151524f, 0.0625f), new Vector2f(0.125f, -0.0f), new Vector2f(0.213388f, -0.0f), new Vector3f(-2.0E-6f, -4.0f, -1.0E-6f));
		this.quads[16] = new ObjQuad(new Vector3f(0.657837f, 0.9f, 0.7f), new Vector3f(0.7f, 0.9f, 0.8f), new Vector3f(0.8f, 0.9f, 0.7f), new Vector3f(0.7f, 0.9f, 0.658789f), new Vector2f(0.811964f, 0.0625f), new Vector2f(0.786612f, -0.0f), new Vector2f(0.875f, -0.0f), new Vector2f(0.848476f, 0.0625f), new Vector3f(-2.0E-6f, 4.0f, -2.0E-6f));
		this.quads[17] = new ObjQuad(new Vector3f(0.657837f, 1.4f, 0.7f), new Vector3f(0.7f, 1.4f, 0.8f), new Vector3f(0.8f, 1.4f, 0.7f), new Vector3f(0.7f, 1.4f, 0.658789f), new Vector2f(0.811964f, 0.0625f), new Vector2f(0.786611f, -0.0f), new Vector2f(0.875f, -0.0f), new Vector2f(0.848476f, 0.0625f), new Vector3f(0.0f, 4.0f, -2.0E-6f));
		this.quads[18] = new ObjQuad(new Vector3f(0.7f, 0.9f, 0.6f), new Vector3f(0.7f, 0.8f, 0.6f), new Vector3f(0.7f, 0.8f, 0.658789f), new Vector3f(0.7f, 0.9f, 0.658789f), new Vector2f(0.125f, 0.0625f), new Vector2f(0.125f, 0.0f), new Vector2f(0.162243f, 0.0f), new Vector2f(0.162243f, 0.0625f), new Vector3f(-3.843358f, 0.0f, -0.775905f));
		this.quads[19] = new ObjQuad(new Vector3f(0.8f, 0.8f, 0.6f), new Vector3f(0.8f, 0.9f, 0.6f), new Vector3f(0.8f, 0.9f, 0.7f), new Vector3f(0.8f, 0.8f, 0.7f), new Vector2f(0.875f, 0.0f), new Vector2f(0.875f, 0.0625f), new Vector2f(0.8125f, 0.0625f), new Vector2f(0.8125f, 0.0f), new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[20] = new ObjQuad(new Vector3f(0.7f, 0.8f, 0.658789f), new Vector3f(0.7f, 0.8f, 0.6f), new Vector3f(0.8f, 0.8f, 0.6f), new Vector3f(0.8f, 0.8f, 0.7f), new Vector2f(0.162243f, 0.0625f), new Vector2f(0.125f, 0.0625f), new Vector2f(0.125f, -0.0f), new Vector2f(0.1875f, -0.0f), new Vector3f(0.0f, -4.0f, -1.0E-6f));
		this.quads[21] = new ObjQuad(new Vector3f(0.7f, 1.4f, 0.6f), new Vector3f(0.7f, 1.3f, 0.6f), new Vector3f(0.7f, 1.3f, 0.658789f), new Vector3f(0.7f, 1.4f, 0.658789f), new Vector2f(0.125f, 1.0f), new Vector2f(0.125f, 0.9375f), new Vector2f(0.162243f, 0.9375f), new Vector2f(0.162243f, 1.0f), new Vector3f(-3.84336f, 0.0f, -0.775904f));
		this.quads[22] = new ObjQuad(new Vector3f(0.8f, 1.3f, 0.6f), new Vector3f(0.8f, 1.4f, 0.6f), new Vector3f(0.8f, 1.4f, 0.7f), new Vector3f(0.8f, 1.3f, 0.7f), new Vector2f(0.875f, 0.9375f), new Vector2f(0.875f, 1.0f), new Vector2f(0.8125f, 1.0f), new Vector2f(0.8125f, 0.9375f), new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[23] = new ObjQuad(new Vector3f(0.7f, 1.3f, 0.658789f), new Vector3f(0.7f, 1.3f, 0.6f), new Vector3f(0.8f, 1.3f, 0.6f), new Vector3f(0.8f, 1.3f, 0.7f), new Vector2f(0.162243f, 0.0625f), new Vector2f(0.125f, 0.0625f), new Vector2f(0.125f, -0.0f), new Vector2f(0.1875f, -0.0f), new Vector3f(2.0E-6f, -4.0f, -3.0E-6f));
	}

	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		HandRailCornerOutside other = new HandRailCornerOutside();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

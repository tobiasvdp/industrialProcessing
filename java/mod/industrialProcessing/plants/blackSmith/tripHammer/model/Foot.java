package  mod.industrialProcessing.plants.blackSmith.tripHammer.model;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Foot extends ObjMesh{
	public Foot(){
		this.quads = new ObjQuad[81];
		this.quads[0] = new ObjQuad(new Vector3f(-0.65f, 0.0f, 0.5f),new Vector3f(-0.65f, 0.0f, -0.5f),new Vector3f(0.65f, 0.0f, -0.5f),new Vector3f(0.65f, 0.0f, 0.5f),new Vector2f(0.9063f, 0.1875f),new Vector2f(0.9062f, 0.8125f),new Vector2f(0.0937f, 0.8125f),new Vector2f(0.0938f, 0.1875f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.308f, 2.0f, 0.4f),new Vector3f(0.308f, 2.0f, 0.1f),new Vector3f(-0.308f, 2.0f, 0.1f),new Vector3f(-0.308f, 2.0f, 0.4f),new Vector2f(0.6925f, 0.25f),new Vector2f(0.6925f, 0.4375f),new Vector2f(0.3075f, 0.4375f),new Vector2f(0.3075f, 0.25f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.65f, 0.0f, 0.5f),new Vector3f(0.65f, 0.0f, 0.5f),new Vector3f(0.65f, 1.5f, 0.5f),new Vector3f(-0.65f, 1.5f, 0.5f),new Vector2f(0.0937f, 0.0f),new Vector2f(0.9062f, 0.0f),new Vector2f(0.9062f, 0.9375f),new Vector2f(0.0937f, 0.9375f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.65f, 0.0f, 0.5f),new Vector3f(0.65f, 0.0f, -0.5f),new Vector3f(0.65f, 0.5f, -0.5f),new Vector3f(0.65f, 1.0f, -0.5f),new Vector2f(0.1875f, 0.0f),new Vector2f(0.8125f, 0.0f),new Vector2f(0.8125f, 0.3125f),new Vector2f(0.8125f, 0.625f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.65f, 0.0f, 0.5f),new Vector3f(0.65f, 1.0f, -0.5f),new Vector3f(0.65f, 1.5f, -0.5f),new Vector3f(0.65f, 1.5f, -0.0f),new Vector2f(0.1875f, 0.0f),new Vector2f(0.8125f, 0.625f),new Vector2f(0.8125f, 0.9375f),new Vector2f(0.5f, 0.9375f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(0.65f, 0.0f, 0.5f),new Vector3f(0.65f, 1.5f, -0.0f),new Vector3f(0.65f, 1.5f, 0.5f),new Vector2f(0.1875f, 0.0f),new Vector2f(0.5f, 0.9375f),new Vector2f(0.1875f, 0.9375f),new Vector3f(3.0f, 0.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(0.2167f, 1.0f, -0.5f),new Vector3f(0.2167f, 0.5f, -0.5f),new Vector3f(-0.2167f, 0.5f, -0.5f),new Vector3f(-0.2167f, 1.0f, -0.5f),new Vector2f(0.3646f, 0.625f),new Vector2f(0.3646f, 0.3125f),new Vector2f(0.6354f, 0.3125f),new Vector2f(0.6354f, 0.625f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.65f, 0.0f, -0.5f),new Vector3f(-0.65f, 0.0f, 0.5f),new Vector3f(-0.65f, 1.5f, 0.5f),new Vector3f(-0.65f, 0.5f, -0.5f),new Vector2f(0.1875f, 0.0f),new Vector2f(0.8125f, 0.0f),new Vector2f(0.8125f, 0.9375f),new Vector2f(0.1875f, 0.3125f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(-0.65f, 1.5f, -0.0f),new Vector3f(-0.65f, 1.5f, -0.5f),new Vector3f(-0.65f, 1.0f, -0.5f),new Vector3f(-0.65f, 1.5f, 0.5f),new Vector2f(0.5f, 0.9375f),new Vector2f(0.1875f, 0.9375f),new Vector2f(0.1875f, 0.625f),new Vector2f(0.8125f, 0.9375f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[9] = new ObjQuad(new Vector3f(-0.65f, 1.5f, 0.5f),new Vector3f(-0.65f, 1.0f, -0.5f),new Vector3f(-0.65f, 0.5f, -0.5f),new Vector2f(0.8125f, 0.9375f),new Vector2f(0.1875f, 0.625f),new Vector2f(0.1875f, 0.3125f),new Vector3f(-3.0f, 0.0f, 0.0f));
		this.quads[10] = new ObjQuad(new Vector3f(-0.65f, 1.5f, -0.5f),new Vector3f(0.65f, 1.5f, -0.5f),new Vector3f(0.65f, 1.0f, -0.5f),new Vector3f(0.2167f, 1.0f, -0.5f),new Vector2f(0.9062f, 0.9375f),new Vector2f(0.0937f, 0.9375f),new Vector2f(0.0937f, 0.625f),new Vector2f(0.3646f, 0.625f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[11] = new ObjQuad(new Vector3f(-0.65f, 1.5f, -0.5f),new Vector3f(0.2167f, 1.0f, -0.5f),new Vector3f(-0.2167f, 1.0f, -0.5f),new Vector3f(-0.65f, 1.0f, -0.5f),new Vector2f(0.9062f, 0.9375f),new Vector2f(0.3646f, 0.625f),new Vector2f(0.6354f, 0.625f),new Vector2f(0.9062f, 0.625f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[12] = new ObjQuad(new Vector3f(0.65f, 0.0f, -0.5f),new Vector3f(-0.65f, 0.0f, -0.5f),new Vector3f(-0.65f, 0.5f, -0.5f),new Vector3f(-0.2167f, 0.5f, -0.5f),new Vector2f(0.0937f, 0.0f),new Vector2f(0.9062f, 0.0f),new Vector2f(0.9062f, 0.3125f),new Vector2f(0.6354f, 0.3125f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[13] = new ObjQuad(new Vector3f(0.65f, 0.0f, -0.5f),new Vector3f(-0.2167f, 0.5f, -0.5f),new Vector3f(0.2167f, 0.5f, -0.5f),new Vector3f(0.65f, 0.5f, -0.5f),new Vector2f(0.0937f, 0.0f),new Vector2f(0.6354f, 0.3125f),new Vector2f(0.3646f, 0.3125f),new Vector2f(0.0937f, 0.3125f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[14] = new ObjQuad(new Vector3f(0.65f, 0.85f, -1.1f),new Vector3f(0.65f, 0.65f, -1.1f),new Vector3f(0.2167f, 0.65f, -1.1f),new Vector3f(0.2167f, 0.85f, -1.1f),new Vector2f(0.0937f, 0.5313f),new Vector2f(0.0937f, 0.4063f),new Vector2f(0.3646f, 0.4063f),new Vector2f(0.3646f, 0.5313f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[15] = new ObjQuad(new Vector3f(-0.65f, 0.65f, -1.1f),new Vector3f(-0.65f, 0.85f, -1.1f),new Vector3f(-0.2167f, 0.85f, -1.1f),new Vector3f(-0.2167f, 0.65f, -1.1f),new Vector2f(0.9062f, 0.4063f),new Vector2f(0.9062f, 0.5313f),new Vector2f(0.6354f, 0.5313f),new Vector2f(0.6354f, 0.4063f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[16] = new ObjQuad(new Vector3f(0.65f, 0.5f, -0.5f),new Vector3f(0.65f, 0.5f, -0.95f),new Vector3f(0.65f, 0.65f, -1.1f),new Vector3f(0.65f, 1.0f, -0.5f),new Vector2f(0.8125f, 0.3125f),new Vector2f(1.0937f, 0.3125f),new Vector2f(1.1875f, 0.4063f),new Vector2f(0.8125f, 0.625f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[17] = new ObjQuad(new Vector3f(0.65f, 0.65f, -1.1f),new Vector3f(0.65f, 0.85f, -1.1f),new Vector3f(0.65f, 1.0f, -0.95f),new Vector3f(0.65f, 1.0f, -0.5f),new Vector2f(1.1875f, 0.4063f),new Vector2f(1.1875f, 0.5313f),new Vector2f(1.0937f, 0.625f),new Vector2f(0.8125f, 0.625f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[18] = new ObjQuad(new Vector3f(0.65f, 0.5f, -0.5f),new Vector3f(0.2167f, 0.5f, -0.5f),new Vector3f(0.2167f, 0.5f, -0.95f),new Vector3f(0.65f, 0.5f, -0.95f),new Vector2f(0.0937f, 0.8125f),new Vector2f(0.3646f, 0.8125f),new Vector2f(0.3646f, 1.0938f),new Vector2f(0.0937f, 1.0937f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[19] = new ObjQuad(new Vector3f(0.2167f, 1.0f, -0.5f),new Vector3f(0.2167f, 1.0f, -0.95f),new Vector3f(0.2167f, 0.85f, -1.1f),new Vector3f(0.2167f, 0.5f, -0.5f),new Vector2f(0.1875f, 0.625f),new Vector2f(-0.0938f, 0.625f),new Vector2f(-0.1875f, 0.5313f),new Vector2f(0.1875f, 0.3125f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[20] = new ObjQuad(new Vector3f(0.2167f, 0.85f, -1.1f),new Vector3f(0.2167f, 0.65f, -1.1f),new Vector3f(0.2167f, 0.5f, -0.95f),new Vector3f(0.2167f, 0.5f, -0.5f),new Vector2f(-0.1875f, 0.5313f),new Vector2f(-0.1875f, 0.4063f),new Vector2f(-0.0938f, 0.3125f),new Vector2f(0.1875f, 0.3125f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[21] = new ObjQuad(new Vector3f(0.2167f, 1.0f, -0.5f),new Vector3f(0.65f, 1.0f, -0.5f),new Vector3f(0.65f, 1.0f, -0.95f),new Vector3f(0.2167f, 1.0f, -0.95f),new Vector2f(0.6354f, 0.8125f),new Vector2f(0.9063f, 0.8125f),new Vector2f(0.9063f, 1.0937f),new Vector2f(0.6354f, 1.0938f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[22] = new ObjQuad(new Vector3f(-0.65f, 1.0f, -0.5f),new Vector3f(-0.65f, 1.0f, -0.95f),new Vector3f(-0.65f, 0.85f, -1.1f),new Vector3f(-0.65f, 0.5f, -0.5f),new Vector2f(0.1875f, 0.625f),new Vector2f(-0.0938f, 0.625f),new Vector2f(-0.1875f, 0.5313f),new Vector2f(0.1875f, 0.3125f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[23] = new ObjQuad(new Vector3f(-0.65f, 0.85f, -1.1f),new Vector3f(-0.65f, 0.65f, -1.1f),new Vector3f(-0.65f, 0.5f, -0.95f),new Vector3f(-0.65f, 0.5f, -0.5f),new Vector2f(-0.1875f, 0.5313f),new Vector2f(-0.1875f, 0.4063f),new Vector2f(-0.0938f, 0.3125f),new Vector2f(0.1875f, 0.3125f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[24] = new ObjQuad(new Vector3f(-0.65f, 1.0f, -0.5f),new Vector3f(-0.2167f, 1.0f, -0.5f),new Vector3f(-0.2167f, 1.0f, -0.95f),new Vector3f(-0.65f, 1.0f, -0.95f),new Vector2f(0.0938f, 0.8125f),new Vector2f(0.3646f, 0.8125f),new Vector2f(0.3646f, 1.0938f),new Vector2f(0.0938f, 1.0938f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[25] = new ObjQuad(new Vector3f(-0.2167f, 0.5f, -0.5f),new Vector3f(-0.2167f, 0.5f, -0.95f),new Vector3f(-0.2167f, 0.65f, -1.1f),new Vector3f(-0.2167f, 1.0f, -0.5f),new Vector2f(0.8125f, 0.3125f),new Vector2f(1.0938f, 0.3125f),new Vector2f(1.1875f, 0.4063f),new Vector2f(0.8125f, 0.625f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[26] = new ObjQuad(new Vector3f(-0.2167f, 0.65f, -1.1f),new Vector3f(-0.2167f, 0.85f, -1.1f),new Vector3f(-0.2167f, 1.0f, -0.95f),new Vector3f(-0.2167f, 1.0f, -0.5f),new Vector2f(1.1875f, 0.4063f),new Vector2f(1.1875f, 0.5313f),new Vector2f(1.0938f, 0.625f),new Vector2f(0.8125f, 0.625f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[27] = new ObjQuad(new Vector3f(-0.2167f, 0.5f, -0.5f),new Vector3f(-0.65f, 0.5f, -0.5f),new Vector3f(-0.65f, 0.5f, -0.95f),new Vector3f(-0.2167f, 0.5f, -0.95f),new Vector2f(0.6354f, 0.8125f),new Vector2f(0.9062f, 0.8125f),new Vector2f(0.9062f, 1.0938f),new Vector2f(0.6354f, 1.0938f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[28] = new ObjQuad(new Vector3f(0.65f, 0.65f, -1.1f),new Vector3f(0.65f, 0.5f, -0.95f),new Vector3f(0.2167f, 0.5f, -0.95f),new Vector3f(0.2167f, 0.65f, -1.1f),new Vector2f(0.0937f, 0.4063f),new Vector2f(0.0937f, 0.3125f),new Vector2f(0.3646f, 0.3125f),new Vector2f(0.3646f, 0.4063f),new Vector3f(0.0f, -2.8284f, -2.8284f));
		this.quads[29] = new ObjQuad(new Vector3f(0.2167f, 0.85f, -1.1f),new Vector3f(0.2167f, 1.0f, -0.95f),new Vector3f(0.65f, 1.0f, -0.95f),new Vector3f(0.65f, 0.85f, -1.1f),new Vector2f(0.3646f, 0.5313f),new Vector2f(0.3646f, 0.625f),new Vector2f(0.0937f, 0.625f),new Vector2f(0.0937f, 0.5313f),new Vector3f(0.0f, 2.8284f, -2.8284f));
		this.quads[30] = new ObjQuad(new Vector3f(-0.65f, 0.85f, -1.1f),new Vector3f(-0.65f, 1.0f, -0.95f),new Vector3f(-0.2167f, 1.0f, -0.95f),new Vector3f(-0.2167f, 0.85f, -1.1f),new Vector2f(0.9062f, 0.5313f),new Vector2f(0.9062f, 0.625f),new Vector2f(0.6354f, 0.625f),new Vector2f(0.6354f, 0.5313f),new Vector3f(0.0f, 2.8284f, -2.8284f));
		this.quads[31] = new ObjQuad(new Vector3f(-0.2167f, 0.65f, -1.1f),new Vector3f(-0.2167f, 0.5f, -0.95f),new Vector3f(-0.65f, 0.5f, -0.95f),new Vector3f(-0.65f, 0.65f, -1.1f),new Vector2f(0.6354f, 0.4063f),new Vector2f(0.6354f, 0.3125f),new Vector2f(0.9062f, 0.3125f),new Vector2f(0.9062f, 0.4063f),new Vector3f(0.0f, -2.8284f, -2.8284f));
		this.quads[32] = new ObjQuad(new Vector3f(-0.3438f, 1.5f, -0.4f),new Vector3f(-0.3438f, 1.5f, -0.1f),new Vector3f(0.3438f, 1.5f, -0.1f),new Vector3f(0.3438f, 1.5f, -0.4f),new Vector2f(0.2852f, 0.75f),new Vector2f(0.2852f, 0.5625f),new Vector2f(0.7148f, 0.5625f),new Vector2f(0.7148f, 0.75f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[33] = new ObjQuad(new Vector3f(-0.65f, 1.5f, 0.5f),new Vector3f(0.65f, 1.5f, 0.5f),new Vector3f(0.65f, 1.5f, 0.5f),new Vector3f(-0.65f, 1.5f, 0.5f),new Vector2f(0.1875f, 0.9375f),new Vector2f(0.1875f, 0.9375f),new Vector2f(0.1875f, 0.9375f),new Vector2f(0.1875f, 0.9375f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[34] = new ObjQuad(new Vector3f(0.65f, 1.5f, 0.5f),new Vector3f(0.65f, 1.5f, -0.0f),new Vector3f(0.65f, 1.5f, 0.0f),new Vector3f(0.65f, 1.5f, 0.5f),new Vector2f(0.1875f, 0.9375f),new Vector2f(0.5f, 0.9375f),new Vector2f(0.5f, 0.9375f),new Vector2f(0.1875f, 0.9375f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[35] = new ObjQuad(new Vector3f(0.65f, 1.5f, -0.0f),new Vector3f(-0.65f, 1.5f, -0.0f),new Vector3f(-0.65f, 1.5f, 0.0f),new Vector3f(0.65f, 1.5f, 0.0f),new Vector2f(0.9063f, 0.5f),new Vector2f(0.0938f, 0.5f),new Vector2f(0.0938f, 0.5f),new Vector2f(0.9063f, 0.5f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[36] = new ObjQuad(new Vector3f(-0.65f, 1.5f, -0.0f),new Vector3f(-0.65f, 1.5f, 0.5f),new Vector3f(-0.65f, 1.5f, 0.5f),new Vector3f(-0.65f, 1.5f, 0.0f),new Vector2f(0.5f, 0.9375f),new Vector2f(0.1875f, 0.9375f),new Vector2f(0.1875f, 0.9375f),new Vector2f(0.5f, 0.9375f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[37] = new ObjQuad(new Vector3f(-0.55f, 1.65f, 0.4f),new Vector3f(0.55f, 1.65f, 0.4f),new Vector3f(0.55f, 2.0f, 0.4f),new Vector3f(0.308f, 2.0f, 0.4f),new Vector2f(0.1562f, 1.0313f),new Vector2f(0.8437f, 1.0313f),new Vector2f(0.8437f, 1.25f),new Vector2f(0.6925f, 1.25f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[38] = new ObjQuad(new Vector3f(-0.55f, 1.65f, 0.4f),new Vector3f(0.308f, 2.0f, 0.4f),new Vector3f(-0.308f, 2.0f, 0.4f),new Vector3f(-0.55f, 2.0f, 0.4f),new Vector2f(0.1562f, 1.0313f),new Vector2f(0.6925f, 1.25f),new Vector2f(0.3075f, 1.25f),new Vector2f(0.1562f, 1.25f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[39] = new ObjQuad(new Vector3f(0.55f, 1.65f, 0.4f),new Vector3f(0.55f, 1.65f, 0.1f),new Vector3f(0.55f, 2.0f, 0.1f),new Vector3f(0.55f, 2.0f, 0.4f),new Vector2f(0.25f, 1.0313f),new Vector2f(0.4375f, 1.0313f),new Vector2f(0.4375f, 1.25f),new Vector2f(0.25f, 1.25f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[40] = new ObjQuad(new Vector3f(0.55f, 1.65f, 0.1f),new Vector3f(-0.55f, 1.65f, 0.1f),new Vector3f(-0.55f, 2.0f, 0.1f),new Vector3f(-0.308f, 2.0f, 0.1f),new Vector2f(0.1563f, 1.0313f),new Vector2f(0.8438f, 1.0313f),new Vector2f(0.8438f, 1.25f),new Vector2f(0.6925f, 1.25f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[41] = new ObjQuad(new Vector3f(0.55f, 1.65f, 0.1f),new Vector3f(-0.308f, 2.0f, 0.1f),new Vector3f(0.308f, 2.0f, 0.1f),new Vector3f(0.55f, 2.0f, 0.1f),new Vector2f(0.1563f, 1.0313f),new Vector2f(0.6925f, 1.25f),new Vector2f(0.3075f, 1.25f),new Vector2f(0.1563f, 1.25f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[42] = new ObjQuad(new Vector3f(-0.55f, 1.65f, 0.1f),new Vector3f(-0.55f, 1.65f, 0.4f),new Vector3f(-0.55f, 2.0f, 0.4f),new Vector3f(-0.55f, 2.0f, 0.1f),new Vector2f(0.5625f, 1.0313f),new Vector2f(0.75f, 1.0313f),new Vector2f(0.75f, 1.25f),new Vector2f(0.5625f, 1.25f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[43] = new ObjQuad(new Vector3f(0.55f, 2.7f, 0.4f),new Vector3f(0.55f, 2.7f, 0.1f),new Vector3f(0.308f, 2.7f, 0.1f),new Vector3f(0.308f, 2.7f, 0.4f),new Vector2f(0.8437f, 0.25f),new Vector2f(0.8438f, 0.4375f),new Vector2f(0.6925f, 0.4375f),new Vector2f(0.6925f, 0.25f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[44] = new ObjQuad(new Vector3f(-0.55f, 2.7f, 0.1f),new Vector3f(-0.55f, 2.7f, 0.4f),new Vector3f(-0.308f, 2.7f, 0.4f),new Vector3f(-0.308f, 2.7f, 0.1f),new Vector2f(0.1563f, 0.4375f),new Vector2f(0.1562f, 0.25f),new Vector2f(0.3075f, 0.25f),new Vector2f(0.3075f, 0.4375f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[45] = new ObjQuad(new Vector3f(0.55f, 2.0f, 0.4f),new Vector3f(0.55f, 2.0f, 0.1f),new Vector3f(0.55f, 2.7f, 0.1f),new Vector3f(0.55f, 2.7f, 0.4f),new Vector2f(0.25f, 1.25f),new Vector2f(0.4375f, 1.25f),new Vector2f(0.4375f, 1.6875f),new Vector2f(0.25f, 1.6875f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[46] = new ObjQuad(new Vector3f(0.55f, 2.0f, 0.1f),new Vector3f(0.308f, 2.0f, 0.1f),new Vector3f(0.308f, 2.7f, 0.1f),new Vector3f(0.55f, 2.7f, 0.1f),new Vector2f(0.1563f, 1.25f),new Vector2f(0.3075f, 1.25f),new Vector2f(0.3075f, 1.6875f),new Vector2f(0.1563f, 1.6875f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[47] = new ObjQuad(new Vector3f(0.308f, 2.0f, 0.1f),new Vector3f(0.308f, 2.0f, 0.4f),new Vector3f(0.308f, 2.7f, 0.4f),new Vector3f(0.308f, 2.7f, 0.1f),new Vector2f(0.5625f, 1.25f),new Vector2f(0.75f, 1.25f),new Vector2f(0.75f, 1.6875f),new Vector2f(0.5625f, 1.6875f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[48] = new ObjQuad(new Vector3f(0.308f, 2.0f, 0.4f),new Vector3f(0.55f, 2.0f, 0.4f),new Vector3f(0.55f, 2.7f, 0.4f),new Vector3f(0.308f, 2.7f, 0.4f),new Vector2f(0.6925f, 1.25f),new Vector2f(0.8437f, 1.25f),new Vector2f(0.8437f, 1.6875f),new Vector2f(0.6925f, 1.6875f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[49] = new ObjQuad(new Vector3f(-0.55f, 2.0f, 0.4f),new Vector3f(-0.308f, 2.0f, 0.4f),new Vector3f(-0.308f, 2.7f, 0.4f),new Vector3f(-0.55f, 2.7f, 0.4f),new Vector2f(0.1562f, 1.25f),new Vector2f(0.3075f, 1.25f),new Vector2f(0.3075f, 1.6875f),new Vector2f(0.1562f, 1.6875f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[50] = new ObjQuad(new Vector3f(-0.308f, 2.0f, 0.4f),new Vector3f(-0.308f, 2.0f, 0.1f),new Vector3f(-0.308f, 2.7f, 0.1f),new Vector3f(-0.308f, 2.7f, 0.4f),new Vector2f(0.25f, 1.25f),new Vector2f(0.4375f, 1.25f),new Vector2f(0.4375f, 1.6875f),new Vector2f(0.25f, 1.6875f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[51] = new ObjQuad(new Vector3f(-0.308f, 2.0f, 0.1f),new Vector3f(-0.55f, 2.0f, 0.1f),new Vector3f(-0.55f, 2.7f, 0.1f),new Vector3f(-0.308f, 2.7f, 0.1f),new Vector2f(0.6925f, 1.25f),new Vector2f(0.8438f, 1.25f),new Vector2f(0.8438f, 1.6875f),new Vector2f(0.6925f, 1.6875f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[52] = new ObjQuad(new Vector3f(-0.55f, 2.0f, 0.1f),new Vector3f(-0.55f, 2.0f, 0.4f),new Vector3f(-0.55f, 2.7f, 0.4f),new Vector3f(-0.55f, 2.7f, 0.1f),new Vector2f(0.5625f, 1.25f),new Vector2f(0.75f, 1.25f),new Vector2f(0.75f, 1.6875f),new Vector2f(0.5625f, 1.6875f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[53] = new ObjQuad(new Vector3f(-0.55f, 1.65f, 0.4f),new Vector3f(-0.65f, 1.5f, 0.5f),new Vector3f(0.65f, 1.5f, 0.5f),new Vector3f(0.55f, 1.65f, 0.4f),new Vector2f(0.1562f, 1.0313f),new Vector2f(0.0937f, 0.9375f),new Vector2f(0.9062f, 0.9375f),new Vector2f(0.8437f, 1.0313f),new Vector3f(0.0f, 2.2188f, 3.3284f));
		this.quads[54] = new ObjQuad(new Vector3f(0.55f, 1.65f, 0.4f),new Vector3f(0.65f, 1.5f, 0.5f),new Vector3f(0.65f, 1.5f, 0.0f),new Vector3f(0.55f, 1.65f, 0.1f),new Vector2f(0.25f, 1.0313f),new Vector2f(0.1875f, 0.9375f),new Vector2f(0.5f, 0.9375f),new Vector2f(0.4375f, 1.0313f),new Vector3f(3.3284f, 2.2188f, 0.0f));
		this.quads[55] = new ObjQuad(new Vector3f(0.55f, 1.65f, 0.1f),new Vector3f(0.65f, 1.5f, 0.0f),new Vector3f(-0.65f, 1.5f, 0.0f),new Vector3f(-0.55f, 1.65f, 0.1f),new Vector2f(0.1563f, 1.0313f),new Vector2f(0.0938f, 0.9375f),new Vector2f(0.9063f, 0.9375f),new Vector2f(0.8438f, 1.0313f),new Vector3f(0.0f, 2.2188f, -3.3284f));
		this.quads[56] = new ObjQuad(new Vector3f(-0.55f, 1.65f, 0.1f),new Vector3f(-0.65f, 1.5f, 0.0f),new Vector3f(-0.65f, 1.5f, 0.5f),new Vector3f(-0.55f, 1.65f, 0.4f),new Vector2f(0.5625f, 1.0313f),new Vector2f(0.5f, 0.9375f),new Vector2f(0.8125f, 0.9375f),new Vector2f(0.75f, 1.0313f),new Vector3f(-3.3284f, 2.2188f, 0.0f));
		this.quads[57] = new ObjQuad(new Vector3f(0.65f, 1.5f, -0.5f),new Vector3f(-0.65f, 1.5f, -0.5f),new Vector3f(-0.55f, 1.5f, -0.4f),new Vector3f(-0.3438f, 1.5f, -0.4f),new Vector2f(0.9063f, 0.8125f),new Vector2f(0.0938f, 0.8125f),new Vector2f(0.1563f, 0.75f),new Vector2f(0.2852f, 0.75f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[58] = new ObjQuad(new Vector3f(0.65f, 1.5f, -0.5f),new Vector3f(-0.3438f, 1.5f, -0.4f),new Vector3f(0.3438f, 1.5f, -0.4f),new Vector3f(0.55f, 1.5f, -0.4f),new Vector2f(0.9063f, 0.8125f),new Vector2f(0.2852f, 0.75f),new Vector2f(0.7148f, 0.75f),new Vector2f(0.8438f, 0.75f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[59] = new ObjQuad(new Vector3f(-0.65f, 1.5f, -0.5f),new Vector3f(-0.65f, 1.5f, -0.0f),new Vector3f(-0.55f, 1.5f, -0.1f),new Vector3f(-0.55f, 1.5f, -0.4f),new Vector2f(0.0938f, 0.8125f),new Vector2f(0.0938f, 0.5f),new Vector2f(0.1563f, 0.5625f),new Vector2f(0.1563f, 0.75f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[60] = new ObjQuad(new Vector3f(-0.65f, 1.5f, -0.0f),new Vector3f(0.65f, 1.5f, -0.0f),new Vector3f(0.55f, 1.5f, -0.1f),new Vector3f(0.3438f, 1.5f, -0.1f),new Vector2f(0.0938f, 0.5f),new Vector2f(0.9063f, 0.5f),new Vector2f(0.8438f, 0.5625f),new Vector2f(0.7148f, 0.5625f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[61] = new ObjQuad(new Vector3f(-0.65f, 1.5f, -0.0f),new Vector3f(0.3438f, 1.5f, -0.1f),new Vector3f(-0.3438f, 1.5f, -0.1f),new Vector3f(-0.55f, 1.5f, -0.1f),new Vector2f(0.0938f, 0.5f),new Vector2f(0.7148f, 0.5625f),new Vector2f(0.2852f, 0.5625f),new Vector2f(0.1563f, 0.5625f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[62] = new ObjQuad(new Vector3f(0.65f, 1.5f, -0.0f),new Vector3f(0.65f, 1.5f, -0.5f),new Vector3f(0.55f, 1.5f, -0.4f),new Vector3f(0.55f, 1.5f, -0.1f),new Vector2f(0.9063f, 0.5f),new Vector2f(0.9063f, 0.8125f),new Vector2f(0.8438f, 0.75f),new Vector2f(0.8438f, 0.5625f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[63] = new ObjQuad(new Vector3f(-0.55f, 3.01f, -0.4f),new Vector3f(-0.55f, 3.01f, -0.1f),new Vector3f(-0.3438f, 3.01f, -0.1f),new Vector3f(-0.3438f, 3.01f, -0.4f),new Vector2f(0.1563f, 0.75f),new Vector2f(0.1563f, 0.5625f),new Vector2f(0.2852f, 0.5625f),new Vector2f(0.2852f, 0.75f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[64] = new ObjQuad(new Vector3f(0.55f, 2.81f, -0.1f),new Vector3f(0.55f, 2.81f, -0.4f),new Vector3f(0.3438f, 2.81f, -0.4f),new Vector3f(0.3438f, 2.81f, -0.1f),new Vector2f(0.8438f, 0.5625f),new Vector2f(0.8438f, 0.75f),new Vector2f(0.7148f, 0.75f),new Vector2f(0.7148f, 0.5625f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[65] = new ObjQuad(new Vector3f(-0.55f, 1.5f, -0.4f),new Vector3f(-0.55f, 1.5f, -0.1f),new Vector3f(-0.55f, 2.81f, -0.1f),new Vector3f(-0.55f, 2.81f, -0.4f),new Vector2f(0.25f, 0.9375f),new Vector2f(0.4375f, 0.9375f),new Vector2f(0.4375f, 1.7563f),new Vector2f(0.25f, 1.7563f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[66] = new ObjQuad(new Vector3f(-0.55f, 1.5f, -0.1f),new Vector3f(-0.3438f, 1.5f, -0.1f),new Vector3f(-0.3438f, 2.81f, -0.1f),new Vector3f(-0.55f, 2.81f, -0.1f),new Vector2f(0.1563f, 0.9375f),new Vector2f(0.2852f, 0.9375f),new Vector2f(0.2852f, 1.7563f),new Vector2f(0.1563f, 1.7563f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[67] = new ObjQuad(new Vector3f(-0.3438f, 1.5f, -0.1f),new Vector3f(-0.3438f, 1.5f, -0.4f),new Vector3f(-0.3438f, 2.81f, -0.4f),new Vector3f(-0.3438f, 2.81f, -0.1f),new Vector2f(0.5625f, 0.9375f),new Vector2f(0.75f, 0.9375f),new Vector2f(0.75f, 1.7563f),new Vector2f(0.5625f, 1.7563f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[68] = new ObjQuad(new Vector3f(-0.3438f, 1.5f, -0.4f),new Vector3f(-0.55f, 1.5f, -0.4f),new Vector3f(-0.55f, 2.81f, -0.4f),new Vector3f(-0.3438f, 2.81f, -0.4f),new Vector2f(0.7148f, 0.9375f),new Vector2f(0.8437f, 0.9375f),new Vector2f(0.8437f, 1.7563f),new Vector2f(0.7148f, 1.7563f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[69] = new ObjQuad(new Vector3f(0.55f, 1.5f, -0.4f),new Vector3f(0.3438f, 1.5f, -0.4f),new Vector3f(0.3438f, 2.81f, -0.4f),new Vector3f(0.55f, 2.81f, -0.4f),new Vector2f(0.1562f, 0.9375f),new Vector2f(0.2852f, 0.9375f),new Vector2f(0.2852f, 1.7563f),new Vector2f(0.1562f, 1.7563f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[70] = new ObjQuad(new Vector3f(0.3438f, 1.5f, -0.4f),new Vector3f(0.3438f, 1.5f, -0.1f),new Vector3f(0.3438f, 2.81f, -0.1f),new Vector3f(0.3438f, 2.81f, -0.4f),new Vector2f(0.25f, 0.9375f),new Vector2f(0.4375f, 0.9375f),new Vector2f(0.4375f, 1.7563f),new Vector2f(0.25f, 1.7563f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[71] = new ObjQuad(new Vector3f(0.3438f, 1.5f, -0.1f),new Vector3f(0.55f, 1.5f, -0.1f),new Vector3f(0.55f, 2.81f, -0.1f),new Vector3f(0.3438f, 2.81f, -0.1f),new Vector2f(0.7148f, 0.9375f),new Vector2f(0.8438f, 0.9375f),new Vector2f(0.8438f, 1.7563f),new Vector2f(0.7148f, 1.7563f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[72] = new ObjQuad(new Vector3f(0.55f, 1.5f, -0.1f),new Vector3f(0.55f, 1.5f, -0.4f),new Vector3f(0.55f, 2.81f, -0.4f),new Vector3f(0.55f, 2.81f, -0.1f),new Vector2f(0.5625f, 0.9375f),new Vector2f(0.75f, 0.9375f),new Vector2f(0.75f, 1.7563f),new Vector2f(0.5625f, 1.7563f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[73] = new ObjQuad(new Vector3f(-0.55f, 2.81f, -0.4f),new Vector3f(-0.55f, 2.81f, -0.1f),new Vector3f(-0.55f, 3.01f, -0.1f),new Vector3f(-0.55f, 3.01f, -0.4f),new Vector2f(0.25f, 1.7563f),new Vector2f(0.4375f, 1.7563f),new Vector2f(0.4375f, 1.8813f),new Vector2f(0.25f, 1.8813f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[74] = new ObjQuad(new Vector3f(-0.55f, 2.81f, -0.1f),new Vector3f(-0.3438f, 2.81f, -0.1f),new Vector3f(-0.3438f, 3.01f, -0.1f),new Vector3f(-0.55f, 3.01f, -0.1f),new Vector2f(0.1563f, 1.7563f),new Vector2f(0.2852f, 1.7563f),new Vector2f(0.2852f, 1.8813f),new Vector2f(0.1563f, 1.8813f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[75] = new ObjQuad(new Vector3f(0.5563f, 2.81f, -0.1f),new Vector3f(0.5563f, 2.81f, -0.4f),new Vector3f(0.5563f, 3.01f, -0.4f),new Vector3f(0.5563f, 3.01f, -0.1f),new Vector2f(0.5625f, 1.7563f),new Vector2f(0.75f, 1.7563f),new Vector2f(0.75f, 1.8813f),new Vector2f(0.5625f, 1.8813f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[76] = new ObjQuad(new Vector3f(-0.3438f, 2.81f, -0.4f),new Vector3f(-0.55f, 2.81f, -0.4f),new Vector3f(-0.55f, 3.01f, -0.4f),new Vector3f(-0.3438f, 3.01f, -0.4f),new Vector2f(0.7148f, 1.7563f),new Vector2f(0.8437f, 1.7563f),new Vector2f(0.8437f, 1.8813f),new Vector2f(0.7148f, 1.8813f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[77] = new ObjQuad(new Vector3f(-0.3438f, 2.81f, -0.1f),new Vector3f(-0.3438f, 2.81f, -0.4f),new Vector3f(0.5563f, 2.81f, -0.4f),new Vector3f(0.5563f, 2.81f, -0.1f),new Vector2f(0.7148f, 0.5625f),new Vector2f(0.7148f, 0.75f),new Vector2f(0.1523f, 0.75f),new Vector2f(0.1523f, 0.5625f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[78] = new ObjQuad(new Vector3f(-0.3438f, 2.81f, -0.4f),new Vector3f(-0.3438f, 3.01f, -0.4f),new Vector3f(0.5563f, 3.01f, -0.4f),new Vector3f(0.5563f, 2.81f, -0.4f),new Vector2f(0.7148f, 1.7563f),new Vector2f(0.7148f, 1.8813f),new Vector2f(0.1523f, 1.8813f),new Vector2f(0.1523f, 1.7563f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[79] = new ObjQuad(new Vector3f(-0.3438f, 3.01f, -0.4f),new Vector3f(-0.3438f, 3.01f, -0.1f),new Vector3f(0.5563f, 3.01f, -0.1f),new Vector3f(0.5563f, 3.01f, -0.4f),new Vector2f(0.2852f, 0.75f),new Vector2f(0.2852f, 0.5625f),new Vector2f(0.8477f, 0.5625f),new Vector2f(0.8477f, 0.75f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[80] = new ObjQuad(new Vector3f(-0.3438f, 3.01f, -0.1f),new Vector3f(-0.3438f, 2.81f, -0.1f),new Vector3f(0.5563f, 2.81f, -0.1f),new Vector3f(0.5563f, 3.01f, -0.1f),new Vector2f(0.2852f, 1.8813f),new Vector2f(0.2852f, 1.7563f),new Vector2f(0.8477f, 1.7563f),new Vector2f(0.8477f, 1.8813f),new Vector3f(0.0f, 0.0f, 4.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Foot other = new Foot();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

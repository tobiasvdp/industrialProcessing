package  mod.industrialProcessing.plants.blackSmith.tripHammer.dummy.woodenHammer.model;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Hammer extends ObjMesh{
	public Hammer(){
		this.quads = new ObjQuad[66];
		this.quads[0] = new ObjQuad(new Vector3f(-0.5f, -0.1f, 0.3414f),new Vector3f(-0.5f, -0.1f, -0.3414f),new Vector3f(-0.3414f, -0.1f, -0.5f),new Vector3f(0.5f, -0.1f, -0.3414f),new Vector2f(0.8125f, 0.2866f),new Vector2f(0.8125f, 0.7134f),new Vector2f(0.7134f, 0.8125f),new Vector2f(0.1875f, 0.7134f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.3414f, -0.1f, -0.5f),new Vector3f(0.3414f, -0.1f, -0.5f),new Vector3f(0.5f, -0.1f, -0.3414f),new Vector2f(0.7134f, 0.8125f),new Vector2f(0.2866f, 0.8125f),new Vector2f(0.1875f, 0.7134f),new Vector3f(0.0f, -3.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.5f, -0.1f, -0.3414f),new Vector3f(0.5f, -0.1f, 0.3414f),new Vector3f(0.3414f, -0.1f, 0.5f),new Vector3f(-0.5f, -0.1f, 0.3414f),new Vector2f(0.1875f, 0.7134f),new Vector2f(0.1875f, 0.2866f),new Vector2f(0.2866f, 0.1875f),new Vector2f(0.8125f, 0.2866f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.3414f, -0.1f, 0.5f),new Vector3f(-0.5f, -0.1f, 0.3414f),new Vector3f(0.3414f, -0.1f, 0.5f),new Vector2f(0.7134f, 0.1875f),new Vector2f(0.8125f, 0.2866f),new Vector2f(0.2866f, 0.1875f),new Vector3f(0.0f, -3.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.3f, 1.2f, 0.3f),new Vector3f(0.3f, 1.2f, 0.3f),new Vector3f(0.3f, 1.2f, -0.3f),new Vector3f(-0.3f, 1.2f, -0.3f),new Vector2f(0.3125f, 0.3125f),new Vector2f(0.6875f, 0.3125f),new Vector2f(0.6875f, 0.6875f),new Vector2f(0.3125f, 0.6875f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.3f, 0.0f, 0.4f),new Vector3f(0.3f, 0.0f, 0.4f),new Vector3f(0.3f, 1.1f, 0.4f),new Vector3f(-0.3f, 1.1f, 0.4f),new Vector2f(0.3125f, 0.1563f),new Vector2f(0.6875f, 0.1563f),new Vector2f(0.6875f, 0.8438f),new Vector2f(0.3125f, 0.8438f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[6] = new ObjQuad(new Vector3f(0.4f, 0.0f, 0.3f),new Vector3f(0.4f, 0.0f, -0.3f),new Vector3f(0.4f, 1.1f, -0.3f),new Vector3f(0.4f, 1.1f, 0.3f),new Vector2f(0.3125f, 0.1563f),new Vector2f(0.6875f, 0.1563f),new Vector2f(0.6875f, 0.8438f),new Vector2f(0.3125f, 0.8438f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(0.3f, 0.0f, -0.4f),new Vector3f(-0.3f, 0.0f, -0.4f),new Vector3f(-0.3f, 1.1f, -0.4f),new Vector3f(0.3f, 1.1f, -0.4f),new Vector2f(0.3125f, 0.1563f),new Vector2f(0.6875f, 0.1563f),new Vector2f(0.6875f, 0.8438f),new Vector2f(0.3125f, 0.8438f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[8] = new ObjQuad(new Vector3f(-0.4f, 0.0f, -0.3f),new Vector3f(-0.4f, 0.0f, 0.3f),new Vector3f(-0.4f, 1.1f, 0.3f),new Vector3f(-0.4f, 1.1f, -0.3f),new Vector2f(0.3125f, 0.1563f),new Vector2f(0.6875f, 0.1563f),new Vector2f(0.6875f, 0.8438f),new Vector2f(0.3125f, 0.8438f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[9] = new ObjQuad(new Vector3f(-0.3f, 1.2f, 0.3f),new Vector3f(-0.3423f, 1.1577f, 0.3423f),new Vector3f(-0.3f, 1.1f, 0.4f),new Vector3f(0.3423f, 1.1577f, 0.3423f),new Vector2f(0.3125f, 0.9063f),new Vector2f(0.2861f, 0.8798f),new Vector2f(0.3125f, 0.8438f),new Vector2f(0.7139f, 0.8798f),new Vector3f(0.0f, 2.8284f, 2.8284f));
		this.quads[10] = new ObjQuad(new Vector3f(-0.3f, 1.1f, 0.4f),new Vector3f(0.3f, 1.1f, 0.4f),new Vector3f(0.3423f, 1.1577f, 0.3423f),new Vector2f(0.3125f, 0.8438f),new Vector2f(0.6875f, 0.8438f),new Vector2f(0.7139f, 0.8798f),new Vector3f(0.0f, 2.1213f, 2.1213f));
		this.quads[11] = new ObjQuad(new Vector3f(-0.3f, 1.2f, 0.3f),new Vector3f(0.3423f, 1.1577f, 0.3423f),new Vector3f(0.3f, 1.2f, 0.3f),new Vector2f(0.3125f, 0.9063f),new Vector2f(0.7139f, 0.8798f),new Vector2f(0.6875f, 0.9063f),new Vector3f(0.0f, 2.1213f, 2.1213f));
		this.quads[12] = new ObjQuad(new Vector3f(0.3f, 1.2f, 0.3f),new Vector3f(0.3423f, 1.1577f, 0.3423f),new Vector3f(0.4f, 1.1f, 0.3f),new Vector3f(0.3423f, 1.1577f, -0.3423f),new Vector2f(0.3125f, 0.9063f),new Vector2f(0.2861f, 0.8798f),new Vector2f(0.3125f, 0.8438f),new Vector2f(0.7139f, 0.8798f),new Vector3f(2.8284f, 2.8284f, 0.0f));
		this.quads[13] = new ObjQuad(new Vector3f(0.4f, 1.1f, 0.3f),new Vector3f(0.4f, 1.1f, -0.3f),new Vector3f(0.3423f, 1.1577f, -0.3423f),new Vector2f(0.3125f, 0.8438f),new Vector2f(0.6875f, 0.8438f),new Vector2f(0.7139f, 0.8798f),new Vector3f(2.1213f, 2.1213f, 0.0f));
		this.quads[14] = new ObjQuad(new Vector3f(0.3f, 1.2f, 0.3f),new Vector3f(0.3423f, 1.1577f, -0.3423f),new Vector3f(0.3f, 1.2f, -0.3f),new Vector2f(0.3125f, 0.9063f),new Vector2f(0.7139f, 0.8798f),new Vector2f(0.6875f, 0.9063f),new Vector3f(2.1213f, 2.1213f, 0.0f));
		this.quads[15] = new ObjQuad(new Vector3f(0.3f, 1.2f, -0.3f),new Vector3f(0.3423f, 1.1577f, -0.3423f),new Vector3f(0.3f, 1.1f, -0.4f),new Vector3f(-0.3423f, 1.1577f, -0.3423f),new Vector2f(0.3125f, 0.9063f),new Vector2f(0.2861f, 0.8798f),new Vector2f(0.3125f, 0.8438f),new Vector2f(0.7139f, 0.8798f),new Vector3f(0.0f, 2.8284f, -2.8284f));
		this.quads[16] = new ObjQuad(new Vector3f(0.3f, 1.1f, -0.4f),new Vector3f(-0.3f, 1.1f, -0.4f),new Vector3f(-0.3423f, 1.1577f, -0.3423f),new Vector2f(0.3125f, 0.8438f),new Vector2f(0.6875f, 0.8438f),new Vector2f(0.7139f, 0.8798f),new Vector3f(0.0f, 2.1213f, -2.1213f));
		this.quads[17] = new ObjQuad(new Vector3f(0.3f, 1.2f, -0.3f),new Vector3f(-0.3423f, 1.1577f, -0.3423f),new Vector3f(-0.3f, 1.2f, -0.3f),new Vector2f(0.3125f, 0.9063f),new Vector2f(0.7139f, 0.8798f),new Vector2f(0.6875f, 0.9063f),new Vector3f(0.0f, 2.1213f, -2.1213f));
		this.quads[18] = new ObjQuad(new Vector3f(-0.3f, 1.2f, -0.3f),new Vector3f(-0.3423f, 1.1577f, -0.3423f),new Vector3f(-0.4f, 1.1f, -0.3f),new Vector3f(-0.3423f, 1.1577f, 0.3423f),new Vector2f(0.3125f, 0.9063f),new Vector2f(0.2861f, 0.8798f),new Vector2f(0.3125f, 0.8438f),new Vector2f(0.7139f, 0.8798f),new Vector3f(-2.8284f, 2.8284f, 0.0f));
		this.quads[19] = new ObjQuad(new Vector3f(-0.4f, 1.1f, -0.3f),new Vector3f(-0.4f, 1.1f, 0.3f),new Vector3f(-0.3423f, 1.1577f, 0.3423f),new Vector2f(0.3125f, 0.8438f),new Vector2f(0.6875f, 0.8438f),new Vector2f(0.7139f, 0.8798f),new Vector3f(-2.1213f, 2.1213f, 0.0f));
		this.quads[20] = new ObjQuad(new Vector3f(-0.3f, 1.2f, -0.3f),new Vector3f(-0.3423f, 1.1577f, 0.3423f),new Vector3f(-0.3f, 1.2f, 0.3f),new Vector2f(0.3125f, 0.9063f),new Vector2f(0.7139f, 0.8798f),new Vector2f(0.6875f, 0.9063f),new Vector3f(-2.1213f, 2.1213f, 0.0f));
		this.quads[21] = new ObjQuad(new Vector3f(-0.3f, 1.1f, 0.4f),new Vector3f(-0.3423f, 1.1577f, 0.3423f),new Vector3f(-0.4f, 1.1f, 0.3f),new Vector2f(0.75f, 0.8438f),new Vector2f(0.7139f, 0.8798f),new Vector2f(0.6875f, 0.8438f),new Vector3f(-2.0841f, 0.55859995f, 2.0841f));
		this.quads[22] = new ObjQuad(new Vector3f(0.4f, 1.1f, 0.3f),new Vector3f(0.3423f, 1.1577f, 0.3423f),new Vector3f(0.3f, 1.1f, 0.4f),new Vector2f(0.75f, 0.8438f),new Vector2f(0.7139f, 0.8798f),new Vector2f(0.6875f, 0.8438f),new Vector3f(2.0841f, 0.55859995f, 2.0841f));
		this.quads[23] = new ObjQuad(new Vector3f(-0.4f, 1.1f, -0.3f),new Vector3f(-0.3423f, 1.1577f, -0.3423f),new Vector3f(-0.3f, 1.1f, -0.4f),new Vector2f(0.75f, 0.8438f),new Vector2f(0.7139f, 0.8798f),new Vector2f(0.6875f, 0.8438f),new Vector3f(-2.0841f, 0.55859995f, -2.0841f));
		this.quads[24] = new ObjQuad(new Vector3f(0.3f, 1.1f, -0.4f),new Vector3f(0.3423f, 1.1577f, -0.3423f),new Vector3f(0.4f, 1.1f, -0.3f),new Vector2f(0.75f, 0.8438f),new Vector2f(0.7139f, 0.8798f),new Vector2f(0.6875f, 0.8438f),new Vector3f(2.0841f, 0.55859995f, -2.0841f));
		this.quads[25] = new ObjQuad(new Vector3f(0.3f, 0.0f, 0.4f),new Vector3f(0.4f, 0.0f, 0.3f),new Vector3f(0.4f, 1.1f, 0.3f),new Vector3f(0.3f, 1.1f, 0.4f),new Vector2f(0.6875f, 0.1563f),new Vector2f(0.75f, 0.1563f),new Vector2f(0.75f, 0.8438f),new Vector2f(0.6875f, 0.8438f),new Vector3f(2.8284f, 0.0f, 2.8284f));
		this.quads[26] = new ObjQuad(new Vector3f(-0.3f, 1.1f, 0.4f),new Vector3f(-0.4f, 1.1f, 0.3f),new Vector3f(-0.4f, 0.0f, 0.3f),new Vector3f(-0.3f, 0.0f, 0.4f),new Vector2f(0.75f, 0.8438f),new Vector2f(0.6875f, 0.8438f),new Vector2f(0.6875f, 0.1563f),new Vector2f(0.75f, 0.1563f),new Vector3f(-2.8284f, 0.0f, 2.8284f));
		this.quads[27] = new ObjQuad(new Vector3f(0.4f, 0.0f, -0.3f),new Vector3f(0.3f, 0.0f, -0.4f),new Vector3f(0.3f, 1.1f, -0.4f),new Vector3f(0.4f, 1.1f, -0.3f),new Vector2f(0.6875f, 0.1563f),new Vector2f(0.75f, 0.1563f),new Vector2f(0.75f, 0.8438f),new Vector2f(0.6875f, 0.8438f),new Vector3f(2.8284f, 0.0f, -2.8284f));
		this.quads[28] = new ObjQuad(new Vector3f(-0.3f, 0.0f, -0.4f),new Vector3f(-0.4f, 0.0f, -0.3f),new Vector3f(-0.4f, 1.1f, -0.3f),new Vector3f(-0.3f, 1.1f, -0.4f),new Vector2f(0.6875f, 0.1563f),new Vector2f(0.75f, 0.1563f),new Vector2f(0.75f, 0.8438f),new Vector2f(0.6875f, 0.8438f),new Vector3f(-2.8284f, 0.0f, -2.8284f));
		this.quads[29] = new ObjQuad(new Vector3f(-0.4f, 0.0f, 0.3f),new Vector3f(-0.4f, 0.0f, -0.3f),new Vector3f(-0.5f, -0.1f, -0.3414f),new Vector3f(-0.5f, -0.1f, 0.3414f),new Vector2f(0.6875f, 0.1563f),new Vector2f(0.3125f, 0.1563f),new Vector2f(0.2866f, 0.0938f),new Vector2f(0.7134f, 0.0938f),new Vector3f(-2.8284f, 2.8284f, 0.0f));
		this.quads[30] = new ObjQuad(new Vector3f(-0.4f, 0.0f, -0.3f),new Vector3f(-0.3f, 0.0f, -0.4f),new Vector3f(-0.3414f, -0.1f, -0.5f),new Vector3f(-0.5f, -0.1f, -0.3414f),new Vector2f(0.25f, 0.6875f),new Vector2f(0.3125f, 0.75f),new Vector2f(0.2866f, 0.8125f),new Vector2f(0.1875f, 0.7134f),new Vector3f(-2.0f, 2.8284f, -2.0f));
		this.quads[31] = new ObjQuad(new Vector3f(-0.3f, 0.0f, -0.4f),new Vector3f(0.3f, 0.0f, -0.4f),new Vector3f(0.3414f, -0.1f, -0.5f),new Vector3f(-0.3414f, -0.1f, -0.5f),new Vector2f(0.6875f, 0.1563f),new Vector2f(0.3125f, 0.1563f),new Vector2f(0.2866f, 0.0938f),new Vector2f(0.7134f, 0.0938f),new Vector3f(0.0f, 2.8284f, -2.8284f));
		this.quads[32] = new ObjQuad(new Vector3f(0.3f, 0.0f, -0.4f),new Vector3f(0.4f, 0.0f, -0.3f),new Vector3f(0.5f, -0.1f, -0.3414f),new Vector3f(0.3414f, -0.1f, -0.5f),new Vector2f(0.6875f, 0.75f),new Vector2f(0.75f, 0.6875f),new Vector2f(0.8125f, 0.7134f),new Vector2f(0.7134f, 0.8125f),new Vector3f(2.0f, 2.8284f, -2.0f));
		this.quads[33] = new ObjQuad(new Vector3f(0.4f, 0.0f, -0.3f),new Vector3f(0.4f, 0.0f, 0.3f),new Vector3f(0.5f, -0.1f, 0.3414f),new Vector3f(0.5f, -0.1f, -0.3414f),new Vector2f(0.6875f, 0.1563f),new Vector2f(0.3125f, 0.1563f),new Vector2f(0.2866f, 0.0938f),new Vector2f(0.7134f, 0.0938f),new Vector3f(2.8284f, 2.8284f, 0.0f));
		this.quads[34] = new ObjQuad(new Vector3f(0.4f, 0.0f, 0.3f),new Vector3f(0.3f, 0.0f, 0.4f),new Vector3f(0.3414f, -0.1f, 0.5f),new Vector3f(0.5f, -0.1f, 0.3414f),new Vector2f(0.75f, 0.3125f),new Vector2f(0.6875f, 0.25f),new Vector2f(0.7134f, 0.1875f),new Vector2f(0.8125f, 0.2866f),new Vector3f(2.0f, 2.8284f, 2.0f));
		this.quads[35] = new ObjQuad(new Vector3f(0.3f, 0.0f, 0.4f),new Vector3f(-0.3f, 0.0f, 0.4f),new Vector3f(-0.3414f, -0.1f, 0.5f),new Vector3f(0.3414f, -0.1f, 0.5f),new Vector2f(0.6875f, 0.1563f),new Vector2f(0.3125f, 0.1563f),new Vector2f(0.2866f, 0.0938f),new Vector2f(0.7134f, 0.0938f),new Vector3f(0.0f, 2.8284f, 2.8284f));
		this.quads[36] = new ObjQuad(new Vector3f(-0.3f, 0.0f, 0.4f),new Vector3f(-0.4f, 0.0f, 0.3f),new Vector3f(-0.5f, -0.1f, 0.3414f),new Vector3f(-0.3414f, -0.1f, 0.5f),new Vector2f(0.3125f, 0.25f),new Vector2f(0.25f, 0.3125f),new Vector2f(0.1875f, 0.2866f),new Vector2f(0.2866f, 0.1875f),new Vector3f(-2.0f, 2.8284f, 2.0f));
		this.quads[37] = new ObjQuad(new Vector3f(-0.1f, 0.35f, 0.6f),new Vector3f(-0.1f, 0.35f, -0.8f),new Vector3f(0.1f, 0.35f, -0.8f),new Vector3f(0.1f, 0.35f, 0.6f),new Vector2f(0.5625f, 0.125f),new Vector2f(0.5625f, 1.0f),new Vector2f(0.4375f, 1.0f),new Vector2f(0.4375f, 0.125f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[38] = new ObjQuad(new Vector3f(-0.1f, 0.85f, 0.6f),new Vector3f(0.1f, 0.85f, 0.6f),new Vector3f(0.1f, 0.85f, -0.8f),new Vector3f(-0.1f, 0.85f, -0.8f),new Vector2f(0.4375f, 0.125f),new Vector2f(0.5625f, 0.125f),new Vector2f(0.5625f, 1.0f),new Vector2f(0.4375f, 1.0f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[39] = new ObjQuad(new Vector3f(-0.05f, 0.55f, 0.8f),new Vector3f(0.05f, 0.55f, 0.8f),new Vector3f(0.05f, 0.65f, 0.8f),new Vector3f(-0.05f, 0.65f, 0.8f),new Vector2f(0.4687f, 0.5f),new Vector2f(0.5312f, 0.5f),new Vector2f(0.5312f, 0.5625f),new Vector2f(0.4687f, 0.5625f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[40] = new ObjQuad(new Vector3f(0.25f, 0.5f, 0.6f),new Vector3f(0.25f, 0.5f, -0.8f),new Vector3f(0.25f, 0.7f, -0.8f),new Vector3f(0.25f, 0.7f, 0.6f),new Vector2f(0.125f, 0.4688f),new Vector2f(1.0f, 0.4688f),new Vector2f(1.0f, 0.5938f),new Vector2f(0.125f, 0.5938f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[41] = new ObjQuad(new Vector3f(0.1f, 0.35f, -0.8f),new Vector3f(-0.1f, 0.35f, -0.8f),new Vector3f(-0.25f, 0.5f, -0.8f),new Vector3f(-0.1f, 0.85f, -0.8f),new Vector2f(0.4375f, 0.375f),new Vector2f(0.5625f, 0.375f),new Vector2f(0.6562f, 0.4688f),new Vector2f(0.5625f, 0.6875f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[42] = new ObjQuad(new Vector3f(-0.25f, 0.5f, -0.8f),new Vector3f(-0.25f, 0.7f, -0.8f),new Vector3f(-0.1f, 0.85f, -0.8f),new Vector2f(0.6562f, 0.4688f),new Vector2f(0.6562f, 0.5938f),new Vector2f(0.5625f, 0.6875f),new Vector3f(0.0f, 0.0f, -3.0f));
		this.quads[43] = new ObjQuad(new Vector3f(-0.1f, 0.85f, -0.8f),new Vector3f(0.1f, 0.85f, -0.8f),new Vector3f(0.25f, 0.7f, -0.8f),new Vector3f(0.1f, 0.35f, -0.8f),new Vector2f(0.5625f, 0.6875f),new Vector2f(0.4375f, 0.6875f),new Vector2f(0.3437f, 0.5938f),new Vector2f(0.4375f, 0.375f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[44] = new ObjQuad(new Vector3f(0.25f, 0.5f, -0.8f),new Vector3f(0.1f, 0.35f, -0.8f),new Vector3f(0.25f, 0.7f, -0.8f),new Vector2f(0.3437f, 0.4688f),new Vector2f(0.4375f, 0.375f),new Vector2f(0.3437f, 0.5938f),new Vector3f(0.0f, 0.0f, -3.0f));
		this.quads[45] = new ObjQuad(new Vector3f(-0.25f, 0.5f, -0.8f),new Vector3f(-0.25f, 0.5f, 0.6f),new Vector3f(-0.25f, 0.7f, 0.6f),new Vector3f(-0.25f, 0.7f, -0.8f),new Vector2f(0.0f, 0.4688f),new Vector2f(0.875f, 0.4688f),new Vector2f(0.875f, 0.5938f),new Vector2f(0.0f, 0.5938f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[46] = new ObjQuad(new Vector3f(0.1634f, 0.4366f, 0.6866f),new Vector3f(0.05f, 0.55f, 0.8f),new Vector3f(-0.05f, 0.55f, 0.8f),new Vector3f(-0.1f, 0.35f, 0.6f),new Vector2f(0.6021f, 0.4291f),new Vector2f(0.5312f, 0.5f),new Vector2f(0.4687f, 0.5f),new Vector2f(0.4375f, 0.375f),new Vector3f(0.0f, -2.8284f, 2.8284f));
		this.quads[47] = new ObjQuad(new Vector3f(-0.05f, 0.55f, 0.8f),new Vector3f(-0.1634f, 0.4366f, 0.6866f),new Vector3f(-0.1f, 0.35f, 0.6f),new Vector2f(0.4687f, 0.5f),new Vector2f(0.3979f, 0.4291f),new Vector2f(0.4375f, 0.375f),new Vector3f(0.0f, -2.1213f, 2.1213f));
		this.quads[48] = new ObjQuad(new Vector3f(0.1f, 0.35f, 0.6f),new Vector3f(0.1634f, 0.4366f, 0.6866f),new Vector3f(-0.1f, 0.35f, 0.6f),new Vector2f(0.5625f, 0.375f),new Vector2f(0.6021f, 0.4291f),new Vector2f(0.4375f, 0.375f),new Vector3f(0.0f, -2.1213f, 2.1213f));
		this.quads[49] = new ObjQuad(new Vector3f(-0.1634f, 0.7634f, 0.6866f),new Vector3f(-0.05f, 0.65f, 0.8f),new Vector3f(0.05f, 0.65f, 0.8f),new Vector3f(0.1f, 0.85f, 0.6f),new Vector2f(0.3979f, 0.6334f),new Vector2f(0.4687f, 0.5625f),new Vector2f(0.5312f, 0.5625f),new Vector2f(0.5625f, 0.6875f),new Vector3f(0.0f, 2.8284f, 2.8284f));
		this.quads[50] = new ObjQuad(new Vector3f(0.05f, 0.65f, 0.8f),new Vector3f(0.1634f, 0.7634f, 0.6866f),new Vector3f(0.1f, 0.85f, 0.6f),new Vector2f(0.5312f, 0.5625f),new Vector2f(0.6021f, 0.6334f),new Vector2f(0.5625f, 0.6875f),new Vector3f(0.0f, 2.1213f, 2.1213f));
		this.quads[51] = new ObjQuad(new Vector3f(-0.1f, 0.85f, 0.6f),new Vector3f(-0.1634f, 0.7634f, 0.6866f),new Vector3f(0.1f, 0.85f, 0.6f),new Vector2f(0.4375f, 0.6875f),new Vector2f(0.3979f, 0.6334f),new Vector2f(0.5625f, 0.6875f),new Vector3f(0.0f, 2.1213f, 2.1213f));
		this.quads[52] = new ObjQuad(new Vector3f(0.05f, 0.55f, 0.8f),new Vector3f(0.1634f, 0.4366f, 0.6866f),new Vector3f(0.25f, 0.5f, 0.6f),new Vector3f(0.1634f, 0.7634f, 0.6866f),new Vector2f(0.5312f, 0.5f),new Vector2f(0.6021f, 0.4291f),new Vector2f(0.6562f, 0.4688f),new Vector2f(0.6021f, 0.6334f),new Vector3f(2.8284f, 0.0f, 2.8284f));
		this.quads[53] = new ObjQuad(new Vector3f(0.25f, 0.5f, 0.6f),new Vector3f(0.25f, 0.7f, 0.6f),new Vector3f(0.1634f, 0.7634f, 0.6866f),new Vector2f(0.6562f, 0.4688f),new Vector2f(0.6562f, 0.5938f),new Vector2f(0.6021f, 0.6334f),new Vector3f(2.1213f, 0.0f, 2.1213f));
		this.quads[54] = new ObjQuad(new Vector3f(0.05f, 0.55f, 0.8f),new Vector3f(0.1634f, 0.7634f, 0.6866f),new Vector3f(0.05f, 0.65f, 0.8f),new Vector2f(0.5312f, 0.5f),new Vector2f(0.6021f, 0.6334f),new Vector2f(0.5312f, 0.5625f),new Vector3f(2.1213f, 0.0f, 2.1213f));
		this.quads[55] = new ObjQuad(new Vector3f(-0.05f, 0.65f, 0.8f),new Vector3f(-0.1634f, 0.7634f, 0.6866f),new Vector3f(-0.25f, 0.7f, 0.6f),new Vector3f(-0.1634f, 0.4366f, 0.6866f),new Vector2f(1.0f, 0.5625f),new Vector2f(0.9291f, 0.6334f),new Vector2f(0.875f, 0.5938f),new Vector2f(0.9291f, 0.4291f),new Vector3f(-2.8284f, 0.0f, 2.8284f));
		this.quads[56] = new ObjQuad(new Vector3f(-0.25f, 0.7f, 0.6f),new Vector3f(-0.25f, 0.5f, 0.6f),new Vector3f(-0.1634f, 0.4366f, 0.6866f),new Vector2f(0.875f, 0.5938f),new Vector2f(0.875f, 0.4688f),new Vector2f(0.9291f, 0.4291f),new Vector3f(-2.1213f, 0.0f, 2.1213f));
		this.quads[57] = new ObjQuad(new Vector3f(-0.05f, 0.65f, 0.8f),new Vector3f(-0.1634f, 0.4366f, 0.6866f),new Vector3f(-0.05f, 0.55f, 0.8f),new Vector2f(1.0f, 0.5625f),new Vector2f(0.9291f, 0.4291f),new Vector2f(1.0f, 0.5f),new Vector3f(-2.1213f, 0.0f, 2.1213f));
		this.quads[58] = new ObjQuad(new Vector3f(0.25f, 0.5f, 0.6f),new Vector3f(0.1634f, 0.4366f, 0.6866f),new Vector3f(0.1f, 0.35f, 0.6f),new Vector2f(0.3438f, 0.125f),new Vector2f(0.3979f, 0.0709f),new Vector2f(0.4375f, 0.125f),new Vector3f(2.0841f, -2.0841f, 0.55859995f));
		this.quads[59] = new ObjQuad(new Vector3f(0.25f, 0.7f, 0.6f),new Vector3f(0.1f, 0.85f, 0.6f),new Vector3f(0.1634f, 0.7634f, 0.6866f),new Vector2f(0.6562f, 0.125f),new Vector2f(0.5625f, 0.125f),new Vector2f(0.6021f, 0.0709f),new Vector3f(2.0841f, 2.0841f, 0.55859995f));
		this.quads[60] = new ObjQuad(new Vector3f(-0.1634f, 0.4366f, 0.6866f),new Vector3f(-0.25f, 0.5f, 0.6f),new Vector3f(-0.1f, 0.35f, 0.6f),new Vector2f(0.9291f, 0.4291f),new Vector2f(0.875f, 0.4688f),new Vector2f(0.875f, 0.375f),new Vector3f(-2.0841f, -2.0841f, 0.55859995f));
		this.quads[61] = new ObjQuad(new Vector3f(-0.1634f, 0.7634f, 0.6866f),new Vector3f(-0.1f, 0.85f, 0.6f),new Vector3f(-0.25f, 0.7f, 0.6f),new Vector2f(0.9291f, 0.6334f),new Vector2f(0.875f, 0.6875f),new Vector2f(0.875f, 0.5938f),new Vector3f(-2.0841f, 2.0841f, 0.55859995f));
		this.quads[62] = new ObjQuad(new Vector3f(-0.1f, 0.35f, 0.6f),new Vector3f(-0.25f, 0.5f, 0.6f),new Vector3f(-0.25f, 0.5f, -0.8f),new Vector3f(-0.1f, 0.35f, -0.8f),new Vector2f(0.875f, 0.375f),new Vector2f(0.875f, 0.4688f),new Vector2f(0.0f, 0.4688f),new Vector2f(0.0f, 0.375f),new Vector3f(-2.8284f, -2.8284f, 0.0f));
		this.quads[63] = new ObjQuad(new Vector3f(0.1f, 0.35f, -0.8f),new Vector3f(0.25f, 0.5f, -0.8f),new Vector3f(0.25f, 0.5f, 0.6f),new Vector3f(0.1f, 0.35f, 0.6f),new Vector2f(1.0f, 0.375f),new Vector2f(1.0f, 0.4688f),new Vector2f(0.125f, 0.4688f),new Vector2f(0.125f, 0.375f),new Vector3f(2.8284f, -2.8284f, 0.0f));
		this.quads[64] = new ObjQuad(new Vector3f(0.1f, 0.85f, 0.6f),new Vector3f(0.25f, 0.7f, 0.6f),new Vector3f(0.25f, 0.7f, -0.8f),new Vector3f(0.1f, 0.85f, -0.8f),new Vector2f(0.125f, 0.6875f),new Vector2f(0.125f, 0.5938f),new Vector2f(1.0f, 0.5938f),new Vector2f(1.0f, 0.6875f),new Vector3f(2.8284f, 2.8284f, 0.0f));
		this.quads[65] = new ObjQuad(new Vector3f(-0.1f, 0.85f, -0.8f),new Vector3f(-0.25f, 0.7f, -0.8f),new Vector3f(-0.25f, 0.7f, 0.6f),new Vector3f(-0.1f, 0.85f, 0.6f),new Vector2f(0.0f, 0.6875f),new Vector2f(0.0f, 0.5938f),new Vector2f(0.875f, 0.5938f),new Vector2f(0.875f, 0.6875f),new Vector3f(-2.8284f, 2.8284f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Hammer other = new Hammer();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

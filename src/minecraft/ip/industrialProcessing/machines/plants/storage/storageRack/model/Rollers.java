package ip.industrialProcessing.machines.plants.storage.storageRack.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Rollers extends ObjMesh{
	public Rollers(){
		this.quads = new ObjQuad[52];
		this.quads[0] = new ObjQuad(new Vector3f(0.1f, 0.8f, 0.8f),new Vector3f(0.1f, 1.1f, -0.8f),new Vector3f(0.4f, 1.1f, -0.8f),new Vector3f(0.4f, 0.8f, 0.8f),new Vector2f(0.4375f, 0.0f),new Vector2f(0.4375f, 1.0f),new Vector2f(0.25f, 1.0f),new Vector2f(0.25f, -0.0f),new Vector3f(0.0f, -3.9316f, -0.7372f));
		this.quads[1] = new ObjQuad(new Vector3f(0.4f, 0.9483f, 0.8184f),new Vector3f(0.4f, 0.9633f, 0.7384f),new Vector3f(0.1f, 0.9633f, 0.7384f),new Vector3f(0.1f, 0.9483f, 0.8184f),new Vector2f(0.75f, -0.0115f),new Vector2f(0.75f, 0.0385f),new Vector2f(0.5625f, 0.0385f),new Vector2f(0.5625f, -0.0115f),new Vector3f(0.0f, 3.9316f, 0.7372f));
		this.quads[2] = new ObjQuad(new Vector3f(0.1f, 0.8f, 0.8f),new Vector3f(0.4f, 0.8f, 0.8f),new Vector3f(0.4f, 0.85f, 0.8f),new Vector3f(0.1f, 0.85f, 0.8f),new Vector2f(0.5625f, 0.5f),new Vector2f(0.75f, 0.5f),new Vector2f(0.75f, 0.5313f),new Vector2f(0.5625f, 0.5313f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.4f, 0.8f, 0.8f),new Vector3f(0.4f, 1.1f, -0.8f),new Vector3f(0.4f, 1.15f, -0.8f),new Vector3f(0.4f, 0.865f, 0.72f),new Vector2f(-0.0f, 0.5f),new Vector2f(1.0f, 0.6875f),new Vector2f(1.0f, 0.7188f),new Vector2f(0.05f, 0.5406f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.4f, 0.8f, 0.8f),new Vector3f(0.4f, 0.865f, 0.72f),new Vector3f(0.4f, 0.85f, 0.8f),new Vector2f(-0.0f, 0.5f),new Vector2f(0.05f, 0.5406f),new Vector2f(-0.0f, 0.5313f),new Vector3f(3.0f, 0.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(0.4f, 1.1f, -0.8f),new Vector3f(0.1f, 1.1f, -0.8f),new Vector3f(0.1f, 1.15f, -0.8f),new Vector3f(0.4f, 1.15f, -0.8f),new Vector2f(0.25f, 0.6875f),new Vector2f(0.4375f, 0.6875f),new Vector2f(0.4375f, 0.7188f),new Vector2f(0.25f, 0.7188f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[6] = new ObjQuad(new Vector3f(0.1f, 1.1f, -0.8f),new Vector3f(0.1f, 0.8f, 0.8f),new Vector3f(0.1f, 0.85f, 0.8f),new Vector3f(0.1f, 0.865f, 0.72f),new Vector2f(0.0f, 0.6875f),new Vector2f(1.0f, 0.5f),new Vector2f(1.0f, 0.5313f),new Vector2f(0.95f, 0.5406f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(0.1f, 1.1f, -0.8f),new Vector3f(0.1f, 0.865f, 0.72f),new Vector3f(0.1f, 1.15f, -0.8f),new Vector2f(0.0f, 0.6875f),new Vector2f(0.95f, 0.5406f),new Vector2f(0.0f, 0.7188f),new Vector3f(-3.0f, 0.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(-0.4f, 0.8f, 0.8f),new Vector3f(-0.4f, 1.1f, -0.8f),new Vector3f(-0.1f, 1.1f, -0.8f),new Vector3f(-0.1f, 0.8f, 0.8f),new Vector2f(0.75f, 0.0f),new Vector2f(0.75f, 1.0f),new Vector2f(0.5625f, 1.0f),new Vector2f(0.5625f, 0.0f),new Vector3f(0.0f, -3.9316f, -0.7372f));
		this.quads[9] = new ObjQuad(new Vector3f(-0.1f, 0.9483f, 0.8184f),new Vector3f(-0.1f, 0.9633f, 0.7384f),new Vector3f(-0.4f, 0.9633f, 0.7384f),new Vector3f(-0.4f, 0.9483f, 0.8184f),new Vector2f(0.4375f, -0.0115f),new Vector2f(0.4375f, 0.0385f),new Vector2f(0.25f, 0.0385f),new Vector2f(0.25f, -0.0115f),new Vector3f(0.0f, 3.9316f, 0.7372f));
		this.quads[10] = new ObjQuad(new Vector3f(-0.4f, 0.8f, 0.8f),new Vector3f(-0.1f, 0.8f, 0.8f),new Vector3f(-0.1f, 0.85f, 0.8f),new Vector3f(-0.4f, 0.85f, 0.8f),new Vector2f(0.25f, 0.5f),new Vector2f(0.4375f, 0.5f),new Vector2f(0.4375f, 0.5313f),new Vector2f(0.25f, 0.5313f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[11] = new ObjQuad(new Vector3f(-0.1f, 0.8f, 0.8f),new Vector3f(-0.1f, 1.1f, -0.8f),new Vector3f(-0.1f, 1.15f, -0.8f),new Vector3f(-0.1f, 0.865f, 0.72f),new Vector2f(0.0f, 0.5f),new Vector2f(1.0f, 0.6875f),new Vector2f(1.0f, 0.7188f),new Vector2f(0.05f, 0.5406f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[12] = new ObjQuad(new Vector3f(-0.1f, 0.8f, 0.8f),new Vector3f(-0.1f, 0.865f, 0.72f),new Vector3f(-0.1f, 0.85f, 0.8f),new Vector2f(0.0f, 0.5f),new Vector2f(0.05f, 0.5406f),new Vector2f(0.0f, 0.5313f),new Vector3f(3.0f, 0.0f, 0.0f));
		this.quads[13] = new ObjQuad(new Vector3f(-0.1f, 1.1f, -0.8f),new Vector3f(-0.4f, 1.1f, -0.8f),new Vector3f(-0.4f, 1.15f, -0.8f),new Vector3f(-0.1f, 1.15f, -0.8f),new Vector2f(0.5625f, 0.6875f),new Vector2f(0.75f, 0.6875f),new Vector2f(0.75f, 0.7188f),new Vector2f(0.5625f, 0.7188f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[14] = new ObjQuad(new Vector3f(-0.4f, 1.1f, -0.8f),new Vector3f(-0.4f, 0.8f, 0.8f),new Vector3f(-0.4f, 0.85f, 0.8f),new Vector3f(-0.4f, 0.865f, 0.72f),new Vector2f(0.0f, 0.6875f),new Vector2f(1.0f, 0.5f),new Vector2f(1.0f, 0.5313f),new Vector2f(0.95f, 0.5406f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[15] = new ObjQuad(new Vector3f(-0.4f, 1.1f, -0.8f),new Vector3f(-0.4f, 0.865f, 0.72f),new Vector3f(-0.4f, 1.15f, -0.8f),new Vector2f(0.0f, 0.6875f),new Vector2f(0.95f, 0.5406f),new Vector2f(0.0f, 0.7188f),new Vector3f(-3.0f, 0.0f, 0.0f));
		this.quads[16] = new ObjQuad(new Vector3f(0.1f, 0.0f, 0.8f),new Vector3f(0.1f, 0.3f, -0.8f),new Vector3f(0.4f, 0.3f, -0.8f),new Vector3f(0.4f, 0.0f, 0.8f),new Vector2f(0.4375f, 0.0f),new Vector2f(0.4375f, 1.0f),new Vector2f(0.25f, 1.0f),new Vector2f(0.25f, -0.0f),new Vector3f(0.0f, -3.9316f, -0.7372f));
		this.quads[17] = new ObjQuad(new Vector3f(0.4f, 0.1483f, 0.8184f),new Vector3f(0.4f, 0.1633f, 0.7384f),new Vector3f(0.1f, 0.1633f, 0.7384f),new Vector3f(0.1f, 0.1483f, 0.8184f),new Vector2f(0.75f, -0.0115f),new Vector2f(0.75f, 0.0385f),new Vector2f(0.5625f, 0.0385f),new Vector2f(0.5625f, -0.0115f),new Vector3f(0.0f, 3.9316f, 0.7372f));
		this.quads[18] = new ObjQuad(new Vector3f(0.1f, 0.0f, 0.8f),new Vector3f(0.4f, 0.0f, 0.8f),new Vector3f(0.4f, 0.05f, 0.8f),new Vector3f(0.1f, 0.05f, 0.8f),new Vector2f(0.5625f, 0.0f),new Vector2f(0.75f, 0.0f),new Vector2f(0.75f, 0.0313f),new Vector2f(0.5625f, 0.0313f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[19] = new ObjQuad(new Vector3f(0.4f, 0.0f, 0.8f),new Vector3f(0.4f, 0.3f, -0.8f),new Vector3f(0.4f, 0.35f, -0.8f),new Vector3f(0.4f, 0.065f, 0.72f),new Vector2f(-0.0f, 0.0f),new Vector2f(1.0f, 0.1875f),new Vector2f(1.0f, 0.2188f),new Vector2f(0.05f, 0.0406f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[20] = new ObjQuad(new Vector3f(0.4f, 0.0f, 0.8f),new Vector3f(0.4f, 0.065f, 0.72f),new Vector3f(0.4f, 0.05f, 0.8f),new Vector2f(-0.0f, 0.0f),new Vector2f(0.05f, 0.0406f),new Vector2f(-0.0f, 0.0313f),new Vector3f(3.0f, 0.0f, 0.0f));
		this.quads[21] = new ObjQuad(new Vector3f(0.4f, 0.3f, -0.8f),new Vector3f(0.1f, 0.3f, -0.8f),new Vector3f(0.1f, 0.35f, -0.8f),new Vector3f(0.4f, 0.35f, -0.8f),new Vector2f(0.25f, 0.1875f),new Vector2f(0.4375f, 0.1875f),new Vector2f(0.4375f, 0.2188f),new Vector2f(0.25f, 0.2188f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[22] = new ObjQuad(new Vector3f(0.1f, 0.3f, -0.8f),new Vector3f(0.1f, 0.0f, 0.8f),new Vector3f(0.1f, 0.05f, 0.8f),new Vector3f(0.1f, 0.065f, 0.72f),new Vector2f(0.0f, 0.1875f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 0.0313f),new Vector2f(0.95f, 0.0406f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[23] = new ObjQuad(new Vector3f(0.1f, 0.3f, -0.8f),new Vector3f(0.1f, 0.065f, 0.72f),new Vector3f(0.1f, 0.35f, -0.8f),new Vector2f(0.0f, 0.1875f),new Vector2f(0.95f, 0.0406f),new Vector2f(0.0f, 0.2188f),new Vector3f(-3.0f, 0.0f, 0.0f));
		this.quads[24] = new ObjQuad(new Vector3f(-0.4f, 0.0f, 0.8f),new Vector3f(-0.4f, 0.3f, -0.8f),new Vector3f(-0.1f, 0.3f, -0.8f),new Vector3f(-0.1f, 0.0f, 0.8f),new Vector2f(0.75f, 0.0f),new Vector2f(0.75f, 1.0f),new Vector2f(0.5625f, 1.0f),new Vector2f(0.5625f, 0.0f),new Vector3f(0.0f, -3.9316f, -0.7372f));
		this.quads[25] = new ObjQuad(new Vector3f(-0.1f, 0.1483f, 0.8184f),new Vector3f(-0.1f, 0.1633f, 0.7384f),new Vector3f(-0.4f, 0.1633f, 0.7384f),new Vector3f(-0.4f, 0.1483f, 0.8184f),new Vector2f(0.4375f, -0.0115f),new Vector2f(0.4375f, 0.0385f),new Vector2f(0.25f, 0.0385f),new Vector2f(0.25f, -0.0115f),new Vector3f(0.0f, 3.9316f, 0.7372f));
		this.quads[26] = new ObjQuad(new Vector3f(-0.4f, 0.0f, 0.8f),new Vector3f(-0.1f, 0.0f, 0.8f),new Vector3f(-0.1f, 0.05f, 0.8f),new Vector3f(-0.4f, 0.05f, 0.8f),new Vector2f(0.25f, 0.0f),new Vector2f(0.4375f, 0.0f),new Vector2f(0.4375f, 0.0313f),new Vector2f(0.25f, 0.0313f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[27] = new ObjQuad(new Vector3f(-0.1f, 0.0f, 0.8f),new Vector3f(-0.1f, 0.3f, -0.8f),new Vector3f(-0.1f, 0.35f, -0.8f),new Vector3f(-0.1f, 0.065f, 0.72f),new Vector2f(0.0f, 0.0f),new Vector2f(1.0f, 0.1875f),new Vector2f(1.0f, 0.2188f),new Vector2f(0.05f, 0.0406f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[28] = new ObjQuad(new Vector3f(-0.1f, 0.0f, 0.8f),new Vector3f(-0.1f, 0.065f, 0.72f),new Vector3f(-0.1f, 0.05f, 0.8f),new Vector2f(0.0f, 0.0f),new Vector2f(0.05f, 0.0406f),new Vector2f(0.0f, 0.0313f),new Vector3f(3.0f, 0.0f, 0.0f));
		this.quads[29] = new ObjQuad(new Vector3f(-0.1f, 0.3f, -0.8f),new Vector3f(-0.4f, 0.3f, -0.8f),new Vector3f(-0.4f, 0.35f, -0.8f),new Vector3f(-0.1f, 0.35f, -0.8f),new Vector2f(0.5625f, 0.1875f),new Vector2f(0.75f, 0.1875f),new Vector2f(0.75f, 0.2188f),new Vector2f(0.5625f, 0.2188f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[30] = new ObjQuad(new Vector3f(-0.4f, 0.3f, -0.8f),new Vector3f(-0.4f, 0.0f, 0.8f),new Vector3f(-0.4f, 0.05f, 0.8f),new Vector3f(-0.4f, 0.065f, 0.72f),new Vector2f(0.0f, 0.1875f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 0.0313f),new Vector2f(0.95f, 0.0406f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[31] = new ObjQuad(new Vector3f(-0.4f, 0.3f, -0.8f),new Vector3f(-0.4f, 0.065f, 0.72f),new Vector3f(-0.4f, 0.35f, -0.8f),new Vector2f(0.0f, 0.1875f),new Vector2f(0.95f, 0.0406f),new Vector2f(0.0f, 0.2188f),new Vector3f(-3.0f, 0.0f, 0.0f));
		this.quads[32] = new ObjQuad(new Vector3f(0.4f, 1.15f, -0.8f),new Vector3f(0.1f, 1.15f, -0.8f),new Vector3f(0.1f, 0.865f, 0.72f),new Vector3f(0.4f, 0.865f, 0.72f),new Vector2f(0.75f, 1.0f),new Vector2f(0.5625f, 1.0f),new Vector2f(0.5625f, 0.05f),new Vector2f(0.75f, 0.05f),new Vector3f(0.0f, 3.9316f, 0.7372f));
		this.quads[33] = new ObjQuad(new Vector3f(-0.1f, 1.15f, -0.8f),new Vector3f(-0.4f, 1.15f, -0.8f),new Vector3f(-0.4f, 0.865f, 0.72f),new Vector3f(-0.1f, 0.865f, 0.72f),new Vector2f(0.4375f, 1.0f),new Vector2f(0.25f, 1.0f),new Vector2f(0.25f, 0.05f),new Vector2f(0.4375f, 0.05f),new Vector3f(0.0f, 3.9316f, 0.7372f));
		this.quads[34] = new ObjQuad(new Vector3f(0.4f, 0.35f, -0.8f),new Vector3f(0.1f, 0.35f, -0.8f),new Vector3f(0.1f, 0.065f, 0.72f),new Vector3f(0.4f, 0.065f, 0.72f),new Vector2f(0.75f, 1.0f),new Vector2f(0.5625f, 1.0f),new Vector2f(0.5625f, 0.05f),new Vector2f(0.75f, 0.05f),new Vector3f(0.0f, 3.9316f, 0.7372f));
		this.quads[35] = new ObjQuad(new Vector3f(-0.1f, 0.35f, -0.8f),new Vector3f(-0.4f, 0.35f, -0.8f),new Vector3f(-0.4f, 0.065f, 0.72f),new Vector3f(-0.1f, 0.065f, 0.72f),new Vector2f(0.4375f, 1.0f),new Vector2f(0.25f, 1.0f),new Vector2f(0.25f, 0.05f),new Vector2f(0.4375f, 0.05f),new Vector3f(0.0f, 3.9316f, 0.7372f));
		this.quads[36] = new ObjQuad(new Vector3f(0.1f, 0.85f, 0.8f),new Vector3f(0.4f, 0.85f, 0.8f),new Vector3f(0.4f, 0.9483f, 0.8184f),new Vector3f(0.1f, 0.9483f, 0.8184f),new Vector2f(0.5625f, 0.5313f),new Vector2f(0.75f, 0.5313f),new Vector2f(0.75f, 0.5927f),new Vector2f(0.5625f, 0.5927f),new Vector3f(0.0f, -0.7372f, 3.9316f));
		this.quads[37] = new ObjQuad(new Vector3f(0.4f, 0.85f, 0.8f),new Vector3f(0.4f, 0.865f, 0.72f),new Vector3f(0.4f, 0.9633f, 0.7384f),new Vector3f(0.4f, 0.9483f, 0.8184f),new Vector2f(-0.0f, 0.5313f),new Vector2f(0.05f, 0.5406f),new Vector2f(0.0385f, 0.6021f),new Vector2f(-0.0115f, 0.5927f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[38] = new ObjQuad(new Vector3f(0.4f, 0.865f, 0.72f),new Vector3f(0.1f, 0.865f, 0.72f),new Vector3f(0.1f, 0.9633f, 0.7384f),new Vector3f(0.4f, 0.9633f, 0.7384f),new Vector2f(0.25f, 0.5406f),new Vector2f(0.4375f, 0.5406f),new Vector2f(0.4375f, 0.6021f),new Vector2f(0.25f, 0.6021f),new Vector3f(0.0f, 0.7372f, -3.9316f));
		this.quads[39] = new ObjQuad(new Vector3f(0.1f, 0.865f, 0.72f),new Vector3f(0.1f, 0.85f, 0.8f),new Vector3f(0.1f, 0.9483f, 0.8184f),new Vector3f(0.1f, 0.9633f, 0.7384f),new Vector2f(0.95f, 0.5406f),new Vector2f(1.0f, 0.5313f),new Vector2f(1.0115f, 0.5927f),new Vector2f(0.9615f, 0.6021f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[40] = new ObjQuad(new Vector3f(-0.4f, 0.85f, 0.8f),new Vector3f(-0.1f, 0.85f, 0.8f),new Vector3f(-0.1f, 0.9483f, 0.8184f),new Vector3f(-0.4f, 0.9483f, 0.8184f),new Vector2f(0.25f, 0.5313f),new Vector2f(0.4375f, 0.5313f),new Vector2f(0.4375f, 0.5927f),new Vector2f(0.25f, 0.5927f),new Vector3f(0.0f, -0.7372f, 3.9316f));
		this.quads[41] = new ObjQuad(new Vector3f(-0.1f, 0.85f, 0.8f),new Vector3f(-0.1f, 0.865f, 0.72f),new Vector3f(-0.1f, 0.9633f, 0.7384f),new Vector3f(-0.1f, 0.9483f, 0.8184f),new Vector2f(0.0f, 0.5313f),new Vector2f(0.05f, 0.5406f),new Vector2f(0.0385f, 0.6021f),new Vector2f(-0.0115f, 0.5927f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[42] = new ObjQuad(new Vector3f(-0.1f, 0.865f, 0.72f),new Vector3f(-0.4f, 0.865f, 0.72f),new Vector3f(-0.4f, 0.9633f, 0.7384f),new Vector3f(-0.1f, 0.9633f, 0.7384f),new Vector2f(0.5625f, 0.5406f),new Vector2f(0.75f, 0.5406f),new Vector2f(0.75f, 0.6021f),new Vector2f(0.5625f, 0.6021f),new Vector3f(0.0f, 0.7372f, -3.9316f));
		this.quads[43] = new ObjQuad(new Vector3f(-0.4f, 0.865f, 0.72f),new Vector3f(-0.4f, 0.85f, 0.8f),new Vector3f(-0.4f, 0.9483f, 0.8184f),new Vector3f(-0.4f, 0.9633f, 0.7384f),new Vector2f(0.95f, 0.5406f),new Vector2f(1.0f, 0.5313f),new Vector2f(1.0115f, 0.5927f),new Vector2f(0.9615f, 0.6021f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[44] = new ObjQuad(new Vector3f(0.1f, 0.05f, 0.8f),new Vector3f(0.4f, 0.05f, 0.8f),new Vector3f(0.4f, 0.1483f, 0.8184f),new Vector3f(0.1f, 0.1483f, 0.8184f),new Vector2f(0.5625f, 0.0313f),new Vector2f(0.75f, 0.0313f),new Vector2f(0.75f, 0.0927f),new Vector2f(0.5625f, 0.0927f),new Vector3f(0.0f, -0.7372f, 3.9316f));
		this.quads[45] = new ObjQuad(new Vector3f(0.4f, 0.05f, 0.8f),new Vector3f(0.4f, 0.065f, 0.72f),new Vector3f(0.4f, 0.1633f, 0.7384f),new Vector3f(0.4f, 0.1483f, 0.8184f),new Vector2f(-0.0f, 0.0313f),new Vector2f(0.05f, 0.0406f),new Vector2f(0.0385f, 0.1021f),new Vector2f(-0.0115f, 0.0927f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[46] = new ObjQuad(new Vector3f(0.4f, 0.065f, 0.72f),new Vector3f(0.1f, 0.065f, 0.72f),new Vector3f(0.1f, 0.1633f, 0.7384f),new Vector3f(0.4f, 0.1633f, 0.7384f),new Vector2f(0.25f, 0.0406f),new Vector2f(0.4375f, 0.0406f),new Vector2f(0.4375f, 0.1021f),new Vector2f(0.25f, 0.1021f),new Vector3f(0.0f, 0.7372f, -3.9316f));
		this.quads[47] = new ObjQuad(new Vector3f(0.1f, 0.065f, 0.72f),new Vector3f(0.1f, 0.05f, 0.8f),new Vector3f(0.1f, 0.1483f, 0.8184f),new Vector3f(0.1f, 0.1633f, 0.7384f),new Vector2f(0.95f, 0.0406f),new Vector2f(1.0f, 0.0313f),new Vector2f(1.0115f, 0.0927f),new Vector2f(0.9615f, 0.1021f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[48] = new ObjQuad(new Vector3f(-0.4f, 0.05f, 0.8f),new Vector3f(-0.1f, 0.05f, 0.8f),new Vector3f(-0.1f, 0.1483f, 0.8184f),new Vector3f(-0.4f, 0.1483f, 0.8184f),new Vector2f(0.25f, 0.0313f),new Vector2f(0.4375f, 0.0313f),new Vector2f(0.4375f, 0.0927f),new Vector2f(0.25f, 0.0927f),new Vector3f(0.0f, -0.7372f, 3.9316f));
		this.quads[49] = new ObjQuad(new Vector3f(-0.1f, 0.05f, 0.8f),new Vector3f(-0.1f, 0.065f, 0.72f),new Vector3f(-0.1f, 0.1633f, 0.7384f),new Vector3f(-0.1f, 0.1483f, 0.8184f),new Vector2f(0.0f, 0.0313f),new Vector2f(0.05f, 0.0406f),new Vector2f(0.0385f, 0.1021f),new Vector2f(-0.0115f, 0.0927f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[50] = new ObjQuad(new Vector3f(-0.1f, 0.065f, 0.72f),new Vector3f(-0.4f, 0.065f, 0.72f),new Vector3f(-0.4f, 0.1633f, 0.7384f),new Vector3f(-0.1f, 0.1633f, 0.7384f),new Vector2f(0.5625f, 0.0406f),new Vector2f(0.75f, 0.0406f),new Vector2f(0.75f, 0.1021f),new Vector2f(0.5625f, 0.1021f),new Vector3f(0.0f, 0.7372f, -3.9316f));
		this.quads[51] = new ObjQuad(new Vector3f(-0.4f, 0.065f, 0.72f),new Vector3f(-0.4f, 0.05f, 0.8f),new Vector3f(-0.4f, 0.1483f, 0.8184f),new Vector3f(-0.4f, 0.1633f, 0.7384f),new Vector2f(0.95f, 0.0406f),new Vector2f(1.0f, 0.0313f),new Vector2f(1.0115f, 0.0927f),new Vector2f(0.9615f, 0.1021f),new Vector3f(-4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Rollers other = new Rollers();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

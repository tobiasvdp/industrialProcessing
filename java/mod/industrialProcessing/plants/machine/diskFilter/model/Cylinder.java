package mod.industrialProcessing.plants.machine.diskFilter.model;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Cylinder extends ObjMesh{
	public Cylinder(){
		this.quads = new ObjQuad[48];
		this.quads[0] = new ObjQuad(new Vector3f(-0.0f, 0.8f, 0.5f),new Vector3f(-0.0f, 1.05f, 0.433f),new Vector3f(-0.6f, 1.05f, 0.433f),new Vector3f(-0.6f, 0.8f, 0.5f),new Vector2f(0.0625f, 0.25f),new Vector2f(0.0625f, 0.0f),new Vector2f(0.8125f, 0.0f),new Vector2f(0.8125f, 0.25f),new Vector3f(0.0f, 1.0f, 3.7319999f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.0f, 1.05f, 0.433f),new Vector3f(-0.0f, 1.233f, 0.25f),new Vector3f(-0.6f, 1.233f, 0.25f),new Vector3f(-0.6f, 1.05f, 0.433f),new Vector2f(0.0625f, 0.75f),new Vector2f(0.0625f, 0.5f),new Vector2f(0.8125f, 0.5f),new Vector2f(0.8125f, 0.75f),new Vector3f(0.0f, 2.7319999f, 2.7319999f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.0f, 1.233f, 0.25f),new Vector3f(-0.0f, 1.3f, 0.0f),new Vector3f(-0.6f, 1.3f, -0.0f),new Vector3f(-0.6f, 1.233f, 0.25f),new Vector2f(0.0625f, 1.0f),new Vector2f(0.0625f, 0.75f),new Vector2f(0.8125f, 0.75f),new Vector2f(0.8125f, 1.0f),new Vector3f(0.0f, 3.7319999f, 1.0f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.0f, 1.3f, 0.0f),new Vector3f(0.0f, 1.233f, -0.25f),new Vector3f(-0.6f, 1.233f, -0.25f),new Vector3f(-0.6f, 1.3f, -0.0f),new Vector2f(0.0625f, 0.5f),new Vector2f(0.0625f, 0.25f),new Vector2f(0.8125f, 0.25f),new Vector2f(0.8125f, 0.5f),new Vector3f(0.0f, 3.7319999f, -1.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.0f, 1.233f, -0.25f),new Vector3f(0.0f, 1.05f, -0.433f),new Vector3f(-0.6f, 1.05f, -0.433f),new Vector3f(-0.6f, 1.233f, -0.25f),new Vector2f(0.0625f, 1.0f),new Vector2f(0.0625f, 0.75f),new Vector2f(0.8125f, 0.75f),new Vector2f(0.8125f, 1.0f),new Vector3f(0.0f, 2.7319999f, -2.7319999f));
		this.quads[5] = new ObjQuad(new Vector3f(0.0f, 1.05f, -0.433f),new Vector3f(0.0f, 0.8f, -0.5f),new Vector3f(-0.6f, 0.8f, -0.5f),new Vector3f(-0.6f, 1.05f, -0.433f),new Vector2f(0.0625f, 0.5f),new Vector2f(0.0625f, 0.25f),new Vector2f(0.8125f, 0.25f),new Vector2f(0.8125f, 0.5f),new Vector3f(0.0f, 1.0f, -3.7319999f));
		this.quads[6] = new ObjQuad(new Vector3f(0.0f, 0.8f, -0.5f),new Vector3f(0.0f, 0.55f, -0.433f),new Vector3f(-0.6f, 0.55f, -0.433f),new Vector3f(-0.6f, 0.8f, -0.5f),new Vector2f(0.0625f, 0.25f),new Vector2f(0.0625f, 0.0f),new Vector2f(0.8125f, 0.0f),new Vector2f(0.8125f, 0.25f),new Vector3f(0.0f, -1.0f, -3.7319999f));
		this.quads[7] = new ObjQuad(new Vector3f(0.0f, 0.55f, -0.433f),new Vector3f(0.0f, 0.367f, -0.25f),new Vector3f(-0.6f, 0.367f, -0.25f),new Vector3f(-0.6f, 0.55f, -0.433f),new Vector2f(0.0625f, 0.75f),new Vector2f(0.0625f, 0.5f),new Vector2f(0.8125f, 0.5f),new Vector2f(0.8125f, 0.75f),new Vector3f(0.0f, -2.7319999f, -2.7319999f));
		this.quads[8] = new ObjQuad(new Vector3f(0.0f, 0.367f, -0.25f),new Vector3f(0.0f, 0.3f, -0.0f),new Vector3f(-0.6f, 0.3f, -0.0f),new Vector3f(-0.6f, 0.367f, -0.25f),new Vector2f(0.0625f, 0.5f),new Vector2f(0.0625f, 0.25f),new Vector2f(0.8125f, 0.25f),new Vector2f(0.8125f, 0.5f),new Vector3f(0.0f, -3.7319999f, -1.0f));
		this.quads[9] = new ObjQuad(new Vector3f(0.0f, 0.3f, -0.0f),new Vector3f(-0.0f, 0.367f, 0.25f),new Vector3f(-0.6f, 0.367f, 0.25f),new Vector3f(-0.6f, 0.3f, -0.0f),new Vector2f(0.0625f, 0.75f),new Vector2f(0.0625f, 0.5f),new Vector2f(0.8125f, 0.5f),new Vector2f(0.8125f, 0.75f),new Vector3f(0.0f, -3.7319999f, 1.0f));
		this.quads[10] = new ObjQuad(new Vector3f(-0.0f, 0.367f, 0.25f),new Vector3f(-0.0f, 0.55f, 0.433f),new Vector3f(-0.6f, 0.55f, 0.433f),new Vector3f(-0.6f, 0.367f, 0.25f),new Vector2f(0.0625f, 0.75f),new Vector2f(0.0625f, 0.5f),new Vector2f(0.8125f, 0.5f),new Vector2f(0.8125f, 0.75f),new Vector3f(0.0f, -2.7319999f, 2.7319999f));
		this.quads[11] = new ObjQuad(new Vector3f(-0.0f, 0.55f, 0.433f),new Vector3f(-0.0f, 0.8f, 0.5f),new Vector3f(-0.6f, 0.8f, 0.5f),new Vector3f(-0.6f, 0.55f, 0.433f),new Vector2f(0.0625f, 0.5f),new Vector2f(0.0625f, 0.25f),new Vector2f(0.8125f, 0.25f),new Vector2f(0.8125f, 0.5f),new Vector3f(0.0f, -1.0f, 3.7319999f));
		this.quads[12] = new ObjQuad(new Vector3f(-0.6f, 0.8f, 0.5f),new Vector3f(-0.6f, 1.05f, 0.433f),new Vector3f(-0.6f, 0.9465f, 0.2537f),new Vector3f(-0.6f, 0.8f, 0.2929f),new Vector2f(0.75f, 0.25f),new Vector2f(0.75f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 0.25f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[13] = new ObjQuad(new Vector3f(-0.6f, 1.05f, 0.433f),new Vector3f(-0.6f, 1.233f, 0.25f),new Vector3f(-0.6f, 1.0537f, 0.1465f),new Vector3f(-0.6f, 0.9465f, 0.2537f),new Vector2f(0.75f, 0.75f),new Vector2f(0.75f, 0.5f),new Vector2f(1.0f, 0.5f),new Vector2f(1.0f, 0.75f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[14] = new ObjQuad(new Vector3f(-0.6f, 1.233f, 0.25f),new Vector3f(-0.6f, 1.3f, -0.0f),new Vector3f(-0.6f, 1.0929f, -0.0f),new Vector3f(-0.6f, 1.0537f, 0.1465f),new Vector2f(0.75f, 1.0f),new Vector2f(0.75f, 0.75f),new Vector2f(1.0f, 0.75f),new Vector2f(1.0f, 1.0f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[15] = new ObjQuad(new Vector3f(-0.6f, 1.3f, -0.0f),new Vector3f(-0.6f, 1.233f, -0.25f),new Vector3f(-0.6f, 1.0537f, -0.1465f),new Vector3f(-0.6f, 1.0929f, -0.0f),new Vector2f(0.75f, 0.5f),new Vector2f(0.75f, 0.25f),new Vector2f(1.0f, 0.25f),new Vector2f(1.0f, 0.5f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[16] = new ObjQuad(new Vector3f(-0.6f, 1.233f, -0.25f),new Vector3f(-0.6f, 1.05f, -0.433f),new Vector3f(-0.6f, 0.9465f, -0.2537f),new Vector3f(-0.6f, 1.0537f, -0.1465f),new Vector2f(0.75f, 1.0f),new Vector2f(0.75f, 0.75f),new Vector2f(1.0f, 0.75f),new Vector2f(1.0f, 1.0f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[17] = new ObjQuad(new Vector3f(-0.6f, 1.05f, -0.433f),new Vector3f(-0.6f, 0.8f, -0.5f),new Vector3f(-0.6f, 0.8f, -0.2929f),new Vector3f(-0.6f, 0.9465f, -0.2537f),new Vector2f(0.75f, 0.5f),new Vector2f(0.75f, 0.25f),new Vector2f(1.0f, 0.25f),new Vector2f(1.0f, 0.5f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[18] = new ObjQuad(new Vector3f(-0.6f, 0.8f, -0.5f),new Vector3f(-0.6f, 0.55f, -0.433f),new Vector3f(-0.6f, 0.6535f, -0.2537f),new Vector3f(-0.6f, 0.8f, -0.2929f),new Vector2f(0.75f, 0.25f),new Vector2f(0.75f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 0.25f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[19] = new ObjQuad(new Vector3f(-0.6f, 0.55f, -0.433f),new Vector3f(-0.6f, 0.367f, -0.25f),new Vector3f(-0.6f, 0.5463f, -0.1465f),new Vector3f(-0.6f, 0.6535f, -0.2537f),new Vector2f(0.75f, 0.75f),new Vector2f(0.75f, 0.5f),new Vector2f(1.0f, 0.5f),new Vector2f(1.0f, 0.75f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[20] = new ObjQuad(new Vector3f(-0.6f, 0.367f, -0.25f),new Vector3f(-0.6f, 0.3f, -0.0f),new Vector3f(-0.6f, 0.5071f, -0.0f),new Vector3f(-0.6f, 0.5463f, -0.1465f),new Vector2f(0.75f, 0.5f),new Vector2f(0.75f, 0.25f),new Vector2f(1.0f, 0.25f),new Vector2f(1.0f, 0.5f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[21] = new ObjQuad(new Vector3f(-0.6f, 0.3f, -0.0f),new Vector3f(-0.6f, 0.367f, 0.25f),new Vector3f(-0.6f, 0.5463f, 0.1465f),new Vector3f(-0.6f, 0.5071f, -0.0f),new Vector2f(0.75f, 0.75f),new Vector2f(0.75f, 0.5f),new Vector2f(1.0f, 0.5f),new Vector2f(1.0f, 0.75f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[22] = new ObjQuad(new Vector3f(-0.6f, 0.367f, 0.25f),new Vector3f(-0.6f, 0.55f, 0.433f),new Vector3f(-0.6f, 0.6535f, 0.2537f),new Vector3f(-0.6f, 0.5463f, 0.1465f),new Vector2f(0.75f, 0.75f),new Vector2f(0.75f, 0.5f),new Vector2f(1.0f, 0.5f),new Vector2f(1.0f, 0.75f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[23] = new ObjQuad(new Vector3f(-0.6f, 0.55f, 0.433f),new Vector3f(-0.6f, 0.8f, 0.5f),new Vector3f(-0.6f, 0.8f, 0.2929f),new Vector3f(-0.6f, 0.6535f, 0.2537f),new Vector2f(0.75f, 0.5f),new Vector2f(0.75f, 0.25f),new Vector2f(1.0f, 0.25f),new Vector2f(1.0f, 0.5f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[24] = new ObjQuad(new Vector3f(-0.0f, 0.8f, 0.5f),new Vector3f(0.6f, 0.8f, 0.5f),new Vector3f(0.6f, 1.05f, 0.433f),new Vector3f(-0.0f, 1.05f, 0.433f),new Vector2f(0.0625f, 0.25f),new Vector2f(0.8125f, 0.25f),new Vector2f(0.8125f, 0.0f),new Vector2f(0.0625f, 0.0f),new Vector3f(0.0f, 1.0f, 3.7319999f));
		this.quads[25] = new ObjQuad(new Vector3f(-0.0f, 1.05f, 0.433f),new Vector3f(0.6f, 1.05f, 0.433f),new Vector3f(0.6f, 1.233f, 0.25f),new Vector3f(-0.0f, 1.233f, 0.25f),new Vector2f(0.0625f, 0.75f),new Vector2f(0.8125f, 0.75f),new Vector2f(0.8125f, 0.5f),new Vector2f(0.0625f, 0.5f),new Vector3f(0.0f, 2.7319999f, 2.7319999f));
		this.quads[26] = new ObjQuad(new Vector3f(-0.0f, 1.233f, 0.25f),new Vector3f(0.6f, 1.233f, 0.25f),new Vector3f(0.6f, 1.3f, 0.0f),new Vector3f(-0.0f, 1.3f, 0.0f),new Vector2f(0.0625f, 1.0f),new Vector2f(0.8125f, 1.0f),new Vector2f(0.8125f, 0.75f),new Vector2f(0.0625f, 0.75f),new Vector3f(0.0f, 3.7319999f, 1.0f));
		this.quads[27] = new ObjQuad(new Vector3f(-0.0f, 1.3f, 0.0f),new Vector3f(0.6f, 1.3f, 0.0f),new Vector3f(0.6f, 1.233f, -0.25f),new Vector3f(0.0f, 1.233f, -0.25f),new Vector2f(0.0625f, 0.5f),new Vector2f(0.8125f, 0.5f),new Vector2f(0.8125f, 0.25f),new Vector2f(0.0625f, 0.25f),new Vector3f(0.0f, 3.7319999f, -1.0f));
		this.quads[28] = new ObjQuad(new Vector3f(0.0f, 1.233f, -0.25f),new Vector3f(0.6f, 1.233f, -0.25f),new Vector3f(0.6f, 1.05f, -0.433f),new Vector3f(0.0f, 1.05f, -0.433f),new Vector2f(0.0625f, 1.0f),new Vector2f(0.8125f, 1.0f),new Vector2f(0.8125f, 0.75f),new Vector2f(0.0625f, 0.75f),new Vector3f(0.0f, 2.7319999f, -2.7319999f));
		this.quads[29] = new ObjQuad(new Vector3f(0.0f, 1.05f, -0.433f),new Vector3f(0.6f, 1.05f, -0.433f),new Vector3f(0.6f, 0.8f, -0.5f),new Vector3f(0.0f, 0.8f, -0.5f),new Vector2f(0.0625f, 0.5f),new Vector2f(0.8125f, 0.5f),new Vector2f(0.8125f, 0.25f),new Vector2f(0.0625f, 0.25f),new Vector3f(0.0f, 1.0f, -3.7319999f));
		this.quads[30] = new ObjQuad(new Vector3f(0.0f, 0.8f, -0.5f),new Vector3f(0.6f, 0.8f, -0.5f),new Vector3f(0.6f, 0.55f, -0.433f),new Vector3f(0.0f, 0.55f, -0.433f),new Vector2f(0.0625f, 0.25f),new Vector2f(0.8125f, 0.25f),new Vector2f(0.8125f, 0.0f),new Vector2f(0.0625f, 0.0f),new Vector3f(0.0f, -1.0f, -3.7319999f));
		this.quads[31] = new ObjQuad(new Vector3f(0.0f, 0.55f, -0.433f),new Vector3f(0.6f, 0.55f, -0.433f),new Vector3f(0.6f, 0.367f, -0.25f),new Vector3f(0.0f, 0.367f, -0.25f),new Vector2f(0.0625f, 0.75f),new Vector2f(0.8125f, 0.75f),new Vector2f(0.8125f, 0.5f),new Vector2f(0.0625f, 0.5f),new Vector3f(0.0f, -2.7319999f, -2.7319999f));
		this.quads[32] = new ObjQuad(new Vector3f(0.0f, 0.367f, -0.25f),new Vector3f(0.6f, 0.367f, -0.25f),new Vector3f(0.6f, 0.3f, -0.0f),new Vector3f(0.0f, 0.3f, -0.0f),new Vector2f(0.0625f, 0.5f),new Vector2f(0.8125f, 0.5f),new Vector2f(0.8125f, 0.25f),new Vector2f(0.0625f, 0.25f),new Vector3f(0.0f, -3.7319999f, -1.0f));
		this.quads[33] = new ObjQuad(new Vector3f(0.0f, 0.3f, -0.0f),new Vector3f(0.6f, 0.3f, -0.0f),new Vector3f(0.6f, 0.367f, 0.25f),new Vector3f(-0.0f, 0.367f, 0.25f),new Vector2f(0.0625f, 0.75f),new Vector2f(0.8125f, 0.75f),new Vector2f(0.8125f, 0.5f),new Vector2f(0.0625f, 0.5f),new Vector3f(0.0f, -3.7319999f, 1.0f));
		this.quads[34] = new ObjQuad(new Vector3f(-0.0f, 0.367f, 0.25f),new Vector3f(0.6f, 0.367f, 0.25f),new Vector3f(0.6f, 0.55f, 0.433f),new Vector3f(-0.0f, 0.55f, 0.433f),new Vector2f(0.0625f, 0.75f),new Vector2f(0.8125f, 0.75f),new Vector2f(0.8125f, 0.5f),new Vector2f(0.0625f, 0.5f),new Vector3f(0.0f, -2.7319999f, 2.7319999f));
		this.quads[35] = new ObjQuad(new Vector3f(-0.0f, 0.55f, 0.433f),new Vector3f(0.6f, 0.55f, 0.433f),new Vector3f(0.6f, 0.8f, 0.5f),new Vector3f(-0.0f, 0.8f, 0.5f),new Vector2f(0.0625f, 0.5f),new Vector2f(0.8125f, 0.5f),new Vector2f(0.8125f, 0.25f),new Vector2f(0.0625f, 0.25f),new Vector3f(0.0f, -1.0f, 3.7319999f));
		this.quads[36] = new ObjQuad(new Vector3f(0.6f, 0.8f, 0.5f),new Vector3f(0.6f, 0.8f, 0.2929f),new Vector3f(0.6f, 0.9465f, 0.2537f),new Vector3f(0.6f, 1.05f, 0.433f),new Vector2f(0.75f, 0.25f),new Vector2f(1.0f, 0.25f),new Vector2f(1.0f, 0.0f),new Vector2f(0.75f, 0.0f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[37] = new ObjQuad(new Vector3f(0.6f, 1.05f, 0.433f),new Vector3f(0.6f, 0.9465f, 0.2537f),new Vector3f(0.6f, 1.0537f, 0.1465f),new Vector3f(0.6f, 1.233f, 0.25f),new Vector2f(0.75f, 0.75f),new Vector2f(1.0f, 0.75f),new Vector2f(1.0f, 0.5f),new Vector2f(0.75f, 0.5f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[38] = new ObjQuad(new Vector3f(0.6f, 1.233f, 0.25f),new Vector3f(0.6f, 1.0537f, 0.1465f),new Vector3f(0.6f, 1.0929f, 0.0f),new Vector3f(0.6f, 1.3f, 0.0f),new Vector2f(0.75f, 1.0f),new Vector2f(1.0f, 1.0f),new Vector2f(1.0f, 0.75f),new Vector2f(0.75f, 0.75f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[39] = new ObjQuad(new Vector3f(0.6f, 1.3f, 0.0f),new Vector3f(0.6f, 1.0929f, 0.0f),new Vector3f(0.6f, 1.0537f, -0.1465f),new Vector3f(0.6f, 1.233f, -0.25f),new Vector2f(0.75f, 0.5f),new Vector2f(1.0f, 0.5f),new Vector2f(1.0f, 0.25f),new Vector2f(0.75f, 0.25f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[40] = new ObjQuad(new Vector3f(0.6f, 1.233f, -0.25f),new Vector3f(0.6f, 1.0537f, -0.1465f),new Vector3f(0.6f, 0.9465f, -0.2537f),new Vector3f(0.6f, 1.05f, -0.433f),new Vector2f(0.75f, 1.0f),new Vector2f(1.0f, 1.0f),new Vector2f(1.0f, 0.75f),new Vector2f(0.75f, 0.75f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[41] = new ObjQuad(new Vector3f(0.6f, 1.05f, -0.433f),new Vector3f(0.6f, 0.9465f, -0.2537f),new Vector3f(0.6f, 0.8f, -0.2929f),new Vector3f(0.6f, 0.8f, -0.5f),new Vector2f(0.75f, 0.5f),new Vector2f(1.0f, 0.5f),new Vector2f(1.0f, 0.25f),new Vector2f(0.75f, 0.25f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[42] = new ObjQuad(new Vector3f(0.6f, 0.8f, -0.5f),new Vector3f(0.6f, 0.8f, -0.2929f),new Vector3f(0.6f, 0.6535f, -0.2537f),new Vector3f(0.6f, 0.55f, -0.433f),new Vector2f(0.75f, 0.25f),new Vector2f(1.0f, 0.25f),new Vector2f(1.0f, 0.0f),new Vector2f(0.75f, 0.0f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[43] = new ObjQuad(new Vector3f(0.6f, 0.55f, -0.433f),new Vector3f(0.6f, 0.6535f, -0.2537f),new Vector3f(0.6f, 0.5463f, -0.1465f),new Vector3f(0.6f, 0.367f, -0.25f),new Vector2f(0.75f, 0.75f),new Vector2f(1.0f, 0.75f),new Vector2f(1.0f, 0.5f),new Vector2f(0.75f, 0.5f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[44] = new ObjQuad(new Vector3f(0.6f, 0.367f, -0.25f),new Vector3f(0.6f, 0.5463f, -0.1465f),new Vector3f(0.6f, 0.5071f, 0.0f),new Vector3f(0.6f, 0.3f, -0.0f),new Vector2f(0.75f, 0.5f),new Vector2f(1.0f, 0.5f),new Vector2f(1.0f, 0.25f),new Vector2f(0.75f, 0.25f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[45] = new ObjQuad(new Vector3f(0.6f, 0.3f, -0.0f),new Vector3f(0.6f, 0.5071f, 0.0f),new Vector3f(0.6f, 0.5463f, 0.1465f),new Vector3f(0.6f, 0.367f, 0.25f),new Vector2f(0.75f, 0.75f),new Vector2f(1.0f, 0.75f),new Vector2f(1.0f, 0.5f),new Vector2f(0.75f, 0.5f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[46] = new ObjQuad(new Vector3f(0.6f, 0.367f, 0.25f),new Vector3f(0.6f, 0.5463f, 0.1465f),new Vector3f(0.6f, 0.6535f, 0.2537f),new Vector3f(0.6f, 0.55f, 0.433f),new Vector2f(0.75f, 0.75f),new Vector2f(1.0f, 0.75f),new Vector2f(1.0f, 0.5f),new Vector2f(0.75f, 0.5f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[47] = new ObjQuad(new Vector3f(0.6f, 0.55f, 0.433f),new Vector3f(0.6f, 0.6535f, 0.2537f),new Vector3f(0.6f, 0.8f, 0.2929f),new Vector3f(0.6f, 0.8f, 0.5f),new Vector2f(0.75f, 0.5f),new Vector2f(1.0f, 0.5f),new Vector2f(1.0f, 0.25f),new Vector2f(0.75f, 0.25f),new Vector3f(4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Cylinder other = new Cylinder();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}
package mod.industrialProcessing.plants.machine.classifier.model;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class ClassifierSpiral extends ObjMesh{
	public ClassifierSpiral(){
		this.quads = new ObjQuad[104];
		this.quads[0] = new ObjQuad(new Vector3f(0.0707f, 0.8293f, 0.7f),new Vector3f(0.0707f, 0.8293f, -0.7f),new Vector3f(0.1f, 0.9f, -0.7f),new Vector3f(0.1f, 0.9f, 0.7f),new Vector2f(0.4558f, 1.0f),new Vector2f(0.4558f, 0.125f),new Vector2f(0.5f, 0.125f),new Vector2f(0.5f, 1.0f),new Vector3f(3.4141998f, -1.4142f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.0f, 0.8f, 0.7f),new Vector3f(-0.0f, 0.8f, -0.7f),new Vector3f(0.0707f, 0.8293f, -0.7f),new Vector3f(0.0707f, 0.8293f, 0.7f),new Vector2f(0.5f, 1.0f),new Vector2f(0.5f, 0.125f),new Vector2f(0.5442f, 0.125f),new Vector2f(0.5442f, 1.0f),new Vector3f(1.4142f, -3.4141998f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.0707f, 0.8293f, 0.7f),new Vector3f(-0.0707f, 0.8293f, -0.7f),new Vector3f(-0.0f, 0.8f, -0.7f),new Vector3f(-0.0f, 0.8f, 0.7f),new Vector2f(0.4558f, 1.0f),new Vector2f(0.4558f, 0.125f),new Vector2f(0.5f, 0.125f),new Vector2f(0.5f, 1.0f),new Vector3f(-1.4142f, -3.4141998f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.1f, 0.9f, 0.7f),new Vector3f(-0.1f, 0.9f, -0.7f),new Vector3f(-0.0707f, 0.8293f, -0.7f),new Vector3f(-0.0707f, 0.8293f, 0.7f),new Vector2f(0.5f, 1.0f),new Vector2f(0.5f, 0.125f),new Vector2f(0.5442f, 0.125f),new Vector2f(0.5442f, 1.0f),new Vector3f(-3.4141998f, -1.4142f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.0707f, 0.9707f, 0.7f),new Vector3f(-0.0707f, 0.9707f, -0.7f),new Vector3f(-0.1f, 0.9f, -0.7f),new Vector3f(-0.1f, 0.9f, 0.7f),new Vector2f(0.4558f, 1.0f),new Vector2f(0.4558f, 0.125f),new Vector2f(0.5f, 0.125f),new Vector2f(0.5f, 1.0f),new Vector3f(-3.4141998f, 1.4142f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.0f, 1.0f, 0.7f),new Vector3f(-0.0f, 1.0f, -0.7f),new Vector3f(-0.0707f, 0.9707f, -0.7f),new Vector3f(-0.0707f, 0.9707f, 0.7f),new Vector2f(0.5f, 1.0f),new Vector2f(0.5f, 0.125f),new Vector2f(0.5442f, 0.125f),new Vector2f(0.5442f, 1.0f),new Vector3f(-1.4142f, 3.4141998f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(0.0707f, 0.9707f, 0.7f),new Vector3f(0.0707f, 0.9707f, -0.7f),new Vector3f(-0.0f, 1.0f, -0.7f),new Vector3f(-0.0f, 1.0f, 0.7f),new Vector2f(0.4558f, 1.0f),new Vector2f(0.4558f, 0.125f),new Vector2f(0.5f, 0.125f),new Vector2f(0.5f, 1.0f),new Vector3f(1.4142f, 3.4141998f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(0.1f, 0.9f, 0.7f),new Vector3f(0.1f, 0.9f, -0.7f),new Vector3f(0.0707f, 0.9707f, -0.7f),new Vector3f(0.0707f, 0.9707f, 0.7f),new Vector2f(0.5f, 1.0f),new Vector2f(0.5f, 0.125f),new Vector2f(0.5442f, 0.125f),new Vector2f(0.5442f, 1.0f),new Vector3f(3.4141998f, 1.4142f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(0.1f, 0.9f, -0.6f),new Vector3f(0.0707f, 0.8293f, -0.575f),new Vector3f(0.2828f, 0.6172f, -0.575f),new Vector3f(0.4f, 0.9f, -0.6f),new Vector2f(0.0642f, 0.2373f),new Vector2f(0.0642f, 0.1894f),new Vector2f(0.2374f, 0.1177f),new Vector2f(0.2374f, 0.309f),new Vector3f(0.1984f, 0.4788f, 3.9664f));
		this.quads[9] = new ObjQuad(new Vector3f(0.0f, 0.5f, -0.55f),new Vector3f(0.2828f, 0.6172f, -0.575f),new Vector3f(0.0707f, 0.8293f, -0.575f),new Vector3f(0.0f, 0.8f, -0.55f),new Vector2f(0.2348f, 0.6011f),new Vector2f(0.2348f, 0.7924f),new Vector2f(0.0616f, 0.7207f),new Vector2f(0.0616f, 0.6729f),new Vector3f(0.4788f, 0.1984f, 3.9664f));
		this.quads[10] = new ObjQuad(new Vector3f(-0.2828f, 0.6172f, -0.525f),new Vector3f(0.0f, 0.5f, -0.55f),new Vector3f(0.0f, 0.8f, -0.55f),new Vector3f(-0.0707f, 0.8293f, -0.525f),new Vector2f(0.4273f, 0.1217f),new Vector2f(0.4273f, 0.313f),new Vector2f(0.2541f, 0.2413f),new Vector2f(0.2541f, 0.1934f),new Vector3f(0.4788f, -0.1984f, 3.9664f));
		this.quads[11] = new ObjQuad(new Vector3f(-0.1f, 0.9f, -0.5f),new Vector3f(-0.4f, 0.9f, -0.5f),new Vector3f(-0.2828f, 0.6172f, -0.525f),new Vector3f(-0.0707f, 0.8293f, -0.525f),new Vector2f(0.2524f, 0.4305f),new Vector2f(0.4257f, 0.3588f),new Vector2f(0.4257f, 0.5501f),new Vector2f(0.2524f, 0.4784f),new Vector3f(0.1984f, -0.4788f, 3.9664f));
		this.quads[12] = new ObjQuad(new Vector3f(-0.1f, 0.9f, -0.5f),new Vector3f(-0.0707f, 0.9707f, -0.475f),new Vector3f(-0.2828f, 1.1828f, -0.475f),new Vector3f(-0.4f, 0.9f, -0.5f),new Vector2f(0.4232f, 0.0718f),new Vector2f(0.4232f, 0.1196f),new Vector2f(0.25f, 0.1913f),new Vector2f(0.25f, 0.0f),new Vector3f(-0.1984f, -0.4788f, 3.9664f));
		this.quads[13] = new ObjQuad(new Vector3f(-0.0707f, 0.9707f, -0.475f),new Vector3f(0.0f, 1.0f, -0.45f),new Vector3f(0.0f, 1.3f, -0.45f),new Vector3f(-0.2828f, 1.1828f, -0.475f),new Vector2f(0.4231f, 0.7939f),new Vector2f(0.4231f, 0.8417f),new Vector2f(0.2499f, 0.9135f),new Vector2f(0.2499f, 0.7221f),new Vector3f(-0.4788f, -0.1984f, 3.9664f));
		this.quads[14] = new ObjQuad(new Vector3f(0.0f, 1.0f, -0.45f),new Vector3f(0.0707f, 0.9707f, -0.425f),new Vector3f(0.2828f, 1.1828f, -0.425f),new Vector3f(0.0f, 1.3f, -0.45f),new Vector2f(0.2341f, 0.3138f),new Vector2f(0.2341f, 0.3616f),new Vector2f(0.0608f, 0.4334f),new Vector2f(0.0608f, 0.242f),new Vector3f(-0.4788f, 0.1984f, 3.9664f));
		this.quads[15] = new ObjQuad(new Vector3f(0.0707f, 0.9707f, -0.425f),new Vector3f(0.1f, 0.9f, -0.4f),new Vector3f(0.4f, 0.9f, -0.4f),new Vector3f(0.2828f, 1.1828f, -0.425f),new Vector2f(0.2365f, 0.5499f),new Vector2f(0.2365f, 0.5977f),new Vector2f(0.0633f, 0.6695f),new Vector2f(0.0633f, 0.4781f),new Vector3f(-0.1984f, 0.4788f, 3.9664f));
		this.quads[16] = new ObjQuad(new Vector3f(0.1f, 0.9f, 0.0f),new Vector3f(0.0707f, 0.8293f, 0.025f),new Vector3f(0.2828f, 0.6172f, 0.025f),new Vector3f(0.4f, 0.9f, 0.0f),new Vector2f(0.6267f, 0.2373f),new Vector2f(0.6267f, 0.1894f),new Vector2f(0.7999f, 0.1177f),new Vector2f(0.7999f, 0.309f),new Vector3f(0.1984f, 0.4788f, 3.9664f));
		this.quads[17] = new ObjQuad(new Vector3f(0.0f, 0.5f, 0.05f),new Vector3f(0.2828f, 0.6172f, 0.025f),new Vector3f(0.0707f, 0.8293f, 0.025f),new Vector3f(0.0f, 0.8f, 0.05f),new Vector2f(0.7973f, 0.6011f),new Vector2f(0.7973f, 0.7924f),new Vector2f(0.6241f, 0.7207f),new Vector2f(0.6241f, 0.6729f),new Vector3f(0.4788f, 0.1984f, 3.9664f));
		this.quads[18] = new ObjQuad(new Vector3f(-0.2828f, 0.6172f, 0.075f),new Vector3f(0.0f, 0.5f, 0.05f),new Vector3f(0.0f, 0.8f, 0.05f),new Vector3f(-0.0707f, 0.8293f, 0.075f),new Vector2f(0.4273f, 0.1217f),new Vector2f(0.4273f, 0.313f),new Vector2f(0.2541f, 0.2413f),new Vector2f(0.2541f, 0.1934f),new Vector3f(0.4788f, -0.1984f, 3.9664f));
		this.quads[19] = new ObjQuad(new Vector3f(-0.1f, 0.9f, 0.1f),new Vector3f(-0.4f, 0.9f, 0.1f),new Vector3f(-0.2828f, 0.6172f, 0.075f),new Vector3f(-0.0707f, 0.8293f, 0.075f),new Vector2f(0.2524f, 0.4305f),new Vector2f(0.4257f, 0.3588f),new Vector2f(0.4257f, 0.5501f),new Vector2f(0.2524f, 0.4784f),new Vector3f(0.1984f, -0.4788f, 3.9664f));
		this.quads[20] = new ObjQuad(new Vector3f(-0.1f, 0.9f, 0.1f),new Vector3f(-0.0707f, 0.9707f, 0.125f),new Vector3f(-0.2828f, 1.1828f, 0.125f),new Vector3f(-0.4f, 0.9f, 0.1f),new Vector2f(0.4232f, 0.0718f),new Vector2f(0.4232f, 0.1196f),new Vector2f(0.25f, 0.1913f),new Vector2f(0.25f, 0.0f),new Vector3f(-0.1984f, -0.4788f, 3.9664f));
		this.quads[21] = new ObjQuad(new Vector3f(-0.0707f, 0.9707f, 0.125f),new Vector3f(0.0f, 1.0f, 0.15f),new Vector3f(0.0f, 1.3f, 0.15f),new Vector3f(-0.2828f, 1.1828f, 0.125f),new Vector2f(0.7981f, 0.7939f),new Vector2f(0.7981f, 0.8417f),new Vector2f(0.6249f, 0.9135f),new Vector2f(0.6249f, 0.7221f),new Vector3f(-0.4788f, -0.1984f, 3.9664f));
		this.quads[22] = new ObjQuad(new Vector3f(0.0f, 1.0f, 0.15f),new Vector3f(0.0707f, 0.9707f, 0.175f),new Vector3f(0.2828f, 1.1828f, 0.175f),new Vector3f(0.0f, 1.3f, 0.15f),new Vector2f(0.7966f, 0.3138f),new Vector2f(0.7966f, 0.3616f),new Vector2f(0.6233f, 0.4334f),new Vector2f(0.6233f, 0.242f),new Vector3f(-0.4788f, 0.1984f, 3.9664f));
		this.quads[23] = new ObjQuad(new Vector3f(0.0707f, 0.9707f, 0.175f),new Vector3f(0.1f, 0.9f, 0.2f),new Vector3f(0.4f, 0.9f, 0.2f),new Vector3f(0.2828f, 1.1828f, 0.175f),new Vector2f(0.799f, 0.5499f),new Vector2f(0.799f, 0.5977f),new Vector2f(0.6258f, 0.6695f),new Vector2f(0.6258f, 0.4781f),new Vector3f(-0.1984f, 0.4788f, 3.9664f));
		this.quads[24] = new ObjQuad(new Vector3f(0.1f, 0.9f, -0.4f),new Vector3f(0.0707f, 0.8293f, -0.375f),new Vector3f(0.2828f, 0.6172f, -0.375f),new Vector3f(0.4f, 0.9f, -0.4f),new Vector2f(0.0642f, 0.2373f),new Vector2f(0.0642f, 0.1894f),new Vector2f(0.2374f, 0.1177f),new Vector2f(0.2374f, 0.309f),new Vector3f(0.1984f, 0.4788f, 3.9664f));
		this.quads[25] = new ObjQuad(new Vector3f(0.0f, 0.5f, -0.35f),new Vector3f(0.2828f, 0.6172f, -0.375f),new Vector3f(0.0707f, 0.8293f, -0.375f),new Vector3f(0.0f, 0.8f, -0.35f),new Vector2f(0.2348f, 0.6011f),new Vector2f(0.2348f, 0.7924f),new Vector2f(0.0616f, 0.7207f),new Vector2f(0.0616f, 0.6729f),new Vector3f(0.4788f, 0.1984f, 3.9664f));
		this.quads[26] = new ObjQuad(new Vector3f(-0.2828f, 0.6172f, -0.325f),new Vector3f(0.0f, 0.5f, -0.35f),new Vector3f(0.0f, 0.8f, -0.35f),new Vector3f(-0.0707f, 0.8293f, -0.325f),new Vector2f(0.4273f, 0.1217f),new Vector2f(0.4273f, 0.313f),new Vector2f(0.2541f, 0.2413f),new Vector2f(0.2541f, 0.1934f),new Vector3f(0.4788f, -0.1984f, 3.9664f));
		this.quads[27] = new ObjQuad(new Vector3f(-0.1f, 0.9f, -0.3f),new Vector3f(-0.4f, 0.9f, -0.3f),new Vector3f(-0.2828f, 0.6172f, -0.325f),new Vector3f(-0.0707f, 0.8293f, -0.325f),new Vector2f(0.2524f, 0.4305f),new Vector2f(0.4257f, 0.3588f),new Vector2f(0.4257f, 0.5501f),new Vector2f(0.2524f, 0.4784f),new Vector3f(0.1984f, -0.4788f, 3.9664f));
		this.quads[28] = new ObjQuad(new Vector3f(-0.1f, 0.9f, -0.3f),new Vector3f(-0.0707f, 0.9707f, -0.275f),new Vector3f(-0.2828f, 1.1828f, -0.275f),new Vector3f(-0.4f, 0.9f, -0.3f),new Vector2f(0.4232f, 0.0718f),new Vector2f(0.4232f, 0.1196f),new Vector2f(0.25f, 0.1913f),new Vector2f(0.25f, 0.0f),new Vector3f(-0.1984f, -0.4788f, 3.9664f));
		this.quads[29] = new ObjQuad(new Vector3f(-0.0707f, 0.9707f, -0.275f),new Vector3f(0.0f, 1.0f, -0.25f),new Vector3f(0.0f, 1.3f, -0.25f),new Vector3f(-0.2828f, 1.1828f, -0.275f),new Vector2f(0.2356f, 0.7939f),new Vector2f(0.2356f, 0.8417f),new Vector2f(0.0624f, 0.9135f),new Vector2f(0.0624f, 0.7221f),new Vector3f(-0.4788f, -0.1984f, 3.9664f));
		this.quads[30] = new ObjQuad(new Vector3f(0.0f, 1.0f, -0.25f),new Vector3f(0.0707f, 0.9707f, -0.225f),new Vector3f(0.2828f, 1.1828f, -0.225f),new Vector3f(0.0f, 1.3f, -0.25f),new Vector2f(0.2341f, 0.3138f),new Vector2f(0.2341f, 0.3616f),new Vector2f(0.0608f, 0.4334f),new Vector2f(0.0608f, 0.242f),new Vector3f(-0.4788f, 0.1984f, 3.9664f));
		this.quads[31] = new ObjQuad(new Vector3f(0.0707f, 0.9707f, -0.225f),new Vector3f(0.1f, 0.9f, -0.2f),new Vector3f(0.4f, 0.9f, -0.2f),new Vector3f(0.2828f, 1.1828f, -0.225f),new Vector2f(0.2365f, 0.5499f),new Vector2f(0.2365f, 0.5977f),new Vector2f(0.0633f, 0.6695f),new Vector2f(0.0633f, 0.4781f),new Vector3f(-0.1984f, 0.4788f, 3.9664f));
		this.quads[32] = new ObjQuad(new Vector3f(0.1f, 0.9f, 0.2f),new Vector3f(0.0707f, 0.8293f, 0.225f),new Vector3f(0.2828f, 0.6172f, 0.225f),new Vector3f(0.4f, 0.9f, 0.2f),new Vector2f(0.4392f, 0.2373f),new Vector2f(0.4392f, 0.1894f),new Vector2f(0.6124f, 0.1177f),new Vector2f(0.6124f, 0.309f),new Vector3f(0.1984f, 0.4788f, 3.9664f));
		this.quads[33] = new ObjQuad(new Vector3f(0.0f, 0.5f, 0.25f),new Vector3f(0.2828f, 0.6172f, 0.225f),new Vector3f(0.0707f, 0.8293f, 0.225f),new Vector3f(0.0f, 0.8f, 0.25f),new Vector2f(0.6098f, 0.6011f),new Vector2f(0.6098f, 0.7924f),new Vector2f(0.4366f, 0.7207f),new Vector2f(0.4366f, 0.6729f),new Vector3f(0.4788f, 0.1984f, 3.9664f));
		this.quads[34] = new ObjQuad(new Vector3f(-0.2828f, 0.6172f, 0.275f),new Vector3f(0.0f, 0.5f, 0.25f),new Vector3f(0.0f, 0.8f, 0.25f),new Vector3f(-0.0707f, 0.8293f, 0.275f),new Vector2f(0.4273f, 0.1217f),new Vector2f(0.4273f, 0.313f),new Vector2f(0.2541f, 0.2413f),new Vector2f(0.2541f, 0.1934f),new Vector3f(0.4788f, -0.1984f, 3.9664f));
		this.quads[35] = new ObjQuad(new Vector3f(-0.1f, 0.9f, 0.3f),new Vector3f(-0.4f, 0.9f, 0.3f),new Vector3f(-0.2828f, 0.6172f, 0.275f),new Vector3f(-0.0707f, 0.8293f, 0.275f),new Vector2f(0.2524f, 0.4305f),new Vector2f(0.4257f, 0.3588f),new Vector2f(0.4257f, 0.5501f),new Vector2f(0.2524f, 0.4784f),new Vector3f(0.1984f, -0.4788f, 3.9664f));
		this.quads[36] = new ObjQuad(new Vector3f(-0.1f, 0.9f, 0.3f),new Vector3f(-0.0707f, 0.9707f, 0.325f),new Vector3f(-0.2828f, 1.1828f, 0.325f),new Vector3f(-0.4f, 0.9f, 0.3f),new Vector2f(0.4232f, 0.0718f),new Vector2f(0.4232f, 0.1196f),new Vector2f(0.25f, 0.1913f),new Vector2f(0.25f, 0.0f),new Vector3f(-0.1984f, -0.4788f, 3.9664f));
		this.quads[37] = new ObjQuad(new Vector3f(-0.0707f, 0.9707f, 0.325f),new Vector3f(0.0f, 1.0f, 0.35f),new Vector3f(0.0f, 1.3f, 0.35f),new Vector3f(-0.2828f, 1.1828f, 0.325f),new Vector2f(0.6106f, 0.7939f),new Vector2f(0.6106f, 0.8417f),new Vector2f(0.4374f, 0.9135f),new Vector2f(0.4374f, 0.7221f),new Vector3f(-0.4788f, -0.1984f, 3.9664f));
		this.quads[38] = new ObjQuad(new Vector3f(0.0f, 1.0f, 0.35f),new Vector3f(0.0707f, 0.9707f, 0.375f),new Vector3f(0.2828f, 1.1828f, 0.375f),new Vector3f(0.0f, 1.3f, 0.35f),new Vector2f(0.6091f, 0.3138f),new Vector2f(0.6091f, 0.3616f),new Vector2f(0.4358f, 0.4334f),new Vector2f(0.4358f, 0.242f),new Vector3f(-0.4788f, 0.1984f, 3.9664f));
		this.quads[39] = new ObjQuad(new Vector3f(0.0707f, 0.9707f, 0.375f),new Vector3f(0.1f, 0.9f, 0.4f),new Vector3f(0.4f, 0.9f, 0.4f),new Vector3f(0.2828f, 1.1828f, 0.375f),new Vector2f(0.6115f, 0.5499f),new Vector2f(0.6115f, 0.5977f),new Vector2f(0.4383f, 0.6695f),new Vector2f(0.4383f, 0.4781f),new Vector3f(-0.1984f, 0.4788f, 3.9664f));
		this.quads[40] = new ObjQuad(new Vector3f(0.1f, 0.9f, -0.2f),new Vector3f(0.0707f, 0.8293f, -0.175f),new Vector3f(0.2828f, 0.6172f, -0.175f),new Vector3f(0.4f, 0.9f, -0.2f),new Vector2f(0.8142f, 0.2373f),new Vector2f(0.8142f, 0.1894f),new Vector2f(0.9874f, 0.1177f),new Vector2f(0.9874f, 0.309f),new Vector3f(0.1984f, 0.4788f, 3.9664f));
		this.quads[41] = new ObjQuad(new Vector3f(0.0f, 0.5f, -0.15f),new Vector3f(0.2828f, 0.6172f, -0.175f),new Vector3f(0.0707f, 0.8293f, -0.175f),new Vector3f(0.0f, 0.8f, -0.15f),new Vector2f(0.9848f, 0.6011f),new Vector2f(0.9848f, 0.7924f),new Vector2f(0.8116f, 0.7207f),new Vector2f(0.8116f, 0.6729f),new Vector3f(0.4788f, 0.1984f, 3.9664f));
		this.quads[42] = new ObjQuad(new Vector3f(-0.2828f, 0.6172f, -0.125f),new Vector3f(0.0f, 0.5f, -0.15f),new Vector3f(0.0f, 0.8f, -0.15f),new Vector3f(-0.0707f, 0.8293f, -0.125f),new Vector2f(0.4273f, 0.1217f),new Vector2f(0.4273f, 0.313f),new Vector2f(0.2541f, 0.2413f),new Vector2f(0.2541f, 0.1934f),new Vector3f(0.4788f, -0.1984f, 3.9664f));
		this.quads[43] = new ObjQuad(new Vector3f(-0.1f, 0.9f, -0.1f),new Vector3f(-0.4f, 0.9f, -0.1f),new Vector3f(-0.2828f, 0.6172f, -0.125f),new Vector3f(-0.0707f, 0.8293f, -0.125f),new Vector2f(0.2524f, 0.4305f),new Vector2f(0.4257f, 0.3588f),new Vector2f(0.4257f, 0.5501f),new Vector2f(0.2524f, 0.4784f),new Vector3f(0.1984f, -0.4788f, 3.9664f));
		this.quads[44] = new ObjQuad(new Vector3f(-0.1f, 0.9f, -0.1f),new Vector3f(-0.0707f, 0.9707f, -0.075f),new Vector3f(-0.2828f, 1.1828f, -0.075f),new Vector3f(-0.4f, 0.9f, -0.1f),new Vector2f(0.4232f, 0.0718f),new Vector2f(0.4232f, 0.1196f),new Vector2f(0.25f, 0.1913f),new Vector2f(0.25f, 0.0f),new Vector3f(-0.1984f, -0.4788f, 3.9664f));
		this.quads[45] = new ObjQuad(new Vector3f(-0.0707f, 0.9707f, -0.075f),new Vector3f(0.0f, 1.0f, -0.05f),new Vector3f(0.0f, 1.3f, -0.05f),new Vector3f(-0.2828f, 1.1828f, -0.075f),new Vector2f(0.9856f, 0.7939f),new Vector2f(0.9856f, 0.8417f),new Vector2f(0.8124f, 0.9135f),new Vector2f(0.8124f, 0.7221f),new Vector3f(-0.4788f, -0.1984f, 3.9664f));
		this.quads[46] = new ObjQuad(new Vector3f(0.0f, 1.0f, -0.05f),new Vector3f(0.0707f, 0.9707f, -0.025f),new Vector3f(0.2828f, 1.1828f, -0.025f),new Vector3f(0.0f, 1.3f, -0.05f),new Vector2f(0.9841f, 0.3138f),new Vector2f(0.9841f, 0.3616f),new Vector2f(0.8108f, 0.4334f),new Vector2f(0.8108f, 0.242f),new Vector3f(-0.4788f, 0.1984f, 3.9664f));
		this.quads[47] = new ObjQuad(new Vector3f(0.0707f, 0.9707f, -0.025f),new Vector3f(0.1f, 0.9f, 0.0f),new Vector3f(0.4f, 0.9f, 0.0f),new Vector3f(0.2828f, 1.1828f, -0.025f),new Vector2f(0.9865f, 0.5499f),new Vector2f(0.9865f, 0.5977f),new Vector2f(0.8133f, 0.6695f),new Vector2f(0.8133f, 0.4781f),new Vector3f(-0.1984f, 0.4788f, 3.9664f));
		this.quads[48] = new ObjQuad(new Vector3f(0.1f, 0.9f, 0.4f),new Vector3f(0.0707f, 0.8293f, 0.425f),new Vector3f(0.2828f, 0.6172f, 0.425f),new Vector3f(0.4f, 0.9f, 0.4f),new Vector2f(0.2517f, 0.2373f),new Vector2f(0.2517f, 0.1894f),new Vector2f(0.4249f, 0.1177f),new Vector2f(0.4249f, 0.309f),new Vector3f(0.1984f, 0.4788f, 3.9664f));
		this.quads[49] = new ObjQuad(new Vector3f(0.0f, 0.5f, 0.45f),new Vector3f(0.2828f, 0.6172f, 0.425f),new Vector3f(0.0707f, 0.8293f, 0.425f),new Vector3f(0.0f, 0.8f, 0.45f),new Vector2f(0.4223f, 0.6011f),new Vector2f(0.4223f, 0.7924f),new Vector2f(0.2491f, 0.7207f),new Vector2f(0.2491f, 0.6729f),new Vector3f(0.4788f, 0.1984f, 3.9664f));
		this.quads[50] = new ObjQuad(new Vector3f(-0.2828f, 0.6172f, 0.475f),new Vector3f(0.0f, 0.5f, 0.45f),new Vector3f(0.0f, 0.8f, 0.45f),new Vector3f(-0.0707f, 0.8293f, 0.475f),new Vector2f(0.4273f, 0.1217f),new Vector2f(0.4273f, 0.313f),new Vector2f(0.2541f, 0.2413f),new Vector2f(0.2541f, 0.1934f),new Vector3f(0.4788f, -0.1984f, 3.9664f));
		this.quads[51] = new ObjQuad(new Vector3f(-0.1f, 0.9f, 0.5f),new Vector3f(-0.4f, 0.9f, 0.5f),new Vector3f(-0.2828f, 0.6172f, 0.475f),new Vector3f(-0.0707f, 0.8293f, 0.475f),new Vector2f(0.2524f, 0.4305f),new Vector2f(0.4257f, 0.3588f),new Vector2f(0.4257f, 0.5501f),new Vector2f(0.2524f, 0.4784f),new Vector3f(0.1984f, -0.4788f, 3.9664f));
		this.quads[52] = new ObjQuad(new Vector3f(-0.1f, 0.9f, 0.5f),new Vector3f(-0.0707f, 0.9707f, 0.525f),new Vector3f(-0.2828f, 1.1828f, 0.525f),new Vector3f(-0.4f, 0.9f, 0.5f),new Vector2f(0.4232f, 0.0718f),new Vector2f(0.4232f, 0.1196f),new Vector2f(0.25f, 0.1913f),new Vector2f(0.25f, 0.0f),new Vector3f(-0.1984f, -0.4788f, 3.9664f));
		this.quads[53] = new ObjQuad(new Vector3f(-0.0707f, 0.9707f, 0.525f),new Vector3f(0.0f, 1.0f, 0.55f),new Vector3f(0.0f, 1.3f, 0.55f),new Vector3f(-0.2828f, 1.1828f, 0.525f),new Vector2f(0.4231f, 0.7939f),new Vector2f(0.4231f, 0.8417f),new Vector2f(0.2499f, 0.9135f),new Vector2f(0.2499f, 0.7221f),new Vector3f(-0.4788f, -0.1984f, 3.9664f));
		this.quads[54] = new ObjQuad(new Vector3f(0.0f, 1.0f, 0.55f),new Vector3f(0.0707f, 0.9707f, 0.575f),new Vector3f(0.2828f, 1.1828f, 0.575f),new Vector3f(0.0f, 1.3f, 0.55f),new Vector2f(0.4216f, 0.3138f),new Vector2f(0.4216f, 0.3616f),new Vector2f(0.2483f, 0.4334f),new Vector2f(0.2483f, 0.242f),new Vector3f(-0.4788f, 0.1984f, 3.9664f));
		this.quads[55] = new ObjQuad(new Vector3f(0.0707f, 0.9707f, 0.575f),new Vector3f(0.1f, 0.9f, 0.6f),new Vector3f(0.4f, 0.9f, 0.6f),new Vector3f(0.2828f, 1.1828f, 0.575f),new Vector2f(0.424f, 0.5499f),new Vector2f(0.424f, 0.5977f),new Vector2f(0.2508f, 0.6695f),new Vector2f(0.2508f, 0.4781f),new Vector3f(-0.1984f, 0.4788f, 3.9664f));
		this.quads[56] = new ObjQuad(new Vector3f(0.1f, 0.9f, -0.6f),new Vector3f(0.4f, 0.9f, -0.6f),new Vector3f(0.2828f, 0.6172f, -0.575f),new Vector3f(0.0707f, 0.8293f, -0.575f),new Vector2f(0.2517f, 0.2373f),new Vector2f(0.4249f, 0.309f),new Vector2f(0.4249f, 0.1177f),new Vector2f(0.2517f, 0.1894f),new Vector3f(-0.1984f, -0.4788f, -3.9664f));
		this.quads[57] = new ObjQuad(new Vector3f(0.0f, 0.5f, -0.55f),new Vector3f(0.0f, 0.8f, -0.55f),new Vector3f(0.0707f, 0.8293f, -0.575f),new Vector3f(0.2828f, 0.6172f, -0.575f),new Vector2f(0.2348f, 0.6011f),new Vector2f(0.0616f, 0.6729f),new Vector2f(0.0616f, 0.7207f),new Vector2f(0.2348f, 0.7924f),new Vector3f(-0.4788f, -0.1984f, -3.9664f));
		this.quads[58] = new ObjQuad(new Vector3f(-0.2828f, 0.6172f, -0.525f),new Vector3f(-0.0707f, 0.8293f, -0.525f),new Vector3f(0.0f, 0.8f, -0.55f),new Vector3f(0.0f, 0.5f, -0.55f),new Vector2f(0.2398f, 0.1217f),new Vector2f(0.0666f, 0.1934f),new Vector2f(0.0666f, 0.2413f),new Vector2f(0.2398f, 0.313f),new Vector3f(-0.4788f, 0.1984f, -3.9664f));
		this.quads[59] = new ObjQuad(new Vector3f(-0.1f, 0.9f, -0.5f),new Vector3f(-0.0707f, 0.8293f, -0.525f),new Vector3f(-0.2828f, 0.6172f, -0.525f),new Vector3f(-0.4f, 0.9f, -0.5f),new Vector2f(0.0649f, 0.4305f),new Vector2f(0.0649f, 0.4784f),new Vector2f(0.2382f, 0.5501f),new Vector2f(0.2382f, 0.3588f),new Vector3f(-0.1984f, 0.4788f, -3.9664f));
		this.quads[60] = new ObjQuad(new Vector3f(-0.1f, 0.9f, -0.5f),new Vector3f(-0.4f, 0.9f, -0.5f),new Vector3f(-0.2828f, 1.1828f, -0.475f),new Vector3f(-0.0707f, 0.9707f, -0.475f),new Vector2f(0.2357f, 0.0718f),new Vector2f(0.0625f, 0.0f),new Vector2f(0.0625f, 0.1913f),new Vector2f(0.2357f, 0.1196f),new Vector3f(0.1984f, 0.4788f, -3.9664f));
		this.quads[61] = new ObjQuad(new Vector3f(-0.0707f, 0.9707f, -0.475f),new Vector3f(-0.2828f, 1.1828f, -0.475f),new Vector3f(0.0f, 1.3f, -0.45f),new Vector3f(0.0f, 1.0f, -0.45f),new Vector2f(0.2356f, 0.7939f),new Vector2f(0.0624f, 0.7221f),new Vector2f(0.0624f, 0.9135f),new Vector2f(0.2356f, 0.8417f),new Vector3f(0.4788f, 0.1984f, -3.9664f));
		this.quads[62] = new ObjQuad(new Vector3f(0.0f, 1.0f, -0.45f),new Vector3f(0.0f, 1.3f, -0.45f),new Vector3f(0.2828f, 1.1828f, -0.425f),new Vector3f(0.0707f, 0.9707f, -0.425f),new Vector2f(0.4216f, 0.3138f),new Vector2f(0.2483f, 0.242f),new Vector2f(0.2483f, 0.4334f),new Vector2f(0.4216f, 0.3616f),new Vector3f(0.4788f, -0.1984f, -3.9664f));
		this.quads[63] = new ObjQuad(new Vector3f(0.0707f, 0.9707f, -0.425f),new Vector3f(0.2828f, 1.1828f, -0.425f),new Vector3f(0.4f, 0.9f, -0.4f),new Vector3f(0.1f, 0.9f, -0.4f),new Vector2f(0.424f, 0.5499f),new Vector2f(0.2508f, 0.4781f),new Vector2f(0.2508f, 0.6695f),new Vector2f(0.424f, 0.5977f),new Vector3f(0.1984f, -0.4788f, -3.9664f));
		this.quads[64] = new ObjQuad(new Vector3f(0.1f, 0.9f, 0.0f),new Vector3f(0.4f, 0.9f, 0.0f),new Vector3f(0.2828f, 0.6172f, 0.025f),new Vector3f(0.0707f, 0.8293f, 0.025f),new Vector2f(0.2517f, 0.2373f),new Vector2f(0.4249f, 0.309f),new Vector2f(0.4249f, 0.1177f),new Vector2f(0.2517f, 0.1894f),new Vector3f(-0.1984f, -0.4788f, -3.9664f));
		this.quads[65] = new ObjQuad(new Vector3f(-0.0f, 0.5f, 0.05f),new Vector3f(-0.0f, 0.8f, 0.05f),new Vector3f(0.0707f, 0.8293f, 0.025f),new Vector3f(0.2828f, 0.6172f, 0.025f),new Vector2f(0.7973f, 0.6011f),new Vector2f(0.6241f, 0.6729f),new Vector2f(0.6241f, 0.7207f),new Vector2f(0.7973f, 0.7924f),new Vector3f(-0.4788f, -0.1984f, -3.9664f));
		this.quads[66] = new ObjQuad(new Vector3f(-0.2828f, 0.6172f, 0.075f),new Vector3f(-0.0707f, 0.8293f, 0.075f),new Vector3f(-0.0f, 0.8f, 0.05f),new Vector3f(-0.0f, 0.5f, 0.05f),new Vector2f(0.8023f, 0.1217f),new Vector2f(0.6291f, 0.1934f),new Vector2f(0.6291f, 0.2413f),new Vector2f(0.8023f, 0.313f),new Vector3f(-0.4788f, 0.1984f, -3.9664f));
		this.quads[67] = new ObjQuad(new Vector3f(-0.1f, 0.9f, 0.1f),new Vector3f(-0.0707f, 0.8293f, 0.075f),new Vector3f(-0.2828f, 0.6172f, 0.075f),new Vector3f(-0.4f, 0.9f, 0.1f),new Vector2f(0.6274f, 0.4305f),new Vector2f(0.6274f, 0.4784f),new Vector2f(0.8007f, 0.5501f),new Vector2f(0.8007f, 0.3588f),new Vector3f(-0.1984f, 0.4788f, -3.9664f));
		this.quads[68] = new ObjQuad(new Vector3f(-0.1f, 0.9f, 0.1f),new Vector3f(-0.4f, 0.9f, 0.1f),new Vector3f(-0.2828f, 1.1828f, 0.125f),new Vector3f(-0.0707f, 0.9707f, 0.125f),new Vector2f(0.7982f, 0.0718f),new Vector2f(0.625f, 0.0f),new Vector2f(0.625f, 0.1913f),new Vector2f(0.7982f, 0.1196f),new Vector3f(0.1984f, 0.4788f, -3.9664f));
		this.quads[69] = new ObjQuad(new Vector3f(-0.0707f, 0.9707f, 0.125f),new Vector3f(-0.2828f, 1.1828f, 0.125f),new Vector3f(-0.0f, 1.3f, 0.15f),new Vector3f(-0.0f, 1.0f, 0.15f),new Vector2f(0.7981f, 0.7939f),new Vector2f(0.6249f, 0.7221f),new Vector2f(0.6249f, 0.9135f),new Vector2f(0.7981f, 0.8417f),new Vector3f(0.4788f, 0.1984f, -3.9664f));
		this.quads[70] = new ObjQuad(new Vector3f(-0.0f, 1.0f, 0.15f),new Vector3f(-0.0f, 1.3f, 0.15f),new Vector3f(0.2828f, 1.1828f, 0.175f),new Vector3f(0.0707f, 0.9707f, 0.175f),new Vector2f(0.4216f, 0.3138f),new Vector2f(0.2483f, 0.242f),new Vector2f(0.2483f, 0.4334f),new Vector2f(0.4216f, 0.3616f),new Vector3f(0.4788f, -0.1984f, -3.9664f));
		this.quads[71] = new ObjQuad(new Vector3f(0.0707f, 0.9707f, 0.175f),new Vector3f(0.2828f, 1.1828f, 0.175f),new Vector3f(0.4f, 0.9f, 0.2f),new Vector3f(0.1f, 0.9f, 0.2f),new Vector2f(0.424f, 0.5499f),new Vector2f(0.2508f, 0.4781f),new Vector2f(0.2508f, 0.6695f),new Vector2f(0.424f, 0.5977f),new Vector3f(0.1984f, -0.4788f, -3.9664f));
		this.quads[72] = new ObjQuad(new Vector3f(0.1f, 0.9f, -0.4f),new Vector3f(0.4f, 0.9f, -0.4f),new Vector3f(0.2828f, 0.6172f, -0.375f),new Vector3f(0.0707f, 0.8293f, -0.375f),new Vector2f(0.2517f, 0.2373f),new Vector2f(0.4249f, 0.309f),new Vector2f(0.4249f, 0.1177f),new Vector2f(0.2517f, 0.1894f),new Vector3f(-0.1984f, -0.4788f, -3.9664f));
		this.quads[73] = new ObjQuad(new Vector3f(0.0f, 0.5f, -0.35f),new Vector3f(0.0f, 0.8f, -0.35f),new Vector3f(0.0707f, 0.8293f, -0.375f),new Vector3f(0.2828f, 0.6172f, -0.375f),new Vector2f(0.2348f, 0.6011f),new Vector2f(0.0616f, 0.6729f),new Vector2f(0.0616f, 0.7207f),new Vector2f(0.2348f, 0.7924f),new Vector3f(-0.4788f, -0.1984f, -3.9664f));
		this.quads[74] = new ObjQuad(new Vector3f(-0.2828f, 0.6172f, -0.325f),new Vector3f(-0.0707f, 0.8293f, -0.325f),new Vector3f(0.0f, 0.8f, -0.35f),new Vector3f(0.0f, 0.5f, -0.35f),new Vector2f(0.2398f, 0.1217f),new Vector2f(0.0666f, 0.1934f),new Vector2f(0.0666f, 0.2413f),new Vector2f(0.2398f, 0.313f),new Vector3f(-0.4788f, 0.1984f, -3.9664f));
		this.quads[75] = new ObjQuad(new Vector3f(-0.1f, 0.9f, -0.3f),new Vector3f(-0.0707f, 0.8293f, -0.325f),new Vector3f(-0.2828f, 0.6172f, -0.325f),new Vector3f(-0.4f, 0.9f, -0.3f),new Vector2f(0.0649f, 0.4305f),new Vector2f(0.0649f, 0.4784f),new Vector2f(0.2382f, 0.5501f),new Vector2f(0.2382f, 0.3588f),new Vector3f(-0.1984f, 0.4788f, -3.9664f));
		this.quads[76] = new ObjQuad(new Vector3f(-0.1f, 0.9f, -0.3f),new Vector3f(-0.4f, 0.9f, -0.3f),new Vector3f(-0.2828f, 1.1828f, -0.275f),new Vector3f(-0.0707f, 0.9707f, -0.275f),new Vector2f(0.2357f, 0.0718f),new Vector2f(0.0625f, 0.0f),new Vector2f(0.0625f, 0.1913f),new Vector2f(0.2357f, 0.1196f),new Vector3f(0.1984f, 0.4788f, -3.9664f));
		this.quads[77] = new ObjQuad(new Vector3f(-0.0707f, 0.9707f, -0.275f),new Vector3f(-0.2828f, 1.1828f, -0.275f),new Vector3f(0.0f, 1.3f, -0.25f),new Vector3f(0.0f, 1.0f, -0.25f),new Vector2f(0.2356f, 0.7939f),new Vector2f(0.0624f, 0.7221f),new Vector2f(0.0624f, 0.9135f),new Vector2f(0.2356f, 0.8417f),new Vector3f(0.4788f, 0.1984f, -3.9664f));
		this.quads[78] = new ObjQuad(new Vector3f(0.0f, 1.0f, -0.25f),new Vector3f(0.0f, 1.3f, -0.25f),new Vector3f(0.2828f, 1.1828f, -0.225f),new Vector3f(0.0707f, 0.9707f, -0.225f),new Vector2f(0.4216f, 0.3138f),new Vector2f(0.2483f, 0.242f),new Vector2f(0.2483f, 0.4334f),new Vector2f(0.4216f, 0.3616f),new Vector3f(0.4788f, -0.1984f, -3.9664f));
		this.quads[79] = new ObjQuad(new Vector3f(0.0707f, 0.9707f, -0.225f),new Vector3f(0.2828f, 1.1828f, -0.225f),new Vector3f(0.4f, 0.9f, -0.2f),new Vector3f(0.1f, 0.9f, -0.2f),new Vector2f(0.424f, 0.5499f),new Vector2f(0.2508f, 0.4781f),new Vector2f(0.2508f, 0.6695f),new Vector2f(0.424f, 0.5977f),new Vector3f(0.1984f, -0.4788f, -3.9664f));
		this.quads[80] = new ObjQuad(new Vector3f(0.1f, 0.9f, 0.2f),new Vector3f(0.4f, 0.9f, 0.2f),new Vector3f(0.2828f, 0.6172f, 0.225f),new Vector3f(0.0707f, 0.8293f, 0.225f),new Vector2f(0.2517f, 0.2373f),new Vector2f(0.4249f, 0.309f),new Vector2f(0.4249f, 0.1177f),new Vector2f(0.2517f, 0.1894f),new Vector3f(-0.1984f, -0.4788f, -3.9664f));
		this.quads[81] = new ObjQuad(new Vector3f(-0.0f, 0.5f, 0.25f),new Vector3f(-0.0f, 0.8f, 0.25f),new Vector3f(0.0707f, 0.8293f, 0.225f),new Vector3f(0.2828f, 0.6172f, 0.225f),new Vector2f(0.6098f, 0.6011f),new Vector2f(0.4366f, 0.6729f),new Vector2f(0.4366f, 0.7207f),new Vector2f(0.6098f, 0.7924f),new Vector3f(-0.4788f, -0.1984f, -3.9664f));
		this.quads[82] = new ObjQuad(new Vector3f(-0.2828f, 0.6172f, 0.275f),new Vector3f(-0.0707f, 0.8293f, 0.275f),new Vector3f(-0.0f, 0.8f, 0.25f),new Vector3f(-0.0f, 0.5f, 0.25f),new Vector2f(0.6148f, 0.1217f),new Vector2f(0.4416f, 0.1934f),new Vector2f(0.4416f, 0.2413f),new Vector2f(0.6148f, 0.313f),new Vector3f(-0.4788f, 0.1984f, -3.9664f));
		this.quads[83] = new ObjQuad(new Vector3f(-0.1f, 0.9f, 0.3f),new Vector3f(-0.0707f, 0.8293f, 0.275f),new Vector3f(-0.2828f, 0.6172f, 0.275f),new Vector3f(-0.4f, 0.9f, 0.3f),new Vector2f(0.4399f, 0.4305f),new Vector2f(0.4399f, 0.4784f),new Vector2f(0.6132f, 0.5501f),new Vector2f(0.6132f, 0.3588f),new Vector3f(-0.1984f, 0.4788f, -3.9664f));
		this.quads[84] = new ObjQuad(new Vector3f(-0.1f, 0.9f, 0.3f),new Vector3f(-0.4f, 0.9f, 0.3f),new Vector3f(-0.2828f, 1.1828f, 0.325f),new Vector3f(-0.0707f, 0.9707f, 0.325f),new Vector2f(0.6107f, 0.0718f),new Vector2f(0.4375f, 0.0f),new Vector2f(0.4375f, 0.1913f),new Vector2f(0.6107f, 0.1196f),new Vector3f(0.1984f, 0.4788f, -3.9664f));
		this.quads[85] = new ObjQuad(new Vector3f(-0.0707f, 0.9707f, 0.325f),new Vector3f(-0.2828f, 1.1828f, 0.325f),new Vector3f(-0.0f, 1.3f, 0.35f),new Vector3f(-0.0f, 1.0f, 0.35f),new Vector2f(0.6106f, 0.7939f),new Vector2f(0.4374f, 0.7221f),new Vector2f(0.4374f, 0.9135f),new Vector2f(0.6106f, 0.8417f),new Vector3f(0.4788f, 0.1984f, -3.9664f));
		this.quads[86] = new ObjQuad(new Vector3f(-0.0f, 1.0f, 0.35f),new Vector3f(-0.0f, 1.3f, 0.35f),new Vector3f(0.2828f, 1.1828f, 0.375f),new Vector3f(0.0707f, 0.9707f, 0.375f),new Vector2f(0.4216f, 0.3138f),new Vector2f(0.2483f, 0.242f),new Vector2f(0.2483f, 0.4334f),new Vector2f(0.4216f, 0.3616f),new Vector3f(0.4788f, -0.1984f, -3.9664f));
		this.quads[87] = new ObjQuad(new Vector3f(0.0707f, 0.9707f, 0.375f),new Vector3f(0.2828f, 1.1828f, 0.375f),new Vector3f(0.4f, 0.9f, 0.4f),new Vector3f(0.1f, 0.9f, 0.4f),new Vector2f(0.424f, 0.5499f),new Vector2f(0.2508f, 0.4781f),new Vector2f(0.2508f, 0.6695f),new Vector2f(0.424f, 0.5977f),new Vector3f(0.1984f, -0.4788f, -3.9664f));
		this.quads[88] = new ObjQuad(new Vector3f(0.1f, 0.9f, -0.2f),new Vector3f(0.4f, 0.9f, -0.2f),new Vector3f(0.2828f, 0.6172f, -0.175f),new Vector3f(0.0707f, 0.8293f, -0.175f),new Vector2f(0.2517f, 0.2373f),new Vector2f(0.4249f, 0.309f),new Vector2f(0.4249f, 0.1177f),new Vector2f(0.2517f, 0.1894f),new Vector3f(-0.1984f, -0.4788f, -3.9664f));
		this.quads[89] = new ObjQuad(new Vector3f(-0.0f, 0.5f, -0.15f),new Vector3f(-0.0f, 0.8f, -0.15f),new Vector3f(0.0707f, 0.8293f, -0.175f),new Vector3f(0.2828f, 0.6172f, -0.175f),new Vector2f(0.9848f, 0.6011f),new Vector2f(0.8116f, 0.6729f),new Vector2f(0.8116f, 0.7207f),new Vector2f(0.9848f, 0.7924f),new Vector3f(-0.4788f, -0.1984f, -3.9664f));
		this.quads[90] = new ObjQuad(new Vector3f(-0.2828f, 0.6172f, -0.125f),new Vector3f(-0.0707f, 0.8293f, -0.125f),new Vector3f(-0.0f, 0.8f, -0.15f),new Vector3f(-0.0f, 0.5f, -0.15f),new Vector2f(0.9898f, 0.1217f),new Vector2f(0.8166f, 0.1934f),new Vector2f(0.8166f, 0.2413f),new Vector2f(0.9898f, 0.313f),new Vector3f(-0.4788f, 0.1984f, -3.9664f));
		this.quads[91] = new ObjQuad(new Vector3f(-0.1f, 0.9f, -0.1f),new Vector3f(-0.0707f, 0.8293f, -0.125f),new Vector3f(-0.2828f, 0.6172f, -0.125f),new Vector3f(-0.4f, 0.9f, -0.1f),new Vector2f(0.8149f, 0.4305f),new Vector2f(0.8149f, 0.4784f),new Vector2f(0.9882f, 0.5501f),new Vector2f(0.9882f, 0.3588f),new Vector3f(-0.1984f, 0.4788f, -3.9664f));
		this.quads[92] = new ObjQuad(new Vector3f(-0.1f, 0.9f, -0.1f),new Vector3f(-0.4f, 0.9f, -0.1f),new Vector3f(-0.2828f, 1.1828f, -0.075f),new Vector3f(-0.0707f, 0.9707f, -0.075f),new Vector2f(0.9857f, 0.0718f),new Vector2f(0.8125f, 0.0f),new Vector2f(0.8125f, 0.1913f),new Vector2f(0.9857f, 0.1196f),new Vector3f(0.1984f, 0.4788f, -3.9664f));
		this.quads[93] = new ObjQuad(new Vector3f(-0.0707f, 0.9707f, -0.075f),new Vector3f(-0.2828f, 1.1828f, -0.075f),new Vector3f(0.0f, 1.3f, -0.05f),new Vector3f(-0.0f, 1.0f, -0.05f),new Vector2f(0.9856f, 0.7939f),new Vector2f(0.8124f, 0.7221f),new Vector2f(0.8124f, 0.9135f),new Vector2f(0.9856f, 0.8417f),new Vector3f(0.4788f, 0.1984f, -3.9664f));
		this.quads[94] = new ObjQuad(new Vector3f(-0.0f, 1.0f, -0.05f),new Vector3f(0.0f, 1.3f, -0.05f),new Vector3f(0.2828f, 1.1828f, -0.025f),new Vector3f(0.0707f, 0.9707f, -0.025f),new Vector2f(0.4216f, 0.3138f),new Vector2f(0.2483f, 0.242f),new Vector2f(0.2483f, 0.4334f),new Vector2f(0.4216f, 0.3616f),new Vector3f(0.4788f, -0.1984f, -3.9664f));
		this.quads[95] = new ObjQuad(new Vector3f(0.0707f, 0.9707f, -0.025f),new Vector3f(0.2828f, 1.1828f, -0.025f),new Vector3f(0.4f, 0.9f, 0.0f),new Vector3f(0.1f, 0.9f, 0.0f),new Vector2f(0.424f, 0.5499f),new Vector2f(0.2508f, 0.4781f),new Vector2f(0.2508f, 0.6695f),new Vector2f(0.424f, 0.5977f),new Vector3f(0.1984f, -0.4788f, -3.9664f));
		this.quads[96] = new ObjQuad(new Vector3f(0.1f, 0.9f, 0.4f),new Vector3f(0.4f, 0.9f, 0.4f),new Vector3f(0.2828f, 0.6172f, 0.425f),new Vector3f(0.0707f, 0.8293f, 0.425f),new Vector2f(0.2517f, 0.2373f),new Vector2f(0.4249f, 0.309f),new Vector2f(0.4249f, 0.1177f),new Vector2f(0.2517f, 0.1894f),new Vector3f(-0.1984f, -0.4788f, -3.9664f));
		this.quads[97] = new ObjQuad(new Vector3f(-0.0f, 0.5f, 0.45f),new Vector3f(-0.0f, 0.8f, 0.45f),new Vector3f(0.0707f, 0.8293f, 0.425f),new Vector3f(0.2828f, 0.6172f, 0.425f),new Vector2f(0.4223f, 0.6011f),new Vector2f(0.2491f, 0.6729f),new Vector2f(0.2491f, 0.7207f),new Vector2f(0.4223f, 0.7924f),new Vector3f(-0.4788f, -0.1984f, -3.9664f));
		this.quads[98] = new ObjQuad(new Vector3f(-0.2828f, 0.6172f, 0.475f),new Vector3f(-0.0707f, 0.8293f, 0.475f),new Vector3f(-0.0f, 0.8f, 0.45f),new Vector3f(-0.0f, 0.5f, 0.45f),new Vector2f(0.4273f, 0.1217f),new Vector2f(0.2541f, 0.1934f),new Vector2f(0.2541f, 0.2413f),new Vector2f(0.4273f, 0.313f),new Vector3f(-0.4788f, 0.1984f, -3.9664f));
		this.quads[99] = new ObjQuad(new Vector3f(-0.1f, 0.9f, 0.5f),new Vector3f(-0.0707f, 0.8293f, 0.475f),new Vector3f(-0.2828f, 0.6172f, 0.475f),new Vector3f(-0.4f, 0.9f, 0.5f),new Vector2f(0.2524f, 0.4305f),new Vector2f(0.2524f, 0.4784f),new Vector2f(0.4257f, 0.5501f),new Vector2f(0.4257f, 0.3588f),new Vector3f(-0.1984f, 0.4788f, -3.9664f));
		this.quads[100] = new ObjQuad(new Vector3f(-0.1f, 0.9f, 0.5f),new Vector3f(-0.4f, 0.9f, 0.5f),new Vector3f(-0.2828f, 1.1828f, 0.525f),new Vector3f(-0.0707f, 0.9707f, 0.525f),new Vector2f(0.4232f, 0.0718f),new Vector2f(0.25f, 0.0f),new Vector2f(0.25f, 0.1913f),new Vector2f(0.4232f, 0.1196f),new Vector3f(0.1984f, 0.4788f, -3.9664f));
		this.quads[101] = new ObjQuad(new Vector3f(-0.0707f, 0.9707f, 0.525f),new Vector3f(-0.2828f, 1.1828f, 0.525f),new Vector3f(-0.0f, 1.3f, 0.55f),new Vector3f(-0.0f, 1.0f, 0.55f),new Vector2f(0.4231f, 0.7939f),new Vector2f(0.2499f, 0.7221f),new Vector2f(0.2499f, 0.9135f),new Vector2f(0.4231f, 0.8417f),new Vector3f(0.4788f, 0.1984f, -3.9664f));
		this.quads[102] = new ObjQuad(new Vector3f(-0.0f, 1.0f, 0.55f),new Vector3f(-0.0f, 1.3f, 0.55f),new Vector3f(0.2828f, 1.1828f, 0.575f),new Vector3f(0.0707f, 0.9707f, 0.575f),new Vector2f(0.4216f, 0.3138f),new Vector2f(0.2483f, 0.242f),new Vector2f(0.2483f, 0.4334f),new Vector2f(0.4216f, 0.3616f),new Vector3f(0.4788f, -0.1984f, -3.9664f));
		this.quads[103] = new ObjQuad(new Vector3f(0.0707f, 0.9707f, 0.575f),new Vector3f(0.2828f, 1.1828f, 0.575f),new Vector3f(0.4f, 0.9f, 0.6f),new Vector3f(0.1f, 0.9f, 0.6f),new Vector2f(0.424f, 0.5499f),new Vector2f(0.2508f, 0.4781f),new Vector2f(0.2508f, 0.6695f),new Vector2f(0.424f, 0.5977f),new Vector3f(0.1984f, -0.4788f, -3.9664f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		ClassifierSpiral other = new ClassifierSpiral();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

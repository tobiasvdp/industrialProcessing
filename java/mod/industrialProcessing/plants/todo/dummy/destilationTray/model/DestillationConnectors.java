package mod.industrialProcessing.plants.todo.dummy.destilationTray.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class DestillationConnectors extends ObjMesh{
	public DestillationConnectors(){
		this.quads = new ObjQuad[78];
		this.quads[0] = new ObjQuad(new Vector3f(0.354778f, 1.55f, 0.148305f),new Vector3f(0.354778f, 1.55f, -0.14523f),new Vector3f(0.147218f, 1.55f, -0.35279f),new Vector3f(-0.146317f, 1.55f, -0.35279f),new Vector2f(0.721455f, 0.40827f),new Vector2f(0.721455f, 0.59173f),new Vector2f(0.59173f, 0.721455f),new Vector2f(0.40827f, 0.721455f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.147218f, 1.55f, 0.355865f),new Vector3f(0.354778f, 1.55f, 0.148305f),new Vector3f(-0.146317f, 1.55f, -0.35279f),new Vector3f(-0.353877f, 1.55f, -0.14523f),new Vector2f(0.59173f, 0.278545f),new Vector2f(0.721455f, 0.40827f),new Vector2f(0.40827f, 0.721455f),new Vector2f(0.278545f, 0.59173f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.146317f, 1.55f, 0.355865f),new Vector3f(0.147218f, 1.55f, 0.355865f),new Vector3f(-0.353877f, 1.55f, -0.14523f),new Vector3f(-0.353877f, 1.55f, 0.148305f),new Vector2f(0.40827f, 0.278545f),new Vector2f(0.59173f, 0.278545f),new Vector2f(0.278545f, 0.59173f),new Vector2f(0.278545f, 0.40827f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.22916f, 1.5f, 0.555865f),new Vector3f(0.230061f, 1.5f, 0.555865f),new Vector3f(0.230061f, 1.6f, 0.555865f),new Vector3f(-0.22916f, 1.6f, 0.555865f),new Vector2f(0.751358f, 0.989953f),new Vector2f(0.751358f, 0.702824f),new Vector2f(0.813071f, 0.702824f),new Vector2f(0.813071f, 0.989953f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.230061f, 1.5f, 0.555865f),new Vector3f(0.554778f, 1.5f, 0.231147f),new Vector3f(0.554778f, 1.6f, 0.231147f),new Vector3f(0.230061f, 1.6f, 0.555865f),new Vector2f(0.749962f, 0.673967f),new Vector2f(0.749961f, 0.386838f),new Vector2f(0.811675f, 0.386838f),new Vector2f(0.811675f, 0.673967f),new Vector3f(2.828428f, 0.0f, 2.828428f));
		this.quads[5] = new ObjQuad(new Vector3f(0.554778f, 1.5f, -0.228073f),new Vector3f(0.554778f, 1.6f, -0.228073f),new Vector3f(0.554778f, 1.6f, 0.231147f),new Vector3f(0.554778f, 1.5f, 0.231147f),new Vector2f(0.751358f, 0.703621f),new Vector2f(0.813071f, 0.703621f),new Vector2f(0.813071f, 0.990749f),new Vector2f(0.751358f, 0.990749f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(0.23006f, 1.5f, -0.55279f),new Vector3f(0.23006f, 1.6f, -0.55279f),new Vector3f(0.554778f, 1.6f, -0.228073f),new Vector3f(0.554778f, 1.5f, -0.228073f),new Vector2f(0.749961f, 0.387635f),new Vector2f(0.811675f, 0.387635f),new Vector2f(0.811675f, 0.674763f),new Vector2f(0.749962f, 0.674763f),new Vector3f(2.828428f, 0.0f, -2.828428f));
		this.quads[7] = new ObjQuad(new Vector3f(0.23006f, 1.5f, -0.55279f),new Vector3f(-0.22916f, 1.5f, -0.55279f),new Vector3f(-0.22916f, 1.6f, -0.55279f),new Vector3f(0.23006f, 1.6f, -0.55279f),new Vector2f(0.751358f, 0.989953f),new Vector2f(0.751358f, 0.702824f),new Vector2f(0.813071f, 0.702824f),new Vector2f(0.813071f, 0.989953f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[8] = new ObjQuad(new Vector3f(-0.22916f, 1.5f, -0.55279f),new Vector3f(-0.553877f, 1.5f, -0.228072f),new Vector3f(-0.553877f, 1.6f, -0.228072f),new Vector3f(-0.22916f, 1.6f, -0.55279f),new Vector2f(0.749962f, 0.673967f),new Vector2f(0.749961f, 0.386838f),new Vector2f(0.811675f, 0.386838f),new Vector2f(0.811675f, 0.673967f),new Vector3f(-2.828428f, 0.0f, -2.828428f));
		this.quads[9] = new ObjQuad(new Vector3f(-0.553877f, 1.5f, 0.231148f),new Vector3f(-0.553877f, 1.6f, 0.231148f),new Vector3f(-0.553877f, 1.6f, -0.228072f),new Vector3f(-0.553877f, 1.5f, -0.228072f),new Vector2f(0.751358f, 0.702028f),new Vector2f(0.813071f, 0.702028f),new Vector2f(0.813071f, 0.989157f),new Vector2f(0.751358f, 0.989157f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[10] = new ObjQuad(new Vector3f(-0.22916f, 1.5f, 0.555865f),new Vector3f(-0.22916f, 1.6f, 0.555865f),new Vector3f(-0.553877f, 1.6f, 0.231148f),new Vector3f(-0.553877f, 1.5f, 0.231148f),new Vector2f(0.749961f, 0.386042f),new Vector2f(0.811675f, 0.386042f),new Vector2f(0.811675f, 0.673171f),new Vector2f(0.749962f, 0.673171f),new Vector3f(-2.828428f, 0.0f, 2.828428f));
		this.quads[11] = new ObjQuad(new Vector3f(-0.553877f, 1.6f, -0.228072f),new Vector3f(-0.553877f, 1.6f, 0.231148f),new Vector3f(-0.453877f, 1.6f, 0.189726f),new Vector3f(-0.453877f, 1.6f, -0.186651f),new Vector2f(1.0f, 0.453369f),new Vector2f(1.0f, 0.740382f),new Vector2f(0.9375f, 0.714493f),new Vector2f(0.9375f, 0.479258f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[12] = new ObjQuad(new Vector3f(-0.553877f, 1.6f, 0.231148f),new Vector3f(-0.22916f, 1.6f, 0.555865f),new Vector3f(-0.187738f, 1.6f, 0.455865f),new Vector3f(-0.453877f, 1.6f, 0.189726f),new Vector2f(1.0f, 0.1223f),new Vector2f(1.0f, 0.409312f),new Vector2f(0.9375f, 0.383424f),new Vector2f(0.9375f, 0.148188f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[13] = new ObjQuad(new Vector3f(-0.22916f, 1.6f, 0.555865f),new Vector3f(0.230061f, 1.6f, 0.555865f),new Vector3f(0.188639f, 1.6f, 0.455865f),new Vector3f(-0.187738f, 1.6f, 0.455865f),new Vector2f(1.0f, 0.002138f),new Vector2f(1.0f, 0.289151f),new Vector2f(0.9375f, 0.263263f),new Vector2f(0.9375f, 0.028027f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[14] = new ObjQuad(new Vector3f(0.230061f, 1.6f, 0.555865f),new Vector3f(0.554778f, 1.6f, 0.231147f),new Vector3f(0.454778f, 1.6f, 0.189726f),new Vector3f(0.188639f, 1.6f, 0.455865f),new Vector2f(1.0f, 0.262884f),new Vector2f(1.0f, 0.549896f),new Vector2f(0.9375f, 0.524008f),new Vector2f(0.9375f, 0.288772f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[15] = new ObjQuad(new Vector3f(0.554778f, 1.6f, 0.231147f),new Vector3f(0.554778f, 1.6f, -0.228073f),new Vector3f(0.454778f, 1.6f, -0.186651f),new Vector3f(0.454778f, 1.6f, 0.189726f),new Vector2f(1.0f, 0.574926f),new Vector2f(1.0f, 0.861938f),new Vector2f(0.9375f, 0.83605f),new Vector2f(0.9375f, 0.600814f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[16] = new ObjQuad(new Vector3f(0.554778f, 1.6f, -0.228073f),new Vector3f(0.23006f, 1.6f, -0.55279f),new Vector3f(0.188639f, 1.6f, -0.45279f),new Vector3f(0.454778f, 1.6f, -0.186651f),new Vector2f(1.0f, 0.38694f),new Vector2f(1.0f, 0.673953f),new Vector2f(0.9375f, 0.648065f),new Vector2f(0.9375f, 0.412829f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[17] = new ObjQuad(new Vector3f(0.23006f, 1.6f, -0.55279f),new Vector3f(-0.22916f, 1.6f, -0.55279f),new Vector3f(-0.187738f, 1.6f, -0.45279f),new Vector3f(0.188639f, 1.6f, -0.45279f),new Vector2f(1.0f, 0.32047f),new Vector2f(1.0f, 0.607482f),new Vector2f(0.9375f, 0.581594f),new Vector2f(0.9375f, 0.346358f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[18] = new ObjQuad(new Vector3f(-0.22916f, 1.6f, -0.55279f),new Vector3f(-0.553877f, 1.6f, -0.228072f),new Vector3f(-0.453877f, 1.6f, -0.186651f),new Vector3f(-0.187738f, 1.6f, -0.45279f),new Vector2f(1.0f, 0.701946f),new Vector2f(1.0f, 0.988959f),new Vector2f(0.9375f, 0.963071f),new Vector2f(0.9375f, 0.727835f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[19] = new ObjQuad(new Vector3f(-0.453877f, 1.6f, -0.186651f),new Vector3f(-0.453877f, 1.6f, 0.189726f),new Vector3f(-0.403877f, 1.55f, 0.169016f),new Vector3f(-0.403877f, 1.55f, -0.16594f),new Vector2f(0.9375f, 0.479258f),new Vector2f(0.9375f, 0.714493f),new Vector2f(0.90625f, 0.701549f),new Vector2f(0.90625f, 0.492202f),new Vector3f(2.828428f, 2.828428f, 0.0f));
		this.quads[20] = new ObjQuad(new Vector3f(-0.453877f, 1.6f, 0.189726f),new Vector3f(-0.187738f, 1.6f, 0.455865f),new Vector3f(-0.167028f, 1.55f, 0.405865f),new Vector3f(-0.403877f, 1.55f, 0.169016f),new Vector2f(0.9375f, 0.148188f),new Vector2f(0.9375f, 0.383424f),new Vector2f(0.90625f, 0.37048f),new Vector2f(0.90625f, 0.161132f),new Vector3f(2.0f, 2.828428f, -2.0f));
		this.quads[21] = new ObjQuad(new Vector3f(-0.187738f, 1.6f, 0.455865f),new Vector3f(0.188639f, 1.6f, 0.455865f),new Vector3f(0.167928f, 1.55f, 0.405865f),new Vector3f(-0.167028f, 1.55f, 0.405865f),new Vector2f(0.9375f, 0.028027f),new Vector2f(0.9375f, 0.263263f),new Vector2f(0.90625f, 0.250319f),new Vector2f(0.90625f, 0.040971f),new Vector3f(0.0f, 2.828428f, -2.828428f));
		this.quads[22] = new ObjQuad(new Vector3f(0.188639f, 1.6f, 0.455865f),new Vector3f(0.454778f, 1.6f, 0.189726f),new Vector3f(0.404778f, 1.55f, 0.169015f),new Vector3f(0.167928f, 1.55f, 0.405865f),new Vector2f(0.9375f, 0.288772f),new Vector2f(0.9375f, 0.524008f),new Vector2f(0.90625f, 0.511064f),new Vector2f(0.90625f, 0.301716f),new Vector3f(-2.0f, 2.828428f, -2.0f));
		this.quads[23] = new ObjQuad(new Vector3f(0.454778f, 1.6f, 0.189726f),new Vector3f(0.454778f, 1.6f, -0.186651f),new Vector3f(0.404778f, 1.55f, -0.165941f),new Vector3f(0.404778f, 1.55f, 0.169015f),new Vector2f(0.9375f, 0.600814f),new Vector2f(0.9375f, 0.83605f),new Vector2f(0.90625f, 0.823106f),new Vector2f(0.90625f, 0.613759f),new Vector3f(-2.828428f, 2.828428f, 0.0f));
		this.quads[24] = new ObjQuad(new Vector3f(0.454778f, 1.6f, -0.186651f),new Vector3f(0.188639f, 1.6f, -0.45279f),new Vector3f(0.167928f, 1.55f, -0.40279f),new Vector3f(0.404778f, 1.55f, -0.165941f),new Vector2f(0.9375f, 0.412829f),new Vector2f(0.9375f, 0.648065f),new Vector2f(0.90625f, 0.635121f),new Vector2f(0.90625f, 0.425773f),new Vector3f(-2.0f, 2.828428f, 2.0f));
		this.quads[25] = new ObjQuad(new Vector3f(0.188639f, 1.6f, -0.45279f),new Vector3f(-0.187738f, 1.6f, -0.45279f),new Vector3f(-0.167028f, 1.55f, -0.40279f),new Vector3f(0.167928f, 1.55f, -0.40279f),new Vector2f(0.9375f, 0.346358f),new Vector2f(0.9375f, 0.581594f),new Vector2f(0.90625f, 0.56865f),new Vector2f(0.90625f, 0.359302f),new Vector3f(0.0f, 2.828428f, 2.828428f));
		this.quads[26] = new ObjQuad(new Vector3f(-0.187738f, 1.6f, -0.45279f),new Vector3f(-0.453877f, 1.6f, -0.186651f),new Vector3f(-0.403877f, 1.55f, -0.16594f),new Vector3f(-0.167028f, 1.55f, -0.40279f),new Vector2f(0.9375f, 0.727835f),new Vector2f(0.9375f, 0.963071f),new Vector2f(0.90625f, 0.950127f),new Vector2f(0.90625f, 0.740779f),new Vector3f(2.0f, 2.828428f, 2.0f));
		this.quads[27] = new ObjQuad(new Vector3f(-0.403877f, 1.55f, -0.16594f),new Vector3f(-0.403877f, 1.55f, 0.169016f),new Vector3f(-0.353877f, 1.55f, 0.148305f),new Vector3f(-0.353877f, 1.55f, -0.14523f),new Vector2f(0.90625f, 0.492202f),new Vector2f(0.90625f, 0.701549f),new Vector2f(0.875f, 0.688605f),new Vector2f(0.875f, 0.505146f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[28] = new ObjQuad(new Vector3f(-0.403877f, 1.55f, 0.169016f),new Vector3f(-0.167028f, 1.55f, 0.405865f),new Vector3f(-0.146317f, 1.55f, 0.355865f),new Vector3f(-0.353877f, 1.55f, 0.148305f),new Vector2f(0.90625f, 0.161132f),new Vector2f(0.90625f, 0.37048f),new Vector2f(0.875f, 0.357535f),new Vector2f(0.875f, 0.174076f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[29] = new ObjQuad(new Vector3f(-0.167028f, 1.55f, 0.405865f),new Vector3f(0.167928f, 1.55f, 0.405865f),new Vector3f(0.147218f, 1.55f, 0.355865f),new Vector3f(-0.146317f, 1.55f, 0.355865f),new Vector2f(0.90625f, 0.040971f),new Vector2f(0.90625f, 0.250319f),new Vector2f(0.875f, 0.237374f),new Vector2f(0.875f, 0.053915f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[30] = new ObjQuad(new Vector3f(0.167928f, 1.55f, 0.405865f),new Vector3f(0.404778f, 1.55f, 0.169015f),new Vector3f(0.354778f, 1.55f, 0.148305f),new Vector3f(0.147218f, 1.55f, 0.355865f),new Vector2f(0.90625f, 0.301716f),new Vector2f(0.90625f, 0.511064f),new Vector2f(0.875f, 0.49812f),new Vector2f(0.875f, 0.31466f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[31] = new ObjQuad(new Vector3f(0.404778f, 1.55f, 0.169015f),new Vector3f(0.404778f, 1.55f, -0.165941f),new Vector3f(0.354778f, 1.55f, -0.14523f),new Vector3f(0.354778f, 1.55f, 0.148305f),new Vector2f(0.90625f, 0.613759f),new Vector2f(0.90625f, 0.823106f),new Vector2f(0.875f, 0.810162f),new Vector2f(0.875f, 0.626703f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[32] = new ObjQuad(new Vector3f(0.404778f, 1.55f, -0.165941f),new Vector3f(0.167928f, 1.55f, -0.40279f),new Vector3f(0.147218f, 1.55f, -0.35279f),new Vector3f(0.354778f, 1.55f, -0.14523f),new Vector2f(0.90625f, 0.425773f),new Vector2f(0.90625f, 0.635121f),new Vector2f(0.875f, 0.622176f),new Vector2f(0.875f, 0.438717f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[33] = new ObjQuad(new Vector3f(0.167928f, 1.55f, -0.40279f),new Vector3f(-0.167028f, 1.55f, -0.40279f),new Vector3f(-0.146317f, 1.55f, -0.35279f),new Vector3f(0.147218f, 1.55f, -0.35279f),new Vector2f(0.90625f, 0.359302f),new Vector2f(0.90625f, 0.56865f),new Vector2f(0.875f, 0.555705f),new Vector2f(0.875f, 0.372246f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[34] = new ObjQuad(new Vector3f(-0.167028f, 1.55f, -0.40279f),new Vector3f(-0.403877f, 1.55f, -0.16594f),new Vector3f(-0.353877f, 1.55f, -0.14523f),new Vector3f(-0.146317f, 1.55f, -0.35279f),new Vector2f(0.90625f, 0.740779f),new Vector2f(0.90625f, 0.950127f),new Vector2f(0.875f, 0.937182f),new Vector2f(0.875f, 0.753723f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[35] = new ObjQuad(new Vector3f(0.230061f, 0.8f, 0.555865f),new Vector3f(0.230061f, 0.85f, 0.555865f),new Vector3f(-0.22916f, 0.85f, 0.555865f),new Vector3f(-0.22916f, 0.8f, 0.555865f),new Vector2f(0.751358f, 0.702824f),new Vector2f(0.782215f, 0.702824f),new Vector2f(0.782215f, 0.989953f),new Vector2f(0.751358f, 0.989953f),new Vector3f(0.0f, -4.0E-6f, 4.0f));
		this.quads[36] = new ObjQuad(new Vector3f(0.554778f, 0.8f, 0.231147f),new Vector3f(0.554778f, 0.85f, 0.231147f),new Vector3f(0.230061f, 0.85f, 0.555865f),new Vector3f(0.230061f, 0.8f, 0.555865f),new Vector2f(0.749961f, 0.386838f),new Vector2f(0.780818f, 0.386838f),new Vector2f(0.780818f, 0.673967f),new Vector2f(0.749962f, 0.673967f),new Vector3f(2.828428f, -4.0E-6f, 2.828428f));
		this.quads[37] = new ObjQuad(new Vector3f(0.554778f, 0.85f, -0.228073f),new Vector3f(0.554778f, 0.85f, 0.231147f),new Vector3f(0.554778f, 0.8f, 0.231147f),new Vector3f(0.554778f, 0.8f, -0.228073f),new Vector2f(0.782215f, 0.703621f),new Vector2f(0.782215f, 0.990749f),new Vector2f(0.751358f, 0.990749f),new Vector2f(0.751358f, 0.703621f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[38] = new ObjQuad(new Vector3f(0.23006f, 0.85f, -0.55279f),new Vector3f(0.554778f, 0.85f, -0.228073f),new Vector3f(0.554778f, 0.8f, -0.228073f),new Vector3f(0.23006f, 0.8f, -0.55279f),new Vector2f(0.780818f, 0.387635f),new Vector2f(0.780818f, 0.674763f),new Vector2f(0.749962f, 0.674763f),new Vector2f(0.749961f, 0.387635f),new Vector3f(2.828428f, 0.0f, -2.828428f));
		this.quads[39] = new ObjQuad(new Vector3f(-0.22916f, 0.8f, -0.55279f),new Vector3f(-0.22916f, 0.85f, -0.55279f),new Vector3f(0.23006f, 0.85f, -0.55279f),new Vector3f(0.23006f, 0.8f, -0.55279f),new Vector2f(0.751358f, 0.702824f),new Vector2f(0.782215f, 0.702824f),new Vector2f(0.782215f, 0.989953f),new Vector2f(0.751358f, 0.989953f),new Vector3f(-4.0E-6f, 0.0f, -4.0f));
		this.quads[40] = new ObjQuad(new Vector3f(-0.553877f, 0.8f, -0.228072f),new Vector3f(-0.553877f, 0.85f, -0.228072f),new Vector3f(-0.22916f, 0.85f, -0.55279f),new Vector3f(-0.22916f, 0.8f, -0.55279f),new Vector2f(0.749961f, 0.386838f),new Vector2f(0.780818f, 0.386838f),new Vector2f(0.780818f, 0.673967f),new Vector2f(0.749962f, 0.673967f),new Vector3f(-2.828428f, 0.0f, -2.828428f));
		this.quads[41] = new ObjQuad(new Vector3f(-0.553877f, 0.85f, 0.231148f),new Vector3f(-0.553877f, 0.85f, -0.228072f),new Vector3f(-0.553877f, 0.8f, -0.228072f),new Vector3f(-0.553877f, 0.8f, 0.231148f),new Vector2f(0.782215f, 0.702028f),new Vector2f(0.782215f, 0.989157f),new Vector2f(0.751358f, 0.989157f),new Vector2f(0.751358f, 0.702028f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[42] = new ObjQuad(new Vector3f(-0.22916f, 0.85f, 0.555865f),new Vector3f(-0.553877f, 0.85f, 0.231148f),new Vector3f(-0.553877f, 0.8f, 0.231148f),new Vector3f(-0.22916f, 0.8f, 0.555865f),new Vector2f(0.780818f, 0.386042f),new Vector2f(0.780818f, 0.673171f),new Vector2f(0.749962f, 0.673171f),new Vector2f(0.749961f, 0.386042f),new Vector3f(-2.828428f, 0.0f, 2.828428f));
		this.quads[43] = new ObjQuad(new Vector3f(-0.146767f, 0.0f, 0.355955f),new Vector3f(-0.354328f, 0.0f, 0.148394f),new Vector3f(-0.354328f, 0.0f, -0.14514f),new Vector3f(0.146767f, 0.0f, 0.355955f),new Vector2f(0.40827f, 0.278545f),new Vector2f(0.278545f, 0.40827f),new Vector2f(0.278545f, 0.59173f),new Vector2f(0.59173f, 0.278545f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[44] = new ObjQuad(new Vector3f(0.146767f, 0.0f, -0.352701f),new Vector3f(0.354328f, 0.0f, -0.14514f),new Vector3f(0.354328f, 0.0f, 0.148394f),new Vector3f(-0.146768f, 0.0f, -0.352701f),new Vector2f(0.59173f, 0.721455f),new Vector2f(0.721455f, 0.59173f),new Vector2f(0.721455f, 0.40827f),new Vector2f(0.40827f, 0.721455f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[45] = new ObjQuad(new Vector3f(-0.146768f, 0.0f, -0.352701f),new Vector3f(0.354328f, 0.0f, 0.148394f),new Vector3f(0.146767f, 0.0f, 0.355955f),new Vector3f(-0.354328f, 0.0f, -0.14514f),new Vector2f(0.40827f, 0.721455f),new Vector2f(0.721455f, 0.40827f),new Vector2f(0.59173f, 0.278545f),new Vector2f(0.278545f, 0.59173f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[46] = new ObjQuad(new Vector3f(-0.22961f, 0.05f, 0.555955f),new Vector3f(0.22961f, 0.05f, 0.555955f),new Vector3f(0.22961f, 0.15f, 0.555955f),new Vector3f(-0.22961f, 0.15f, 0.555955f),new Vector2f(0.813071f, 0.989953f),new Vector2f(0.813071f, 0.702824f),new Vector2f(0.751358f, 0.702824f),new Vector2f(0.751358f, 0.989953f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[47] = new ObjQuad(new Vector3f(0.22961f, 0.05f, 0.555955f),new Vector3f(0.554328f, 0.05f, 0.231237f),new Vector3f(0.554328f, 0.15f, 0.231237f),new Vector3f(0.22961f, 0.15f, 0.555955f),new Vector2f(0.811675f, 0.673967f),new Vector2f(0.811675f, 0.386838f),new Vector2f(0.749961f, 0.386838f),new Vector2f(0.749962f, 0.673967f),new Vector3f(2.828428f, 0.0f, 2.828428f));
		this.quads[48] = new ObjQuad(new Vector3f(0.554328f, 0.05f, 0.231237f),new Vector3f(0.554328f, 0.05f, -0.227983f),new Vector3f(0.554328f, 0.15f, -0.227983f),new Vector3f(0.554328f, 0.15f, 0.231237f),new Vector2f(0.813071f, 0.990749f),new Vector2f(0.813071f, 0.703621f),new Vector2f(0.751358f, 0.703621f),new Vector2f(0.751358f, 0.990749f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[49] = new ObjQuad(new Vector3f(0.554328f, 0.05f, -0.227983f),new Vector3f(0.22961f, 0.05f, -0.552701f),new Vector3f(0.22961f, 0.15f, -0.552701f),new Vector3f(0.554328f, 0.15f, -0.227983f),new Vector2f(0.811675f, 0.674763f),new Vector2f(0.811675f, 0.387635f),new Vector2f(0.749961f, 0.387635f),new Vector2f(0.749962f, 0.674763f),new Vector3f(2.828428f, 0.0f, -2.828428f));
		this.quads[50] = new ObjQuad(new Vector3f(0.22961f, 0.05f, -0.552701f),new Vector3f(-0.22961f, 0.05f, -0.552701f),new Vector3f(-0.22961f, 0.15f, -0.552701f),new Vector3f(0.22961f, 0.15f, -0.552701f),new Vector2f(0.813071f, 0.989953f),new Vector2f(0.813071f, 0.702824f),new Vector2f(0.751358f, 0.702824f),new Vector2f(0.751358f, 0.989953f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[51] = new ObjQuad(new Vector3f(-0.22961f, 0.05f, -0.552701f),new Vector3f(-0.554328f, 0.05f, -0.227983f),new Vector3f(-0.554328f, 0.15f, -0.227983f),new Vector3f(-0.22961f, 0.15f, -0.552701f),new Vector2f(0.811675f, 0.673967f),new Vector2f(0.811675f, 0.386838f),new Vector2f(0.749961f, 0.386838f),new Vector2f(0.749962f, 0.673967f),new Vector3f(-2.828428f, 0.0f, -2.828428f));
		this.quads[52] = new ObjQuad(new Vector3f(-0.554328f, 0.05f, -0.227983f),new Vector3f(-0.554328f, 0.05f, 0.231237f),new Vector3f(-0.554328f, 0.15f, 0.231237f),new Vector3f(-0.554328f, 0.15f, -0.227983f),new Vector2f(0.813071f, 0.989157f),new Vector2f(0.813071f, 0.702028f),new Vector2f(0.751358f, 0.702028f),new Vector2f(0.751358f, 0.989157f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[53] = new ObjQuad(new Vector3f(-0.554328f, 0.05f, 0.231237f),new Vector3f(-0.22961f, 0.05f, 0.555955f),new Vector3f(-0.22961f, 0.15f, 0.555955f),new Vector3f(-0.554328f, 0.15f, 0.231237f),new Vector2f(0.811675f, 0.673171f),new Vector2f(0.811675f, 0.386042f),new Vector2f(0.749961f, 0.386042f),new Vector2f(0.749962f, 0.673171f),new Vector3f(-2.828424f, 0.0f, 2.828428f));
		this.quads[54] = new ObjQuad(new Vector3f(-0.554328f, 0.05f, -0.227983f),new Vector3f(-0.454328f, 0.05f, -0.186562f),new Vector3f(-0.454328f, 0.05f, 0.189816f),new Vector3f(-0.554328f, 0.05f, 0.231237f),new Vector2f(1.0f, 0.453369f),new Vector2f(0.9375f, 0.479258f),new Vector2f(0.9375f, 0.714493f),new Vector2f(1.0f, 0.740382f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[55] = new ObjQuad(new Vector3f(-0.554328f, 0.05f, 0.231237f),new Vector3f(-0.454328f, 0.05f, 0.189816f),new Vector3f(-0.188189f, 0.05f, 0.455955f),new Vector3f(-0.22961f, 0.05f, 0.555955f),new Vector2f(1.0f, 0.1223f),new Vector2f(0.9375f, 0.148188f),new Vector2f(0.9375f, 0.383424f),new Vector2f(1.0f, 0.409312f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[56] = new ObjQuad(new Vector3f(-0.22961f, 0.05f, 0.555955f),new Vector3f(-0.188189f, 0.05f, 0.455955f),new Vector3f(0.188189f, 0.05f, 0.455955f),new Vector3f(0.22961f, 0.05f, 0.555955f),new Vector2f(1.0f, 0.002138f),new Vector2f(0.9375f, 0.028027f),new Vector2f(0.9375f, 0.263263f),new Vector2f(1.0f, 0.289151f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[57] = new ObjQuad(new Vector3f(0.22961f, 0.05f, 0.555955f),new Vector3f(0.188189f, 0.05f, 0.455955f),new Vector3f(0.454328f, 0.05f, 0.189816f),new Vector3f(0.554328f, 0.05f, 0.231237f),new Vector2f(1.0f, 0.262884f),new Vector2f(0.9375f, 0.288772f),new Vector2f(0.9375f, 0.524008f),new Vector2f(1.0f, 0.549896f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[58] = new ObjQuad(new Vector3f(0.554328f, 0.05f, 0.231237f),new Vector3f(0.454328f, 0.05f, 0.189816f),new Vector3f(0.454328f, 0.05f, -0.186562f),new Vector3f(0.554328f, 0.05f, -0.227983f),new Vector2f(1.0f, 0.574926f),new Vector2f(0.9375f, 0.600814f),new Vector2f(0.9375f, 0.83605f),new Vector2f(1.0f, 0.861938f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[59] = new ObjQuad(new Vector3f(0.554328f, 0.05f, -0.227983f),new Vector3f(0.454328f, 0.05f, -0.186562f),new Vector3f(0.188189f, 0.05f, -0.452701f),new Vector3f(0.22961f, 0.05f, -0.552701f),new Vector2f(1.0f, 0.38694f),new Vector2f(0.9375f, 0.412829f),new Vector2f(0.9375f, 0.648065f),new Vector2f(1.0f, 0.673953f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[60] = new ObjQuad(new Vector3f(0.22961f, 0.05f, -0.552701f),new Vector3f(0.188189f, 0.05f, -0.452701f),new Vector3f(-0.188189f, 0.05f, -0.452701f),new Vector3f(-0.22961f, 0.05f, -0.552701f),new Vector2f(1.0f, 0.32047f),new Vector2f(0.9375f, 0.346358f),new Vector2f(0.9375f, 0.581594f),new Vector2f(1.0f, 0.607482f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[61] = new ObjQuad(new Vector3f(-0.22961f, 0.05f, -0.552701f),new Vector3f(-0.188189f, 0.05f, -0.452701f),new Vector3f(-0.454328f, 0.05f, -0.186562f),new Vector3f(-0.554328f, 0.05f, -0.227983f),new Vector2f(1.0f, 0.701946f),new Vector2f(0.9375f, 0.727835f),new Vector2f(0.9375f, 0.963071f),new Vector2f(1.0f, 0.988959f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[62] = new ObjQuad(new Vector3f(-0.454328f, 0.05f, -0.186562f),new Vector3f(-0.404328f, 0.0f, -0.165851f),new Vector3f(-0.404328f, 0.0f, 0.169105f),new Vector3f(-0.454328f, 0.05f, 0.189816f),new Vector2f(0.9375f, 0.479258f),new Vector2f(0.90625f, 0.492202f),new Vector2f(0.90625f, 0.701549f),new Vector2f(0.9375f, 0.714493f),new Vector3f(-2.828428f, -2.828428f, 0.0f));
		this.quads[63] = new ObjQuad(new Vector3f(-0.454328f, 0.05f, 0.189816f),new Vector3f(-0.404328f, 0.0f, 0.169105f),new Vector3f(-0.167478f, 0.0f, 0.405955f),new Vector3f(-0.188189f, 0.05f, 0.455955f),new Vector2f(0.9375f, 0.148188f),new Vector2f(0.90625f, 0.161132f),new Vector2f(0.90625f, 0.37048f),new Vector2f(0.9375f, 0.383424f),new Vector3f(-2.0f, -2.828428f, 2.0f));
		this.quads[64] = new ObjQuad(new Vector3f(-0.188189f, 0.05f, 0.455955f),new Vector3f(-0.167478f, 0.0f, 0.405955f),new Vector3f(0.167478f, 0.0f, 0.405955f),new Vector3f(0.188189f, 0.05f, 0.455955f),new Vector2f(0.9375f, 0.028027f),new Vector2f(0.90625f, 0.040971f),new Vector2f(0.90625f, 0.250319f),new Vector2f(0.9375f, 0.263263f),new Vector3f(0.0f, -2.828428f, 2.828428f));
		this.quads[65] = new ObjQuad(new Vector3f(0.188189f, 0.05f, 0.455955f),new Vector3f(0.167478f, 0.0f, 0.405955f),new Vector3f(0.404328f, 0.0f, 0.169105f),new Vector3f(0.454328f, 0.05f, 0.189816f),new Vector2f(0.9375f, 0.288772f),new Vector2f(0.90625f, 0.301716f),new Vector2f(0.90625f, 0.511064f),new Vector2f(0.9375f, 0.524008f),new Vector3f(2.0f, -2.828428f, 2.0f));
		this.quads[66] = new ObjQuad(new Vector3f(0.454328f, 0.05f, 0.189816f),new Vector3f(0.404328f, 0.0f, 0.169105f),new Vector3f(0.404328f, 0.0f, -0.165851f),new Vector3f(0.454328f, 0.05f, -0.186562f),new Vector2f(0.9375f, 0.600814f),new Vector2f(0.90625f, 0.613759f),new Vector2f(0.90625f, 0.823106f),new Vector2f(0.9375f, 0.83605f),new Vector3f(2.828428f, -2.828428f, 0.0f));
		this.quads[67] = new ObjQuad(new Vector3f(0.454328f, 0.05f, -0.186562f),new Vector3f(0.404328f, 0.0f, -0.165851f),new Vector3f(0.167478f, 0.0f, -0.402701f),new Vector3f(0.188189f, 0.05f, -0.452701f),new Vector2f(0.9375f, 0.412829f),new Vector2f(0.90625f, 0.425773f),new Vector2f(0.90625f, 0.635121f),new Vector2f(0.9375f, 0.648065f),new Vector3f(2.0f, -2.828428f, -2.0f));
		this.quads[68] = new ObjQuad(new Vector3f(0.188189f, 0.05f, -0.452701f),new Vector3f(0.167478f, 0.0f, -0.402701f),new Vector3f(-0.167478f, 0.0f, -0.402701f),new Vector3f(-0.188189f, 0.05f, -0.452701f),new Vector2f(0.9375f, 0.346358f),new Vector2f(0.90625f, 0.359302f),new Vector2f(0.90625f, 0.56865f),new Vector2f(0.9375f, 0.581594f),new Vector3f(0.0f, -2.828428f, -2.828428f));
		this.quads[69] = new ObjQuad(new Vector3f(-0.188189f, 0.05f, -0.452701f),new Vector3f(-0.167478f, 0.0f, -0.402701f),new Vector3f(-0.404328f, 0.0f, -0.165851f),new Vector3f(-0.454328f, 0.05f, -0.186562f),new Vector2f(0.9375f, 0.727835f),new Vector2f(0.90625f, 0.740779f),new Vector2f(0.90625f, 0.950127f),new Vector2f(0.9375f, 0.963071f),new Vector3f(-2.0f, -2.828428f, -2.0f));
		this.quads[70] = new ObjQuad(new Vector3f(-0.404328f, 0.0f, -0.165851f),new Vector3f(-0.354328f, 0.0f, -0.14514f),new Vector3f(-0.354328f, 0.0f, 0.148394f),new Vector3f(-0.404328f, 0.0f, 0.169105f),new Vector2f(0.90625f, 0.492202f),new Vector2f(0.875f, 0.505146f),new Vector2f(0.875f, 0.688605f),new Vector2f(0.90625f, 0.701549f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[71] = new ObjQuad(new Vector3f(-0.404328f, 0.0f, 0.169105f),new Vector3f(-0.354328f, 0.0f, 0.148394f),new Vector3f(-0.146767f, 0.0f, 0.355955f),new Vector3f(-0.167478f, 0.0f, 0.405955f),new Vector2f(0.90625f, 0.161132f),new Vector2f(0.875f, 0.174076f),new Vector2f(0.875f, 0.357535f),new Vector2f(0.90625f, 0.37048f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[72] = new ObjQuad(new Vector3f(-0.167478f, 0.0f, 0.405955f),new Vector3f(-0.146767f, 0.0f, 0.355955f),new Vector3f(0.146767f, 0.0f, 0.355955f),new Vector3f(0.167478f, 0.0f, 0.405955f),new Vector2f(0.90625f, 0.040971f),new Vector2f(0.875f, 0.053915f),new Vector2f(0.875f, 0.237374f),new Vector2f(0.90625f, 0.250319f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[73] = new ObjQuad(new Vector3f(0.167478f, 0.0f, 0.405955f),new Vector3f(0.146767f, 0.0f, 0.355955f),new Vector3f(0.354328f, 0.0f, 0.148394f),new Vector3f(0.404328f, 0.0f, 0.169105f),new Vector2f(0.90625f, 0.301716f),new Vector2f(0.875f, 0.31466f),new Vector2f(0.875f, 0.49812f),new Vector2f(0.90625f, 0.511064f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[74] = new ObjQuad(new Vector3f(0.404328f, 0.0f, 0.169105f),new Vector3f(0.354328f, 0.0f, 0.148394f),new Vector3f(0.354328f, 0.0f, -0.14514f),new Vector3f(0.404328f, 0.0f, -0.165851f),new Vector2f(0.90625f, 0.613759f),new Vector2f(0.875f, 0.626703f),new Vector2f(0.875f, 0.810162f),new Vector2f(0.90625f, 0.823106f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[75] = new ObjQuad(new Vector3f(0.404328f, 0.0f, -0.165851f),new Vector3f(0.354328f, 0.0f, -0.14514f),new Vector3f(0.146767f, 0.0f, -0.352701f),new Vector3f(0.167478f, 0.0f, -0.402701f),new Vector2f(0.90625f, 0.425773f),new Vector2f(0.875f, 0.438717f),new Vector2f(0.875f, 0.622176f),new Vector2f(0.90625f, 0.635121f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[76] = new ObjQuad(new Vector3f(0.167478f, 0.0f, -0.402701f),new Vector3f(0.146767f, 0.0f, -0.352701f),new Vector3f(-0.146768f, 0.0f, -0.352701f),new Vector3f(-0.167478f, 0.0f, -0.402701f),new Vector2f(0.90625f, 0.359302f),new Vector2f(0.875f, 0.372246f),new Vector2f(0.875f, 0.555705f),new Vector2f(0.90625f, 0.56865f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[77] = new ObjQuad(new Vector3f(-0.167478f, 0.0f, -0.402701f),new Vector3f(-0.146768f, 0.0f, -0.352701f),new Vector3f(-0.354328f, 0.0f, -0.14514f),new Vector3f(-0.404328f, 0.0f, -0.165851f),new Vector2f(0.90625f, 0.740779f),new Vector2f(0.875f, 0.753723f),new Vector2f(0.875f, 0.937182f),new Vector2f(0.90625f, 0.950127f),new Vector3f(0.0f, -4.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		DestillationConnectors other = new DestillationConnectors();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}
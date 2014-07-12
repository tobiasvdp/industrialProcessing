package mod.industrialProcessing.transport.fluids.models.block.raintank;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class RaintankFrame extends ObjMesh{
	public RaintankFrame(){
		this.quads = new ObjQuad[80];
		this.quads[0] = new ObjQuad(new Vector3f(-0.8f, 0.0f, 0.8f),new Vector3f(-0.8f, 0.0f, -0.8f),new Vector3f(-0.7f, 0.0f, -0.7f),new Vector3f(-0.7f, 0.0f, 0.7f),new Vector2f(0.376707f, 1.000238f),new Vector2f(0.376707f, 2.38E-4f),new Vector2f(0.439207f, 0.062738f),new Vector2f(0.439207f, 0.937738f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.8f, 0.0f, -0.8f),new Vector3f(0.8f, 0.0f, -0.8f),new Vector3f(0.7f, 0.0f, -0.7f),new Vector3f(-0.7f, 0.0f, -0.7f),new Vector2f(0.564208f, 1.000238f),new Vector2f(0.564208f, 2.38E-4f),new Vector2f(0.626708f, 0.062738f),new Vector2f(0.626708f, 0.937738f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.8f, 0.0f, -0.8f),new Vector3f(0.8f, 0.0f, 0.8f),new Vector3f(0.7f, 0.0f, 0.7f),new Vector3f(0.7f, 0.0f, -0.7f),new Vector2f(0.501707f, 2.38E-4f),new Vector2f(0.501707f, 1.000238f),new Vector2f(0.439207f, 0.937738f),new Vector2f(0.439207f, 0.062738f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.8f, 0.0f, 0.8f),new Vector3f(-0.8f, 0.0f, 0.8f),new Vector3f(-0.7f, 0.0f, 0.7f),new Vector3f(0.7f, 0.0f, 0.7f),new Vector2f(0.564208f, 2.38E-4f),new Vector2f(0.564207f, 1.000238f),new Vector2f(0.501707f, 0.937738f),new Vector2f(0.501708f, 0.062738f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.8f, 0.0f, 0.8f),new Vector3f(0.8f, 0.0f, 0.8f),new Vector3f(0.7f, 0.1f, 0.8f),new Vector3f(-0.7f, 0.1f, 0.8f),new Vector2f(0.437501f, 1.0f),new Vector2f(0.437501f, 0.0f),new Vector2f(0.500001f, 0.0625f),new Vector2f(0.500001f, 0.9375f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[5] = new ObjQuad(new Vector3f(0.8f, 1.1f, 0.8f),new Vector3f(0.7f, 1.1f, 0.8f),new Vector3f(0.7f, 0.1f, 0.8f),new Vector3f(0.8f, 0.0f, 0.8f),new Vector2f(0.439466f, 0.687425f),new Vector2f(0.376966f, 0.687425f),new Vector2f(0.376966f, 0.062425f),new Vector2f(0.439466f, -7.5E-5f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[6] = new ObjQuad(new Vector3f(0.8f, 0.0f, 0.8f),new Vector3f(0.8f, 0.0f, -0.8f),new Vector3f(0.8f, 0.1f, -0.7f),new Vector3f(0.8f, 0.1f, 0.7f),new Vector2f(0.312501f, 1.0f),new Vector2f(0.312501f, 0.0f),new Vector2f(0.375001f, 0.0625f),new Vector2f(0.375001f, 0.9375f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(0.8f, 1.1f, -0.8f),new Vector3f(0.8f, 1.1f, -0.7f),new Vector3f(0.8f, 0.1f, -0.7f),new Vector3f(0.8f, 0.0f, -0.8f),new Vector2f(0.50026f, 0.687187f),new Vector2f(0.43776f, 0.687187f),new Vector2f(0.43776f, 0.062187f),new Vector2f(0.50026f, -3.13E-4f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(0.8f, 0.0f, -0.8f),new Vector3f(-0.8f, 0.0f, -0.8f),new Vector3f(-0.7f, 0.1f, -0.8f),new Vector3f(0.7f, 0.1f, -0.8f),new Vector2f(0.250001f, 1.0f),new Vector2f(0.250001f, 0.0f),new Vector2f(0.312501f, 0.0625f),new Vector2f(0.312501f, 0.9375f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[9] = new ObjQuad(new Vector3f(-0.8f, 1.1f, -0.8f),new Vector3f(-0.7f, 1.1f, -0.8f),new Vector3f(-0.7f, 0.1f, -0.8f),new Vector3f(-0.8f, 0.0f, -0.8f),new Vector2f(0.564466f, 0.687425f),new Vector2f(0.501966f, 0.687425f),new Vector2f(0.501966f, 0.062425f),new Vector2f(0.564466f, -7.5E-5f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[10] = new ObjQuad(new Vector3f(-0.8f, 0.0f, -0.8f),new Vector3f(-0.8f, 0.0f, 0.8f),new Vector3f(-0.8f, 0.1f, 0.7f),new Vector3f(-0.8f, 0.1f, -0.7f),new Vector2f(0.375001f, 1.0f),new Vector2f(0.375001f, 0.0f),new Vector2f(0.437501f, 0.0625f),new Vector2f(0.437501f, 0.9375f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[11] = new ObjQuad(new Vector3f(-0.8f, 1.1f, 0.8f),new Vector3f(-0.8f, 1.1f, 0.7f),new Vector3f(-0.8f, 0.1f, 0.7f),new Vector3f(-0.8f, 0.0f, 0.8f),new Vector2f(0.43776f, 0.687187f),new Vector2f(0.37526f, 0.687187f),new Vector2f(0.37526f, 0.062187f),new Vector2f(0.43776f, -3.13E-4f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[12] = new ObjQuad(new Vector3f(-0.7f, 0.0f, 0.7f),new Vector3f(-0.7f, 0.0f, -0.7f),new Vector3f(-0.7f, 0.1f, -0.7f),new Vector3f(-0.7f, 0.1f, 0.7f),new Vector2f(0.438352f, 0.877679f),new Vector2f(0.438352f, 0.002679f),new Vector2f(0.500852f, 0.002679f),new Vector2f(0.500852f, 0.877679f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[13] = new ObjQuad(new Vector3f(-0.7f, 0.0f, -0.7f),new Vector3f(0.7f, 0.0f, -0.7f),new Vector3f(0.7f, 0.1f, -0.7f),new Vector3f(-0.7f, 0.1f, -0.7f),new Vector2f(0.375819f, 0.877679f),new Vector2f(0.375819f, 0.002679f),new Vector2f(0.438319f, 0.002679f),new Vector2f(0.438319f, 0.877679f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[14] = new ObjQuad(new Vector3f(0.7f, 0.0f, -0.7f),new Vector3f(0.7f, 0.0f, 0.7f),new Vector3f(0.7f, 0.1f, 0.7f),new Vector3f(0.7f, 0.1f, -0.7f),new Vector2f(0.500852f, 0.877679f),new Vector2f(0.500852f, 0.002679f),new Vector2f(0.563352f, 0.002679f),new Vector2f(0.563352f, 0.877679f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[15] = new ObjQuad(new Vector3f(0.7f, 0.0f, 0.7f),new Vector3f(-0.7f, 0.0f, 0.7f),new Vector3f(-0.7f, 0.1f, 0.7f),new Vector3f(0.7f, 0.1f, 0.7f),new Vector2f(0.438319f, 0.877679f),new Vector2f(0.438319f, 0.002679f),new Vector2f(0.500819f, 0.002679f),new Vector2f(0.500819f, 0.877679f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[16] = new ObjQuad(new Vector3f(-0.7f, 0.1f, 0.8f),new Vector3f(0.7f, 0.1f, 0.8f),new Vector3f(0.7f, 0.1f, 0.7f),new Vector3f(-0.7f, 0.1f, 0.7f),new Vector2f(0.500001f, 0.875f),new Vector2f(0.500001f, 0.0f),new Vector2f(0.562501f, 0.0f),new Vector2f(0.562501f, 0.875f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[17] = new ObjQuad(new Vector3f(0.7f, 1.1f, 0.8f),new Vector3f(0.7f, 1.1f, 0.7f),new Vector3f(0.7f, 0.1f, 0.7f),new Vector3f(0.7f, 0.1f, 0.8f),new Vector2f(0.50152f, 0.625966f),new Vector2f(0.43902f, 0.625966f),new Vector2f(0.43902f, 9.66E-4f),new Vector2f(0.50152f, 9.66E-4f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[18] = new ObjQuad(new Vector3f(0.8f, 0.1f, 0.7f),new Vector3f(0.8f, 0.1f, -0.7f),new Vector3f(0.7f, 0.1f, -0.7f),new Vector3f(0.7f, 0.1f, 0.7f),new Vector2f(0.563319f, 0.002679f),new Vector2f(0.563319f, 0.877679f),new Vector2f(0.500819f, 0.877679f),new Vector2f(0.500819f, 0.002679f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[19] = new ObjQuad(new Vector3f(0.8f, 1.1f, -0.7f),new Vector3f(0.7f, 1.1f, -0.7f),new Vector3f(0.7f, 0.1f, -0.7f),new Vector3f(0.8f, 0.1f, -0.7f),new Vector2f(0.438988f, 0.625966f),new Vector2f(0.376488f, 0.625966f),new Vector2f(0.376488f, 9.66E-4f),new Vector2f(0.438988f, 9.66E-4f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[20] = new ObjQuad(new Vector3f(0.7f, 0.1f, -0.8f),new Vector3f(-0.7f, 0.1f, -0.8f),new Vector3f(-0.7f, 0.1f, -0.7f),new Vector3f(0.7f, 0.1f, -0.7f),new Vector2f(0.438351f, 0.002679f),new Vector2f(0.438352f, 0.877679f),new Vector2f(0.375852f, 0.877679f),new Vector2f(0.375851f, 0.002679f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[21] = new ObjQuad(new Vector3f(-0.7f, 1.1f, -0.8f),new Vector3f(-0.7f, 1.1f, -0.7f),new Vector3f(-0.7f, 0.1f, -0.7f),new Vector3f(-0.7f, 0.1f, -0.8f),new Vector2f(0.501488f, 0.625966f),new Vector2f(0.438988f, 0.625966f),new Vector2f(0.438988f, 9.66E-4f),new Vector2f(0.501488f, 9.66E-4f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[22] = new ObjQuad(new Vector3f(-0.8f, 0.1f, -0.7f),new Vector3f(-0.8f, 0.1f, 0.7f),new Vector3f(-0.7f, 0.1f, 0.7f),new Vector3f(-0.7f, 0.1f, -0.7f),new Vector2f(0.313351f, 0.877679f),new Vector2f(0.313351f, 0.002679f),new Vector2f(0.375851f, 0.002679f),new Vector2f(0.375851f, 0.877679f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[23] = new ObjQuad(new Vector3f(-0.8f, 1.1f, 0.7f),new Vector3f(-0.7f, 1.1f, 0.7f),new Vector3f(-0.7f, 0.1f, 0.7f),new Vector3f(-0.8f, 0.1f, 0.7f),new Vector2f(0.56317f, 0.625424f),new Vector2f(0.50067f, 0.625424f),new Vector2f(0.50067f, 4.24E-4f),new Vector2f(0.56317f, 4.24E-4f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[24] = new ObjQuad(new Vector3f(-0.8f, 1.1f, 0.8f),new Vector3f(-0.8f, 0.0f, 0.8f),new Vector3f(-0.7f, 0.1f, 0.8f),new Vector3f(-0.7f, 1.1f, 0.8f),new Vector2f(0.439466f, 0.687425f),new Vector2f(0.439466f, -7.5E-5f),new Vector2f(0.501966f, 0.062425f),new Vector2f(0.501966f, 0.687425f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[25] = new ObjQuad(new Vector3f(0.8f, 1.1f, 0.8f),new Vector3f(0.8f, 0.0f, 0.8f),new Vector3f(0.8f, 0.1f, 0.7f),new Vector3f(0.8f, 1.1f, 0.7f),new Vector2f(0.25026f, 0.687187f),new Vector2f(0.25026f, -3.13E-4f),new Vector2f(0.31276f, 0.062187f),new Vector2f(0.31276f, 0.687187f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[26] = new ObjQuad(new Vector3f(0.8f, 1.1f, -0.8f),new Vector3f(0.8f, 0.0f, -0.8f),new Vector3f(0.7f, 0.1f, -0.8f),new Vector3f(0.7f, 1.1f, -0.8f),new Vector2f(0.564466f, 0.687425f),new Vector2f(0.564466f, -7.5E-5f),new Vector2f(0.626966f, 0.062425f),new Vector2f(0.626966f, 0.687425f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[27] = new ObjQuad(new Vector3f(-0.8f, 1.1f, -0.8f),new Vector3f(-0.8f, 0.0f, -0.8f),new Vector3f(-0.8f, 0.1f, -0.7f),new Vector3f(-0.8f, 1.1f, -0.7f),new Vector2f(0.31276f, 0.687187f),new Vector2f(0.31276f, -3.13E-4f),new Vector2f(0.37526f, 0.062187f),new Vector2f(0.37526f, 0.687187f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[28] = new ObjQuad(new Vector3f(-0.7f, 0.1f, 0.8f),new Vector3f(-0.7f, 0.1f, 0.7f),new Vector3f(-0.7f, 1.1f, 0.7f),new Vector3f(-0.7f, 1.1f, 0.8f),new Vector2f(0.31402f, 9.66E-4f),new Vector2f(0.37652f, 9.66E-4f),new Vector2f(0.37652f, 0.625966f),new Vector2f(0.31402f, 0.625966f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[29] = new ObjQuad(new Vector3f(0.8f, 0.1f, 0.7f),new Vector3f(0.7f, 0.1f, 0.7f),new Vector3f(0.7f, 1.1f, 0.7f),new Vector3f(0.8f, 1.1f, 0.7f),new Vector2f(0.37652f, 9.66E-4f),new Vector2f(0.43902f, 9.66E-4f),new Vector2f(0.43902f, 0.625966f),new Vector2f(0.37652f, 0.625966f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[30] = new ObjQuad(new Vector3f(0.7f, 0.1f, -0.8f),new Vector3f(0.7f, 0.1f, -0.7f),new Vector3f(0.7f, 1.1f, -0.7f),new Vector3f(0.7f, 1.1f, -0.8f),new Vector2f(0.50152f, 9.66E-4f),new Vector2f(0.56402f, 9.66E-4f),new Vector2f(0.56402f, 0.625966f),new Vector2f(0.50152f, 0.625966f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[31] = new ObjQuad(new Vector3f(-0.8f, 0.1f, -0.7f),new Vector3f(-0.7f, 0.1f, -0.7f),new Vector3f(-0.7f, 1.1f, -0.7f),new Vector3f(-0.8f, 1.1f, -0.7f),new Vector2f(0.501488f, 9.66E-4f),new Vector2f(0.563988f, 9.66E-4f),new Vector2f(0.563988f, 0.625966f),new Vector2f(0.501488f, 0.625966f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[32] = new ObjQuad(new Vector3f(0.7f, 1.01281f, -0.725f),new Vector3f(0.7f, 1.1f, -0.725f),new Vector3f(0.638967f, 1.1f, -0.725f),new Vector3f(0.061033f, 0.1f, -0.725f),new Vector2f(0.626014f, 0.718756f),new Vector2f(0.594758f, 0.763395f),new Vector2f(0.563511f, 0.741515f),new Vector2f(0.626112f, 0.022364f),new Vector3f(-2.0E-6f, -4.0E-6f, 4.0f));
		this.quads[33] = new ObjQuad(new Vector3f(0.061033f, 0.1f, -0.725f),new Vector3f(0.638967f, 1.1f, -0.725f),new Vector3f(-0.0f, 0.18719f, -0.725f),new Vector3f(-0.0f, 0.1f, -0.725f),new Vector2f(0.626112f, 0.022364f),new Vector2f(0.563511f, 0.741515f),new Vector2f(0.563608f, 0.045123f),new Vector2f(0.594864f, 4.85E-4f),new Vector3f(0.0f, -1.0E-6f, 4.0f));
		this.quads[34] = new ObjQuad(new Vector3f(0.638967f, 1.1f, -0.725f),new Vector3f(0.638967f, 1.1f, -0.775f),new Vector3f(-0.0f, 0.18719f, -0.775f),new Vector3f(-0.0f, 0.18719f, -0.725f),new Vector2f(0.781768f, 0.570326f),new Vector2f(0.750518f, 0.570326f),new Vector2f(0.750518f, -1.8E-4f),new Vector2f(0.781768f, -1.8E-4f),new Vector3f(-3.276928f, 2.293848f, 0.0f));
		this.quads[35] = new ObjQuad(new Vector3f(-0.7f, 1.012811f, -0.775f),new Vector3f(-0.7f, 1.1f, -0.775f),new Vector3f(-0.638967f, 1.1f, -0.775f),new Vector3f(-0.061033f, 0.1f, -0.775f),new Vector2f(0.438027f, 0.719312f),new Vector2f(0.406771f, 0.76395f),new Vector2f(0.375524f, 0.74207f),new Vector2f(0.438124f, 0.022919f),new Vector3f(0.0f, 1.0E-6f, -4.0f));
		this.quads[36] = new ObjQuad(new Vector3f(-0.061033f, 0.1f, -0.775f),new Vector3f(-0.638967f, 1.1f, -0.775f),new Vector3f(0.0f, 0.18719f, -0.775f),new Vector3f(0.0f, 0.1f, -0.775f),new Vector2f(0.438124f, 0.022919f),new Vector2f(0.375524f, 0.74207f),new Vector2f(0.375621f, 0.045679f),new Vector2f(0.406877f, 0.00104f),new Vector3f(0.0f, -1.0E-6f, -4.0f));
		this.quads[37] = new ObjQuad(new Vector3f(-0.638967f, 1.1f, -0.775f),new Vector3f(-0.638967f, 1.1f, -0.725f),new Vector3f(0.0f, 0.18719f, -0.725f),new Vector3f(0.0f, 0.18719f, -0.775f),new Vector2f(0.813018f, 0.570326f),new Vector2f(0.781768f, 0.570326f),new Vector2f(0.781768f, -1.8E-4f),new Vector2f(0.813018f, -1.81E-4f),new Vector3f(3.276928f, 2.293848f, 0.0f));
		this.quads[38] = new ObjQuad(new Vector3f(0.7f, 1.01281f, -0.775f),new Vector3f(0.7f, 1.01281f, -0.725f),new Vector3f(0.061033f, 0.1f, -0.725f),new Vector3f(0.061033f, 0.1f, -0.775f),new Vector2f(0.87512f, 0.570398f),new Vector2f(0.84387f, 0.570398f),new Vector2f(0.84387f, -1.08E-4f),new Vector2f(0.87512f, -1.08E-4f),new Vector3f(3.276928f, -2.293848f, 0.0f));
		this.quads[39] = new ObjQuad(new Vector3f(0.638967f, 1.1f, -0.775f),new Vector3f(0.7f, 1.1f, -0.775f),new Vector3f(0.7f, 1.01281f, -0.775f),new Vector3f(0.061033f, 0.1f, -0.775f),new Vector2f(0.501619f, 0.741856f),new Vector2f(0.470372f, 0.763735f),new Vector2f(0.439116f, 0.719097f),new Vector2f(0.439019f, 0.022705f),new Vector3f(0.0f, 1.0E-6f, -4.0f));
		this.quads[40] = new ObjQuad(new Vector3f(-0.0f, 0.18719f, -0.775f),new Vector3f(0.638967f, 1.1f, -0.775f),new Vector3f(0.061033f, 0.1f, -0.775f),new Vector3f(0.0f, 0.1f, -0.775f),new Vector2f(0.501522f, 0.045465f),new Vector2f(0.501619f, 0.741856f),new Vector2f(0.439019f, 0.022705f),new Vector2f(0.470265f, 8.26E-4f),new Vector3f(0.0f, -1.0E-6f, -4.0f));
		this.quads[41] = new ObjQuad(new Vector3f(-0.7f, 1.012811f, -0.725f),new Vector3f(-0.7f, 1.012811f, -0.775f),new Vector3f(-0.061033f, 0.1f, -0.775f),new Vector3f(-0.061033f, 0.1f, -0.725f),new Vector2f(0.875172f, 0.570455f),new Vector2f(0.843922f, 0.570455f),new Vector2f(0.843922f, -5.2E-5f),new Vector2f(0.875172f, -5.2E-5f),new Vector3f(-3.276928f, -2.293848f, 0.0f));
		this.quads[42] = new ObjQuad(new Vector3f(-0.638967f, 1.1f, -0.725f),new Vector3f(-0.7f, 1.1f, -0.725f),new Vector3f(-0.7f, 1.012811f, -0.725f),new Vector3f(-0.061033f, 0.1f, -0.725f),new Vector2f(0.564219f, 0.741856f),new Vector2f(0.532972f, 0.763735f),new Vector2f(0.501716f, 0.719097f),new Vector2f(0.501619f, 0.022705f),new Vector3f(-1.0E-6f, -3.0E-6f, 4.0f));
		this.quads[43] = new ObjQuad(new Vector3f(0.0f, 0.18719f, -0.725f),new Vector3f(-0.638967f, 1.1f, -0.725f),new Vector3f(-0.061033f, 0.1f, -0.725f),new Vector3f(0.0f, 0.1f, -0.725f),new Vector2f(0.564122f, 0.045465f),new Vector2f(0.564219f, 0.741856f),new Vector2f(0.501619f, 0.022705f),new Vector2f(0.532866f, 8.26E-4f),new Vector3f(0.0f, -1.0E-6f, 4.0f));
		this.quads[44] = new ObjQuad(new Vector3f(-0.7f, 1.01281f, 0.725f),new Vector3f(-0.7f, 1.1f, 0.725f),new Vector3f(-0.638967f, 1.1f, 0.725f),new Vector3f(-0.061033f, 0.1f, 0.725f),new Vector2f(0.626722f, 0.719097f),new Vector2f(0.595466f, 0.763736f),new Vector2f(0.564219f, 0.741856f),new Vector2f(0.626819f, 0.022705f),new Vector3f(1.0E-6f, -6.0E-6f, -4.0f));
		this.quads[45] = new ObjQuad(new Vector3f(-0.061033f, 0.1f, 0.725f),new Vector3f(-0.638967f, 1.1f, 0.725f),new Vector3f(0.0f, 0.18719f, 0.725f),new Vector3f(0.0f, 0.1f, 0.725f),new Vector2f(0.626819f, 0.022705f),new Vector2f(0.564219f, 0.741856f),new Vector2f(0.564316f, 0.045465f),new Vector2f(0.595572f, 8.26E-4f),new Vector3f(0.0f, -2.0E-6f, -4.0f));
		this.quads[46] = new ObjQuad(new Vector3f(-0.638967f, 1.1f, 0.725f),new Vector3f(-0.638967f, 1.1f, 0.775f),new Vector3f(0.0f, 0.18719f, 0.775f),new Vector3f(0.0f, 0.18719f, 0.725f),new Vector2f(0.937672f, 0.570455f),new Vector2f(0.906422f, 0.570455f),new Vector2f(0.906422f, -5.2E-5f),new Vector2f(0.937672f, -5.2E-5f),new Vector3f(3.276928f, 2.293848f, 0.0f));
		this.quads[47] = new ObjQuad(new Vector3f(0.7f, 1.012811f, 0.775f),new Vector3f(0.7f, 1.1f, 0.775f),new Vector3f(0.638967f, 1.1f, 0.775f),new Vector3f(0.061033f, 0.1f, 0.775f),new Vector2f(0.500814f, 0.718756f),new Vector2f(0.469558f, 0.763395f),new Vector2f(0.438311f, 0.741515f),new Vector2f(0.500911f, 0.022364f),new Vector3f(0.0f, 1.0E-6f, 4.0f));
		this.quads[48] = new ObjQuad(new Vector3f(0.061033f, 0.1f, 0.775f),new Vector3f(0.638967f, 1.1f, 0.775f),new Vector3f(0.0f, 0.18719f, 0.775f),new Vector3f(0.0f, 0.1f, 0.775f),new Vector2f(0.500911f, 0.022364f),new Vector2f(0.438311f, 0.741515f),new Vector2f(0.438408f, 0.045123f),new Vector2f(0.469664f, 4.85E-4f),new Vector3f(0.0f, -1.0E-6f, 4.0f));
		this.quads[49] = new ObjQuad(new Vector3f(0.638967f, 1.1f, 0.775f),new Vector3f(0.638967f, 1.1f, 0.725f),new Vector3f(0.0f, 0.18719f, 0.725f),new Vector3f(0.0f, 0.18719f, 0.775f),new Vector2f(1.000172f, 0.570455f),new Vector2f(0.968922f, 0.570455f),new Vector2f(0.968922f, -5.2E-5f),new Vector2f(1.000172f, -5.2E-5f),new Vector3f(-3.276928f, 2.293848f, 0.0f));
		this.quads[50] = new ObjQuad(new Vector3f(-0.7f, 1.01281f, 0.775f),new Vector3f(-0.7f, 1.01281f, 0.725f),new Vector3f(-0.061033f, 0.1f, 0.725f),new Vector3f(-0.061033f, 0.1f, 0.775f),new Vector2f(0.93762f, 0.570398f),new Vector2f(0.90637f, 0.570398f),new Vector2f(0.90637f, -1.08E-4f),new Vector2f(0.93762f, -1.08E-4f),new Vector3f(-3.276928f, -2.293848f, 0.0f));
		this.quads[51] = new ObjQuad(new Vector3f(-0.638967f, 1.1f, 0.775f),new Vector3f(-0.7f, 1.1f, 0.775f),new Vector3f(-0.7f, 1.01281f, 0.775f),new Vector3f(-0.061033f, 0.1f, 0.775f),new Vector2f(0.439019f, 0.741856f),new Vector2f(0.407772f, 0.763736f),new Vector2f(0.376515f, 0.719097f),new Vector2f(0.376418f, 0.022705f),new Vector3f(1.0E-6f, 3.0E-6f, 4.0f));
		this.quads[52] = new ObjQuad(new Vector3f(0.0f, 0.18719f, 0.775f),new Vector3f(-0.638967f, 1.1f, 0.775f),new Vector3f(-0.061033f, 0.1f, 0.775f),new Vector3f(0.0f, 0.1f, 0.775f),new Vector2f(0.438922f, 0.045465f),new Vector2f(0.439019f, 0.741856f),new Vector2f(0.376418f, 0.022705f),new Vector2f(0.407665f, 8.26E-4f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[53] = new ObjQuad(new Vector3f(0.7f, 1.012811f, 0.725f),new Vector3f(0.7f, 1.012811f, 0.775f),new Vector3f(0.061033f, 0.1f, 0.775f),new Vector3f(0.061033f, 0.1f, 0.725f),new Vector2f(0.719268f, 0.570327f),new Vector2f(0.688018f, 0.570327f),new Vector2f(0.688018f, -1.79E-4f),new Vector2f(0.719268f, -1.79E-4f),new Vector3f(3.276928f, -2.293848f, 0.0f));
		this.quads[54] = new ObjQuad(new Vector3f(0.638967f, 1.1f, 0.725f),new Vector3f(0.7f, 1.1f, 0.725f),new Vector3f(0.7f, 1.012811f, 0.725f),new Vector3f(0.061033f, 0.1f, 0.725f),new Vector2f(0.500724f, 0.74207f),new Vector2f(0.469477f, 0.763949f),new Vector2f(0.438221f, 0.719311f),new Vector2f(0.438124f, 0.022919f),new Vector3f(1.0E-6f, -3.0E-6f, -4.0f));
		this.quads[55] = new ObjQuad(new Vector3f(0.0f, 0.18719f, 0.725f),new Vector3f(0.638967f, 1.1f, 0.725f),new Vector3f(0.061033f, 0.1f, 0.725f),new Vector3f(0.0f, 0.1f, 0.725f),new Vector2f(0.500627f, 0.045678f),new Vector2f(0.500724f, 0.74207f),new Vector2f(0.438124f, 0.022919f),new Vector2f(0.469371f, 0.00104f),new Vector3f(0.0f, -1.0E-6f, -4.0f));
		this.quads[56] = new ObjQuad(new Vector3f(-0.725f, 1.01281f, -0.7f),new Vector3f(-0.725f, 1.1f, -0.7f),new Vector3f(-0.725f, 1.1f, -0.638967f),new Vector3f(-0.725f, 0.1f, -0.061033f),new Vector2f(0.563414f, 0.718756f),new Vector2f(0.532158f, 0.763395f),new Vector2f(0.500911f, 0.741515f),new Vector2f(0.563511f, 0.022364f),new Vector3f(4.0f, -4.0E-6f, 2.0E-6f));
		this.quads[57] = new ObjQuad(new Vector3f(-0.725f, 0.1f, -0.061033f),new Vector3f(-0.725f, 1.1f, -0.638967f),new Vector3f(-0.725f, 0.18719f, -0.0f),new Vector3f(-0.725f, 0.1f, -0.0f),new Vector2f(0.563511f, 0.022364f),new Vector2f(0.500911f, 0.741515f),new Vector2f(0.501008f, 0.045124f),new Vector2f(0.532264f, 4.85E-4f),new Vector3f(4.0f, -1.0E-6f, 0.0f));
		this.quads[58] = new ObjQuad(new Vector3f(-0.725f, 1.1f, -0.638967f),new Vector3f(-0.775f, 1.1f, -0.638967f),new Vector3f(-0.775f, 0.18719f, -0.0f),new Vector3f(-0.725f, 0.18719f, -0.0f),new Vector2f(0.843922f, 0.570455f),new Vector2f(0.812672f, 0.570455f),new Vector2f(0.812672f, -5.2E-5f),new Vector2f(0.843922f, -5.2E-5f),new Vector3f(0.0f, 2.293848f, 3.276928f));
		this.quads[59] = new ObjQuad(new Vector3f(-0.775f, 1.012811f, 0.7f),new Vector3f(-0.775f, 1.1f, 0.7f),new Vector3f(-0.775f, 1.1f, 0.638967f),new Vector3f(-0.775f, 0.1f, 0.061033f),new Vector2f(0.438214f, 0.718756f),new Vector2f(0.406958f, 0.763395f),new Vector2f(0.375711f, 0.741515f),new Vector2f(0.438311f, 0.022364f),new Vector3f(-4.0f, 3.0E-6f, -1.0E-6f));
		this.quads[60] = new ObjQuad(new Vector3f(-0.775f, 0.1f, 0.061033f),new Vector3f(-0.775f, 1.1f, 0.638967f),new Vector3f(-0.775f, 0.18719f, -0.0f),new Vector3f(-0.775f, 0.1f, -0.0f),new Vector2f(0.438311f, 0.022364f),new Vector2f(0.375711f, 0.741515f),new Vector2f(0.375808f, 0.045123f),new Vector2f(0.407064f, 4.85E-4f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[61] = new ObjQuad(new Vector3f(-0.775f, 1.1f, 0.638967f),new Vector3f(-0.725f, 1.1f, 0.638967f),new Vector3f(-0.725f, 0.18719f, -0.0f),new Vector3f(-0.775f, 0.18719f, -0.0f),new Vector2f(0.906422f, 0.570455f),new Vector2f(0.875172f, 0.570455f),new Vector2f(0.875172f, -5.1E-5f),new Vector2f(0.906422f, -5.2E-5f),new Vector3f(0.0f, 2.293848f, -3.276928f));
		this.quads[62] = new ObjQuad(new Vector3f(-0.775f, 1.01281f, -0.7f),new Vector3f(-0.725f, 1.01281f, -0.7f),new Vector3f(-0.725f, 0.1f, -0.061033f),new Vector3f(-0.775f, 0.1f, -0.061033f),new Vector2f(0.750518f, 0.570326f),new Vector2f(0.719268f, 0.570326f),new Vector2f(0.719268f, -1.81E-4f),new Vector2f(0.750518f, -1.81E-4f),new Vector3f(0.0f, -2.293848f, -3.276928f));
		this.quads[63] = new ObjQuad(new Vector3f(-0.775f, 1.1f, -0.638967f),new Vector3f(-0.775f, 1.1f, -0.7f),new Vector3f(-0.775f, 1.01281f, -0.7f),new Vector3f(-0.775f, 0.1f, -0.061033f),new Vector2f(0.564032f, 0.742412f),new Vector2f(0.532785f, 0.764291f),new Vector2f(0.501529f, 0.719652f),new Vector2f(0.501432f, 0.023261f),new Vector3f(-4.0f, 1.0E-6f, 0.0f));
		this.quads[64] = new ObjQuad(new Vector3f(-0.775f, 0.18719f, -0.0f),new Vector3f(-0.775f, 1.1f, -0.638967f),new Vector3f(-0.775f, 0.1f, -0.061033f),new Vector3f(-0.775f, 0.1f, -0.0f),new Vector2f(0.563935f, 0.04602f),new Vector2f(0.564032f, 0.742412f),new Vector2f(0.501432f, 0.023261f),new Vector2f(0.532679f, 0.001381f),new Vector3f(-4.0f, -1.0E-6f, 0.0f));
		this.quads[65] = new ObjQuad(new Vector3f(-0.725f, 1.012811f, 0.7f),new Vector3f(-0.775f, 1.012811f, 0.7f),new Vector3f(-0.775f, 0.1f, 0.061033f),new Vector3f(-0.725f, 0.1f, 0.061033f),new Vector2f(0.90637f, 0.570399f),new Vector2f(0.87512f, 0.570399f),new Vector2f(0.87512f, -1.08E-4f),new Vector2f(0.90637f, -1.08E-4f),new Vector3f(0.0f, -2.293848f, 3.276928f));
		this.quads[66] = new ObjQuad(new Vector3f(-0.725f, 1.1f, 0.638967f),new Vector3f(-0.725f, 1.1f, 0.7f),new Vector3f(-0.725f, 1.012811f, 0.7f),new Vector3f(-0.725f, 0.1f, 0.061033f),new Vector2f(0.438831f, 0.742411f),new Vector2f(0.407584f, 0.764291f),new Vector2f(0.376328f, 0.719652f),new Vector2f(0.376231f, 0.02326f),new Vector3f(4.0f, -4.0E-6f, 2.0E-6f));
		this.quads[67] = new ObjQuad(new Vector3f(-0.725f, 0.18719f, -0.0f),new Vector3f(-0.725f, 1.1f, 0.638967f),new Vector3f(-0.725f, 0.1f, 0.061033f),new Vector3f(-0.725f, 0.1f, -0.0f),new Vector2f(0.438734f, 0.046019f),new Vector2f(0.438831f, 0.742411f),new Vector2f(0.376231f, 0.02326f),new Vector2f(0.407478f, 0.001381f),new Vector3f(4.0f, -1.0E-6f, 1.0E-6f));
		this.quads[68] = new ObjQuad(new Vector3f(0.725f, 1.01281f, 0.7f),new Vector3f(0.725f, 1.1f, 0.7f),new Vector3f(0.725f, 1.1f, 0.638967f),new Vector3f(0.725f, 0.1f, 0.061033f),new Vector2f(0.626535f, 0.719653f),new Vector2f(0.595279f, 0.764291f),new Vector2f(0.564032f, 0.742412f),new Vector2f(0.626632f, 0.023261f),new Vector3f(-4.0f, -4.0E-6f, -2.0E-6f));
		this.quads[69] = new ObjQuad(new Vector3f(0.725f, 0.1f, 0.061033f),new Vector3f(0.725f, 1.1f, 0.638967f),new Vector3f(0.725f, 0.18719f, -0.0f),new Vector3f(0.725f, 0.1f, -0.0f),new Vector2f(0.626632f, 0.023261f),new Vector2f(0.564032f, 0.742412f),new Vector2f(0.564129f, 0.04602f),new Vector2f(0.595385f, 0.001381f),new Vector3f(-4.0f, -1.0E-6f, 0.0f));
		this.quads[70] = new ObjQuad(new Vector3f(0.725f, 1.1f, 0.638967f),new Vector3f(0.775f, 1.1f, 0.638967f),new Vector3f(0.775f, 0.18719f, -0.0f),new Vector3f(0.725f, 0.18719f, -0.0f),new Vector2f(0.96887f, 0.570398f),new Vector2f(0.93762f, 0.570398f),new Vector2f(0.93762f, -1.08E-4f),new Vector2f(0.96887f, -1.08E-4f),new Vector3f(0.0f, 2.293848f, -3.276928f));
		this.quads[71] = new ObjQuad(new Vector3f(0.775f, 1.012811f, -0.7f),new Vector3f(0.775f, 1.1f, -0.7f),new Vector3f(0.775f, 1.1f, -0.638967f),new Vector3f(0.775f, 0.1f, -0.061033f),new Vector2f(0.563227f, 0.719312f),new Vector2f(0.531971f, 0.76395f),new Vector2f(0.500724f, 0.74207f),new Vector2f(0.563324f, 0.022919f),new Vector3f(4.0f, 1.0E-6f, 0.0f));
		this.quads[72] = new ObjQuad(new Vector3f(0.775f, 0.1f, -0.061033f),new Vector3f(0.775f, 1.1f, -0.638967f),new Vector3f(0.775f, 0.18719f, -0.0f),new Vector3f(0.775f, 0.1f, -0.0f),new Vector2f(0.563324f, 0.022919f),new Vector2f(0.500724f, 0.74207f),new Vector2f(0.500821f, 0.045679f),new Vector2f(0.532078f, 0.00104f),new Vector3f(4.0f, -1.0E-6f, 0.0f));
		this.quads[73] = new ObjQuad(new Vector3f(0.775f, 1.1f, -0.638967f),new Vector3f(0.725f, 1.1f, -0.638967f),new Vector3f(0.725f, 0.18719f, -0.0f),new Vector3f(0.775f, 0.18719f, -0.0f),new Vector2f(1.00012f, 0.570398f),new Vector2f(0.96887f, 0.570398f),new Vector2f(0.96887f, -1.08E-4f),new Vector2f(1.00012f, -1.08E-4f),new Vector3f(0.0f, 2.293848f, 3.276928f));
		this.quads[74] = new ObjQuad(new Vector3f(0.775f, 1.01281f, 0.7f),new Vector3f(0.725f, 1.01281f, 0.7f),new Vector3f(0.725f, 0.1f, 0.061033f),new Vector3f(0.775f, 0.1f, 0.061033f),new Vector2f(0.968922f, 0.570455f),new Vector2f(0.937672f, 0.570455f),new Vector2f(0.937672f, -5.2E-5f),new Vector2f(0.968922f, -5.2E-5f),new Vector3f(0.0f, -2.293848f, 3.276928f));
		this.quads[75] = new ObjQuad(new Vector3f(0.775f, 1.1f, 0.638967f),new Vector3f(0.775f, 1.1f, 0.7f),new Vector3f(0.775f, 1.01281f, 0.7f),new Vector3f(0.775f, 0.1f, 0.061033f),new Vector2f(0.625925f, 0.74207f),new Vector2f(0.594678f, 0.76395f),new Vector2f(0.563421f, 0.719311f),new Vector2f(0.563324f, 0.022919f),new Vector3f(4.0f, 1.0E-6f, 0.0f));
		this.quads[76] = new ObjQuad(new Vector3f(0.775f, 0.18719f, -0.0f),new Vector3f(0.775f, 1.1f, 0.638967f),new Vector3f(0.775f, 0.1f, 0.061033f),new Vector3f(0.775f, 0.1f, -0.0f),new Vector2f(0.625828f, 0.045679f),new Vector2f(0.625925f, 0.74207f),new Vector2f(0.563324f, 0.022919f),new Vector2f(0.594571f, 0.00104f),new Vector3f(4.0f, -1.0E-6f, 0.0f));
		this.quads[77] = new ObjQuad(new Vector3f(0.725f, 1.012811f, -0.7f),new Vector3f(0.775f, 1.012811f, -0.7f),new Vector3f(0.775f, 0.1f, -0.061033f),new Vector3f(0.725f, 0.1f, -0.061033f),new Vector2f(0.688018f, 0.570327f),new Vector2f(0.656768f, 0.570327f),new Vector2f(0.656768f, -1.8E-4f),new Vector2f(0.688018f, -1.8E-4f),new Vector3f(0.0f, -2.293848f, -3.276928f));
		this.quads[78] = new ObjQuad(new Vector3f(0.725f, 1.1f, -0.638967f),new Vector3f(0.725f, 1.1f, -0.7f),new Vector3f(0.725f, 1.012811f, -0.7f),new Vector3f(0.725f, 0.1f, -0.061033f),new Vector2f(0.501432f, 0.742411f),new Vector2f(0.470185f, 0.76429f),new Vector2f(0.438929f, 0.719652f),new Vector2f(0.438831f, 0.02326f),new Vector3f(-4.0f, -3.0E-6f, -1.0E-6f));
		this.quads[79] = new ObjQuad(new Vector3f(0.725f, 0.18719f, -0.0f),new Vector3f(0.725f, 1.1f, -0.638967f),new Vector3f(0.725f, 0.1f, -0.061033f),new Vector3f(0.725f, 0.1f, -0.0f),new Vector2f(0.501335f, 0.046019f),new Vector2f(0.501432f, 0.742411f),new Vector2f(0.438831f, 0.02326f),new Vector2f(0.470078f, 0.001381f),new Vector3f(-4.0f, -1.0E-6f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		RaintankFrame other = new RaintankFrame();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

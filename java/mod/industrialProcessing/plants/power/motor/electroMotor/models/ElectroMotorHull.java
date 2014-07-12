package mod.industrialProcessing.plants.power.motor.electroMotor.models;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class ElectroMotorHull extends ObjMesh{
	public ElectroMotorHull(){
		this.quads = new ObjQuad[90];
		this.quads[0] = new ObjQuad(new Vector3f(0.6f, 0.8f, 0.640685f),new Vector3f(-0.6f, 0.8f, 0.640685f),new Vector3f(-0.6f, 0.423415f, 0.518325f),new Vector3f(0.6f, 0.423415f, 0.518325f),new Vector2f(0.5f, 0.125f),new Vector2f(0.5f, 0.875f),new Vector2f(0.264634f, 0.875f),new Vector2f(0.264634f, 0.125f),new Vector3f(0.0f, -1.236068f, 3.804228f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.6f, 0.8f, 0.640685f),new Vector3f(-0.6f, 0.8f, 0.550134f),new Vector3f(-0.6f, 0.476639f, 0.445068f),new Vector3f(-0.6f, 0.423415f, 0.518325f),new Vector2f(0.5f, 0.099572f),new Vector2f(0.5f, 0.156166f),new Vector2f(0.2979f, 0.221833f),new Vector2f(0.264634f, 0.176047f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.6f, 0.8f, 0.550134f),new Vector3f(0.6f, 0.8f, 0.640685f),new Vector3f(0.6f, 0.423415f, 0.518325f),new Vector3f(0.6f, 0.476639f, 0.445068f),new Vector2f(0.5f, 0.156166f),new Vector2f(0.5f, 0.099572f),new Vector2f(0.735366f, 0.176047f),new Vector2f(0.702101f, 0.221833f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.6f, 0.423415f, 0.518325f),new Vector3f(-0.6f, 0.423415f, 0.518325f),new Vector3f(-0.6f, 0.190672f, 0.197983f),new Vector3f(0.6f, 0.190672f, 0.197982f),new Vector2f(0.823953f, 0.125f),new Vector2f(0.823953f, 0.875f),new Vector2f(0.623739f, 0.875f),new Vector2f(0.623739f, 0.125f),new Vector3f(0.0f, -3.236068f, 2.35114f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.6f, 0.423415f, 0.518325f),new Vector3f(-0.6f, 0.476639f, 0.445068f),new Vector3f(-0.6f, 0.276791f, 0.170001f),new Vector3f(-0.6f, 0.190672f, 0.197983f),new Vector2f(0.264634f, 0.176047f),new Vector2f(0.2979f, 0.221833f),new Vector2f(0.172995f, 0.39375f),new Vector2f(0.11917f, 0.376261f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(0.6f, 0.476639f, 0.445068f),new Vector3f(0.6f, 0.423415f, 0.518325f),new Vector3f(0.6f, 0.190672f, 0.197982f),new Vector3f(0.6f, 0.276792f, 0.170001f),new Vector2f(0.702101f, 0.221833f),new Vector2f(0.735366f, 0.176047f),new Vector2f(0.88083f, 0.376261f),new Vector2f(0.827005f, 0.39375f),new Vector3f(4.0f, 4.0E-6f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(0.6f, 0.190672f, 0.197982f),new Vector3f(-0.6f, 0.190672f, 0.197983f),new Vector3f(-0.6f, 0.190672f, -0.197983f),new Vector3f(0.6f, 0.190672f, -0.197983f),new Vector2f(0.623739f, 0.125f),new Vector2f(0.623739f, 0.875f),new Vector2f(0.376261f, 0.875f),new Vector2f(0.376261f, 0.125f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.6f, 0.190672f, 0.197983f),new Vector3f(-0.6f, 0.276791f, 0.170001f),new Vector3f(-0.6f, 0.276791f, -0.170001f),new Vector3f(-0.6f, 0.190672f, -0.197983f),new Vector2f(0.11917f, 0.376261f),new Vector2f(0.172995f, 0.39375f),new Vector2f(0.172995f, 0.606251f),new Vector2f(0.11917f, 0.623739f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(0.6f, 0.276792f, 0.170001f),new Vector3f(0.6f, 0.190672f, 0.197982f),new Vector3f(0.6f, 0.190672f, -0.197983f),new Vector3f(0.6f, 0.276792f, -0.170001f),new Vector2f(0.827005f, 0.39375f),new Vector2f(0.88083f, 0.376261f),new Vector2f(0.88083f, 0.623739f),new Vector2f(0.827005f, 0.606251f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[9] = new ObjQuad(new Vector3f(0.6f, 0.190672f, -0.197983f),new Vector3f(-0.6f, 0.190672f, -0.197983f),new Vector3f(-0.6f, 0.423415f, -0.518325f),new Vector3f(0.6f, 0.423415f, -0.518325f),new Vector2f(0.376261f, 0.125f),new Vector2f(0.376261f, 0.875f),new Vector2f(0.176047f, 0.875f),new Vector2f(0.176047f, 0.125f),new Vector3f(0.0f, -3.236068f, -2.35114f));
		this.quads[10] = new ObjQuad(new Vector3f(-0.6f, 0.190672f, -0.197983f),new Vector3f(-0.6f, 0.276791f, -0.170001f),new Vector3f(-0.6f, 0.476639f, -0.445068f),new Vector3f(-0.6f, 0.423415f, -0.518325f),new Vector2f(0.11917f, 0.623739f),new Vector2f(0.172995f, 0.606251f),new Vector2f(0.2979f, 0.778167f),new Vector2f(0.264634f, 0.823953f),new Vector3f(-4.0f, -4.0E-6f, -4.0E-6f));
		this.quads[11] = new ObjQuad(new Vector3f(0.6f, 0.276792f, -0.170001f),new Vector3f(0.6f, 0.190672f, -0.197983f),new Vector3f(0.6f, 0.423415f, -0.518325f),new Vector3f(0.6f, 0.47664f, -0.445068f),new Vector2f(0.827005f, 0.606251f),new Vector2f(0.88083f, 0.623739f),new Vector2f(0.735366f, 0.823953f),new Vector2f(0.7021f, 0.778167f),new Vector3f(4.0f, 4.0E-6f, 0.0f));
		this.quads[12] = new ObjQuad(new Vector3f(0.6f, 0.423415f, -0.518325f),new Vector3f(-0.6f, 0.423415f, -0.518325f),new Vector3f(-0.6f, 0.8f, -0.640685f),new Vector3f(0.6f, 0.8f, -0.640685f),new Vector2f(0.735366f, 0.125f),new Vector2f(0.735366f, 0.875f),new Vector2f(0.5f, 0.875f),new Vector2f(0.5f, 0.125f),new Vector3f(0.0f, -1.236068f, -3.804228f));
		this.quads[13] = new ObjQuad(new Vector3f(-0.6f, 0.423415f, -0.518325f),new Vector3f(-0.6f, 0.476639f, -0.445068f),new Vector3f(-0.6f, 0.8f, -0.550134f),new Vector3f(-0.6f, 0.8f, -0.640685f),new Vector2f(0.264634f, 0.823953f),new Vector2f(0.2979f, 0.778167f),new Vector2f(0.5f, 0.843834f),new Vector2f(0.5f, 0.900428f),new Vector3f(-4.0f, -4.0E-6f, -4.0E-6f));
		this.quads[14] = new ObjQuad(new Vector3f(0.6f, 0.47664f, -0.445068f),new Vector3f(0.6f, 0.423415f, -0.518325f),new Vector3f(0.6f, 0.8f, -0.640685f),new Vector3f(0.6f, 0.8f, -0.550134f),new Vector2f(0.7021f, 0.778167f),new Vector2f(0.735366f, 0.823953f),new Vector2f(0.5f, 0.900428f),new Vector2f(0.5f, 0.843834f),new Vector3f(4.0f, 4.0E-6f, 4.0E-6f));
		this.quads[15] = new ObjQuad(new Vector3f(0.6f, 0.8f, -0.640685f),new Vector3f(-0.6f, 0.8f, -0.640685f),new Vector3f(-0.6f, 1.176585f, -0.518325f),new Vector3f(0.6f, 1.176585f, -0.518325f),new Vector2f(0.5f, 0.125f),new Vector2f(0.5f, 0.875f),new Vector2f(0.264634f, 0.875f),new Vector2f(0.264634f, 0.125f),new Vector3f(0.0f, 1.236068f, -3.804228f));
		this.quads[16] = new ObjQuad(new Vector3f(-0.6f, 0.8f, -0.640685f),new Vector3f(-0.6f, 0.8f, -0.550134f),new Vector3f(-0.6f, 1.12336f, -0.445068f),new Vector3f(-0.6f, 1.176585f, -0.518325f),new Vector2f(0.5f, 0.900428f),new Vector2f(0.5f, 0.843834f),new Vector2f(0.7021f, 0.778167f),new Vector2f(0.735366f, 0.823953f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[17] = new ObjQuad(new Vector3f(0.6f, 0.8f, -0.550134f),new Vector3f(0.6f, 0.8f, -0.640685f),new Vector3f(0.6f, 1.176585f, -0.518325f),new Vector3f(0.6f, 1.123361f, -0.445068f),new Vector2f(0.5f, 0.843834f),new Vector2f(0.5f, 0.900428f),new Vector2f(0.264634f, 0.823953f),new Vector2f(0.2979f, 0.778167f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[18] = new ObjQuad(new Vector3f(0.6f, 1.176585f, -0.518325f),new Vector3f(-0.6f, 1.176585f, -0.518325f),new Vector3f(-0.6f, 1.409327f, -0.197982f),new Vector3f(0.6f, 1.409328f, -0.197982f),new Vector2f(0.823953f, 0.125f),new Vector2f(0.823953f, 0.875f),new Vector2f(0.623739f, 0.875f),new Vector2f(0.623739f, 0.125f),new Vector3f(0.0f, 3.236068f, -2.35114f));
		this.quads[19] = new ObjQuad(new Vector3f(-0.6f, 1.176585f, -0.518325f),new Vector3f(-0.6f, 1.12336f, -0.445068f),new Vector3f(-0.6f, 1.323208f, -0.170001f),new Vector3f(-0.6f, 1.409327f, -0.197982f),new Vector2f(0.735366f, 0.823953f),new Vector2f(0.7021f, 0.778167f),new Vector2f(0.827005f, 0.60625f),new Vector2f(0.88083f, 0.623739f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[20] = new ObjQuad(new Vector3f(0.6f, 1.123361f, -0.445068f),new Vector3f(0.6f, 1.176585f, -0.518325f),new Vector3f(0.6f, 1.409328f, -0.197982f),new Vector3f(0.6f, 1.323208f, -0.170001f),new Vector2f(0.2979f, 0.778167f),new Vector2f(0.264634f, 0.823953f),new Vector2f(0.11917f, 0.623739f),new Vector2f(0.172995f, 0.60625f),new Vector3f(4.0f, 4.0E-6f, 0.0f));
		this.quads[21] = new ObjQuad(new Vector3f(0.6f, 1.409328f, -0.197982f),new Vector3f(-0.6f, 1.409327f, -0.197982f),new Vector3f(-0.6f, 1.409327f, 0.197983f),new Vector3f(0.6f, 1.409328f, 0.197983f),new Vector2f(0.623739f, 0.125f),new Vector2f(0.623739f, 0.875f),new Vector2f(0.376261f, 0.875f),new Vector2f(0.376261f, 0.125f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[22] = new ObjQuad(new Vector3f(-0.6f, 1.409327f, -0.197982f),new Vector3f(-0.6f, 1.323208f, -0.170001f),new Vector3f(-0.6f, 1.323208f, 0.170001f),new Vector3f(-0.6f, 1.409327f, 0.197983f),new Vector2f(0.88083f, 0.623739f),new Vector2f(0.827005f, 0.60625f),new Vector2f(0.827005f, 0.393749f),new Vector2f(0.88083f, 0.376261f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[23] = new ObjQuad(new Vector3f(0.6f, 1.323208f, -0.170001f),new Vector3f(0.6f, 1.409328f, -0.197982f),new Vector3f(0.6f, 1.409328f, 0.197983f),new Vector3f(0.6f, 1.323208f, 0.170001f),new Vector2f(0.172995f, 0.60625f),new Vector2f(0.11917f, 0.623739f),new Vector2f(0.11917f, 0.376261f),new Vector2f(0.172995f, 0.39375f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[24] = new ObjQuad(new Vector3f(0.6f, 1.409328f, 0.197983f),new Vector3f(-0.6f, 1.409327f, 0.197983f),new Vector3f(-0.6f, 1.176585f, 0.518325f),new Vector3f(0.6f, 1.176585f, 0.518325f),new Vector2f(0.376261f, 0.125f),new Vector2f(0.376261f, 0.875f),new Vector2f(0.176047f, 0.875f),new Vector2f(0.176047f, 0.125f),new Vector3f(0.0f, 3.236068f, 2.35114f));
		this.quads[25] = new ObjQuad(new Vector3f(-0.6f, 1.409327f, 0.197983f),new Vector3f(-0.6f, 1.323208f, 0.170001f),new Vector3f(-0.6f, 1.12336f, 0.445068f),new Vector3f(-0.6f, 1.176585f, 0.518325f),new Vector2f(0.88083f, 0.376261f),new Vector2f(0.827005f, 0.393749f),new Vector2f(0.7021f, 0.221833f),new Vector2f(0.735366f, 0.176047f),new Vector3f(-4.0f, -4.0E-6f, -4.0E-6f));
		this.quads[26] = new ObjQuad(new Vector3f(0.6f, 1.323208f, 0.170001f),new Vector3f(0.6f, 1.409328f, 0.197983f),new Vector3f(0.6f, 1.176585f, 0.518325f),new Vector3f(0.6f, 1.123361f, 0.445068f),new Vector2f(0.172995f, 0.39375f),new Vector2f(0.11917f, 0.376261f),new Vector2f(0.264634f, 0.176047f),new Vector2f(0.2979f, 0.221833f),new Vector3f(4.0f, 4.0E-6f, 0.0f));
		this.quads[27] = new ObjQuad(new Vector3f(0.6f, 1.176585f, 0.518325f),new Vector3f(-0.6f, 1.176585f, 0.518325f),new Vector3f(-0.6f, 0.8f, 0.640685f),new Vector3f(0.6f, 0.8f, 0.640685f),new Vector2f(0.735366f, 0.125f),new Vector2f(0.735366f, 0.875f),new Vector2f(0.5f, 0.875f),new Vector2f(0.5f, 0.125f),new Vector3f(0.0f, 1.236068f, 3.804224f));
		this.quads[28] = new ObjQuad(new Vector3f(-0.6f, 1.176585f, 0.518325f),new Vector3f(-0.6f, 1.12336f, 0.445068f),new Vector3f(-0.6f, 0.8f, 0.550134f),new Vector3f(-0.6f, 0.8f, 0.640685f),new Vector2f(0.735366f, 0.176047f),new Vector2f(0.7021f, 0.221833f),new Vector2f(0.5f, 0.156166f),new Vector2f(0.5f, 0.099572f),new Vector3f(-4.0f, -4.0E-6f, -4.0E-6f));
		this.quads[29] = new ObjQuad(new Vector3f(0.6f, 1.123361f, 0.445068f),new Vector3f(0.6f, 1.176585f, 0.518325f),new Vector3f(0.6f, 0.8f, 0.640685f),new Vector3f(0.6f, 0.8f, 0.550134f),new Vector2f(0.2979f, 0.221833f),new Vector2f(0.264634f, 0.176047f),new Vector2f(0.5f, 0.099572f),new Vector2f(0.5f, 0.156166f),new Vector3f(4.0f, 4.0E-6f, 4.0E-6f));
		this.quads[30] = new ObjQuad(new Vector3f(-0.7f, 1.12336f, 0.445068f),new Vector3f(-0.7f, 1.323208f, 0.170001f),new Vector3f(-0.7f, 1.323208f, -0.170001f),new Vector3f(-0.7f, 0.476639f, 0.445068f),new Vector2f(0.7021f, 0.221833f),new Vector2f(0.827005f, 0.393749f),new Vector2f(0.827005f, 0.60625f),new Vector2f(0.2979f, 0.221833f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[31] = new ObjQuad(new Vector3f(-0.7f, 1.323208f, -0.170001f),new Vector3f(-0.7f, 1.12336f, -0.445067f),new Vector3f(-0.7f, 0.8f, -0.550134f),new Vector3f(-0.7f, 0.476639f, 0.445068f),new Vector2f(0.827005f, 0.60625f),new Vector2f(0.7021f, 0.778167f),new Vector2f(0.5f, 0.843834f),new Vector2f(0.2979f, 0.221833f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[32] = new ObjQuad(new Vector3f(-0.7f, 0.8f, -0.550134f),new Vector3f(-0.7f, 0.476639f, -0.445067f),new Vector3f(-0.7f, 0.276791f, -0.170001f),new Vector3f(-0.7f, 0.476639f, 0.445068f),new Vector2f(0.5f, 0.843834f),new Vector2f(0.2979f, 0.778167f),new Vector2f(0.172995f, 0.606251f),new Vector2f(0.2979f, 0.221833f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[33] = new ObjQuad(new Vector3f(-0.7f, 0.276791f, -0.170001f),new Vector3f(-0.7f, 0.276791f, 0.170001f),new Vector3f(-0.7f, 0.476639f, 0.445068f),new Vector2f(0.172995f, 0.606251f),new Vector2f(0.172995f, 0.39375f),new Vector2f(0.2979f, 0.221833f),new Vector3f(-3.0f, 0.0f, 0.0f));
		this.quads[34] = new ObjQuad(new Vector3f(-0.7f, 0.8f, 0.550134f),new Vector3f(-0.7f, 1.12336f, 0.445068f),new Vector3f(-0.7f, 0.476639f, 0.445068f),new Vector2f(0.5f, 0.156166f),new Vector2f(0.7021f, 0.221833f),new Vector2f(0.2979f, 0.221833f),new Vector3f(-3.0f, 0.0f, 0.0f));
		this.quads[35] = new ObjQuad(new Vector3f(0.7f, 0.276792f, 0.170001f),new Vector3f(0.7f, 0.276792f, -0.170001f),new Vector3f(0.7f, 0.47664f, -0.445068f),new Vector3f(0.7f, 0.8f, 0.550134f),new Vector2f(0.827005f, 0.39375f),new Vector2f(0.827005f, 0.606251f),new Vector2f(0.7021f, 0.778167f),new Vector2f(0.5f, 0.156166f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[36] = new ObjQuad(new Vector3f(0.7f, 0.47664f, -0.445068f),new Vector3f(0.7f, 0.8f, -0.550134f),new Vector3f(0.7f, 1.123361f, -0.445068f),new Vector3f(0.7f, 0.8f, 0.550134f),new Vector2f(0.7021f, 0.778167f),new Vector2f(0.5f, 0.843834f),new Vector2f(0.2979f, 0.778167f),new Vector2f(0.5f, 0.156166f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[37] = new ObjQuad(new Vector3f(0.7f, 1.123361f, -0.445068f),new Vector3f(0.7f, 1.323208f, -0.170001f),new Vector3f(0.7f, 1.323208f, 0.170001f),new Vector3f(0.7f, 0.8f, 0.550134f),new Vector2f(0.2979f, 0.778167f),new Vector2f(0.172995f, 0.60625f),new Vector2f(0.172995f, 0.39375f),new Vector2f(0.5f, 0.156166f),new Vector3f(4.0f, 4.0E-6f, 0.0f));
		this.quads[38] = new ObjQuad(new Vector3f(0.7f, 1.323208f, 0.170001f),new Vector3f(0.7f, 1.123361f, 0.445068f),new Vector3f(0.7f, 0.8f, 0.550134f),new Vector2f(0.172995f, 0.39375f),new Vector2f(0.2979f, 0.221833f),new Vector2f(0.5f, 0.156166f),new Vector3f(3.0f, 0.0f, -3.0E-6f));
		this.quads[39] = new ObjQuad(new Vector3f(0.7f, 0.476639f, 0.445068f),new Vector3f(0.7f, 0.276792f, 0.170001f),new Vector3f(0.7f, 0.8f, 0.550134f),new Vector2f(0.7021f, 0.221833f),new Vector2f(0.827005f, 0.39375f),new Vector2f(0.5f, 0.156166f),new Vector3f(3.0f, 0.0f, 3.0E-6f));
		this.quads[40] = new ObjQuad(new Vector3f(-0.6f, 0.476639f, 0.445068f),new Vector3f(-0.6f, 0.8f, 0.550134f),new Vector3f(-0.7f, 0.8f, 0.550134f),new Vector3f(-0.7f, 0.476639f, 0.445068f),new Vector2f(0.2979f, 0.875f),new Vector2f(0.5f, 0.875f),new Vector2f(0.5f, 0.9375f),new Vector2f(0.2979f, 0.9375f),new Vector3f(0.0f, -1.236068f, 3.804224f));
		this.quads[41] = new ObjQuad(new Vector3f(-0.6f, 0.8f, 0.550134f),new Vector3f(-0.6f, 1.12336f, 0.445068f),new Vector3f(-0.7f, 1.12336f, 0.445068f),new Vector3f(-0.7f, 0.8f, 0.550134f),new Vector2f(0.5f, 0.875f),new Vector2f(0.7021f, 0.875f),new Vector2f(0.7021f, 0.9375f),new Vector2f(0.5f, 0.9375f),new Vector3f(0.0f, 1.236068f, 3.804224f));
		this.quads[42] = new ObjQuad(new Vector3f(-0.6f, 1.12336f, 0.445068f),new Vector3f(-0.6f, 1.323208f, 0.170001f),new Vector3f(-0.7f, 1.323208f, 0.170001f),new Vector3f(-0.7f, 1.12336f, 0.445068f),new Vector2f(0.221833f, 0.875f),new Vector2f(0.393749f, 0.875f),new Vector2f(0.393749f, 0.9375f),new Vector2f(0.221833f, 0.9375f),new Vector3f(0.0f, 3.236068f, 2.351144f));
		this.quads[43] = new ObjQuad(new Vector3f(-0.6f, 1.323208f, 0.170001f),new Vector3f(-0.6f, 1.323208f, -0.170001f),new Vector3f(-0.7f, 1.323208f, -0.170001f),new Vector3f(-0.7f, 1.323208f, 0.170001f),new Vector2f(0.393749f, 0.875f),new Vector2f(0.60625f, 0.875f),new Vector2f(0.60625f, 0.9375f),new Vector2f(0.393749f, 0.9375f),new Vector3f(-4.0E-6f, 4.0f, 0.0f));
		this.quads[44] = new ObjQuad(new Vector3f(-0.6f, 1.323208f, -0.170001f),new Vector3f(-0.6f, 1.12336f, -0.445068f),new Vector3f(-0.7f, 1.12336f, -0.445067f),new Vector3f(-0.7f, 1.323208f, -0.170001f),new Vector2f(0.60625f, 0.875f),new Vector2f(0.778167f, 0.875f),new Vector2f(0.778167f, 0.9375f),new Vector2f(0.60625f, 0.9375f),new Vector3f(0.0f, 3.236068f, -2.35114f));
		this.quads[45] = new ObjQuad(new Vector3f(-0.6f, 1.12336f, -0.445068f),new Vector3f(-0.6f, 0.8f, -0.550134f),new Vector3f(-0.7f, 0.8f, -0.550134f),new Vector3f(-0.7f, 1.12336f, -0.445067f),new Vector2f(0.2979f, 0.875f),new Vector2f(0.5f, 0.875f),new Vector2f(0.5f, 0.9375f),new Vector2f(0.2979f, 0.9375f),new Vector3f(0.0f, 1.236068f, -3.804228f));
		this.quads[46] = new ObjQuad(new Vector3f(-0.6f, 0.8f, -0.550134f),new Vector3f(-0.6f, 0.476639f, -0.445068f),new Vector3f(-0.7f, 0.476639f, -0.445067f),new Vector3f(-0.7f, 0.8f, -0.550134f),new Vector2f(0.5f, 0.875f),new Vector2f(0.7021f, 0.875f),new Vector2f(0.7021f, 0.9375f),new Vector2f(0.5f, 0.9375f),new Vector3f(0.0f, -1.236068f, -3.804228f));
		this.quads[47] = new ObjQuad(new Vector3f(-0.6f, 0.476639f, -0.445068f),new Vector3f(-0.6f, 0.276791f, -0.170001f),new Vector3f(-0.7f, 0.276791f, -0.170001f),new Vector3f(-0.7f, 0.476639f, -0.445067f),new Vector2f(0.221833f, 0.875f),new Vector2f(0.393749f, 0.875f),new Vector2f(0.393749f, 0.9375f),new Vector2f(0.221833f, 0.9375f),new Vector3f(0.0f, -3.236068f, -2.35114f));
		this.quads[48] = new ObjQuad(new Vector3f(-0.6f, 0.276791f, -0.170001f),new Vector3f(-0.6f, 0.276791f, 0.170001f),new Vector3f(-0.7f, 0.276791f, 0.170001f),new Vector3f(-0.7f, 0.276791f, -0.170001f),new Vector2f(0.393749f, 0.875f),new Vector2f(0.60625f, 0.875f),new Vector2f(0.60625f, 0.9375f),new Vector2f(0.393749f, 0.9375f),new Vector3f(4.0E-6f, -4.0f, 0.0f));
		this.quads[49] = new ObjQuad(new Vector3f(-0.6f, 0.276791f, 0.170001f),new Vector3f(-0.6f, 0.476639f, 0.445068f),new Vector3f(-0.7f, 0.476639f, 0.445068f),new Vector3f(-0.7f, 0.276791f, 0.170001f),new Vector2f(0.60625f, 0.875f),new Vector2f(0.778167f, 0.875f),new Vector2f(0.778167f, 0.9375f),new Vector2f(0.60625f, 0.9375f),new Vector3f(0.0f, -3.236068f, 2.35114f));
		this.quads[50] = new ObjQuad(new Vector3f(0.6f, 0.8f, 0.550134f),new Vector3f(0.6f, 0.476639f, 0.445068f),new Vector3f(0.7f, 0.476639f, 0.445068f),new Vector3f(0.7f, 0.8f, 0.550134f),new Vector2f(0.5f, 0.125f),new Vector2f(0.2979f, 0.125f),new Vector2f(0.2979f, 0.0625f),new Vector2f(0.5f, 0.0625f),new Vector3f(0.0f, -1.236068f, 3.804228f));
		this.quads[51] = new ObjQuad(new Vector3f(0.6f, 0.476639f, 0.445068f),new Vector3f(0.6f, 0.276792f, 0.170001f),new Vector3f(0.7f, 0.276792f, 0.170001f),new Vector3f(0.7f, 0.476639f, 0.445068f),new Vector2f(0.778167f, 0.125f),new Vector2f(0.60625f, 0.125f),new Vector2f(0.60625f, 0.0625f),new Vector2f(0.778167f, 0.0625f),new Vector3f(0.0f, -3.236068f, 2.35114f));
		this.quads[52] = new ObjQuad(new Vector3f(0.6f, 0.276792f, 0.170001f),new Vector3f(0.6f, 0.276792f, -0.170001f),new Vector3f(0.7f, 0.276792f, -0.170001f),new Vector3f(0.7f, 0.276792f, 0.170001f),new Vector2f(0.60625f, 0.125f),new Vector2f(0.393749f, 0.125f),new Vector2f(0.393749f, 0.0625f),new Vector2f(0.60625f, 0.0625f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[53] = new ObjQuad(new Vector3f(0.6f, 0.276792f, -0.170001f),new Vector3f(0.6f, 0.47664f, -0.445068f),new Vector3f(0.7f, 0.47664f, -0.445068f),new Vector3f(0.7f, 0.276792f, -0.170001f),new Vector2f(0.393749f, 0.125f),new Vector2f(0.221833f, 0.125f),new Vector2f(0.221833f, 0.0625f),new Vector2f(0.393749f, 0.0625f),new Vector3f(0.0f, -3.236068f, -2.35114f));
		this.quads[54] = new ObjQuad(new Vector3f(0.6f, 0.47664f, -0.445068f),new Vector3f(0.6f, 0.8f, -0.550134f),new Vector3f(0.7f, 0.8f, -0.550134f),new Vector3f(0.7f, 0.47664f, -0.445068f),new Vector2f(0.7021f, 0.125f),new Vector2f(0.5f, 0.125f),new Vector2f(0.5f, 0.0625f),new Vector2f(0.7021f, 0.0625f),new Vector3f(0.0f, -1.236068f, -3.804224f));
		this.quads[55] = new ObjQuad(new Vector3f(0.6f, 0.8f, -0.550134f),new Vector3f(0.6f, 1.123361f, -0.445068f),new Vector3f(0.7f, 1.123361f, -0.445068f),new Vector3f(0.7f, 0.8f, -0.550134f),new Vector2f(0.5f, 0.125f),new Vector2f(0.2979f, 0.125f),new Vector2f(0.2979f, 0.0625f),new Vector2f(0.5f, 0.0625f),new Vector3f(-4.0E-6f, 1.236068f, -3.804224f));
		this.quads[56] = new ObjQuad(new Vector3f(0.6f, 1.123361f, -0.445068f),new Vector3f(0.6f, 1.323208f, -0.170001f),new Vector3f(0.7f, 1.323208f, -0.170001f),new Vector3f(0.7f, 1.123361f, -0.445068f),new Vector2f(0.778167f, 0.125f),new Vector2f(0.60625f, 0.125f),new Vector2f(0.60625f, 0.0625f),new Vector2f(0.778167f, 0.0625f),new Vector3f(0.0f, 3.236068f, -2.35114f));
		this.quads[57] = new ObjQuad(new Vector3f(0.6f, 1.323208f, -0.170001f),new Vector3f(0.6f, 1.323208f, 0.170001f),new Vector3f(0.7f, 1.323208f, 0.170001f),new Vector3f(0.7f, 1.323208f, -0.170001f),new Vector2f(0.60625f, 0.125f),new Vector2f(0.39375f, 0.125f),new Vector2f(0.39375f, 0.0625f),new Vector2f(0.60625f, 0.0625f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[58] = new ObjQuad(new Vector3f(0.6f, 1.323208f, 0.170001f),new Vector3f(0.6f, 1.123361f, 0.445068f),new Vector3f(0.7f, 1.123361f, 0.445068f),new Vector3f(0.7f, 1.323208f, 0.170001f),new Vector2f(0.39375f, 0.125f),new Vector2f(0.221833f, 0.125f),new Vector2f(0.221833f, 0.0625f),new Vector2f(0.39375f, 0.0625f),new Vector3f(0.0f, 3.236068f, 2.35114f));
		this.quads[59] = new ObjQuad(new Vector3f(0.6f, 1.123361f, 0.445068f),new Vector3f(0.6f, 0.8f, 0.550134f),new Vector3f(0.7f, 0.8f, 0.550134f),new Vector3f(0.7f, 1.123361f, 0.445068f),new Vector2f(0.7021f, 0.125f),new Vector2f(0.5f, 0.125f),new Vector2f(0.5f, 0.0625f),new Vector2f(0.7021f, 0.0625f),new Vector3f(0.0f, 1.236068f, 3.804224f));
		this.quads[60] = new ObjQuad(new Vector3f(0.8f, 0.8f, 0.3f),new Vector3f(0.7f, 0.8f, 0.3f),new Vector3f(0.7f, 0.623664f, 0.242705f),new Vector3f(0.8f, 0.623664f, 0.242705f),new Vector2f(0.5f, 0.46875f),new Vector2f(0.5f, 0.53125f),new Vector2f(0.38979f, 0.53125f),new Vector2f(0.38979f, 0.46875f),new Vector3f(0.0f, -1.236068f, 3.804228f));
		this.quads[61] = new ObjQuad(new Vector3f(0.7f, 0.8f, 0.2f),new Vector3f(0.8f, 0.8f, 0.2f),new Vector3f(0.8f, 0.682443f, 0.161803f),new Vector3f(0.7f, 0.682443f, 0.161803f),new Vector2f(0.5f, 0.53125f),new Vector2f(0.5f, 0.46875f),new Vector2f(0.573473f, 0.46875f),new Vector2f(0.573473f, 0.53125f),new Vector3f(0.0f, 1.236068f, -3.804228f));
		this.quads[62] = new ObjQuad(new Vector3f(0.8f, 0.8f, 0.2f),new Vector3f(0.8f, 0.8f, 0.3f),new Vector3f(0.8f, 0.623664f, 0.242705f),new Vector3f(0.8f, 0.682443f, 0.161803f),new Vector2f(0.5f, 0.625f),new Vector2f(0.5f, 0.6875f),new Vector2f(0.38979f, 0.651691f),new Vector2f(0.426527f, 0.601127f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[63] = new ObjQuad(new Vector3f(0.8f, 0.623664f, 0.242705f),new Vector3f(0.7f, 0.623664f, 0.242705f),new Vector3f(0.7f, 0.514683f, 0.092705f),new Vector3f(0.8f, 0.514683f, 0.092705f),new Vector2f(0.651691f, 0.46875f),new Vector2f(0.651691f, 0.53125f),new Vector2f(0.557941f, 0.53125f),new Vector2f(0.557941f, 0.46875f),new Vector3f(0.0f, -3.236068f, 2.35114f));
		this.quads[64] = new ObjQuad(new Vector3f(0.7f, 0.682443f, 0.161803f),new Vector3f(0.8f, 0.682443f, 0.161803f),new Vector3f(0.8f, 0.609789f, 0.061803f),new Vector3f(0.7f, 0.609789f, 0.061803f),new Vector2f(0.398873f, 0.53125f),new Vector2f(0.398873f, 0.46875f),new Vector2f(0.461373f, 0.46875f),new Vector2f(0.461373f, 0.53125f),new Vector3f(0.0f, 3.236068f, -2.35114f));
		this.quads[65] = new ObjQuad(new Vector3f(0.8f, 0.682443f, 0.161803f),new Vector3f(0.8f, 0.623664f, 0.242705f),new Vector3f(0.8f, 0.514683f, 0.092705f),new Vector3f(0.8f, 0.609789f, 0.061803f),new Vector2f(0.426527f, 0.601127f),new Vector2f(0.38979f, 0.651691f),new Vector2f(0.321677f, 0.557941f),new Vector2f(0.381118f, 0.538627f),new Vector3f(4.0f, -4.0E-6f, 0.0f));
		this.quads[66] = new ObjQuad(new Vector3f(0.8f, 0.514683f, 0.092705f),new Vector3f(0.7f, 0.514683f, 0.092705f),new Vector3f(0.7f, 0.514683f, -0.092705f),new Vector3f(0.8f, 0.514683f, -0.092705f),new Vector2f(0.557941f, 0.46875f),new Vector2f(0.557941f, 0.53125f),new Vector2f(0.442059f, 0.53125f),new Vector2f(0.442059f, 0.46875f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[67] = new ObjQuad(new Vector3f(0.7f, 0.609789f, 0.061803f),new Vector3f(0.8f, 0.609789f, 0.061803f),new Vector3f(0.8f, 0.609789f, -0.061803f),new Vector3f(0.7f, 0.609789f, -0.061803f),new Vector2f(0.461373f, 0.53125f),new Vector2f(0.461373f, 0.46875f),new Vector2f(0.538627f, 0.46875f),new Vector2f(0.538627f, 0.53125f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[68] = new ObjQuad(new Vector3f(0.8f, 0.609789f, 0.061803f),new Vector3f(0.8f, 0.514683f, 0.092705f),new Vector3f(0.8f, 0.514683f, -0.092705f),new Vector3f(0.8f, 0.609789f, -0.061803f),new Vector2f(0.381118f, 0.538627f),new Vector2f(0.321677f, 0.557941f),new Vector2f(0.321677f, 0.442059f),new Vector2f(0.381118f, 0.461373f),new Vector3f(4.0f, -8.0E-6f, 0.0f));
		this.quads[69] = new ObjQuad(new Vector3f(0.8f, 0.514683f, -0.092705f),new Vector3f(0.7f, 0.514683f, -0.092705f),new Vector3f(0.7f, 0.623664f, -0.242705f),new Vector3f(0.8f, 0.623664f, -0.242705f),new Vector2f(0.442059f, 0.46875f),new Vector2f(0.442059f, 0.53125f),new Vector2f(0.348309f, 0.53125f),new Vector2f(0.348309f, 0.46875f),new Vector3f(0.0f, -3.236068f, -2.35114f));
		this.quads[70] = new ObjQuad(new Vector3f(0.7f, 0.609789f, -0.061803f),new Vector3f(0.8f, 0.609789f, -0.061803f),new Vector3f(0.8f, 0.682443f, -0.161803f),new Vector3f(0.7f, 0.682443f, -0.161803f),new Vector2f(0.538627f, 0.53125f),new Vector2f(0.538627f, 0.46875f),new Vector2f(0.601127f, 0.46875f),new Vector2f(0.601127f, 0.53125f),new Vector3f(0.0f, 3.236068f, 2.35114f));
		this.quads[71] = new ObjQuad(new Vector3f(0.8f, 0.609789f, -0.061803f),new Vector3f(0.8f, 0.514683f, -0.092705f),new Vector3f(0.8f, 0.623664f, -0.242705f),new Vector3f(0.8f, 0.682443f, -0.161803f),new Vector2f(0.381118f, 0.461373f),new Vector2f(0.321677f, 0.442059f),new Vector2f(0.38979f, 0.348309f),new Vector2f(0.426527f, 0.398873f),new Vector3f(4.0f, -4.0E-6f, 0.0f));
		this.quads[72] = new ObjQuad(new Vector3f(0.8f, 0.623664f, -0.242705f),new Vector3f(0.7f, 0.623664f, -0.242705f),new Vector3f(0.7f, 0.8f, -0.3f),new Vector3f(0.8f, 0.8f, -0.3f),new Vector2f(0.61021f, 0.46875f),new Vector2f(0.61021f, 0.53125f),new Vector2f(0.5f, 0.53125f),new Vector2f(0.5f, 0.46875f),new Vector3f(0.0f, -1.236068f, -3.804228f));
		this.quads[73] = new ObjQuad(new Vector3f(0.7f, 0.682443f, -0.161803f),new Vector3f(0.8f, 0.682443f, -0.161803f),new Vector3f(0.8f, 0.8f, -0.2f),new Vector3f(0.7f, 0.8f, -0.2f),new Vector2f(0.426527f, 0.53125f),new Vector2f(0.426527f, 0.46875f),new Vector2f(0.5f, 0.46875f),new Vector2f(0.5f, 0.53125f),new Vector3f(0.0f, 1.236068f, 3.804228f));
		this.quads[74] = new ObjQuad(new Vector3f(0.8f, 0.682443f, -0.161803f),new Vector3f(0.8f, 0.623664f, -0.242705f),new Vector3f(0.8f, 0.8f, -0.3f),new Vector3f(0.8f, 0.8f, -0.2f),new Vector2f(0.426527f, 0.398873f),new Vector2f(0.38979f, 0.348309f),new Vector2f(0.5f, 0.3125f),new Vector2f(0.5f, 0.375f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[75] = new ObjQuad(new Vector3f(0.8f, 0.8f, -0.3f),new Vector3f(0.7f, 0.8f, -0.3f),new Vector3f(0.7f, 0.976336f, -0.242705f),new Vector3f(0.8f, 0.976336f, -0.242705f),new Vector2f(0.5f, 0.46875f),new Vector2f(0.5f, 0.53125f),new Vector2f(0.38979f, 0.53125f),new Vector2f(0.38979f, 0.46875f),new Vector3f(0.0f, 1.236068f, -3.804228f));
		this.quads[76] = new ObjQuad(new Vector3f(0.7f, 0.8f, -0.2f),new Vector3f(0.8f, 0.8f, -0.2f),new Vector3f(0.8f, 0.917557f, -0.161803f),new Vector3f(0.7f, 0.917557f, -0.161803f),new Vector2f(0.5f, 0.53125f),new Vector2f(0.5f, 0.46875f),new Vector2f(0.573473f, 0.46875f),new Vector2f(0.573473f, 0.53125f),new Vector3f(0.0f, -1.236068f, 3.804228f));
		this.quads[77] = new ObjQuad(new Vector3f(0.8f, 0.8f, -0.2f),new Vector3f(0.8f, 0.8f, -0.3f),new Vector3f(0.8f, 0.976336f, -0.242705f),new Vector3f(0.8f, 0.917557f, -0.161803f),new Vector2f(0.5f, 0.375f),new Vector2f(0.5f, 0.3125f),new Vector2f(0.61021f, 0.348309f),new Vector2f(0.573473f, 0.398873f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[78] = new ObjQuad(new Vector3f(0.8f, 0.976336f, -0.242705f),new Vector3f(0.7f, 0.976336f, -0.242705f),new Vector3f(0.7f, 1.085317f, -0.092705f),new Vector3f(0.8f, 1.085317f, -0.092705f),new Vector2f(0.651691f, 0.46875f),new Vector2f(0.651691f, 0.53125f),new Vector2f(0.557941f, 0.53125f),new Vector2f(0.557941f, 0.46875f),new Vector3f(0.0f, 3.236068f, -2.35114f));
		this.quads[79] = new ObjQuad(new Vector3f(0.7f, 0.917557f, -0.161803f),new Vector3f(0.8f, 0.917557f, -0.161803f),new Vector3f(0.8f, 0.990211f, -0.061803f),new Vector3f(0.7f, 0.990211f, -0.061803f),new Vector2f(0.398873f, 0.53125f),new Vector2f(0.398873f, 0.46875f),new Vector2f(0.461373f, 0.46875f),new Vector2f(0.461373f, 0.53125f),new Vector3f(0.0f, -3.236068f, 2.35114f));
		this.quads[80] = new ObjQuad(new Vector3f(0.8f, 0.917557f, -0.161803f),new Vector3f(0.8f, 0.976336f, -0.242705f),new Vector3f(0.8f, 1.085317f, -0.092705f),new Vector3f(0.8f, 0.990211f, -0.061803f),new Vector2f(0.573473f, 0.398873f),new Vector2f(0.61021f, 0.348309f),new Vector2f(0.678323f, 0.442059f),new Vector2f(0.618882f, 0.461373f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[81] = new ObjQuad(new Vector3f(0.8f, 1.085317f, -0.092705f),new Vector3f(0.7f, 1.085317f, -0.092705f),new Vector3f(0.7f, 1.085317f, 0.092705f),new Vector3f(0.8f, 1.085317f, 0.092705f),new Vector2f(0.557941f, 0.46875f),new Vector2f(0.557941f, 0.53125f),new Vector2f(0.442059f, 0.53125f),new Vector2f(0.442059f, 0.46875f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[82] = new ObjQuad(new Vector3f(0.7f, 0.990211f, -0.061803f),new Vector3f(0.8f, 0.990211f, -0.061803f),new Vector3f(0.8f, 0.990211f, 0.061803f),new Vector3f(0.7f, 0.990211f, 0.061803f),new Vector2f(0.461373f, 0.53125f),new Vector2f(0.461373f, 0.46875f),new Vector2f(0.538627f, 0.46875f),new Vector2f(0.538627f, 0.53125f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[83] = new ObjQuad(new Vector3f(0.8f, 0.990211f, -0.061803f),new Vector3f(0.8f, 1.085317f, -0.092705f),new Vector3f(0.8f, 1.085317f, 0.092705f),new Vector3f(0.8f, 0.990211f, 0.061803f),new Vector2f(0.618882f, 0.461373f),new Vector2f(0.678323f, 0.442059f),new Vector2f(0.678323f, 0.557941f),new Vector2f(0.618882f, 0.538627f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[84] = new ObjQuad(new Vector3f(0.8f, 1.085317f, 0.092705f),new Vector3f(0.7f, 1.085317f, 0.092705f),new Vector3f(0.7f, 0.976336f, 0.242705f),new Vector3f(0.8f, 0.976336f, 0.242705f),new Vector2f(0.442059f, 0.46875f),new Vector2f(0.442059f, 0.53125f),new Vector2f(0.348309f, 0.53125f),new Vector2f(0.348309f, 0.46875f),new Vector3f(0.0f, 3.236068f, 2.35114f));
		this.quads[85] = new ObjQuad(new Vector3f(0.7f, 0.990211f, 0.061803f),new Vector3f(0.8f, 0.990211f, 0.061803f),new Vector3f(0.8f, 0.917557f, 0.161803f),new Vector3f(0.7f, 0.917557f, 0.161803f),new Vector2f(0.538627f, 0.53125f),new Vector2f(0.538627f, 0.46875f),new Vector2f(0.601127f, 0.46875f),new Vector2f(0.601127f, 0.53125f),new Vector3f(0.0f, -3.236068f, -2.35114f));
		this.quads[86] = new ObjQuad(new Vector3f(0.8f, 0.990211f, 0.061803f),new Vector3f(0.8f, 1.085317f, 0.092705f),new Vector3f(0.8f, 0.976336f, 0.242705f),new Vector3f(0.8f, 0.917557f, 0.161803f),new Vector2f(0.618882f, 0.538627f),new Vector2f(0.678323f, 0.557941f),new Vector2f(0.61021f, 0.651691f),new Vector2f(0.573473f, 0.601127f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[87] = new ObjQuad(new Vector3f(0.8f, 0.976336f, 0.242705f),new Vector3f(0.7f, 0.976336f, 0.242705f),new Vector3f(0.7f, 0.8f, 0.3f),new Vector3f(0.8f, 0.8f, 0.3f),new Vector2f(0.61021f, 0.46875f),new Vector2f(0.61021f, 0.53125f),new Vector2f(0.5f, 0.53125f),new Vector2f(0.5f, 0.46875f),new Vector3f(0.0f, 1.236068f, 3.804224f));
		this.quads[88] = new ObjQuad(new Vector3f(0.7f, 0.917557f, 0.161803f),new Vector3f(0.8f, 0.917557f, 0.161803f),new Vector3f(0.8f, 0.8f, 0.2f),new Vector3f(0.7f, 0.8f, 0.2f),new Vector2f(0.426527f, 0.53125f),new Vector2f(0.426527f, 0.46875f),new Vector2f(0.5f, 0.46875f),new Vector2f(0.5f, 0.53125f),new Vector3f(0.0f, -1.236068f, -3.804224f));
		this.quads[89] = new ObjQuad(new Vector3f(0.8f, 0.917557f, 0.161803f),new Vector3f(0.8f, 0.976336f, 0.242705f),new Vector3f(0.8f, 0.8f, 0.3f),new Vector3f(0.8f, 0.8f, 0.2f),new Vector2f(0.573473f, 0.601127f),new Vector2f(0.61021f, 0.651691f),new Vector2f(0.5f, 0.6875f),new Vector2f(0.5f, 0.625f),new Vector3f(4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		ElectroMotorHull other = new ElectroMotorHull();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

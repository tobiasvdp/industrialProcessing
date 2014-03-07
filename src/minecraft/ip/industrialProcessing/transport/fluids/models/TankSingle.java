package ip.industrialProcessing.transport.fluids.models;

import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class TankSingle extends ObjMesh {

	public TankSingle() {
		this.quads = new ObjQuad[50];
		this.quads[0] = new ObjQuad(new Vector3f(0.289959f, 0.2f, -0.700024f), new Vector3f(0.289959f, 1.4f, -0.700024f), new Vector3f(0.700024f, 1.4f, -0.289959f), new Vector3f(0.700024f, 0.2f, -0.289959f), new Vector2f(-2.65E-4f, 0.062586f), new Vector2f(0.750157f, 0.062586f), new Vector2f(0.750157f, 0.425239f), new Vector2f(-2.65E-4f, 0.425239f), new Vector3f(2.828428f, 0.0f, -2.828428f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.289959f, 0.2f, -0.700024f), new Vector3f(-0.289959f, 1.4f, -0.700024f), new Vector3f(0.289959f, 1.4f, -0.700024f), new Vector3f(0.289959f, 0.2f, -0.700024f), new Vector2f(-3.15E-4f, 0.637409f), new Vector2f(0.750107f, 0.637409f), new Vector2f(0.750107f, 1.000062f), new Vector2f(-3.15E-4f, 1.000062f), new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.700024f, 0.2f, -0.289959f), new Vector3f(-0.700024f, 1.4f, -0.289959f), new Vector3f(-0.289959f, 1.4f, -0.700024f), new Vector3f(-0.289959f, 0.2f, -0.700024f), new Vector2f(-3.15E-4f, 0.274756f), new Vector2f(0.750107f, 0.274756f), new Vector2f(0.750107f, 0.637409f), new Vector2f(-3.15E-4f, 0.637409f), new Vector3f(-2.828428f, 0.0f, -2.828428f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.700023f, 0.2f, 0.289959f), new Vector3f(-0.700023f, 1.4f, 0.289959f), new Vector3f(-0.700024f, 1.4f, -0.289959f), new Vector3f(-0.700024f, 0.2f, -0.289959f), new Vector2f(6.4E-5f, 0.362681f), new Vector2f(0.750486f, 0.362681f), new Vector2f(0.750486f, 0.725334f), new Vector2f(6.4E-5f, 0.725334f), new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.289959f, 0.2f, 0.700024f), new Vector3f(-0.289959f, 1.4f, 0.700024f), new Vector3f(-0.700023f, 1.4f, 0.289959f), new Vector3f(-0.700023f, 0.2f, 0.289959f), new Vector2f(6.5E-5f, 2.8E-5f), new Vector2f(0.750486f, 2.8E-5f), new Vector2f(0.750486f, 0.362681f), new Vector2f(6.4E-5f, 0.362681f), new Vector3f(-2.828428f, 0.0f, 2.828428f));
		this.quads[5] = new ObjQuad(new Vector3f(0.700023f, 0.2f, 0.289959f), new Vector3f(0.700023f, 1.4f, 0.289959f), new Vector3f(0.289959f, 1.4f, 0.700024f), new Vector3f(0.289959f, 0.2f, 0.700024f), new Vector2f(-3.36E-4f, 0.637166f), new Vector2f(0.750086f, 0.637166f), new Vector2f(0.750086f, 0.999819f), new Vector2f(-3.36E-4f, 0.999819f), new Vector3f(2.828428f, 0.0f, 2.828428f));
		this.quads[6] = new ObjQuad(new Vector3f(0.700024f, 0.2f, -0.289959f), new Vector3f(0.700024f, 1.4f, -0.289959f), new Vector3f(0.700023f, 1.4f, 0.289959f), new Vector3f(0.700023f, 0.2f, 0.289959f), new Vector2f(-2.65E-4f, 0.425239f), new Vector2f(0.750157f, 0.425239f), new Vector2f(0.750157f, 0.787892f), new Vector2f(-2.64E-4f, 0.787892f), new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(0.248538f, 0.1f, -0.600024f), new Vector3f(0.600024f, 0.1f, -0.248538f), new Vector3f(-0.600024f, 0.1f, -0.248538f), new Vector3f(-0.248538f, 0.1f, -0.600024f), new Vector2f(0.655324f, 0.874986f), new Vector2f(0.874986f, 0.655324f), new Vector2f(0.125014f, 0.655324f), new Vector2f(0.344675f, 0.874986f), new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(0.600024f, 0.1f, -0.248538f), new Vector3f(0.248538f, 0.1f, -0.600024f), new Vector3f(0.289959f, 0.2f, -0.700024f), new Vector3f(0.700024f, 0.2f, -0.289959f), new Vector2f(0.874986f, 0.655324f), new Vector2f(0.655324f, 0.874986f), new Vector2f(0.681211f, 0.937482f), new Vector2f(0.937482f, 0.681211f), new Vector3f(2.0f, -2.828428f, -2.0f));
		this.quads[9] = new ObjQuad(new Vector3f(0.600024f, 0.1f, 0.248538f), new Vector3f(0.600024f, 0.1f, -0.248538f), new Vector3f(0.700024f, 0.2f, -0.289959f), new Vector3f(0.700023f, 0.2f, 0.289959f), new Vector2f(0.874986f, 0.344676f), new Vector2f(0.874986f, 0.655324f), new Vector2f(0.937482f, 0.681211f), new Vector2f(0.937482f, 0.318789f), new Vector3f(2.828428f, -2.828428f, 0.0f));
		this.quads[10] = new ObjQuad(new Vector3f(0.248538f, 0.1f, 0.600024f), new Vector3f(0.600024f, 0.1f, 0.248538f), new Vector3f(0.700023f, 0.2f, 0.289959f), new Vector3f(0.289959f, 0.2f, 0.700024f), new Vector2f(0.655325f, 0.125014f), new Vector2f(0.874986f, 0.344676f), new Vector2f(0.937482f, 0.318789f), new Vector2f(0.681211f, 0.062518f), new Vector3f(2.0f, -2.828428f, 2.0f));
		this.quads[11] = new ObjQuad(new Vector3f(-0.248538f, 0.1f, 0.600024f), new Vector3f(0.248538f, 0.1f, 0.600024f), new Vector3f(0.289959f, 0.2f, 0.700024f), new Vector3f(-0.289959f, 0.2f, 0.700024f), new Vector2f(0.344676f, 0.125014f), new Vector2f(0.655325f, 0.125014f), new Vector2f(0.681211f, 0.062518f), new Vector2f(0.318789f, 0.062518f), new Vector3f(0.0f, -2.828428f, 2.828428f));
		this.quads[12] = new ObjQuad(new Vector3f(-0.600024f, 0.1f, 0.248538f), new Vector3f(-0.248538f, 0.1f, 0.600024f), new Vector3f(-0.289959f, 0.2f, 0.700024f), new Vector3f(-0.700023f, 0.2f, 0.289959f), new Vector2f(0.125014f, 0.344675f), new Vector2f(0.344676f, 0.125014f), new Vector2f(0.318789f, 0.062518f), new Vector2f(0.062518f, 0.318789f), new Vector3f(-2.0f, -2.828428f, 2.0f));
		this.quads[13] = new ObjQuad(new Vector3f(-0.600024f, 0.1f, -0.248538f), new Vector3f(-0.600024f, 0.1f, 0.248538f), new Vector3f(-0.700023f, 0.2f, 0.289959f), new Vector3f(-0.700024f, 0.2f, -0.289959f), new Vector2f(0.125014f, 0.655324f), new Vector2f(0.125014f, 0.344675f), new Vector2f(0.062518f, 0.318789f), new Vector2f(0.062518f, 0.681211f), new Vector3f(-2.828428f, -2.828428f, 0.0f));
		this.quads[14] = new ObjQuad(new Vector3f(-0.248538f, 0.1f, -0.600024f), new Vector3f(-0.600024f, 0.1f, -0.248538f), new Vector3f(-0.700024f, 0.2f, -0.289959f), new Vector3f(-0.289959f, 0.2f, -0.700024f), new Vector2f(0.344675f, 0.874986f), new Vector2f(0.125014f, 0.655324f), new Vector2f(0.062518f, 0.681211f), new Vector2f(0.318789f, 0.937482f), new Vector3f(-2.0f, -2.828428f, -2.0f));
		this.quads[15] = new ObjQuad(new Vector3f(0.248538f, 0.1f, -0.600024f), new Vector3f(-0.248538f, 0.1f, -0.600024f), new Vector3f(-0.289959f, 0.2f, -0.700024f), new Vector3f(0.289959f, 0.2f, -0.700024f), new Vector2f(0.655324f, 0.874986f), new Vector2f(0.344675f, 0.874986f), new Vector2f(0.318789f, 0.937482f), new Vector2f(0.681211f, 0.937482f), new Vector3f(0.0f, -2.828428f, -2.828428f));
		this.quads[16] = new ObjQuad(new Vector3f(-0.559585f, 0.189912f, -0.231788f), new Vector3f(-0.559585f, 0.189912f, 0.231788f), new Vector3f(0.559585f, 0.189912f, 0.231788f), new Vector3f(0.559585f, 0.189912f, -0.231788f), new Vector2f(0.157828f, 0.641732f), new Vector2f(0.157828f, 0.358268f), new Vector2f(0.842172f, 0.358268f), new Vector2f(0.842172f, 0.641732f), new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[17] = new ObjQuad(new Vector3f(0.254389f, 0.236885f, -0.61415f), new Vector3f(0.231788f, 0.189912f, -0.559585f), new Vector3f(0.559585f, 0.189912f, -0.231788f), new Vector3f(0.61415f, 0.236885f, -0.254389f), new Vector2f(0.655552f, 0.875537f), new Vector2f(0.641732f, 0.842172f), new Vector2f(0.842172f, 0.641732f), new Vector2f(0.875537f, 0.655553f), new Vector3f(-1.845312f, 3.03144f, 1.845316f));
		this.quads[18] = new ObjQuad(new Vector3f(0.61415f, 0.236885f, -0.254389f), new Vector3f(0.559585f, 0.189912f, -0.231788f), new Vector3f(0.559585f, 0.189912f, 0.231788f), new Vector3f(0.61415f, 0.236885f, 0.254389f), new Vector2f(0.875537f, 0.655553f), new Vector2f(0.842172f, 0.641732f), new Vector2f(0.842172f, 0.358268f), new Vector2f(0.875537f, 0.344448f), new Vector3f(-2.609668f, 3.03144f, 0.0f));
		this.quads[19] = new ObjQuad(new Vector3f(0.61415f, 0.236885f, 0.254389f), new Vector3f(0.559585f, 0.189912f, 0.231788f), new Vector3f(0.231788f, 0.189912f, 0.559585f), new Vector3f(0.254389f, 0.236885f, 0.61415f), new Vector2f(0.875537f, 0.344448f), new Vector2f(0.842172f, 0.358268f), new Vector2f(0.641732f, 0.157828f), new Vector2f(0.655553f, 0.124463f), new Vector3f(-1.845312f, 3.03144f, -1.845312f));
		this.quads[20] = new ObjQuad(new Vector3f(0.254389f, 0.236885f, 0.61415f), new Vector3f(0.231788f, 0.189912f, 0.559585f), new Vector3f(-0.231788f, 0.189912f, 0.559585f), new Vector3f(-0.254389f, 0.236885f, 0.61415f), new Vector2f(0.655553f, 0.124463f), new Vector2f(0.641732f, 0.157828f), new Vector2f(0.358268f, 0.157828f), new Vector2f(0.344448f, 0.124463f), new Vector3f(0.0f, 3.03144f, -2.609668f));
		this.quads[21] = new ObjQuad(new Vector3f(-0.254389f, 0.236885f, 0.61415f), new Vector3f(-0.231788f, 0.189912f, 0.559585f), new Vector3f(-0.559585f, 0.189912f, 0.231788f), new Vector3f(-0.61415f, 0.236885f, 0.254389f), new Vector2f(0.344448f, 0.124463f), new Vector2f(0.358268f, 0.157828f), new Vector2f(0.157828f, 0.358268f), new Vector2f(0.124463f, 0.344447f), new Vector3f(1.845312f, 3.03144f, -1.845316f));
		this.quads[22] = new ObjQuad(new Vector3f(-0.61415f, 0.236885f, 0.254389f), new Vector3f(-0.559585f, 0.189912f, 0.231788f), new Vector3f(-0.559585f, 0.189912f, -0.231788f), new Vector3f(-0.61415f, 0.236885f, -0.254389f), new Vector2f(0.124463f, 0.344447f), new Vector2f(0.157828f, 0.358268f), new Vector2f(0.157828f, 0.641732f), new Vector2f(0.124463f, 0.655552f), new Vector3f(2.609668f, 3.03144f, 0.0f));
		this.quads[23] = new ObjQuad(new Vector3f(-0.61415f, 0.236885f, -0.254389f), new Vector3f(-0.559585f, 0.189912f, -0.231788f), new Vector3f(-0.231788f, 0.189912f, -0.559585f), new Vector3f(-0.254389f, 0.236885f, -0.61415f), new Vector2f(0.124463f, 0.655552f), new Vector2f(0.157828f, 0.641732f), new Vector2f(0.358268f, 0.842172f), new Vector2f(0.344447f, 0.875537f), new Vector3f(1.845312f, 3.03144f, 1.845312f));
		this.quads[24] = new ObjQuad(new Vector3f(-0.254389f, 0.236885f, -0.61415f), new Vector3f(-0.231788f, 0.189912f, -0.559585f), new Vector3f(0.231788f, 0.189912f, -0.559585f), new Vector3f(0.254389f, 0.236885f, -0.61415f), new Vector2f(0.344447f, 0.875537f), new Vector2f(0.358268f, 0.842172f), new Vector2f(0.641732f, 0.842172f), new Vector2f(0.655552f, 0.875537f), new Vector3f(0.0f, 3.03144f, 2.609668f));
		this.quads[25] = new ObjQuad(new Vector3f(0.254389f, 0.236885f, -0.61415f), new Vector3f(0.61415f, 0.236885f, -0.254389f), new Vector3f(0.608591f, 1.4f, -0.252087f), new Vector3f(0.252087f, 1.4f, -0.608591f), new Vector2f(0.0f, 0.25f), new Vector2f(0.0f, 0.0f), new Vector2f(0.639958f, 0.0f), new Vector2f(0.639958f, 0.25f), new Vector3f(-2.828396f, -0.019116f, 2.828396f));
		this.quads[26] = new ObjQuad(new Vector3f(-0.254389f, 0.236885f, -0.61415f), new Vector3f(0.254389f, 0.236885f, -0.61415f), new Vector3f(0.252087f, 1.4f, -0.608591f), new Vector3f(-0.252087f, 1.4f, -0.608591f), new Vector2f(0.0f, 0.25f), new Vector2f(0.0f, 0.0f), new Vector2f(0.639958f, 0.0f), new Vector2f(0.639958f, 0.25f), new Vector3f(0.0f, -0.019116f, 3.999956f));
		this.quads[27] = new ObjQuad(new Vector3f(-0.61415f, 0.236885f, -0.254389f), new Vector3f(-0.254389f, 0.236885f, -0.61415f), new Vector3f(-0.252087f, 1.4f, -0.608591f), new Vector3f(-0.608591f, 1.4f, -0.252087f), new Vector2f(0.75f, 0.0f), new Vector2f(0.75f, 0.25f), new Vector2f(0.110042f, 0.25f), new Vector2f(0.110042f, 0.0f), new Vector3f(2.828396f, -0.019116f, 2.828396f));
		this.quads[28] = new ObjQuad(new Vector3f(-0.61415f, 0.236885f, 0.254389f), new Vector3f(-0.61415f, 0.236885f, -0.254389f), new Vector3f(-0.608591f, 1.4f, -0.252087f), new Vector3f(-0.608591f, 1.4f, 0.252087f), new Vector2f(0.75f, 0.0f), new Vector2f(0.75f, 0.25f), new Vector2f(0.110042f, 0.25f), new Vector2f(0.110042f, 0.0f), new Vector3f(3.999956f, -0.019116f, 0.0f));
		this.quads[29] = new ObjQuad(new Vector3f(-0.254389f, 0.236885f, 0.61415f), new Vector3f(-0.61415f, 0.236885f, 0.254389f), new Vector3f(-0.608591f, 1.4f, 0.252087f), new Vector3f(-0.252087f, 1.4f, 0.608591f), new Vector2f(0.75f, 0.0f), new Vector2f(0.75f, 0.25f), new Vector2f(0.110042f, 0.25f), new Vector2f(0.110042f, 0.0f), new Vector3f(2.828396f, -0.019116f, -2.828396f));
		this.quads[30] = new ObjQuad(new Vector3f(0.61415f, 0.236885f, 0.254389f), new Vector3f(0.254389f, 0.236885f, 0.61415f), new Vector3f(0.252087f, 1.4f, 0.608591f), new Vector3f(0.608591f, 1.4f, 0.252087f), new Vector2f(0.0f, 0.25f), new Vector2f(0.0f, 0.0f), new Vector2f(0.639958f, 0.0f), new Vector2f(0.639958f, 0.25f), new Vector3f(-2.828396f, -0.019116f, -2.828396f));
		this.quads[31] = new ObjQuad(new Vector3f(0.61415f, 0.236885f, -0.254389f), new Vector3f(0.61415f, 0.236885f, 0.254389f), new Vector3f(0.608591f, 1.4f, 0.252087f), new Vector3f(0.608591f, 1.4f, -0.252087f), new Vector2f(0.0f, 0.25f), new Vector2f(0.0f, 0.0f), new Vector2f(0.639958f, 0.0f), new Vector2f(0.639958f, 0.25f), new Vector3f(-3.999956f, -0.019116f, 0.0f));
		this.quads[32] = new ObjQuad(new Vector3f(-0.252087f, 1.4f, -0.608591f), new Vector3f(0.252087f, 1.4f, -0.608591f), new Vector3f(0.608591f, 1.4f, -0.252087f), new Vector3f(-0.608591f, 1.4f, -0.252087f), new Vector2f(0.342446f, 0.11963f), new Vector2f(0.657554f, 0.11963f), new Vector2f(0.88037f, 0.342446f), new Vector2f(0.11963f, 0.342446f), new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[33] = new ObjQuad(new Vector3f(-0.608591f, 1.4f, -0.252087f), new Vector3f(0.608591f, 1.4f, -0.252087f), new Vector3f(0.608591f, 1.4f, 0.252087f), new Vector3f(-0.608591f, 1.4f, 0.252087f), new Vector2f(0.11963f, 0.342446f), new Vector2f(0.88037f, 0.342446f), new Vector2f(0.88037f, 0.657554f), new Vector2f(0.11963f, 0.657554f), new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[34] = new ObjQuad(new Vector3f(-0.608591f, 1.4f, 0.252087f), new Vector3f(0.608591f, 1.4f, 0.252087f), new Vector3f(0.252087f, 1.4f, 0.608591f), new Vector3f(-0.252087f, 1.4f, 0.608591f), new Vector2f(0.11963f, 0.657554f), new Vector2f(0.88037f, 0.657554f), new Vector2f(0.657554f, 0.88037f), new Vector2f(0.342446f, 0.88037f), new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[35] = new ObjQuad(new Vector3f(-0.600023f, 1.5f, 0.248538f), new Vector3f(0.600023f, 1.5f, 0.248538f), new Vector3f(0.600024f, 1.5f, -0.248538f), new Vector3f(-0.600024f, 1.5f, -0.248538f), new Vector2f(0.124985f, 0.655336f), new Vector2f(0.875015f, 0.655336f), new Vector2f(0.875015f, 0.344664f), new Vector2f(0.124985f, 0.344664f), new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[36] = new ObjQuad(new Vector3f(0.700024f, 1.4f, -0.289959f), new Vector3f(0.289959f, 1.4f, -0.700024f), new Vector3f(0.248538f, 1.5f, -0.600024f), new Vector3f(0.600024f, 1.5f, -0.248538f), new Vector2f(0.937515f, 0.318775f), new Vector2f(0.681224f, 0.062485f), new Vector2f(0.655336f, 0.124985f), new Vector2f(0.875015f, 0.344664f), new Vector3f(2.0f, 2.828428f, -2.0f));
		this.quads[37] = new ObjQuad(new Vector3f(0.289959f, 1.4f, -0.700024f), new Vector3f(-0.289959f, 1.4f, -0.700024f), new Vector3f(-0.248538f, 1.5f, -0.600024f), new Vector3f(0.248538f, 1.5f, -0.600024f), new Vector2f(0.681224f, 0.062485f), new Vector2f(0.318775f, 0.062485f), new Vector2f(0.344664f, 0.124985f), new Vector2f(0.655336f, 0.124985f), new Vector3f(0.0f, 2.828428f, -2.828428f));
		this.quads[38] = new ObjQuad(new Vector3f(-0.289959f, 1.4f, -0.700024f), new Vector3f(-0.700024f, 1.4f, -0.289959f), new Vector3f(-0.600024f, 1.5f, -0.248538f), new Vector3f(-0.248538f, 1.5f, -0.600024f), new Vector2f(0.318775f, 0.062485f), new Vector2f(0.062485f, 0.318776f), new Vector2f(0.124985f, 0.344664f), new Vector2f(0.344664f, 0.124985f), new Vector3f(-2.0f, 2.828428f, -2.0f));
		this.quads[39] = new ObjQuad(new Vector3f(-0.700024f, 1.4f, -0.289959f), new Vector3f(-0.700023f, 1.4f, 0.289959f), new Vector3f(-0.600023f, 1.5f, 0.248538f), new Vector3f(-0.600024f, 1.5f, -0.248538f), new Vector2f(0.062485f, 0.318776f), new Vector2f(0.062485f, 0.681225f), new Vector2f(0.124985f, 0.655336f), new Vector2f(0.124985f, 0.344664f), new Vector3f(-2.828428f, 2.828428f, 0.0f));
		this.quads[40] = new ObjQuad(new Vector3f(-0.700023f, 1.4f, 0.289959f), new Vector3f(-0.289959f, 1.4f, 0.700024f), new Vector3f(-0.248538f, 1.5f, 0.600024f), new Vector3f(-0.600023f, 1.5f, 0.248538f), new Vector2f(0.062485f, 0.681225f), new Vector2f(0.318776f, 0.937515f), new Vector2f(0.344664f, 0.875015f), new Vector2f(0.124985f, 0.655336f), new Vector3f(-2.0f, 2.828428f, 2.0f));
		this.quads[41] = new ObjQuad(new Vector3f(-0.289959f, 1.4f, 0.700024f), new Vector3f(0.289959f, 1.4f, 0.700024f), new Vector3f(0.248538f, 1.5f, 0.600024f), new Vector3f(-0.248538f, 1.5f, 0.600024f), new Vector2f(0.318776f, 0.937515f), new Vector2f(0.681225f, 0.937515f), new Vector2f(0.655336f, 0.875015f), new Vector2f(0.344664f, 0.875015f), new Vector3f(0.0f, 2.828428f, 2.828428f));
		this.quads[42] = new ObjQuad(new Vector3f(0.289959f, 1.4f, 0.700024f), new Vector3f(0.700023f, 1.4f, 0.289959f), new Vector3f(0.600023f, 1.5f, 0.248538f), new Vector3f(0.248538f, 1.5f, 0.600024f), new Vector2f(0.681225f, 0.937515f), new Vector2f(0.937515f, 0.681225f), new Vector2f(0.875015f, 0.655336f), new Vector2f(0.655336f, 0.875015f), new Vector3f(2.0f, 2.828428f, 2.0f));
		this.quads[43] = new ObjQuad(new Vector3f(0.700023f, 1.4f, 0.289959f), new Vector3f(0.700024f, 1.4f, -0.289959f), new Vector3f(0.600024f, 1.5f, -0.248538f), new Vector3f(0.600023f, 1.5f, 0.248538f), new Vector2f(0.937515f, 0.681225f), new Vector2f(0.937515f, 0.318775f), new Vector2f(0.875015f, 0.344664f), new Vector2f(0.875015f, 0.655336f), new Vector3f(2.828428f, 2.828428f, 0.0f));
		this.quads[44] = new ObjQuad(new Vector3f(-0.248538f, 1.5f, 0.600024f), new Vector3f(0.248538f, 1.5f, 0.600024f), new Vector3f(0.600023f, 1.5f, 0.248538f), new Vector3f(-0.600023f, 1.5f, 0.248538f), new Vector2f(0.344664f, 0.875015f), new Vector2f(0.655336f, 0.875015f), new Vector2f(0.875015f, 0.655336f), new Vector2f(0.124985f, 0.655336f), new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[45] = new ObjQuad(new Vector3f(0.248538f, 1.5f, -0.600024f), new Vector3f(-0.248538f, 1.5f, -0.600024f), new Vector3f(-0.600024f, 1.5f, -0.248538f), new Vector3f(0.600024f, 1.5f, -0.248538f), new Vector2f(0.655336f, 0.124985f), new Vector2f(0.344664f, 0.124985f), new Vector2f(0.124985f, 0.344664f), new Vector2f(0.875015f, 0.344664f), new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[46] = new ObjQuad(new Vector3f(0.231788f, 0.189912f, -0.559585f), new Vector3f(-0.231788f, 0.189912f, -0.559585f), new Vector3f(-0.559585f, 0.189912f, -0.231788f), new Vector3f(0.559585f, 0.189912f, -0.231788f), new Vector2f(0.641732f, 0.842172f), new Vector2f(0.358268f, 0.842172f), new Vector2f(0.157828f, 0.641732f), new Vector2f(0.842172f, 0.641732f), new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[47] = new ObjQuad(new Vector3f(-0.231788f, 0.189912f, 0.559585f), new Vector3f(0.231788f, 0.189912f, 0.559585f), new Vector3f(0.559585f, 0.189912f, 0.231788f), new Vector3f(-0.559585f, 0.189912f, 0.231788f), new Vector2f(0.358268f, 0.157828f), new Vector2f(0.641732f, 0.157828f), new Vector2f(0.842172f, 0.358268f), new Vector2f(0.157828f, 0.358268f), new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[48] = new ObjQuad(new Vector3f(0.248538f, 0.1f, 0.600024f), new Vector3f(-0.248538f, 0.1f, 0.600024f), new Vector3f(-0.600024f, 0.1f, 0.248538f), new Vector3f(0.600024f, 0.1f, 0.248538f), new Vector2f(0.655325f, 0.125014f), new Vector2f(0.344676f, 0.125014f), new Vector2f(0.125014f, 0.344675f), new Vector2f(0.874986f, 0.344676f), new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[49] = new ObjQuad(new Vector3f(0.600024f, 0.1f, 0.248538f), new Vector3f(-0.600024f, 0.1f, 0.248538f), new Vector3f(-0.600024f, 0.1f, -0.248538f), new Vector3f(0.600024f, 0.1f, -0.248538f), new Vector2f(0.874986f, 0.344676f), new Vector2f(0.125014f, 0.344675f), new Vector2f(0.125014f, 0.655324f), new Vector2f(0.874986f, 0.655324f), new Vector3f(0.0f, -4.0f, 0.0f));
	}

	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
	    TankSingle other = new TankSingle();
        other.quads = cloneQuads(this.quads, transform);
        return other;
	}

}
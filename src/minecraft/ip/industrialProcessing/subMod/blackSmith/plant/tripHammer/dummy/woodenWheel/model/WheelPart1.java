package  ip.industrialProcessing.subMod.blackSmith.plant.tripHammer.dummy.woodenWheel.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class WheelPart1 extends ObjMesh{
	public WheelPart1(){
		this.quads = new ObjQuad[85];
		this.quads[0] = new ObjQuad(new Vector3f(0.8f, 1.2f, 0.8f),new Vector3f(0.8f, 1.3172f, 0.5172f),new Vector3f(0.8f, 1.6f, 0.8f),new Vector2f(5.0E-4f, 0.7498f),new Vector2f(0.1771f, 0.8229f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(3.0f, 0.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.8f, 1.3172f, 0.5172f),new Vector3f(0.8f, 1.6f, 0.4f),new Vector3f(0.8f, 1.6f, 0.8f),new Vector2f(0.1771f, 0.8229f),new Vector2f(0.2503f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(3.0f, 0.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.8f, 0.0f, 0.8f),new Vector3f(0.8f, 0.4686f, -0.3314f),new Vector3f(0.8f, 0.6217f, -0.1783f),new Vector3f(0.8f, 0.4634f, 0.2038f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.7069f, 0.2931f),new Vector2f(0.6113f, 0.3887f),new Vector2f(0.3727f, 0.2898f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.8f, 0.0f, 0.8f),new Vector3f(0.8f, 0.4634f, 0.2038f),new Vector3f(0.8f, 0.3748f, 0.4179f),new Vector3f(0.8f, 0.2165f, 0.8f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.3727f, 0.2898f),new Vector2f(0.2391f, 0.2345f),new Vector2f(5.0E-4f, 0.1357f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.8f, 0.4686f, -0.3314f),new Vector3f(0.8f, 1.6f, -0.8f),new Vector3f(0.8f, 1.6f, -0.5835f),new Vector3f(0.8f, 1.2179f, -0.4252f),new Vector2f(0.7069f, 0.2931f),new Vector2f(0.9995f, 0.9995f),new Vector2f(0.8643f, 0.9995f),new Vector2f(0.7655f, 0.7609f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(0.8f, 0.4686f, -0.3314f),new Vector3f(0.8f, 1.2179f, -0.4252f),new Vector3f(0.8f, 1.0038f, -0.3366f),new Vector3f(0.8f, 0.6217f, -0.1783f),new Vector2f(0.7069f, 0.2931f),new Vector2f(0.7655f, 0.7609f),new Vector2f(0.7102f, 0.6273f),new Vector2f(0.6113f, 0.3887f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(0.4f, 1.6f, -0.0f),new Vector3f(0.4f, 1.0343f, 0.2343f),new Vector3f(-0.8f, 1.0343f, 0.2343f),new Vector3f(-0.8f, 1.6f, 0.0f),new Vector2f(0.9995f, 0.7498f),new Vector2f(0.6463f, 0.7498f),new Vector2f(0.6463f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector3f(0.0f, -1.5308f, -3.6956f));
		this.quads[7] = new ObjQuad(new Vector3f(0.4f, 1.0343f, 0.2343f),new Vector3f(0.4f, 0.8f, 0.8f),new Vector3f(-0.8f, 0.8f, 0.8f),new Vector3f(-0.8f, 1.0343f, 0.2343f),new Vector2f(0.3537f, 0.7498f),new Vector2f(5.0E-4f, 0.7498f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.3537f, 5.0E-4f),new Vector3f(0.0f, -3.6956f, -1.5308f));
		this.quads[8] = new ObjQuad(new Vector3f(0.4f, 1.0343f, 0.2343f),new Vector3f(0.8f, 1.3172f, 0.5172f),new Vector3f(0.8f, 1.2f, 0.8f),new Vector3f(0.4f, 0.8f, 0.8f),new Vector2f(0.3537f, 0.6463f),new Vector2f(0.1771f, 0.8229f),new Vector2f(5.0E-4f, 0.7498f),new Vector2f(5.0E-4f, 0.5f),new Vector3f(2.7144f, -2.7144f, -1.1244f));
		this.quads[9] = new ObjQuad(new Vector3f(0.4f, 1.6f, -0.0f),new Vector3f(0.8f, 1.6f, 0.4f),new Vector3f(0.8f, 1.3172f, 0.5172f),new Vector3f(0.4f, 1.0343f, 0.2343f),new Vector2f(0.5f, 0.9995f),new Vector2f(0.2503f, 0.9995f),new Vector2f(0.1771f, 0.8229f),new Vector2f(0.3537f, 0.6463f),new Vector3f(2.7144f, -1.1244f, -2.7144f));
		this.quads[10] = new ObjQuad(new Vector3f(0.8f, 1.6f, -0.8f),new Vector3f(0.8f, 0.4686f, -0.3314f),new Vector3f(0.6f, 0.4686f, -0.3314f),new Vector3f(0.6f, 1.6f, -0.8f),new Vector2f(0.9995f, 0.9995f),new Vector2f(0.2931f, 0.9995f),new Vector2f(0.2931f, 0.8746f),new Vector2f(0.9995f, 0.8746f),new Vector3f(0.0f, -1.5308f, -3.6956f));
		this.quads[11] = new ObjQuad(new Vector3f(0.8f, 0.4686f, -0.3314f),new Vector3f(0.8f, 0.0f, 0.8f),new Vector3f(0.6f, 0.0f, 0.8f),new Vector3f(0.6f, 0.4686f, -0.3314f),new Vector2f(0.7069f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector2f(5.0E-4f, 0.8746f),new Vector2f(0.7069f, 0.8746f),new Vector3f(0.0f, -3.6956f, -1.5308f));
		this.quads[12] = new ObjQuad(new Vector3f(0.6f, 1.6f, -0.5835f),new Vector3f(0.6f, 1.6f, -0.8f),new Vector3f(0.6f, 0.4686f, -0.3314f),new Vector3f(0.6f, 1.2179f, -0.4252f),new Vector2f(0.1357f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector2f(0.2931f, 0.2931f),new Vector2f(0.2345f, 0.7609f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[13] = new ObjQuad(new Vector3f(0.6f, 1.0038f, -0.3366f),new Vector3f(0.6f, 1.2179f, -0.4252f),new Vector3f(0.6f, 0.4686f, -0.3314f),new Vector3f(0.6f, 0.6217f, -0.1783f),new Vector2f(0.2898f, 0.6273f),new Vector2f(0.2345f, 0.7609f),new Vector2f(0.2931f, 0.2931f),new Vector2f(0.3887f, 0.3887f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[14] = new ObjQuad(new Vector3f(0.6f, 0.6217f, -0.1783f),new Vector3f(0.6f, 0.4686f, -0.3314f),new Vector3f(0.6f, 0.0f, 0.8f),new Vector3f(0.6f, 0.4634f, 0.2039f),new Vector2f(0.3887f, 0.3887f),new Vector2f(0.2931f, 0.2931f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.6273f, 0.2898f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[15] = new ObjQuad(new Vector3f(0.6f, 0.3748f, 0.4179f),new Vector3f(0.6f, 0.4634f, 0.2039f),new Vector3f(0.6f, 0.0f, 0.8f),new Vector3f(0.6f, 0.2165f, 0.8f),new Vector2f(0.7609f, 0.2345f),new Vector2f(0.6273f, 0.2898f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.1357f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[16] = new ObjQuad(new Vector3f(0.8f, 1.6f, -0.5835f),new Vector3f(0.6f, 1.6f, -0.5835f),new Vector3f(0.6f, 1.2179f, -0.4252f),new Vector3f(0.8f, 1.2179f, -0.4252f),new Vector2f(5.0E-4f, 0.9995f),new Vector2f(5.0E-4f, 0.8746f),new Vector2f(0.2391f, 0.8746f),new Vector2f(0.2391f, 0.9995f),new Vector3f(0.0f, 1.5308f, 3.6956f));
		this.quads[17] = new ObjQuad(new Vector3f(0.6f, 0.6217f, -0.1783f),new Vector3f(0.8f, 0.6217f, -0.1783f),new Vector3f(0.8f, 1.0038f, -0.3366f),new Vector3f(0.6f, 1.0038f, -0.3366f),new Vector2f(0.6113f, 0.8746f),new Vector2f(0.6113f, 0.9995f),new Vector2f(0.3727f, 0.9995f),new Vector2f(0.3727f, 0.8746f),new Vector3f(0.0f, 1.5308f, 3.6956f));
		this.quads[18] = new ObjQuad(new Vector3f(0.8f, 0.6217f, -0.1783f),new Vector3f(0.6f, 0.6217f, -0.1783f),new Vector3f(0.6f, 0.4634f, 0.2039f),new Vector3f(0.8f, 0.4634f, 0.2038f),new Vector2f(0.3887f, 0.9995f),new Vector2f(0.3887f, 0.8746f),new Vector2f(0.6273f, 0.8746f),new Vector2f(0.6273f, 0.9995f),new Vector3f(0.0f, 3.6956f, 1.5308f));
		this.quads[19] = new ObjQuad(new Vector3f(0.6f, 0.2165f, 0.8f),new Vector3f(0.8f, 0.2165f, 0.8f),new Vector3f(0.8f, 0.3748f, 0.4179f),new Vector3f(0.6f, 0.3748f, 0.4179f),new Vector2f(0.9995f, 0.8746f),new Vector2f(0.9995f, 0.9995f),new Vector2f(0.7609f, 0.9995f),new Vector2f(0.7609f, 0.8746f),new Vector3f(0.0f, 3.6956f, 1.5308f));
		this.quads[20] = new ObjQuad(new Vector3f(0.8f, 0.3748f, 0.4179f),new Vector3f(0.8f, 0.4634f, 0.2038f),new Vector3f(0.75f, 0.4443f, 0.25f),new Vector3f(0.75f, 0.3939f, 0.3717f),new Vector2f(0.7609f, 0.9995f),new Vector2f(0.6273f, 0.9995f),new Vector2f(0.6561f, 0.9683f),new Vector2f(0.7321f, 0.9683f),new Vector3f(0.0f, 3.6956f, 1.5308f));
		this.quads[21] = new ObjQuad(new Vector3f(0.8f, 0.4634f, 0.2038f),new Vector3f(0.6f, 0.4634f, 0.2039f),new Vector3f(0.65f, 0.4443f, 0.25f),new Vector3f(0.75f, 0.4443f, 0.25f),new Vector2f(0.6273f, 0.9995f),new Vector2f(0.6273f, 0.8746f),new Vector2f(0.6561f, 0.9058f),new Vector2f(0.6561f, 0.9683f),new Vector3f(0.0f, 3.6956f, 1.5308f));
		this.quads[22] = new ObjQuad(new Vector3f(0.6f, 0.4634f, 0.2039f),new Vector3f(0.6f, 0.3748f, 0.4179f),new Vector3f(0.65f, 0.3939f, 0.3717f),new Vector3f(0.65f, 0.4443f, 0.25f),new Vector2f(0.6273f, 0.8746f),new Vector2f(0.7609f, 0.8746f),new Vector2f(0.7321f, 0.9058f),new Vector2f(0.6561f, 0.9058f),new Vector3f(0.0f, 3.6956f, 1.5308f));
		this.quads[23] = new ObjQuad(new Vector3f(0.6f, 0.3748f, 0.4179f),new Vector3f(0.8f, 0.3748f, 0.4179f),new Vector3f(0.75f, 0.3939f, 0.3717f),new Vector3f(0.65f, 0.3939f, 0.3717f),new Vector2f(0.7609f, 0.8746f),new Vector2f(0.7609f, 0.9995f),new Vector2f(0.7321f, 0.9683f),new Vector2f(0.7321f, 0.9058f),new Vector3f(0.0f, 3.6956f, 1.5308f));
		this.quads[24] = new ObjQuad(new Vector3f(0.8f, 1.0038f, -0.3366f),new Vector3f(0.8f, 1.2179f, -0.4252f),new Vector3f(0.75f, 1.1717f, -0.4061f),new Vector3f(0.75f, 1.05f, -0.3557f),new Vector2f(0.3727f, 0.9995f),new Vector2f(0.2391f, 0.9995f),new Vector2f(0.2679f, 0.9683f),new Vector2f(0.3439f, 0.9683f),new Vector3f(0.0f, 1.5308f, 3.6956f));
		this.quads[25] = new ObjQuad(new Vector3f(0.8f, 1.2179f, -0.4252f),new Vector3f(0.6f, 1.2179f, -0.4252f),new Vector3f(0.65f, 1.1717f, -0.4061f),new Vector3f(0.75f, 1.1717f, -0.4061f),new Vector2f(0.2391f, 0.9995f),new Vector2f(0.2391f, 0.8746f),new Vector2f(0.2679f, 0.9058f),new Vector2f(0.2679f, 0.9683f),new Vector3f(0.0f, 1.5308f, 3.6956f));
		this.quads[26] = new ObjQuad(new Vector3f(0.6f, 1.2179f, -0.4252f),new Vector3f(0.6f, 1.0038f, -0.3366f),new Vector3f(0.65f, 1.05f, -0.3557f),new Vector3f(0.65f, 1.1717f, -0.4061f),new Vector2f(0.2391f, 0.8746f),new Vector2f(0.3727f, 0.8746f),new Vector2f(0.3439f, 0.9058f),new Vector2f(0.2679f, 0.9058f),new Vector3f(0.0f, 1.5308f, 3.6956f));
		this.quads[27] = new ObjQuad(new Vector3f(0.6f, 1.0038f, -0.3366f),new Vector3f(0.8f, 1.0038f, -0.3366f),new Vector3f(0.75f, 1.05f, -0.3557f),new Vector3f(0.65f, 1.05f, -0.3557f),new Vector2f(0.3727f, 0.8746f),new Vector2f(0.3727f, 0.9995f),new Vector2f(0.3439f, 0.9683f),new Vector2f(0.3439f, 0.9058f),new Vector3f(0.0f, 1.5308f, 3.6956f));
		this.quads[28] = new ObjQuad(new Vector3f(0.75f, 0.3939f, 0.3717f),new Vector3f(0.75f, 0.4443f, 0.25f),new Vector3f(0.75f, 1.2758f, 0.5945f),new Vector3f(0.75f, 1.2254f, 0.7161f),new Vector2f(0.2679f, 0.2464f),new Vector2f(0.3439f, 0.2779f),new Vector2f(0.1288f, 0.7971f),new Vector2f(0.0529f, 0.7656f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[29] = new ObjQuad(new Vector3f(0.75f, 0.4443f, 0.25f),new Vector3f(0.65f, 0.4443f, 0.25f),new Vector3f(0.65f, 1.2758f, 0.5945f),new Vector3f(0.75f, 1.2758f, 0.5945f),new Vector2f(0.2779f, 0.9683f),new Vector2f(0.2779f, 0.9058f),new Vector2f(0.7971f, 0.9058f),new Vector2f(0.7971f, 0.9683f),new Vector3f(0.0f, 1.5308f, -3.6956f));
		this.quads[30] = new ObjQuad(new Vector3f(0.65f, 0.4443f, 0.25f),new Vector3f(0.65f, 0.3939f, 0.3717f),new Vector3f(0.65f, 1.2254f, 0.7161f),new Vector3f(0.65f, 1.2758f, 0.5945f),new Vector2f(0.6561f, 0.2779f),new Vector2f(0.7321f, 0.2464f),new Vector2f(0.9471f, 0.7656f),new Vector2f(0.8712f, 0.7971f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[31] = new ObjQuad(new Vector3f(0.65f, 0.3939f, 0.3717f),new Vector3f(0.75f, 0.3939f, 0.3717f),new Vector3f(0.75f, 1.2254f, 0.7161f),new Vector3f(0.65f, 1.2254f, 0.7161f),new Vector2f(0.7536f, 0.9058f),new Vector2f(0.7536f, 0.9683f),new Vector2f(0.2344f, 0.9683f),new Vector2f(0.2344f, 0.9058f),new Vector3f(0.0f, -1.5308f, 3.6956f));
		this.quads[32] = new ObjQuad(new Vector3f(0.75f, 1.05f, -0.3557f),new Vector3f(0.75f, 1.1717f, -0.4061f),new Vector3f(0.75f, 1.5161f, 0.4254f),new Vector3f(0.75f, 1.3945f, 0.4758f),new Vector2f(0.7221f, 0.6561f),new Vector2f(0.7536f, 0.7321f),new Vector2f(0.2344f, 0.9471f),new Vector2f(0.2029f, 0.8712f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[33] = new ObjQuad(new Vector3f(0.75f, 1.1717f, -0.4061f),new Vector3f(0.65f, 1.1717f, -0.4061f),new Vector3f(0.65f, 1.5161f, 0.4254f),new Vector3f(0.75f, 1.5161f, 0.4254f),new Vector2f(0.2464f, 0.9683f),new Vector2f(0.2464f, 0.9058f),new Vector2f(0.7656f, 0.9058f),new Vector2f(0.7656f, 0.9683f),new Vector3f(0.0f, 3.6956f, -1.5308f));
		this.quads[34] = new ObjQuad(new Vector3f(0.65f, 1.1717f, -0.4061f),new Vector3f(0.65f, 1.05f, -0.3557f),new Vector3f(0.65f, 1.3945f, 0.4758f),new Vector3f(0.65f, 1.5161f, 0.4254f),new Vector2f(0.2464f, 0.7321f),new Vector2f(0.2779f, 0.6561f),new Vector2f(0.7971f, 0.8712f),new Vector2f(0.7656f, 0.9471f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[35] = new ObjQuad(new Vector3f(0.65f, 1.05f, -0.3557f),new Vector3f(0.75f, 1.05f, -0.3557f),new Vector3f(0.75f, 1.3945f, 0.4758f),new Vector3f(0.65f, 1.3945f, 0.4758f),new Vector2f(0.7221f, 0.9058f),new Vector2f(0.7221f, 0.9683f),new Vector2f(0.2029f, 0.9683f),new Vector2f(0.2029f, 0.9058f),new Vector3f(0.0f, -3.6956f, 1.5308f));
		this.quads[36] = new ObjQuad(new Vector3f(-0.5482f, 0.0f, 0.8f),new Vector3f(-0.5482f, 0.3866f, -0.1334f),new Vector3f(-0.5482f, 0.2442f, 0.7331f),new Vector3f(-0.5482f, 0.2165f, 0.8f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.5833f, 0.2419f),new Vector2f(0.0423f, 0.153f),new Vector2f(5.0E-4f, 0.1357f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[37] = new ObjQuad(new Vector3f(-0.5482f, 0.4686f, -0.3314f),new Vector3f(-0.5482f, 1.402f, -0.718f),new Vector3f(-0.5482f, 0.6886f, -0.206f),new Vector3f(-0.5482f, 0.6217f, -0.1783f),new Vector2f(0.7069f, 0.2931f),new Vector2f(0.9483f, 0.8759f),new Vector2f(0.6286f, 0.4304f),new Vector2f(0.6113f, 0.3887f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[38] = new ObjQuad(new Vector3f(-0.5482f, 1.402f, -0.718f),new Vector3f(-0.5482f, 0.4686f, -0.3314f),new Vector3f(-0.7482f, 0.4686f, -0.3314f),new Vector3f(-0.5482f, 1.6f, -0.8f),new Vector2f(0.8759f, 0.1577f),new Vector2f(0.2931f, 0.1577f),new Vector2f(0.2931f, 0.0328f),new Vector2f(0.9995f, 0.1577f),new Vector3f(0.0f, -1.5308f, -3.6956f));
		this.quads[39] = new ObjQuad(new Vector3f(-0.5482f, 1.6f, -0.8f),new Vector3f(-0.7482f, 0.4686f, -0.3314f),new Vector3f(-0.7482f, 1.6f, -0.8f),new Vector2f(0.9995f, 0.1577f),new Vector2f(0.2931f, 0.0328f),new Vector2f(0.9995f, 0.0328f),new Vector3f(0.0f, -1.1481f, -2.7717f));
		this.quads[40] = new ObjQuad(new Vector3f(-0.5482f, 0.3866f, -0.1334f),new Vector3f(-0.5482f, 0.0f, 0.8f),new Vector3f(-0.7482f, 0.0f, 0.8f),new Vector3f(-0.5482f, 0.4686f, -0.3314f),new Vector2f(0.5833f, 0.1577f),new Vector2f(5.0E-4f, 0.1577f),new Vector2f(5.0E-4f, 0.0328f),new Vector2f(0.7069f, 0.1577f),new Vector3f(0.0f, -3.6956f, -1.5308f));
		this.quads[41] = new ObjQuad(new Vector3f(-0.5482f, 0.4686f, -0.3314f),new Vector3f(-0.7482f, 0.0f, 0.8f),new Vector3f(-0.7482f, 0.4686f, -0.3314f),new Vector2f(0.7069f, 0.1577f),new Vector2f(5.0E-4f, 0.0328f),new Vector2f(0.7069f, 0.0328f),new Vector3f(0.0f, -2.7717f, -1.1481f));
		this.quads[42] = new ObjQuad(new Vector3f(-0.7482f, 1.6f, -0.5835f),new Vector3f(-0.7482f, 1.6f, -0.8f),new Vector3f(-0.7482f, 0.4686f, -0.3314f),new Vector3f(-0.7482f, 1.2179f, -0.4252f),new Vector2f(0.1357f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector2f(0.2931f, 0.2931f),new Vector2f(0.2345f, 0.7609f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[43] = new ObjQuad(new Vector3f(-0.7482f, 1.0038f, -0.3366f),new Vector3f(-0.7482f, 1.2179f, -0.4252f),new Vector3f(-0.7482f, 0.4686f, -0.3314f),new Vector3f(-0.7482f, 0.6217f, -0.1783f),new Vector2f(0.2898f, 0.6273f),new Vector2f(0.2345f, 0.7609f),new Vector2f(0.2931f, 0.2931f),new Vector2f(0.3887f, 0.3887f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[44] = new ObjQuad(new Vector3f(-0.7482f, 0.6217f, -0.1783f),new Vector3f(-0.7482f, 0.4686f, -0.3314f),new Vector3f(-0.7482f, 0.0f, 0.8f),new Vector3f(-0.7482f, 0.4634f, 0.2039f),new Vector2f(0.3887f, 0.3887f),new Vector2f(0.2931f, 0.2931f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.6273f, 0.2898f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[45] = new ObjQuad(new Vector3f(-0.7482f, 0.3748f, 0.4179f),new Vector3f(-0.7482f, 0.4634f, 0.2039f),new Vector3f(-0.7482f, 0.0f, 0.8f),new Vector3f(-0.7482f, 0.2165f, 0.8f),new Vector2f(0.7609f, 0.2345f),new Vector2f(0.6273f, 0.2898f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.1357f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[46] = new ObjQuad(new Vector3f(-0.5482f, 1.6f, -0.5835f),new Vector3f(-0.7482f, 1.6f, -0.5835f),new Vector3f(-0.7482f, 1.2179f, -0.4252f),new Vector3f(-0.5482f, 1.2179f, -0.4252f),new Vector2f(5.0E-4f, 0.1577f),new Vector2f(5.0E-4f, 0.0328f),new Vector2f(0.2391f, 0.0328f),new Vector2f(0.2391f, 0.1577f),new Vector3f(0.0f, 1.5308f, 3.6956f));
		this.quads[47] = new ObjQuad(new Vector3f(-0.7482f, 0.6217f, -0.1783f),new Vector3f(-0.5482f, 0.6217f, -0.1783f),new Vector3f(-0.5482f, 0.6886f, -0.206f),new Vector3f(-0.5482f, 1.0038f, -0.3366f),new Vector2f(0.6113f, 0.0328f),new Vector2f(0.6113f, 0.1577f),new Vector2f(0.5696f, 0.1577f),new Vector2f(0.3727f, 0.1577f),new Vector3f(0.0f, 1.5308f, 3.6956f));
		this.quads[48] = new ObjQuad(new Vector3f(-0.7482f, 1.0038f, -0.3366f),new Vector3f(-0.7482f, 0.6217f, -0.1783f),new Vector3f(-0.5482f, 1.0038f, -0.3366f),new Vector2f(0.3727f, 0.0328f),new Vector2f(0.6113f, 0.0328f),new Vector2f(0.3727f, 0.1577f),new Vector3f(0.0f, 1.1481f, 2.7717f));
		this.quads[49] = new ObjQuad(new Vector3f(-0.5482f, 0.6217f, -0.1783f),new Vector3f(-0.7482f, 0.6217f, -0.1783f),new Vector3f(-0.7482f, 0.4634f, 0.2039f),new Vector3f(-0.5482f, 0.4634f, 0.2039f),new Vector2f(0.3887f, 0.1577f),new Vector2f(0.3887f, 0.0328f),new Vector2f(0.6273f, 0.0328f),new Vector2f(0.6273f, 0.1577f),new Vector3f(0.0f, 3.6956f, 1.5308f));
		this.quads[50] = new ObjQuad(new Vector3f(-0.7482f, 0.2165f, 0.8f),new Vector3f(-0.5482f, 0.2165f, 0.8f),new Vector3f(-0.5482f, 0.2442f, 0.7331f),new Vector3f(-0.5482f, 0.3748f, 0.4179f),new Vector2f(0.9995f, 0.0328f),new Vector2f(0.9995f, 0.1577f),new Vector2f(0.9577f, 0.1577f),new Vector2f(0.7609f, 0.1577f),new Vector3f(0.0f, 3.6956f, 1.5308f));
		this.quads[51] = new ObjQuad(new Vector3f(-0.7482f, 0.3748f, 0.4179f),new Vector3f(-0.7482f, 0.2165f, 0.8f),new Vector3f(-0.5482f, 0.3748f, 0.4179f),new Vector2f(0.7609f, 0.0328f),new Vector2f(0.9995f, 0.0328f),new Vector2f(0.7609f, 0.1577f),new Vector3f(0.0f, 2.7717f, 1.1481f));
		this.quads[52] = new ObjQuad(new Vector3f(-0.5482f, 0.3748f, 0.4179f),new Vector3f(-0.5482f, 0.4634f, 0.2039f),new Vector3f(-0.5982f, 0.4443f, 0.25f),new Vector3f(-0.5982f, 0.3939f, 0.3717f),new Vector2f(0.7609f, 0.1577f),new Vector2f(0.6273f, 0.1577f),new Vector2f(0.6561f, 0.1265f),new Vector2f(0.7321f, 0.1265f),new Vector3f(0.0f, 3.6956f, 1.5308f));
		this.quads[53] = new ObjQuad(new Vector3f(-0.5482f, 0.4634f, 0.2039f),new Vector3f(-0.7482f, 0.4634f, 0.2039f),new Vector3f(-0.6982f, 0.4443f, 0.25f),new Vector3f(-0.5982f, 0.4443f, 0.25f),new Vector2f(0.6273f, 0.1577f),new Vector2f(0.6273f, 0.0328f),new Vector2f(0.6561f, 0.064f),new Vector2f(0.6561f, 0.1265f),new Vector3f(0.0f, 3.6956f, 1.5308f));
		this.quads[54] = new ObjQuad(new Vector3f(-0.7482f, 0.4634f, 0.2039f),new Vector3f(-0.7482f, 0.3748f, 0.4179f),new Vector3f(-0.6982f, 0.3939f, 0.3717f),new Vector3f(-0.6982f, 0.4443f, 0.25f),new Vector2f(0.6273f, 0.0328f),new Vector2f(0.7609f, 0.0328f),new Vector2f(0.7321f, 0.064f),new Vector2f(0.6561f, 0.064f),new Vector3f(0.0f, 3.6956f, 1.5308f));
		this.quads[55] = new ObjQuad(new Vector3f(-0.7482f, 0.3748f, 0.4179f),new Vector3f(-0.5482f, 0.3748f, 0.4179f),new Vector3f(-0.5982f, 0.3939f, 0.3717f),new Vector3f(-0.6982f, 0.3939f, 0.3717f),new Vector2f(0.7609f, 0.0328f),new Vector2f(0.7609f, 0.1577f),new Vector2f(0.7321f, 0.1265f),new Vector2f(0.7321f, 0.064f),new Vector3f(0.0f, 3.6956f, 1.5308f));
		this.quads[56] = new ObjQuad(new Vector3f(-0.5482f, 1.0038f, -0.3366f),new Vector3f(-0.5482f, 1.2179f, -0.4252f),new Vector3f(-0.5982f, 1.1717f, -0.4061f),new Vector3f(-0.5982f, 1.05f, -0.3557f),new Vector2f(0.3727f, 0.1577f),new Vector2f(0.2391f, 0.1577f),new Vector2f(0.2679f, 0.1265f),new Vector2f(0.3439f, 0.1265f),new Vector3f(0.0f, 1.5308f, 3.6956f));
		this.quads[57] = new ObjQuad(new Vector3f(-0.5482f, 1.2179f, -0.4252f),new Vector3f(-0.7482f, 1.2179f, -0.4252f),new Vector3f(-0.6982f, 1.1717f, -0.4061f),new Vector3f(-0.5982f, 1.1717f, -0.4061f),new Vector2f(0.2391f, 0.1577f),new Vector2f(0.2391f, 0.0328f),new Vector2f(0.2679f, 0.064f),new Vector2f(0.2679f, 0.1265f),new Vector3f(0.0f, 1.5308f, 3.6956f));
		this.quads[58] = new ObjQuad(new Vector3f(-0.7482f, 1.2179f, -0.4252f),new Vector3f(-0.7482f, 1.0038f, -0.3366f),new Vector3f(-0.6982f, 1.05f, -0.3557f),new Vector3f(-0.6982f, 1.1717f, -0.4061f),new Vector2f(0.2391f, 0.0328f),new Vector2f(0.3727f, 0.0328f),new Vector2f(0.3439f, 0.064f),new Vector2f(0.2679f, 0.064f),new Vector3f(0.0f, 1.5308f, 3.6956f));
		this.quads[59] = new ObjQuad(new Vector3f(-0.7482f, 1.0038f, -0.3366f),new Vector3f(-0.5482f, 1.0038f, -0.3366f),new Vector3f(-0.5982f, 1.05f, -0.3557f),new Vector3f(-0.6982f, 1.05f, -0.3557f),new Vector2f(0.3727f, 0.0328f),new Vector2f(0.3727f, 0.1577f),new Vector2f(0.3439f, 0.1265f),new Vector2f(0.3439f, 0.064f),new Vector3f(0.0f, 1.5308f, 3.6956f));
		this.quads[60] = new ObjQuad(new Vector3f(-0.5982f, 0.3939f, 0.3717f),new Vector3f(-0.5982f, 0.4443f, 0.25f),new Vector3f(-0.5982f, 1.2758f, 0.5945f),new Vector3f(-0.5982f, 1.2254f, 0.7161f),new Vector2f(0.2679f, 0.2464f),new Vector2f(0.3439f, 0.2779f),new Vector2f(0.1288f, 0.7971f),new Vector2f(0.0529f, 0.7656f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[61] = new ObjQuad(new Vector3f(-0.5982f, 0.4443f, 0.25f),new Vector3f(-0.6982f, 0.4443f, 0.25f),new Vector3f(-0.6982f, 1.2758f, 0.5945f),new Vector3f(-0.5982f, 1.2758f, 0.5945f),new Vector2f(0.2779f, 0.1265f),new Vector2f(0.2779f, 0.064f),new Vector2f(0.7971f, 0.064f),new Vector2f(0.7971f, 0.1265f),new Vector3f(0.0f, 1.5308f, -3.6956f));
		this.quads[62] = new ObjQuad(new Vector3f(-0.6982f, 0.4443f, 0.25f),new Vector3f(-0.6982f, 0.3939f, 0.3717f),new Vector3f(-0.6982f, 1.2254f, 0.7161f),new Vector3f(-0.6982f, 1.2758f, 0.5945f),new Vector2f(0.6561f, 0.2779f),new Vector2f(0.7321f, 0.2464f),new Vector2f(0.9471f, 0.7656f),new Vector2f(0.8712f, 0.7971f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[63] = new ObjQuad(new Vector3f(-0.6982f, 0.3939f, 0.3717f),new Vector3f(-0.5982f, 0.3939f, 0.3717f),new Vector3f(-0.5982f, 1.2254f, 0.7161f),new Vector3f(-0.6982f, 1.2254f, 0.7161f),new Vector2f(0.7536f, 0.064f),new Vector2f(0.7536f, 0.1265f),new Vector2f(0.2344f, 0.1265f),new Vector2f(0.2344f, 0.064f),new Vector3f(0.0f, -1.5308f, 3.6956f));
		this.quads[64] = new ObjQuad(new Vector3f(-0.5982f, 1.05f, -0.3557f),new Vector3f(-0.5982f, 1.1717f, -0.4061f),new Vector3f(-0.5982f, 1.5161f, 0.4254f),new Vector3f(-0.5982f, 1.3945f, 0.4758f),new Vector2f(0.7221f, 0.6561f),new Vector2f(0.7536f, 0.7321f),new Vector2f(0.2344f, 0.9471f),new Vector2f(0.2029f, 0.8712f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[65] = new ObjQuad(new Vector3f(-0.5982f, 1.1717f, -0.4061f),new Vector3f(-0.6982f, 1.1717f, -0.4061f),new Vector3f(-0.6982f, 1.5161f, 0.4254f),new Vector3f(-0.5982f, 1.5161f, 0.4254f),new Vector2f(0.2464f, 0.1265f),new Vector2f(0.2464f, 0.064f),new Vector2f(0.7656f, 0.064f),new Vector2f(0.7656f, 0.1265f),new Vector3f(0.0f, 3.6956f, -1.5308f));
		this.quads[66] = new ObjQuad(new Vector3f(-0.6982f, 1.1717f, -0.4061f),new Vector3f(-0.6982f, 1.05f, -0.3557f),new Vector3f(-0.6982f, 1.3945f, 0.4758f),new Vector3f(-0.6982f, 1.5161f, 0.4254f),new Vector2f(0.2464f, 0.7321f),new Vector2f(0.2779f, 0.6561f),new Vector2f(0.7971f, 0.8712f),new Vector2f(0.7656f, 0.9471f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[67] = new ObjQuad(new Vector3f(-0.6982f, 1.05f, -0.3557f),new Vector3f(-0.5982f, 1.05f, -0.3557f),new Vector3f(-0.5982f, 1.3945f, 0.4758f),new Vector3f(-0.6982f, 1.3945f, 0.4758f),new Vector2f(0.7221f, 0.064f),new Vector2f(0.7221f, 0.1265f),new Vector2f(0.2029f, 0.1265f),new Vector2f(0.2029f, 0.064f),new Vector3f(0.0f, -3.6956f, 1.5308f));
		this.quads[68] = new ObjQuad(new Vector3f(0.6518f, 0.3866f, -0.1334f),new Vector3f(0.6518f, 0.4686f, -0.3314f),new Vector3f(0.6518f, 0.6217f, -0.1783f),new Vector3f(0.6518f, 0.4634f, 0.2039f),new Vector2f(0.5833f, 0.2419f),new Vector2f(0.7069f, 0.2931f),new Vector2f(0.6113f, 0.3887f),new Vector2f(0.3727f, 0.2898f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[69] = new ObjQuad(new Vector3f(0.6518f, 0.3866f, -0.1334f),new Vector3f(0.6518f, 0.4634f, 0.2039f),new Vector3f(0.6518f, 0.3748f, 0.4179f),new Vector3f(0.6518f, 0.2442f, 0.7331f),new Vector2f(0.5833f, 0.2419f),new Vector2f(0.3727f, 0.2898f),new Vector2f(0.2391f, 0.2345f),new Vector2f(0.0423f, 0.153f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[70] = new ObjQuad(new Vector3f(0.6518f, 1.402f, -0.718f),new Vector3f(0.6518f, 1.6f, -0.8f),new Vector3f(0.6518f, 1.6f, -0.5835f),new Vector3f(0.6518f, 1.2179f, -0.4252f),new Vector2f(0.9483f, 0.8759f),new Vector2f(0.9995f, 0.9995f),new Vector2f(0.8643f, 0.9995f),new Vector2f(0.7655f, 0.7609f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[71] = new ObjQuad(new Vector3f(0.6518f, 1.402f, -0.718f),new Vector3f(0.6518f, 1.2179f, -0.4252f),new Vector3f(0.6518f, 1.0039f, -0.3366f),new Vector3f(0.6518f, 0.6886f, -0.206f),new Vector2f(0.9483f, 0.8759f),new Vector2f(0.7655f, 0.7609f),new Vector2f(0.7102f, 0.6273f),new Vector2f(0.6286f, 0.4304f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[72] = new ObjQuad(new Vector3f(-0.5482f, 0.3866f, -0.1334f),new Vector3f(-0.5482f, 0.4686f, -0.3314f),new Vector3f(0.6518f, 0.4686f, -0.3314f),new Vector3f(0.6518f, 0.3866f, -0.1334f),new Vector2f(0.5833f, 0.1577f),new Vector2f(0.7069f, 0.1577f),new Vector2f(0.7069f, 0.9069f),new Vector2f(0.5833f, 0.9069f),new Vector3f(0.0f, -3.6956f, -1.5308f));
		this.quads[73] = new ObjQuad(new Vector3f(-0.5482f, 0.4686f, -0.3314f),new Vector3f(-0.5482f, 0.6217f, -0.1783f),new Vector3f(0.6518f, 0.6217f, -0.1783f),new Vector3f(0.6518f, 0.4686f, -0.3314f),new Vector2f(0.2931f, 0.1577f),new Vector2f(0.3887f, 0.1577f),new Vector2f(0.3887f, 0.9069f),new Vector2f(0.2931f, 0.9069f),new Vector3f(0.0f, 2.8284f, -2.8284f));
		this.quads[74] = new ObjQuad(new Vector3f(-0.5482f, 0.6217f, -0.1783f),new Vector3f(-0.5482f, 0.4634f, 0.2039f),new Vector3f(0.6518f, 0.4634f, 0.2039f),new Vector3f(0.6518f, 0.6217f, -0.1783f),new Vector2f(0.3887f, 0.1577f),new Vector2f(0.6273f, 0.1577f),new Vector2f(0.6273f, 0.9069f),new Vector2f(0.3887f, 0.9069f),new Vector3f(0.0f, 3.6956f, 1.5308f));
		this.quads[75] = new ObjQuad(new Vector3f(-0.5482f, 0.4634f, 0.2039f),new Vector3f(-0.5482f, 0.3748f, 0.4179f),new Vector3f(0.6518f, 0.3748f, 0.4179f),new Vector3f(0.6518f, 0.4634f, 0.2039f),new Vector2f(0.6273f, 0.1577f),new Vector2f(0.7609f, 0.1577f),new Vector2f(0.7609f, 0.9069f),new Vector2f(0.6273f, 0.9069f),new Vector3f(0.0f, 3.6956f, 1.5308f));
		this.quads[76] = new ObjQuad(new Vector3f(-0.5482f, 0.3748f, 0.4179f),new Vector3f(-0.5482f, 0.2442f, 0.7331f),new Vector3f(0.6518f, 0.2442f, 0.7331f),new Vector3f(0.6518f, 0.3748f, 0.4179f),new Vector2f(0.7609f, 0.1577f),new Vector2f(0.9577f, 0.1577f),new Vector2f(0.9577f, 0.9069f),new Vector2f(0.7609f, 0.9069f),new Vector3f(0.0f, 3.6956f, 1.5308f));
		this.quads[77] = new ObjQuad(new Vector3f(-0.5482f, 0.2442f, 0.7331f),new Vector3f(-0.5482f, 0.3866f, -0.1334f),new Vector3f(0.6518f, 0.3866f, -0.1334f),new Vector3f(0.6518f, 0.2442f, 0.7331f),new Vector2f(0.0423f, 0.1577f),new Vector2f(0.5833f, 0.1577f),new Vector2f(0.5833f, 0.9069f),new Vector2f(0.0423f, 0.9069f),new Vector3f(0.0f, -3.9472f, -0.6488f));
		this.quads[78] = new ObjQuad(new Vector3f(-0.5482f, 1.402f, -0.718f),new Vector3f(-0.5482f, 1.6f, -0.8f),new Vector3f(0.6518f, 1.6f, -0.8f),new Vector3f(0.6518f, 1.402f, -0.718f),new Vector2f(0.8759f, 0.1577f),new Vector2f(0.9995f, 0.1577f),new Vector2f(0.9995f, 0.9069f),new Vector2f(0.8759f, 0.9069f),new Vector3f(0.0f, -1.5308f, -3.6956f));
		this.quads[79] = new ObjQuad(new Vector3f(-0.5482f, 1.6f, -0.8f),new Vector3f(-0.5482f, 1.6f, -0.5835f),new Vector3f(0.6518f, 1.6f, -0.5835f),new Vector3f(0.6518f, 1.6f, -0.8f),new Vector2f(5.0E-4f, 0.1577f),new Vector2f(0.1357f, 0.1577f),new Vector2f(0.1357f, 0.9069f),new Vector2f(5.0E-4f, 0.9069f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[80] = new ObjQuad(new Vector3f(-0.5482f, 1.6f, -0.5835f),new Vector3f(-0.5482f, 1.2179f, -0.4252f),new Vector3f(0.6518f, 1.2179f, -0.4252f),new Vector3f(0.6518f, 1.6f, -0.5835f),new Vector2f(5.0E-4f, 0.1577f),new Vector2f(0.2391f, 0.1577f),new Vector2f(0.2391f, 0.9069f),new Vector2f(5.0E-4f, 0.9069f),new Vector3f(0.0f, 1.5308f, 3.6956f));
		this.quads[81] = new ObjQuad(new Vector3f(-0.5482f, 1.2179f, -0.4252f),new Vector3f(-0.5482f, 1.0038f, -0.3366f),new Vector3f(0.6518f, 1.0039f, -0.3366f),new Vector3f(0.6518f, 1.2179f, -0.4252f),new Vector2f(0.2391f, 0.1577f),new Vector2f(0.3727f, 0.1577f),new Vector2f(0.3727f, 0.9069f),new Vector2f(0.2391f, 0.9069f),new Vector3f(0.0f, 1.5308f, 3.6956f));
		this.quads[82] = new ObjQuad(new Vector3f(-0.5482f, 1.0038f, -0.3366f),new Vector3f(-0.5482f, 0.6886f, -0.206f),new Vector3f(0.6518f, 0.6886f, -0.206f),new Vector3f(0.6518f, 1.0039f, -0.3366f),new Vector2f(0.3727f, 0.1577f),new Vector2f(0.5696f, 0.1577f),new Vector2f(0.5696f, 0.9069f),new Vector2f(0.3727f, 0.9069f),new Vector3f(0.0f, 1.5308f, 3.6956f));
		this.quads[83] = new ObjQuad(new Vector3f(-0.5482f, 0.6886f, -0.206f),new Vector3f(-0.5482f, 1.402f, -0.718f),new Vector3f(0.6518f, 1.402f, -0.718f),new Vector3f(0.6518f, 0.6886f, -0.206f),new Vector2f(0.4304f, 0.1577f),new Vector2f(0.8759f, 0.1577f),new Vector2f(0.8759f, 0.9069f),new Vector2f(0.4304f, 0.9069f),new Vector3f(0.0f, -2.332f, -3.2496f));
		this.quads[84] = new ObjQuad(new Vector3f(-0.8f, 1.0343f, 0.2343f),new Vector3f(-0.8f, 0.8f, 0.8f),new Vector3f(-0.8f, 1.6f, 0.8f),new Vector3f(-0.8f, 1.6f, 0.0f),new Vector2f(0.6463f, 0.6463f),new Vector2f(0.9995f, 0.5f),new Vector2f(0.9995f, 0.9995f),new Vector2f(0.5f, 0.9995f),new Vector3f(-4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		WheelPart1 other = new WheelPart1();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

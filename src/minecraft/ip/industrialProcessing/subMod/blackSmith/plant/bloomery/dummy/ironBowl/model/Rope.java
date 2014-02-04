package  ip.industrialProcessing.subMod.blackSmith.plant.bloomery.dummy.ironBowl.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Rope extends ObjMesh{
	public Rope(){
		this.quads = new ObjQuad[18];
		this.quads[0] = new ObjQuad(new Vector3f(0.435f, 0.2f, -0.0f),new Vector3f(0.4246f, 0.2f, -0.0143f),new Vector3f(0.0046f, 0.65f, -0.0143f),new Vector3f(0.015f, 0.65f, -0.0f),new Vector2f(0.75f, 0.0f),new Vector2f(0.95f, 0.0f),new Vector2f(0.95f, 1.0f),new Vector2f(0.75f, 1.0f),new Vector3f(1.951f, 1.8208998f, -1.7748001f));
		this.quads[1] = new ObjQuad(new Vector3f(0.4246f, 0.2f, -0.0143f),new Vector3f(0.4079f, 0.2f, -0.0088f),new Vector3f(-0.0121f, 0.65f, -0.0088f),new Vector3f(0.0046f, 0.65f, -0.0143f),new Vector2f(0.95f, 0.0f),new Vector2f(1.15f, 0.0f),new Vector2f(1.15f, 1.0f),new Vector2f(0.95f, 1.0f),new Vector3f(-0.7489f, -0.69890004f, -2.7954001f));
		this.quads[2] = new ObjQuad(new Vector3f(0.4079f, 0.2f, -0.0088f),new Vector3f(0.4079f, 0.2f, 0.0088f),new Vector3f(-0.0121f, 0.65f, 0.0088f),new Vector3f(-0.0121f, 0.65f, -0.0088f),new Vector2f(0.15f, 0.0f),new Vector2f(0.35f, 0.0f),new Vector2f(0.35f, 1.0f),new Vector2f(0.15f, 1.0f),new Vector3f(-2.4754f, -2.3104f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.4079f, 0.2f, 0.0088f),new Vector3f(0.4246f, 0.2f, 0.0143f),new Vector3f(0.0046f, 0.65f, 0.0143f),new Vector3f(-0.0121f, 0.65f, 0.0088f),new Vector2f(0.35f, 0.0f),new Vector2f(0.55f, 0.0f),new Vector2f(0.55f, 1.0f),new Vector2f(0.35f, 1.0f),new Vector3f(-0.7489f, -0.6989f, 2.7954f));
		this.quads[4] = new ObjQuad(new Vector3f(0.4246f, 0.2f, 0.0143f),new Vector3f(0.435f, 0.2f, -0.0f),new Vector3f(0.015f, 0.65f, -0.0f),new Vector3f(0.0046f, 0.65f, 0.0143f),new Vector2f(0.55f, 0.0f),new Vector2f(0.75f, 0.0f),new Vector2f(0.75f, 1.0f),new Vector2f(0.55f, 1.0f),new Vector3f(1.9510001f, 1.8209f, 1.7748001f));
		this.quads[5] = new ObjQuad(new Vector3f(0.4079f, 0.2f, -0.0088f),new Vector3f(0.4246f, 0.2f, -0.0143f),new Vector3f(0.435f, 0.2f, -0.0f),new Vector3f(0.4079f, 0.2f, 0.0088f),new Vector2f(0.2061f, 0.0955f),new Vector2f(0.0245f, 0.6545f),new Vector2f(0.5f, 1.0f),new Vector2f(0.7939f, 0.0955f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(0.4246f, 0.2f, 0.0143f),new Vector3f(0.4079f, 0.2f, 0.0088f),new Vector3f(0.435f, 0.2f, -0.0f),new Vector2f(0.9755f, 0.6545f),new Vector2f(0.7939f, 0.0955f),new Vector2f(0.5f, 1.0f),new Vector3f(0.0f, -3.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.0121f, 0.65f, -0.0088f),new Vector3f(-0.0121f, 0.65f, 0.0088f),new Vector3f(0.0046f, 0.65f, 0.0143f),new Vector3f(0.0046f, 0.65f, -0.0143f),new Vector2f(0.2061f, 0.0955f),new Vector2f(0.7939f, 0.0955f),new Vector2f(0.9755f, 0.6545f),new Vector2f(0.0245f, 0.6545f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(0.015f, 0.65f, -0.0f),new Vector3f(0.0046f, 0.65f, -0.0143f),new Vector3f(0.0046f, 0.65f, 0.0143f),new Vector2f(0.5f, 1.0f),new Vector2f(0.0245f, 0.6545f),new Vector2f(0.9755f, 0.6545f),new Vector3f(0.0f, 3.0f, 0.0f));
		this.quads[9] = new ObjQuad(new Vector3f(-0.415f, 0.2f, -0.0f),new Vector3f(-0.4254f, 0.2f, -0.0143f),new Vector3f(0.0046f, 0.65f, -0.0143f),new Vector3f(0.015f, 0.65f, -0.0f),new Vector2f(0.75f, 0.0f),new Vector2f(0.95f, 0.0f),new Vector2f(0.95f, 1.0f),new Vector2f(0.75f, 1.0f),new Vector3f(1.9298999f, -1.8442001f, -1.7697f));
		this.quads[10] = new ObjQuad(new Vector3f(-0.4254f, 0.2f, -0.0143f),new Vector3f(-0.4421f, 0.2f, -0.0088f),new Vector3f(-0.0121f, 0.65f, -0.0088f),new Vector3f(0.0046f, 0.65f, -0.0143f),new Vector2f(0.95f, 0.0f),new Vector2f(1.15f, 0.0f),new Vector2f(1.15f, 1.0f),new Vector2f(0.95f, 1.0f),new Vector3f(-0.7419001f, 0.7089f, -2.785f));
		this.quads[11] = new ObjQuad(new Vector3f(-0.4421f, 0.2f, -0.0088f),new Vector3f(-0.4421f, 0.2f, 0.0088f),new Vector3f(-0.0121f, 0.65f, 0.0088f),new Vector3f(-0.0121f, 0.65f, -0.0088f),new Vector2f(0.15f, 0.0f),new Vector2f(0.35f, 0.0f),new Vector2f(0.35f, 1.0f),new Vector2f(0.15f, 1.0f),new Vector3f(-2.4516f, 2.3426f, 0.0f));
		this.quads[12] = new ObjQuad(new Vector3f(-0.4421f, 0.2f, 0.0088f),new Vector3f(-0.4254f, 0.2f, 0.0143f),new Vector3f(0.0046f, 0.65f, 0.0143f),new Vector3f(-0.0121f, 0.65f, 0.0088f),new Vector2f(0.35f, 0.0f),new Vector2f(0.55f, 0.0f),new Vector2f(0.55f, 1.0f),new Vector2f(0.35f, 1.0f),new Vector3f(-0.74189997f, 0.7089f, 2.7849998f));
		this.quads[13] = new ObjQuad(new Vector3f(-0.4254f, 0.2f, 0.0143f),new Vector3f(-0.415f, 0.2f, -0.0f),new Vector3f(0.015f, 0.65f, -0.0f),new Vector3f(0.0046f, 0.65f, 0.0143f),new Vector2f(0.55f, 0.0f),new Vector2f(0.75f, 0.0f),new Vector2f(0.75f, 1.0f),new Vector2f(0.55f, 1.0f),new Vector3f(1.9299f, -1.8442f, 1.7697f));
		this.quads[14] = new ObjQuad(new Vector3f(-0.4421f, 0.2f, -0.0088f),new Vector3f(-0.4254f, 0.2f, -0.0143f),new Vector3f(-0.415f, 0.2f, -0.0f),new Vector3f(-0.4421f, 0.2f, 0.0088f),new Vector2f(0.2061f, 0.0955f),new Vector2f(0.0245f, 0.6545f),new Vector2f(0.5f, 1.0f),new Vector2f(0.7939f, 0.0955f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[15] = new ObjQuad(new Vector3f(-0.4254f, 0.2f, 0.0143f),new Vector3f(-0.4421f, 0.2f, 0.0088f),new Vector3f(-0.415f, 0.2f, -0.0f),new Vector2f(0.9755f, 0.6545f),new Vector2f(0.7939f, 0.0955f),new Vector2f(0.5f, 1.0f),new Vector3f(0.0f, -3.0f, 0.0f));
		this.quads[16] = new ObjQuad(new Vector3f(-0.0121f, 0.65f, -0.0088f),new Vector3f(-0.0121f, 0.65f, 0.0088f),new Vector3f(0.0046f, 0.65f, 0.0143f),new Vector3f(0.0046f, 0.65f, -0.0143f),new Vector2f(0.2061f, 0.0955f),new Vector2f(0.7939f, 0.0955f),new Vector2f(0.9755f, 0.6545f),new Vector2f(0.0245f, 0.6545f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[17] = new ObjQuad(new Vector3f(0.015f, 0.65f, -0.0f),new Vector3f(0.0046f, 0.65f, -0.0143f),new Vector3f(0.0046f, 0.65f, 0.0143f),new Vector2f(0.5f, 1.0f),new Vector2f(0.0245f, 0.6545f),new Vector2f(0.9755f, 0.6545f),new Vector3f(0.0f, 3.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Rope other = new Rope();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

package  ip.industrialProcessing.subMod.blackSmith.plant.bloomery.dummy.ironBowl.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class SupportBar extends ObjMesh{
	public SupportBar(){
		this.quads = new ObjQuad[20];
		this.quads[0] = new ObjQuad(new Vector3f(0.475f, -0.1f, 0.025f),new Vector3f(0.475f, -0.1f, -0.025f),new Vector3f(0.525f, -0.1f, -0.025f),new Vector3f(0.525f, -0.1f, 0.025f),new Vector2f(0.166f, 0.9024f),new Vector2f(0.166f, 0.9267f),new Vector2f(0.1418f, 0.9267f),new Vector2f(0.1418f, 0.9024f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.475f, 0.7f, 0.025f),new Vector3f(0.525f, 0.7f, 0.025f),new Vector3f(0.525f, 0.7f, -0.025f),new Vector3f(0.475f, 0.7f, -0.025f),new Vector2f(0.2522f, 0.578f),new Vector2f(0.2522f, 0.6023f),new Vector2f(0.2279f, 0.6023f),new Vector2f(0.2279f, 0.578f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.475f, -0.1f, 0.025f),new Vector3f(0.525f, -0.1f, 0.025f),new Vector3f(0.525f, 0.7f, 0.025f),new Vector3f(0.475f, 0.652f, 0.025f),new Vector2f(0.9465f, 0.5736f),new Vector2f(0.9465f, 0.5979f),new Vector2f(0.5578f, 0.5979f),new Vector2f(0.5812f, 0.5736f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.525f, 0.7f, 0.025f),new Vector3f(0.475f, 0.7f, 0.025f),new Vector3f(0.475f, 0.652f, 0.025f),new Vector2f(0.5578f, 0.5979f),new Vector2f(0.5578f, 0.5736f),new Vector2f(0.5812f, 0.5736f),new Vector3f(0.0f, 0.0f, 3.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.525f, -0.1f, 0.025f),new Vector3f(0.525f, -0.1f, -0.025f),new Vector3f(0.525f, 0.7f, -0.025f),new Vector3f(0.525f, 0.7f, 0.025f),new Vector2f(0.166f, 0.9024f),new Vector2f(0.1418f, 0.9024f),new Vector2f(0.1418f, 0.5137f),new Vector2f(0.166f, 0.5137f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(0.525f, -0.1f, -0.025f),new Vector3f(0.475f, -0.1f, -0.025f),new Vector3f(0.475f, 0.652f, -0.025f),new Vector3f(0.475f, 0.7f, -0.025f),new Vector2f(0.407f, 0.0208f),new Vector2f(0.407f, 0.045f),new Vector2f(0.0416f, 0.045f),new Vector2f(0.0183f, 0.045f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[6] = new ObjQuad(new Vector3f(0.525f, -0.1f, -0.025f),new Vector3f(0.475f, 0.7f, -0.025f),new Vector3f(0.525f, 0.7f, -0.025f),new Vector2f(0.407f, 0.0208f),new Vector2f(0.0183f, 0.045f),new Vector2f(0.0183f, 0.0208f),new Vector3f(0.0f, 0.0f, -3.0f));
		this.quads[7] = new ObjQuad(new Vector3f(0.475f, -0.1f, 0.025f),new Vector3f(0.475f, 0.652f, 0.025f),new Vector3f(0.475f, 0.652f, -0.025f),new Vector3f(0.475f, -0.1f, -0.025f),new Vector2f(0.0871f, 0.4542f),new Vector2f(0.0871f, 0.0889f),new Vector2f(0.1114f, 0.0889f),new Vector2f(0.1114f, 0.4542f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(-0.525f, -0.1f, 0.025f),new Vector3f(-0.525f, -0.1f, -0.025f),new Vector3f(-0.475f, -0.1f, -0.025f),new Vector3f(-0.475f, -0.1f, 0.025f),new Vector2f(0.0263f, 0.9737f),new Vector2f(0.0263f, 0.998f),new Vector2f(0.002f, 0.998f),new Vector2f(0.002f, 0.9737f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[9] = new ObjQuad(new Vector3f(-0.525f, 0.7f, 0.025f),new Vector3f(-0.475f, 0.7f, 0.025f),new Vector3f(-0.475f, 0.7f, -0.025f),new Vector3f(-0.525f, 0.7f, -0.025f),new Vector2f(0.2522f, 0.0922f),new Vector2f(0.2522f, 0.1165f),new Vector2f(0.2279f, 0.1165f),new Vector2f(0.2279f, 0.0922f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[10] = new ObjQuad(new Vector3f(-0.525f, -0.1f, 0.025f),new Vector3f(-0.475f, -0.1f, 0.025f),new Vector3f(-0.475f, 0.652f, 0.025f),new Vector3f(-0.475f, 0.7f, 0.025f),new Vector2f(0.9465f, 0.0878f),new Vector2f(0.9465f, 0.1121f),new Vector2f(0.5812f, 0.1121f),new Vector2f(0.5578f, 0.1121f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[11] = new ObjQuad(new Vector3f(-0.525f, -0.1f, 0.025f),new Vector3f(-0.475f, 0.7f, 0.025f),new Vector3f(-0.525f, 0.7f, 0.025f),new Vector2f(0.9465f, 0.0878f),new Vector2f(0.5578f, 0.1121f),new Vector2f(0.5578f, 0.0878f),new Vector3f(0.0f, 0.0f, 3.0f));
		this.quads[12] = new ObjQuad(new Vector3f(-0.475f, -0.1f, -0.025f),new Vector3f(-0.475f, 0.652f, -0.025f),new Vector3f(-0.475f, 0.652f, 0.025f),new Vector3f(-0.475f, -0.1f, 0.025f),new Vector2f(0.3092f, 0.4831f),new Vector2f(0.3092f, 0.1177f),new Vector2f(0.3335f, 0.1177f),new Vector2f(0.3335f, 0.4831f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[13] = new ObjQuad(new Vector3f(-0.475f, -0.1f, -0.025f),new Vector3f(-0.525f, -0.1f, -0.025f),new Vector3f(-0.525f, 0.7f, -0.025f),new Vector3f(-0.475f, 0.652f, -0.025f),new Vector2f(0.4248f, 0.5035f),new Vector2f(0.4006f, 0.5035f),new Vector2f(0.4006f, 0.1149f),new Vector2f(0.4248f, 0.1382f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[14] = new ObjQuad(new Vector3f(-0.525f, 0.7f, -0.025f),new Vector3f(-0.475f, 0.7f, -0.025f),new Vector3f(-0.475f, 0.652f, -0.025f),new Vector2f(0.4006f, 0.1149f),new Vector2f(0.4248f, 0.1149f),new Vector2f(0.4248f, 0.1382f),new Vector3f(0.0f, 0.0f, -3.0f));
		this.quads[15] = new ObjQuad(new Vector3f(-0.525f, -0.1f, -0.025f),new Vector3f(-0.525f, -0.1f, 0.025f),new Vector3f(-0.525f, 0.7f, 0.025f),new Vector3f(-0.525f, 0.7f, -0.025f),new Vector2f(0.1859f, 0.4797f),new Vector2f(0.1616f, 0.4797f),new Vector2f(0.1616f, 0.091f),new Vector2f(0.1859f, 0.091f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[16] = new ObjQuad(new Vector3f(0.475f, 0.652f, 0.025f),new Vector3f(0.475f, 0.7f, 0.025f),new Vector3f(-0.475f, 0.7f, 0.025f),new Vector3f(-0.475f, 0.652f, 0.025f),new Vector2f(0.5812f, 0.5736f),new Vector2f(0.5578f, 0.5736f),new Vector2f(0.5578f, 0.1121f),new Vector2f(0.5812f, 0.1121f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[17] = new ObjQuad(new Vector3f(0.475f, 0.7f, 0.025f),new Vector3f(0.475f, 0.7f, -0.025f),new Vector3f(-0.475f, 0.7f, -0.025f),new Vector3f(-0.475f, 0.7f, 0.025f),new Vector2f(0.2522f, 0.578f),new Vector2f(0.2279f, 0.578f),new Vector2f(0.2279f, 0.1165f),new Vector2f(0.2522f, 0.1165f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[18] = new ObjQuad(new Vector3f(0.475f, 0.7f, -0.025f),new Vector3f(0.475f, 0.652f, -0.025f),new Vector3f(-0.475f, 0.652f, -0.025f),new Vector3f(-0.475f, 0.7f, -0.025f),new Vector2f(0.0183f, 0.045f),new Vector2f(0.0416f, 0.045f),new Vector2f(0.0416f, 0.5066f),new Vector2f(0.0183f, 0.5066f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[19] = new ObjQuad(new Vector3f(0.475f, 0.652f, -0.025f),new Vector3f(0.475f, 0.652f, 0.025f),new Vector3f(-0.475f, 0.652f, 0.025f),new Vector3f(-0.475f, 0.652f, -0.025f),new Vector2f(0.3288f, 0.5229f),new Vector2f(0.3531f, 0.5229f),new Vector2f(0.3531f, 0.9844f),new Vector2f(0.3288f, 0.9844f),new Vector3f(0.0f, -4.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		SupportBar other = new SupportBar();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

package ip.industrialProcessing.power.storage.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class BatteryBoxPowerRails extends ObjMesh{
	public BatteryBoxPowerRails(){
		this.quads = new ObjQuad[9];
		this.quads[0] = new ObjQuad(new Vector3f(-0.5f, 1.25f, 0.05f),new Vector3f(0.5f, 1.25f, 0.05f),new Vector3f(0.5f, 1.25f, -0.05f),new Vector3f(-0.5f, 1.25f, -0.05f),new Vector2f(0.8187f, 0.8095f),new Vector2f(0.1937f, 0.8095f),new Vector2f(0.1937f, 0.747f),new Vector2f(0.8187f, 0.747f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.5f, 1.25f, -0.05f),new Vector3f(0.5f, 1.25f, -0.05f),new Vector3f(0.5f, 1.2f, -0.05f),new Vector3f(-0.5f, 1.2f, -0.05f),new Vector2f(0.8125f, 0.9175f),new Vector2f(0.1875f, 0.9175f),new Vector2f(0.1875f, 0.8862f),new Vector2f(0.8125f, 0.8862f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.5f, 1.25f, 0.05f),new Vector3f(-0.5f, 1.25f, 0.05f),new Vector3f(-0.5f, 1.2f, 0.05f),new Vector3f(0.5f, 1.2f, 0.05f),new Vector2f(0.8166f, 0.9814f),new Vector2f(0.1916f, 0.9814f),new Vector2f(0.1916f, 0.9501f),new Vector2f(0.8166f, 0.9501f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.5f, 1.25f, -0.25f),new Vector3f(0.5f, 1.25f, -0.25f),new Vector3f(0.5f, 1.25f, -0.35f),new Vector3f(-0.5f, 1.25f, -0.35f),new Vector2f(0.8187f, 0.8095f),new Vector2f(0.1937f, 0.8095f),new Vector2f(0.1937f, 0.747f),new Vector2f(0.8187f, 0.747f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.5f, 1.25f, -0.35f),new Vector3f(0.5f, 1.25f, -0.35f),new Vector3f(0.5f, 1.2f, -0.35f),new Vector3f(-0.5f, 1.2f, -0.35f),new Vector2f(0.8125f, 0.9175f),new Vector2f(0.1875f, 0.9175f),new Vector2f(0.1875f, 0.8862f),new Vector2f(0.8125f, 0.8862f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[5] = new ObjQuad(new Vector3f(0.5f, 1.25f, -0.25f),new Vector3f(-0.5f, 1.25f, -0.25f),new Vector3f(-0.5f, 1.2f, -0.25f),new Vector3f(0.5f, 1.2f, -0.25f),new Vector2f(0.8166f, 0.9814f),new Vector2f(0.1916f, 0.9814f),new Vector2f(0.1916f, 0.9501f),new Vector2f(0.8166f, 0.9501f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.5f, 1.25f, 0.35f),new Vector3f(0.5f, 1.25f, 0.35f),new Vector3f(0.5f, 1.25f, 0.25f),new Vector3f(-0.5f, 1.25f, 0.25f),new Vector2f(0.8187f, 0.8095f),new Vector2f(0.1937f, 0.8095f),new Vector2f(0.1937f, 0.747f),new Vector2f(0.8187f, 0.747f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.5f, 1.25f, 0.25f),new Vector3f(0.5f, 1.25f, 0.25f),new Vector3f(0.5f, 1.2f, 0.25f),new Vector3f(-0.5f, 1.2f, 0.25f),new Vector2f(0.8125f, 0.9175f),new Vector2f(0.1875f, 0.9175f),new Vector2f(0.1875f, 0.8862f),new Vector2f(0.8125f, 0.8862f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[8] = new ObjQuad(new Vector3f(0.5f, 1.25f, 0.35f),new Vector3f(-0.5f, 1.25f, 0.35f),new Vector3f(-0.5f, 1.2f, 0.35f),new Vector3f(0.5f, 1.2f, 0.35f),new Vector2f(0.8166f, 0.9814f),new Vector2f(0.1916f, 0.9814f),new Vector2f(0.1916f, 0.9501f),new Vector2f(0.8166f, 0.9501f),new Vector3f(0.0f, 0.0f, 4.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		BatteryBoxPowerRails other = new BatteryBoxPowerRails();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

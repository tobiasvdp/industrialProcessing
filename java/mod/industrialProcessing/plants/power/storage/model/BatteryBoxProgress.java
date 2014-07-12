package mod.industrialProcessing.plants.power.storage.model;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class BatteryBoxProgress extends ObjMesh{
	public BatteryBoxProgress(){
		this.quads = new ObjQuad[2];
		this.quads[0] = new ObjQuad(new Vector3f(0.725f, 0.4f, -0.1f),new Vector3f(0.725f, 1.0f, -0.1f),new Vector3f(0.725f, 1.0f, 0.1f),new Vector3f(0.725f, 0.4f, 0.1f),new Vector2f(0.4375f, 0.3125f),new Vector2f(0.4375f, 0.6875f),new Vector2f(0.5625f, 0.6875f),new Vector2f(0.5625f, 0.3125f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.725f, 0.4f, -0.1f),new Vector3f(-0.725f, 0.4f, 0.1f),new Vector3f(-0.725f, 1.0f, 0.1f),new Vector3f(-0.725f, 1.0f, -0.1f),new Vector2f(0.4375f, 0.3125f),new Vector2f(0.5625f, 0.3125f),new Vector2f(0.5625f, 0.6875f),new Vector2f(0.4375f, 0.6875f),new Vector3f(-4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		BatteryBoxProgress other = new BatteryBoxProgress();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

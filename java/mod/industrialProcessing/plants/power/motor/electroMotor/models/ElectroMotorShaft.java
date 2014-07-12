package mod.industrialProcessing.plants.power.motor.electroMotor.models;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class ElectroMotorShaft extends ObjMesh{
	public ElectroMotorShaft(){
		this.quads = new ObjQuad[9];
		this.quads[0] = new ObjQuad(new Vector3f(0.8f, 0.713398f, -0.05f),new Vector3f(0.8f, 0.8f, -0.1f),new Vector3f(0.8f, 0.886603f, -0.05f),new Vector3f(0.8f, 0.8f, 0.1f),new Vector2f(0.554127f, 0.53125f),new Vector2f(0.5f, 0.5625f),new Vector2f(0.445873f, 0.53125f),new Vector2f(0.5f, 0.4375f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.8f, 0.886603f, -0.05f),new Vector3f(0.8f, 0.886603f, 0.05f),new Vector3f(0.8f, 0.8f, 0.1f),new Vector2f(0.445873f, 0.53125f),new Vector2f(0.445873f, 0.46875f),new Vector2f(0.5f, 0.4375f),new Vector3f(3.0f, 0.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.8f, 0.713398f, 0.05f),new Vector3f(0.8f, 0.713398f, -0.05f),new Vector3f(0.8f, 0.8f, 0.1f),new Vector2f(0.554127f, 0.46875f),new Vector2f(0.554127f, 0.53125f),new Vector2f(0.5f, 0.4375f),new Vector3f(3.0f, 0.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.8f, 0.8f, 0.1f),new Vector3f(0.8f, 0.886603f, 0.05f),new Vector3f(0.7f, 0.886603f, 0.05f),new Vector3f(0.7f, 0.8f, 0.1f),new Vector2f(0.5f, 1.0f),new Vector2f(0.445873f, 1.0f),new Vector2f(0.445873f, 0.125f),new Vector2f(0.5f, 0.125f),new Vector3f(-1.2E-5f, 2.0f, 3.4641f));
		this.quads[4] = new ObjQuad(new Vector3f(0.8f, 0.886603f, 0.05f),new Vector3f(0.8f, 0.886603f, -0.05f),new Vector3f(0.7f, 0.886603f, -0.05f),new Vector3f(0.7f, 0.886603f, 0.05f),new Vector2f(0.53125f, 1.0f),new Vector2f(0.46875f, 1.0f),new Vector2f(0.46875f, 0.125f),new Vector2f(0.53125f, 0.125f),new Vector3f(-8.0E-6f, 4.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(0.8f, 0.886603f, -0.05f),new Vector3f(0.8f, 0.8f, -0.1f),new Vector3f(0.7f, 0.8f, -0.1f),new Vector3f(0.7f, 0.886603f, -0.05f),new Vector2f(0.554127f, 1.0f),new Vector2f(0.5f, 1.0f),new Vector2f(0.5f, 0.125f),new Vector2f(0.554127f, 0.125f),new Vector3f(4.0E-6f, 2.0f, -3.464104f));
		this.quads[6] = new ObjQuad(new Vector3f(0.8f, 0.8f, -0.1f),new Vector3f(0.8f, 0.713398f, -0.05f),new Vector3f(0.7f, 0.713398f, -0.05f),new Vector3f(0.7f, 0.8f, -0.1f),new Vector2f(0.5f, 1.0f),new Vector2f(0.445873f, 1.0f),new Vector2f(0.445873f, 0.125f),new Vector2f(0.5f, 0.125f),new Vector3f(1.2E-5f, -2.0f, -3.4641f));
		this.quads[7] = new ObjQuad(new Vector3f(0.8f, 0.713398f, -0.05f),new Vector3f(0.8f, 0.713398f, 0.05f),new Vector3f(0.7f, 0.713398f, 0.05f),new Vector3f(0.7f, 0.713398f, -0.05f),new Vector2f(0.53125f, 1.0f),new Vector2f(0.46875f, 1.0f),new Vector2f(0.46875f, 0.125f),new Vector2f(0.53125f, 0.125f),new Vector3f(8.0E-6f, -4.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(0.8f, 0.713398f, 0.05f),new Vector3f(0.8f, 0.8f, 0.1f),new Vector3f(0.7f, 0.8f, 0.1f),new Vector3f(0.7f, 0.713398f, 0.05f),new Vector2f(0.554127f, 1.0f),new Vector2f(0.5f, 1.0f),new Vector2f(0.5f, 0.125f),new Vector2f(0.554127f, 0.125f),new Vector3f(-4.0E-6f, -2.0f, 3.4641f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		ElectroMotorShaft other = new ElectroMotorShaft();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

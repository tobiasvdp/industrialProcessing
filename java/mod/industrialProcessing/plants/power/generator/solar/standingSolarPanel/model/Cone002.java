package mod.industrialProcessing.plants.power.generator.solar.standingSolarPanel.model;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Cone002 extends ObjMesh{
	public Cone002(){
		this.quads = new ObjQuad[12];
		this.quads[0] = new ObjQuad(new Vector3f(0.4f, 0.8f, -0.0f),new Vector3f(0.2f, 0.8f, -0.3464f),new Vector3f(0.1f, 1.2f, -0.1732f),new Vector3f(0.2f, 1.2f, -0.0f),new Vector2f(0.7546f, 0.002f),new Vector2f(0.998f, 0.002f),new Vector2f(0.8763f, 0.283f),new Vector2f(0.7546f, 0.283f),new Vector3f(2.6832f, 1.7888f, -1.5492f));
		this.quads[1] = new ObjQuad(new Vector3f(0.2f, 0.8f, -0.3464f),new Vector3f(-0.2f, 0.8f, -0.3464f),new Vector3f(-0.1f, 1.2f, -0.1732f),new Vector3f(0.1f, 1.2f, -0.1732f),new Vector2f(0.002f, 0.7334f),new Vector2f(0.2635f, 0.7334f),new Vector2f(0.1981f, 0.9949f),new Vector2f(0.0674f, 0.9949f),new Vector3f(0.0f, 1.7888f, -3.0984f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.2f, 0.8f, -0.3464f),new Vector3f(-0.4f, 0.8f, 0.0f),new Vector3f(-0.2f, 1.2f, 0.0f),new Vector3f(-0.1f, 1.2f, -0.1732f),new Vector2f(0.002f, 0.4442f),new Vector2f(0.2454f, 0.4442f),new Vector2f(0.2454f, 0.7252f),new Vector2f(0.1237f, 0.7252f),new Vector3f(-2.6832001f, 1.7888f, -1.5492f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.4f, 0.8f, 0.0f),new Vector3f(-0.2f, 0.8f, 0.3464f),new Vector3f(-0.1f, 1.2f, 0.1732f),new Vector3f(-0.2f, 1.2f, 0.0f),new Vector2f(0.2454f, 0.4442f),new Vector2f(0.4887f, 0.4442f),new Vector2f(0.367f, 0.7252f),new Vector2f(0.2454f, 0.7252f),new Vector3f(-2.6832f, 1.7888f, 1.5492f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.2f, 0.8f, 0.3464f),new Vector3f(0.2f, 0.8f, 0.3464f),new Vector3f(0.1f, 1.2f, 0.1732f),new Vector3f(-0.1f, 1.2f, 0.1732f),new Vector2f(0.497f, 0.4442f),new Vector2f(0.7585f, 0.4442f),new Vector2f(0.6931f, 0.7057f),new Vector2f(0.5624f, 0.7057f),new Vector3f(0.0f, 1.7888f, 3.0984f));
		this.quads[5] = new ObjQuad(new Vector3f(0.2f, 0.8f, 0.3464f),new Vector3f(0.4f, 0.8f, -0.0f),new Vector3f(0.2f, 1.2f, -0.0f),new Vector3f(0.1f, 1.2f, 0.1732f),new Vector2f(0.5113f, 0.002f),new Vector2f(0.7546f, 0.002f),new Vector2f(0.7546f, 0.283f),new Vector2f(0.633f, 0.283f),new Vector3f(2.6832001f, 1.7888f, 1.5492f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.2f, 0.8f, 0.3464f),new Vector3f(-0.4f, 0.8f, 0.0f),new Vector3f(-0.2f, 0.8f, -0.3464f),new Vector3f(0.4f, 0.8f, -0.0f),new Vector2f(0.3778f, 0.002f),new Vector2f(0.503f, 0.2189f),new Vector2f(0.3778f, 0.4359f),new Vector2f(0.002f, 0.2189f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.2f, 0.8f, -0.3464f),new Vector3f(0.2f, 0.8f, -0.3464f),new Vector3f(0.4f, 0.8f, -0.0f),new Vector2f(0.3778f, 0.4359f),new Vector2f(0.1273f, 0.4359f),new Vector2f(0.002f, 0.2189f),new Vector3f(0.0f, -3.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(0.2f, 0.8f, 0.3464f),new Vector3f(-0.2f, 0.8f, 0.3464f),new Vector3f(0.4f, 0.8f, -0.0f),new Vector2f(0.1273f, 0.002f),new Vector2f(0.3778f, 0.002f),new Vector2f(0.002f, 0.2189f),new Vector3f(0.0f, -3.0f, 0.0f));
		this.quads[9] = new ObjQuad(new Vector3f(0.1f, 1.2f, -0.1732f),new Vector3f(-0.1f, 1.2f, -0.1732f),new Vector3f(-0.2f, 1.2f, 0.0f),new Vector3f(0.1f, 1.2f, 0.1732f),new Vector2f(0.6849f, 0.9309f),new Vector2f(0.5596f, 0.9309f),new Vector2f(0.497f, 0.8224f),new Vector2f(0.6849f, 0.7139f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[10] = new ObjQuad(new Vector3f(-0.2f, 1.2f, 0.0f),new Vector3f(-0.1f, 1.2f, 0.1732f),new Vector3f(0.1f, 1.2f, 0.1732f),new Vector2f(0.497f, 0.8224f),new Vector2f(0.5596f, 0.7139f),new Vector2f(0.6849f, 0.7139f),new Vector3f(0.0f, 3.0f, 0.0f));
		this.quads[11] = new ObjQuad(new Vector3f(0.2f, 1.2f, -0.0f),new Vector3f(0.1f, 1.2f, -0.1732f),new Vector3f(0.1f, 1.2f, 0.1732f),new Vector2f(0.7475f, 0.8224f),new Vector2f(0.6849f, 0.9309f),new Vector2f(0.6849f, 0.7139f),new Vector3f(0.0f, 3.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Cone002 other = new Cone002();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

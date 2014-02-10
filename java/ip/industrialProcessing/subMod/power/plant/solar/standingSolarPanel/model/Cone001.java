package ip.industrialProcessing.subMod.power.plant.solar.standingSolarPanel.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Cone001 extends ObjMesh{
	public Cone001(){
		this.quads = new ObjQuad[12];
		this.quads[0] = new ObjQuad(new Vector3f(0.4f, 0.0f, -0.0f),new Vector3f(0.2f, 0.0f, -0.3464f),new Vector3f(0.2f, 0.8f, -0.3464f),new Vector3f(0.4f, 0.8f, -0.0f),new Vector2f(0.5f, 0.1f),new Vector2f(0.8464f, 0.1f),new Vector2f(0.8464f, 0.9f),new Vector2f(0.5f, 0.9f),new Vector3f(3.0f, 0.0f, -1.732f));
		this.quads[1] = new ObjQuad(new Vector3f(0.2f, 0.0f, -0.3464f),new Vector3f(-0.2f, 0.0f, -0.3464f),new Vector3f(-0.2f, 0.8f, -0.3464f),new Vector3f(0.2f, 0.8f, -0.3464f),new Vector2f(0.3f, 0.1f),new Vector2f(0.7f, 0.1f),new Vector2f(0.7f, 0.9f),new Vector2f(0.3f, 0.9f),new Vector3f(0.0f, 0.0f, -3.464f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.2f, 0.0f, -0.3464f),new Vector3f(-0.4f, 0.0f, 0.0f),new Vector3f(-0.4f, 0.8f, 0.0f),new Vector3f(-0.2f, 0.8f, -0.3464f),new Vector2f(0.1536f, 0.1f),new Vector2f(0.5f, 0.1f),new Vector2f(0.5f, 0.9f),new Vector2f(0.1536f, 0.9f),new Vector3f(-3.0f, 0.0f, -1.732f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.4f, 0.0f, 0.0f),new Vector3f(-0.2f, 0.0f, 0.3464f),new Vector3f(-0.2f, 0.8f, 0.3464f),new Vector3f(-0.4f, 0.8f, 0.0f),new Vector2f(0.5f, 0.1f),new Vector2f(0.8464f, 0.1f),new Vector2f(0.8464f, 0.9f),new Vector2f(0.5f, 0.9f),new Vector3f(-3.0f, 0.0f, 1.732f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.2f, 0.0f, 0.3464f),new Vector3f(0.2f, 0.0f, 0.3464f),new Vector3f(0.2f, 0.8f, 0.3464f),new Vector3f(-0.2f, 0.8f, 0.3464f),new Vector2f(0.3f, 0.1f),new Vector2f(0.7f, 0.1f),new Vector2f(0.7f, 0.9f),new Vector2f(0.3f, 0.9f),new Vector3f(0.0f, 0.0f, 3.464f));
		this.quads[5] = new ObjQuad(new Vector3f(0.2f, 0.0f, 0.3464f),new Vector3f(0.4f, 0.0f, -0.0f),new Vector3f(0.4f, 0.8f, -0.0f),new Vector3f(0.2f, 0.8f, 0.3464f),new Vector2f(0.1536f, 0.1f),new Vector2f(0.5f, 0.1f),new Vector2f(0.5f, 0.9f),new Vector2f(0.1536f, 0.9f),new Vector3f(3.0f, 0.0f, 1.732f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.2f, 0.0f, 0.3464f),new Vector3f(-0.4f, 0.0f, 0.0f),new Vector3f(-0.2f, 0.0f, -0.3464f),new Vector3f(0.4f, 0.0f, -0.0f),new Vector2f(0.7f, 0.1536f),new Vector2f(0.9f, 0.5f),new Vector2f(0.7f, 0.8464f),new Vector2f(0.1f, 0.5f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.2f, 0.0f, -0.3464f),new Vector3f(0.2f, 0.0f, -0.3464f),new Vector3f(0.4f, 0.0f, -0.0f),new Vector2f(0.7f, 0.8464f),new Vector2f(0.3f, 0.8464f),new Vector2f(0.1f, 0.5f),new Vector3f(0.0f, -3.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(0.2f, 0.0f, 0.3464f),new Vector3f(-0.2f, 0.0f, 0.3464f),new Vector3f(0.4f, 0.0f, -0.0f),new Vector2f(0.3f, 0.1536f),new Vector2f(0.7f, 0.1536f),new Vector2f(0.1f, 0.5f),new Vector3f(0.0f, -3.0f, 0.0f));
		this.quads[9] = new ObjQuad(new Vector3f(0.2f, 0.8f, -0.3464f),new Vector3f(-0.2f, 0.8f, -0.3464f),new Vector3f(-0.4f, 0.8f, 0.0f),new Vector3f(0.2f, 0.8f, 0.3464f),new Vector2f(0.7f, 0.8464f),new Vector2f(0.3f, 0.8464f),new Vector2f(0.1f, 0.5f),new Vector2f(0.7f, 0.1536f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[10] = new ObjQuad(new Vector3f(-0.4f, 0.8f, 0.0f),new Vector3f(-0.2f, 0.8f, 0.3464f),new Vector3f(0.2f, 0.8f, 0.3464f),new Vector2f(0.1f, 0.5f),new Vector2f(0.3f, 0.1536f),new Vector2f(0.7f, 0.1536f),new Vector3f(0.0f, 3.0f, 0.0f));
		this.quads[11] = new ObjQuad(new Vector3f(0.4f, 0.8f, -0.0f),new Vector3f(0.2f, 0.8f, -0.3464f),new Vector3f(0.2f, 0.8f, 0.3464f),new Vector2f(0.9f, 0.5f),new Vector2f(0.7f, 0.8464f),new Vector2f(0.7f, 0.1536f),new Vector3f(0.0f, 3.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Cone001 other = new Cone001();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

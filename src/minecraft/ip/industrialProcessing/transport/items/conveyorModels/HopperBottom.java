package ip.industrialProcessing.transport.items.conveyorModels;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class HopperBottom extends ObjMesh{
	public HopperBottom(){
		this.quads = new ObjQuad[10];
		this.quads[0] = new ObjQuad(new Vector3f(-0.3f, 0.0f, 0.3f),new Vector3f(-0.3f, -0.0f, -0.3f),new Vector3f(0.3f, -0.0f, -0.3f),new Vector3f(0.3f, 0.0f, 0.3f),new Vector2f(1.001254f, 0.624504f),new Vector2f(1.001254f, 0.999504f),new Vector2f(0.626254f, 0.999504f),new Vector2f(0.626254f, 0.624504f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.2f, 0.1f, 0.2f),new Vector3f(0.2f, 0.1f, 0.2f),new Vector3f(0.2f, 0.1f, -0.2f),new Vector3f(-0.2f, 0.1f, -0.2f),new Vector2f(0.688754f, 0.687004f),new Vector2f(0.938754f, 0.687004f),new Vector2f(0.938754f, 0.937004f),new Vector2f(0.688754f, 0.937004f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.2f, 0.1f, 0.2f),new Vector3f(-0.2f, 0.1f, 0.2f),new Vector3f(-0.2f, 0.2f, 0.2f),new Vector3f(0.2f, 0.2f, 0.2f),new Vector2f(0.875773f, 0.622939f),new Vector2f(0.875773f, 0.372939f),new Vector2f(0.938273f, 0.372939f),new Vector2f(0.938273f, 0.622939f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.2f, 0.1f, -0.2f),new Vector3f(0.2f, 0.1f, -0.2f),new Vector3f(0.2f, 0.2f, -0.2f),new Vector3f(-0.2f, 0.2f, -0.2f),new Vector2f(0.750773f, 0.622939f),new Vector2f(0.750773f, 0.372939f),new Vector2f(0.813273f, 0.372939f),new Vector2f(0.813273f, 0.622939f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.2f, 0.1f, 0.2f),new Vector3f(-0.2f, 0.1f, -0.2f),new Vector3f(-0.2f, 0.2f, -0.2f),new Vector3f(-0.2f, 0.2f, 0.2f),new Vector2f(0.500773f, 0.622939f),new Vector2f(0.500773f, 0.372939f),new Vector2f(0.563273f, 0.372939f),new Vector2f(0.563273f, 0.622939f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(0.2f, 0.1f, -0.2f),new Vector3f(0.2f, 0.1f, 0.2f),new Vector3f(0.2f, 0.2f, 0.2f),new Vector3f(0.2f, 0.2f, -0.2f),new Vector2f(0.625773f, 0.62294f),new Vector2f(0.625773f, 0.372939f),new Vector2f(0.688273f, 0.372939f),new Vector2f(0.688273f, 0.62294f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.3f, -0.0f, -0.3f),new Vector3f(-0.3f, 0.0f, 0.3f),new Vector3f(-0.3f, 0.2f, 0.3f),new Vector3f(-0.3f, 0.2f, -0.3f),new Vector2f(0.625773f, 0.372939f),new Vector2f(0.625773f, -0.002061f),new Vector2f(0.750773f, -0.002061f),new Vector2f(0.750773f, 0.372939f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(0.3f, -0.0f, -0.3f),new Vector3f(-0.3f, -0.0f, -0.3f),new Vector3f(-0.3f, 0.2f, -0.3f),new Vector3f(0.3f, 0.2f, -0.3f),new Vector2f(0.750773f, 0.372939f),new Vector2f(0.750773f, -0.002061f),new Vector2f(0.875773f, -0.002061f),new Vector2f(0.875773f, 0.372939f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[8] = new ObjQuad(new Vector3f(0.3f, 0.0f, 0.3f),new Vector3f(0.3f, -0.0f, -0.3f),new Vector3f(0.3f, 0.2f, -0.3f),new Vector3f(0.3f, 0.2f, 0.3f),new Vector2f(0.500773f, 0.372939f),new Vector2f(0.500773f, -0.002061f),new Vector2f(0.625773f, -0.002061f),new Vector2f(0.625773f, 0.372939f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[9] = new ObjQuad(new Vector3f(-0.3f, 0.0f, 0.3f),new Vector3f(0.3f, 0.0f, 0.3f),new Vector3f(0.3f, 0.2f, 0.3f),new Vector3f(-0.3f, 0.2f, 0.3f),new Vector2f(0.875773f, 0.372939f),new Vector2f(0.875773f, -0.002061f),new Vector2f(1.000773f, -0.002061f),new Vector2f(1.000773f, 0.372939f),new Vector3f(0.0f, 0.0f, 4.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		HopperBottom other = new HopperBottom();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

package ip.industrialProcessing.subMod.logic.network.devices.readout.displayPanel.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Panel extends ObjMesh{
	public Panel(){
		this.quads = new ObjQuad[1];
		this.quads[0] = new ObjQuad(new Vector3f(-0.5f, 0.5f, -0.5f),new Vector3f(0.5f, 0.5f, -0.5f),new Vector3f(0.5f, 1.1f, -0.5f),new Vector3f(-0.5f, 1.1f, -0.5f),new Vector2f(0.0f, 0.2f),new Vector2f(1.0f, 0.2f),new Vector2f(1.0f, 0.8f),new Vector2f(0.0f, 0.8f),new Vector3f(0.0f, 0.0f, 4.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Panel other = new Panel();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

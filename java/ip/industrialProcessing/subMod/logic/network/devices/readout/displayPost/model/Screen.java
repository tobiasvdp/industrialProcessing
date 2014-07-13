package ip.industrialProcessing.subMod.logic.network.devices.readout.displayPost.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Screen extends ObjMesh{
	public Screen(){
		this.quads = new ObjQuad[1];
		this.quads[0] = new ObjQuad(new Vector3f(-0.6f, 0.9087f, 0.474f),new Vector3f(0.6f, 0.9087f, 0.474f),new Vector3f(0.6f, 1.5216f, -0.0402f),new Vector3f(-0.6f, 1.5216f, -0.0402f),new Vector2f(0.0f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector3f(0.0f, 2.5712f, 3.064f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Screen other = new Screen();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

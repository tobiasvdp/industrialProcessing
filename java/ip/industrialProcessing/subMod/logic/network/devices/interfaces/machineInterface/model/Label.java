package  ip.industrialProcessing.subMod.logic.network.devices.interfaces.machineInterface.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Label extends ObjMesh{
	public Label(){
		this.quads = new ObjQuad[1];
		this.quads[0] = new ObjQuad(new Vector3f(-0.16f, 0.64f, -0.4f),new Vector3f(0.16f, 0.64f, -0.4f),new Vector3f(0.16f, 0.96f, -0.4f),new Vector3f(-0.16f, 0.96f, -0.4f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(0.0f, 0.0f, 4.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Label other = new Label();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

package ip.industrialProcessing.multiblock.dummy.block.weldingTableExt.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Chest extends ObjMesh{
	public Chest(){
		this.quads = new ObjQuad[6];
		this.quads[0] = new ObjQuad(new Vector3f(-0.25f, 0.4f, 0.65f),new Vector3f(-0.25f, 0.4f, -0.15f),new Vector3f(0.55f, 0.4f, -0.15f),new Vector3f(0.55f, 0.4f, 0.65f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.25f, 1.2f, 0.65f),new Vector3f(0.55f, 1.2f, 0.65f),new Vector3f(0.55f, 1.2f, -0.15f),new Vector3f(-0.25f, 1.2f, -0.15f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.25f, 0.4f, 0.65f),new Vector3f(0.55f, 0.4f, 0.65f),new Vector3f(0.55f, 1.2f, 0.65f),new Vector3f(-0.25f, 1.2f, 0.65f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.55f, 0.4f, 0.65f),new Vector3f(0.55f, 0.4f, -0.15f),new Vector3f(0.55f, 1.2f, -0.15f),new Vector3f(0.55f, 1.2f, 0.65f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.55f, 0.4f, -0.15f),new Vector3f(-0.25f, 0.4f, -0.15f),new Vector3f(-0.25f, 1.2f, -0.15f),new Vector3f(0.55f, 1.2f, -0.15f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.25f, 0.4f, -0.15f),new Vector3f(-0.25f, 0.4f, 0.65f),new Vector3f(-0.25f, 1.2f, 0.65f),new Vector3f(-0.25f, 1.2f, -0.15f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(-4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Chest other = new Chest();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

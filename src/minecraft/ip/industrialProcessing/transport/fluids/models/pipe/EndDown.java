package ip.industrialProcessing.transport.fluids.models.pipe;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class EndDown extends ObjMesh{
	public EndDown(){
		this.quads = new ObjQuad[4];
		this.quads[0] = new ObjQuad(new Vector3f(0.2f, 0.5f, 0.2f),new Vector3f(-0.2f, 0.5f, 0.2f),new Vector3f(-0.2f, 0.0f, 0.2f),new Vector3f(0.2f, -0.0f, 0.2f),new Vector2f(0.375088f, 0.625202f),new Vector2f(0.624951f, 0.625202f),new Vector2f(0.624951f, 0.999962f),new Vector2f(0.375088f, 0.999962f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.2f, 0.5f, 0.2f),new Vector3f(-0.2f, 0.5f, -0.2f),new Vector3f(-0.2f, 0.0f, -0.2f),new Vector3f(-0.2f, 0.0f, 0.2f),new Vector2f(0.375088f, 0.625202f),new Vector2f(0.624951f, 0.625202f),new Vector2f(0.624951f, 0.999962f),new Vector2f(0.375088f, 0.999962f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.2f, 0.5f, -0.2f),new Vector3f(0.2f, 0.5f, -0.2f),new Vector3f(0.2f, -0.0f, -0.2f),new Vector3f(-0.2f, 0.0f, -0.2f),new Vector2f(0.375088f, 0.625202f),new Vector2f(0.624951f, 0.625202f),new Vector2f(0.624951f, 0.999962f),new Vector2f(0.375088f, 0.999962f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.2f, 0.5f, -0.2f),new Vector3f(0.2f, 0.5f, 0.2f),new Vector3f(0.2f, -0.0f, 0.2f),new Vector3f(0.2f, -0.0f, -0.2f),new Vector2f(0.375088f, 0.625202f),new Vector2f(0.624951f, 0.625202f),new Vector2f(0.624951f, 0.999962f),new Vector2f(0.375088f, 0.999962f),new Vector3f(4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		EndDown other = new EndDown();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

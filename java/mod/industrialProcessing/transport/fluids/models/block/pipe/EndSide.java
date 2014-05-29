package mod.industrialProcessing.transport.fluids.models.block.pipe;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class EndSide extends ObjMesh{
	public EndSide(){
		this.quads = new ObjQuad[4];
		this.quads[0] = new ObjQuad(new Vector3f(0.2f, 0.6f, -0.3f),new Vector3f(-0.2f, 0.6f, -0.3f),new Vector3f(-0.2f, 0.6f, -0.8f),new Vector3f(0.2f, 0.6f, -0.8f),new Vector2f(0.375088f, 0.625202f),new Vector2f(0.624951f, 0.625202f),new Vector2f(0.624951f, 0.999962f),new Vector2f(0.375088f, 0.999962f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.2f, 0.6f, -0.3f),new Vector3f(-0.2f, 1.0f, -0.3f),new Vector3f(-0.2f, 1.0f, -0.8f),new Vector3f(-0.2f, 0.6f, -0.8f),new Vector2f(0.375088f, 0.625202f),new Vector2f(0.624951f, 0.625202f),new Vector2f(0.624951f, 0.999962f),new Vector2f(0.375088f, 0.999962f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.2f, 1.0f, -0.3f),new Vector3f(0.2f, 1.0f, -0.3f),new Vector3f(0.2f, 1.0f, -0.8f),new Vector3f(-0.2f, 1.0f, -0.8f),new Vector2f(0.375088f, 0.625202f),new Vector2f(0.624951f, 0.625202f),new Vector2f(0.624951f, 0.999962f),new Vector2f(0.375088f, 0.999962f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.2f, 1.0f, -0.3f),new Vector3f(0.2f, 0.6f, -0.3f),new Vector3f(0.2f, 0.6f, -0.8f),new Vector3f(0.2f, 1.0f, -0.8f),new Vector2f(0.375088f, 0.625202f),new Vector2f(0.624951f, 0.625202f),new Vector2f(0.624951f, 0.999962f),new Vector2f(0.375088f, 0.999962f),new Vector3f(4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		EndSide other = new EndSide();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

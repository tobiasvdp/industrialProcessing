package mod.industrialProcessing.transport.fluids.models.block.pipe;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class ConnectorTop extends ObjMesh{
	public ConnectorTop(){
		this.quads = new ObjQuad[6];
		this.quads[0] = new ObjQuad(new Vector3f(-0.25f, 1.55f, 0.25f),new Vector3f(-0.25f, 1.55f, -0.25f),new Vector3f(0.25f, 1.55f, -0.25f),new Vector3f(0.25f, 1.55f, 0.25f),new Vector2f(0.312481f, 0.06251f),new Vector2f(0.312481f, 0.374988f),new Vector2f(3.7E-5f, 0.374988f),new Vector2f(3.7E-5f, 0.06251f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.25f, 1.65f, 0.25f),new Vector3f(0.25f, 1.65f, 0.25f),new Vector3f(0.25f, 1.65f, -0.25f),new Vector3f(-0.25f, 1.65f, -0.25f),new Vector2f(3.7E-5f, 0.06251f),new Vector2f(0.312481f, 0.06251f),new Vector2f(0.312481f, 0.374988f),new Vector2f(3.7E-5f, 0.374988f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.25f, 1.55f, 0.25f),new Vector3f(0.25f, 1.55f, 0.25f),new Vector3f(0.25f, 1.65f, 0.25f),new Vector3f(-0.25f, 1.65f, 0.25f),new Vector2f(0.0f, 0.0f),new Vector2f(0.312724f, 0.0f),new Vector2f(0.312724f, 0.0625f),new Vector2f(0.0f, 0.0625f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.25f, 1.55f, 0.25f),new Vector3f(0.25f, 1.55f, -0.25f),new Vector3f(0.25f, 1.65f, -0.25f),new Vector3f(0.25f, 1.65f, 0.25f),new Vector2f(0.0f, 0.0f),new Vector2f(0.312724f, 0.0f),new Vector2f(0.312724f, 0.0625f),new Vector2f(0.0f, 0.0625f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.25f, 1.55f, -0.25f),new Vector3f(-0.25f, 1.55f, -0.25f),new Vector3f(-0.25f, 1.65f, -0.25f),new Vector3f(0.25f, 1.65f, -0.25f),new Vector2f(0.0f, 0.0f),new Vector2f(0.312724f, 0.0f),new Vector2f(0.312724f, 0.0625f),new Vector2f(0.0f, 0.0625f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.25f, 1.55f, -0.25f),new Vector3f(-0.25f, 1.55f, 0.25f),new Vector3f(-0.25f, 1.65f, 0.25f),new Vector3f(-0.25f, 1.65f, -0.25f),new Vector2f(0.0f, 0.0f),new Vector2f(0.312724f, 0.0f),new Vector2f(0.312724f, 0.0625f),new Vector2f(0.0f, 0.0625f),new Vector3f(-4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		ConnectorTop other = new ConnectorTop();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

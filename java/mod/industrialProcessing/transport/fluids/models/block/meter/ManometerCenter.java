package mod.industrialProcessing.transport.fluids.models.block.meter;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class ManometerCenter extends ObjMesh{
	public ManometerCenter(){
		this.quads = new ObjQuad[8];
		this.quads[0] = new ObjQuad(new Vector3f(0.1f, 0.510056f, -0.699987f),new Vector3f(0.1f, 1.089944f, -0.699987f),new Vector3f(0.1f, 1.499987f, -0.289944f),new Vector3f(0.1f, 0.100013f, 0.289944f),new Vector2f(0.681215f, 0.937492f),new Vector2f(0.318785f, 0.937492f),new Vector2f(0.062508f, 0.681215f),new Vector2f(0.937492f, 0.318785f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.1f, 1.499987f, -0.289944f),new Vector3f(0.1f, 1.499987f, 0.289944f),new Vector3f(0.1f, 1.089944f, 0.699987f),new Vector3f(0.1f, 0.100013f, 0.289944f),new Vector2f(0.062508f, 0.681215f),new Vector2f(0.062508f, 0.318785f),new Vector2f(0.318785f, 0.062508f),new Vector2f(0.937492f, 0.318785f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.1f, 1.089944f, 0.699987f),new Vector3f(0.1f, 0.510056f, 0.699987f),new Vector3f(0.1f, 0.100013f, 0.289944f),new Vector2f(0.318785f, 0.062508f),new Vector2f(0.681215f, 0.062508f),new Vector2f(0.937492f, 0.318785f),new Vector3f(0.0f, -3.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.1f, 0.100013f, -0.289944f),new Vector3f(0.1f, 0.510056f, -0.699987f),new Vector3f(0.1f, 0.100013f, 0.289944f),new Vector2f(0.937492f, 0.681215f),new Vector2f(0.681215f, 0.937492f),new Vector2f(0.937492f, 0.318785f),new Vector3f(0.0f, -3.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.1f, 0.510056f, 0.699987f),new Vector3f(-0.1f, 1.089944f, 0.699987f),new Vector3f(-0.1f, 1.499987f, 0.289944f),new Vector3f(-0.1f, 0.100013f, -0.289944f),new Vector2f(0.681215f, 0.937492f),new Vector2f(0.318785f, 0.937492f),new Vector2f(0.062508f, 0.681215f),new Vector2f(0.937492f, 0.318785f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.1f, 1.499987f, 0.289944f),new Vector3f(-0.1f, 1.499987f, -0.289944f),new Vector3f(-0.1f, 1.089944f, -0.699987f),new Vector3f(-0.1f, 0.100013f, -0.289944f),new Vector2f(0.062508f, 0.681215f),new Vector2f(0.062508f, 0.318785f),new Vector2f(0.318785f, 0.062508f),new Vector2f(0.937492f, 0.318785f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.1f, 1.089944f, -0.699987f),new Vector3f(-0.1f, 0.510056f, -0.699987f),new Vector3f(-0.1f, 0.100013f, -0.289944f),new Vector2f(0.318785f, 0.062508f),new Vector2f(0.681215f, 0.062508f),new Vector2f(0.937492f, 0.318785f),new Vector3f(0.0f, 3.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.1f, 0.100013f, 0.289944f),new Vector3f(-0.1f, 0.510056f, 0.699987f),new Vector3f(-0.1f, 0.100013f, -0.289944f),new Vector2f(0.937492f, 0.681215f),new Vector2f(0.681215f, 0.937492f),new Vector2f(0.937492f, 0.318785f),new Vector3f(0.0f, 3.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		ManometerCenter other = new ManometerCenter();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

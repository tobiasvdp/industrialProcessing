package ip.industrialProcessing.power.storage.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Battery extends ObjMesh{
	public Battery(){
		this.quads = new ObjQuad[16];
		this.quads[0] = new ObjQuad(new Vector3f(-0.1375f, 0.9f, 0.1375f),new Vector3f(-0.1375f, 0.9f, -0.1375f),new Vector3f(0.1375f, 0.9f, -0.1375f),new Vector3f(0.1375f, 0.9f, 0.1375f),new Vector2f(-2.0E-4f, 0.1887f),new Vector2f(-2.0E-4f, 0.0028f),new Vector2f(0.1857f, 0.0028f),new Vector2f(0.1857f, 0.1887f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.1375f, 1.2f, 0.1375f),new Vector3f(0.1375f, 1.2f, 0.1375f),new Vector3f(0.1375f, 1.2f, -0.1375f),new Vector3f(-0.1375f, 1.2f, -0.1375f),new Vector2f(0.1873f, 4.0E-4f),new Vector2f(0.3732f, 3.0E-4f),new Vector2f(0.3732f, 0.1863f),new Vector2f(0.1873f, 0.1863f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.1375f, 0.9f, 0.1375f),new Vector3f(0.1375f, 0.9f, 0.1375f),new Vector3f(0.1375f, 1.2f, 0.1375f),new Vector3f(-0.1375f, 1.2f, 0.1375f),new Vector2f(0.8177f, 0.5569f),new Vector2f(0.8177f, 0.3691f),new Vector2f(1.0043f, 0.3691f),new Vector2f(1.0043f, 0.5569f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.1375f, 0.9f, 0.1375f),new Vector3f(0.1375f, 0.9f, -0.1375f),new Vector3f(0.1375f, 1.2f, -0.1375f),new Vector3f(0.1375f, 1.2f, 0.1375f),new Vector2f(0.8177f, 0.7435f),new Vector2f(0.8177f, 0.5556f),new Vector2f(1.0043f, 0.5556f),new Vector2f(1.0043f, 0.7435f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.1375f, 0.9f, -0.1375f),new Vector3f(-0.1375f, 0.9f, -0.1375f),new Vector3f(-0.1375f, 1.2f, -0.1375f),new Vector3f(0.1375f, 1.2f, -0.1375f),new Vector2f(0.8153f, 0.1872f),new Vector2f(0.8153f, -6.0E-4f),new Vector2f(1.0019f, -6.0E-4f),new Vector2f(1.0019f, 0.1872f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.1375f, 0.9f, -0.1375f),new Vector3f(-0.1375f, 0.9f, 0.1375f),new Vector3f(-0.1375f, 1.2f, 0.1375f),new Vector3f(-0.1375f, 1.2f, -0.1375f),new Vector2f(0.8153f, 0.3738f),new Vector2f(0.8153f, 0.1859f),new Vector2f(1.0019f, 0.1859f),new Vector2f(1.0019f, 0.3738f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.1f, 1.225f, 0.1f),new Vector3f(-0.05f, 1.225f, 0.1f),new Vector3f(-0.05f, 1.225f, 0.05f),new Vector3f(-0.1f, 1.225f, 0.05f),new Vector2f(0.3766f, 0.0621f),new Vector2f(0.4426f, 0.0621f),new Vector2f(0.4426f, 0.1281f),new Vector2f(0.3766f, 0.1281f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.1f, 1.2f, 0.1f),new Vector3f(-0.05f, 1.2f, 0.1f),new Vector3f(-0.05f, 1.225f, 0.1f),new Vector3f(-0.1f, 1.225f, 0.1f),new Vector2f(0.3782f, 0.127f),new Vector2f(0.3782f, 0.0615f),new Vector2f(0.4432f, 0.0615f),new Vector2f(0.4432f, 0.127f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[8] = new ObjQuad(new Vector3f(-0.05f, 1.2f, 0.1f),new Vector3f(-0.05f, 1.2f, 0.05f),new Vector3f(-0.05f, 1.225f, 0.05f),new Vector3f(-0.05f, 1.225f, 0.1f),new Vector2f(0.3772f, 0.1278f),new Vector2f(0.3772f, 0.0622f),new Vector2f(0.4422f, 0.0622f),new Vector2f(0.4422f, 0.1278f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[9] = new ObjQuad(new Vector3f(-0.05f, 1.2f, 0.05f),new Vector3f(-0.1f, 1.2f, 0.05f),new Vector3f(-0.1f, 1.225f, 0.05f),new Vector3f(-0.05f, 1.225f, 0.05f),new Vector2f(0.3782f, 0.1265f),new Vector2f(0.3782f, 0.061f),new Vector2f(0.4432f, 0.061f),new Vector2f(0.4432f, 0.1265f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[10] = new ObjQuad(new Vector3f(-0.1f, 1.2f, 0.05f),new Vector3f(-0.1f, 1.2f, 0.1f),new Vector3f(-0.1f, 1.225f, 0.1f),new Vector3f(-0.1f, 1.225f, 0.05f),new Vector2f(0.3801f, 0.1286f),new Vector2f(0.3801f, 0.0614f),new Vector2f(0.4426f, 0.0614f),new Vector2f(0.4426f, 0.1286f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[11] = new ObjQuad(new Vector3f(0.05f, 1.225f, -0.05f),new Vector3f(0.1f, 1.225f, -0.05f),new Vector3f(0.1f, 1.225f, -0.1f),new Vector3f(0.05f, 1.225f, -0.1f),new Vector2f(0.3774f, 0.0012f),new Vector2f(0.4423f, 0.0012f),new Vector2f(0.4423f, 0.0612f),new Vector2f(0.3774f, 0.0612f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[12] = new ObjQuad(new Vector3f(0.05f, 1.2f, -0.05f),new Vector3f(0.1f, 1.2f, -0.05f),new Vector3f(0.1f, 1.225f, -0.05f),new Vector3f(0.05f, 1.225f, -0.05f),new Vector2f(0.3761f, 0.0602f),new Vector2f(0.3761f, 5.0E-4f),new Vector2f(0.4401f, 5.0E-4f),new Vector2f(0.4401f, 0.0602f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[13] = new ObjQuad(new Vector3f(0.1f, 1.2f, -0.05f),new Vector3f(0.1f, 1.2f, -0.1f),new Vector3f(0.1f, 1.225f, -0.1f),new Vector3f(0.1f, 1.225f, -0.05f),new Vector2f(0.3772f, 0.0618f),new Vector2f(0.3772f, 0.0021f),new Vector2f(0.4412f, 0.0021f),new Vector2f(0.4412f, 0.0618f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[14] = new ObjQuad(new Vector3f(0.1f, 1.2f, -0.1f),new Vector3f(0.05f, 1.2f, -0.1f),new Vector3f(0.05f, 1.225f, -0.1f),new Vector3f(0.1f, 1.225f, -0.1f),new Vector2f(0.3777f, 0.0593f),new Vector2f(0.3777f, -4.0E-4f),new Vector2f(0.4417f, -4.0E-4f),new Vector2f(0.4417f, 0.0593f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[15] = new ObjQuad(new Vector3f(0.05f, 1.2f, -0.1f),new Vector3f(0.05f, 1.2f, -0.05f),new Vector3f(0.05f, 1.225f, -0.05f),new Vector3f(0.05f, 1.225f, -0.1f),new Vector2f(0.3791f, 0.0609f),new Vector2f(0.3791f, -3.0E-4f),new Vector2f(0.4406f, -3.0E-4f),new Vector2f(0.4406f, 0.0609f),new Vector3f(-4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Battery other = new Battery();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

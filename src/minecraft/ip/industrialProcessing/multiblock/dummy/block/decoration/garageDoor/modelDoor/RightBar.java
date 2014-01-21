package ip.industrialProcessing.multiblock.dummy.block.decoration.garageDoor.modelDoor;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class RightBar extends ObjMesh{
	public RightBar(){
		this.quads = new ObjQuad[16];
		this.quads[0] = new ObjQuad(new Vector3f(0.81f, 0.0f, -0.1f),new Vector3f(0.61f, 0.0f, -0.1f),new Vector3f(0.61f, 1.6f, -0.1f),new Vector3f(0.81f, 1.6f, -0.1f),new Vector2f(0.3951f, 0.002f),new Vector2f(0.7795f, 0.002f),new Vector2f(0.7795f, 0.3864f),new Vector2f(0.3951f, 0.3864f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.71f, 0.0f, 0.05f),new Vector3f(0.71f, 1.6f, 0.05f),new Vector3f(0.71f, 1.6f, -0.05f),new Vector3f(0.71f, 0.0f, -0.05f),new Vector2f(0.5873f, 0.3951f),new Vector2f(0.5873f, 0.7795f),new Vector2f(0.3951f, 0.7795f),new Vector2f(0.3951f, 0.3951f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.61f, 0.0f, 0.1f),new Vector3f(0.81f, 0.0f, 0.1f),new Vector3f(0.81f, 1.6f, 0.1f),new Vector3f(0.61f, 1.6f, 0.1f),new Vector2f(0.002f, 0.002f),new Vector2f(0.3864f, 0.002f),new Vector2f(0.3864f, 0.3864f),new Vector2f(0.002f, 0.3864f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.81f, 0.0f, -0.05f),new Vector3f(0.81f, 1.6f, -0.05f),new Vector3f(0.81f, 1.6f, 0.05f),new Vector3f(0.81f, 0.0f, 0.05f),new Vector2f(0.2903f, 0.3951f),new Vector2f(0.2903f, 0.7795f),new Vector2f(0.0981f, 0.7795f),new Vector2f(0.0981f, 0.3951f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.81f, 0.0f, 0.1f),new Vector3f(0.61f, 0.0f, 0.1f),new Vector3f(0.61f, 0.0f, 0.05f),new Vector3f(0.81f, 0.0f, 0.05f),new Vector2f(0.1379f, 0.8223f),new Vector2f(0.002f, 0.8223f),new Vector2f(0.002f, 0.7883f),new Vector2f(0.1379f, 0.7883f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(0.61f, 0.0f, -0.1f),new Vector3f(0.81f, 0.0f, -0.1f),new Vector3f(0.81f, 0.0f, -0.05f),new Vector3f(0.61f, 0.0f, -0.05f),new Vector2f(0.002f, 0.831f),new Vector2f(0.1379f, 0.831f),new Vector2f(0.1379f, 0.865f),new Vector2f(0.002f, 0.865f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(0.61f, 1.6f, 0.1f),new Vector3f(0.81f, 1.6f, 0.1f),new Vector3f(0.81f, 1.6f, 0.05f),new Vector3f(0.61f, 1.6f, 0.05f),new Vector2f(0.5311f, 0.8223f),new Vector2f(0.3951f, 0.8223f),new Vector2f(0.3951f, 0.7883f),new Vector2f(0.5311f, 0.7883f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(0.81f, 1.6f, -0.1f),new Vector3f(0.61f, 1.6f, -0.1f),new Vector3f(0.61f, 1.6f, -0.05f),new Vector3f(0.81f, 1.6f, -0.05f),new Vector2f(0.5961f, 0.7883f),new Vector2f(0.732f, 0.7883f),new Vector2f(0.732f, 0.8223f),new Vector2f(0.5961f, 0.8223f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(0.61f, 0.0f, 0.1f),new Vector3f(0.61f, 1.6f, 0.1f),new Vector3f(0.61f, 1.6f, 0.05f),new Vector3f(0.61f, 0.0f, 0.05f),new Vector2f(0.8931f, 0.3951f),new Vector2f(0.8931f, 0.7795f),new Vector2f(0.797f, 0.7795f),new Vector2f(0.797f, 0.3951f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[9] = new ObjQuad(new Vector3f(0.61f, 1.6f, -0.1f),new Vector3f(0.61f, 0.0f, -0.1f),new Vector3f(0.61f, 0.0f, -0.05f),new Vector3f(0.61f, 1.6f, -0.05f),new Vector2f(0.9019f, 0.7795f),new Vector2f(0.9019f, 0.3951f),new Vector2f(0.998f, 0.3951f),new Vector2f(0.998f, 0.7795f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[10] = new ObjQuad(new Vector3f(0.81f, 0.0f, -0.1f),new Vector3f(0.81f, 1.6f, -0.1f),new Vector3f(0.81f, 1.6f, -0.05f),new Vector3f(0.81f, 0.0f, -0.05f),new Vector2f(0.3864f, 0.3951f),new Vector2f(0.3864f, 0.7795f),new Vector2f(0.2903f, 0.7795f),new Vector2f(0.2903f, 0.3951f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[11] = new ObjQuad(new Vector3f(0.81f, 1.6f, 0.1f),new Vector3f(0.81f, 0.0f, 0.1f),new Vector3f(0.81f, 0.0f, 0.05f),new Vector3f(0.81f, 1.6f, 0.05f),new Vector2f(0.002f, 0.7795f),new Vector2f(0.002f, 0.3951f),new Vector2f(0.0981f, 0.3951f),new Vector2f(0.0981f, 0.7795f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[12] = new ObjQuad(new Vector3f(0.61f, 0.0f, 0.05f),new Vector3f(0.61f, 1.6f, 0.05f),new Vector3f(0.71f, 1.6f, 0.05f),new Vector3f(0.71f, 0.0f, 0.05f),new Vector2f(0.9805f, 0.002f),new Vector2f(0.9805f, 0.3864f),new Vector2f(0.7883f, 0.3864f),new Vector2f(0.7883f, 0.002f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[13] = new ObjQuad(new Vector3f(0.61f, 1.6f, -0.05f),new Vector3f(0.61f, 0.0f, -0.05f),new Vector3f(0.71f, 0.0f, -0.05f),new Vector3f(0.71f, 1.6f, -0.05f),new Vector2f(0.5961f, 0.7795f),new Vector2f(0.5961f, 0.3951f),new Vector2f(0.7883f, 0.3951f),new Vector2f(0.7883f, 0.7795f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[14] = new ObjQuad(new Vector3f(0.81f, 0.0f, -0.05f),new Vector3f(0.81f, 0.0f, 0.05f),new Vector3f(0.71f, 0.0f, 0.05f),new Vector3f(0.71f, 0.0f, -0.05f),new Vector2f(0.9699f, 0.7883f),new Vector2f(0.9699f, 0.8562f),new Vector2f(0.9019f, 0.8562f),new Vector2f(0.9019f, 0.7883f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[15] = new ObjQuad(new Vector3f(0.81f, 1.6f, 0.05f),new Vector3f(0.81f, 1.6f, -0.05f),new Vector3f(0.71f, 1.6f, -0.05f),new Vector3f(0.71f, 1.6f, 0.05f),new Vector2f(0.797f, 0.8562f),new Vector2f(0.797f, 0.7883f),new Vector2f(0.865f, 0.7883f),new Vector2f(0.865f, 0.8562f),new Vector3f(0.0f, 4.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		RightBar other = new RightBar();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

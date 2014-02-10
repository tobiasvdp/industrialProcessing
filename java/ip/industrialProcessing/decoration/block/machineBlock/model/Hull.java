package  ip.industrialProcessing.decoration.block.machineBlock.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Hull extends ObjMesh{
	public Hull(){
		this.quads = new ObjQuad[14];
		this.quads[0] = new ObjQuad(new Vector3f(-0.7f, 0.1f, 0.7f),new Vector3f(-0.7f, 0.1f, -0.7f),new Vector3f(0.7f, 0.1f, -0.7f),new Vector3f(0.7f, 0.1f, 0.7f),new Vector2f(0.2702f, 0.2702f),new Vector2f(0.2702f, 0.5383f),new Vector2f(0.002f, 0.5383f),new Vector2f(0.002f, 0.2702f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.6f, 0.2f, 0.6f),new Vector3f(0.6f, 0.2f, 0.6f),new Vector3f(0.6f, 0.2f, -0.6f),new Vector3f(-0.6f, 0.2f, -0.6f),new Vector2f(0.7298f, 0.5383f),new Vector2f(0.9597f, 0.5383f),new Vector2f(0.9597f, 0.7682f),new Vector2f(0.7298f, 0.7682f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.7f, 0.1f, 0.7f),new Vector3f(0.7f, 0.1f, 0.7f),new Vector3f(0.7f, 1.5f, 0.7f),new Vector3f(-0.7f, 1.5f, 0.7f),new Vector2f(0.5383f, 0.002f),new Vector2f(0.8065f, 0.002f),new Vector2f(0.8065f, 0.2702f),new Vector2f(0.5383f, 0.2702f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.7f, 0.1f, 0.7f),new Vector3f(0.7f, 0.1f, -0.7f),new Vector3f(0.7f, 1.5f, -0.7f),new Vector3f(0.7f, 1.5f, 0.7f),new Vector2f(0.2702f, 0.002f),new Vector2f(0.5383f, 0.002f),new Vector2f(0.5383f, 0.2702f),new Vector2f(0.2702f, 0.2702f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.7f, 0.1f, -0.7f),new Vector3f(-0.7f, 0.1f, -0.7f),new Vector3f(-0.7f, 1.5f, -0.7f),new Vector3f(0.7f, 1.5f, -0.7f),new Vector2f(0.002f, 0.5383f),new Vector2f(0.2702f, 0.5383f),new Vector2f(0.2702f, 0.8065f),new Vector2f(0.002f, 0.8065f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.7f, 0.1f, -0.7f),new Vector3f(-0.7f, 0.1f, 0.7f),new Vector3f(-0.7f, 1.5f, 0.7f),new Vector3f(-0.7f, 1.5f, -0.7f),new Vector2f(0.2702f, 0.2702f),new Vector2f(0.5383f, 0.2702f),new Vector2f(0.5383f, 0.5383f),new Vector2f(0.2702f, 0.5383f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.7f, 1.5f, 0.7f),new Vector3f(0.7f, 1.5f, 0.7f),new Vector3f(0.6f, 1.5f, 0.6f),new Vector3f(-0.6f, 1.5f, 0.6f),new Vector2f(0.002f, 0.002f),new Vector2f(0.2702f, 0.002f),new Vector2f(0.251f, 0.0212f),new Vector2f(0.0212f, 0.0212f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(0.7f, 1.5f, 0.7f),new Vector3f(0.7f, 1.5f, -0.7f),new Vector3f(0.6f, 1.5f, -0.6f),new Vector3f(0.6f, 1.5f, 0.6f),new Vector2f(0.2702f, 0.002f),new Vector2f(0.2702f, 0.2702f),new Vector2f(0.251f, 0.251f),new Vector2f(0.251f, 0.0212f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(0.7f, 1.5f, -0.7f),new Vector3f(-0.7f, 1.5f, -0.7f),new Vector3f(-0.6f, 1.5f, -0.6f),new Vector3f(0.6f, 1.5f, -0.6f),new Vector2f(0.2702f, 0.2702f),new Vector2f(0.002f, 0.2702f),new Vector2f(0.0212f, 0.251f),new Vector2f(0.251f, 0.251f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[9] = new ObjQuad(new Vector3f(-0.7f, 1.5f, -0.7f),new Vector3f(-0.7f, 1.5f, 0.7f),new Vector3f(-0.6f, 1.5f, 0.6f),new Vector3f(-0.6f, 1.5f, -0.6f),new Vector2f(0.002f, 0.2702f),new Vector2f(0.002f, 0.002f),new Vector2f(0.0212f, 0.0212f),new Vector2f(0.0212f, 0.251f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[10] = new ObjQuad(new Vector3f(-0.6f, 1.5f, 0.6f),new Vector3f(0.6f, 1.5f, 0.6f),new Vector3f(0.6f, 0.2f, 0.6f),new Vector3f(-0.6f, 0.2f, 0.6f),new Vector2f(0.7682f, 0.5192f),new Vector2f(0.5383f, 0.5192f),new Vector2f(0.5383f, 0.2702f),new Vector2f(0.7682f, 0.2702f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[11] = new ObjQuad(new Vector3f(0.6f, 1.5f, 0.6f),new Vector3f(0.6f, 1.5f, -0.6f),new Vector3f(0.6f, 0.2f, -0.6f),new Vector3f(0.6f, 0.2f, 0.6f),new Vector2f(0.7298f, 0.7873f),new Vector2f(0.5f, 0.7873f),new Vector2f(0.5f, 0.5383f),new Vector2f(0.7298f, 0.5383f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[12] = new ObjQuad(new Vector3f(0.6f, 1.5f, -0.6f),new Vector3f(-0.6f, 1.5f, -0.6f),new Vector3f(-0.6f, 0.2f, -0.6f),new Vector3f(0.6f, 0.2f, -0.6f),new Vector2f(0.998f, 0.5192f),new Vector2f(0.7682f, 0.5192f),new Vector2f(0.7682f, 0.2702f),new Vector2f(0.998f, 0.2702f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[13] = new ObjQuad(new Vector3f(-0.6f, 1.5f, -0.6f),new Vector3f(-0.6f, 1.5f, 0.6f),new Vector3f(-0.6f, 0.2f, 0.6f),new Vector3f(-0.6f, 0.2f, -0.6f),new Vector2f(0.5f, 0.7873f),new Vector2f(0.2702f, 0.7873f),new Vector2f(0.2702f, 0.5383f),new Vector2f(0.5f, 0.5383f),new Vector3f(4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Hull other = new Hull();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

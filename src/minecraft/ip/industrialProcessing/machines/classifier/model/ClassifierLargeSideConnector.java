package ip.industrialProcessing.machines.classifier.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class ClassifierLargeSideConnector extends ObjMesh{
	public ClassifierLargeSideConnector(){
		this.quads = new ObjQuad[15];
		this.quads[0] = new ObjQuad(new Vector3f(0.8f, 0.5002f, 0.3f),new Vector3f(0.8f, 0.5002f, -0.3f),new Vector3f(0.8f, 1.1002f, -0.3f),new Vector3f(0.8f, 1.1002f, 0.3f),new Vector2f(0.6254f, 1.0001f),new Vector2f(0.6254f, 0.6251f),new Vector2f(1.0004f, 0.6251f),new Vector2f(1.0004f, 1.0001f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.8f, 0.5002f, -0.3f),new Vector3f(0.8f, 0.5002f, 0.3f),new Vector3f(0.8f, 0.5002f, 0.0f),new Vector2f(1.0005f, 0.2498f),new Vector2f(1.0005f, 0.6248f),new Vector2f(1.0005f, 0.4373f),new Vector3f(-1.3416f, -2.6832f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.7f, 0.5002f, -0.3f),new Vector3f(0.8f, 0.5002f, -0.3f),new Vector3f(0.8f, 0.5002f, 0.0f),new Vector3f(0.7f, 0.5002f, 0.3f),new Vector2f(0.6249f, 0.1241f),new Vector2f(0.6249f, 0.0616f),new Vector2f(0.8124f, 0.0616f),new Vector2f(0.9999f, 0.1241f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.7f, 0.5002f, 0.3f),new Vector3f(0.8f, 0.5002f, 0.0f),new Vector3f(0.8f, 0.5002f, 0.3f),new Vector2f(0.9999f, 0.1241f),new Vector2f(0.8124f, 0.0616f),new Vector2f(0.9999f, 0.0616f),new Vector3f(0.0f, -3.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.7f, 0.5002f, -0.3f),new Vector3f(0.7f, 1.1002f, -0.3f),new Vector3f(0.8f, 1.1002f, -0.3f),new Vector3f(0.8f, 0.5002f, -0.3f),new Vector2f(0.9999f, 0.1241f),new Vector2f(0.6249f, 0.1241f),new Vector2f(0.6249f, 0.0616f),new Vector2f(0.9999f, 0.0616f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[5] = new ObjQuad(new Vector3f(0.5f, 1.0002f, 0.2f),new Vector3f(0.5f, 0.6002f, 0.2f),new Vector3f(0.7f, 0.6002f, 0.2f),new Vector3f(0.7f, 1.0002f, 0.2f),new Vector2f(0.9374f, 0.2488f),new Vector2f(0.6874f, 0.2488f),new Vector2f(0.6874f, 0.1241f),new Vector2f(0.9374f, 0.1241f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[6] = new ObjQuad(new Vector3f(0.7f, 1.0002f, -0.2f),new Vector3f(0.7f, 0.6002f, -0.2f),new Vector3f(0.5f, 0.6002f, -0.2f),new Vector3f(0.5f, 1.0002f, -0.2f),new Vector2f(0.6874f, 0.1241f),new Vector2f(0.9374f, 0.1241f),new Vector2f(0.9374f, 0.2488f),new Vector2f(0.6874f, 0.2488f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[7] = new ObjQuad(new Vector3f(0.7f, 0.6002f, 0.2f),new Vector3f(0.5f, 0.6002f, 0.2f),new Vector3f(0.5f, 0.6002f, -0.2f),new Vector3f(0.7f, 0.6002f, -0.2f),new Vector2f(0.9374f, 0.1241f),new Vector2f(0.9374f, 0.2488f),new Vector2f(0.6874f, 0.2488f),new Vector2f(0.6874f, 0.1241f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(0.5f, 1.0002f, 0.2f),new Vector3f(0.7f, 1.0002f, 0.2f),new Vector3f(0.7f, 1.0002f, -0.2f),new Vector3f(0.5f, 1.0002f, -0.2f),new Vector2f(0.6874f, 0.2488f),new Vector2f(0.6874f, 0.1241f),new Vector2f(0.9374f, 0.1241f),new Vector2f(0.9374f, 0.2488f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[9] = new ObjQuad(new Vector3f(0.8f, 0.5002f, 0.3f),new Vector3f(0.8f, 1.1002f, 0.3f),new Vector3f(0.7f, 1.1002f, 0.3f),new Vector3f(0.7f, 0.5002f, 0.3f),new Vector2f(0.6249f, 0.0616f),new Vector2f(0.9999f, 0.0616f),new Vector2f(0.9999f, 0.1241f),new Vector2f(0.6249f, 0.1241f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[10] = new ObjQuad(new Vector3f(0.8f, 1.1002f, -0.3f),new Vector3f(0.7f, 1.1002f, -0.3f),new Vector3f(0.7f, 1.1002f, 0.3f),new Vector3f(0.8f, 1.1002f, 0.3f),new Vector2f(0.9999f, 0.0616f),new Vector2f(0.9999f, 0.1241f),new Vector2f(0.6249f, 0.1241f),new Vector2f(0.6249f, 0.0616f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[11] = new ObjQuad(new Vector3f(0.7f, 0.6002f, -0.2f),new Vector3f(0.7f, 0.5002f, -0.3f),new Vector3f(0.7f, 0.5002f, 0.3f),new Vector3f(0.7f, 0.6002f, 0.2f),new Vector2f(0.938f, 0.3123f),new Vector2f(1.0005f, 0.2498f),new Vector2f(1.0005f, 0.6248f),new Vector2f(0.938f, 0.5623f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[12] = new ObjQuad(new Vector3f(0.7f, 1.1002f, -0.3f),new Vector3f(0.7f, 1.0002f, -0.2f),new Vector3f(0.7f, 1.0002f, 0.2f),new Vector3f(0.7f, 1.1002f, 0.3f),new Vector2f(0.6255f, 0.2498f),new Vector2f(0.688f, 0.3123f),new Vector2f(0.688f, 0.5623f),new Vector2f(0.6255f, 0.6248f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[13] = new ObjQuad(new Vector3f(0.7f, 1.1002f, 0.3f),new Vector3f(0.7f, 1.0002f, 0.2f),new Vector3f(0.7f, 0.6002f, 0.2f),new Vector3f(0.7f, 0.5002f, 0.3f),new Vector2f(0.6255f, 0.6248f),new Vector2f(0.688f, 0.5623f),new Vector2f(0.938f, 0.5623f),new Vector2f(1.0005f, 0.6248f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[14] = new ObjQuad(new Vector3f(0.7f, 1.0002f, -0.2f),new Vector3f(0.7f, 1.1002f, -0.3f),new Vector3f(0.7f, 0.5002f, -0.3f),new Vector3f(0.7f, 0.6002f, -0.2f),new Vector2f(0.688f, 0.3123f),new Vector2f(0.6255f, 0.2498f),new Vector2f(1.0005f, 0.2498f),new Vector2f(0.938f, 0.3123f),new Vector3f(-4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		ClassifierLargeSideConnector other = new ClassifierLargeSideConnector();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

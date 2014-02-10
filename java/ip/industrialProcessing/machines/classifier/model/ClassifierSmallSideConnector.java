package ip.industrialProcessing.machines.classifier.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class ClassifierSmallSideConnector extends ObjMesh{
	public ClassifierSmallSideConnector(){
		this.quads = new ObjQuad[7];
		this.quads[0] = new ObjQuad(new Vector3f(0.3f, 0.5002f, -0.8f),new Vector3f(-0.3f, 0.5002f, -0.8f),new Vector3f(-0.3f, 1.1002f, -0.8f),new Vector3f(0.3f, 1.1002f, -0.8f),new Vector2f(0.6254f, 1.0001f),new Vector2f(0.6254f, 0.6251f),new Vector2f(1.0004f, 0.6251f),new Vector2f(1.0004f, 1.0001f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.3f, 0.5002f, -0.8f),new Vector3f(0.3f, 0.5002f, -0.8f),new Vector3f(0.0f, 0.5002f, -0.8f),new Vector2f(1.0005f, 0.2498f),new Vector2f(1.0005f, 0.6248f),new Vector2f(1.0005f, 0.4373f),new Vector3f(0.0f, -2.6832f, 1.3416f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.3f, 0.5002f, -0.7f),new Vector3f(-0.3f, 0.5002f, -0.8f),new Vector3f(0.0f, 0.5002f, -0.8f),new Vector3f(0.3f, 0.5002f, -0.7f),new Vector2f(0.6249f, 0.1241f),new Vector2f(0.6249f, 0.0616f),new Vector2f(0.8124f, 0.0616f),new Vector2f(0.9999f, 0.1241f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.3f, 0.5002f, -0.7f),new Vector3f(0.0f, 0.5002f, -0.8f),new Vector3f(0.3f, 0.5002f, -0.8f),new Vector2f(0.9999f, 0.1241f),new Vector2f(0.8124f, 0.0616f),new Vector2f(0.9999f, 0.0616f),new Vector3f(0.0f, -3.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.3f, 0.5002f, -0.7f),new Vector3f(-0.3f, 1.1002f, -0.7f),new Vector3f(-0.3f, 1.1002f, -0.8f),new Vector3f(-0.3f, 0.5002f, -0.8f),new Vector2f(0.9999f, 0.1241f),new Vector2f(0.6249f, 0.1241f),new Vector2f(0.6249f, 0.0616f),new Vector2f(0.9999f, 0.0616f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(0.3f, 0.5002f, -0.8f),new Vector3f(0.3f, 1.1002f, -0.8f),new Vector3f(0.3f, 1.1002f, -0.7f),new Vector3f(0.3f, 0.5002f, -0.7f),new Vector2f(0.6249f, 0.0616f),new Vector2f(0.9999f, 0.0616f),new Vector2f(0.9999f, 0.1241f),new Vector2f(0.6249f, 0.1241f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.3f, 1.1002f, -0.8f),new Vector3f(-0.3f, 1.1002f, -0.7f),new Vector3f(0.3f, 1.1002f, -0.7f),new Vector3f(0.3f, 1.1002f, -0.8f),new Vector2f(0.9999f, 0.0616f),new Vector2f(0.9999f, 0.1241f),new Vector2f(0.6249f, 0.1241f),new Vector2f(0.6249f, 0.0616f),new Vector3f(0.0f, 4.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		ClassifierSmallSideConnector other = new ClassifierSmallSideConnector();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

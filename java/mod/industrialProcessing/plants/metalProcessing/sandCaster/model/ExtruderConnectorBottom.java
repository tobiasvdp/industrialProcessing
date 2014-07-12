package ip.industrialProcessing.machines.plants.metalProcessing.sandCaster.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class ExtruderConnectorBottom extends ObjMesh{
	public ExtruderConnectorBottom(){
		this.quads = new ObjQuad[12];
		this.quads[0] = new ObjQuad(new Vector3f(0.3f, -0.0f, 0.2998f),new Vector3f(-0.3f, -0.0f, 0.2998f),new Vector3f(-0.3f, -0.0f, -0.3002f),new Vector3f(0.3f, -0.0f, -0.3002f),new Vector2f(0.6254f, 1.0001f),new Vector2f(0.6254f, 0.6251f),new Vector2f(1.0004f, 0.6251f),new Vector2f(1.0004f, 1.0001f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.3f, -0.0f, 0.2998f),new Vector3f(0.3f, -0.0f, 0.2998f),new Vector3f(0.0f, 0.0f, 0.2998f),new Vector2f(1.0005f, 0.2498f),new Vector2f(1.0005f, 0.6248f),new Vector2f(1.0005f, 0.4373f),new Vector3f(0.0f, 1.2572999f, 2.724f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.3f, 0.1f, 0.2998f),new Vector3f(-0.3f, -0.0f, 0.2998f),new Vector3f(0.0f, 0.0f, 0.2998f),new Vector3f(0.3f, 0.1f, 0.2998f),new Vector2f(0.6249f, 0.1241f),new Vector2f(0.6249f, 0.0616f),new Vector2f(0.8124f, 0.0616f),new Vector2f(0.9999f, 0.1241f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.3f, 0.1f, 0.2998f),new Vector3f(0.0f, 0.0f, 0.2998f),new Vector3f(0.3f, -0.0f, 0.2998f),new Vector2f(0.9999f, 0.1241f),new Vector2f(0.8124f, 0.0616f),new Vector2f(0.9999f, 0.0616f),new Vector3f(0.0f, 0.0f, 3.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.3f, 0.1f, 0.2998f),new Vector3f(-0.3f, 0.1f, -0.3002f),new Vector3f(-0.3f, -0.0f, -0.3002f),new Vector3f(-0.3f, -0.0f, 0.2998f),new Vector2f(0.9999f, 0.1241f),new Vector2f(0.6249f, 0.1241f),new Vector2f(0.6249f, 0.0616f),new Vector2f(0.9999f, 0.0616f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(0.3f, -0.0f, 0.2998f),new Vector3f(0.3f, -0.0f, -0.3002f),new Vector3f(0.3f, 0.1f, -0.3002f),new Vector3f(0.3f, 0.1f, 0.2998f),new Vector2f(0.6249f, 0.0616f),new Vector2f(0.9999f, 0.0616f),new Vector2f(0.9999f, 0.1241f),new Vector2f(0.6249f, 0.1241f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.3f, -0.0f, -0.3002f),new Vector3f(-0.3f, 0.1f, -0.3002f),new Vector3f(0.3f, 0.1f, -0.3002f),new Vector3f(0.3f, -0.0f, -0.3002f),new Vector2f(0.9999f, 0.0616f),new Vector2f(0.9999f, 0.1241f),new Vector2f(0.6249f, 0.1241f),new Vector2f(0.6249f, 0.0616f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.2f, 0.2f, -0.2f),new Vector3f(-0.2f, 0.1f, -0.2f),new Vector3f(-0.2f, 0.1f, 0.2f),new Vector3f(-0.2f, 0.2f, 0.2f),new Vector2f(0.6875f, 0.1241f),new Vector2f(0.6875f, 0.0616f),new Vector2f(0.9375f, 0.0616f),new Vector2f(0.9375f, 0.1241f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(0.2f, 0.1f, -0.2f),new Vector3f(0.2f, 0.2f, -0.2f),new Vector3f(0.2f, 0.2f, 0.2f),new Vector3f(0.2f, 0.1f, 0.2f),new Vector2f(0.9372f, 0.0616f),new Vector2f(0.9372f, 0.1241f),new Vector2f(0.6872f, 0.1241f),new Vector2f(0.6872f, 0.0616f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[9] = new ObjQuad(new Vector3f(0.1998f, 0.2f, 0.1998f),new Vector3f(-0.1998f, 0.2f, 0.1998f),new Vector3f(-0.1998f, 0.1f, 0.1998f),new Vector3f(0.0f, 0.1f, 0.1998f),new Vector2f(0.9372f, 0.1241f),new Vector2f(0.6875f, 0.1241f),new Vector2f(0.6875f, 0.0616f),new Vector2f(0.8124f, 0.0616f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[10] = new ObjQuad(new Vector3f(0.1998f, 0.2f, 0.1998f),new Vector3f(0.0f, 0.1f, 0.1998f),new Vector3f(0.1998f, 0.1f, 0.1998f),new Vector2f(0.9372f, 0.1241f),new Vector2f(0.8124f, 0.0616f),new Vector2f(0.9372f, 0.0616f),new Vector3f(0.0f, 0.0f, 3.0f));
		this.quads[11] = new ObjQuad(new Vector3f(0.2002f, 0.2f, -0.2002f),new Vector3f(0.2002f, 0.1f, -0.2002f),new Vector3f(-0.2002f, 0.1f, -0.2002f),new Vector3f(-0.2002f, 0.2f, -0.2002f),new Vector2f(0.6872f, 0.1241f),new Vector2f(0.6872f, 0.0616f),new Vector2f(0.9375f, 0.0616f),new Vector2f(0.9375f, 0.1241f),new Vector3f(0.0f, 0.0f, -4.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		ExtruderConnectorBottom other = new ExtruderConnectorBottom();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

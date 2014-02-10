package ip.industrialProcessing.machines.diskFilter.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class ConnectorTop extends ObjMesh{
	public ConnectorTop(){
		this.quads = new ObjQuad[13];
		this.quads[0] = new ObjQuad(new Vector3f(-0.2f, 1.4f, 0.2f),new Vector3f(-0.2f, 1.5f, 0.2f),new Vector3f(-0.2f, 1.5f, -0.2f),new Vector3f(-0.2f, 1.4f, -0.2f),new Vector2f(0.5625f, 0.875f),new Vector2f(0.5625f, 0.9375f),new Vector2f(0.3125f, 0.9375f),new Vector2f(0.3125f, 0.875f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.2f, 1.4f, 0.2f),new Vector3f(0.2f, 1.4f, 0.2f),new Vector3f(0.2f, 1.5f, 0.2f),new Vector3f(-0.2f, 1.5f, 0.2f),new Vector2f(0.3125f, 0.875f),new Vector2f(0.5625f, 0.875f),new Vector2f(0.5625f, 0.9375f),new Vector2f(0.3125f, 0.9375f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.2f, 1.4f, 0.2f),new Vector3f(0.2f, 1.4f, -0.2f),new Vector3f(0.2f, 1.5f, -0.2f),new Vector3f(0.2f, 1.5f, 0.2f),new Vector2f(0.3125f, 0.875f),new Vector2f(0.5625f, 0.875f),new Vector2f(0.5625f, 0.9375f),new Vector2f(0.3125f, 0.9375f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.2f, 1.5f, -0.2f),new Vector3f(0.2f, 1.5f, -0.2f),new Vector3f(0.2f, 1.4f, -0.2f),new Vector3f(-0.2f, 1.4f, -0.2f),new Vector2f(0.5625f, 0.9375f),new Vector2f(0.3125f, 0.9375f),new Vector2f(0.3125f, 0.875f),new Vector2f(0.5625f, 0.875f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.2f, 1.5f, -0.2f),new Vector3f(-0.3014f, 1.5f, -0.3014f),new Vector3f(0.2986f, 1.5f, -0.3014f),new Vector3f(0.2f, 1.5f, -0.2f),new Vector2f(0.9375f, 0.5625f),new Vector2f(1.0009f, 0.6259f),new Vector2f(0.6259f, 0.6259f),new Vector2f(0.6875f, 0.5625f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(0.2986f, 1.5f, -0.3014f),new Vector3f(0.2986f, 1.6f, -0.3014f),new Vector3f(0.2986f, 1.6f, 0.2986f),new Vector3f(0.2986f, 1.5f, 0.2986f),new Vector2f(0.6252f, 0.9375f),new Vector2f(0.6252f, 1.0f),new Vector2f(0.2502f, 1.0f),new Vector2f(0.2502f, 0.9375f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(0.2986f, 1.5f, -0.3014f),new Vector3f(-0.3014f, 1.5f, -0.3014f),new Vector3f(-0.3014f, 1.6f, -0.3014f),new Vector3f(0.2986f, 1.6f, -0.3014f),new Vector2f(0.2502f, 0.9375f),new Vector2f(0.6252f, 0.9375f),new Vector2f(0.6252f, 1.0f),new Vector2f(0.2502f, 1.0f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.3014f, 1.5f, 0.2986f),new Vector3f(-0.3014f, 1.6f, 0.2986f),new Vector3f(-0.3014f, 1.6f, -0.3014f),new Vector3f(-0.3014f, 1.5f, -0.3014f),new Vector2f(0.6252f, 0.9373f),new Vector2f(0.6252f, 0.9998f),new Vector2f(0.2502f, 0.9998f),new Vector2f(0.2502f, 0.9373f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(-0.3014f, 1.5f, 0.2986f),new Vector3f(0.2986f, 1.5f, 0.2986f),new Vector3f(0.2986f, 1.6f, 0.2986f),new Vector3f(-0.3014f, 1.6f, 0.2986f),new Vector2f(0.2502f, 0.9373f),new Vector2f(0.6252f, 0.9373f),new Vector2f(0.6252f, 0.9998f),new Vector2f(0.2502f, 0.9998f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[9] = new ObjQuad(new Vector3f(0.2986f, 1.6f, 0.2986f),new Vector3f(0.2986f, 1.6f, -0.3014f),new Vector3f(-0.3014f, 1.6f, -0.3014f),new Vector3f(-0.3014f, 1.6f, 0.2986f),new Vector2f(0.9991f, 0.6259f),new Vector2f(0.9991f, 1.0009f),new Vector2f(0.6241f, 1.0009f),new Vector2f(0.6241f, 0.6259f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[10] = new ObjQuad(new Vector3f(-0.2f, 1.5f, -0.2f),new Vector3f(-0.2f, 1.5f, 0.2f),new Vector3f(-0.3014f, 1.5f, 0.2986f),new Vector3f(-0.3014f, 1.5f, -0.3014f),new Vector2f(0.9375f, 0.5625f),new Vector2f(0.9375f, 0.3125f),new Vector2f(1.0009f, 0.2509f),new Vector2f(1.0009f, 0.6259f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[11] = new ObjQuad(new Vector3f(0.2986f, 1.5f, 0.2986f),new Vector3f(-0.3014f, 1.5f, 0.2986f),new Vector3f(-0.2f, 1.5f, 0.2f),new Vector3f(0.2f, 1.5f, 0.2f),new Vector2f(0.6259f, 0.2509f),new Vector2f(1.0009f, 0.2509f),new Vector2f(0.9375f, 0.3125f),new Vector2f(0.6875f, 0.3125f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[12] = new ObjQuad(new Vector3f(0.2986f, 1.5f, 0.2986f),new Vector3f(0.2f, 1.5f, 0.2f),new Vector3f(0.2f, 1.5f, -0.2f),new Vector3f(0.2986f, 1.5f, -0.3014f),new Vector2f(0.6259f, 0.2509f),new Vector2f(0.6875f, 0.3125f),new Vector2f(0.6875f, 0.5625f),new Vector2f(0.6259f, 0.6259f),new Vector3f(0.0f, -4.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		ConnectorTop other = new ConnectorTop();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

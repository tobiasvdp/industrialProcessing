package mod.industrialProcessing.plants.machine.diskFilter.model;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class ConnectorSide extends ObjMesh{
	public ConnectorSide(){
		this.quads = new ObjQuad[5];
		this.quads[0] = new ObjQuad(new Vector3f(0.3f, 1.1f, -0.7f),new Vector3f(0.3f, 1.1f, -0.8f),new Vector3f(-0.3f, 1.1f, -0.8f),new Vector3f(-0.3f, 1.1f, -0.7f),new Vector2f(1.0f, 0.0625f),new Vector2f(1.0f, 0.125f),new Vector2f(0.625f, 0.125f),new Vector2f(0.625f, 0.0625f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.3f, 1.1f, -0.7f),new Vector3f(0.3f, 0.5f, -0.6f),new Vector3f(0.3f, 0.5f, -0.8f),new Vector3f(0.3f, 1.1f, -0.8f),new Vector2f(0.9375f, 0.625f),new Vector2f(0.875f, 0.25f),new Vector2f(1.0f, 0.25f),new Vector2f(1.0f, 0.625f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.3f, 1.1f, -0.8f),new Vector3f(0.3f, 1.1f, -0.8f),new Vector3f(0.3f, 0.5f, -0.8f),new Vector3f(-0.3f, 0.5f, -0.8f),new Vector2f(1.0f, 1.0f),new Vector2f(0.625f, 1.0f),new Vector2f(0.625f, 0.625f),new Vector2f(1.0f, 0.625f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.3f, 0.5f, -0.6f),new Vector3f(-0.3f, 0.5f, -0.6f),new Vector3f(-0.3f, 0.5f, -0.8f),new Vector3f(0.3f, 0.5f, -0.8f),new Vector2f(0.625f, 0.125f),new Vector2f(1.0f, 0.125f),new Vector2f(1.0f, 0.25f),new Vector2f(0.625f, 0.25f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.3f, 0.5f, -0.6f),new Vector3f(-0.3f, 1.1f, -0.7f),new Vector3f(-0.3f, 1.1f, -0.8f),new Vector3f(-0.3f, 0.5f, -0.8f),new Vector2f(0.75f, 0.25f),new Vector2f(0.6875f, 0.625f),new Vector2f(0.625f, 0.625f),new Vector2f(0.625f, 0.25f),new Vector3f(-4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		ConnectorSide other = new ConnectorSide();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

package mod.industrialProcessing.plants.construction.weldingStation.model;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class LeftBar extends ObjMesh{
	public LeftBar(){
		this.quads = new ObjQuad[6];
		this.quads[0] = new ObjQuad(new Vector3f(-0.775f, 0.0f, 0.74f),new Vector3f(-0.775f, 0.0f, -0.66f),new Vector3f(-0.625f, 0.0f, -0.66f),new Vector3f(-0.625f, 0.0f, 0.74f),new Vector2f(0.9844f, 0.0375f),new Vector2f(0.9844f, 0.9125f),new Vector2f(0.8906f, 0.9125f),new Vector2f(0.8906f, 0.0375f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.775f, 0.15f, 0.74f),new Vector3f(-0.625f, 0.15f, 0.74f),new Vector3f(-0.625f, 0.15f, -0.66f),new Vector3f(-0.775f, 0.15f, -0.66f),new Vector2f(0.0156f, 0.0375f),new Vector2f(0.1094f, 0.0375f),new Vector2f(0.1094f, 0.9125f),new Vector2f(0.0156f, 0.9125f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.775f, 0.0f, 0.74f),new Vector3f(-0.625f, 0.0f, 0.74f),new Vector3f(-0.625f, 0.15f, 0.74f),new Vector3f(-0.775f, 0.15f, 0.74f),new Vector2f(0.0156f, 0.0f),new Vector2f(0.1094f, 0.0f),new Vector2f(0.1094f, 0.0938f),new Vector2f(0.0156f, 0.0938f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.625f, 0.0f, 0.74f),new Vector3f(-0.625f, 0.0f, -0.66f),new Vector3f(-0.625f, 0.15f, -0.66f),new Vector3f(-0.625f, 0.15f, 0.74f),new Vector2f(0.0375f, 0.0f),new Vector2f(0.9125f, 0.0f),new Vector2f(0.9125f, 0.0938f),new Vector2f(0.0375f, 0.0938f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.625f, 0.0f, -0.66f),new Vector3f(-0.775f, 0.0f, -0.66f),new Vector3f(-0.775f, 0.15f, -0.66f),new Vector3f(-0.625f, 0.15f, -0.66f),new Vector2f(0.8906f, 0.0f),new Vector2f(0.9844f, 0.0f),new Vector2f(0.9844f, 0.0938f),new Vector2f(0.8906f, 0.0938f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.775f, 0.0f, -0.66f),new Vector3f(-0.775f, 0.0f, 0.74f),new Vector3f(-0.775f, 0.15f, 0.74f),new Vector3f(-0.775f, 0.15f, -0.66f),new Vector2f(0.0875f, 0.0f),new Vector2f(0.9625f, 0.0f),new Vector2f(0.9625f, 0.0938f),new Vector2f(0.0875f, 0.0938f),new Vector3f(-4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		LeftBar other = new LeftBar();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

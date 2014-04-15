package mod.industrialProcessing.plants.power.wire.models;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Center extends ObjMesh{
	public Center(){
		this.quads = new ObjQuad[6];
		this.quads[0] = new ObjQuad(new Vector3f(-0.2f, 0.6f, 0.2f),new Vector3f(-0.2f, 0.6f, -0.2f),new Vector3f(0.2f, 0.6f, -0.2f),new Vector3f(0.2f, 0.6f, 0.2f),new Vector2f(0.249962f, 0.750091f),new Vector2f(0.249962f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector2f(0.0f, 0.750091f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.2f, 1.0f, 0.2f),new Vector3f(0.2f, 1.0f, 0.2f),new Vector3f(0.2f, 1.0f, -0.2f),new Vector3f(-0.2f, 1.0f, -0.2f),new Vector2f(0.0f, 0.750091f),new Vector2f(0.249962f, 0.750091f),new Vector2f(0.249962f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.2f, 0.6f, 0.2f),new Vector3f(0.2f, 0.6f, 0.2f),new Vector3f(0.2f, 1.0f, 0.2f),new Vector3f(-0.2f, 1.0f, 0.2f),new Vector2f(0.0f, 0.750114f),new Vector2f(0.249923f, 0.750114f),new Vector2f(0.249923f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.2f, 0.6f, 0.2f),new Vector3f(0.2f, 0.6f, -0.2f),new Vector3f(0.2f, 1.0f, -0.2f),new Vector3f(0.2f, 1.0f, 0.2f),new Vector2f(0.0f, 0.750114f),new Vector2f(0.249923f, 0.750114f),new Vector2f(0.249923f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.2f, 0.6f, -0.2f),new Vector3f(-0.2f, 0.6f, -0.2f),new Vector3f(-0.2f, 1.0f, -0.2f),new Vector3f(0.2f, 1.0f, -0.2f),new Vector2f(0.0f, 0.750114f),new Vector2f(0.249923f, 0.750114f),new Vector2f(0.249923f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.2f, 0.6f, -0.2f),new Vector3f(-0.2f, 0.6f, 0.2f),new Vector3f(-0.2f, 1.0f, 0.2f),new Vector3f(-0.2f, 1.0f, -0.2f),new Vector2f(0.0f, 0.750114f),new Vector2f(0.249923f, 0.750114f),new Vector2f(0.249923f, 1.0f),new Vector2f(0.0f, 1.0f),new Vector3f(-4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Center other = new Center();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

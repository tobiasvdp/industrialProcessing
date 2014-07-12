package mod.industrialProcessing.plants.power.wire.models;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class StraightVertical extends ObjMesh{
	public StraightVertical(){
		this.quads = new ObjQuad[4];
		this.quads[0] = new ObjQuad(new Vector3f(-0.2f, 0.0f, 0.2f),new Vector3f(0.2f, 0.0f, 0.2f),new Vector3f(0.2f, 1.6f, 0.2f),new Vector3f(-0.2f, 1.6f, 0.2f),new Vector2f(0.750027f, 1.93E-4f),new Vector2f(1.0f, 1.93E-4f),new Vector2f(1.0f, 1.0f),new Vector2f(0.750027f, 1.0f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.2f, 0.0f, 0.2f),new Vector3f(0.2f, 0.0f, -0.2f),new Vector3f(0.2f, 1.6f, -0.2f),new Vector3f(0.2f, 1.6f, 0.2f),new Vector2f(0.750027f, 1.93E-4f),new Vector2f(1.0f, 1.93E-4f),new Vector2f(1.0f, 1.0f),new Vector2f(0.750027f, 1.0f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.2f, 0.0f, -0.2f),new Vector3f(-0.2f, 0.0f, -0.2f),new Vector3f(-0.2f, 1.6f, -0.2f),new Vector3f(0.2f, 1.6f, -0.2f),new Vector2f(0.750027f, 1.93E-4f),new Vector2f(1.0f, 1.93E-4f),new Vector2f(1.0f, 1.0f),new Vector2f(0.750027f, 1.0f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.2f, 0.0f, -0.2f),new Vector3f(-0.2f, 0.0f, 0.2f),new Vector3f(-0.2f, 1.6f, 0.2f),new Vector3f(-0.2f, 1.6f, -0.2f),new Vector2f(0.750027f, 1.93E-4f),new Vector2f(1.0f, 1.93E-4f),new Vector2f(1.0f, 1.0f),new Vector2f(0.750027f, 1.0f),new Vector3f(-4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		StraightVertical other = new StraightVertical();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

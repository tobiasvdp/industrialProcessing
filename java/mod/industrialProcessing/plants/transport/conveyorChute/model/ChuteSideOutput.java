package mod.industrialProcessing.plants.transport.conveyorChute.model;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class ChuteSideOutput extends ObjMesh{
	public ChuteSideOutput(){
		this.quads = new ObjQuad[4];
		this.quads[0] = new ObjQuad(new Vector3f(0.25f, 1.05f, -0.7f),new Vector3f(0.25f, 1.05f, -0.3f),new Vector3f(0.25f, 0.55f, -0.3f),new Vector3f(0.25f, 0.55f, -0.7f),new Vector2f(0.3125f, 0.0625f),new Vector2f(0.3125f, 0.3125f),new Vector2f(-0.0f, 0.3125f),new Vector2f(-0.0f, 0.0625f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.25f, 1.05f, -0.7f),new Vector3f(-0.25f, 1.05f, -0.3f),new Vector3f(0.25f, 1.05f, -0.3f),new Vector3f(0.25f, 1.05f, -0.7f),new Vector2f(0.3125f, 0.0625f),new Vector2f(0.3125f, 0.3125f),new Vector2f(0.0f, 0.3125f),new Vector2f(0.0f, 0.0625f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.25f, 0.55f, -0.7f),new Vector3f(0.25f, 0.55f, -0.7f),new Vector3f(0.25f, 0.55f, -0.3f),new Vector3f(-0.25f, 0.55f, -0.3f),new Vector2f(0.3125f, 0.0625f),new Vector2f(0.0f, 0.0625f),new Vector2f(0.0f, 0.3125f),new Vector2f(0.3125f, 0.3125f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.25f, 1.05f, -0.7f),new Vector3f(-0.25f, 0.55f, -0.7f),new Vector3f(-0.25f, 0.55f, -0.3f),new Vector3f(-0.25f, 1.05f, -0.3f),new Vector2f(0.3125f, 0.0625f),new Vector2f(-0.0f, 0.0625f),new Vector2f(-0.0f, 0.3125f),new Vector2f(0.3125f, 0.3125f),new Vector3f(-4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		ChuteSideOutput other = new ChuteSideOutput();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

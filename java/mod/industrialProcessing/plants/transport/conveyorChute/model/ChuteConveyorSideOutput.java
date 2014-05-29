package mod.industrialProcessing.plants.transport.conveyorChute.model;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class ChuteConveyorSideOutput extends ObjMesh{
	public ChuteConveyorSideOutput(){
		this.quads = new ObjQuad[4];
		this.quads[0] = new ObjQuad(new Vector3f(-0.3f, 0.9f, 0.2f),new Vector3f(-0.3f, 1.5f, 0.2f),new Vector3f(0.3f, 1.5f, 0.2f),new Vector3f(0.3f, 0.9f, 0.2f),new Vector2f(0.0f, 1.0f),new Vector2f(0.0f, 0.625f),new Vector2f(0.375f, 0.625f),new Vector2f(0.375f, 1.0f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.3f, 1.5f, 0.3f),new Vector3f(-0.3f, 1.5f, 0.3f),new Vector3f(-0.3f, 0.9f, 0.3f),new Vector3f(0.3f, 0.9f, 0.3f),new Vector2f(0.625f, 0.625f),new Vector2f(1.0f, 0.625f),new Vector2f(1.0f, 1.0f),new Vector2f(0.625f, 1.0f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.3f, 0.9f, 0.2f),new Vector3f(0.3f, 1.5f, 0.2f),new Vector3f(0.3f, 1.5f, 0.3f),new Vector3f(0.3f, 0.9f, 0.3f),new Vector2f(1.0f, 0.53125f),new Vector2f(0.625f, 0.53125f),new Vector2f(0.625f, 0.46875f),new Vector2f(1.0f, 0.46875f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.3f, 1.5f, 0.2f),new Vector3f(-0.3f, 0.9f, 0.2f),new Vector3f(-0.3f, 0.9f, 0.3f),new Vector3f(-0.3f, 1.5f, 0.3f),new Vector2f(0.375f, 0.53125f),new Vector2f(-0.0f, 0.53125f),new Vector2f(-0.0f, 0.46875f),new Vector2f(0.375f, 0.46875f),new Vector3f(-4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		ChuteConveyorSideOutput other = new ChuteConveyorSideOutput();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

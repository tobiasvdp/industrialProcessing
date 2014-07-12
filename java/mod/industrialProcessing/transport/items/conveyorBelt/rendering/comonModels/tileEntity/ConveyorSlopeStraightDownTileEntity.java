package mod.industrialProcessing.transport.items.conveyorBelt.rendering.comonModels.tileEntity;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class ConveyorSlopeStraightDownTileEntity extends ObjMesh{
	public ConveyorSlopeStraightDownTileEntity(){
		this.quads = new ObjQuad[3];
		this.quads[0] = new ObjQuad(new Vector3f(0.6939f, 1.7061f, -0.2f),new Vector3f(-0.9061f, 0.1061f, -0.2f),new Vector3f(-0.9061f, 0.1061f, 0.2f),new Vector3f(0.6939f, 1.7061f, 0.2f),new Vector2f(0.125f, 1.0f),new Vector2f(0.125f, 0.0f),new Vector2f(0.375f, 0.0f),new Vector2f(0.375f, 1.0f),new Vector3f(-2.8284f, 2.8284f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(0.7293f, 1.6707f, -0.3f),new Vector3f(-0.8707f, 0.0707f, -0.3f),new Vector3f(-0.9061f, 0.1061f, -0.2f),new Vector3f(0.6939f, 1.7061f, -0.2f),new Vector2f(0.0625f, 1.0f),new Vector2f(0.0625f, 0.0f),new Vector2f(0.125f, 0.0f),new Vector2f(0.125f, 1.0f),new Vector3f(-2.53f, 2.53f, -1.7888f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.8707f, 0.0707f, 0.3f),new Vector3f(0.7293f, 1.6707f, 0.3f),new Vector3f(0.6939f, 1.7061f, 0.2f),new Vector3f(-0.9061f, 0.1061f, 0.2f),new Vector2f(0.4375f, 0.0f),new Vector2f(0.4375f, 1.0f),new Vector2f(0.375f, 1.0f),new Vector2f(0.375f, 0.0f),new Vector3f(-2.53f, 2.53f, 1.7888f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		ConveyorSlopeStraightDownTileEntity other = new ConveyorSlopeStraightDownTileEntity();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

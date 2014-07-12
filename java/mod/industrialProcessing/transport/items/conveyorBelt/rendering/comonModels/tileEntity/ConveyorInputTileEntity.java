package mod.industrialProcessing.transport.items.conveyorBelt.rendering.comonModels.tileEntity;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class ConveyorInputTileEntity extends ObjMesh{
	public ConveyorInputTileEntity(){
		this.quads = new ObjQuad[4];
		this.quads[0] = new ObjQuad(new Vector3f(-0.3f, 0.95f, 0.2f),new Vector3f(-0.3f, 0.95f, -0.2f),new Vector3f(-0.8f, 0.95f, -0.2f),new Vector3f(-0.8f, 0.95f, 0.2f),new Vector2f(0.125f, 0.6875f),new Vector2f(0.375f, 0.6875f),new Vector2f(0.375f, 1.0f),new Vector2f(0.125f, 1.0f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.3f, 0.9f, 0.3f),new Vector3f(-0.3f, 0.95f, 0.2f),new Vector3f(-0.8f, 0.95f, 0.2f),new Vector3f(-0.8f, 0.9f, 0.3f),new Vector2f(0.0625f, 0.6875f),new Vector2f(0.125f, 0.6875f),new Vector2f(0.125f, 1.0f),new Vector2f(0.0625f, 1.0f),new Vector3f(0.0f, 3.5776f, 1.7888f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.8f, 0.9f, -0.3f),new Vector3f(-0.8f, 0.95f, -0.2f),new Vector3f(-0.3f, 0.95f, -0.2f),new Vector3f(-0.3f, 0.9f, -0.3f),new Vector2f(0.4375f, 1.0f),new Vector2f(0.375f, 1.0f),new Vector2f(0.375f, 0.6875f),new Vector2f(0.4375f, 0.6875f),new Vector3f(0.0f, 3.5776f, -1.7888f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.3f, 0.95f, -0.2f),new Vector3f(-0.3f, 0.95f, 0.2f),new Vector3f(-0.3f, 0.9f, 0.3f),new Vector3f(-0.3f, 0.9f, -0.3f),new Vector2f(0.375f, 0.6875f),new Vector2f(0.125f, 0.6875f),new Vector2f(0.0625f, 0.6875f),new Vector2f(0.4375f, 0.6875f),new Vector3f(4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		ConveyorInputTileEntity other = new ConveyorInputTileEntity();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

package ip.industrialProcessing.transport.items.conveyorModels.tileEntity;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class ConveyorStraightTileEntity extends ObjMesh{
	public ConveyorStraightTileEntity(){
		this.quads = new ObjQuad[3];
		this.quads[0] = new ObjQuad(new Vector3f(-0.8f, 0.95f, 0.2f),new Vector3f(0.8f, 0.95f, 0.2f),new Vector3f(0.8f, 0.95f, -0.2f),new Vector3f(-0.8f, 0.95f, -0.2f),new Vector2f(0.125f, 1.0f),new Vector2f(0.125f, 0.0f),new Vector2f(0.375f, 0.0f),new Vector2f(0.375f, 1.0f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.8f, 0.9f, 0.3f),new Vector3f(0.8f, 0.9f, 0.3f),new Vector3f(0.8f, 0.95f, 0.2f),new Vector3f(-0.8f, 0.95f, 0.2f),new Vector2f(0.0625f, 1.0f),new Vector2f(0.0625f, 0.0f),new Vector2f(0.125f, 0.0f),new Vector2f(0.125f, 1.0f),new Vector3f(0.0f, 3.5776f, 1.7888f));
		this.quads[2] = new ObjQuad(new Vector3f(0.8f, 0.9f, -0.3f),new Vector3f(-0.8f, 0.9f, -0.3f),new Vector3f(-0.8f, 0.95f, -0.2f),new Vector3f(0.8f, 0.95f, -0.2f),new Vector2f(0.4375f, 0.0f),new Vector2f(0.4375f, 1.0f),new Vector2f(0.375f, 1.0f),new Vector2f(0.375f, 0.0f),new Vector3f(0.0f, 3.5776f, -1.7888f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		ConveyorStraightTileEntity other = new ConveyorStraightTileEntity();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

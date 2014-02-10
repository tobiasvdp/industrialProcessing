package ip.industrialProcessing.multiblock.dummy.block.ironPole.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Box001 extends ObjMesh{
	public Box001(){
		this.quads = new ObjQuad[10];
		this.quads[0] = new ObjQuad(new Vector3f(-0.5f, 0.0f, 0.5f),new Vector3f(-0.5f, 0.0f, -0.5f),new Vector3f(0.5f, 0.0f, -0.5f),new Vector3f(0.5f, 0.0f, 0.5f),new Vector2f(0.8125f, 0.1875f),new Vector2f(0.8125f, 0.8125f),new Vector2f(0.1875f, 0.8125f),new Vector2f(0.1875f, 0.1875f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.4f, 0.3f, 0.4f),new Vector3f(0.4f, 0.3f, 0.4f),new Vector3f(0.4f, 0.3f, -0.4f),new Vector3f(-0.4f, 0.3f, -0.4f),new Vector2f(0.25f, 0.25f),new Vector2f(0.75f, 0.25f),new Vector2f(0.75f, 0.75f),new Vector2f(0.25f, 0.75f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.5f, 0.0f, 0.5f),new Vector3f(0.5f, 0.0f, 0.5f),new Vector3f(0.5f, 0.2f, 0.5f),new Vector3f(-0.5f, 0.2f, 0.5f),new Vector2f(0.1875f, 0.0f),new Vector2f(0.8125f, 0.0f),new Vector2f(0.8125f, 0.6667f),new Vector2f(0.1875f, 0.6667f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.5f, 0.0f, 0.5f),new Vector3f(0.5f, 0.0f, -0.5f),new Vector3f(0.5f, 0.2f, -0.5f),new Vector3f(0.5f, 0.2f, 0.5f),new Vector2f(0.1875f, 0.0f),new Vector2f(0.8125f, 0.0f),new Vector2f(0.8125f, 0.6667f),new Vector2f(0.1875f, 0.6667f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.5f, 0.0f, -0.5f),new Vector3f(-0.5f, 0.0f, -0.5f),new Vector3f(-0.5f, 0.2f, -0.5f),new Vector3f(0.5f, 0.2f, -0.5f),new Vector2f(0.1875f, 0.0f),new Vector2f(0.8125f, 0.0f),new Vector2f(0.8125f, 0.6667f),new Vector2f(0.1875f, 0.6667f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.5f, 0.0f, -0.5f),new Vector3f(-0.5f, 0.0f, 0.5f),new Vector3f(-0.5f, 0.2f, 0.5f),new Vector3f(-0.5f, 0.2f, -0.5f),new Vector2f(0.1875f, 0.0f),new Vector2f(0.8125f, 0.0f),new Vector2f(0.8125f, 0.6667f),new Vector2f(0.1875f, 0.6667f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.4f, 0.3f, 0.4f),new Vector3f(-0.5f, 0.2f, 0.5f),new Vector3f(0.5f, 0.2f, 0.5f),new Vector3f(0.4f, 0.3f, 0.4f),new Vector2f(0.25f, 0.25f),new Vector2f(0.1875f, 0.1875f),new Vector2f(0.8125f, 0.1875f),new Vector2f(0.75f, 0.25f),new Vector3f(0.0f, 2.8284f, 2.8284f));
		this.quads[7] = new ObjQuad(new Vector3f(0.4f, 0.3f, 0.4f),new Vector3f(0.5f, 0.2f, 0.5f),new Vector3f(0.5f, 0.2f, -0.5f),new Vector3f(0.4f, 0.3f, -0.4f),new Vector2f(0.75f, 0.25f),new Vector2f(0.8125f, 0.1875f),new Vector2f(0.8125f, 0.8125f),new Vector2f(0.75f, 0.75f),new Vector3f(2.8284f, 2.8284f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(0.4f, 0.3f, -0.4f),new Vector3f(0.5f, 0.2f, -0.5f),new Vector3f(-0.5f, 0.2f, -0.5f),new Vector3f(-0.4f, 0.3f, -0.4f),new Vector2f(0.75f, 0.75f),new Vector2f(0.8125f, 0.8125f),new Vector2f(0.1875f, 0.8125f),new Vector2f(0.25f, 0.75f),new Vector3f(0.0f, 2.8284f, -2.8284f));
		this.quads[9] = new ObjQuad(new Vector3f(-0.4f, 0.3f, -0.4f),new Vector3f(-0.5f, 0.2f, -0.5f),new Vector3f(-0.5f, 0.2f, 0.5f),new Vector3f(-0.4f, 0.3f, 0.4f),new Vector2f(0.25f, 0.75f),new Vector2f(0.1875f, 0.8125f),new Vector2f(0.1875f, 0.1875f),new Vector2f(0.25f, 0.25f),new Vector3f(-2.8284f, 2.8284f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Box001 other = new Box001();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

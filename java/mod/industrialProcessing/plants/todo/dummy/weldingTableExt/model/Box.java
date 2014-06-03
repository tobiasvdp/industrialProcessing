package mod.industrialProcessing.plants.todo.dummy.weldingTableExt.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Box extends ObjMesh{
	public Box(){
		this.quads = new ObjQuad[22];
		this.quads[0] = new ObjQuad(new Vector3f(0.8f, 0.3f, -0.656f),new Vector3f(0.8f, 0.3f, 0.64f),new Vector3f(-0.64f, 0.3f, -0.656f),new Vector2f(-0.0f, 0.91f),new Vector2f(0.0f, 0.1f),new Vector2f(0.9f, 0.91f),new Vector3f(0.0f, -3.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.8f, 0.3f, -0.656f),new Vector3f(-0.64f, 0.3f, -0.656f),new Vector3f(0.8f, 0.3f, 0.64f),new Vector3f(-0.8f, 0.3f, 0.64f),new Vector2f(1.0f, 0.91f),new Vector2f(0.9f, 0.91f),new Vector2f(0.0f, 0.1f),new Vector2f(1.0f, 0.1f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.8f, 1.4f, -0.8f),new Vector3f(0.8f, 1.4f, -0.8f),new Vector3f(0.8f, 0.3f, -0.8f),new Vector3f(-0.8f, 0.3f, -0.8f),new Vector2f(1.0f, 0.875f),new Vector2f(-0.0f, 0.875f),new Vector2f(-0.0f, 0.1875f),new Vector2f(1.0f, 0.1875f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.8f, 1.4f, -0.8f),new Vector3f(0.8f, 1.4f, 0.64f),new Vector3f(0.8f, 0.3f, 0.64f),new Vector3f(0.8f, 0.3f, -0.656f),new Vector2f(1.0f, 0.875f),new Vector2f(0.1f, 0.875f),new Vector2f(0.1f, 0.1875f),new Vector2f(0.91f, 0.1875f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(0.8f, 1.4f, -0.8f),new Vector3f(0.8f, 0.3f, -0.656f),new Vector3f(0.8f, 0.3f, -0.8f),new Vector2f(1.0f, 0.875f),new Vector2f(0.91f, 0.1875f),new Vector2f(1.0f, 0.1875f),new Vector3f(3.0f, 0.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(0.7f, 1.3f, -0.36f),new Vector3f(-0.7f, 1.3f, -0.36f),new Vector3f(-0.7f, 0.4f, -0.36f),new Vector3f(0.7f, 0.4f, -0.36f),new Vector2f(0.9375f, 0.8125f),new Vector2f(0.0625f, 0.8125f),new Vector2f(0.0625f, 0.25f),new Vector2f(0.9375f, 0.25f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.8f, 1.4f, 0.64f),new Vector3f(-0.8f, 1.4f, -0.8f),new Vector3f(-0.8f, 0.3f, -0.8f),new Vector3f(-0.8f, 0.3f, -0.656f),new Vector2f(0.9f, 0.875f),new Vector2f(-0.0f, 0.875f),new Vector2f(-0.0f, 0.1875f),new Vector2f(0.09f, 0.1875f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.8f, 1.4f, 0.64f),new Vector3f(-0.8f, 0.3f, -0.656f),new Vector3f(-0.8f, 0.3f, 0.64f),new Vector2f(0.9f, 0.875f),new Vector2f(0.09f, 0.1875f),new Vector2f(0.9f, 0.1875f),new Vector3f(-3.0f, 0.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(-0.8f, 0.0f, -0.8f),new Vector3f(0.8f, 0.0f, -0.8f),new Vector3f(0.8f, 0.0f, -0.656f),new Vector3f(-0.8f, 0.0f, -0.656f),new Vector2f(1.0f, 1.0f),new Vector2f(-0.0f, 1.0f),new Vector2f(-0.0f, 0.91f),new Vector2f(1.0f, 0.91f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[9] = new ObjQuad(new Vector3f(-0.8f, 0.3f, -0.8f),new Vector3f(0.8f, 0.3f, -0.8f),new Vector3f(0.8f, 0.0f, -0.8f),new Vector3f(-0.8f, 0.0f, -0.8f),new Vector2f(1.0f, 0.1875f),new Vector2f(-0.0f, 0.1875f),new Vector2f(-0.0f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[10] = new ObjQuad(new Vector3f(0.8f, 0.3f, -0.8f),new Vector3f(0.8f, 0.3f, -0.656f),new Vector3f(0.8f, 0.0f, -0.656f),new Vector3f(0.8f, 0.0f, -0.8f),new Vector2f(1.0f, 0.1875f),new Vector2f(0.91f, 0.1875f),new Vector2f(0.91f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[11] = new ObjQuad(new Vector3f(-0.64f, 0.3f, -0.656f),new Vector3f(-0.8f, 0.3f, -0.656f),new Vector3f(-0.8f, 0.0f, -0.656f),new Vector3f(0.8f, 0.0f, -0.656f),new Vector2f(0.1f, 0.1875f),new Vector2f(0.0f, 0.1875f),new Vector2f(0.0f, 0.0f),new Vector2f(1.0f, 0.0f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[12] = new ObjQuad(new Vector3f(-0.64f, 0.3f, -0.656f),new Vector3f(0.8f, 0.0f, -0.656f),new Vector3f(0.8f, 0.3f, -0.656f),new Vector2f(0.1f, 0.1875f),new Vector2f(1.0f, 0.0f),new Vector2f(1.0f, 0.1875f),new Vector3f(0.0f, 0.0f, 3.0f));
		this.quads[13] = new ObjQuad(new Vector3f(-0.8f, 0.3f, -0.656f),new Vector3f(-0.8f, 0.3f, -0.8f),new Vector3f(-0.8f, 0.0f, -0.8f),new Vector3f(-0.8f, 0.0f, -0.656f),new Vector2f(0.09f, 0.1875f),new Vector2f(-0.0f, 0.1875f),new Vector2f(-0.0f, 0.0f),new Vector2f(0.09f, 0.0f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[14] = new ObjQuad(new Vector3f(0.8f, 1.4f, 0.64f),new Vector3f(-0.8f, 1.4f, 0.64f),new Vector3f(-0.7f, 1.3f, 0.64f),new Vector3f(0.7f, 1.3f, 0.64f),new Vector2f(1.0f, 0.875f),new Vector2f(-0.0f, 0.875f),new Vector2f(0.0625f, 0.8125f),new Vector2f(0.9375f, 0.8125f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[15] = new ObjQuad(new Vector3f(-0.8f, 1.4f, 0.64f),new Vector3f(-0.8f, 0.3f, 0.64f),new Vector3f(-0.7f, 0.4f, 0.64f),new Vector3f(-0.7f, 1.3f, 0.64f),new Vector2f(-0.0f, 0.875f),new Vector2f(-0.0f, 0.1875f),new Vector2f(0.0625f, 0.25f),new Vector2f(0.0625f, 0.8125f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[16] = new ObjQuad(new Vector3f(-0.8f, 0.3f, 0.64f),new Vector3f(0.8f, 0.3f, 0.64f),new Vector3f(0.7f, 0.4f, 0.64f),new Vector3f(-0.7f, 0.4f, 0.64f),new Vector2f(-0.0f, 0.1875f),new Vector2f(1.0f, 0.1875f),new Vector2f(0.9375f, 0.25f),new Vector2f(0.0625f, 0.25f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[17] = new ObjQuad(new Vector3f(0.8f, 0.3f, 0.64f),new Vector3f(0.8f, 1.4f, 0.64f),new Vector3f(0.7f, 1.3f, 0.64f),new Vector3f(0.7f, 0.4f, 0.64f),new Vector2f(1.0f, 0.1875f),new Vector2f(1.0f, 0.875f),new Vector2f(0.9375f, 0.8125f),new Vector2f(0.9375f, 0.25f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[18] = new ObjQuad(new Vector3f(0.7f, 1.3f, 0.64f),new Vector3f(-0.7f, 1.3f, 0.64f),new Vector3f(-0.7f, 1.3f, -0.36f),new Vector3f(0.7f, 1.3f, -0.36f),new Vector2f(0.0625f, 0.1f),new Vector2f(0.9375f, 0.1f),new Vector2f(0.9375f, 0.725f),new Vector2f(0.0625f, 0.725f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[19] = new ObjQuad(new Vector3f(-0.7f, 1.3f, 0.64f),new Vector3f(-0.7f, 0.4f, 0.64f),new Vector3f(-0.7f, 0.4f, -0.36f),new Vector3f(-0.7f, 1.3f, -0.36f),new Vector2f(0.1f, 0.8125f),new Vector2f(0.1f, 0.25f),new Vector2f(0.725f, 0.25f),new Vector2f(0.725f, 0.8125f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[20] = new ObjQuad(new Vector3f(-0.7f, 0.4f, 0.64f),new Vector3f(0.7f, 0.4f, 0.64f),new Vector3f(0.7f, 0.4f, -0.36f),new Vector3f(-0.7f, 0.4f, -0.36f),new Vector2f(0.0625f, 0.1f),new Vector2f(0.9375f, 0.1f),new Vector2f(0.9375f, 0.725f),new Vector2f(0.0625f, 0.725f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[21] = new ObjQuad(new Vector3f(0.7f, 0.4f, 0.64f),new Vector3f(0.7f, 1.3f, 0.64f),new Vector3f(0.7f, 1.3f, -0.36f),new Vector3f(0.7f, 0.4f, -0.36f),new Vector2f(0.9f, 0.25f),new Vector2f(0.9f, 0.8125f),new Vector2f(0.275f, 0.8125f),new Vector2f(0.275f, 0.25f),new Vector3f(-4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Box other = new Box();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

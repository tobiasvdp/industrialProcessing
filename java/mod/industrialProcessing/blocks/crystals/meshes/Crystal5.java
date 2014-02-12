package mod.industrialProcessing.blocks.crystals.meshes;

import mod.industrialProcessing.client.rendering.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class Crystal5 extends ObjMesh {

	public Crystal5() {
		this.quads = new ObjQuad[6];
		this.quads[0] = new ObjQuad(new Vector3f(0.278574f, 0.479867f, -0.017834f),new Vector3f(0.269789f, 0.410516f, -0.09796f),new Vector3f(0.175899f, 0.466488f, -0.042036f),new Vector3f(0.226689f, 0.44258f, 0.067164f),new Vector2f(0.4375f, 0.5625f),new Vector2f(0.5f, 0.625f),new Vector2f(0.375f, 0.625f),new Vector2f(0.375f, 0.5f),new Vector3f(1.223383f, 3.2614498f, -0.314f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.015988f, 0.016032f, 0.08665f),new Vector3f(0.077903f, -0.03994f, 0.030726f),new Vector3f(0.32058f, 0.386608f, 0.01124f),new Vector3f(0.226689f, 0.44258f, 0.067164f),new Vector2f(0.0f, 0.0f),new Vector2f(0.125f, 0.0f),new Vector2f(0.125f, 0.5f),new Vector2f(0.0f, 0.5f),new Vector3f(1.654628f, -0.778856f, 3.5574698f));
		this.quads[2] = new ObjQuad(new Vector3f(0.077903f, -0.03994f, 0.030726f),new Vector3f(0.027112f, -0.016032f, -0.078474f),new Vector3f(0.269789f, 0.410516f, -0.09796f),new Vector3f(0.32058f, 0.386608f, 0.01124f),new Vector2f(0.375f, 0.0f),new Vector2f(0.5f, 0.0f),new Vector2f(0.5f, 0.5f),new Vector2f(0.375f, 0.5f),new Vector3f(3.058732f, -1.823444f, -1.821872f));
		this.quads[3] = new ObjQuad(new Vector3f(0.027112f, -0.016032f, -0.078474f),new Vector3f(-0.066779f, 0.03994f, -0.02255f),new Vector3f(0.175899f, 0.466488f, -0.042036f),new Vector3f(0.269789f, 0.410516f, -0.09796f),new Vector2f(0.25f, 0.0f),new Vector2f(0.375f, 0.0f),new Vector2f(0.375f, 0.5f),new Vector2f(0.25f, 0.5f),new Vector3f(-1.654628f, 0.778856f, -3.5574698f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.066779f, 0.03994f, -0.02255f),new Vector3f(-0.015988f, 0.016032f, 0.08665f),new Vector3f(0.226689f, 0.44258f, 0.067164f),new Vector3f(0.175899f, 0.466488f, -0.042036f),new Vector2f(0.125f, 0.0f),new Vector2f(0.25f, 0.0f),new Vector2f(0.25f, 0.5f),new Vector2f(0.125f, 0.5f),new Vector3f(-3.058732f, 1.823444f, 1.821872f));
		this.quads[5] = new ObjQuad(new Vector3f(0.32058f, 0.386608f, 0.01124f),new Vector3f(0.269789f, 0.410516f, -0.09796f),new Vector3f(0.278574f, 0.479867f, -0.017834f),new Vector3f(0.226689f, 0.44258f, 0.067164f),new Vector2f(0.5f, 0.5f),new Vector2f(0.5f, 0.625f),new Vector2f(0.4375f, 0.5625f),new Vector2f(0.375f, 0.5f),new Vector3f(2.185494f, 2.730259f, 0.040276974f));
}

	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Crystal5 other = new Crystal5();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}

}

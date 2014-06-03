package mod.industrialProcessing.plants.power.generator.solar.standingSolarPanel.model;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Cylinder001 extends ObjMesh{
	public Cylinder001(){
		this.quads = new ObjQuad[12];
		this.quads[0] = new ObjQuad(new Vector3f(0.0f, 1.0f, -0.0f),new Vector3f(-0.15f, 1.199f, -0.167f),new Vector3f(0.15f, 1.199f, -0.167f),new Vector3f(0.3f, 1.0f, -0.0f),new Vector2f(0.5f, 0.5f),new Vector2f(0.7498f, 0.9995f),new Vector2f(0.2502f, 0.9995f),new Vector2f(5.0E-4f, 0.5f),new Vector3f(0.0f, -2.5712f, -3.064f));
		this.quads[1] = new ObjQuad(new Vector3f(0.0f, 1.0f, -0.0f),new Vector3f(-0.15f, 0.801f, 0.167f),new Vector3f(-0.3f, 1.0f, 0.0f),new Vector3f(-0.15f, 1.199f, -0.167f),new Vector2f(0.5f, 0.5f),new Vector2f(0.7498f, 5.0E-4f),new Vector2f(0.9995f, 0.5f),new Vector2f(0.7498f, 0.9995f),new Vector3f(0.0f, -2.5712f, -3.064f));
		this.quads[2] = new ObjQuad(new Vector3f(0.0f, 1.0f, -0.0f),new Vector3f(0.3f, 1.0f, -0.0f),new Vector3f(0.15f, 0.801f, 0.167f),new Vector3f(-0.15f, 0.801f, 0.167f),new Vector2f(0.5f, 0.5f),new Vector2f(5.0E-4f, 0.5f),new Vector2f(0.2502f, 5.0E-4f),new Vector2f(0.7498f, 5.0E-4f),new Vector3f(0.0f, -2.5712f, -3.064f));
		this.quads[3] = new ObjQuad(new Vector3f(0.3f, 1.0f, -0.0f),new Vector3f(0.15f, 1.199f, -0.167f),new Vector3f(0.15f, 1.7133f, 0.4458f),new Vector3f(0.3f, 1.5142f, 0.6128f),new Vector2f(0.5f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.9995f),new Vector2f(0.5f, 0.9995f),new Vector3f(3.0f, 1.3268f, -1.1134f));
		this.quads[4] = new ObjQuad(new Vector3f(0.15f, 1.199f, -0.167f),new Vector3f(-0.15f, 1.199f, -0.167f),new Vector3f(-0.15f, 1.7133f, 0.4458f),new Vector3f(0.15f, 1.7133f, 0.4458f),new Vector2f(0.2502f, 5.0E-4f),new Vector2f(0.7498f, 5.0E-4f),new Vector2f(0.7498f, 0.9995f),new Vector2f(0.2502f, 0.9995f),new Vector3f(0.0f, 2.6536f, -2.2268f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.15f, 1.199f, -0.167f),new Vector3f(-0.3f, 1.0f, 0.0f),new Vector3f(-0.3f, 1.5142f, 0.6128f),new Vector3f(-0.15f, 1.7133f, 0.4458f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.5f, 5.0E-4f),new Vector2f(0.5f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(-3.0f, 1.3268f, -1.1134f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.3f, 1.0f, 0.0f),new Vector3f(-0.15f, 0.801f, 0.167f),new Vector3f(-0.15f, 1.3152f, 0.7798f),new Vector3f(-0.3f, 1.5142f, 0.6128f),new Vector2f(0.5f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.9995f),new Vector2f(0.5f, 0.9995f),new Vector3f(-3.0f, -1.3268f, 1.1134f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.15f, 0.801f, 0.167f),new Vector3f(0.15f, 0.801f, 0.167f),new Vector3f(0.15f, 1.3152f, 0.7798f),new Vector3f(-0.15f, 1.3152f, 0.7798f),new Vector2f(0.2502f, 5.0E-4f),new Vector2f(0.7498f, 5.0E-4f),new Vector2f(0.7498f, 0.9995f),new Vector2f(0.2502f, 0.9995f),new Vector3f(0.0f, -2.6536f, 2.2268f));
		this.quads[8] = new ObjQuad(new Vector3f(0.15f, 0.801f, 0.167f),new Vector3f(0.3f, 1.0f, -0.0f),new Vector3f(0.3f, 1.5142f, 0.6128f),new Vector3f(0.15f, 1.3152f, 0.7798f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.5f, 5.0E-4f),new Vector2f(0.5f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(3.0f, -1.3268f, 1.1134f));
		this.quads[9] = new ObjQuad(new Vector3f(0.0f, 1.5142f, 0.6128f),new Vector3f(0.15f, 1.3152f, 0.7798f),new Vector3f(0.3f, 1.5142f, 0.6128f),new Vector3f(0.15f, 1.7133f, 0.4458f),new Vector2f(0.5f, 0.5f),new Vector2f(0.7498f, 5.0E-4f),new Vector2f(0.9995f, 0.5f),new Vector2f(0.7498f, 0.9995f),new Vector3f(0.0f, 2.5712f, 3.064f));
		this.quads[10] = new ObjQuad(new Vector3f(0.0f, 1.5142f, 0.6128f),new Vector3f(0.15f, 1.7133f, 0.4458f),new Vector3f(-0.15f, 1.7133f, 0.4458f),new Vector3f(-0.3f, 1.5142f, 0.6128f),new Vector2f(0.5f, 0.5f),new Vector2f(0.7498f, 0.9995f),new Vector2f(0.2502f, 0.9995f),new Vector2f(5.0E-4f, 0.5f),new Vector3f(0.0f, 2.5712f, 3.064f));
		this.quads[11] = new ObjQuad(new Vector3f(0.0f, 1.5142f, 0.6128f),new Vector3f(-0.3f, 1.5142f, 0.6128f),new Vector3f(-0.15f, 1.3152f, 0.7798f),new Vector3f(0.15f, 1.3152f, 0.7798f),new Vector2f(0.5f, 0.5f),new Vector2f(5.0E-4f, 0.5f),new Vector2f(0.2502f, 5.0E-4f),new Vector2f(0.7498f, 5.0E-4f),new Vector3f(0.0f, 2.5712f, 3.064f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Cylinder001 other = new Cylinder001();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

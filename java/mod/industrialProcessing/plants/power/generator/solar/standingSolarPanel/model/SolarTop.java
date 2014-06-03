package mod.industrialProcessing.plants.power.generator.solar.standingSolarPanel.model;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class SolarTop extends ObjMesh{
	public SolarTop(){
		this.quads = new ObjQuad[4];
		this.quads[0] = new ObjQuad(new Vector3f(-0.047f, 0.4474f, 1.5791f),new Vector3f(-0.047f, 2.7455f, -0.3493f),new Vector3f(-1.103f, 2.7455f, -0.3493f),new Vector3f(-1.103f, 0.4474f, 1.5791f),new Vector2f(0.998f, 0.002f),new Vector2f(0.998f, 0.7521f),new Vector2f(0.7554f, 0.7521f),new Vector2f(0.7554f, 0.002f),new Vector3f(0.0f, 2.5712f, 3.064f));
		this.quads[1] = new ObjQuad(new Vector3f(2.253f, 0.4474f, 1.5791f),new Vector3f(2.253f, 2.7455f, -0.3493f),new Vector3f(1.197f, 2.7455f, -0.3493f),new Vector3f(1.197f, 0.4474f, 1.5791f),new Vector2f(0.2446f, 0.002f),new Vector2f(0.2446f, 0.7521f),new Vector2f(0.002f, 0.7521f),new Vector2f(0.002f, 0.002f),new Vector3f(0.0f, 2.5712f, 3.064f));
		this.quads[2] = new ObjQuad(new Vector3f(1.103f, 0.4474f, 1.5791f),new Vector3f(1.103f, 2.7455f, -0.3493f),new Vector3f(0.047f, 2.7455f, -0.3493f),new Vector3f(0.047f, 0.4474f, 1.5791f),new Vector2f(0.7469f, 0.002f),new Vector2f(0.7469f, 0.7521f),new Vector2f(0.5043f, 0.7521f),new Vector2f(0.5043f, 0.002f),new Vector3f(0.0f, 2.5712f, 3.064f));
		this.quads[3] = new ObjQuad(new Vector3f(-2.253f, 2.7455f, -0.3493f),new Vector3f(-2.253f, 0.4474f, 1.5791f),new Vector3f(-1.197f, 0.4474f, 1.5791f),new Vector3f(-1.197f, 2.7455f, -0.3493f),new Vector2f(0.2531f, 0.7521f),new Vector2f(0.2531f, 0.002f),new Vector2f(0.4957f, 0.002f),new Vector2f(0.4957f, 0.7521f),new Vector3f(0.0f, 2.5712f, 3.064f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		SolarTop other = new SolarTop();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

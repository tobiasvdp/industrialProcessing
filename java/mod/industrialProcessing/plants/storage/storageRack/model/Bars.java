package ip.industrialProcessing.machines.plants.storage.storageRack.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Bars extends ObjMesh{
	public Bars(){
		this.quads = new ObjQuad[24];
		this.quads[0] = new ObjQuad(new Vector3f(-0.65f, 0.8f, 0.8f),new Vector3f(-0.65f, 1.1f, -0.8f),new Vector3f(-0.55f, 1.1f, -0.8f),new Vector3f(-0.55f, 0.8f, 0.8f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.9995f),new Vector2f(0.9227f, 0.9995f),new Vector2f(0.9227f, 5.0E-4f),new Vector3f(0.0f, -3.9316f, -0.7372f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.65f, 0.9f, 0.8f),new Vector3f(-0.55f, 0.9f, 0.8f),new Vector3f(-0.55f, 1.2f, -0.8f),new Vector3f(-0.65f, 1.2f, -0.8f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.0773f, 5.0E-4f),new Vector2f(0.0773f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(0.0f, 3.9316f, 0.7372f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.65f, 0.8f, 0.8f),new Vector3f(-0.55f, 0.8f, 0.8f),new Vector3f(-0.55f, 0.9f, 0.8f),new Vector3f(-0.65f, 0.9f, 0.8f),new Vector2f(5.0E-4f, 0.6665f),new Vector2f(0.0773f, 0.6665f),new Vector2f(0.0773f, 0.7498f),new Vector2f(5.0E-4f, 0.7498f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.55f, 0.8f, 0.8f),new Vector3f(-0.55f, 1.1f, -0.8f),new Vector3f(-0.55f, 1.2f, -0.8f),new Vector3f(-0.55f, 0.9f, 0.8f),new Vector2f(5.0E-4f, 0.6665f),new Vector2f(0.9995f, 0.9163f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.7498f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.55f, 1.1f, -0.8f),new Vector3f(-0.65f, 1.1f, -0.8f),new Vector3f(-0.65f, 1.2f, -0.8f),new Vector3f(-0.55f, 1.2f, -0.8f),new Vector2f(0.9227f, 0.9163f),new Vector2f(0.9995f, 0.9163f),new Vector2f(0.9995f, 0.9995f),new Vector2f(0.9227f, 0.9995f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.65f, 1.1f, -0.8f),new Vector3f(-0.65f, 0.8f, 0.8f),new Vector3f(-0.65f, 0.9f, 0.8f),new Vector3f(-0.65f, 1.2f, -0.8f),new Vector2f(5.0E-4f, 0.9163f),new Vector2f(0.9995f, 0.6665f),new Vector2f(0.9995f, 0.7498f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(0.55f, 0.8f, 0.8f),new Vector3f(0.55f, 1.1f, -0.8f),new Vector3f(0.65f, 1.1f, -0.8f),new Vector3f(0.65f, 0.8f, 0.8f),new Vector2f(0.0773f, 5.0E-4f),new Vector2f(0.0773f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector3f(0.0f, -3.9316f, -0.7372f));
		this.quads[7] = new ObjQuad(new Vector3f(0.55f, 0.9f, 0.8f),new Vector3f(0.65f, 0.9f, 0.8f),new Vector3f(0.65f, 1.2f, -0.8f),new Vector3f(0.55f, 1.2f, -0.8f),new Vector2f(0.9227f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.9995f),new Vector2f(0.9227f, 0.9995f),new Vector3f(0.0f, 3.9316f, 0.7372f));
		this.quads[8] = new ObjQuad(new Vector3f(0.55f, 0.8f, 0.8f),new Vector3f(0.65f, 0.8f, 0.8f),new Vector3f(0.65f, 0.9f, 0.8f),new Vector3f(0.55f, 0.9f, 0.8f),new Vector2f(0.9227f, 0.6665f),new Vector2f(0.9995f, 0.6665f),new Vector2f(0.9995f, 0.7498f),new Vector2f(0.9227f, 0.7498f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[9] = new ObjQuad(new Vector3f(0.65f, 0.8f, 0.8f),new Vector3f(0.65f, 1.1f, -0.8f),new Vector3f(0.65f, 1.2f, -0.8f),new Vector3f(0.65f, 0.9f, 0.8f),new Vector2f(5.0E-4f, 0.6665f),new Vector2f(0.9995f, 0.9163f),new Vector2f(0.9995f, 0.9995f),new Vector2f(5.0E-4f, 0.7498f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[10] = new ObjQuad(new Vector3f(0.65f, 1.1f, -0.8f),new Vector3f(0.55f, 1.1f, -0.8f),new Vector3f(0.55f, 1.2f, -0.8f),new Vector3f(0.65f, 1.2f, -0.8f),new Vector2f(5.0E-4f, 0.9163f),new Vector2f(0.0773f, 0.9163f),new Vector2f(0.0773f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[11] = new ObjQuad(new Vector3f(0.55f, 1.1f, -0.8f),new Vector3f(0.55f, 0.8f, 0.8f),new Vector3f(0.55f, 0.9f, 0.8f),new Vector3f(0.55f, 1.2f, -0.8f),new Vector2f(5.0E-4f, 0.9163f),new Vector2f(0.9995f, 0.6665f),new Vector2f(0.9995f, 0.7498f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[12] = new ObjQuad(new Vector3f(-0.65f, 0.0f, 0.8f),new Vector3f(-0.65f, 0.3f, -0.8f),new Vector3f(-0.55f, 0.3f, -0.8f),new Vector3f(-0.55f, 0.0f, 0.8f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.9995f),new Vector2f(0.9227f, 0.9995f),new Vector2f(0.9227f, 5.0E-4f),new Vector3f(0.0f, -3.9316f, -0.7372f));
		this.quads[13] = new ObjQuad(new Vector3f(-0.65f, 0.1f, 0.8f),new Vector3f(-0.55f, 0.1f, 0.8f),new Vector3f(-0.55f, 0.4f, -0.8f),new Vector3f(-0.65f, 0.4f, -0.8f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.0773f, 5.0E-4f),new Vector2f(0.0773f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector3f(0.0f, 3.9316f, 0.7372f));
		this.quads[14] = new ObjQuad(new Vector3f(-0.65f, 0.0f, 0.8f),new Vector3f(-0.55f, 0.0f, 0.8f),new Vector3f(-0.55f, 0.1f, 0.8f),new Vector3f(-0.65f, 0.1f, 0.8f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.0773f, 5.0E-4f),new Vector2f(0.0773f, 0.0837f),new Vector2f(5.0E-4f, 0.0837f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[15] = new ObjQuad(new Vector3f(-0.55f, 0.0f, 0.8f),new Vector3f(-0.55f, 0.3f, -0.8f),new Vector3f(-0.55f, 0.4f, -0.8f),new Vector3f(-0.55f, 0.1f, 0.8f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.9995f, 0.2502f),new Vector2f(0.9995f, 0.3335f),new Vector2f(5.0E-4f, 0.0837f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[16] = new ObjQuad(new Vector3f(-0.55f, 0.3f, -0.8f),new Vector3f(-0.65f, 0.3f, -0.8f),new Vector3f(-0.65f, 0.4f, -0.8f),new Vector3f(-0.55f, 0.4f, -0.8f),new Vector2f(0.9227f, 0.2502f),new Vector2f(0.9995f, 0.2502f),new Vector2f(0.9995f, 0.3335f),new Vector2f(0.9227f, 0.3335f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[17] = new ObjQuad(new Vector3f(-0.65f, 0.3f, -0.8f),new Vector3f(-0.65f, 0.0f, 0.8f),new Vector3f(-0.65f, 0.1f, 0.8f),new Vector3f(-0.65f, 0.4f, -0.8f),new Vector2f(5.0E-4f, 0.2502f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.0837f),new Vector2f(5.0E-4f, 0.3335f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[18] = new ObjQuad(new Vector3f(0.55f, 0.0f, 0.8f),new Vector3f(0.55f, 0.3f, -0.8f),new Vector3f(0.65f, 0.3f, -0.8f),new Vector3f(0.65f, 0.0f, 0.8f),new Vector2f(0.0773f, 5.0E-4f),new Vector2f(0.0773f, 0.9995f),new Vector2f(5.0E-4f, 0.9995f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector3f(0.0f, -3.9316f, -0.7372f));
		this.quads[19] = new ObjQuad(new Vector3f(0.55f, 0.1f, 0.8f),new Vector3f(0.65f, 0.1f, 0.8f),new Vector3f(0.65f, 0.4f, -0.8f),new Vector3f(0.55f, 0.4f, -0.8f),new Vector2f(0.9227f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.9995f),new Vector2f(0.9227f, 0.9995f),new Vector3f(0.0f, 3.9316f, 0.7372f));
		this.quads[20] = new ObjQuad(new Vector3f(0.55f, 0.0f, 0.8f),new Vector3f(0.65f, 0.0f, 0.8f),new Vector3f(0.65f, 0.1f, 0.8f),new Vector3f(0.55f, 0.1f, 0.8f),new Vector2f(0.9227f, 5.0E-4f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.0837f),new Vector2f(0.9227f, 0.0837f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[21] = new ObjQuad(new Vector3f(0.65f, 0.0f, 0.8f),new Vector3f(0.65f, 0.3f, -0.8f),new Vector3f(0.65f, 0.4f, -0.8f),new Vector3f(0.65f, 0.1f, 0.8f),new Vector2f(5.0E-4f, 5.0E-4f),new Vector2f(0.9995f, 0.2502f),new Vector2f(0.9995f, 0.3335f),new Vector2f(5.0E-4f, 0.0837f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[22] = new ObjQuad(new Vector3f(0.65f, 0.3f, -0.8f),new Vector3f(0.55f, 0.3f, -0.8f),new Vector3f(0.55f, 0.4f, -0.8f),new Vector3f(0.65f, 0.4f, -0.8f),new Vector2f(5.0E-4f, 0.2502f),new Vector2f(0.0773f, 0.2502f),new Vector2f(0.0773f, 0.3335f),new Vector2f(5.0E-4f, 0.3335f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[23] = new ObjQuad(new Vector3f(0.55f, 0.3f, -0.8f),new Vector3f(0.55f, 0.0f, 0.8f),new Vector3f(0.55f, 0.1f, 0.8f),new Vector3f(0.55f, 0.4f, -0.8f),new Vector2f(5.0E-4f, 0.2502f),new Vector2f(0.9995f, 5.0E-4f),new Vector2f(0.9995f, 0.0837f),new Vector2f(5.0E-4f, 0.3335f),new Vector3f(-4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Bars other = new Bars();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

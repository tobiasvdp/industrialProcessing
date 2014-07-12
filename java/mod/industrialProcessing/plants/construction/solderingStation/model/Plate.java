package mod.industrialProcessing.plants.construction.solderingStation.model;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Plate extends ObjMesh{
	public Plate(){
		this.quads = new ObjQuad[5];
		this.quads[0] = new ObjQuad(new Vector3f(-0.2543f, 1.05f, 0.3611f),new Vector3f(-0.2543f, 1.05f, 0.3389f),new Vector3f(-0.5458f, 1.05f, 0.3389f),new Vector3f(-0.5458f, 1.05f, 0.3611f),new Vector2f(0.2968f, 0.5273f),new Vector2f(0.2968f, 0.5499f),new Vector2f(0.002f, 0.5499f),new Vector2f(0.002f, 0.5273f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.5458f, 0.55f, 0.522f),new Vector3f(-0.2543f, 0.55f, 0.522f),new Vector3f(-0.2543f, 1.05f, 0.3611f),new Vector3f(-0.5458f, 1.05f, 0.3611f),new Vector2f(0.3112f, 0.002f),new Vector2f(0.6133f, 0.002f),new Vector2f(0.6133f, 0.5202f),new Vector2f(0.3112f, 0.5202f),new Vector3f(0.0f, 1.2252f, 3.8076f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.2543f, 0.55f, 0.522f),new Vector3f(-0.2543f, 0.55f, 0.4997f),new Vector3f(-0.2543f, 1.05f, 0.3389f),new Vector3f(-0.2543f, 1.05f, 0.3611f),new Vector2f(0.8128f, 0.002f),new Vector2f(0.8353f, 0.002f),new Vector2f(0.998f, 0.5076f),new Vector2f(0.9755f, 0.5076f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.2543f, 0.55f, 0.4997f),new Vector3f(-0.5458f, 0.55f, 0.4997f),new Vector3f(-0.5458f, 1.05f, 0.3389f),new Vector3f(-0.2543f, 1.05f, 0.3389f),new Vector2f(0.002f, 0.002f),new Vector2f(0.3041f, 0.002f),new Vector2f(0.3041f, 0.5202f),new Vector2f(0.002f, 0.5202f),new Vector3f(0.0f, -1.2252f, -3.8076f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.5458f, 0.55f, 0.4997f),new Vector3f(-0.5458f, 0.55f, 0.522f),new Vector3f(-0.5458f, 1.05f, 0.3611f),new Vector3f(-0.5458f, 1.05f, 0.3389f),new Vector2f(0.7831f, 0.002f),new Vector2f(0.8057f, 0.002f),new Vector2f(0.643f, 0.5076f),new Vector2f(0.6205f, 0.5076f),new Vector3f(-4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Plate other = new Plate();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

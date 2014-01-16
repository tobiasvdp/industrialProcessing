package ip.industrialProcessing.machines.flotationCell.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
public class Mesh03 extends ObjMesh{
	public Mesh03(){
		this.quads = new ObjQuad[0];
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Mesh03 other = new Mesh03();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

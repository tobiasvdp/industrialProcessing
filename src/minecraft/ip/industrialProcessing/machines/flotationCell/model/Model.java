package ip.industrialProcessing.machines.flotationCell.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
public class Model extends ObjMesh{
	public Model(){
		this.quads = new ObjQuad[0];
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Model other = new Model();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}

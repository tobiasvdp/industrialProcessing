package mod.industrialProcessing.client.rendering.block.obj.wavefront;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

public class ObjRotator {
	private ObjMesh[] meshes;
	private int offset;

	public ObjRotator(ObjMesh baseMesh, int offset) { 
		this(baseMesh, offset, 4);
	}

	public ObjRotator(ObjMesh baseMesh, int offset, int amount) {
	    if(baseMesh == null) 
	        throw new NullPointerException();
		this.meshes = new ObjMesh[amount];
		this.meshes[0] = baseMesh;
		Matrix4f rotation = Matrix4f.rotate((float) (Math.PI * 2 / amount), new Vector3f(0, 1, 0), new Matrix4f(), null);
		for (int i = 1; i < this.meshes.length; i++) {
		    ObjMesh source = this.meshes[i-1];
			ObjMesh target = source.cloneTransformed(rotation);
			if(target == null)
	            throw new NullPointerException();
			this.meshes[i] = target;
		}
		this.offset = offset;
	}

	public ObjMesh getRotated(int i) {
		int j = (this.offset + i) % this.meshes.length;
		if (j < 0)
			j += this.meshes.length;
		return this.meshes[j];
	}
}

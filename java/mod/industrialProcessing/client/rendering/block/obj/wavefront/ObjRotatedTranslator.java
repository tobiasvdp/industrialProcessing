package mod.industrialProcessing.client.rendering.block.obj.wavefront;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

public class ObjRotatedTranslator{
	ObjRotator[] rotaters;
	int offset;
	
	public ObjRotatedTranslator(ObjMesh baseMesh, int offset){
		this(baseMesh, offset, 1);
	}
	
	public ObjRotatedTranslator(ObjMesh baseMesh, int offset, int amount) {
		rotaters = new ObjRotator[amount];
		this.offset = offset;
		rotaters[0] = new ObjRotator(baseMesh, offset);
	}
	
	public void setTranslated(int i, float x,float y,float z){
		rotaters[i] = new ObjRotator(translateMesh(rotaters[0],x,y,z), offset);
	}

	private ObjMesh translateMesh(ObjRotator objRotator, float x, float y, float z) {
		ObjMesh mesh = rotaters[0].getRotated(0);
		Matrix4f transform = Matrix4f.translate(new Vector3f(x,y,z), new Matrix4f(), null);
		ObjMesh cloneMesh = mesh.cloneTransformed(transform);
		if(cloneMesh == null)
            throw new NullPointerException();
		return cloneMesh;
	}

	public ObjMesh getRotated(int dir) {
		return getRotated(0,dir);
	}
	
	public ObjMesh getRotated(int translatedVersion, int dir) {
		return rotaters[translatedVersion].getRotated(dir);
	}
	
	

}

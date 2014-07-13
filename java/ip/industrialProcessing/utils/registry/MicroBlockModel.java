package ip.industrialProcessing.utils.registry;

import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;

public class MicroBlockModel {
	public ObjMesh[][][] meshes;
	public String[][][] icons;
	
	public MicroBlockModel(ObjMesh[][][] meshes,String[][][] icons) {
		this.icons = icons;
		this.meshes = meshes;
	}
}

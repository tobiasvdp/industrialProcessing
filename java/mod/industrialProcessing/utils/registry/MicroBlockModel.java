package mod.industrialProcessing.utils.registry;

import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;

public class MicroBlockModel {
	public ObjMesh[][][] meshes;
	public String[][][] icons;
	
	public MicroBlockModel(ObjMesh[][][] meshes,String[][][] icons) {
		this.icons = icons;
		this.meshes = meshes;
	}
}

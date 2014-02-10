package ip.industrialProcessing.utils.registry;

import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;

import java.util.HashMap;

public class MicroBlockModelRegistry {
	private static HashMap<Integer, MicroBlockModel> models = new HashMap<Integer, MicroBlockModel>();
	public static int getNextAvailableID(){
		int size = models.size();
		models.put(size, null);
		return size;
		
	}
	public static void registerModel(int id, ObjMesh[][] center,ObjMesh[][] internalConnections,ObjMesh[][] externalConnections, String[][] centerIcons,String[][] internalIcons,String[][] externalIcons){
		ObjMesh[][][] mesh = new ObjMesh[][][]{center,internalConnections,externalConnections};
		String[][][] names = new String[][][]{centerIcons,internalIcons,externalIcons};
		models.put(id, new MicroBlockModel(mesh,names));
	}
	public static MicroBlockModel getModel(int id){
		MicroBlockModel model = models.get(id);
		return model;
	}
}

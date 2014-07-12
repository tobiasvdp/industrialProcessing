package mod.industrialProcessing.utils.registry;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class BlockSwitcherRegistry {
	private static BiMap<String, String> array = HashBiMap.create(); 
	
	public static void addSwitching(String dummyName, String coreName){
		array.put(coreName, dummyName);
	}
	
	public static String getCoreName(String dummyName){
		if(dummyName.startsWith("tile.")){
			return array.inverse().get(dummyName);
		}
		return array.inverse().get("tile."+dummyName);
	}
	
	public static String getDummyName(String coreName){
		if(coreName.startsWith("tile.")){
			return array.get(coreName);
		}
		return array.get("tile."+ coreName);
	}
}

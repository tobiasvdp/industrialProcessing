package ip.industrialProcessing.utils.registry;

import ip.industrialProcessing.api.config.INamepace;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.swing.Icon;

public class MicroBlockIconRegistry {
	private static HashMap<String, Icon> icons = new HashMap<String, Icon>();
	static{
		icons.put("blockWire", null);
		icons.put("Orange", null);
		icons.put("DataPanel", null);
		icons.put("Iron", null);
	}
	public static void registerIcons(IconRegister iconRegister){
		Set<String> names = icons.keySet();
		Iterator<String> it = names.iterator();
		while(it.hasNext()){
			String name = it.next();
			putIcon(name,iconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + name));	
		}
	}
	public static Icon getIcon(String name){
		return icons.get(name);
	}

	public static void putIcon(String name,Icon icon){
		icons.put(name, icon);
	}
}

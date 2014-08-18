package mod.industrialProcessing.utils.registry;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.swing.Icon;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import mod.industrialProcessing.utils.INamepace;

public class MicroBlockIconRegistry {
	private static HashMap<String, IIcon> icons = new HashMap<String, IIcon>();
	static{
		icons.put("blockWire", null);
		icons.put("Orange", null);
		icons.put("DataPanel", null);
		icons.put("Iron", null);
	}
	public static void registerIcons(IIconRegister iconRegister){
		Set<String> names = icons.keySet();
		Iterator<String> it = names.iterator();
		while(it.hasNext()){
			String name = it.next();
			putIcon(name,iconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + name));	
		}
	}
	public static IIcon getIcon(String name){
		return icons.get(name);
	}

	public static void putIcon(String name,IIcon icon){
		icons.put(name, icon);
	}
}

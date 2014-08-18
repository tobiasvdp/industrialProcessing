package mod.industrialProcessing.utils.registry;

import java.util.Iterator;
import java.util.Set;

import mod.industrialProcessing.blockContainer.microblock.MicroBlockType;

import com.google.common.collect.HashMultimap;

public class MicroBlockConnectionRegistry {

	private static HashMultimap map = HashMultimap.create();
	
	public static void addConnection(MicroBlockType type1,MicroBlockType type2){
		map.put(type1, type2);
		map.put(type2, type1);
	}
	
	public static boolean isConnectionSupported(MicroBlockType type1,MicroBlockType type2){
		if(type1==type2){
			return true;
		}
		Set entries = map.get(type1);
		if(entries != null){
			Iterator it = entries.iterator();
			while(it.hasNext()){
				if(it.next() == type2)
					return true;
			}
		}
		return false;
	}
	
}

package ip.industrialProcessing.utils.registry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import net.minecraft.block.Block;


public class BlockRegistry {
	private static HashMap<Block, BlockType> array = new HashMap<Block, BlockType>();
	
	public static void RegisterBlock(Block block,BlockType type){
		array.put(block,type);
	}
	
	public static Iterator<Block> getBlocks(){
		return array.keySet().iterator();
	}
	
	public static Iterator<Block> getMachines(){
		ArrayList<Block> list = new ArrayList<Block>();
		Iterator<Entry<Block, BlockType>> it = array.entrySet().iterator();
		while(it.hasNext()){
			Entry<Block, BlockType> set = it.next();
			if (set.getValue() == BlockType.Machine)
				list.add(set.getKey());
		}
		return list.iterator();
	}
	
	public static Block[] getMachinesArray(){
		ArrayList<Block> list = new ArrayList<Block>();
		Iterator<Entry<Block, BlockType>> it = array.entrySet().iterator();
		while(it.hasNext()){
			Entry<Block, BlockType> set = it.next();
			if (set.getValue() == BlockType.Machine)
				list.add(set.getKey());
		}
		Block[] blocks = new Block[list.size()];
		for(int i = 0;i<list.size();i++){
			blocks[i] = list.get(i);
		}
		return blocks;
	}
}

package ip.industrialProcessing.utils.registry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import net.minecraft.block.Block;

public class BlockRegistry {
	private static HashMap<Block, BlockType[]> array = new HashMap<Block, BlockType[]>();

	public static void RegisterBlock(Block block, BlockType... type) {
		array.put(block, type);
	}
	
	public static void RegisterBlock(Block block, BlockType type) {
		RegisterBlock(block,new BlockType[]{type});
	}

	public static Iterator<Block> getBlocks() {
		return array.keySet().iterator();
	}

	public static Iterator<Block> getMachines() {
		ArrayList<Block> list = new ArrayList<Block>();
		Iterator<Entry<Block, BlockType[]>> it = array.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Block, BlockType[]> set = it.next();
			if (ContainsTag(set.getValue(), BlockType.Machine))
				list.add(set.getKey());
		}
		return list.iterator();
	}

	private static boolean ContainsTag(BlockType[] value, BlockType machine) {
		for (int i = 0; i < value.length; i++) {
			if (value[i] == machine)
				return true;
		}
		return false;
	}

	public static Block[] getMachinesArray() {
		ArrayList<Block> list = new ArrayList<Block>();
		Iterator<Entry<Block, BlockType[]>> it = array.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Block, BlockType[]> set = it.next();
			if (ContainsTag(set.getValue(), BlockType.Machine))
				list.add(set.getKey());
		}
		Block[] blocks = new Block[list.size()];
		for (int i = 0; i < list.size(); i++) {
			blocks[i] = list.get(i);
		}
		return blocks;
	}

	public static Block[] getBlocksByTagArray(BlockType type) {
		ArrayList<Block> list = new ArrayList<Block>();
		Iterator<Entry<Block, BlockType[]>> it = array.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Block, BlockType[]> set = it.next();
			if (ContainsTag(set.getValue(), type))
				list.add(set.getKey());
		}
		Block[] blocks = new Block[list.size()];
		for (int i = 0; i < list.size(); i++) {
			blocks[i] = list.get(i);
		}
		return blocks;
	}

	public static Iterator<Block> getBlocksByTag(BlockType type) {
		ArrayList<Block> list = new ArrayList<Block>();
		Iterator<Entry<Block, BlockType[]>> it = array.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Block, BlockType[]> set = it.next();
			if (ContainsTag(set.getValue(), type))
				list.add(set.getKey());
		}
		return list.iterator();
	}

	public static Block[] getBlocksByTagArray(BlockType... type) {
		ArrayList<Block> list = new ArrayList<Block>();
		Iterator<Entry<Block, BlockType[]>> it = array.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Block, BlockType[]> set = it.next();
			boolean containsTag = true;
			for (int i = 0; i < type.length; i++) {
				if (!ContainsTag(set.getValue(), type[i]))
					containsTag = false;
			}
			if (containsTag) {
				list.add(set.getKey());
			}
		}
		Block[] blocks = new Block[list.size()];
		for (int i = 0; i < list.size(); i++) {
			blocks[i] = list.get(i);
		}
		return blocks;
	}

	public static Iterator<Block> getBlocksByTag(BlockType... type) {
		ArrayList<Block> list = new ArrayList<Block>();
		Iterator<Entry<Block, BlockType[]>> it = array.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Block, BlockType[]> set = it.next();
			boolean containsTag = true;
			for (int i = 0; i < type.length; i++) {
				if (!ContainsTag(set.getValue(), type[i]))
					containsTag = false;
			}
			if (containsTag) {
				list.add(set.getKey());
			}
		}
		return list.iterator();
	}
}

package ip.industrialProcessing.utils.registry;

import ip.industrialProcessing.microBlock.BlockMicroBlock;

import java.util.ArrayList;

import net.minecraft.block.Block;

public class MicroBlockRegistry {
	private static ArrayList<Block> array = new ArrayList<Block>();
	
	public static void RegisterMicroBlock(BlockMicroBlock block) {
		array.add(block);
	}
	
	public static void setBounds(boolean full){
		if(full){
			for(int i =0;i<array.size();i++){
				array.get(i).setBlockBounds(0, 0, 0, 1, 1, 1);
			}
		}else{
			for(int i =0;i<array.size();i++){
				array.get(i).setBlockBounds(0, 0, 0, 0, 0, 0);
			}
		}
	}
}

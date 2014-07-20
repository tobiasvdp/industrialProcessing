package mod.industrialProcessing.utils.registry;

import java.util.ArrayList;

import mod.industrialProcessing.microBlock.core.BlockMicroBlock;
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

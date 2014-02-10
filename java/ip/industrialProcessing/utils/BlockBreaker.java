package ip.industrialProcessing.utils;

import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.world.World;

public class BlockBreaker {
	public static void breakBlocks(World world, ArrayList<int[]> blocks) {
		Iterator<int[]> it = blocks.iterator();
		while(it.hasNext()){
			int[] block = it.next();
			world.destroyBlock(block[0], block[1], block[2], true);
		}
	}
}

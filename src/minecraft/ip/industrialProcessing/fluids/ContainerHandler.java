package ip.industrialProcessing.fluids;

	import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.FillBucketEvent;
@Deprecated
public class ContainerHandler {


	public static ContainerHandler INSTANCE = new ContainerHandler();
	public static Map<Block, Item> containers = new HashMap<Block, Item>();


	private ContainerHandler() {
	}


	@ForgeSubscribe
	public void onBucketFill(FillBucketEvent event) {


		ItemStack result = fillCustomBucket(event.world, event.target);


		if (result == null)
			return;


		event.result = result;
		event.setResult(Result.ALLOW);
	}


	private ItemStack fillCustomBucket(World world, MovingObjectPosition pos) {


		int blockID = world.getBlockId(pos.blockX, pos.blockY, pos.blockZ);
		Item bucket = containers.get(Block.blocksList[blockID]);
		if (bucket != null && world.getBlockMetadata(pos.blockX, pos.blockY, pos.blockZ) == 0) {
			world.setBlock(pos.blockX, pos.blockY, pos.blockZ, 0);
			return new ItemStack(bucket);
		} else
			return null;


	}
}



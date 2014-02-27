package ip.industrialProcessing.utils.handler.fluids;

import ip.industrialProcessing.subMod.blackSmith.item.ItemWoodenBucketFilled;
import ip.industrialProcessing.utils.registry.BucketRegistery;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.Multimap;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.FillBucketEvent;

public class BucketHandler {

	public static BucketHandler INSTANCE = new BucketHandler();
	private Multimap<Block, Item> buckets = ArrayListMultimap.create();

	private BucketHandler() {
	}

	public void put(Block block, Item item) {
		this.buckets.put(block, item);
	}

	@ForgeSubscribe
	public void onBucketFill(FillBucketEvent event) {

		ItemStack result = fillCustomBucket(event);

		if (result == null)
			return;

		event.result = result;
		event.setResult(Result.ALLOW);
	}

	private ItemStack fillCustomBucket(FillBucketEvent event) {
		World world = event.world;
		MovingObjectPosition pos = event.target;
		int blockID = world.getBlockId(pos.blockX, pos.blockY, pos.blockZ);
		Item bucket = null;
		
		Collection<Item> bucketCollection = buckets.get(Block.blocksList[blockID]);	
		Iterator<Item> it = bucketCollection.iterator();
		while (it.hasNext()) {
			Item tempBucket = it.next();
			if(BucketRegistery.isFilledBucketForEmptyBucket(event.entityPlayer.getCurrentEquippedItem(), new ItemStack(tempBucket))){
				bucket = tempBucket;
			}
		}
		
		if (bucket != null && world.getBlockMetadata(pos.blockX, pos.blockY, pos.blockZ) == 0) {
			world.setBlock(pos.blockX, pos.blockY, pos.blockZ, 0);
			return new ItemStack(bucket);
		}
		return null;
	}
}
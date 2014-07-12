package mod.industrialProcessing.utils.handlers.fluids;

import java.util.Collection;
import java.util.Iterator;

import mod.industrialProcessing.utils.registry.BucketRegistery;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.FillBucketEvent;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class BucketHandler {

	public static BucketHandler INSTANCE = new BucketHandler();
	private Multimap<Block, Item> buckets = ArrayListMultimap.create();

	private BucketHandler() {
	}

	public void put(Block block, Item item) {
		this.buckets.put(block, item);
	}

	@SubscribeEvent
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
		Block block = world.getBlock(pos.blockX, pos.blockY, pos.blockZ);
		Item bucket = null;
		
		Collection<Item> bucketCollection = buckets.get(block);	
		Iterator<Item> it = bucketCollection.iterator();
		while (it.hasNext()) {
			Item tempBucket = it.next();
			if(BucketRegistery.isFilledBucketForEmptyBucket(event.entityPlayer.getCurrentEquippedItem(), new ItemStack(tempBucket))){
				bucket = tempBucket;
			}
		}
		
		if (bucket != null && world.getBlockMetadata(pos.blockX, pos.blockY, pos.blockZ) == 0) {
			world.setBlockToAir(pos.blockX, pos.blockY, pos.blockZ);
			return new ItemStack(bucket);
		}
		return null;
	}
}
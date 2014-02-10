package ip.industrialProcessing.utils.registry;

import java.util.HashMap;

import net.minecraft.item.ItemStack;

public class BucketRegistery {
	private static HashMap<Class, Class> array = new HashMap<Class, Class>();
	
	public static void put(Class bucket, Class filledBucket){
		array.put(filledBucket, bucket);
	}
	
	public static boolean isFilledBucketForEmptyBucket(ItemStack stackEmpty,ItemStack stackFilled){
		return array.get(stackFilled.getItem().getClass()) == stackEmpty.getItem().getClass();
	}
}

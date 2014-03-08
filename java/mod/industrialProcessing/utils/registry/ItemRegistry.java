package mod.industrialProcessing.utils.registry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import cpw.mods.fml.common.registry.GameRegistry;
import mod.industrialProcessing.utils.INamepace;
import mod.industrialProcessing.utils.creativeTab.ISetupCreativeTabs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;

public class ItemRegistry {
	private static HashMap<Item, ItemType[]> array = new HashMap<Item, ItemType[]>();
	
	public static void registerItem(Item item, String unlocalizedName){
		item.setUnlocalizedName(unlocalizedName);
		item.setTextureName(INamepace.TEXTURE_NAME_PREFIX + item.getUnlocalizedName());
		item.setCreativeTab(ISetupCreativeTabs.tabItems);
		GameRegistry.registerItem(item, unlocalizedName);
		registerItem(item, ItemType.item);
	}
	
	public static void registerItem(Item item, String unlocalizedName, CreativeTabs tab){
		item.setUnlocalizedName(unlocalizedName);
		item.setTextureName(INamepace.TEXTURE_NAME_PREFIX +  item.getUnlocalizedName());
		item.setCreativeTab(tab);
		GameRegistry.registerItem(item, unlocalizedName);
		registerItem(item, ItemType.item);
	}
	
	public static void registerBucket(ItemBucket item, String unlocalizedName){
		item.setUnlocalizedName(unlocalizedName);
		item.setTextureName(INamepace.TEXTURE_NAME_PREFIX +  item.getUnlocalizedName());
		item.setCreativeTab(ISetupCreativeTabs.tabFluids);
		GameRegistry.registerItem(item, unlocalizedName);
		registerItem(item, ItemType.fluid);
	}
	
	private static void registerItem(Item item, ItemType... type) {
		array.put(item, type);
	}

	public static Iterator<Item> getItems() {
		return array.keySet().iterator();
	}
	
	private static boolean ContainsTag(ItemType[] value, ItemType item) {
		for (int i = 0; i < value.length; i++) {
			if (value[i] == item)
				return true;
		}
		return false;
	}

	public static Item[] getItemsByTagArray(ItemType type) {
		ArrayList<Item> list = new ArrayList<Item>();
		Iterator<Entry<Item, ItemType[]>> it = array.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Item, ItemType[]> set = it.next();
			if (ContainsTag(set.getValue(), type))
				list.add(set.getKey());
		}
		Item[] items = new Item[list.size()];
		for (int i = 0; i < list.size(); i++) {
			items[i] = list.get(i);
		}
		return items;
	}

	public static Iterator<Item> getItemsByTag(ItemType type) {
		ArrayList<Item> list = new ArrayList<Item>();
		Iterator<Entry<Item, ItemType[]>> it = array.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Item, ItemType[]> set = it.next();
			if (ContainsTag(set.getValue(), type))
				list.add(set.getKey());
		}
		return list.iterator();
	}

	public static Item[] getItemsByTagArray(ItemType... type) {
		ArrayList<Item> list = new ArrayList<Item>();
		Iterator<Entry<Item, ItemType[]>> it = array.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Item, ItemType[]> set = it.next();
			boolean containsTag = true;
			for (int i = 0; i < type.length; i++) {
				if (!ContainsTag(set.getValue(), type[i]))
					containsTag = false;
			}
			if (containsTag) {
				list.add(set.getKey());
			}
		}
		Item[] items = new Item[list.size()];
		for (int i = 0; i < list.size(); i++) {
			items[i] = list.get(i);
		}
		return items;
	}

	public static Iterator<Item> getItemsByTag(ItemType... type) {
		ArrayList<Item> list = new ArrayList<Item>();
		Iterator<Entry<Item, ItemType[]>> it = array.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Item, ItemType[]> set = it.next();
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

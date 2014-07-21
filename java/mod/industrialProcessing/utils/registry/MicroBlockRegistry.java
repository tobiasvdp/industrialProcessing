package mod.industrialProcessing.utils.registry;

import java.util.ArrayList;

import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.items.ISetupItems;
import mod.industrialProcessing.items.ItemMicroBlock;
import mod.industrialProcessing.logic.wire.cable.model.ModelCable;
import net.minecraft.item.Item;

public class MicroBlockRegistry {
	private static ArrayList<Item> array = new ArrayList<Item>();
	
	private static int RegisterMicroBlock(Item item) {
		array.add(item);
		return array.indexOf(item);
	}
	
	public static void setBounds(boolean full){
		if(full){
			IndustrialProcessing.microBlock.setBlockBounds(0, 0, 0, 1, 1, 1);
		}else{
			IndustrialProcessing.microBlock.setBlockBounds(0, 0, 0, 0, 0, 0);
		}
	}

	public static void registerMicroBlock(ItemMicroBlock item, String name, ModelCable modelCable) {
		int id = RegisterMicroBlock(item);
		item.setMicroblockID(id);
		
		int renderID = MicroBlockModelRegistry.getNextAvailableID();
		modelCable.register(renderID);
		
	    ItemRegistry.registerItem(item,name);
	}
}

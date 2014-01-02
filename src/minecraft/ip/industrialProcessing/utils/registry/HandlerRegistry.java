package ip.industrialProcessing.utils.registry;

import ip.industrialProcessing.utils.heat.IHeatHandler;

import java.util.Iterator;
import java.util.List;

import net.minecraft.item.ItemStack;

import com.google.common.collect.Lists;

public class HandlerRegistry {
	
    private static List<IHeatHandler> heatHandlers = Lists.newArrayList();
    
	public static void registerHeatHandler(IHeatHandler handler){
		heatHandlers.add(handler);	
	}
	
	public static int getHeatValue(ItemStack stack){
		Iterator<IHeatHandler> it = heatHandlers.iterator();
		int max = 0;
		while(it.hasNext()){
			IHeatHandler handler = it.next();
			int val = handler.getHeatOfItem(stack);
			if(val > max)
				max = val;
		}
		return max;
	}
}

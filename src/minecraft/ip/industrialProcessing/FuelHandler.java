package ip.industrialProcessing;

import ip.industrialProcessing.config.ISetupItems;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler {

    @Override
    public int getBurnTime(ItemStack fuel) {
	int var1 = fuel.itemID;
	
	if(var1 == ISetupItems.itemThickStick.itemID)
	    return 300;
	return 0;
    }

}

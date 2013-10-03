package ip.industrialProcessing.items;

import ip.industrialProcessing.IndustrialProcessing;

import java.awt.Point;

import net.minecraft.item.ItemStack;
 

public class GuideTreePage extends GuidePage {

    @Override
    public String getTitle() { 
	return "Ore Processing";
    }

    @Override
    public void drawScreen(int i, int j) {
	// TODO Auto-generated method stub

    }

    @Override
    public Point getIconLocation() { 
	return null;
    }

    @Override
    public ItemStack getIconStack() { 
	return new ItemStack(IndustrialProcessing.itemSmallMachineCasing);
    }

}

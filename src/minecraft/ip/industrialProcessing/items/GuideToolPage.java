package ip.industrialProcessing.items;

import ip.industrialProcessing.IndustrialProcessing;

import java.awt.Point;

import net.minecraft.item.ItemStack;

public class GuideToolPage extends GuidePage {

    @Override
    public Point getIconLocation() { 
	return null;
    }

    @Override
    public String getTitle() { 
	return "Tools";
    }

    @Override
    public void drawScreen(int i, int j) { 

    }

    @Override
    public ItemStack getIconStack() { 
	return new ItemStack(IndustrialProcessing.itemWrench);
    }

}

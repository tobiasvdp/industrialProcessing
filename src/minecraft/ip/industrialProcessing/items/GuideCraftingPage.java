package ip.industrialProcessing.items;

import java.awt.Point;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class GuideCraftingPage extends GuidePage {

    @Override
    public Point getIconLocation() { 
	return null;
    }

    @Override
    public String getTitle() { 
	return "Crafting";
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, int x, int y) {
	 
    }

    @Override
    public ItemStack getIconStack() { 
	return new ItemStack(Block.workbench);
    }

}

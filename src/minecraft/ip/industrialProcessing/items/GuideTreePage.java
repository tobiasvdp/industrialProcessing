package ip.industrialProcessing.items;

import ip.industrialProcessing.IndustrialProcessing;

import java.awt.Point;
import java.awt.Rectangle;

import net.minecraft.item.ItemStack;

public class GuideTreePage extends GuidePanoramaPage {

    public GuideTreePage() {
	super(new Rectangle(0, 0, 236, 172), new Point(10,20));

    }

    @Override
    public String getTitle() {
	return "Ore Processing";
    }

    @Override
    protected void drawPane(int mouseX, int mouseY) {
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

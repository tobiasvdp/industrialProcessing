package ip.industrialProcessing.gui3.guide.pages.machines.crafts;

import net.minecraft.item.crafting.IRecipe;
import ip.industrialProcessing.gui3.framework.UIElement;
import ip.industrialProcessing.gui3.framework.controls.ProgressBar;
import ip.industrialProcessing.gui3.framework.controls.SlotItemControl;
import ip.industrialProcessing.gui3.framework.custom.CraftingGrid;
import ip.industrialProcessing.gui3.framework.custom.ElementGrid;
import ip.industrialProcessing.gui3.framework.panels.Orientation;
import ip.industrialProcessing.gui3.framework.panels.StackPanel;
import ip.industrialProcessing.gui3.framework.rendering.TextureReference;

public class AnvilCraft extends WorkbenchCraft {

    public AnvilCraft(IRecipe recipe) {
	super("Anvil", recipe);
    }

}

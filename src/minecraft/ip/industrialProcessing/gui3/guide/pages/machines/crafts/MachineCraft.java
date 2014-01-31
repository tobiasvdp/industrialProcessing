package ip.industrialProcessing.gui3.guide.pages.machines.crafts;

import ip.industrialProcessing.gui3.framework.UIElement;
import ip.industrialProcessing.gui3.framework.controls.IButtonClickListener;
import ip.industrialProcessing.gui3.framework.controls.TextBlock;
import ip.industrialProcessing.gui3.generating.IGuiBlock;
import ip.industrialProcessing.gui3.generating.IGuiBuilder;
import ip.industrialProcessing.recipes.IMachineRecipe;
import ip.industrialProcessing.recipes.Recipe;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class MachineCraft implements ICraftBase {

    private Block block;
    private IMachineRecipe recipe;

    public MachineCraft(Block craftingBlock, IMachineRecipe recipe) {
	this.block = craftingBlock;
	this.recipe = recipe;
    }

    @Override
    public UIElement getGui(IButtonClickListener<ItemStack> slotClickListener) {
	if (this.block instanceof IGuiBlock) {
	    IGuiBuilder builder = ((IGuiBlock) this.block).getGui();
	    return builder.getRecipePage(this.recipe);
	}
	return TextBlock.createText(block.getLocalizedName() + " doesn't implement " + IGuiBlock.class);
    }

}

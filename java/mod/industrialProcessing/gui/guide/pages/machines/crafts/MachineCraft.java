package mod.industrialProcessing.gui.guide.pages.machines.crafts;

import ip.industrialProcessing.gui3.framework.UIElement;
import ip.industrialProcessing.gui3.framework.controls.IButtonClickListener;
import ip.industrialProcessing.gui3.framework.controls.TextBlock;
import ip.industrialProcessing.gui3.generating.IGuiBlock;
import ip.industrialProcessing.gui3.generating.IGuiBuilder;
import ip.industrialProcessing.gui3.generating.IGuiMultiblock;
import ip.industrialProcessing.multiblock.recipes.ITierRecipe;
import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.recipes.IMachineRecipe;
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
	    return builder.getRecipePage(this.recipe, slotClickListener);
	}
	if (this.block instanceof IGuiMultiblock) {
	    Tiers tier = getTier(this.recipe);
	    IGuiBuilder builder = ((IGuiMultiblock) this.block).getGui(tier);
	    return builder.getRecipePage(this.recipe, slotClickListener);
	}
	return TextBlock.createText(block.getLocalizedName() + " doesn't implement " + IGuiBlock.class);
    }

    private Tiers getTier(IMachineRecipe recipe) {
	if (recipe instanceof ITierRecipe) {
	    return ((ITierRecipe) recipe).getTier();
	}
	return Tiers.Tier0;
    }

}

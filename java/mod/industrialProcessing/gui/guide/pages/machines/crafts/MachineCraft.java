package mod.industrialProcessing.gui.guide.pages.machines.crafts;

import mod.industrialProcessing.blockContainer.multiblock.tier.Tiers;
import mod.industrialProcessing.gui.framework.UIElement;
import mod.industrialProcessing.gui.framework.controls.IButtonClickListener;
import mod.industrialProcessing.gui.framework.controls.TextBlock;
import mod.industrialProcessing.gui.generating.IGuiBuilder;
import mod.industrialProcessing.utils.block.IGuiBlock;
import mod.industrialProcessing.utils.block.IGuiMultiblock;
import mod.industrialProcessing.work.recipe.IMachineRecipe;
import mod.industrialProcessing.work.recipe.ITierRecipe;
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

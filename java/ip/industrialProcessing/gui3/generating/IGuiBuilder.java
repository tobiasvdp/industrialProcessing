package ip.industrialProcessing.gui3.generating;

import ip.industrialProcessing.gui3.containers.GuiLayoutContainer;
import ip.industrialProcessing.gui3.containers.LayoutContainer;
import ip.industrialProcessing.gui3.framework.controls.IButtonClickListener;
import ip.industrialProcessing.gui3.guide.pages.RecipeFrame;
import ip.industrialProcessing.recipes.IMachineRecipe;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public interface IGuiBuilder {
    GuiLayoutContainer getGuiContainer(LayoutContainer container, TileEntity tileEntity); 
    LayoutContainer getContainer(InventoryPlayer player, TileEntity tileEntity);
    RecipeFrame getRecipePage(IMachineRecipe recipe);
    RecipeFrame getRecipePage(IMachineRecipe recipe, IButtonClickListener<ItemStack> stackClickListener);
}

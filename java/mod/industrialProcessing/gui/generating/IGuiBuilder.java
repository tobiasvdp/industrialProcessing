package mod.industrialProcessing.gui.generating;

import mod.industrialProcessing.gui.containers.GuiLayoutContainer;
import mod.industrialProcessing.gui.containers.LayoutContainer;
import mod.industrialProcessing.gui.framework.controls.IButtonClickListener;
import mod.industrialProcessing.gui.guide.pages.RecipeFrame;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public interface IGuiBuilder {
    GuiLayoutContainer getGuiContainer(LayoutContainer container, TileEntity tileEntity); 
    LayoutContainer getContainer(InventoryPlayer player, TileEntity tileEntity);
    RecipeFrame getRecipePage(IMachineRecipe recipe);
    RecipeFrame getRecipePage(IMachineRecipe recipe, IButtonClickListener<ItemStack> stackClickListener);
}

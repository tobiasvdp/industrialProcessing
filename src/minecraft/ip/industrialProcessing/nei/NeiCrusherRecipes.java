package ip.industrialProcessing.nei;

import java.util.List;
import java.util.ArrayList;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.PacketHandler;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import codechicken.nei.LayoutManager;
import codechicken.nei.OffsetPositioner;
import codechicken.nei.PositionedStack;
import codechicken.nei.api.DefaultOverlayRenderer;
import codechicken.nei.api.IOverlayHandler;
import codechicken.nei.api.IRecipeOverlayRenderer;
import codechicken.nei.api.IStackPositioner;
import codechicken.nei.recipe.IRecipeHandler;
import codechicken.nei.recipe.TemplateRecipeHandler;

public class NeiCrusherRecipes implements IOverlayHandler{
	 	@Override
	    public void overlayRecipe(GuiContainer cont, IRecipeHandler recipe, int recipeIndex, boolean shift) {
	        List<PositionedStack> ingr = recipe.getIngredientStacks(recipeIndex);


	        if (IndustrialProcessing.invertShift) {
	            shift = !shift;
	        }


	        if (!shift) {
	            IStackPositioner positioner = new OffsetPositioner(5, 11);
	            IRecipeOverlayRenderer renderer = new DefaultOverlayRenderer(ingr, positioner);
	            LayoutManager.overlayRenderer = renderer;
	        } else {
	            NBTTagList stacksnbt = new NBTTagList();


	            for (int i = 0; i < ingr.size(); i++) {


	                if (ingr.get(i) != null) {
	                    int x = (ingr.get(i).relx - 25) / 18;
	                    int y = (ingr.get(i).rely - 6) / 18;


	                    ItemStack stack = ingr.get(i).items[0];
	                    NBTTagCompound stacknbt = stack.writeToNBT(new NBTTagCompound());
	                    stacknbt.setInteger("slot", y * 3 + x);
	                    stacksnbt.appendTag(stacknbt);
	                }
	            }
	            NBTTagCompound data = new NBTTagCompound();
	            data.setTag("stacks", stacksnbt);


	            PacketHandler.send("SetCrusherRecipe", data);
	        }
	    }
}

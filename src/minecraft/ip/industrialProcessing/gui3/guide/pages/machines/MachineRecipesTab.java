package ip.industrialProcessing.gui3.guide.pages.machines;

import ip.industrialProcessing.gui3.framework.Thickness;
import ip.industrialProcessing.gui3.framework.Visibility;
import ip.industrialProcessing.gui3.framework.controls.Button;
import ip.industrialProcessing.gui3.framework.controls.IButtonClickListener;
import ip.industrialProcessing.gui3.framework.controls.SlotItemControl;
import ip.industrialProcessing.gui3.framework.controls.TextBlock;
import ip.industrialProcessing.gui3.framework.controls.UserControl;
import ip.industrialProcessing.gui3.framework.panels.MouseButton;
import ip.industrialProcessing.gui3.framework.panels.Orientation;
import ip.industrialProcessing.gui3.framework.panels.ScrollPanel;
import ip.industrialProcessing.gui3.framework.panels.ScrollPanel;
import ip.industrialProcessing.gui3.framework.panels.StackPanel;
import ip.industrialProcessing.gui3.framework.panels.WrapPanel;
import ip.industrialProcessing.gui3.framework.panels.tabs.TabPage;
import ip.industrialProcessing.gui3.generating.IGuiBlock;
import ip.industrialProcessing.gui3.generating.IGuiBuilder;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.IRecipeBlock;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class MachineRecipesTab extends TabPage implements IButtonClickListener<Recipe> {

    private WrapPanel wrapPanel;
    private Block block;
    private UserControl recipeDock;

    public MachineRecipesTab() {
	this.header = TextBlock.createText("Recipes");
	this.activeHeader = TextBlock.createText("Recipes", 0xffffffff);
	StackPanel stack = new StackPanel();
	stack.orientation = Orientation.VERTICAL;
	this.wrapPanel = new WrapPanel();
	ScrollPanel scroll = new ScrollPanel();
	scroll.allowHorizontalScroll = false;
	scroll.allowVerticalScroll = true;
	scroll.maxHeight = 18 * 2 + 2;
	scroll.minHeight = 18 * 2 + 2; 
	scroll.content = wrapPanel;
	stack.addChild(scroll);
	this.recipeDock = new UserControl();
	this.recipeDock.width = this.recipeDock.height = Float.NaN;
	this.recipeDock.margin = new Thickness(7, 0, 0, 0);
	stack.addChild(recipeDock);
	this.content = stack;
    }

    public void setBlock(Block tag) {
	this.block = tag;
	this.wrapPanel.clear();
	this.recipeDock.child = null;
	if (tag instanceof IRecipeBlock) {
	    RecipesMachine recipes = ((IRecipeBlock) tag).getRecipes();

	    for (int i = 0; i < recipes.size(); i++) {
		Recipe recipe = recipes.get(i);
		if (recipe.outputs != null && recipe.outputs.length > 0) {

		    StackPanel outputStack = new StackPanel();
		    outputStack.orientation = Orientation.HORIZONTAL;
		    for (int j = 0; j < recipe.outputs.length; j++) {
			ItemStack stack = getStack(recipe.outputs[j]);
			outputStack.addChild(SlotItemControl.createItemstack(stack));
		    }

		    Button button = new Button<Recipe>(outputStack, recipe);
		    button.subscribeClick(this);
		    wrapPanel.addChild(button);
		}
	    }
	}
    }

    private ItemStack getStack(RecipeOutputSlot mainProduct) {
	switch (mainProduct.type) {
	case INVENTORY:
	case DAMAGEDITEM:
	    return new ItemStack(mainProduct.itemId, 1, mainProduct.damage);
	case TANK:
	    Fluid fluid = FluidRegistry.getFluid(mainProduct.itemId);
	    return new ItemStack(fluid.getBlockID(), 1, 0);
	default:
	    return null;
	}
    }

    @Override
    public void buttonClicked(Button<Recipe> button, Recipe tag, float mouseX, float mouseY, MouseButton mouseButton) {
	if (block instanceof IGuiBlock && tag != null) {
	    IGuiBuilder builder = ((IGuiBlock) this.block).getGui();
	    this.recipeDock.child = builder.getRecipePage(tag);
	} else
	    this.recipeDock.child = null;
    }
}

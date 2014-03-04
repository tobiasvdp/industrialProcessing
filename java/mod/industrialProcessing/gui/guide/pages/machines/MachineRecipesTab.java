package mod.industrialProcessing.gui.guide.pages.machines;

import ip.industrialProcessing.gui3.framework.Thickness;
import ip.industrialProcessing.gui3.framework.controls.Button;
import ip.industrialProcessing.gui3.framework.controls.IButtonClickListener;
import ip.industrialProcessing.gui3.framework.controls.SlotItemControl;
import ip.industrialProcessing.gui3.framework.controls.TextBlock;
import ip.industrialProcessing.gui3.framework.controls.UserControl;
import ip.industrialProcessing.gui3.framework.panels.MouseButton;
import ip.industrialProcessing.gui3.framework.panels.Orientation;
import ip.industrialProcessing.gui3.framework.panels.ScrollPanel;
import ip.industrialProcessing.gui3.framework.panels.StackPanel;
import ip.industrialProcessing.gui3.framework.panels.WrapPanel;
import ip.industrialProcessing.gui3.framework.panels.tabs.TabPage;
import ip.industrialProcessing.gui3.generating.IGuiBlock;
import ip.industrialProcessing.gui3.generating.IGuiBuilder;
import ip.industrialProcessing.gui3.generating.IGuiMultiblock;
import ip.industrialProcessing.multiblock.recipes.ITierRecipe;
import ip.industrialProcessing.recipes.IMachineRecipe;
import ip.industrialProcessing.recipes.IRecipeBlock;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.utils.registry.RecipeRegistry;

import java.util.Iterator;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class MachineRecipesTab extends TabPage implements IButtonClickListener<IMachineRecipe> {

	private WrapPanel wrapPanel;
	private Block block;
	private UserControl recipeDock;
	private IButtonClickListener<ItemStack> stackClickListener;

	public MachineRecipesTab(IButtonClickListener<ItemStack> stackClickListener) {
		this.header = TextBlock.createText("Recipes");
		this.activeHeader = TextBlock.createText("Recipes", 0xffffffff);
        this.header.margin = this.activeHeader.margin = new Thickness(0, 5, 0, 0);
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
		this.stackClickListener = stackClickListener;
	}

	public void setBlock(Block tag) {
		this.block = tag;
		this.wrapPanel.clear();
		this.recipeDock.child = null;
		Iterator<IMachineRecipe> recipes;
		if (tag instanceof IRecipeBlock) {
			recipes = ((IRecipeBlock) tag).getRecipes().getRecipes();
		} else {
			recipes = RecipeRegistry.getRecipesForMachine(tag).iterator();
		}
		IMachineRecipe firstRecipe = null;
		if (recipes != null && recipes.hasNext()) {
			int i = 0;
			while(recipes.hasNext()){
				IMachineRecipe recipe = recipes.next();
				if(i == 0)
					firstRecipe = recipe;
				RecipeOutputSlot[] outputs = recipe.getOutputs();
				if (outputs != null && outputs.length > 0) {

					StackPanel outputStack = new StackPanel();
					outputStack.orientation = Orientation.HORIZONTAL;
					for (int j = 0; j < outputs.length; j++) {
						ItemStack stack = getStack(outputs[j]);
						outputStack.addChild(SlotItemControl.createItemstack(stack));
					}

					Button button = new Button<IMachineRecipe>(outputStack, recipe);
					button.subscribeClick(this);
					wrapPanel.addChild(button);
				}
				i++;
			}
			setRecipe(firstRecipe);
		}
	}

	private void setRecipe(IMachineRecipe tag) {
		if (block instanceof IGuiBlock && tag != null) {
			IGuiBuilder builder = ((IGuiBlock) this.block).getGui();
			this.recipeDock.child = builder.getRecipePage(tag, this.stackClickListener);
		} else if (block instanceof IGuiMultiblock && tag != null && tag instanceof ITierRecipe) {
			IGuiBuilder builder = ((IGuiMultiblock) this.block).getGui(((ITierRecipe) tag).getTier());
			this.recipeDock.child = builder.getRecipePage(tag, this.stackClickListener);
		} else
			this.recipeDock.child = TextBlock.createText(block.getLocalizedName() + " doesn't implement " + IGuiBlock.class + " or " + IGuiMultiblock.class);

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
	public void buttonClicked(Button<IMachineRecipe> button, IMachineRecipe tag, float mouseX, float mouseY, MouseButton mouseButton) {
		setRecipe(tag);
	}
}

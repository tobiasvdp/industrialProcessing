package mod.industrialProcessing.gui.guide.pages.machines;

import java.util.Iterator;

import mod.industrialProcessing.gui.framework.Thickness;
import mod.industrialProcessing.gui.framework.controls.Button;
import mod.industrialProcessing.gui.framework.controls.IButtonClickListener;
import mod.industrialProcessing.gui.framework.controls.SlotItemControl;
import mod.industrialProcessing.gui.framework.controls.TextBlock;
import mod.industrialProcessing.gui.framework.controls.UserControl;
import mod.industrialProcessing.gui.framework.panels.MouseButton;
import mod.industrialProcessing.gui.framework.panels.Orientation;
import mod.industrialProcessing.gui.framework.panels.ScrollPanel;
import mod.industrialProcessing.gui.framework.panels.StackPanel;
import mod.industrialProcessing.gui.framework.panels.WrapPanel;
import mod.industrialProcessing.gui.framework.panels.tabs.TabPage;
import mod.industrialProcessing.gui.generating.IGuiBuilder;
import mod.industrialProcessing.utils.block.IGuiBlock;
import mod.industrialProcessing.utils.block.IGuiMultiblock;
import mod.industrialProcessing.utils.block.IRecipeBlock;
import mod.industrialProcessing.utils.registry.RecipeRegistry;
import mod.industrialProcessing.work.recipe.IMachineRecipe;
import mod.industrialProcessing.work.recipe.ITierRecipe;
import mod.industrialProcessing.work.recipe.RecipeOutputSlot;
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
			return new ItemStack(mainProduct.item, 1, mainProduct.damage);
		case TANK:
			Fluid fluid = (mainProduct.fluid);
			return new ItemStack(fluid.getBlock(), 1, 0);
		default:
			return null;
		}
	}

	@Override
	public void buttonClicked(Button<IMachineRecipe> button, IMachineRecipe tag, float mouseX, float mouseY, MouseButton mouseButton) {
		setRecipe(tag);
	}
}

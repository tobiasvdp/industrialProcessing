package mod.industrialProcessing.gui.guide.pages.machines.crafts;

import java.util.ArrayList;
import java.util.List;

import mod.industrialProcessing.gui.framework.Alignment;
import mod.industrialProcessing.gui.framework.UIElement;
import mod.industrialProcessing.gui.framework.controls.Button;
import mod.industrialProcessing.gui.framework.controls.IButtonClickListener;
import mod.industrialProcessing.gui.framework.controls.ProgressBar;
import mod.industrialProcessing.gui.framework.controls.SlotItemControl;
import mod.industrialProcessing.gui.framework.controls.TextBlock;
import mod.industrialProcessing.gui.framework.custom.ElementGrid;
import mod.industrialProcessing.gui.framework.panels.GridCell;
import mod.industrialProcessing.gui.framework.panels.GridPanel;
import mod.industrialProcessing.gui.framework.panels.GridSize;
import mod.industrialProcessing.gui.framework.panels.Orientation;
import mod.industrialProcessing.gui.framework.panels.SizeMode;
import mod.industrialProcessing.gui.framework.panels.StackPanel;
import mod.industrialProcessing.gui.framework.rendering.TextureReference;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class WorkbenchCraft implements ICraftBase {

    private static final TextureReference WORKER_TEXTURE = TextureReference.createDefault("Worker.png", 24, 32);
    private IRecipe recipe;
    private String name;

    public WorkbenchCraft(IRecipe recipe) {
	this("Workbench", recipe);
    }

    protected WorkbenchCraft(String name, IRecipe recipe) {
	this.recipe = recipe;
	this.name = name;
    }

    @Override
    public UIElement getGui(IButtonClickListener<ItemStack> slotClickListener) {
	UIElement[] slots = new UIElement[9];

	if (recipe instanceof ShapedOreRecipe) {
	    ShapedOreRecipe shaped = (ShapedOreRecipe) recipe;
	    Object[] input = shaped.getInput();
	    for (int i = 0; i < slots.length; i++) {
		if (i < input.length) {
		    Object item = input[i];
		    if (item instanceof ArrayList<?>) {
			ArrayList<ItemStack> list = (ArrayList<ItemStack>) item;
			if (!list.isEmpty()) {
			    slots[i] = SlotItemControl.createButtonSlot(list.get(0), slotClickListener);
			    continue;
			}
		    }
		    if (item instanceof ItemStack) {
			ItemStack stack = (ItemStack) item;
			slots[i] = SlotItemControl.createButtonSlot(stack, slotClickListener);
			continue;
		    }
		}
		slots[i] = SlotItemControl.createSlot(null);
	    }
	} else if (recipe instanceof ShapedRecipes) {
	    ShapedRecipes shaped = (ShapedRecipes) recipe;
	    for (int i = 0; i < slots.length; i++) {
		ItemStack stack = null;
		if (shaped.recipeItems.length > i)
		    stack = shaped.recipeItems[i];
		if (stack == null)
		    slots[i] = SlotItemControl.createSlot(null);
		else
		    slots[i] = SlotItemControl.createButtonSlot(stack, slotClickListener);
	    }
	} else if (recipe instanceof ShapelessRecipes) {
	    ShapelessRecipes shapeless = (ShapelessRecipes) recipe;

	    List recipeItems = shapeless.recipeItems;
	    for (int i = 0; i < slots.length; i++) {
		ItemStack stack = null;
		if (i < recipeItems.size())
		    stack = (ItemStack) recipeItems.get(i);
		if (stack == null)
		    slots[i] = SlotItemControl.createSlot(null);
		else
		    slots[i] = SlotItemControl.createButtonSlot(stack, slotClickListener);
	    }
	}

	StackPanel stack = new StackPanel();
	stack.orientation = Orientation.VERTICAL;
	stack.addChild(TextBlock.createText(this.name));
	GridPanel gridPanel = new GridPanel();
	gridPanel.rows.add(new GridSize(1, SizeMode.RELATIVE));

	ElementGrid grid = new ElementGrid(slots, 3, Orientation.HORIZONTAL);
	grid.horizontalAlign = Alignment.MIN;
	gridPanel.children.add(new GridCell(0, 0, grid));
	gridPanel.columns.add(new GridSize(3, SizeMode.RELATIVE));
	ProgressBar worker = ProgressBar.createWorker(WORKER_TEXTURE);
	worker.horizontalAlign = Alignment.CENTER;
	gridPanel.children.add(new GridCell(0, 1, worker));
	gridPanel.columns.add(new GridSize(2, SizeMode.RELATIVE));
	Button slot = SlotItemControl.createButtonSlot(recipe.getRecipeOutput(), slotClickListener);
	slot.verticalAlign = Alignment.CENTER;
	slot.horizontalAlign = Alignment.CENTER;
	gridPanel.children.add(new GridCell(0, 2, slot));
	gridPanel.columns.add(new GridSize(1, SizeMode.RELATIVE));
	stack.addChild(gridPanel);
	return stack;
    }
}

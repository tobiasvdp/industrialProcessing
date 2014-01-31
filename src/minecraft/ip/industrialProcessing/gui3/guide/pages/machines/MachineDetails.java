package ip.industrialProcessing.gui3.guide.pages.machines;

import ip.industrialProcessing.gui3.framework.Thickness;
import ip.industrialProcessing.gui3.framework.Visibility;
import ip.industrialProcessing.gui3.framework.controls.BlockModelControl;
import ip.industrialProcessing.gui3.framework.controls.Button;
import ip.industrialProcessing.gui3.framework.controls.IButtonClickListener;
import ip.industrialProcessing.gui3.framework.controls.TextBlock;
import ip.industrialProcessing.gui3.framework.controls.UserControl;
import ip.industrialProcessing.gui3.framework.panels.DockPanel;
import ip.industrialProcessing.gui3.framework.panels.MouseButton;
import ip.industrialProcessing.gui3.framework.panels.Orientation;
import ip.industrialProcessing.gui3.framework.panels.StackPanel;
import ip.industrialProcessing.gui3.framework.panels.tabs.TabPanel;
import ip.industrialProcessing.gui3.generating.IGuiBlock;
import ip.industrialProcessing.gui3.generating.IGuiBuilder;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.IRecipeBlock;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.utils.IDescriptionBlock;
import net.minecraft.block.Block;

public class MachineDetails extends UserControl implements IButtonClickListener<Block> {

    private TextBlock title;
    private TextBlock description;
    private BlockModelControl render;
    private IGuiBlock block;
    private MachineCraftTab craftTab;
    private MachineRecipesTab recipeTab;
    private TabPanel recipeTabs;

    public MachineDetails() {
	this.isHittestVisible = true;
	this.width = Float.NaN;
	this.height = Float.NaN;
	StackPanel stack = new StackPanel();
	stack.orientation = Orientation.VERTICAL;
	title = TextBlock.createText("Block");
	title.margin = new Thickness(0, 0, 7, 0);
	stack.addChild(title);

	DockPanel dock = new DockPanel();
	description = TextBlock.createText("Bladibladibla");
	description.margin = new Thickness(0, 0, 0, 7);
	dock.content = description;
	render = new BlockModelControl(null);
	render.width = 48;
	render.height = 48;
	dock.docked = render;

	stack.addChild(dock);

	recipeTabs = new TabPanel();
	recipeTabs.margin = new Thickness(7, 0, 0, 0);
	this.craftTab = new MachineCraftTab();
	this.recipeTab = new MachineRecipesTab();
	recipeTabs.addTab(craftTab);
	recipeTabs.addTab(recipeTab);

	stack.addChild(recipeTabs);
	stack.margin = new Thickness(0, 0, 0, 7);
	this.child = stack;
    }

    @Override
    public void buttonClicked(Button<Block> button, Block tag, float mouseX, float mouseY, MouseButton mouseButton) {
	this.setBlock(tag);
    }

    public void setBlock(Block tag) {
	recipeTabs.clear();
	title.text = tag.getLocalizedName();
	render.model = tag;
	if (tag instanceof IDescriptionBlock) {
	    description.text = ((IDescriptionBlock) tag).getDescription();
	    description.visibility = Visibility.VISIBLE;
	} else
	    description.visibility = Visibility.COLLAPSED;

	recipeTabs.addTab(craftTab);
	this.craftTab.setBlock(tag);
	if (tag instanceof IRecipeBlock)
	    this.recipeTabs.addTab(recipeTab);
	this.recipeTab.setBlock(tag);
    }

}

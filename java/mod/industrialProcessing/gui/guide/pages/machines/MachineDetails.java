package mod.industrialProcessing.gui.guide.pages.machines;

import mod.industrialProcessing.gui.framework.Thickness;
import mod.industrialProcessing.gui.framework.Visibility;
import mod.industrialProcessing.gui.framework.controls.BlockModelControl;
import mod.industrialProcessing.gui.framework.controls.Button;
import mod.industrialProcessing.gui.framework.controls.IButtonClickListener;
import mod.industrialProcessing.gui.framework.controls.TextBlock;
import mod.industrialProcessing.gui.framework.controls.UserControl;
import mod.industrialProcessing.gui.framework.panels.DockPanel;
import mod.industrialProcessing.gui.framework.panels.MouseButton;
import mod.industrialProcessing.gui.framework.panels.Orientation;
import mod.industrialProcessing.gui.framework.panels.StackPanel;
import mod.industrialProcessing.gui.framework.panels.tabs.TabPanel;
import mod.industrialProcessing.utils.block.IDescriptionBlock;
import mod.industrialProcessing.utils.block.IGuiBlock;
import mod.industrialProcessing.utils.block.IRecipeBlock;
import mod.industrialProcessing.utils.registry.RecipeRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class MachineDetails extends UserControl implements IButtonClickListener<ItemStack> {

	private TextBlock title;
	private TextBlock description;
	private BlockModelControl render;
	private IGuiBlock block;
	private MachineCraftTab craftTab;
	private MachineRecipesTab recipeTab;
	private TabPanel recipeTabs;
	private MachineTechChainTab techTreeTab;

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
		description = TextBlock.createText("Select a machine");
		description.margin = new Thickness(0, 0, 0, 7);
		dock.content = description;
		render = new BlockModelControl(null);
		render.width = 48;
		render.height = 48;
		dock.docked = render;

		stack.addChild(dock);

		recipeTabs = new TabPanel();
		recipeTabs.margin = new Thickness(7, 0, 0, 0);
		this.craftTab = new MachineCraftTab(this);
		this.recipeTab = new MachineRecipesTab(this);
		this.techTreeTab = new MachineTechChainTab(this);

		stack.addChild(recipeTabs);
		stack.margin = new Thickness(0, 0, 0, 7);
		this.child = stack;
	}

	@Override
	public void buttonClicked(Button<ItemStack> button, ItemStack tag, float mouseX, float mouseY, MouseButton mouseButton) {
		this.setItemStack(tag);
	}

	public void setItemStack(ItemStack tag) {
		tag = tag.copy();
		tag.stackSize = 1;
		recipeTabs.clear();
		title.text = tag.getDisplayName();
		render.model = tag;

		recipeTabs.addTab(craftTab);
		this.craftTab.setStack(tag);

		Block block = Block.getBlockFromItem(tag.getItem());
		if (block != null) {
			if (block instanceof IDescriptionBlock) {
				description.text = ((IDescriptionBlock) block).getDescription();
				description.visibility = Visibility.VISIBLE;
			} else
				description.visibility = Visibility.COLLAPSED;
			if (block instanceof IRecipeBlock || !RecipeRegistry.getRecipesForMachine(block).isEmpty()) {
				this.recipeTabs.addTab(recipeTab);
				this.recipeTab.setBlock(block);
			}
			this.recipeTabs.addTab(techTreeTab);
			this.techTreeTab.setBlock(block);
		} else
			description.visibility = Visibility.COLLAPSED;

	}
}

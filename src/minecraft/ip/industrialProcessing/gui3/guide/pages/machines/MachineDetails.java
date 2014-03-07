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
import ip.industrialProcessing.recipes.IRecipeBlock;
import ip.industrialProcessing.utils.IDescriptionBlock;
import ip.industrialProcessing.utils.registry.RecipeRegistry;
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
        title.setText(tag.getDisplayName());
        render.model = tag;

        recipeTabs.addTab(craftTab);
        this.craftTab.setStack(tag);

        if (tag.itemID < Block.blocksList.length) {
            Block block = Block.blocksList[tag.itemID];
            if (block instanceof IDescriptionBlock) {
                description.setText(((IDescriptionBlock) block).getDescription());
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

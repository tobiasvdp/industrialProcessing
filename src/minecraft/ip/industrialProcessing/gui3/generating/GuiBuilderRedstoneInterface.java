package ip.industrialProcessing.gui3.generating;

import ip.industrialProcessing.gui3.containers.GuiLayoutContainer;
import ip.industrialProcessing.gui3.containers.LayoutContainer;
import ip.industrialProcessing.gui3.framework.Alignment;
import ip.industrialProcessing.gui3.framework.Thickness;
import ip.industrialProcessing.gui3.framework.UIElement;
import ip.industrialProcessing.gui3.framework.controls.Decorator;
import ip.industrialProcessing.gui3.framework.controls.IButtonClickListener;
import ip.industrialProcessing.gui3.framework.controls.SlotItemControl;
import ip.industrialProcessing.gui3.framework.controls.TextBlock;
import ip.industrialProcessing.gui3.framework.custom.StateButton;
import ip.industrialProcessing.gui3.framework.panels.DockPanel;
import ip.industrialProcessing.gui3.framework.panels.GridCell;
import ip.industrialProcessing.gui3.framework.panels.GridPanel;
import ip.industrialProcessing.gui3.framework.panels.GridSize;
import ip.industrialProcessing.gui3.framework.panels.Orientation;
import ip.industrialProcessing.gui3.framework.panels.SizeMode;
import ip.industrialProcessing.gui3.framework.panels.StackPanel;
import ip.industrialProcessing.gui3.framework.panels.tabs.TabPage;
import ip.industrialProcessing.gui3.framework.panels.tabs.TabPanel;
import ip.industrialProcessing.gui3.framework.rendering.TextureReference;
import ip.industrialProcessing.gui3.generating.builderParts.DefaultInventory;
import ip.industrialProcessing.gui3.generating.builderParts.DefaultStateConfigs;
import ip.industrialProcessing.gui3.generating.builderParts.StateButtonReference;
import ip.industrialProcessing.gui3.guide.pages.RecipeFrame;
import ip.industrialProcessing.recipes.IMachineRecipe;
import ip.industrialProcessing.utils.handler.numbers.IStateConfig;
import net.minecraft.block.Block;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class GuiBuilderRedstoneInterface implements IGuiBuilder {

    private final TextureReference REDSTONE_BUTTON_TEXTURE = TextureReference.createDefault("RestoneTorch.png", 48, 16);
    private final String[] REDSTONE_BUTTON_TOOLTIPS = new String[] { "Emit", "Don't Emit", "Emit progress" };
    StateButtonReference idle = new StateButtonReference(0, REDSTONE_BUTTON_TEXTURE, 1, 3, REDSTONE_BUTTON_TOOLTIPS);
    StateButtonReference working = new StateButtonReference(1, REDSTONE_BUTTON_TEXTURE, 1, 3, REDSTONE_BUTTON_TOOLTIPS);
    StateButtonReference supsended = new StateButtonReference(2, REDSTONE_BUTTON_TEXTURE, 1, 3, REDSTONE_BUTTON_TOOLTIPS);
    private String name;

    public GuiBuilderRedstoneInterface(String unlocalizedName) {
        this.name = unlocalizedName;
    }

    @Override
    public GuiLayoutContainer getGuiContainer(LayoutContainer container, TileEntity tileEntity) {

        Decorator redstone = Decorator.createDecorator();
        redstone.verticalAlign = Alignment.CENTER;
        redstone.horizontalAlign = Alignment.CENTER;
        GuiLayoutContainer guiContainer = new GuiLayoutContainer(container, redstone);
        redstone.setChild(createRestoneTab(guiContainer, container, tileEntity));

        return guiContainer;
    }

    private UIElement createRestoneTab(GuiLayoutContainer guiContainer, LayoutContainer container, TileEntity tileEntity) {

        StackPanel stack = new StackPanel();
        stack.orientation = Orientation.VERTICAL; 
        stack.minWidth = 250;
        GridPanel outputGrid = new GridPanel();
        outputGrid.columns.add(new GridSize(21, SizeMode.ABSOLUTE));
        outputGrid.columns.add(new GridSize(1, SizeMode.RELATIVE));
        outputGrid.columns.add(new GridSize(21, SizeMode.ABSOLUTE));
        outputGrid.columns.add(new GridSize(1, SizeMode.RELATIVE));
        outputGrid.columns.add(new GridSize(21, SizeMode.ABSOLUTE));
        outputGrid.columns.add(new GridSize(1, SizeMode.RELATIVE));


        TextBlock text = TextBlock.createText(this.name); 
        text.margin = new Thickness(0, 0, 5, 0);
        stack.addChild(text);
        
        text = TextBlock.createText("Working");
        text.verticalAlign = Alignment.CENTER;
        text.margin = new Thickness(0, 0, 0, 5);
        outputGrid.children.add(new GridCell(outputGrid.rows.size(), 1, text));
        outputGrid.children.add(new GridCell(outputGrid.rows.size(), 0, DefaultStateConfigs.setupButton(working, guiContainer, tileEntity)));
        // outputGrid.rows.add(new GridSize(21, SizeMode.ABSOLUTE));
        // outputGrid.rows.add(new GridSize(5, SizeMode.ABSOLUTE));

        text = TextBlock.createText("Idle");
        text.verticalAlign = Alignment.CENTER;
        text.margin = new Thickness(0, 0, 0, 5);
        outputGrid.children.add(new GridCell(outputGrid.rows.size(), 3, text));
        outputGrid.children.add(new GridCell(outputGrid.rows.size(), 2, DefaultStateConfigs.setupButton(idle, guiContainer, tileEntity))); 

        text = TextBlock.createText("Suspended");
        text.verticalAlign = Alignment.CENTER;
        text.margin = new Thickness(0, 0, 0, 5);
        outputGrid.children.add(new GridCell(outputGrid.rows.size(), 5, text));
        outputGrid.children.add(new GridCell(outputGrid.rows.size(), 4, DefaultStateConfigs.setupButton(supsended, guiContainer, tileEntity)));
        
        
        outputGrid.rows.add(new GridSize(21, SizeMode.ABSOLUTE));
        outputGrid.rows.add(new GridSize(5, SizeMode.ABSOLUTE));

        text = TextBlock.createText("Output when");
        text.margin = new Thickness(0, 0, 5, 0);
        stack.addChild(text);
        stack.addChild(outputGrid);
 
        return stack;
    }

    @Override
    public LayoutContainer getContainer(InventoryPlayer player, TileEntity tileEntity) {
        LayoutContainer container = new LayoutContainer();
        IStateConfig config = (IStateConfig) tileEntity;
        DefaultStateConfigs.setupButton(working, container, config);
        DefaultStateConfigs.setupButton(idle, container, config);
        DefaultStateConfigs.setupButton(supsended, container, config);
        return container;
    }

    @Override
    public RecipeFrame getRecipePage(IMachineRecipe recipe) {
        return null;
    }

    @Override
    public RecipeFrame getRecipePage(IMachineRecipe recipe, IButtonClickListener<ItemStack> stackClickListener) {
        return null;
    }

}

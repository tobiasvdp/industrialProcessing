package ip.industrialProcessing.gui3.generating;

import ip.industrialProcessing.gui3.containers.GuiLayoutContainer;
import ip.industrialProcessing.gui3.containers.LayoutContainer;
import ip.industrialProcessing.gui3.framework.Alignment;
import ip.industrialProcessing.gui3.framework.Thickness;
import ip.industrialProcessing.gui3.framework.controls.Decorator;
import ip.industrialProcessing.gui3.framework.controls.IButtonClickListener;
import ip.industrialProcessing.gui3.framework.controls.TextBlock;
import ip.industrialProcessing.gui3.framework.panels.Orientation;
import ip.industrialProcessing.gui3.framework.panels.StackPanel;
import ip.industrialProcessing.gui3.generating.builderParts.DefaultInventory;
import ip.industrialProcessing.gui3.generating.builderParts.InventoryReference;
import ip.industrialProcessing.gui3.generating.builderParts.specialized.InventoryHeaderRowReference;
import ip.industrialProcessing.gui3.generating.builderParts.specialized.InventoryHeaderRows;
import ip.industrialProcessing.gui3.guide.pages.RecipeFrame;
import ip.industrialProcessing.recipes.IMachineRecipe;

import java.util.ArrayList;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class GuiBuilderInventory implements IGuiBuilder {

    private String name;

    public GuiBuilderInventory(String name) {
        this.name = name;
        this.inventoryRef = new InventoryReference(true);
    }

    ArrayList<InventoryHeaderRowReference> headerRows = new ArrayList<InventoryHeaderRowReference>();
    private Orientation orientation;
    private InventoryReference inventoryRef;

    public GuiBuilderInventory addInventoryHeaderRow(int headerSlot, int firstSlot, int slotCount, int size) {
        headerRows.add(new InventoryHeaderRowReference(headerSlot, firstSlot, slotCount, size));
        return this;
    }

    @Override
    public GuiLayoutContainer getGuiContainer(LayoutContainer container, TileEntity tileEntity) {
        Decorator root = Decorator.createDecorator();
        StackPanel rootStack = new StackPanel();
        TextBlock title = TextBlock.createText(this.name);
        rootStack.addChild(title);
        rootStack.orientation = Orientation.VERTICAL;
        GuiLayoutContainer guiContainer = new GuiLayoutContainer(container, root);
        StackPanel content = new StackPanel();
        content.orientation = this.orientation.getOpposite();
        InventoryHeaderRows.setup(this.headerRows, guiContainer, content, this.orientation);
        rootStack.addChild(content);
        content.margin = new Thickness(0, 0, 7, 0);
        DefaultInventory.setup(this.inventoryRef, guiContainer, rootStack);
        root.setChild(rootStack);
        root.verticalAlign = Alignment.CENTER;
        root.horizontalAlign = Alignment.CENTER;
        return guiContainer;
    }

    @Override
    public LayoutContainer getContainer(InventoryPlayer player, TileEntity tileEntity) {
        LayoutContainer container = new LayoutContainer();
        InventoryHeaderRows.setup(this.headerRows, container, tileEntity);
        DefaultInventory.setup(this.inventoryRef, player, container);
        return container;
    }

    @Override
    public RecipeFrame getRecipePage(IMachineRecipe recipe) {
        return getRecipePage(recipe, null);
    }

    @Override
    public RecipeFrame getRecipePage(IMachineRecipe recipe, IButtonClickListener<ItemStack> stackClickListener) {
        return new RecipeFrame(TextBlock.createText("Storage Inventory with recipes ... what?"), this.name);
    }

    public GuiBuilderInventory setMode(Orientation a) {
        this.orientation = a;
        return this;
    }

}

package mod.industrialProcessing.gui.generating;

import java.util.ArrayList;

import mod.industrialProcessing.gui.containers.GuiLayoutContainer;
import mod.industrialProcessing.gui.containers.LayoutContainer;
import mod.industrialProcessing.gui.framework.Alignment;
import mod.industrialProcessing.gui.framework.Thickness;
import mod.industrialProcessing.gui.framework.controls.Decorator;
import mod.industrialProcessing.gui.framework.controls.IButtonClickListener;
import mod.industrialProcessing.gui.framework.controls.TextBlock;
import mod.industrialProcessing.gui.framework.panels.Orientation;
import mod.industrialProcessing.gui.framework.panels.StackPanel;
import mod.industrialProcessing.gui.generating.builderParts.DefaultInventory;
import mod.industrialProcessing.gui.generating.builderParts.InventoryReference;
import mod.industrialProcessing.gui.generating.builderParts.specialized.InventoryHeaderRowReference;
import mod.industrialProcessing.gui.generating.builderParts.specialized.InventoryHeaderRows;
import mod.industrialProcessing.gui.guide.pages.RecipeFrame;
import mod.industrialProcessing.work.recipe.IMachineRecipe;
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

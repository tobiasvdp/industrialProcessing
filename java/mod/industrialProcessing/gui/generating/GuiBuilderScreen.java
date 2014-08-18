package mod.industrialProcessing.gui.generating;

import java.util.ArrayList;

import mod.industrialProcessing.gui.containers.GuiLayoutContainer;
import mod.industrialProcessing.gui.containers.LayoutContainer;
import mod.industrialProcessing.gui.containers.ViewContainer;
import mod.industrialProcessing.gui.framework.Alignment;
import mod.industrialProcessing.gui.framework.Thickness;
import mod.industrialProcessing.gui.framework.controls.Decorator;
import mod.industrialProcessing.gui.framework.controls.IButtonClickListener;
import mod.industrialProcessing.gui.framework.controls.TextBlock;
import mod.industrialProcessing.gui.framework.panels.Orientation;
import mod.industrialProcessing.gui.framework.panels.StackPanel;
import mod.industrialProcessing.gui.generating.builderParts.DefaultInventory;
import mod.industrialProcessing.gui.generating.builderParts.InventoryReference;
import mod.industrialProcessing.gui.generating.builderParts.SlotClusterReference;
import mod.industrialProcessing.gui.guide.pages.RecipeFrame;
import mod.industrialProcessing.work.recipe.IMachineRecipe;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class GuiBuilderScreen implements IGuiBuilder {

	private String name;
	private InventoryReference inventoryRef = new InventoryReference(false);
	private ArrayList<SlotClusterReference> inputSlots = new ArrayList<SlotClusterReference>();

	public GuiBuilderScreen(String name) {
		this.name = name;
	}

	@Override
	public GuiLayoutContainer getGuiContainer(LayoutContainer container, TileEntity tileEntity) {
		
		Decorator mainDecorator = Decorator.createDecorator();

		StackPanel root = new StackPanel();
		root.verticalAlign = Alignment.CENTER;
		root.horizontalAlign = Alignment.CENTER;

		root.orientation = Orientation.HORIZONTAL;

		StackPanel flyout = new StackPanel();
		flyout.orientation = Orientation.VERTICAL;
		flyout.margin = new Thickness(0, -3, 0, 0);
		root.addChild(flyout);

		root.addChild(mainDecorator);
		
		GuiLayoutContainer guiContainer = new GuiLayoutContainer(container, root);
		
		StackPanel verticalStack = new StackPanel();
		verticalStack.orientation = Orientation.VERTICAL;
		
		TextBlock title = new TextBlock(this.name, 10);
		StackPanel titleDurabilityStack = new StackPanel();
		titleDurabilityStack.orientation = Orientation.VERTICAL;
		titleDurabilityStack.addChild(title);
		titleDurabilityStack.horizontalAlign = Alignment.MIN;
		verticalStack.addChild(titleDurabilityStack);
		
		StackPanel mainpanel = new StackPanel();
		mainpanel.horizontalAlign = Alignment.STRETCH;
		mainpanel.orientation =Orientation.HORIZONTAL;
		Decorator innerDecorator = Decorator.createExpanderDecorator(false);
		innerDecorator.horizontalAlign =Alignment.CENTER;
		innerDecorator.minHeight = 100;
		innerDecorator.maxHeight = 100;
		innerDecorator.minWidth = 300;
		innerDecorator.maxWidth = 300;
		mainpanel.addChild(innerDecorator);
		verticalStack.addChild(mainpanel);
		
		StackPanel rootStack = new StackPanel();
		rootStack.orientation = Orientation.VERTICAL;
		rootStack.addChild(verticalStack);
		verticalStack.margin = new Thickness(0, 0, 7, 0);
		DefaultInventory.setup(inventoryRef, guiContainer, rootStack);

		mainDecorator.setChild(rootStack);
		return guiContainer;
	}

	@Override
	public LayoutContainer getContainer(InventoryPlayer player, TileEntity tileEntity) {
		ViewContainer container = new ViewContainer();
		DefaultInventory.setup(this.inventoryRef, player, container);
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

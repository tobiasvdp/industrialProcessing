package mod.industrialProcessing.gui.generating;

import java.util.ArrayList;

import mod.industrialProcessing.gui.containers.CraftingContainer;
import mod.industrialProcessing.gui.containers.GuiLayoutContainer;
import mod.industrialProcessing.gui.containers.LayoutContainer;
import mod.industrialProcessing.gui.framework.Alignment;
import mod.industrialProcessing.gui.framework.Thickness;
import mod.industrialProcessing.gui.framework.controls.Decorator;
import mod.industrialProcessing.gui.framework.controls.IButtonClickListener;
import mod.industrialProcessing.gui.framework.controls.TextBlock;
import mod.industrialProcessing.gui.framework.panels.GridPanel;
import mod.industrialProcessing.gui.framework.panels.GridSize;
import mod.industrialProcessing.gui.framework.panels.LayerPanel;
import mod.industrialProcessing.gui.framework.panels.Orientation;
import mod.industrialProcessing.gui.framework.panels.SizeMode;
import mod.industrialProcessing.gui.framework.panels.StackPanel;
import mod.industrialProcessing.gui.framework.rendering.TextureReference;
import mod.industrialProcessing.gui.generating.builderParts.DefaultBurner;
import mod.industrialProcessing.gui.generating.builderParts.DefaultDurability;
import mod.industrialProcessing.gui.generating.builderParts.DefaultGauges;
import mod.industrialProcessing.gui.generating.builderParts.DefaultHeat;
import mod.industrialProcessing.gui.generating.builderParts.DefaultInventory;
import mod.industrialProcessing.gui.generating.builderParts.DefaultPower;
import mod.industrialProcessing.gui.generating.builderParts.DefaultSlots;
import mod.industrialProcessing.gui.generating.builderParts.DefaultStateConfigs;
import mod.industrialProcessing.gui.generating.builderParts.DefaultTanks;
import mod.industrialProcessing.gui.generating.builderParts.DefaultWorker;
import mod.industrialProcessing.gui.generating.builderParts.InventoryReference;
import mod.industrialProcessing.gui.generating.builderParts.SlotClusterReference;
import mod.industrialProcessing.gui.guide.pages.RecipeFrame;
import mod.industrialProcessing.work.recipe.IMachineRecipe;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class GuiBuilderCrafting implements IGuiBuilder {

	private String title;
	private final TextureReference WORKER_TEXTURE;
	private InventoryReference inventoryRef = new InventoryReference(false);
	private ArrayList<SlotClusterReference> inputSlots = new ArrayList<SlotClusterReference>();
	private ArrayList<SlotClusterReference> outputSlots = new ArrayList<SlotClusterReference>();
	private IInventory craftResult = new InventoryCraftResult();
	private int fillingSlot = -1;
	private boolean sync = true;

	public GuiBuilderCrafting(String title) {
		this.title = title;
		WORKER_TEXTURE = TextureReference.createDefault("Worker.png", 24, 32);
		outputSlots.add(new SlotClusterReference(0));
	}

	@Override
	public GuiLayoutContainer getGuiContainer(LayoutContainer container, TileEntity tileEntity) {
		Decorator root = Decorator.createDecorator();
		GuiLayoutContainer guiContainer = new GuiLayoutContainer(container, root);

		StackPanel verticalStack = new StackPanel();
		verticalStack.orientation = Orientation.VERTICAL;
		LayerPanel topPanel = new LayerPanel();

		TextBlock title = new TextBlock(this.title, 4210752);
		StackPanel titleDurabilityStack = new StackPanel();
		titleDurabilityStack.orientation = Orientation.VERTICAL;
		titleDurabilityStack.addChild(title);
		titleDurabilityStack.horizontalAlign = Alignment.MIN;
		topPanel.addChild(titleDurabilityStack);
		verticalStack.addChild(topPanel);

		GridPanel grid = new GridPanel();
		grid.rows.add(new GridSize(54, SizeMode.ABSOLUTE));
		grid.horizontalAlign = Alignment.STRETCH;
		
		
		DefaultSlots.setup(this.inputSlots, container, grid, Alignment.MIN);
		DefaultSlots.setup(this.outputSlots, container, grid, Alignment.MAX);

		if (grid.columns.size() > 0)
			verticalStack.addChild(grid);

		StackPanel rootStack = new StackPanel();
		rootStack.orientation = Orientation.VERTICAL;

		rootStack.addChild(verticalStack);
		verticalStack.margin = new Thickness(0, 0, 7, 0);
		DefaultInventory.setup(inventoryRef, guiContainer, rootStack);
		root.setChild(rootStack);
		root.verticalAlign = Alignment.CENTER;
		root.horizontalAlign = Alignment.CENTER;
		return guiContainer;
	}

	@Override
	public LayoutContainer getContainer(InventoryPlayer player, TileEntity tileEntity) {
		CraftingContainer container = new CraftingContainer(tileEntity);
		
		DefaultSlots.setup(this.inputSlots, container, tileEntity, true);
		DefaultSlots.setup(this.outputSlots, container, tileEntity, false);
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

	public GuiBuilderCrafting addInputSlotCluster(int startSlot, int count, int size, Orientation orientation) {
		this.inputSlots.add(new SlotClusterReference(startSlot, count, size, orientation));
		return this;
	}

	public GuiBuilderCrafting addInputSlot(int slot) {
		inputSlots.add(new SlotClusterReference(slot));
		return this;
	}
	
	public int getInputSlots(){
		int a = 0;
		for(int i = 0;i<inputSlots.size();i++){
			a += inputSlots.get(i).slotCount;
		}
		return a;
	}
	

	public GuiBuilderCrafting setFillingSlot(int i){
		fillingSlot = i;
		return this;
	}
	
	public int getFillingSlot(){
		return fillingSlot;
	}

}

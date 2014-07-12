package mod.industrialProcessing.gui.generating;

import java.util.ArrayList;

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
import mod.industrialProcessing.gui.generating.builderParts.BurnerReference;
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
import mod.industrialProcessing.gui.generating.builderParts.DurabilityReference;
import mod.industrialProcessing.gui.generating.builderParts.GaugeReference;
import mod.industrialProcessing.gui.generating.builderParts.HeatedReference;
import mod.industrialProcessing.gui.generating.builderParts.InventoryReference;
import mod.industrialProcessing.gui.generating.builderParts.PowerReference;
import mod.industrialProcessing.gui.generating.builderParts.SlotClusterReference;
import mod.industrialProcessing.gui.generating.builderParts.SpinnerReference;
import mod.industrialProcessing.gui.generating.builderParts.StateButtonReference;
import mod.industrialProcessing.gui.generating.builderParts.TankReference;
import mod.industrialProcessing.gui.generating.builderParts.WorkerReference;
import mod.industrialProcessing.gui.guide.pages.RecipeFrame;
import mod.industrialProcessing.work.recipe.IMachineRecipe;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class GuiBuilderDefault implements IGuiBuilder {

    private String title;
    private final TextureReference WORKER_TEXTURE;

    public GuiBuilderDefault(Class blockClass) {
        this(blockClass, blockClass.getSimpleName());
    }

    public GuiBuilderDefault(Class blockClass, String title) {
        this.WORKER_TEXTURE = TextureReference.createDefault(blockClass.getSimpleName() + ".png", 24, 32);
        this.title = title;
    }

    public GuiBuilderDefault(String title) {
        this.title = title;
        WORKER_TEXTURE = TextureReference.createDefault("Worker.png", 24, 32);
    }

    private ArrayList<SlotClusterReference> inputSlots = new ArrayList<SlotClusterReference>();
    private ArrayList<SlotClusterReference> outputSlots = new ArrayList<SlotClusterReference>();
    private ArrayList<TankReference> inputTanks = new ArrayList<TankReference>();
    private ArrayList<TankReference> outputTanks = new ArrayList<TankReference>();
    private ArrayList<SpinnerReference> spinners = new ArrayList<SpinnerReference>();
    private ArrayList<StateButtonReference> stateButtons = new ArrayList<StateButtonReference>();
    private ArrayList<GaugeReference> gauges = new ArrayList<GaugeReference>();

    private WorkerReference workerRef;
    private HeatedReference heatRef;
    private PowerReference powerRef;
    private DurabilityReference durabilityRef;
    private InventoryReference inventoryRef = new InventoryReference(false);
    private BurnerReference burnerRef;

    public GuiBuilderDefault disableInventory() {
        this.inventoryRef = null;
        return this;
    }

    public GuiBuilderDefault enableInventoryArmor() {
        if (this.inventoryRef != null)
            this.inventoryRef.showArmor = true;
        return this;
    }

    public GuiBuilderDefault enableWorker(TextureReference texture) {
        this.workerRef = new WorkerReference(texture);
        return this;
    }

    public GuiBuilderDefault enableWorker() {
        this.workerRef = new WorkerReference(WORKER_TEXTURE);
        return this;
    }

    public GuiBuilderDefault addLabeledGauge(String name, String format, int index) {
        this.gauges.add(new GaugeReference(name, format, index, true));
        return this;
    }

    public GuiBuilderDefault addGauge(String name, String format, int index) {
        this.gauges.add(new GaugeReference(name, format, index, false));
        return this;
    }

    public GuiBuilderDefault addOutputSlotCluster(int startSlot, int count, int size, Orientation orientation) {
        this.outputSlots.add(new SlotClusterReference(startSlot, count, size, orientation));
        return this;
    }

    public GuiBuilderDefault addInputSlotCluster(int startSlot, int count, int size, Orientation orientation) {
        this.inputSlots.add(new SlotClusterReference(startSlot, count, size, orientation));
        return this;
    }

    public GuiBuilderDefault addStateButton(int slot, TextureReference texture, int rows, int columns) {
        this.stateButtons.add(new StateButtonReference(slot, texture, rows, columns, null));
        return this;
    }

    public GuiBuilderDefault addStateButton(int slot, TextureReference texture, int rows, int columns, String... names) {
        this.stateButtons.add(new StateButtonReference(slot, texture, rows, columns, names));
        return this;
    }

    public GuiBuilderDefault addSpinner(int slot, String format, float scale, float width) {
        this.spinners.add(new SpinnerReference(slot, format, scale, width));
        return this;
    }

    public GuiBuilderDefault addSpinner(int slot, String format, float scale) {
        this.spinners.add(new SpinnerReference(slot, format, scale, 18f));
        return this;
    }

    public GuiBuilderDefault addSpinner(int slot) {
        this.spinners.add(new SpinnerReference(slot));
        return this;
    }

    public GuiBuilderDefault enablePower(int batterySlot) {
        this.powerRef = new PowerReference(batterySlot);
        return this;
    }

    public GuiBuilderDefault enablePower() {
        this.powerRef = new PowerReference();
        return this;
    }

    public GuiBuilderDefault enableDurability() {
        this.durabilityRef = new DurabilityReference();
        return this;
    }

    public GuiBuilderDefault enableThermometer() {
        this.heatRef = new HeatedReference();
        return this;
    }

    public GuiBuilderDefault addOutputTank(int tankSlot, int inputSlot, int outputSlot) {
        outputTanks.add(new TankReference(tankSlot, inputSlot, outputSlot));
        return this;
    }

    public GuiBuilderDefault addInputTank(int tankSlot, int inputSlot, int outputSlot) {
        inputTanks.add(new TankReference(tankSlot, inputSlot, outputSlot));
        return this;
    }

    public GuiBuilderDefault addOutputTank(int tankSlot) {
        outputTanks.add(new TankReference(tankSlot));
        return this;
    }

    public GuiBuilderDefault addInputTank(int tankSlot) {
        inputTanks.add(new TankReference(tankSlot));
        return this;
    }

    public GuiBuilderDefault addOutputSlot(int slot) {
        outputSlots.add(new SlotClusterReference(slot));
        return this;
    }

    public GuiBuilderDefault addInputSlot(int slot) {
        inputSlots.add(new SlotClusterReference(slot));
        return this;
    }

    @Override
    public GuiLayoutContainer getGuiContainer(LayoutContainer container, TileEntity tileEntity) {
        Decorator root = Decorator.createDecorator();
        GuiLayoutContainer guiContainer = new GuiLayoutContainer(container, root);

        StackPanel verticalStack = new StackPanel();
        verticalStack.orientation = Orientation.VERTICAL;
        LayerPanel topPanel = new LayerPanel();
        DefaultPower.setup(powerRef, guiContainer, topPanel, Alignment.MAX);

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

        DefaultBurner.setup(this.burnerRef, guiContainer, tileEntity, grid, Alignment.MIN);
        DefaultDurability.setup(durabilityRef, guiContainer, titleDurabilityStack);
        DefaultHeat.setup(heatRef, guiContainer, grid, Alignment.MIN);
        DefaultGauges.setup(this.gauges, guiContainer, container, grid, Alignment.CENTER);
        DefaultTanks.setup(this.inputTanks, guiContainer, container, grid, Alignment.MIN);
        DefaultSlots.setup(this.inputSlots, container, grid, Alignment.MIN);
        DefaultWorker.setup(workerRef, guiContainer, grid, Alignment.CENTER);
        DefaultSlots.setup(this.outputSlots, container, grid, Alignment.MAX);
        DefaultTanks.setup(this.outputTanks, guiContainer, container, grid, Alignment.MAX);

        if (grid.columns.size() > 0)
            verticalStack.addChild(grid);

        if (!spinners.isEmpty() || !stateButtons.isEmpty()) {
            StackPanel stateStack = new StackPanel();
            stateStack.orientation = Orientation.HORIZONTAL;
            DefaultStateConfigs.setupSpinners(this.spinners, guiContainer, stateStack, tileEntity);
            DefaultStateConfigs.setupButtons(this.stateButtons, guiContainer, stateStack, tileEntity);
            verticalStack.addChild(stateStack);
        }
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

        LayoutContainer container = new LayoutContainer();
        DefaultDurability.setup(this.durabilityRef, container, tileEntity);
        DefaultBurner.setup(this.burnerRef, container, tileEntity);
        DefaultTanks.setup(this.inputTanks, container, tileEntity);
        DefaultTanks.setup(this.outputTanks, container, tileEntity);
        DefaultSlots.setup(this.inputSlots, container, tileEntity, true);
        DefaultSlots.setup(this.outputSlots, container, tileEntity, false);
        DefaultGauges.setup(this.gauges, container, tileEntity);
        DefaultPower.setup(this.powerRef, container, tileEntity);
        DefaultHeat.setup(this.heatRef, container, tileEntity);
        DefaultWorker.setup(this.workerRef, container, tileEntity);

        DefaultStateConfigs.setupSpinners(this.spinners, container, tileEntity);
        DefaultStateConfigs.setupButtons(this.stateButtons, container, tileEntity);
        DefaultInventory.setup(this.inventoryRef, player, container);

        return container;
    }

    @Override
    public RecipeFrame getRecipePage(IMachineRecipe recipe, IButtonClickListener<ItemStack> stackClickListener) {
        StackPanel stackPanel = new StackPanel();
        stackPanel.orientation = Orientation.VERTICAL;
        DefaultPower.setup(powerRef, recipe, stackPanel);

        GridPanel grid = new GridPanel();
        grid.rows.add(new GridSize(54, SizeMode.ABSOLUTE));
        DefaultHeat.setup(this.heatRef, recipe, grid, Alignment.MIN);

        int maxTankAmount = Math.max(DefaultTanks.getMaxAmount(recipe.getInventoryInputs()), DefaultTanks.getMaxAmount(recipe.getInventoryOutputs()));

        DefaultSlots.setup(this.inputSlots, recipe.getInventoryInputs(), grid, Alignment.MIN, stackClickListener);
        DefaultTanks.setup(this.inputTanks, recipe.getInventoryInputs(), maxTankAmount, grid, Alignment.MIN);
        DefaultWorker.setup(this.workerRef, recipe, grid, Alignment.CENTER);
        DefaultTanks.setup(this.outputTanks, recipe.getInventoryOutputs(), maxTankAmount, grid, Alignment.MAX);
        DefaultSlots.setup(this.outputSlots, recipe.getInventoryOutputs(), grid, Alignment.MAX, stackClickListener);
        stackPanel.addChild(grid);
        return new RecipeFrame(stackPanel, this.title);
    }

    @Override
    public RecipeFrame getRecipePage(IMachineRecipe recipe) {
        return getRecipePage(recipe, null);
    }

    public GuiBuilderDefault enableBurner(int lighterSlot, int fuelSlot, int ashSlot) {
        this.burnerRef = new BurnerReference(lighterSlot, fuelSlot, ashSlot);
        return this;
    }

}

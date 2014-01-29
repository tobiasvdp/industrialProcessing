package ip.industrialProcessing.gui3.generating;

import ip.industrialProcessing.gui3.binding.Binder;
import ip.industrialProcessing.gui3.binding.IProgressBinding;
import ip.industrialProcessing.gui3.binding.ITankBinding;
import ip.industrialProcessing.gui3.containers.GuiLayoutContainer;
import ip.industrialProcessing.gui3.containers.LayoutContainer;
import ip.industrialProcessing.gui3.containers.handlers.HeatedHandler;
import ip.industrialProcessing.gui3.containers.handlers.PowerHandler;
import ip.industrialProcessing.gui3.containers.handlers.StateHandler;
import ip.industrialProcessing.gui3.containers.handlers.TankHandler;
import ip.industrialProcessing.gui3.containers.handlers.WorkHandler;
import ip.industrialProcessing.gui3.framework.Alignment;
import ip.industrialProcessing.gui3.framework.Thickness;
import ip.industrialProcessing.gui3.framework.controls.Control;
import ip.industrialProcessing.gui3.framework.controls.Decorator;
import ip.industrialProcessing.gui3.framework.controls.ProgressBar;
import ip.industrialProcessing.gui3.framework.controls.SlotControl;
import ip.industrialProcessing.gui3.framework.controls.TankControl;
import ip.industrialProcessing.gui3.framework.controls.TextBlock;
import ip.industrialProcessing.gui3.framework.custom.NumericSpinner;
import ip.industrialProcessing.gui3.framework.custom.PlayerInventory;
import ip.industrialProcessing.gui3.framework.custom.PowerControl;
import ip.industrialProcessing.gui3.framework.custom.SlotGrid;
import ip.industrialProcessing.gui3.framework.custom.StateButton;
import ip.industrialProcessing.gui3.framework.custom.TankWithSlotsControl;
import ip.industrialProcessing.gui3.framework.panels.GridCell;
import ip.industrialProcessing.gui3.framework.panels.GridPanel;
import ip.industrialProcessing.gui3.framework.panels.GridSize;
import ip.industrialProcessing.gui3.framework.panels.LayerPanel;
import ip.industrialProcessing.gui3.framework.panels.Orientation;
import ip.industrialProcessing.gui3.framework.panels.SizeMode;
import ip.industrialProcessing.gui3.framework.panels.StackPanel;
import ip.industrialProcessing.gui3.framework.rendering.TextureReference;
import ip.industrialProcessing.machines.containers.IFluidMachineContainerEntity;
import ip.industrialProcessing.power.IPoweredMachine;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.slots.SlotLiquid;
import ip.industrialProcessing.slots.SlotLiquidOutput;
import ip.industrialProcessing.slots.SlotOutput;
import ip.industrialProcessing.utils.containers.ContainerUtils;
import ip.industrialProcessing.utils.handler.heat.IHeated;
import ip.industrialProcessing.utils.handler.numbers.IStateConfig;
import ip.industrialProcessing.utils.working.IWorkingEntity;

import java.util.ArrayList;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.tileentity.TileEntity;

public class DefaultGuiBuilder implements IGuiBuilder {

    ArrayList<SlotClusterReference> inputSlots = new ArrayList<SlotClusterReference>();
    ArrayList<SlotClusterReference> outputSlots = new ArrayList<SlotClusterReference>();
    ArrayList<TankReference> inputTanks = new ArrayList<TankReference>();
    ArrayList<TankReference> outputTanks = new ArrayList<TankReference>();
    ArrayList<SpinnerReference> spinners = new ArrayList<SpinnerReference>();
    ArrayList<StateButtonReference> stateButtons = new ArrayList<StateButtonReference>();

    private boolean hasHeat = false;
    private boolean hasBurner = false;
    private boolean hasWorker = false;
    private TextureReference workerTexture = null;

    private boolean hasPlayerInventory = true;
    private int powerSlot = -1;
    private boolean hasPower = false;
    private boolean hasDurability = false;
    private int powerContainerSlot;
    private int inventoryStartSlot;
    private int powerHandlerSlot;
    private int heatHandlerSlot;
    private int workerHandler;

    public DefaultGuiBuilder enableWorker(TextureReference texture) {
	this.hasWorker = true;
	this.workerTexture = texture;
	return this;
    }

    public DefaultGuiBuilder addOutputSlotCluster(int startSlot, int count, int size, Orientation orientation) {
	this.outputSlots.add(new SlotClusterReference(startSlot, count, size, orientation));
	return this;
    }

    public DefaultGuiBuilder addInputSlotCluster(int startSlot, int count, int size, Orientation orientation) {
	this.inputSlots.add(new SlotClusterReference(startSlot, count, size, orientation));
	return this;
    }

    public DefaultGuiBuilder addStateButton(int slot, TextureReference texture, int rows, int columns) {
	this.stateButtons.add(new StateButtonReference(slot, texture, rows, columns, null));
	return this;
    }
    public DefaultGuiBuilder addStateButton(int slot, TextureReference texture, int rows, int columns, String[] names) {
	this.stateButtons.add(new StateButtonReference(slot, texture, rows, columns, names));
	return this;
    }

    public DefaultGuiBuilder addSpinner(int slot, String format, float scale, float width) {
	this.spinners.add(new SpinnerReference(slot, format, scale, width));
	return this;
    }

    public DefaultGuiBuilder addSpinner(int slot, String format, float scale) {
	this.spinners.add(new SpinnerReference(slot, format, scale, 18f));
	return this;
    }

    public DefaultGuiBuilder addSpinner(int slot) {
	this.spinners.add(new SpinnerReference(slot));
	return this;
    }

    public DefaultGuiBuilder enableDurability() {
	this.hasDurability = true;
	return this;
    }

    public DefaultGuiBuilder enablePower(int batterySlot) {
	this.powerSlot = batterySlot;
	this.hasPower = true;
	return this;
    }

    public DefaultGuiBuilder enablePower() {
	this.hasPower = true;
	return this;
    }

    public DefaultGuiBuilder enableThermometer() {
	this.hasHeat = true;
	return this;
    }

    public DefaultGuiBuilder addOutputTank(int tankSlot, int inputSlot, int outputSlot) {
	outputTanks.add(new TankReference(tankSlot, inputSlot, outputSlot));
	return this;
    }

    public DefaultGuiBuilder addInputTank(int tankSlot, int inputSlot, int outputSlot) {
	inputTanks.add(new TankReference(tankSlot, inputSlot, outputSlot));
	return this;
    }

    public DefaultGuiBuilder addOutputTank(int tankSlot) {
	outputTanks.add(new TankReference(tankSlot));
	return this;
    }

    public DefaultGuiBuilder addInputTank(int tankSlot) {
	inputTanks.add(new TankReference(tankSlot));
	return this;
    }

    public DefaultGuiBuilder addOutputSlot(int slot) {
	outputSlots.add(new SlotClusterReference(slot));
	return this;
    }

    public DefaultGuiBuilder addInputSlot(int slot) {
	inputSlots.add(new SlotClusterReference(slot));
	return this;
    }

    public DefaultGuiBuilder setHasPlayerInventory(boolean value) {
	this.hasPlayerInventory = value;
	return this;
    }

    public boolean hasPlayerInventory() {
	return hasPlayerInventory;
    }

    @Override
    public GuiLayoutContainer getGuiContainer(LayoutContainer container) {
	Decorator root = Decorator.createDecorator();
	GuiLayoutContainer guiContainer = new GuiLayoutContainer(container, root);

	StackPanel verticalStack = new StackPanel();
	verticalStack.orientation = Orientation.VERTICAL;
	LayerPanel topPanel = new LayerPanel();
	if (hasPower) {
	    Control control;
	    Binder binder;
	    PowerHandler powerHandler = (PowerHandler)container.getHandler(this.powerHandlerSlot);
	    if (powerSlot >= 0) {
		PowerControl powerControl = PowerControl.createPowerWithSlots(container.getSlot(powerContainerSlot));
		control = powerControl;
		binder = new Binder<IProgressBinding>(powerHandler, powerControl);
	    } else {
		ProgressBar powerControl = ProgressBar.createHorizontal1();
		control = powerControl;
		binder = new Binder<IProgressBinding>(powerHandler, powerControl);
	    }
	    guiContainer.addBinding(binder);
	    control.horizontalAlign = Alignment.MAX;
	    control.verticalAlign = Alignment.MIN;
	    topPanel.addChild(control);
	}

	TextBlock title = new TextBlock("Some machine", 4210752);
	if (hasDurability) {
	    StackPanel titleDurabilityStack = new StackPanel();
	    titleDurabilityStack.orientation = Orientation.VERTICAL;
	    titleDurabilityStack.addChild(title);
	    ProgressBar durabilityProgress = ProgressBar.createHorizontal1();
	    durabilityProgress.horizontalAlign = Alignment.MIN;
	    titleDurabilityStack.addChild(durabilityProgress);
	    topPanel.addChild(titleDurabilityStack);
	    titleDurabilityStack.margin = new Thickness(0, 0, 7, 0);
	} else {
	    topPanel.addChild(title);
	}
	verticalStack.addChild(topPanel);

	GridPanel grid = new GridPanel();
	grid.rows.add(new GridSize(54, SizeMode.ABSOLUTE));
	grid.horizontalAlign = Alignment.STRETCH;
	if (hasHeat) { 
	    HeatedHandler heatHandler = (HeatedHandler)container.getHandler(this.heatHandlerSlot);
	    ProgressBar thermometer = ProgressBar.createTemperature();
	    Binder binder = new Binder<IProgressBinding>(heatHandler, thermometer);
	    guiContainer.addBinding(binder);
	    thermometer.horizontalAlign = Alignment.MIN;
	    grid.children.add(new GridCell(0, grid.columns.size(), thermometer));
	    grid.columns.add(new GridSize(1, SizeMode.RELATIVE));
	}
	setupTanks(this.inputTanks, guiContainer, container, grid, Alignment.MIN);
	setupSlots(this.inputSlots, container, grid, Alignment.MIN);
	if (hasWorker) {
	    ProgressBar workBar = ProgressBar.createWorker(this.workerTexture);
	    WorkHandler workHandler = (WorkHandler) container.getHandler(this.workerHandler);
	    Binder binder = new Binder<IProgressBinding>(workHandler, workBar);
	    guiContainer.addBinding(binder);
	    workBar.horizontalAlign = Alignment.CENTER;
	    grid.children.add(new GridCell(0, grid.columns.size(), workBar));
	    grid.columns.add(new GridSize(1, SizeMode.RELATIVE));
	}
	setupSlots(this.outputSlots, container, grid, Alignment.MAX);
	setupTanks(this.outputTanks, guiContainer, container, grid, Alignment.MAX);
	if (grid.columns.size() > 0)
	    verticalStack.addChild(grid);

	if (!spinners.isEmpty() || stateButtons.isEmpty()) {
	    StackPanel stateStack = new StackPanel();
	    stateStack.orientation = Orientation.HORIZONTAL;
	    for (SpinnerReference spinnerRef : this.spinners) {
		NumericSpinner spinner = NumericSpinner.createSpinner(spinnerRef.format, spinnerRef.scale, spinnerRef.width);
		stateStack.addChild(spinner);
	    }
	    for (StateButtonReference stateRef : this.stateButtons) {
		StateButton button = new StateButton(stateRef.texture, stateRef.rows, stateRef.columns, stateRef.names);
		stateStack.addChild(button);
	    }
	    verticalStack.addChild(stateStack);
	}
	StackPanel rootStack = new StackPanel();
	rootStack.orientation = Orientation.VERTICAL;

	rootStack.addChild(verticalStack);
	verticalStack.margin = new Thickness(0, 0, 7, 0);
	if (hasPlayerInventory) {
	    rootStack.addChild(PlayerInventory.createInventory(container, inventoryStartSlot));
	}
	root.setChild(rootStack);
	root.verticalAlign = Alignment.CENTER;
	root.horizontalAlign = Alignment.CENTER;
	return guiContainer;
    }

    private void setupTanks(ArrayList<TankReference> tankRefs, GuiLayoutContainer guiContainer, LayoutContainer container, GridPanel grid, Alignment max) {
	for (TankReference tank : tankRefs) {
	    TankHandler handler = (TankHandler) container.getHandler(tank.handlerIndex);
	    Binder binder;
	    Control control;
	    int size;
	    if (tank.inputSlot >= 0 && tank.outputSlot >= 0) {
		TankWithSlotsControl tankControl = TankWithSlotsControl.createTankWithSlots(container.getSlot(tank.inputContainerSlot), container.getSlot(tank.outputContainerSlot));
		control = tankControl;
		binder = new Binder<ITankBinding>(handler, tankControl);
		size = 2;
	    } else {
		TankControl tankControl = TankControl.createTank();
		control = tankControl;
		binder = new Binder<ITankBinding>(handler, tankControl);
		size = 1;
	    }
	    guiContainer.addBinding(binder);
	    control.horizontalAlign = max;
	    grid.children.add(new GridCell(0, grid.columns.size(), control));
	    grid.columns.add(new GridSize(size, SizeMode.RELATIVE));
	}
    }

    private void setupSlots(ArrayList<SlotClusterReference> slotRefs, LayoutContainer container, GridPanel grid, Alignment max) {

	for (SlotClusterReference slot : slotRefs) {
	    if (slot.slotCount == 1) {
		SlotControl slotControl = SlotControl.createSlot(container.getSlot(slot.containerStartSlot));
		slotControl.horizontalAlign = max;
		slotControl.verticalAlign = Alignment.CENTER;
		grid.children.add(new GridCell(0, grid.columns.size(), slotControl));
		grid.columns.add(new GridSize(1, SizeMode.RELATIVE));
	    } else {
		Slot[] slots = new Slot[slot.slotCount];
		for (int i = 0; i < slots.length; i++) {
		    slots[i] = container.getSlot(slot.containerStartSlot + i);
		}
		SlotGrid slotGrid = SlotGrid.createSlotGrid(slots, slot.size, slot.orientation);
		slotGrid.horizontalAlign = max;
		slotGrid.verticalAlign = Alignment.CENTER;
		grid.children.add(new GridCell(0, grid.columns.size(), slotGrid));
		grid.columns.add(new GridSize((slots.length - 1) / slot.size + 1, SizeMode.RELATIVE));
	    }
	}
    }

    @Override
    public LayoutContainer getContainer(InventoryPlayer player, TileEntity tileEntity) {
	IInventory inventory = null;
	IFluidMachineContainerEntity tankEntity = null;
	if (tileEntity instanceof IInventory)
	    inventory = (IInventory) tileEntity;
	if (tileEntity instanceof IFluidMachineContainerEntity)
	    tankEntity = (IFluidMachineContainerEntity) tileEntity;
	LayoutContainer container = new LayoutContainer();
	setupContainerTanks(this.inputTanks, container, tankEntity, inventory);
	setupContainerTanks(this.outputTanks, container, tankEntity, inventory);
	setupSlots(this.inputSlots, container, inventory, true);
	setupSlots(this.outputSlots, container, inventory, false);
	if (hasPower) {
	    IPoweredMachine machine = null;
	    if (tileEntity instanceof IPoweredMachine)
		machine = (IPoweredMachine) tileEntity;
	    setupPower(container, inventory, machine);
	}
	if (hasHeat) {
	    IHeated heated = null;
	    if (tileEntity instanceof IHeated)
		heated = (IHeated) tileEntity;
	    if (heated == null)
		throw new NullPointerException("Heat without IHeated?!");
	    this.heatHandlerSlot = container.addHandler(new HeatedHandler(heated));
	}

	if (hasWorker) {
	    IWorkingEntity workingEntity = null;
	    if (tileEntity instanceof IWorkingEntity)
		workingEntity = (IWorkingEntity) tileEntity;
	    if (workingEntity == null)
		throw new NullPointerException("Work without IWorkingEntity?!");
	    this.workerHandler = container.addHandler(new WorkHandler(workingEntity));
	}
	if (!this.stateButtons.isEmpty() || !this.spinners.isEmpty()) {
	    IStateConfig stateEntity = null;
	    if (tileEntity instanceof IStateConfig)
		stateEntity = (IStateConfig) tileEntity;
	    setupIStateConfigs(this.stateButtons, this.spinners, container, stateEntity);
	}
	this.inventoryStartSlot = container.inventorySlots.size();
	if (hasPlayerInventory) {
	    ContainerUtils.BindPlayerInventory(player, container, 0);
	    ContainerUtils.BindPlayerArmor(player, container, 0);
	}
	return container;
    }

    private void setupIStateConfigs(ArrayList<StateButtonReference> stateButtonsRefs, ArrayList<SpinnerReference> spinnerRefs, LayoutContainer container, IStateConfig stateEntity) {
	for (SpinnerReference spinnerReference : spinnerRefs) {
	    spinnerReference.handlerIndex = container.addHandler(new StateHandler(spinnerReference.slot, stateEntity));
	}
	for (StateButtonReference stateButtonReference : stateButtonsRefs) {
	    stateButtonReference.handlerIndex = container.addHandler(new StateHandler(stateButtonReference.slot, stateEntity));
	}
    }

    private void setupPower(LayoutContainer container, IInventory inventory, IPoweredMachine machine) {
	if (machine == null)
	    throw new NullPointerException("Power without IPoweredMachine?!");
	if (powerSlot >= 0) {
	    if (inventory == null)
		throw new NullPointerException("Slots without IInventory?!");
	    this.powerContainerSlot = container.inventorySlots.size();
	    container.containerAddSlot(new SlotBase(inventory, powerSlot, 0, 0));
	}
	this.powerHandlerSlot = container.addHandler(new PowerHandler(machine));
    }

    private void setupSlots(ArrayList<SlotClusterReference> slots, LayoutContainer container, IInventory inventory, boolean input) {
	if (inventory == null)
	    throw new NullPointerException("Slots without IInventory?!");
	for (SlotClusterReference slotRef : slots) {
	    int index = container.inventorySlots.size();
	    slotRef.containerStartSlot = index;
	    for (int i = slotRef.startSlot; i < slotRef.slotCount; i++) {
		Slot slot = input ? new SlotBase(inventory, i, 0, 0) : new SlotOutput(inventory, i, 0, 0);
		container.containerAddSlot(slot);
	    }
	}
    }

    private void setupContainerTanks(ArrayList<TankReference> tanks, LayoutContainer container, IFluidMachineContainerEntity entity, IInventory inventory) {
	if (entity == null)
	    throw new NullPointerException("Slots without IInventory?!");
	for (TankReference tank : tanks) {
	    tank.handlerIndex = container.addHandler(new TankHandler(tank.tankSlot, entity));
	    if (tank.inputSlot >= 0 && tank.outputSlot >= 0) {
		if (inventory == null)
		    throw new NullPointerException("Slots without IInventory?!");
		tank.inputContainerSlot = container.inventorySlots.size();
		tank.outputContainerSlot = tank.inputContainerSlot + 1;
		container.containerAddSlot(new SlotLiquid(inventory, tank.inputSlot, 0, 0));
		container.containerAddSlot(new SlotLiquidOutput(inventory, tank.outputSlot, 0, 0));
	    }
	}
    }
}

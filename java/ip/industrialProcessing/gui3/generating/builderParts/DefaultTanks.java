package ip.industrialProcessing.gui3.generating.builderParts;

import ip.industrialProcessing.gui3.binding.Binder;
import ip.industrialProcessing.gui3.binding.ITankBinding;
import ip.industrialProcessing.gui3.containers.GuiLayoutContainer;
import ip.industrialProcessing.gui3.containers.LayoutContainer;
import ip.industrialProcessing.gui3.containers.handlers.TankHandler;
import ip.industrialProcessing.gui3.framework.Alignment;
import ip.industrialProcessing.gui3.framework.controls.Control;
import ip.industrialProcessing.gui3.framework.controls.TankControl;
import ip.industrialProcessing.gui3.framework.custom.TankWithSlotsControl;
import ip.industrialProcessing.gui3.framework.panels.GridCell;
import ip.industrialProcessing.gui3.framework.panels.GridPanel;
import ip.industrialProcessing.gui3.framework.panels.GridSize;
import ip.industrialProcessing.gui3.framework.panels.SizeMode;
import ip.industrialProcessing.machines.containers.IFluidMachineContainerEntity;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;
import ip.industrialProcessing.slots.SlotLiquid;
import ip.industrialProcessing.slots.SlotLiquidOutput;

import java.util.ArrayList;

import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class DefaultTanks {
    public static void setup(ArrayList<TankReference> tankRefs, GuiLayoutContainer guiContainer, LayoutContainer container, GridPanel grid, Alignment max) {
	for (TankReference tank : tankRefs) {
	    Binder binder;
	    Control control;
	    int size;
	    if (tank.inputSlot >= 0 && tank.outputSlot >= 0) {
		TankWithSlotsControl tankControl = TankWithSlotsControl.createTankWithSlots(tank.inputContainerSlot, tank.outputContainerSlot);
		control = tankControl;
		binder = new Binder<ITankBinding>(tank.handler, tankControl);
		size = 2;
	    } else {
		TankControl tankControl = TankControl.createTank();
		control = tankControl;
		binder = new Binder<ITankBinding>(tank.handler, tankControl);
		size = 1;
	    }
	    guiContainer.addBinding(binder);
	    control.horizontalAlign = max;
	    grid.children.add(new GridCell(0, grid.columns.size(), control));
	    grid.columns.add(new GridSize(size, SizeMode.RELATIVE));
	}
    }

    public static void setup(ArrayList<TankReference> tanks, LayoutContainer container, TileEntity entity) {
	if (!tanks.isEmpty()) {
	    IFluidMachineContainerEntity machine = getFluidMachine(entity);
	    for (TankReference tank : tanks) {
		container.addHandler(tank.handler = new TankHandler(tank.tankSlot, machine));
		if (tank.inputSlot >= 0 && tank.outputSlot >= 0) {
		    IInventory inventory = getInventory(entity);
		    container.containerAddSlot(tank.inputContainerSlot = new SlotLiquid(inventory, tank.inputSlot, 0, 0));
		    container.containerAddSlot(tank.outputContainerSlot = new SlotLiquidOutput(inventory, tank.outputSlot, 0, 0));
		}
	    }
	}
    }

    private static IFluidMachineContainerEntity getFluidMachine(TileEntity tileEntity) {
	IFluidMachineContainerEntity inventory = null;
	if (tileEntity instanceof IFluidMachineContainerEntity)
	    inventory = (IFluidMachineContainerEntity) tileEntity;
	if (inventory == null)
	    throw new NullPointerException("Tanks without IFluidMachineContainerEntity?!");
	return inventory;
    }

    private static IInventory getInventory(TileEntity tileEntity) {
	IInventory inventory = null;
	if (tileEntity instanceof IInventory)
	    inventory = (IInventory) tileEntity;
	if (inventory == null)
	    throw new NullPointerException("Slots without IInventory?!");
	return inventory;
    }

    public static void setup(ArrayList<TankReference> tankRefs, RecipeSlot[] slots, int maxAmount, GridPanel grid, Alignment min) {
	for (TankReference tank : tankRefs) {
	    TankControl tankControl = TankControl.createTank();
	    // TODO: get min and max for output
	    FluidStack stack = getStack(slots, tank.tankSlot);
	    tankControl.horizontalAlign = min;
	    if (stack != null) {
		tankControl.setCapacity(maxAmount);
		tankControl.setFluidAmount(stack.amount);
		tankControl.setFluidID(stack.fluidID);
	    } else {
		tankControl.setCapacity(0);
		tankControl.setFluidAmount(0);
		tankControl.setFluidID(-1);
	    }
	    grid.children.add(new GridCell(0, grid.columns.size(), tankControl));
	    grid.columns.add(new GridSize(1, SizeMode.RELATIVE));
	}
    }

    private static FluidStack getStack(RecipeSlot[] slots, int tankSlot) {
	for (int i = 0; i < slots.length; i++) {
	    RecipeSlot slot = slots[i];
	    if (slot.index == tankSlot && slot.type == RecipeSlotType.TANK) {
		int amount = getAmount(slot);
		return new FluidStack(FluidRegistry.getFluid(slot.itemId), amount);
	    }
	}
	return null;
    }

    private static int getAmount(RecipeSlot slot) {
	if (slot instanceof RecipeInputSlot) {
	    RecipeInputSlot inputSlot = (RecipeInputSlot) slot;
	    return inputSlot.amount;
	} else if (slot instanceof RecipeOutputSlot) {
	    RecipeOutputSlot inputSlot = (RecipeOutputSlot) slot;
	    return inputSlot.maxAmount;
	}
	return 0;
    }

    public static int getMaxAmount(RecipeSlot[] outputs) {
	int max = 0;
	for (int i = 0; i < outputs.length; i++) {
	    int amount = getAmount(outputs[i]);
	    if (amount > max)
		max = amount;
	}
	return max;
    }
}

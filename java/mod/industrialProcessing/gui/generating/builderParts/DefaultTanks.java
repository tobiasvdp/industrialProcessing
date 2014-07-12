package mod.industrialProcessing.gui.generating.builderParts;

import java.util.ArrayList;

import mod.industrialProcessing.fluids.IFluidInfo;
import mod.industrialProcessing.gui.binding.Binder;
import mod.industrialProcessing.gui.binding.ITankBinding;
import mod.industrialProcessing.gui.containers.GuiLayoutContainer;
import mod.industrialProcessing.gui.containers.LayoutContainer;
import mod.industrialProcessing.gui.containers.handlers.TankHandler;
import mod.industrialProcessing.gui.framework.Alignment;
import mod.industrialProcessing.gui.framework.controls.Control;
import mod.industrialProcessing.gui.framework.controls.TankControl;
import mod.industrialProcessing.gui.framework.custom.TankWithSlotsControl;
import mod.industrialProcessing.gui.framework.panels.GridCell;
import mod.industrialProcessing.gui.framework.panels.GridPanel;
import mod.industrialProcessing.gui.framework.panels.GridSize;
import mod.industrialProcessing.gui.framework.panels.SizeMode;
import mod.industrialProcessing.gui.framework.slots.SlotLiquid;
import mod.industrialProcessing.gui.framework.slots.SlotLiquidOutput;
import mod.industrialProcessing.work.recipe.slots.RecipeInputInventorySlot;
import mod.industrialProcessing.work.recipe.slots.RecipeOutputInventorySlot;
import mod.industrialProcessing.work.recipe.slots.RecipeSlot;
import mod.industrialProcessing.work.recipe.slots.RecipeSlotType;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
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
			IFluidInfo machine = getFluidMachine(entity);
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

	private static IFluidInfo getFluidMachine(TileEntity tileEntity) {
		IFluidInfo inventory = null;
		if (tileEntity instanceof IFluidInfo)
			inventory = (IFluidInfo) tileEntity;
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
				int amount = slot.getMaxAmount();
				return new FluidStack(slot.fluid, amount);
			}
		}
		return null;
	}
 

	public static int getMaxAmount(RecipeSlot[] outputs) {
		int max = 0;
		for (int i = 0; i < outputs.length; i++) {
			int amount = outputs[i].getMaxAmount();
			if (amount > max)
				max = amount;
		}
		return max;
	}
}

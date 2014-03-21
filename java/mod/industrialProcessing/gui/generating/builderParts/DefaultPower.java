package mod.industrialProcessing.gui.generating.builderParts;

import mod.industrialProcessing.gui.binding.Binder;
import mod.industrialProcessing.gui.binding.IProgressBinding;
import mod.industrialProcessing.gui.containers.GuiLayoutContainer;
import mod.industrialProcessing.gui.containers.LayoutContainer;
import mod.industrialProcessing.gui.containers.handlers.PowerHandler;
import mod.industrialProcessing.gui.framework.Alignment;
import mod.industrialProcessing.gui.framework.controls.Control;
import mod.industrialProcessing.gui.framework.controls.ProgressBar;
import mod.industrialProcessing.gui.framework.custom.PowerControl;
import mod.industrialProcessing.gui.framework.panels.LayerPanel;
import mod.industrialProcessing.gui.framework.panels.StackPanel;
import mod.industrialProcessing.gui.framework.slots.SlotBase;
import mod.industrialProcessing.power.network.IPoweredMachine;
import mod.industrialProcessing.work.recipe.IMachineRecipe;
import mod.industrialProcessing.work.recipe.IPowerRecipe;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;

public class DefaultPower {
	public static void setup(PowerReference powerRef, LayoutContainer container, TileEntity entity) {
		if (powerRef != null) {
			IPoweredMachine machine = getMachine(entity);
			IInventory inventory = getInventory(entity);
			if (powerRef.index >= 0) {
				if (inventory == null)
					throw new NullPointerException("Slots without IInventory?!");
				container.containerAddSlot(powerRef.slot = new SlotBase(inventory, powerRef.index, 0, 0));
			}
			container.addHandler(powerRef.powerHandler = new PowerHandler(machine));
		}
	}

	public static IInventory getInventory(TileEntity tileEntity) {
		IInventory machine = null;
		if (tileEntity instanceof IInventory)
			machine = (IInventory) tileEntity;
		if (machine == null)
			throw new NullPointerException("Slot without IInventory?!");
		return machine;
	}

	public static IPoweredMachine getMachine(TileEntity tileEntity) {
		IPoweredMachine machine = null;
		if (tileEntity instanceof IPoweredMachine)
			machine = (IPoweredMachine) tileEntity;
		if (machine == null)
			throw new NullPointerException("Power without IPoweredMachine?!");
		return machine;
	}

	public static void setup(PowerReference powerRef, GuiLayoutContainer guiContainer, LayerPanel topPanel, Alignment max) {
		if (powerRef != null) {
			Control control;
			Binder binder;
			if (powerRef.index >= 0) {
				PowerControl powerControl = PowerControl.createPowerWithSlots(powerRef.slot);
				control = powerControl;
				binder = new Binder<IProgressBinding>(powerRef.powerHandler, powerControl);
			} else {
				ProgressBar powerControl = ProgressBar.createHorizontal1();
				powerControl.tooltip = "%.0fJoules";
				control = powerControl;
				binder = new Binder<IProgressBinding>(powerRef.powerHandler, powerControl);
			}
			guiContainer.addBinding(binder);
			control.horizontalAlign = max;
			control.verticalAlign = Alignment.MIN;
			topPanel.addChild(control);
		}
	}

	public static void setup(PowerReference powerRef, IMachineRecipe recipe, StackPanel stackPanel) {
		int powerRequired = getPowerRequired(recipe);

		if (powerRef != null && powerRequired > 0) {
			ProgressBar powerControl = ProgressBar.createHorizontal1();
			powerControl.tooltip = "%.0fJoules";
			powerControl.horizontalAlign = Alignment.MAX;
			powerControl.value = powerRequired * recipe.getWorkRequired();
			powerControl.maxValue = powerRequired * recipe.getWorkRequired();
			stackPanel.addChild(powerControl);
		}
	}

	private static int getPowerRequired(IMachineRecipe recipe) {
		if (recipe instanceof IPowerRecipe) {
			IPowerRecipe powerRecipe = (IPowerRecipe) recipe;
			return powerRecipe.getPowerRequired();
		}
		return 0;
	}
}

package ip.industrialProcessing.gui3.generating.builderParts;

import ip.industrialProcessing.gui3.binding.Binder;
import ip.industrialProcessing.gui3.binding.IProgressBinding;
import ip.industrialProcessing.gui3.containers.GuiLayoutContainer;
import ip.industrialProcessing.gui3.containers.LayoutContainer;
import ip.industrialProcessing.gui3.containers.handlers.PowerHandler;
import ip.industrialProcessing.gui3.framework.Alignment;
import ip.industrialProcessing.gui3.framework.controls.Control;
import ip.industrialProcessing.gui3.framework.controls.ProgressBar;
import ip.industrialProcessing.gui3.framework.custom.PowerControl;
import ip.industrialProcessing.gui3.framework.panels.LayerPanel;
import ip.industrialProcessing.gui3.framework.panels.StackPanel;
import ip.industrialProcessing.power.IPoweredMachine;
import ip.industrialProcessing.recipes.IMachineRecipe;
import ip.industrialProcessing.recipes.IPowerRecipe;
import ip.industrialProcessing.slots.SlotBase;
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

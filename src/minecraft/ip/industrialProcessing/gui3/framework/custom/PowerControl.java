package ip.industrialProcessing.gui3.framework.custom;

import ip.industrialProcessing.gui3.binding.IProgressBinding;
import ip.industrialProcessing.gui3.framework.Thickness;
import ip.industrialProcessing.gui3.framework.controls.ProgressBar;
import ip.industrialProcessing.gui3.framework.controls.SlotControl;
import ip.industrialProcessing.gui3.framework.controls.UserControl;
import ip.industrialProcessing.gui3.framework.panels.Orientation;
import ip.industrialProcessing.gui3.framework.panels.StackPanel;
import net.minecraft.inventory.Slot;

public class PowerControl extends UserControl implements IProgressBinding {

    public static PowerControl createPowerWithSlots(Slot powerSlot) {
	return new PowerControl(powerSlot);
    }

    private ProgressBar progress;

    public PowerControl(Slot powerSlot) {
	width = Float.NaN;
	height = Float.NaN;
	StackPanel stack = new StackPanel();
	stack.orientation = Orientation.HORIZONTAL;

	SlotControl slot = SlotControl.createPowerSlot(powerSlot);
	stack.addChild(slot);

	progress = ProgressBar.createHorizontal1();
	progress.margin = new Thickness(0, 0, 0, 0); 
	slot.margin = new Thickness(0, 0, 0, 0);
	stack.addChild(progress);

	this.child = stack;
    }

    @Override
    public void setValue(float value) {
	this.progress.setValue(value);
    }

    @Override
    public float getValue() {
	return this.progress.getValue();
    }

    @Override
    public void setMaxValue(float value) {
	this.progress.setMaxValue(value);
    }

    @Override
    public float getMaxValue() {
	return this.progress.getMaxValue();
    }
}

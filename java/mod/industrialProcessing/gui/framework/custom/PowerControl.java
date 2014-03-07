package mod.industrialProcessing.gui.framework.custom;

import mod.industrialProcessing.gui.binding.IProgressBinding;
import mod.industrialProcessing.gui.framework.Thickness;
import mod.industrialProcessing.gui.framework.controls.ProgressBar;
import mod.industrialProcessing.gui.framework.controls.SlotControl;
import mod.industrialProcessing.gui.framework.controls.UserControl;
import mod.industrialProcessing.gui.framework.panels.Orientation;
import mod.industrialProcessing.gui.framework.panels.StackPanel;
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
		progress.tooltip = "%.0fJoules";
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

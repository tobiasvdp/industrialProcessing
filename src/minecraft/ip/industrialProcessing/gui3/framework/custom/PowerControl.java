package ip.industrialProcessing.gui3.framework.custom;

import ip.industrialProcessing.gui3.framework.controls.ProgressBar;
import ip.industrialProcessing.gui3.framework.controls.SlotControl;
import ip.industrialProcessing.gui3.framework.controls.UserControl;
import ip.industrialProcessing.gui3.framework.panels.Orientation;
import ip.industrialProcessing.gui3.framework.panels.StackPanel;
import net.minecraft.inventory.Slot;

public class PowerControl extends UserControl {

    public static PowerControl createPowerWithSlots(Slot powerSlot){
	return new PowerControl(powerSlot);
    }
    
    public PowerControl(Slot powerSlot) {
	width = Float.NaN;
	height = Float.NaN;
	StackPanel stack = new StackPanel();
	stack.orientation = Orientation.HORIZONTAL;

	SlotControl tank = SlotControl.createPowerSlot(powerSlot);
	stack.addChild(tank); 
	 
	ProgressBar progress = ProgressBar.createHorizontal1();
	stack.addChild(progress);
	
	this.child = stack;
    }
}

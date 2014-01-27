package ip.industrialProcessing.gui3.framework.custom;

import ip.industrialProcessing.gui3.framework.controls.ProgressBar;
import ip.industrialProcessing.gui3.framework.controls.SlotControl;
import ip.industrialProcessing.gui3.framework.controls.TankControl;
import ip.industrialProcessing.gui3.framework.controls.UserControl;
import ip.industrialProcessing.gui3.framework.panels.GridCell;
import ip.industrialProcessing.gui3.framework.panels.GridPanel;
import ip.industrialProcessing.gui3.framework.panels.GridSize;
import ip.industrialProcessing.gui3.framework.panels.Orientation;
import ip.industrialProcessing.gui3.framework.panels.SizeMode;
import ip.industrialProcessing.gui3.framework.panels.StackPanel;

public class PowerControl extends UserControl {

    public static PowerControl createPowerWithSlots(){
	return new PowerControl();
    }
    
    public PowerControl() {
	width = Float.NaN;
	height = Float.NaN;
	StackPanel stack = new StackPanel();
	stack.orientation = Orientation.HORIZONTAL;

	SlotControl tank = SlotControl.createPowerSlot();
	stack.addChild(tank); 
	 
	ProgressBar progress = ProgressBar.createHorizontal1();
	stack.addChild(progress);
	
	this.child = stack;
    }
}

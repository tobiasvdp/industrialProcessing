package ip.industrialProcessing.gui3.framework.custom;

import ip.industrialProcessing.gui3.framework.controls.SlotControl;
import ip.industrialProcessing.gui3.framework.controls.TankControl;
import ip.industrialProcessing.gui3.framework.controls.UserControl;
import ip.industrialProcessing.gui3.framework.panels.GridCell;
import ip.industrialProcessing.gui3.framework.panels.GridPanel;
import ip.industrialProcessing.gui3.framework.panels.GridSize;
import ip.industrialProcessing.gui3.framework.panels.Orientation;
import ip.industrialProcessing.gui3.framework.panels.SizeMode;
import ip.industrialProcessing.gui3.framework.panels.StackPanel;

public class TankWithSlotsControl extends UserControl {

    public TankWithSlotsControl() {

	StackPanel stack = new StackPanel();
	stack.orientation = Orientation.HORIZONTAL;

	TankControl tank = TankControl.createTank();
	stack.addChild(tank); 
	
	GridPanel grid = new GridPanel();
	grid.columns.add(new GridSize(18, SizeMode.ABSOLUTE));
	grid.rows.add(new GridSize(18, SizeMode.ABSOLUTE));
	grid.rows.add(new GridSize(1, SizeMode.RELATIVE));
	grid.rows.add(new GridSize(18, SizeMode.ABSOLUTE));

	SlotControl slotInput = new SlotControl();
	SlotControl slotOutput = new SlotControl();
	grid.children.add(new GridCell(0, 0, slotInput));
	grid.children.add(new GridCell(2, 0, slotOutput));
	
	stack.addChild(grid); 
	this.child = stack;
    }
}

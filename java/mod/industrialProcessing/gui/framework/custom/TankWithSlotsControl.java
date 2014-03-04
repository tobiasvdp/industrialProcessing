package mod.industrialProcessing.gui.framework.custom;

import ip.industrialProcessing.gui3.binding.ITankBinding;
import ip.industrialProcessing.gui3.framework.controls.SlotControl;
import ip.industrialProcessing.gui3.framework.controls.TankControl;
import ip.industrialProcessing.gui3.framework.controls.UserControl;
import ip.industrialProcessing.gui3.framework.panels.GridCell;
import ip.industrialProcessing.gui3.framework.panels.GridPanel;
import ip.industrialProcessing.gui3.framework.panels.GridSize;
import ip.industrialProcessing.gui3.framework.panels.Orientation;
import ip.industrialProcessing.gui3.framework.panels.SizeMode;
import ip.industrialProcessing.gui3.framework.panels.StackPanel;
import net.minecraft.inventory.Slot;

public class TankWithSlotsControl extends UserControl implements ITankBinding {

    public static TankWithSlotsControl createTankWithSlots(Slot inputSlot, Slot outputSlot){
	return new TankWithSlotsControl(inputSlot, outputSlot);
    }

    private TankControl tank;
    
    public TankWithSlotsControl(Slot inputSlot, Slot outputSlot) {
	width = Float.NaN;
	height = Float.NaN;
	StackPanel stack = new StackPanel();
	stack.orientation = Orientation.HORIZONTAL;

	  tank = TankControl.createTank();
	stack.addChild(tank); 
	
	GridPanel grid = new GridPanel();
	grid.columns.add(new GridSize(18, SizeMode.ABSOLUTE));
	grid.rows.add(new GridSize(18, SizeMode.ABSOLUTE));
	grid.rows.add(new GridSize(1, SizeMode.RELATIVE));
	grid.rows.add(new GridSize(18, SizeMode.ABSOLUTE));

	SlotControl slotInput = SlotControl.createBucketSlot(inputSlot);
	SlotControl slotOutput = SlotControl.createBucketSlot(outputSlot);
	grid.children.add(new GridCell(0, 0, slotInput));
	grid.children.add(new GridCell(2, 0, slotOutput));
	
	stack.addChild(grid); 
	this.child = stack;
    }

    @Override
    public void setCapacity(int capacity) {
	this.tank.setCapacity(capacity);
    }

    @Override
    public int getCapacity() { 
	return this.tank.getCapacity();
    }

    @Override
    public int getFluidAmount() { 
	return this.tank.getFluidAmount();
    }

    @Override
    public void setFluidAmount(int amount) {
	this.tank.setFluidAmount(amount);
    }

    @Override
    public int getFluidID() { 
	return this.tank.getFluidID();
    }

    @Override
    public void setFluidID(int fluidId) {
	this.tank.setFluidID(fluidId);
    }
}

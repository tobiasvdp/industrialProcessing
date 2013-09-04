package ip.industrialProcessing.multiblock.dummy.block.toggleButton;

import ip.industrialProcessing.multiblock.core.block.elevator.TEmultiblockElevator;
import ip.industrialProcessing.multiblock.dummy.TEmultiblockDummy;

public class TEmultiblockToggleButton extends TEmultiblockDummy {

	public TEmultiblockToggleButton(){
		super();
	}

	public void toggle(){
		if(getCore() != null)
			((TEmultiblockElevator) getCore()).toggle(this.ID);
	}
}

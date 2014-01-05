package ip.industrialProcessing.multiblock.dummy.block.toggleButton;

import ip.industrialProcessing.multiblock.core.block.elevator.TEmultiblockElevator;
import ip.industrialProcessing.multiblock.dummy.TileEntityMultiblockDummy;

public class TEmultiblockToggleButton extends TileEntityMultiblockDummy {

	public TEmultiblockToggleButton(){
		super();
	}

	public void toggle(){
		if(getCore() != null)
			((TEmultiblockElevator) getCore()).toggle(this.ID);
	}
}

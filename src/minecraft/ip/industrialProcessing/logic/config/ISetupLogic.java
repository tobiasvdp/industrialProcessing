package ip.industrialProcessing.logic.config;

import ip.industrialProcessing.logic.function.and.BLlogicAnd;
import ip.industrialProcessing.logic.function.or.BLlogicOr;
import ip.industrialProcessing.logic.network.display.BlockLogicDisplay;
import ip.industrialProcessing.logic.network.interfaces.machine.BlockMachineInterface;
import ip.industrialProcessing.logic.transport.wired.bundle.BLlogicBundle;
import ip.industrialProcessing.logic.transport.wired.cable.BLlogicCable;
import ip.industrialProcessing.logic.transport.wired.displayBox.BLlogicDisplayBox;
import ip.industrialProcessing.logic.transport.wired.switchbox.BLlogicSwitchBox;

public interface ISetupLogic {
	// logic
	public final static BLlogicCable BLlogicCable = new BLlogicCable();
	public final static BLlogicSwitchBox BLlogicSwitchBox = new BLlogicSwitchBox();
	public final static BLlogicBundle BLlogicBundle = new BLlogicBundle();
	public final static BLlogicDisplayBox BLlogicDisplayBox = new BLlogicDisplayBox();
	public final static BLlogicAnd BLlogicAnd = new BLlogicAnd();
	public final static BLlogicOr BLlogicOr = new BLlogicOr();
	public final static BlockMachineInterface BlockMachineInterface = new BlockMachineInterface();
	public final static BlockLogicDisplay BlockLogicDisplay = new BlockLogicDisplay();
}

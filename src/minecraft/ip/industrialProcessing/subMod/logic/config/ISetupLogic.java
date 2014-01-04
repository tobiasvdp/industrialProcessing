package ip.industrialProcessing.subMod.logic.config;

import ip.industrialProcessing.subMod.logic.function.and.BLlogicAnd;
import ip.industrialProcessing.subMod.logic.function.or.BLlogicOr;
import ip.industrialProcessing.subMod.logic.network.display.BlockLogicDisplay;
import ip.industrialProcessing.subMod.logic.network.interfaces.machine.BlockMachineInterface;
import ip.industrialProcessing.subMod.logic.transport.wired.bundle.BLlogicBundle;
import ip.industrialProcessing.subMod.logic.transport.wired.cable.BLlogicCable;
import ip.industrialProcessing.subMod.logic.transport.wired.displayBox.BLlogicDisplayBox;
import ip.industrialProcessing.subMod.logic.transport.wired.switchbox.BLlogicSwitchBox;

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

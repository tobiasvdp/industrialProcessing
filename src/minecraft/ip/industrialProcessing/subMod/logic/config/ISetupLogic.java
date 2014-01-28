package ip.industrialProcessing.subMod.logic.config;

import ip.industrialProcessing.subMod.logic.old.function.and.BLlogicAnd;
import ip.industrialProcessing.subMod.logic.old.function.or.BLlogicOr;
import ip.industrialProcessing.subMod.logic.old.network.display.BlockLogicDisplay;
import ip.industrialProcessing.subMod.logic.old.network.interfaces.machine.BlockMachineInterface;
import ip.industrialProcessing.subMod.logic.old.transport.wired.bundle.BLlogicBundle;
import ip.industrialProcessing.subMod.logic.old.transport.wired.cable.BLlogicCable;
import ip.industrialProcessing.subMod.logic.old.transport.wired.displayBox.BLlogicDisplayBox;
import ip.industrialProcessing.subMod.logic.old.transport.wired.switchbox.BLlogicSwitchBox;

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

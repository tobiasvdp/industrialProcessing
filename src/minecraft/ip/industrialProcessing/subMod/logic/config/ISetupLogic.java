package ip.industrialProcessing.subMod.logic.config;

import ip.industrialProcessing.subMod.logic.network.devices.interfaces.machineInterface.BlockMachineInterface;
import ip.industrialProcessing.subMod.logic.network.devices.readout.displayPanel.BlockDisplayPanel;
import ip.industrialProcessing.subMod.logic.network.devices.readout.displayPost.BlockDisplayPost;
import ip.industrialProcessing.subMod.logic.network.microblock.BlockLogicTransport;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.BlockDataBus;
import ip.industrialProcessing.subMod.logic.old.function.and.BLlogicAnd;
import ip.industrialProcessing.subMod.logic.old.function.or.BLlogicOr;
import ip.industrialProcessing.subMod.logic.old.network.display.BlockLogicDisplay;
import ip.industrialProcessing.subMod.logic.old.transport.wired.bundle.BLlogicBundle;
import ip.industrialProcessing.subMod.logic.old.transport.wired.cable.BLlogicCable;
import ip.industrialProcessing.subMod.logic.old.transport.wired.displayBox.BLlogicDisplayBox;
import ip.industrialProcessing.subMod.logic.old.transport.wired.switchbox.BLlogicSwitchBox;

public interface ISetupLogic {

	public final static BlockDataBus blockDataBus = new BlockDataBus();
	public final static BlockDisplayPanel blockDisplayPanel = new BlockDisplayPanel();
	public final static BlockDisplayPost blockDisplayPost = new BlockDisplayPost();
	public final static BlockMachineInterface blockMachineInterface = new BlockMachineInterface();
}

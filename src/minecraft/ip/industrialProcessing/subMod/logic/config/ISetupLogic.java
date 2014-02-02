package ip.industrialProcessing.subMod.logic.config;

import ip.industrialProcessing.items.ItemMicroBlock;
import ip.industrialProcessing.microBlock.MicroBlockType;
import ip.industrialProcessing.subMod.logic.IPLogic;
import ip.industrialProcessing.utils.registry.MicroBlockModelRegistry;

public interface ISetupLogic {
	
	public final static ItemMicroBlock itemMicroblockWire = new ItemMicroBlock(ConfigLogic.getItemMicroblockDatabusID(),"itemMicroblockWire",IPLogic.tabLogic,ConfigLogic.setRendererMicroblockDataBus(MicroBlockModelRegistry.getNextAvailableID()),MicroBlockType.wire,"TileEntityDataBus",0);
	public final static ItemMicroBlock itemMicroblockMachineInterface = new ItemMicroBlock(ConfigLogic.getItemMicroblockMachineInterfaceID(),"itemMicroblockMachineInterface",IPLogic.tabLogic,ConfigLogic.setRendererMicroblockMachineInterface(MicroBlockModelRegistry.getNextAvailableID()),MicroBlockType.device,"TileEntityMachineInterface",1);

}

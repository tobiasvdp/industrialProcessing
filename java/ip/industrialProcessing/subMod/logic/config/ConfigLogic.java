package ip.industrialProcessing.subMod.logic.config;

import ip.industrialProcessing.api.config.ConfigCategories;
import ip.industrialProcessing.subMod.logic.IPLogic;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.TileEntityDataBus;
import ip.industrialProcessing.subMod.logic.old.network.interfaces.machine.TileEntityMachineInterface;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ConfigLogic {
	private static ConfigLogic instance = new ConfigLogic();

	public static int getBLlogicAnd() {
		return getInstance().BLlogicAnd;
	}

	public static int getBLlogicBundle() {
		return getInstance().blockDisplayPanelID;
	}

	public static int getBlockDataBusID() {
		return getInstance().blockDataBusID;
	}
	public static int getBlockDisplayPanelID() {
		return getInstance().blockDisplayPanelID;
	}
	
	public static int getBlockMachineInterfaceID() {
		return getInstance().blockMachineInterfaceID;
	}
	
	public static int getBlockDisplayPostID() {
		return getInstance().blockDisplayPostID;
	}

	public static int getBLlogicDisplayBox() {
		return getInstance().BLlogicDisplayBox;
	}

	public static int getBLlogicOr() {
		return getInstance().blockMachineInterfaceID;
	}

	public static int getBLlogicSwitchBox() {
		return getInstance().blockDisplayPostID;
	}

	public static int getBlockLogicDisplay() {
		return getInstance().BlockLogicDisplay;
	}

	public static int getBlockMachineInterface() {
		return getInstance().BlockMachineInterface;
	}

	public static ConfigLogic getInstance() {
		return instance;
	}

	public static int getRDlogicAnd() {
		return getInstance().RDlogicAnd;
	}

	public static int getRDlogicCable() {
		return getInstance().RDlogicCable;
	}

	public static int getRDlogicOr() {
		return getInstance().RDlogicOr;
	}

	public static int getRDlogicSwitchBox() {
		return getInstance().RDlogicSwitchBox;
	}

	public static void setRDlogicAnd(int value) {
		getInstance().RDlogicAnd = value;
	}

	public static void setRDlogicCable(int value) {
		getInstance().RDlogicCable = value;
	}

	public static void setRDlogicOr(int value) {
		getInstance().RDlogicOr = value;
	}

	public static void setRDlogicSwitchBox(int value) {
		getInstance().RDlogicSwitchBox = value;
	}

	private int blockDisplayPostID = IPLogic.config.get(ConfigCategories.logic.toString(), "blockDisplayPostID", 738).getInt();

	private int blockDataBusID = IPLogic.config.get(ConfigCategories.logic.toString(), "blockDataBusID", 739).getInt();

	private int blockDisplayPanelID = IPLogic.config.get(ConfigCategories.logic.toString(), "blockDisplayPanelID", 740).getInt();

	private int BLlogicDisplayBox = IPLogic.config.get(ConfigCategories.logic.toString(), "DisplayBoxID", 741).getInt();

	private int BLlogicAnd = IPLogic.config.get(ConfigCategories.logic.toString(), "AndGateID", 742).getInt();

	private int blockMachineInterfaceID = IPLogic.config.get(ConfigCategories.logic.toString(), "OrGateID", 743).getInt();

	private int BlockMachineInterface = IPLogic.config.get(ConfigCategories.logic.toString(), "BlockMachineInterface", 844).getInt();

	private int BlockLogicDisplay = IPLogic.config.get(ConfigCategories.logic.toString(), "BlockLogicDisplay", 845).getInt();

	private int RDlogicSwitchBox;

	private int RDlogicCable;

	private int RDlogicAnd;

	private int RDlogicOr;
	
	//blocks
	
	//items	
	private int itemMicroblockDatabusID = 8000;
	private int itemMicroblockMachineInterfaceID = 8001;

	public static int getItemMicroblockDatabusID() {
		return getInstance().itemMicroblockDatabusID;
	}

	public static int getItemMicroblockMachineInterfaceID() {
		return getInstance().itemMicroblockMachineInterfaceID;
	}
	
	//renderers
	private int rendererMicroblockDataBus;
	private int rendererMicroblockMachineInterface;
	
	public static int setRendererMicroblockDataBus(int var) {
		getInstance().rendererMicroblockDataBus = var;
		return var;
	}

	public static int getRendererMicroblockDataBus() {
		return getInstance().rendererMicroblockDataBus;
	}
	
	public static int setRendererMicroblockMachineInterface(int var) {
		getInstance().rendererMicroblockMachineInterface = var;
		return var;
	}

	public static int getRendererMicroblockMachineInterface() {
		return getInstance().rendererMicroblockMachineInterface;
	}
	
	

	public void register() {
		LanguageRegistry.instance().addStringLocalization("IP.itemGroup.tabLogic", "en_US", "IP Logic");
		//((CreativeTabsIP) IPLogic.tabLogic).setIcon(new ItemStack(ISetupLogic.BLlogicSwitchBox));
		
		LanguageRegistry.addName(ISetupLogic.itemMicroblockWire , "Data bus");
		LanguageRegistry.addName(ISetupLogic.itemMicroblockMachineInterface , "Machine interface");
		
		//register multiblock multiple tileEntities
		ModLoader.registerTileEntity(TileEntityDataBus.class, ISetupLogic.itemMicroblockWire.tileEntity);
		ModLoader.registerTileEntity(TileEntityMachineInterface.class, ISetupLogic.itemMicroblockMachineInterface.tileEntity);
	}
}

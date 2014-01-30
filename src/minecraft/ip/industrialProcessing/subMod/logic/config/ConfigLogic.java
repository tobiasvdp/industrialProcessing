package ip.industrialProcessing.subMod.logic.config;

import ip.industrialProcessing.api.config.ConfigCategories;
import ip.industrialProcessing.api.utils.CreativeTabsIP;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.subMod.logic.IPLogic;
import ip.industrialProcessing.subMod.logic.network.TileEntityLogicTransport;
import ip.industrialProcessing.subMod.logic.network.devices.readout.displayPanel.TileEntityDisplayPanel;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.TileEntityDataBus;
import ip.industrialProcessing.subMod.logic.old.function.and.TElogicAnd;
import ip.industrialProcessing.subMod.logic.old.function.or.TElogicOr;
import ip.industrialProcessing.subMod.logic.old.network.display.TileEntityLogicDisplay;
import ip.industrialProcessing.subMod.logic.old.network.interfaces.machine.TileEntityMachineInterface;
import ip.industrialProcessing.subMod.logic.old.transport.wired.bundle.TElogicBundle;
import ip.industrialProcessing.subMod.logic.old.transport.wired.cable.TElogicCable;
import ip.industrialProcessing.subMod.logic.old.transport.wired.displayBox.TElogicDisplayBox;
import ip.industrialProcessing.subMod.logic.old.transport.wired.switchbox.TElogicSwitchBox;
import ip.industrialProcessing.utils.registry.BlockType;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;
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

	public static int getBLlogicDisplayBox() {
		return getInstance().BLlogicDisplayBox;
	}

	public static int getBLlogicOr() {
		return getInstance().BLlogicOr;
	}

	public static int getBLlogicSwitchBox() {
		return getInstance().BLlogicSwitchBox;
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

	private int BLlogicSwitchBox = IPLogic.config.get(ConfigCategories.logic.toString(), "SwitchBoxID", 738).getInt();

	private int blockDataBusID = IPLogic.config.get(ConfigCategories.logic.toString(), "blockDataBusID", 739).getInt();

	private int blockDisplayPanelID = IPLogic.config.get(ConfigCategories.logic.toString(), "blockDisplayPanelID", 740).getInt();

	private int BLlogicDisplayBox = IPLogic.config.get(ConfigCategories.logic.toString(), "DisplayBoxID", 741).getInt();

	private int BLlogicAnd = IPLogic.config.get(ConfigCategories.logic.toString(), "AndGateID", 742).getInt();

	private int BLlogicOr = IPLogic.config.get(ConfigCategories.logic.toString(), "OrGateID", 743).getInt();

	private int BlockMachineInterface = IPLogic.config.get(ConfigCategories.logic.toString(), "BlockMachineInterface", 844).getInt();

	private int BlockLogicDisplay = IPLogic.config.get(ConfigCategories.logic.toString(), "BlockLogicDisplay", 845).getInt();

	private int RDlogicSwitchBox;

	private int RDlogicCable;

	private int RDlogicAnd;

	private int RDlogicOr;

	public void register() {
		LanguageRegistry.instance().addStringLocalization("IP.itemGroup.tabLogic", "en_US", "IP Logic");
		//((CreativeTabsIP) IPLogic.tabLogic).setIcon(new ItemStack(ISetupLogic.BLlogicSwitchBox));
		
		ConfigMachineBlocks.registerMachineBlock(ISetupLogic.blockDataBus, "IP.Logic.dataBus", "Data bus", TileEntityDataBus.class, BlockType.logic);
		ConfigMachineBlocks.registerMachineBlock(ISetupLogic.blockDisplayPanel, "IP.Logic.display", "Display panel", TileEntityDisplayPanel.class, BlockType.logic);
	}
}

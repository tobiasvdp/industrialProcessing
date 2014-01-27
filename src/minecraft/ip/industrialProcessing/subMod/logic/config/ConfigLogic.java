package ip.industrialProcessing.subMod.logic.config;

import ip.industrialProcessing.api.config.ConfigCategories;
import ip.industrialProcessing.api.utils.CreativeTabsIP;
import ip.industrialProcessing.subMod.logic.IPLogic;
import ip.industrialProcessing.subMod.logic.function.and.TElogicAnd;
import ip.industrialProcessing.subMod.logic.function.or.TElogicOr;
import ip.industrialProcessing.subMod.logic.network.display.TileEntityLogicDisplay;
import ip.industrialProcessing.subMod.logic.network.interfaces.machine.TileEntityMachineInterface;
import ip.industrialProcessing.subMod.logic.transport.wired.bundle.TElogicBundle;
import ip.industrialProcessing.subMod.logic.transport.wired.cable.TElogicCable;
import ip.industrialProcessing.subMod.logic.transport.wired.displayBox.TElogicDisplayBox;
import ip.industrialProcessing.subMod.logic.transport.wired.switchbox.TElogicSwitchBox;
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
		return getInstance().BLlogicBundle;
	}

	public static int getBLlogicCable() {
		return getInstance().BLlogicCable;
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

	private int BLlogicCable = IPLogic.config.get(ConfigCategories.logic.toString(), "CableID", 739).getInt();

	private int BLlogicBundle = IPLogic.config.get(ConfigCategories.logic.toString(), "BundleID", 740).getInt();

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
		((CreativeTabsIP) IPLogic.tabLogic).setIcon(new ItemStack(ISetupLogic.BLlogicSwitchBox));

		this.register(ISetupLogic.BLlogicCable, "IP.Logic.Cable", "Cable", TElogicCable.class);
		this.register(ISetupLogic.BLlogicSwitchBox, "IP.Logic.SwBox", "Switch box", TElogicSwitchBox.class);
		this.register(ISetupLogic.BLlogicBundle, "IP.Logic.Bundle", "Bundled cables", TElogicBundle.class);
		this.register(ISetupLogic.BLlogicDisplayBox, "IP.Logic.DsBox", "Display box", TElogicDisplayBox.class);
		this.register(ISetupLogic.BLlogicAnd, "IP.Logic.And", "And gate", TElogicAnd.class);
		this.register(ISetupLogic.BLlogicOr, "IP.Logic.Or", "Or gate", TElogicOr.class);
		this.register(ISetupLogic.BlockMachineInterface, "IP.Logic.MInt", "Interface", TileEntityMachineInterface.class);
		this.register(ISetupLogic.BlockLogicDisplay, "IP.Logic.Display", "Display", TileEntityLogicDisplay.class);
	}

	private void register(Block block, String uniqueId, String displayName, Class tileEntity) {
		GameRegistry.registerBlock(block, uniqueId);
		MinecraftForge.setBlockHarvestLevel(block, "pickaxe", 1);
		LanguageRegistry.addName(block, displayName);
		GameRegistry.registerTileEntity(tileEntity, uniqueId);
	}
}

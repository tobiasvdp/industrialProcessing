package ip.industrialProcessing.logic.config;

import ip.industrialProcessing.api.config.ConfigCategories;
import ip.industrialProcessing.api.utils.CreativeTabsIP;
import ip.industrialProcessing.logic.IPLogic;
import ip.industrialProcessing.logic.function.and.TElogicAnd;
import ip.industrialProcessing.logic.function.or.TElogicOr;
import ip.industrialProcessing.logic.network.display.TileEntityLogicDisplay;
import ip.industrialProcessing.logic.network.interfaces.machine.TileEntityMachineInterface;
import ip.industrialProcessing.logic.transport.wired.bundle.TElogicBundle;
import ip.industrialProcessing.logic.transport.wired.cable.TElogicCable;
import ip.industrialProcessing.logic.transport.wired.displayBox.TElogicDisplayBox;
import ip.industrialProcessing.logic.transport.wired.switchbox.TElogicSwitchBox;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ConfigLogic {
	private static ConfigLogic instance = new ConfigLogic();
	private int BLlogicSwitchBox = IPLogic.config.get(ConfigCategories.logic.toString(),"SwitchBoxID",738).getInt();
	private int BLlogicCable = IPLogic.config.get(ConfigCategories.logic.toString(),"CableID",739).getInt();
	private int BLlogicBundle = IPLogic.config.get(ConfigCategories.logic.toString(),"BundleID",740).getInt();
	private int BLlogicDisplayBox = IPLogic.config.get(ConfigCategories.logic.toString(),"DisplayBoxID",741).getInt();
	private int BLlogicAnd = IPLogic.config.get(ConfigCategories.logic.toString(),"AndGateID",742).getInt();
	private int BLlogicOr = IPLogic.config.get(ConfigCategories.logic.toString(),"OrGateID",743).getInt();
	private int BlockMachineInterface = IPLogic.config.get(ConfigCategories.logic.toString(),"BlockMachineInterface",844).getInt();
	private int BlockLogicDisplay = IPLogic.config.get(ConfigCategories.logic.toString(),"BlockLogicDisplay",845).getInt();
	
	private int RDlogicSwitchBox;
	private int RDlogicCable;
	private int RDlogicAnd;
	private int RDlogicOr;
	
	public static int getRDlogicOr() {
		return getInstance().RDlogicOr;
	}

	public static void setRDlogicOr(int value) {
		getInstance().RDlogicOr = value;
	}

	public static int getRDlogicAnd() {
		return getInstance().RDlogicAnd;
	}

	public static void setRDlogicAnd(int value) {
		getInstance().RDlogicAnd = value;
	}

	public static int getRDlogicCable() {
		return getInstance().RDlogicCable;
	}

	public static void setRDlogicCable(int value) {
		getInstance().RDlogicCable = value;
	}

	public static int getRDlogicSwitchBox() {
		return getInstance().RDlogicSwitchBox;
	}

	public static void setRDlogicSwitchBox(int value) {
		getInstance().RDlogicSwitchBox = value;
	}
	
	public void register(){
		LanguageRegistry.instance().addStringLocalization("IP.itemGroup.tabLogic", "en_US", "IP Logic");
		((CreativeTabsIP) IPLogic.tabLogic).setIcon(new ItemStack(IPLogic.BLlogicSwitchBox));
		
		register(IPLogic.BLlogicCable, "IP.Logic.Cable", "Cable", TElogicCable.class);
		register(IPLogic.BLlogicSwitchBox, "IP.Logic.SwBox", "Switch box", TElogicSwitchBox.class);
		register(IPLogic.BLlogicBundle, "IP.Logic.Bundle", "Bundled cables", TElogicBundle.class);
		register(IPLogic.BLlogicDisplayBox, "IP.Logic.DsBox", "Display box", TElogicDisplayBox.class);
		register(IPLogic.BLlogicAnd, "IP.Logic.And", "And gate", TElogicAnd.class);
		register(IPLogic.BLlogicOr, "IP.Logic.Or", "Or gate", TElogicOr.class);
		register(IPLogic.BlockMachineInterface, "IP.Logic.MInt", "Interface", TileEntityMachineInterface.class);
		register(IPLogic.BlockLogicDisplay, "IP.Logic.Display", "Display", TileEntityLogicDisplay.class);
	}
	
	private void register(Block block, String uniqueId, String displayName, Class tileEntity) {
		GameRegistry.registerBlock(block, uniqueId);
		MinecraftForge.setBlockHarvestLevel(block, "pickaxe", 1);
		LanguageRegistry.addName(block, displayName);
		GameRegistry.registerTileEntity(tileEntity, uniqueId);
	}
	
	public static ConfigLogic getInstance() {
		return instance ;
	}
	
	public static int getBlockLogicDisplay() {
		return getInstance().BlockLogicDisplay;
	}
	
	public static int getBlockMachineInterface() {
		return getInstance().BlockMachineInterface;
	}
	
	public static int getBLlogicOr() {
		return getInstance().BLlogicOr;
	}

	public static int getBLlogicAnd() {
		return getInstance().BLlogicAnd;
	}

	public static int getBLlogicDisplayBox() {
		return getInstance().BLlogicDisplayBox;
	}

	public static int getBLlogicBundle() {
		return getInstance().BLlogicBundle;
	}

	public static int getBLlogicSwitchBox() {
		return getInstance().BLlogicSwitchBox;
	}

	public static int getBLlogicCable() {
		return getInstance().BLlogicCable;
	}
}

package ip.industrialProcessing.subMod.power.config;

import ip.industrialProcessing.api.config.ConfigCategories;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ISetupMachineBlocks;
import ip.industrialProcessing.subMod.power.IPPower;
import ip.industrialProcessing.subMod.power.plant.creative.TileEntityCreativeGenerator;
import ip.industrialProcessing.utils.registry.BlockType;

public class ConfigPower {
	private static ConfigPower instance = new ConfigPower();
	
	private int creativeEngineID = IPPower.config.get(ConfigCategories.power.toString(), "creativeEngineID", 840).getInt();
	
	public void register(){
		ConfigMachineBlocks.getInstance().registerMachineBlock(IPPower.blockCreativeGenerator, "IP.Power.Creat", "Creative engine", TileEntityCreativeGenerator.class, BlockType.Machine, BlockType.Power);
	}
	
	public static ConfigPower getInstance() {
		return instance ;
	}
	
	public static int getCreativeEngineID(){
		return getInstance().creativeEngineID;
	}
}

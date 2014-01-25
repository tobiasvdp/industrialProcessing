package ip.industrialProcessing.subMod.mine.config;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.utils.registry.BlockType;


public class ConfigMine {
	private static ConfigMine instance = new ConfigMine();
	
	public void register(){
		//ConfigMachineBlocks.getInstance().registerMachineBlock(IPPower.blockCreativeGenerator, "IP.Power.Creat", "Creative engine", TileEntityCreativeGenerator.class, BlockType.Power);
		//ConfigMachineBlocks.getInstance().registerMachineBlock(IPPower.blockStandingSolarPanel, "IP.Power.StSolar", "Standing solar panels", TileEntityStandingSolarPanel.class, BlockType.Power);
	}
	
	public static ConfigMine getInstance() {
		return instance ;
	}
	
}

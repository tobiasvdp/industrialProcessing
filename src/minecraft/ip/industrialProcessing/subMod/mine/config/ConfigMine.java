package ip.industrialProcessing.subMod.mine.config;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.multiblock.dummy.block.decoration.garageDoor.entity.EntityGarageDoor;
import ip.industrialProcessing.subMod.mine.IPMine;
import ip.industrialProcessing.subMod.mine.machines.mining.bobcatMiner.EntityBobcatMiner;
import ip.industrialProcessing.utils.registry.BlockType;


public class ConfigMine {
	private static ConfigMine instance = new ConfigMine();
	
	public void register(){
		//ConfigMachineBlocks.getInstance().registerMachineBlock(IPPower.blockCreativeGenerator, "IP.Power.Creat", "Creative engine", TileEntityCreativeGenerator.class, BlockType.Power);
		//ConfigMachineBlocks.getInstance().registerMachineBlock(IPPower.blockStandingSolarPanel, "IP.Power.StSolar", "Standing solar panels", TileEntityStandingSolarPanel.class, BlockType.Power);
		
		EntityRegistry.registerModEntity(EntityBobcatMiner.class, "Bobcat miner", 0, IPMine.instance, 80, 1, true);
		LanguageRegistry.instance().addStringLocalization("entity.BobcatMiner.name", "en_US", "Bobcat miner");
	}
	
	public static ConfigMine getInstance() {
		return instance ;
	}
	
}

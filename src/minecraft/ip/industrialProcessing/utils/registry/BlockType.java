package ip.industrialProcessing.utils.registry;

import cpw.mods.fml.common.registry.LanguageRegistry;

public enum BlockType {
	Block, Machine, Tier0,Tier1,Power,Refinary,Smelting,Ore_Processing, assemble, Dummy,Transport,Storage;
	
	public static void registerNames(){
		LanguageRegistry.instance().addStringLocalization("IP.BlockType."+Ore_Processing.toString(),"en_US", "Ore processing");
		LanguageRegistry.instance().addStringLocalization("IP.BlockType."+Smelting.toString(),"en_US", "Smelting");
	}
}

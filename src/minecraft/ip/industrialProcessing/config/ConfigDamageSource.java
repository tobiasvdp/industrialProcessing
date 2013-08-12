package ip.industrialProcessing.config;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class ConfigDamageSource {

	public void addToLanguageRegistry(){
		LanguageRegistry.instance().addStringLocalization("death.attack.DirtyWater", "%1$s was poisoned to death by swiming in dirty water.");
		LanguageRegistry.instance().addStringLocalization("death.attack.DirtyWater.player", "%1$s was killed in dirty water by %2$s");
		LanguageRegistry.instance().addStringLocalization("death.attack.DirtyWater.item", "%1$s was killed in dirty water by %2$s");
	}
	
	public ConfigDamageSource() {
	}
	
	private static ConfigDamageSource instance = new ConfigDamageSource();
	
	public static ConfigDamageSource getInstance(){
		return instance;
	}

}

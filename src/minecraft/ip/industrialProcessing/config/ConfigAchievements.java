package ip.industrialProcessing.config;

import cpw.mods.fml.common.registry.LanguageRegistry;
import ip.industrialProcessing.IndustrialProcessing;
import net.minecraftforge.common.AchievementPage;

public class ConfigAchievements {
	private int placedFilter = 2001;
	private int achPlacedCrusher = 2002;
	
	public static int PlacedFilterID(){return getInstance().placedFilter;}
	public static int PlacedCrusherID(){return getInstance().achPlacedCrusher;}
	
	public void registerAchievments(){
		IndustrialProcessing.achPage.getAchievements().add(IndustrialProcessing.achPlacedFilter);
		IndustrialProcessing.achPage.getAchievements().add(IndustrialProcessing.achPlacedCrusher);
		AchievementPage.registerAchievementPage(IndustrialProcessing.achPage);
		
		LanguageRegistry.instance().addStringLocalization("achievement." + "placedFilter", "en_US", "First filter");
		LanguageRegistry.instance().addStringLocalization("achievement." + "placedFilter" + ".desc", "en_US", "Placing your first filter");
		LanguageRegistry.instance().addStringLocalization("achievement." + "placedCrusher", "en_US", "First crusher");
		LanguageRegistry.instance().addStringLocalization("achievement." + "placedCrusher" + ".desc", "en_US", "Placing your first crusher");
	}
	
	private ConfigAchievements(){
	
	}
	
	private static ConfigAchievements instance = new ConfigAchievements();
	
	public static ConfigAchievements getInstance(){
		return instance;
	}
}

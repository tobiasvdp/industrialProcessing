package ip.industrialProcessing.config;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraftforge.common.AchievementPage;

public class ConfigAchievements {
	private int placedFilter = 2001;
	private int achPlacedCrusher = 2002;
	private int achHammer = 2003;
	
	public static int PlacedFilterID(){return getInstance().placedFilter;}
	public static int PlacedCrusherID(){return getInstance().achPlacedCrusher;}
	public static int madeHammerID(){return getInstance().achHammer;}
	
	public void registerAchievments(){
		ISetupAchievements.achPage.getAchievements().add(ISetupAchievements.achPlacedFilter);
		ISetupAchievements.achPage.getAchievements().add(ISetupAchievements.achPlacedCrusher);
		ISetupAchievements.achPage.getAchievements().add(ISetupAchievements.achHammer);
		AchievementPage.registerAchievementPage(ISetupAchievements.achPage);
		
		LanguageRegistry.instance().addStringLocalization("achievement." + "placedFilter", "en_US", "First filter");
		LanguageRegistry.instance().addStringLocalization("achievement." + "placedFilter" + ".desc", "en_US", "Placing your first filter");
		LanguageRegistry.instance().addStringLocalization("achievement." + "placedCrusher", "en_US", "First crusher");
		LanguageRegistry.instance().addStringLocalization("achievement." + "placedCrusher" + ".desc", "en_US", "Placing your first crusher");
		
		LanguageRegistry.instance().addStringLocalization("achievement." + "madeHammer", "en_US", "Hammer time");
		LanguageRegistry.instance().addStringLocalization("achievement." + "madeHammer" + ".desc", "en_US", "Hit that thing");
	}
	
	private ConfigAchievements(){
	
	}
	
	private static ConfigAchievements instance = new ConfigAchievements();
	
	public static ConfigAchievements getInstance(){
		return instance;
	}
}

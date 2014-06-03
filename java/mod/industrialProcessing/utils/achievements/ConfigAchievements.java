package mod.industrialProcessing.utils.achievements;

import net.minecraftforge.common.AchievementPage;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ConfigAchievements {
	
	public void registerAchievments(){
		ISetupAchievements.achPage.getAchievements().add(ISetupAchievements.achPlacedFilter);
		ISetupAchievements.achPage.getAchievements().add(ISetupAchievements.achPlacedCrusher);
		ISetupAchievements.achPage.getAchievements().add(ISetupAchievements.achHammer);
		AchievementPage.registerAchievementPage(ISetupAchievements.achPage);
	}
	
	private ConfigAchievements(){
	
	}
	
	private static ConfigAchievements instance = new ConfigAchievements();
	
	public static ConfigAchievements getInstance(){
		return instance;
	}
}

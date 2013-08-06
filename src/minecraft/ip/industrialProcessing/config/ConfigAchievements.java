package ip.industrialProcessing.config;

public class ConfigAchievements {
	private int placedFilter = 2001;
	private int achPlacedCrusher = 2002;
	
	public static int PlacedFilterID(){return getInstance().placedFilter;}
	public static int PlacedCrusherID(){return getInstance().achPlacedCrusher;}
	
	private ConfigAchievements(){
	
	}
	
	private static ConfigAchievements instance = new ConfigAchievements();
	
	public static ConfigAchievements getInstance(){
		return instance;
	}
}

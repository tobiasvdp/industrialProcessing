package ip.industrialProcessing.config;

import ip.industrialProcessing.IndustrialProcessing;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public interface ISetupAchievements {
	public static AchievementPage achPage = new AchievementPage("Industrial Processing");
    public static Achievement achPlacedFilter = new Achievement(ConfigAchievements.PlacedFilterID(), "placedFilter", 0, 0, IndustrialProcessing.blockFilter, null).registerAchievement();
    public static Achievement achPlacedCrusher = new Achievement(ConfigAchievements.PlacedCrusherID(), "placedCrusher", 0, -1, IndustrialProcessing.blockCrusher, achPlacedFilter).registerAchievement();
}

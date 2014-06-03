package mod.industrialProcessing.utils.achievements;

import mod.industrialProcessing.IndustrialProcessing;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public interface ISetupAchievements {
	public static AchievementPage achPage = new AchievementPage("Industrial Processing");
    public static Achievement achPlacedFilter = new Achievement("placedFilter","placedFilter", 0, 11, IndustrialProcessing.blockFilter, null).registerStat();
    public static Achievement achPlacedCrusher = new Achievement("placedCrusher","placedCrusher", 0, 10, IndustrialProcessing.blockCrusher, achPlacedFilter).registerStat();
    public static Achievement achHammer = new Achievement("madeHammer","madeHammer", 0, 12, IndustrialProcessing.itemHammer, null).registerStat();
}

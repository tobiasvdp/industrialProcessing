package mod.industrialProcessing.utils;

import net.minecraft.world.World;

public class Sun implements ISolar{

	@Override
	public int getSunLight(World world) {
		int brightness = (int) ((world.getSunBrightness(1.0f)-0.2f)*100);
		return brightness;
	}

}

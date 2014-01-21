package ip.industrialProcessing.subMod.power.config;

import ip.industrialProcessing.subMod.power.plant.creative.BlockCreativeGenerator;
import ip.industrialProcessing.subMod.power.plant.solar.standingSolarPanel.BlockStandingSolarPanel;

public interface ISetupPower {
	public static final BlockCreativeGenerator blockCreativeGenerator =new BlockCreativeGenerator();
	public static final BlockStandingSolarPanel blockStandingSolarPanel =new BlockStandingSolarPanel();
}

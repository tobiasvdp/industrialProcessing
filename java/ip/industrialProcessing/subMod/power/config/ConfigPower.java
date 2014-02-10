package ip.industrialProcessing.subMod.power.config;

import ip.industrialProcessing.api.config.ConfigCategories;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.subMod.power.IPPower;
import ip.industrialProcessing.subMod.power.plant.creative.TileEntityCreativeGenerator;
import ip.industrialProcessing.subMod.power.plant.solar.standingSolarPanel.TileEntityStandingSolarPanel;
import ip.industrialProcessing.utils.registry.BlockType;

public class ConfigPower {
	private static ConfigPower instance = new ConfigPower();
	
	private int creativeEngineID = IPPower.config.get(ConfigCategories.power.toString(), "creativeEngineID", 840).getInt();
	
	private int standingSolarPanelID = IPPower.config.get(ConfigCategories.power.toString(), "standingSolarPanelID", 841).getInt();
	private int rendererStandingSolarPanel;
	
	public void register(){
		ConfigMachineBlocks.getInstance();
		ConfigMachineBlocks.registerMachineBlock(ISetupPower.blockCreativeGenerator, "IP.Power.Creat", "Creative engine", TileEntityCreativeGenerator.class, BlockType.Power);
		ConfigMachineBlocks.getInstance();
		ConfigMachineBlocks.registerMachineBlock(ISetupPower.blockStandingSolarPanel, "IP.Power.StSolar", "Standing solar panels", TileEntityStandingSolarPanel.class, BlockType.Power);
	}
	
	public static ConfigPower getInstance() {
		return instance ;
	}
	
	public static int getCreativeEngineID(){
		return getInstance().creativeEngineID;
	}
	
	public static int getStandingSolarPanelID(){
		return getInstance().standingSolarPanelID;
	}
	
	public static int getRendererStandingSolarPanel(){
		return getInstance().rendererStandingSolarPanel;
	}
	
	public static void setRendererStandingSolarPanel(int id){
		getInstance().rendererStandingSolarPanel = id;
	}
}

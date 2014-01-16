package ip.industrialProcessing.config;

import net.minecraft.block.Block;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.api.config.ConfigCategories;
import ip.industrialProcessing.utils.SuspensionList;

public class ConfigTransportBlocks {
    private int blockTransportFluidsID = IndustrialProcessing.config.get(ConfigCategories.transport.toString(), "FluidPipeID", 3500).getInt();
    private int blockTransportFluidPumpID = IndustrialProcessing.config.get(ConfigCategories.transport.toString(), "FluidPumpID", 3501).getInt();
    private int blockTransportFluidTankID = IndustrialProcessing.config.get(ConfigCategories.transport.toString(), "FluidTankID", 3502).getInt();
    private int blockTransportFluidManometerID = IndustrialProcessing.config.get(ConfigCategories.transport.toString(), "FluidManometerID", 3503).getInt();
    private int blockTransportFluidRainTankID = IndustrialProcessing.config.get(ConfigCategories.transport.toString(), "FluidRaintankID", 3504).getInt();
    private int blockTransportFluidValveID = IndustrialProcessing.config.get(ConfigCategories.transport.toString(), "FluidValveID", 3505).getInt();
    private int blockTransportFluidGrateID = IndustrialProcessing.config.get(ConfigCategories.transport.toString(), "FluidGrateID", 3506).getInt();
    private int blockTransportFluidsWoodID = IndustrialProcessing.config.get(ConfigCategories.transport.toString(), "FluidPipeWoodID", 3507).getInt();
    private int blockTransportFluidsStoneID = IndustrialProcessing.config.get(ConfigCategories.transport.toString(), "FluidPipeStoneID", 3508).getInt();
    private int blockSuspendedRailID = IndustrialProcessing.config.get(ConfigCategories.transport.toString(), "blockSuspendedRailID", 3509).getInt();
    private int blockSuspensionID = IndustrialProcessing.config.get(ConfigCategories.transport.toString(), "blockSuspensionID", 3510).getInt();

    private SuspensionList suspensionList = new SuspensionList();
    
    public static SuspensionList getSuspensionList(){
    	return getInstance().suspensionList;
    }

    public static int getBlockSuspensionID() {
        return getInstance().blockSuspensionID;
    }
    public static int getBlockSuspendedRailID() {
        return getInstance().blockSuspendedRailID;
    }
    public static int getBlockTransportFluidsID() {
        return getInstance().blockTransportFluidsID;
    }

    public static int getBlockTransportFluidsWoodID() {
        return getInstance().blockTransportFluidsWoodID;
    }

    public static int getBlockTransportFluidsStoneID() {
        return getInstance().blockTransportFluidsStoneID;
    }

    public static int getBlockTransportFluidPumpID() {
        return getInstance().blockTransportFluidPumpID;
    }

    public static int getBlockTransportFluidTankID() {
        return getInstance().blockTransportFluidTankID;
    }

    public static int getBlockTransportFluidManometerID() {
        return getInstance().blockTransportFluidManometerID;
    }

    public static int getBlockTransportFluidGrateID() {
        return getInstance().blockTransportFluidGrateID;
    }

    public static int getBlockRainTankID() {
        return getInstance().blockTransportFluidRainTankID;
    }

    public static int getBlockValveID() {
        return getInstance().blockTransportFluidValveID;
    }

    public void register() {
    	registerBlock(ISetupTransportBlocks.blockSuspendedRail, "Ip.Trans.SusRail", "Suspended rail");
    	registerSuspension(ISetupTransportBlocks.blockSuspension, "Ip.Trans.Sus", "Suspension");
    }

    private static ConfigTransportBlocks instance = new ConfigTransportBlocks();

    public static ConfigTransportBlocks getInstance() {
        return instance;
    }
    
    private void registerTileEntity(Block block, String uniqueId, String displayName, Class tileEntity) {
        GameRegistry.registerBlock(block, uniqueId);
        MinecraftForge.setBlockHarvestLevel(block, "pickaxe", 1);
        LanguageRegistry.addName(block, displayName);
        ModLoader.registerTileEntity(tileEntity, uniqueId);
    }
    private void registerBlock(Block block, String uniqueId, String displayName) {
        GameRegistry.registerBlock(block, uniqueId);
        MinecraftForge.setBlockHarvestLevel(block, "pickaxe", 1);
        LanguageRegistry.addName(block, displayName);
    }
    private void registerSuspension(Block block, String uniqueId, String displayName) {
    	registerBlock(block,uniqueId,displayName);
    	suspensionList.add(block.blockID);
    }

}

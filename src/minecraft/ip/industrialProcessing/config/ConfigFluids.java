package ip.industrialProcessing.config;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.api.config.ConfigCategories;
import ip.industrialProcessing.items.ItemIPBucket;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidContainerRegistry.FluidContainerData;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ConfigFluids {

    private static ConfigFluids instance = new ConfigFluids();

    public static int blockFluidBaseDirtyWaterID() {
        return getInstance().blockFluidBaseDirtyWaterID;
    }

    public static int blockFluidBaseExhaustGasID() {
        return getInstance().blockFluidBaseExhaustGasID;
    }

    public static int blockFluidBasefiltyWaterID() {
        return getInstance().blockFluidBasefiltyWaterID;
    }

    public static int blockFluidBaseGritSludgeID() {
        return getInstance().blockFluidBaseGritSludgeID;
    }

    public static int blockFluidBaseHotSlagID() {
        return getInstance().blockFluidBaseHotSlagID;
    }

    public static int blockFluidBaseHotSteelID() {
        return getInstance().blockFluidBaseHotSteelID;
    }

    public static int blockFluidBaseMicrobialWaterID() {
        return getInstance().blockFluidBaseMicrobialWaterID;
    }

    public static int blockFluidBaseMixedSludgeChromiteID() {
        return getInstance().blockFluidBaseMixedSludgeChromiteID;
    }

    public static int blockFluidBaseMixedSludgeCopperID() {
        return getInstance().blockFluidBaseMixedSludgeCopperID;
    }

    public static int blockFluidBaseMixedSludgeGalenaID() {
        return getInstance().blockFluidBaseMixedSludgeGalenaID;
    }

    public static int blockFluidBaseMixedSludgeGoldID() {
        return getInstance().blockFluidBaseMixedSludgeGoldID;
    }

    public static int blockFluidBaseMixedSludgeIronID() {
        return getInstance().blockFluidBaseMixedSludgeIronID;
    }

    public static int blockFluidBaseMixedSludgeTaliaID() {
        return getInstance().blockFluidBaseMixedSludgeTaliaID;
    }

    public static int blockFluidBaseMixedSludgeTinID() {
        return getInstance().blockFluidBaseMixedSludgeTinID;
    }

    public static int blockFluidBaseOreSludgeChromiteID() {
        return getInstance().blockFluidBaseOreSludgeChromiteID;
    }

    public static int blockFluidBaseOreSludgeCopperID() {
        return getInstance().blockFluidBaseOreSludgeCopperID;
    }

    public static int blockFluidBaseOreSludgeGalenaID() {
        return getInstance().blockFluidBaseOreSludgeGalenaID;
    }

    public static int blockFluidBaseOreSludgeGoldID() {
        return getInstance().blockFluidBaseOreSludgeGoldID;
    }

    public static int blockFluidBaseOreSludgeIronID() {
        return getInstance().blockFluidBaseOreSludgeIronID;
    }

    public static int blockFluidBaseOreSludgeTaliaID() {
        return getInstance().blockFluidBaseOreSludgeTaliaID;
    }

    public static int blockFluidBaseOreSludgeTinID() {
        return getInstance().blockFluidBaseOreSludgeTinID;
    }

    public static int blockFluidBasePigIronID() {
        return getInstance().blockFluidBasePigIronID;
    }

    public static int blockFluidBaseResiduID() {
        return getInstance().blockFluidBaseResiduID;
    }

    public static int blockFluidBaseSteamID() {
        return getInstance().blockFluidBaseSteamID;
    }

    public static int blockFluidBaseUncleanWaterID() {
        return getInstance().blockFluidBaseUncleanWaterID;
    }

    public static int BucketDirtyWaterID() {
        return getInstance().BucketDirtyWaterID;
    }

    public static int BucketfiltyWaterID() {
        return getInstance().BucketfiltyWaterID;
    }

    public static int BucketGritSludgeID() {
        return getInstance().BucketGritSludgeID;
    }

    public static int BucketHotSlagID() {
        return getInstance().BucketHotSlagID;
    }

    public static int BucketHotSteelID() {
        return getInstance().BucketHotSteelID;
    }

    public static int BucketMicrobialWaterID() {
        return getInstance().BucketMicrobialWaterID;
    }

    public static int bucketOreSludgeChromiteID() {
        return getInstance().bucketOreSludgeChromiteID;
    }

    public static int BucketOreSludgeCopperID() {
        return getInstance().BucketOreSludgeCopperID;
    }

    public static int bucketOreSludgeGalenaID() {
        return getInstance().bucketOreSludgeGalenaID;
    }

    public static int bucketOreSludgeGoldID() {
        return getInstance().bucketOreSludgeGoldID;
    }

    public static int BucketOreSludgeIronID() {
        return getInstance().BucketOreSludgeIronID;
    }

    public static int bucketOreSludgeTaliaID() {
        return getInstance().bucketOreSludgeTaliaID;
    }

    public static int BucketOreSludgeTinID() {
        return getInstance().BucketOreSludgeTinID;
    }

    public static int bucketMixedSludgeChromiteID() {
        return getInstance().bucketMixedSludgeChromiteID;
    }

    public static int BucketMixedSludgeCopperID() {
        return getInstance().BucketMixedSludgeCopperID;
    }

    public static int bucketMixedSludgeGalenaID() {
        return getInstance().bucketMixedSludgeGalenaID;
    }

    public static int bucketMixedSludgeGoldID() {
        return getInstance().bucketMixedSludgeGoldID;
    }

    public static int BucketMixedSludgeIronID() {
        return getInstance().BucketMixedSludgeIronID;
    }

    public static int bucketMixedSludgeTaliaID() {
        return getInstance().bucketMixedSludgeTaliaID;
    }

    public static int BucketMixedSludgeTinID() {
        return getInstance().BucketMixedSludgeTinID;
    }

    public static int BucketPigIronID() {
        return getInstance().BucketPigIronID;
    }

    public static int BucketResiduID() {
        return getInstance().BucketResiduID;
    }

    public static int BucketUncleanWaterID() {
        return getInstance().BucketUncleanWaterID;
    }

    public static int getAirFluidBlockID() {
        return getInstance().blockFluidBaseAirID;
    }

    public static int getAlkylateFluidBlockID() {
        return getInstance().blockFluidBaseAlkylateID;
    }

    public static int getAsphaltSludgeFluidBlockID() {
        return getInstance().blockFluidBaseAsphaltSludgeID;
    }

    public static int getAsphaltSludgeFluidBucketID() {
        return getInstance().BucketAsphaltSludgeID;
    }

    public static int getButaneFluidBlockID() {
        return getInstance().blockFluidBaseButaneID;
    }

    public static int getCO2FluidBlockID() {
        return getInstance().blockFluidBaseCO2ID;
    }

    public static int getFuelGasFluidBlockID() {
        return getInstance().blockFluidBaseFuelGasID;
    }

    public static int getGasMixFluidBlockID() {
        return getInstance().blockFluidBaseGasMixID;
    }

    public static int getH2FluidBlockID() {
        return getInstance().blockFluidBaseH2ID;
    }

    public static int getH2SFluidBlockID() {
        return getInstance().blockFluidBaseH2SID;
    }

    public static ConfigFluids getInstance() {
        return instance;
    }

    public static int getIsoButaneFluidBlockID() {
        return getInstance().blockFluidBaseIsoButaneID;
    }

    public static int getIsomerateFluidBlockID() {
        return getInstance().blockFluidBaseIsomerateID;
    }

    public static int getLatexFluidBlockID() {
        return getInstance().blockFluidBaseLatexID;
    }

    public static int getLatexFluidBucketID() {
        return getInstance().bucketLatexID;
    }

    public static int getParaffinicNaphthaFluidBlockID() {
        return getInstance().blockFluidBaseParaffinicNaphthaID;
    }

    public static int getSourWaterFluidBlockID() {
        return getInstance().blockFluidBaseSourWaterID;
    }

    public static int getSourWaterFluidBucketID() {
        return getInstance().BucketSourWaterID;
    }

    public static int getUnsweetenedButaneFluidBlockID() {
        return getInstance().blockFluidBaseUnsweetenedButaneID;
    }

    public static int getUnsweetenedLPGFluidBlockID() {
        return getInstance().blockFluidBaseUnsweetenedLPGID;
    }
    
    public static int getAtmoshepicBottomsFluidBlock() {
        return getInstance().blockFluidBaseAtmosphericBottoms;
    }

    public static int getAtmoshepicBottomsFluidBucket() {
        return getInstance().bucketAtmosphericBottoms;
    }
    public static int getGasOilFluidBlock() {
        return getInstance().blockFluidBaseGasOil;
    }

    public static int getGasOilFluidBucket() {
        return getInstance().bucketGasOil;
    }
    public static int getDieselOilFluidBlock() {
        return getInstance().blockFluidBaseDieselOil;
    }

    public static int getDieselOilFluidBucket() {
        return getInstance().bucketDieselOil;
    }
    public static int getKeroseneFluidBlock() {
        return getInstance().blockFluidBaseKerosene;
    }

    public static int getKeroseneFluidBucket() {
        return getInstance().bucketKerosene;
    }
    public static int getHeavyNaphthaFluidBlock() {
        return getInstance().blockFluidBaseHeavyNaphtha;
    }

    public static int getHeavyNaphthaFluidBucket() {
        return getInstance().bucketHeavyNaphtha;
    }
    public static int getLightNaphthaFluidBlock() {
        return getInstance().blockFluidBaseLightNaphtha;
    }

    public static int getLightNaphthaFluidBucket() {
        return getInstance().bucketLightNaphtha;
    }
    
    public static int getUntreatedKeroseneFluidBlock() {
        return getInstance().blockFluidBaseUntreatedKerosene;
    }

    public static int getUntreatedKeroseneFluidBucket() {
        return getInstance().bucketUntreatedKerosene;
    }
    
    public static int getUntreatedDieselOilFluidBlock() {
        return getInstance().blockFluidBaseUntreatedDieselOil;
    }

    public static int getUntreatedDieselOilFluidBucket() {
        return getInstance().bucketUntreatedDieselOil;
    }
    
    public static int getHeavyvacuumGasOilFluidBlock() {
        return getInstance().blockFluidBaseHeavyvacuumGasOil;
    }

    public static int getHeavyvacuumGasOilFluidBucket() {
        return getInstance().bucketHeavyvacuumGasOil;
    }
    
    public static int getLightvacuumGasOilFluidBlock() {
        return getInstance().blockFluidBaseLightvacuumGasOil;
    }

    public static int getLightvacuumGasOilFluidBucket() {
        return getInstance().bucketLightvacuumGasOil;
    }
    
    public static int getHeavyVirginNaphthaFluidBlock() {
        return getInstance().blockFluidBaseHeavyVirginNaphtha;
    }

    public static int getHeavyVirginNaphthaFluidBucket() {
        return getInstance().bucketHeavyVirginNaphtha;
    }
    
    public static int getParaffinicNaphthaFluidBlock() {
        return getInstance().blockFluidBaseParaffinicNaphtha;
    }

    public static int getParaffinicNaphthaFluidBucket() {
        return getInstance().bucketParaffinicNaphtha;
    }
    
    public static int getResinFluidBlockID() {
        return getInstance().blockFluidBaseResin;
    }

    public static int getResinFluidBucketID() {
        return getInstance().bucketResin;
    }
    
    private int offset = 2500;

    private int blockFluidBaseDirtyWaterID = IndustrialProcessing.config.get(ConfigCategories.fluids.toString(), "DirtyWaterID", offset).getInt();

    private int BucketDirtyWaterID = offset + 1;

    private int blockFluidBaseOreSludgeIronID = IndustrialProcessing.config.get(ConfigCategories.fluids.toString(), "IronSludgeID", offset + 2).getInt();

    private int blockFluidBaseOreSludgeCopperID = IndustrialProcessing.config.get(ConfigCategories.fluids.toString(), "CopperSludgeID", offset + 3).getInt();

    private int blockFluidBaseOreSludgeTinID = IndustrialProcessing.config.get(ConfigCategories.fluids.toString(), "TinSludgeID", offset + 4).getInt();

    private int BucketOreSludgeIronID = offset + 5;

    private int BucketOreSludgeCopperID = offset + 6;

    private int BucketOreSludgeTinID = offset + 7;

    private int BucketHotSlagID = offset + 8;

    private int BucketPigIronID = offset + 9;

    private int BucketHotSteelID = offset + 10;

    private int blockFluidBaseHotSlagID = IndustrialProcessing.config.get(ConfigCategories.fluids.toString(), "HotSlagID", offset + 11).getInt();

    private int blockFluidBasePigIronID = IndustrialProcessing.config.get(ConfigCategories.fluids.toString(), "PigIronID", offset + 12).getInt();

    private int blockFluidBaseHotSteelID = IndustrialProcessing.config.get(ConfigCategories.fluids.toString(), "HotSteelID", offset + 13).getInt();

    private int blockFluidBaseExhaustGasID = IndustrialProcessing.config.get(ConfigCategories.fluids.toString(), "ExhaustGasID", offset + 14).getInt();

    private int blockFluidBaseSteamID = IndustrialProcessing.config.get(ConfigCategories.fluids.toString(), "SteamID", offset + 15).getInt();

    private int bucketOreSludgeChromiteID = offset + 16;

    private int bucketOreSludgeGalenaID = offset + 17;

    private int bucketOreSludgeGoldID = offset + 18;

    private int bucketOreSludgeTaliaID = offset + 19;

    private int blockFluidBaseOreSludgeChromiteID = IndustrialProcessing.config.get(ConfigCategories.fluids.toString(), "ChromiteSludgeID", offset + 20).getInt();

    private int blockFluidBaseOreSludgeGalenaID = IndustrialProcessing.config.get(ConfigCategories.fluids.toString(), "GalenaSludgeID", offset + 21).getInt();

    private int blockFluidBaseOreSludgeGoldID = IndustrialProcessing.config.get(ConfigCategories.fluids.toString(), "GoldSludgeID", offset + 22).getInt();

    private int blockFluidBaseOreSludgeTaliaID = IndustrialProcessing.config.get(ConfigCategories.fluids.toString(), "TaliaSludgeID", offset + 23).getInt();

    private int blockFluidBasefiltyWaterID = offset + 24;

    private int BucketfiltyWaterID = offset + 25;

    private int blockFluidBaseGritSludgeID = offset + 26;

    private int BucketGritSludgeID = offset + 27;

    private int blockFluidBaseUncleanWaterID = offset + 28;

    private int BucketUncleanWaterID = offset + 29;

    private int blockFluidBaseResiduID = offset + 30;

    private int BucketResiduID = offset + 31;

    private int blockFluidBaseMicrobialWaterID = offset + 32;

    private int BucketMicrobialWaterID = offset + 33;

    private int blockFluidBaseLatexID = offset + 34;

    private int bucketLatexID = offset + 35;

    private int blockFluidBaseAirID = offset + 36;

    private int blockFluidBaseCO2ID = offset + 37;

    private int blockFluidBaseH2ID = offset + 38;

    private int blockFluidBaseH2SID = offset + 39;

    private int blockFluidBaseSourWaterID = offset + 40;

    private int BucketSourWaterID = offset + 41;

    private int blockFluidBaseAsphaltSludgeID = offset + 42;

    private int BucketAsphaltSludgeID = offset + 43;

    private int blockFluidBaseFuelGasID = offset + 44;

    private int blockFluidBaseUnsweetenedLPGID = offset + 45;

    private int blockFluidBaseUnsweetenedButaneID = offset + 46;

    private int blockFluidBaseGasMixID = offset + 47;

    private int blockFluidBaseParaffinicNaphthaID = offset + 48;

    private int blockFluidBaseIsomerateID = offset + 49;

    private int blockFluidBaseIsoButaneID = offset + 50;

    private int blockFluidBaseButaneID = offset + 51;

    private int blockFluidBaseAlkylateID = offset + 52;

    private int blockFluidBaseMixedSludgeChromiteID = IndustrialProcessing.config.get(ConfigCategories.fluids.toString(), "ChromiteMixedSludgeID", offset + 53).getInt();

    private int blockFluidBaseMixedSludgeGalenaID = IndustrialProcessing.config.get(ConfigCategories.fluids.toString(), "GalenaMixedSludgeID", offset + 54).getInt();

    private int blockFluidBaseMixedSludgeGoldID = IndustrialProcessing.config.get(ConfigCategories.fluids.toString(), "GoldMixedSludgeID", offset + 55).getInt();

    private int blockFluidBaseMixedSludgeTaliaID = IndustrialProcessing.config.get(ConfigCategories.fluids.toString(), "TaliaMixedSludgeID", offset + 56).getInt();

    private int blockFluidBaseMixedSludgeIronID = IndustrialProcessing.config.get(ConfigCategories.fluids.toString(), "IronMixedSludgeID", offset + 57).getInt();

    private int blockFluidBaseMixedSludgeCopperID = IndustrialProcessing.config.get(ConfigCategories.fluids.toString(), "CopperMixedSludgeID", offset + 58).getInt();

    private int blockFluidBaseMixedSludgeTinID = IndustrialProcessing.config.get(ConfigCategories.fluids.toString(), "TinMixedSludgeID", offset + 59).getInt();

    private int BucketMixedSludgeIronID = offset + 60;

    private int BucketMixedSludgeCopperID = offset + 61;

    private int BucketMixedSludgeTinID = offset + 62;

    private int bucketMixedSludgeChromiteID = offset + 63;

    private int bucketMixedSludgeGalenaID = offset + 64;

    private int bucketMixedSludgeGoldID = offset + 65;

    private int bucketMixedSludgeTaliaID = offset + 66;
    
    private int blockFluidBaseLightNaphtha = offset + 67;
    private int bucketLightNaphtha = offset + 68;
    
    private int blockFluidBaseHeavyNaphtha = offset + 69;
    private int bucketHeavyNaphtha = offset + 70;
    
    private int blockFluidBaseKerosene = offset + 71;
    private int bucketKerosene = offset + 72;
    
    private int blockFluidBaseDieselOil = offset + 73;
    private int bucketDieselOil = offset + 74;
    
    private int blockFluidBaseGasOil = offset + 75;
    private int bucketGasOil = offset + 76;
    
    private int blockFluidBaseAtmosphericBottoms = offset + 77;
    private int bucketAtmosphericBottoms = offset + 78;
    
    private int blockFluidBaseUntreatedKerosene = offset + 79;
    private int bucketUntreatedKerosene = offset + 80;
    
    private int blockFluidBaseUntreatedDieselOil = offset + 81;
    private int bucketUntreatedDieselOil = offset + 82;
    
    private int blockFluidBaseHeavyvacuumGasOil = offset + 83;
    private int bucketHeavyvacuumGasOil = offset + 84;
    
    private int blockFluidBaseLightvacuumGasOil = offset + 85;
    private int bucketLightvacuumGasOil = offset + 86;
    
    private int blockFluidBaseHeavyVirginNaphtha = offset + 87;
    private int bucketHeavyVirginNaphtha = offset + 88;
    
    private int blockFluidBaseParaffinicNaphtha = offset + 89;
    private int bucketParaffinicNaphtha = offset + 90;
    
    private int blockFluidBaseResin = offset + 91;
    private int bucketResin = offset + 92;

    public ConfigFluids() {

    }

    private void registerFluid(Block block, Fluid fluid, ItemIPBucket bucket, String displayName) {
        GameRegistry.registerBlock(block, "BlockFluid" + fluid.getName());
        LanguageRegistry.addName(block, displayName);
        if (bucket != null) {
            FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack(fluid.getName(), FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(bucket), new ItemStack(Item.bucketEmpty)));
        }
        // FluidRegistry.registerFluid(fluid) is done in constructor of
        // itemFluid;
    }

    public void registerFluids() {
        registerFluid(ISetupFluids.blockFluidIsoButane, ISetupFluids.itemFluidIsoButane, null, "Isobutane");
        registerFluid(ISetupFluids.blockFluidButane, ISetupFluids.itemFluidButane, null, "Butane");
        registerFluid(ISetupFluids.blockFluidAlkylate, ISetupFluids.itemFluidAlkylate, null, "Alkylate"); 
        registerFluid(ISetupFluids.blockFluidIsomerate, ISetupFluids.itemFluidIsomerate, null, "Isomerate");
        registerFluid(ISetupFluids.blockFluidUnsweetenedLPG, ISetupFluids.itemFluidUnsweetenedLPG, null, "Unsweetened LPG");
        registerFluid(ISetupFluids.blockFluidUnsweetenedButane, ISetupFluids.itemFluidUnsweetenedButane, null, "Unsweetened Butane");
        registerFluid(ISetupFluids.blockFluidFuelGas, ISetupFluids.itemFluidFuelGas, null, "Fuel gas");
        registerFluid(ISetupFluids.blockFluidGasMix, ISetupFluids.itemFluidGasMix, null, "Gas mix");
        
        registerFluid(ISetupFluids.blockFluidResin, ISetupFluids.itemFluidResin, ISetupFluids.bucketResin, "Resin");
        LanguageRegistry.addName(ISetupFluids.bucketResin, "Resin Bucket");
        
        registerFluid(ISetupFluids.blockFluidParaffinicNaphtha, ISetupFluids.itemFluidParaffinicNaphtha, ISetupFluids.bucketParaffinicNaphtha, "Paraffinic naphtha");
        LanguageRegistry.addName(ISetupFluids.bucketParaffinicNaphtha, "Paraffinic naphtha Bucket");
        
        registerFluid(ISetupFluids.blockFluidHeavyVirginNaphtha, ISetupFluids.itemFluidHeavyVirginNaphtha, ISetupFluids.bucketHeavyVirginNaphtha, "Heavy virgin naphtha");
        LanguageRegistry.addName(ISetupFluids.bucketHeavyVirginNaphtha, "Heavy virgin naphtha Bucket");
        
        registerFluid(ISetupFluids.blockFluidLightVacuumGasOil, ISetupFluids.itemFluidLightVacuumGasOil, ISetupFluids.bucketLightVacuumGasOil, "Light vacuum gasOil");
        LanguageRegistry.addName(ISetupFluids.bucketLightVacuumGasOil, "Light vacuum gasOil Bucket");

        registerFluid(ISetupFluids.blockFluidHeavyvacuumGasOil, ISetupFluids.itemFluidHeavyvacuumGasOil, ISetupFluids.bucketHeavyvacuumGasOil, "Heavy vacuum gasOil");
        LanguageRegistry.addName(ISetupFluids.bucketHeavyvacuumGasOil, "Heavy vacuum gasOil Bucket");
        
        registerFluid(ISetupFluids.blockFluidUntreatedDieselOil, ISetupFluids.itemFluidUntreatedDieselOil, ISetupFluids.bucketUntreatedDieselOil, "Untreated diesel Oil");
        LanguageRegistry.addName(ISetupFluids.bucketUntreatedDieselOil, "Untreated diesel Oil Bucket");

        registerFluid(ISetupFluids.blockFluidUntreatedKerosene, ISetupFluids.itemFluidUntreatedKerosene, ISetupFluids.bucketUntreatedKerosene, "Untreated kerosene");
        LanguageRegistry.addName(ISetupFluids.bucketUntreatedKerosene, "Untreated kerosene Bucket");
        
        registerFluid(ISetupFluids.blockFluidLightNaphtha, ISetupFluids.itemFluidLightNaphtha, ISetupFluids.bucketLightNaphtha, "Light naphtha");
        LanguageRegistry.addName(ISetupFluids.bucketLightNaphtha, "Light naphtha Bucket");
        
        registerFluid(ISetupFluids.blockFluidHeavyNaphtha, ISetupFluids.itemFluidHeavyNaphtha, ISetupFluids.bucketHeavyNaphtha, "Heavy naphtha");
        LanguageRegistry.addName(ISetupFluids.bucketHeavyNaphtha, "Heavy naphtha Bucket");
        
        registerFluid(ISetupFluids.blockFluidKerosene, ISetupFluids.itemFluidKerosene, ISetupFluids.bucketKerosene, "Kerosene");
        LanguageRegistry.addName(ISetupFluids.bucketKerosene, "Kerosene Bucket");
        
        registerFluid(ISetupFluids.blockFluidDieselOil, ISetupFluids.itemFluidDieselOil, ISetupFluids.bucketDieselOil, "Diesel oil");
        LanguageRegistry.addName(ISetupFluids.bucketDieselOil, "Diesel oil Bucket");
        
        registerFluid(ISetupFluids.blockFluidGasOil, ISetupFluids.itemFluidGasOil, ISetupFluids.bucketGasOil, "Gasoil");
        LanguageRegistry.addName(ISetupFluids.bucketGasOil, "Gasoil Bucket");
        
        registerFluid(ISetupFluids.blockFluidAtmosphericBottoms, ISetupFluids.itemFluidAtmosphericBottoms, ISetupFluids.bucketAtmosphericBottoms, "Atmospheric bottoms");
        LanguageRegistry.addName(ISetupFluids.bucketAtmosphericBottoms, "Atmospheric bottoms Bucket");
        
        registerFluid(ISetupFluids.blockFluidAsphaltSludge, ISetupFluids.itemFluidAsphaltSludge, ISetupFluids.bucketAsphaltSludge, "Asphalt sludge");
        LanguageRegistry.addName(ISetupFluids.bucketAsphaltSludge, "Asphalt sludge Bucket");

        registerFluid(ISetupFluids.blockFluidH2S, ISetupFluids.itemFluidH2S, null, "H2S");

        registerFluid(ISetupFluids.blockFluidSourWater, ISetupFluids.itemFluidSourWater, ISetupFluids.bucketSourWater, "Sour water");
        LanguageRegistry.addName(ISetupFluids.bucketSourWater, "Sour water Bucket");

        registerFluid(ISetupFluids.blockFluidH2, ISetupFluids.itemFluidH2, null, "H2");
        registerFluid(ISetupFluids.blockFluidCO2, ISetupFluids.itemFluidCO2, null, "CO2");
        registerFluid(ISetupFluids.blockFluidAir, ISetupFluids.itemFluidAir, null, "Air");

        registerFluid(ISetupFluids.blockFluidLatex, ISetupFluids.itemFluidLatex, ISetupFluids.bucketFluidLatex, "Latex");
        LanguageRegistry.addName(ISetupFluids.bucketFluidLatex, "Latex Bucket");

        registerFluid(ISetupFluids.blockFluidMicrobialWater, ISetupFluids.itemFluidMicrobialWater, ISetupFluids.bucketMicrobialWater, "Microbial water");
        LanguageRegistry.addName(ISetupFluids.bucketMicrobialWater, "Microbial water Bucket");

        registerFluid(ISetupFluids.blockFluidUncleanWater, ISetupFluids.itemFluidUncleanWater, ISetupFluids.bucketUncleanWater, "Unclean water");
        LanguageRegistry.addName(ISetupFluids.bucketUncleanWater, "Unclean water Bucket");

        registerFluid(ISetupFluids.blockFluidResidu, ISetupFluids.itemFluidResidu, ISetupFluids.bucketResidu, "Residu");
        LanguageRegistry.addName(ISetupFluids.bucketResidu, "Residu Bucket");

        registerFluid(ISetupFluids.blockFluidGritSludge, ISetupFluids.itemFluidGritSludge, ISetupFluids.bucketGritSludge, "Grit sludge");
        LanguageRegistry.addName(ISetupFluids.bucketGritSludge, "Grit sludge Bucket");

        registerFluid(ISetupFluids.blockFluidDirtyWater, ISetupFluids.itemFluidDirtyWater, ISetupFluids.bucketDirtyWater, "Dirty water");
        LanguageRegistry.addName(ISetupFluids.bucketDirtyWater, "Dirty water Bucket");

        registerFluid(ISetupFluids.blockFluidfiltyWater, ISetupFluids.itemFluidfiltyWater, ISetupFluids.bucketfiltyWater, "Filty water");
        LanguageRegistry.addName(ISetupFluids.bucketfiltyWater, "Filty water Bucket");

        registerFluid(ISetupFluids.blockFluidOreSludgeIron, ISetupFluids.itemFluidOreSludgeIron, ISetupFluids.bucketOreSludgeIron, "Iron ore sludge");
        LanguageRegistry.addName(ISetupFluids.bucketOreSludgeIron, "Iron sludge Bucket");

        registerFluid(ISetupFluids.blockFluidOreSludgeCopper, ISetupFluids.itemFluidOreSludgeCopper, ISetupFluids.bucketOreSludgeCopper, "Copper ore sludge");
        LanguageRegistry.addName(ISetupFluids.bucketOreSludgeCopper, "Copper sludge Bucket");

        registerFluid(ISetupFluids.blockFluidOreSludgeTin, ISetupFluids.itemFluidOreSludgeTin, ISetupFluids.bucketOreSludgeTin, "Tin ore sludge");
        LanguageRegistry.addName(ISetupFluids.bucketOreSludgeTin, "Tin sludge Bucket");

        registerFluid(ISetupFluids.blockFluidHotSlag, ISetupFluids.itemFluidHotSlag, ISetupFluids.bucketHotSlag, "Hot slag");
        LanguageRegistry.addName(ISetupFluids.bucketHotSlag, "Hot slag Bucket");

        registerFluid(ISetupFluids.blockFluidPigIron, ISetupFluids.itemFluidPigIron, ISetupFluids.bucketPigIron, "Pig iron");
        LanguageRegistry.addName(ISetupFluids.bucketPigIron, "Pig iron Bucket");

        registerFluid(ISetupFluids.blockFluidHotSteel, ISetupFluids.itemFluidHotSteel, ISetupFluids.bucketHotSteel, "Molten steel");
        LanguageRegistry.addName(ISetupFluids.bucketHotSteel, "Molten steel Bucket");

        registerFluid(ISetupFluids.blockFluidExhaustGas, ISetupFluids.itemFluidExhaustGas, null, "Exhaust gas");

        registerFluid(ISetupFluids.blockFluidSteam, ISetupFluids.itemFluidSteam, null, "Steam");

        registerFluid(ISetupFluids.blockFluidOreSludgeChromite, ISetupFluids.itemFluidOreSludgeChromite, ISetupFluids.bucketOreSludgeChromite, "Chromite ore sludge");
        LanguageRegistry.addName(ISetupFluids.bucketOreSludgeChromite, "Chromite sludge Bucket");
        registerFluid(ISetupFluids.blockFluidOreSludgeGalena, ISetupFluids.itemFluidOreSludgeGalena, ISetupFluids.bucketOreSludgeGalena, "Galena ore sludge");
        LanguageRegistry.addName(ISetupFluids.bucketOreSludgeGalena, "Galena sludge Bucket");
        registerFluid(ISetupFluids.blockFluidOreSludgeGold, ISetupFluids.itemFluidOreSludgeGold, ISetupFluids.bucketOreSludgeGold, "Gold ore sludge");
        LanguageRegistry.addName(ISetupFluids.bucketOreSludgeGold, "Gold sludge Bucket");
        registerFluid(ISetupFluids.blockFluidOreSludgeTalia, ISetupFluids.itemFluidOreSludgeTalia, ISetupFluids.bucketOreSludgeTalia, "Thalium ore sludge");
        LanguageRegistry.addName(ISetupFluids.bucketOreSludgeTalia, "Thalium sludge Bucket");
        
        registerFluid(ISetupFluids.blockFluidMixedSludgeIron, ISetupFluids.itemFluidMixedSludgeIron, ISetupFluids.bucketMixedSludgeIron, "Iron ore mixedSludge");
        LanguageRegistry.addName(ISetupFluids.bucketMixedSludgeIron, "Iron mixedSludge Bucket");
        registerFluid(ISetupFluids.blockFluidMixedSludgeCopper, ISetupFluids.itemFluidMixedSludgeCopper, ISetupFluids.bucketMixedSludgeCopper, "Copper ore mixedSludge");
        LanguageRegistry.addName(ISetupFluids.bucketMixedSludgeCopper, "Copper mixedSludge Bucket");
        registerFluid(ISetupFluids.blockFluidMixedSludgeTin, ISetupFluids.itemFluidMixedSludgeTin, ISetupFluids.bucketMixedSludgeTin, "Tin ore mixedSludge");
        LanguageRegistry.addName(ISetupFluids.bucketMixedSludgeTin, "Tin mixedSludge Bucket");
        registerFluid(ISetupFluids.blockFluidMixedSludgeChromite, ISetupFluids.itemFluidMixedSludgeChromite, ISetupFluids.bucketMixedSludgeChromite, "Chromite ore mixedSludge");
        LanguageRegistry.addName(ISetupFluids.bucketMixedSludgeChromite, "Chromite mixedSludge Bucket");
        registerFluid(ISetupFluids.blockFluidMixedSludgeGalena, ISetupFluids.itemFluidMixedSludgeGalena, ISetupFluids.bucketMixedSludgeGalena, "Galena ore mixedSludge");
        LanguageRegistry.addName(ISetupFluids.bucketMixedSludgeGalena, "Galena mixedSludge Bucket");
        registerFluid(ISetupFluids.blockFluidMixedSludgeGold, ISetupFluids.itemFluidMixedSludgeGold, ISetupFluids.bucketMixedSludgeGold, "Gold ore mixedSludge");
        LanguageRegistry.addName(ISetupFluids.bucketMixedSludgeGold, "Gold mixedSludge Bucket");
        registerFluid(ISetupFluids.blockFluidMixedSludgeTalia, ISetupFluids.itemFluidMixedSludgeTalia, ISetupFluids.bucketMixedSludgeTalia, "Thalium ore mixedSludge");
        LanguageRegistry.addName(ISetupFluids.bucketMixedSludgeTalia, "Thalium mixedSludge Bucket");
        
    }

}
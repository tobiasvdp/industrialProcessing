package ip.industrialProcessing.config;

import ip.industrialProcessing.fluids.BlockFluid;
import ip.industrialProcessing.fluids.ContainerFluid;
import ip.industrialProcessing.fluids.ItemFluid;
import net.minecraft.block.material.Material;

public interface ISetupFluids {

	public final static ItemFluid itemFluidLightNaphtha = new ItemFluid("LightNaphtha", 1000, 1000);
	public final static BlockFluid blockFluidLightNaphtha = new BlockFluid(ConfigFluids.getLightNaphthaFluidBlock(), itemFluidLightNaphtha, Material.water, true);
	public final static ContainerFluid bucketLightNaphtha = new ContainerFluid(ConfigFluids.getLightNaphthaFluidBucket(), itemFluidLightNaphtha, blockFluidLightNaphtha, "ContainerLightNaphtha");

	public final static ItemFluid itemFluidParaffinicNaphtha = new ItemFluid("ParaffinicNaphtha", 1000, 1000);
	public final static BlockFluid blockFluidParaffinicNaphtha = new BlockFluid(ConfigFluids.getParaffinicNaphthaFluidBlock(), itemFluidParaffinicNaphtha, Material.water, true);
	public final static ContainerFluid bucketParaffinicNaphtha = new ContainerFluid(ConfigFluids.getParaffinicNaphthaFluidBucket(), itemFluidParaffinicNaphtha, blockFluidParaffinicNaphtha, "ContainerParaffinicNaphtha");

	public final static ItemFluid itemFluidHeavyNaphtha = new ItemFluid("HeavyNaphtha", 1000, 1000);
	public final static BlockFluid blockFluidHeavyNaphtha = new BlockFluid(ConfigFluids.getHeavyNaphthaFluidBlock(), itemFluidHeavyNaphtha, Material.water, true);
	public final static ContainerFluid bucketHeavyNaphtha = new ContainerFluid(ConfigFluids.getHeavyNaphthaFluidBucket(), itemFluidHeavyNaphtha, blockFluidHeavyNaphtha, "ContainerHeavyNaphtha");

	public final static ItemFluid itemFluidHeavyVirginNaphtha = new ItemFluid("HeavyVirginNaphtha", 1000, 1000);
	public final static BlockFluid blockFluidHeavyVirginNaphtha = new BlockFluid(ConfigFluids.getHeavyVirginNaphthaFluidBlock(), itemFluidHeavyVirginNaphtha, Material.water, true);
	public final static ContainerFluid bucketHeavyVirginNaphtha = new ContainerFluid(ConfigFluids.getHeavyVirginNaphthaFluidBucket(), itemFluidHeavyVirginNaphtha, blockFluidHeavyVirginNaphtha, "ContainerHeavyVirginNaphtha");

	public final static ItemFluid itemFluidLightVacuumGasOil = new ItemFluid("LightVacuumGasOil", 1000, 1000);
	public final static BlockFluid blockFluidLightVacuumGasOil = new BlockFluid(ConfigFluids.getLightvacuumGasOilFluidBlock(), itemFluidLightVacuumGasOil, Material.water, true);
	public final static ContainerFluid bucketLightVacuumGasOil = new ContainerFluid(ConfigFluids.getLightvacuumGasOilFluidBucket(), itemFluidLightVacuumGasOil, blockFluidLightVacuumGasOil, "ContainerLightVacuumGasOil");

	public final static ItemFluid itemFluidHeavyvacuumGasOil = new ItemFluid("HeavyvacuumGasOil", 1000, 1000);
	public final static BlockFluid blockFluidHeavyvacuumGasOil = new BlockFluid(ConfigFluids.getHeavyvacuumGasOilFluidBlock(), itemFluidHeavyvacuumGasOil, Material.water, true);
	public final static ContainerFluid bucketHeavyvacuumGasOil = new ContainerFluid(ConfigFluids.getHeavyvacuumGasOilFluidBucket(), itemFluidHeavyvacuumGasOil, blockFluidHeavyvacuumGasOil, "ContainerHeavyvacuumGasOil");

	public final static ItemFluid itemFluidUntreatedKerosene = new ItemFluid("UntreatedKerosene", 1000, 1000);
	public final static BlockFluid blockFluidUntreatedKerosene = new BlockFluid(ConfigFluids.getUntreatedKeroseneFluidBlock(), itemFluidUntreatedKerosene, Material.water, true);
	public final static ContainerFluid bucketUntreatedKerosene = new ContainerFluid(ConfigFluids.getUntreatedKeroseneFluidBucket(), itemFluidUntreatedKerosene, blockFluidUntreatedKerosene, "ContainerUntreatedKerosene");

	public final static ItemFluid itemFluidKerosene = new ItemFluid("Kerosene", 1000, 1000);
	public final static BlockFluid blockFluidKerosene = new BlockFluid(ConfigFluids.getKeroseneFluidBlock(), itemFluidKerosene, Material.water, true);
	public final static ContainerFluid bucketKerosene = new ContainerFluid(ConfigFluids.getKeroseneFluidBucket(), itemFluidKerosene, blockFluidKerosene, "ContainerKerosene");

	public final static ItemFluid itemFluidUntreatedDieselOil = new ItemFluid("UntreatedDieselOil", 1000, 1000);
	public final static BlockFluid blockFluidUntreatedDieselOil = new BlockFluid(ConfigFluids.getUntreatedDieselOilFluidBlock(), itemFluidUntreatedDieselOil, Material.water, true);
	public final static ContainerFluid bucketUntreatedDieselOil = new ContainerFluid(ConfigFluids.getUntreatedDieselOilFluidBucket(), itemFluidUntreatedDieselOil, blockFluidUntreatedDieselOil, "ContainerUntreatedDieselOil");

	public final static ItemFluid itemFluidDieselOil = new ItemFluid("DieselOil", 1000, 1000);
	public final static BlockFluid blockFluidDieselOil = new BlockFluid(ConfigFluids.getDieselOilFluidBlock(), itemFluidDieselOil, Material.water, true);
	public final static ContainerFluid bucketDieselOil = new ContainerFluid(ConfigFluids.getDieselOilFluidBucket(), itemFluidDieselOil, blockFluidDieselOil, "ContainerDieselOil");

	public final static ItemFluid itemFluidGasOil = new ItemFluid("GasOil", 1000, 1000);
	public final static BlockFluid blockFluidGasOil = new BlockFluid(ConfigFluids.getGasOilFluidBlock(), itemFluidGasOil, Material.water, true);
	public final static ContainerFluid bucketGasOil = new ContainerFluid(ConfigFluids.getGasOilFluidBucket(), itemFluidGasOil, blockFluidGasOil, "ContainerGasOil");

	public final static ItemFluid itemFluidAtmosphericBottoms = new ItemFluid("AtmosphericBottoms", 1000, 1000);
	public final static BlockFluid blockFluidAtmosphericBottoms = new BlockFluid(ConfigFluids.getAtmoshepicBottomsFluidBlock(), itemFluidAtmosphericBottoms, Material.water, true);
	public final static ContainerFluid bucketAtmosphericBottoms = new ContainerFluid(ConfigFluids.getAtmoshepicBottomsFluidBucket(), itemFluidAtmosphericBottoms, blockFluidAtmosphericBottoms, "ContainerAtmosphericBottoms");

	public final static ItemFluid itemFluidMicrobialWater = new ItemFluid("MicrobialWater", 1000, 1000);
	public final static BlockFluid blockFluidMicrobialWater = new BlockFluid(ConfigFluids.blockFluidBaseMicrobialWaterID(), itemFluidMicrobialWater, Material.water, true);
	public final static ContainerFluid bucketMicrobialWater = new ContainerFluid(ConfigFluids.BucketMicrobialWaterID(), itemFluidMicrobialWater, blockFluidMicrobialWater, "ContainerMicrobialWater");

	public final static ItemFluid itemFluidLatex = new ItemFluid("Latex", 1200, 100);
	public final static BlockFluid blockFluidLatex = new BlockFluid(ConfigFluids.getLatexFluidBlockID(), itemFluidLatex, Material.water, true);
	public final static ContainerFluid bucketFluidLatex = new ContainerFluid(ConfigFluids.getLatexFluidBucketID(), itemFluidLatex, blockFluidLatex, "ContainerLatex");

	public final static ItemFluid itemFluidDirtyWater = new ItemFluid("DirtyWater", 1000, 1000);
	public final static BlockFluid blockFluidDirtyWater = new BlockFluid(ConfigFluids.blockFluidBaseDirtyWaterID(), itemFluidDirtyWater, Material.water, true);
	public final static ContainerFluid bucketDirtyWater = new ContainerFluid(ConfigFluids.BucketDirtyWaterID(), itemFluidDirtyWater, blockFluidDirtyWater, "ContainerDirtyWater");

	public final static ItemFluid itemFluidOreSludgeIron = new ItemFluid("OreSludgeIron", 1000, 1000);
	public final static BlockFluid blockFluidOreSludgeIron = new BlockFluid(ConfigFluids.blockFluidBaseOreSludgeIronID(), itemFluidOreSludgeIron, Material.water, false);
	public final static ContainerFluid bucketOreSludgeIron = new ContainerFluid(ConfigFluids.BucketOreSludgeIronID(), itemFluidOreSludgeIron, blockFluidOreSludgeIron, "ContainerOreSludgeIron");

	public final static ItemFluid itemFluidOreSludgeChromite = new ItemFluid("OreSludgeChromite", 1000, 1000);
	public final static BlockFluid blockFluidOreSludgeChromite = new BlockFluid(ConfigFluids.blockFluidBaseOreSludgeChromiteID(), itemFluidOreSludgeChromite, Material.water, false);
	public final static ContainerFluid bucketOreSludgeChromite = new ContainerFluid(ConfigFluids.bucketOreSludgeChromiteID(), itemFluidOreSludgeChromite, blockFluidOreSludgeChromite, "ContainerOreSludgeChromite");

	public final static ItemFluid itemFluidOreSludgeGalena = new ItemFluid("OreSludgeGalena", 1000, 1000);
	public final static BlockFluid blockFluidOreSludgeGalena = new BlockFluid(ConfigFluids.blockFluidBaseOreSludgeGalenaID(), itemFluidOreSludgeGalena, Material.water, false);
	public final static ContainerFluid bucketOreSludgeGalena = new ContainerFluid(ConfigFluids.bucketOreSludgeGalenaID(), itemFluidOreSludgeGalena, blockFluidOreSludgeGalena, "ContainerOreSludgeGalena");

	public final static ItemFluid itemFluidOreSludgeGold = new ItemFluid("OreSludgeGold", 1000, 1000);
	public final static BlockFluid blockFluidOreSludgeGold = new BlockFluid(ConfigFluids.blockFluidBaseOreSludgeGoldID(), itemFluidOreSludgeGold, Material.water, false);
	public final static ContainerFluid bucketOreSludgeGold = new ContainerFluid(ConfigFluids.bucketOreSludgeGoldID(), itemFluidOreSludgeGold, blockFluidOreSludgeGold, "ContainerOreSludgeGold");

	public final static ItemFluid itemFluidOreSludgeTalia = new ItemFluid("OreSludgeTalia", 1000, 1000);
	public final static BlockFluid blockFluidOreSludgeTalia = new BlockFluid(ConfigFluids.blockFluidBaseOreSludgeTaliaID(), itemFluidOreSludgeTalia, Material.water, false);
	public final static ContainerFluid bucketOreSludgeTalia = new ContainerFluid(ConfigFluids.bucketOreSludgeTaliaID(), itemFluidOreSludgeTalia, blockFluidOreSludgeTalia, "ContainerOreSludgeTalia");

	public final static ItemFluid itemFluidOreSludgeCopper = new ItemFluid("OreSludgeCopper", 1000, 1000);
	public final static BlockFluid blockFluidOreSludgeCopper = new BlockFluid(ConfigFluids.blockFluidBaseOreSludgeCopperID(), itemFluidOreSludgeCopper, Material.water, false);
	public final static ContainerFluid bucketOreSludgeCopper = new ContainerFluid(ConfigFluids.BucketOreSludgeCopperID(), itemFluidOreSludgeCopper, blockFluidOreSludgeCopper, "ContainerOreSludgeCopper");

	public final static ItemFluid itemFluidOreSludgeTin = new ItemFluid("OreSludgeTin", 1000, 1000);
	public final static BlockFluid blockFluidOreSludgeTin = new BlockFluid(ConfigFluids.blockFluidBaseOreSludgeTinID(), itemFluidOreSludgeTin, Material.water, false);
	public final static ContainerFluid bucketOreSludgeTin = new ContainerFluid(ConfigFluids.BucketOreSludgeTinID(), itemFluidOreSludgeTin, blockFluidOreSludgeTin, "ContainerOreSludgeTin");

	public final static ItemFluid itemFluidHotSlag = new ItemFluid("IP.fluid.hotSlag", 3000, 3000);
	public final static BlockFluid blockFluidHotSlag = new BlockFluid(ConfigFluids.blockFluidBaseHotSlagID(), itemFluidHotSlag, Material.fire, false);
	public final static ContainerFluid bucketHotSlag = new ContainerFluid(ConfigFluids.BucketHotSlagID(), itemFluidHotSlag, blockFluidHotSlag, "ContainerHotSlag");

	public final static ItemFluid itemFluidPigIron = new ItemFluid("IP.fluid.pigIron", 2000, 2000);
	public final static BlockFluid blockFluidPigIron = new BlockFluid(ConfigFluids.blockFluidBasePigIronID(), itemFluidPigIron, Material.fire, false);
	public final static ContainerFluid bucketPigIron = new ContainerFluid(ConfigFluids.BucketPigIronID(), itemFluidPigIron, blockFluidPigIron, "ContainerPigIron");

	public final static ItemFluid itemFluidHotSteel = new ItemFluid("IP.fluid.hotSteel", 2000, 2000);
	public final static BlockFluid blockFluidHotSteel = new BlockFluid(ConfigFluids.blockFluidBaseHotSteelID(), itemFluidHotSteel, Material.fire, false);
	public final static ContainerFluid bucketHotSteel = new ContainerFluid(ConfigFluids.BucketHotSteelID(), itemFluidHotSteel, blockFluidHotSteel, "ContainerHotSteel");

	public final static ItemFluid itemFluidExhaustGas = new ItemFluid("IP.fluid.exhaustGas", 1000, 1000);
	public final static BlockFluid blockFluidExhaustGas = new BlockFluid(ConfigFluids.blockFluidBaseExhaustGasID(), itemFluidExhaustGas, Material.water, false);

	public final static ItemFluid itemFluidSteam = new ItemFluid("Steam", 1000, 1000);
	public final static BlockFluid blockFluidSteam = new BlockFluid(ConfigFluids.blockFluidBaseSteamID(), itemFluidSteam, Material.water, false);

	public final static ItemFluid itemFluidfiltyWater = new ItemFluid("filtyWater", 2000, 2000);
	public final static BlockFluid blockFluidfiltyWater = new BlockFluid(ConfigFluids.blockFluidBasefiltyWaterID(), itemFluidfiltyWater, Material.water, false);
	public final static ContainerFluid bucketfiltyWater = new ContainerFluid(ConfigFluids.BucketfiltyWaterID(), itemFluidfiltyWater, blockFluidfiltyWater, "ContainerfiltyWater");

	public final static ItemFluid itemFluidGritSludge = new ItemFluid("gritSludge", 2000, 2000);
	public final static BlockFluid blockFluidGritSludge = new BlockFluid(ConfigFluids.blockFluidBaseGritSludgeID(), itemFluidGritSludge, Material.water, false);
	public final static ContainerFluid bucketGritSludge = new ContainerFluid(ConfigFluids.BucketGritSludgeID(), itemFluidGritSludge, blockFluidGritSludge, "ContainerGritSludge");

	public final static ItemFluid itemFluidUncleanWater = new ItemFluid("uncleanWater", 2000, 2000);
	public final static BlockFluid blockFluidUncleanWater = new BlockFluid(ConfigFluids.blockFluidBaseUncleanWaterID(), itemFluidUncleanWater, Material.water, false);
	public final static ContainerFluid bucketUncleanWater = new ContainerFluid(ConfigFluids.BucketUncleanWaterID(), itemFluidUncleanWater, blockFluidUncleanWater, "ContainerUncleanWater");

	public final static ItemFluid itemFluidResidu = new ItemFluid("residu", 2000, 2000);
	public final static BlockFluid blockFluidResidu = new BlockFluid(ConfigFluids.blockFluidBaseResiduID(), itemFluidResidu, Material.water, false);
	public final static ContainerFluid bucketResidu = new ContainerFluid(ConfigFluids.BucketResiduID(), itemFluidResidu, blockFluidResidu, "ContainerResidu");

	public final static ItemFluid itemFluidAir = new ItemFluid("air", 1000, 1000);
	public final static BlockFluid blockFluidAir = new BlockFluid(ConfigFluids.getAirFluidBlockID(), itemFluidAir, Material.water, false);

	public final static ItemFluid itemFluidCO2 = new ItemFluid("CO2", 1000, 1000);
	public final static BlockFluid blockFluidCO2 = new BlockFluid(ConfigFluids.getCO2FluidBlockID(), itemFluidCO2, Material.water, false);

	public final static ItemFluid itemFluidH2 = new ItemFluid("H2", 1000, 1000);
	public final static BlockFluid blockFluidH2 = new BlockFluid(ConfigFluids.getH2FluidBlockID(), itemFluidH2, Material.water, false);

	public final static ItemFluid itemFluidH2S = new ItemFluid("H2S", 1000, 1000);
	public final static BlockFluid blockFluidH2S = new BlockFluid(ConfigFluids.getH2SFluidBlockID(), itemFluidH2S, Material.water, false);

	public final static ItemFluid itemFluidIsoButane = new ItemFluid("IsoButane", 1000, 1000);
	public final static BlockFluid blockFluidIsoButane = new BlockFluid(ConfigFluids.getIsoButaneFluidBlockID(), itemFluidIsoButane, Material.water, false);

	public final static ItemFluid itemFluidButane = new ItemFluid("Butane", 1000, 1000);
	public final static BlockFluid blockFluidButane = new BlockFluid(ConfigFluids.getButaneFluidBlockID(), itemFluidButane, Material.water, false);

	public final static ItemFluid itemFluidAlkylate = new ItemFluid("Alkylate", 1000, 1000);
	public final static BlockFluid blockFluidAlkylate = new BlockFluid(ConfigFluids.getAlkylateFluidBlockID(), itemFluidAlkylate, Material.water, false);

	public final static ItemFluid itemFluidGasMix = new ItemFluid("GasMix", 1000, 1000);
	public final static BlockFluid blockFluidGasMix = new BlockFluid(ConfigFluids.getGasMixFluidBlockID(), itemFluidGasMix, Material.water, false);

	public final static ItemFluid itemFluidFuelGas = new ItemFluid("FuelGas", 1000, 1000);
	public final static BlockFluid blockFluidFuelGas = new BlockFluid(ConfigFluids.getFuelGasFluidBlockID(), itemFluidFuelGas, Material.water, false);

	public final static ItemFluid itemFluidUnsweetenedLPG = new ItemFluid("UnsweetenedLPG", 1000, 1000);
	public final static BlockFluid blockFluidUnsweetenedLPG = new BlockFluid(ConfigFluids.getUnsweetenedLPGFluidBlockID(), itemFluidUnsweetenedLPG, Material.water, false);

	public final static ItemFluid itemFluidUnsweetenedButane = new ItemFluid("UnsweetenedButane", 1000, 1000);
	public final static BlockFluid blockFluidUnsweetenedButane = new BlockFluid(ConfigFluids.getUnsweetenedButaneFluidBlockID(), itemFluidUnsweetenedButane, Material.water, false);

	public final static ItemFluid itemFluidIsomerate = new ItemFluid("Isomerate", 1000, 1000);
	public final static BlockFluid blockFluidIsomerate = new BlockFluid(ConfigFluids.getIsomerateFluidBlockID(), itemFluidIsomerate, Material.water, false);

	public final static ItemFluid itemFluidAsphaltSludge = new ItemFluid("AsphaltSludge", 1000, 1000);
	public final static BlockFluid blockFluidAsphaltSludge = new BlockFluid(ConfigFluids.getAsphaltSludgeFluidBlockID(), itemFluidAsphaltSludge, Material.water, false);
	public final static ContainerFluid bucketAsphaltSludge = new ContainerFluid(ConfigFluids.getAsphaltSludgeFluidBucketID(), itemFluidAsphaltSludge, blockFluidAsphaltSludge, "ContainerAsphaltSludge");

	public final static ItemFluid itemFluidSourWater = new ItemFluid("SourWater", 1000, 1000);
	public final static BlockFluid blockFluidSourWater = new BlockFluid(ConfigFluids.getSourWaterFluidBlockID(), itemFluidSourWater, Material.water, false);
	public final static ContainerFluid bucketSourWater = new ContainerFluid(ConfigFluids.getSourWaterFluidBucketID(), itemFluidSourWater, blockFluidSourWater, "ContainerSourWater");

	public final static ItemFluid itemFluidMixedSludgeIron = new ItemFluid("MixedSludgeIron", 1000, 1000);
	public final static BlockFluid blockFluidMixedSludgeIron = new BlockFluid(ConfigFluids.blockFluidBaseMixedSludgeIronID(), itemFluidMixedSludgeIron, Material.water, false);
	public final static ContainerFluid bucketMixedSludgeIron = new ContainerFluid(ConfigFluids.BucketMixedSludgeIronID(), itemFluidMixedSludgeIron, blockFluidMixedSludgeIron, "ContainerMixedSludgeIron");

	public final static ItemFluid itemFluidMixedSludgeChromite = new ItemFluid("MixedSludgeChromite", 1000, 1000);
	public final static BlockFluid blockFluidMixedSludgeChromite = new BlockFluid(ConfigFluids.blockFluidBaseMixedSludgeChromiteID(), itemFluidMixedSludgeChromite, Material.water, false);
	public final static ContainerFluid bucketMixedSludgeChromite = new ContainerFluid(ConfigFluids.bucketMixedSludgeChromiteID(), itemFluidMixedSludgeChromite, blockFluidMixedSludgeChromite, "ContainerMixedSludgeChromite");

	public final static ItemFluid itemFluidMixedSludgeGalena = new ItemFluid("MixedSludgeGalena", 1000, 1000);
	public final static BlockFluid blockFluidMixedSludgeGalena = new BlockFluid(ConfigFluids.blockFluidBaseMixedSludgeGalenaID(), itemFluidMixedSludgeGalena, Material.water, false);
	public final static ContainerFluid bucketMixedSludgeGalena = new ContainerFluid(ConfigFluids.bucketMixedSludgeGalenaID(), itemFluidMixedSludgeGalena, blockFluidMixedSludgeGalena, "ContainerMixedSludgeGalena");

	public final static ItemFluid itemFluidMixedSludgeGold = new ItemFluid("MixedSludgeGold", 1000, 1000);
	public final static BlockFluid blockFluidMixedSludgeGold = new BlockFluid(ConfigFluids.blockFluidBaseMixedSludgeGoldID(), itemFluidMixedSludgeGold, Material.water, false);
	public final static ContainerFluid bucketMixedSludgeGold = new ContainerFluid(ConfigFluids.bucketMixedSludgeGoldID(), itemFluidMixedSludgeGold, blockFluidMixedSludgeGold, "ContainerMixedSludgeGold");

	public final static ItemFluid itemFluidMixedSludgeTalia = new ItemFluid("MixedSludgeTalia", 1000, 1000);
	public final static BlockFluid blockFluidMixedSludgeTalia = new BlockFluid(ConfigFluids.blockFluidBaseMixedSludgeTaliaID(), itemFluidMixedSludgeTalia, Material.water, false);
	public final static ContainerFluid bucketMixedSludgeTalia = new ContainerFluid(ConfigFluids.bucketMixedSludgeTaliaID(), itemFluidMixedSludgeTalia, blockFluidMixedSludgeTalia, "ContainerMixedSludgeTalia");

	public final static ItemFluid itemFluidMixedSludgeCopper = new ItemFluid("MixedSludgeCopper", 1000, 1000);
	public final static BlockFluid blockFluidMixedSludgeCopper = new BlockFluid(ConfigFluids.blockFluidBaseMixedSludgeCopperID(), itemFluidMixedSludgeCopper, Material.water, false);
	public final static ContainerFluid bucketMixedSludgeCopper = new ContainerFluid(ConfigFluids.BucketMixedSludgeCopperID(), itemFluidMixedSludgeCopper, blockFluidMixedSludgeCopper, "ContainerMixedSludgeCopper");

	public final static ItemFluid itemFluidMixedSludgeTin = new ItemFluid("MixedSludgeTin", 1000, 1000);
	public final static BlockFluid blockFluidMixedSludgeTin = new BlockFluid(ConfigFluids.blockFluidBaseMixedSludgeTinID(), itemFluidMixedSludgeTin, Material.water, false);
	public final static ContainerFluid bucketMixedSludgeTin = new ContainerFluid(ConfigFluids.BucketMixedSludgeTinID(), itemFluidMixedSludgeTin, blockFluidMixedSludgeTin, "ContainerMixedSludgeTin");

	public final static ItemFluid itemFluidResin = new ItemFluid("Resin", 1000, 1000);
	public final static BlockFluid blockFluidResin = new BlockFluid(ConfigFluids.getResinFluidBlockID(), itemFluidResin, Material.water, false);
	public final static ContainerFluid bucketResin = new ContainerFluid(ConfigFluids.getResinFluidBucketID(), itemFluidResin, blockFluidResin, "ContainerResin");

	public final static ItemFluid itemFluidThickTinSludge = new ItemFluid("IP.fluid.ThickTinSludge", 2000, 2000);
	public final static BlockFluid blockFluidThickTinSludge = new BlockFluid(ConfigFluids.getBlockFluidBaseThickTinSludgeID(), itemFluidThickTinSludge, Material.water, false);
	public final static ContainerFluid bucketThickTinSludge = new ContainerFluid(ConfigFluids.getBucketThickTinSludgeID(), itemFluidThickTinSludge, blockFluidThickTinSludge, "ContainerThickTinSludge");

	public final static ItemFluid itemFluidThickCopperSludge = new ItemFluid("IP.fluid.ThickCopperSludge", 2000, 2000);
	public final static BlockFluid blockFluidThickCopperSludge = new BlockFluid(ConfigFluids.getBlockFluidBaseThickCopperSludgeID(), itemFluidThickCopperSludge, Material.water, false);
	public final static ContainerFluid bucketThickCopperSludge = new ContainerFluid(ConfigFluids.getBucketThickCopperSludgeID(), itemFluidThickCopperSludge, blockFluidThickCopperSludge, "ContainerThickCopperSludge");

	public final static ItemFluid itemFluidThickTaliaSludge = new ItemFluid("IP.fluid.ThickTaliaSludge", 2000, 2000);
	public final static BlockFluid blockFluidThickTaliaSludge = new BlockFluid(ConfigFluids.getBlockFluidBaseThickTaliaSludgeID(), itemFluidThickTaliaSludge, Material.water, false);
	public final static ContainerFluid bucketThickTaliaSludge = new ContainerFluid(ConfigFluids.getBucketThickTaliaSludgeID(), itemFluidThickTaliaSludge, blockFluidThickTaliaSludge, "ContainerThickTaliaSludge");

	public final static ItemFluid itemFluidThickGoldSludge = new ItemFluid("IP.fluid.ThickGoldSludge", 2000, 2000);
	public final static BlockFluid blockFluidThickGoldSludge = new BlockFluid(ConfigFluids.getBlockFluidBaseThickGoldSludgeID(), itemFluidThickGoldSludge, Material.water, false);
	public final static ContainerFluid bucketThickGoldSludge = new ContainerFluid(ConfigFluids.getBucketThickGoldSludgeID(), itemFluidThickGoldSludge, blockFluidThickGoldSludge, "ContainerThickGoldSludge");

	public final static ItemFluid itemFluidThickGalenaSludge = new ItemFluid("IP.fluid.ThickGalenaSludge", 2000, 2000);
	public final static BlockFluid blockFluidThickGalenaSludge = new BlockFluid(ConfigFluids.getBlockFluidBaseThickGalenaSludgeID(), itemFluidThickGalenaSludge, Material.water, false);
	public final static ContainerFluid bucketThickGalenaSludge = new ContainerFluid(ConfigFluids.getBucketThickGalenaSludgeID(), itemFluidThickGalenaSludge, blockFluidThickGalenaSludge, "ContainerThickGalenaSludge");

	public final static ItemFluid itemFluidThickChromiteSludge = new ItemFluid("IP.fluid.ThickChromiteSludge", 2000, 2000);
	public final static BlockFluid blockFluidThickChromiteSludge = new BlockFluid(ConfigFluids.getBlockFluidBaseThickChromiteSludgeID(), itemFluidThickChromiteSludge, Material.water, false);
	public final static ContainerFluid bucketThickChromiteSludge = new ContainerFluid(ConfigFluids.getBucketThickChromiteSludgeID(), itemFluidThickChromiteSludge, blockFluidThickChromiteSludge, "ContainerThickChromiteSludge");

	public final static ItemFluid itemFluidThickIronSludge = new ItemFluid("IP.fluid.ThickIronSludge", 2000, 2000);
	public final static BlockFluid blockFluidThickIronSludge = new BlockFluid(ConfigFluids.getBlockFluidBaseThickIronSludgeID(), itemFluidThickIronSludge, Material.water, false);
	public final static ContainerFluid bucketThickIronSludge = new ContainerFluid(ConfigFluids.getBucketThickIronSludgeID(), itemFluidThickIronSludge, blockFluidThickIronSludge, "ContainerThickIronSludge");

	public final static ItemFluid itemFluidFlotationTinSediment = new ItemFluid("IP.fluid.FlotationTinSediment", 2000, 2000);
	public final static BlockFluid blockFluidFlotationTinSediment = new BlockFluid(ConfigFluids.getBlockFluidBaseFlotationTinSedimentID(), itemFluidFlotationTinSediment, Material.water, false);
	public final static ContainerFluid bucketFlotationTinSediment = new ContainerFluid(ConfigFluids.getBucketFlotationTinSedimentID(), itemFluidFlotationTinSediment, blockFluidFlotationTinSediment, "ContainerFlotationTinSediment");

	public final static ItemFluid itemFluidFlotationCopperSediment = new ItemFluid("IP.fluid.FlotationCopperSediment", 2000, 2000);
	public final static BlockFluid blockFluidFlotationCopperSediment = new BlockFluid(ConfigFluids.getBlockFluidBaseFlotationCopperSedimentID(), itemFluidFlotationCopperSediment, Material.water, false);
	public final static ContainerFluid bucketFlotationCopperSediment = new ContainerFluid(ConfigFluids.getBucketFlotationCopperSedimentID(), itemFluidFlotationCopperSediment, blockFluidFlotationCopperSediment, "ContainerFlotationCopperSediment");

	public final static ItemFluid itemFluidFlotationTaliaSediment = new ItemFluid("IP.fluid.FlotationTaliaSediment", 2000, 2000);
	public final static BlockFluid blockFluidFlotationTaliaSediment = new BlockFluid(ConfigFluids.getBlockFluidBaseFlotationTaliaSedimentID(), itemFluidFlotationTaliaSediment, Material.water, false);
	public final static ContainerFluid bucketFlotationTaliaSediment = new ContainerFluid(ConfigFluids.getBucketFlotationTaliaSedimentID(), itemFluidFlotationTaliaSediment, blockFluidFlotationTaliaSediment, "ContainerFlotationTaliaSediment");

	public final static ItemFluid itemFluidFlotationGoldSediment = new ItemFluid("IP.fluid.FlotationGoldSediment", 2000, 2000);
	public final static BlockFluid blockFluidFlotationGoldSediment = new BlockFluid(ConfigFluids.getBlockFluidBaseFlotationGoldSedimentID(), itemFluidFlotationGoldSediment, Material.water, false);
	public final static ContainerFluid bucketFlotationGoldSediment = new ContainerFluid(ConfigFluids.getBucketFlotationGoldSedimentID(), itemFluidFlotationGoldSediment, blockFluidFlotationGoldSediment, "ContainerFlotationGoldSediment");

	public final static ItemFluid itemFluidFlotationGalenaSediment = new ItemFluid("IP.fluid.FlotationGalenaSediment", 2000, 2000);
	public final static BlockFluid blockFluidFlotationGalenaSediment = new BlockFluid(ConfigFluids.getBlockFluidBaseFlotationGalenaSedimentID(), itemFluidFlotationGalenaSediment, Material.water, false);
	public final static ContainerFluid bucketFlotationGalenaSediment = new ContainerFluid(ConfigFluids.getBucketFlotationGalenaSedimentID(), itemFluidFlotationGalenaSediment, blockFluidFlotationGalenaSediment, "ContainerFlotationGalenaSediment");

	public final static ItemFluid itemFluidFlotationChromiteSediment = new ItemFluid("IP.fluid.FlotationChromiteSediment", 2000, 2000);
	public final static BlockFluid blockFluidFlotationChromiteSediment = new BlockFluid(ConfigFluids.getBlockFluidBaseFlotationChromiteSedimentID(), itemFluidFlotationChromiteSediment, Material.water, false);
	public final static ContainerFluid bucketFlotationChromiteSediment = new ContainerFluid(ConfigFluids.getBucketFlotationChromiteSedimentID(), itemFluidFlotationChromiteSediment, blockFluidFlotationChromiteSediment, "ContainerFlotationChromiteSediment");

	public final static ItemFluid itemFluidFlotationIronSediment = new ItemFluid("IP.fluid.FlotationIronSediment", 2000, 2000);
	public final static BlockFluid blockFluidFlotationIronSediment = new BlockFluid(ConfigFluids.getBlockFluidBaseFlotationIronSedimentID(), itemFluidFlotationIronSediment, Material.water, false);
	public final static ContainerFluid bucketFlotationIronSediment = new ContainerFluid(ConfigFluids.getBucketFlotationIronSedimentID(), itemFluidFlotationIronSediment, blockFluidFlotationIronSediment, "ContainerFlotationIronSediment");

	public final static ItemFluid itemFluidCycloneTinSediment = new ItemFluid("IP.fluid.CycloneTinSediment", 2000, 2000);
	public final static BlockFluid blockFluidCycloneTinSediment = new BlockFluid(ConfigFluids.getBlockFluidBaseCycloneTinSedimentID(), itemFluidCycloneTinSediment, Material.water, false);
	public final static ContainerFluid bucketCycloneTinSediment = new ContainerFluid(ConfigFluids.getBucketCycloneTinSedimentID(), itemFluidCycloneTinSediment, blockFluidCycloneTinSediment, "ContainerCycloneTinSediment");

	public final static ItemFluid itemFluidCycloneCopperSediment = new ItemFluid("IP.fluid.CycloneCopperSediment", 2000, 2000);
	public final static BlockFluid blockFluidCycloneCopperSediment = new BlockFluid(ConfigFluids.getBlockFluidBaseCycloneCopperSedimentID(), itemFluidCycloneCopperSediment, Material.water, false);
	public final static ContainerFluid bucketCycloneCopperSediment = new ContainerFluid(ConfigFluids.getBucketCycloneCopperSedimentID(), itemFluidCycloneCopperSediment, blockFluidCycloneCopperSediment, "ContainerCycloneCopperSediment");

	public final static ItemFluid itemFluidCycloneTaliaSediment = new ItemFluid("IP.fluid.CycloneTaliaSediment", 2000, 2000);
	public final static BlockFluid blockFluidCycloneTaliaSediment = new BlockFluid(ConfigFluids.getBlockFluidBaseCycloneTaliaSedimentID(), itemFluidCycloneTaliaSediment, Material.water, false);
	public final static ContainerFluid bucketCycloneTaliaSediment = new ContainerFluid(ConfigFluids.getBucketCycloneTaliaSedimentID(), itemFluidCycloneTaliaSediment, blockFluidCycloneTaliaSediment, "ContainerCycloneTaliaSediment");

	public final static ItemFluid itemFluidCycloneGoldSediment = new ItemFluid("IP.fluid.CycloneGoldSediment", 2000, 2000);
	public final static BlockFluid blockFluidCycloneGoldSediment = new BlockFluid(ConfigFluids.getBlockFluidBaseCycloneGoldSedimentID(), itemFluidCycloneGoldSediment, Material.water, false);
	public final static ContainerFluid bucketCycloneGoldSediment = new ContainerFluid(ConfigFluids.getBucketCycloneGoldSedimentID(), itemFluidCycloneGoldSediment, blockFluidCycloneGoldSediment, "ContainerCycloneGoldSediment");

	public final static ItemFluid itemFluidCycloneGalenaSediment = new ItemFluid("IP.fluid.CycloneGalenaSediment", 2000, 2000);
	public final static BlockFluid blockFluidCycloneGalenaSediment = new BlockFluid(ConfigFluids.getBlockFluidBaseCycloneGalenaSedimentID(), itemFluidCycloneGalenaSediment, Material.water, false);
	public final static ContainerFluid bucketCycloneGalenaSediment = new ContainerFluid(ConfigFluids.getBucketCycloneGalenaSedimentID(), itemFluidCycloneGalenaSediment, blockFluidCycloneGalenaSediment, "ContainerCycloneGalenaSediment");

	public final static ItemFluid itemFluidCycloneChromiteSediment = new ItemFluid("IP.fluid.CycloneChromiteSediment", 2000, 2000);
	public final static BlockFluid blockFluidCycloneChromiteSediment = new BlockFluid(ConfigFluids.getBlockFluidBaseCycloneChromiteSedimentID(), itemFluidCycloneChromiteSediment, Material.water, false);
	public final static ContainerFluid bucketCycloneChromiteSediment = new ContainerFluid(ConfigFluids.getBucketCycloneChromiteSedimentID(), itemFluidCycloneChromiteSediment, blockFluidCycloneChromiteSediment, "ContainerCycloneChromiteSediment");

	public final static ItemFluid itemFluidCycloneIronSediment = new ItemFluid("IP.fluid.CycloneIronSediment", 2000, 2000);
	public final static BlockFluid blockFluidCycloneIronSediment = new BlockFluid(ConfigFluids.getBlockFluidBaseCycloneIronSedimentID(), itemFluidCycloneIronSediment, Material.water, false);
	public final static ContainerFluid bucketCycloneIronSediment = new ContainerFluid(ConfigFluids.getBucketCycloneIronSedimentID(), itemFluidCycloneIronSediment, blockFluidCycloneIronSediment, "ContainerCycloneIronSediment");

	public final static ItemFluid itemFluidConcentratedTinSludge = new ItemFluid("IP.fluid.ConcentratedTinSludge", 2000, 2000);
	public final static BlockFluid blockFluidConcentratedTinSludge = new BlockFluid(ConfigFluids.getBlockFluidBaseConcentratedTinSludgeID(), itemFluidConcentratedTinSludge, Material.water, false);
	public final static ContainerFluid bucketConcentratedTinSludge = new ContainerFluid(ConfigFluids.getBucketConcentratedTinSludgeID(), itemFluidConcentratedTinSludge, blockFluidConcentratedTinSludge, "ContainerConcentratedTinSludge");

	public final static ItemFluid itemFluidConcentratedCopperSludge = new ItemFluid("IP.fluid.ConcentratedCopperSludge", 2000, 2000);
	public final static BlockFluid blockFluidConcentratedCopperSludge = new BlockFluid(ConfigFluids.getBlockFluidBaseConcentratedCopperSludgeID(), itemFluidConcentratedCopperSludge, Material.water, false);
	public final static ContainerFluid bucketConcentratedCopperSludge = new ContainerFluid(ConfigFluids.getBucketConcentratedCopperSludgeID(), itemFluidConcentratedCopperSludge, blockFluidConcentratedCopperSludge, "ContainerConcentratedCopperSludge");

	public final static ItemFluid itemFluidConcentratedTaliaSludge = new ItemFluid("IP.fluid.ConcentratedTaliaSludge", 2000, 2000);
	public final static BlockFluid blockFluidConcentratedTaliaSludge = new BlockFluid(ConfigFluids.getBlockFluidBaseConcentratedTaliaSludgeID(), itemFluidConcentratedTaliaSludge, Material.water, false);
	public final static ContainerFluid bucketConcentratedTaliaSludge = new ContainerFluid(ConfigFluids.getBucketConcentratedTaliaSludgeID(), itemFluidConcentratedTaliaSludge, blockFluidConcentratedTaliaSludge, "ContainerConcentratedTaliaSludge");

	public final static ItemFluid itemFluidConcentratedGoldSludge = new ItemFluid("IP.fluid.ConcentratedGoldSludge", 2000, 2000);
	public final static BlockFluid blockFluidConcentratedGoldSludge = new BlockFluid(ConfigFluids.getBlockFluidBaseConcentratedGoldSludgeID(), itemFluidConcentratedGoldSludge, Material.water, false);
	public final static ContainerFluid bucketConcentratedGoldSludge = new ContainerFluid(ConfigFluids.getBucketConcentratedGoldSludgeID(), itemFluidConcentratedGoldSludge, blockFluidConcentratedGoldSludge, "ContainerConcentratedGoldSludge");

	public final static ItemFluid itemFluidConcentratedGalenaSludge = new ItemFluid("IP.fluid.ConcentratedGalenaSludge", 2000, 2000);
	public final static BlockFluid blockFluidConcentratedGalenaSludge = new BlockFluid(ConfigFluids.getBlockFluidBaseConcentratedGalenaSludgeID(), itemFluidConcentratedGalenaSludge, Material.water, false);
	public final static ContainerFluid bucketConcentratedGalenaSludge = new ContainerFluid(ConfigFluids.getBucketConcentratedGalenaSludgeID(), itemFluidConcentratedGalenaSludge, blockFluidConcentratedGalenaSludge, "ContainerConcentratedGalenaSludge");

	public final static ItemFluid itemFluidConcentratedChromiteSludge = new ItemFluid("IP.fluid.ConcentratedChromiteSludge", 2000, 2000);
	public final static BlockFluid blockFluidConcentratedChromiteSludge = new BlockFluid(ConfigFluids.getBlockFluidBaseConcentratedChromiteSludgeID(), itemFluidConcentratedChromiteSludge, Material.water, false);
	public final static ContainerFluid bucketConcentratedChromiteSludge = new ContainerFluid(ConfigFluids.getBucketConcentratedChromiteSludgeID(), itemFluidConcentratedChromiteSludge, blockFluidConcentratedChromiteSludge, "ContainerConcentratedChromiteSludge");

	public final static ItemFluid itemFluidConcentratedIronSludge = new ItemFluid("IP.fluid.ConcentratedIronSludge", 2000, 2000);
	public final static BlockFluid blockFluidConcentratedIronSludge = new BlockFluid(ConfigFluids.getBlockFluidBaseConcentratedIronSludgeID(), itemFluidConcentratedIronSludge, Material.water, false);
	public final static ContainerFluid bucketConcentratedIronSludge = new ContainerFluid(ConfigFluids.getBucketConcentratedIronSludgeID(), itemFluidConcentratedIronSludge, blockFluidConcentratedIronSludge, "ContainerConcentratedIronSludge");

	public final static ItemFluid itemFluidLightTinSediment = new ItemFluid("IP.fluid.LightTinSediment", 2000, 2000);
	public final static BlockFluid blockFluidLightTinSediment = new BlockFluid(ConfigFluids.getBlockFluidBaseLightTinSedimentID(), itemFluidLightTinSediment, Material.water, false);
	public final static ContainerFluid bucketLightTinSediment = new ContainerFluid(ConfigFluids.getBucketLightTinSedimentID(), itemFluidLightTinSediment, blockFluidLightTinSediment, "ContainerLightTinSediment");

	public final static ItemFluid itemFluidLightCopperSediment = new ItemFluid("IP.fluid.LightCopperSediment", 2000, 2000);
	public final static BlockFluid blockFluidLightCopperSediment = new BlockFluid(ConfigFluids.getBlockFluidBaseLightCopperSedimentID(), itemFluidLightCopperSediment, Material.water, false);
	public final static ContainerFluid bucketLightCopperSediment = new ContainerFluid(ConfigFluids.getBucketLightCopperSedimentID(), itemFluidLightCopperSediment, blockFluidLightCopperSediment, "ContainerLightCopperSediment");

	public final static ItemFluid itemFluidLightTaliaSediment = new ItemFluid("IP.fluid.LightTaliaSediment", 2000, 2000);
	public final static BlockFluid blockFluidLightTaliaSediment = new BlockFluid(ConfigFluids.getBlockFluidBaseLightTaliaSedimentID(), itemFluidLightTaliaSediment, Material.water, false);
	public final static ContainerFluid bucketLightTaliaSediment = new ContainerFluid(ConfigFluids.getBucketLightTaliaSedimentID(), itemFluidLightTaliaSediment, blockFluidLightTaliaSediment, "ContainerLightTaliaSediment");

	public final static ItemFluid itemFluidLightGoldSediment = new ItemFluid("IP.fluid.LightGoldSediment", 2000, 2000);
	public final static BlockFluid blockFluidLightGoldSediment = new BlockFluid(ConfigFluids.getBlockFluidBaseLightGoldSedimentID(), itemFluidLightGoldSediment, Material.water, false);
	public final static ContainerFluid bucketLightGoldSediment = new ContainerFluid(ConfigFluids.getBucketLightGoldSedimentID(), itemFluidLightGoldSediment, blockFluidLightGoldSediment, "ContainerLightGoldSediment");

	public final static ItemFluid itemFluidLightGalenaSediment = new ItemFluid("IP.fluid.LightGalenaSediment", 2000, 2000);
	public final static BlockFluid blockFluidLightGalenaSediment = new BlockFluid(ConfigFluids.getBlockFluidBaseLightGalenaSedimentID(), itemFluidLightGalenaSediment, Material.water, false);
	public final static ContainerFluid bucketLightGalenaSediment = new ContainerFluid(ConfigFluids.getBucketLightGalenaSedimentID(), itemFluidLightGalenaSediment, blockFluidLightGalenaSediment, "ContainerLightGalenaSediment");

	public final static ItemFluid itemFluidLightChromiteSediment = new ItemFluid("IP.fluid.LightChromiteSediment", 2000, 2000);
	public final static BlockFluid blockFluidLightChromiteSediment = new BlockFluid(ConfigFluids.getBlockFluidBaseLightChromiteSedimentID(), itemFluidLightChromiteSediment, Material.water, false);
	public final static ContainerFluid bucketLightChromiteSediment = new ContainerFluid(ConfigFluids.getBucketLightChromiteSedimentID(), itemFluidLightChromiteSediment, blockFluidLightChromiteSediment, "ContainerLightChromiteSediment");

	public final static ItemFluid itemFluidLightIronSediment = new ItemFluid("IP.fluid.LightIronSediment", 2000, 2000);
	public final static BlockFluid blockFluidLightIronSediment = new BlockFluid(ConfigFluids.getBlockFluidBaseLightIronSedimentID(), itemFluidLightIronSediment, Material.water, false);
	public final static ContainerFluid bucketLightIronSediment = new ContainerFluid(ConfigFluids.getBucketLightIronSedimentID(), itemFluidLightIronSediment, blockFluidLightIronSediment, "ContainerLightIronSediment");

	public final static ItemFluid itemFluidThickTinSediment = new ItemFluid("IP.fluid.ThickTinSediment", 2000, 2000);
	public final static BlockFluid blockFluidThickTinSediment = new BlockFluid(ConfigFluids.getBlockFluidBaseThickTinSedimentID(), itemFluidThickTinSediment, Material.water, false);
	public final static ContainerFluid bucketThickTinSediment = new ContainerFluid(ConfigFluids.getBucketThickTinSedimentID(), itemFluidThickTinSediment, blockFluidThickTinSediment, "ContainerThickTinSediment");

	public final static ItemFluid itemFluidThickCopperSediment = new ItemFluid("IP.fluid.ThickCopperSediment", 2000, 2000);
	public final static BlockFluid blockFluidThickCopperSediment = new BlockFluid(ConfigFluids.getBlockFluidBaseThickCopperSedimentID(), itemFluidThickCopperSediment, Material.water, false);
	public final static ContainerFluid bucketThickCopperSediment = new ContainerFluid(ConfigFluids.getBucketThickCopperSedimentID(), itemFluidThickCopperSediment, blockFluidThickCopperSediment, "ContainerThickCopperSediment");

	public final static ItemFluid itemFluidThickTaliaSediment = new ItemFluid("IP.fluid.ThickTaliaSediment", 2000, 2000);
	public final static BlockFluid blockFluidThickTaliaSediment = new BlockFluid(ConfigFluids.getBlockFluidBaseThickTaliaSedimentID(), itemFluidThickTaliaSediment, Material.water, false);
	public final static ContainerFluid bucketThickTaliaSediment = new ContainerFluid(ConfigFluids.getBucketThickTaliaSedimentID(), itemFluidThickTaliaSediment, blockFluidThickTaliaSediment, "ContainerThickTaliaSediment");

	public final static ItemFluid itemFluidThickGoldSediment = new ItemFluid("IP.fluid.ThickGoldSediment", 2000, 2000);
	public final static BlockFluid blockFluidThickGoldSediment = new BlockFluid(ConfigFluids.getBlockFluidBaseThickGoldSedimentID(), itemFluidThickGoldSediment, Material.water, false);
	public final static ContainerFluid bucketThickGoldSediment = new ContainerFluid(ConfigFluids.getBucketThickGoldSedimentID(), itemFluidThickGoldSediment, blockFluidThickGoldSediment, "ContainerThickGoldSediment");

	public final static ItemFluid itemFluidThickGalenaSediment = new ItemFluid("IP.fluid.ThickGalenaSediment", 2000, 2000);
	public final static BlockFluid blockFluidThickGalenaSediment = new BlockFluid(ConfigFluids.getBlockFluidBaseThickGalenaSedimentID(), itemFluidThickGalenaSediment, Material.water, false);
	public final static ContainerFluid bucketThickGalenaSediment = new ContainerFluid(ConfigFluids.getBucketThickGalenaSedimentID(), itemFluidThickGalenaSediment, blockFluidThickGalenaSediment, "ContainerThickGalenaSediment");

	public final static ItemFluid itemFluidThickChromiteSediment = new ItemFluid("IP.fluid.ThickChromiteSediment", 2000, 2000);
	public final static BlockFluid blockFluidThickChromiteSediment = new BlockFluid(ConfigFluids.getBlockFluidBaseThickChromiteSedimentID(), itemFluidThickChromiteSediment, Material.water, false);
	public final static ContainerFluid bucketThickChromiteSediment = new ContainerFluid(ConfigFluids.getBucketThickChromiteSedimentID(), itemFluidThickChromiteSediment, blockFluidThickChromiteSediment, "ContainerThickChromiteSediment");

	public final static ItemFluid itemFluidThickIronSediment = new ItemFluid("IP.fluid.ThickIronSediment", 2000, 2000);
	public final static BlockFluid blockFluidThickIronSediment = new BlockFluid(ConfigFluids.getBlockFluidBaseThickIronSedimentID(), itemFluidThickIronSediment, Material.water, false);
	public final static ContainerFluid bucketThickIronSediment = new ContainerFluid(ConfigFluids.getBucketThickIronSedimentID(), itemFluidThickIronSediment, blockFluidThickIronSediment, "ContainerThickIronSediment");
}

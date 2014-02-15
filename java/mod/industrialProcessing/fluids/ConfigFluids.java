package mod.industrialProcessing.fluids;

import mod.industrialProcessing.utils.handlers.fluids.BucketHandler;
import mod.industrialProcessing.utils.registry.BlockRegistry;
import mod.industrialProcessing.utils.registry.BucketRegistery;
import mod.industrialProcessing.utils.registry.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidContainerRegistry.FluidContainerData;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ConfigFluids {

	private static ConfigFluids instance = new ConfigFluids();

	public ConfigFluids() {

	}
	
	public static ConfigFluids  getInstance(){
		return instance;
	}

	private void registerFluid(Block block, Fluid fluid, ItemIPBucket bucket, String unlocalizedName) {
		BlockRegistry.registerFluid(block, unlocalizedName+".block");
		fluid.setUnlocalizedName(unlocalizedName+".fluid");
		if (bucket != null) {
			ItemRegistry.registerBucket(bucket, unlocalizedName+".bucket");
			FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack(fluid.getName(), FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(bucket), new ItemStack(Items.bucket)));
			BucketHandler.INSTANCE.put(block, bucket);
		}
		
	}
	
	private void registerFluid(FluidIP fluidHolder) {
		String unlocalizedName = "IP.fluid."+fluidHolder.getItem().getName();
		BlockRegistry.registerFluid(fluidHolder.getBlock(), unlocalizedName+".block");
		FluidRegistry.registerFluid(fluidHolder.getItem());
		fluidHolder.getItem().setUnlocalizedName(unlocalizedName+".fluid");
		if (fluidHolder.getBucket() != null) {
			ItemRegistry.registerBucket(fluidHolder.getBucket(), unlocalizedName+".bucket");
			FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack(fluidHolder.getItem().getName(), FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(fluidHolder.getBucket()), new ItemStack(Items.bucket)));
			BucketHandler.INSTANCE.put(fluidHolder.getBlock(), fluidHolder.getBucket());
		}
		
	}

	public void registerFluids() {
		
		BucketRegistery.put(ItemBucket.class, ItemIPBucket.class);
		
		registerFluid(ISetupFluids.fluidLightNaphtha);
		registerFluid(ISetupFluids.fluidDirtyWater);
		registerFluid(ISetupFluids.fluidFiltyWater);
		registerFluid(ISetupFluids.fluidUncleanWater);
		
		/*registerFluid(ISetupFluids.blockFluidIsoButane, ISetupFluids.itemFluidIsoButane, null, "Isobutane");
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

		registerFluid(ISetupFluids.blockFluidCycloneChromiteSediment, ISetupFluids.itemFluidCycloneChromiteSediment,ISetupFluids.bucketCycloneChromiteSediment, "Cyclone Chromite Sediment");
		registerFluid(ISetupFluids.blockFluidCycloneCopperSediment, ISetupFluids.itemFluidCycloneCopperSediment,ISetupFluids.bucketCycloneCopperSediment, "Cyclone Copper Sediment");
		registerFluid(ISetupFluids.blockFluidCycloneGalenaSediment, ISetupFluids.itemFluidCycloneGalenaSediment,ISetupFluids.bucketCycloneGalenaSediment, "Cyclone Galena Sediment");
		registerFluid(ISetupFluids.blockFluidCycloneTinSediment, ISetupFluids.itemFluidCycloneTinSediment,ISetupFluids.bucketCycloneTinSediment, "Cyclone Tin Sediment");
		registerFluid(ISetupFluids.blockFluidCycloneGoldSediment, ISetupFluids.itemFluidCycloneGoldSediment,ISetupFluids.bucketCycloneGoldSediment, "Cyclone Gold Sediment");
		registerFluid(ISetupFluids.blockFluidCycloneIronSediment, ISetupFluids.itemFluidCycloneIronSediment,ISetupFluids.bucketCycloneIronSediment, "Cyclone Iron Sediment");
		registerFluid(ISetupFluids.blockFluidCycloneTaliaSediment, ISetupFluids.itemFluidCycloneTaliaSediment,ISetupFluids.bucketCycloneTaliaSediment, "Cyclone Talia Sediment");
		 
		
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
		LanguageRegistry.addName(ISetupFluids.bucketMixedSludgeTalia, "Thalium mixedSludge Bucket");*/

	}

}

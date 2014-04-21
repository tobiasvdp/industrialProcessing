package mod.industrialProcessing.fluids;

import mod.industrialProcessing.utils.handlers.fluids.BucketHandler;
import mod.industrialProcessing.utils.registry.BlockRegistry;
import mod.industrialProcessing.utils.registry.BucketRegistery;
import mod.industrialProcessing.utils.registry.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidContainerRegistry.FluidContainerData;
import net.minecraftforge.fluids.FluidRegistry;

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
		registerFluid(ISetupFluids.fluidParaffinicNaphtha);
		registerFluid(ISetupFluids.fluidHeavyNaphtha);
		registerFluid(ISetupFluids.fluidHeavyVirginNaphtha);
		registerFluid(ISetupFluids.fluidLightVacuumGasOil);
		registerFluid(ISetupFluids.fluidHeavyvacuumGasOil);
		registerFluid(ISetupFluids.fluidUntreatedKerosene);
		registerFluid(ISetupFluids.fluidKerosene);
		registerFluid(ISetupFluids.fluidUntreatedDieselOil);
		registerFluid(ISetupFluids.fluidDieselOil);
		registerFluid(ISetupFluids.fluidGasOil);
		registerFluid(ISetupFluids.fluidAtmosphericBottoms);
		registerFluid(ISetupFluids.fluidMicrobialWater);
		registerFluid(ISetupFluids.fluidLatex);
		registerFluid(ISetupFluids.fluidOreSludgeIron);
		registerFluid(ISetupFluids.fluidOreSludgeChromite);
		registerFluid(ISetupFluids.fluidOreSludgeGalena);
		registerFluid(ISetupFluids.fluidOreSludgeGold);
		registerFluid(ISetupFluids.fluidOreSludgeTalia);
		registerFluid(ISetupFluids.fluidOreSludgeCopper);
		registerFluid(ISetupFluids.fluidOreSludgeTin);
		registerFluid(ISetupFluids.fluidHotSlag);
		registerFluid(ISetupFluids.fluidPigIron);
		registerFluid(ISetupFluids.fluidHotSteel);
		registerFluid(ISetupFluids.fluidExhaustGas);
		registerFluid(ISetupFluids.fluidSteam);
		registerFluid(ISetupFluids.fluidGritSludge);
		registerFluid(ISetupFluids.fluidResidu);
		registerFluid(ISetupFluids.fluidAir);
		registerFluid(ISetupFluids.fluidCO2);
		registerFluid(ISetupFluids.fluidH2);
		registerFluid(ISetupFluids.fluidH2S);
		registerFluid(ISetupFluids.fluidIsoButane);
		registerFluid(ISetupFluids.fluidButane);
		registerFluid(ISetupFluids.fluidAlkylate);
		registerFluid(ISetupFluids.fluidGasMix);
		registerFluid(ISetupFluids.fluidFuelGas);
		registerFluid(ISetupFluids.fluidUnsweetenedLPG);
		registerFluid(ISetupFluids.fluidUnsweetenedButane);
		registerFluid(ISetupFluids.fluidIsomerate);
		registerFluid(ISetupFluids.fluidAsphaltSludge);
		registerFluid(ISetupFluids.fluidSourWater);
		registerFluid(ISetupFluids.fluidMixedSludgeIron);
		registerFluid(ISetupFluids.fluidMixedSludgeChromite);
		registerFluid(ISetupFluids.fluidMixedSludgeGalena);
		registerFluid(ISetupFluids.fluidMixedSludgeGold);
		registerFluid(ISetupFluids.fluidMixedSludgeTalia);
		registerFluid(ISetupFluids.fluidMixedSludgeCopper);
		registerFluid(ISetupFluids.fluidMixedSludgeTin);
		registerFluid(ISetupFluids.fluidResin);
		registerFluid(ISetupFluids.fluidThickTinSludge);
		registerFluid(ISetupFluids.fluidThickCopperSludge);
		registerFluid(ISetupFluids.fluidThickTaliaSludge);
		registerFluid(ISetupFluids.fluidThickGoldSludge);
		registerFluid(ISetupFluids.fluidThickGalenaSludge);
		registerFluid(ISetupFluids.fluidThickChromiteSludge);
		registerFluid(ISetupFluids.fluidThickIronSludge);
		registerFluid(ISetupFluids.fluidFlotationTinSediment);
		registerFluid(ISetupFluids.fluidFlotationCopperSediment);
		registerFluid(ISetupFluids.fluidFlotationTaliaSediment);
		registerFluid(ISetupFluids.fluidFlotationGoldSediment);
		registerFluid(ISetupFluids.fluidFlotationGalenaSediment);
		registerFluid(ISetupFluids.fluidFlotationChromiteSediment);
		registerFluid(ISetupFluids.fluidFlotationIronSediment);
		registerFluid(ISetupFluids.fluidCycloneTinSediment);
		registerFluid(ISetupFluids.fluidCycloneCopperSediment);
		registerFluid(ISetupFluids.fluidCycloneTaliaSediment);
		registerFluid(ISetupFluids.fluidCycloneGoldSediment);
		registerFluid(ISetupFluids.fluidCycloneGalenaSediment);
		registerFluid(ISetupFluids.fluidCycloneChromiteSediment);
		registerFluid(ISetupFluids.fluidCycloneIronSediment);
		registerFluid(ISetupFluids.fluidConcentratedTinSludge);
		registerFluid(ISetupFluids.fluidConcentratedCopperSludge);
		registerFluid(ISetupFluids.fluidConcentratedTaliaSludge);
		registerFluid(ISetupFluids.fluidConcentratedGoldSludge);
		registerFluid(ISetupFluids.fluidConcentratedGalenaSludge);
		registerFluid(ISetupFluids.fluidConcentratedChromiteSludge);
		registerFluid(ISetupFluids.fluidConcentratedIronSludge);
		registerFluid(ISetupFluids.fluidLightTinSediment);
		registerFluid(ISetupFluids.fluidLightCopperSediment);
		registerFluid(ISetupFluids.fluidLightTaliaSediment);
		registerFluid(ISetupFluids.fluidLightGoldSediment);
		registerFluid(ISetupFluids.fluidLightGalenaSediment);
		registerFluid(ISetupFluids.fluidLightChromiteSediment);
		registerFluid(ISetupFluids.fluidLightIronSediment);
		registerFluid(ISetupFluids.fluidThickTinSediment);
		registerFluid(ISetupFluids.fluidThickCopperSediment);
		registerFluid(ISetupFluids.fluidThickTaliaSediment);
		registerFluid(ISetupFluids.fluidThickGoldSediment);
		registerFluid(ISetupFluids.fluidThickGalenaSediment);
		registerFluid(ISetupFluids.fluidThickChromiteSediment);
		registerFluid(ISetupFluids.fluidThickIronSediment);
		registerFluid(ISetupFluids.fluidPasteTinSediment);
		registerFluid(ISetupFluids.fluidPasteCopperSediment);
		registerFluid(ISetupFluids.fluidPasteTaliaSediment);
		registerFluid(ISetupFluids.fluidPasteGoldSediment);
		registerFluid(ISetupFluids.fluidPasteGalenaSediment);
		registerFluid(ISetupFluids.fluidPasteChromiteSediment);
		registerFluid(ISetupFluids.fluidPasteIronSediment);

	}

}

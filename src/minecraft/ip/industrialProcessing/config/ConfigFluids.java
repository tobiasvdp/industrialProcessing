package ip.industrialProcessing.config;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.fluids.ContainerFluid;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidContainerRegistry.FluidContainerData;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ConfigFluids {
	
	public ConfigFluids(){
		
	}

	
	private int offset = 2500;
	private int blockFluidBaseDirtyWaterID = offset;
	private int BucketDirtyWaterID = offset+1;
	private int blockFluidBaseOreSludgeIronID = offset+2;
	private int blockFluidBaseOreSludgeCopperID = offset+3;
	private int blockFluidBaseOreSludgeTinID = offset+4;
	private int BucketOreSludgeIronID = offset+5;
	private int BucketOreSludgeCopperID = offset+6;
	private int BucketOreSludgeTinID = offset+7;
	private int BucketHotSlagID = offset+8;
	private int BucketPigIronID = offset+9;
	private int BucketHotSteelID = offset+10;
	private int blockFluidBaseHotSlagID = offset+11;
	private int blockFluidBasePigIronID = offset+12;
	private int blockFluidBaseHotSteelID = offset+13;
	private int blockFluidBaseExhaustGasID = offset+14;
	
	private int blockFluidBaseSteamID = offset + 15; 
	
	public static int blockFluidBaseDirtyWaterID(){return getInstance().blockFluidBaseDirtyWaterID;}
	public static int BucketDirtyWaterID(){return getInstance().BucketDirtyWaterID;}
	public static int blockFluidBaseOreSludgeIronID() {return getInstance().blockFluidBaseOreSludgeIronID ;}
	public static int blockFluidBaseOreSludgeCopperID() {return getInstance().blockFluidBaseOreSludgeCopperID ;}
	public static int blockFluidBaseOreSludgeTinID() {return getInstance().blockFluidBaseOreSludgeTinID ;}
	public static int BucketOreSludgeIronID() {return getInstance().BucketOreSludgeIronID ;}
	public static int BucketOreSludgeCopperID() {return getInstance().BucketOreSludgeCopperID ;}
	public static int BucketOreSludgeTinID() {return getInstance().BucketOreSludgeTinID ;}
	public static int BucketHotSlagID() {return getInstance().BucketHotSlagID ;}
	public static int BucketPigIronID() {return getInstance().BucketPigIronID ;}
	public static int BucketHotSteelID() {return getInstance().BucketHotSteelID ;}
	public static int blockFluidBaseHotSlagID() {return getInstance().blockFluidBaseHotSlagID ;}
	public static int blockFluidBasePigIronID() {return getInstance().blockFluidBasePigIronID ;}
	public static int blockFluidBaseHotSteelID() {return getInstance().blockFluidBaseHotSteelID ;}
	public static int blockFluidBaseExhaustGasID() {return getInstance().blockFluidBaseExhaustGasID ;}
	public static int blockFluidBaseSteamID() {return getInstance().blockFluidBaseSteamID ;}
	
	public void registerFluids(){
		registerFluid(IndustrialProcessing.blockFluidDirtyWater, IndustrialProcessing.itemFluidDirtyWater, IndustrialProcessing.bucketDirtyWater, "Dirty water");
		LanguageRegistry.addName(IndustrialProcessing.bucketDirtyWater, "Dirty water Bucket");
		registerFluid(IndustrialProcessing.blockFluidOreSludgeIron, IndustrialProcessing.itemFluidOreSludgeIron, IndustrialProcessing.bucketOreSludgeIron, "Iron ore sludge");
		LanguageRegistry.addName(IndustrialProcessing.bucketOreSludgeIron, "Iron sludge Bucket");
		registerFluid(IndustrialProcessing.blockFluidOreSludgeCopper, IndustrialProcessing.itemFluidOreSludgeCopper, IndustrialProcessing.bucketOreSludgeCopper, "Copper ore sludge");
		LanguageRegistry.addName(IndustrialProcessing.bucketOreSludgeCopper, "Copper sludge Bucket");
		registerFluid(IndustrialProcessing.blockFluidOreSludgeTin, IndustrialProcessing.itemFluidOreSludgeTin, IndustrialProcessing.bucketOreSludgeTin, "Tin ore sludge");
		LanguageRegistry.addName(IndustrialProcessing.bucketOreSludgeTin, "Tin sludge Bucket");
		registerFluid(IndustrialProcessing.blockFluidHotSlag, IndustrialProcessing.itemFluidHotSlag, IndustrialProcessing.bucketHotSlag, "Hot slag");
		LanguageRegistry.addName(IndustrialProcessing.bucketHotSlag, "Hot slag Bucket");
		registerFluid(IndustrialProcessing.blockFluidPigIron, IndustrialProcessing.itemFluidPigIron, IndustrialProcessing.bucketPigIron, "Pig iron");
		LanguageRegistry.addName(IndustrialProcessing.bucketPigIron, "Pig iron Bucket");
		registerFluid(IndustrialProcessing.blockFluidHotSteel, IndustrialProcessing.itemFluidHotSteel, IndustrialProcessing.bucketHotSteel, "Molten steel");
		LanguageRegistry.addName(IndustrialProcessing.bucketHotSteel, "Molten steel Bucket");
		registerFluid(IndustrialProcessing.blockFluidExhaustGas, IndustrialProcessing.itemFluidExhaustGas, null, "Exhaust gas");
		
		registerFluid(IndustrialProcessing.blockFluidSteam, IndustrialProcessing.itemFluidSteam, null, "Steam");
	}
	
	private void registerFluid(Block block, Fluid fluid, ContainerFluid bucket, String displayName) {
		GameRegistry.registerBlock(block, "BlockFluid" + fluid.getName());
		LanguageRegistry.addName(block, displayName);
		if (bucket != null){
			FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack(fluid.getName(), FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(bucket), new ItemStack(Item.bucketEmpty)));
		}
		//FluidRegistry.registerFluid(fluid) is done in constructor of itemFluid;
	}
	
	
	private static ConfigFluids instance = new ConfigFluids();
	
	public static ConfigFluids getInstance(){
		return instance;
	}

}
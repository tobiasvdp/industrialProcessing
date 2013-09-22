package ip.industrialProcessing.config;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.api.config.ConfigCategories;
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
	private int blockFluidBaseDirtyWaterID = IndustrialProcessing.config.get(ConfigCategories.fluids.toString(),"DirtyWaterID",offset).getInt();
	private int BucketDirtyWaterID = offset+1;
	private int blockFluidBaseOreSludgeIronID = IndustrialProcessing.config.get(ConfigCategories.fluids.toString(),"IronSludgeID",offset+2).getInt();
	private int blockFluidBaseOreSludgeCopperID = IndustrialProcessing.config.get(ConfigCategories.fluids.toString(),"CopperSludgeID",offset+3).getInt();
	private int blockFluidBaseOreSludgeTinID = IndustrialProcessing.config.get(ConfigCategories.fluids.toString(),"TinSludgeID",offset+4).getInt();
	private int BucketOreSludgeIronID = offset+5;
	private int BucketOreSludgeCopperID = offset+6;
	private int BucketOreSludgeTinID = offset+7;
	private int BucketHotSlagID = offset+8;
	private int BucketPigIronID = offset+9;
	private int BucketHotSteelID = offset+10;
	private int blockFluidBaseHotSlagID = IndustrialProcessing.config.get(ConfigCategories.fluids.toString(),"HotSlagID",offset+11).getInt();
	private int blockFluidBasePigIronID = IndustrialProcessing.config.get(ConfigCategories.fluids.toString(),"PigIronID",offset+12).getInt();
	private int blockFluidBaseHotSteelID = IndustrialProcessing.config.get(ConfigCategories.fluids.toString(),"HotSteelID",offset+13).getInt();
	private int blockFluidBaseExhaustGasID = IndustrialProcessing.config.get(ConfigCategories.fluids.toString(),"ExhaustGasID",offset+14).getInt();
	
	private int blockFluidBaseSteamID = IndustrialProcessing.config.get(ConfigCategories.fluids.toString(),"SteamID",offset + 15).getInt(); 
	
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
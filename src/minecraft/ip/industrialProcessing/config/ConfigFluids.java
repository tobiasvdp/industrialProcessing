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

	private int blockFluidBaseDirtyWaterID = 2000;
	private int BucketDirtyWaterID = 2001;
	private int blockFluidBaseOreSludgeIronID = 2002;
	private int blockFluidBaseOreSludgeCopperID = 2003;
	private int blockFluidBaseOreSludgeTinID = 2004;
	private int BucketOreSludgeIronID = 2005;
	private int BucketOreSludgeCopperID = 2006;
	private int BucketOreSludgeTinID = 2007;
	
	public static int blockFluidBaseDirtyWaterID(){return getInstance().blockFluidBaseDirtyWaterID;}
	public static int BucketDirtyWaterID(){return getInstance().BucketDirtyWaterID;}
	public static int blockFluidBaseOreSludgeIronID() {return getInstance().blockFluidBaseOreSludgeIronID ;}
	public static int blockFluidBaseOreSludgeCopperID() {return getInstance().blockFluidBaseOreSludgeCopperID ;}
	public static int blockFluidBaseOreSludgeTinID() {return getInstance().blockFluidBaseOreSludgeTinID ;}
	public static int BucketOreSludgeIronID() {return getInstance().BucketOreSludgeIronID ;}
	public static int BucketOreSludgeCopperID() {return getInstance().BucketOreSludgeCopperID ;}
	public static int BucketOreSludgeTinID() {return getInstance().BucketOreSludgeTinID ;}
	
	public void registerFluids(){
		registerFluid(IndustrialProcessing.blockFluidDirtyWater, IndustrialProcessing.itemFluidDirtyWater, IndustrialProcessing.bucketDirtyWater, "Dirty water");
		LanguageRegistry.addName(IndustrialProcessing.bucketDirtyWater, "Dirty water Bucket");
		registerFluid(IndustrialProcessing.blockFluidOreSludgeIron, IndustrialProcessing.itemFluidOreSludgeIron, IndustrialProcessing.bucketOreSludgeIron, "Iron ore sludge");
		LanguageRegistry.addName(IndustrialProcessing.bucketOreSludgeIron, "Iron sludge Bucket");
		registerFluid(IndustrialProcessing.blockFluidOreSludgeCopper, IndustrialProcessing.itemFluidOreSludgeCopper, IndustrialProcessing.bucketOreSludgeCopper, "Copper ore sludge");
		LanguageRegistry.addName(IndustrialProcessing.bucketOreSludgeCopper, "Copper sludge Bucket");
		registerFluid(IndustrialProcessing.blockFluidOreSludgeTin, IndustrialProcessing.itemFluidOreSludgeTin, IndustrialProcessing.bucketOreSludgeTin, "Tin ore sludge");
		LanguageRegistry.addName(IndustrialProcessing.bucketOreSludgeTin, "Tin sludge Bucket");
	}
	
	private void registerFluid(Block block, Fluid fluid, ContainerFluid bucket, String displayName) {
		GameRegistry.registerBlock(block, "BlockFluid" + fluid.getName());
		LanguageRegistry.addName(block, displayName);
		FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack(fluid.getName(), FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(bucket), new ItemStack(Item.bucketEmpty)));
	}
	
	private ConfigFluids(){
	
	}
	
	private static ConfigFluids instance = new ConfigFluids();
	
	public static ConfigFluids getInstance(){
		return instance;
	}

}
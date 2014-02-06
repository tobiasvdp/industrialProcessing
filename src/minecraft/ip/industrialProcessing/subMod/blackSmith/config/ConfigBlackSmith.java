package ip.industrialProcessing.subMod.blackSmith.config;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.api.config.ConfigCategories;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ISetupItems;
import ip.industrialProcessing.config.ISetupMachineBlocks;
import ip.industrialProcessing.recipes.VanillaRecipeBridge;
import ip.industrialProcessing.subMod.blackSmith.IPBlackSmith;
import ip.industrialProcessing.subMod.blackSmith.item.ItemWoodenBucket;
import ip.industrialProcessing.subMod.blackSmith.item.ItemWoodenBucketFilled;
import ip.industrialProcessing.subMod.blackSmith.plant.bloomery.TileEntityBloomery;
import ip.industrialProcessing.subMod.blackSmith.plant.bloomery.dummy.bellows.TileEntityBellows;
import ip.industrialProcessing.subMod.blackSmith.plant.bloomery.dummy.ironBowl.TileEntityIronBowl;
import ip.industrialProcessing.subMod.blackSmith.plant.tripHammer.TileEntityTripHammer;
import ip.industrialProcessing.subMod.blackSmith.plant.tripHammer.dummy.woodenBar.TileEntityWoodenBar;
import ip.industrialProcessing.subMod.blackSmith.plant.tripHammer.dummy.woodenHammer.TileEntityWoodenHammer;
import ip.industrialProcessing.subMod.blackSmith.plant.tripHammer.dummy.woodenWheel.TileEntityWoodenWheel;
import ip.industrialProcessing.subMod.blackSmith.plant.waterBasin.TileEntityWaterBasinCore;
import ip.industrialProcessing.subMod.blackSmith.plant.waterBasin.TileEntityWaterBasinDummy;
import ip.industrialProcessing.utils.registry.BlockType;
import ip.industrialProcessing.utils.registry.BucketRegistery;
import ip.industrialProcessing.utils.registry.RecipeRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidContainerRegistry.FluidContainerData;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ConfigBlackSmith {
	private static ConfigBlackSmith instance = new ConfigBlackSmith();
	public static final int WILDCARD_VALUE = Short.MAX_VALUE;

	public static ConfigBlackSmith getInstance() {
		return instance;
	}

	// items
	private static int ItemWroughtIronID = 6000;
	private static int itemWoodenBucketID = 6001;
	private static int itemWoodenBucketWaterID = 6002;

	// blocks
	private int bloomeryBlockID = IPBlackSmith.config.get(ConfigCategories.machineOreProcessing.toString(), "bloomeryBlockID", 950).getInt();
	private int rendererBloomery;

	private int bellowsBlockID = IPBlackSmith.config.get(ConfigCategories.machineOreProcessing.toString(), "bellowsBlockID", 951).getInt();
	private int rendererBellows;

	private int ironBowlBlockID = IndustrialProcessing.config.get(ConfigCategories.machineOreProcessing.toString(), "ironBowlBlockID", 952).getInt();
	private int rendererIronBowl;

	private int waterBasinBlockID = IndustrialProcessing.config.get(ConfigCategories.machineOreProcessing.toString(), "waterBasinBlockID", 953).getInt();
	private int rendererWaterBasin;
	
	private int tripHammerBlockID = IndustrialProcessing.config.get(ConfigCategories.machineOreProcessing.toString(), "tripHammerBlockID", 954).getInt();
	private int rendererTripHammer;
	
	private int woodenBarBlockID = IndustrialProcessing.config.get(ConfigCategories.machineOreProcessing.toString(), "woodenBarBlockID", 955).getInt();
	private int rendererWoodenBar;
	
	private int woodenWheelBlockID = IndustrialProcessing.config.get(ConfigCategories.machineOreProcessing.toString(), "woodenWheelBlockID", 956).getInt();
	private int rendererWoodenWheel;
	
	private int woodenHammerBlockID = IndustrialProcessing.config.get(ConfigCategories.machineOreProcessing.toString(), "woodenHammerBlockID", 957).getInt();
	private int rendererWoodenHammer;

	public void register() {

		// items
		LanguageRegistry.addName(ISetupBlackSmith.itemWroughtIron, "Wrought iron");
		LanguageRegistry.instance().addStringLocalization(ISetupBlackSmith.itemWroughtIron.getUnlocalizedName() + ".desc", "A porous mass of iron. It can be heated again to shape it into an object.");
		LanguageRegistry.addName(ISetupBlackSmith.itemWoodenBucket, "Wooden bucket");
		LanguageRegistry.addName(ISetupBlackSmith.itemWoodenBucketWater, "Wooden bucket of water");
		BucketRegistery.put(ItemWoodenBucket.class, ItemWoodenBucketFilled.class);
		FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack(FluidRegistry.WATER.getName(), FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(ISetupBlackSmith.itemWoodenBucketWater), new ItemStack(ISetupBlackSmith.itemWoodenBucket)));
		
		// machines
		ConfigMachineBlocks.registerMachineBlock(ISetupBlackSmith.blockBloomery, "IP.MBC.Bloom", "Bloomery", TileEntityBloomery.class, BlockType.Machine, BlockType.blackSmith);
		ConfigMachineBlocks.registerMachineBlock(ISetupBlackSmith.blockBellows, "IP.MBD.Bellow", "Bellows", TileEntityBellows.class, BlockType.Machine, BlockType.blackSmith);
		ConfigMachineBlocks.registerMachineBlock(ISetupBlackSmith.blockIronBowl, "IP.MBD.IBowl", "Iron bowl", TileEntityIronBowl.class, BlockType.Machine, BlockType.blackSmith);
		ConfigMachineBlocks.registerMachineBlock(ISetupBlackSmith.blockWaterBasin, "IP.MBD.WaterB", "Water basin", TileEntityWaterBasinDummy.class, BlockType.Machine, BlockType.blackSmith);
		GameRegistry.registerTileEntity(TileEntityWaterBasinCore.class, "IP.MBC.WaterB");
		ConfigMachineBlocks.registerMachineBlock(ISetupBlackSmith.blockTripHammer, "IP.MBC.Trip", "Trip hammer base", TileEntityTripHammer.class, BlockType.Machine, BlockType.blackSmith);
		ConfigMachineBlocks.registerMachineBlock(ISetupBlackSmith.blockWoodenBar, "IP.MBD.WBar", "Wooden bar", TileEntityWoodenBar.class, BlockType.Dummy, BlockType.blackSmith);
		ConfigMachineBlocks.registerMachineBlock(ISetupBlackSmith.blockWoodenHammer, "IP.MBD.WHam", "Wooden hammer", TileEntityWoodenHammer.class, BlockType.Dummy, BlockType.blackSmith);
		ConfigMachineBlocks.registerMachineBlock(ISetupBlackSmith.blockWoodenWheel, "IP.MBD.WWheel", "Wooden wheel", TileEntityWoodenWheel.class, BlockType.Dummy, BlockType.blackSmith);

		// vanilla recipes
		RecipeRegistry.appendVanillaRecipe(VanillaRecipeBridge.getRecipeFromVanilla(GameRegistry.addShapedRecipe(new ItemStack(ISetupBlackSmith.blockBloomery), "xyx", "y y", "xzx", 'x', new ItemStack(Item.brick), 'y', new ItemStack(Block.dirt), 'z', new ItemStack(Block.cobblestone))));
		RecipeRegistry.appendVanillaRecipe(VanillaRecipeBridge.getRecipeFromVanilla(GameRegistry.addShapedRecipe(new ItemStack(ISetupBlackSmith.blockBellows), "xxx", "yyy", "xxx", 'x', new ItemStack(Block.wood, 1, WILDCARD_VALUE), 'y', new ItemStack(Item.leather))));
		RecipeRegistry.appendVanillaRecipe(VanillaRecipeBridge.getRecipeFromVanilla(GameRegistry.addShapedRecipe(new ItemStack(ISetupBlackSmith.blockIronBowl), "   ", "xyx", "   ", 'x', new ItemStack(ISetupItems.itemThickStick), 'y', new ItemStack(ISetupItems.itemIronBowl, 8))));
		RecipeRegistry.appendVanillaRecipe(VanillaRecipeBridge.getRecipeFromVanilla(GameRegistry.addShapedRecipe(new ItemStack(ISetupBlackSmith.blockWaterBasin), "   ", "x x", "xxx", 'x', new ItemStack(Block.cobblestone))));
		RecipeRegistry.appendVanillaRecipe(VanillaRecipeBridge.getRecipeFromVanilla(GameRegistry.addShapedRecipe(new ItemStack(ISetupBlackSmith.itemWoodenBucket), " y ", "x x", " x ", 'x', new ItemStack(Block.planks,1,WILDCARD_VALUE),'y',new ItemStack(Item.silk))));
	}

	public static int getItemWroughtIronID() {
		return getInstance().ItemWroughtIronID;
	}

	public static int getItemWoodenBucketID() {
		return getInstance().itemWoodenBucketID;
	}
	
	public static int getItemWoodenBucketWaterID() {
		return getInstance().itemWoodenBucketWaterID;
	}


	public static int getBlockBloomeryID() {
		return getInstance().bloomeryBlockID;
	}

	public static int getRendererBloomeryId() {
		return getInstance().rendererBloomery;
	}

	public static void setRendererBloomeryId(int id) {
		getInstance().rendererBloomery = id;
	}

	public static int getBlockBellowsID() {
		return getInstance().bellowsBlockID;
	}

	public static int getRendererBellowsId() {
		return getInstance().rendererBellows;
	}

	public static void setRendererBellowsId(int id) {
		getInstance().rendererBellows = id;
	}

	public static int getBlockIronBowlID() {
		return getInstance().ironBowlBlockID;
	}

	public static int getRendererIronBowlId() {
		return getInstance().rendererIronBowl;
	}

	public static void setRendererIronBowlId(int id) {
		getInstance().rendererIronBowl = id;
	}

	public static int getBlockWaterBasinID() {
		return getInstance().waterBasinBlockID;
	}

	public static int getRendererWaterBasinId() {
		return getInstance().rendererWaterBasin;
	}

	public static void setRendererWaterBasinId(int id) {
		getInstance().rendererWaterBasin = id;
	}
	
	public static int getBlockTripHammerID() {
		return getInstance().tripHammerBlockID;
	}

	public static int getRendererTripHammerId() {
		return getInstance().rendererTripHammer;
	}

	public static void setRendererTripHammerId(int id) {
		getInstance().rendererTripHammer = id;
	}
	
	public static int getBlockWoodenBarID() {
		return getInstance().woodenBarBlockID;
	}

	public static int getRendererWoodenBarId() {
		return getInstance().rendererWoodenBar;
	}

	public static void setRendererWoodenBarId(int id) {
		getInstance().rendererWoodenBar = id;
	}
	
	public static int getBlockWoodenHammerID() {
		return getInstance().woodenHammerBlockID;
	}

	public static int getRendererWoodenHammerId() {
		return getInstance().rendererWoodenHammer;
	}

	public static void setRendererWoodenHammerId(int id) {
		getInstance().rendererWoodenHammer = id;
	}
	
	public static int getBlockWoodenWheelID() {
		return getInstance().woodenWheelBlockID;
	}

	public static int getRendererWoodenWheelId() {
		return getInstance().rendererWoodenWheel;
	}

	public static void setRendererWoodenWheelId(int id) {
		getInstance().rendererWoodenWheel = id;
	}

}

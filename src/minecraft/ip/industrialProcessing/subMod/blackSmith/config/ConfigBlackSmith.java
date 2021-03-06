package ip.industrialProcessing.subMod.blackSmith.config;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.api.config.ConfigCategories;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ISetupItems;
import ip.industrialProcessing.recipes.VanillaRecipeBridge;
import ip.industrialProcessing.subMod.blackSmith.IPBlackSmith;
import ip.industrialProcessing.subMod.blackSmith.item.ItemWoodenBucket;
import ip.industrialProcessing.subMod.blackSmith.item.ItemWoodenBucketFilled;
import ip.industrialProcessing.subMod.blackSmith.plant.bloomery.TileEntityBloomery;
import ip.industrialProcessing.subMod.blackSmith.plant.bloomery.dummy.bellows.TileEntityBellows;
import ip.industrialProcessing.subMod.blackSmith.plant.bloomery.dummy.ironBowl.TileEntityIronBowl;
import ip.industrialProcessing.subMod.blackSmith.plant.forge.TileEntityForgeCore;
import ip.industrialProcessing.subMod.blackSmith.plant.forge.TileEntityForgeDummy;
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
import net.minecraftforge.fluids.FluidContainerRegistry.FluidContainerData;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ConfigBlackSmith {
	private static ConfigBlackSmith instance = new ConfigBlackSmith();
	public static final int WILDCARD_VALUE = Short.MAX_VALUE;

	public static ConfigBlackSmith getInstance() {
		return instance;
	}

	// items
	private static int itemWroughtIronID = 6000;
	private static int itemWoodenBucketID = 6001;
	private static int itemWoodenBucketWaterID = 6002;
	//private static int itemBloomIronID = 6003;
	//private static int itemHeatedIronID = 6004;
	private static int itemPliersID = 6005;
	private static int itemPliersBloomIronID = 6006;
	private static int itemPliersHeatedironID = 6007;

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
	
	private int forgeBlockID = IndustrialProcessing.config.get(ConfigCategories.machineOreProcessing.toString(), "forgeBlockID", 958).getInt();
	private int rendererForge;
	
	private int waterWheelBlockID = IndustrialProcessing.config.get(ConfigCategories.machineOreProcessing.toString(), "WaterWheelBlockID", 959).getInt();
	private int rendererWaterWheel;

	public void register() {

		// items
		LanguageRegistry.addName(ISetupBlackSmith.itemWroughtIron, "Wrought iron");
		LanguageRegistry.instance().addStringLocalization(ISetupBlackSmith.itemWroughtIron.getUnlocalizedName() + ".desc", "A porous mass of iron. It can be heated again to shape it into an object.");
		LanguageRegistry.addName(ISetupBlackSmith.itemWoodenBucket, "Wooden bucket");
		LanguageRegistry.addName(ISetupBlackSmith.itemWoodenBucketWater, "Wooden bucket of water");
		BucketRegistery.put(ItemWoodenBucket.class, ItemWoodenBucketFilled.class);
		FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack(FluidRegistry.WATER.getName(), FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(ISetupBlackSmith.itemWoodenBucketWater), new ItemStack(ISetupBlackSmith.itemWoodenBucket)));
		LanguageRegistry.addName(ISetupBlackSmith.itemPliersBloomIron, "Bloom (iron)");
		LanguageRegistry.instance().addStringLocalization(ISetupBlackSmith.itemPliersBloomIron.getUnlocalizedName() + ".desc", "Wrought iron heated to a high temperature, still containing some slag.");
		LanguageRegistry.addName(ISetupBlackSmith.itemPliersHeatedIron, "Heated iron");
		LanguageRegistry.instance().addStringLocalization(ISetupBlackSmith.itemPliersHeatedIron.getUnlocalizedName() + ".desc", "Bloom that has been consolidated using the trip hammer");
		LanguageRegistry.addName(ISetupBlackSmith.itemPliers, "Pliers");
		LanguageRegistry.instance().addStringLocalization(ISetupBlackSmith.itemPliers.getUnlocalizedName() + ".desc", "Pliers are used to move really hot items arround.");		
		
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
		ConfigMachineBlocks.registerMachineBlock(ISetupBlackSmith.blockForge, "IP.MBD.Forge", "Forge", TileEntityForgeDummy.class, BlockType.Machine, BlockType.blackSmith);
		GameRegistry.registerTileEntity(TileEntityForgeCore.class, "IP.MBC.Forge");
		
		// vanilla recipes
		RecipeRegistry.appendVanillaRecipe(VanillaRecipeBridge.getRecipeFromVanilla(GameRegistry.addShapedRecipe(new ItemStack(ISetupBlackSmith.blockBellows), "xxx", "yyy", "xxx", 'x', new ItemStack(Block.wood, 1, WILDCARD_VALUE), 'y', new ItemStack(Item.leather))));
		RecipeRegistry.appendVanillaRecipe(VanillaRecipeBridge.getRecipeFromVanilla(GameRegistry.addShapedRecipe(new ItemStack(ISetupBlackSmith.blockIronBowl), "   ", "xyx", "   ", 'x', new ItemStack(ISetupItems.itemThickStick), 'y', new ItemStack(ISetupItems.itemIronBowl, 8))));
		RecipeRegistry.appendVanillaRecipe(VanillaRecipeBridge.getRecipeFromVanilla(GameRegistry.addShapedRecipe(new ItemStack(ISetupBlackSmith.blockWaterBasin), "   ", "x x", "xxx", 'x', new ItemStack(Block.cobblestone))));
		RecipeRegistry.appendVanillaRecipe(VanillaRecipeBridge.getRecipeFromVanilla(GameRegistry.addShapedRecipe(new ItemStack(ISetupBlackSmith.itemWoodenBucket), " y ", "x x", " x ", 'x', new ItemStack(Block.planks,1,WILDCARD_VALUE),'y',new ItemStack(Item.silk))));
		RecipeRegistry.appendVanillaRecipe(VanillaRecipeBridge.getRecipeFromVanilla(GameRegistry.addShapedRecipe(new ItemStack(ISetupBlackSmith.itemPliers), "x x", " x ", " x ", 'x', new ItemStack(Block.cobblestone))));
	}

	public static int getItemWroughtIronID() {
		return getInstance().itemWroughtIronID;
	}

	public static int getItemWoodenBucketID() {
		return getInstance().itemWoodenBucketID;
	}
	
	public static int getItemWoodenBucketWaterID() {
		return getInstance().itemWoodenBucketWaterID;
	}
	
	public static int getItemPliersHeatedironID() {
		return getInstance().itemPliersHeatedironID;
	}
	
	public static int getItemPliersID() {
		return getInstance().itemPliersID;
	}
	
	public static int getItemPliersBloomIronID() {
		return getInstance().itemPliersBloomIronID;
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
	
	public static int getBlockForgeID() {
		return getInstance().forgeBlockID;
	}

	public static int getRendererForgeId() {
		return getInstance().rendererForge;
	}

	public static void setRendererForgeId(int id) {
		getInstance().rendererForge = id;
	}

	public static int getBlockWaterWheelID() {
		return getInstance().waterWheelBlockID;
	}

	public static int getRendererWaterWheelId() {
		return getInstance().rendererWaterWheel;
	}

	public static void setRendererWaterWheelId(int id) {
		getInstance().rendererWaterWheel = id;
	}
}

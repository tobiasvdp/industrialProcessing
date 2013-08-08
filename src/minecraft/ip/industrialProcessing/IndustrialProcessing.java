package ip.industrialProcessing;

import ip.industrialProcessing.config.ConfigAchievements;
import ip.industrialProcessing.config.ConfigBlocks;
import ip.industrialProcessing.config.ConfigItems;
import ip.industrialProcessing.items.*;
import ip.industrialProcessing.machines.crusher.BlockCrusher;
import ip.industrialProcessing.machines.crusher.TileEntityCrusher;
import ip.industrialProcessing.machines.filter.BlockFilter;
import ip.industrialProcessing.machines.filter.TileEntityFilter;
import ip.industrialProcessing.machines.magneticSeparator.BlockMagneticSeparator;
import ip.industrialProcessing.machines.magneticSeparator.TileEntityMagneticSeparator;
import ip.industrialProcessing.machines.mixer.BlockMixer;
import ip.industrialProcessing.machines.mixer.TileEntityMixer;
import ip.industrialProcessing.machines.multiblock.MachineFrameState;
import ip.industrialProcessing.machines.multiblock.TileEntityMultiMachineFrame;
import ip.industrialProcessing.machines.multiblock.crusher.BlockLargeCrusher;
import ip.industrialProcessing.machines.multiblock.crusher.TileEntityLargeCrusher;
import ip.industrialProcessing.machines.multiblock.machineFrame.BlockMachineFrame;
import ip.industrialProcessing.machines.multiblock.machineFrame.TileEntityMachineFrame;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.stats.Achievement;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "IndustrialProcessing", name = "Industrial Processing", version = "0.0.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = { "IPTileSync" }, packetHandler = PacketHandler.class)
public class IndustrialProcessing {

	public static final String RESOURCE_PATH = "/assets/industrialprocessing/";
	public static final String TEXTURE_DIRECTORY = RESOURCE_PATH + "textures/";
	public static final String GUI_DIRECTORY = TEXTURE_DIRECTORY + "gui/";
	public static final String BLOCK_TEXTURE_DIRECTORY = TEXTURE_DIRECTORY
			+ "blocks/";
	public static final String ITEM_TEXTURE_DIRECTORY = TEXTURE_DIRECTORY
			+ "items/";
	public static final String MODEL_TEXTURE_DIRECTORY = TEXTURE_DIRECTORY
			+ "models/";
	public static final String TEXTURE_DOMAIN = "industrialprocessing";
	public static final String TEXTURE_NAME_PREFIX = TEXTURE_DOMAIN + ":";

	// The instance of your mod that Forge uses.
	@Instance("IndustrialProcessing")
	public static IndustrialProcessing instance;

	// create creative tab
	public static CreativeTabs tabMachines = new TabMachines(
			CreativeTabs.getNextID(), "industrialprocessing");

	// create worldgen
	public static WorldGeneration worldGen = new WorldGeneration();

	// create items
	public final static ItemIP itemIronLargeChunks = new ItemIP(
			ConfigItems.ItemIronLargeChunksID(), "ItemIronLargeChunks");
	public final static ItemIP itemCopperLargeChunks = new ItemIP(
			ConfigItems.ItemCopperLargeChunksID(), "ItemCopperLargeChunks");
	public final static ItemIP itemTinLargeChunks = new ItemIP(
			ConfigItems.ItemTinLargeChunksID(), "ItemTinLargeChunks");
	public final static ItemIP itemIronSmallChunks = new ItemIP(
			ConfigItems.ItemIronSmallChunksID(), "ItemIronSmallChunks");
	public final static ItemIP itemCopperSmallChunks = new ItemIP(
			ConfigItems.ItemCopperSmallChunksID(), "ItemCopperSmallChunks");
	public final static ItemIP itemTinSmallChunks = new ItemIP(
			ConfigItems.ItemTinSmallChunksID(), "ItemTinSmallChunks");
	public final static ItemIP itemIronCrushedChunks = new ItemIP(
			ConfigItems.ItemIronCrushedChunksID(), "ItemIronCrushedChunks");
	public final static ItemIP itemCopperCrushedChunks = new ItemIP(
			ConfigItems.ItemCopperCrushedChunksID(), "ItemCopperCrushedChunks");
	public final static ItemIP itemTinCrushedChunks = new ItemIP(
			ConfigItems.ItemTinCrushedChunksID(), "ItemTinCrushedChunks");
	public final static ItemIP itemIronWashedChunks = new ItemIP(
			ConfigItems.ItemIronWashedChunksID(), "itemIronWashedChunks");
	public final static ItemIP itemCopperWashedChunks = new ItemIP(
			ConfigItems.ItemCopperWashedChunksID(), "ItemCopperWashedChunks");
	public final static ItemIP itemTinWashedChunks = new ItemIP(
			ConfigItems.ItemTinWashedChunksID(), "ItemTinWashedChunks");
	public final static ItemIP itemIronFineChunks = new ItemIP(
			ConfigItems.ItemIronFineChunksID(), "ItemIronFineChunks");
	public final static ItemIP itemCopperFineChunks = new ItemIP(
			ConfigItems.ItemCopperFineChunksID(), "ItemCopperFineChunks");
	public final static ItemIP itemTinFineChunks = new ItemIP(
			ConfigItems.ItemTinFineChunksID(), "ItemTinFineChunks");
	public final static ItemIP itemIronOxideDust = new ItemIP(
			ConfigItems.ItemIronOxideDustID(), "ItemIronOxideDust");
	public final static ItemIP itemCopperMineral = new ItemIP(
			ConfigItems.ItemCopperMineralID(), "ItemCopperMineral");
	public final static ItemIP itemTinOxideDust = new ItemIP(
			ConfigItems.ItemTinOxideDustID(), "ItemTinOxideDust");
	public final static ItemIP itemCopperPurified = new ItemIP(
			ConfigItems.ItemCopperPurifiedID(), "ItemCopperPurified");
	public final static ItemIP itemSilicium = new ItemIP(
			ConfigItems.ItemSiliciumID(), "ItemSilicium");
	public final static ItemIP itemZincDust = new ItemIP(
			ConfigItems.ItemZincDustID(), "ItemZincDust");
	public final static ItemIP itemTinPurified = new ItemIP(
			ConfigItems.ItemTinPurifiedID(), "ItemTinPurified");
	public final static ItemIP itemSulfur = new ItemIP(
			ConfigItems.ItemSulfurID(), "ItemSulfur");

	// create ores
	public static final Block blockCopperOre = (new BlockOre(
			ConfigBlocks.BlockCopperOreID())).setHardness(2.0F)
			.setResistance(5.0F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("blockCopperOre")
			.func_111022_d(TEXTURE_NAME_PREFIX + "blockCopperOre")
			.setCreativeTab(IndustrialProcessing.tabMachines);;
	public static final Block blockTinOre = (new BlockOre(
			ConfigBlocks.BlockTinOreID())).setHardness(2.0F)
			.setResistance(5.0F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("blockTinOre")
			.func_111022_d(TEXTURE_NAME_PREFIX + "blockTinOre")
			.setCreativeTab(IndustrialProcessing.tabMachines);;

	// create Machines
	public final static BlockCrusher blockCrusher = new BlockCrusher();
	public final static BlockFilter blockFilter = new BlockFilter();
	public final static BlockMagneticSeparator blockMageneticSeparator = new BlockMagneticSeparator();
	public final static BlockMixer blockMixer = new BlockMixer();

	// create Multiblock Machines

	public final static BlockMachineFrame blockMachineFrame = new BlockMachineFrame();
	public final static BlockLargeCrusher blockLargeCrusher = new BlockLargeCrusher();

	// create achivements
	public static AchievementPage achPage = new AchievementPage(
			"Industrial Processing");
	public static Achievement achPlacedFilter = new Achievement(
			ConfigAchievements.PlacedFilterID(), "placedFilter", 0, 0,
			blockFilter, null).registerAchievement();
	public static Achievement achPlacedCrusher = new Achievement(
			ConfigAchievements.PlacedCrusherID(), "placedCrusher", 0, -1,
			blockCrusher, achPlacedFilter).registerAchievement();

	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide = "ip.industrialProcessing.client.ClientProxy", serverSide = "ip.industrialProcessing.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		// Stub Method
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		GameRegistry.registerWorldGenerator(worldGen);

		LanguageRegistry.instance().addStringLocalization(
				"itemGroup.tabMachines", "en_US", "Industrial Processing");

		registerMachine(blockCrusher, "IP.Machine.Crusher", "Ore Crusher",
				TileEntityCrusher.class);
		registerMachine(blockFilter, "IP.Machine.Filter", "Ore Filter",
				TileEntityFilter.class);
		registerMachine(blockMageneticSeparator, "IP.Machine.Separator",
				"Magnetic Separator", TileEntityMagneticSeparator.class);
		registerMachine(blockMixer, "IP.Machine.Mixer", "Mixer",
				TileEntityMixer.class);

		registerMachine(blockMachineFrame, "IP.Machine.Multi.Frame",
				"Machine Frame", TileEntityMachineFrame.class);
		registerMachine(blockLargeCrusher, "IP.Machine.Multi.Crusher",
				"Large Crusher", TileEntityLargeCrusher.class);

		registerOre(blockCopperOre, "IP.World.CopperOre", "Copper Ore",
				"copper");
		registerOre(blockTinOre, "IP.World.TinOre", "Tin Ore", "copper");

		NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());

		// give items a name
		LanguageRegistry.addName(itemIronLargeChunks, "Large iron Chunks");
		LanguageRegistry.addName(itemCopperLargeChunks, "Large copper Chunks");
		LanguageRegistry.addName(itemTinLargeChunks, "Large tin Chunks");
		LanguageRegistry.addName(itemIronSmallChunks, "Small iron Chunks");
		LanguageRegistry.addName(itemCopperSmallChunks, "Small copper Chunks");
		LanguageRegistry.addName(itemTinSmallChunks, "Small tin Chunks");
		LanguageRegistry.addName(itemIronCrushedChunks, "Crushed iron Chunks");
		LanguageRegistry.addName(itemCopperCrushedChunks,
				"Crushed copper Chunks");
		LanguageRegistry.addName(itemTinCrushedChunks, "Crushed tin Chunks");
		LanguageRegistry.addName(itemIronWashedChunks, "Washed iron Chunks");
		LanguageRegistry.addName(itemCopperWashedChunks, "Washed copper Chunks");
		LanguageRegistry.addName(itemTinWashedChunks, "Washed tin Chunks");
		LanguageRegistry.addName(itemIronFineChunks, "Fine iron Chunks");
		LanguageRegistry.addName(itemCopperFineChunks, "Fine copper Chunks");
		LanguageRegistry.addName(itemTinFineChunks, "Fine tin Chunks");
		LanguageRegistry.addName(itemIronOxideDust, "Iron oxide Dust");
		LanguageRegistry.addName(itemCopperMineral, "Copper mineral");
		LanguageRegistry.addName(itemTinOxideDust, "Tin oxide Dust");
		LanguageRegistry.addName(itemSilicium, "Silicium");
		LanguageRegistry.addName(itemZincDust, "zinc Dust");
		LanguageRegistry.addName(itemCopperPurified, "Purified copper");
		LanguageRegistry.addName(itemTinPurified, "Purified tin");
		LanguageRegistry.addName(itemSulfur, "Sulfur");
		
		// register achievements
		achPage.getAchievements().add(achPlacedFilter);
		achPage.getAchievements().add(achPlacedCrusher);
		AchievementPage.registerAchievementPage(achPage);

		// give achievements a name
		LanguageRegistry.instance().addStringLocalization(
				"achievement." + "placedFilter", "en_US", "First filter");
		LanguageRegistry.instance().addStringLocalization(
				"achievement." + "placedFilter" + ".desc", "en_US",
				"Placing your first filter");
		LanguageRegistry.instance().addStringLocalization(
				"achievement." + "placedCrusher", "en_US", "First crusher");
		LanguageRegistry.instance().addStringLocalization(
				"achievement." + "placedCrusher" + ".desc", "en_US",
				"Placing your first crusher");

		proxy.registerRenderers();
	}

	private void registerOre(Block block, String uniqueId, String displayName,
			String oreDictionaryKey) {
		GameRegistry.registerBlock(block, uniqueId);
		MinecraftForge.setBlockHarvestLevel(block, "pickaxe", 1);
		LanguageRegistry.addName(block, displayName);
		OreDictionary.registerOre(oreDictionaryKey, block);
	}

	private void registerMachine(Block block, String uniqueId,
			String displayName, Class tileEntity) {

		GameRegistry.registerBlock(block, uniqueId);
		MinecraftForge.setBlockHarvestLevel(block, "pickaxe", 1);
		LanguageRegistry.addName(block, displayName);
		ModLoader.registerTileEntity(tileEntity, uniqueId);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		// Stub Method
	}
}

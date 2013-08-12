package ip.industrialProcessing;

import ip.industrialProcessing.config.ConfigAchievements;
import ip.industrialProcessing.config.ConfigBlocks;
import ip.industrialProcessing.config.ConfigCreativeTabs;
import ip.industrialProcessing.config.ConfigDamageSource;
import ip.industrialProcessing.config.ConfigFluids;
import ip.industrialProcessing.config.ConfigItems;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.config.ISetupAchievements;
import ip.industrialProcessing.config.ISetupBlocks;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.config.ISetupDamageSource;
import ip.industrialProcessing.config.ISetupFluids;
import ip.industrialProcessing.config.ISetupItems;
import ip.industrialProcessing.config.ISetupMachineBlocks;
import ip.industrialProcessing.fluids.BlockFluid;
import ip.industrialProcessing.fluids.BucketHandler;
import ip.industrialProcessing.fluids.ContainerFluid;
import ip.industrialProcessing.fluids.ItemFluid;
import ip.industrialProcessing.items.*;
import ip.industrialProcessing.machines.classifier.BlockClassifier;
import ip.industrialProcessing.machines.classifier.TileEntityClassifier;
import ip.industrialProcessing.machines.crusher.BlockCrusher;
import ip.industrialProcessing.machines.crusher.TileEntityCrusher;
import ip.industrialProcessing.machines.diskFilter.BlockDiskFilter;
import ip.industrialProcessing.machines.diskFilter.TileEntityDiskFilter;
import ip.industrialProcessing.machines.dryer.BlockDryer;
import ip.industrialProcessing.machines.dryer.TileEntityDryer;
import ip.industrialProcessing.machines.filter.BlockFilter;
import ip.industrialProcessing.machines.filter.TileEntityFilter;
import ip.industrialProcessing.machines.flotationCell.BlockFlotationCell;
import ip.industrialProcessing.machines.flotationCell.TileEntityFlotationCell;
import ip.industrialProcessing.machines.hydroCyclone.BlockHydroCyclone;
import ip.industrialProcessing.machines.hydroCyclone.TileEntityHydroCyclone;
import ip.industrialProcessing.machines.magneticSeparator.BlockMagneticSeparator;
import ip.industrialProcessing.machines.magneticSeparator.TileEntityMagneticSeparator;
import ip.industrialProcessing.machines.mixer.BlockMixer;
import ip.industrialProcessing.machines.mixer.TileEntityMixer;
import ip.industrialProcessing.machines.multiblock.MachineFrameState;
import ip.industrialProcessing.machines.multiblock.TileEntityMultiMachineFrame;
import ip.industrialProcessing.machines.multiblock.crusher.BlockLargeCrusher;
import ip.industrialProcessing.machines.multiblock.crusher.TileEntityLargeCrusher;
import ip.industrialProcessing.machines.multiblock.inventory.BlockMultiMachineInput;
import ip.industrialProcessing.machines.multiblock.inventory.TileEntityMultiMachineInput;
import ip.industrialProcessing.machines.multiblock.machineFrame.BlockMachineFrame;
import ip.industrialProcessing.machines.multiblock.machineFrame.TileEntityMachineFrame;
import ip.industrialProcessing.machines.thickener.BlockThickener;
import ip.industrialProcessing.machines.thickener.TileEntityThickener;
import ip.industrialProcessing.power.buildcraftGenerator.BlockBuildcraftGenerator;
import ip.industrialProcessing.power.buildcraftGenerator.TileEntityBuildcraftGenerator;
import ip.industrialProcessing.power.manualGenerator.BlockManualGenerator;
import ip.industrialProcessing.power.manualGenerator.TileEntityManualGenerator;
import ip.industrialProcessing.power.meters.BlockAmpMeter;
import ip.industrialProcessing.power.meters.BlockVoltMeter;
import ip.industrialProcessing.power.meters.TileEntityAmpMeter;
import ip.industrialProcessing.power.meters.TileEntityVoltMeter;
import ip.industrialProcessing.power.wire.BlockWire;
import ip.industrialProcessing.power.wire.TileEntityWire;
import ip.industrialProcessing.transport.fluids.BlockTransportFluids;
import ip.industrialProcessing.transport.fluids.TileEntityTransportFluids;
import ip.industrialProcessing.utils.DamageSourceIP;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.stats.Achievement;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidContainerRegistry.FluidContainerData;
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
@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = { PacketHandler.ANIMATION_SYNC }, packetHandler = PacketHandler.class)
public class IndustrialProcessing implements ISetupCreativeTabs, INamepace, ISetupMachineBlocks, ISetupItems, ISetupBlocks, ISetupFluids, ISetupAchievements, ISetupDamageSource {
	// The instance of your mod that Forge uses.
	@Instance("IndustrialProcessing")
	public static IndustrialProcessing instance;

	// create namespaces: INamespace
	// create items: ISetupItems
	// create fluids: ISetupFluids
	// create ores: ISetupBlocks
	// create Machines, power, etc: ISetupMachineBlocks
	// create achievements: ISetupAchievements
	// create damagesources: ISetupDamageSource
	// create creative tab: ISetupCreativeTabs

	// create worldgen
	public static WorldGeneration worldGen = new WorldGeneration();

	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide = "ip.industrialProcessing.client.ClientProxy", serverSide = "ip.industrialProcessing.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		// register listeners for events
		MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		// register worldgenerator
		GameRegistry.registerWorldGenerator(worldGen);

		// register machines, power, transport
		ConfigMachineBlocks.getInstance().registerMachineBlocks();

		// register ores
		ConfigBlocks.getInstance().registerOres();

		// register item name's
		ConfigItems.getInstance().addToLanguageRegistry();

		// add death display messages
		ConfigDamageSource.getInstance().addToLanguageRegistry();

		// register achievements
		ConfigAchievements.getInstance().registerAchievments();

		// register fluid
		ConfigFluids.getInstance().registerFluids();

		// register the gui handler
		NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());
		
		// register creative tabs
		ConfigCreativeTabs.getInstance().addToLanguageRegistry();

		// register renders
		proxy.registerRenderers();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		// Stub Method
	}
}

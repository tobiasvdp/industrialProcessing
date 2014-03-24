package mod.industrialProcessing.block;

import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.block.crystals.ModelCrystal;
import mod.industrialProcessing.block.doors.emergency.model.ModelDoorEmergency;
import mod.industrialProcessing.block.platforms.ModelPlatform;
import mod.industrialProcessing.block.platforms.ModelStairs;
import mod.industrialProcessing.plants.decoration.machineBlock.model.ModelMachineBlock;
import mod.industrialProcessing.utils.registry.BlockRegistry;
import mod.industrialProcessing.utils.registry.BlockType;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ConfigBlocks {

	public void registerOres() {
		BlockRegistry.registerOre(ISetupBlocks.blockBauxiteOre, "IP.ore.bauxiteOre","bauxite", 1);
		BlockRegistry.registerOre(ISetupBlocks.blockCopperOre, "IP.ore.copperOre", "copper", 1);
		BlockRegistry.registerOre(ISetupBlocks.blockTinOre, "IP.ore.tinOre", "tin", 1);
		BlockRegistry.registerOre(ISetupBlocks.blockGalenaOre, "IP.ore.galenaOre", "silver", 2);
		BlockRegistry.registerOre(ISetupBlocks.blockRutileOre, "IP.ore.rutileOre", "rutile", 2);
		BlockRegistry.registerOre(ISetupBlocks.blockChromiteOre, "IP.ore.chromiteOre", "chromite", 2);
		BlockRegistry.registerOre(ISetupBlocks.blockCinnebarOre, "IP.ore.cinnebarOre", "cinnebar", 1);
		BlockRegistry.registerOre(ISetupBlocks.blockTaliaOre, "IP.ore.taliaOre", "talia", 3);
	}
	
	public void registerBlocks(){
		BlockRegistry.registerBlock(ISetupBlocks.blockGrit, "IP.block.girt","shovel",0);
		BlockRegistry.registerBlock(ISetupBlocks.blockAsphalt, "IP.block.asphalt","pickaxe",2);
		BlockRegistry.registerBlock(ISetupBlocks.blockCobbleLimestone, "IP.block.cobbleLimestone","pickaxe",0);
		BlockRegistry.registerBlock(ISetupBlocks.blockLimestone, "IP.block.limestone","pickaxe",0);
		BlockRegistry.registerBlock(ISetupBlocks.blockHardSand, "IP.block.hardSand","shovel",0);
		BlockRegistry.registerBlock(ISetupBlocks.blockRutile, "IP.block.rutile", "pickaxe", 2,new ModelCrystal());
		BlockRegistry.registerBlock(ISetupBlocks.blockCinnebar, "IP.block.cinnebar", "pickaxe", 1,new ModelCrystal());
		BlockRegistry.registerBlock(ISetupBlocks.blockStairs, "IP.block.stairs", "pickaxe", 1,new ModelStairs());
		BlockRegistry.registerBlock(ISetupBlocks.blockPlatform, "IP.block.platform", "pickaxe", 1,new ModelPlatform());
		BlockRegistry.registerBlock(ISetupBlocks.blockDoorEmergency, "IP.block.doorEmergency", "pickaxe", 1,new ModelDoorEmergency());
		BlockRegistry.registerMCBlock(ISetupBlocks.blockHalfWavePlate, "IP.block.halfWavePlate", "pickaxe", 1);
		BlockRegistry.registerBlock(ISetupBlocks.blockMachineBlock, "IP.block.machine", "pickaxe", 1,new ModelMachineBlock());
				
		BlockRegistry.registerMetadataBlock(ISetupBlocks.blockLeaves,"IP.block.tree.leaves", "axe",0);
		BlockRegistry.registerMetadataBlock(ISetupBlocks.blockLog, "IP.block.tree.log", "axe",0);
		BlockRegistry.registerBlock(ISetupBlocks.blockRubberLog, "IP.block.tree.log.rubber", "axe",0);
		BlockRegistry.registerBlock(ISetupBlocks.blockPineLog, "IP.block.tree.log.pine", "axe",0);
		BlockRegistry.registerMetadataBlock(ISetupBlocks.blockSapling,"IP.block.tree.sapling", "axe",0);

	}

	private static ConfigBlocks instance = new ConfigBlocks();

	public static ConfigBlocks getInstance() {
		return instance;
	}

}

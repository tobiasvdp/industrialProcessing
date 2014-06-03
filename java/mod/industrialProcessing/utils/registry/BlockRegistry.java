package mod.industrialProcessing.utils.registry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.block.doors.BlockDoor;
import mod.industrialProcessing.block.doors.emergency.model.ModelDoorEmergency;
import mod.industrialProcessing.client.rendering.block.ModelBlock;
import mod.industrialProcessing.client.rendering.tileEntity.ModelTileEntity;
import mod.industrialProcessing.plants.power.motor.electroMotor.BlockElectroMotor;
import mod.industrialProcessing.plants.power.motor.electroMotor.TileEntityElectroMotor;
import mod.industrialProcessing.plants.power.motor.electroMotor.models.ModelElectroMotorBlock;
import mod.industrialProcessing.plants.power.motor.electroMotor.models.ModelElectroMotorTile;
import mod.industrialProcessing.utils.forgeFixes.ItemBlockWithMeta;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockRegistry {
	private static HashMap<Block, BlockType[]> array = new HashMap<Block, BlockType[]>();

	public static void registerOre(Block block, String uniqueId, String oreDictionaryKey, int level) {
		block.setBlockName(uniqueId);
		block.setBlockTextureName(IndustrialProcessing.TEXTURE_NAME_PREFIX + block.getUnlocalizedName());
		block.setCreativeTab(IndustrialProcessing.tabOres);
		block.setHarvestLevel("pickaxe", level);
		GameRegistry.registerBlock(block, uniqueId);
		OreDictionary.registerOre(oreDictionaryKey, block);
		RegisterBlock(block, BlockType.Ore);
	}
	
	public static void registerBlock(Block block, String uniqueId, String harvest, int level, ModelBlock model) {
		registerBlock(block, uniqueId, harvest, level);
		if (Minecraft.getMinecraft() != null)
			RenderRegistry.registerRendering(block, model);
	}

	public static void registerBlock(Block block, String uniqueId, String harvest, int level) {
		block.setBlockName(uniqueId);
		block.setBlockTextureName(IndustrialProcessing.TEXTURE_NAME_PREFIX + block.getUnlocalizedName());
		block.setCreativeTab(IndustrialProcessing.tabBlocks);
		block.setHarvestLevel(harvest, level);
		GameRegistry.registerBlock(block, uniqueId);
		RegisterBlock(block, BlockType.Block);
	}

	public static void registerMCBlock(Block block, String uniqueId, String harvest, int level) {
		block.setBlockName(uniqueId);
		block.setCreativeTab(IndustrialProcessing.tabBlocks);
		block.setHarvestLevel(harvest, level);
		GameRegistry.registerBlock(block, uniqueId);
		RegisterBlock(block, BlockType.Block);
	}

	public static void registerMetadataBlock(Block block, String uniqueId, String harvest, int level) {
		block.setBlockName(uniqueId);
		block.setBlockTextureName(IndustrialProcessing.TEXTURE_NAME_PREFIX + block.getUnlocalizedName());
		block.setHarvestLevel(harvest, level);
		GameRegistry.registerBlock(block, ItemBlockWithMeta.class, uniqueId);
		RegisterBlock(block, BlockType.Block);
	}

	public static void registerFluid(Block block, String uniqueId) {
		block.setBlockName(uniqueId);
		block.setCreativeTab(IndustrialProcessing.tabFluids);
		GameRegistry.registerBlock(block, uniqueId);
		RegisterBlock(block, BlockType.fluid);
	}

	public static void registerMachine(Block block, Class tileEntity, String uniqueId, ModelTileEntity model) {
		registerMachine(block, tileEntity, uniqueId);
		if (Minecraft.getMinecraft() != null)
			RenderRegistry.registerRendering(block, model);
	}
	
	public static void registerMachine(Block block, Class tileEntity, String uniqueId, ModelBlock model) {
		registerMachine(block, tileEntity, uniqueId);
		if (Minecraft.getMinecraft() != null)
			RenderRegistry.registerRendering(block, model);
	}
	
	public static void registerMachine(Block block, Class tileEntity, String uniqueId, ModelBlock modelBL,ModelTileEntity modelTE) {
		registerMachine(block, tileEntity, uniqueId);
		if (Minecraft.getMinecraft() != null){
			RenderRegistry.registerRendering(block, modelBL);
			RenderRegistry.registerRendering(block, modelTE);
		}
		
	}

	public static void registerMachine(Block block, Class tileEntity, String uniqueId) {
		block.setBlockName(uniqueId);
		block.setBlockTextureName(IndustrialProcessing.TEXTURE_NAME_PREFIX + block.getUnlocalizedName());
		block.setCreativeTab(IndustrialProcessing.tabMachines);
		block.setHarvestLevel("pickaxe", 1);

		GameRegistry.registerBlock(block, uniqueId);
		RegisterBlock(block, BlockType.Machine);

		TileEntityRegistry.registerTileEntity(block, tileEntity, uniqueId);

		// TODO if (block instanceof IRecipeBlock)
		// TODO RecipeRegistry.registerMachinesRecipes(((IRecipeBlock)
		// block).getRecipes(), block);
		// TODO if (block instanceof BlockMicroBlock)
		// TODO MicroBlockRegistry.RegisterMicroBlock((BlockMicroBlock) block);
	}

	private static void RegisterBlock(Block block, BlockType[] type) {
		array.put(block, type);
	}

	public static void RegisterBlock(Block block, BlockType type) {
		RegisterBlock(block, new BlockType[] { type });
	}

	public static Iterator<Block> getBlocks() {
		return array.keySet().iterator();
	}

	public static Iterator<Block> getMachines() {
		ArrayList<Block> list = new ArrayList<Block>();
		Iterator<Entry<Block, BlockType[]>> it = array.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Block, BlockType[]> set = it.next();
			if (ContainsTag(set.getValue(), BlockType.Machine))
				list.add(set.getKey());
		}
		return list.iterator();
	}

	private static boolean ContainsTag(BlockType[] value, BlockType machine) {
		for (int i = 0; i < value.length; i++) {
			if (value[i] == machine)
				return true;
		}
		return false;
	}

	public static Block[] getMachinesArray() {
		ArrayList<Block> list = new ArrayList<Block>();
		Iterator<Entry<Block, BlockType[]>> it = array.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Block, BlockType[]> set = it.next();
			if (ContainsTag(set.getValue(), BlockType.Machine))
				list.add(set.getKey());
		}
		Block[] blocks = new Block[list.size()];
		for (int i = 0; i < list.size(); i++) {
			blocks[i] = list.get(i);
		}
		return blocks;
	}

	public static Block[] getBlocksByTagArray(BlockType type) {
		ArrayList<Block> list = new ArrayList<Block>();
		Iterator<Entry<Block, BlockType[]>> it = array.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Block, BlockType[]> set = it.next();
			if (ContainsTag(set.getValue(), type))
				list.add(set.getKey());
		}
		Block[] blocks = new Block[list.size()];
		for (int i = 0; i < list.size(); i++) {
			blocks[i] = list.get(i);
		}
		return blocks;
	}

	public static Iterator<Block> getBlocksByTag(BlockType type) {
		ArrayList<Block> list = new ArrayList<Block>();
		Iterator<Entry<Block, BlockType[]>> it = array.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Block, BlockType[]> set = it.next();
			if (ContainsTag(set.getValue(), type))
				list.add(set.getKey());
		}
		return list.iterator();
	}

	public static Block[] getBlocksByTagArray(BlockType... type) {
		ArrayList<Block> list = new ArrayList<Block>();
		Iterator<Entry<Block, BlockType[]>> it = array.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Block, BlockType[]> set = it.next();
			boolean containsTag = true;
			for (int i = 0; i < type.length; i++) {
				if (!ContainsTag(set.getValue(), type[i]))
					containsTag = false;
			}
			if (containsTag) {
				list.add(set.getKey());
			}
		}
		Block[] blocks = new Block[list.size()];
		for (int i = 0; i < list.size(); i++) {
			blocks[i] = list.get(i);
		}
		return blocks;
	}

	public static Iterator<Block> getBlocksByTag(BlockType... type) {
		ArrayList<Block> list = new ArrayList<Block>();
		Iterator<Entry<Block, BlockType[]>> it = array.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Block, BlockType[]> set = it.next();
			boolean containsTag = true;
			for (int i = 0; i < type.length; i++) {
				if (!ContainsTag(set.getValue(), type[i]))
					containsTag = false;
			}
			if (containsTag) {
				list.add(set.getKey());
			}
		}
		return list.iterator();
	}

}

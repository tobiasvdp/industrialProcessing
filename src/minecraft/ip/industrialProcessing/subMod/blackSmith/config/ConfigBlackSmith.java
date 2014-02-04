package ip.industrialProcessing.subMod.blackSmith.config;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.api.config.ConfigCategories;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ISetupItems;
import ip.industrialProcessing.config.ISetupMachineBlocks;
import ip.industrialProcessing.recipes.VanillaRecipeBridge;
import ip.industrialProcessing.subMod.blackSmith.IPBlackSmith;
import ip.industrialProcessing.subMod.blackSmith.plant.bloomery.TileEntityBloomery;
import ip.industrialProcessing.subMod.blackSmith.plant.bloomery.dummy.bellows.TileEntityBellows;
import ip.industrialProcessing.subMod.blackSmith.plant.bloomery.dummy.ironBowl.TileEntityIronBowl;
import ip.industrialProcessing.utils.registry.BlockType;
import ip.industrialProcessing.utils.registry.RecipeRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ConfigBlackSmith {
	private static ConfigBlackSmith instance = new ConfigBlackSmith();
	public static final int WILDCARD_VALUE = Short.MAX_VALUE;
	public static ConfigBlackSmith getInstance() {
		return instance ;
	}
	
	//items
	private static int ItemWroughtIronID = 6000;
	
	//blocks
	private int bloomeryBlockID = IPBlackSmith.config.get(ConfigCategories.machineOreProcessing.toString(), "bloomeryBlockID", 522).getInt();
	private int rendererBloomery;
	
	private int bellowsBlockID = IPBlackSmith.config.get(ConfigCategories.machineOreProcessing.toString(), "bellowsBlockID", 521).getInt();
	private int rendererBellows;
	
	 private int ironBowlBlockID = IndustrialProcessing.config.get(ConfigCategories.machineOreProcessing.toString(), "ironBowlBlockID", 523).getInt();
	 private int rendererIronBowl;
	public void register(){
		
		//items
		LanguageRegistry.addName(ISetupBlackSmith.itemWroughtIron , "Wrought iron");
		LanguageRegistry.instance().addStringLocalization(ISetupBlackSmith.itemWroughtIron.getUnlocalizedName()+".desc" , "A porous mass of iron. It can be heated again to shape it into an object.");
		
		//machines
		ConfigMachineBlocks.registerMachineBlock(ISetupBlackSmith.blockBloomery, "IP.MBC.Bloom", "Bloomery", TileEntityBloomery.class, BlockType.Machine, BlockType.blackSmith);
		ConfigMachineBlocks.registerMachineBlock(ISetupBlackSmith.blockBellows, "IP.MBD.Bellow", "Bellows", TileEntityBellows.class, BlockType.Machine, BlockType.blackSmith);
		ConfigMachineBlocks.registerMachineBlock(ISetupBlackSmith.blockIronBowl, "IP.MBD.IBowl", "Iron bowl", TileEntityIronBowl.class, BlockType.Machine, BlockType.blackSmith);
		
		//vanilla recipes
		RecipeRegistry.appendVanillaRecipe(VanillaRecipeBridge.getRecipeFromVanilla(GameRegistry.addShapedRecipe(new ItemStack(ISetupBlackSmith.blockBloomery), "xyx", "y y", "xzx", 'x', new ItemStack(Item.brick), 'y', new ItemStack(Block.dirt), 'z', new ItemStack(Block.cobblestone))));
		RecipeRegistry.appendVanillaRecipe(VanillaRecipeBridge.getRecipeFromVanilla(GameRegistry.addShapedRecipe(new ItemStack(ISetupBlackSmith.blockBellows), "xxx", "yyy", "xxx", 'x', new ItemStack(Block.wood, 1, WILDCARD_VALUE), 'y', new ItemStack(Item.leather))));
		RecipeRegistry.appendVanillaRecipe(VanillaRecipeBridge.getRecipeFromVanilla(GameRegistry.addShapedRecipe(new ItemStack(ISetupBlackSmith.blockIronBowl), "   ", "xyx", "   ", 'x', new ItemStack(ISetupItems.itemThickStick), 'y', new ItemStack(ISetupItems.itemIronBowl, 8))));
	}

	public static int getItemWroughtIronID() {
		return getInstance().ItemWroughtIronID;
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
	
}

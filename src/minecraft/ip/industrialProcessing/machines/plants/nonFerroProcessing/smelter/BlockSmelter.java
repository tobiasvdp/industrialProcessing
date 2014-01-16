package ip.industrialProcessing.machines.plants.nonFerroProcessing.smelter;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.IRecipeBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSmelter extends BlockMachineRendered implements IRecipeBlock{

	public BlockSmelter() {
		super(ConfigMachineBlocks.getBlockSmelterID(), Material.iron, 1f, Block.soundMetalFootstep, "BlockSmelter", ISetupCreativeTabs.tabOreProcessing); 
	}

	@Override
	public TileEntity createNewTileEntity(World world) { 
		TileEntitySmelter te = new TileEntitySmelter();
		te.setName(getLocalizedName());
		return te;
	}

	
	@Override
	public int getRenderType() { 
		return ConfigRenderers.getRendererSmelterId();
	}

	@Override
	public RecipesMachine getRecipes() { 
	    return TileEntitySmelter.recipes;
	}

}

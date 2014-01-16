package ip.industrialProcessing.machines.plants.nonFerroProcessing.roaster;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.machines.plants.nonFerroProcessing.quenchTank.TileEntityQuenchTank;
import ip.industrialProcessing.recipes.IRecipeBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockRoaster extends BlockMachineRendered implements IRecipeBlock{

	public BlockRoaster() {
		super(ConfigMachineBlocks.getBlockRoasterID(), Material.iron, 1f, Block.soundMetalFootstep, "BlockRoaster", ISetupCreativeTabs.tabOreProcessing); 
	}

	@Override
	public TileEntity createNewTileEntity(World world) { 
		TileEntityRoaster te = new TileEntityRoaster();
		te.setName(getLocalizedName());
		return te;
	}

	
	@Override
	public int getRenderType() { 
		return ConfigRenderers.getRendererRoasterId();
	}

	@Override
	public RecipesMachine getRecipes() { 
	    return TileEntityQuenchTank.recipes;
	}
}

package ip.industrialProcessing.machines.plants.metalProcessing.turretLathe;

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

public class BlockTurretLathe   extends BlockMachineRendered implements IRecipeBlock {

	public BlockTurretLathe() {
		super(ConfigMachineBlocks.getBlockTurretLatheID(), Material.iron, 1f, Block.soundMetalFootstep, "TurretLathe", ISetupCreativeTabs.tabOreProcessing); 
	}

	@Override
	public TileEntity createNewTileEntity(World world) { 
		TileEntityTurretLathe te = new TileEntityTurretLathe();
		te.setName(getLocalizedName());
		return te;
	}

	
	@Override
	public int getRenderType() { 
		return ConfigRenderers.getRendererTurretLatheId();
	}

	@Override
	public RecipesMachine getRecipes() { 
	    return TileEntityTurretLathe.recipes;
	}

}

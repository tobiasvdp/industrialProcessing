package ip.industrialProcessing.machines.dryer;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.IRecipeBlock;

public class BlockDryer extends BlockMachineRendered implements IRecipeBlock{

	public BlockDryer() {
		super(ConfigMachineBlocks.getDryerBlockID(), Material.iron, 1f, Block.soundMetalFootstep, "Dryer", IndustrialProcessing.tabOreProcessing); 
	}

	@Override
	public TileEntity createNewTileEntity(World world) { 
		TileEntityDryer te = new TileEntityDryer();
		te.setName(getLocalizedName());
		return te;
	}

	
	@Override
	public int getRenderType() { 
		return ConfigRenderers.getRendererDryerId();
	}

	@Override
	public RecipesMachine getRecipes() { 
	    return TileEntityDryer.recipes;
	}
}

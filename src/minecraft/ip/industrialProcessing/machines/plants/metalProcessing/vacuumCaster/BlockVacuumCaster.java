package ip.industrialProcessing.machines.plants.metalProcessing.vacuumCaster;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.machines.dryer.TileEntityDryer;
import ip.industrialProcessing.recipes.IRecipeBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockVacuumCaster  extends BlockMachineRendered implements IRecipeBlock {

	public BlockVacuumCaster() {
		super(ConfigMachineBlocks.getBlockVacuumCasterID(), Material.iron, 1f, Block.soundMetalFootstep, "VacuumCaster", IndustrialProcessing.tabOreProcessing); 
	}

	@Override
	public TileEntity createNewTileEntity(World world) { 
		TileEntityVacuumCaster te = new TileEntityVacuumCaster();
		te.setName(getLocalizedName());
		return te;
	}

	
	@Override
	public int getRenderType() { 
		return ConfigRenderers.getRendererVacuumCasterId();
	}

	@Override
	public RecipesMachine getRecipes() { 
	    return TileEntityVacuumCaster.recipes;
	}

}

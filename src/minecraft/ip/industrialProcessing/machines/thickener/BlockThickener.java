package ip.industrialProcessing.machines.thickener;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.IRecipeBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockThickener extends BlockMachineRendered implements IRecipeBlock {

	public BlockThickener() {
		super(ConfigMachineBlocks.getThickenerBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Thickener", IndustrialProcessing.tabOreProcessing);

	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		TileEntityThickener te = new TileEntityThickener();
		te.setName(getLocalizedName());
		return te;
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererThickenerId();
	}

	@Override
	public RecipesMachine getRecipes() { 
	    return TileEntityThickener.recipes;
	}
}

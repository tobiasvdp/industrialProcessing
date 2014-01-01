package ip.industrialProcessing.machines.hydroCyclone;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.IRecipeBlock;

public class BlockHydroCyclone extends BlockMachine implements IRecipeBlock {

	public BlockHydroCyclone() {
		super(ConfigMachineBlocks.getHydroCycloneBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Hydro Cyclone Separator", IndustrialProcessing.tabOreProcessing);

	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		TileEntityHydroCyclone te = new TileEntityHydroCyclone();
		te.setName(getLocalizedName());
		return te;
	}

	@Override
	public RecipesMachine getRecipes() { 
	    return TileEntityHydroCyclone.recipes;
	}

}

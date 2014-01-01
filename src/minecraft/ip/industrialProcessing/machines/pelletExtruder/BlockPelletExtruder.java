package ip.industrialProcessing.machines.pelletExtruder;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.IRecipeBlock;

public class BlockPelletExtruder extends BlockMachine implements IRecipeBlock{

	public BlockPelletExtruder() {
		super(ConfigMachineBlocks.getPelletExtruderID(), Material.iron, 1F, Block.soundMetalFootstep, "Pellet Extruder", IndustrialProcessing.tabOreProcessing);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		TileEntityPelletExtruder te = new TileEntityPelletExtruder();
		te.setName(getLocalizedName());
		return te;
	}

	@Override
	public RecipesMachine getRecipes() { 
	    return TileEntityPelletExtruder.recipes;
	}

}

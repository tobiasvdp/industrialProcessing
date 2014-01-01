package ip.industrialProcessing.machines.plants.metalProcessing.extruder;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.machines.dryer.TileEntityDryer;
import ip.industrialProcessing.machines.pelletExtruder.TileEntityPelletExtruder;
import ip.industrialProcessing.recipes.IRecipeBlock;

public class BlockExtruder extends BlockMachineRendered implements IRecipeBlock {

	public BlockExtruder() {
		super(ConfigMachineBlocks.getExtruderID(), Material.iron, 1f, Block.soundMetalFootstep, "Extruder", IndustrialProcessing.tabOreProcessing);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		TileEntityExtruder te = new TileEntityExtruder();
		te.setName(getLocalizedName());
		return te;
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererExtruderId();
	}

	@Override
	public RecipesMachine getRecipes() { 
	    return TileEntityExtruder.recipes;
	}

}

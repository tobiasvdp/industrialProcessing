package ip.industrialProcessing.machines.classifier;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigBlocks;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.IRecipeBlock;

public class BlockClassifier extends BlockMachineRendered implements IRecipeBlock {

	public BlockClassifier() {
		super(ConfigMachineBlocks.getClassifierBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Spiral Classifier", IndustrialProcessing.tabOreProcessing);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityClassifier();
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererClassifierId();
	}

	@Override
	public RecipesMachine getRecipes() { 
	    return TileEntityClassifier.recipes;
	}
}

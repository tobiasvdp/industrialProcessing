package ip.industrialProcessing.machines.electrolyser;

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

public class BlockElectrolyser extends BlockMachineRendered implements IRecipeBlock {

	public BlockElectrolyser() {
		super(ConfigMachineBlocks.getElectrolyserBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Electrolyser", ISetupCreativeTabs.tabOreProcessing);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		TileEntityElectrolyser te = new TileEntityElectrolyser();
		te.setName(getLocalizedName());
		return te;
	}
	
    @Override
    public int getRenderType()
    {
        return ConfigRenderers.getRendererElectrolyserId();
    }

    @Override
    public RecipesMachine getRecipes() { 
	return TileEntityElectrolyser.recipes;
    }
}

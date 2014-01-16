package ip.industrialProcessing.machines.plants.nonFerroProcessing.magneticSeparator;

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

public class BlockMagneticSeparator extends BlockMachineRendered implements IRecipeBlock {

    public BlockMagneticSeparator() {
	super(ConfigMachineBlocks.getMagneticSeparatorBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Magnetic Ore Separator", ISetupCreativeTabs.tabOreProcessing);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	TileEntityMagneticSeparator te = new TileEntityMagneticSeparator();
	te.setName(getLocalizedName());
	return te;
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererMagneticSeperatorId();
    }

    @Override
    public RecipesMachine getRecipes() {
	return TileEntityMagneticSeparator.recipes;
    }
}

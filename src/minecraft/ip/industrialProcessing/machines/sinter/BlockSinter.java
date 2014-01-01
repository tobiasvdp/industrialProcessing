package ip.industrialProcessing.machines.sinter;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.machines.crusher.TileEntityCrusher;
import ip.industrialProcessing.recipes.IRecipeBlock;

public class BlockSinter extends BlockMachineRendered implements IRecipeBlock {
    public BlockSinter() {
	super(ConfigMachineBlocks.getSinterBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Sinter", IndustrialProcessing.tabOreProcessing);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	TileEntitySinter te = new TileEntitySinter();
	te.setName(this.getLocalizedName());
	return te;
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererSinterId();
    }

    @Override
    public RecipesMachine getRecipes() {
	return TileEntitySinter.recipes;
    }
}

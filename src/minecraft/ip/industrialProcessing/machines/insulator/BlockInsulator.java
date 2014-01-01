package ip.industrialProcessing.machines.insulator;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.machines.mixer.TileEntityMixer;
import ip.industrialProcessing.recipes.IRecipeBlock;

public class BlockInsulator extends BlockMachineRendered implements IRecipeBlock {
    public BlockInsulator() {
	super(ConfigMachineBlocks.getInsulatorBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Insulator", IndustrialProcessing.tabOreProcessing);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	TileEntityInsulator te = new TileEntityInsulator();
	te.setName(getLocalizedName());
	return te;
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererInsulatorID();
    }

    @Override
    public RecipesMachine getRecipes() {
	return TileEntityInsulator.recipes;
    }
}

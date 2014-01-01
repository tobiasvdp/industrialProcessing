package ip.industrialProcessing.machines.plants.waste.waterTreatment.tricklingFilter;

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

public class BlockTricklingFilter extends BlockMachineRendered implements IRecipeBlock {
    public BlockTricklingFilter() {
	super(ConfigMachineBlocks.getTricklingFilterID(), Material.iron, 1F, Block.soundMetalFootstep, "TricklingFilter", IndustrialProcessing.tabOreProcessing);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	TileEntityTricklingFilter te = new TileEntityTricklingFilter();
	te.setName(getLocalizedName());
	return te;
    }

    @Override
    public int getRenderType() {
	return 0;
    }

    @Override
    public RecipesMachine getRecipes() {
	return TileEntityTricklingFilter.recipes;
    }
}

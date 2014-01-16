package ip.industrialProcessing.machines.plants.waste.waterTreatment.incubator;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.machines.mixer.TileEntityMixer;
import ip.industrialProcessing.recipes.IRecipeBlock;

public class BlockIncubator extends BlockMachineRendered implements IRecipeBlock {
    public BlockIncubator() {
	super(ConfigMachineBlocks.getIncubatorID(), Material.iron, 1F, Block.soundMetalFootstep, "Incubator", ISetupCreativeTabs.tabOreProcessing);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	TileEntityIncubator te = new TileEntityIncubator();
	te.setName(getLocalizedName());
	return te;
    }

    @Override
    public int getRenderType() {
	return 0;
    }

    @Override
    public RecipesMachine getRecipes() {
	return TileEntityMixer.recipes;
    }
}

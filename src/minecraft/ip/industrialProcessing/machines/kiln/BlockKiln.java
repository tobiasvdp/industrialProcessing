package ip.industrialProcessing.machines.kiln;

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

public class BlockKiln  extends BlockMachineRendered implements IRecipeBlock {

    public BlockKiln() {
        super(ConfigMachineBlocks.getKilnBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Kiln", ISetupCreativeTabs.tabOreProcessing);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        TileEntityKiln te = new TileEntityKiln();
        te.setName(this.getLocalizedName());
        return te;
    }

    @Override
    public int getRenderType() {
        return ConfigRenderers.getRendererKilnId();
    }

    @Override
    public RecipesMachine getRecipes() { 
	return TileEntityKiln.recipes;
    }

}

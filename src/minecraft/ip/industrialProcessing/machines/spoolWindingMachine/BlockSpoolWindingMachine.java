package ip.industrialProcessing.machines.spoolWindingMachine;

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

public class BlockSpoolWindingMachine extends BlockMachineRendered implements IRecipeBlock {
    public BlockSpoolWindingMachine() {
	super(ConfigMachineBlocks.getSpoolWindingMachineBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "SpoolWindingMachine", IndustrialProcessing.tabOreProcessing);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	TileEntitySpoolWindingMachine te = new TileEntitySpoolWindingMachine();
	te.setName(getLocalizedName());
	return te;
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererSpoolWindingMachineID();
    }

    @Override
    public RecipesMachine getRecipes() {
	return TileEntitySpoolWindingMachine.recipes;
    }
}

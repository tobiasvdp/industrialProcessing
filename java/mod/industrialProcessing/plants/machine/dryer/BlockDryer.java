package ip.industrialProcessing.machines.dryer;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.gui3.framework.rendering.TextureReference;
import ip.industrialProcessing.gui3.generating.GuiBuilderDefault;
import ip.industrialProcessing.gui3.generating.IGuiBlock;
import ip.industrialProcessing.gui3.generating.IGuiBuilder;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.IRecipeBlock;
import ip.industrialProcessing.utils.IDescriptionBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockDryer extends BlockMachineRendered implements IRecipeBlock, IDescriptionBlock, IGuiBlock {

    private static final TextureReference WORKER_TEXTURE = TextureReference.createDefault("Dryer.png", 20, 32);
    public static IGuiBuilder guiBuilder = new GuiBuilderDefault("Dryer").addInputTank(0, 1, 2).addOutputTank(1, 3, 4).enablePower(1).addOutputSlot(0).enableWorker(WORKER_TEXTURE);

    public BlockDryer() {
	super(ConfigMachineBlocks.getDryerBlockID(), Material.iron, 1f, Block.soundMetalFootstep, "Dryer", ISetupCreativeTabs.tabOreProcessing);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	TileEntityDryer te = new TileEntityDryer();
	te.setName(getLocalizedName());
	return te;
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererDryerId();
    }

    @Override
    public RecipesMachine getRecipes() {
	return TileEntityDryer.recipes;
    }

    @Override
    public IGuiBuilder getGui() {
	return guiBuilder;
    }

    @Override
    public String getDescription() {
	return "Dries the sludge to purified chunks.";
    }
}

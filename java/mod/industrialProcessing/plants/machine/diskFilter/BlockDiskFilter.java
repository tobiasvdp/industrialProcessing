package ip.industrialProcessing.machines.diskFilter;

import mod.industrialProcessing.blockContainer.BlockContainerIPRendered;
import mod.industrialProcessing.gui.framework.rendering.TextureReference;
import mod.industrialProcessing.gui.generating.GuiBuilderDefault;
import mod.industrialProcessing.gui.generating.IGuiBuilder;
import mod.industrialProcessing.utils.block.IDescriptionBlock;
import mod.industrialProcessing.utils.block.IGuiBlock;
import mod.industrialProcessing.utils.block.IRecipeBlock;
import mod.industrialProcessing.work.recipe.RecipesMachine;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockDiskFilter extends BlockContainerIPRendered implements IRecipeBlock, IDescriptionBlock, IGuiBlock {

    private static final TextureReference WORKER_TEXTURE = TextureReference.createDefault("Disk Filter.png", 16, 32);
    public static IGuiBuilder guiBuilder = new GuiBuilderDefault("Disk Filter").addInputTank(0, 1, 2).addInputTank(1, 3, 4).addOutputTank(2, 5, 6).addOutputSlot(0).enableWorker(WORKER_TEXTURE).enablePower(7);

    public BlockDiskFilter() {
	super(1.0f,1.0f, Material.iron, Block.soundTypeMetal, "powerFeatures","tankSide","conveyorHopperFeatures","tankFeatures","DiskFilterRings");
    }


    @Override
    public RecipesMachine getRecipes() {
	return TileEntityDiskFilter.recipes;
    }

    @Override
    public IGuiBuilder getGui() {
	return guiBuilder;
    }

    @Override
    public String getDescription() {
	return "Filters the usable particles from a slurry by sending it through rotating disks.";
    }

}

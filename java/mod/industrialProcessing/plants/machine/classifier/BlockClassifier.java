package mod.industrialProcessing.plants.machine.classifier;

import javax.swing.Icon;

import mod.industrialProcessing.blockContainer.BlockContainerIPRendered;
import mod.industrialProcessing.gui.framework.rendering.TextureReference;
import mod.industrialProcessing.gui.generating.GuiBuilderDefault;
import mod.industrialProcessing.gui.generating.IGuiBuilder;
import mod.industrialProcessing.utils.block.IDescriptionBlock;
import mod.industrialProcessing.utils.block.IGuiBlock;
import mod.industrialProcessing.utils.block.IRecipeBlock;
import mod.industrialProcessing.work.recipe.IMachineRecipes;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockClassifier extends BlockContainerIPRendered implements IRecipeBlock, IDescriptionBlock, IGuiBlock {
    private static final TextureReference WORKER_TEXTURE = TextureReference.createDefault("Classifier.png", 24, 32);
    private Icon[] icons = new Icon[4];
    public static IGuiBuilder guiBuilder = new GuiBuilderDefault("Spiral Classifier").addInputSlot(0).addOutputSlot(1).addInputTank(0, 2, 3).addOutputTank(1, 4, 5).enableWorker(WORKER_TEXTURE).enablePower(6);

    public BlockClassifier() {
	super(1.0f,1.0f, Material.iron, Block.soundTypeMetal, "conveyorHopperFeatures","tankSide","powerFeatures","tankFeatures");
    }

    @Override
    public IMachineRecipes getRecipes() {
	return TileEntityClassifier.recipes;
    }

    @Override
    public IGuiBuilder getGui() {
	return guiBuilder;
    }

    @Override
    public String getDescription() {
	return "Separate some solid components from a slurry, based upon a combination of the solid particle density.d";
    }
}

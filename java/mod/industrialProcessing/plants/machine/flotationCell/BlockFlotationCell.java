package mod.industrialProcessing.plants.machine.flotationCell;

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

public class BlockFlotationCell extends BlockContainerIPRendered implements IRecipeBlock, IDescriptionBlock, IGuiBlock {

	private static final TextureReference WORKER_TEXTURE = TextureReference.createDefault("Flotation Cell.png", 22, 32);
	public static IGuiBuilder guiBuilder = new GuiBuilderDefault("Flotation Cell").enableWorker(WORKER_TEXTURE).addInputTank(0, 0, 1).addOutputTank(1, 2, 3).addOutputTank(2, 4, 5);

	public BlockFlotationCell() {
		super(1.0f, 1.0f, Material.iron, Block.soundTypeMetal, "tankFeatures", "tankSide");
	}

	@Override
	public RecipesMachine getRecipes() {
		return TileEntityFlotationCell.recipes;
	}

	@Override
	public IGuiBuilder getGui() {
		return guiBuilder;
	}

	@Override
	public String getDescription() {
		return "Froth flotation is a process for selectively separating hydrophobic materials from hydrophilic.";
	}

}

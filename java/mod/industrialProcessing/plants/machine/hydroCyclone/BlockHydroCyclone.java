package mod.industrialProcessing.plants.machine.hydroCyclone;

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

public class BlockHydroCyclone extends BlockContainerIPRendered implements IRecipeBlock, IDescriptionBlock, IGuiBlock {

	private static final TextureReference WORKER_TEXTURE = TextureReference.createDefault("Hydro Cyclone Separator.png", 18, 24);

	public static IGuiBuilder guiBuilder = new GuiBuilderDefault("Hydro Cyclone Separator").addInputTank(0, 0, 1).addOutputTank(1, 2, 3).addOutputTank(2, 4, 5).enablePower(6).enableWorker(WORKER_TEXTURE);

	public BlockHydroCyclone() {
		super(1.0f, 1.0f, Material.iron, Block.soundTypeMetal, "tankFeatures", "tankSide", "powerFeatures");
	}

	@Override
	public RecipesMachine getRecipes() {
		return TileEntityHydroCyclone.recipes;
	}

	@Override
	public IGuiBuilder getGui() {
		return guiBuilder;
	}

	@Override
	public String getDescription() {
		return "Separate particles in a liquid suspension based on the ratio of their centripetal force to fluid resistance.";
	}

}

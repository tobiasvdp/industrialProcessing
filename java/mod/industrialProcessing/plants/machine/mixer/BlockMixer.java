package mod.industrialProcessing.plants.machine.mixer;

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

public class BlockMixer extends BlockContainerIPRendered implements IRecipeBlock, IDescriptionBlock, IGuiBlock {

	private static final TextureReference WORKER_TEXTURE = TextureReference.createDefault("Mixer.png", 16, 36);
	public static IGuiBuilder guiBuilder = new GuiBuilderDefault("Mixer").addInputSlot(0).addInputTank(0, 1, 2).addOutputTank(1, 3, 4).enablePower(5).enableWorker(WORKER_TEXTURE);

	public BlockMixer() {
		super(1.0f, 1.0f, Material.iron, Block.soundTypeMetal);
	}

	@Override
	public RecipesMachine getRecipes() {
		return TileEntityMixer.recipes;
	}

	@Override
	public IGuiBuilder getGui() {
		return guiBuilder;
	}

	@Override
	public String getDescription() {
		return "Mixes liquids and solids together to form a slurry.";
	}

}

package mod.industrialProcessing.plants.machine.thickener;

import javax.swing.Icon;

import mod.industrialProcessing.blockContainer.BlockContainerIPRendered;
import mod.industrialProcessing.gui.generating.GuiBuilderDefault;
import mod.industrialProcessing.gui.generating.IGuiBuilder;
import mod.industrialProcessing.utils.block.IDescriptionBlock;
import mod.industrialProcessing.utils.block.IGuiBlock;
import mod.industrialProcessing.utils.block.IRecipeBlock;
import mod.industrialProcessing.work.recipe.RecipesMachine;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockThickener extends BlockContainerIPRendered implements IRecipeBlock, IDescriptionBlock, IGuiBlock {

	public static String UNLOCALIZED_NAME = "IP.Machine.Thickener";
	public static IGuiBuilder guiBuilder = new GuiBuilderDefault(UNLOCALIZED_NAME).addInputTank(0, 0, 1).addOutputTank(1, 2, 3).addOutputTank(2, 4, 5).enableWorker().enablePower(6);

	public BlockThickener() {

		super(1.0f, 1.0f, Material.iron, Block.soundTypeMetal, "tankFeatures", "tankSide", "powerFeatures");
	}

	@Override
	public RecipesMachine getRecipes() {
		return TileEntityThickener.recipes;
	}

	@Override
	public IGuiBuilder getGui() {
		return guiBuilder;
	}

	@Override
	public String getDescription() {
		return "Thickens or something";
	}
}

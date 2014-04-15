package mod.industrialProcessing.plants.machine.filter;

import javax.swing.Icon;

import mod.industrialProcessing.blockContainer.BlockContainerIPRendered;
import mod.industrialProcessing.gui.framework.rendering.TextureReference;
import mod.industrialProcessing.gui.generating.GuiBuilderDefault;
import mod.industrialProcessing.gui.generating.IGuiBuilder;
import mod.industrialProcessing.utils.block.IDescriptionBlock;
import mod.industrialProcessing.utils.block.IGuiBlock;
import mod.industrialProcessing.utils.block.IRecipeBlock;
import mod.industrialProcessing.utils.creativeTab.ISetupCreativeTabs;
import mod.industrialProcessing.work.recipe.RecipesMachine;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockFilter extends BlockContainerIPRendered implements IRecipeBlock, IDescriptionBlock, IGuiBlock {

    private static final TextureReference WORKER_TEXTURE = TextureReference.createDefault("Filter.png", 24, 34);

    private Icon[] textures;

    public static IGuiBuilder guiBuilder = new GuiBuilderDefault("Ore Filter").addInputSlot(0).addOutputSlot(1).addOutputSlot(2).enableWorker(WORKER_TEXTURE).enablePower(3);

    public BlockFilter() {
	super(1.0f,1.0f, Material.iron, Block.soundTypeMetal);
    }

    @Override
    public RecipesMachine getRecipes() {
    	return TileEntityFilter.recipes;
    }

    @Override
    public IGuiBuilder getGui() {
	return guiBuilder;
    }

    @Override
    public String getDescription() {
	return "This machine seperates small and larger chunks from materials.";
    }
}

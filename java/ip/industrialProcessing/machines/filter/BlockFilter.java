package ip.industrialProcessing.machines.filter;

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

import javax.swing.Icon;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockFilter extends BlockMachineRendered implements IRecipeBlock, IDescriptionBlock, IGuiBlock {

    private static final TextureReference WORKER_TEXTURE = TextureReference.createDefault("Filter.png", 24, 34);

    private Icon[] textures;

    public static IGuiBuilder guiBuilder = new GuiBuilderDefault("Ore Filter").addInputSlot(0).addOutputSlot(1).addOutputSlot(2).enableWorker(WORKER_TEXTURE).enablePower(3);

    public BlockFilter() {
	super(ConfigMachineBlocks.getFilterBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Ore Filter", ISetupCreativeTabs.tabOreProcessing);
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererFilterId();
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	TileEntityFilter te = new TileEntityFilter();
	te.setName(getLocalizedName());
	return te;
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

package ip.industrialProcessing.machines.flotationCell;

import ip.industrialProcessing.api.config.INamepace;
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

public class BlockFlotationCell extends BlockMachineRendered implements IRecipeBlock, IDescriptionBlock, IGuiBlock {

    private static final TextureReference WORKER_TEXTURE = TextureReference.createDefault("Flotation Cell.png", 22, 32);
    public static IGuiBuilder guiBuilder = new GuiBuilderDefault("Flotation Cell").enableWorker(WORKER_TEXTURE).addInputTank(0, 0, 1).addOutputTank(1, 2, 3).addOutputTank(2, 4, 5);
    private Icon[] icons = new Icon[2];

    public BlockFlotationCell() {
	super(ConfigMachineBlocks.getFlotationCellBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Flotation Cell", ISetupCreativeTabs.tabOreProcessing);

    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	TileEntityFlotationCell te = new TileEntityFlotationCell();
	te.setName(getLocalizedName());
	return te;
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererFlotationCellId();
    }

    @Override
    public Icon getIcon(int par1, int par2) {
	par1 %= icons.length;
	return icons[par1];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
	this.icons[1] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "tankSide");
	this.icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "tankFeatures");
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

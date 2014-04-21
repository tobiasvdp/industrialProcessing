package ip.industrialProcessing.machines.thickener;

import ip.industrialProcessing.api.config.INamepace;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
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

public class BlockThickener extends BlockMachineRendered implements IRecipeBlock, IDescriptionBlock, IGuiBlock {
    private Icon[] icons = new Icon[3];
    public static String UNLOCALIZED_NAME = "IP.Machine.Thickener";
    public static IGuiBuilder guiBuilder = new GuiBuilderDefault(UNLOCALIZED_NAME).addInputTank(0, 0, 1).addOutputTank(1, 2, 3).addOutputTank(2, 4, 5).enableWorker().enablePower(6);

    public BlockThickener() {
	super(ConfigMachineBlocks.getThickenerBlockID(), Material.iron, 1F, Block.soundMetalFootstep, UNLOCALIZED_NAME, ISetupCreativeTabs.tabOreProcessing);

    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	TileEntityThickener te = new TileEntityThickener();
	te.setName(getLocalizedName());
	return te;
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererThickenerId();
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
	this.icons[2] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "powerFeatures");
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

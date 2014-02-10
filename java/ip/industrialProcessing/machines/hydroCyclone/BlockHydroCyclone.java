package ip.industrialProcessing.machines.hydroCyclone;

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

public class BlockHydroCyclone extends BlockMachineRendered implements IRecipeBlock, IDescriptionBlock, IGuiBlock {

    private static final TextureReference WORKER_TEXTURE = TextureReference.createDefault("Hydro Cyclone Separator.png", 18, 24);
    private Icon[] icons = new Icon[3];
    public static IGuiBuilder guiBuilder = new GuiBuilderDefault("Hydro Cyclone Separator").addInputTank(0, 0, 1).addOutputTank(1, 2, 3).addOutputTank(2, 4, 5).enablePower(6).enableWorker(WORKER_TEXTURE);

    public BlockHydroCyclone() {
	super(ConfigMachineBlocks.getHydroCycloneBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Hydro Cyclone Separator", ISetupCreativeTabs.tabOreProcessing);

    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	TileEntityHydroCyclone te = new TileEntityHydroCyclone();
	te.setName(getLocalizedName());
	return te;
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererHydroCycloneId();
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

package ip.industrialProcessing.machines.diskFilter;

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

public class BlockDiskFilter extends BlockMachineRendered implements IRecipeBlock, IDescriptionBlock, IGuiBlock {

    private static final TextureReference WORKER_TEXTURE = TextureReference.createDefault("Disk Filter.png", 16, 32);

    public static IGuiBuilder guiBuilder = new GuiBuilderDefault("Disk Filter").addInputTank(0, 1, 2).addInputTank(1, 3, 4).addOutputTank(2, 5, 6).addOutputSlot(0).enableWorker(WORKER_TEXTURE).enablePower(7);

    Icon[] icons = new Icon[5];

    public BlockDiskFilter() {
	super(ConfigMachineBlocks.getDiskFilterBlockID(), Material.iron, 1f, Block.soundMetalFootstep, "Disk Filter", ISetupCreativeTabs.tabOreProcessing);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	TileEntityDiskFilter te = new TileEntityDiskFilter();
	te.setName(getLocalizedName());
	return te;
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererDiskFilterId();
    }

    @Override
    public Icon getIcon(int par1, int par2) {
	return icons[par1 % icons.length];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
	icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "powerFeatures");
	icons[1] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "tankSide");
	icons[2] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "conveyorHopperFeatures");
	icons[3] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "tankFeatures");
	icons[4] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "DiskFilterRings");
    }

    @Override
    public RecipesMachine getRecipes() {
	return TileEntityDiskFilter.recipes;
    }

    @Override
    public IGuiBuilder getGui() {
	return guiBuilder;
    }

    @Override
    public String getDescription() {
	return "Filters the usable particles from a slurry by sending it through rotating disks.";
    }

}

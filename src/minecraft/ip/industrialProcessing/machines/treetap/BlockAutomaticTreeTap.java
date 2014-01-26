package ip.industrialProcessing.machines.treetap;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.gui.GuiLayout;
import ip.industrialProcessing.gui.IGuiLayout;
import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.utils.IDescriptionBlock;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockAutomaticTreeTap extends BlockManualTreeTap implements IDescriptionBlock, IGuiLayout {

    private static GuiLayout guiLayout;
    static {
	guiLayout = new GuiLayout();
	guiLayout.addLayoutPanel(GuiLayoutPanelType.simpleTankOutput); 
    }
    private Icon tapIcon;
    private Icon tankIcon;

    public BlockAutomaticTreeTap() {
	super(ConfigMachineBlocks.getAutomaticTreeTapBlockID(), Material.iron, 1.0f, soundMetalFootstep, "Automatic Tree Tap", ISetupCreativeTabs.tabOreProcessing);
	func_111022_d(INamepace.TEXTURE_NAME_PREFIX + "automaticTreeTap");
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	TileEntityAutomaticTreeTap te = new TileEntityAutomaticTreeTap();
	te.setName(getLocalizedName());
	return te;
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess par1iBlockAccess, int par2, int par3, int par4) {
	setBlockBounds(0, 0, 0, 1, 1, 1);
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererAutomaticTreeTapID();
    }

    @Override
    public Icon getIcon(int par1, int par2) {
	if (par1 == 1)
	    return tankIcon;
	return tapIcon;
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
	this.tankIcon = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "tankSide");
	this.tapIcon = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "automaticTreeTap");
    }

    @Override
    public GuiLayout getGuiLayout() {
	return guiLayout;
    }

    @Override
    public String getDescription() {
	return "Collects secretion fluids from trees";
    }

}

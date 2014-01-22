package ip.industrialProcessing.power.plants;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.gui.GuiLayout;
import ip.industrialProcessing.gui.IGuiLayout;
import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayoutType;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.utils.IDescriptionBlock;

public class BlockBoiler extends BlockMachineRendered implements IGuiLayout, IDescriptionBlock {

    private Icon[] icons = new Icon[3];
    private static GuiLayout guiLayout;
    static {
	guiLayout = new GuiLayout();
	guiLayout.addLayoutPanel(GuiLayoutPanelType.tankInput);
	guiLayout.addLayoutPanel(GuiLayoutPanelType.simpleTankOutput);
	guiLayout.addLayoutPanel(GuiLayoutPanelType.simpleHeat);
    }

    public BlockBoiler() {
	super(ConfigMachineBlocks.getBoilerBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Steam Boiler", ISetupCreativeTabs.tabPower);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	return new TileEntityBoiler();
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererBoilerId();
    }

    @Override
    public Icon getIcon(int par1, int par2) {
	par1 %= icons.length;
	return icons[par1];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
	icons[1] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "tankSide");
	icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "tankFeatures");
	icons[2] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "burnerGrill");
    }

    @Override
    public String getDescription() {
	return "Boils water to steam.";
    }

    @Override
    public GuiLayout getGuiLayout() {
	return guiLayout;
    }
}

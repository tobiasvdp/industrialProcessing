package ip.industrialProcessing.power.storage;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.gui.GuiLayout;
import ip.industrialProcessing.gui.IGuiLayout;
import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayoutType;
import ip.industrialProcessing.power.BlockPowerGenerator;
import ip.industrialProcessing.utils.IDescriptionBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockEnergyCell extends BlockPowerGenerator implements IDescriptionBlock, IGuiLayout {

    private static GuiLayout guiLayout;
    static {
        guiLayout = new GuiLayout();
        guiLayout.addLayoutPanel(GuiLayoutPanelType.slotsInput).setSlotLayout(SlotLayoutType.horizontal, 9);
        guiLayout.addLayoutPanel(GuiLayoutPanelType.power);
    }
    Icon[] icons = new Icon[4];

    public BlockEnergyCell() {
        super(ConfigMachineBlocks.getEnergyCellBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Energy Cell", ISetupCreativeTabs.tabPower);
        this.setBlockBounds(0, 0, 0, 1, 13 / 16f, 1);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileEntityEnergyCell();
    }

    @Override
    public int getRenderType() {
        return ConfigRenderers.getRendererEnergyCellId();
    }

    @Override
    public Icon getIcon(int par1, int par2) {
        return icons[par1 % icons.length];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "generatorFeatures");
        icons[1] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "tankSide");
        icons[2] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "battery");
        icons[3] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "powerFeatures");
    }

    @Override
    public GuiLayout getGuiLayout() {
        return guiLayout;
    }

    @Override
    public String getDescription() {
        return "Can store energy in batteries.";
    }
}

package ip.industrialProcessing.power.storage;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.gui3.framework.panels.Orientation;
import ip.industrialProcessing.gui3.generating.GuiBuilderDefault;
import ip.industrialProcessing.gui3.generating.IGuiBlock;
import ip.industrialProcessing.gui3.generating.IGuiBuilder;
import ip.industrialProcessing.power.BlockPowerGenerator;
import ip.industrialProcessing.utils.IDescriptionBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockEnergyCell extends BlockPowerGenerator implements IDescriptionBlock, IGuiBlock {

    public static final String UNLOCALIZED_NAME = "IP.Machine.EnergyCel";
    private static IGuiBuilder guiLayout = new GuiBuilderDefault(UNLOCALIZED_NAME).enablePower(9).addInputSlotCluster(0, 9, 3, Orientation.HORIZONTAL);

    Icon[] icons = new Icon[4];

    public BlockEnergyCell() {
        super(ConfigMachineBlocks.getEnergyCellBlockID(), Material.iron, 1F, Block.soundMetalFootstep, UNLOCALIZED_NAME, ISetupCreativeTabs.tabPower);
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
    public IGuiBuilder getGui() {
        return guiLayout;
    }

    @Override
    public String getDescription() {
        return "Can store energy in batteries.";
    }
}

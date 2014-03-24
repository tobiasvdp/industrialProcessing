package mod.industrialProcessing.plants.power.storage;

import javax.swing.Icon;

import mod.industrialProcessing.blockContainer.machine.power.generator.BlockPowerGenerator;
import mod.industrialProcessing.gui.framework.panels.Orientation;
import mod.industrialProcessing.gui.generating.GuiBuilderDefault;
import mod.industrialProcessing.gui.generating.IGuiBuilder;
import mod.industrialProcessing.utils.INamepace;
import mod.industrialProcessing.utils.block.IDescriptionBlock;
import mod.industrialProcessing.utils.block.IGuiBlock;
import mod.industrialProcessing.utils.creativeTab.ISetupCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockEnergyCell extends BlockPowerGenerator implements IDescriptionBlock, IGuiBlock {

    public static final String UNLOCALIZED_NAME = "IP.Machine.EnergyCel";
    private static IGuiBuilder guiLayout = new GuiBuilderDefault(UNLOCALIZED_NAME).enablePower(9).addInputSlotCluster(0, 9, 3, Orientation.HORIZONTAL);

    Icon[] icons = new Icon[4];

    public BlockEnergyCell() {
        super(1f,1f, Material.iron, Block.soundTypeMetal, "generatorFeatures","tankSide","battery","powerFeatures");
        this.setBlockBounds(0, 0, 0, 1, 13 / 16f, 1);
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

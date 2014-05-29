package mod.industrialProcessing.plants.power.generator.creative;

import mod.industrialProcessing.blockContainer.machine.power.generator.BlockPowerGenerator;
import mod.industrialProcessing.gui.generating.GuiBuilderDefault;
import mod.industrialProcessing.gui.generating.IGuiBuilder;
import mod.industrialProcessing.utils.INamepace;
import mod.industrialProcessing.utils.block.IDescriptionBlock;
import mod.industrialProcessing.utils.block.IGuiBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCreativeGenerator extends BlockPowerGenerator implements IDescriptionBlock, IGuiBlock {

    private static String UNLOCALIZED_NAME = "IP.Power.CreativeGenerator";
    public static IGuiBuilder guiBuilder = new GuiBuilderDefault(UNLOCALIZED_NAME).addGauge("Voltage", "%.2fV", 0).addGauge("Current", "%.2fA", 1).addGauge("Power", "%.2fW", 2).addSpinner(0, "%.0f Volt", 1, 18 * 4);

    public BlockCreativeGenerator() {
        super(1.0f,1.0f, Material.iron, Block.soundTypeMetal, "creativeGenerator");
    }

    @Override
    public IGuiBuilder getGui() {
        return guiBuilder;
    }

    @Override
    public String getDescription() {
        return "A cheaty creative engine";
    }

}

package ip.industrialProcessing.subMod.power.plant.creative;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.gui.GuiLayout;
import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.gui3.generating.GuiBuilderDefault;
import ip.industrialProcessing.gui3.generating.IGuiBlock;
import ip.industrialProcessing.gui3.generating.IGuiBuilder;
import ip.industrialProcessing.power.BlockPowerGenerator;
import ip.industrialProcessing.subMod.power.IPPower;
import ip.industrialProcessing.subMod.power.config.ConfigPower;
import ip.industrialProcessing.utils.IDescriptionBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCreativeGenerator extends BlockPowerGenerator implements IDescriptionBlock, IGuiBlock {

    private static String UNLOCALIZED_NAME = "IP.Power.CreativeGenerator";
    public static IGuiBuilder guiBuilder = new GuiBuilderDefault(UNLOCALIZED_NAME).addGauge("Voltage", "%.2fV", 0).addGauge("Current", "%.2fA", 1).addGauge("Power", "%.2fW", 2).addSpinner(0, "%.0f Volt", 1, 18 * 4);

    public BlockCreativeGenerator() {
        super(ConfigPower.getCreativeEngineID(), Material.iron, 1f, Block.soundMetalFootstep, UNLOCALIZED_NAME, IPPower.tabPower);
        setTextureName(IndustrialProcessing.TEXTURE_NAME_PREFIX + "creativeGenerator");
    }

    @Override
    public IGuiBuilder getGui() {
        return guiBuilder;
    }

    @Override
    public String getDescription() {
        return "A cheaty creative engine";
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileEntityCreativeGenerator();
    }

}

package ip.industrialProcessing.power.buildcraftGenerator;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.gui3.framework.panels.Orientation;
import ip.industrialProcessing.gui3.generating.GuiBuilderDefault;
import ip.industrialProcessing.gui3.generating.IGuiBlock;
import ip.industrialProcessing.gui3.generating.IGuiBuilder;
import ip.industrialProcessing.power.BlockPowerGenerator;
import ip.industrialProcessing.utils.IDescriptionBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockBuildcraftGenerator extends BlockPowerGenerator implements IGuiBlock, IDescriptionBlock {

    public static final String UNLOCALIZED_NAME = "IP.Machine.BuildcraftGenerator";
    private static IGuiBuilder guiBuilder = new GuiBuilderDefault(UNLOCALIZED_NAME).addGauge("Voltage", "%.0fV", 0).addGauge("Current", "%.0fA", 1).addGauge("Power", "%.0fW", 2);

    
    public BlockBuildcraftGenerator() {
	super(ConfigMachineBlocks.getBuildcraftGeneratorBlockID(), Material.iron, 1F, Block.soundMetalFootstep, UNLOCALIZED_NAME, ISetupCreativeTabs.tabPower);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	return new TileEntityBuildcraftGenerator();
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererBCGeneratorId();
    }

    @Override
    public String getDescription() { 
	return "Converts buildcraft energy into electricity";
    }

    @Override
    public IGuiBuilder getGui() { 
	return guiBuilder;
    }
}

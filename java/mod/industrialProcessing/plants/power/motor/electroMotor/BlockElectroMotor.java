package mod.industrialProcessing.plants.power.motor.electroMotor;

import javax.swing.Icon;

import mod.industrialProcessing.blockContainer.BlockContainerIPRendered;
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

public class BlockElectroMotor extends BlockContainerIPRendered implements IDescriptionBlock, IGuiBlock {

    private static IGuiBuilder guiBuilder = new GuiBuilderDefault("Motor").addLabeledGauge("Voltage", "%.2fV", 0).addLabeledGauge("Speed", "%.0fRPM", 1);
    
    public BlockElectroMotor() {
        super(1f,1f,Material.iron, Block.soundTypeMetal);
    }

    @Override
    public IGuiBuilder getGui() { 
	return guiBuilder;
    }

    @Override
    public String getDescription() { 
	return "Converts electricity into mechanical motion";
    }
}

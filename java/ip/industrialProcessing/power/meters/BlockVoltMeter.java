package ip.industrialProcessing.power.meters;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.machines.BlockMachineRendered;

public class BlockVoltMeter extends BlockMachineRendered {

    public BlockVoltMeter() {
	super(ConfigMachineBlocks.getVoltMeterBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Volt Meter", ISetupCreativeTabs.tabPower);
    }

    @Override
    public TileEntity createNewTileEntity(World world) { 
	return new TileEntityVoltMeter();
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererVoltMeterId();
    }
}

package ip.industrialProcessing.power.meters;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.BlockMachineRendered;

public class BlockAmpMeter extends BlockMachineRendered {
    public BlockAmpMeter() {
	super(ConfigMachineBlocks.getAmpMeterBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Amp Meter", IndustrialProcessing.tabPower);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	return new TileEntityAmpMeter();
    }

    @Override
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) { 
        super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
        TileEntityAmpMeter ampMeter = (TileEntityAmpMeter)par1World.getBlockTileEntity(par2, par3, par4);
        ampMeter.checkConnections();
    }
    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererAmpMeterId();
    }
}

package ip.industrialProcessing.transport.fluids;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigBlocks;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ConfigTransportBlocks;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.machines.BlockMachineRendered;

public class BlockPump extends BlockMachineRendered {

	public BlockPump() {
		super(ConfigTransportBlocks.getBlockTransportFluidPumpID(), Material.iron, 1F, Block.soundMetalFootstep, "Fluid Pump", IndustrialProcessing.tabOreProcessing);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityPump();
	}

	
	@Override
	public int getRenderType() { 
		return ConfigRenderers.getRendererPumpId();
	}
}

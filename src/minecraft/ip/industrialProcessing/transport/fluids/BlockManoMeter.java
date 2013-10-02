package ip.industrialProcessing.transport.fluids;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ConfigTransportBlocks;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.machines.BlockMachineRendered;

public class BlockManoMeter extends BlockMachineRendered {

	public BlockManoMeter() {
		super(ConfigTransportBlocks.getBlockTransportFluidManometerID(), Material.iron, 1F, Block.soundMetalFootstep, "Manometer", IndustrialProcessing.tabOreProcessing);
		setBlockBounds(0, 0, 0.25f, 1, 1, 0.75f);
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess par1iBlockAccess, int par2, int par3, int par4) {
		ForgeDirection direction = BlockMachine.getForwardFromEntity(par1iBlockAccess.getBlockTileEntity(par2, par3, par4));
		
		
		if(direction.ordinal() < 2)
			setBlockBounds(0, 0, 0, 1, 1, 1);
		else if(direction.ordinal() < 4)
			setBlockBounds(0, 0, 0.25f, 1, 1, 0.75f);
		else
			setBlockBounds(0.25f, 0, 0, 0.75f, 1, 1);
			
		super.setBlockBoundsBasedOnState(par1iBlockAccess, par2, par3, par4);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityManoMeter();
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererManometerId();
	}

}

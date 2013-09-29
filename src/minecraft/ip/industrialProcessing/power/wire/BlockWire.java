package ip.industrialProcessing.power.wire;

import java.util.List;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.transport.BlockTransport;
import ip.industrialProcessing.transport.fluids.TileEntityTransportFluidsBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockWire extends BlockTransport {

	public BlockWire() {
		super(ConfigMachineBlocks.getWireBlockID(), Material.cloth, 1F, Block.soundClothFootstep, "Wire", IndustrialProcessing.tabPower);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityWire();
	}

	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
		super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
		TileEntityWire wire = (TileEntityWire) par1World.getBlockTileEntity(par2, par3, par4);
		wire.searchForConnections();
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererWireId();
	}
}

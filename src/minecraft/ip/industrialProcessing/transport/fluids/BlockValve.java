package ip.industrialProcessing.transport.fluids;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ConfigTransportBlocks;
import ip.industrialProcessing.machines.BlockMachineRendered;

public class BlockValve extends BlockMachineRendered {

	public BlockValve() {
		super(ConfigTransportBlocks.getBlockValveID(), Material.glass, 1F, Block.soundGlassFootstep, "Fluid Pipe Valve", IndustrialProcessing.tabOreProcessing);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityTransportFluids();
	}

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		return false;
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererTransportFluidsId();
	}
}

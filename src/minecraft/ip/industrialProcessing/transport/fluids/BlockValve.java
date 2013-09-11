package ip.industrialProcessing.transport.fluids;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ConfigTransportBlocks;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.transport.BlockTransport;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockValve extends BlockTransport {

	public BlockValve() {
		super(ConfigTransportBlocks.getBlockValveID(), Material.glass, 1F, Block.soundGlassFootstep, "Fluid Pipe Valve", IndustrialProcessing.tabOreProcessing);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityValve();
	}

	@Override
	public void onBlockPlacedBy(World par1World, int x, int y, int z, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {
		int dir = MathHelper.floor_double((double) ((par5EntityLivingBase.rotationYaw * 4F) / 360F) + 0.5D) & 3;
		TileEntity entity = par1World.getBlockTileEntity(x, y, z);
		if (entity instanceof TileEntityValve) {
			TileEntityValve machine = (TileEntityValve) entity;
			machine.setForwardDirection(BlockMachine.getForwardFromMetadata(dir));
		}
		super.onBlockPlacedBy(par1World, x, y, z, par5EntityLivingBase, par6ItemStack);
	}

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		TileEntityValve entity = (TileEntityValve) par1World.getBlockTileEntity(par2, par3, par4);
		if (par5EntityPlayer.isSneaking()) {
			entity.openValveHit();
		} else {
			entity.closeValveHit();
		}
		return false;
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererValveId();
	}
}

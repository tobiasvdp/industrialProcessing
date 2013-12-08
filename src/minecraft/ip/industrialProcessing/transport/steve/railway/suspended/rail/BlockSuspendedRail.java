package ip.industrialProcessing.transport.steve.railway.suspended.rail;

import java.util.Random;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigTransportBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockSuspendedRail extends Block {

	public BlockSuspendedRail() {
		super(ConfigTransportBlocks.getBlockSuspendedRailID(), Material.iron);
		setHardness(1.0f);
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName("BlockSuspendedRail");
		setCreativeTab(IndustrialProcessing.tabPower);
	}

	@Override
	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
		Block block = Block.blocksList[par1World.getBlockId(par2, par3 - 1, par4)];
		if (block == null || block.isBlockReplaceable(par1World, par2, par3, par4)) {
			if (isSuspended(par1World, par2, par3, par4, 6, -1))
				return super.canPlaceBlockAt(par1World, par2, par3, par4);
			return false;
		}
		return false;
	}

	private boolean isSuspended(World par1World, int par2, int par3, int par4, int ttl, int origin) {
		if (ttl > 0) {
			if (isBlockSuspended(par1World, par2, par3, par4))
				return true;
			return isNeighbourSuspended(par1World, par2, par3, par4, ttl, origin);
		}
		return false;
	}

	private boolean isBlockSuspended(World par1World, int par2, int par3, int par4) {
		for (int i = 2; i < 6; i++) {
			ForgeDirection dir = ForgeDirection.values()[i];
			int id = par1World.getBlockId(par2 + dir.offsetX, par3, par4 + dir.offsetZ);
			if (ConfigTransportBlocks.getSuspensionList().isSuspension(id))
				return true;
		}
		return false;
	}

	private boolean isNeighbourSuspended(World par1World, int par2, int par3, int par4, int ttl, int origin) {
		for (int i = 2; i < 6; i++) {
			if (i != origin) {
				ForgeDirection dir = ForgeDirection.values()[i];
				int id = par1World.getBlockId(par2 + dir.offsetX, par3, par4 + dir.offsetZ);
				if (id == this.blockID)
					if (isSuspended(par1World, par2 + dir.offsetX, par3, par4 + dir.offsetZ, ttl - 1, dir.getOpposite().ordinal()))
						return true;
			}

		}
		return false;
	}

	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
		super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
		if (!isSuspended(par1World, par2, par3, par4, 6, -1)) {
			this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
			par1World.setBlockToAir(par2, par3, par4);
		}
		par1World.setBlockMetadataWithNotify(par2, par3, par4, updateConnections(par1World, par2, par3, par4, par5), 3);
	}

	@Override
	public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9) {
		return updateConnections(par1World, par2, par3, par4, 0);
	}

	private int updateConnections(World par1World, int par2, int par3, int par4, int meta) {
		int east = par1World.getBlockId(par2 + 1, par3, par4);
		int west = par1World.getBlockId(par2 - 1, par3, par4);
		if (east == this.blockID && west == this.blockID)
			return 1;
		int north = par1World.getBlockId(par2, par3, par4 - 1);
		int south = par1World.getBlockId(par2, par3, par4 + 1);
		if (north == this.blockID && south == this.blockID)
			return 2;
		if (north == this.blockID && east == this.blockID)
			return 3;
		if (north == this.blockID && west == this.blockID)
			return 4;
		if (south == this.blockID && west == this.blockID)
			return 5;
		if (south == this.blockID && east == this.blockID)
			return 6;
		int westUp = par1World.getBlockId(par2 - 1, par3 + 1, par4);
		int westDown = par1World.getBlockId(par2 - 1, par3 - 1, par4);
		if (east == this.blockID && westUp == this.blockID) {
			if (meta != 7)
				par1World.scheduleBlockUpdate(par2 - 1, par3 + 1, par4, this.blockID, 1);
			return 7;
		}
		if (east == this.blockID && westDown == this.blockID) {
			if (meta != 10)
				par1World.scheduleBlockUpdate(par2 - 1, par3 - 1, par4, this.blockID, 1);
			return 10;
		}
		int eastUp = par1World.getBlockId(par2 + 1, par3 + 1, par4);
		int eastDown = par1World.getBlockId(par2 + 1, par3 - 1, par4);
		if (west == this.blockID && eastUp == this.blockID) {
			if (meta != 8)
				par1World.scheduleBlockUpdate(par2 + 1, par3 + 1, par4, this.blockID, 1);
			return 8;
		}
		if (west == this.blockID && eastDown == this.blockID) {
			if (meta != 9)
				par1World.scheduleBlockUpdate(par2 + 1, par3 - 1, par4, this.blockID, 1);
			return 9;
		}
		int northUp = par1World.getBlockId(par2, par3 + 1, par4 - 1);
		int northDown = par1World.getBlockId(par2, par3 - 1, par4 - 1);
		if (south == this.blockID && northUp == this.blockID) {
			if (meta != 11)
				par1World.scheduleBlockUpdate(par2, par3 + 1, par4 - 1, this.blockID, 1);
			return 11;
		}
		if (south == this.blockID && northDown == this.blockID) {
			if (meta != 14)
				par1World.scheduleBlockUpdate(par2, par3 - 1, par4 - 1, this.blockID, 1);
			return 14;
		}
		int southUp = par1World.getBlockId(par2, par3 + 1, par4 + 1);
		int southDown = par1World.getBlockId(par2, par3 - 1, par4 + 1);
		if (north == this.blockID && southUp == this.blockID) {
			if (meta != 12)
				par1World.scheduleBlockUpdate(par2, par3 + 1, par4 + 1, this.blockID, 1);
			return 12;
		}
		if (north == this.blockID && southDown == this.blockID) {
			if (meta != 13)
				par1World.scheduleBlockUpdate(par2, par3 - 1, par4 + 1, this.blockID, 1);
			return 13;
		}
		return 0;
	}

	@Override
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		super.updateTick(par1World, par2, par3, par4, par5Random);
		par1World.setBlockMetadataWithNotify(par2, par3, par4, updateConnections(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4)),3);
	}
	
	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		System.out.println(par1World.getBlockMetadata(par2, par3, par4));
		return super.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9);
	}

}

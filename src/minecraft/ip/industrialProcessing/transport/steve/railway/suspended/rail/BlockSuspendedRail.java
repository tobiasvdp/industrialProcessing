package ip.industrialProcessing.transport.steve.railway.suspended.rail;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class BlockSuspendedRail extends Block{

	public BlockSuspendedRail() {
		super(par1, Material.iron);
	}
	@Override
	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
		Block block = Block.blocksList[par1World.getBlockId(par2, par3-1, par4)];
		if(block == null || block.isBlockReplaceable(par1World, par2, par3, par4)){
			if(isSuspended(par1World, par2, par3, par4,6))
				return super.canPlaceBlockAt(par1World, par2, par3, par4);
			return false;
		}
		return false;
	}
	private boolean isSuspended(World par1World, int par2, int par3, int par4,int ttl) {
		if(ttl > 0){
			if(isBlockSuspended( par1World,  par2,  par3,  par4))
				return true;
			return isNeighbourSuspended(par1World,  par2,  par3,  par4,ttl);
		}
		return false;
	}
	private boolean isBlockSuspended(World par1World, int par2, int par3, int par4) {
		// TODO Auto-generated method stub
		return false;
	}
	private boolean isNeighbourSuspended(World par1World, int par2, int par3, int par4, int ttl) {
		// TODO Auto-generated method stub
		return false;
	}

}

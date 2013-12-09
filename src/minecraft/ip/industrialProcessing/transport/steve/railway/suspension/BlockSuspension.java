package ip.industrialProcessing.transport.steve.railway.suspension;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigTransportBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class BlockSuspension extends Block {

	public BlockSuspension() {
		super(ConfigTransportBlocks.getBlockSuspensionID(), Material.iron);
		setHardness(1.0f);
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName("BlockSuspension");
		setCreativeTab(IndustrialProcessing.tabPower);
	}

	@Override
	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
		Block block = Block.blocksList[par1World.getBlockId(par2, par3 - 1, par4)];
		if (block == null || block.isBlockReplaceable(par1World, par2, par3-1, par4)) {
			return false;
		}
		return true;
	}
	
	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
		super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
		Block block = Block.blocksList[par1World.getBlockId(par2, par3 - 1, par4)];
		if (block == null || block.isBlockReplaceable(par1World, par2, par3-1, par4)) {
            this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
            par1World.setBlockToAir(par2, par3, par4);
		}
		
	}
}

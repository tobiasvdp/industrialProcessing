package mod.industrialProcessing.blockContainer.light;

import java.util.List;
import java.util.Random;

import mod.industrialProcessing.blockContainer.BlockContainerIPRendered;
import mod.industrialProcessing.utils.rotation.IRotateableEntity;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public abstract class BlockLamp extends BlockContainerIPRendered {

	public BlockLamp(float hardness, float resistance, Material material, SoundType soundtype, String... iconNames) {
		super(hardness, resistance, material, soundtype, iconNames);
		this.setTickRandomly(true);
	}

	@Override
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		super.updateTick(par1World, par2, par3, par4, par5Random);

		if (par1World.getBlockMetadata(par2, par3, par4) == 0) {
			this.onBlockAdded(par1World, par2, par3, par4);
		}
	}

	/**
	 * Called whenever the block is added into the world. Args: world, x, y, z
	 */
	@Override
	public void onBlockAdded(World par1World, int par2, int par3, int par4) {
		IRotateableEntity machine = (IRotateableEntity) par1World.getTileEntity(par2, par3, par4);
		if (par1World.getBlockMetadata(par2, par3, par4) == 0) {
			if (par1World.isSideSolid(par2 - 1, par3, par4, ForgeDirection.EAST, true)) {
				par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 2);
				ForgeDirection forward = getForwardFromMetadata(1);
				machine.setForwardDirection(forward);
			} else if (par1World.isSideSolid(par2 + 1, par3, par4, ForgeDirection.WEST, true)) {
				par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
				ForgeDirection forward = getForwardFromMetadata(3);
				machine.setForwardDirection(forward);
			} else if (par1World.isSideSolid(par2, par3, par4 - 1, ForgeDirection.SOUTH, true)) {
				par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
				ForgeDirection forward = getForwardFromMetadata(2);
				machine.setForwardDirection(forward);
			} else if (par1World.isSideSolid(par2, par3, par4 + 1, ForgeDirection.NORTH, true)) {
				par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
				ForgeDirection forward = getForwardFromMetadata(4);
				machine.setForwardDirection(forward);
			}
		}
	}

	@Override
	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
		return par1World.isSideSolid(par2 - 1, par3, par4, ForgeDirection.EAST, true) || par1World.isSideSolid(par2 + 1, par3, par4, ForgeDirection.WEST, true) || par1World.isSideSolid(par2, par3, par4 - 1, ForgeDirection.SOUTH, true) || par1World.isSideSolid(par2, par3, par4 + 1, ForgeDirection.NORTH, true);
	}

	@Override
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		TileEntityLamp te = (TileEntityLamp) par1World.getTileEntity(par2, par3, par4);

		if (te.lightChanged) {
			te.updateLight();
			te.lightChanged = false;
		}

		if (te.getForwardDirection() != null) {
			int l = te.getForwardDirection().ordinal();
			double d0 = par2 + 0.5F;
			double d1 = par3 + te.yOffset();
			double d2 = par4 + 0.5F;
			double d3 = te.xzOffset();
			double d4 = te.xzOffset();

			if (te.getLightLevel() > 8) {
				if (l == 1) {
					par1World.spawnParticle("smoke", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
					par1World.spawnParticle("flame", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
				} else if (l == 2) {
					par1World.spawnParticle("smoke", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
					par1World.spawnParticle("flame", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
				} else if (l == 3) {
					par1World.spawnParticle("smoke", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
					par1World.spawnParticle("flame", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
				} else if (l == 4) {
					par1World.spawnParticle("smoke", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
					par1World.spawnParticle("flame", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
				} else if (l == 5) {
					par1World.spawnParticle("smoke", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
					par1World.spawnParticle("flame", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
				}
			} else if (te.getLightLevel() > 0) {
				if (l == 1) {
					par1World.spawnParticle("smoke", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
				} else if (l == 2) {
					par1World.spawnParticle("smoke", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
				} else if (l == 3) {
					par1World.spawnParticle("smoke", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
				} else if (l == 4) {
					par1World.spawnParticle("smoke", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
				} else if (l == 5) {
					par1World.spawnParticle("smoke", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
				}
			}
		}
	}

	@Override
	public int getLightValue(IBlockAccess world, int x, int y, int z) {
		TileEntityLamp te = (TileEntityLamp) world.getTileEntity(x, y, z);
		return te.getLightLevel();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float clickX, float clickY, float clickZ) {
		TileEntityLamp te = (TileEntityLamp) world.getTileEntity(x, y, z);
		if (te.getBurnTime() < 6000) {
			te.addTo(player);
		}
		return super.onBlockActivated(world, x, y, z, player, metadata, clickX, clickY, clickZ);
	}

	@Override
	public void addCollisionBoxesToList(World p_149743_1_, int p_149743_2_, int p_149743_3_, int p_149743_4_, AxisAlignedBB p_149743_5_, List p_149743_6_, Entity p_149743_7_) {

	}
}

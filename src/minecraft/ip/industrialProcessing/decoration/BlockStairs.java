package ip.industrialProcessing.decoration;

import java.util.List;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.api.rendering.connectedTile.ConnectionCompass;
import ip.industrialProcessing.api.rendering.connectedTile.TileConnection;
import ip.industrialProcessing.config.ConfigBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockStairs extends BlockDecoration {

	public BlockStairs() {
		super(ConfigBlocks.getStairsBlockID(), Material.iron, 1f, Block.soundMetalFootstep, "Walkway stairs", IndustrialProcessing.tabPower);
		this.setBlockBounds(0, 0, 0, 1, 1, 1);
		func_111022_d(IndustrialProcessing.TEXTURE_NAME_PREFIX + "platformFloor");
	}

	@Override
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {
		super.onBlockPlacedBy(par1World, par2, par3, par4, par5EntityLivingBase, par6ItemStack);

		int dir = MathHelper.floor_double((double) ((par5EntityLivingBase.rotationYaw * 4F) / 360F) + 0.5D) & 3;
		if (par5EntityLivingBase.isSneaking())
			dir += 2;
		if (dir % 2 == 0)
			dir += 2;
		dir %= 4;

		par1World.setBlockMetadataWithNotify(par2, par3, par4, dir, 2);
	}

	public ConnectionCompass getConnections(IBlockAccess world, int x, int y, int z) {

		int dir = world.getBlockMetadata(x, y, z);
		ConnectionCompass compass = new ConnectionCompass();

		int dyN = dir == 0 ? 1 : 0;
		int dyE = dir == 1 ? 1 : 0;
		int dyS = dir == 2 ? 1 : 0;
		int dyW = dir == 3 ? 1 : 0;

		int meta = world.getBlockMetadata(x, y, z);

		compass.connectionN = getConnection(world, x, y, z, 0, dyN, -1, meta);
		compass.connectionE = getConnection(world, x, y, z, 1, dyE, 0, meta);
		compass.connectionS = getConnection(world, x, y, z, 0, dyS, 1, meta);
		compass.connectionW = getConnection(world, x, y, z, -1, dyW, 0, meta);

		compass.connectionNE = getConnection(world, x, y, z, 1, dyN + dyE, -1, meta);
		compass.connectionSE = getConnection(world, x, y, z, 1, dyS + dyE, 1, meta);
		compass.connectionSW = getConnection(world, x, y, z, -1, dyS + dyW, 1, meta);
		compass.connectionNW = getConnection(world, x, y, z, -1, dyN + dyW, -1, meta);
		return compass;
	}

	protected TileConnection getConnection(IBlockAccess world, int x, int y, int z, int dx, int dy, int dz, int meta) {
		int x2 = x + dx;
		int y2 = y + dy;
		int z2 = z + dz;
		int id = world.getBlockId(x2, y2, z2);
		if (id == ConfigBlocks.getStairsBlockID()) {
			int meta2 = world.getBlockMetadata(x2, y2, z2);
			if (meta == meta2)
				return TileConnection.CONNECTED;
		} else if (id == ConfigBlocks.getPlatformBlockID()) {
			return TileConnection.GROUND;
		}
		if (isSolid(world, x2, y2 - 1, z2))
			return TileConnection.GROUND;
		return TileConnection.AIR;
	}

	protected boolean isSolid(IBlockAccess world, int x, int y, int z) {
		if (world.isBlockOpaqueCube(x, y, z))
			return true;
		if (world.isBlockNormalCube(x, y, z))
			return true;
		return false;
	}

	@Override
	public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity) {

		ConnectionCompass compass = this.getConnections(par1World, par2, par3, par4);

		float minX1 = 0;
		float maxX1 = 1;
		float minXL1 = 0;
		float maxXL1 = 1 / 16f;
		float minXR1 = 15 / 16f;
		float maxXR1 = 16 / 16f;

		float minY1 = 7 / 16f;
		float maxY1 = 8 / 16f;
		float minZ1 = 0;
		float maxZ1 = 8 / 16f;

		float minX2 = 0;
		float maxX2 = 1;
		float minXL2 = 0;
		float maxXL2 = 1 / 16f;
		float minXR2 = 15 / 16f;
		float maxXR2 = 16 / 16f;
		float minY2 = 15 / 16f;
		float maxY2 = 16 / 16f;
		float minZ2 = 8 / 16f;
		float maxZ2 = 16 / 16f;

		int dir = par1World.getBlockMetadata(par2, par3, par4);

		TileConnection[] lefts = new TileConnection[4];
		lefts[0] = compass.connectionE;
		lefts[1] = compass.connectionN;
		lefts[2] = compass.connectionW;
		lefts[3] = compass.connectionS;
		TileConnection[] rights = new TileConnection[4];
		rights[0] = compass.connectionW;
		rights[1] = compass.connectionS;
		rights[2] = compass.connectionE;
		rights[3] = compass.connectionN;

		switch (dir) {
		case 2:
			this.setBlockBounds(minX1, minY1, minZ1, maxX1, maxY1, maxZ1);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
			this.setBlockBounds(minX2, minY2, minZ2, maxX2, maxY2, maxZ2);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);

			if (compass.connectionW == TileConnection.AIR || compass.connectionW == TileConnection.GROUND) {
				this.setBlockBounds(minXL1, minY1, minZ1, maxXL1, maxY1 + 1.2f, maxZ1);
				super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
				this.setBlockBounds(minXL2, minY2, minZ2, maxXL2, maxY2 + 1.2f, maxZ2);
				super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
			}

			if (compass.connectionE == TileConnection.AIR || compass.connectionE == TileConnection.GROUND) {
				this.setBlockBounds(minXR1, minY1, minZ1, maxXR1, maxY1 + 1.2f, maxZ1);
				super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
				this.setBlockBounds(minXR2, minY2, minZ2, maxXR2, maxY2 + 1.2f, maxZ2);
				super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
			}
			break;
		case 0:
			this.setBlockBounds(minX1, minY1, minZ2, maxX1, maxY1, maxZ2);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
			this.setBlockBounds(minX2, minY2, minZ1, maxX2, maxY2, maxZ1);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);

			if (compass.connectionW == TileConnection.AIR || compass.connectionW == TileConnection.GROUND) {
				this.setBlockBounds(minXL1, minY1, minZ2, maxXL1, maxY1 + 1.2f, maxZ2);
				super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
				this.setBlockBounds(minXL2, minY2, minZ1, maxXL2, maxY2 + 1.2f, maxZ1);
				super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
			}

			if (compass.connectionE == TileConnection.AIR || compass.connectionE == TileConnection.GROUND) {
				this.setBlockBounds(minXR1, minY1, minZ2, maxXR1, maxY1 + 1.2f, maxZ2);
				super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
				this.setBlockBounds(minXR2, minY2, minZ1, maxXR2, maxY2 + 1.2f, maxZ1);
				super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
			}
			break;
		case 3:
			this.setBlockBounds(minZ1, minY1, minX1, maxZ1, maxY1, maxX1);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
			this.setBlockBounds(minZ2, minY2, minX2, maxZ2, maxY2, maxX2);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);

			if (compass.connectionN == TileConnection.AIR || compass.connectionN == TileConnection.GROUND) {
				this.setBlockBounds(minZ1, minY1, minXL1, maxZ1, maxY1 + 1.2f, maxXL1);
				super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
				this.setBlockBounds(minZ2, minY2, minXL2, maxZ2, maxY2 + 1.2f, maxXL2);
				super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
			}
			if (compass.connectionS == TileConnection.AIR || compass.connectionS == TileConnection.GROUND) {
				this.setBlockBounds(minZ1, minY1, minXR1, maxZ1, maxY1 + 1.2f, maxXR1);
				super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
				this.setBlockBounds(minZ2, minY2, minXR2, maxZ2, maxY2 + 1.2f, maxXR2);
				super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
			}
			break;
		case 1:
			this.setBlockBounds(minZ2, minY1, minX1, maxZ2, maxY1, maxX1);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
			this.setBlockBounds(minZ1, minY2, minX2, maxZ1, maxY2, maxX2);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);

			if (compass.connectionN == TileConnection.AIR || compass.connectionN == TileConnection.GROUND) {
				this.setBlockBounds(minZ2, minY1, minXL1, maxZ2, maxY1 + 1.2f, maxXL1);
				super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
				this.setBlockBounds(minZ1, minY2, minXL2, maxZ1, maxY2 + 1.2f, maxXL2);
				super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
			}
			if (compass.connectionS == TileConnection.AIR || compass.connectionS == TileConnection.GROUND) {
				this.setBlockBounds(minZ2, minY1, minXR1, maxZ2, maxY1 + 1.2f, maxXR1);
				super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
				this.setBlockBounds(minZ1, minY2, minXR2, maxZ1, maxY2 + 1.2f, maxXR2);
				super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
			}
			break;
		}
		this.setBlockBounds(0, 0, 0, 1, 1, 1);
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererStairsId();
	}
}

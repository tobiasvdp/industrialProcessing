package ip.industrialProcessing.decoration.platforms;

import ip.industrialProcessing.api.rendering.connectedTile.ConnectionCompass;
import ip.industrialProcessing.api.rendering.connectedTile.TileConnection;
import ip.industrialProcessing.config.ConfigBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockPlatform extends BlockScaffolding {

	public BlockPlatform() {
		super(ConfigBlocks.getPlatformBlockID(), Material.iron, 1f, Block.soundMetalFootstep, "Walkway", ISetupCreativeTabs.tabPower);
		this.setBlockBounds(0, 0, 0, 1, 1 / 16f, 1);
		func_111022_d(INamepace.TEXTURE_NAME_PREFIX + "platformFloor");
		setStepSound(soundMetalFootstep);
	}

	protected BlockPlatform(int id, String name) {
		super(id, Material.iron, 1f, Block.soundMetalFootstep, name, ISetupCreativeTabs.tabPower);
		this.setBlockBounds(0, 0, 0, 1, 1 / 16f, 1);
		func_111022_d(INamepace.TEXTURE_NAME_PREFIX + "platformFloor");
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererPlatformId();
	}

	public ConnectionCompass getConnections(IBlockAccess world, int x, int y, int z) {
		ConnectionCompass compass = new ConnectionCompass();

		compass.connectionN = getConnection(world, x, y, z, 0, 0, -1);
		compass.connectionE = getConnection(world, x, y, z, 1, 0, 0);
		compass.connectionS = getConnection(world, x, y, z, 0, 0, 1);
		compass.connectionW = getConnection(world, x, y, z, -1, 0, 0);

		compass.connectionNE = getConnection(world, x, y, z, 1, 0, -1);
		compass.connectionSE = getConnection(world, x, y, z, 1, 0, 1);
		compass.connectionSW = getConnection(world, x, y, z, -1, 0, 1);
		compass.connectionNW = getConnection(world, x, y, z, -1, 0, -1);
		return compass;
	}

	protected TileConnection getConnection(IBlockAccess world, int x, int y, int z, int dx, int dy, int dz) {
		int x2 = x + dx;
		int y2 = y + dy;
		int z2 = z + dz;
		int id = world.getBlockId(x2, y2, z2);
		if (id == ConfigBlocks.getPlatformBlockID()) {
			return TileConnection.CONNECTED;
		} else if (id == ConfigBlocks.getStairsBlockID()) {
			if (BlockStairs.isStairsFacing(world, x2, y2, z2, dx, dy, dz))
				return TileConnection.STAIRS; 
			else
				return TileConnection.STAIRSSIDE; 
		} else {
			TileEntity entity = world.getBlockTileEntity(x2, y2, z2);
			if (entity instanceof IInventory) {
				return TileConnection.MACHINE;
			} else if (isSolid(world, x2, y2, z2)) {
				return TileConnection.WALL;
			} else if (!isSolid(world, x2, y2 - 1, z2)) {
				int idBelow = world.getBlockId(x2, y2 - 1, z2);
				if (idBelow == ConfigBlocks.getStairsBlockID()) {
					if (BlockStairs.isStairsFacing(world, x2, y2 - 1, z2, -dx, -dy, -dz)) {
						return TileConnection.CONNECTEDSTAIRS;
					}else
						return TileConnection.STAIRSTOP;
				} else if (idBelow == ladder.blockID)
					return TileConnection.GROUND;
				return TileConnection.AIR;
			} else {
				return TileConnection.GROUND;
			}
		}

	}

	protected boolean isSolid(IBlockAccess world, int x, int y, int z) {
		if (world.isBlockOpaqueCube(x, y, z))
			return true;
		if (world.isBlockNormalCube(x, y, z))
			return true;
		return false;
	}

	@Override
	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity) {

		addCollision(ForgeDirection.NORTH, world, x, y, z, par5AxisAlignedBB, par6List, par7Entity);
		addCollision(ForgeDirection.EAST, world, x, y, z, par5AxisAlignedBB, par6List, par7Entity);
		addCollision(ForgeDirection.SOUTH, world, x, y, z, par5AxisAlignedBB, par6List, par7Entity);
		addCollision(ForgeDirection.WEST, world, x, y, z, par5AxisAlignedBB, par6List, par7Entity);
		AxisAlignedBB axisalignedbb1 = AxisAlignedBB.getBoundingBox(0 + x, 0 + y, 0 + z, 1 + x, 1 / 16f + y, 1 + z);

		if (axisalignedbb1 != null && par5AxisAlignedBB.intersectsWith(axisalignedbb1)) {
			par6List.add(axisalignedbb1);
		}
	}

	private void addCollision(ForgeDirection direction, World world, int x, int y, int z, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity) {

		TileConnection connection = getConnection(world, x, y, z, direction.offsetX, direction.offsetY, direction.offsetZ);

		if (connection == TileConnection.AIR || connection == TileConnection.STAIRSTOP || connection == TileConnection.STAIRSSIDE) {

			double x0 = Math.abs(direction.offsetZ) / 2f;
			double z0 = Math.abs(direction.offsetX) / 2f;

			double minX = 1, maxX = 0;
			double minY = 1, maxY = 0;
			double minZ = 1, maxZ = 0;

			double x1 = 0.5 + direction.offsetX * 7 / 16f;
			double x2 = 0.5 + direction.offsetX / 2f;

			minX = Math.min(minX, x1 - x0);
			minX = Math.min(minX, x2 - x0);
			maxX = Math.max(maxX, x1 + x0);
			maxX = Math.max(maxX, x2 + x0);

			minY = 0;
			maxY = 1;

			double z1 = 0.5 + direction.offsetZ * 7 / 16f;
			double z2 = 0.5 + direction.offsetZ / 2f;

			minZ = Math.min(minZ, z1 - z0);
			minZ = Math.min(minZ, z2 - z0);
			maxZ = Math.max(maxZ, z1 + z0);
			maxZ = Math.max(maxZ, z2 + z0);

			AxisAlignedBB axisalignedbb1 = AxisAlignedBB.getBoundingBox(minX + x, minY + y, minZ + z, maxX + x, maxY + y, maxZ + z);

			if (axisalignedbb1 != null && par5AxisAlignedBB.intersectsWith(axisalignedbb1)) {
				par6List.add(axisalignedbb1);
			}
		}

	}

}

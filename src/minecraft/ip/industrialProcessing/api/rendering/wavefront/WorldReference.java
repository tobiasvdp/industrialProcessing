package ip.industrialProcessing.api.rendering.wavefront;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.ForgeDirection;

import org.lwjgl.util.vector.Vector3f;

public class WorldReference {
	public IBlockAccess world;
	public int x;
	public int y;
	public int z;
	public Block block;
	public int baseBrightness;
	public int[] neighborBrightness;

	public static int getBrightness(IBlockAccess world, int x, int y, int z, Block block) {
		return block.getMixedBrightnessForBlock(world, x, y, z);
	}

	public static float getAmbientOcclusion(IBlockAccess world, int x, int y, int z, Block block) {
		return block.getAmbientOcclusionLightValue(world, x, y, z);
	}

	public WorldReference(IBlockAccess world, int x, int y, int z, Block block) {
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
		this.block = block;

		this.baseBrightness = getBrightness(world, x, y, z, block);

		this.neighborBrightness = new int[6];
		for (int i = 0; i < neighborBrightness.length; i++) {
			ForgeDirection direction = ForgeDirection.getOrientation(i);

			int dx = direction.offsetX;
			int dy = direction.offsetY;
			int dz = direction.offsetZ;

			this.neighborBrightness[i] = getBrightness(dx, dy, dz);
		}
	}

	protected int getBrightness(int dx, int dy, int dz) {
		Block other = block;
		if (dx != 0 || dy != 0 || dz != 0) {
			int id = world.getBlockId(x + dx, y + dy, z + dz);
			block = Block.blocksList[id];
			if (block == null)
				return this.baseBrightness;
		}
		return getBrightness(world, x + dx, y + dy, z + dz, block);
	}

	public int getBrightness(Vector3f position) {
		float dx = position.x;
		float dy = position.y;
		float dz = position.z;

		long bA = brighnessLerp(ForgeDirection.DOWN, ForgeDirection.UP, position.y);
		long bB = brighnessLerp(ForgeDirection.NORTH, ForgeDirection.SOUTH, position.z);
		long bC = brighnessLerp(ForgeDirection.WEST, ForgeDirection.EAST, position.x);
		long sum = bA + bB + bC;
		return (int) (sum / 3);
	}

	private long brighnessLerp(ForgeDirection up, ForgeDirection down, double y2) {
		long a = this.neighborBrightness[up.ordinal()];
		long b = this.baseBrightness;
		long c = this.neighborBrightness[down.ordinal()];

		if (y2 < 0) {
			return (long) (a + (b - a) * -y2);
		} else if (y2 > 0) {
			return (long) (b + (c - b) * y2);
		}
		return b;
	}

	public TileEntity getBlockTileEntity() {
		return world.getBlockTileEntity(x, y, z);
	}

	public Icon getIcon(int i) {
		return block.getIcon(i, getBlockMetadata());
	}

	public int getBlockMetadata() {
		return world.getBlockMetadata(x, y, z);
	}
}

package ip.industrialProcessing.api.rendering.wavefront;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.ForgeDirection;

import org.lwjgl.util.vector.Vector3f;

public class WorldReference {
	public final IBlockAccess world;
	public final int x;
	public final int y;
	public final int z;
	public final Block block;
	public final int[][][] neighborBrightness;

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

		int baseBrightness = getBrightness(world, x, y, z, block);

		this.neighborBrightness = new int[3][3][3];

		getBrightnessCube(baseBrightness);
	}

	private void getBrightnessCube(int baseBrightness) {
		for (int x = -1; x <= 1; x++) {
			for (int y = -1; y <= 1; y++) {
				for (int z = -1; z <= 1; z++) {
					this.neighborBrightness[x + 1][y + 1][z + 1] = getBrightness(x, y, z, baseBrightness);
				}
			}
		}
	}

	protected int getBrightness(int dx, int dy, int dz, int baseBrightness) {
		Block other = block;
		// dy += 1;
		if (dx != 0 || dy != 0 || dz != 0) {
			int id = world.getBlockId(x + dx, y + dy, z + dz);
			other = Block.blocksList[id];
			if (other == null)
				return baseBrightness;
		} else
			return baseBrightness;
		return getBrightness(world, x + dx, y + dy, z + dz, other);
	}

	public int getBrightness(Vector3f position, Vector3f normal) {
		float dx = position.x + normal.x / 4f;
		float dy = position.y +0.25f+ normal.y / 4f;
		float dz = position.z + normal.z / 4f;

		/*
		 * long bA = brighnessLerp(ForgeDirection.DOWN, ForgeDirection.UP,
		 * position.y); long bB = brighnessLerp(ForgeDirection.NORTH,
		 * ForgeDirection.SOUTH, position.z); long bC =
		 * brighnessLerp(ForgeDirection.WEST, ForgeDirection.EAST, position.x);
		 */

		int[][] intermediate = new int[3][3];

		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				intermediate[x][y] = brighnessLerp(neighborBrightness[x][y][0], neighborBrightness[x][y][1], neighborBrightness[x][y][2], dz);
			}
		}

		int[] intermediate2 = new int[3];
		for (int x = 0; x < 3; x++) {
			intermediate2[x] = brighnessLerp(intermediate[x][0], intermediate[x][1], intermediate[x][2], dy - 0.5f);
		}

		return (int) brighnessLerp(intermediate2[0], intermediate2[1], intermediate2[2], dx);
	}

	private int brighnessLerp(int a, int b, int c, float lerp) {
		// int sa = a >> 20;
		// int ba = (a - (sa << 20)) >> 4;

		int sa = a >> 20 & 15;
		int sb = b >> 20 & 15;
		int sc = c >> 20 & 15;

		int ba = a >> 4 & 15;
		int bb = b >> 4 & 15;
		int bc = c >> 4 & 15;

		if (lerp < -1)
			lerp = -1;
		if (lerp > 1)
			lerp = 1;

		if (lerp < 0) {
			int sk = (int) (sb + (sa - sb) * -lerp) << 20;
			int bl = (int) (bb + (ba - bb) * -lerp) << 4;
			return sk | bl;
		} else if (lerp > 0) {
			int sk = (int) (sb + (sc - sb) * lerp) << 20;
			int bl = (int) (bb + (bc - bb) * lerp) << 4;
			return sk | bl;
		}
		return b;
	}

	public TileEntity getBlockTileEntity() {
		return world.getBlockTileEntity(x, y, z);
	}

	public Icon getIcon(int i) {
		return this.block.getIcon(i, getBlockMetadata());
	}

	public int getBlockMetadata() {
		return world.getBlockMetadata(x, y, z);
	}
}

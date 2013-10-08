package ip.industrialProcessing.decoration.trees;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenIndustrialTree extends WorldGenerator {

	private int blockLog;
	private int meta;
	private int blockLeaves;

	public WorldGenIndustrialTree(int blockLog, int blockLeaves, int meta) {
		this.blockLog = blockLog;
		this.blockLeaves = blockLeaves;
		this.meta = meta;
	}

	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {

		int height = random.nextInt(3) + 3;

		for (int i = 2; i < height + 2; i++) {
			float width = (height - i + 2) / 1.5f;
			if (i == 2)
				width -= 1.5f;
			int w = (int) width + 1;
			for (int tx = -w; tx <= w; tx++) {
				for (int tz = -w; tz <= w; tz++) {
					if (tx == 0 && tz == 0 && i <= height)
						continue;
					double dist = Math.sqrt(tx * tx + tz * tz);
					if (dist < width) {
						world.setBlock(x + tx, y + i, z + tz, this.blockLeaves);
						world.setBlockMetadataWithNotify(x + tx, y + i, z + tz, meta, 3);
					} else if (dist < width + 0.5) {
						if (random.nextGaussian() < 0.25) {
							world.setBlock(x + tx, y + i, z + tz, this.blockLeaves);
							world.setBlockMetadataWithNotify(x + tx, y + i, z + tz, meta, 3);
						}
					}
				}
			}
		}
		for (int i = 0; i < height; i++) {
			world.setBlock(x, y + i, z, this.blockLog);
			world.setBlockMetadataWithNotify(x, y + i, z, meta, 3);
		}
		return false;
	}

}

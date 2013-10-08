package ip.industrialProcessing.decoration.trees;

import java.util.Random;

import net.minecraft.block.Block;
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

        int maxHeight = random.nextInt(3) + 4;

        int height = 0;
        for (int i = 1; i <= maxHeight; i++) {

            int existingBlockId = world.getBlockId(x, y + i, z);
            Block block = Block.blocksList[existingBlockId];
            if (block == null || block.isBlockReplaceable(world, x, y + i, z)) {
                height = i - 1;
            } else
                break;
        } 
        if (height < 2)
            return false; 
        for (int i = 2; i < height + 2; i++) {
            float width = (height - i + 2) / 1.5f;
            if (i == 2)
                width -= 1.5f;
            int w = (int) width + 1;
            for (int tx = -w; tx <= w; tx++) {
                for (int tz = -w; tz <= w; tz++) {
                    if (tx == 0 && tz == 0 && i < height)
                        continue;
                    double dist = Math.sqrt(tx * tx + tz * tz);

                    int existingBlockId = world.getBlockId(x + tx, y + i, z + tz);
                    Block block = Block.blocksList[existingBlockId];
                    if (block == null || block.isBlockReplaceable(world, x + tx, y + i, z + tz)) {
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
        }
        for (int i = 0; i < height; i++) {
            world.setBlock(x, y + i, z, this.blockLog);
            world.setBlockMetadataWithNotify(x, y + i, z, meta, 3);
        }
        return true;
    }

}

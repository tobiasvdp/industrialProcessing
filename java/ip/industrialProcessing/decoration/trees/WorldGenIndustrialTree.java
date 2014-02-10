package ip.industrialProcessing.decoration.trees;

import ip.industrialProcessing.config.ConfigBlocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenIndustrialTree extends WorldGenerator {

    private int blockLog;
    private int leavesMeta;
    private int blockLeaves;
    private int blockBranch;
    private int minHeight;
    private int maxHeight;
    private float slope;
    private int logMeta;
    private int branchMeta;

    public static WorldGenIndustrialTree Create(int meta) {
        int blockLeaves = ConfigBlocks.getLeavesID();
        int block = ConfigBlocks.getLogID();
        int blockBranch = block;
        int logMeta = meta;
        switch (meta) {
        case 0:
            block = ConfigBlocks.getRubberLogID();
            blockBranch = 0;
            logMeta = 0;
            break;
        case 1:
            block = ConfigBlocks.getPineLogID();
            logMeta = 0;
            break;
        }

        float slope = IndustrialTrees.getSlope(meta);
        int minHeight = IndustrialTrees.getMinHeight(meta);
        int maxHeight = IndustrialTrees.getMaxHeight(meta);
        return new WorldGenIndustrialTree(block, blockBranch, blockLeaves, meta, logMeta, meta, slope, minHeight, maxHeight);
    }

    public WorldGenIndustrialTree(int blockLog, int blockBranch, int blockLeaves, int leavesMeta, int logMeta, int branchMeta, float slope, int minHeight, int maxHeight) {
        this.blockLog = blockLog;
        this.blockLeaves = blockLeaves;
        this.leavesMeta = leavesMeta;
        this.logMeta = logMeta;
        this.blockBranch = blockBranch;
        this.slope = slope;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.branchMeta = branchMeta;
    }

    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {

        int maxHeight = random.nextInt(this.maxHeight - this.minHeight) + this.minHeight;

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
            float width = (height - i + 2) / this.slope;
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
                            world.setBlockMetadataWithNotify(x + tx, y + i, z + tz, leavesMeta, 3);
                        } else if (dist < width + 0.5) {
                            if (random.nextGaussian() < 0.25) {
                                world.setBlock(x + tx, y + i, z + tz, this.blockLeaves);
                                world.setBlockMetadataWithNotify(x + tx, y + i, z + tz, leavesMeta, 3);
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < height; i++) {
            world.setBlock(x, y + i, z, this.blockLog);
            world.setBlockMetadataWithNotify(x, y + i, z, this.logMeta, 3);
        }
/*
        if (this.blockBranch > 0 && height > 3) {
            int branchCount = random.nextInt((height - 3) * 2);
            for (int i = 0; i < branchCount; i++) {
                int branchHeight = random.nextInt(height - 3) + 3;
                ForgeDirection branchDirection = ForgeDirection.getOrientation(random.nextInt(4) + 2);
                int branchLength = random.nextInt(Math.min(height - branchHeight + 1, branchHeight)) + 1;
                int bx = x;
                int by = y + branchHeight;
                int bz = z;

                double leaveLength = (height - branchHeight + 2) / this.slope;
                int w = (int) (leaveLength * 2 + 1);
                int h = (int) (branchLength / 2 + 1);
                for (int j = -w; j < w; j++) {
                    for (int dy = -h; dy < h; dy++) {
                        for (int l = 0; l < branchLength + 3; l++) {

                            int cx = branchDirection.offsetX * l;
                            int cy = 0;
                            int cz = branchDirection.offsetZ * l;

                            int lx = branchDirection.offsetZ * j;
                            int ly = dy;
                            int lz = branchDirection.offsetX * j;

                            double len = Math.sqrt(lx * lx + ly * ly + lz * lz);
                            int px = lx + cx + bx;
                            int py = ly + cy + by;
                            int pz = lz + cz + bz;

                            double diameter = (leaveLength - Math.abs(cx + cz) * leaveLength / branchLength) + 2.2f;
                            diameter += +2 * random.nextDouble() - 1;
                            if (len <= diameter) {

                                int existingBlockId = world.getBlockId(px, py, pz);
                                Block block = Block.blocksList[existingBlockId];
                                if (block == null || block.isBlockReplaceable(world, px, py, pz)) {
                                    world.setBlock(px, py, pz, this.blockLeaves);
                                    world.setBlockMetadataWithNotify(px, py, pz, leavesMeta, 3);
                                }
                            }
                        }
                    }
                }
                int typeMeta = branchMeta & 3;
                byte branchMeta = 0;

                switch (branchDirection.ordinal()) {
                case 0:
                case 1:
                    branchMeta = 0;
                    break;
                case 2:
                case 3:
                    branchMeta = 8;
                    break;
                case 4:
                case 5:
                    branchMeta = 4;
                }

                int blockMeta = typeMeta | branchMeta;
                for (int j = 0; j < branchLength; j++) {
                    bx += branchDirection.offsetX;
                    bz += branchDirection.offsetZ;
                    world.setBlock(bx, by, bz, this.blockBranch);
                    world.setBlockMetadataWithNotify(bx, by, bz, blockMeta, 3);
                }
                break;
            }
        }
            */
        return true;
    }
}

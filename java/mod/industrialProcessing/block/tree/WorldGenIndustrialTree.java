package mod.industrialProcessing.block.tree;

import java.util.Random;

import mod.industrialProcessing.block.ISetupBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.util.ForgeDirection;

public class WorldGenIndustrialTree extends WorldGenerator {

    private Block blockLog;
    private int leavesMeta;
    private Block blockLeaves;
    private Block blockBranch;
    private int minHeight;
    private int maxHeight;
    private float slope;
    private int logMeta;
    private int branchMeta;

    public static WorldGenIndustrialTree Create(int meta) {
        Block blockLeaves = ISetupBlocks.blockLeaves;
        Block block = ISetupBlocks.blockLog;
        Block blockBranch = block;
        int logMeta = meta;
        switch (meta) {
        case 0:
            block = ISetupBlocks.blockRubberLog;
            blockBranch = null;
            logMeta = 0;
            break;
        case 1:
            block = ISetupBlocks.blockPineLog;
            logMeta = 0;
            break;
        }

        float slope = IndustrialTrees.getSlope(meta);
        int minHeight = IndustrialTrees.getMinHeight(meta);
        int maxHeight = IndustrialTrees.getMaxHeight(meta);
        return new WorldGenIndustrialTree(block, blockBranch, blockLeaves, meta, logMeta, meta, slope, minHeight, maxHeight);
    }

    public WorldGenIndustrialTree(Block blockLog, Block blockBranch, Block blockLeaves, int leavesMeta, int logMeta, int branchMeta, float slope, int minHeight, int maxHeight) {
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

            Block block = world.getBlock(x, y + i, z);
            if (block == null || block.isReplaceable(world, x, y + i, z)) {
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

                    Block block = world.getBlock(x + tx, y + i, z + tz);
                    if (block == null || block.isReplaceable(world, x + tx, y + i, z + tz)) {
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

        if (this.blockBranch != null && height > 3) {
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

                                Block block = world.getBlock(px, py, pz);
                                if (block == null || block.isReplaceable(world, px, py, pz)) {
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
        return true;
    }
}

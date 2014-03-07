package ip.industrialProcessing.worldGen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;

public class OreLayer {

    private float scaleZ;
    private float scaleY;
    private float scaleX;
    private float fill;
    private int seed;
    private int lowYFadeLow = 0;
    private int lowYFadeHigh = 10;
    private int highYFadeHigh = 54;
    private int highYFadeLow = 64;
    private float terrainFalloffDistance;
    private Block block;
    private int metadata;
    private SimplexNoise simplexLayers;

    public OreLayer(Block block, int metadata) {
        this(1f, 0.125f, 1f, 0.5f, 0.33f, block.blockID ^ metadata, 0, 10, 54, 64, 10, 100, 4, block, metadata);
    }

    public OreLayer(float scaleX, float scaleY, float scaleZ, float roughness, float fill, int seed, int lowYFadeLow, int lowYFadeHigh, int highYFadeHigh, int highYFadeLow, int terrainFalloffDistance, int largestFeature, int smallestFeature, Block block, int metadata) {
        this.scaleX = scaleX;
        this.scaleY = scaleY;
        this.scaleZ = scaleZ;
        this.fill = fill;
        this.seed = seed;
        this.lowYFadeLow = lowYFadeLow;
        this.lowYFadeHigh = lowYFadeHigh;
        this.highYFadeHigh = highYFadeHigh;
        this.highYFadeLow = highYFadeLow;
        this.terrainFalloffDistance = terrainFalloffDistance;
        this.block = block;
        this.metadata = metadata;
        this.simplexLayers = new SimplexNoise(largestFeature, smallestFeature, roughness, seed);
    }

    public float sampleBlock(World world, int x, int y, int z, int height) {
        float falloff = sampleFalloff(y);
        if (falloff <= 0)
            return 0;
        if (terrainFalloffDistance > 0)
            falloff *= sampleTerrainFalloff(world, x, y, z, height);
        if (falloff <= 0)
            return 0;
        return falloff * simplex(simplexLayers, x, y, z) - fill;
    }

    private static float min = Float.POSITIVE_INFINITY;
    private static float max = Float.NEGATIVE_INFINITY;

    private float simplex(SimplexNoise simplex, int x, int y, int z) {
        float noise = simplex.getNoise(x / scaleX, y / scaleY, z / scaleZ);
        if (noise < min) {
            System.out.println("Min: " + noise);
            min = noise;
        }
        if (noise > max) {
            max = noise;
            System.out.println("Max:" + noise + "  " + (noise - fill) + " f:" + fill);
        }
        return noise;
    }

    private float sampleTerrainFalloff(World world, int x, int y, int z, int worldYMax) {
        float worldYMin = worldYMax - terrainFalloffDistance;
        if (y > worldYMax)
            return 0;
        if (y < worldYMin)
            return 1;
        return 1 - (y - worldYMin) / terrainFalloffDistance;
    }

    private float sampleFalloff(int y) {
        if (y < lowYFadeLow)
            return 0;
        if (y > highYFadeLow)
            return 0;

        if (y > lowYFadeHigh) {
            if (y < highYFadeHigh) {
                // center area
                return 1;
            } else {
                // top fadeout
                return 1 - (y - highYFadeHigh) / (float) (highYFadeLow - highYFadeHigh);
            }
        } else {
            // bottom fadeout
            return (y - lowYFadeLow) / (float) (lowYFadeHigh - lowYFadeLow);
        }
    }

    public void placeBlock(World world, int x, int y, int z) {
        world.setBlock(x, y + 128, z, block.blockID, metadata, 4); // flag 4:
                                                                   // don't
        // rerender
    }

    public void editChunk(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkProvider, IChunkProvider chunkGenerator, int x, int y, int z) {

        Chunk chunk = world.getChunkFromBlockCoords(x, z);
        if (chunk != null) {
            int id = chunk.getBlockID(x & 15, y, z & 15);
            if (random.nextBoolean() || id == Block.stone.blockID) {
                chunk.setBlockIDWithMetadata(x & 15, y, z & 15, block.blockID, metadata);
            }
        }
    }

}

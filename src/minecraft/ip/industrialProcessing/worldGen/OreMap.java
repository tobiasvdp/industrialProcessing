package ip.industrialProcessing.worldGen;

import ip.industrialProcessing.subMod.logic.old.transport.blockLogic;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

public class OreMap {
    private ArrayList<OreLayer> layers = new ArrayList<OreLayer>();
    private float minimum;

    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        int offsetX = chunkX * 16;
        int offsetZ = chunkZ * 16;
        int size = 4;
        for (int x = offsetX + size / 2; x <= offsetX + 16 - size+1; x += size) {
            for (int z = offsetZ + size / 2; z <= offsetZ + 16 - size+1; z += size) {
                int height = 64;// world.getTopSolidOrLiquidBlock(x, z);
                for (int y = 1 + size / 2; y <= height - size / 2; y++) {
                    OreLayer layer = getLayer(x, y, z, height, world);
                    if (layer != null) {
                        for (int dx = -size / 2; dx <= size / 2; dx++) {
                            for (int dy = -size / 2; dy <= size / 2; dy++) {
                                for (int dz = -size / 2; dz <= size / 2; dz++) {
                                    layer.editChunk(random, chunkX, chunkZ, world, chunkProvider, chunkGenerator, x + dx, y + dy, z + dz);
                                }
                            } 
                        }
                    }
                }
            }
        }
    }

    private OreLayer getLayer(int x, int y, int z, int height, World world) {
        float bestSample = 0;
        OreLayer bestLayer = null;
        for (int i = 0; i < layers.size(); i++) {
            OreLayer layer = layers.get(i);
            float sample = layer.sampleBlock(world, x, y, z, height);
            if (sample > bestSample) {
                bestSample = sample;
                bestLayer = layer;
            }
        }
        if (bestSample > 0)
            return bestLayer;
        return null;
    }

    public void addLayer(OreLayer layer) {
        this.layers.add(layer);
    }

    public void clear() {
        this.layers.clear();
    }
}

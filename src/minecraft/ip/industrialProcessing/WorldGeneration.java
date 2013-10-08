package ip.industrialProcessing;

import ip.industrialProcessing.config.ConfigBlocks;
import ip.industrialProcessing.config.ISetupBlocks;
import ip.industrialProcessing.decoration.trees.IndustrialTrees;
import ip.industrialProcessing.decoration.trees.WorldGenIndustrialTree;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.event.terraingen.TerrainGen;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGeneration implements IWorldGenerator {

    private WorldGenIndustrialTree[] treeGenerators;

    public WorldGeneration() {
        this.treeGenerators = new WorldGenIndustrialTree[IndustrialTrees.getTreeCount()];
        for (int i = 0; i < treeGenerators.length; i++) {
            int block = i == 0 ? ConfigBlocks.getRubberLogID() : ConfigBlocks.getLogID();
            this.treeGenerators[i] = new WorldGenIndustrialTree(block, ConfigBlocks.getLeavesID(), i);
        }
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        generateOre(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider, 3, 6, 40, 60, 2, 4, ISetupBlocks.blockTinOre.blockID);
        generateOre(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider, 2, 5, 30, 60, 2, 4, ISetupBlocks.blockCopperOre.blockID);
        generateOre(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider, 1, 3, 5, 40, 1, 3, ISetupBlocks.blockGalenaOre.blockID);
        generateOre(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider, 2, 3, 10, 60, 1, 3, ISetupBlocks.blockCinnebarOre.blockID);
        generateOre(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider, 1, 4, 1, 8, 2, 3, ISetupBlocks.blockRutileOre.blockID);
        generateOre(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider, 1, 2, 1, 40, 1, 3, ISetupBlocks.blockChromiteOre.blockID);
        generateOre(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider, 1, 1, 1, 20, 1, 1, ISetupBlocks.blockTaliaOre.blockID);

        generateTree(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
    }

    private void generateTree(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

        int x = chunkX * 16;
        int z = chunkZ * 16;

        int treeCount = 10;
        for (int i = 0; i < treeCount; i++) {

            int sX = x + random.nextInt(8) + 4;
            int sZ = z + random.nextInt(8) + 4;
            BiomeGenBase biome = world.getBiomeGenForCoords(sX, sZ);

            int max = 0;

            if (biome.isHighHumidity())
                max+=2;
            if (biome.rainfall > 1)
                max++;
            if (biome.canSpawnLightningBolt())
                max++;

            double gaussian = random.nextGaussian() * max;

            if (gaussian > 2f) {

                int sY = world.getTopSolidOrLiquidBlock(sX, sZ);

                int meta = random.nextInt(this.treeGenerators.length);
                if (!TerrainGen.saplingGrowTree(world, random, sX, sY, sZ))
                    return;

                int block = world.getBlockId(sX, sY - 1, sZ);
                if (block != Block.grass.blockID)
                    return;
                this.treeGenerators[meta].generate(world, random, sX, sY, sZ);
            }
        }
    }

    private boolean generateOre(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider, int minSpawn, int maxSpawn, int minLayer, int maxLayer, int minAmount, int maxAmount, int oreID) {
        // times to place in chunk
        int rep;
        if (maxSpawn != minSpawn) {
            rep = maxSpawn - random.nextInt(maxSpawn - minSpawn);
        } else {
            rep = maxSpawn;
        }
        int count = 0;

        for (int i = 0; i < rep; i++) {
            // get random coordinate
            int x = chunkX * 16 + random.nextInt(16);
            int y;
            if (maxLayer != minLayer) {
                y = maxLayer - random.nextInt(maxLayer - minLayer);
            } else {
                y = maxLayer;
            }
            int z = chunkZ * 16 + random.nextInt(16);

            // check if id is replaceable
            boolean isReplacable = false;
            int blockId = world.getBlockId(x, y, z);
            if (blockId == 1 || blockId == 3 || blockId == 13) {
                isReplacable = true;
            }

            // replace if possible
            if (isReplacable) {
                world.setBlock(x, y, z, oreID);
            } else {
                if (count < 50) {
                    i--;
                }
                count++;
            }

            // amount of surrounding ores
            int surround;
            if (maxAmount != minAmount) {
                surround = maxAmount - random.nextInt(maxAmount - minAmount);
            } else {
                surround = maxAmount;
            }

            // generate surrounding ores
            if (isReplacable) {
                for (int a = 0; a < surround; a++) {
                    int side = random.nextInt(6);
                    switch (side) {
                    case 0:
                        y = y + 1;
                        break;
                    case 1:
                        y = y - 1;
                        break;
                    case 2:
                        x = x + 1;
                        break;
                    case 3:
                        x = x - 1;
                        break;
                    case 4:
                        z = z + 1;
                        break;
                    case 5:
                        z = z - 1;
                        break;
                    default:
                        break;
                    }
                    if (blockId == 1 || blockId == 3 || blockId == 13) {
                        world.setBlock(x, y, z, oreID);
                    }
                }
            }
        }
        return true;
    }

}

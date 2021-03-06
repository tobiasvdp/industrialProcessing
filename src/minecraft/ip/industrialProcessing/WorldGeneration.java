package ip.industrialProcessing;

import ip.industrialProcessing.config.ISetupBlocks;
import ip.industrialProcessing.decoration.trees.IndustrialTrees;
import ip.industrialProcessing.decoration.trees.WorldGenIndustrialTree;
import ip.industrialProcessing.worldGen.OreLayer;
import ip.industrialProcessing.worldGen.OreMap;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable;
import net.minecraftforge.event.terraingen.TerrainGen;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGeneration implements IWorldGenerator {

    private WorldGenIndustrialTree[] treeGenerators;
    private OreMap map;

    public WorldGeneration() {
        this.treeGenerators = new WorldGenIndustrialTree[IndustrialTrees.getTreeCount()];
        for (int i = 0; i < treeGenerators.length; i++) {
            this.treeGenerators[i] = WorldGenIndustrialTree.Create(i, false);
        }
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

        if (map == null)
            map = generateMap(world);

        map.generate(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);

        /*
         * generateOre(random, chunkX, chunkZ, world, chunkGenerator,
         * chunkProvider, 20, 25, 30, 60, 2, 4,
         * ISetupBlocks.blockTinOre.blockID); generateOre(random, chunkX,
         * chunkZ, world, chunkGenerator, chunkProvider, 22, 27, 25, 60, 2, 4,
         * ISetupBlocks.blockCopperOre.blockID); generateOre(random, chunkX,
         * chunkZ, world, chunkGenerator, chunkProvider, 12, 14, 5, 40, 1, 3,
         * ISetupBlocks.blockGalenaOre.blockID); generateOre(random, chunkX,
         * chunkZ, world, chunkGenerator, chunkProvider, 7, 10, 10, 60, 1, 3,
         * ISetupBlocks.blockCinnebarOre.blockID); generateOre(random, chunkX,
         * chunkZ, world, chunkGenerator, chunkProvider, 6, 8, 1, 8, 2, 3,
         * ISetupBlocks.blockRutileOre.blockID); generateOre(random, chunkX,
         * chunkZ, world, chunkGenerator, chunkProvider, 7, 10, 1, 40, 1, 3,
         * ISetupBlocks.blockChromiteOre.blockID); generateOre(random, chunkX,
         * chunkZ, world, chunkGenerator, chunkProvider, 1, 1, 1, 20, 1, 1,
         * ISetupBlocks.blockTaliaOre.blockID); generateOre(random, chunkX,
         * chunkZ, world, chunkGenerator, chunkProvider, 20, 30, 30, 85, 6, 10,
         * ISetupBlocks.blockLimestone.blockID); generateOre(random, chunkX,
         * chunkZ, world, chunkGenerator, chunkProvider, 15, 25, 0, 85, 6, 10,
         * ISetupBlocks.blockBauxiteOre.blockID);
         */
        generateTree(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
    }

    private OreMap generateMap(World world) {
        Random random = new Random(world.getSeed());
        float scaleX = 2f;
        float scaleY = 0.25f; // many flat layers of ore
        float scaleZ = 2f;
        float roughness = 0.65f; // influence of higher frequency noise.
        int featureSize = 110;
        map = new OreMap();
        map.addLayer(new OreLayer(scaleX, scaleY * 2, scaleZ, roughness, 0.35f, random.nextInt(), 0, 1, 256, 128, 10, featureSize, 1, Block.dirt, 0));
        map.addLayer(new OreLayer(scaleX, scaleY * 2, scaleZ, roughness, 0.45f, random.nextInt(), 0, 1, 256, 128, 10, featureSize, 1, Block.gravel, 0));

        map.addLayer(new OreLayer(scaleX, scaleY, scaleZ, roughness, 0.45f, random.nextInt(), 0, 1, 256, 128, 10, featureSize, 1, Block.oreCoal, 0));

        map.addLayer(new OreLayer(scaleX, scaleY, scaleZ, roughness, 0.60f, random.nextInt(), 0, 1, 256, 128, 10, featureSize, 4, Block.oreGold, 0));
        map.addLayer(new OreLayer(scaleX, scaleY, scaleZ, roughness, 0.50f, random.nextInt(), 0, 1, 256, 128, 10, featureSize, 4, Block.oreIron, 0));

        map.addLayer(new OreLayer(scaleX, scaleY, scaleZ, roughness, 0.55f, random.nextInt(), 0, 1, 40, 30, 10, featureSize, 4, Block.oreDiamond, 0));

        map.addLayer(new OreLayer(scaleX, scaleY, scaleZ, roughness, 0.60f, random.nextInt(), 0, 1, 128, 64, 10, featureSize, 1, Block.oreEmerald, 0));

        map.addLayer(new OreLayer(scaleX, scaleY, scaleZ, roughness, 0.55f, random.nextInt(), 0, 1, 256, 128, 10, featureSize, 4, IndustrialProcessing.blockBauxiteOre, 0));
        map.addLayer(new OreLayer(scaleX, scaleY, scaleZ, roughness, 0.55f, random.nextInt(), 0, 1, 256, 128, 10, featureSize, 4, IndustrialProcessing.blockChromiteOre, 0));
        map.addLayer(new OreLayer(scaleX, scaleY, scaleZ, roughness, 0.55f, random.nextInt(), 0, 1, 256, 128, 10, featureSize, 4, IndustrialProcessing.blockCinnebarOre, 0));
        map.addLayer(new OreLayer(scaleX, scaleY, scaleZ, roughness, 0.55f, random.nextInt(), 0, 1, 256, 128, 10, featureSize, 4, IndustrialProcessing.blockCopperOre, 0));
        map.addLayer(new OreLayer(scaleX, scaleY, scaleZ, roughness, 0.55f, random.nextInt(), 0, 1, 256, 128, 10, featureSize, 4, IndustrialProcessing.blockGalenaOre, 0));
        map.addLayer(new OreLayer(scaleX, scaleY, scaleZ, roughness, 0.55f, random.nextInt(), 0, 1, 256, 128, 10, featureSize, 4, IndustrialProcessing.blockRutileOre, 0));
        map.addLayer(new OreLayer(scaleX, scaleY, scaleZ, roughness, 0.55f, random.nextInt(), 0, 1, 256, 128, 10, featureSize, 4, IndustrialProcessing.blockTaliaOre, 0));
        map.addLayer(new OreLayer(scaleX, scaleY, scaleZ, roughness, 0.55f, random.nextInt(), 0, 1, 256, 128, 10, featureSize, 4, IndustrialProcessing.blockTinOre, 0));

        return map;
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
                max += 2;
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
        chunkX = chunkX * 16;
        chunkZ = chunkZ * 16;
        int spawnAmount = maxSpawn - random.nextInt(maxSpawn - minSpawn + 1);
        WorldGenMinable gen = new WorldGenMinable(oreID, maxAmount);
        if (TerrainGen.generateOre(world, random, gen, chunkX, chunkZ, GenerateMinable.EventType.CUSTOM))
            this.genStandardOre(spawnAmount, gen, minLayer, maxLayer, world, chunkX, chunkZ, random);
        return true;
    }

    protected void genStandardOre(int par1, WorldGenerator par2WorldGenerator, int par3, int par4, World world, int chunk_X, int chunk_Z, Random randomGenerator) {
        for (int l = 0; l < par1; ++l) {
            int i1 = chunk_X + randomGenerator.nextInt(16);
            int j1 = randomGenerator.nextInt(par4 - par3) + par3;
            int k1 = chunk_Z + randomGenerator.nextInt(16);
            par2WorldGenerator.generate(world, randomGenerator, i1, j1, k1);
        }
    }
}

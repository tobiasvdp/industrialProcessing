package ip.industrialProcessing;

import ip.industrialProcessing.config.ConfigBlocks;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraftforge.common.ForgeDirection;

public class WorldGeneration implements IWorldGenerator {

	public WorldGeneration() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		// copper ore
		int maxSpawn = 6;
		int minSpawn = 3;
		int rep = maxSpawn - random.nextInt(maxSpawn - minSpawn);
		int minLayer = 30;
		int maxLayer = 50;
		for (int i = 0; i < 5; i++) {
			int x = chunkX * 16 + random.nextInt(16);
			int y = maxLayer - random.nextInt(maxLayer - minLayer);
			int z = chunkZ * 16 + random.nextInt(16);
			int blockId = world.getBlockId(x, y, z);
			if (blockId == 1 || blockId == 3 || blockId == 13) {
				world.setBlock(x, y, z, ConfigBlocks.BlockCopperOreID());
				int group = random.nextInt(10);
				switch (group) {
				case 0:
				case 1:
				case 2:
					group = 1;
					break;
				case 3:
				case 4:
				case 5:
				case 6:
					group = 2;
					break;
				default:
					group = 3;
					break;
				}
				for (int a = 0; a < group; a++) {
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
						world.setBlock(x, y, z, ConfigBlocks.BlockCopperOreID());
					}
				}
			}
		}
		// tin ore
		maxSpawn = 6;
		minSpawn = 3;
		rep = maxSpawn - random.nextInt(maxSpawn - minSpawn);
		minLayer = 30;
		maxLayer = 50;
		for (int i = 0; i < 5; i++) {
			int x = chunkX * 16 + random.nextInt(16);
			int y = maxLayer - random.nextInt(maxLayer - minLayer);
			int z = chunkZ * 16 + random.nextInt(16);
			int blockId = world.getBlockId(x, y, z);
			if (blockId == 1 || blockId == 3 || blockId == 13) {
				world.setBlock(x, y, z, ConfigBlocks.BlockTinOreID());
				int group = random.nextInt(10);
				switch (group) {
				case 0:
				case 1:
				case 2:
					group = 1;
					break;
				case 3:
				case 4:
				case 5:
				case 6:
					group = 2;
					break;
				default:
					group = 3;
					break;
				}
				for (int a = 0; a < group; a++) {
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
						world.setBlock(x, y, z, ConfigBlocks.BlockTinOreID());
					}
				}
			}
		}
	}

}

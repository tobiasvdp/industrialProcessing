package ip.industrialProcessing.buildingBlock;

import ip.industrialProcessing.IndustrialProcessing;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.item.Item;

public class BlockOreIP extends BlockOre {

	public BlockOreIP(int par1) {
		super(par1);
	}

	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	public int idDropped(int par1, Random par2Random, int par3) {
		if (this.blockID == IndustrialProcessing.blockCinnebarOre.blockID) {
			return IndustrialProcessing.itemCinnebarCrystals.itemID;
		}
		if (this.blockID == IndustrialProcessing.blockRutileOre.blockID) {
			return IndustrialProcessing.itemRutileCrystals.itemID;
		}
		return super.idDropped(par1, par2Random, par3);
	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	public int quantityDropped(Random par1Random) {
		if (this.blockID == IndustrialProcessing.blockCinnebarOre.blockID) {
			return par1Random.nextInt(6);
		}
		if (this.blockID == IndustrialProcessing.blockRutileOre.blockID) {
			return par1Random.nextInt(4);
		}
		return super.quantityDropped(par1Random);
	}

}

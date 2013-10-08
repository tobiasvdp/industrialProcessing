package ip.industrialProcessing.buildingBlock;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.utils.ItemTransfers;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockOreIP extends BlockOre {

	public BlockOreIP(int par1) {
		super(par1);
	}
	
	@Override
	public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6) {
		super.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
		if (this.blockID == IndustrialProcessing.blockCinnebarOre.blockID) {
			Random random = new Random();
			ItemTransfers.launch(new ItemStack(IndustrialProcessing.itemCinnebarLargeCrushedCrystals,random.nextInt(2)), par1World, par3, par4, par5, random.nextFloat()/2, random.nextFloat()/2, random.nextFloat()/2);
			ItemTransfers.launch(new ItemStack(IndustrialProcessing.itemCinnebarSmallCrushedCrystals,random.nextInt(3)), par1World, par3, par4, par5, random.nextFloat()/2, random.nextFloat()/2, random.nextFloat()/2);
			par1World.setBlock(par3, par4, par5, IndustrialProcessing.blockCinnebar.blockID);
		}
		if (this.blockID == IndustrialProcessing.blockRutileOre.blockID) {
			Random random = new Random();
			ItemTransfers.launch(new ItemStack(IndustrialProcessing.itemRutileLargeCrushedCrystals,random.nextInt(1)), par1World, par3, par4, par5, random.nextFloat()/2, random.nextFloat()/2, random.nextFloat()/2);
			ItemTransfers.launch(new ItemStack(IndustrialProcessing.itemRutileSmallCrushedCrystals,random.nextInt(2)), par1World, par3, par4, par5, random.nextFloat()/2, random.nextFloat()/2, random.nextFloat()/2);
			par1World.setBlock(par3, par4, par5, IndustrialProcessing.blockRutile.blockID);
		}
	}

	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	public int idDropped(int par1, Random par2Random, int par3) {
		return Block.cobblestone.blockID;
	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	public int quantityDropped(Random par1Random) {
		return 1;
	}

}

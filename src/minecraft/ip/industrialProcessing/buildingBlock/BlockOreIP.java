package ip.industrialProcessing.buildingBlock;

import ip.industrialProcessing.config.ISetupBlocks;
import ip.industrialProcessing.config.ISetupItems;
import ip.industrialProcessing.utils.ItemTransfers;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockOreIP extends BlockOre {

	public BlockOreIP(int par1) {
		super(par1);
	}
	
	@Override
	public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6) {
		super.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
		if (this.blockID == ISetupBlocks.blockCinnebarOre.blockID) {
			Random random = new Random();
			ItemTransfers.launch(new ItemStack(ISetupItems.itemCinnebarLargeCrushedCrystals,random.nextInt(2)), par1World, par3, par4, par5, random.nextFloat()/2, random.nextFloat()/2, random.nextFloat()/2);
			ItemTransfers.launch(new ItemStack(ISetupItems.itemCinnebarSmallCrushedCrystals,random.nextInt(3)), par1World, par3, par4, par5, random.nextFloat()/2, random.nextFloat()/2, random.nextFloat()/2);
			par1World.setBlock(par3, par4, par5, ISetupBlocks.blockCinnebar.blockID);
		}
		if (this.blockID == ISetupBlocks.blockRutileOre.blockID) {
			Random random = new Random();
			ItemTransfers.launch(new ItemStack(ISetupItems.itemRutileLargeCrushedCrystals,random.nextInt(1)), par1World, par3, par4, par5, random.nextFloat()/2, random.nextFloat()/2, random.nextFloat()/2);
			ItemTransfers.launch(new ItemStack(ISetupItems.itemRutileSmallCrushedCrystals,random.nextInt(2)), par1World, par3, par4, par5, random.nextFloat()/2, random.nextFloat()/2, random.nextFloat()/2);
			par1World.setBlock(par3, par4, par5, ISetupBlocks.blockRutile.blockID);
		}
	}

	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return Block.cobblestone.blockID;
	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	@Override
	public int quantityDropped(Random par1Random) {
		return 1;
	}

}

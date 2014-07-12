package mod.industrialProcessing.block.ore;

import java.util.Random;

import mod.industrialProcessing.block.ISetupBlocks;
import mod.industrialProcessing.items.ISetupItems;
import mod.industrialProcessing.utils.inventory.ItemTransfers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockIPOre extends BlockOre {

	public BlockIPOre() {
		super();
	}

	@Override
	public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6) {
		super.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
		if (this == ISetupBlocks.blockCinnebarOre) {
			Random random = new Random();
			ItemTransfers.launch(new ItemStack(ISetupItems.itemCinnebarLargeCrushedCrystals, random.nextInt(2)), par1World, par3, par4, par5, random.nextFloat() / 2, random.nextFloat() / 2, random.nextFloat() / 2);
			ItemTransfers.launch(new ItemStack(ISetupItems.itemCinnebarSmallCrushedCrystals, random.nextInt(3)), par1World, par3, par4, par5, random.nextFloat() / 2, random.nextFloat() / 2, random.nextFloat() / 2);
			par1World.setBlock(par3, par4, par5, ISetupBlocks.blockCinnebar);
		}
		if (this == ISetupBlocks.blockRutileOre) {
			Random random = new Random();
			ItemTransfers.launch(new ItemStack(ISetupItems.itemRutileLargeCrushedCrystals, random.nextInt(1)), par1World, par3, par4, par5, random.nextFloat() / 2, random.nextFloat() / 2, random.nextFloat() / 2);
			ItemTransfers.launch(new ItemStack(ISetupItems.itemRutileSmallCrushedCrystals, random.nextInt(2)), par1World, par3, par4, par5, random.nextFloat() / 2, random.nextFloat() / 2, random.nextFloat() / 2);
			par1World.setBlock(par3, par4, par5, ISetupBlocks.blockRutile);
		}
	}

	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		return Item.getItemFromBlock(Block.getBlockFromName("coble"));
	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	@Override
	public int quantityDropped(Random par1Random) {
		return 1;
	}

}

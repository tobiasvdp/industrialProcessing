package mod.industrialProcessing.items;

import mod.industrialProcessing.blocks.ISetupBlocks;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class ItemMicroBlock extends ItemIP {

	public int microblock;
	public MicroBlockType type;
	public int level;
	public String tileEntity;

	public ItemMicroBlock(String name, CreativeTabs tab, int microblock, MicroBlockType type, String tileEntity,int level) {
		super(name, tab);
		this.microblock = microblock;
		this.type = type;
		this.level = level;
		this.tileEntity = tileEntity;
	}

	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {

		ForgeDirection dir = BlockMicroBlock.sideToForge(par7);
		if (canPlaceBlockAt(par3World, par4 + dir.offsetX, par5 + dir.offsetY, par6 + dir.offsetZ)) {
			par3World.setBlock(par4 + dir.offsetX, par5 + dir.offsetY, par6 + dir.offsetZ, ISetupBlocks.microBlock);
			par3World.setBlockMetadataWithNotify(par4 + dir.offsetX, par5 + dir.offsetY, par6 + dir.offsetZ, BlockMicroBlock.invertSide(par7), 0);
			ISetupBlocks.microBlock.onBlockPlacedBy(par3World, par4 + dir.offsetX, par5 + dir.offsetY, par6 + dir.offsetZ, par2EntityPlayer, par1ItemStack);
		}
		return super.onItemUse(par1ItemStack, par2EntityPlayer, par3World, par4, par5, par6, par7, par8, par9, par10);
	}

	public boolean canPlaceBlockAt(World par1World, int x, int y, int z) {
		boolean canPlace = true;
		Block block = par1World.getBlock(x, y, z);
		if (block != null) {
			if (!block.isReplaceable(par1World, x, y, z))
				canPlace = false;
		}
		return canPlace;
	}

	public boolean isValidPlacingSide(ForgeDirection dir, World worldObj, int xCoord, int yCoord, int zCoord, ItemMicroBlock itemMicroBlock) {
		return true;
	}

	public String getTileEntityName() {
		return tileEntity;
	}

}

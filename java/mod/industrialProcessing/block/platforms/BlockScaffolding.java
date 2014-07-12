package mod.industrialProcessing.block.platforms;

import mod.industrialProcessing.block.BlockIPRendered;
import mod.industrialProcessing.blockContainer.BlockContainerIP;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockScaffolding extends BlockIPRendered {

	public BlockScaffolding(float hardness, float resistance, Material par2Material, SoundType stepSound) {
		super(hardness, resistance, par2Material, stepSound);
	}

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {

		ItemStack stack = par5EntityPlayer.inventory.getCurrentItem();
		if (stack != null) {
			Block placed = Block.getBlockFromItem(stack.getItem());
			if (placed != null) {
				if (placed instanceof BlockScaffolding) {
					int dir = MathHelper.floor_double((par5EntityPlayer.rotationYaw * 4F) / 360F + 0.5D) & 3;
					ForgeDirection placeTarget = BlockContainerIP.getForwardFromMetadata(dir).getOpposite();

					if (placeScaffolding(par1World, par2, par3, par4, stack, placeTarget, par5EntityPlayer, 0)) {
						if (!par5EntityPlayer.capabilities.isCreativeMode) {
							stack.stackSize--;
							if (stack.stackSize <= 0)
								par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, null);
							return true;
						}
					}
				}
			}
		}

		return super.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9);
	}

	protected boolean placeScaffolding(World par1World, int x, int y, int z, ItemStack stack, ForgeDirection placeTarget, EntityPlayer par5EntityPlayer, int distance) {

		if (distance > 5)
			return false;

		int tx = x + placeTarget.offsetX;
		int ty = y + placeTarget.offsetY;
		int tz = z + placeTarget.offsetZ;

		Block block = par1World.getBlock(tx, ty, tz);
		if (block instanceof BlockScaffolding) {
			BlockScaffolding scaffold = (BlockScaffolding) block;
			return scaffold.placeScaffolding(par1World, tx, ty, tz, stack, placeTarget, par5EntityPlayer, distance++);
		}
		return stack.tryPlaceItemIntoWorld(par5EntityPlayer, par1World, tx, ty + 1, tz, 0, 0, 0, 0);
	}

}

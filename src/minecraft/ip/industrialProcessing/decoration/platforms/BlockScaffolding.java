package ip.industrialProcessing.decoration.platforms;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.decoration.BlockDecoration;
import ip.industrialProcessing.machines.BlockMachine;

public class BlockScaffolding extends BlockDecoration {

	public BlockScaffolding(int par1, Material par2Material, float hardness, StepSound stepSound, String name, CreativeTabs tab) {
		super(par1, par2Material, hardness, stepSound, name, tab);
	}

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {

		ItemStack stack = par5EntityPlayer.inventory.getCurrentItem();
		if (stack != null) {
			if (stack.itemID < blocksList.length) {

				Block placed = blocksList[stack.itemID];
				if (placed instanceof BlockScaffolding) {
					int dir = MathHelper.floor_double((double) ((par5EntityPlayer.rotationYaw * 4F) / 360F) + 0.5D) & 3;
					ForgeDirection placeTarget = BlockMachine.getForwardFromMetadata(dir).getOpposite();

					if (placeScaffolding(par1World, par2, par3, par4, stack, placeTarget, par5EntityPlayer, 0)) {
						if(!par5EntityPlayer.capabilities.isCreativeMode){
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

		int blockID = par1World.getBlockId(tx, ty, tz);
		Block block = blocksList[blockID];
		if (block instanceof BlockScaffolding) {
			BlockScaffolding scaffold = (BlockScaffolding) block;
			return scaffold.placeScaffolding(par1World, tx, ty, tz, stack, placeTarget, par5EntityPlayer, distance++);
		}
		return stack.tryPlaceItemIntoWorld(par5EntityPlayer, par1World, tx, ty + 1, tz, 0, 0, 0, 0);
	}

}

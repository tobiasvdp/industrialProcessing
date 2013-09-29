package ip.industrialProcessing.buildingBlock;

import java.util.Random;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.items.ItemIP;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockIP extends Block {
	boolean dropItems = false;
	ItemIP dropItem;

	public BlockIP(int blockID, String name, float hardness, Material blockMaterial, StepSound stepSound) {
		super(blockID, blockMaterial);
		setHardness(hardness);
		setStepSound(stepSound);
		setUnlocalizedName(name);
		setCreativeTab(IndustrialProcessing.tabPower);
		func_111022_d(IndustrialProcessing.TEXTURE_NAME_PREFIX + name);
	}

	public BlockIP(int blockID, String name, float hardness, Material blockMaterial, StepSound stepSound, ItemIP dropitem) {
		super(blockID, blockMaterial);
		setHardness(hardness);
		setStepSound(stepSound);
		setUnlocalizedName(name);
		setCreativeTab(IndustrialProcessing.tabOres);
		func_111022_d(IndustrialProcessing.TEXTURE_NAME_PREFIX + name);
		this.dropItems = true;
		this.dropItem = dropitem;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack) {
		int dir = MathHelper.floor_double((double) ((entityLivingBase.rotationYaw * 4F) / 360F) + 0.5D) & 3;
		world.setBlockMetadataWithNotify(x, y, z, dir, 0);
		super.onBlockPlacedBy(world, x, y, z, entityLivingBase, itemStack);
	}

	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		if (this.dropItems) {
			return this.dropItem.itemID;
		}
		return super.idDropped(par1, par2Random, par3);
	}

}

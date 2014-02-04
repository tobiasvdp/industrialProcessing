package ip.industrialProcessing.buildingBlock;

import java.util.Random;

import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockIP extends Block {
	boolean dropItems = false;
	int dropItem;

	public BlockIP(int blockID, String name, float hardness, Material blockMaterial, StepSound stepSound) {
		super(blockID, blockMaterial);
		setHardness(hardness);
		setStepSound(stepSound);
		setUnlocalizedName(name);
		setCreativeTab(ISetupCreativeTabs.tabPower);
		setTextureName(INamepace.TEXTURE_NAME_PREFIX + name);
	}

	public BlockIP(int blockID, String name, float hardness, Material blockMaterial, StepSound stepSound, int dropitem) {
		super(blockID, blockMaterial);
		setHardness(hardness);
		setStepSound(stepSound);
		setUnlocalizedName(name);
		setCreativeTab(ISetupCreativeTabs.tabOres);
		setTextureName(INamepace.TEXTURE_NAME_PREFIX + name);
		this.dropItems = true;
		this.dropItem = dropitem;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack) {
		int dir = MathHelper.floor_double((entityLivingBase.rotationYaw * 4F) / 360F + 0.5D) & 3;
		world.setBlockMetadataWithNotify(x, y, z, dir, 0);
		super.onBlockPlacedBy(world, x, y, z, entityLivingBase, itemStack);
	}

	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		if (this.dropItems) {
			return this.dropItem;
		}
		return super.idDropped(par1, par2Random, par3);
	}

}

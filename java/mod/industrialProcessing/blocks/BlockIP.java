package mod.industrialProcessing.blocks;

import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import mod.industrialProcessing.utils.INamepace;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockIP extends Block {
	boolean dropItems = false;
	Item dropItem;

	public BlockIP(String name, float hardness, Material blockMaterial, SoundType stepSound) {
		super(blockMaterial);
		setHardness(hardness);
		setStepSound(stepSound);
		setBlockTextureName(INamepace.TEXTURE_NAME_PREFIX + name);
		GameRegistry.registerBlock(this, name);
	}

	public BlockIP(String name, float hardness, Material blockMaterial, SoundType stepSound, Item dropitem) {
		super(blockMaterial);
		setHardness(hardness);
		setStepSound(stepSound);
		setBlockTextureName(INamepace.TEXTURE_NAME_PREFIX + name);
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
	public Item getItemDropped(int par1, Random par2Random, int par3) {
		if (this.dropItems) {
			return this.dropItem;
		}
		return super.getItemDropped(par1, par2Random, par3);
	}

}

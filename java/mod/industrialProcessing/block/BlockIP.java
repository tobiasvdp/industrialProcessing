package mod.industrialProcessing.block;

import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import mod.industrialProcessing.utils.INamepace;
import mod.industrialProcessing.utils.block.IDescriptionBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockIP extends Block implements IDescriptionBlock{
	boolean dropItems = false;
	Item dropItem;

	public BlockIP(float hardness, float resistance, Material material, SoundType soundtype) {
		super(material);
		setHardness(hardness);
		setResistance(resistance);
		setStepSound(soundtype);
	}
	

	public BlockIP(float hardness, float resistance, Material material, SoundType soundtype,Item dropitem) {
		super(material);
		setHardness(hardness);
		setResistance(resistance);
		setStepSound(soundtype);
		this.dropItems = true;
		this.dropItem = dropitem;
	}
	
	public BlockIP(float hardness, float resistance, Material material, SoundType soundtype,Block dropitem) {
		super(material);
		setHardness(hardness);
		setResistance(resistance);
		setStepSound(soundtype);
		this.dropItems = true;
		this.dropItem = Item.getItemFromBlock(dropitem);
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


	@Override
	public String getDescription() {
		return LanguageRegistry.instance().getStringLocalization(getUnlocalizedName()+".desc");
	}

}

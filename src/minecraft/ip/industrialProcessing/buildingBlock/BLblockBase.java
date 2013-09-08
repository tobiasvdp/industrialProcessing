package ip.industrialProcessing.buildingBlock;

import ip.industrialProcessing.IndustrialProcessing;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BLblockBase extends Block{

	public BLblockBase(int blockID,String name,float hardness, Material blockMaterial, StepSound stepSound) {
		super(blockID, blockMaterial);
		setHardness(hardness);
		setStepSound(stepSound);
		setUnlocalizedName(name);
		setCreativeTab(IndustrialProcessing.tabPower);
		func_111022_d(IndustrialProcessing.TEXTURE_NAME_PREFIX + name);
	}
	
	@Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack) {
	int dir = MathHelper.floor_double((double) ((entityLivingBase.rotationYaw * 4F) / 360F) + 0.5D) & 3;
	world.setBlockMetadataWithNotify(x, y, z, dir, 0); 
	super.onBlockPlacedBy(world, x, y, z, entityLivingBase, itemStack);
    }

}

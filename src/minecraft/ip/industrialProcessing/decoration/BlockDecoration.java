package ip.industrialProcessing.decoration;

import ip.industrialProcessing.IndustrialProcessing;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public abstract class BlockDecoration extends Block { 
	public BlockDecoration(int par1, Material par2Material, float hardness, StepSound stepSound, String name, CreativeTabs tab) {
		super(par1, par2Material);
		setHardness(hardness);
		setStepSound(stepSound);
		setUnlocalizedName(name);
		setCreativeTab(tab);
		func_111022_d(IndustrialProcessing.TEXTURE_NAME_PREFIX + "inputTop");
	}

}

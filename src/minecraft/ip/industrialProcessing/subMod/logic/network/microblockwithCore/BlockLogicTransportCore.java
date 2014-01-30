package ip.industrialProcessing.subMod.logic.network.microblockwithCore;

import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import ip.industrialProcessing.microBlock.centerBlock.BlockMicroBlockwithCenter;

public abstract class BlockLogicTransportCore  extends BlockMicroBlockwithCenter{

	protected BlockLogicTransportCore(int par1, Material par2Material, float hardness, StepSound stepSound, String name, CreativeTabs tab) {
		super(par1, par2Material, hardness, stepSound, name, tab);
	}

}

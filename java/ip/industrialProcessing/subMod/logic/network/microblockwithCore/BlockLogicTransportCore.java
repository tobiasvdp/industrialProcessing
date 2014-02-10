package ip.industrialProcessing.subMod.logic.network.microblockwithCore;

import ip.industrialProcessing.microBlock.extend.centerBlock.BlockMicroBlockwithCenter;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public abstract class BlockLogicTransportCore  extends BlockMicroBlockwithCenter{

	protected BlockLogicTransportCore(int par1, Material par2Material, float hardness, StepSound stepSound, String name, CreativeTabs tab) {
		super(par1, par2Material, hardness, stepSound, name, tab);
	}

}

package ip.industrialProcessing.machines.crusher;

import ip.industrialProcessing.IndustrialProcessing;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockCrusher extends Block {

	public BlockCrusher(int id) {
		super(id, Material.iron);
		setHardness(1F);
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName("crusher");
		setCreativeTab(IndustrialProcessing.tabMachines);
	}

}

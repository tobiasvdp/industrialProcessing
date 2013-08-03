package ip.industrialProcessing.machines.filter;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.IndustrialProcessingConfig;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockFilter extends Block {

	public BlockFilter() {
		super(IndustrialProcessingConfig.getFilterBlockID(), Material.iron);
		setHardness(1F);
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName("Ore Filter");
		setCreativeTab(IndustrialProcessing.tabMachines);
	}

	
}

package ip.industrialProcessing.machines.filter;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockFilter extends Block {

	public BlockFilter(int id) {
		super(id, Material.iron);
		setHardness(1F);
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName("Ore Filter");
	}

	
}

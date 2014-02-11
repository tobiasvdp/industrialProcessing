package mod.industrialProcessing.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

public class BlockIPRendered extends BlockIP {

	public BlockIPRendered(float hardness, float resistance, Material material, SoundType soundtype) {
		super(hardness, resistance, material, soundtype);
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l) {
		return false;
	}
}

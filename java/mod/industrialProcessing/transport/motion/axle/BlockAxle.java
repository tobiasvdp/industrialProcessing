package mod.industrialProcessing.transport.motion.axle;

import mod.industrialProcessing.transport.motion.BlockMotion;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockAxle extends BlockMotion {

	public BlockAxle() {
		super(1f, 1f, Material.iron, soundTypeMetal); 
	}

	@Override
	public boolean renderAsNormalBlock() { 
		return true;
	}
	
	@Override
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l) {
		if(ForgeDirection.getOrientation(l) == ForgeDirection.UP) return false;
		return true;
		//return super.shouldSideBeRendered(iblockaccess, i, j, k, l);
	}
	
	
}

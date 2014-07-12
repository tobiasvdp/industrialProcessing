package mod.industrialProcessing.plants.transport.fluids.manoMeter;

import mod.industrialProcessing.blockContainer.BlockContainerIP;
import mod.industrialProcessing.blockContainer.BlockContainerIPRendered;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockManoMeter extends BlockContainerIPRendered {

	public BlockManoMeter() {
		super(1.0f, 1.0f, Material.iron, Block.soundTypeMetal,"manometer", "tankSide");
		setBlockBounds(0, 0, 0.25f, 1, 1, 0.75f);
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess par1iBlockAccess, int par2, int par3, int par4) {
		ForgeDirection direction = BlockContainerIP.getForwardFromEntity(par1iBlockAccess.getTileEntity(par2, par3, par4));
		if (direction != null) {
			if (direction.ordinal() < 2)
				setBlockBounds(0, 0, 0, 1, 1, 1);
			else if (direction.ordinal() < 4)
				setBlockBounds(0, 0, 0.25f, 1, 1, 0.75f);
			else
				setBlockBounds(0.25f, 0, 0, 0.75f, 1, 1);
		}
		super.setBlockBoundsBasedOnState(par1iBlockAccess, par2, par3, par4);
	}

}

package ip.industrialProcessing.multiblock.layout;

import ip.industrialProcessing.multiblock.utils.MultiblockState;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class StructureMultiblock {

	LayoutMultiblock[] layouts = new LayoutMultiblock[4];

	public StructureMultiblock() {
	}

	public void addLayout(LayoutMultiblock layout, FacingDirection dir) {
		layouts[dir.ordinal()] = layout;
	}

	// i,j,k = coord - coord core
	public int getModelIDforBlock(int i, int j, int k, FacingDirection dir) {
		if (dir != FacingDirection.Invalid)
			return layouts[dir.ordinal()].getModelIDforBlock(i, j, k);
		else
			return 0;
	}
	
	// i,j,k = coord - coord core
	public int getModelConnectionforBlock(int i, int j, int k, FacingDirection dir) {
		if (dir != FacingDirection.Invalid)
			return layouts[dir.ordinal()].getModelConnectionforBlock(i, j, k);
		else
			return 0;
	}

	// i,j,k = coord - coord core
	public FacingDirection isBlockValid(int i, int j, int k, int blockID, FacingDirection dir, boolean isSideLocked) {
		if (dir != FacingDirection.Invalid) {
			if (layouts[dir.ordinal()].isBlockValid(i, j, k, blockID)) {
				return dir;
			} else {
				if (!isSideLocked) {
					for (FacingDirection direction : FacingDirection.values()) {
						if (direction != FacingDirection.Invalid && direction != dir) {
							if (layouts[direction.ordinal()].isBlockValid(i, j, k, blockID)) {
								return direction;
							}
						}
					}
				}
			}
			return FacingDirection.Invalid;
		} else {
			return FacingDirection.Invalid;
		}
	}

	public MultiblockState isLayoutValid(World world, int xCore, int yCore, int zCore, FacingDirection dir) {
		if (layouts[dir.ordinal()].isLayoutValid(world, xCore, yCore, zCore)) {
			return MultiblockState.COMPLETED;
		} else {
			return MultiblockState.CONNECTED;
		}
	}

}

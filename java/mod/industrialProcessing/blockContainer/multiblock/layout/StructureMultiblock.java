package mod.industrialProcessing.blockContainer.multiblock.layout;

import mod.industrialProcessing.blockContainer.multiblock.utils.MultiblockState;
import net.minecraft.block.Block;
import net.minecraft.world.World;

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
	public int getIDforBlock(int i, int j, int k, FacingDirection dir) {
		if (dir != FacingDirection.Invalid)
			return layouts[dir.ordinal()].getIDforBlock(i, j, k);
		else
			return 0;
	}

	// i,j,k = coord - coord core
	public int getGroupIDforBlock(int i, int j, int k, FacingDirection dir) {
		if (dir != FacingDirection.Invalid)
			return layouts[dir.ordinal()].getGroupIDforBlock(i, j, k);
		else
			return 0;
	}

	// i,j,k = coord - coord core
	public FacingDirection isBlockValid(int i, int j, int k, Block blockID, FacingDirection dir, boolean isSideLocked) {
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

	public int getSizeLeft(FacingDirection dir) {
		return layouts[dir.ordinal()].getSizeLeft();
	}

	public int getSizeRight(FacingDirection dir) {
		return layouts[dir.ordinal()].getSizeRight();
	}

	public int getSizeDown(FacingDirection dir) {
		return layouts[dir.ordinal()].getSizeDown();
	}

	public int getSizeUp(FacingDirection dir) {
		return layouts[dir.ordinal()].getSizeUp();
	}

	public int getSizeBack(FacingDirection dir) {
		return layouts[dir.ordinal()].getSizeBack();
	}

	public int getSizeFront(FacingDirection dir) {
		return layouts[dir.ordinal()].getSizeFront();
	}

	public int getLayoutValidCount(World worldObj, int xCore, int yCore, int zCore, FacingDirection dir) {
		return (layouts[dir.ordinal()].getLayoutValidCount(worldObj, xCore, yCore, zCore));
	}

	public void registerAllValidDummies(World worldObj, int xCore, int yCore, int zCore, FacingDirection face) {
		layouts[face.ordinal()].registerAllValidDummies(worldObj, xCore, yCore, zCore);
	}

	public MultiblockState couldLayoutBeValid(World world, int xCore, int yCore, int zCore, FacingDirection dir) {
		if (layouts[dir.ordinal()].couldLayoutBeValid(world, xCore, yCore, zCore)) {
			return MultiblockState.COMPLETED;
		} else {
			return MultiblockState.CONNECTED;
		}
	}
}

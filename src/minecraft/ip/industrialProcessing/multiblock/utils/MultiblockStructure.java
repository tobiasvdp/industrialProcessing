package ip.industrialProcessing.multiblock.utils;

import ip.industrialProcessing.multiblock.TileEntityMultiblockBlock;
import ip.industrialProcessing.multiblock.TileEntityMultiblockCore;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class MultiblockStructure {
	protected MultiBlockStructureBlockDescription[][][] layout;
	protected int xCore;
	protected int yCore;
	protected int zCore;
	protected int sizeLeft;
	protected int sizeRight;
	protected int sizeDown;
	protected int sizeUp;
	protected int sizeBack;
	protected int sizeFront;

	public MultiblockStructure(int blocksLeft, int blocksRight, int blocksFront, int blocksBack, int blocksUp, int blocksDown) {
		layout = new MultiBlockStructureBlockDescription[blocksLeft + blocksRight + 1][blocksUp + blocksDown + 1][blocksFront + blocksBack + 1];
		xCore = blocksLeft;
		yCore = blocksDown;
		zCore = blocksFront;
		sizeLeft = blocksLeft;
		sizeRight = blocksRight;
		sizeDown = blocksDown;
		sizeUp = blocksUp;
		sizeBack = blocksBack;
		sizeFront = blocksFront;
	}

	public MultiblockStructure(MultiblockStructure original, int angle) {
		layout = original.layout;
		xCore = original.xCore;
		yCore = original.yCore;
		zCore = original.zCore;
		sizeLeft = original.sizeLeft;
		sizeRight = original.sizeRight;
		sizeDown = original.sizeDown;
		sizeUp = original.sizeUp;
		sizeBack = original.sizeBack;
		sizeFront = original.sizeFront;
		for (int i = 0; i < angle; i++) {
			transformToAngle();
		}
	}

	/*
	 * Turns the provides structure 90deg
	 */
	public MultiblockStructure(MultiblockStructure original) {
		layout = original.layout;
		xCore = original.xCore;
		yCore = original.yCore;
		zCore = original.zCore;
		sizeLeft = original.sizeLeft;
		sizeRight = original.sizeRight;
		sizeDown = original.sizeDown;
		sizeUp = original.sizeUp;
		sizeBack = original.sizeBack;
		sizeFront = original.sizeFront;
		transformToAngle();
	}

	public int getSizeLeft() {
		return sizeLeft;
	}

	public int getSizeRight() {
		return sizeRight;
	}

	public int getSizeDown() {
		return sizeDown;
	}

	public int getSizeUp() {
		return sizeUp;
	}

	public int getSizeBack() {
		return sizeBack;
	}

	public int getSizeFront() {
		return sizeFront;
	}

	public void setCoreID(int blockID) {
		layout[xCore][yCore][zCore] = new MultiBlockStructureBlockDescription(0, 0, 0, blockID);
	}

	public void addBlockIDRelative(int hor, int ver, int depth, int... blockIDs) {

		layout[hor + xCore][ver + yCore][depth + zCore] = new MultiBlockStructureBlockDescription(hor, ver, depth, blockIDs);
	}

	public void fillLayer(int hor, int ver, int depth, int... blockIDs) {
		if (hor != -1) {
			int i = hor;
			for (int j = 0; j < layout[i].length; j++) {
				for (int k = 0; k < layout[i][j].length; k++) {
					if (layout[i][j][k] == null) {
						addBlockID(i, j, k, blockIDs);
					}
				}
			}
		}
		if (ver != -1) {
			for (int i = 0; i < layout.length; i++) {
				int j = ver;
				for (int k = 0; k < layout[i][j].length; k++) {
					if (layout[i][j][k] == null) {
						addBlockID(i, j, k, blockIDs);
					}
				}

			}
		}
		if (depth != -1) {
			for (int i = 0; i < layout.length; i++) {
				for (int j = 0; j < layout[i].length; j++) {
					int k = depth;
					if (layout[i][j][k] == null) {
						addBlockID(i, j, k, blockIDs);
					}

				}
			}
		}
	}

	public void addBlockID(int hor, int ver, int depth, int... blockIDs) {
		layout[hor][ver][depth] = new MultiBlockStructureBlockDescription(hor - xCore, ver - yCore, depth - zCore, blockIDs);
	}

	public void fillBlockID(int blockID) {
		for (int i = 0; i < layout.length; i++) {
			for (int j = 0; j < layout[i].length; j++) {
				for (int k = 0; k < layout[i][j].length; k++) {
					if (layout[i][j][k] == null) {
						addBlockID(i, j, k, blockID);
					}
				}
			}
		}
	}

	public MultiBlockStructureBlockDescription getDescription(int i, int j, int k) {
		return layout[i][j][k];
	}

	

	public boolean hasDiscriptionBlockId(int i, int j, int k, int blockId) {
		if (i<0 || j<0 || k<0 || i>layout.length-1 || j>layout[0].length-1 || k>layout[0][0].length-1)
			return false;
		boolean isValid = false;
		MultiBlockStructureBlockDescription desc = layout[i][j][k];
		if (desc != null)
			isValid = desc.containsBlock(blockId);
		return isValid;

	}

	private void transformToAngle() {
		MultiBlockStructureBlockDescription[][][] layout = new MultiBlockStructureBlockDescription[sizeFront + sizeBack + 1][sizeUp + sizeDown + 1][sizeLeft + sizeRight + 1];
		int blocksLeft = sizeBack;
		int blocksRight = sizeFront;
		int blocksFront = sizeLeft;
		int blocksBack = sizeRight;
		int blocksUp = sizeUp;
		int blocksDown = sizeDown;
		int xCore = blocksLeft;
		int yCore = blocksDown;
		int zCore = blocksFront;

		for (int i = 0; i < this.layout.length; i++) {
			for (int j = 0; j < this.layout[0].length; j++) {
				for (int k = 0; k < this.layout[0][0].length; k++) {
					int x = i - this.xCore;
					int z = k - this.zCore;
					int temp = x;
					x = -z;
					z = temp;
					MultiBlockStructureBlockDescription desc = null;
					if (this.layout[i][j][k] != null)
						desc = this.layout[i][j][k].copy(x, j - 1, z);
					x += xCore;
					z += zCore;
					layout[x][j][z] = desc;
				}
			}
		}

		this.layout = layout;
		this.xCore = blocksLeft;
		this.yCore = blocksDown;
		this.zCore = blocksFront;
		sizeLeft = blocksLeft;
		sizeRight = blocksRight;
		sizeDown = blocksDown;
		sizeUp = blocksUp;
		sizeBack = blocksBack;
		sizeFront = blocksFront;
	}

	public boolean checkLayout(World world, int xCore, int yCore, int zCore) {
		for (int i = 0; i < layout.length; i++) {
			for (int j = 0; j < layout[0].length; j++) {
				for (int k = 0; k < layout[0][0].length; k++) {
					int blockId = world.getBlockId(xCore - this.xCore + i, yCore - this.yCore + j, zCore - this.zCore + k);
					if (hasDiscription(i, j, k)){
						if (!hasDiscriptionBlockId(i, j, k, blockId))
							return false;
						TileEntity te = world.getBlockTileEntity(xCore - this.xCore + i, yCore - this.yCore + j, zCore - this.zCore + k);
						if (te instanceof TileEntityMultiblockBlock) {
							if (((TileEntityMultiblockBlock) te).hasCore() && !((TileEntityMultiblockBlock) te).getCore().equals(world.getBlockTileEntity(xCore, yCore, zCore))) {
								return false;
							}
						}
						if (te instanceof TileEntityMultiblockCore) {
							if (!te.equals(world.getBlockTileEntity(xCore, yCore, zCore)))
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	public int getxCore() {
		return xCore;
	}

	public int getyCore() {
		return yCore;
	}

	public int getzCore() {
		return zCore;
	}

	public boolean hasDiscription(int x, int y, int z) {
		if(layout[x][y][z]==null)
			return false;
		return true;
	}
}

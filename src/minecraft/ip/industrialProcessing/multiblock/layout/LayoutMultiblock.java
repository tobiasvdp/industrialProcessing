package ip.industrialProcessing.multiblock.layout;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.multiblock.core.TEmultiblockCore;
import ip.industrialProcessing.multiblock.dummy.TEmultiblockDummy;
import ip.industrialProcessing.multiblock.utils.layout.MultiBlockStructureBlockDescription;

public class LayoutMultiblock {

	private LayoutBlockDescription[][][] layout;
	private int xCore;
	private int yCore;
	private int zCore;
	private int sizeLeft;
	private int sizeRight;
	private int sizeDown;
	private int sizeUp;
	private int sizeBack;
	private int sizeFront;

	public LayoutMultiblock(int blocksLeft, int blocksRight, int blocksFront, int blocksBack, int blocksUp, int blocksDown) {
		layout = new LayoutBlockDescription[blocksLeft + blocksRight + 1][blocksUp + blocksDown + 1][blocksFront + blocksBack + 1];
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

	public void setCoreID(int modelID, int renderConnection, int blockID) {
		layout[xCore][yCore][zCore] = new LayoutBlockDescription(modelID, renderConnection, blockID);
	}

	public void setBlockID(int i, int j, int k, int renderID, int renderConnection, int... blockIDs) {
		layout[i + xCore][j + yCore][-k + zCore] = new LayoutBlockDescription(renderID, renderConnection, blockIDs);
	}

	// i,j,k = coord - coord core
	public int getModelIDforBlock(int i, int j, int k) {
		return layout[i + xCore][j + yCore][-k + zCore].getModelID();
	}
	
	// i,j,k = coord - coord core
	public int getModelConnectionforBlock(int i, int j, int k) {
		return layout[i + xCore][j + yCore][-k + zCore].getModelConnection();
	}

	// i,j,k = coord - coord core
	public boolean isBlockValid(int i, int j, int k, int blockID) {
		int x = i + xCore;
		int y = j + yCore;
		int z = -k + zCore;
		if (x >= 0 && y >= 0 && z >= 0 && x < layout.length && y < layout[0].length & z < layout[0][0].length)
			return layout[x][y][z].isValidID(blockID);
		else
			return false;
	}

	public boolean isLayoutValid(World world, int xCore, int yCore, int zCore) {
		for (int i = 0; i < layout.length; i++) {
			for (int j = 0; j < layout[0].length; j++) {
				for (int k = 0; k < layout[0][0].length; k++) {
					int xBlock = xCore - this.xCore + i;
					int yBlock = yCore - this.yCore + j;
					int zBlock = zCore + this.zCore - k;
					if (layout[i][j][k] != null) {
						if (!layout[i][j][k].isValidID(world.getBlockId(xBlock, yBlock, zBlock))) {
							return false;
						}
						TileEntity te = world.getBlockTileEntity(xBlock, yBlock, zBlock);
						if (te instanceof TEmultiblockDummy) {
							TEmultiblockCore teCore = ((TEmultiblockDummy) te).getCore();
							if (teCore == null)
								return false;
							if (teCore != world.getBlockTileEntity(xCore, yCore, zCore))
								return false;
						}
					}
				}
			}
		}
		return true;
	}

	public LayoutBlockDescription[][][] getLayout() {
		return layout;
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

}

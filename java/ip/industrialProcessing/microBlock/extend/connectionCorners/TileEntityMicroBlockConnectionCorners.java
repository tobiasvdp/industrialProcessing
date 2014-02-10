package ip.industrialProcessing.microBlock.extend.connectionCorners;

import java.lang.reflect.Array;
import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.microBlock.IMicroBlock;
import ip.industrialProcessing.microBlock.core.BlockMicroBlock;
import ip.industrialProcessing.microBlock.extend.connectingSides.TileEntityMicroBlockConnectingSides;
import ip.industrialProcessing.microBlock.extend.connections.TileEntityMicroBlockConnection;
import ip.industrialProcessing.microBlock.extend.externalConnections.IMicroBlockExternalConnection;

public abstract class TileEntityMicroBlockConnectionCorners extends TileEntityMicroBlockConnection implements IMicroBlockConnectionCorner {

	protected boolean[][] externalConnectionExtentions = new boolean[6][4];

	public TileEntityMicroBlockConnectionCorners() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 4; j++) {
				externalConnectionExtentions[i][j] = false;
			}
		}
	}

	@Override
	protected void setExternalConnectionForSide(int i, IMicroBlock te, boolean repeat) {
		int[] sides = rotation[i];
		/*for (int j = 0; j < 3; j++) {
			externalConnectionExtentions[i][j] = false;
		}*/
		if (te != null) {
			for (int j = 0; j < sides.length; j++) {
				if (!te.isSideFree(sides[j])) {
					externalConnections[sides[j]][externalDirections[sides[j]][i]] = true;
				} else {
					if (hasDiagonalConnection(sides[j], i, te, repeat))
						externalConnections[sides[j]][externalDirections[sides[j]][i]] = true;
					else
						externalConnections[sides[j]][externalDirections[sides[j]][i]] = false;
				}
			}
			if (repeat && te instanceof IMicroBlockExternalConnection) {
				((IMicroBlockExternalConnection) te).updateConnections(BlockMicroBlock.invertSide(i));
			}
		} else {

			for (int j = 0; j < sides.length; j++) {
				if (hasDiagonalConnection(sides[j], i, te, repeat))
					externalConnections[sides[j]][externalDirections[sides[j]][i]] = true;
				else
					externalConnections[sides[j]][externalDirections[sides[j]][i]] = false;
			}
		}
	}

	@Override
	protected boolean hasDiagonalConnection(int face, int side, IMicroBlock te, boolean repeat) {
		ForgeDirection dir = ForgeDirection.values()[side];
		ForgeDirection dirface = ForgeDirection.values()[face];
		Block block = Block.blocksList[worldObj.getBlockId(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ)];
		if (block == null || !worldObj.isBlockSolidOnSide(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ, dir.getOpposite())) {
			Block blockFace = Block.blocksList[worldObj.getBlockId(xCoord + dir.offsetX + dirface.offsetX, yCoord + dir.offsetY + dirface.offsetY, zCoord + dir.offsetZ + dirface.offsetZ)];
			if (blockFace != null && blockFace instanceof BlockMicroBlock) {
				if (!isSideFree(face)) {
					TileEntity diagonalSide = worldObj.getBlockTileEntity(xCoord + dir.offsetX + dirface.offsetX, yCoord + dir.offsetY + dirface.offsetY, zCoord + dir.offsetZ + dirface.offsetZ);
					if (diagonalSide instanceof IMicroBlockConnectionCorner) {
						IMicroBlockConnectionCorner diagSide = (IMicroBlockConnectionCorner) diagonalSide;
						if (!diagSide.isSideFree(dir.getOpposite())) {
							externalConnectionExtentions[face][externalDirections[face][side]] = true;
							if (repeat)
								diagSide.updateConnections(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ);
							return true;
						}
					}
				}
				else{
					TileEntity diagonalSide = worldObj.getBlockTileEntity(xCoord + dir.offsetX + dirface.offsetX, yCoord + dir.offsetY + dirface.offsetY, zCoord + dir.offsetZ + dirface.offsetZ);
					if (diagonalSide instanceof IMicroBlockConnectionCorner) {
						IMicroBlockConnectionCorner diagSide = (IMicroBlockConnectionCorner) diagonalSide;
					if (repeat)
						diagSide.updateConnections(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ);
					}
				}
			}
		}
		externalConnectionExtentions[face][externalDirections[face][side]] = false;
		return false;
	}

	@Override
	public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
		for (int i = 0; i < externalConnectionExtentions.length; i++) {
			for (int j = 0; j < externalConnectionExtentions[0].length; j++) {
				par1nbtTagCompound.setBoolean("externCornCon" + i * 10 + j, externalConnectionExtentions[i][j]);
			}
		}
		super.writeToNBT(par1nbtTagCompound);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
		for (int i = 0; i < externalConnectionExtentions.length; i++) {
			for (int j = 0; j < externalConnectionExtentions[0].length; j++) {
				externalConnectionExtentions[i][j] = par1nbtTagCompound.getBoolean("externCornCon" + i * 10 + j);
			}
		}
		super.readFromNBT(par1nbtTagCompound);
	}

	@Override
	public boolean[] getExternalConnectionCorners(int i) {
		return externalConnectionExtentions[i];
	}
}

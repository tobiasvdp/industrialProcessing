package mod.industrialProcessing.plants.network.monitor;

import java.util.Arrays;

import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.blockContainer.TileEntityBlockContainerIP;
import mod.industrialProcessing.blockContainer.microblock.MicroBlockType;
import mod.industrialProcessing.blockContainer.microblock.core.TileEntityMicroBlock;
import mod.industrialProcessing.items.ItemMicroBlock;
import mod.industrialProcessing.utils.handlers.line.ILineTileEntity;
import mod.industrialProcessing.utils.handlers.line.ILineTileEntityMicroblock;
import mod.industrialProcessing.utils.handlers.line.ILineTileEntitySolidBlock;
import mod.industrialProcessing.utils.registry.HandlerRegistry;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityNetworkMonitor extends TileEntityBlockContainerIP implements ILineTileEntitySolidBlock {

	protected int lineID;
	protected int lineLength = 0;
	protected boolean isLoaded = false;
	protected LocalDirection connectionSide = LocalDirection.BACK;
	protected boolean register = false;

	public TileEntityNetworkMonitor() {
		lineID = -1;
	}

	@Override
	public boolean hasMultipleLineSupport() {
		return false;
	}

	@Override
	public boolean isMicroblock() {
		return false;
	}

	@Override
	public boolean isInLine() {
		if (lineID != -1)
			return true;
		return false;
	}

	@Override
	public boolean isPartOfLine(int lineID) {
		if (lineID == this.lineID)
			return true;
		return false;
	}

	@Override
	public int getXCoord() {
		return this.xCoord;
	}

	@Override
	public int getYCoord() {
		return this.yCoord;
	}

	@Override
	public int getZCoord() {
		return this.zCoord;
	}

	@Override
	public int getLineId() {
		return lineID;
	}

	@Override
	public void setLineID(int id) {
		lineID = id;
	}

	@Override
	public void registerToLine() {
		//register next tick for race condition
		register = true;
	}
	
	@Override
	public void updateEntity() {
		super.updateEntity();
		if(register){
			register = false;
			HandlerRegistry.registerUtilToLineHandler("logic", this, ForgeDirection.UNKNOWN);
		}
	}

	@Override
	public void unregisterFromLine() {
		if (this.lineID != -1)
			HandlerRegistry.unregisterUtilFromLineHandler("logic", this, ForgeDirection.UNKNOWN);
	}

	@Override
	public int[] getLineConnectionArray(ForgeDirection dir) {
		dir = getExternalDirection(connectionSide);
		TileEntity te = worldObj.getTileEntity(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ);
		if (te instanceof TileEntityMicroBlock) {
			TileEntityMicroBlock micro = (TileEntityMicroBlock) te;
			if (!micro.isSideFree(dir.getOpposite())) {
				if (micro.getItemOnSide(dir.getOpposite()).equals(IndustrialProcessing.itemInterfaceAdaptor)) {
					if(micro instanceof ILineTileEntitySolidBlock)
						return new int[] { ((ILineTileEntitySolidBlock)micro).getLineId() };
					if(micro instanceof ILineTileEntityMicroblock)
						return new int[] { ((ILineTileEntityMicroblock)micro).getLineID(dir.getOpposite().ordinal())};
				}
			}
		}
		return new int[] { -1 };
	}

	@Override
	public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
		super.writeToNBT(par1nbtTagCompound);
		par1nbtTagCompound.setInteger("lineID", lineID);
		par1nbtTagCompound.setInteger("lineLength", lineLength);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
		super.readFromNBT(par1nbtTagCompound);

		lineID = par1nbtTagCompound.getInteger("lineID");
		lineLength = par1nbtTagCompound.getInteger("lineLength");

		if (!isLoaded) {
			HandlerRegistry.registerUtilToLineHandlerFromNBT("logic", this);
			isLoaded = true;
		}
	}

	@Override
	public boolean isLineNull() {
		return false;
	}

	@Override
	public void setLineLength(int length) {
		lineLength = length;
	}

	@Override
	public int getLineLength() {
		return lineLength;
	}
}

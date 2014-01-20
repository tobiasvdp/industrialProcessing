package ip.industrialProcessing.multiblock.dummy.block.decoration.garageDoor;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.machines.IRotateableEntity;
import ip.industrialProcessing.multiblock.dummy.TileEntityMultiblockDummy;
import ip.industrialProcessing.multiblock.dummy.extend.TileEntityMultiblockDummyInv;

public class TileEntityGarageDoorDoor extends TileEntity implements IRotateableEntity {
	ForgeDirection forward;
	public boolean hide =false;
	
	public TileEntityGarageDoorDoor() {
		super();
	}

	@Override
	public ForgeDirection getForwardDirection() {
		return forward;
	}

	@Override
	public void setForwardDirection(ForgeDirection forward) {
		this.forward = forward;
	}

	@Override
	public boolean canWrenchRotate() {
		return false;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
		forward = ForgeDirection.values()[par1nbtTagCompound.getInteger("forward")];
		hide = par1nbtTagCompound.getBoolean("hide");
		super.readFromNBT(par1nbtTagCompound);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
		par1nbtTagCompound.setInteger("forward",forward.ordinal());
		par1nbtTagCompound.setBoolean("hide", hide);
		super.writeToNBT(par1nbtTagCompound);
	}

	public void hide() {
		hide = true;
		this.worldObj.markBlockForRenderUpdate(xCoord, yCoord, zCoord);
	}

	public void unhide() {
		hide = false;
		this.worldObj.markBlockForRenderUpdate(xCoord, yCoord, zCoord);
	}

}

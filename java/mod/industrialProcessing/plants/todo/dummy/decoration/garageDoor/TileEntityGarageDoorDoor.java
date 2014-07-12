package mod.industrialProcessing.plants.todo.dummy.decoration.garageDoor;

import ip.industrialProcessing.machines.IRotateableEntity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityGarageDoorDoor extends TileEntity implements IRotateableEntity {
	ForgeDirection forward;
	public boolean hide = false;
	public boolean NBTupdate = false;
	public boolean isCreated = true;

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
	public void updateEntity() {
		if (NBTupdate) {
			worldObj.markBlockForRenderUpdate(xCoord, yCoord, zCoord);
			NBTupdate = false;
		}
		if (isCreated) {
			worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
			isCreated = false;
		}
		super.updateEntity();
	}

	@Override
	public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
		forward = ForgeDirection.values()[par1nbtTagCompound.getInteger("forward")];
		hide = par1nbtTagCompound.getBoolean("hide");
		super.readFromNBT(par1nbtTagCompound);

		if (this.worldObj != null && this.worldObj.isRemote) {
			NBTupdate = true;
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
		par1nbtTagCompound.setInteger("forward", forward.ordinal());
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

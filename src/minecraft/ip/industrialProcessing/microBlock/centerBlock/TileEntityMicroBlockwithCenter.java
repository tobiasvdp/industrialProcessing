package ip.industrialProcessing.microBlock.centerBlock;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.microBlock.MicroBlockType;
import ip.industrialProcessing.microBlock.connectionCorners.TileEntityMicroBlockConnectionCorners;

public abstract class TileEntityMicroBlockwithCenter extends TileEntityMicroBlockConnectionCorners implements IMicroBlockCore {

	protected int coreID = -1;

	public TileEntityMicroBlockwithCenter() {
		hasCore = true;
	}

	@Override
	public void setSide(ForgeDirection dir, int itemID, EntityPlayer player) {
		if (!hasCore()) {
			setCore(itemID);
		} else {
			super.setSide(dir, itemID, player);
		}
	}

	@Override
	public void unsetSide(ForgeDirection dir, EntityPlayer player) {
		super.unsetSide(dir, player);
	}

	@Override
	public void destroyBlock(EntityPlayer player) {
		coreID = -1;
		if (player.capabilities.isCreativeMode)
			this.worldObj.destroyBlock(xCoord, yCoord, zCoord, false);
		else
			this.worldObj.destroyBlock(xCoord, yCoord, zCoord, true);
	}

	@Override
	public void setCore(int id) {
		coreID = id;
	}

	@Override
	public boolean hasCore() {
		return coreID != -1;
	}

	@Override
	public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
		par1nbtTagCompound.setInteger("mircoblockCore", coreID);
		super.writeToNBT(par1nbtTagCompound);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
		coreID = par1nbtTagCompound.getInteger("mircoblockCore");
		super.readFromNBT(par1nbtTagCompound);
	}

}

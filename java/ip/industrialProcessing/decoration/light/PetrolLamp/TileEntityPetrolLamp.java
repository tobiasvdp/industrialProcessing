package ip.industrialProcessing.decoration.light.PetrolLamp;

import ip.industrialProcessing.machines.TileEntityMachine;
import net.minecraft.nbt.NBTTagCompound;

public class TileEntityPetrolLamp extends TileEntityMachine {

	private int burnTime;
	public boolean lightChanged = true;
	public boolean count = true;
	
	public int getBurnTime() {
		return burnTime;
	}
	
	public void increaseBurnTime(int val){
		burnTime += val;
		if(!worldObj.isRemote){
			this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		}
	}

	@Override
	public void updateEntity() {
		if (burnTime > 0 && count)
			burnTime--;
		super.updateEntity();
	}
	
	public int getLightLevel(){
		if(burnTime > 100){
			if(burnTime == 5500)
				lightChanged = true;
			if(burnTime < 6000)
				return 8;
			return 15;
		}
		if(burnTime == 50)
			lightChanged = true;
		return 0;
	}

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		return false;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		burnTime = nbt.getInteger("burnTime");
		count = nbt.getBoolean("count");
		lightChanged = true;
		super.readFromNBT(nbt);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		nbt.setInteger("burnTime", burnTime);
		nbt.setBoolean("count", count);
		super.writeToNBT(nbt);
	}

	public void updateLight() {
		this.worldObj.updateAllLightTypes(xCoord, yCoord, zCoord);
	}

}

package ip.industrialProcessing.decoration.light;

import cpw.mods.fml.common.registry.GameRegistry;
import ip.industrialProcessing.machines.TileEntityMachine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public abstract class TileEntityLamp  extends TileEntityMachine {

	protected int burnTime;
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
		if(burnTime == 0){
		    OnFuelUsed();
		}
		super.updateEntity();
	}
	
	protected void OnFuelUsed() {

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

	public abstract float yOffset();

	public abstract float xzOffset();

	public void addTo(EntityPlayer player) {
	    ItemStack item = player.getCurrentEquippedItem();
	    if (item != null) {
		int val = GameRegistry.getFuelValue(item);
		if (val > 0) {
		    this.increaseBurnTime(val * 10);
		    if (item.itemID == Item.bucketLava.itemID)
			this.count = false;
		    item.stackSize--;
		    if (item == null || item.stackSize == 0) {
			item = null;
		    }
		    player.inventory.onInventoryChanged();
		    System.out.println("Torch will burn for " + val * 10 + " ticks.");
		}
	    }
	}

}

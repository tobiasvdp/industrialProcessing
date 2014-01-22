package ip.industrialProcessing.utils.handler.heat;

import net.minecraft.item.ItemStack;

public interface IHeatStorage extends IHeated{
	//in update transfer heat from fuel to environement
	public void transferHeat();
	
	//add heat from fuelSource
	public void ConsumeFuel(ItemStack stack);
	
	//tick fuel source()
	public void tickFuel();
	
	//get the temperature of the fuel
	public float getHeatFuel();
	public void setHeatFuel(float val);
	
	public void setHeat(float val);

	
	//burnTime
	public int getBurnTime();
	public void setBurnTime(int val);
	
	
	//max burntime
	public int getMaxBurnTime();
	public void setMaxBurnTime(int val);
	
	//set the required Heat Level
	public float requiredHeatLevel();
	
	//get the coolent factor
	public float getCoolingFactor();
	
	
	//get the scaled heat 
	public int getScaledHeat(int maxSize);
	
	//get the scaledBurnTime
	public int getScaledBurnTime(int size);


	
}

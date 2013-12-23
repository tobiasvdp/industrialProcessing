package ip.industrialProcessing.utils;

import net.minecraft.item.ItemStack;

public interface IHeatStorage {
	//in update transfer heat from fuel to environement
	public void transferHeat();
	
	//add heat from fuelSource
	public void ConsumeFuel(ItemStack stack);
	
	//tick fuel source()
	public void tickFuel();
	
	//get the temperature of the fuel
	public float getHeatFuel();
	
	//get heat
	public float getHeat();
	
	//set the maximum heat temp
	public float getMaxHeat();
	
	//get the coolent factor
	public float getCoolingFactor();
	
	
	//get the scaled heat 
	public int getScaledHeat(int maxSize);
	
	//get the scaledBurnTime
	public int getScaledBurnTime(int size);
	
}

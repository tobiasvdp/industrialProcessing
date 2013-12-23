package ip.industrialProcessing.machines.kiln;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.SimplePowerStorage;
import ip.industrialProcessing.machines.TileEntityPoweredWorkerMachine;
import ip.industrialProcessing.power.plants.IHeatable;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.utils.IHeatStorage;

import java.util.Iterator;

import net.minecraft.item.ItemStack;

public class TileEntityKiln extends TileEntityPoweredWorkerMachine implements IHeatable,IHeatStorage{

	public static RecipesKiln recipes = new RecipesKiln();

	public TileEntityKiln() {
		super(LocalDirection.UNKNOWN, 100000, 100); // does 100 work per tick, lasts
												// 100 ticks
		this.addStack(null, LocalDirection.UP, true, false);
		this.addStack(null, LocalDirection.DOWN, false, true);
	}

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		return recipes.isValidInput(slot, itemID);
	}

	@Override
	public Iterator<Recipe> iterateRecipes() {
		return recipes.iterator();
	}

	@Override
	public void addHeat(int heat) {
		((SimplePowerStorage)getMainPowerStorage()).fillPower(heat*16, true);
	}
	
	@Override
	public void updateEntity() {
		((SimplePowerStorage)getMainPowerStorage()).drainPower(1, true);
		if(getMainPowerStorage().getStoredPower() > 8000)
		    super.updateEntity();
		
	}

	@Override
	public void ConsumeFuel(ItemStack stack) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float getHeat() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getMaxHeat() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getCoolingFactor() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getScaledHeat(int maxSize) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void transferHeat() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tickFuel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float getHeatFuel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getScaledBurnTime(int size) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}

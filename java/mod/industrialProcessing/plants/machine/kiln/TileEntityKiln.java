package ip.industrialProcessing.machines.kiln;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityWorkerMachine;
import ip.industrialProcessing.power.plants.IHeatable;
import ip.industrialProcessing.recipes.IMachineRecipe;
import ip.industrialProcessing.utils.handler.heat.IHeated;
import ip.industrialProcessing.utils.working.HeatManager;

import java.util.Iterator;

import net.minecraft.nbt.NBTTagCompound;

public class TileEntityKiln extends TileEntityWorkerMachine implements IHeatable, IHeated {

    public static RecipesKiln recipes = new RecipesKiln();
    private HeatManager heatManager;

    public TileEntityKiln() {
        super(false); // 100 ticks
        this.addStack(null, LocalDirection.UP, true, false);
        this.addStack(null, LocalDirection.RIGHT, false, true);
        this.heatManager = new HeatManager(0.00005f, 8000f, 0.01f, this.getWorker());
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        this.heatManager.writeToNBT(nbt);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        this.heatManager.readFromNBT(nbt);
    }

    @Override
    protected boolean isValidInput(int slot, int itemID) {
        return recipes.isValidInput(slot, itemID);
    }

    @Override
    public Iterator<IMachineRecipe> iterateRecipes() {
        return recipes.getRecipes();
    }

    @Override
    public void addHeat(float heat) {
        this.heatManager.addHeat(heat);
    }

    @Override
    public void updateEntity() {
        if (!this.worldObj.isRemote) {
            float ambientTemperature = (this.worldObj.getBiomeGenForCoords(this.xCoord, this.zCoord).getFloatTemperature() * 20);
            this.heatManager.update(ambientTemperature);
        }
        super.updateEntity();
    }

    @Override
    protected void doWork() {
        if (!this.worldObj.isRemote)
            this.heatManager.doWork();
    }

    @Override
    public float getHeat() {
        return this.heatManager.getTemperature();
    }

    @Override
    public float getMaxHeat() {
        return 10000;
    }

}

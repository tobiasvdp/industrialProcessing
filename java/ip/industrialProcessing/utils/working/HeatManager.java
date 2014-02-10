package ip.industrialProcessing.utils.working;

import ip.industrialProcessing.recipes.IHeatRecipe;
import ip.industrialProcessing.recipes.IMachineRecipe;
import ip.industrialProcessing.recipes.RecipeWorker;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class HeatManager {

    private float heat;
    private float coolingRate;
    private IWorker worker;
    private float operatingTemperature;
    private float workRate;

    public HeatManager(float coolingRate, float operatingTemperature, float workRate, IWorker worker) {
        this.heat = Float.NaN;
        this.coolingRate = coolingRate;
        this.worker = worker;
        this.operatingTemperature = operatingTemperature;
        this.workRate = workRate;
    }

    public void update(float ambientTemperature) {
        if (Float.isNaN(this.heat))
            heat = ambientTemperature;
        // the hotter the boiler get,
        // the faster the heat dissipates to the environment:
        this.heat += coolingRate * (ambientTemperature - this.heat);
    }

    public void writeToNBT(NBTTagCompound nbt) {
        nbt.setFloat("Heat", heat);
    }

    public void readFromNBT(NBTTagCompound nbt) {
        this.heat = nbt.getFloat("Heat");
    }

    public void doWork() {
        if (heat > 0) {
            float minHeat = operatingTemperature;
            if (worker instanceof RecipeWorker) {
                IMachineRecipe recipe = ((RecipeWorker) worker).getCurrentRecipe();
                if (recipe instanceof IHeatRecipe)
                    minHeat = ((IHeatRecipe) recipe).getHeatRequired();
            }
            int done = worker.doWork((int) ((heat - minHeat) * workRate));
            this.heat -= done * workRate;
        }
    }

    public float getTemperature() {
        return this.heat;
    }

    public void addHeat(float heat) {
        this.heat += heat * 2.5f;
    }

}

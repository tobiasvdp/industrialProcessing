package ip.industrialProcessing.machines;

import ip.industrialProcessing.DirectionUtils;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.logic.api.network.interfaces.InterfaceType;
import ip.industrialProcessing.logic.api.network.interfaces.StatusType;
import ip.industrialProcessing.power.IPoweredMachine;
import ip.industrialProcessing.power.PowerHelper;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeWorker;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;

public abstract class TileEntityPoweredWorkerMachine extends TileEntityWorkerMachine implements IPoweredMachine {

    private LocalDirection powerInputSide;
    private int maxWorkSpeed;

    private SimplePowerStorage storage;

    public TileEntityPoweredWorkerMachine(LocalDirection powerInput, int powerCapacity, int maxWorkSpeed) {
        this.powerInputSide = powerInput;
        this.maxWorkSpeed = maxWorkSpeed;
        this.storage = new SimplePowerStorage(powerCapacity);
    }

    public TileEntityPoweredWorkerMachine(LocalDirection powerInput, int powerCapacity) {
        this(powerInput, powerCapacity, PowerWorkerHelper.DEFAULT_WORK_SPEED);
    }

    @Override
    public void doWork() {
        Recipe recipe = ((RecipeWorker) this.worker).getCurrentRecipe();

        if (recipe != null) {
        	status = StatusType.working;
            int amount = PowerWorkerHelper.getWork(this.storage, this.maxWorkSpeed);
            int maxWork = this.storage.drainPower(amount, false);

            if (recipe.powerRequired > 0){
                maxWork /= recipe.powerRequired;
        		if(maxWork == 0)
        			status = StatusType.lowPower;
            }else
                maxWork = this.maxWorkSpeed;

            int maxPower = work(maxWork);

            if (recipe.powerRequired > 0) {
                maxPower *= recipe.powerRequired;
                this.storage.drainPower(maxPower, true);
            }
            
        }else
        	status = StatusType.idle;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        this.storage.readFromNBT(nbt);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        this.storage.writeToNBT(nbt);
    }

    @Override
    public float getResistance(ForgeDirection side, float voltage) {
        if (canAcceptPower(side)) {
            return PowerHelper.getResistanceForStorage(this.storage);
        }
        return Float.POSITIVE_INFINITY;
    }

    @Override
    public void applyPower(ForgeDirection side, float coulombs, float voltage) {
        if (canAcceptPower(side)) {
            int joules = (int) PowerHelper.getEnergy(coulombs, voltage);
            this.storage.fillPower(joules, true);
        }
    }

    @Override
    public boolean canAcceptPower(ForgeDirection side) {
        return this.powerInputSide == DirectionUtils.getLocalDirection(side, getForwardDirection());
    }

    @Override
    public IPowerStorage getMainPowerStorage() {
        return this.storage;
    }
    @Override
    public InterfaceType[] getConnectionTypes(){
    	return new InterfaceType[]{InterfaceType.single,InterfaceType.inventory,InterfaceType.worker,InterfaceType.power};
    };
}

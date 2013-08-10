package ip.industrialProcessing.machines;

import ip.industrialProcessing.recipes.IRecipeWorkHandler;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeWorker;
import ip.industrialProcessing.utils.working.ClientWorker;
import ip.industrialProcessing.utils.working.IWorkHandler;
import ip.industrialProcessing.utils.working.IWorker;
import ip.industrialProcessing.utils.working.IWorkingEntity;
import ip.industrialProcessing.utils.working.ServerWorker;
import ip.industrialProcessing.utils.working.WorkUtils;

import java.util.Iterator;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public abstract class TileEntityWorkerMachine extends TileEntityMachine implements IWorkHandler, IRecipeWorkHandler, IWorkingEntity {

    public TileEntityWorkerMachine() {
	this.serverWorker = createServerSideWorker();
	this.clientWorker = new ClientWorker();  
    }

    protected ServerWorker createServerSideWorker() {
	return new RecipeWorker(this);
    }

    protected ServerWorker serverWorker;
    protected ClientWorker clientWorker;

    public IWorker getWorker() {
	if (this.worldObj.isRemote)
	    return clientWorker;
	else
	    return serverWorker;
    }

    @Override
    public void updateEntity() {
	doWork();
    }

    protected void doWork()
    {
	work(1);
    }
    
    @Override
    public boolean canUpdate() {
	return true;
    }

    protected int work(int amount) {
	return this.getWorker().doWork(amount);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
	super.writeToNBT(nbt); 
	writeWorker(nbt);
    };

    private void writeWorker(NBTTagCompound nbt) {
	if (this.worldObj.isRemote) {
	    WorkUtils.writeToNBT(clientWorker, nbt);
	} else {
	    WorkUtils.writeToNBT(serverWorker, nbt);
	}
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
	super.readFromNBT(nbt); 
	readWorker(nbt);
    };

    private void readWorker(NBTTagCompound nbt) {
	WorkUtils.readFromNBT(clientWorker, nbt);
	WorkUtils.readFromNBT(serverWorker, nbt);
    }

    @Override
    public void workProgressed(int amount) {
    }

    @Override
    public void workCancelled() {
	notifyBlockChange();
    }

    @Override
    public void prepareWork() {
    }

    @Override
    public void beginWork() {
	notifyBlockChange();
    }

    @Override
    public void workDone() {
	notifyBlockChange();
    }

    @Override
    public boolean hasWork() {
	return true;
    }

    @Override
    public boolean canWork() {
	return true;
    }

    @Override
    public TileEntity getTileEntity() {
	return this;
    }
}

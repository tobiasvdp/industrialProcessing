package ip.industrialProcessing.machines;

import ip.industrialProcessing.client.render.IAnimationProgress;
import ip.industrialProcessing.logic.api.network.interfaces.InterfaceType;
import ip.industrialProcessing.machines.animation.AnimationHandler;
import ip.industrialProcessing.machines.animation.AnimationMode;
import ip.industrialProcessing.machines.animation.IAnimationSyncable;
import ip.industrialProcessing.machines.animation.TileAnimationSyncHandler;
import ip.industrialProcessing.recipes.IRecipeWorkHandler;
import ip.industrialProcessing.recipes.RecipeWorker;
import ip.industrialProcessing.utils.working.IWorkHandler;
import ip.industrialProcessing.utils.working.IWorker;
import ip.industrialProcessing.utils.working.IWorkingEntity;
import ip.industrialProcessing.utils.working.ServerWorker;
import ip.industrialProcessing.utils.working.WorkUtils;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public abstract class TileEntityWorkerMachine extends TileEntityMachine implements IWorkHandler, IRecipeWorkHandler, IWorkingEntity, IAnimationProgress, IAnimationSyncable {

    public TileEntityWorkerMachine() {
	this.worker = createServerSideWorker();
	this.animationHandler = creatAnimationHandler();
    }

    protected AnimationHandler creatAnimationHandler() {
	return new AnimationHandler(AnimationMode.WRAP, 1f, true);
    }

    protected ServerWorker createServerSideWorker() {
	return new RecipeWorker(this);
    }

    protected ServerWorker worker;
    protected AnimationHandler animationHandler;

    @Override
	public IWorker getWorker() {
	return worker;
    }

    @Override
    public void updateEntity() {
	doWork();
	this.animationHandler.update();
	TileAnimationSyncHandler.sendAnimationData(this, this.animationHandler);
    }

    protected void doWork() {
	work(1);
    }

    protected int work(int amount) {
	int workDone = this.getWorker().doWork(amount);
	return workDone;
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
	super.writeToNBT(nbt);
	writeWorker(nbt);
    };

    private void writeWorker(NBTTagCompound nbt) {
	WorkUtils.writeToNBT(worker, nbt);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
	super.readFromNBT(nbt);
	readWorker(nbt);
    };

    private void readWorker(NBTTagCompound nbt) { 
	WorkUtils.readFromNBT(worker, nbt);
    }

    @Override
    public void workProgressed(int amount) {
	updateAnimation(amount);
    }

    protected void updateAnimation(int workDone) {
	IWorker worker = getWorker();
	float maxWork = worker.getTotalWork();
	// each frame, workDone/maxWork % will be added to the animation
	this.animationHandler.setSpeed(workDone / maxWork / AnimationHandler.DT);
    }

    @Override
    public float getAnimationProgress(float scale, int index) {
	return this.animationHandler.getAnimationProgress(scale);
    }

    @Override
    public int getAnimationCount() {
	return 1;
    }

    @Override
	public AnimationHandler getAnimationHandler() {
	return animationHandler;
    }

    @Override
    public void workCancelled() {
	this.animationHandler.setProgress(0f);
	this.animationHandler.setSpeed(0f);
    }

    @Override
    public void prepareWork() {
    }

    @Override
    public void beginWork() {
	// work has started, begin animation
	this.animationHandler.setProgress(0f);
	this.animationHandler.setSpeed(0f);
    }

    @Override
    public void workDone() {
	// work is done, no more animation
	this.animationHandler.setProgress(this.animationHandler.getScale());
	this.animationHandler.setSpeed(0f);
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
    @Override
    public InterfaceType[] getConnectionTypes(){
    	return new InterfaceType[]{InterfaceType.single,InterfaceType.inventory,InterfaceType.worker,InterfaceType.power};
    };

}

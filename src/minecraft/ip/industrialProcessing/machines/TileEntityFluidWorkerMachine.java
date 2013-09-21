package ip.industrialProcessing.machines;

import ip.industrialProcessing.client.render.IAnimationProgress;
import ip.industrialProcessing.machines.animation.AnimationHandler;
import ip.industrialProcessing.machines.animation.AnimationMode;
import ip.industrialProcessing.machines.animation.IAnimationSyncable;
import ip.industrialProcessing.machines.animation.TileAnimationSyncHandler;
import ip.industrialProcessing.recipes.IRecipeFluidWorkHandler;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeFluidWorker;
import ip.industrialProcessing.recipes.RecipeWorker;
import ip.industrialProcessing.utils.working.ClientWorker;
import ip.industrialProcessing.utils.working.IWorker;
import ip.industrialProcessing.utils.working.ServerWorker;
import ip.industrialProcessing.utils.working.WorkUtils;

import java.util.Iterator;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public abstract class TileEntityFluidWorkerMachine extends TileEntityFluidMachine implements IRecipeFluidWorkHandler, IAnimationProgress, IAnimationSyncable {

	public TileEntityFluidWorkerMachine() {
		this.serverWorker = createServerSideWorker();
		this.clientWorker = new ClientWorker();
		this.animationHandler = creatAnimationHandler();
	}

	protected AnimationHandler creatAnimationHandler() {
		return new AnimationHandler(AnimationMode.WRAP, 1f, true);
	}

	protected ServerWorker createServerSideWorker() {
		return new RecipeFluidWorker(this);
	}

	protected ServerWorker serverWorker;
	protected ClientWorker clientWorker;
	protected AnimationHandler animationHandler;

	public IWorker getWorker() {
		if (this.worldObj.isRemote)
			return clientWorker;
		else
			return serverWorker;
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
		updateAnimation(amount);
	}
 
	protected void updateAnimation(int workDone) {
		IWorker worker = getWorker();
		float maxWork = worker.getTotalWork();
		// each frame, workDone/maxWork % will be added to the animation
		this.animationHandler.setSpeed(workDone / maxWork / this.animationHandler.DT);
	}

	@Override
	public float getAnimationProgress(float scale, int index) {
		return this.animationHandler.getAnimationProgress(scale);
	}

	@Override
	public int getAnimationCount() {
		return 1;
	}

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
	 
}

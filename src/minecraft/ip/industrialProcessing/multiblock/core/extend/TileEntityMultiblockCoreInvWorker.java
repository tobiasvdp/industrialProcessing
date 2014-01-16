package ip.industrialProcessing.multiblock.core.extend;

import ip.industrialProcessing.client.render.IAnimationProgress;
import ip.industrialProcessing.machines.animation.AnimationHandler;
import ip.industrialProcessing.machines.animation.AnimationMode;
import ip.industrialProcessing.machines.animation.IAnimationSyncable;
import ip.industrialProcessing.machines.animation.TileAnimationSyncHandler;
import ip.industrialProcessing.multiblock.layout.StructureMultiblock;
import ip.industrialProcessing.multiblock.recipes.IRecipeMultiblockWorkHandler;
import ip.industrialProcessing.multiblock.recipes.RecipeMultiblock;
import ip.industrialProcessing.multiblock.recipes.RecipeMultiblockWorker;
import ip.industrialProcessing.multiblock.recipes.RecipesMultiblock;
import ip.industrialProcessing.multiblock.tier.TierCollection;
import ip.industrialProcessing.utils.working.ClientWorker;
import ip.industrialProcessing.utils.working.IWorker;
import ip.industrialProcessing.utils.working.ServerWorker;
import ip.industrialProcessing.utils.working.WorkUtils;

import java.util.Iterator;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public abstract class TileEntityMultiblockCoreInvWorker extends TileEntityMultiblockCoreInv implements IRecipeMultiblockWorkHandler, IAnimationProgress, IAnimationSyncable {

    public TileEntityMultiblockCoreInvWorker(StructureMultiblock structure, TierCollection tierRequirments, RecipesMultiblock recipes) {
	super(structure, tierRequirments, recipes);
	this.recipe = recipes;
	this.serverWorker = createServerSideWorker();
	this.clientWorker = new ClientWorker();
	this.animationHandler = this.creatAnimationHandler();
    }

    protected AnimationHandler creatAnimationHandler() {
	return new AnimationHandler(AnimationMode.WRAP, 1f, true);
    }

    protected ServerWorker createServerSideWorker() {
    	return new RecipeMultiblockWorker(this);
    }

    private RecipesMultiblock recipe;
    private ServerWorker serverWorker;
    private ClientWorker clientWorker;
    private AnimationHandler animationHandler;

    @Override
    public Iterator<RecipeMultiblock> iterateRecipes() {
    	return recipe.iterator();
    }

    @Override
	public IWorker getWorker() {
	if (this.worldObj.isRemote)
	    return clientWorker;
	else
	    return serverWorker;
    }

    @Override
    public void updateEntity() {
	super.updateEntity();
	if (!worldObj.isRemote)
	    doWork();
	if (animationHandler != null) {
	    this.animationHandler.update();
	    TileAnimationSyncHandler.sendAnimationData(this, this.animationHandler);
	}
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
}

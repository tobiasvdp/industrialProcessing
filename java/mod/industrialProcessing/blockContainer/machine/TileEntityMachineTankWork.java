package mod.industrialProcessing.blockContainer.machine;

import java.util.Iterator;

import mod.industrialProcessing.client.rendering.tileEntity.IAnimationProgress;
import mod.industrialProcessing.client.rendering.tileEntity.animation.AnimationHandler;
import mod.industrialProcessing.client.rendering.tileEntity.animation.AnimationMode;
import mod.industrialProcessing.client.rendering.tileEntity.animation.IAnimationSyncable;
import mod.industrialProcessing.client.rendering.tileEntity.animation.TileAnimationSyncHandler;
import mod.industrialProcessing.work.recipe.IMachineRecipe;
import mod.industrialProcessing.work.recipe.IRecipeFluidWorkHandler;
import mod.industrialProcessing.work.recipe.RecipeFluidWorker;
import mod.industrialProcessing.work.recipe.RecipeGenericFluidWorker;
import mod.industrialProcessing.work.recipe.RecipeGenericWorker;
import mod.industrialProcessing.work.recipe.RecipesMachine;
import mod.industrialProcessing.work.worker.IWorkHandler;
import mod.industrialProcessing.work.worker.IWorker;
import mod.industrialProcessing.work.worker.ServerWorker;
import mod.industrialProcessing.work.worker.WorkUtils;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import mod.industrialProcessing.fluids.tank.IPfluidTank;

public class TileEntityMachineTankWork extends TileEntityMachineTank implements IWorkHandler, IRecipeFluidWorkHandler<IMachineRecipe>,IAnimationProgress, IAnimationSyncable{

	protected RecipeGenericFluidWorker<IMachineRecipe, IRecipeFluidWorkHandler<IMachineRecipe>> worker;
	protected RecipesMachine recipes; 
	protected AnimationHandler animation = new AnimationHandler(AnimationMode.WRAP, 1f, true);
	protected boolean animated = false;

	public TileEntityMachineTankWork(RecipesMachine recipes) {
		this.worker = createServerSideWorker();
		this.recipes = recipes;
	}	
	
	@Override
	protected boolean isTankValidForFluid(int slot, Fluid fluid) {
		return recipes.isValidFluidInput(slot, fluid);
	}

	protected RecipeGenericFluidWorker<IMachineRecipe, IRecipeFluidWorkHandler<IMachineRecipe>> createServerSideWorker() {
		return new RecipeFluidWorker(this);
	}

	@Override
	public void updateEntity() {
		super.updateEntity();
		doWork();
		if(animated ){
		    this.animation.update();
		    TileAnimationSyncHandler.sendAnimationData(this, this.animation);
		}
	}

	protected void doWork() {
		work(1);
	}

	protected int work(int amount) {
		if (!this.worldObj.isRemote) {
			int workDone = this.getWorker().doWork(amount);
			return workDone;
		}
		return 0;
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
	public Iterator<IMachineRecipe> iterateRecipes() {
		return recipes.getRecipes();
	}

	@Override
	public boolean hasWorkToDo() {
		return true;
	}

	@Override
	public boolean canWorkProgress() {
		return true;
	}

	@Override
	public void workDone() {

	}

	@Override
	public void prepareWork() {

	}

	@Override
	public void workCancelled() {

	}

	@Override
	public void workProgressed(int amount) {

	}

	@Override
	public void beginWork() {

	}

	@Override
	public TileEntity getTileEntity() {
		return this;
	}

	@Override
	public IWorker getWorker() {
		return worker;
	}
	
	@Override
	protected boolean isValidInput(int slot, Item item){
		if(super.isValidInput(slot, item))
			return true;
		else
			return recipes.isValidInput(slot, item);
	}
	
	@Override
	public int getAnimationCount() {
		return 1;
	}

	@Override
	public float getAnimationProgress(float scale, int animationIndex) {
		return animation.getAnimationProgress(scale);
	}

	@Override
	public AnimationHandler getAnimationHandler(int index) {
		return animation;
	}

}

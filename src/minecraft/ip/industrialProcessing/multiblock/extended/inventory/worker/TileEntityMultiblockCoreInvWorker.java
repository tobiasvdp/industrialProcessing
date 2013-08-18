package ip.industrialProcessing.multiblock.extended.inventory.worker;

import java.util.Iterator;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import ip.industrialProcessing.client.render.IAnimationProgress;
import ip.industrialProcessing.multiblock.extended.inventory.TileEntityMultiblockCoreInv;
import ip.industrialProcessing.multiblock.utils.layout.MultiblockLayout;
import ip.industrialProcessing.recipes.IRecipeWorkHandler;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeWorker;
import ip.industrialProcessing.utils.working.ClientWorker;
import ip.industrialProcessing.utils.working.IWorkHandler;
import ip.industrialProcessing.utils.working.IWorker;
import ip.industrialProcessing.utils.working.IWorkingEntity;
import ip.industrialProcessing.utils.working.ServerWorker;
import ip.industrialProcessing.utils.working.WorkUtils;

public abstract class TileEntityMultiblockCoreInvWorker extends TileEntityMultiblockCoreInv implements IWorkHandler, IRecipeWorkHandler, IWorkingEntity, IAnimationProgress {

	protected ServerWorker serverWorker;
	protected ClientWorker clientWorker;
	protected int amount;

	public TileEntityMultiblockCoreInvWorker(MultiblockLayout structure, int amount) {
		super(structure);
		this.amount = amount;
		this.serverWorker = createServerSideWorker();
		this.clientWorker = new ClientWorker();
	}

	protected ServerWorker createServerSideWorker() {
		return new RecipeWorker(this);
	}

	@Override
	public void updateEntity() {
		super.updateEntity();
		doWork();
	}

	@Override
	public boolean canUpdate() {
		return true;
	}

	protected void doWork() {
		work(amount);
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
	public float getAnimationProgress(float scale) {
		IWorker worker = getWorker();
		if (worker != null)
		    return worker.getScaledProgress(100) / 100f * scale;
		return 0;
	}

	@Override
	public IWorker getWorker() {
		if (this.worldObj.isRemote)
			return clientWorker;
		else
			return serverWorker;
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
	public void workDone() {
		notifyBlockChange();

	}

	@Override
	public void prepareWork() {
	}

	@Override
	public void workCancelled() {
		notifyBlockChange();

	}

	@Override
	public void workProgressed(int amount) {

	}

	@Override
	public void beginWork() {
		notifyBlockChange();

	}

	@Override
	public TileEntity getTileEntity() {
		return this;
	}

}

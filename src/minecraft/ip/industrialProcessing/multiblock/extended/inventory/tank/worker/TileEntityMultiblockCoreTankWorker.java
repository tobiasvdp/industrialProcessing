package ip.industrialProcessing.multiblock.extended.inventory.tank.worker;

import java.util.Iterator;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.FluidStack;
import ip.industrialProcessing.client.render.IAnimationProgress;
import ip.industrialProcessing.machines.MachineFluidTank;
import ip.industrialProcessing.multiblock.extended.inventory.tank.TileEntityMultiblockCoreTank;
import ip.industrialProcessing.multiblock.utils.layout.MultiblockLayout;
import ip.industrialProcessing.multiblock.utils.tank.MultiblockTank;
import ip.industrialProcessing.recipes.IRecipeFluidWorkHandler;
import ip.industrialProcessing.recipes.IRecipeWorkHandler;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeFluidWorker;
import ip.industrialProcessing.recipes.RecipeWorker;
import ip.industrialProcessing.utils.working.ClientWorker;
import ip.industrialProcessing.utils.working.IWorkHandler;
import ip.industrialProcessing.utils.working.IWorker;
import ip.industrialProcessing.utils.working.IWorkingEntity;
import ip.industrialProcessing.utils.working.ServerWorker;
import ip.industrialProcessing.utils.working.WorkUtils;

public abstract class TileEntityMultiblockCoreTankWorker extends TileEntityMultiblockCoreTank implements IWorkHandler, IRecipeFluidWorkHandler, IWorkingEntity, IAnimationProgress {

	protected ServerWorker serverWorker;
	protected ClientWorker clientWorker;
	protected int amount;

	public TileEntityMultiblockCoreTankWorker(MultiblockLayout structure, int amount) {
		super(structure);
		this.amount = amount;
		this.serverWorker = createServerSideWorker();
		this.clientWorker = new ClientWorker();
	}

	protected ServerWorker createServerSideWorker() {
		return new RecipeFluidWorker(this);
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

	@Override
	public boolean tankContains(int slot, int itemId, int amount) {
		MultiblockTank tank = fluidTanks.get(slot);
		if (tank == null)
			return false;
		FluidStack stack = tank.getFluid();
		if (stack == null)
			return false;
		return stack.fluidID == itemId && stack.amount >= amount;
	}

	@Override
	public boolean tankHasRoomFor(int slot, FluidStack addStack) {
		MultiblockTank tank = fluidTanks.get(slot);
		if (tank == null)
			return false;
		FluidStack stack = tank.getFluid();
		if (stack == null)
			return true;
		return stack.isFluidEqual(addStack) && stack.amount + addStack.amount <= tank.getCapacity();
	}

	@Override
	public boolean tankHasRoomFor(int slot, int itemId, int amount) {
		MultiblockTank tank = fluidTanks.get(slot);
		if (tank == null)
			return false;
		FluidStack stack = tank.getFluid();
		if (stack == null)
			return true;
		return stack.fluidID == itemId && stack.amount + amount <= tank.getCapacity();
	}

	@Override
	public boolean addToTank(int index, int itemId, int amount) {
		MultiblockTank tank = fluidTanks.get(index);
		if (tank == null)
			return false;
		FluidStack stack = tank.getFluid();
		FluidStack newStack = new FluidStack(itemId, amount);
		if (stack == null) {
			tank.setFluid(newStack);
			super.notifyBlockChange();
			return true;
		} else if (stack.fluidID == itemId && stack.amount + amount <= tank.getCapacity()) {
			tank.fill(newStack, true);
			onTanksChanged();
			return true;
		}
		return false;
	}

	@Override
	public boolean removeFromTank(int index, int itemId, int amount) {
		MultiblockTank tank = fluidTanks.get(index);
		if (tank == null)
			return false;
		FluidStack stack = tank.getFluid();
		if (stack == null)
			return false;
		if (stack.fluidID == itemId && stack.amount >= amount) {
			tank.drain(amount, true);
			onTanksChanged();
			return true;
		}
		return false;
	}
}

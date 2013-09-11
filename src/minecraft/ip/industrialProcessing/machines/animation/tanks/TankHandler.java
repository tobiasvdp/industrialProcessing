package ip.industrialProcessing.machines.animation.tanks;

import ip.industrialProcessing.machines.TileEntityFluidMachine;

import java.util.ArrayList;

import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidTank;

public class TankHandler {

	private int[] syncedTanks;
	int[] amounts;
	private ITankSyncable fluidMachine;
	private int[] fluidIds;
	private int[] capacities;

	public TankHandler(ITankSyncable fluidMachine, int[] tankSlots) {
		this.fluidMachine = fluidMachine;
		this.syncedTanks = tankSlots;
		this.amounts = new int[tankSlots.length];
		this.fluidIds = new int[tankSlots.length];
		this.capacities = new int[tankSlots.length];
		for (int i = 0; i < tankSlots.length; i++) {
			IFluidTank tank = fluidMachine.getTankInSlot(tankSlots[i]);
			this.capacities[i] = tank.getCapacity();
		}
	}

	public int getTankCount() {
		return syncedTanks.length;
	}

	public int getAmount(int i) {
		return this.amounts[i];
		/*
		 * int tankSlot = syncedTanks[i]; IFluidTank tank =
		 * fluidMachine.getTankInSlot(tankSlot); return tank.getFluidAmount();
		 */
	}

	public int getFluidID(int i) {
		return this.fluidIds[i];
		/*
		 * int tankSlot = syncedTanks[i]; IFluidTank tank =
		 * fluidMachine.getTankInSlot(tankSlot); FluidStack stack =
		 * tank.getFluid(); if(stack != null) return stack.fluidID; return -1;
		 */
	}

	public void setFluidId(int i, int fluidId) {
		this.fluidIds[i] = fluidId;
	}

	public void setAmount(int i, int amount) {
		this.amounts[i] = amount;
	}

	public boolean readDataFromTanks() {
		boolean changed = true;
		for (int i = 0; i < this.syncedTanks.length; i++) {
			int slot = this.syncedTanks[i];
			IFluidTank tank = fluidMachine.getTankInSlot(slot);
			FluidStack stack = tank.getFluid();
			int amount = stack == null ? 0 : stack.amount;
			if (amount != this.amounts[i]) {
				this.amounts[i] = amount;
				changed = true;
			}
			int fluidID = stack == null ? -1 : stack.fluidID;
			if (fluidID != this.fluidIds[i]) {
				this.fluidIds[i] = fluidID;
				changed = true;
			}
		}
		return changed;
	}

	public int getCapacity(int l) { 
		return this.capacities[l];
	}
}

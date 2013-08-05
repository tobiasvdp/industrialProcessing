package ip.industrialProcessing.machines;

import ip.industrialProcessing.recipes.Recipe;

import java.util.ArrayList;
import java.util.Iterator;

import javax.activity.InvalidActivityException;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidIdMapPacket;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import net.minecraftforge.liquids.LiquidTank;

public abstract class TileEntityFluidMachine extends TileEntityMachine
		implements IFluidHandler {

	private int[][] fluidTankSideslots = new int[6][0];
	private ArrayList<MachineFluidTank> fluidTanks = new ArrayList<MachineFluidTank>();

	protected void addTank(FluidTank stack, ForgeDirection side, boolean input,
			boolean output) {
		addTank(stack, new ForgeDirection[] { side }, input, output);
	}

	protected void addTank(FluidTank tank, ForgeDirection[] sides,
			boolean input, boolean output) {
		if (tank == null)
			throw new NullPointerException("Tank is required");
		int index = fluidTanks.size();

		int[] sideIndices = new int[sides.length];
		for (int i = 0; i < sideIndices.length; i++)
			sideIndices[i] = sides[i].ordinal();

		fluidTanks.add(new MachineFluidTank(tank, sideIndices, input, output));

		for (int i = 0; i < sideIndices.length; i++) {
			int sideIndex = sideIndices[i];
			int[] slots = fluidTankSideslots[sideIndex];
			int[] newSlots = new int[slots.length + 1];
			System.arraycopy(slots, 0, newSlots, 0, slots.length);
			newSlots[slots.length] = index;
			fluidTankSideslots[sideIndex] = newSlots;
		}
	}

	private MachineFluidTank getTankInSlot(int i) {
		if (i < 0 || i > this.fluidTanks.size())
			return null;
		return this.fluidTanks.get(i);
	}

	protected abstract boolean isTankValidForLiquid(int index, int fluidId);

	protected MachineFluidTank getFluidTankForSlot(int slot)
	{
		if(slot < 0 || slot > fluidTanks.size()) return null;
		return this.fluidTanks.get(slot);
	}
	
	private FluidTank getInputTankForFluid(ForgeDirection from, Fluid resource) {
		if (resource == null)
			return null;
		int[] sideSlots = fluidTankSideslots[from.ordinal()];
		for (int i = 0; i < sideSlots.length; i++) {
			int slotIndex = sideSlots[i];
			if (isTankValidForLiquid(slotIndex, resource.getID())) {
				MachineFluidTank machineTank = this.getTankInSlot(slotIndex);
				if (machineTank.input) {
					FluidTank tank = machineTank.tank;
					if (tank.getFluidAmount() > tank.getCapacity()) {
						FluidStack tankFluid = tank.getFluid();
						if (tankFluid == null
								|| tankFluid.fluidID == resource.getID()) {
							return tank;
						}
					}
				}
			}
		}
		return null;
	}

	private FluidTank getInputTankForFluidStack(ForgeDirection from,
			FluidStack resource) {
		if (resource == null)
			return null;
		int[] sideSlots = fluidTankSideslots[from.ordinal()];
		for (int i = 0; i < sideSlots.length; i++) {
			int slotIndex = sideSlots[i];
			if (isTankValidForLiquid(slotIndex, resource.fluidID)) {
				MachineFluidTank machineTank = this.getTankInSlot(slotIndex);
				if (machineTank.input) {
					FluidTank tank = machineTank.tank;
					if (tank.getFluidAmount() > tank.getCapacity()) {
						FluidStack tankFluid = tank.getFluid();
						if (tankFluid == null
								|| tankFluid.isFluidEqual(resource)) {
							return tank;
						}
					}
				}
			}

		}
		return null;
	}
	private FluidTank getOutputTankForFluid(ForgeDirection from,
			Fluid resource) {
		if (resource == null)
			return null;
		int[] sideSlots = fluidTankSideslots[from.ordinal()];
		for (int i = 0; i < sideSlots.length; i++) {
			int slotIndex = sideSlots[i];
			if (isTankValidForLiquid(slotIndex, resource.getID())) {
				MachineFluidTank machineTank = this.getTankInSlot(slotIndex);
				if (machineTank.output) {
					FluidTank tank = machineTank.tank;
					if (tank.getFluidAmount() > 0) {
						FluidStack tankFluid = tank.getFluid();
						if (tankFluid.fluidID == resource.getID()) {
							return tank;
						}
					}
				}
			}

		}
		return null;
	}

	private FluidTank getOutputTankForFluidStack(ForgeDirection from,
			FluidStack resource) {
		if (resource == null)
			return null;
		int[] sideSlots = fluidTankSideslots[from.ordinal()];
		for (int i = 0; i < sideSlots.length; i++) {
			int slotIndex = sideSlots[i];
			if (isTankValidForLiquid(slotIndex, resource.fluidID)) {
				MachineFluidTank machineTank = this.getTankInSlot(slotIndex);
				if (machineTank.output) {
					FluidTank tank = machineTank.tank;
					if (tank.getFluidAmount() > 0) {
						FluidStack tankFluid = tank.getFluid();
						if (tankFluid.isFluidEqual(resource)) {
							return tank;
						}
					}
				}
			}

		}
		return null;
	}

	private FluidTank getOutputTank(ForgeDirection from) {
		int[] sideSlots = fluidTankSideslots[from.ordinal()];
		for (int i = 0; i < sideSlots.length; i++) {
			int slotIndex = sideSlots[i];
			MachineFluidTank machineTank = this.getTankInSlot(slotIndex);
			if (machineTank.output) {
				FluidTank tank = machineTank.tank;
				if (tank.getFluidAmount() > 0) {
					return tank;
				}
			}

		}
		return null;
	}

	@Override
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		FluidTank tank = getInputTankForFluidStack(from, resource);
		if (tank == null)
			return 0;
		return tank.fill(resource, doFill);
	}

	@Override
	public FluidStack drain(ForgeDirection from, FluidStack resource,
			boolean doDrain) {
		FluidTank tank = getOutputTankForFluidStack(from, resource);
		if (tank == null)
			return null;
		return tank.drain(tank.getFluidAmount(), doDrain);
	}

	@Override
	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {

		FluidTank tank = getOutputTank(from);
		if (tank == null)
			return null;
		return tank.drain(tank.getFluidAmount(), doDrain);
	}

	@Override
	public boolean canFill(ForgeDirection from, Fluid fluid) {

		FluidTank tank = getInputTankForFluid(from, fluid);
		return tank != null;
	}

	@Override
	public boolean canDrain(ForgeDirection from, Fluid fluid) {

		FluidTank tank = getInputTankForFluid(from, fluid);
		return tank != null;
	}

	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection from) {
		int[] sides = this.fluidTankSideslots[from.ordinal()];
		
		FluidTankInfo[] tanks = new FluidTankInfo[sides.length];
		for(int i = 0; i < sides.length; i++)
		{
			tanks[i] = getTankInSlot(sides[i]).tank.getInfo();
		}
		return tanks;
	}
}

package ip.industrialProcessing.transport.fluids;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import buildcraft.api.transport.IPipe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import ip.industrialProcessing.DirectionUtils;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.machines.IMachineTanks;
import ip.industrialProcessing.machines.MachineFluidTank;
import ip.industrialProcessing.transport.TileEntityTransport;
import ip.industrialProcessing.transport.TransportConnectionState;

public class TileEntityTransportFluids extends TileEntityTransport {

    FluidTank fluid = new FluidTank(1000);

    public FluidTankInfo getTankInfo() {
	return fluid.getInfo();
    }

    @Override
    protected TransportConnectionState getState(TileEntity entity, ForgeDirection direction) {
	ForgeDirection from = direction.getOpposite();
	if (entity instanceof TileEntityTransportFluids)
	    return TransportConnectionState.TRANSPORT; // TODO: check if
						       // connection should be
						       // made (lava pipe with
						       // water pipe ..)

	if (entity instanceof IFluidHandler) {
	    IFluidHandler handler = (IFluidHandler) entity;
	    return canInsertOrExtractFluid(handler, from);
	}
	return TransportConnectionState.NONE;
    }

    private TransportConnectionState canInsertOrExtractFluid(IFluidHandler handler, ForgeDirection from) {
	FluidTankInfo[] info = handler.getTankInfo(from);
	if (info != null && info.length > 0)
	    return TransportConnectionState.DUAL; // can't decide if input only
						  // or input/output
	return TransportConnectionState.NONE;
    }

    @Override
    public void updateEntity() {
	super.updateEntity();
	if (this.worldObj.isRemote)
	    return;

	outputToInputs();
	inputFromOutputs();
	equalizeToOtherPipes(); 
    }

    private void equalizeToOtherPipes() {
	TileEntityTransportFluids[] otherPipes = new TileEntityTransportFluids[states.length];
	int[] balances = new int[states.length];
	int balance = 0;
	for (int i = 0; i < states.length; i++) {
	    TransportConnectionState state = this.states[i];
	    ForgeDirection direction = ForgeDirection.VALID_DIRECTIONS[i];
	    if (state == TransportConnectionState.TRANSPORT) {
		TileEntityTransportFluids other = getNeighborPipe(direction);
		if (other != null) {
		    int diff = (int)Math.ceil((this.fluid.getFluidAmount() - other.fluid.getFluidAmount()) / 2d);
		    if (diff > 0) {
			balance += balances[i] = diff;
			otherPipes[i] = other;
		    }
		}
	    }
	}

	for (int i = 0; i < balances.length; i++) {
	    TileEntityTransportFluids other = otherPipes[i];
	    if (other != null) {
		FluidStack fluidStack = this.fluid.drain(balances[i], false);
		int amount = other.fluid.fill(fluidStack, true);
		this.fluid.drain(amount, true);
	    }
	}
    }

    private void inputFromOutputs() {
	IFluidHandler[] handlers = new IFluidHandler[states.length];
	int[] availableAmounts = new int[states.length];
	int totalOutput = 0;
	FluidStack drain = this.fluid.getFluid();
	if (drain != null) {
	    drain = drain.copy();
	    drain.amount = this.fluid.getCapacity() - drain.amount;
	}
	int maxOutput = this.fluid.getCapacity() - this.fluid.getFluidAmount();
	for (int i = 0; i < states.length; i++) {
	    TransportConnectionState state = this.states[i];
	    ForgeDirection direction = ForgeDirection.VALID_DIRECTIONS[i];
	    if (state == TransportConnectionState.OUTPUT || state == TransportConnectionState.DUAL) {
		IFluidHandler handler = getNeighborFluidHandler(direction);
		if (handler != null && (drain == null || handler.canDrain(direction.getOpposite(), drain.getFluid()))) {
		    handlers[i] = handler;
		    FluidStack output = drain == null ? handler.drain(direction.getOpposite(), this.fluid.getCapacity(), false) : handler.drain(direction.getOpposite(), drain, false);
		    if (output != null)
			totalOutput += availableAmounts[i] = output.amount;
		}
	    }
	} 
	if (totalOutput > 0) {
	    for (int i = 0; i < handlers.length; i++) {
		IFluidHandler handler = handlers[i];
		if (handler != null) {
		    ForgeDirection direction = ForgeDirection.VALID_DIRECTIONS[i];
		    int output = availableAmounts[i] * maxOutput / totalOutput;
		    FluidStack stack = handler.drain(direction.getOpposite(), output, true);
		    this.fluid.fill(stack, true);
		}
	    }
	}
    }

    private void outputToInputs() {

	FluidStack fluid = this.fluid.getFluid();
	if (fluid != null) {
	    IFluidHandler[] handlers = new IFluidHandler[states.length];
	    int inputCount = 0;
	    for (int i = 0; i < states.length; i++) {
		TransportConnectionState state = this.states[i];
		ForgeDirection direction = ForgeDirection.VALID_DIRECTIONS[i];
		if (state == TransportConnectionState.INPUT || state == TransportConnectionState.DUAL) {
		    IFluidHandler handler = getNeighborFluidHandler(direction);
		    if (handler != null && handler.canFill(direction.getOpposite(), fluid.getFluid())) {
			handlers[i] = handler;
			inputCount++;
		    }
		}
	    }
	    if (inputCount > 0) {
		fluid.copy();
		fluid.amount /= inputCount;
		for (int i = 0; i < handlers.length; i++) {
		    IFluidHandler handler = handlers[i];
		    if (handler != null) {
			ForgeDirection direction = ForgeDirection.VALID_DIRECTIONS[i];
			int amount = handler.fill(direction.getOpposite(), fluid, true);
			this.fluid.drain(amount, true);
		    }
		}
	    }
	}
    }

    private IFluidHandler getNeighborFluidHandler(ForgeDirection direction) {
	TileEntity ent = this.worldObj.getBlockTileEntity(this.xCoord + direction.offsetX, this.yCoord + direction.offsetY, this.zCoord + direction.offsetZ);
	if (ent instanceof IFluidHandler)
	    return (IFluidHandler) ent;
	return null;
    }

    private TileEntityTransportFluids getNeighborPipe(ForgeDirection direction) {
	TileEntity ent = this.worldObj.getBlockTileEntity(this.xCoord + direction.offsetX, this.yCoord + direction.offsetY, this.zCoord + direction.offsetZ);
	if (ent instanceof TileEntityTransportFluids)
	    return (TileEntityTransportFluids) ent;
	return null;
    }
}
